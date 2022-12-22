package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001'BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006("}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo;", "Ljava/io/Serializable;", "originalAmount", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "accessoryCharges", "discountAmount", "actualAmount", "additionalInfo", "", "Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo;", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/util/List;)V", "getAccessoryCharges", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setAccessoryCharges", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "getActualAmount", "setActualAmount", "getAdditionalInfo", "()Ljava/util/List;", "setAdditionalInfo", "(Ljava/util/List;)V", "getDiscountAmount", "setDiscountAmount", "getOriginalAmount", "setOriginalAmount", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "AdditionalInfo", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PayInfoResponse.kt */
public final class PriceInfo implements Serializable {
    @SerializedName("accessory_charges")
    private PriceAmount accessoryCharges;
    @SerializedName("actual_amount")
    private PriceAmount actualAmount;
    @SerializedName("additional_info")
    private List<AdditionalInfo> additionalInfo;
    @SerializedName("discount_amount")
    private PriceAmount discountAmount;
    @SerializedName("original_amount")
    private PriceAmount originalAmount;

    public PriceInfo() {
        this((PriceAmount) null, (PriceAmount) null, (PriceAmount) null, (PriceAmount) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PriceInfo copy$default(PriceInfo priceInfo, PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, PriceAmount priceAmount4, List<AdditionalInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            priceAmount = priceInfo.originalAmount;
        }
        if ((i & 2) != 0) {
            priceAmount2 = priceInfo.accessoryCharges;
        }
        PriceAmount priceAmount5 = priceAmount2;
        if ((i & 4) != 0) {
            priceAmount3 = priceInfo.discountAmount;
        }
        PriceAmount priceAmount6 = priceAmount3;
        if ((i & 8) != 0) {
            priceAmount4 = priceInfo.actualAmount;
        }
        PriceAmount priceAmount7 = priceAmount4;
        if ((i & 16) != 0) {
            list = priceInfo.additionalInfo;
        }
        return priceInfo.copy(priceAmount, priceAmount5, priceAmount6, priceAmount7, list);
    }

    public final PriceAmount component1() {
        return this.originalAmount;
    }

    public final PriceAmount component2() {
        return this.accessoryCharges;
    }

    public final PriceAmount component3() {
        return this.discountAmount;
    }

    public final PriceAmount component4() {
        return this.actualAmount;
    }

    public final List<AdditionalInfo> component5() {
        return this.additionalInfo;
    }

    public final PriceInfo copy(PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, PriceAmount priceAmount4, List<AdditionalInfo> list) {
        return new PriceInfo(priceAmount, priceAmount2, priceAmount3, priceAmount4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PriceInfo)) {
            return false;
        }
        PriceInfo priceInfo = (PriceInfo) obj;
        return Intrinsics.areEqual((Object) this.originalAmount, (Object) priceInfo.originalAmount) && Intrinsics.areEqual((Object) this.accessoryCharges, (Object) priceInfo.accessoryCharges) && Intrinsics.areEqual((Object) this.discountAmount, (Object) priceInfo.discountAmount) && Intrinsics.areEqual((Object) this.actualAmount, (Object) priceInfo.actualAmount) && Intrinsics.areEqual((Object) this.additionalInfo, (Object) priceInfo.additionalInfo);
    }

