package com.didichuxing.comp.telecom.core.voip;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 13})
/* compiled from: SimpleCallingListener.kt */
final class CallingServiceListenerWrapper$onJoinFailed$1 implements Runnable {
    final /* synthetic */ String $p0;
    final /* synthetic */ CallingServiceListenerWrapper this$0;

    CallingServiceListenerWrapper$onJoinFailed$1(CallingServiceListenerWrapper callingServiceListenerWrapper, String str) {
        this.this$0 = callingServiceListenerWrapper;
        this.$p0 = str;
    }

    public final void run() {
        this.this$0.f46428a.onJoinFailed(this.$p0);
    }
}
