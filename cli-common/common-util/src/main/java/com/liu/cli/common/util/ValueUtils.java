package com.liu.cli.common.util;

import org.apache.commons.lang3.StringUtils;

public class ValueUtils {

    private ValueUtils() {
    }

    public static Byte getByte(Byte value, Byte defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static Long getValue(Long value) {
        return getValue(value, 0L);
    }

    public static Long getValue(Long value, Long defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static Integer getValue(Integer value) {
        return getValue(value, 0);
    }

    public static Integer getValue(Integer value, Integer defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static Double getValue(Double value) {
        return getValue(value, 0.0D);
    }

    public static Double getValue(Double value, Double defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static Float getValue(Float value) {
        return getValue(value, 0.0F);
    }

    public static Float getValue(Float value, Float defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static Number getValue(Number value) {
        return getValue((Number)value, (int)0);
    }

    public static Number getValue(Number value, Number defaultValue) {
        return value == null ? defaultValue : value;
    }

    public static String toString(long source, int size) {
        String sourceString = String.valueOf(source);
        if (sourceString.length() >= size) {
            return sourceString;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int whiteSpanSize = size - sourceString.length();

            for(int i = 0; i < whiteSpanSize; ++i) {
                stringBuilder.append('0');
            }

            stringBuilder.append(sourceString);
            return stringBuilder.toString();
        }
    }

    public static Boolean getValue(Boolean booleanValue) {
        return booleanValue != null && booleanValue;
    }

    public static Boolean getValue(Boolean booleanValue, Boolean defaultValue) {
        return booleanValue == null ? defaultValue : booleanValue;
    }

    public static <T> T getValueOrDefault(T obj, T defaultValue) {
        return obj == null ? defaultValue : obj;
    }

    public static String getValue(String value, String defaultValue) {
        return StringUtils.isBlank(value) ? defaultValue : value;
    }
}
