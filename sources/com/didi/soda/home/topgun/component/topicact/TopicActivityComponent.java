package com.didi.soda.home.topgun.component.topicact;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.home.topgun.component.topicact.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0014J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/TopicActivityComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityView;", "Lcom/didi/soda/home/topgun/component/topicact/Contract$AbsTopicActivityPresenter;", "viewGroup", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "onCreatePresenter", "onCreateView", "onHandleBack", "", "onPageResult", "", "data", "Landroid/os/Bundle;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityComponent.kt */
public final class TopicActivityComponent extends MvpComponent<Contract.AbsTopicActivityView, Contract.AbsTopicActivityPresenter> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopicActivityComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
    }

    /* access modifiers changed from: protected */
    public Contract.AbsTopicActivityView onCreateView() {
        return new TopicActivityView();
    }

    /* access modifiers changed from: protected */
    public Contract.AbsTopicActivityPresenter onCreatePresenter() {
        return new TopicActivityPresenter();
    }

    public final boolean onHandleBack() {
        Contract.AbsTopicActivityPresenter absTopicActivityPresenter = (Contract.AbsTopicActivityPresenter) getPresenter();
        if (absTopicActivityPresenter == null) {
            return false;
        }
        return absTopicActivityPresenter.onHandleBack();
    }

    public final void onPageResult(Bundle bundle) {
        Contract.AbsTopicActivityPresenter absTopicActivityPresenter = (Contract.AbsTopicActivityPresenter) getPresenter();
        if (absTopicActivityPresenter != null) {
            absTopicActivityPresenter.onPageResult(bundle);
        }
    }
}
