package com.didi.soda.order.omega;

import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/order/omega/EvaluateOmegaHelper$Companion$trackEvaluatePageLikeCk$moduleShowTrack$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.order.omega.EvaluateOmegaHelper$Companion$trackEvaluatePageLikeCk$moduleShowTrack$1 */
/* compiled from: EvaluateOmegaHelper.kt */
public final class C14140x5ba68bb7 extends OnceActionUtil.OnceAction {
    final /* synthetic */ int $from;
    final /* synthetic */ int $likeType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C14140x5ba68bb7(int i, int i2, String str) {
        super(str);
        this.$from = i;
        this.$likeType = i2;
    }

    public void run() {
        EvaluateOmegaHelper.Companion.createTracker(EventConst.Order.SAILING_C_X_SIDEBAR_EVALUATE_PAGE_LICK_CK).addEventParam("from_channel", Integer.valueOf(this.$from)).addEventParam(ParamConst.PARAMS_LIKE_TYPE, Integer.valueOf(this.$likeType)).build().track();
    }
}
