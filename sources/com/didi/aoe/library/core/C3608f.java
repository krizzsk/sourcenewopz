package com.didi.aoe.library.core;

import com.didi.aoe.library.api.AoeProcessor;

/* renamed from: com.didi.aoe.library.core.f */
/* compiled from: ProcessorDelegate */
final class C3608f implements AoeProcessor {

    /* renamed from: a */
    private final AoeProcessor f8194a;

    /* renamed from: b */
    private final C3607e f8195b = new C3607e();

    public C3608f(AoeProcessor aoeProcessor) {
        this.f8194a = aoeProcessor;
    }

    public void setId(String str) {
        this.f8194a.setId(str);
    }

    public AoeProcessor.InterpreterComponent getInterpreterComponent() {
        return this.f8194a.getInterpreterComponent();
    }

    public AoeProcessor.ParcelComponent getParcelComponent() {
        return this.f8194a.getParcelComponent();
    }

    /* renamed from: a */
    public C3607e mo40243a() {
        return this.f8195b;
    }
}
