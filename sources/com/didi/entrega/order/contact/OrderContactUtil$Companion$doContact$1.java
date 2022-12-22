package com.didi.entrega.order.contact;

import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.order.contact.OrderContactUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "orderInfo", "Lcom/didi/entrega/order/contact/IMContactModel;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderContactUtil.kt */
final class OrderContactUtil$Companion$doContact$1 extends Lambda implements Function1<IMContactModel, Unit> {
    final /* synthetic */ int $contactRole;
    final /* synthetic */ int $contactType;
    final /* synthetic */ Context $context;
    final /* synthetic */ ScopeContext $scopeContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderContactUtil$Companion$doContact$1(int i, Context context, ScopeContext scopeContext, int i2) {
        super(1);
        this.$contactRole = i;
        this.$context = context;
        this.$scopeContext = scopeContext;
        this.$contactType = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IMContactModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IMContactModel iMContactModel) {
        OrderContactUtil.Companion companion = OrderContactUtil.Companion;
        int i = this.$contactRole;
        Context context = this.$context;
        ScopeContext scopeContext = this.$scopeContext;
        int i2 = this.$contactType;
        LogUtil.m14761d("OrderContactUtil", "requestOrderInfoById  end！");
        if (iMContactModel != null) {
            IRole access$getRole = companion.getRole(i, iMContactModel);
            if (access$getRole != null) {
                access$getRole.doRealContact(context, scopeContext, i2);
                return;
            }
            return;
        }
        LogUtil.m14763e("OrderContactUtil", "callContact but orderInfoEntity is empty!!! ");
    }
}
