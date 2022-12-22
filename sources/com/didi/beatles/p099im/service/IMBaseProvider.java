package com.didi.beatles.p099im.service;

import android.content.Context;

/* renamed from: com.didi.beatles.im.service.IMBaseProvider */
public class IMBaseProvider {
    protected Context mContext;
    protected IMServiceProvider mProvider;

    protected IMBaseProvider(IMServiceProvider iMServiceProvider) {
        this.mProvider = iMServiceProvider;
        this.mContext = iMServiceProvider.getContext();
    }
}
