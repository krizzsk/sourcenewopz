package com.didi.component.service.activity.risk.dialog;

import android.graphics.drawable.Drawable;
import com.didi.sdk.view.dialog.AlertController;

public class NormalDialogInfo extends com.didi.component.common.dialog.NormalDialogInfo {

    /* renamed from: m */
    int f15707m;

    /* renamed from: n */
    Drawable f15708n;

    /* renamed from: o */
    AlertController.IconType f15709o;

    /* renamed from: p */
    CharSequence f15710p;

    /* renamed from: q */
    CharSequence f15711q;

    /* renamed from: r */
    CharSequence f15712r;

    /* renamed from: s */
    CharSequence f15713s;

    /* renamed from: t */
    CharSequence f15714t;

    /* renamed from: u */
    boolean f15715u = true;

    /* renamed from: v */
    boolean f15716v;

    /* renamed from: w */
    boolean f15717w = false;

    public NormalDialogInfo(int i) {
        super(i);
    }

    public NormalDialogInfo setIcon(int i) {
        this.f15707m = i;
        return this;
    }

    public NormalDialogInfo setIcon(Drawable drawable) {
        this.f15708n = drawable;
        return this;
    }

    public NormalDialogInfo setIcon(AlertController.IconType iconType) {
        this.f15709o = iconType;
        return this;
    }

    public NormalDialogInfo setTitle(CharSequence charSequence) {
        this.f15710p = charSequence;
        return this;
    }

    public NormalDialogInfo setMessage(CharSequence charSequence) {
        this.f15711q = charSequence;
        return this;
    }

    public NormalDialogInfo setPositiveText(CharSequence charSequence) {
        this.f15712r = charSequence;
        return this;
    }

    public NormalDialogInfo setNeutralText(CharSequence charSequence) {
        this.f15713s = charSequence;
        return this;
    }

    public NormalDialogInfo setNegativeText(CharSequence charSequence) {
        this.f15714t = charSequence;
        return this;
    }

    public NormalDialogInfo setCancelable(boolean z) {
        this.f15716v = z;
        return this;
    }

    public NormalDialogInfo setIconVisible(boolean z) {
        this.f15715u = z;
        return this;
    }

    public NormalDialogInfo setCloseVisible(boolean z) {
        this.f15717w = z;
        return this;
    }
}
