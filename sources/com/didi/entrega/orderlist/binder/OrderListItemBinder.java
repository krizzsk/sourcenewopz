package com.didi.entrega.orderlist.binder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.entrega.customer.foundation.rpc.entity.order.ButtonEntity;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.button.RFStyleButton;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J,\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0002H&J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0002H\u0002¨\u0006 "}, mo175978d2 = {"Lcom/didi/entrega/orderlist/binder/OrderListItemBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "Lcom/didi/entrega/orderlist/binder/OrderListItemHolder;", "()V", "bind", "", "holder", "item", "bindDataType", "Ljava/lang/Class;", "buttonGroupClick", "buttonEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ButtonEntity;", "itemEntity", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "createButton", "Landroid/view/View;", "context", "Landroid/content/Context;", "type", "", "isHighLight", "content", "", "goOrderPage", "itemModel", "onCardClick", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListItemBinder.kt */
public abstract class OrderListItemBinder extends ItemBinder<OrderListItemModel, OrderListItemHolder> {
    public Class<OrderListItemModel> bindDataType() {
        return OrderListItemModel.class;
    }

    public abstract void buttonGroupClick(ButtonEntity buttonEntity, OrderListItemModel orderListItemModel);

    public abstract void goOrderPage(OrderListItemModel orderListItemModel);

