package com.didi.soda.bill.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.item.BillAddressItemViewV2;
import com.didi.soda.bill.view.item.BillCommonItemViewV2;
import com.didi.soda.bill.view.item.BillDeliveryItemViewV2;
import com.didi.soda.bill.view.item.BillFollowItemViewV2;
import com.didi.soda.bill.view.item.BillLineInfoView;
import com.didi.soda.bill.view.item.BillPayChannelItemView2;
import com.didi.soda.bill.view.item.BillRemarkItemView2;
import com.didi.soda.bill.view.item.BillReminderItemView;
import com.didi.soda.bill.view.item.BillTablewareItemView;
import com.didi.soda.bill.view.item.BillTitleInfoItemView;
import com.didi.soda.bill.view.item.BillTotalItemViewV2;
import com.didi.soda.bill.view.item.EtaItemViewV2;
import com.didi.soda.bill.view.item.TyingItemView;
import com.didi.soda.bill.view.item.logic.ItemViewAbsLogic;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2;
import com.didi.soda.bill.view.item.logic.ItemViewTipsFeeLogic;
import com.didi.soda.bill.view.item.logic.ItemViewTotalPriceLogic;
import com.didi.soda.bill.view.item.tipfee.BillTipsFeeItemView;
import com.didi.soda.customer.foundation.rpc.ABConfigHelper;
import com.didi.soda.globalcart.view.BillItemsInfoItemView;
import com.didi.soda.globalcart.view.BillOutOfStockItemView;
import com.didi.soda.globalcart.view.BillTotalPriceItemView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/view/BillItemViewFactoryV2;", "", "()V", "createItemView", "Lcom/didi/soda/bill/view/BillItemView;", "component", "Lcom/didi/soda/bill/model/ComponentModel;", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "createTotalItemView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemViewFactoryV2.kt */
public final class BillItemViewFactoryV2 {
    public final BillItemView<?> createItemView(ComponentModel componentModel, Context context, ScopeContext scopeContext) {
        BillItemView<?> billItemView;
        Intrinsics.checkNotNullParameter(componentModel, "component");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        switch (componentModel.getType()) {
            case 1:
                billItemView = new BillReminderItemView(context, R.layout.customer_item_bill_small_tip_v2);
                billItemView.attach(componentModel, (ItemViewAbsLogic) null);
                break;
            case 2:
                BillItemView<?> billAddressItemViewV2 = new BillAddressItemViewV2(context);
                billAddressItemViewV2.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billAddressItemViewV2;
            case 3:
                billItemView = new BillDeliveryItemViewV2(context);
                billItemView.attach(componentModel, (ItemViewAbsLogic) null);
                break;
            case 4:
                BillItemView<?> billPayChannelItemView2 = new BillPayChannelItemView2(context);
                billPayChannelItemView2.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billPayChannelItemView2;
            case 5:
                BillItemView<?> billItemsInfoItemView = new BillItemsInfoItemView(context, true);
                billItemsInfoItemView.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billItemsInfoItemView;
            case 6:
            case 9:
            case 10:
            case 15:
                BillItemView<?> billCommonItemViewV2 = new BillCommonItemViewV2(context);
                billCommonItemViewV2.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billCommonItemViewV2;
            case 7:
                BillItemView<?> billTipsFeeItemView = new BillTipsFeeItemView(context);
                billTipsFeeItemView.attach(componentModel, new ItemViewTipsFeeLogic(scopeContext));
                return billTipsFeeItemView;
            case 8:
                BillItemView<?> billRemarkItemView2 = new BillRemarkItemView2(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                billRemarkItemView2.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billRemarkItemView2;
            case 11:
                BillItemView<?> billFollowItemViewV2 = new BillFollowItemViewV2(context);
                billFollowItemViewV2.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billFollowItemViewV2;
            case 12:
                return m27748a(componentModel, context, scopeContext);
            case 13:
                BillItemView<?> billOutOfStockItemView = new BillOutOfStockItemView(context, R.layout.customer_widget_cart_out_of_stock_view_v2);
                billOutOfStockItemView.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billOutOfStockItemView;
            case 18:
                billItemView = new EtaItemViewV2(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                billItemView.attach(componentModel, (ItemViewAbsLogic) null);
                break;
            case 19:
                BillItemView<?> billTitleInfoItemView = new BillTitleInfoItemView(context);
                billTitleInfoItemView.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billTitleInfoItemView;
            case 20:
                billItemView = new BillLineInfoView(context);
                billItemView.attach(componentModel, (ItemViewAbsLogic) null);
                break;
            case 21:
                BillItemView<?> billTablewareItemView = new BillTablewareItemView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                billTablewareItemView.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return billTablewareItemView;
            case 22:
                BillItemView<?> tyingItemView = new TyingItemView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                tyingItemView.attach(componentModel, new ItemViewCommonLogicV2(scopeContext));
                return tyingItemView;
            default:
                BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
                String simpleName = getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
                companion.trackBillTypeNotFound(simpleName, "type=" + componentModel.getType() + " not found,config=" + ABConfigHelper.Companion.getAllConfig());
                return null;
        }
        return billItemView;
    }

    /* renamed from: a */
    private final BillItemView<?> m27748a(ComponentModel componentModel, Context context, ScopeContext scopeContext) {
        int sourcePage = componentModel.getSourcePage();
        if (sourcePage == 1) {
            BillItemView<?> billTotalPriceItemView = new BillTotalPriceItemView(context);
            billTotalPriceItemView.attach(componentModel, (ItemViewAbsLogic) null);
            return billTotalPriceItemView;
        } else if (sourcePage != 2) {
            return null;
        } else {
            BillItemView<?> billTotalItemViewV2 = new BillTotalItemViewV2(context);
            billTotalItemViewV2.attach(componentModel, new ItemViewTotalPriceLogic(scopeContext));
            return billTotalItemViewV2;
        }
    }
}
