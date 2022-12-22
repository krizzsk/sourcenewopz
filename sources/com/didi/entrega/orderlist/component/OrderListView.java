package com.didi.entrega.orderlist.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.pullToRefresh.IRefreshView;
import com.didi.app.nova.support.view.pullToRefresh.NovaPullRefreshLayout;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.entrega.customer.component.feed.base.FooterViewIView;
import com.didi.entrega.customer.component.feed.base.HeaderViewIView;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.widget.abnormal.AbnormalView;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.customer.widget.headerview.CustomerHeaderView;
import com.didi.entrega.orderlist.component.Contract;
import com.didi.entrega.orderlist.omega.OrderListOmegaHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0013H\u0014J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006#"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/OrderListView;", "Lcom/didi/entrega/orderlist/component/Contract$IOrderListView;", "()V", "abnormalView", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalView;", "pullToRefreshView", "Lcom/didi/app/nova/support/view/pullToRefresh/NovaPullRefreshLayout;", "recyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/NovaRecyclerView;", "footerViewMode", "Lcom/didi/entrega/customer/component/feed/base/FooterViewIView$Mode;", "generateHeaderView", "Lcom/didi/app/nova/support/view/pullToRefresh/IRefreshView;", "generateNovaRecyclerView", "Lcom/didi/app/nova/support/view/recyclerview/view/INovaRecyclerView;", "generatePullToRefreshView", "headerViewMode", "Lcom/didi/entrega/customer/component/feed/base/HeaderViewIView$Mode;", "hideAbnormalView", "", "hideGlobalLoading", "inflateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initItemBinders", "scrollToTop", "showGlobalLoading", "showNetError", "showNoData", "showServerError", "msg", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListView.kt */
public final class OrderListView extends Contract.IOrderListView {

    /* renamed from: a */
    private NovaRecyclerView f20985a;

    /* renamed from: b */
    private NovaPullRefreshLayout f20986b;

    /* renamed from: c */
    private AbnormalView f20987c;

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        NovaRecyclerView novaRecyclerView = this.f20985a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        return novaRecyclerView;
    }

    public NovaPullRefreshLayout generatePullToRefreshView() {
        NovaPullRefreshLayout novaPullRefreshLayout = this.f20986b;
        if (novaPullRefreshLayout != null) {
            return novaPullRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pullToRefreshView");
        return null;
    }

    public void showGlobalLoading() {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
    }

    public void hideGlobalLoading() {
        DialogUtil.hideLoadingDialog();
    }

    public void showNetError() {
        AbnormalView abnormalView = this.f20987c;
        AbnormalView abnormalView2 = null;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            abnormalView = null;
        }
        abnormalView.setVisibility(0);
        AbnormalView abnormalView3 = this.f20987c;
        if (abnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
        } else {
            abnormalView2 = abnormalView3;
        }
        abnormalView2.show(AbnormalViewModelFactory.buildNoNetwork(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderListView.m15361a(OrderListView.this, view);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15361a(OrderListView orderListView, View view) {
        Intrinsics.checkNotNullParameter(orderListView, "this$0");
        ((Contract.IOrderListPresenter) orderListView.getPresenter()).doRefresh((Bundle) null, false);
    }

    public void showNoData() {
        AbnormalView abnormalView = this.f20987c;
        AbnormalView abnormalView2 = null;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            abnormalView = null;
        }
        abnormalView.setVisibility(0);
        AbnormalView abnormalView3 = this.f20987c;
        if (abnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
        } else {
            abnormalView2 = abnormalView3;
        }
        abnormalView2.show(AbnormalViewModelFactory.buildOrderListNoData(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderListView.m15363b(OrderListView.this, view);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15363b(OrderListView orderListView, View view) {
        Intrinsics.checkNotNullParameter(orderListView, "this$0");
        ((Contract.IOrderListPresenter) orderListView.getPresenter()).doRefresh((Bundle) null, false);
    }

    public void showServerError(String str) {
        AbnormalView abnormalView = this.f20987c;
        AbnormalView abnormalView2 = null;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            abnormalView = null;
        }
        abnormalView.setVisibility(0);
        AbnormalView abnormalView3 = this.f20987c;
        if (abnormalView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
        } else {
            abnormalView2 = abnormalView3;
        }
        abnormalView2.show(AbnormalViewModelFactory.buildNoService(str, new View.OnClickListener() {
            public final void onClick(View view) {
                OrderListView.m15364c(OrderListView.this, view);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m15364c(OrderListView orderListView, View view) {
        Intrinsics.checkNotNullParameter(orderListView, "this$0");
        ((Contract.IOrderListPresenter) orderListView.getPresenter()).doRefresh((Bundle) null, false);
    }

    public void hideAbnormalView() {
        AbnormalView abnormalView = this.f20987c;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            abnormalView = null;
        }
        abnormalView.setVisibility(8);
    }

    public void scrollToTop() {
        NovaRecyclerView novaRecyclerView = this.f20985a;
        if (novaRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            novaRecyclerView = null;
        }
        novaRecyclerView.scrollToPosition(0);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.entrega_customer_component_order_list, viewGroup, true);
        View findViewById = inflate.findViewById(R.id.entrega_customer_order_list_prl);
        Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.ent…_customer_order_list_prl)");
        this.f20986b = (NovaPullRefreshLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.entrega_customer_order_list_recycler);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.ent…omer_order_list_recycler)");
        this.f20985a = (NovaRecyclerView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.entrega_customer_order_list_abnormal);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.ent…omer_order_list_abnormal)");
        AbnormalView abnormalView = (AbnormalView) findViewById3;
        this.f20987c = abnormalView;
        if (abnormalView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("abnormalView");
            abnormalView = null;
        }
        abnormalView.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return OrderListView.m15362a(OrderListView.this, view, motionEvent);
            }
        });
        View findViewById4 = inflate.findViewById(R.id.entrega_iv_page_back);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "it.findViewById(R.id.entrega_iv_page_back)");
        ((TextView) findViewById4).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderListView.m15365d(OrderListView.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(inflate, "from(container.context)\n…      }\n                }");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m15362a(OrderListView orderListView, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(orderListView, "this$0");
        if (motionEvent.getAction() == 1) {
            ((Contract.IOrderListPresenter) orderListView.getPresenter()).doRefresh(orderListView.getScopeContext().getBundle(), false);
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m15365d(OrderListView orderListView, View view) {
        Intrinsics.checkNotNullParameter(orderListView, "this$0");
        orderListView.getScopeContext().getNavigator().finish();
        OrderListOmegaHelper.Companion.getInstance().trackReturnBk();
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        registerBinder(new OrderListView$initItemBinders$1(this));
    }

    public HeaderViewIView.Mode headerViewMode() {
        return HeaderViewIView.Mode.ENABLED;
    }

    public IRefreshView generateHeaderView() {
        IRefreshView generateHeaderView = super.generateHeaderView();
        if (generateHeaderView != null) {
            CustomerHeaderView customerHeaderView = (CustomerHeaderView) generateHeaderView;
            customerHeaderView.changeStyle(CustomerHeaderView.HeaderStyle.GRAY);
            return customerHeaderView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.entrega.customer.widget.headerview.CustomerHeaderView");
    }

    public FooterViewIView.Mode footerViewMode() {
        return FooterViewIView.Mode.MULTI_COLOR;
    }
}
