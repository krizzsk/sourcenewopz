package com.didichuxing.gbankcard.ocr.act;

import com.didichuxing.dfbasesdk.act.DFBaseAct;
import com.taxis99.R;

/* renamed from: com.didichuxing.gbankcard.ocr.act.a */
/* compiled from: GBankcardBaseAct */
abstract class C15711a extends DFBaseAct {
    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.gbankcard_base_act_title;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.gbankcard_base_act_progress_msg;
    }

    C15711a() {
    }

    /* access modifiers changed from: protected */
    public void customizeLeftTitleBtn() {
        this.mLeftTitleBtn.setImageResource(R.drawable.gbankcard_back_icon);
    }
}
