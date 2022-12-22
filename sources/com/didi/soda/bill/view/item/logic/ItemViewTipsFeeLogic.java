package com.didi.soda.bill.view.item.logic;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/logic/ItemViewTipsFeeLogic;", "Lcom/didi/soda/bill/view/item/logic/ItemViewAbsLogic;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "handleTipsFeeViewClick", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "selectFee", "", "selectIndex", "", "clickType", "handleTipsIConClick", "ruleDescEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemViewTipsFeeLogic.kt */
public final class ItemViewTipsFeeLogic extends ItemViewAbsLogic {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemViewTipsFeeLogic(ScopeContext scopeContext) {
        super(scopeContext);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
    }

    public final void handleTipsFeeViewClick(ComponentModel componentModel, long j, int i, int i2) {
        BillTipModel tipModel;
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        if (1 == i2) {
            ComponentDataModel data = componentModel.getData();
            if (data != null && (tipModel = data.getTipModel()) != null) {
                if (j == tipModel.getTipFeeValue()) {
                    j = 0;
                }
                tipModel.setTipFeeValue(j);
                BillOmegaHelper.Companion.traceBillTipsFeeCK(componentModel.getCartId(), componentModel.getShopId(), false, tipModel.getTipFeeValue(), tipModel.getTipFeeType());
                ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(tipModel.convertToEntity());
            }
        } else if (2 == i2) {
            Request.Builder putLong = DiRouter.request().path(RoutePath.BILL_TIP_FEE_EDIT_TIP).putInt("price", componentModel.getAfterFavPrice()).putString(Const.PageParams.KEY_BILL_TIP_FEE_CURRENCY, componentModel.getCurrency()).putLong(Const.PageParams.KEY_BILL_TIP_FEE_SELECTED_FEE, j);
            ComponentDataModel data2 = componentModel.getData();
            putLong.putSerializable(Const.PageParams.KEY_BILL_TIP_FEE_MODEL, data2 == null ? null : data2.getTipModel()).putString(Const.PageParams.CART_ID, componentModel.getCartId()).putString(Const.PageParams.SHOP_ID, componentModel.getShopId()).open();
        }
    }

    public final void handleTipsIConClick(RuleDescEntity ruleDescEntity) {
        if (ruleDescEntity != null) {
            DiRouter.request().path("priceRuleDescPage").putSerializable("entity", ruleDescEntity).open();
        }
    }
}
