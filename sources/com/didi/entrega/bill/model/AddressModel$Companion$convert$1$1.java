package com.didi.entrega.bill.model;

import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.base.pages.RoutePath;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.didi.entrega.router.DiRouter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AddressModel.kt */
final class AddressModel$Companion$convert$1$1 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ ScopeContext $scopeContext;
    final /* synthetic */ AddressType $type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddressModel$Companion$convert$1$1(AddressType addressType, ScopeContext scopeContext) {
        super(1);
        this.$type = addressType;
        this.$scopeContext = scopeContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "it");
        if (this.$type == AddressType.SENDER) {
            BillOmegaHelper.INSTANCE.trackBillClick(this.$scopeContext, Const.BillClickType.SENDER);
            str = RoutePath.EDIT_SEND_PAGE;
        } else {
            BillOmegaHelper.INSTANCE.trackBillClick(this.$scopeContext, "receiver");
            str = RoutePath.EDIT_RECEIVE_PAGE;
        }
        ScopeContext scopeContext = this.$scopeContext;
        if (scopeContext != null) {
            DiRouter.request().path(str).setFromPage(scopeContext).putSerializable(Const.BundleKey.INFO_PAGE_CONFIG, InfoStepConfig.Companion.getUPDATE()).putInt("page_source", BillRepo.Companion.get(scopeContext).getPageSource()).putInt(ParamConst.InfoOmega.EVENT_SOURCE, 2).open();
        }
    }
}
