package com.didi.rfusion.widget.calendar;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0003J3\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/rfusion/widget/calendar/RFDateSelection;", "T", "", "dateSelector", "Lcom/didi/rfusion/widget/calendar/RFDateSelector;", "listener", "Lcom/didi/rfusion/widget/calendar/OnSelectionChangedListener;", "(Lcom/didi/rfusion/widget/calendar/RFDateSelector;Lcom/didi/rfusion/widget/calendar/OnSelectionChangedListener;)V", "getDateSelector", "()Lcom/didi/rfusion/widget/calendar/RFDateSelector;", "getListener", "()Lcom/didi/rfusion/widget/calendar/OnSelectionChangedListener;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFDateSelection.kt */
public final class RFDateSelection<T> {

    /* renamed from: a */
    private final RFDateSelector<T> f33457a;

    /* renamed from: b */
    private final OnSelectionChangedListener<T> f33458b;

    public RFDateSelection() {
        this((RFDateSelector) null, (OnSelectionChangedListener) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RFDateSelection copy$default(RFDateSelection rFDateSelection, RFDateSelector<T> rFDateSelector, OnSelectionChangedListener<T> onSelectionChangedListener, int i, Object obj) {
        if ((i & 1) != 0) {
            rFDateSelector = rFDateSelection.f33457a;
        }
        if ((i & 2) != 0) {
            onSelectionChangedListener = rFDateSelection.f33458b;
        }
        return rFDateSelection.copy(rFDateSelector, onSelectionChangedListener);
    }

    public final RFDateSelector<T> component1() {
        return this.f33457a;
    }

    public final OnSelectionChangedListener<T> component2() {
        return this.f33458b;
    }

    public final RFDateSelection<T> copy(RFDateSelector<T> rFDateSelector, OnSelectionChangedListener<T> onSelectionChangedListener) {
        return new RFDateSelection<>(rFDateSelector, onSelectionChangedListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFDateSelection)) {
            return false;
        }
        RFDateSelection rFDateSelection = (RFDateSelection) obj;
        return Intrinsics.areEqual((Object) this.f33457a, (Object) rFDateSelection.f33457a) && Intrinsics.areEqual((Object) this.f33458b, (Object) rFDateSelection.f33458b);
    }

    public int hashCode() {
        RFDateSelector<T> rFDateSelector = this.f33457a;
        int i = 0;
        int hashCode = (rFDateSelector != null ? rFDateSelector.hashCode() : 0) * 31;
        OnSelectionChangedListener<T> onSelectionChangedListener = this.f33458b;
        if (onSelectionChangedListener != null) {
            i = onSelectionChangedListener.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RFDateSelection(dateSelector=" + this.f33457a + ", listener=" + this.f33458b + ")";
    }

    public RFDateSelection(RFDateSelector<T> rFDateSelector, OnSelectionChangedListener<T> onSelectionChangedListener) {
        this.f33457a = rFDateSelector;
        this.f33458b = onSelectionChangedListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFDateSelection(RFDateSelector rFDateSelector, OnSelectionChangedListener onSelectionChangedListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : rFDateSelector, (i & 2) != 0 ? null : onSelectionChangedListener);
    }

    public final RFDateSelector<T> getDateSelector() {
        return this.f33457a;
    }

    public final OnSelectionChangedListener<T> getListener() {
        return this.f33458b;
    }
}
