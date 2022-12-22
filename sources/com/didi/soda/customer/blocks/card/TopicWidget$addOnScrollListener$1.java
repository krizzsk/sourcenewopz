package com.didi.soda.customer.blocks.card;

import com.didi.soda.customer.blocks.widget.OnScrollListener;
import com.didi.soda.home.topgun.binder.model.HomeHorizontalScrollTopicRvModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/customer/blocks/card/TopicWidget$addOnScrollListener$1", "Lcom/didi/soda/customer/blocks/widget/OnScrollListener;", "onScroll", "", "scrollX", "", "scrollY", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicWidget.kt */
public final class TopicWidget$addOnScrollListener$1 implements OnScrollListener {
    final /* synthetic */ TopicWidget this$0;

    TopicWidget$addOnScrollListener$1(TopicWidget topicWidget) {
        this.this$0 = topicWidget;
    }

    public void onScroll(int i, int i2) {
        HomeHorizontalScrollTopicRvModel rvModel = this.this$0.getRvModel();
        if (rvModel != null) {
            rvModel.mScrollX = i;
        }
    }
}
