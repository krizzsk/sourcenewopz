package com.didi.entrega.customer.foundation.util;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;

public final class ErrorHandleUtil {

    /* renamed from: a */
    private static final String f20134a = "ErrorHandleUtil";

    /* renamed from: b */
    private static ErrorHandleListener f20135b;

    public interface ErrorHandleListener {
        void onErrorHandle(SFRpcException sFRpcException);
    }

    private ErrorHandleUtil() {
    }

    public static void setErrorHandleListener(ErrorHandleListener errorHandleListener) {
        if (errorHandleListener == null || f20135b == null) {
            f20135b = errorHandleListener;
        } else {
            LogUtil.m14763e(f20134a, "ErrorHandleListener can only set once.");
        }
    }

    public static void setError(SFRpcException sFRpcException) {
        ErrorHandleListener errorHandleListener = f20135b;
        if (errorHandleListener != null) {
            errorHandleListener.onErrorHandle(sFRpcException);
        }
    }
}
