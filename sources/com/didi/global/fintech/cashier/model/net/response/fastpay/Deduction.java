package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/Deduction;", "", "title", "", "payChannelList", "", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/DeductionPayChannel;", "(Ljava/lang/String;Ljava/util/List;)V", "getPayChannelList", "()Ljava/util/List;", "setPayChannelList", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderResponse.kt */
public final class Deduction {
    @SerializedName("pay_channel_list")
    private List<DeductionPayChannel> payChannelList;
    @SerializedName("title")
    private String title;

    public static /* synthetic */ Deduction copy$default(Deduction deduction, String str, List<DeductionPayChannel> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deduction.title;
        }
        if ((i & 2) != 0) {
            list = deduction.payChannelList;
        }
        return deduction.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<DeductionPayChannel> component2() {
        return this.payChannelList;
    }

    public final Deduction copy(String str, List<DeductionPayChannel> list) {
        Intrinsics.checkNotNullParameter(list, "payChannelList");
        return new Deduction(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Deduction)) {
            return false;
        }
        Deduction deduction = (Deduction) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) deduction.title) && Intrinsics.areEqual((Object) this.payChannelList, (Object) deduction.payChannelList);
    }

    public int hashCode() {
        String str = this.title;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.payChannelList.hashCode();
    }

    public String toString() {
        return "Deduction(title=" + this.title + ", payChannelList=" + this.payChannelList + VersionRange.RIGHT_OPEN;
    }

    public Deduction(String str, List<DeductionPayChannel> list) {
        Intrinsics.checkNotNullParameter(list, "payChannelList");
        this.title = str;
        this.payChannelList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<DeductionPayChannel> getPayChannelList() {
        return this.payChannelList;
    }

    public final void setPayChannelList(List<DeductionPayChannel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.payChannelList = list;
    }
}
