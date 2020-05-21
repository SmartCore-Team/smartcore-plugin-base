package com.hangyin.smart.smartcore.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * device information model
 *
 * author hang.yin
 * @date 2020-04-24
 */
@SuppressWarnings("unused")
public class SmartCoreDeviceInfoModel {
    private String manufacturer;
    private String model;
    private String serialNumber;
    private Map<String, Object> extra = new ConcurrentHashMap<>();

    public SmartCoreDeviceInfoModel(String manufacturer, String model, String serialNumber) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public SmartCoreDeviceInfoModel setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public SmartCoreDeviceInfoModel setModel(String model) {
        this.model = model;
        return this;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public SmartCoreDeviceInfoModel setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public Object getExtra(String extraKey) {
        return extra.get(extraKey);
    }

    public SmartCoreDeviceInfoModel addExtra(String extraKey, Object extraValue) {
        this.extra.put(extraKey, extraValue);
        return this;
    }

    public SmartCoreDeviceInfoModel removeExtra(String extraKey) {
        extra.remove(extraKey);
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public SmartCoreDeviceInfoModel setExtra(Map<String, Object> extra) {
        if(null != extra) {
            extra.forEach((k, v) -> this.extra.put(k, v));
        }
        return this;
    }
}
