package com.hangyin.smart.smartcore.service;

/**
 * notify function
 *
 * @author hang.yin
 * @date 2020-04-25
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
@FunctionalInterface
public interface ISmartCoreDevicePropertyValueChangeNotifyFunction {
    Boolean notify(String deviceId, String propertyId, Object newValue, Object oldValue);
}
