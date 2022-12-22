package com.didi.app.nova.skeleton.dialog;

/* renamed from: com.didi.app.nova.skeleton.dialog.a */
/* compiled from: DialogTransaction */
final class C3727a {

    /* renamed from: a */
    private Dialog f8437a;

    /* renamed from: b */
    private String f8438b;

    /* renamed from: a */
    public static C3727a m5630a(Dialog dialog) {
        return new C3727a(dialog);
    }

    private C3727a(Dialog dialog) {
        this.f8437a = dialog;
    }

    /* renamed from: a */
    public C3727a mo40921a(String str) {
        this.f8438b = str;
        return this;
    }

    /* renamed from: a */
    public TransformAnimation mo40920a() {
        return this.f8437a.getEnterAnimation();
    }

    /* renamed from: b */
    public TransformAnimation mo40922b() {
        return this.f8437a.getExitAnimation();
    }

    /* renamed from: c */
    public String mo40923c() {
        return this.f8438b;
    }

    /* renamed from: d */
    public Dialog mo40924d() {
        return this.f8437a;
    }
}
