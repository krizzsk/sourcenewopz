package com.didi.entrega.info.binder;

import com.didi.entrega.info.binder.StufTypeItemBinder;
import com.didi.entrega.info.model.StuffTypeItemModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/entrega/info/binder/StufTypeBinder$create$1$1", "Lcom/didi/entrega/info/binder/StufTypeItemBinder$OnInfoTypeItemClickListener;", "onInfoTypeItemClick", "", "item", "Lcom/didi/entrega/info/model/StuffTypeItemModel;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StufTypeBinder.kt */
public final class StufTypeBinder$create$1$1 implements StufTypeItemBinder.OnInfoTypeItemClickListener {
    final /* synthetic */ StufTypeBinder this$0;

    StufTypeBinder$create$1$1(StufTypeBinder stufTypeBinder) {
        this.this$0 = stufTypeBinder;
    }

    public void onInfoTypeItemClick(StuffTypeItemModel stuffTypeItemModel) {
        this.this$0.setItemData(stuffTypeItemModel);
    }
}
