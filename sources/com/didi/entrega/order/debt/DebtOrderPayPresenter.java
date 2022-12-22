package com.didi.entrega.order.debt;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.customer.pay.ValidateCardHelper;
import com.didi.entrega.foundation.rpc.entity.DebtRepayEntity;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.manager.base.ICustomerPayManager;
import com.didi.entrega.order.debt.Contract;
import com.didi.entrega.order.omega.OrderOmegaHelper;
import com.didi.entrega.pay.PayMethodPage;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import com.taxis99.R;

public class DebtOrderPayPresenter extends Contract.AbsDebtOrderPayPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private int f20878a;

    /* renamed from: b */
    private String f20879b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PayChannel f20880c;

    /* renamed from: d */
    private String f20881d;

    /* renamed from: e */
    private String f20882e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f20883f = true;

    /* renamed from: g */
    private int f20884g = 0;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void closePage() {
        if (this.f20883f) {
            dismiss(getScopeContext());
        }
    }

    public void pay() {
        if (this.f20880c == null) {
            ToastUtil.showCustomerErrorToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_unpaid_Please_select_dAPg));
            return;
        }
        this.f20883f = false;
        ((Contract.AbsDebtOrderPayView) getLogicView()).setLoading(true);
        CustomerRpcManagerProxy.get().debtRepay(this.f20881d, this.f20882e, this.f20880c, DeviceTokenWrapper.getInstance().getDeviceToken(), new CustomerRpcCallback<DebtRepayEntity>() {
            public void onRpcSuccess(DebtRepayEntity debtRepayEntity, long j) {
                if (debtRepayEntity == null || TextUtils.isEmpty(debtRepayEntity.transId)) {
                    ((Contract.AbsDebtOrderPayView) DebtOrderPayPresenter.this.getLogicView()).setLoading(false);
                    boolean unused = DebtOrderPayPresenter.this.f20883f = true;
                    return;
                }
                DebtOrderPayPresenter.this.m15296a(debtRepayEntity.transId);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                ((Contract.AbsDebtOrderPayView) DebtOrderPayPresenter.this.getLogicView()).setLoading(false);
                boolean unused = DebtOrderPayPresenter.this.f20883f = true;
                if (sFRpcException == null) {
                    ToastUtil.showCustomerErrorToast(DebtOrderPayPresenter.this.getScopeContext(), ResourceHelper.getString(R.string.FoodC_unpaid_Request_failed_jlJL));
                } else if (sFRpcException.getCode() != 48201 || DebtOrderPayPresenter.this.f20880c == null) {
                    ToastUtil.showCustomerErrorToast(DebtOrderPayPresenter.this.getScopeContext(), TextUtils.isEmpty(sFRpcException.getMessage()) ? ResourceHelper.getString(R.string.FoodC_unpaid_Request_failed_jlJL) : sFRpcException.getMessage());
                } else {
                    ValidateCardHelper.validateCard(DebtOrderPayPresenter.this.f20880c.getCardSuffix(), DebtOrderPayPresenter.this.f20880c.getCardIndex(), -1);
                }
            }
        });
    }

    public void selectPayMethod() {
        Bundle bundle = new Bundle();
        bundle.putInt("pay_scene", 1);
        bundle.putInt("pay_method_price", this.f20878a);
        PayMethodPage.toPayMethod(getScopeContext(), this.f20878a, 1, "", this.f20880c);
    }

    public void onPageResult(Bundle bundle) {
        if (bundle != null) {
            PayChannel payChannel = (PayChannel) bundle.getSerializable("payMethodPage");
            this.f20880c = payChannel;
            if (payChannel != null) {
                ((Contract.AbsDebtOrderPayView) getLogicView()).setPayInfo(this.f20881d, this.f20879b, this.f20880c);
            }
        }
    }

    public boolean onHandleBack() {
        return !this.f20883f;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        try {
            this.f20880c = (PayChannel) GsonUtils.fromJson(GsonUtils.toJson(bundle.getSerializable("payChannel")), PayChannel.class);
        } catch (Exception unused) {
            this.f20880c = null;
        }
        this.f20879b = bundle.getString("unpaidMoneyDisplay", "");
        this.f20878a = bundle.getInt("unpaidMoney", 0);
        this.f20881d = bundle.getString("orderId", "");
        this.f20882e = bundle.getString("debtId", "");
        this.f20884g = bundle.getInt(Const.FlutterBundleKey.Order_STATUS, 0);
        OrderOmegaHelper.INSTANCE.traceDebtSW(this.f20881d, Integer.valueOf(this.f20884g));
        ((Contract.AbsDebtOrderPayView) getLogicView()).setPayInfo(this.f20881d, this.f20879b, this.f20880c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15291a() {
        ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderInfoById(this.f20881d, 6);
        dismiss(getScopeContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15296a(String str) {
        OrderOmegaHelper.INSTANCE.traceDebtCK(this.f20881d, Integer.valueOf(this.f20884g));
        ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
        payParamEntity.token = LoginUtil.getToken();
        payParamEntity.transId = str;
        ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).getPayStatus((Activity) getContext(), getScopeContext(), payParamEntity, new ICustomerPayManager.PayCallback() {
            public void onThirdPayStart(int i) {
            }

            public void payFail(int i, String str) {
                boolean unused = DebtOrderPayPresenter.this.f20883f = true;
                DebtOrderPayPresenter.this.m15292a(i, str);
            }

            public void paySucceed() {
                boolean unused = DebtOrderPayPresenter.this.f20883f = true;
                DebtOrderPayPresenter.this.m15291a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15292a(final int i, final String str) {
        CustomerRpcManagerProxy.get().postDebtRepayFail(this.f20881d, this.f20882e, new CustomerRpcCallback<OrderCreateEntity>() {
            public void onRpcSuccess(OrderCreateEntity orderCreateEntity, long j) {
                DebtOrderPayPresenter.this.m15298b(i, str);
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                DebtOrderPayPresenter.this.m15298b(i, str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m15298b(int i, String str) {
        ScopeContext scopeContext = getScopeContext();
        if (TextUtils.isEmpty(str)) {
            str = ResourceHelper.getString(R.string.FoodC_remind_Unable_to_Wjlz);
        }
        DialogUtil.showDebtPayFailDialog(scopeContext, str, new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                DebtOrderPayPresenter.this.m15295a(rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15295a(RFDialog rFDialog) {
        m15291a();
    }
}
