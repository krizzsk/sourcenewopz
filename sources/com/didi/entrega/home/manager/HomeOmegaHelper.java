package com.didi.entrega.home.manager;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.home.component.feed.binder.model.banner.BannerRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/HomeOmegaHelper;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeOmegaHelper.kt */
public final class HomeOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ*\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\fJ\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u001d\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0002\u0010$J\u0016\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f¨\u0006,"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/HomeOmegaHelper$Companion;", "", "()V", "create", "Lcom/didi/entrega/customer/foundation/tracker/OmegaTracker$Builder;", "eventConst", "", "homeBannerImageDownLoadTime", "", "item", "Lcom/didi/entrega/home/component/feed/binder/model/banner/BannerRvModel;", "position", "", "time", "", "itemExposureForBanner", "trackBannerClick", "trackBusinessHourCK", "trackBusinessHourSW", "trackCouponCK", "trackCouponSW", "trackHomeBGSW", "activityId", "url", "isSuccess", "trackHomeBack", "type", "trackHomeFeedShow", "trackLegalCK", "clickType", "trackLegalCheckCK", "trackLegalCheckSW", "trackLegalSW", "trackOrderCK", "orderStatus", "orderIds", "(Ljava/lang/Integer;Ljava/lang/String;)V", "trackOrderListCK", "hasPoint", "(Ljava/lang/Integer;)V", "trackOrderSW", "trackServiceCK", "serviceType", "is_actived_toast", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackHomeFeedShow() {
            create(EventConst.Home.HOME_COMMON_SW).build().track();
        }

        public final void trackServiceCK(int i, int i2) {
            create(EventConst.Home.HOME_SERVICES_CK).addEventParam(ParamConst.PARAM_SERVICE_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_IS_ACTIVED_TOAST, Integer.valueOf(i2)).build().track();
        }

        public final void trackLegalCheckSW() {
            create(EventConst.Home.HOME_HOMEPAGE_LEGAL_COMMON_SW).build().track();
        }

        public final void trackLegalCheckCK() {
            create(EventConst.Home.HOME_HOMEPAGE_LEGAL_COMMON_CK).build().track();
        }

        public final void trackOrderListCK(Integer num) {
            create(EventConst.Home.HOME_ORDER_LIST_CK).addEventParam(ParamConst.PARAM_HAD_POINT, Integer.valueOf((num == null || num.intValue() <= 0) ? 0 : 1)).build().track();
        }

        public final void trackCouponSW() {
            create(EventConst.Home.HOME_COUPON_SW).build().track();
        }

        public final void trackCouponCK() {
            create(EventConst.Home.HOME_COUPON_CK).build().track();
        }

        public final void trackOrderSW(Integer num, String str) {
            int i;
            Intrinsics.checkNotNullParameter(str, "orderIds");
            OmegaTracker.Builder create = create(EventConst.Home.HOME_ORDER_SW);
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
            create.addEventParam(ParamConst.PARAM_ORDER_STATUS_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ORDER_LIST, str).build().track();
        }

        public final void trackOrderCK(Integer num, String str) {
            int i;
            Intrinsics.checkNotNullParameter(str, "orderIds");
            OmegaTracker.Builder create = create(EventConst.Home.HOME_ORDER_CK);
            if (num == null) {
                i = -1;
            } else {
                i = num.intValue();
            }
            create.addEventParam(ParamConst.PARAM_ORDER_STATUS_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ORDER_LIST, str).build().track();
        }

        public final void trackLegalSW() {
            create(EventConst.Home.HOME_LEGAL_SW).build().track();
        }

        public final void trackLegalCK(int i) {
            create(EventConst.Home.HOME_LEGAL_CK).addEventParam("click_type", Integer.valueOf(i)).build().track();
        }

        public final void trackBusinessHourSW() {
            create(EventConst.Home.HOME_BUSINESS_HOUR_SW).build().track();
        }

        public final void trackBusinessHourCK() {
            create(EventConst.Home.HOME_BUSINESS_HOUR_CK).build().track();
        }

        public final void itemExposureForBanner(BannerRvModel bannerRvModel, int i) {
            Intrinsics.checkNotNullParameter(bannerRvModel, "item");
            BannerRvModel.BannerItemRvModel bannerItemRvModel = bannerRvModel.mBannerList.get(i);
            Intrinsics.checkNotNullExpressionValue(bannerItemRvModel, "item.mBannerList[position]");
            BannerRvModel.BannerItemRvModel bannerItemRvModel2 = bannerItemRvModel;
            create(EventConst.Home.HOME_BANNER_SW).addEventParam("frame", Integer.valueOf(i)).addEventParam("activity_id", bannerItemRvModel2.mActivityId).addEventParam(ParamConst.PARAM_PIC_URL, bannerItemRvModel2.mUrl).build().track();
        }

        public final void homeBannerImageDownLoadTime(BannerRvModel bannerRvModel, int i, long j) {
            Intrinsics.checkNotNullParameter(bannerRvModel, "item");
            BannerRvModel.BannerItemRvModel bannerItemRvModel = bannerRvModel.mBannerList.get(i);
            Intrinsics.checkNotNullExpressionValue(bannerItemRvModel, "item.mBannerList[position]");
            BannerRvModel.BannerItemRvModel bannerItemRvModel2 = bannerItemRvModel;
            create(EventConst.Home.HOME_BANNER_DURATION_SW).addEventParam("frame", Integer.valueOf(i)).addEventParam("activity_id", bannerItemRvModel2.mActivityId).addEventParam(ParamConst.PARAM_PIC_URL, bannerItemRvModel2.mImg).addEventParam(ParamConst.PARAM_LOAD_TIME, String.valueOf(j)).build().track();
        }

        public final void trackBannerClick(BannerRvModel bannerRvModel, int i) {
            Intrinsics.checkNotNullParameter(bannerRvModel, "item");
            BannerRvModel.BannerItemRvModel bannerItemRvModel = bannerRvModel.mBannerList.get(i);
            Intrinsics.checkNotNullExpressionValue(bannerItemRvModel, "item.mBannerList[position]");
            BannerRvModel.BannerItemRvModel bannerItemRvModel2 = bannerItemRvModel;
            create(EventConst.Home.HOME_BANNER_CK).addEventParam("frame", Integer.valueOf(i)).addEventParam("activity_id", bannerItemRvModel2.mActivityId).addEventParam(ParamConst.PARAM_PIC_URL, bannerItemRvModel2.mUrl).build().track();
        }

        public final void trackHomeBGSW(String str, String str2, String str3, int i) {
            Intrinsics.checkNotNullParameter(str, "time");
            OmegaTracker.Builder addEventParam = create(EventConst.Home.HOME_HOMEPAGE_BACKGROUND_SW).addEventParam(ParamConst.PARAM_LOAD_TIME, str);
            if (str2 == null) {
                str2 = "";
            }
            OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("activity_id", str2);
            if (str3 == null) {
                str3 = "";
            }
            addEventParam2.addEventParam(ParamConst.PARAM_PIC_URL, str3).addEventParam(ParamConst.PARAM_IS_SUCCESS, Integer.valueOf(i)).build().track();
        }

        public final void trackHomeBack(int i) {
            create(EventConst.Home.HOME_BACK_CK).addEventParam(ParamConst.PARAM_EXIT_TYPE, Integer.valueOf(i)).build().track();
        }

        private final OmegaTracker.Builder create(String str) {
            OmegaTracker.Builder create = OmegaTracker.Builder.create(str);
            Intrinsics.checkNotNullExpressionValue(create, "create(eventConst)");
            return create;
        }
    }
}
