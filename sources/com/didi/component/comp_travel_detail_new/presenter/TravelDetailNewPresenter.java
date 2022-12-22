package com.didi.component.comp_travel_detail_new.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.comp_travel_detail_new.AbsTravelDetailNewPresenter;
import com.didi.sdk.app.BusinessContext;

public class TravelDetailNewPresenter extends AbsTravelDetailNewPresenter {

    /* renamed from: a */
    private Context f12500a;

    public TravelDetailNewPresenter(BusinessContext businessContext) {
        super(businessContext);
        this.f12500a = businessContext.getContext();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }
}
