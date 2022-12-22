package com.didi.soda.bill.view.item.logic;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.customer.foundation.util.ToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JT\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "Lcom/didi/soda/bill/view/item/logic/ItemViewAbsLogic;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "onItemClick", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "type", "", "bundle", "Landroid/os/Bundle;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lcom/didi/soda/bill/model/ComponentModel;Ljava/lang/Integer;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;)V", "showToast", "msg", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemViewCommonLogic.kt */
public abstract class ItemViewCommonLogic extends ItemViewAbsLogic {
    public abstract void onItemClick(ComponentModel componentModel, Integer num, Bundle bundle, Function1<? super ScopeContext, Unit> function1);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemViewCommonLogic(ScopeContext scopeContext) {
        super(scopeContext);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
    }

    public static /* synthetic */ void onItemClick$default(ItemViewCommonLogic itemViewCommonLogic, ComponentModel componentModel, Integer num, Bundle bundle, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                num = 0;
            }
            if ((i & 4) != 0) {
                bundle = new Bundle();
            }
            if ((i & 8) != 0) {
                function1 = null;
            }
            itemViewCommonLogic.onItemClick(componentModel, num, bundle, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onItemClick");
    }

    public final void showToast(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        ToastUtil.showCustomerToast(getScopeContext(), str);
    }
}
