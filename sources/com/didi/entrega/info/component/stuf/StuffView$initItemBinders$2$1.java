package com.didi.entrega.info.component.stuf;

import com.didi.entrega.info.binder.StufRemarkBinder;
import com.didi.entrega.info.model.StuffRemarkModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/info/component/stuf/StuffView$initItemBinders$2$1", "Lcom/didi/entrega/info/binder/StufRemarkBinder$StuffRemarkCardClickListener;", "onRemarkTextChange", "", "item", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffView.kt */
public final class StuffView$initItemBinders$2$1 implements StufRemarkBinder.StuffRemarkCardClickListener {
    final /* synthetic */ StuffView this$0;

    StuffView$initItemBinders$2$1(StuffView stuffView) {
        this.this$0 = stuffView;
    }

    public void onRemarkTextChange(StuffRemarkModel stuffRemarkModel) {
        this.this$0.getRepo().setstuffRemarkModelValue(stuffRemarkModel);
    }
}
