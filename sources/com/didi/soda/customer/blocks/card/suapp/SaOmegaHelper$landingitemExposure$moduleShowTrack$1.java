package com.didi.soda.customer.blocks.card.suapp;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/customer/blocks/card/suapp/SaOmegaHelper$landingitemExposure$moduleShowTrack$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaOmegaHelper.kt */
public final class SaOmegaHelper$landingitemExposure$moduleShowTrack$1 extends OnceActionUtil.OnceAction {
    final /* synthetic */ String $actId;
    final /* synthetic */ HomeBusinessInfoRvModel $businessItem;
    final /* synthetic */ String $componentId;
    final /* synthetic */ int $scene;
    final /* synthetic */ SaOmegaHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaOmegaHelper$landingitemExposure$moduleShowTrack$1(SaOmegaHelper saOmegaHelper, HomeBusinessInfoRvModel homeBusinessInfoRvModel, String str, int i, String str2, Object[] objArr) {
        super(objArr);
        this.this$0 = saOmegaHelper;
        this.$businessItem = homeBusinessInfoRvModel;
        this.$actId = str;
        this.$scene = i;
        this.$componentId = str2;
    }

    public void run() {
        OmegaTracker.Builder addEventParam = this.this$0.m28873a(EventConst.TopicActivity.LANDING_SHOP_ITEM_SHOW).addEventParam(ParamConst.PARAM_SHOP_NAME, this.$businessItem.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(this.$businessItem.mShopStatus)).addEventParam("shop_id", this.$businessItem.mShopId);
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, this.$businessItem.mCurrency + '_' + this.$businessItem.mDeliveryPriceOri + '_' + this.$businessItem.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_DELIVERY_TIME, Integer.valueOf(this.$businessItem.mDeliveryTime)).addEventParam(ParamConst.PARAM_DELIVERY_TYPE, Integer.valueOf(this.$businessItem.mDeliveryType)).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(this.$businessItem.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(this.$businessItem.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, this.$businessItem.mShopCateInfoDescForTrack).addEventParam("activity_id", this.$actId).addEventParam("from", 2).addEventParam("scene", Integer.valueOf(this.$scene)).addEventParam("lv1_location", this.$businessItem.toModuleString()).addEventParam("lv1_recid", this.$businessItem.mRecId).addEventParam("lv1_body", Intrinsics.stringPlus("shop_", this.$businessItem.mShopId)).addEventParam("lv1_filter", this.$businessItem.mPageFilter);
        addEventParam2.addEventParam("from_channel", 1);
        String str = this.$componentId;
        if (str == null) {
            str = "";
        }
        addEventParam2.addEventParam("topic_id", str);
        addEventParam2.build().track();
    }
}
