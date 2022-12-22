package com.didi.global.globaluikit.popup;

import android.view.View;
import com.didi.global.globaluikit.model.LEGOTextModel;
import com.didi.global.globaluikit.popup.model.LEGOBubbleArrow;
import com.didi.global.globaluikit.popup.model.LEGOBubbleBaseModel;

/* renamed from: com.didi.global.globaluikit.popup.b */
/* compiled from: LEGOPopupModel */
class C8666b {

    /* renamed from: a */
    public LEGOTextModel f22616a;

    /* renamed from: b */
    public String f22617b;

    /* renamed from: c */
    public int f22618c;

    /* renamed from: d */
    public String f22619d;

    /* renamed from: e */
    public String f22620e;

    /* renamed from: f */
    public LEGOBubbleArrow f22621f;

    /* renamed from: g */
    public View.OnClickListener f22622g;

    C8666b(LEGOBubbleBaseModel lEGOBubbleBaseModel, View.OnClickListener onClickListener) {
        this.f22616a = lEGOBubbleBaseModel.text;
        this.f22617b = lEGOBubbleBaseModel.icon;
        this.f22618c = lEGOBubbleBaseModel.cancelable;
        this.f22619d = lEGOBubbleBaseModel.background_color;
        this.f22620e = lEGOBubbleBaseModel.url;
        this.f22621f = lEGOBubbleBaseModel.arrow;
        this.f22622g = onClickListener;
    }
}
