package com.didi.global.globalgenerickit;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.dialog.GGKBaseDialogModel;
import com.didi.global.globalgenerickit.dialog.GGKCustomFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogFragment;
import com.didi.global.globalgenerickit.dialog.GGKDialogModel3;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.model.ComponentConfigBannerModel;
import com.didi.global.globalgenerickit.model.ComponentConfigBubbleModel;
import com.didi.global.globalgenerickit.model.ComponentConfigDialogModel;
import com.didi.global.globalgenerickit.model.ComponentConfigPopModel;
import com.didi.global.globalgenerickit.model.sheet.ComponentSheet;
import com.didi.global.globalgenerickit.net.BffRequest;
import com.didi.global.globalgenerickit.net.ParamKeys;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globalgenerickit.utils.OmegaUtils;
import com.didi.global.globalgenerickit.view.ComponentConfigBannerView;
import com.google.gson.Gson;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ComponentConfigManager {
    public static final String BUSINESS_SCENE_CANCEL = "pCanceled";
    public static final String BUSINESS_SCENE_END = "pEnd";
    public static final String BUSINESS_SCENE_ESTIMATE = "pEstimate";
    public static final String BUSINESS_SCENE_HOME = "pHome";
    public static final String BUSINESS_SCENE_ON_TRIP = "pOnTrip";
    public static final String BUSINESS_SCENE_PICK_UP = "pWaitingForPickup";
    public static final String BUSINESS_SCENE_TAKE_CAR_PLACE = "pTakeCarPlace";
    public static final String BUSINESS_SCENE_WAIT = "pWait";

    public interface CusEventListener {
        boolean onEvent(GGKCustomFragment gGKCustomFragment, String str, String str2, Map<String, Object> map);
    }

    public static void showComponentConfigDialogWithCusListener(FragmentActivity fragmentActivity, Map<String, Object> map, String str, CusEventListener cusEventListener) {
        showCompoentConfigDialog(fragmentActivity, map, str, "", cusEventListener);
    }

    public static void showCompoentConfigDialog(FragmentActivity fragmentActivity, Map<String, Object> map, String str) {
        showCompoentConfigDialog(fragmentActivity, map, str, "", (CusEventListener) null);
    }

    public static void showCompoentConfigDialog(final FragmentActivity fragmentActivity, Map<String, Object> map, String str, String str2, final CusEventListener cusEventListener) {
        BffRequest.requestCompoentConfig(fragmentActivity, map, str, str2, new BffResponseListener<ComponentConfigPopModel>() {
            public void onSuccess(ComponentConfigPopModel componentConfigPopModel) {
                super.onSuccess(componentConfigPopModel);
                if (componentConfigPopModel != null && componentConfigPopModel.isAvailable() && componentConfigPopModel.popUps != null && componentConfigPopModel.popUps.size() > 0) {
                    for (ComponentConfigDialogModel next : componentConfigPopModel.popUps) {
                        if (next.isNative()) {
                            ComponentConfigManager.m15974b(fragmentActivity, next);
                        } else if (next.isXml()) {
                            ComponentConfigManager.m15975b(fragmentActivity, next, cusEventListener);
                        }
                    }
                }
            }
        });
    }

    public static void showComponentSheetConfigDialog(Context context, Map<String, Object> map, String str, BffResponseListener<ComponentSheet> bffResponseListener) {
        BffRequest.requestSheetComponentConfig(context, map, str, bffResponseListener);
    }

    public static void showCompoentConfigDialog(FragmentActivity fragmentActivity, JSONObject jSONObject, CusEventListener cusEventListener) {
        JSONArray optJSONArray = jSONObject.optJSONArray(ParamKeys.PARAM_PASSENGER_POPUP);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                if (optJSONArray.optJSONObject(i) != null) {
                    ComponentConfigDialogModel componentConfigDialogModel = (ComponentConfigDialogModel) new Gson().fromJson(optJSONArray.optJSONObject(i).toString(), ComponentConfigDialogModel.class);
                    componentConfigDialogModel.parse(componentConfigDialogModel);
                    if (componentConfigDialogModel.isNative()) {
                        m15974b(fragmentActivity, componentConfigDialogModel);
                    } else if (componentConfigDialogModel.isXml()) {
                        m15975b(fragmentActivity, componentConfigDialogModel, cusEventListener);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15974b(final FragmentActivity fragmentActivity, final ComponentConfigDialogModel componentConfigDialogModel) {
        componentConfigDialogModel.parse(componentConfigDialogModel);
        if (componentConfigDialogModel.businessData != null) {
            GGKBaseDialogModel imageUrl = new GGKDialogModel3(componentConfigDialogModel.businessData.title, componentConfigDialogModel.businessData.showMsg).setImageUrl(componentConfigDialogModel.businessData.image);
            final GGKDialogFragment showDialogModel = GGKUICreator.showDialogModel(fragmentActivity.getSupportFragmentManager(), imageUrl, ComponentConfigDialogModel.class.getName());
            if (componentConfigDialogModel.businessData.options != null) {
                for (final ComponentConfigDialogModel.ComponentConfigDialogOptionModel next : componentConfigDialogModel.businessData.options) {
                    imageUrl.addMinorBtn(new GGKBtnTextAndCallback(next.text, new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            if (!TextUtils.isEmpty(next.url)) {
                                DRouter.build(next.url).start(fragmentActivity);
                            }
                            showDialogModel.dismiss();
                            ComponentConfigDialogModel componentConfigDialogModel = componentConfigDialogModel;
                            OmegaUtils.trackComponentConfigDialogCK(componentConfigDialogModel, next.type + "");
                        }
                    }));
                }
            }
            showDialogModel.setCancelable(true);
            OmegaUtils.trackComponentConfigDialogSW(componentConfigDialogModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15975b(final FragmentActivity fragmentActivity, final ComponentConfigDialogModel componentConfigDialogModel, CusEventListener cusEventListener) {
        componentConfigDialogModel.parse(componentConfigDialogModel);
        if (componentConfigDialogModel.businessData == null) {
            final GGKCustomFragment gGKCustomFragment = new GGKCustomFragment();
            final GGKData gGKData = new GGKData(componentConfigDialogModel.f22193id, componentConfigDialogModel.template, componentConfigDialogModel.cdn, componentConfigDialogModel.data, componentConfigDialogModel.extension);
            gGKData.setCDNCallback(new GGKData.CDNCallback() {
                public void onCDNCached() {
                    ComponentConfigManager.m15976b(fragmentActivity, componentConfigDialogModel, gGKCustomFragment, gGKData);
                }
            });
            final CusEventListener cusEventListener2 = cusEventListener;
            final GGKCustomFragment gGKCustomFragment2 = gGKCustomFragment;
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            final ComponentConfigDialogModel componentConfigDialogModel2 = componentConfigDialogModel;
            gGKData.setEventListener(new CommonEventListener(gGKData) {
                public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                    CusEventListener cusEventListener = cusEventListener2;
                    if (cusEventListener != null && cusEventListener.onEvent(gGKCustomFragment2, str, str2, map)) {
                        return true;
                    }
                    DRouter.build(str2).start(fragmentActivity2);
                    GGKCustomFragment gGKCustomFragment = gGKCustomFragment2;
                    if (gGKCustomFragment != null) {
                        gGKCustomFragment.dismiss();
                    }
                    String str3 = "xpanel_card_ck";
                    if (!str3.equals(str)) {
                        str3 = map.containsKey(Const.BUTTON_ID) ? (String) map.get(Const.BUTTON_ID) : "";
                    }
                    OmegaUtils.trackComponentConfigDialogCK(componentConfigDialogModel2, str3);
                    return true;
                }
            });
            m15976b(fragmentActivity, componentConfigDialogModel, gGKCustomFragment, gGKData);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m15976b(FragmentActivity fragmentActivity, ComponentConfigDialogModel componentConfigDialogModel, GGKCustomFragment gGKCustomFragment, GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(fragmentActivity, gGKData);
        if (createTemplateView != null && gGKCustomFragment != null) {
            gGKCustomFragment.setRootView(createTemplateView.getView());
            gGKCustomFragment.show(fragmentActivity.getSupportFragmentManager(), ComponentConfigDialogModel.class.getName());
            gGKCustomFragment.setCancelable(false);
            OmegaUtils.trackComponentConfigDialogSW(componentConfigDialogModel);
        }
    }

    public static ComponentConfigBannerView getCompoentConfigBannerView(FragmentActivity fragmentActivity, JSONObject jSONObject) {
        JSONArray optJSONArray;
        ComponentConfigBannerView componentConfigBannerView = new ComponentConfigBannerView(fragmentActivity);
        if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("passenger_bubble")) == null || optJSONArray.optJSONObject(0) == null)) {
            ComponentConfigBannerModel componentConfigBannerModel = (ComponentConfigBannerModel) new Gson().fromJson(optJSONArray.optJSONObject(0).toString(), ComponentConfigBannerModel.class);
            componentConfigBannerModel.parse(componentConfigBannerModel);
            componentConfigBannerView.setData(componentConfigBannerModel);
            OmegaUtils.trackComponentConfigBannerSW(componentConfigBannerModel);
        }
        return componentConfigBannerView;
    }

    public static ComponentConfigBubbleModel getCompoentConfigBubbleModel(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("passenger_bubble");
        if (optJSONArray == null || optJSONArray.length() == 0 || optJSONArray.optJSONObject(0) == null) {
            return null;
        }
        ComponentConfigBubbleModel componentConfigBubbleModel = (ComponentConfigBubbleModel) new Gson().fromJson(optJSONArray.optJSONObject(0).toString(), ComponentConfigBubbleModel.class);
        componentConfigBubbleModel.parse(componentConfigBubbleModel);
        return componentConfigBubbleModel;
    }
}
