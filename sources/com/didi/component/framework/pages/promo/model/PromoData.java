package com.didi.component.framework.pages.promo.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00066"}, mo175978d2 = {"Lcom/didi/component/framework/pages/promo/model/PromoData;", "", "activityId", "", "businessLine", "couponInfoList", "", "Lcom/didi/component/framework/pages/promo/model/CouponInfo;", "promoType", "promotionCode", "resultLang", "shareBannerInfo", "Lcom/didi/component/framework/pages/promo/model/ShareBannerInfo;", "shareInfo", "Lcom/didi/component/framework/pages/promo/model/PromoShareInfo;", "shareUrl", "tuiCouponInfoList", "waiMaiVo", "Lcom/didi/component/framework/pages/promo/model/WaiMaiVo;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/didi/component/framework/pages/promo/model/ShareBannerInfo;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/didi/component/framework/pages/promo/model/WaiMaiVo;)V", "getActivityId", "()Ljava/lang/String;", "getBusinessLine", "()Ljava/lang/Object;", "getCouponInfoList", "()Ljava/util/List;", "getPromoType", "getPromotionCode", "getResultLang", "getShareBannerInfo", "()Lcom/didi/component/framework/pages/promo/model/ShareBannerInfo;", "getShareInfo", "getShareUrl", "getTuiCouponInfoList", "getWaiMaiVo", "()Lcom/didi/component/framework/pages/promo/model/WaiMaiVo;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PromoResponse.kt */
public final class PromoData {
    private final String activityId;
    private final Object businessLine;
    private final List<CouponInfo> couponInfoList;
    private final String promoType;
    private final String promotionCode;
    private final String resultLang;
    private final ShareBannerInfo shareBannerInfo;
    private final List<PromoShareInfo> shareInfo;
    private final String shareUrl;
    private final List<CouponInfo> tuiCouponInfoList;
    private final WaiMaiVo waiMaiVo;

    public static /* synthetic */ PromoData copy$default(PromoData promoData, String str, Object obj, List list, String str2, String str3, String str4, ShareBannerInfo shareBannerInfo2, List list2, String str5, List list3, WaiMaiVo waiMaiVo2, int i, Object obj2) {
        PromoData promoData2 = promoData;
        int i2 = i;
        return promoData.copy((i2 & 1) != 0 ? promoData2.activityId : str, (i2 & 2) != 0 ? promoData2.businessLine : obj, (i2 & 4) != 0 ? promoData2.couponInfoList : list, (i2 & 8) != 0 ? promoData2.promoType : str2, (i2 & 16) != 0 ? promoData2.promotionCode : str3, (i2 & 32) != 0 ? promoData2.resultLang : str4, (i2 & 64) != 0 ? promoData2.shareBannerInfo : shareBannerInfo2, (i2 & 128) != 0 ? promoData2.shareInfo : list2, (i2 & 256) != 0 ? promoData2.shareUrl : str5, (i2 & 512) != 0 ? promoData2.tuiCouponInfoList : list3, (i2 & 1024) != 0 ? promoData2.waiMaiVo : waiMaiVo2);
    }

    public final String component1() {
        return this.activityId;
    }

    public final List<CouponInfo> component10() {
        return this.tuiCouponInfoList;
    }

    public final WaiMaiVo component11() {
        return this.waiMaiVo;
    }

    public final Object component2() {
        return this.businessLine;
    }

    public final List<CouponInfo> component3() {
        return this.couponInfoList;
    }

    public final String component4() {
        return this.promoType;
    }

    public final String component5() {
        return this.promotionCode;
    }

    public final String component6() {
        return this.resultLang;
    }

    public final ShareBannerInfo component7() {
        return this.shareBannerInfo;
    }

    public final List<PromoShareInfo> component8() {
        return this.shareInfo;
    }

    public final String component9() {
        return this.shareUrl;
    }

