package com.didi.soda.home.topgun.binder;

import com.didi.soda.home.topgun.adapter.HomeSearchViewFlpperAdapter;
import com.didi.soda.home.topgun.binder.HomeNewHeaderBinder;
import com.didi.soda.home.topgun.model.HomeSearchHotWordsModel;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/home/topgun/binder/HomeNewHeaderBinder$ViewHolder$setViewAdapterFlipper$2", "Lcom/didi/soda/home/topgun/adapter/HomeSearchViewFlpperAdapter$OnItemClickListener;", "onItemClickListener", "", "model", "Lcom/didi/soda/home/topgun/model/HomeSearchHotWordsModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeNewHeaderBinder.kt */
public final class HomeNewHeaderBinder$ViewHolder$setViewAdapterFlipper$2 implements HomeSearchViewFlpperAdapter.OnItemClickListener {
    final /* synthetic */ HomeNewHeaderBinder.ViewHolder this$0;
    final /* synthetic */ HomeNewHeaderBinder this$1;

    HomeNewHeaderBinder$ViewHolder$setViewAdapterFlipper$2(HomeNewHeaderBinder.ViewHolder viewHolder, HomeNewHeaderBinder homeNewHeaderBinder) {
        this.this$0 = viewHolder;
        this.this$1 = homeNewHeaderBinder;
    }

    public void onItemClickListener(HomeSearchHotWordsModel homeSearchHotWordsModel) {
        if (homeSearchHotWordsModel != null) {
            HomeNewHeaderBinder.ViewHolder viewHolder = this.this$0;
            HomeNewHeaderBinder homeNewHeaderBinder = this.this$1;
            ((HomeHeaderBinderLogic) homeNewHeaderBinder.getBinderLogic()).onSearchLayoutClick(viewHolder.isFloating(), homeSearchHotWordsModel);
        }
    }
}
