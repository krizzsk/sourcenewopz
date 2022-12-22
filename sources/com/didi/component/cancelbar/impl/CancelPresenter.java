package com.didi.component.cancelbar.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.component.business.cancelintercept.CancelInterceptRequest;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.cancelbar.AbsCancelPresenter;
import com.didi.component.cancelbar.CancelTextModel;
import com.didi.component.cancelbar.ICancelView;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.ComponentConfigManager;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.convert.GGKDrawerModelConverter;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKBaseDrawerModel;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheet;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheetModel;
import com.didi.sdk.app.BusinessContext;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.OperationCancelModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didiglobal.travel.biz.experim.GlobalExperims;
import com.didiglobal.travel.util.Preconditions;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class CancelPresenter extends AbsCancelPresenter<ICancelView> implements XpNewAdapter {
    protected static final int sDialogIDCancel = 34;

    /* renamed from: a */
    private BusinessContext f11418a;

    /* renamed from: b */
    private long f11419b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f11420c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public HashMap<String, SoftReference<GGKDrawer>> f11421d = new HashMap<>();

    /* renamed from: e */
    private CancelTextModel f11422e = new CancelTextModel();

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<Bundle> f11423f = new BaseEventPublisher.OnEventListener<Bundle>() {
        public void onEvent(String str, Bundle bundle) {
            String string = bundle.getString("id");
            bundle.getString("action");
            SoftReference softReference = (SoftReference) CancelPresenter.this.f11421d.get(string);
            if (softReference != null && softReference.get() != null) {
                ((GGKDrawer) softReference.get()).dismiss();
                CancelPresenter.this.f11421d.remove(string);
            }
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f11424g = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CancelPresenter.this.trackCancelEvent();
            CancelPresenter.this.onCancelItemClicked();
        }
    };

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f11425h = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            CancelPresenter.this.trackCancelTripEvent();
            CancelPresenter.this.m7741d();
        }
    };

    public CancelPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f11418a = componentParams.bizCtx;
    }

    public BusinessContext getBizContext() {
        return this.f11418a;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        init(bundle);
        subscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, this.f11423f);
        subscribe(BaseEventKeys.Router.EVENT_ROUTER_CANCELBAR_CANCEL_ORDER, this.f11424g);
        subscribe(BaseEventKeys.Router.EVENT_ROUTER_CANCELBAR_CANCEL_TRIP, this.f11425h);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_CANCEL, this.f11423f);
        unsubscribe(BaseEventKeys.Router.EVENT_ROUTER_CANCELBAR_CANCEL_ORDER, this.f11424g);
        unsubscribe(BaseEventKeys.Router.EVENT_ROUTER_CANCELBAR_CANCEL_TRIP, this.f11425h);
        dismisGGKDialog(true);
    }

    /* access modifiers changed from: protected */
    public void init(Bundle bundle) {
        this.f11419b = System.currentTimeMillis();
    }

    public void onClickCancel() {
        String str = Preconditions.nonNull(this.f11422e) ? this.f11422e.url : "";
        if (!TextUtils.isEmpty(str)) {
            DRouter.build(str).start();
        }
    }

    public int getNearCarFlag() {
        if (!FormStore.getInstance().isShowNearCarMsg()) {
            return 0;
        }
        int nearbyCarNum = FormStore.getInstance().getNearbyCarNum();
        if (nearbyCarNum <= GlobalApolloUtil.getNoCarCount()) {
            return 2;
        }
        return nearbyCarNum <= GlobalApolloUtil.getFewCarCount() ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onCancelItemClicked() {
        if (CarOrderHelper.getOrder() != null) {
            trackCancelDlgEvent();
            if (GlobalExperims.checkCancelOrderNewPage()) {
                m7739c();
            } else {
                m7737b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7737b() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (order.mOperationModel == null || order.mOperationModel.operationCancelModel == null) {
                showNormalCancelDialog();
                return;
            }
            OperationCancelModel operationCancelModel = order.mOperationModel.operationCancelModel;
            showCancelDialog(operationCancelModel.subject, operationCancelModel.descList.length > 0 ? operationCancelModel.descList[0] : "", operationCancelModel.keepButton, operationCancelModel.cancelButton);
        }
    }

    /* access modifiers changed from: protected */
    public void showCancelDialog(String str, String str2, String str3, String str4) {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(34);
        normalDialogInfo.setCancelable(false);
        normalDialogInfo.setIconVisible(false);
        normalDialogInfo.setCloseVisible(false);
        normalDialogInfo.setTitle(str);
        normalDialogInfo.setMessage(str2);
        normalDialogInfo.setPositiveText(str3);
        normalDialogInfo.setNegativeText(str4);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void showNormalCancelDialog() {
        doPublish(BaseEventKeys.WaitRsp.EVENT_WAIT_SHOW_CANCEL_INTERCEPT_POPUP);
    }

    /* renamed from: c */
    private void m7739c() {
        if (this.f11420c || dismisGGKDialog(false)) {
            GLog.m7967e(" showExpoCancelDialog request expo " + this.f11420c);
            return;
        }
        this.f11420c = true;
        C46874 r1 = new BffResponseListener<ComponentSheet>() {
            public void onFinish(ComponentSheet componentSheet) {
                super.onFinish(componentSheet);
                if (!CancelPresenter.this.mRemoved) {
                    boolean unused = CancelPresenter.this.f11420c = false;
                    if (componentSheet == null || componentSheet.errno != 0) {
                        CancelPresenter.this.m7737b();
                    } else if (componentSheet.passenger_sheet == null || componentSheet.passenger_sheet.size() <= 0) {
                        CancelPresenter.this.m7737b();
                    } else {
                        for (ComponentSheetModel next : componentSheet.passenger_sheet) {
                            GGKBaseDrawerModel convert2GGKDrawerModel = GGKDrawerModelConverter.convert2GGKDrawerModel(next);
                            convert2GGKDrawerModel.setClickOutsideCanCancel(false);
                            convert2GGKDrawerModel.setmBackPressedEnabled(false);
                            if (!TextUtils.isEmpty(next.cdn)) {
                                CancelPresenter.this.m7737b();
                                return;
                            } else {
                                CancelPresenter.this.f11421d.put(convert2GGKDrawerModel.getTrackId(), new SoftReference(GGKUICreator.showDrawerModel(CancelPresenter.this.mContext, convert2GGKDrawerModel)));
                            }
                        }
                    }
                }
            }
        };
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        String str = CarOrderHelper.getOrder() != null ? CarOrderHelper.getOrder().oid : "";
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("orderId", str);
        if (newEstimateItem != null) {
            if (newEstimateItem.carConfig != null) {
                arrayMap.put("business_id", Integer.valueOf(newEstimateItem.carConfig.carBussinessId));
            } else {
                arrayMap.put("business_id", 0);
            }
            arrayMap.put("combo_type", 0);
            arrayMap.put("version", "0");
        } else if (CarOrderHelper.getOrder() != null) {
            CarOrder order = CarOrderHelper.getOrder();
            arrayMap.put("business_id", Integer.valueOf(order.productid));
            arrayMap.put("combo_type", Integer.valueOf(order.comboType));
            arrayMap.put("version", "0");
        }
        ComponentConfigManager.showComponentSheetConfigDialog(this.mContext, arrayMap, ComponentConfigManager.BUSINESS_SCENE_CANCEL, r1);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        if (backType != IPresenter.BackType.BackKey || !dismisGGKDialog(true)) {
            return super.onBackPressed(backType);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean dismisGGKDialog(boolean z) {
        Iterator<Map.Entry<String, SoftReference<GGKDrawer>>> it = this.f11421d.entrySet().iterator();
        while (it.hasNext()) {
            SoftReference softReference = (SoftReference) it.next().getValue();
            if (softReference != null && softReference.get() != null && ((GGKDrawer) softReference.get()).isShowing()) {
                if (!z) {
                    return true;
                }
                ((GGKDrawer) softReference.get()).dismiss();
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void trackCancelEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("fixed", FormStore.getInstance().isCountPriceTypeFixed() ? "1" : "0");
        hashMap.put("nearcar", Integer.valueOf(FormStore.getInstance().getNearbyCarNum()));
        hashMap.put("type", Integer.valueOf(CarOrderHelper.getReAssignOrderType()));
        hashMap.put(ParamConst.PARAM_WAIT_TIME, String.valueOf((System.currentTimeMillis() - this.f11419b) / 1000));
        GlobalOmegaUtils.trackEvent("pas_waitforresponse_cancel_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void trackCancelTripEvent() {
        GlobalOmegaUtils.trackEvent("ibt_waitfordriver_canceltrip_ck");
    }

    /* access modifiers changed from: protected */
    public void trackCancelDlgEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(CarOrderHelper.getReAssignOrderType()));
        hashMap.put("fixed", FormStore.getInstance().isQuotaInCurEstimateItem() ? "1" : "0");
        hashMap.put("nearcar", Integer.valueOf(getNearCarFlag()));
        GlobalOmegaUtils.trackEvent("pas_waitforresponse_cancelconfirmdlg_sw", (Map<String, Object>) hashMap);
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        JSONObject optJSONObject = jSONObject.optJSONObject("normal");
        if (optJSONObject != null) {
            this.f11422e.parse(optJSONObject);
            ((ICancelView) this.mView).setButtonInfo(this.f11422e);
            iXpCardBindDataReadyCallback.ready(true);
            return;
        }
        iXpCardBindDataReadyCallback.ready(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7741d() {
        showLoading();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && this.mContext != null && !this.mRemoved) {
            CarRequest.cancelTrip(this.mContext, order.oid, 1, 1, "", (Map<String, Object>) null, new ResponseListener<CarCancelTrip>() {
                public void onSuccess(CarCancelTrip carCancelTrip) {
                    super.onSuccess(carCancelTrip);
                    CancelPresenter.this.hideLoading();
                    if (carCancelTrip.cancelReasonInfo != null) {
                        CancelPresenter.this.doPublish(BaseEventKeys.Service.CancelOrder.EVENT_SHOW_CANCEL_REASON_LIST, carCancelTrip.cancelReasonInfo);
                        return;
                    }
                    CancelPresenter.this.doPublish(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_LIST_BEFORE);
                    CancelPresenter.this.doPublish(BaseEventKeys.OnService.EVENT_ONSERVICE_SHOW_CANCEL_INTERCEPT_POPUP, carCancelTrip);
                }

                public void onError(CarCancelTrip carCancelTrip) {
                    super.onError(carCancelTrip);
                    CancelPresenter.this.hideLoading();
                }

                public void onFail(CarCancelTrip carCancelTrip) {
                    super.onFail(carCancelTrip);
                    CarHttpHelper.validate((FragmentActivity) CancelPresenter.this.mContext, carCancelTrip);
                    if (carCancelTrip != null && carCancelTrip.errno == 22152) {
                        new CancelInterceptRequest(CancelPresenter.this.mContext).loadOrderDetailAndJump(CancelPresenter.this.mComponentParams, carCancelTrip.reassignOid, new ResponseListener<CarOrder>() {
                            public void onFinish(CarOrder carOrder) {
                                super.onFinish(carOrder);
                                CancelPresenter.this.hideLoading();
                            }
                        });
                    }
                }
            });
        }
    }
}
