package com.didi.soda.order.component.receipt;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.order.binder.receipt.OrderReceiptInputLogicRepo;
import com.didi.soda.order.component.receipt.Contract;
import com.didi.soda.order.model.OrderReceiptHeaderRvModel;
import com.didi.soda.order.model.OrderReceiptInputRvModel;
import com.taxis99.R;
import java.util.ArrayList;

/* renamed from: com.didi.soda.order.component.receipt.a */
/* compiled from: OrderReceiptPresenter */
class C14122a extends Contract.AbsOrderReceiptPresenter {

    /* renamed from: a */
    private static final String f43450a = "OrderDetailPresenter";

    /* renamed from: b */
    private String f43451b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f43452c = "";

    /* renamed from: d */
    private int f43453d = 0;

    /* renamed from: e */
    private OrderReceiptInfoEntity f43454e;

    /* renamed from: f */
    private ChildDataListManager<RecyclerModel> f43455f;

    /* renamed from: g */
    private boolean f43456g;

    /* renamed from: h */
    private String f43457h;

    /* renamed from: i */
    private ComponentLogicUnit f43458i;

    C14122a() {
    }

    public void onCreate() {
        super.onCreate();
        m30773d();
        m30772c();
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        if (this.f43458i == null) {
            this.f43458i = new OrderReceiptPresenter$1(this);
        }
        return this.f43458i;
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f43455f == null) {
            ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
            this.f43455f = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    /* access modifiers changed from: package-private */
    public void onConformClicked() {
        if (this.f43456g) {
            m30771b();
        } else {
            m30765a();
        }
    }

    /* access modifiers changed from: package-private */
    public void goBack() {
        ((Contract.AbsOrderReceiptView) getLogicView()).hideSoftInput();
        getScopeContext().getNavigator().finish();
    }

    /* renamed from: a */
    private void m30765a() {
        ((Contract.AbsOrderReceiptView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().saveReceiptInfo(this.f43457h, this.f43452c, new OrderReceiptPresenter$2(this));
    }

    /* renamed from: b */
    private void m30771b() {
        ((Contract.AbsOrderReceiptView) getLogicView()).showLoading();
        CustomerRpcManagerProxy.get().sendReceipt(this.f43451b, this.f43452c, this.f43457h, new OrderReceiptPresenter$3(this));
    }

    /* renamed from: c */
    private void m30772c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OrderReceiptHeaderRvModel());
        arrayList.add(OrderReceiptInputRvModel.newInstance(this.f43454e, this.f43456g));
        arrayList.add(m30777h());
        this.f43455f.set(arrayList);
        this.f43457h = this.f43454e.receiptUp;
        this.f43452c = this.f43454e.email;
        ((Contract.AbsOrderReceiptView) getLogicView()).updateViewStyle(this.f43456g);
        m30778i();
    }

    /* renamed from: d */
    private void m30773d() {
        Bundle bundle = getScopeContext().getBundle();
        this.f43451b = bundle.getString("orderid");
        this.f43453d = bundle.getInt(Const.PageParams.ORDER_RECEIPT_STATE);
        boolean z = true;
        if (bundle.getInt(Const.PageParams.RECEIPT_PAGE_TYPE) != 1) {
            z = false;
        }
        this.f43456g = z;
        this.f43454e = (OrderReceiptInfoEntity) bundle.getSerializable(Const.PageParams.RECEIPT_ENTITIES);
        m30774e();
    }

    /* renamed from: e */
    private void m30774e() {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_SEND_RECEIPT_SW).addEventParam("order_id", this.f43451b).addEventParam(ParamConst.PARAM_RECEIPT_STATUS, Integer.valueOf(this.f43453d)).build().track();
    }

    /* renamed from: f */
    private void m30775f() {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_SEND_RECEIPT_CK).addEventParam("order_id", this.f43451b).addEventParam(ParamConst.PARAM_RECEIPT_STATUS, Integer.valueOf(this.f43453d)).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m30776g() {
        OmegaTracker.Builder.create(EventConst.Order.ORDER_SEND_RECEIPT_SUCCESS_SW).addEventParam("order_id", this.f43451b).build().track();
    }

    /* renamed from: h */
    private CustomerDividerLineRvModel m30777h() {
        return new CustomerDividerLineRvModel(DisplayUtils.dip2px(getContext(), 100.0f), 0, 0, getContext().getResources().getColor(R.color.rf_color_white_100_FFFFFF));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30766a(OrderReceiptInputLogicRepo.ReceiptInputLogicModel receiptInputLogicModel) {
        if (receiptInputLogicModel != null) {
            if (receiptInputLogicModel.logicType == 0) {
                LoginUtil.go2ModifyEmail(getContext(), new OrderReceiptPresenter$4(this));
            } else if (receiptInputLogicModel.logicType == 1) {
                this.f43457h = receiptInputLogicModel.receiptName != null ? receiptInputLogicModel.receiptName.toString() : "";
                m30778i();
            }
        }
    }

    /* renamed from: i */
    private void m30778i() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f43457h);
        boolean z3 = this.f43454e.status == 1;
        if (!z2 || !z3) {
            z = false;
        }
        ((Contract.AbsOrderReceiptView) getLogicView()).updateConfirmButtonState(z, new View.OnClickListener(z, z2, z3) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ boolean f$2;
            public final /* synthetic */ boolean f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(View view) {
                C14122a.this.m30769a(this.f$1, this.f$2, this.f$3, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30769a(boolean z, boolean z2, boolean z3, View view) {
        if (z) {
            onConformClicked();
        } else {
            ((OrderReceiptInputLogicRepo) getComponentLogicUnit().getLogic(OrderReceiptInputLogicRepo.class)).setValue(OrderReceiptInputLogicRepo.ReceiptInputLogicModel.newValidStateChangedModel(z2, z3));
        }
    }
}