    public int hashCode() {
        PriceAmount priceAmount = this.originalAmount;
        int i = 0;
        int hashCode = (priceAmount == null ? 0 : priceAmount.hashCode()) * 31;
        PriceAmount priceAmount2 = this.accessoryCharges;
        int hashCode2 = (hashCode + (priceAmount2 == null ? 0 : priceAmount2.hashCode())) * 31;
        PriceAmount priceAmount3 = this.discountAmount;
        int hashCode3 = (hashCode2 + (priceAmount3 == null ? 0 : priceAmount3.hashCode())) * 31;
        PriceAmount priceAmount4 = this.actualAmount;
        int hashCode4 = (hashCode3 + (priceAmount4 == null ? 0 : priceAmount4.hashCode())) * 31;
        List<AdditionalInfo> list = this.additionalInfo;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PriceInfo(originalAmount=" + this.originalAmount + ", accessoryCharges=" + this.accessoryCharges + ", discountAmount=" + this.discountAmount + ", actualAmount=" + this.actualAmount + ", additionalInfo=" + this.additionalInfo + VersionRange.RIGHT_OPEN;
    }

    public PriceInfo(PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, PriceAmount priceAmount4, List<AdditionalInfo> list) {
        this.originalAmount = priceAmount;
        this.accessoryCharges = priceAmount2;
        this.discountAmount = priceAmount3;
        this.actualAmount = priceAmount4;
        this.additionalInfo = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PriceInfo(com.didi.global.fintech.cashier.model.net.response.PriceAmount r5, com.didi.global.fintech.cashier.model.net.response.PriceAmount r6, com.didi.global.fintech.cashier.model.net.response.PriceAmount r7, com.didi.global.fintech.cashier.model.net.response.PriceAmount r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.PriceInfo.<init>(com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PriceAmount getOriginalAmount() {
        return this.originalAmount;
    }

    public final void setOriginalAmount(PriceAmount priceAmount) {
        this.originalAmount = priceAmount;
    }

    public final PriceAmount getAccessoryCharges() {
        return this.accessoryCharges;
    }

    public final void setAccessoryCharges(PriceAmount priceAmount) {
        this.accessoryCharges = priceAmount;
    }

    public final PriceAmount getDiscountAmount() {
        return this.discountAmount;
    }

    public final void setDiscountAmount(PriceAmount priceAmount) {
        this.discountAmount = priceAmount;
    }

    public final PriceAmount getActualAmount() {
        return this.actualAmount;
    }

    public final void setActualAmount(PriceAmount priceAmount) {
        this.actualAmount = priceAmount;
    }

    public final List<AdditionalInfo> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final void setAdditionalInfo(List<AdditionalInfo> list) {
        this.additionalInfo = list;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0019B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo;", "Ljava/io/Serializable;", "message", "", "helpInfo", "Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;", "(Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;)V", "getHelpInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;", "setHelpInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "HelpInfo", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PayInfoResponse.kt */
    public static final class AdditionalInfo implements Serializable {
        @SerializedName("help_info")
        private HelpInfo helpInfo;
        @SerializedName("message")
        private String message;

        public AdditionalInfo() {
            this((String) null, (HelpInfo) null, 3, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ AdditionalInfo copy$default(AdditionalInfo additionalInfo, String str, HelpInfo helpInfo2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = additionalInfo.message;
            }
            if ((i & 2) != 0) {
                helpInfo2 = additionalInfo.helpInfo;
            }
            return additionalInfo.copy(str, helpInfo2);
        }

        public final String component1() {
            return this.message;
        }

        public final HelpInfo component2() {
            return this.helpInfo;
        }

        public final AdditionalInfo copy(String str, HelpInfo helpInfo2) {
            return new AdditionalInfo(str, helpInfo2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdditionalInfo)) {
                return false;
            }
            AdditionalInfo additionalInfo = (AdditionalInfo) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) additionalInfo.message) && Intrinsics.areEqual((Object) this.helpInfo, (Object) additionalInfo.helpInfo);
        }

        public int hashCode() {
            String str = this.message;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            HelpInfo helpInfo2 = this.helpInfo;
            if (helpInfo2 != null) {
                i = helpInfo2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "AdditionalInfo(message=" + this.message + ", helpInfo=" + this.helpInfo + VersionRange.RIGHT_OPEN;
        }

        public AdditionalInfo(String str, HelpInfo helpInfo2) {
            this.message = str;
            this.helpInfo = helpInfo2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AdditionalInfo(String str, HelpInfo helpInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : helpInfo2);
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        public final HelpInfo getHelpInfo() {
            return this.helpInfo;
        }

        public final void setHelpInfo(HelpInfo helpInfo2) {
            this.helpInfo = helpInfo2;
        }

        @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;", "", "type", "", "title", "", "message", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/didi/global/fintech/cashier/model/net/response/PriceInfo$AdditionalInfo$HelpInfo;", "equals", "", "other", "hashCode", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: PayInfoResponse.kt */
        public static final class HelpInfo {
            @SerializedName("message")
            private String message;
            @SerializedName("title")
            private String title;
            @SerializedName("type")
            private Integer type;

            public HelpInfo() {
                this((Integer) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ HelpInfo copy$default(HelpInfo helpInfo, Integer num, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = helpInfo.type;
                }
                if ((i & 2) != 0) {
                    str = helpInfo.title;
                }
                if ((i & 4) != 0) {
                    str2 = helpInfo.message;
                }
                return helpInfo.copy(num, str, str2);
            }

            public final Integer component1() {
                return this.type;
            }

            public final String component2() {
                return this.title;
            }

            public final String component3() {
                return this.message;
            }

            public final HelpInfo copy(Integer num, String str, String str2) {
                return new HelpInfo(num, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof HelpInfo)) {
                    return false;
                }
                HelpInfo helpInfo = (HelpInfo) obj;
                return Intrinsics.areEqual((Object) this.type, (Object) helpInfo.type) && Intrinsics.areEqual((Object) this.title, (Object) helpInfo.title) && Intrinsics.areEqual((Object) this.message, (Object) helpInfo.message);
            }

            public int hashCode() {
                Integer num = this.type;
                int i = 0;
                int hashCode = (num == null ? 0 : num.hashCode()) * 31;
                String str = this.title;
                int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.message;
                if (str2 != null) {
                    i = str2.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "HelpInfo(type=" + this.type + ", title=" + this.title + ", message=" + this.message + VersionRange.RIGHT_OPEN;
            }

            public HelpInfo(Integer num, String str, String str2) {
                this.type = num;
                this.title = str;
                this.message = str2;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ HelpInfo(Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
            }

            public final Integer getType() {
                return this.type;
            }

            public final void setType(Integer num) {
                this.type = num;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setTitle(String str) {
                this.title = str;
            }

            public final String getMessage() {
                return this.message;
            }

            public final void setMessage(String str) {
                this.message = str;
            }
        }
    }
}
