package com.didi.component.common.dialog;

public class ImageHintDialogInfo extends DialogInfo {
    public static final int IMAGE_HOLDER_99 = 1;
    public static final int IMAGE_HOLDER_DIDI = 0;

    /* renamed from: a */
    String f11563a;

    /* renamed from: b */
    String f11564b;

    /* renamed from: c */
    String f11565c;

    /* renamed from: d */
    String f11566d;

    /* renamed from: e */
    int f11567e = -1;

    public ImageHintDialogInfo(int i) {
        super(i);
    }

    public ImageHintDialogInfo setImageUrl(String str) {
        this.f11563a = str;
        return this;
    }

    public ImageHintDialogInfo setTitle(String str) {
        this.f11564b = str;
        return this;
    }

    public ImageHintDialogInfo setSubtitle(String str) {
        this.f11565c = str;
        return this;
    }

    public ImageHintDialogInfo setButton(String str) {
        this.f11566d = str;
        return this;
    }

    public void setImageHolder(int i) {
        this.f11567e = i;
    }
}
