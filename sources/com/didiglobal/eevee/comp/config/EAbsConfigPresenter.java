package com.didiglobal.eevee.comp.config;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.page.Page;
import com.didi.global.globalgenerickit.config.ButtonModel;
import com.didi.global.globalgenerickit.config.GGKConfigCallbackAdapter;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.xengine.register.XERegister;
import com.didiglobal.common.common.never.component.EeveeCompPresenterImpl;
import com.didiglobal.common.common.xengine.commit.XEngineCommitUtil;
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

public abstract class EAbsConfigPresenter extends EeveeCompPresenterImpl<EAbsConfigView> {

    /* renamed from: a */
    private static final int f50061a = 0;

    /* renamed from: b */
    private static final int f50062b = 1;

    /* renamed from: c */
    private static final int f50063c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f50064d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f50065e = "";
    protected XEResponseCallback mXELogicCallbackAlert = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            EAbsConfigPresenter.this.onSuccess(xEngineData.jsonObject, "passenger_newPopup");
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            EAbsConfigPresenter.this.onFail(engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallbackSheet = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            EAbsConfigPresenter.this.onSuccess(xEngineData.jsonObject, "passenger_newSheet");
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            EAbsConfigPresenter.this.onFail(engineErrorException);
        }
    };
    protected XEResponseCallback mXELogicCallbackToast = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            EAbsConfigPresenter.this.m36067a(xEngineData.jsonObject);
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            EAbsConfigPresenter.this.onFail(engineErrorException);
        }
    };

    /* access modifiers changed from: protected */
    public void onFail(Exception exc) {
    }

    public EAbsConfigPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel("passenger_newSheet", getNodeEeveeID(), this.mXELogicCallbackSheet));
        XERegister.registerTemplate(new XERegisterModel("passenger_newPopup", getNodeEeveeID(), this.mXELogicCallbackAlert));
        XERegister.registerTemplate(new XERegisterModel("passenger_toast", getNodeEeveeID(), this.mXELogicCallbackToast));
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate("passenger_newSheet");
        XERegister.unregisterTemplate("passenger_newPopup");
        XERegister.unregisterTemplate("passenger_toast");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36067a(JsonObject jsonObject) {
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
                m36070b(jsonObject);
            }
        }
    }

    /* renamed from: b */
    private void m36070b(JsonObject jsonObject) {
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
        PageFragment pageFragment;
        FragmentActivity activity;
        if (getNodeParent() != null && getNodeParent().getNodeManager() != null && getNodeParent().getNodeManager().getHostPage() != null) {
            Page hostPage = getNodeParent().getNodeManager().getHostPage();
            if ((hostPage instanceof Fragment) && (pageFragment = (PageFragment) hostPage) != null && pageFragment.getActivity() != null && (activity = pageFragment.getActivity()) != null && jsonObject != null) {
                try {
                    GGKConfigManager.legoConfig(activity, new JSONObject(jsonObject.toString()), str, new GGKConfigCallbackAdapter() {
                        public boolean alertWillShow(String str) {
                            if (EAbsConfigPresenter.this.f50065e.equals(str)) {
                                return false;
                            }
                            String unused = EAbsConfigPresenter.this.f50065e = str;
                            return true;
                        }

                        public boolean sheetWillShow(String str) {
                            if (EAbsConfigPresenter.this.f50064d.equals(str)) {
                                return false;
                            }
                            String unused = EAbsConfigPresenter.this.f50064d = str;
                            return true;
                        }

                        public boolean alertClickLis(final LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment, final ButtonModel buttonModel, String str) {
                            XEngineCommitUtil.configRouterSkip(EAbsConfigPresenter.this.mContext, buttonModel, str, new XEngineCommitUtil.RouterFinishedListener() {
                                public void onRouterFinished() {
                                    if (buttonModel.nodismiss != 1) {
                                        lEGOBaseAlertDialogFragment.dismiss();
                                    }
                                }
                            });
                            return true;
                        }

                        public boolean sheetClickLis(final LEGODrawer lEGODrawer, final ButtonModel buttonModel, String str) {
                            XEngineCommitUtil.configRouterSkip(EAbsConfigPresenter.this.mContext, buttonModel, str, new XEngineCommitUtil.RouterFinishedListener() {
                                public void onRouterFinished() {
                                    if (buttonModel.nodismiss != 1) {
                                        lEGODrawer.dismiss();
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
}
