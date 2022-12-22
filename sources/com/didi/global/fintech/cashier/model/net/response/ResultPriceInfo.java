package com.didi.global.fintech.cashier.model.net.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001(BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JK\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u001aHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR&\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006)"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo;", "Ljava/io/Serializable;", "originalAmount", "Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "accessoryCharges", "discountAmount", "actualAmount", "additionalInfo", "", "Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo$ResultAdditionalInfo;", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;Ljava/util/List;)V", "getAccessoryCharges", "()Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;", "setAccessoryCharges", "(Lcom/didi/global/fintech/cashier/model/net/response/PriceAmount;)V", "getActualAmount", "setActualAmount", "getAdditionalInfo", "()Ljava/util/List;", "setAdditionalInfo", "(Ljava/util/List;)V", "getDiscountAmount", "setDiscountAmount", "getOriginalAmount", "setOriginalAmount", "additionalMessages", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ResultAdditionalInfo", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuccessInfoResponse.kt */
public final class ResultPriceInfo implements Serializable {
    @SerializedName("accessory_charges")
    private PriceAmount accessoryCharges;
    @SerializedName("actual_amount")
    private PriceAmount actualAmount;
    @SerializedName("additional_info")
    private List<ResultAdditionalInfo> additionalInfo;
    @SerializedName("discount_amount")
    private PriceAmount discountAmount;
    @SerializedName("original_amount")
    private PriceAmount originalAmount;

    public ResultPriceInfo() {
        this((PriceAmount) null, (PriceAmount) null, (PriceAmount) null, (PriceAmount) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ResultPriceInfo copy$default(ResultPriceInfo resultPriceInfo, PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, PriceAmount priceAmount4, List<ResultAdditionalInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            priceAmount = resultPriceInfo.originalAmount;
        }
        if ((i & 2) != 0) {
            priceAmount2 = resultPriceInfo.accessoryCharges;
        }
        PriceAmount priceAmount5 = priceAmount2;
        if ((i & 4) != 0) {
            priceAmount3 = resultPriceInfo.discountAmount;
        }
        PriceAmount priceAmount6 = priceAmount3;
        if ((i & 8) != 0) {
            priceAmount4 = resultPriceInfo.actualAmount;
        }
        PriceAmount priceAmount7 = priceAmount4;
        if ((i & 16) != 0) {
            list = resultPriceInfo.additionalInfo;
        }
        return resultPriceInfo.copy(priceAmount, priceAmount5, priceAmount6, priceAmount7, list);
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

    public final List<ResultAdditionalInfo> component5() {
        return this.additionalInfo;
    }

    public final ResultPriceInfo copy(PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, PriceAmount priceAmount4, List<ResultAdditionalInfo> list) {
        return new ResultPriceInfo(priceAmount, priceAmount2, priceAmount3, priceAmount4, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResultPriceInfo)) {
            return false;
        }
        ResultPriceInfo resultPriceInfo = (ResultPriceInfo) obj;
        return Intrinsics.areEqual((Object) this.originalAmount, (Object) resultPriceInfo.originalAmount) && Intrinsics.areEqual((Object) this.accessoryCharges, (Object) resultPriceInfo.accessoryCharges) && Intrinsics.areEqual((Object) this.discountAmount, (Object) resultPriceInfo.discountAmount) && Intrinsics.areEqual((Object) this.actualAmount, (Object) resultPriceInfo.actualAmount) && Intrinsics.areEqual((Object) this.additionalInfo, (Object) resultPriceInfo.additionalInfo);
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
        List<ResultAdditionalInfo> list = this.additionalInfo;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ResultPriceInfo(originalAmount=" + this.originalAmount + ", accessoryCharges=" + this.accessoryCharges + ", discountAmount=" + this.discountAmount + ", actualAmount=" + this.actualAmount + ", additionalInfo=" + this.additionalInfo + VersionRange.RIGHT_OPEN;
    }

    public ResultPriceInfo(PriceAmount priceAmount, PriceAmount priceAmount2, PriceAmount priceAmount3, PriceAmount priceAmount4, List<ResultAdditionalInfo> list) {
        this.originalAmount = priceAmount;
        this.accessoryCharges = priceAmount2;
        this.discountAmount = priceAmount3;
        this.actualAmount = priceAmount4;
        this.additionalInfo = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ResultPriceInfo(com.didi.global.fintech.cashier.model.net.response.PriceAmount r5, com.didi.global.fintech.cashier.model.net.response.PriceAmount r6, com.didi.global.fintech.cashier.model.net.response.PriceAmount r7, com.didi.global.fintech.cashier.model.net.response.PriceAmount r8, java.util.List r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.ResultPriceInfo.<init>(com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, com.didi.global.fintech.cashier.model.net.response.PriceAmount, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final List<ResultAdditionalInfo> getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final void setAdditionalInfo(List<ResultAdditionalInfo> list) {
        this.additionalInfo = list;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/ResultPriceInfo$ResultAdditionalInfo;", "Ljava/io/Serializable;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SuccessInfoResponse.kt */
    public static final class ResultAdditionalInfo implements Serializable {
        @SerializedName("message")
        private String message;

        public ResultAdditionalInfo() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ResultAdditionalInfo copy$default(ResultAdditionalInfo resultAdditionalInfo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resultAdditionalInfo.message;
            }
            return resultAdditionalInfo.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final ResultAdditionalInfo copy(String str) {
            return new ResultAdditionalInfo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ResultAdditionalInfo) && Intrinsics.areEqual((Object) this.message, (Object) ((ResultAdditionalInfo) obj).message);
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ResultAdditionalInfo(message=" + this.message + VersionRange.RIGHT_OPEN;
        }

        public ResultAdditionalInfo(String str) {
            this.message = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ResultAdditionalInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }
    }

    public final String additionalMessages() {
        StringBuilder sb = new StringBuilder();
        List<ResultAdditionalInfo> list = this.additionalInfo;
        if (list != null) {
            int i = 0;
            for (Object next : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                sb.append(((ResultAdditionalInfo) next).getMessage());
                List<ResultAdditionalInfo> additionalInfo2 = getAdditionalInfo();
                boolean z = true;
                if (additionalInfo2 == null || i != additionalInfo2.size() - 1) {
                    z = false;
                }
                if (!z) {
                    sb.append("\n");
                }
                i = i2;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
