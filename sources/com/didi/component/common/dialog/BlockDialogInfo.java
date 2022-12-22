package com.didi.component.common.dialog;

public class BlockDialogInfo extends DialogInfo {

    /* renamed from: a */
    String f11525a;

    /* renamed from: b */
    String f11526b;

    /* renamed from: c */
    String f11527c;

    /* renamed from: d */
    String f11528d;

    public BlockDialogInfo(int i) {
        super(i);
    }

    public BlockDialogInfo setTitle(String str) {
        this.f11525a = str;
        return this;
    }

    public void setContent(String str) {
        this.f11526b = str;
    }

    public void setNegativeButton(String str) {
        this.f11527c = str;
    }

    public void setPositiveButton(String str) {
        this.f11528d = str;
    }
}
