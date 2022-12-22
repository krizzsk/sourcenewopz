package com.didi.soda.customer.foundation.p164im;

import com.didi.beatles.p099im.module.IMSessionUnreadCallback;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;

/* renamed from: com.didi.soda.customer.foundation.im.-$$Lambda$IMDefaultImp$b2FBH2aUV0bPjlJ49aY3ppZn3uk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$IMDefaultImp$b2FBH2aUV0bPjlJ49aY3ppZn3uk implements IMSessionUnreadCallback {
    public static final /* synthetic */ $$Lambda$IMDefaultImp$b2FBH2aUV0bPjlJ49aY3ppZn3uk INSTANCE = new $$Lambda$IMDefaultImp$b2FBH2aUV0bPjlJ49aY3ppZn3uk();

    private /* synthetic */ $$Lambda$IMDefaultImp$b2FBH2aUV0bPjlJ49aY3ppZn3uk() {
    }

    public final void unReadCount(int i) {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).setUnreadImCount(i);
    }
}
