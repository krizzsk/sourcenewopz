package com.didi.soda.customer.biz.popdialog.natived.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.CouponEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bD\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002BÏ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u000e\b\u0002\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0019J\u000b\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010G\u001a\u00020\fHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010S\u001a\u00020\fHÆ\u0003J\u000f\u0010T\u001a\b\u0018\u00010\u000eR\u00020\u000fHÆ\u0003JÓ\u0001\u0010U\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010YHÖ\u0003J\t\u0010Z\u001a\u00020\fHÖ\u0001J\t\u0010[\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR \u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001a\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001dR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001dR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001b\"\u0004\b=\u0010\u001dR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001b\"\u0004\b?\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001d¨\u0006\\"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/model/NAPopCouponRvModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "couponAmount", "", "couponId", "activityName", "rlCustomLogo", "currencyMark", "batchId", "discountDesc", "newUser", "", "btn", "Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ButtonInfo;", "Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity;", "businessCouponType", "expireInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ExpireInfo;", "couponTypeInt", "expireStr", "extStr", "discountStr", "limitStr", "couponAmountSplitDisplay", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ButtonInfo;ILcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ExpireInfo;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityName", "()Ljava/lang/String;", "setActivityName", "(Ljava/lang/String;)V", "getBatchId", "setBatchId", "getBtn", "()Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ButtonInfo;", "setBtn", "(Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ButtonInfo;)V", "getBusinessCouponType", "()I", "setBusinessCouponType", "(I)V", "getCouponAmount", "setCouponAmount", "getCouponAmountSplitDisplay", "setCouponAmountSplitDisplay", "getCouponId", "setCouponId", "getCouponTypeInt", "setCouponTypeInt", "getCurrencyMark", "setCurrencyMark", "getDiscountDesc", "setDiscountDesc", "getDiscountStr", "setDiscountStr", "getExpireInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ExpireInfo;", "setExpireInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity$ExpireInfo;)V", "getExpireStr", "setExpireStr", "getExtStr", "setExtStr", "getLimitStr", "setLimitStr", "getNewUser", "setNewUser", "getRlCustomLogo", "setRlCustomLogo", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NAPopCouponRvModel.kt */
public final class NAPopCouponRvModel implements RecyclerModel, IEntity {
    private String activityName;
    private String batchId;
    private CouponEntity.ButtonInfo btn;
    private int businessCouponType;
    private String couponAmount;
    private String couponAmountSplitDisplay;
    private String couponId;
    private int couponTypeInt;
    private String currencyMark;
    private String discountDesc;
    private String discountStr;
    private CouponEntity.ExpireInfo expireInfo;
    private String expireStr;
    private String extStr;
    private String limitStr;
    private int newUser;
    private String rlCustomLogo;

    public NAPopCouponRvModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (CouponEntity.ButtonInfo) null, 0, (CouponEntity.ExpireInfo) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 131071, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NAPopCouponRvModel copy$default(NAPopCouponRvModel nAPopCouponRvModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, CouponEntity.ButtonInfo buttonInfo, int i2, CouponEntity.ExpireInfo expireInfo2, int i3, String str8, String str9, String str10, String str11, String str12, int i4, Object obj) {
        NAPopCouponRvModel nAPopCouponRvModel2 = nAPopCouponRvModel;
        int i5 = i4;
        return nAPopCouponRvModel.copy((i5 & 1) != 0 ? nAPopCouponRvModel2.couponAmount : str, (i5 & 2) != 0 ? nAPopCouponRvModel2.couponId : str2, (i5 & 4) != 0 ? nAPopCouponRvModel2.activityName : str3, (i5 & 8) != 0 ? nAPopCouponRvModel2.rlCustomLogo : str4, (i5 & 16) != 0 ? nAPopCouponRvModel2.currencyMark : str5, (i5 & 32) != 0 ? nAPopCouponRvModel2.batchId : str6, (i5 & 64) != 0 ? nAPopCouponRvModel2.discountDesc : str7, (i5 & 128) != 0 ? nAPopCouponRvModel2.newUser : i, (i5 & 256) != 0 ? nAPopCouponRvModel2.btn : buttonInfo, (i5 & 512) != 0 ? nAPopCouponRvModel2.businessCouponType : i2, (i5 & 1024) != 0 ? nAPopCouponRvModel2.expireInfo : expireInfo2, (i5 & 2048) != 0 ? nAPopCouponRvModel2.couponTypeInt : i3, (i5 & 4096) != 0 ? nAPopCouponRvModel2.expireStr : str8, (i5 & 8192) != 0 ? nAPopCouponRvModel2.extStr : str9, (i5 & 16384) != 0 ? nAPopCouponRvModel2.discountStr : str10, (i5 & 32768) != 0 ? nAPopCouponRvModel2.limitStr : str11, (i5 & 65536) != 0 ? nAPopCouponRvModel2.couponAmountSplitDisplay : str12);
    }

    public final String component1() {
        return this.couponAmount;
    }

    public final int component10() {
        return this.businessCouponType;
    }

    public final CouponEntity.ExpireInfo component11() {
        return this.expireInfo;
    }

