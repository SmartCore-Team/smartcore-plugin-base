package com.hangyin.smart.smartcore.model;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * device property model
 *
 * @author hang.yin
 * @date 2020-04-24
 */
@SuppressWarnings({"WeakerAccess", "UnusedReturnValue", "unused", "MismatchedQueryAndUpdateOfCollection"})
public class SmartCorePropertyModel {
    private final static Map<String, String> valueTypeAdapter = new HashMap<String, String>() {{
        put("string", String.class.getName());
        put("boolean", Boolean.class.getName());
        put("int", Integer.class.getName());
        put("integer", Integer.class.getName());
        put("float", Float.class.getName());
        put("long", Long.class.getName());
        put("double", Double.class.getName());
    }};

    private String friendlyName;
    private String valueType;
    private Object value;
    private String valuePattern;
    private boolean readOnly;
    private boolean isNotify;
    private Map<String, Object> extra = new ConcurrentHashMap<>();

    public SmartCorePropertyModel(String friendlyName, Object value, String valuePattern, boolean readOnly, boolean isNotify) {
        this.friendlyName = friendlyName;
        this.value = value;
        this.valueType = value.getClass().getName();
        this.valuePattern = valuePattern;
        this.readOnly = readOnly;
        this.isNotify = isNotify;
    }

    public SmartCorePropertyModel(String friendlyName, Object value, String valueType, String valuePattern, boolean readOnly, boolean isNotify) {
        this.friendlyName = friendlyName;
        this.value = value;
        this.setValueType(valueType);
        this.valuePattern = valuePattern;
        this.readOnly = readOnly;
        this.isNotify = isNotify;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public SmartCorePropertyModel setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public SmartCorePropertyModel setValue(Object value) {
        this.value = value;
        return this;
    }

    public String getValuePattern() {
        return valuePattern;
    }

    public SmartCorePropertyModel setValuePattern(String valuePattern) {
        this.valuePattern = valuePattern;
        return this;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public SmartCorePropertyModel setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public SmartCorePropertyModel setNotify(boolean notify) {
        isNotify = notify;
        return this;
    }

    public Object getExtra(String extraKey) {
        return extra.get(extraKey);
    }

    public SmartCorePropertyModel addExtra(String extraKey, Object extraValue) {
        this.extra.put(extraKey, extraValue);
        return this;
    }

    public SmartCorePropertyModel removeExtra(String extraKey) {
        extra.remove(extraKey);
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public SmartCorePropertyModel setExtra(Map<String, Object> extra) {
        if(null != extra) {
            extra.forEach((k, v) -> this.extra.put(k, v));
        }
        return this;
    }

    public String getValueType() {
        return valueType;
    }

    public SmartCorePropertyModel setValueType(String valueType) {
        if(null == valueTypeAdapter.get(valueType.toLowerCase())) {
            this.valueType = valueType;
        } else {
            this.valueType = valueTypeAdapter.get(valueType.toLowerCase());
        }
        return this;
    }
}
