package com.didi.soda.home.manager;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.kingkong.KingKongItemModel;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/manager/KingKongOmegaHelper$onKingKongItemShow$onceAction$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KingKongOmegaHelper.kt */
public final class KingKongOmegaHelper$onKingKongItemShow$onceAction$1 extends OnceActionUtil.OnceAction {
    final /* synthetic */ HashMap<String, String> $map;
    final /* synthetic */ KingKongItemModel $model;
    final /* synthetic */ int $position;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KingKongOmegaHelper$onKingKongItemShow$onceAction$1(HashMap<String, String> hashMap, KingKongItemModel kingKongItemModel, int i, Object[] objArr) {
        super(objArr);
        this.$map = hashMap;
        this.$model = kingKongItemModel;
        this.$position = i;
    }

    public void run() {
        String str;
        String str2;
        String str3;
        String str4;
        String num;
        FeedPayload payload;
        String str5;
        OmegaTracker.Builder addAllEventParam = OmegaTracker.Builder.create(EventConst.KingKong.SAILING_C_X_HOMEPAGE_DIAMOND_REALEXPOSURE_SW).addAllEventParam(this.$map);
        FeedPayload payload2 = this.$model.getPayload();
        String str6 = "";
        if (payload2 == null || (str5 = payload2.mRecId) == null || (str = str5.toString()) == null) {
            str = str6;
        }
        OmegaTracker.Builder addEventParam = addAllEventParam.addEventParam("rec_id", str);
        KingKongItemModel kingKongItemModel = this.$model;
        if (kingKongItemModel == null || (payload = kingKongItemModel.getPayload()) == null || (str2 = payload.mPageId) == null) {
            str2 = str6;
        }
        String lowerCase = str2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("page", lowerCase);
        KingKongItemModel kingKongItemModel2 = this.$model;
        if (kingKongItemModel2 == null || (str3 = kingKongItemModel2.getResourceId()) == null) {
            str3 = str6;
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("resource_id", str3);
        KingKongItemModel kingKongItemModel3 = this.$model;
        if (kingKongItemModel3 == null || (str4 = kingKongItemModel3.getUrl()) == null) {
            str4 = str6;
        }
        OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam("activity_url", str4).addEventParam("index", String.valueOf(this.$position));
        FeedPayload payload3 = this.$model.getPayload();
        if (!(payload3 == null || (num = Integer.valueOf(payload3.mComponentIndex).toString()) == null)) {
            str6 = num;
        }
        addEventParam4.addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, str6).build().track();
        KingKongOmegaHelper.onCategoryRedFlagSW(this.$model, this.$position);
    }
}
