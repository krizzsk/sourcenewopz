package com.didi.global.fintech.cashier.model.net.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/request/PaymentThreeDSDetailsRequest;", "Lcom/didi/global/fintech/cashier/model/net/request/CashierRequestCommonParams;", "reference", "", "channel_id", "", "vendor", "shopper", "auth_details", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuth_details", "()Ljava/lang/String;", "setAuth_details", "(Ljava/lang/String;)V", "getChannel_id", "()I", "setChannel_id", "(I)V", "getReference", "setReference", "getShopper", "setShopper", "getVendor", "setVendor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PaymentThreeDSDetailsRequest.kt */
public final class PaymentThreeDSDetailsRequest extends CashierRequestCommonParams {
    private String auth_details;
    private int channel_id;
    private String reference;
    private String shopper;
    private String vendor;

    public PaymentThreeDSDetailsRequest() {
        this((String) null, 0, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PaymentThreeDSDetailsRequest copy$default(PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest, String str, int i, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = paymentThreeDSDetailsRequest.reference;
        }
        if ((i2 & 2) != 0) {
            i = paymentThreeDSDetailsRequest.channel_id;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = paymentThreeDSDetailsRequest.vendor;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = paymentThreeDSDetailsRequest.shopper;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = paymentThreeDSDetailsRequest.auth_details;
        }
        return paymentThreeDSDetailsRequest.copy(str, i3, str5, str6, str4);
    }

    public final String component1() {
        return this.reference;
    }

    public final int component2() {
        return this.channel_id;
    }

    public final String component3() {
        return this.vendor;
    }

    public final String component4() {
        return this.shopper;
    }

    public final String component5() {
        return this.auth_details;
    }

    public final PaymentThreeDSDetailsRequest copy(String str, int i, String str2, String str3, String str4) {
        return new PaymentThreeDSDetailsRequest(str, i, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentThreeDSDetailsRequest)) {
            return false;
        }
        PaymentThreeDSDetailsRequest paymentThreeDSDetailsRequest = (PaymentThreeDSDetailsRequest) obj;
        return Intrinsics.areEqual((Object) this.reference, (Object) paymentThreeDSDetailsRequest.reference) && this.channel_id == paymentThreeDSDetailsRequest.channel_id && Intrinsics.areEqual((Object) this.vendor, (Object) paymentThreeDSDetailsRequest.vendor) && Intrinsics.areEqual((Object) this.shopper, (Object) paymentThreeDSDetailsRequest.shopper) && Intrinsics.areEqual((Object) this.auth_details, (Object) paymentThreeDSDetailsRequest.auth_details);
    }

    public int hashCode() {
        String str = this.reference;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.channel_id) * 31;
        String str2 = this.vendor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.shopper;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.auth_details;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "PaymentThreeDSDetailsRequest(reference=" + this.reference + ", channel_id=" + this.channel_id + ", vendor=" + this.vendor + ", shopper=" + this.shopper + ", auth_details=" + this.auth_details + VersionRange.RIGHT_OPEN;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentThreeDSDetailsRequest(java.lang.String r5, int r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
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
            if (r5 == 0) goto L_0x000f
            r6 = 0
            r1 = 0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r7
        L_0x0017:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r8
        L_0x001e:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0024
            r10 = r0
            goto L_0x0025
        L_0x0024:
            r10 = r9
        L_0x0025:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.request.PaymentThreeDSDetailsRequest.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getReference() {
        return this.reference;
    }

    public final void setReference(String str) {
        this.reference = str;
    }

    public final int getChannel_id() {
        return this.channel_id;
    }

    public final void setChannel_id(int i) {
        this.channel_id = i;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final void setVendor(String str) {
        this.vendor = str;
    }

    public final String getShopper() {
        return this.shopper;
    }

    public final void setShopper(String str) {
        this.shopper = str;
    }

    public final String getAuth_details() {
        return this.auth_details;
    }

    public final void setAuth_details(String str) {
        this.auth_details = str;
    }

    public PaymentThreeDSDetailsRequest(String str, int i, String str2, String str3, String str4) {
        this.reference = str;
        this.channel_id = i;
        this.vendor = str2;
        this.shopper = str3;
        this.auth_details = str4;
    }
}
