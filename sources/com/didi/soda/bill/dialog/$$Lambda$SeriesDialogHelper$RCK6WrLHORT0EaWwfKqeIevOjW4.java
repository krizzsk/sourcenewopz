package com.didi.soda.bill.dialog;

import android.view.View;
import com.didi.soda.customer.foundation.tracker.event.EventConst;

/* renamed from: com.didi.soda.bill.dialog.-$$Lambda$SeriesDialogHelper$RCK6WrLHORT0EaWwfKqeIevOjW4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SeriesDialogHelper$RCK6WrLHORT0EaWwfKqeIevOjW4 implements View.OnClickListener {
    public static final /* synthetic */ $$Lambda$SeriesDialogHelper$RCK6WrLHORT0EaWwfKqeIevOjW4 INSTANCE = new $$Lambda$SeriesDialogHelper$RCK6WrLHORT0EaWwfKqeIevOjW4();

    private /* synthetic */ $$Lambda$SeriesDialogHelper$RCK6WrLHORT0EaWwfKqeIevOjW4() {
    }

    public final void onClick(View view) {
        SeriesDialogHelper.m27692a((String) EventConst.Cart.EVENT_JUVENILES_POPUP_CK).addEventParam("click_type", 0).build().track();
    }
}
