package com.didi.soda.search.component.result;

import com.didi.soda.customer.foundation.rpc.entity.SearchModuleEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didi/soda/search/component/result/SearchResultPageParam;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultDataSource.kt */
final class SearchResultDataSource$buildMoudleList$3 extends Lambda implements Function1<SearchResultPageParam, Unit> {
    final /* synthetic */ SearchModuleEntity $moudleEntity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultDataSource$buildMoudleList$3(SearchModuleEntity searchModuleEntity) {
        super(1);
        this.$moudleEntity = searchModuleEntity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SearchResultPageParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SearchResultPageParam searchResultPageParam) {
        Intrinsics.checkNotNullParameter(searchResultPageParam, "$this$updateParams");
        Integer num = this.$moudleEntity.mSize;
        searchResultPageParam.setHighRatingRecallNumm(num == null ? 0 : num.intValue());
    }
}
