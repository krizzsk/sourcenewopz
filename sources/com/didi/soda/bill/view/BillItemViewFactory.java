package com.didi.soda.bill.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.view.item.BillAddressItemView;
import com.didi.soda.bill.view.item.BillCommonItemView;
import com.didi.soda.bill.view.item.BillDeliveryItemView;
import com.didi.soda.bill.view.item.BillFollowItemView;
import com.didi.soda.bill.view.item.BillPayChannelItemView;
import com.didi.soda.bill.view.item.BillRemarkItemView;
import com.didi.soda.bill.view.item.BillReminderItemView;
import com.didi.soda.bill.view.item.BillTotalItemView;
import com.didi.soda.bill.view.item.EtaItemView;
import com.didi.soda.bill.view.item.logic.DefaultItemViewCommonLogic;
import com.didi.soda.bill.view.item.logic.ItemViewAbsLogic;
import com.didi.soda.bill.view.item.logic.ItemViewTotalPriceLogic;
import com.didi.soda.customer.foundation.rpc.ABConfigHelper;
import com.didi.soda.globalcart.view.BillItemsInfoItemView;
import com.didi.soda.globalcart.view.BillOutOfStockItemView;
import com.didi.soda.globalcart.view.BillTotalPriceItemView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ&\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/bill/view/BillItemViewFactory;", "", "()V", "createItemView", "Lcom/didi/soda/bill/view/BillItemView;", "component", "Lcom/didi/soda/bill/model/ComponentModel;", "context", "Landroid/content/Context;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "createTotalItemView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemViewFactory.kt */
public final class BillItemViewFactory {
    public final BillItemView<?> createItemView(ComponentModel componentModel, Context context, ScopeContext scopeContext) {
        BillItemView<?> etaItemView;
        Intrinsics.checkNotNullParameter(componentModel, "component");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        int type = componentModel.getType();
        if (type != 15) {
            if (type != 18) {
                switch (type) {
                    case 1:
                        etaItemView = new BillReminderItemView(context, R.layout.customer_item_bill_small_tip);
                        etaItemView.attach(componentModel, (ItemViewAbsLogic) null);
                        break;
                    case 2:
                        BillItemView<?> billAddressItemView = new BillAddressItemView(context);
                        billAddressItemView.attach(componentModel, new DefaultItemViewCommonLogic(scopeContext));
                        return billAddressItemView;
                    case 3:
                        etaItemView = new BillDeliveryItemView(context);
                        etaItemView.attach(componentModel, (ItemViewAbsLogic) null);
                        break;
                    case 4:
                        BillItemView<?> billPayChannelItemView = new BillPayChannelItemView(context);
                        billPayChannelItemView.attach(componentModel, new DefaultItemViewCommonLogic(scopeContext));
                        return billPayChannelItemView;
                    case 5:
                        BillItemView<?> billItemsInfoItemView = new BillItemsInfoItemView(context, false, 2, (DefaultConstructorMarker) null);
                        billItemsInfoItemView.attach(componentModel, new DefaultItemViewCommonLogic(scopeContext));
                        return billItemsInfoItemView;
                    case 6:
                    case 7:
                    case 9:
                    case 10:
                        break;
                    case 8:
                        BillItemView<?> billRemarkItemView = new BillRemarkItemView(context);
                        billRemarkItemView.attach(componentModel, new DefaultItemViewCommonLogic(scopeContext));
                        return billRemarkItemView;
                    case 11:
                        etaItemView = new BillFollowItemView(context);
                        etaItemView.attach(componentModel, (ItemViewAbsLogic) null);
                        break;
                    case 12:
                        return m27747a(componentModel, context, scopeContext);
                    case 13:
                        BillItemView<?> billOutOfStockItemView = new BillOutOfStockItemView(context, R.layout.customer_widget_cart_out_of_stock_view);
                        billOutOfStockItemView.attach(componentModel, new DefaultItemViewCommonLogic(scopeContext));
                        return billOutOfStockItemView;
                    default:
                        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
                        String simpleName = getClass().getSimpleName();
                        Intrinsics.checkNotNullExpressionValue(simpleName, "this.javaClass.simpleName");
                        companion.trackBillTypeNotFound(simpleName, "type=" + componentModel.getType() + " not found,config=" + ABConfigHelper.Companion.getAllConfig());
                        return null;
                }
            } else {
                etaItemView = new EtaItemView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                etaItemView.attach(componentModel, (ItemViewAbsLogic) null);
            }
            return etaItemView;
        }
        BillItemView<?> billCommonItemView = new BillCommonItemView(context);
        billCommonItemView.attach(componentModel, new DefaultItemViewCommonLogic(scopeContext));
        return billCommonItemView;
    }

    /* renamed from: a */
    private final BillItemView<?> m27747a(ComponentModel componentModel, Context context, ScopeContext scopeContext) {
        int sourcePage = componentModel.getSourcePage();
        if (sourcePage == 1) {
            BillItemView<?> billTotalPriceItemView = new BillTotalPriceItemView(context);
            billTotalPriceItemView.attach(componentModel, (ItemViewAbsLogic) null);
            return billTotalPriceItemView;
        } else if (sourcePage != 2) {
            return null;
        } else {
            BillItemView<?> billTotalItemView = new BillTotalItemView(context);
            billTotalItemView.attach(componentModel, new ItemViewTotalPriceLogic(scopeContext));
            return billTotalItemView;
        }
    }
}
