package com.didichuxing.omega.sdk.common;

public class OmegaCallback {
    public static AsyncInit iAsyncInit;
    public static RecordCurrentPageListener iCurrentPageListener;
    public static PrintLogListener iPrintLogListener;

    public interface AsyncInit {
        void init();
    }

    public interface PrintLogListener {
        void printLog(int i, String str, Throwable th);
    }

    public interface RecordCurrentPageListener {
        String getCurActivityPage(String str);
    }
}
