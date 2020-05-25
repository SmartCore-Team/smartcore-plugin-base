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
        this.referenceNum = 0;
    }

    public SmartCoreShareModel use() {
        referenceNum ++;
        return this;
    }

    public Object get() {
        return value;
    }

    public int useNum() {
        return referenceNum;
    }

    public Object revert() {
        referenceNum --;
        if(0 == referenceNum) {
            return value;
        } else {
            return null;
        }
    }
}
