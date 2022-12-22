package com.didi.soda.search.component.result;

import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.home.topgun.model.FilterItemParam;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n"}, mo175978d2 = {"<anonymous>", "", "Lcom/didi/soda/search/component/result/SearchResultPageParam;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPresenter.kt */
final class SearchResultPresenter$confirm$1 extends Lambda implements Function1<SearchResultPageParam, Unit> {
    final /* synthetic */ ArrayList<FilterItemParam> $selectedFilters;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultPresenter$confirm$1(ArrayList<FilterItemParam> arrayList) {
        super(1);
        this.$selectedFilters = arrayList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SearchResultPageParam) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SearchResultPageParam searchResultPageParam) {
        searchResultPageParam.setLastQuery(searchResultPageParam.getSearchTag());
        searchResultPageParam.setFilterParams(GsonUtil.toJson(this.$selectedFilters));
    }
}
