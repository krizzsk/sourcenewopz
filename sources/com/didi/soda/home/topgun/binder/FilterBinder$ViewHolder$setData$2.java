package com.didi.soda.home.topgun.binder;

import android.view.View;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.home.topgun.binder.FilterBinder;
import com.didi.soda.home.topgun.model.FilterModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, mo175978d2 = {"<anonymous>", "", "filterModel", "Lcom/didi/soda/home/topgun/model/FilterModel;", "item", "Landroid/view/View;", "isReset", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FilterBinder.kt */
final class FilterBinder$ViewHolder$setData$2 extends Lambda implements Function3<FilterModel, View, Boolean, Unit> {
    final /* synthetic */ FilterBinder this$0;
    final /* synthetic */ FilterBinder.ViewHolder this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FilterBinder$ViewHolder$setData$2(FilterBinder filterBinder, FilterBinder.ViewHolder viewHolder) {
        super(3);
        this.this$0 = filterBinder;
        this.this$1 = viewHolder;
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((FilterModel) obj, (View) obj2, ((Boolean) obj3).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FilterModel filterModel, View view, boolean z) {
        Intrinsics.checkNotNullParameter(filterModel, "filterModel");
        Intrinsics.checkNotNullParameter(view, "item");
        if (!ClickUtils.isFastClick()) {
            if (z) {
                this.this$0.scopeContext.detach(FilterBinderKt.keyFilterBinderPos);
                this.this$0.scopeContext.detach(FilterBinderKt.keyFilterBinderOffset);
            }
            ((HomeHeaderBinderLogic) this.this$0.getBinderLogic()).filterItemAction(filterModel, this.this$1.isFloating());
        }
    }
}
