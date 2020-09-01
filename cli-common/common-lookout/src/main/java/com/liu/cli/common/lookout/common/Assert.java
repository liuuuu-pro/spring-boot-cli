package com.liu.cli.common.lookout.common;

/**
 * Copied from seata.jar by liujiazhong
 * @author liujiazhong
 * @date 2020/9/1 16:31
 */
public final class Assert {

    private Assert() {
    }

    public static <T> T notNull(T obj, String name) {
        if (obj == null) {
            String msg = String.format("parameter '%s' cannot be null", name);
            throw new IllegalArgumentException(msg);
        } else {
            return obj;
        }
    }

    public static void checkArg(boolean expr, String err) {
        if (!expr) {
            throw new IllegalArgumentException(err);
        }
    }

    public static void state(boolean expr, String err) {
        if (!expr) {
            throw new IllegalStateException(err);
        }
    }

}