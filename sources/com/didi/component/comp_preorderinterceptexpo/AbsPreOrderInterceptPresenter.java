package com.didi.component.comp_preorderinterceptexpo;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigProcessor;
import com.didi.global.globalgenerickit.config.IConfig;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsPreOrderInterceptPresenter extends IPresenter<IView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f12348a = getClass().getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PreOrderInterceptExpo f12349b;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<String> f12350c = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (!TextUtils.isEmpty(str2) && AbsPreOrderInterceptPresenter.this.f12349b != null && AbsPreOrderInterceptPresenter.this.f12349b.data != null && !CollectionUtil.isEmpty((Collection<?>) AbsPreOrderInterceptPresenter.this.f12349b.data.interceptList)) {
                for (final PreOrderInterceptListItemModel next : AbsPreOrderInterceptPresenter.this.f12349b.data.interceptList) {
                    if (next != null && !TextUtils.isEmpty(next.uniqueId) && next.uniqueId.equals(str2) && next.data != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(next.data.toString());
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next2 = keys.next();
                                if (!TextUtils.isEmpty(next2)) {
                                    Iterator<String> it = GGKConfigProcessor.getMaps().keySet().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        } else if (next2.equals(it.next())) {
                                            JSONArray jSONArray = jSONObject.getJSONObject(next2).getJSONArray("list");
                                            IConfig iConfig = GGKConfigProcessor.getMaps().get(next2);
                                            if (!(jSONArray == null || iConfig == null)) {
                                                iConfig.show(AbsPreOrderInterceptPresenter.this.getHost().getActivity(), jSONArray, (GGKConfigCallbackAdapter) new GGKConfigCallbackAdapter() {
                                                    public boolean sheetClickLis(LEGODrawer lEGODrawer, ButtonModel buttonModel, String str) {
                                                        if (lEGODrawer == null) {
                                                            return true;
                                                        }
                                                        AbsPreOrderInterceptPresenter.this.m8371a(next, buttonModel, str);
                                                        lEGODrawer.dismiss();
                                                        return true;
                                                    }

                                                    public boolean alertClickLis(LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, ButtonModel buttonModel, String str) {
                                                        if (lEGOBaseAlertDialogFragment == null) {
                                                            return true;
                                                        }
                                                        AbsPreOrderInterceptPresenter.this.m8371a(next, buttonModel, str);
                                                        lEGOBaseAlertDialogFragment.dismiss();
                                                        return true;
                                                    }
                                                });
                                                String eventSw = next.getEventSw();
                                                if (!TextUtils.isEmpty(eventSw)) {
                                                    Map<String, Object> extraLog = next.getExtraLog();
                                                    if (!CollectionUtil.isEmpty((Map<?, ?>) extraLog)) {
                                                        GlobalOmegaUtils.trackEvent(eventSw, extraLog);
                                                    } else {
                                                        GlobalOmegaUtils.trackEvent(eventSw);
                                                    }
                                                }
                                                ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
                                                if (confirmListener == null || !confirmListener.getIsAnyCar()) {
                                                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                                                    if (newEstimateItem != null && newEstimateItem.carBreakModel != null && newEstimateItem.carBreakModel.preorderExpoInterceptInfo != null && !TextUtils.isEmpty(newEstimateItem.carBreakModel.preorderExpoInterceptInfo.displayedScheme)) {
                                                        DRouter.build(newEstimateItem.carBreakModel.preorderExpoInterceptInfo.displayedScheme).start();
                                                    }
                                                } else {
                                                    AnyCarEstimateItemModel hitPreOrderItem = confirmListener.getHitPreOrderItem();
                                                    if (hitPreOrderItem != null && hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel != null && hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo != null && !TextUtils.isEmpty(hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.displayedScheme)) {
                                                        DRouter.build(hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.displayedScheme).start();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }
    };

    /* renamed from: d */
    private XEResponseCallback f12351d = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null) {
                String c = AbsPreOrderInterceptPresenter.this.f12348a;
                LogUtils.m31493i(c, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
                AbsPreOrderInterceptPresenter.this.m8372a(xEngineData.jsonObject);
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            AbsPreOrderInterceptPresenter.this.m8373a((Exception) engineErrorException);
        }
    };

    /* renamed from: e */
    private XEReqJSONParamsCallbackImpl f12352e = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            return new JSONObject(new HashMap());
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8373a(Exception exc) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8371a(PreOrderInterceptListItemModel preOrderInterceptListItemModel, ButtonModel buttonModel, String str) {
        if (!TextUtils.isEmpty(str)) {
            DRouter.build(str).start(this.mContext);
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null) {
                if (confirmListener.getIsAnyCar()) {
                    AnyCarEstimateItemModel hitPreOrderItem = confirmListener.getHitPreOrderItem();
                    if (!(hitPreOrderItem == null || hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel == null || hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo == null)) {
                        hitPreOrderItem.mAnyCarEstimateNetItem.carBreakModel.preorderExpoInterceptInfo.show = false;
                    }
                } else {
                    EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                    if (!(newEstimateItem == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.preorderExpoInterceptInfo == null)) {
                        newEstimateItem.carBreakModel.preorderExpoInterceptInfo.show = false;
                    }
                }
            }
        } else {
            doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER);
        }
        String eventCk = preOrderInterceptListItemModel != null ? preOrderInterceptListItemModel.getEventCk() : "";
        Map<String, Object> map = null;
        if (preOrderInterceptListItemModel != null) {
            map = preOrderInterceptListItemModel.getExtraLog();
        }
        if (CollectionUtil.isEmpty((Map<?, ?>) map)) {
            map = new HashMap<>();
        }
        if (buttonModel != null && !TextUtils.isEmpty(buttonModel.actionId)) {
            map.put("popupbutton_name", buttonModel.actionId);
        }
        if (TextUtils.isEmpty(eventCk)) {
            return;
        }
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            GlobalOmegaUtils.trackEvent(eventCk, map);
        } else {
            GlobalOmegaUtils.trackEvent(eventCk);
        }
    }

    public AbsPreOrderInterceptPresenter(BusinessContext businessContext) {
        super(businessContext.getContext());
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(XERequestKey.SingleCompRefresh.REQUEST_KEY_PREORDER_EXPO_INTERCEPT, XERequestKey.SCENE_ESTIMATE, this.f12351d));
        subscribe(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_EXPO, this.f12350c);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterCallback(XERequestKey.SingleCompRefresh.REQUEST_KEY_PREORDER_EXPO_INTERCEPT, this.f12351d);
        unsubscribe(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_EXPO, this.f12350c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8372a(JsonObject jsonObject) {
        if (getHost() != null && getHost().getActivity() != null && jsonObject != null && !TextUtils.isEmpty(jsonObject.toString())) {
            try {
                this.f12349b = (PreOrderInterceptExpo) new Gson().fromJson(jsonObject.toString(), PreOrderInterceptExpo.class);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
    }
}
