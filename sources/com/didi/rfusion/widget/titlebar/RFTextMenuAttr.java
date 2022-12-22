package com.didi.rfusion.widget.titlebar;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/rfusion/widget/titlebar/RFTextMenuAttr;", "Lcom/didi/rfusion/widget/titlebar/RFMenuAttr;", "text", "", "listener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "getListener", "()Landroid/view/View$OnClickListener;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFMenuAttr.kt */
public final class RFTextMenuAttr implements RFMenuAttr {

    /* renamed from: a */
    private final String f33965a;

    /* renamed from: b */
    private final View.OnClickListener f33966b;

    public static /* synthetic */ RFTextMenuAttr copy$default(RFTextMenuAttr rFTextMenuAttr, String str, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFTextMenuAttr.f33965a;
        }
        if ((i & 2) != 0) {
            onClickListener = rFTextMenuAttr.f33966b;
        }
        return rFTextMenuAttr.copy(str, onClickListener);
    }

    public final String component1() {
        return this.f33965a;
    }

    public final View.OnClickListener component2() {
        return this.f33966b;
    }

    public final RFTextMenuAttr copy(String str, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(onClickListener, "listener");
        return new RFTextMenuAttr(str, onClickListener);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFTextMenuAttr)) {
            return false;
        }
        RFTextMenuAttr rFTextMenuAttr = (RFTextMenuAttr) obj;
        return Intrinsics.areEqual((Object) this.f33965a, (Object) rFTextMenuAttr.f33965a) && Intrinsics.areEqual((Object) this.f33966b, (Object) rFTextMenuAttr.f33966b);
    }

    public int hashCode() {
        String str = this.f33965a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        View.OnClickListener onClickListener = this.f33966b;
        if (onClickListener != null) {
            i = onClickListener.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RFTextMenuAttr(text=" + this.f33965a + ", listener=" + this.f33966b + ")";
    }

    public RFTextMenuAttr(String str, View.OnClickListener onClickListener) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        Intrinsics.checkParameterIsNotNull(onClickListener, "listener");
        this.f33965a = str;
        this.f33966b = onClickListener;
    }

    public final String getText() {
        return this.f33965a;
    }

    public final View.OnClickListener getListener() {
        return this.f33966b;
    }
}
