package com.didichuxing.comp.telecom.biz.api;

import android.content.Context;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: VoipBusinessSDK.kt */
final class VoipBusinessSDK$displayInComingCall$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $jsonStr;
    final /* synthetic */ Integer $pushTye;

    VoipBusinessSDK$displayInComingCall$1(Context context, String str, Integer num) {
        this.$context = context;
        this.$jsonStr = str;
        this.$pushTye = num;
    }

    public final void run() {
        VoipBusinessSDK.INSTANCE.m33235a(this.$context, this.$jsonStr, this.$pushTye);
    }
}
