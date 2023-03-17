package com.halemia.familymanager.context;

/**
 * @Author : shangchy
 * @Date : Create in 14:21 2023/3/17
 */
public class ThreadContext {

    private static final ThreadLocal<ThreadParam> LOCAL = new ThreadLocal<>();

    public static ThreadParam getInstance() {
        if (null == LOCAL.get()) {
            LOCAL.set(new ThreadParam());
        }
        return LOCAL.get();
    }

    public static void setThreadParam(ThreadParam threadParam) {
        LOCAL.set(threadParam);
    }

    public static void complete() {
        LOCAL.remove();
    }
}
