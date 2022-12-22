package com.didi.component.comp_selectseat.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.comp_selectseat.AbsSeatSelectPresenter;
import com.didi.sdk.app.BusinessContext;

public class SeatSelectPresenter extends AbsSeatSelectPresenter {

    /* renamed from: a */
    private Context f12405a;

    public SeatSelectPresenter(BusinessContext businessContext) {
        super(businessContext);
        this.f12405a = businessContext.getContext();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }
}
