package com.didi.sdk.onehotpatch.installer.merge.dex;

public class DexException extends RuntimeException {
    public DexException(String str) {
        super(str);
    }

    public DexException(Throwable th) {
        super(th);
    }
}
