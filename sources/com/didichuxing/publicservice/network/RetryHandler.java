package com.didichuxing.publicservice.network;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ConnectTimeoutException;

public class RetryHandler {
    private static int RETRY_INTERVAL_MILLIS = 1000;
    private static HashSet<Class<?>> mExceptionNotRetryList = new HashSet<>();
    private static HashSet<Class<?>> mExceptionRetryList = new HashSet<>();
    private int mRetryMaxTimes = 0;

    static {
        mExceptionRetryList.add(InterruptedIOException.class);
        mExceptionRetryList.add(SocketTimeoutException.class);
        mExceptionRetryList.add(ConnectTimeoutException.class);
        mExceptionRetryList.add(SSLHandshakeException.class);
        mExceptionRetryList.add(ConnectException.class);
        mExceptionNotRetryList.add(UnknownHostException.class);
        mExceptionNotRetryList.add(SocketException.class);
        mExceptionNotRetryList.add(NoRouteToHostException.class);
    }

    public RetryHandler(int i) {
        this.mRetryMaxTimes = i;
    }

    public boolean retryRequest(IOException iOException, int i) {
        boolean z = false;
        if (this.mRetryMaxTimes >= i && (mExceptionRetryList.contains(iOException.getClass()) || !mExceptionNotRetryList.contains(iOException.getClass()))) {
            z = true;
        }
        if (z) {
            SystemClock.sleep((long) RETRY_INTERVAL_MILLIS);
        }
        return z;
    }
}
