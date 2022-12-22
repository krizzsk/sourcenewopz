package com.didichuxing.comp.telecom.core.voip.tipstate;

import android.os.Handler;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didichuxing/comp/telecom/core/voip/tipstate/TipStateComponent$runnable$1", "Ljava/lang/Runnable;", "run", "", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: TipStateComponent.kt */
public final class TipStateComponent$runnable$1 implements Runnable {
    final /* synthetic */ TipStateComponent this$0;

    TipStateComponent$runnable$1(TipStateComponent tipStateComponent) {
        this.this$0 = tipStateComponent;
    }

    public void run() {
        this.this$0.m33308a();
        Handler access$getMHandler$p = this.this$0.f46462b;
        if (access$getMHandler$p != null) {
            access$getMHandler$p.postDelayed(this, 1000);
        }
    }
}
