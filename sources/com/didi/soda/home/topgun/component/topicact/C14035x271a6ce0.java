package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActOmegaHelper$headerFilterTopicSortSw$filterItemShowTrack$1", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$OnceAction;", "run", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.home.topgun.component.topicact.TopicActOmegaHelper$headerFilterTopicSortSw$filterItemShowTrack$1 */
/* compiled from: TopicActOmegaHelper.kt */
public final class C14035x271a6ce0 extends OnceActionUtil.OnceAction {
    final /* synthetic */ String $filter_param;
    final /* synthetic */ String $from;
    final /* synthetic */ String $index;
    final /* synthetic */ String $location;
    final /* synthetic */ String $time;
    final /* synthetic */ TopicActOmegaHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C14035x271a6ce0(TopicActOmegaHelper topicActOmegaHelper, String str, String str2, String str3, String str4, String str5) {
        super(str5);
        this.this$0 = topicActOmegaHelper;
        this.$from = str;
        this.$filter_param = str2;
        this.$index = str3;
        this.$time = str4;
        this.$location = str5;
    }

    public void run() {
        OmegaTracker.Builder access$create = this.this$0.m30358a(EventConst.Home.SAILING_C_X_OPERATION_SORT_FILTER_SW);
        String str = this.$from;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        OmegaTracker.Builder addEventParam = access$create.addEventParam("from", str);
        String str3 = this.$filter_param;
        if (str3 == null) {
            str3 = str2;
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.FILTER_PARAM, str3);
        String str4 = this.$index;
        if (str4 == null) {
            str4 = str2;
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("index", str4);
        String str5 = this.$time;
        if (str5 != null) {
            str2 = str5;
        }
        addEventParam3.addEventParam("time_period", str2).build().track();
    }
}