    public OrderListItemHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_binder_order_list_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…list_item, parent, false)");
        return new OrderListItemHolder(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        r1 = r1.getOrderInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bind(com.didi.entrega.orderlist.binder.OrderListItemHolder r7, com.didi.entrega.orderlist.binder.OrderListItemModel r8) {
        /*
            r6 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getServiceDescTv()
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r1 = r8.getData()
            r2 = 0
            if (r1 != 0) goto L_0x0017
        L_0x0015:
            r1 = r2
            goto L_0x0022
        L_0x0017:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r1 = r1.getOrderInfo()
            if (r1 != 0) goto L_0x001e
            goto L_0x0015
        L_0x001e:
            java.lang.String r1 = r1.getServiceDesc()
        L_0x0022:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getStatusTv()
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r1 = r8.getData()
            if (r1 != 0) goto L_0x0033
        L_0x0031:
            r1 = r2
            goto L_0x003e
        L_0x0033:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r1 = r1.getOrderInfo()
            if (r1 != 0) goto L_0x003a
            goto L_0x0031
        L_0x003a:
            java.lang.String r1 = r1.getStatusDesc()
        L_0x003e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r0 = r8.getData()
            r1 = 1
            r3 = 0
            if (r0 != 0) goto L_0x004d
        L_0x004b:
            r0 = 0
            goto L_0x005b
        L_0x004d:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r0 = r0.getOrderInfo()
            if (r0 != 0) goto L_0x0054
            goto L_0x004b
        L_0x0054:
            int r0 = r0.isComplete()
            if (r0 != r1) goto L_0x004b
            r0 = 1
        L_0x005b:
            if (r0 == 0) goto L_0x006c
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getStatusTv()
            r4 = 2131101459(0x7f060713, float:1.7815328E38)
            int r4 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r4)
            r0.setTextColor(r4)
            goto L_0x007a
        L_0x006c:
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getStatusTv()
            r4 = 2131101490(0x7f060732, float:1.7815391E38)
            int r4 = com.didi.entrega.customer.foundation.util.ResourceHelper.getColor(r4)
            r0.setTextColor(r4)
        L_0x007a:
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r0 = r8.getData()
            if (r0 != 0) goto L_0x0082
        L_0x0080:
            r0 = r2
            goto L_0x008d
        L_0x0082:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r0 = r0.getOrderInfo()
            if (r0 != 0) goto L_0x0089
            goto L_0x0080
        L_0x0089:
            java.lang.String r0 = r0.getCreateTime()
        L_0x008d:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x009a
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r0 = 0
            goto L_0x009b
        L_0x009a:
            r0 = 1
        L_0x009b:
            r4 = 8
            if (r0 != 0) goto L_0x00c3
            android.widget.LinearLayout r0 = r7.getOrderTimeLayout()
            r0.setVisibility(r3)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getOrderTimeTv()
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r5 = r8.getData()
            if (r5 != 0) goto L_0x00b2
        L_0x00b0:
            r5 = r2
            goto L_0x00bd
        L_0x00b2:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r5 = r5.getOrderInfo()
            if (r5 != 0) goto L_0x00b9
            goto L_0x00b0
        L_0x00b9:
            java.lang.String r5 = r5.getCreateTime()
        L_0x00bd:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            goto L_0x00ca
        L_0x00c3:
            android.widget.LinearLayout r0 = r7.getOrderTimeLayout()
            r0.setVisibility(r4)
        L_0x00ca:
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r0 = r8.getData()
            if (r0 != 0) goto L_0x00d2
        L_0x00d0:
            r0 = r2
            goto L_0x00dd
        L_0x00d2:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r0 = r0.getOrderInfo()
            if (r0 != 0) goto L_0x00d9
            goto L_0x00d0
        L_0x00d9:
            java.lang.String r0 = r0.getSenderAddressDisplay()
        L_0x00dd:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00ea
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00e8
            goto L_0x00ea
        L_0x00e8:
            r0 = 0
            goto L_0x00eb
        L_0x00ea:
            r0 = 1
        L_0x00eb:
            if (r0 != 0) goto L_0x0111
            android.widget.LinearLayout r0 = r7.getSenderLayout()
            r0.setVisibility(r3)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getSenderAddressTv()
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r5 = r8.getData()
            if (r5 != 0) goto L_0x0100
        L_0x00fe:
            r5 = r2
            goto L_0x010b
        L_0x0100:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r5 = r5.getOrderInfo()
            if (r5 != 0) goto L_0x0107
            goto L_0x00fe
        L_0x0107:
            java.lang.String r5 = r5.getSenderAddressDisplay()
        L_0x010b:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            goto L_0x0118
        L_0x0111:
            android.widget.LinearLayout r0 = r7.getSenderLayout()
            r0.setVisibility(r4)
        L_0x0118:
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r0 = r8.getData()
            if (r0 != 0) goto L_0x0120
        L_0x011e:
            r0 = r2
            goto L_0x012b
        L_0x0120:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r0 = r0.getOrderInfo()
            if (r0 != 0) goto L_0x0127
            goto L_0x011e
        L_0x0127:
            java.lang.String r0 = r0.getReceiverAddressDisplay()
        L_0x012b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0138
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r0 = 0
            goto L_0x0139
        L_0x0138:
            r0 = 1
        L_0x0139:
            if (r0 != 0) goto L_0x015f
            android.widget.LinearLayout r0 = r7.getReceiverLayout()
            r0.setVisibility(r3)
            com.didi.entrega.customer.widget.support.CustomerAppCompatTextView r0 = r7.getReceiverAddressTv()
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r5 = r8.getData()
            if (r5 != 0) goto L_0x014e
        L_0x014c:
            r5 = r2
            goto L_0x0159
        L_0x014e:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r5 = r5.getOrderInfo()
            if (r5 != 0) goto L_0x0155
            goto L_0x014c
        L_0x0155:
            java.lang.String r5 = r5.getReceiverAddressDisplay()
        L_0x0159:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            goto L_0x0166
        L_0x015f:
            android.widget.LinearLayout r0 = r7.getReceiverLayout()
            r0.setVisibility(r4)
        L_0x0166:
            android.view.View r0 = r7.getRootView()
            com.didi.entrega.orderlist.binder.-$$Lambda$OrderListItemBinder$05DadxnZIUTkq5SjPQ2jm1IYCDU r5 = new com.didi.entrega.orderlist.binder.-$$Lambda$OrderListItemBinder$05DadxnZIUTkq5SjPQ2jm1IYCDU
            r5.<init>(r8)
            r0.setOnClickListener(r5)
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r0 = r8.getData()
            if (r0 != 0) goto L_0x0179
            goto L_0x017d
        L_0x0179:
            java.util.List r2 = r0.getButtons()
        L_0x017d:
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0189
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0188
            goto L_0x0189
        L_0x0188:
            r1 = 0
        L_0x0189:
            if (r1 == 0) goto L_0x0193
            android.widget.LinearLayout r7 = r7.getButtonContainer()
            r7.setVisibility(r4)
            goto L_0x01f3
        L_0x0193:
            android.widget.LinearLayout r0 = r7.getButtonContainer()
            r0.setVisibility(r3)
            android.widget.LinearLayout r0 = r7.getButtonContainer()
            r0.removeAllViews()
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r0 = r8.getData()
            if (r0 != 0) goto L_0x01a8
            goto L_0x01f3
        L_0x01a8:
            java.util.List r0 = r0.getButtons()
            if (r0 != 0) goto L_0x01af
            goto L_0x01f3
        L_0x01af:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x01b5:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01f3
            java.lang.Object r1 = r0.next()
            com.didi.entrega.customer.foundation.rpc.entity.order.ButtonEntity r1 = (com.didi.entrega.customer.foundation.rpc.entity.order.ButtonEntity) r1
            android.widget.LinearLayout r2 = r7.getButtonContainer()
            android.content.Context r2 = r2.getContext()
            java.lang.String r3 = "holder.buttonContainer.context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            int r3 = r1.getType()
            int r4 = r1.getHighlight()
            java.lang.String r5 = r1.getName()
            android.view.View r2 = r6.createButton(r2, r3, r4, r5)
            if (r2 == 0) goto L_0x01e7
            android.widget.LinearLayout r3 = r7.getButtonContainer()
            r3.addView(r2)
        L_0x01e7:
            if (r2 != 0) goto L_0x01ea
            goto L_0x01b5
        L_0x01ea:
            com.didi.entrega.orderlist.binder.-$$Lambda$OrderListItemBinder$y5ArIrhiiZyrrmUW3i_F7Cvw3k4 r3 = new com.didi.entrega.orderlist.binder.-$$Lambda$OrderListItemBinder$y5ArIrhiiZyrrmUW3i_F7Cvw3k4
            r3.<init>(r1, r8)
            r2.setOnClickListener(r3)
            goto L_0x01b5
        L_0x01f3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.orderlist.binder.OrderListItemBinder.bind(com.didi.entrega.orderlist.binder.OrderListItemHolder, com.didi.entrega.orderlist.binder.OrderListItemModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m46405bind$lambda0(OrderListItemBinder orderListItemBinder, OrderListItemModel orderListItemModel, View view) {
        Intrinsics.checkNotNullParameter(orderListItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(orderListItemModel, "$item");
        orderListItemBinder.onCardClick(orderListItemModel);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-2$lambda-1  reason: not valid java name */
    public static final void m46406bind$lambda2$lambda1(OrderListItemBinder orderListItemBinder, ButtonEntity buttonEntity, OrderListItemModel orderListItemModel, View view) {
        Intrinsics.checkNotNullParameter(orderListItemBinder, "this$0");
        Intrinsics.checkNotNullParameter(buttonEntity, "$buttonEntity");
        Intrinsics.checkNotNullParameter(orderListItemModel, "$item");
        orderListItemBinder.buttonGroupClick(buttonEntity, orderListItemModel);
    }

    private final View createButton(Context context, int i, int i2, String str) {
        RFStyleButton rFStyleButton;
        CharSequence charSequence;
        if (i == 1) {
            rFStyleButton = new RFMainButton(context);
        } else if (i != 2) {
            rFStyleButton = null;
        } else {
            rFStyleButton = new RFGhostButton(context);
            if (i2 == 1) {
                ((RFGhostButton) rFStyleButton).setType(0);
            } else {
                ((RFGhostButton) rFStyleButton).setType(1);
            }
        }
        if (rFStyleButton != null) {
            rFStyleButton.setSpec(1);
        }
        if (rFStyleButton != null) {
            if (str != null) {
                charSequence = str;
            }
            rFStyleButton.setText(charSequence);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_218), -2);
        layoutParams.leftMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_8);
        if (rFStyleButton != null) {
            rFStyleButton.setLayoutParams(layoutParams);
        }
        return rFStyleButton;
    }

    private final void onCardClick(OrderListItemModel orderListItemModel) {
        goOrderPage(orderListItemModel);
    }
}
