package com.didi.soda.address.component.selectlist.binder;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/address/component/selectlist/binder/SelectedAddressDescRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SelectedAddressDescRvModel.kt */
public final class SelectedAddressDescRvModel implements RecyclerModel {

    /* renamed from: a */
    private final String f38704a;

    public static /* synthetic */ SelectedAddressDescRvModel copy$default(SelectedAddressDescRvModel selectedAddressDescRvModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectedAddressDescRvModel.f38704a;
        }
        return selectedAddressDescRvModel.copy(str);
    }

    public final String component1() {
        return this.f38704a;
    }

    public final SelectedAddressDescRvModel copy(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new SelectedAddressDescRvModel(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SelectedAddressDescRvModel) && Intrinsics.areEqual((Object) this.f38704a, (Object) ((SelectedAddressDescRvModel) obj).f38704a);
    }

    public int hashCode() {
        return this.f38704a.hashCode();
    }

    public String toString() {
        return "SelectedAddressDescRvModel(text=" + this.f38704a + VersionRange.RIGHT_OPEN;
    }

    public SelectedAddressDescRvModel(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.f38704a = str;
    }

    public final String getText() {
        return this.f38704a;
    }
}
