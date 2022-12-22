package com.didi.entrega.info.component.send;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.entrega.info.binder.HistoryItemBinder;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.model.HistoryModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/entrega/info/component/send/SendContactView$initItemBinders$2$1", "Lcom/didi/entrega/info/binder/HistoryItemBinder$HistoryClickListener;", "onClickDelete", "", "item", "Lcom/didi/entrega/info/model/HistoryModel;", "onClickItem", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SendContactView.kt */
public final class SendContactView$initItemBinders$2$1 implements HistoryItemBinder.HistoryClickListener {
    final /* synthetic */ SendContactView this$0;

    SendContactView$initItemBinders$2$1(SendContactView sendContactView) {
        this.this$0 = sendContactView;
    }

    public void onClickDelete(HistoryModel historyModel) {
        IPresenter presenter = this.this$0.getPresenter();
        if (presenter != null) {
            ((ContactConstract.AbsEditContactPresenter) presenter).onHistoryItemDeleteClick(historyModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter");
    }

    public void onClickItem(HistoryModel historyModel) {
        IPresenter presenter = this.this$0.getPresenter();
        if (presenter != null) {
            ((ContactConstract.AbsEditContactPresenter) presenter).onHistoryItemClick(historyModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.info.component.ContactConstract.AbsEditContactPresenter");
    }
}
