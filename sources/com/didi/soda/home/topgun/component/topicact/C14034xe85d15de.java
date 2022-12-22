package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper$headerFilterTopicCategoriesSw$filterItemShowTrack$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$headerFilterTopicCategoriesSw$filterItemShowTrack$1 */
/* compiled from: TopicActOmegaHelper.kt */
public final class C14034xe85d15de extends OnceActionUtil.OnceAction {
    final /* synthetic */ String $from;
    final /* synthetic */ String $location;
    final /* synthetic */ String $time;
    final /* synthetic */ TopicActOmegaHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C14034xe85d15de(TopicActOmegaHelper topicActOmegaHelper, String str, String str2, String str3) {
        super(str3);
        this.this$0 = topicActOmegaHelper;
        this.$from = str;
        this.$time = str2;
        this.$location = str3;
    }

    public void run() {
        OmegaTracker.Builder access$create = this.this$0.m30358a(EventConst.Home.SAILING_C_X_OPERATION_CATEGORY_FILTER_SW);
        String str = this.$from;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        OmegaTracker.Builder addEventParam = access$create.addEventParam("from", str);
        String str3 = this.$time;
        if (str3 != null) {
            str2 = str3;
        }
        addEventParam.addEventParam("time_period", str2).build().track();
    }
}
