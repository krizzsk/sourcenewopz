package com.didi.soda.home.widget;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.TabInfoEntity;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/widget/ITabItemView;", "", "bindData", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "tabInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/TabInfoEntity;", "getView", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TabsView.kt */
public interface ITabItemView {
    void bindData(ScopeContext scopeContext, TabInfoEntity tabInfoEntity);

    View getView();
}
