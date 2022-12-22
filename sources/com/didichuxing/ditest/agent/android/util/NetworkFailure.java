package com.didichuxing.ditest.agent.android.util;

import com.didi.dimina.container.monitor.ErrorCode;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;

public enum NetworkFailure {
    Unknown(-1),
    BadURL(-1000),
    TimedOut(-1001),
    CannotConnectToHost(ErrorCode.APP_SERVICE_READ_ERROR),
    DNSLookupFailed(-1006),
    BadServerResponse(-1011),
    SecureConnectionFailed(-1200);
    
    private int errorCode;

    private NetworkFailure(int i) {
        this.errorCode = i;
    }

    public static NetworkFailure exceptionToNetworkFailure(Exception exc) {
        NetworkFailure networkFailure = Unknown;
        if (exc instanceof UnknownHostException) {
            return DNSLookupFailed;
        }
        if ((exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException)) {
            return TimedOut;
        }
        if (exc instanceof ConnectException) {
            return CannotConnectToHost;
        }
        if (exc instanceof MalformedURLException) {
            return BadURL;
        }
        if (exc instanceof SSLException) {
            return SecureConnectionFailed;
        }
        if ((exc instanceof HttpResponseException) || (exc instanceof ClientProtocolException)) {
            return BadServerResponse;
        }
        return networkFailure;
    }

    public static int exceptionToErrorCode(Exception exc) {
        return exceptionToNetworkFailure(exc).getErrorCode();
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
