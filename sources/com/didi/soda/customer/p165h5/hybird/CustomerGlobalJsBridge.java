package com.didi.soda.customer.p165h5.hybird;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.didi.app.nova.skeleton.repo.Action2;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.biz.popdialog.HomePopConfigRepo;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.share.ShareHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.p165h5.CustomerWebPage;
import com.didi.soda.customer.p165h5.hybird.module.ContactModule;
import com.didi.soda.customer.p165h5.hybird.tool.ContactUtil;
import com.didi.soda.customer.p165h5.hybird.tool.WebPermissionUtil;
import com.didi.soda.customer.repo.CustomerPermissionResultRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.router.Callback;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Response;
import com.didi.soda.web.GlobalJsBridge;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.PhotoJsBridgeData;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.foundation.p188io.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.soda.customer.h5.hybird.CustomerGlobalJsBridge */
public class CustomerGlobalJsBridge extends GlobalJsBridge {
    public static final String ERROR_MESSAGE_EMPTY_PARAMS = "Empty params!";
    public static final String ERROR_MESSAGE_INVALID_PARAMS = "Invalid params!";
    public static final String ERROR_MESSAGE_INVALID_STATE = "Invalid state!";

    /* renamed from: b */
    private static final String f41311b = "CustomerGlobalJsBridge";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f41312a;

    /* access modifiers changed from: protected */
    public void pay(JSONObject jSONObject, CallbackFunction callbackFunction) {
    }

    public CustomerGlobalJsBridge(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f41312a = hybridableContainer.getActivity();
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
        m29264a(jSONObject, callbackFunction);
    }

    public void requestLogoutJs(JSONObject jSONObject, CallbackFunction callbackFunction) {
        m29264a(jSONObject, callbackFunction);
    }

