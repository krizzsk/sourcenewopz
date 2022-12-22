package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.customer.foundation.login.LoginListener;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActivityPresenter$onFooterSignInClicked$listener$1", "Lcom/didi/soda/customer/foundation/login/LoginListener;", "onCancel", "", "onSuccess", "token", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
public final class TopicActivityPresenter$onFooterSignInClicked$listener$1 implements LoginListener {
    final /* synthetic */ TopicActivityPresenter this$0;

    TopicActivityPresenter$onFooterSignInClicked$listener$1(TopicActivityPresenter topicActivityPresenter) {
        this.this$0 = topicActivityPresenter;
    }

    public void onSuccess(String str) {
        this.this$0.m30393j();
    }

    public void onCancel() {
        LoginListener.CC.$default$onCancel(this);
    }
}
