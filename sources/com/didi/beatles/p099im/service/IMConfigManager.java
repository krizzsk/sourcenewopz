package com.didi.beatles.p099im.service;

import com.didi.beatles.p099im.access.IMContext;

/* renamed from: com.didi.beatles.im.service.IMConfigManager */
public class IMConfigManager extends IMBaseProvider {

    /* renamed from: a */
    private IMContext f9586a;

    /* renamed from: b */
    private long f9587b;

    protected IMConfigManager(IMServiceProvider iMServiceProvider) {
        super(iMServiceProvider);
    }

    public void init(IMContext iMContext) {
        this.f9586a = iMContext;
        this.f9587b = iMContext.getUid();
        this.mProvider.getDaoManager().init(this.f9587b);
        this.mProvider.getFileManager().init(this.f9587b);
    }

    public long getLoginId() {
        return this.f9587b;
    }
}
