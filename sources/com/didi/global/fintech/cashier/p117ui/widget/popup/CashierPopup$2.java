package com.didi.global.fintech.cashier.p117ui.widget.popup;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierPopup$2 */
class CashierPopup$2 implements View.OnClickListener {
    final /* synthetic */ C8518a this$0;

    CashierPopup$2(C8518a aVar) {
        this.this$0 = aVar;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.this$0.dismiss();
    }
}
