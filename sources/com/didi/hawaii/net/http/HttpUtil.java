package com.didi.hawaii.net.http;

import com.didi.hawaii.net.http.exception.NetUnInitializedException;
import com.didi.hawaii.net.http.exception.NetUnavailableException;

public class HttpUtil {
    public static HttpResponse sendSyncGetRequest(String str, String str2) throws NetUnInitializedException, NetUnavailableException, Exception {
        if (HttpContext.isInitialized()) {
            return m17257a(true, str, str2, (byte[]) null);
        }
        throw new NetUnInitializedException("net isn't initialized!");
    }

    public static HttpResponse sendSyncPostRequest(String str, String str2, byte[] bArr) throws NetUnInitializedException, NetUnavailableException, Exception {
        if (HttpContext.isInitialized()) {
            return m17257a(false, str, str2, bArr);
        }
        throw new NetUnInitializedException("net isn't initialized!");
    }

    /* renamed from: a */
    private static HttpResponse m17257a(boolean z, String str, String str2, byte[] bArr) throws NetUnavailableException, Exception {
        return C9254a.m17258a(z, str, str2, bArr, false);
    }
}
