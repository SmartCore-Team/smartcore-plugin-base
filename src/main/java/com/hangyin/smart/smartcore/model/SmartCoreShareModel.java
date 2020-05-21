package com.hangyin.smart.smartcore.model;

/**
 *
 *
 * @author hang.yin
 * @date 2020-05-15 04:00
 */
public class SmartCoreShareModel {
    private Object value;
    private int referenceNum;

    public SmartCoreShareModel(Object value) {
        this.value = value;
        this.referenceNum = 1;
    }

    public Object get() {
        referenceNum ++;
        return value;
    }

    public Object close() {
        referenceNum --;
        if(0 == referenceNum) {
            return value;
        } else {
            return null;
        }
    }
}
