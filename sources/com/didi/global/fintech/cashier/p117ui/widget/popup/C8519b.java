package com.didi.global.fintech.cashier.p117ui.widget.popup;

import android.view.View;
import com.didi.global.fintech.cashier.p117ui.widget.popup.model.CashierBubbleArrow;
import com.didi.global.fintech.cashier.p117ui.widget.popup.model.CashierBubbleBaseModel;
import com.didi.global.fintech.cashier.p117ui.widget.popup.model.CashierTextModel;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.b */
/* compiled from: CashierPopupModel */
class C8519b {

    /* renamed from: a */
    public CashierTextModel f21954a;

    /* renamed from: b */
    public String f21955b;

    /* renamed from: c */
    public int f21956c;

    /* renamed from: d */
    public String f21957d;

    /* renamed from: e */
    public String f21958e;

    /* renamed from: f */
    public CashierBubbleArrow f21959f;

    /* renamed from: g */
    public View.OnClickListener f21960g;

    C8519b(CashierBubbleBaseModel cashierBubbleBaseModel, View.OnClickListener onClickListener) {
        this.f21954a = cashierBubbleBaseModel.text;
        this.f21955b = cashierBubbleBaseModel.icon;
        this.f21956c = cashierBubbleBaseModel.cancelable;
        this.f21957d = cashierBubbleBaseModel.background_color;
        this.f21958e = cashierBubbleBaseModel.url;
        this.f21959f = cashierBubbleBaseModel.arrow;
        this.f21960g = onClickListener;
    }
}