    /* access modifiers changed from: protected */
    public void shareToPlatform(ShareToolModel shareToolModel, final CallbackFunction callbackFunction) {
        ShareHelper.getInstance().shareToPlatform(this.f41312a, shareToolModel, new ICallback.IPlatformShareCallback() {
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
        Map<String, Object> commonParams = ParamsHelper.getCommonParams();
        Context context = GlobalContext.getContext();
        if (context != null) {
            commonParams.put(ParamsHelper.H5_BRIDGE_STATUS_BAR_HEIGHT, Integer.valueOf(CustomerSystemUtil.getImmersiveStatusBarHeight(context)));
        }
        return new JSONObject(commonParams);
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
            return SystemUtil.getServiceProvider(this.f41312a);
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
    private void m29264a(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject.optInt("dontPopRoot", 0) == 1) {
            LoginUtil.updateLoginPopToRootStatus(false);
        }
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
                ((HomePopConfigRepo) RepoFactory.getRepo(HomePopConfigRepo.class)).setLoginFetchHomePopFlag(true);
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
        if (jSONObject.optInt("needPopup", 1) == 0) {
            ((HomePopConfigRepo) RepoFactory.getRepo(HomePopConfigRepo.class)).setLoginFetchHomePopFlag(false);
        }
        LoginUtil.loginActivityAndTrack(this.f41312a, 2);
    }

    @JsInterface({"faceRecognition"})
    public void faceRecognition(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            LogUtil.m29102e(f41311b, "faceRecognition error: Empty params!");
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_EMPTY_PARAMS, (JSONObject) null)));
            return;
        }
        final String optString = jSONObject.optString("session_id");
        String optString2 = jSONObject.optString("bizcode");
        DiFaceParam diFaceParam = new DiFaceParam();
        JSONObject jSONObject2 = new JSONObject();
        Activity activity = this.mHybridContainer.getActivity();
        if (activity != null) {
            try {
                if (DIDILocationManager.getInstance(activity).getLastKnownLocation() != null) {
                    jSONObject2.put("lat", DIDILocationManager.getInstance(activity).getLastKnownLocation().getLatitude());
                    jSONObject2.put("lng", DIDILocationManager.getInstance(activity).getLastKnownLocation().getLongitude());
                }
                jSONObject2.put("ip", SystemUtil.getIPAddress(activity));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        diFaceParam.setData(jSONObject2.toString());
        diFaceParam.setSessionId(optString);
        try {
            diFaceParam.setBizCode(Integer.parseInt(optString2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        diFaceParam.setToken(LoginUtil.getToken());
        DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback() {
            public void onResult(DiFaceResult diFaceResult) {
                if (diFaceResult != null) {
                    LogUtil.m29104i(CustomerGlobalJsBridge.f41311b, "face result: " + diFaceResult.getCode() + " " + diFaceResult.getMsg());
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("result", diFaceResult.getCode());
                        jSONObject.put("session_id", optString);
                        jSONObject.put("msg", diFaceResult.getMsg());
                    } catch (JSONException e) {
                        LogUtil.m29102e(CustomerGlobalJsBridge.f41311b, e.toString());
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, CustomerGlobalJsBridge.ERROR_MESSAGE_INVALID_STATE, (JSONObject) null)));
                    }
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, jSONObject)));
                }
            }
        });
    }

    @JsInterface({"setNavigationBarStyle"})
    public void setNavigationBarStyle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            LogUtil.m29102e(f41311b, "setNavigationBarStyle error: Empty params!");
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_EMPTY_PARAMS, (JSONObject) null)));
            return;
        }
        String optString = jSONObject.optString("bgColor", "");
        String optString2 = jSONObject.optString("titleColor", "");
        int optInt = jSONObject.optInt("navStyle", 0);
        int optInt2 = jSONObject.optInt("shadowHidden", 0);
        String optString3 = jSONObject.optString("position", "center");
        UpdateUIHandler updateUIHandler = this.mHybridContainer.getUpdateUIHandler();
        if (updateUIHandler instanceof CustomerWebPage) {
            ((CustomerWebPage) updateUIHandler).updateTitleBar(optString, optString2, optInt, optInt2, optString3);
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, (JSONObject) null)));
            return;
        }
        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_INVALID_STATE, (JSONObject) null)));
    }

    @JsInterface({"getAllContacts"})
    public void getAllContacts(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        HandlerThread handlerThread = new HandlerThread("getAllContacts");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() {
            public void run() {
                try {
                    JSONObject contacts2content = ContactUtil.getContacts2content(CustomerGlobalJsBridge.this.f41312a);
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, contacts2content)));
                } catch (JSONException e) {
                    e.printStackTrace();
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.toString(), (JSONObject) null)));
                }
            }
        });
    }

    @JsInterface({"permissionCheck"})
    public void permissionCheck(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            LogUtil.m29102e(f41311b, "permissionCheck error: Empty params!");
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_EMPTY_PARAMS, (JSONObject) null)));
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        for (String str : arrayList) {
            try {
                hashMap.put(str, Integer.valueOf(WebPermissionUtil.permissionGrantedConvert(ActivityCompat.checkSelfPermission(this.mHybridContainer.getActivity(), WebPermissionUtil.permissionConvert(str)))));
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, new JSONObject(hashMap))));
    }

    @JsInterface({"requestPermission"})
    public void requestPermission(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            LogUtil.m29102e(f41311b, "requestPermission error: Empty params!");
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_EMPTY_PARAMS, (JSONObject) null)));
            return;
        }
        try {
            final String string = jSONObject.getString("type");
            String permissionConvert = WebPermissionUtil.permissionConvert(string);
            if (Build.VERSION.SDK_INT < 23) {
                HashMap hashMap = new HashMap();
                hashMap.put(string, 1);
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, new JSONObject(hashMap))));
                return;
            }
            UpdateUIHandler updateUIHandler = this.mHybridContainer.getUpdateUIHandler();
            if (updateUIHandler instanceof CustomerWebPage) {
                ((CustomerPermissionResultRepo) RepoFactory.getRepo(CustomerPermissionResultRepo.class)).subscribeResult(((CustomerWebPage) updateUIHandler).getScopeContext(), new Action2<CustomerPermissionResultRepo.PermissionResult>() {
                    public void call(CustomerPermissionResultRepo.PermissionResult permissionResult, Subscription subscription) {
                        String[] strArr = permissionResult.permissions;
                        int[] iArr = permissionResult.grantResults;
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            if (iArr[i] != 0) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(string, 2);
                                JSONObject jSONObject = new JSONObject(hashMap);
                                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, jSONObject)));
                            } else {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(string, 1);
                                JSONObject jSONObject2 = new JSONObject(hashMap2);
                                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, jSONObject2)));
                            }
                        }
                        subscription.unsubscribe();
                    }
                }, 1000);
            }
            Activity activity = this.mHybridContainer.getActivity();
            if (activity != null) {
                activity.requestPermissions(new String[]{permissionConvert}, 1000);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @JsInterface({"openAddressBook"})
    public void openAddressBook(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ContactModule contactModule = (ContactModule) this.mHybridContainer.getWebView().getExportModuleInstance(ContactModule.class);
        if (contactModule != null) {
            contactModule.openAddressBook(jSONObject, callbackFunction);
            return;
        }
        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_INVALID_STATE, (JSONObject) null)));
    }

    @JsInterface({"openScheme"})
    public void openScheme(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        try {
            String string = jSONObject.getString(PayBaseWebActivity.EXTRA_URL);
            Uri parse = Uri.parse(string);
            if (!parse.isOpaque()) {
                int i = -1;
                try {
                    i = Integer.parseInt(parse.getQueryParameter("forceClose"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Activity activity = this.mHybridContainer.getActivity();
                if (i == 1) {
                    activity.finish();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                DiRouter.request().path(string).open(new Callback() {
                    public void onResponse(Response response) {
                        if (response != null) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("errno", 0);
                                jSONObject.put("data", new JSONObject(JSON.stringify(response)));
                                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, jSONObject)));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, ERROR_MESSAGE_INVALID_PARAMS, (JSONObject) null)));
        }
    }
}
