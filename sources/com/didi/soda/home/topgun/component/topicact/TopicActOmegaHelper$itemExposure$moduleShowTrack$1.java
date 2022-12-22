package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper$itemExposure$moduleShowTrack$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActOmegaHelper.kt */
public final class TopicActOmegaHelper$itemExposure$moduleShowTrack$1 extends OnceActionUtil.OnceAction {
    final /* synthetic */ HomeBusinessInfoRvModel $businessItem;
    final /* synthetic */ TopicActOmegaHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopicActOmegaHelper$itemExposure$moduleShowTrack$1(TopicActOmegaHelper topicActOmegaHelper, HomeBusinessInfoRvModel homeBusinessInfoRvModel, Object[] objArr) {
        super(objArr);
        this.this$0 = topicActOmegaHelper;
        this.$businessItem = homeBusinessInfoRvModel;
    }

    public void run() {
        OmegaTracker.Builder addEventParam = this.this$0.m30358a(EventConst.TopicActivity.SHOP_ITEM_SHOW).addEventParam("shop_id", this.$businessItem.mShopId).addEventParam(ParamConst.PARAM_SHOP_NAME, this.$businessItem.mShopName).addEventParam(ParamConst.PARAM_SHOP_STATUS, Integer.valueOf(this.$businessItem.mShopStatus));
        addEventParam.addEventParam(ParamConst.PARAM_SHOP_DELIVERY_FEE, this.$businessItem.mCurrency + '_' + this.$businessItem.mDeliveryPriceOri + '_' + this.$businessItem.mDeliveryPriceAct).addEventParam(ParamConst.PARAM_SHOP_TAG, SentenceUtil.foldStringList(this.$businessItem.mShopTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_DISCOUNT_TAG, SentenceUtil.foldStringList(this.$businessItem.mActTipList, ",")).addEventParam(ParamConst.PARAM_SHOP_MAIN_TAG, this.$businessItem.mShopCateInfoDescForTrack).addEventParam("activity_id", this.this$0.f42907c).addEventParam("index", Integer.valueOf(this.$businessItem.mRowInModule)).build().track();
    }
}
