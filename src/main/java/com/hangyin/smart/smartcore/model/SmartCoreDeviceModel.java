package com.hangyin.smart.smartcore.model;

import com.hangyin.smart.smartcore.service.ISmartCoreDevicePropertyValueChangeNotifyFunction;
import com.hangyin.smart.smartcore.service.ISmartCoreSetPropertyValueFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/**
 * device model
 *
 * @author hang.yin
 * @date 2020-04-24 19:17
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class SmartCoreDeviceModel {
    private String deviceId;
    private String friendlyName;
    private String type;
    private SmartCoreDeviceInfoModel info;
    private Map<String, SmartCorePropertyModel> properties;
    private Map<String, Object> extra = new ConcurrentHashMap<>();

    public SmartCoreDeviceModel(String deviceId) {
        this.deviceId = deviceId;
        this.properties = new HashMap<>();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public SmartCoreDeviceModel setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public Map<String, SmartCorePropertyModel> getProperties() {
        return properties;
    }

    public SmartCoreDeviceModel setProperties(Map<String, SmartCorePropertyModel> properties) {
        this.properties = properties;
        return this;
    }

    public SmartCoreDeviceInfoModel getInfo() {
        return info;
    }

    public SmartCoreDeviceModel setInfo(SmartCoreDeviceInfoModel info) {
        this.info = info;
        return this;
    }

    public String getType() {
        return type;
    }

    public SmartCoreDeviceModel setType(String type) {
        this.type = type;
        return this;
    }

    public Object getExtra(String extraKey) {
        return extra.get(extraKey);
    }

    public SmartCoreDeviceModel addExtra(String extraKey, Object extraValue) {
        this.extra.put(extraKey, extraValue);
        return this;
    }

    public SmartCoreDeviceModel removeExtra(String extraKey) {
        extra.remove(extraKey);
        return this;
    }

    public SmartCoreDeviceModel addProperty(String propertyId, SmartCorePropertyModel propertyObj) {
        this.properties.put(propertyId, propertyObj);
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public SmartCoreDeviceModel setExtra(Map<String, Object> extra) {
        if(null != extra) {
            extra.forEach((k, v) -> this.extra.put(k, v));
        }
        return this;
    }

    public SmartCoreDeviceModel removeProperty(String propertyId) {
        this.properties.remove(propertyId);
        return this;
    }

    public SmartCorePropertyModel getProperty(String propertyId) {
        return this.properties.get(propertyId);
    }

    public Object getPropertyValue(String propertyId) {
        return Optional.ofNullable(this.getProperty(propertyId)).map(SmartCorePropertyModel::getValue).orElse(null);
    }

    public Object getPropertyFriendlyName(String propertyId) {
        return Optional.ofNullable(this.getProperty(propertyId)).map(SmartCorePropertyModel::getFriendlyName).orElse(null);
    }

    public Boolean setPropertyValue(String propertyId, Object value, ISmartCoreSetPropertyValueFunction setPropertyValueFunction, ISmartCoreDevicePropertyValueChangeNotifyFunction notifyFunction) {
        SmartCorePropertyModel propertyObj = this.getProperty(propertyId);
        if(null == propertyObj) {
            return false;
        }

        if(propertyObj.isReadOnly()) {
            return false;
        }

        if(null == propertyObj.getValueType()) {
            return false;
        }

        if(null != value) {
            if (!propertyObj.getValueType().equals(value.getClass().getName())) {
                return false;
            }

            if (null != propertyObj.getValuePattern()) {
                if (!Pattern.matches(propertyObj.getValuePattern(), String.valueOf(value))) {
                    return false;
                }
            }
        }

        if(value != propertyObj.getValue()) {
            if(setPropertyValueFunction.setPropertyValueProcess(propertyId, value)) {
                if (null != notifyFunction) {
                    if (propertyObj.isNotify()) {
                        notifyFunction.notify(deviceId, propertyId, value, propertyObj.getValue());
                    }
                }
                propertyObj.setValue(value);
            } else {
                return false;
            }
        }
        return true;
    }
}
