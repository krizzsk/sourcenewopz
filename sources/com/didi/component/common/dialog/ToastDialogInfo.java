package com.didi.component.common.dialog;

import android.graphics.drawable.Drawable;

public class ToastDialogInfo extends DialogInfo {

    /* renamed from: a */
    Drawable f11594a;

    /* renamed from: b */
    IconType f11595b;

    /* renamed from: c */
    String f11596c;

    public enum IconType {
        INFO,
        COMPLETE,
        ERROR
    }

    public ToastDialogInfo(int i) {
        super(i);
        setCancelable(false);
    }

    public void setIcon(IconType iconType) {
        this.f11595b = iconType;
    }

    public void setIcon(Drawable drawable) {
        this.f11594a = drawable;
    }

    public void setMessage(String str) {
        this.f11596c = str;
    }
}