    public final int component12() {
        return this.couponTypeInt;
    }

    public final String component13() {
        return this.expireStr;
    }

    public final String component14() {
        return this.extStr;
    }

    public final String component15() {
        return this.discountStr;
    }

    public final String component16() {
        return this.limitStr;
    }

    public final String component17() {
        return this.couponAmountSplitDisplay;
    }

    public final String component2() {
        return this.couponId;
    }

    public final String component3() {
        return this.activityName;
    }

    public final String component4() {
        return this.rlCustomLogo;
    }

    public final String component5() {
        return this.currencyMark;
    }

    public final String component6() {
        return this.batchId;
    }

    public final String component7() {
        return this.discountDesc;
    }

    public final int component8() {
        return this.newUser;
    }

    public final CouponEntity.ButtonInfo component9() {
        return this.btn;
    }

    public final NAPopCouponRvModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, CouponEntity.ButtonInfo buttonInfo, int i2, CouponEntity.ExpireInfo expireInfo2, int i3, String str8, String str9, String str10, String str11, String str12) {
        return new NAPopCouponRvModel(str, str2, str3, str4, str5, str6, str7, i, buttonInfo, i2, expireInfo2, i3, str8, str9, str10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NAPopCouponRvModel)) {
            return false;
        }
        NAPopCouponRvModel nAPopCouponRvModel = (NAPopCouponRvModel) obj;
        return Intrinsics.areEqual((Object) this.couponAmount, (Object) nAPopCouponRvModel.couponAmount) && Intrinsics.areEqual((Object) this.couponId, (Object) nAPopCouponRvModel.couponId) && Intrinsics.areEqual((Object) this.activityName, (Object) nAPopCouponRvModel.activityName) && Intrinsics.areEqual((Object) this.rlCustomLogo, (Object) nAPopCouponRvModel.rlCustomLogo) && Intrinsics.areEqual((Object) this.currencyMark, (Object) nAPopCouponRvModel.currencyMark) && Intrinsics.areEqual((Object) this.batchId, (Object) nAPopCouponRvModel.batchId) && Intrinsics.areEqual((Object) this.discountDesc, (Object) nAPopCouponRvModel.discountDesc) && this.newUser == nAPopCouponRvModel.newUser && Intrinsics.areEqual((Object) this.btn, (Object) nAPopCouponRvModel.btn) && this.businessCouponType == nAPopCouponRvModel.businessCouponType && Intrinsics.areEqual((Object) this.expireInfo, (Object) nAPopCouponRvModel.expireInfo) && this.couponTypeInt == nAPopCouponRvModel.couponTypeInt && Intrinsics.areEqual((Object) this.expireStr, (Object) nAPopCouponRvModel.expireStr) && Intrinsics.areEqual((Object) this.extStr, (Object) nAPopCouponRvModel.extStr) && Intrinsics.areEqual((Object) this.discountStr, (Object) nAPopCouponRvModel.discountStr) && Intrinsics.areEqual((Object) this.limitStr, (Object) nAPopCouponRvModel.limitStr) && Intrinsics.areEqual((Object) this.couponAmountSplitDisplay, (Object) nAPopCouponRvModel.couponAmountSplitDisplay);
    }

    public int hashCode() {
        String str = this.couponAmount;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.couponId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.activityName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.rlCustomLogo;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.currencyMark;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.batchId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.discountDesc;
        int hashCode7 = (((hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.newUser) * 31;
        CouponEntity.ButtonInfo buttonInfo = this.btn;
        int hashCode8 = (((hashCode7 + (buttonInfo == null ? 0 : buttonInfo.hashCode())) * 31) + this.businessCouponType) * 31;
        CouponEntity.ExpireInfo expireInfo2 = this.expireInfo;
        int hashCode9 = (((hashCode8 + (expireInfo2 == null ? 0 : expireInfo2.hashCode())) * 31) + this.couponTypeInt) * 31;
        String str8 = this.expireStr;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.extStr;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.discountStr;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.limitStr;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.couponAmountSplitDisplay;
        if (str12 != null) {
            i = str12.hashCode();
        }
        return hashCode13 + i;
    }

    public String toString() {
        return "NAPopCouponRvModel(couponAmount=" + this.couponAmount + ", couponId=" + this.couponId + ", activityName=" + this.activityName + ", rlCustomLogo=" + this.rlCustomLogo + ", currencyMark=" + this.currencyMark + ", batchId=" + this.batchId + ", discountDesc=" + this.discountDesc + ", newUser=" + this.newUser + ", btn=" + this.btn + ", businessCouponType=" + this.businessCouponType + ", expireInfo=" + this.expireInfo + ", couponTypeInt=" + this.couponTypeInt + ", expireStr=" + this.expireStr + ", extStr=" + this.extStr + ", discountStr=" + this.discountStr + ", limitStr=" + this.limitStr + ", couponAmountSplitDisplay=" + this.couponAmountSplitDisplay + VersionRange.RIGHT_OPEN;
    }

    public NAPopCouponRvModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, CouponEntity.ButtonInfo buttonInfo, int i2, CouponEntity.ExpireInfo expireInfo2, int i3, String str8, String str9, String str10, String str11, String str12) {
        this.couponAmount = str;
        this.couponId = str2;
        this.activityName = str3;
        this.rlCustomLogo = str4;
        this.currencyMark = str5;
        this.batchId = str6;
        this.discountDesc = str7;
        this.newUser = i;
        this.btn = buttonInfo;
        this.businessCouponType = i2;
        this.expireInfo = expireInfo2;
        this.couponTypeInt = i3;
        this.expireStr = str8;
        this.extStr = str9;
        this.discountStr = str10;
        this.limitStr = str11;
        this.couponAmountSplitDisplay = str12;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NAPopCouponRvModel(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, com.didi.soda.customer.foundation.rpc.entity.CouponEntity.ButtonInfo r27, int r28, com.didi.soda.customer.foundation.rpc.entity.CouponEntity.ExpireInfo r29, int r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r19
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r20
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r21
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r22
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r23
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r24
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r2
            goto L_0x003c
        L_0x003a:
            r8 = r25
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            r10 = 0
            if (r9 == 0) goto L_0x0043
            r9 = 0
            goto L_0x0045
        L_0x0043:
            r9 = r26
        L_0x0045:
            r11 = r0 & 256(0x100, float:3.59E-43)
            r12 = 0
            if (r11 == 0) goto L_0x004c
            r11 = r12
            goto L_0x004e
        L_0x004c:
            r11 = r27
        L_0x004e:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0054
            r13 = 0
            goto L_0x0056
        L_0x0054:
            r13 = r28
        L_0x0056:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r12 = r29
        L_0x005d:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r10 = r30
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = r2
            goto L_0x006c
        L_0x006a:
            r14 = r31
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0072
            r15 = r2
            goto L_0x0074
        L_0x0072:
            r15 = r32
        L_0x0074:
            r37 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007d
            r2 = r37
            goto L_0x007f
        L_0x007d:
            r2 = r33
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0089
            r16 = r37
            goto L_0x008b
        L_0x0089:
            r16 = r34
        L_0x008b:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x0094
            r0 = r37
            goto L_0x0096
        L_0x0094:
            r0 = r35
        L_0x0096:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r11
            r29 = r13
            r30 = r12
            r31 = r10
            r32 = r14
            r33 = r15
            r34 = r2
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.biz.popdialog.natived.model.NAPopCouponRvModel.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.didi.soda.customer.foundation.rpc.entity.CouponEntity$ButtonInfo, int, com.didi.soda.customer.foundation.rpc.entity.CouponEntity$ExpireInfo, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCouponAmount() {
        return this.couponAmount;
    }

    public final void setCouponAmount(String str) {
        this.couponAmount = str;
    }

    public final String getCouponId() {
        return this.couponId;
    }

    public final void setCouponId(String str) {
        this.couponId = str;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final void setActivityName(String str) {
        this.activityName = str;
    }

    public final String getRlCustomLogo() {
        return this.rlCustomLogo;
    }

    public final void setRlCustomLogo(String str) {
        this.rlCustomLogo = str;
    }

    public final String getCurrencyMark() {
        return this.currencyMark;
    }

    public final void setCurrencyMark(String str) {
        this.currencyMark = str;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final void setBatchId(String str) {
        this.batchId = str;
    }

    public final String getDiscountDesc() {
        return this.discountDesc;
    }

    public final void setDiscountDesc(String str) {
        this.discountDesc = str;
    }

    public final int getNewUser() {
        return this.newUser;
    }

    public final void setNewUser(int i) {
        this.newUser = i;
    }

    public final CouponEntity.ButtonInfo getBtn() {
        return this.btn;
    }

    public final void setBtn(CouponEntity.ButtonInfo buttonInfo) {
        this.btn = buttonInfo;
    }

    public final int getBusinessCouponType() {
        return this.businessCouponType;
    }

    public final void setBusinessCouponType(int i) {
        this.businessCouponType = i;
    }

    public final CouponEntity.ExpireInfo getExpireInfo() {
        return this.expireInfo;
    }

    public final void setExpireInfo(CouponEntity.ExpireInfo expireInfo2) {
        this.expireInfo = expireInfo2;
    }

    public final int getCouponTypeInt() {
        return this.couponTypeInt;
    }

    public final void setCouponTypeInt(int i) {
        this.couponTypeInt = i;
    }

    public final String getExpireStr() {
        return this.expireStr;
    }

    public final void setExpireStr(String str) {
        this.expireStr = str;
    }

    public final String getExtStr() {
        return this.extStr;
    }

    public final void setExtStr(String str) {
        this.extStr = str;
    }

    public final String getDiscountStr() {
        return this.discountStr;
    }

    public final void setDiscountStr(String str) {
        this.discountStr = str;
    }

    public final String getLimitStr() {
        return this.limitStr;
    }

    public final void setLimitStr(String str) {
        this.limitStr = str;
    }

    public final String getCouponAmountSplitDisplay() {
        return this.couponAmountSplitDisplay;
    }

    public final void setCouponAmountSplitDisplay(String str) {
        this.couponAmountSplitDisplay = str;
    }
}
