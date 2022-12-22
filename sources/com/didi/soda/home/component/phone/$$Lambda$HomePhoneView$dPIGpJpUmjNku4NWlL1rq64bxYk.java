package com.didi.soda.home.component.phone;

import android.view.View;
import com.didi.soda.customer.p165h5.CustomerH5UrlConst;
import com.didi.soda.router.DiRouter;

/* renamed from: com.didi.soda.home.component.phone.-$$Lambda$HomePhoneView$dPIGpJpUmjNku4NWlL1rq64bxYk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$HomePhoneView$dPIGpJpUmjNku4NWlL1rq64bxYk implements View.OnClickListener {
    public static final /* synthetic */ $$Lambda$HomePhoneView$dPIGpJpUmjNku4NWlL1rq64bxYk INSTANCE = new $$Lambda$HomePhoneView$dPIGpJpUmjNku4NWlL1rq64bxYk();

    private /* synthetic */ $$Lambda$HomePhoneView$dPIGpJpUmjNku4NWlL1rq64bxYk() {
    }

    public final void onClick(View view) {
        DiRouter.request().path("webPage").putString("url", CustomerH5UrlConst.getLawUrl()).open();
    }
}
