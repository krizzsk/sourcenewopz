package com.didichuxing.foundation.rpc;

public class RpcException extends Exception {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 5086949316427458175L;
    private final int mCode;

    public RpcException() {
        this(-1, (String) null, (Throwable) null);
    }

    public RpcException(String str, Throwable th) {
        this(-1, str, th);
    }

    public RpcException(String str) {
        this(-1, str, (Throwable) null);
    }

    public RpcException(Throwable th) {
        this(-1, (String) null, th);
    }

    public RpcException(int i, String str) {
        this(i, str, (Throwable) null);
    }

    public RpcException(int i, String str, Throwable th) {
        super(str, th);
        this.mCode = i;
    }

    public int getErrorCode() {
        return this.mCode;
    }
}
