package com.didi.soda.order.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.didi.soda.order.view.OrderReceiptFrameLayout;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class OrderReceiptFrameLayout extends FrameLayout {

    /* renamed from: a */
    private TextView f43617a;

    /* renamed from: b */
    private LottieLoadingView f43618b;

    public OrderReceiptFrameLayout(Context context) {
        super(context);
        m30910a();
    }

    public OrderReceiptFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30910a();
    }

    public OrderReceiptFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30910a();
    }

    public void updateViewState(OrderReceiptViewModel orderReceiptViewModel) {
        if (OrderReceiptViewModel.showReceipt(orderReceiptViewModel)) {
            setVisibility(0);
            setOnClickListener(new View.OnClickListener(orderReceiptViewModel) {
                public final /* synthetic */ OrderReceiptFrameLayout.OrderReceiptViewModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    OrderReceiptFrameLayout.this.m30911a(this.f$1, view);
                }
            });
            return;
        }
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30911a(final OrderReceiptViewModel orderReceiptViewModel, View view) {
        if (!ClickUtils.isFastClick()) {
            m30913b();
            CustomerRpcManagerProxy.get().getReceiptInfo(new CustomerRpcCallback<OrderReceiptInfoEntity>() {
                public void onRpcSuccess(OrderReceiptInfoEntity orderReceiptInfoEntity, long j) {
                    OrderReceiptFrameLayout.this.m30914c();
                    if (orderReceiptInfoEntity != null) {
                        if (TextUtils.isEmpty(orderReceiptInfoEntity.email)) {
                            LoginUtil.go2ModifyEmail(OrderReceiptFrameLayout.this.getContext(), new LoginCallbacks.ModifyEmailListener() {
                                public void onCancel() {
                                }

                                public void onSuccess(Activity activity) {
                                }
                            });
                        } else {
                            DiRouter.request().path(RoutePath.SEND_RECEIPT).putString("orderid", orderReceiptViewModel.orderId).putInt(Const.PageParams.ORDER_RECEIPT_STATE, orderReceiptViewModel.status).putString("from", orderReceiptViewModel.fromPage).putInt(Const.PageParams.RECEIPT_PAGE_TYPE, orderReceiptViewModel.receiptPageType).putSerializable(Const.PageParams.RECEIPT_ENTITIES, orderReceiptInfoEntity).open();
                        }
                    }
                }

                public void onRpcFailure(SFRpcException sFRpcException) {
                    OrderReceiptFrameLayout.this.m30914c();
                }
            });
        }
    }

    /* renamed from: a */
    private void m30910a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_order_receipt_container, this, true);
        this.f43617a = (TextView) inflate.findViewById(R.id.customer_tv_send_receipt);
        this.f43618b = (LottieLoadingView) inflate.findViewById(R.id.customer_custom_loading);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f43617a, IToolsService.FontType.MEDIUM);
    }

    /* renamed from: b */
    private void m30913b() {
        this.f43617a.setVisibility(4);
        this.f43618b.setVisibility(0);
        this.f43618b.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30914c() {
        this.f43617a.setVisibility(0);
        this.f43618b.setVisibility(4);
        this.f43618b.stop();
    }

    public static class OrderReceiptViewModel {
        String fromPage;
        String orderId;
        int receiptPageType;
        int status;

        public static OrderReceiptViewModel newInstance(int i, String str, int i2) {
            OrderReceiptViewModel orderReceiptViewModel = new OrderReceiptViewModel();
            orderReceiptViewModel.status = i;
            orderReceiptViewModel.orderId = str;
            orderReceiptViewModel.receiptPageType = i2;
            return orderReceiptViewModel;
        }

        public static boolean showReceipt(OrderReceiptViewModel orderReceiptViewModel) {
            return orderReceiptViewModel != null && orderReceiptViewModel.status > 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OrderReceiptViewModel)) {
                return false;
            }
            OrderReceiptViewModel orderReceiptViewModel = (OrderReceiptViewModel) obj;
            if (this.status != orderReceiptViewModel.status || this.receiptPageType != orderReceiptViewModel.receiptPageType) {
                return false;
            }
            String str = this.orderId;
            if (str == null ? orderReceiptViewModel.orderId != null : !str.equals(orderReceiptViewModel.orderId)) {
                return false;
            }
            String str2 = this.fromPage;
            String str3 = orderReceiptViewModel.fromPage;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = this.status * 31;
            String str = this.orderId;
            int i2 = 0;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.fromPage;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            return ((hashCode + i2) * 31) + this.receiptPageType;
        }
    }
}
