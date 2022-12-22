package com.didi.security.wireless.adapter;

import android.content.Context;
import com.didi.onehybrid.FusionEngine;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushKey;

/* renamed from: com.didi.security.wireless.adapter.b */
/* compiled from: SecurityInitializer */
class C13359b {

    /* renamed from: a */
    private static final int f38622a = 274;

    C13359b() {
    }

    /* renamed from: a */
    static void m27351a(Context context) {
        FusionEngine.export("WSGHybridModule", WSGHybridModule.class);
        m27350a();
    }

    /* renamed from: a */
    private static void m27350a() {
        PushClient.getClient().registerMessageListener(PushKey.Creator.createAppPushMsgKey(274), new SecurityInitializer$1());
    }
}
