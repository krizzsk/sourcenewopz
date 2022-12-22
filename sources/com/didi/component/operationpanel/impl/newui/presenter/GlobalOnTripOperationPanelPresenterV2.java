package com.didi.component.operationpanel.impl.newui.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.sharetrip.CommonTripShareManager;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.dialog.GlobalCommonBottomPop;
import com.didi.component.common.pininput.dialog.ShowPinDialog;
import com.didi.component.common.pininput.dialog.ShowPinDialogInfo;
import com.didi.component.common.router.GlobalRouter;
import com.didi.component.common.util.OnlineHelpUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.operationpanel.AbsOperationPanelPresenter;
import com.didi.component.operationpanel.IOperationPanelView;
import com.didi.component.operationpanel.OperationPanelItemModel;
import com.didi.component.operationpanel.impl.newui.data.OperationPanelObject;
import com.didi.component.operationpanel.impl.view.ReceiptReceiveEmailActivity;
import com.didi.component.operationpanel.model.OperationPanelModel;
import com.didi.drouter.api.DRouter;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.reactive.tracker.EventTracker;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.monitor.GlobalPaxTechTracker;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.sidebar.history.manager.JPInvoiceManager;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class GlobalOnTripOperationPanelPresenterV2 extends AbsOperationPanelPresenter implements XpNewAdapter {
    protected static final int REQUEST_CODE_HELP_WEB_PAGE = 101;

    /* renamed from: b */
    private static final String f14781b = "gp_split_start_btn_ck";

    /* renamed from: c */
    private static final int f14782c = 1000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ArrayList<OperationPanelItemModel> f14783d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ShowPinDialog f14784e;

    /* renamed from: f */
    private final LoginListeners.LoginOutListener f14785f = new LoginListeners.LoginOutListener() {
        public void onSuccess() {
            if (GlobalOnTripOperationPanelPresenterV2.this.f14786g != null && GlobalOnTripOperationPanelPresenterV2.this.f14786g.isShowing()) {
                GlobalOnTripOperationPanelPresenterV2.this.f14786g.dismiss();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GlobalCommonBottomPop f14786g;

    /* renamed from: h */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14787h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GlobalOnTripOperationPanelPresenterV2.this.m10574e();
            ((IOperationPanelView) GlobalOnTripOperationPanelPresenterV2.this.mView).showItems(GlobalOnTripOperationPanelPresenterV2.this.f14783d);
        }
    };

    /* renamed from: i */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14788i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GlobalOnTripOperationPanelPresenterV2.this.onShareItemClicked();
        }
    };

    /* renamed from: j */
    private final OperationPanelModel f14789j = new OperationPanelModel();

    /* renamed from: k */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14790k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            GlobalOnTripOperationPanelPresenterV2.this.m10587l();
        }
    };

    /* renamed from: l */
    private JPInvoiceManager f14791l;
    protected BusinessContext mBizContext;
    protected CommonTripShareManager mShareManager;

    public GlobalOnTripOperationPanelPresenterV2(ComponentParams componentParams) {
        super(componentParams);
        this.mBizContext = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m10568b();
        this.f14789j.attach();
    }

    /* renamed from: b */
    private void m10568b() {
        subscribe(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE, this.f14787h);
        OneLoginFacade.getFunction().addLoginOutListener(this.f14785f);
        subscribe(BaseEventKeys.OnService.EVENT_SUBSTITUTE_CALL_TRAVEL_SHARING, this.f14788i);
        subscribe(BaseEventKeys.Trip.EVENT_GLOBAL_TRIP_SEND_RECEIPT, this.f14790k);
    }

    /* renamed from: c */
    private void m10571c() {
        unsubscribe(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE, this.f14787h);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f14785f);
        unsubscribe(BaseEventKeys.OnService.EVENT_SUBSTITUTE_CALL_TRAVEL_SHARING, this.f14788i);
        unsubscribe(BaseEventKeys.Trip.EVENT_GLOBAL_TRIP_SEND_RECEIPT, this.f14790k);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m10571c();
        this.f14789j.detach();
        CommonTripShareManager commonTripShareManager = this.mShareManager;
        if (commonTripShareManager != null) {
            commonTripShareManager.disMissOneKeyShareDialog();
        }
        hideLoading();
        ((IOperationPanelView) this.mView).dismissPopup();
        m10586k();
    }

    /* access modifiers changed from: protected */
    public void onItemClicked(OperationPanelItemModel operationPanelItemModel) {
        ((IOperationPanelView) this.mView).dismissPopup();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int i = operationPanelItemModel.f14774id;
            if (isDoingService()) {
                if (i == 519) {
                    m10581h();
                } else if (i == 521) {
                    m10577f();
                } else if (i != 528) {
                    switch (i) {
                        case 513:
                            onShareItemClicked();
                            break;
                        case 514:
                            onHelpClicked();
                            break;
                        case 515:
                            m10585j();
                            break;
                    }
                } else {
                    m10573d();
                }
            }
            if (!isEndService()) {
                return;
            }
            if (i == 514) {
                onEndServiceHelp(order);
            } else if (i == 522) {
                onInvoiceV2(operationPanelItemModel, order);
            } else if (i == 529) {
                openExpensiveCompensationHelp(operationPanelItemModel);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onInvoice(CarOrder carOrder) {
        if (carOrder.invoiceInfo != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.isSupportCache = true;
            webViewModel.url = GlobalWebUrl.buildUrl(carOrder.invoiceInfo.invoicePageUrl, getUrlParams(carOrder, false));
            webViewModel.title = "Receipt";
            Intent intent = new Intent(this.mContext, ReceiptReceiveEmailActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            this.mContext.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onInvoiceV2(OperationPanelItemModel operationPanelItemModel, CarOrder carOrder) {
        String str = operationPanelItemModel.url;
        if (!TextUtils.isEmpty(str)) {
            if (!(str.startsWith("http") || str.startsWith("https"))) {
                DRouter.build(str).start(this.mContext);
                return;
            }
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.isSupportCache = true;
            String str2 = operationPanelItemModel.url;
            webViewModel.title = operationPanelItemModel.title == null ? "Receipt" : operationPanelItemModel.title.getContent();
            if (str2.startsWith("http") || str2.startsWith("https")) {
                webViewModel.url = GlobalWebUrl.buildUrl(str2, getUrlParams(carOrder, true));
                Intent intent = new Intent(this.mContext, WebActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                this.mContext.startActivity(intent);
            } else if (carOrder.invoiceInfo != null) {
                webViewModel.url = GlobalWebUrl.buildUrl(carOrder.invoiceInfo.invoicePageUrl, getUrlParams(carOrder, false));
                Intent intent2 = new Intent(this.mContext, ReceiptReceiveEmailActivity.class);
                intent2.putExtra("web_view_model", webViewModel);
                this.mContext.startActivity(intent2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onEndServiceHelp(CarOrder carOrder) {
        String str = carOrder.status == 5 ? "1" : "2";
        if (carOrder.status == 6 || carOrder.status == 2 || carOrder.status == 5 || carOrder.substatus != 5001) {
            str = "3";
        }
        GlobalOmegaUtils.trackEvent("pas_drivercard_help_ck", ServerParam.PARAM_ORDER_TYPE, str);
        OnlineHelpUtil.startOnServiceHelp(this.mContext);
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Object> getUrlParams(CarOrder carOrder, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("productId", Integer.valueOf(carOrder.productid));
        hashMap.put("lang", NationTypeUtil.getNationComponentData().getLocaleCode());
        hashMap.put("uid", OneLoginFacade.getStore().getUid());
        String str = "";
        if (z) {
            if (CarOrderHelper.getOrder() != null) {
                str = CarOrderHelper.getOrder().getOid();
            }
            hashMap.put("order_id", str);
        } else {
            if (CarOrderHelper.getOrder() != null) {
                str = CarOrderHelper.getOrder().getOid();
            }
            hashMap.put("orderId", str);
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void openExpensiveCompensationHelp(OperationPanelItemModel operationPanelItemModel) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && operationPanelItemModel != null) {
            String str = operationPanelItemModel.url;
            if (!TextUtils.isEmpty(str)) {
                WebViewModel webViewModel = new WebViewModel();
                webViewModel.url = str;
                webViewModel.isAddCommonParam = true;
                webViewModel.addParam("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
                webViewModel.addParam("terminal_id", NationTypeUtil.getNationComponentData().getTerminal_id());
                webViewModel.addParam("order_id", order.getOid());
                webViewModel.addParam("pid", String.valueOf(NationComponentDataUtil.getUid()));
                Intent intent = new Intent(this.mContext, WebActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                this.mContext.startActivity(intent);
                trackExpensiveCompensation();
            } else if (!TextUtils.isEmpty(operationPanelItemModel.toastTip)) {
                LEGOToastHelper.showToast(this.mContext, operationPanelItemModel.toastTip);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void trackExpensiveCompensation() {
        HashMap hashMap = new HashMap();
        hashMap.put("pid", Long.valueOf(NationComponentDataUtil.getUid()));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            hashMap.put("orderid", order.getOid());
        }
        GlobalOmegaUtils.trackEvent("ibt_pricematch_finishorder_page_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: d */
    private void m10573d() {
        doPublish(BaseEventKeys.OnService.SPLIT_FARE_OWNER_CANCEL);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10574e() {
        CarOrder order;
        ArrayList<OperationPanelItemModel> arrayList = this.f14783d;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<OperationPanelItemModel> it = this.f14783d.iterator();
            while (true) {
                if (it.hasNext()) {
                    OperationPanelItemModel next = it.next();
                    if (next != null && next.f14774id == 520) {
                        this.f14783d.remove(next);
                        break;
                    }
                } else {
                    break;
                }
            }
            int i = 0;
            while (i < this.f14783d.size()) {
                if (this.f14783d.get(i).f14774id != 521 || (order = CarOrderHelper.getOrder()) == null || (!(4 == order.status || 1 == order.status) || !order.isSplitFareOrder())) {
                    i++;
                } else {
                    this.f14783d.add(i + 1, new OperationPanelItemModel(520, 2147483646, ComponentType.SPLIT_FARE));
                    return;
                }
            }
        }
    }

    /* renamed from: f */
    private void m10577f() {
        EventTracker.trackEvent("gp_split_start_btn_ck");
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.isCanSplitFare()) {
            if (order != null && order.splitFareInfo != null) {
                m10579g();
            }
        } else if (order.splitFareInfo == null) {
        } else {
            if (!TextUtils.isEmpty(order.splitFareInfo.fee_msg_title) || !TextUtils.isEmpty(order.splitFareInfo.fee_msg_content)) {
                GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
                if (!TextUtils.isEmpty(order.splitFareInfo.fee_msg_title)) {
                    bottomPopModel.title = order.splitFareInfo.fee_msg_title;
                    bottomPopModel.content = order.splitFareInfo.fee_msg_content;
                } else if (!TextUtils.isEmpty(order.splitFareInfo.fee_msg_content)) {
                    bottomPopModel.title = order.splitFareInfo.fee_msg_content;
                }
                bottomPopModel.positive = this.mContext.getString(R.string.car_me_known);
                GlobalCommonBottomPop globalCommonBottomPop = new GlobalCommonBottomPop(this.mContext, bottomPopModel);
                this.f14786g = globalCommonBottomPop;
                globalCommonBottomPop.setCanceledOnTouchOutside(true);
                this.f14786g.show();
                GlobalOmegaUtils.trackEvent("gp_split_cannotstart_dlg_sw", "title", order.splitFareInfo.fee_msg_content);
                this.f14786g.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
                    public void onNegativeClick() {
                    }

                    public void onPositiveClick() {
                        GlobalOnTripOperationPanelPresenterV2.this.f14786g.dismiss();
                    }
                });
            }
        }
    }

    /* renamed from: g */
    private void m10579g() {
        DRouter.build(GlobalRouter.PAGE_SPLIT_FARE_CONTACTS).start(this.mContext);
    }

    /* renamed from: h */
    private void m10581h() {
        if (this.mContext != null) {
            SafeToolKit.getIns().startEmergencyAssistanceActivity(this.mContext);
        }
    }

    /* access modifiers changed from: protected */
    public void onShareItemClicked() {
        if (!Utils.isFastDoubleClick()) {
            CommonTripShareManager commonTripShareManager = this.mShareManager;
            if (commonTripShareManager != null) {
                commonTripShareManager.disMissOneKeyShareDialog();
            }
            if (this.mShareManager == null) {
                this.mShareManager = new CommonTripShareManager();
            }
            if (Preconditions.nonNull(CarOrderHelper.getOrder()) && Preconditions.nonNull(this.mContext)) {
                this.f14789j.doShare(this.mContext, getHost());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onHelpClicked() {
        GlobalOmegaUtils.trackEvent("pas_drivercard_needhelp_ck");
        startActivityForResult(OnlineHelpUtil.getStartIntent(this.mContext, GlobalWebUrl.getServiceHelpUrl(this.mContext, ""), OnlineHelpUtil.DEFAULT_ON_SERVICE_SOURCE_PARAM), 101);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 101 && i2 == -1 && intent != null && intent.getBooleanExtra("isCancelTrip", false)) {
            m10583i();
        }
    }

    /* renamed from: i */
    private void m10583i() {
        NotificationUtils.getInstance(this.mContext).hideNotification();
        goBackRoot();
        DDTravelOrderStore.setOrder((ICarOrder) null);
    }

    /* renamed from: j */
    private void m10585j() {
        String userPin = NationComponentDataUtil.getUserPin(this.mContext);
        if (!TextUtils.isEmpty(userPin) && userPin.length() == 3) {
            ShowPinDialogInfo showPinDialogInfo = new ShowPinDialogInfo(1000);
            showPinDialogInfo.setPin(userPin);
            showPinDialogInfo.setTitle(this.mContext.getResources().getString(R.string.global_pin_dialog_show_tips));
            showPinDialogInfo.setButton(this.mContext.getResources().getString(R.string.global_pin_dialog_show_confirm));
            showPinDialogInfo.setCancelable(true);
            ShowPinDialog showPinDialog = this.f14784e;
            if (showPinDialog == null) {
                ShowPinDialog build = new ShowPinDialog.DialogBuilder(this.mBizContext).setDialogInfo(showPinDialogInfo).setListener(new ShowPinDialog.DialogListener() {
                    public void onAction(int i) {
                        GlobalOnTripOperationPanelPresenterV2.this.f14784e.dismiss();
                    }
                }).build();
                this.f14784e = build;
                build.show();
            } else if (showPinDialog.isShowing()) {
                this.f14784e.dismiss();
                this.f14784e.update(showPinDialogInfo);
                this.f14784e.show();
            } else {
                this.f14784e.update(showPinDialogInfo);
                this.f14784e.show();
            }
        }
    }

    /* renamed from: k */
    private void m10586k() {
        ShowPinDialog showPinDialog = this.f14784e;
        if (showPinDialog != null && showPinDialog.isShowing()) {
            try {
                this.f14784e.dismiss();
            } catch (Throwable unused) {
            }
        }
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        if (jSONObject != null) {
            OperationPanelObject operationPanelObject = new OperationPanelObject();
            operationPanelObject.parse(jSONObject);
            if (operationPanelObject.list != null && operationPanelObject.list.size() > 0) {
                m10567a(operationPanelObject);
                iXpCardBindDataReadyCallback.ready(true);
            }
        }
    }

    /* renamed from: a */
    private void m10567a(OperationPanelObject operationPanelObject) {
        if (operationPanelObject.title != null && !TextUtils.isEmpty(operationPanelObject.title.getContent())) {
            ((IOperationPanelView) this.mView).setTitle(operationPanelObject.title);
        }
        this.f14783d = new ArrayList<>();
        if (operationPanelObject.list != null && operationPanelObject.list.size() > 0) {
            List<OperationPanelObject.OperationModel> list = operationPanelObject.list;
            for (int i = 0; i < list.size(); i++) {
                OperationPanelObject.OperationModel operationModel = list.get(i);
                GlobalRichInfo globalRichInfo = operationModel.title;
                int i2 = operationModel.option_id;
                String str = operationModel.icon;
                String str2 = operationModel.corner_icon;
                String str3 = operationModel.url;
                GlobalRichInfo globalRichInfo2 = operationModel.item_text;
                this.f14783d.add(new OperationPanelItemModel(i2, globalRichInfo, str, str2, str3).setRichInfo(globalRichInfo2).setToastTip(operationModel.toast_text));
                m10566a(i2);
            }
        }
        m10574e();
        ((IOperationPanelView) this.mView).showItems(this.f14783d);
    }

    /* renamed from: a */
    private void m10566a(int i) {
        CarOrder order = CarOrderHelper.getOrder();
        if (i == 515 && order != null) {
            GlobalPaxTechTracker.getInstance().trackPIN(order.productid, order.oid);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isDoingService() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return false;
        }
        int i = order.status;
        if (i == 4 || i == 1 || i == 7) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isEndService() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return false;
        }
        if (order.status == 2 || order.status == 6 || order.status == 5 || order.status == 3) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m10587l() {
        Fragment host = getHost();
        if (!Preconditions.isNull(host) && host.isAdded()) {
            if (this.f14791l == null) {
                this.f14791l = new JPInvoiceManager(this.mContext, new JPInvoiceManager.ICallback() {
                    public void showLoading() {
                        GlobalOnTripOperationPanelPresenterV2.this.showMaskLayerLoading();
                    }

                    public void onSuccess() {
                        ToastHelper.showShortCompleted(GlobalOnTripOperationPanelPresenterV2.this.mContext, GlobalOnTripOperationPanelPresenterV2.this.mContext.getString(R.string.history_email_send_ok));
                    }

                    public void onFail() {
                        ToastHelper.showShortInfo(GlobalOnTripOperationPanelPresenterV2.this.mContext, GlobalOnTripOperationPanelPresenterV2.this.mContext.getString(R.string.history_email_send_fail));
                    }

                    public void hideLoading() {
                        GlobalOnTripOperationPanelPresenterV2.this.hideLoading();
                    }
                }, 1);
            }
            this.f14789j.doSendReceipt(this.f14791l, host.getChildFragmentManager());
        }
    }
}
