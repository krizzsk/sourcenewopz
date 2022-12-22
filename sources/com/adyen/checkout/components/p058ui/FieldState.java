package com.adyen.checkout.components.p058ui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u0005HÆ\u0003J(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, mo175978d2 = {"Lcom/adyen/checkout/components/ui/FieldState;", "T", "", "value", "validation", "Lcom/adyen/checkout/components/ui/Validation;", "(Ljava/lang/Object;Lcom/adyen/checkout/components/ui/Validation;)V", "getValidation", "()Lcom/adyen/checkout/components/ui/Validation;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Object;Lcom/adyen/checkout/components/ui/Validation;)Lcom/adyen/checkout/components/ui/FieldState;", "equals", "", "other", "hashCode", "", "toString", "", "components-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.adyen.checkout.components.ui.FieldState */
/* compiled from: FieldState.kt */
public final class FieldState<T> {

    /* renamed from: a */
    private final T f894a;

    /* renamed from: b */
    private final Validation f895b;

    public static /* synthetic */ FieldState copy$default(FieldState fieldState, T t, Validation validation, int i, Object obj) {
        if ((i & 1) != 0) {
            t = fieldState.f894a;
        }
        if ((i & 2) != 0) {
            validation = fieldState.f895b;
        }
        return fieldState.copy(t, validation);
    }

    public final T component1() {
        return this.f894a;
    }

    public final Validation component2() {
        return this.f895b;
    }

    public final FieldState<T> copy(T t, Validation validation) {
        Intrinsics.checkNotNullParameter(validation, "validation");
        return new FieldState<>(t, validation);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldState)) {
            return false;
        }
        FieldState fieldState = (FieldState) obj;
        return Intrinsics.areEqual((Object) this.f894a, (Object) fieldState.f894a) && Intrinsics.areEqual((Object) this.f895b, (Object) fieldState.f895b);
    }

    public int hashCode() {
        T t = this.f894a;
        return ((t == null ? 0 : t.hashCode()) * 31) + this.f895b.hashCode();
    }

    public String toString() {
        return "FieldState(value=" + this.f894a + ", validation=" + this.f895b + VersionRange.RIGHT_OPEN;
    }

    public FieldState(T t, Validation validation) {
        Intrinsics.checkNotNullParameter(validation, "validation");
        this.f894a = t;
        this.f895b = validation;
    }

    public final T getValue() {
        return this.f894a;
    }

    public final Validation getValidation() {
        return this.f895b;
    }
}
