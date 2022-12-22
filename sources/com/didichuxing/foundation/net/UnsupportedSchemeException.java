package com.didichuxing.foundation.net;

import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class UnsupportedSchemeException extends RuntimeException {
    private static final long serialVersionUID = 1483805501877757662L;
    private final String mScheme;

    public UnsupportedSchemeException(String str) {
        super("Unsupported scheme: [" + str + Const.jaRight);
        this.mScheme = str;
    }

    public String getScheme() {
        return this.mScheme;
    }
}
