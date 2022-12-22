package com.didi.soda.home.topgun.component.topicact;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.datasource.page.UpdateUtils;
import com.didi.soda.home.topgun.binder.model.HomeNoResultRvModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"com/didi/soda/home/topgun/component/topicact/TopicActivityPresenter$isFilterNone$1", "Lcom/didi/soda/datasource/page/UpdateUtils$DiffCallback;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "isTarget", "", "pos", "", "oldTarget", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicActivityPresenter.kt */
public final class TopicActivityPresenter$isFilterNone$1 implements UpdateUtils.DiffCallback<RecyclerModel> {
    TopicActivityPresenter$isFilterNone$1() {
    }

    public boolean isTarget(int i, RecyclerModel recyclerModel) {
        return recyclerModel instanceof HomeNoResultRvModel;
    }
}
