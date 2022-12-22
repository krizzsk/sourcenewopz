package com.didichuxing.sofa.animation;

import android.animation.TypeEvaluator;

/* renamed from: com.didichuxing.sofa.animation.h */
/* compiled from: BaseEasingMethod */
abstract class C16462h implements TypeEvaluator<Number> {

    /* renamed from: a */
    private float f49103a;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Float mo121111a(float f, float f2, float f3, float f4);

    C16462h(float f) {
        this.f49103a = f;
    }

    /* renamed from: a */
    public void mo121113a(float f) {
        this.f49103a = f;
    }

    /* renamed from: a */
    public final Float evaluate(float f, Number number, Number number2) {
        return mo121111a(this.f49103a * f, number.floatValue(), number2.floatValue() - number.floatValue(), this.f49103a);
    }
}
