package com.hangyin.smart.smartcore.service;

/**
 * notify function
 *
 * @author hang.yin
 * @date 2020-04-25
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
@FunctionalInterface
public interface ISmartCoreSetPropertyValueFunction {
    Boolean setPropertyValueProcess(String propertyId, Object value);
}
