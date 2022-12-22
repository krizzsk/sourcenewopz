package com.didi.component.comp_form_common.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.comp_form_common.AbsFormCommonPresenter;
import com.didi.sdk.app.BusinessContext;

public class FormCommonPresenter extends AbsFormCommonPresenter {

    /* renamed from: a */
    private Context f12223a;

    public FormCommonPresenter(BusinessContext businessContext) {
        super(businessContext);
        this.f12223a = businessContext.getContext();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }
}
