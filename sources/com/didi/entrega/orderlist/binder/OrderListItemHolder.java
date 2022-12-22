package com.didi.entrega.orderlist.binder;

import android.view.View;
import android.widget.LinearLayout;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0005R\u001a\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014R\u001a\u0010\"\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001a\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\u001a\u0010(\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006+"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/binder/OrderListItemHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "buttonContainer", "Landroid/widget/LinearLayout;", "getButtonContainer", "()Landroid/widget/LinearLayout;", "setButtonContainer", "(Landroid/widget/LinearLayout;)V", "orderTimeLayout", "getOrderTimeLayout", "setOrderTimeLayout", "orderTimeTv", "Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "getOrderTimeTv", "()Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;", "setOrderTimeTv", "(Lcom/didi/entrega/customer/widget/support/CustomerAppCompatTextView;)V", "receiverAddressTv", "getReceiverAddressTv", "setReceiverAddressTv", "receiverLayout", "getReceiverLayout", "setReceiverLayout", "rootView", "getRootView", "()Landroid/view/View;", "setRootView", "senderAddressTv", "getSenderAddressTv", "setSenderAddressTv", "senderLayout", "getSenderLayout", "setSenderLayout", "serviceDescTv", "getServiceDescTv", "setServiceDescTv", "statusTv", "getStatusTv", "setStatusTv", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListItemBinder.kt */
public final class OrderListItemHolder extends ItemViewHolder<OrderListItemModel> {

    /* renamed from: a */
    private View f20965a;

    /* renamed from: b */
    private CustomerAppCompatTextView f20966b;

    /* renamed from: c */
    private CustomerAppCompatTextView f20967c;

    /* renamed from: d */
    private LinearLayout f20968d;

    /* renamed from: e */
    private CustomerAppCompatTextView f20969e;

    /* renamed from: f */
    private LinearLayout f20970f;

    /* renamed from: g */
    private CustomerAppCompatTextView f20971g;

    /* renamed from: h */
    private LinearLayout f20972h;

    /* renamed from: i */
    private CustomerAppCompatTextView f20973i;

    /* renamed from: j */
    private LinearLayout f20974j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderListItemHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.entrega_customer_order_item_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…stomer_order_item_layout)");
        this.f20965a = findViewById;
        View findViewById2 = view.findViewById(R.id.entrega_customer_order_item_service_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…er_order_item_service_tv)");
        this.f20966b = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.entrega_customer_order_item_status_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…mer_order_item_status_tv)");
        this.f20967c = (CustomerAppCompatTextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.entrega_customer_order_item_time_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.…tomer_order_item_time_ll)");
        this.f20968d = (LinearLayout) findViewById4;
        View findViewById5 = view.findViewById(R.id.entrega_customer_order_item_time_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.…tomer_order_item_time_tv)");
        this.f20969e = (CustomerAppCompatTextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.entrega_customer_order_item_sender_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.…mer_order_item_sender_ll)");
        this.f20970f = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.entrega_customer_order_item_sender_address);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.…rder_item_sender_address)");
        this.f20971g = (CustomerAppCompatTextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.entrega_customer_order_item_receiver_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.…r_order_item_receiver_ll)");
        this.f20972h = (LinearLayout) findViewById8;
        View findViewById9 = view.findViewById(R.id.entrega_customer_item_receiver_address);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.…er_item_receiver_address)");
        this.f20973i = (CustomerAppCompatTextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.entrega_customer_item_button_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.…_customer_item_button_ll)");
        this.f20974j = (LinearLayout) findViewById10;
    }

    public final View getRootView() {
        return this.f20965a;
    }

    public final void setRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.f20965a = view;
    }

    public final CustomerAppCompatTextView getServiceDescTv() {
        return this.f20966b;
    }

    public final void setServiceDescTv(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.f20966b = customerAppCompatTextView;
    }

    public final CustomerAppCompatTextView getStatusTv() {
        return this.f20967c;
    }

    public final void setStatusTv(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.f20967c = customerAppCompatTextView;
    }

    public final LinearLayout getOrderTimeLayout() {
        return this.f20968d;
    }

    public final void setOrderTimeLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.f20968d = linearLayout;
    }

    public final CustomerAppCompatTextView getOrderTimeTv() {
        return this.f20969e;
    }

    public final void setOrderTimeTv(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.f20969e = customerAppCompatTextView;
    }

    public final LinearLayout getSenderLayout() {
        return this.f20970f;
    }

    public final void setSenderLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.f20970f = linearLayout;
    }

    public final CustomerAppCompatTextView getSenderAddressTv() {
        return this.f20971g;
    }

    public final void setSenderAddressTv(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.f20971g = customerAppCompatTextView;
    }

    public final LinearLayout getReceiverLayout() {
        return this.f20972h;
    }

    public final void setReceiverLayout(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.f20972h = linearLayout;
    }

    public final CustomerAppCompatTextView getReceiverAddressTv() {
        return this.f20973i;
    }

    public final void setReceiverAddressTv(CustomerAppCompatTextView customerAppCompatTextView) {
        Intrinsics.checkNotNullParameter(customerAppCompatTextView, "<set-?>");
        this.f20973i = customerAppCompatTextView;
    }

    public final LinearLayout getButtonContainer() {
        return this.f20974j;
    }

    public final void setButtonContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.f20974j = linearLayout;
    }
}
