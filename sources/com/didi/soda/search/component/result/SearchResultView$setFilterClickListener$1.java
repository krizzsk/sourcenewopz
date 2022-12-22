package com.didi.soda.search.component.result;

import android.view.View;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.home.topgun.model.FilterModel;
import com.didi.soda.search.component.result.Contract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, mo175978d2 = {"<anonymous>", "", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SearchResultView.kt */
final class SearchResultView$setFilterClickListener$1 extends Lambda implements Function3<FilterModel, View, Boolean, Unit> {
    final /* synthetic */ SearchResultView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SearchResultView$setFilterClickListener$1(SearchResultView searchResultView) {
        super(3);
        this.this$0 = searchResultView;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((FilterModel) obj, (View) obj2, ((Boolean) obj3).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FilterModel filterModel, View view, boolean z) {
        if (!ClickUtils.isFastClick()) {
            ((Contract.AbsSearchResultPresenter) this.this$0.getPresenter()).notifyFilterItemClick(filterModel);
        }
    }
}
