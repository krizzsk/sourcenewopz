package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/CommonResourceState;", "Ljava/io/Serializable;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "title", "", "bannerState", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/ResourceStateData;", "popUpState", "suspensionState", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBannerState", "()Ljava/util/List;", "setBannerState", "(Ljava/util/List;)V", "getPopUpState", "setPopUpState", "getSuspensionState", "setSuspensionState", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.resp.CommonResourceState */
/* compiled from: WalletHomeModel.kt */
public final class CommonResourceState implements IData, Serializable {
    private List<ResourceStateData> bannerState;
    private List<ResourceStateData> popUpState;
    private List<ResourceStateData> suspensionState;
    private String title;

    public CommonResourceState() {
        this((String) null, (List) null, (List) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CommonResourceState copy$default(CommonResourceState commonResourceState, String str, List<ResourceStateData> list, List<ResourceStateData> list2, List<ResourceStateData> list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = commonResourceState.title;
        }
        if ((i & 2) != 0) {
            list = commonResourceState.bannerState;
        }
        if ((i & 4) != 0) {
            list2 = commonResourceState.popUpState;
        }
        if ((i & 8) != 0) {
            list3 = commonResourceState.suspensionState;
        }
        return commonResourceState.copy(str, list, list2, list3);
    }

    public final String component1() {
        return this.title;
    }

    public final List<ResourceStateData> component2() {
        return this.bannerState;
    }

    public final List<ResourceStateData> component3() {
        return this.popUpState;
    }

    public final List<ResourceStateData> component4() {
        return this.suspensionState;
    }

    public final CommonResourceState copy(String str, List<ResourceStateData> list, List<ResourceStateData> list2, List<ResourceStateData> list3) {
        return new CommonResourceState(str, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommonResourceState)) {
            return false;
        }
        CommonResourceState commonResourceState = (CommonResourceState) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) commonResourceState.title) && Intrinsics.areEqual((Object) this.bannerState, (Object) commonResourceState.bannerState) && Intrinsics.areEqual((Object) this.popUpState, (Object) commonResourceState.popUpState) && Intrinsics.areEqual((Object) this.suspensionState, (Object) commonResourceState.suspensionState);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ResourceStateData> list = this.bannerState;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ResourceStateData> list2 = this.popUpState;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<ResourceStateData> list3 = this.suspensionState;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "CommonResourceState(title=" + this.title + ", bannerState=" + this.bannerState + ", popUpState=" + this.popUpState + ", suspensionState=" + this.suspensionState + VersionRange.RIGHT_OPEN;
    }

    public CommonResourceState(String str, List<ResourceStateData> list, List<ResourceStateData> list2, List<ResourceStateData> list3) {
        this.title = str;
        this.bannerState = list;
        this.popUpState = list2;
        this.suspensionState = list3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonResourceState(String str, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : list3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<ResourceStateData> getBannerState() {
        return this.bannerState;
    }

    public final void setBannerState(List<ResourceStateData> list) {
        this.bannerState = list;
    }

    public final List<ResourceStateData> getPopUpState() {
        return this.popUpState;
    }

    public final void setPopUpState(List<ResourceStateData> list) {
        this.popUpState = list;
    }

    public final List<ResourceStateData> getSuspensionState() {
        return this.suspensionState;
    }

    public final void setSuspensionState(List<ResourceStateData> list) {
        this.suspensionState = list;
    }
}
