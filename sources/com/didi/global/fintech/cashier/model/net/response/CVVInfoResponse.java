package com.didi.global.fintech.cashier.model.net.response;

import com.didi.global.fintech.cashier.model.net.request.CVVCardInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003J]\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u00063"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/model/net/response/CVVInfoResponse;", "Ljava/io/Serializable;", "title", "", "subTitle", "brandName", "brandLogo", "cardInfo", "Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "encryptInfo", "Lcom/didi/global/fintech/cashier/model/net/response/EncryptInfo;", "drawerData", "Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;Lcom/didi/global/fintech/cashier/model/net/response/EncryptInfo;Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;)V", "getBrandLogo", "()Ljava/lang/String;", "setBrandLogo", "(Ljava/lang/String;)V", "getBrandName", "setBrandName", "getCardInfo", "()Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;", "setCardInfo", "(Lcom/didi/global/fintech/cashier/model/net/request/CVVCardInfo;)V", "getDrawerData", "()Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;", "setDrawerData", "(Lcom/didi/global/fintech/cashier/model/net/response/CVVDrawerData;)V", "getEncryptInfo", "()Lcom/didi/global/fintech/cashier/model/net/response/EncryptInfo;", "setEncryptInfo", "(Lcom/didi/global/fintech/cashier/model/net/response/EncryptInfo;)V", "getSubTitle", "setSubTitle", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "cashier_model_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CVVInfoResponse.kt */
public final class CVVInfoResponse implements Serializable {
    @SerializedName("brand_logo")
    private String brandLogo;
    @SerializedName("brand_name")
    private String brandName;
    @SerializedName("card_info")
    private CVVCardInfo cardInfo;
    @SerializedName("help_info")
    private CVVDrawerData drawerData;
    @SerializedName("encrypt_info")
    private EncryptInfo encryptInfo;
    @SerializedName("sub_title")
    private String subTitle;
    @SerializedName("title")
    private String title;

    public CVVInfoResponse() {
        this((String) null, (String) null, (String) null, (String) null, (CVVCardInfo) null, (EncryptInfo) null, (CVVDrawerData) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CVVInfoResponse copy$default(CVVInfoResponse cVVInfoResponse, String str, String str2, String str3, String str4, CVVCardInfo cVVCardInfo, EncryptInfo encryptInfo2, CVVDrawerData cVVDrawerData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = cVVInfoResponse.title;
        }
        if ((i & 2) != 0) {
            str2 = cVVInfoResponse.subTitle;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = cVVInfoResponse.brandName;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = cVVInfoResponse.brandLogo;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            cVVCardInfo = cVVInfoResponse.cardInfo;
        }
        CVVCardInfo cVVCardInfo2 = cVVCardInfo;
        if ((i & 32) != 0) {
            encryptInfo2 = cVVInfoResponse.encryptInfo;
        }
        EncryptInfo encryptInfo3 = encryptInfo2;
        if ((i & 64) != 0) {
            cVVDrawerData = cVVInfoResponse.drawerData;
        }
        return cVVInfoResponse.copy(str, str5, str6, str7, cVVCardInfo2, encryptInfo3, cVVDrawerData);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final String component3() {
        return this.brandName;
    }

    public final String component4() {
        return this.brandLogo;
    }

    public final CVVCardInfo component5() {
        return this.cardInfo;
    }

    public final EncryptInfo component6() {
        return this.encryptInfo;
    }

    public final CVVDrawerData component7() {
        return this.drawerData;
    }

    public final CVVInfoResponse copy(String str, String str2, String str3, String str4, CVVCardInfo cVVCardInfo, EncryptInfo encryptInfo2, CVVDrawerData cVVDrawerData) {
        return new CVVInfoResponse(str, str2, str3, str4, cVVCardInfo, encryptInfo2, cVVDrawerData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CVVInfoResponse)) {
            return false;
        }
        CVVInfoResponse cVVInfoResponse = (CVVInfoResponse) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) cVVInfoResponse.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) cVVInfoResponse.subTitle) && Intrinsics.areEqual((Object) this.brandName, (Object) cVVInfoResponse.brandName) && Intrinsics.areEqual((Object) this.brandLogo, (Object) cVVInfoResponse.brandLogo) && Intrinsics.areEqual((Object) this.cardInfo, (Object) cVVInfoResponse.cardInfo) && Intrinsics.areEqual((Object) this.encryptInfo, (Object) cVVInfoResponse.encryptInfo) && Intrinsics.areEqual((Object) this.drawerData, (Object) cVVInfoResponse.drawerData);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.brandName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.brandLogo;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        CVVCardInfo cVVCardInfo = this.cardInfo;
        int hashCode5 = (hashCode4 + (cVVCardInfo == null ? 0 : cVVCardInfo.hashCode())) * 31;
        EncryptInfo encryptInfo2 = this.encryptInfo;
        int hashCode6 = (hashCode5 + (encryptInfo2 == null ? 0 : encryptInfo2.hashCode())) * 31;
        CVVDrawerData cVVDrawerData = this.drawerData;
        if (cVVDrawerData != null) {
            i = cVVDrawerData.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "CVVInfoResponse(title=" + this.title + ", subTitle=" + this.subTitle + ", brandName=" + this.brandName + ", brandLogo=" + this.brandLogo + ", cardInfo=" + this.cardInfo + ", encryptInfo=" + this.encryptInfo + ", drawerData=" + this.drawerData + VersionRange.RIGHT_OPEN;
    }

    public CVVInfoResponse(String str, String str2, String str3, String str4, CVVCardInfo cVVCardInfo, EncryptInfo encryptInfo2, CVVDrawerData cVVDrawerData) {
        this.title = str;
        this.subTitle = str2;
        this.brandName = str3;
        this.brandLogo = str4;
        this.cardInfo = cVVCardInfo;
        this.encryptInfo = encryptInfo2;
        this.drawerData = cVVDrawerData;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CVVInfoResponse(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, com.didi.global.fintech.cashier.model.net.request.CVVCardInfo r11, com.didi.global.fintech.cashier.model.net.response.EncryptInfo r12, com.didi.global.fintech.cashier.model.net.response.CVVDrawerData r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.model.net.response.CVVInfoResponse.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.didi.global.fintech.cashier.model.net.request.CVVCardInfo, com.didi.global.fintech.cashier.model.net.response.EncryptInfo, com.didi.global.fintech.cashier.model.net.response.CVVDrawerData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final String getBrandName() {
        return this.brandName;
    }

    public final void setBrandName(String str) {
        this.brandName = str;
    }

    public final String getBrandLogo() {
        return this.brandLogo;
    }

    public final void setBrandLogo(String str) {
        this.brandLogo = str;
    }

    public final CVVCardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final void setCardInfo(CVVCardInfo cVVCardInfo) {
        this.cardInfo = cVVCardInfo;
    }

    public final EncryptInfo getEncryptInfo() {
        return this.encryptInfo;
    }

    public final void setEncryptInfo(EncryptInfo encryptInfo2) {
        this.encryptInfo = encryptInfo2;
    }

    public final CVVDrawerData getDrawerData() {
        return this.drawerData;
    }

    public final void setDrawerData(CVVDrawerData cVVDrawerData) {
        this.drawerData = cVVDrawerData;
    }
}
