package com.didi.soda.home.topgun.component.topicact;

import com.didi.soda.home.topgun.component.topicact.Contract;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.home.topgun.widget.BindViewHolderCallBack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActivityView$initItemBinders$2$1", "Lcom/didi/soda/home/topgun/widget/BindViewHolderCallBack;", "onbind", "", "model", "Lcom/didi/soda/home/topgun/model/FilterModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityView.kt */
public final class TopicActivityView$initItemBinders$2$1 implements BindViewHolderCallBack {
    final /* synthetic */ TopicActivityView this$0;

    TopicActivityView$initItemBinders$2$1(TopicActivityView topicActivityView) {
        this.this$0 = topicActivityView;
    }

    public void onbind(FilterModel filterModel, int i) {
        Intrinsics.checkNotNullParameter(filterModel, "model");
        if (filterModel.mShowType == 7) {
            TopicActOmegaHelper.Companion.getInstance().headerFilterTopicCategoriesSw(String.valueOf(i), String.valueOf(this.this$0.f42937i), ((Contract.AbsTopicActivityPresenter) this.this$0.getPresenter()).getMOmegaTabTime());
        } else if (filterModel.mShowType == 5) {
            TopicActOmegaHelper.Companion.getInstance().headerFilterTopicSortSw(String.valueOf(i), String.valueOf(this.this$0.f42937i), filterModel.getOutFilterId(), String.valueOf(i), ((Contract.AbsTopicActivityPresenter) this.this$0.getPresenter()).getMOmegaTabTime());
        }
    }
}
