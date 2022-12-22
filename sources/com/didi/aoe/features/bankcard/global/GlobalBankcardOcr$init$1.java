package com.didi.aoe.features.bankcard.global;

import com.didi.aoe.library.core.AoeClient;
import com.didi.aoe.library.logging.Logger;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/aoe/features/bankcard/global/GlobalBankcardOcr$init$1", "Lcom/didi/aoe/library/core/AoeClient$OnInitListener;", "onFailed", "", "code", "", "msg", "", "onSuccess", "global-ocr_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: GlobalBankcardOcr.kt */
public final class GlobalBankcardOcr$init$1 extends AoeClient.OnInitListener {
    final /* synthetic */ GlobalBankcardOcr this$0;

    GlobalBankcardOcr$init$1(GlobalBankcardOcr globalBankcardOcr) {
        this.this$0 = globalBankcardOcr;
    }

    public void onSuccess() {
        super.onSuccess();
        this.this$0.f8150a.debug("aoe client init success", new Object[0]);
    }

    public void onFailed(int i, String str) {
        super.onFailed(i, str);
        Logger access$getMLogger$p = this.this$0.f8150a;
        access$getMLogger$p.debug("aoe client init failed, code: " + i + ", msg: " + str, new Object[0]);
    }
}
