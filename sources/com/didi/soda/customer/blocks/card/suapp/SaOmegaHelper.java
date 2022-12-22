package com.didi.soda.customer.blocks.card.suapp;

import android.text.TextUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J*\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nJ*\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaOmegaHelper;", "", "()V", "mActionPool", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$ActionPool;", "attach", "", "create", "Lcom/didi/soda/customer/foundation/tracker/OmegaTracker$Builder;", "eventConst", "", "landingitemExposure", "businessItem", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "scene", "", "actId", "componentId", "trackLandingItemClick", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaOmegaHelper.kt */
public final class SaOmegaHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f40622b = "TopicActOmegaHelper";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final SaOmegaHelper f40623c = new SaOmegaHelper();

    /* renamed from: a */
    private OnceActionUtil.ActionPool f40624a;

    public final void attach() {
        this.f40624a = new OnceActionUtil.ActionPool();
    }

    public static /* synthetic */ void landingitemExposure$default(SaOmegaHelper saOmegaHelper, HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        saOmegaHelper.landingitemExposure(homeBusinessInfoRvModel, i, str, str2);
    }

    public final void landingitemExposure(HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "businessItem");
        Intrinsics.checkNotNullParameter(str, BlocksConst.BLOCK_ACT_ID);
        if (!TextUtils.isEmpty(homeBusinessInfoRvModel.mShopId)) {
            SaOmegaHelper$landingitemExposure$moduleShowTrack$1 saOmegaHelper$landingitemExposure$moduleShowTrack$1 = new SaOmegaHelper$landingitemExposure$moduleShowTrack$1(this, homeBusinessInfoRvModel, str, i, str2, new Object[]{homeBusinessInfoRvModel.mShopId, Integer.valueOf(homeBusinessInfoRvModel.mRowInModule)});
            OnceActionUtil.ActionPool actionPool = this.f40624a;
            if (actionPool != null && actionPool != null) {
                actionPool.doAction(saOmegaHelper$landingitemExposure$moduleShowTrack$1);
            }
        }
    }

    public static /* synthetic */ void trackLandingItemClick$default(SaOmegaHelper saOmegaHelper, HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        saOmegaHelper.trackLandingItemClick(homeBusinessInfoRvModel, i, str, str2);
    }

    public final void trackLandingItemClick(HomeBusinessInfoRvModel homeBusinessInfoRvModel, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "businessItem");
        Intrinsics.checkNotNullParameter(str, BlocksConst.BLOCK_ACT_ID);
        OmegaTracker.Builder addEventParam = m28873a(EventConst.TopicActivity.LANDING_SHOP_ITEM_CLICK).addEventParam(ParamConst.PARAM_SHOP_NAME, homeBusinessInfoRvModel.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(homeBusinessInfoRvModel.mShopStatus)).addEventParam("shop_id", homeBusinessInfoRvModel.mShopId);
        OmegaTracker.Builder enableGuideParam = addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, homeBusinessInfoRvModel.mCurrency + '_' + homeBusinessInfoRvModel.mDeliveryPriceOri + '_' + homeBusinessInfoRvModel.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryTime)).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(homeBusinessInfoRvModel.mDeliveryType)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(homeBusinessInfoRvModel.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, homeBusinessInfoRvModel.mShopCateInfoDescForTrack).addEventParam("activity_id", str).addEventParam("from", 2).addEventParam("scene", Integer.valueOf(i)).enableGuideParam();
        enableGuideParam.addEventParam("from_channel", 1);
        if (str2 == null) {
            str2 = "";
        }
        enableGuideParam.addEventParam("topic_id", str2);
        enableGuideParam.build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final OmegaTracker.Builder m28873a(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(str);
        Intrinsics.checkNotNullExpressionValue(create, "create(eventConst)");
        return create;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaOmegaHelper$Companion;", "", "()V", "TAG", "", "instance", "Lcom/didi/soda/customer/blocks/card/suapp/SaOmegaHelper;", "getInstance", "()Lcom/didi/soda/customer/blocks/card/suapp/SaOmegaHelper;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SaOmegaHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SaOmegaHelper getInstance() {
            return SaOmegaHelper.f40623c;
        }
    }
}
