package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.compose.action.ActionInterceptListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActivityPresenter$onHandleBack$lis$1", "Lcom/didi/soda/customer/compose/action/ActionInterceptListener;", "onActionIntercept", "", "intercept", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
public final class TopicActivityPresenter$onHandleBack$lis$1 implements ActionInterceptListener {
    final /* synthetic */ TopicActivityPresenter this$0;

    TopicActivityPresenter$onHandleBack$lis$1(TopicActivityPresenter topicActivityPresenter) {
        this.this$0 = topicActivityPresenter;
    }

    public void onActionIntercept(boolean z) {
        if (!z) {
            this.this$0.getScopeContext().getNavigator().finish();
        }
    }
}
