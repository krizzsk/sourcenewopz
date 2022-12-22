package com.didi.rfusion.widget.floating;

/* renamed from: com.didi.rfusion.widget.floating.c */
/* compiled from: RFFloatingNavBarModel */
class C11559c implements Cloneable {

    /* renamed from: a */
    RFFloatingTextAttr f33581a;

    /* renamed from: b */
    RFFloatingIconAttr f33582b;

    /* renamed from: c */
    RFFloatingTextAttr f33583c;

    /* renamed from: d */
    boolean f33584d;

    /* renamed from: e */
    boolean f33585e;

    /* renamed from: f */
    int f33586f;

    C11559c() {
    }

    C11559c(RFFloatingTextAttr rFFloatingTextAttr, RFFloatingIconAttr rFFloatingIconAttr, RFFloatingTextAttr rFFloatingTextAttr2, boolean z, boolean z2, int i) {
        this.f33581a = rFFloatingTextAttr;
        this.f33582b = rFFloatingIconAttr;
        this.f33583c = rFFloatingTextAttr2;
        this.f33584d = z;
        this.f33585e = z2;
        this.f33586f = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C11559c clone() {
        try {
            return (C11559c) super.clone();
        } catch (Exception e) {
            C11559c cVar = new C11559c();
            e.printStackTrace();
            return cVar;
        }
    }
}
