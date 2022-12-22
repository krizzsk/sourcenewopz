package com.didi.foundation.sdk.p116im;

import com.didi.beatles.p099im.access.IMAssister;
import com.didi.beatles.p099im.access.core.IMNotifyLister;
import com.didi.foundation.sdk.liveconnection.LiveConnectionService;
import com.didi.foundation.sdk.push.PushService;
import com.didi.sdk.logging.Logger;

/* renamed from: com.didi.foundation.sdk.im.a */
/* compiled from: FoundationIMAssistant */
class C8357a implements IMAssister {

    /* renamed from: a */
    private static final int f21176a = 4096;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Logger f21177b = IMHelper.f21171a;

    C8357a() {
    }

    public void createPushChannel(IMNotifyLister iMNotifyLister) {
        PushService instance = PushService.getInstance();
        instance.registerMessageReceiver(new FoundationIMAssistant$1(this, iMNotifyLister, instance));
        LiveConnectionService.getInstance().registerMessageListener(new FoundationIMAssistant$2(this, iMNotifyLister));
    }
}
