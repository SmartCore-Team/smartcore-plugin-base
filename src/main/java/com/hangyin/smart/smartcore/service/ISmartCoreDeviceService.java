package com.hangyin.smart.smartcore.service;

import com.hangyin.smart.smartcore.model.SmartCoreShareModel;
import com.hangyin.smart.smartcore.model.SmartCoreDeviceInfoModel;
import com.hangyin.smart.smartcore.model.SmartCoreDeviceModel;
import com.hangyin.smart.smartcore.model.SmartCorePropertyModel;
import java.util.Map;

/**
 * device service
 *
 * @author hang.yin
 * @date 2020-04-25
 */
@SuppressWarnings("unused")
public interface ISmartCoreDeviceService {
    Boolean init(Map<String, SmartCoreShareModel> shareMap, ISmartCoreDevicePropertyValueChangeNotifyFunction notifyFunction, String deviceId, Map params);
    Boolean close(Map params);

    SmartCoreDeviceModel getDevice();
    String getDeviceId();
    String getDeviceFriendlyName();
    String getDeviceType();
    SmartCoreDeviceInfoModel getDeviceInfo();
    Map<String, SmartCorePropertyModel> getDeviceProperties();

    SmartCorePropertyModel getProperty(String propertyId);
    Object getPropertyValue(String propertyId);
    Object getPropertyFriendlyName(String propertyId);
    Boolean setPropertyValue(String propertyId, Object propertyValue);

    Map<String, Object> getPropertyValueMap();
    Map<String, Boolean> setPropertyValueMap(Map<String, Object> values);

    Boolean operation(String operationType);
}
