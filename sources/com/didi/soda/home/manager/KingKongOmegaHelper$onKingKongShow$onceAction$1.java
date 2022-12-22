package com.didi.soda.home.manager;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.kingkong.KingKongModel;
import com.google.gson.JsonArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/manager/KingKongOmegaHelper$onKingKongShow$onceAction$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KingKongOmegaHelper.kt */
public final class KingKongOmegaHelper$onKingKongShow$onceAction$1 extends OnceActionUtil.OnceAction {
    final /* synthetic */ JsonArray $list;
    final /* synthetic */ KingKongModel $model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KingKongOmegaHelper$onKingKongShow$onceAction$1(JsonArray jsonArray, KingKongModel kingKongModel, Object[] objArr) {
        super(objArr);
        this.$list = jsonArray;
        this.$model = kingKongModel;
    }

    public void run() {
        String str;
        String str2;
        String num;
        FeedPayload payload;
        String str3;
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.KingKong.SAILING_C_X_HOMEPAGE_DIAMOND_BAR_SW).addEventParam(ParamConst.PARAM_CATEGORY_LIST, GsonUtil.toJson(this.$list));
        FeedPayload payload2 = this.$model.getPayload();
        String str4 = "";
        if (payload2 == null || (str3 = payload2.mRecId) == null || (str = str3.toString()) == null) {
            str = str4;
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("rec_id", str);
        KingKongModel kingKongModel = this.$model;
        if (kingKongModel == null || (payload = kingKongModel.getPayload()) == null || (str2 = payload.mPageId) == null) {
            str2 = str4;
        }
        String lowerCase = str2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("page", lowerCase);
        FeedPayload payload3 = this.$model.getPayload();
        if (!(payload3 == null || (num = Integer.valueOf(payload3.mComponentIndex).toString()) == null)) {
            str4 = num;
        }
        addEventParam3.addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, str4).build().track();
    }
}
