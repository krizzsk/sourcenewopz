package com.didi.soda.search.component.result;

import com.didi.soda.home.topgun.component.filter.FilterDataManager;
import com.didi.soda.home.topgun.model.FilterModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultPresenter.kt */
final class SearchResultPresenter$initFilterEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SearchResultPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultPresenter$initFilterEvent$1(SearchResultPresenter searchResultPresenter) {
        super(0);
        this.this$0 = searchResultPresenter;
    }

    public final void invoke() {
        List filterModelListWithoutMain$default = FilterDataManager.getFilterModelListWithoutMain$default(this.this$0.f43745c, false, 1, (Object) null);
        this.this$0.m31054a(this.this$0.f43745c.getMainFilterModel(), (List<? extends FilterModel>) filterModelListWithoutMain$default);
    }
}
