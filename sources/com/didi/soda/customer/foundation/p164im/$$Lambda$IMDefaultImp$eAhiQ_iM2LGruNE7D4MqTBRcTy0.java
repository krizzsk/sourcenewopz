package com.didi.soda.customer.foundation.p164im;

import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;

/* renamed from: com.didi.soda.customer.foundation.im.-$$Lambda$IMDefaultImp$eAhiQ_iM2LGruNE7D4MqTBRcTy0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$IMDefaultImp$eAhiQ_iM2LGruNE7D4MqTBRcTy0 implements IMSessionUnreadCallback {
    public static final /* synthetic */ $$Lambda$IMDefaultImp$eAhiQ_iM2LGruNE7D4MqTBRcTy0 INSTANCE = new $$Lambda$IMDefaultImp$eAhiQ_iM2LGruNE7D4MqTBRcTy0();

    private /* synthetic */ $$Lambda$IMDefaultImp$eAhiQ_iM2LGruNE7D4MqTBRcTy0() {
    }

    public final void unReadCount(int i) {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).setUnReadRedCount(i);
    }
}
