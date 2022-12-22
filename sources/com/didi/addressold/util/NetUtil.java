package com.didi.addressold.util;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class NetUtil {
    public static boolean isNetException(Throwable th) {
        if (th != null) {
            return (th instanceof ConnectException) || (th instanceof SocketTimeoutException) || (th instanceof UnknownHostException);
        }
        return false;
    }
}
