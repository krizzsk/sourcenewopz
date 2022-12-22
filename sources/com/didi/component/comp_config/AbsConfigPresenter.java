package com.didi.component.comp_config;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.commit.XEngineCommitUtil;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragmentManager;
import com.didi.global.globalgenerickit.drawer.GGKDrawerManager;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.dialog.LEGODialogFragmentManager;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerManager;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsConfigPresenter extends IPresenter<AbsConfigView> {

    /* renamed from: a */
    private static final int f12122a = 0;

    /* renamed from: b */
    private static final int f12123b = 1;

    /* renamed from: c */
    private static final int f12124c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final String f12125d = getClass().getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f12126e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f12127f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f12128g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f12129h;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<String> f12130i = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                boolean z = true;
                boolean z2 = (AbsConfigPresenter.this.f12128g == 0 || order.status <= 0 || order.status == AbsConfigPresenter.this.f12128g) ? false : true;
                if (AbsConfigPresenter.this.f12129h == 0 || order.substatus == AbsConfigPresenter.this.f12129h) {
                    z = false;
                }
                if (z2 || z) {
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            GGKDialogFragmentManager.getInstance().dismissAllGGKDialog();
                            GGKDrawerManager.dismissGGKDrawer();
                            LEGODialogFragmentManager.getInstance().dismissAllGGKDialog();
                            LEGODrawerManager.dismissGGKDrawer();
                            String unused = AbsConfigPresenter.this.f12127f = "";
                            String unused2 = AbsConfigPresenter.this.f12126e = "";
                        }
                    });
                }
                int unused = AbsConfigPresenter.this.f12128g = order.status;
                int unused2 = AbsConfigPresenter.this.f12129h = order.substatus;
            }
        }
    };
    protected BusinessContext mBizCtx;
    protected BaseEventPublisher.OnEventListener<String> mOrderStatusChangeListener = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (EventKeys.XEngine.EVENT_X_ENGINE_ORDER_STATUS_CHANGE.equals(str)) {
                UIThreadHandler.post(new Runnable() {
                    public void run() {
                        GGKDialogFragmentManager.getInstance().dismissAllGGKDialog();
                        GGKDrawerManager.dismissGGKDrawer();
                        LEGODialogFragmentManager.getInstance().dismissAllGGKDialog();
                        LEGODrawerManager.dismissGGKDrawer();
                        String unused = AbsConfigPresenter.this.f12127f = "";
                        String unused2 = AbsConfigPresenter.this.f12126e = "";
                    }
                });
            }
        }
    };
    protected XEResponseCallback mXELogicCallbackAlert = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String a = AbsConfigPresenter.this.f12125d;
            LogUtils.m31493i(a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            AbsConfigPresenter.this.onSuccess(xEngineData.jsonObject, "passenger_newPopup");
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String a = AbsConfigPresenter.this.f12125d;
            LogUtils.m31493i(a, "onFailed:e = " + engineErrorException);
            AbsConfigPresenter.this.onFail(engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallbackSheet = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String a = AbsConfigPresenter.this.f12125d;
            LogUtils.m31493i(a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            AbsConfigPresenter.this.onSuccess(xEngineData.jsonObject, "passenger_newSheet");
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String a = AbsConfigPresenter.this.f12125d;
            LogUtils.m31493i(a, "onFailed:e = " + engineErrorException);
            AbsConfigPresenter.this.onFail(engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallbackToast = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            String a = AbsConfigPresenter.this.f12125d;
            LogUtils.m31493i(a, "onSuccessWithLogic:jsonObject = " + xEngineData.jsonObject);
            AbsConfigPresenter.this.m8191a(xEngineData.jsonObject);
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            String a = AbsConfigPresenter.this.f12125d;
            LogUtils.m31493i(a, "onFailed:e = " + engineErrorException);
            AbsConfigPresenter.this.onFail(engineErrorException);
        }
    };

    /* access modifiers changed from: protected */
    public void onFail(Exception exc) {
    }

    public AbsConfigPresenter(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.mBizCtx = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        String[] strArr = {XERequestKey.SCENE_HOME, XERequestKey.SCENE_ESTIMATE, XERequestKey.SCENE_NEW_ORDER, XERequestKey.SCENE_CONFIRM, XERequestKey.SCENE_CONFIRM_ADDRESS};
        XERegisterModel xERegisterModel = new XERegisterModel("passenger_newSheet", XERequestKey.SCENE_TRIP, this.mXELogicCallbackSheet);
        xERegisterModel.addScene(strArr);
        XERegister.registerTemplate(xERegisterModel);
        XERegisterModel xERegisterModel2 = new XERegisterModel("passenger_newPopup", XERequestKey.SCENE_TRIP, this.mXELogicCallbackAlert);
        xERegisterModel2.addScene(strArr);
        XERegister.registerTemplate(xERegisterModel2);
        XERegisterModel xERegisterModel3 = new XERegisterModel("passenger_toast", XERequestKey.SCENE_TRIP, this.mXELogicCallbackToast);
        xERegisterModel3.addScene(strArr);
        XERegister.registerTemplate(xERegisterModel3);
        BaseEventPublisher.getPublisher().subscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, this.f12130i);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate("passenger_newSheet");
        XERegister.unregisterTemplate("passenger_newPopup");
        XERegister.unregisterTemplate("passenger_toast");
        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, this.f12130i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8191a(JsonObject jsonObject) {
        JsonObject asObject = XEParserUtil.getAsObject("data", jsonObject);
        if (asObject != null) {
            String asString = XEParserUtil.getAsString("toast_content", asObject, "");
            if (!TextUtils.isEmpty(asString)) {
                int asInt = XEParserUtil.getAsInt("type", asObject, 0);
                if (asInt == 0) {
                    LEGOToastHelper.showToast(this.mContext, asString);
                } else if (asInt == 1) {
                    LEGOToastHelper.showShortPosToast(this.mContext, asString);
                } else if (asInt == 2) {
                    LEGOToastHelper.showShortNagToast(this.mContext, asString);
                }
                m8195b(jsonObject);
            }
        }
    }

    /* renamed from: b */
    private void m8195b(JsonObject jsonObject) {
        JsonObject asObject = XEParserUtil.getAsObject("extension", jsonObject);
        if (asObject != null) {
            JsonObject asObject2 = XEParserUtil.getAsObject("log_data", asObject);
            Map hashMap = new HashMap();
            if (asObject2 != null) {
                try {
                    hashMap = (Map) new Gson().fromJson((JsonElement) asObject2, new TypeToken<Map<String, Object>>() {
                    }.getType());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_sw", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onSuccess(JsonObject jsonObject, String str) {
        if (getHost() != null && getHost().getActivity() != null && jsonObject != null) {
            try {
                GGKConfigManager.legoConfig(getHost().getActivity(), new JSONObject(jsonObject.toString()), str, new GGKConfigCallbackAdapter() {
                    public boolean alertWillShow(String str) {
                        if (AbsConfigPresenter.this.f12127f.equals(str)) {
                            return false;
                        }
                        String unused = AbsConfigPresenter.this.f12127f = str;
                        return true;
                    }

                    public boolean sheetWillShow(String str) {
                        if (AbsConfigPresenter.this.f12126e.equals(str)) {
                            return false;
                        }
                        String unused = AbsConfigPresenter.this.f12126e = str;
                        return true;
                    }

                    public boolean alertClickLis(final LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, final ButtonModel buttonModel, String str) {
                        XEngineCommitUtil.configRouterSkip(AbsConfigPresenter.this.mContext, buttonModel, str, new XEngineCommitUtil.RouterFinishedListener() {
                            public void onRouterFinished() {
                                if (buttonModel.nodismiss != 1) {
                                    lEGOBaseAlertDialogFragment.dismiss();
                                }
                            }
                        });
                        return true;
                    }

                    public boolean sheetClickLis(final LEGODrawer lEGODrawer, final ButtonModel buttonModel, String str) {
                        XEngineCommitUtil.configRouterSkip(AbsConfigPresenter.this.mContext, buttonModel, str, new XEngineCommitUtil.RouterFinishedListener() {
                            public void onRouterFinished() {
                                if (buttonModel.nodismiss != 1) {
                                    lEGODrawer.dismiss();
                                    String unused = AbsConfigPresenter.this.f12126e = "";
                                }
                            }
                        });
                        return true;
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
