package com.didi.global.fintech.cashier.fastpay.presenter;

import android.content.Context;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierBaseView;
import com.didi.global.fintech.cashier.core.interceptor.CashierActionInterceptor;
import com.didi.global.fintech.cashier.fastpay.api.IFastPayOrderProcessor;
import com.didi.global.fintech.cashier.fastpay.consts.FastPayStatus;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayBaseViewBinder;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayCallback;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderPresenter;
import com.didi.global.fintech.cashier.fastpay.contract.IFastPayOrderView;
import com.didi.global.fintech.cashier.fastpay.omega.FastPayOmegaConstants;
import com.didi.global.fintech.cashier.fastpay.viewbinder.order.FastPayOrderBtnVB;
import com.didi.global.fintech.cashier.fastpay.viewbinder.order.FastPayOrderContentVB;
import com.didi.global.fintech.cashier.fastpay.viewbinder.order.FastPayOrderHeaderVB;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.fastpay.ChangePayOrderRequest;
import com.didi.global.fintech.cashier.model.net.request.fastpay.DeductionChannel;
import com.didi.global.fintech.cashier.model.net.request.fastpay.FastPayInfoRequest;
import com.didi.global.fintech.cashier.model.net.response.fastpay.ChangePayOrderResponse;
import com.didi.global.fintech.cashier.model.net.response.fastpay.Deduction;
import com.didi.global.fintech.cashier.model.net.response.fastpay.DeductionPayChannel;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayOrderResponse;
import com.didi.global.fintech.cashier.p117ui.omega.CashierOmegaUtils;
import com.didi.global.fintech.cashier.p117ui.viewholder.OrderType;
import com.didi.global.fintech.cashier.user.model.FastPayParam;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\u0012\u0010!\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\""}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayOrderPresenter;", "Lcom/didi/global/fintech/cashier/fastpay/presenter/FastPayBasePresenter;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayOrderResponse;", "Lcom/didi/global/fintech/cashier/fastpay/api/IFastPayOrderProcessor;", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderPresenter;", "context", "Landroid/content/Context;", "callback", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCallback;", "(Landroid/content/Context;Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayCallback;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "IView", "Lcom/didi/global/fintech/cashier/fastpay/contract/IFastPayOrderView;", "bindView", "", "view", "Lcom/didi/global/fintech/cashier/core/contract/IGlobalCashierBaseView;", "onAddCardClick", "onBackPressed", "onBind", "onChangeOrderChangeSuccess", "response", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/ChangePayOrderResponse;", "onConfirmBtnClick", "onPayOrderSuccess", "showLastMethodToast", "toast", "unBind", "updateTitle", "cashier_fastpay_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FastPayOrderPresenter.kt */
public final class FastPayOrderPresenter extends FastPayBasePresenter<FastPayOrderResponse> implements IFastPayOrderProcessor, IFastPayOrderPresenter {

    /* renamed from: a */
    private final IFastPayCallback f21583a;

    /* renamed from: b */
    private String f21584b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPayOrderPresenter(Context context, IFastPayCallback iFastPayCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iFastPayCallback, "callback");
        this.f21583a = iFastPayCallback;
    }

    public final String getTitle() {
        return this.f21584b;
    }

    public final void setTitle(String str) {
        this.f21584b = str;
    }

    public void updateTitle(String str) {
        this.f21584b = str;
    }

    public void bindView(IGlobalCashierBaseView iGlobalCashierBaseView) {
        Object obj;
        super.bindView(iGlobalCashierBaseView);
        IFastPayOrderPresenter iFastPayOrderPresenter = this;
        FastPayOrderHeaderVB fastPayOrderHeaderVB = new FastPayOrderHeaderVB(iFastPayOrderPresenter);
        IFastPayOrderView IView = IView();
        FastPayOrderHeaderVB fastPayOrderHeaderVB2 = null;
        fastPayOrderHeaderVB.viewBind(IView == null ? null : IView.headerView());
        FastPayOrderContentVB fastPayOrderContentVB = new FastPayOrderContentVB(iFastPayOrderPresenter);
        IFastPayOrderView IView2 = IView();
        fastPayOrderContentVB.viewBind(IView2 == null ? null : IView2.contentView());
        FastPayOrderBtnVB fastPayOrderBtnVB = new FastPayOrderBtnVB(iFastPayOrderPresenter);
        IFastPayOrderView IView3 = IView();
        fastPayOrderBtnVB.viewBind(IView3 == null ? null : IView3.payBtnView());
        Iterator it = this.f21566a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IFastPayBaseViewBinder) obj) instanceof FastPayOrderHeaderVB) {
                break;
            }
        }
        IFastPayBaseViewBinder iFastPayBaseViewBinder = (IFastPayBaseViewBinder) obj;
        if (iFastPayBaseViewBinder instanceof FastPayOrderHeaderVB) {
            fastPayOrderHeaderVB2 = iFastPayBaseViewBinder;
        }
        FastPayOrderHeaderVB fastPayOrderHeaderVB3 = fastPayOrderHeaderVB2;
        if (fastPayOrderHeaderVB3 != null) {
            fastPayOrderHeaderVB3.updateHeader(this.f21584b);
        }
    }

    public void onBind() {
        super.onBind();
        registerProcessor(this, IFastPayOrderProcessor.class);
        String str = null;
        FastPayInfoRequest fastPayInfoRequest = new FastPayInfoRequest((String) null, 1, (DefaultConstructorMarker) null);
        FastPayParam fastPayParam = getFastPayParam();
        if (fastPayParam != null) {
            str = fastPayParam.getProductId();
        }
        fastPayInfoRequest.setProduct_id(str);
        Unit unit = Unit.INSTANCE;
        requestFastPayOrder(fastPayInfoRequest);
    }

    public void onConfirmBtnClick() {
        Object obj;
        Object obj2;
        FastPayBasePresenter fastPayBasePresenter = this;
        Iterator it = fastPayBasePresenter.f21566a.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((IFastPayBaseViewBinder) obj) instanceof FastPayOrderContentVB) {
                break;
            }
        }
        IFastPayBaseViewBinder iFastPayBaseViewBinder = (IFastPayBaseViewBinder) obj;
        if (!(iFastPayBaseViewBinder instanceof FastPayOrderContentVB)) {
            iFastPayBaseViewBinder = null;
        }
        FastPayOrderContentVB fastPayOrderContentVB = (FastPayOrderContentVB) iFastPayBaseViewBinder;
        List<DeductionChannel> orderItemsByType = fastPayOrderContentVB == null ? null : fastPayOrderContentVB.getOrderItemsByType(OrderType.Deduction);
        Iterator it2 = fastPayBasePresenter.f21566a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (((IFastPayBaseViewBinder) obj2) instanceof FastPayOrderContentVB) {
                break;
            }
        }
        IFastPayBaseViewBinder iFastPayBaseViewBinder2 = (IFastPayBaseViewBinder) obj2;
        if (!(iFastPayBaseViewBinder2 instanceof FastPayOrderContentVB)) {
            iFastPayBaseViewBinder2 = null;
        }
        FastPayOrderContentVB fastPayOrderContentVB2 = (FastPayOrderContentVB) iFastPayBaseViewBinder2;
        List<DeductionChannel> orderItemsByType2 = fastPayOrderContentVB2 == null ? null : fastPayOrderContentVB2.getOrderItemsByType(OrderType.NoDeduction);
        ChangePayOrderRequest changePayOrderRequest = new ChangePayOrderRequest((List) null, (List) null, 3, (DefaultConstructorMarker) null);
        changePayOrderRequest.setAuto_deduction_channel_list(orderItemsByType);
        changePayOrderRequest.setNon_auto_deduction_channel_list(orderItemsByType2);
        Unit unit = Unit.INSTANCE;
        changeFastPayOrder(changePayOrderRequest);
        CashierOmegaUtils cashierOmegaUtils = new CashierOmegaUtils(FastPayOmegaConstants.EVENT_ORDER_CONFIRM_CK);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("auto_deduction_channel_list", orderItemsByType);
        linkedHashMap.put("non_auto_deduction_channel_list", orderItemsByType2);
        Unit unit2 = Unit.INSTANCE;
        cashierOmegaUtils.addParam("list", linkedHashMap.toString()).send();
    }

    public void onAddCardClick() {
        CashierActionInterceptor actionInterceptor = getActionInterceptor();
        if (actionInterceptor != null) {
            actionInterceptor.intercept(getContext(), CashierAction.Companion.insAddCard(getMProductId(), getMAppId()), (Function0<Unit>[]) new Function0[]{new FastPayOrderPresenter$onAddCardClick$1(this)});
        }
        CashierOmegaUtils.Companion.trackEvent(FastPayOmegaConstants.EVENT_ORDER_ADD_CARD_CK);
    }

    public void onBackPressed() {
        this.f21583a.onClose(getRefreshed(), getCurFastPayStatus());
    }

    public void onPayOrderSuccess(FastPayOrderResponse fastPayOrderResponse) {
        List<DeductionPayChannel> payChannelList;
        List<DeductionPayChannel> payChannelList2;
        Intrinsics.checkNotNullParameter(fastPayOrderResponse, "response");
        for (IFastPayBaseViewBinder iFastPayBaseViewBinder : getViewBinders()) {
            iFastPayBaseViewBinder.setupView(fastPayOrderResponse);
        }
        IFastPayOrderView IView = IView();
        if (IView != null) {
            IView.setupView(fastPayOrderResponse);
        }
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        Deduction autoDeduction = fastPayOrderResponse.getAutoDeduction();
        if (!(autoDeduction == null || (payChannelList2 = autoDeduction.getPayChannelList()) == null)) {
            for (DeductionPayChannel add : payChannelList2) {
                arrayList.add(add);
            }
        }
        Deduction noAutoDeduction = fastPayOrderResponse.getNoAutoDeduction();
        if (!(noAutoDeduction == null || (payChannelList = noAutoDeduction.getPayChannelList()) == null)) {
            for (DeductionPayChannel add2 : payChannelList) {
                arrayList2.add(add2);
            }
        }
        CashierOmegaUtils cashierOmegaUtils = new CashierOmegaUtils(FastPayOmegaConstants.EVENT_ORDER_SW);
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("auto_deduction_channel_list", arrayList);
        linkedHashMap.put("non_auto_deduction_channel_list", arrayList2);
        Unit unit = Unit.INSTANCE;
        cashierOmegaUtils.addParam("list", linkedHashMap.toString()).send();
    }

    public void showLastMethodToast(String str) {
        Intrinsics.checkNotNullParameter(str, BlocksConst.ACTION_TYPE_TOAST);
        toast(str, false);
    }

    public void onChangeOrderChangeSuccess(ChangePayOrderResponse changePayOrderResponse) {
        Intrinsics.checkNotNullParameter(changePayOrderResponse, "response");
        this.f21583a.onClose(true, FastPayStatus.ON);
    }

    public IFastPayOrderView IView() {
        IGlobalCashierBaseView mView = getMView();
        if (mView instanceof IFastPayOrderView) {
            return (IFastPayOrderView) mView;
        }
        return null;
    }

    public void unBind() {
        super.unBind();
        getViewBinders().clear();
    }
}
