package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;

public final class ErrorHandleUtil {

    /* renamed from: a */
    private static final String f41235a = "ErrorHandleUtil";

    /* renamed from: b */
    private static ErrorHandleListener f41236b;

    public interface ErrorHandleListener {
        void onErrorHandle(SFRpcException sFRpcException);
    }

    private ErrorHandleUtil() {
    }

    public static void setErrorHandleListener(ErrorHandleListener errorHandleListener) {
        if (errorHandleListener == null || f41236b == null) {
            f41236b = errorHandleListener;
        } else {
            LogUtil.m29102e(f41235a, "ErrorHandleListener can only set once.");
        }
    }

    public static void setError(SFRpcException sFRpcException) {
        ErrorHandleListener errorHandleListener = f41236b;
        if (errorHandleListener != null) {
            errorHandleListener.onErrorHandle(sFRpcException);
        }
    }
}
