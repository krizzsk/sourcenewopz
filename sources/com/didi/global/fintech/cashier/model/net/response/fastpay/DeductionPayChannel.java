package com.didi.global.fintech.cashier.model.net.response.fastpay;

import com.didi.global.fintech.cashier.model.net.request.fastpay.DeductionChannel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006)"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/DeductionPayChannel;", "Lcom/didi/global/fintech/cashier/model/net/request/fastpay/DeductionChannel;", "type", "", "iconUrl", "display", "subheadDisplay", "available", "", "notAvailableDesc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAvailable", "()Z", "setAvailable", "(Z)V", "getDisplay", "()Ljava/lang/String;", "setDisplay", "(Ljava/lang/String;)V", "getIconUrl", "setIconUrl", "getNotAvailableDesc", "setNotAvailableDesc", "getSubheadDisplay", "setSubheadDisplay", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderResponse.kt */
public final class DeductionPayChannel extends DeductionChannel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYMENT_TYPE_BIND_CARD = "bind_card";
    public static final String PAYMENT_TYPE_CHANNEL = "channel";
    @SerializedName("is_available")
    private boolean available;
    @SerializedName("display")
    private String display;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("not_available_desc")
    private String notAvailableDesc;
    @SerializedName("subhead_display")
    private String subheadDisplay;
    @SerializedName("type")
    private String type;

    public static /* synthetic */ DeductionPayChannel copy$default(DeductionPayChannel deductionPayChannel, String str, String str2, String str3, String str4, boolean z, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deductionPayChannel.type;
        }
        if ((i & 2) != 0) {
            str2 = deductionPayChannel.iconUrl;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = deductionPayChannel.display;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = deductionPayChannel.subheadDisplay;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            z = deductionPayChannel.available;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str5 = deductionPayChannel.notAvailableDesc;
        }
        return deductionPayChannel.copy(str, str6, str7, str8, z2, str5);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.iconUrl;
    }

    public final String component3() {
        return this.display;
    }

    public final String component4() {
        return this.subheadDisplay;
    }

    public final boolean component5() {
        return this.available;
    }

    public final String component6() {
        return this.notAvailableDesc;
    }

    public final DeductionPayChannel copy(String str, String str2, String str3, String str4, boolean z, String str5) {
        Intrinsics.checkNotNullParameter(str, "type");
        return new DeductionPayChannel(str, str2, str3, str4, z, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeductionPayChannel)) {
            return false;
        }
        DeductionPayChannel deductionPayChannel = (DeductionPayChannel) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) deductionPayChannel.type) && Intrinsics.areEqual((Object) this.iconUrl, (Object) deductionPayChannel.iconUrl) && Intrinsics.areEqual((Object) this.display, (Object) deductionPayChannel.display) && Intrinsics.areEqual((Object) this.subheadDisplay, (Object) deductionPayChannel.subheadDisplay) && this.available == deductionPayChannel.available && Intrinsics.areEqual((Object) this.notAvailableDesc, (Object) deductionPayChannel.notAvailableDesc);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.iconUrl;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.display;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.subheadDisplay;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z = this.available;
        if (z) {
            z = true;
        }
        int i2 = (hashCode4 + (z ? 1 : 0)) * 31;
        String str4 = this.notAvailableDesc;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "DeductionPayChannel(type=" + this.type + ", iconUrl=" + this.iconUrl + ", display=" + this.display + ", subheadDisplay=" + this.subheadDisplay + ", available=" + this.available + ", notAvailableDesc=" + this.notAvailableDesc + VersionRange.RIGHT_OPEN;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeductionPayChannel(String str, String str2, String str3, String str4, boolean z, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i & 16) != 0 ? false : z, str5);
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final void setDisplay(String str) {
        this.display = str;
    }

    public final String getSubheadDisplay() {
        return this.subheadDisplay;
    }

    public final void setSubheadDisplay(String str) {
        this.subheadDisplay = str;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final void setAvailable(boolean z) {
        this.available = z;
    }

    public final String getNotAvailableDesc() {
        return this.notAvailableDesc;
    }

    public final void setNotAvailableDesc(String str) {
        this.notAvailableDesc = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/fastpay/DeductionPayChannel$Companion;", "", "()V", "PAYMENT_TYPE_BIND_CARD", "", "PAYMENT_TYPE_CHANNEL", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: FastPayOrderResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeductionPayChannel(String str, String str2, String str3, String str4, boolean z, String str5) {
        super((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "type");
        this.type = str;
        this.iconUrl = str2;
        this.display = str3;
        this.subheadDisplay = str4;
        this.available = z;
        this.notAvailableDesc = str5;
    }
}
