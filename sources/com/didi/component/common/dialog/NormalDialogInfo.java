package com.didi.component.common.dialog;

import android.graphics.drawable.Drawable;
import com.didi.sdk.view.dialog.AlertController;

public class NormalDialogInfo extends DialogInfo {

    /* renamed from: a */
    int f11580a;

    /* renamed from: b */
    Drawable f11581b;

    /* renamed from: c */
    AlertController.IconType f11582c;

    /* renamed from: d */
    CharSequence f11583d;

    /* renamed from: e */
    CharSequence f11584e;

    /* renamed from: f */
    CharSequence f11585f;

    /* renamed from: g */
    CharSequence f11586g;

    /* renamed from: h */
    CharSequence f11587h;

    /* renamed from: i */
    boolean f11588i = true;

    /* renamed from: j */
    boolean f11589j;

    /* renamed from: k */
    boolean f11590k = false;

    /* renamed from: l */
    boolean f11591l = false;

    public void setSupportMultiLine(boolean z) {
        this.f11591l = z;
    }

    public NormalDialogInfo(int i) {
        super(i);
    }

    public NormalDialogInfo setIcon(int i) {
        this.f11580a = i;
        return this;
    }

    public NormalDialogInfo setIcon(Drawable drawable) {
        this.f11581b = drawable;
        return this;
    }

    public NormalDialogInfo setIcon(AlertController.IconType iconType) {
        this.f11582c = iconType;
        return this;
    }

    public NormalDialogInfo setTitle(CharSequence charSequence) {
        this.f11583d = charSequence;
        return this;
    }

    public NormalDialogInfo setMessage(CharSequence charSequence) {
        this.f11584e = charSequence;
        return this;
    }

    public NormalDialogInfo setPositiveText(CharSequence charSequence) {
        this.f11585f = charSequence;
        return this;
    }

    public NormalDialogInfo setNeutralText(CharSequence charSequence) {
        this.f11586g = charSequence;
        return this;
    }

    public NormalDialogInfo setNegativeText(CharSequence charSequence) {
        this.f11587h = charSequence;
        return this;
    }

    public NormalDialogInfo setCancelable(boolean z) {
        this.f11589j = z;
        return this;
    }

    public NormalDialogInfo setIconVisible(boolean z) {
        this.f11588i = z;
        return this;
    }

    public NormalDialogInfo setCloseVisible(boolean z) {
        this.f11590k = z;
        return this;
    }
}
