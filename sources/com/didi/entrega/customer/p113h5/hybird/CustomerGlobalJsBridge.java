package com.didi.entrega.customer.p113h5.hybird;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.biz.scheme.SchemeHelper;
import com.didi.entrega.customer.foundation.rpc.ParamsHelper;
import com.didi.entrega.customer.foundation.share.ShareHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.router.DiRouter;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.web.GlobalJsBridge;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.PhotoJsBridgeData;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.entrega.customer.h5.hybird.CustomerGlobalJsBridge */
public class CustomerGlobalJsBridge extends GlobalJsBridge {

    /* renamed from: a */
    private final Activity f20172a;

    /* access modifiers changed from: protected */
    public void pay(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    public CustomerGlobalJsBridge(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f20172a = hybridableContainer.getActivity();
    }

    public JSONObject getUserInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("phone", LoginUtil.getPhone());
            jSONObject.put("token", LoginUtil.getToken());
            jSONObject.put("uid", LoginUtil.getUid());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void requestLoginJs(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m14858a(jSONObject, callbackFunction);
    }

    public void requestLogoutJs(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m14858a(jSONObject, callbackFunction);
    }

    /* access modifiers changed from: protected */
    public void shareToPlatform(ShareToolModel shareToolModel, final CallbackFunction callbackFunction) {
        ShareHelper.getInstance().shareToPlatform(this.f20172a, shareToolModel, new ICallback.IPlatformShareCallback() {
            public void onCancel(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 2);
            }

            public void onComplete(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 0);
            }

            public void onError(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 1);
            }
        });
    }

    /* access modifiers changed from: protected */
    public JSONObject getGlobalParams() {
        return new JSONObject(ParamsHelper.getCommonParams());
    }

    /* access modifiers changed from: protected */
    public void openPageByPath(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SCHEME).addModuleName("hybrid").addErrorType("null").addErrorMsg("openPageByPath").build().trackError();
        } else {
            SchemeHelper.dispatchMsg(Uri.parse(str), "webPage", str2, false);
        }
    }

    /* access modifiers changed from: protected */
    public int getCityId() {
        return LocationUtil.getCityId();
    }

    /* access modifiers changed from: protected */
    public String getCountyId() {
        return String.valueOf(LocationUtil.getCountyId());
    }

    /* access modifiers changed from: protected */
    public String getCountyGroupId() {
        return String.valueOf(LocationUtil.getCountyGroupId());
    }

    /* access modifiers changed from: protected */
    public String getArea() {
        return LocationUtil.getCityName();
    }

    /* access modifiers changed from: protected */
    public String getServiceProvider() {
        try {
            return SystemUtil.getServiceProvider(this.f20172a);
        } catch (Exception unused) {
            return "None";
        }
    }

    /* access modifiers changed from: protected */
    public void openTransferPage(String str, PhotoJsBridgeData.GetPhotoData getPhotoData) {
        DiRouter.request().path("WebPage/Transfer_Page").putSerializable(str, getPhotoData).open();
    }

    /* access modifiers changed from: protected */
    public double getLatitude() {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(GlobalContext.getContext()).getLastKnownLocation();
        if (lastKnownLocation != null) {
            return lastKnownLocation.getLatitude();
        }
        return 0.0d;
    }

    /* access modifiers changed from: protected */
    public double getLongitude() {
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(GlobalContext.getContext()).getLastKnownLocation();
        if (lastKnownLocation != null) {
            return lastKnownLocation.getLongitude();
        }
        return 0.0d;
    }

    /* access modifiers changed from: protected */
    public String getDeviceId() {
        return CustomerSystemUtil.getDeviceId();
    }

    /* renamed from: a */
    private void m14858a(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        LoginUtil.registerLoginListener(new LoginCallbacks.LoginListener() {
            public void onCancel() {
                LoginUtil.unRegisterLoginListener(this);
                onFinish(false);
            }

            public void onSuccess(Activity activity, String str) {
                LoginUtil.unRegisterLoginListener(this);
                onFinish(true);
            }

            private void onFinish(boolean z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("phone", LoginUtil.getPhone());
                    jSONObject.put("token", LoginUtil.getToken());
                    jSONObject.put("uid", LoginUtil.getUid());
                    CallBackModel callBackModel = new CallBackModel(jSONObject);
                    callBackModel.errno = z ? 0 : 1;
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(callBackModel));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        DIDILocation currentLocation = LocationUtil.getCurrentLocation();
        Bundle bundle = new Bundle();
        if (currentLocation != null) {
            bundle.putString("lat", String.valueOf(currentLocation.getLatitude()));
            bundle.putString("lng", String.valueOf(currentLocation.getLongitude()));
        }
    }
}
