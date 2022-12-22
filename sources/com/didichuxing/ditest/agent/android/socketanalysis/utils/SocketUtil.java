package com.didichuxing.ditest.agent.android.socketanalysis.utils;

public class SocketUtil {
    public static boolean isStringOrNumber(Object obj) {
        return (obj instanceof String) || (obj instanceof Number);
    }
}