    public final PromoData copy(String str, Object obj, List<CouponInfo> list, String str2, String str3, String str4, ShareBannerInfo shareBannerInfo2, List<PromoShareInfo> list2, String str5, List<CouponInfo> list3, WaiMaiVo waiMaiVo2) {
        return new PromoData(str, obj, list, str2, str3, str4, shareBannerInfo2, list2, str5, list3, waiMaiVo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromoData)) {
            return false;
        }
        PromoData promoData = (PromoData) obj;
        return Intrinsics.areEqual((Object) this.activityId, (Object) promoData.activityId) && Intrinsics.areEqual(this.businessLine, promoData.businessLine) && Intrinsics.areEqual((Object) this.couponInfoList, (Object) promoData.couponInfoList) && Intrinsics.areEqual((Object) this.promoType, (Object) promoData.promoType) && Intrinsics.areEqual((Object) this.promotionCode, (Object) promoData.promotionCode) && Intrinsics.areEqual((Object) this.resultLang, (Object) promoData.resultLang) && Intrinsics.areEqual((Object) this.shareBannerInfo, (Object) promoData.shareBannerInfo) && Intrinsics.areEqual((Object) this.shareInfo, (Object) promoData.shareInfo) && Intrinsics.areEqual((Object) this.shareUrl, (Object) promoData.shareUrl) && Intrinsics.areEqual((Object) this.tuiCouponInfoList, (Object) promoData.tuiCouponInfoList) && Intrinsics.areEqual((Object) this.waiMaiVo, (Object) promoData.waiMaiVo);
    }

    public int hashCode() {
        String str = this.activityId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.businessLine;
        int hashCode2 = (hashCode + (obj == null ? 0 : obj.hashCode())) * 31;
        List<CouponInfo> list = this.couponInfoList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.promoType;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.promotionCode;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.resultLang;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        ShareBannerInfo shareBannerInfo2 = this.shareBannerInfo;
        int hashCode7 = (hashCode6 + (shareBannerInfo2 == null ? 0 : shareBannerInfo2.hashCode())) * 31;
        List<PromoShareInfo> list2 = this.shareInfo;
        int hashCode8 = (hashCode7 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str5 = this.shareUrl;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<CouponInfo> list3 = this.tuiCouponInfoList;
        int hashCode10 = (hashCode9 + (list3 == null ? 0 : list3.hashCode())) * 31;
        WaiMaiVo waiMaiVo2 = this.waiMaiVo;
        if (waiMaiVo2 != null) {
            i = waiMaiVo2.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        return "PromoData(activityId=" + this.activityId + ", businessLine=" + this.businessLine + ", couponInfoList=" + this.couponInfoList + ", promoType=" + this.promoType + ", promotionCode=" + this.promotionCode + ", resultLang=" + this.resultLang + ", shareBannerInfo=" + this.shareBannerInfo + ", shareInfo=" + this.shareInfo + ", shareUrl=" + this.shareUrl + ", tuiCouponInfoList=" + this.tuiCouponInfoList + ", waiMaiVo=" + this.waiMaiVo + VersionRange.RIGHT_OPEN;
    }

    public PromoData(String str, Object obj, List<CouponInfo> list, String str2, String str3, String str4, ShareBannerInfo shareBannerInfo2, List<PromoShareInfo> list2, String str5, List<CouponInfo> list3, WaiMaiVo waiMaiVo2) {
        this.activityId = str;
        this.businessLine = obj;
        this.couponInfoList = list;
        this.promoType = str2;
        this.promotionCode = str3;
        this.resultLang = str4;
        this.shareBannerInfo = shareBannerInfo2;
        this.shareInfo = list2;
        this.shareUrl = str5;
        this.tuiCouponInfoList = list3;
        this.waiMaiVo = waiMaiVo2;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final Object getBusinessLine() {
        return this.businessLine;
    }

    public final List<CouponInfo> getCouponInfoList() {
        return this.couponInfoList;
    }

    public final String getPromoType() {
        return this.promoType;
    }

    public final String getPromotionCode() {
        return this.promotionCode;
    }

    public final String getResultLang() {
        return this.resultLang;
    }

    public final ShareBannerInfo getShareBannerInfo() {
        return this.shareBannerInfo;
    }

    public final List<PromoShareInfo> getShareInfo() {
        return this.shareInfo;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final List<CouponInfo> getTuiCouponInfoList() {
        return this.tuiCouponInfoList;
    }

    public final WaiMaiVo getWaiMaiVo() {
        return this.waiMaiVo;
    }
}
