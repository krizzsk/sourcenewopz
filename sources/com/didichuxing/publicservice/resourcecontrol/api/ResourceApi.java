package com.didichuxing.publicservice.resourcecontrol.api;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.FutureTarget;
import com.didi.dynamic.manager.DownloadManager;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.jsbridge.WebViewJavascriptBridge;
import com.didi.onehybrid.resource.offline.FusionContract;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.general.SecutityKey;
import com.didichuxing.publicservice.network.HttpHelper;
import com.didichuxing.publicservice.resourcecontrol.dialogfragments.AssetPopwindowDialogFragment;
import com.didichuxing.publicservice.resourcecontrol.dialogfragments.PublicServiceModel;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import com.didichuxing.publicservice.resourcecontrol.pojo.RCRequestParams;
import com.didichuxing.publicservice.resourcecontrol.pojo.SdkDevice;
import com.didichuxing.publicservice.resourcecontrol.utils.RequestUtils;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.resourcecontrol.utils.RoamingManager;
import com.didichuxing.publicservice.screenAd.ScreenAdManager;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.xcard.loader.IXMLLoaderTrackCallback;
import com.didichuxing.xpanel.xcard.loader.IXMLoaderCallback;
import com.didichuxing.xpanel.xcard.loader.XCardManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import rui.config.RConfigConstants;

public class ResourceApi {
    private static final int MSG_NOTIFY_POPUP_SHOW = 101;
    private static final int MSG_NOTIFY_SPLASH_SHOW = 102;
    public static final String POPUP_DIMENSION = "res_popup";
    public static final String POPUP_XML_TEMPLATE = "res_popup_template";
    public static final int PUBLIC_NOTICE_BIZ_ID = 256;
    /* access modifiers changed from: private */

    /* renamed from: SP */
    public static SharedPreferences f48491SP = null;
    public static final String SPLASH_DIMENSION = "res_splash";
    private static final long SPLASH_INTERVAL = 7200000;
    public static final String SPLASH_XML_TEMPLATE = "res_splash_template";
    /* access modifiers changed from: private */
    public static final String TAG = ResourceApi.class.getSimpleName();
    public static boolean isFromSlashActvity = false;
    /* access modifiers changed from: private */
    public static IBffProxy.Ability mBusinessPopupAbility;
    /* access modifiers changed from: private */
    public static boolean mHasUniversalPop;
    /* access modifiers changed from: private */
    public static IBffProxy.Ability mPublicPopupAbility;
    public static Handler mResourceHandler = new ResourceHandler();
    /* access modifiers changed from: private */
    public static XCardManager mXCardManager = XCardManager.getInstance();
    /* access modifiers changed from: private */
    public static DPopResource prePopResource;
    /* access modifiers changed from: private */
    public static List<DSplashResource.DataBean> preSplashResourceData;
    /* access modifiers changed from: private */
    public static ConstantUtils.ResourceId sPopResourceId;

    public interface OnPopUpCommercialShownCallback {
        boolean canShowPopUpCommercial(DPopResource dPopResource);
    }

    public interface OnSplashListener {
        void onDisplaySplash();

        void onSplashCloseOrAbsent();
    }

    public static void setResourceLocaleIsPt(boolean z) {
        ResourceLocale.setResourceLocaleIsPt(z);
    }

    public static void switchURLEnvironment(ConstantUtils.URLEnvironment uRLEnvironment) {
        ConstantUtils.URL_ENVIRONMENT = uRLEnvironment;
        if (uRLEnvironment == ConstantUtils.URLEnvironment.ONLINE) {
            ConstantUtils.URL_RC_SERVER = ConstantUtils.getRCServerUrl();
        } else if (uRLEnvironment == ConstantUtils.URLEnvironment.OFFLINE) {
            ConstantUtils.URL_RC_SERVER = ConstantUtils.URL_RC_SERVER_DEBUG;
        }
    }

    public static void initResourceSDK(RCRequestParams rCRequestParams, Activity activity, SdkDevice sdkDevice) {
        if (rCRequestParams == null) {
            AppUtils.log(TAG + " -> initResourceSDK ========== please check the params are correct...");
            return;
        }
        boolean containsKey = WebViewJavascriptBridge.namespaceMap.containsKey("DADForceShowActivityModule");
        AppUtils.log("reg model,contains key = " + containsKey);
        if (!containsKey) {
            FusionEngine.export("DADForceShowActivityModule", PublicServiceModel.class);
        }
        if (activity != null) {
            ResourceManager.getManager().setActivity(activity);
            ResourceManager.getManager().setApplication(activity.getApplication());
        }
        ResourceManager.getManager().setRcRequestParams(rCRequestParams);
        ResourceManager.getManager().initBusinessInfo(rCRequestParams);
        if (sdkDevice != null) {
            ResourceManager.getManager().setDevice(sdkDevice);
        }
    }

    public static void resetLanguage(String str) {
        SdkDevice device = ResourceManager.getManager().getDevice();
        if (device != null) {
            device.lang = str;
        }
    }

    /* access modifiers changed from: private */
    public static void saveString(SharedPreferences sharedPreferences, String str, String str2) {
        if (sharedPreferences != null && !TextUtils.isEmpty(str)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static Map getMapFromString(SharedPreferences sharedPreferences, String str) {
        if (sharedPreferences == null) {
            return null;
        }
        return (Map) new Gson().fromJson(sharedPreferences.getString(str, ""), HashMap.class);
    }

    public static void saveArray(SharedPreferences sharedPreferences, String str, List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i != size - 1) {
                    sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                }
            }
            saveString(sharedPreferences, str, sb.toString());
        }
    }

    public static List<String> getListFromString(SharedPreferences sharedPreferences, String str) {
        ArrayList arrayList = new ArrayList();
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                for (String add : string.split(RConfigConstants.KEYWORD_COLOR_SIGN)) {
                    arrayList.add(add);
                }
            }
        }
        return arrayList;
    }

    private static void getSplashFromInternet(final Context context, final String str) {
        List<DSplashResource.DataBean> list = preSplashResourceData;
        if (list != null) {
            list.clear();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_NAME, str);
        hashMap.put("nl", "1");
        mXCardManager.bindIXMLoaderCallback(SPLASH_DIMENSION, new IXMLoaderCallback() {
            public void onTaskComplete(boolean z) {
                Activity activity = ResourceManager.getManager().getActivity();
                if (activity != null) {
                    boolean z2 = true;
                    if (ResourceApi.preSplashResourceData != null) {
                        for (DSplashResource.DataBean dataBean : ResourceApi.preSplashResourceData) {
                            if (!(dataBean == null || dataBean.data == null)) {
                                if (ScreenAdManager.getInstance().isSingleResourceExists(context, (long) dataBean.activity_id)) {
                                    LogcatUtil.m35794d(ScreenAdManager.TAG, "@onTaskComplete, exist single resource|" + dataBean);
                                } else {
                                    z2 &= ResourceApi.prepareSplashXmlSingle(activity, dataBean);
                                }
                            }
                        }
                        if (z2 && ResourceApi.preSplashResourceData.size() > 0) {
                            LogcatUtil.m35796i(ResourceApi.TAG, "@getSplashFromInternet, xml 已加载完成");
                            ResourceApi.preSplashResourceData.clear();
                            ResourceApi.mXCardManager.unBindIXMLoaderCallback(ResourceApi.SPLASH_DIMENSION);
                        }
                    }
                }
            }
        });
        RequestUtils.postRequestNotAddPublicParams(ConstantUtils.URL_RC_PRELOAD_SPLASH_RESOURCE, hashMap, new HttpHelper.RequestCallBack() {
            public void onSuccess(final HttpHelper.HttpResult httpResult) {
                AppUtils.log("ScreenAdManager  getPreloadingResource onSuccess");
                ScreenAdManager.getInstance().submitTask(new Runnable() {
                    public void run() {
                        DSplashResource dSplashResource = (DSplashResource) AppUtils.parseResultData(httpResult, DSplashResource.class);
                        if (ResourceApi.isEmptySplashResouce(dSplashResource)) {
                            AppUtils.log("ScreenAdManager  no new resource");
                            ScreenAdManager.getInstance().deleteAllResourceSync(context);
                            return;
                        }
                        for (DSplashResource.DataBean next : dSplashResource.data) {
                            HashMap hashMap = new HashMap();
                            String valueOf = String.valueOf(next.activity_id);
                            hashMap.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_NAME, str);
                            hashMap.put(CommonBIUtil.KEY_ACDID, valueOf);
                            hashMap.putAll(next.log_data);
                            ResourceApi.saveString(ResourceApi.f48491SP, valueOf, new Gson().toJson((Object) next.log_data));
                            SharedPreferences access$600 = ResourceApi.f48491SP;
                            ResourceApi.saveArray(access$600, valueOf + "imp", next.imp_tracks);
                            SharedPreferences access$6002 = ResourceApi.f48491SP;
                            ResourceApi.saveArray(access$6002, valueOf + "click", next.click_tracks);
                            SharedPreferences access$6003 = ResourceApi.f48491SP;
                            ResourceApi.saveArray(access$6003, valueOf + "close", next.close_tracks);
                            hashMap.put("key", ConstantUtils.PASSAGER_RESOURCE_NAME);
                            OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_BUB_ACT_SUS_REQ, (Map<String, Object>) hashMap);
                        }
                        ResourceApi.removeInValidLocalResource(dSplashResource, context);
                        List unused = ResourceApi.preSplashResourceData = dSplashResource.data;
                        for (DSplashResource.DataBean next2 : dSplashResource.data) {
                            if (!(next2 == null || next2.data == null)) {
                                if (ScreenAdManager.getInstance().isSingleResourceExists(context, (long) next2.activity_id)) {
                                    LogcatUtil.m35796i(ScreenAdManager.TAG, "  exist single resource|" + next2);
                                } else if (!TextUtils.isEmpty(next2.cdn)) {
                                    boolean unused2 = ResourceApi.prepareSplashXmlSingle(context, next2);
                                } else {
                                    DSplashResource.DataDetail dataDetail = next2.getDataDetail();
                                    if (dataDetail.image != null && !TextUtils.isEmpty(dataDetail.image.trim()) && next2.activity_id >= 0) {
                                        dataDetail.localPath = ScreenAdManager.getInstance().getLocalPath(context, dataDetail.image.trim());
                                        AppUtils.log("ScreenAdManager  insert single resource|" + next2);
                                        ScreenAdManager.getInstance().insertSingleResourceSync(context, next2);
                                        FutureTarget<File> downloadOnly = Glide.with(context).load(dataDetail.image.trim()).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE);
                                        if (downloadOnly != null) {
                                            try {
                                                if (downloadOnly.get() != null && !TextUtils.isEmpty(((File) downloadOnly.get()).getAbsolutePath())) {
                                                    String absolutePath = ((File) downloadOnly.get()).getAbsolutePath();
                                                    ScreenAdManager.getInstance().updateLocalPath(context, (long) next2.activity_id, absolutePath);
                                                    AppUtils.log("ScreenAdManager  preload resource success path >>>>" + absolutePath);
                                                }
                                            } catch (Exception unused3) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }

            public void onFail() {
                AppUtils.log("ScreenAdManager  getPreloadingResource onFail");
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    public static void removeInValidLocalResource(DSplashResource dSplashResource, Context context) {
        DSplashResource allResource = ScreenAdManager.getInstance().getAllResource(context);
        if (!isEmptyResouce(allResource)) {
            for (int i = 0; i < allResource.data.size(); i++) {
                DSplashResource.DataBean dataBean = allResource.data.get(i);
                int i2 = 0;
                while (i2 < dSplashResource.data.size() && dSplashResource.data.get(i2).activity_id != dataBean.activity_id) {
                    i2++;
                }
                if (i2 == dSplashResource.data.size()) {
                    ScreenAdManager.getInstance().deleteSingleResourceSync(context, (long) dataBean.activity_id);
                }
            }
        }
    }

    public static void showSplashComercial(final Activity activity, final SdkDevice sdkDevice, ConstantUtils.ResourceId resourceId, final String str, final OnSplashListener onSplashListener) {
        if (activity == null || sdkDevice == null || resourceId == null || resourceId != ConstantUtils.ResourceId.SPLASH || activity.isFinishing()) {
            AppUtils.log("ScreenAdManager ------> passed null parameters ========= ");
        } else if (ResourceManager.APP_ID != ConstantUtils.AppId.ECHO_PASSENGER) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    DSplashResource.DataBean dataBean;
                    final DSplashResource availableResource = ScreenAdManager.getInstance().getAvailableResource(activity.getApplicationContext());
                    if (!ResourceApi.isEmptyResouce(availableResource) && (dataBean = availableResource.data.get(0)) != null && !TextUtils.isEmpty(dataBean.cdn)) {
                        XCardManager.getInstance().createCacheFromLocal(ResourceApi.SPLASH_XML_TEMPLATE, dataBean.cdn);
                    }
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            if (activity != null && !activity.isFinishing()) {
                                ResourceApi.showSplash(activity, sdkDevice, str, onSplashListener, availableResource);
                            }
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void showSplash(Activity activity, SdkDevice sdkDevice, String str, OnSplashListener onSplashListener, DSplashResource dSplashResource) {
        boolean isEmptyResouce = isEmptyResouce(dSplashResource);
        AppUtils.log("available resource = " + dSplashResource + ", emptySource = " + isEmptyResouce);
        if (isEmptyResouce) {
            onSplashListener.onSplashCloseOrAbsent();
            updateAndDeleteSplash(activity, sdkDevice, str);
            return;
        }
        DSplashResource.DataBean dataBean = dSplashResource.data.get(dSplashResource.data.size() - 1);
        if (TextUtils.isEmpty(dataBean.cdn)) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = dataBean.dataDetail.lastShowTime;
            if (currentTimeMillis <= j) {
                ScreenAdManager.getInstance().updateLastShowTime(activity.getApplicationContext(), dSplashResource, currentTimeMillis);
            } else if (!ResourceLocale.isResourceLocaleIsGl() && !ResourceLocale.isResourceLocaleIsPt() && currentTimeMillis - j < SPLASH_INTERVAL && onSplashListener != null) {
                onSplashListener.onSplashCloseOrAbsent();
                return;
            }
            randomShow(dSplashResource);
        }
        ResourceManager.getManager().setActivity(activity);
        isFromSlashActvity = true;
        ResourceManager.getManager().displaySplashResource(dSplashResource, onSplashListener);
        updateAndDeleteSplash(activity, sdkDevice, str);
    }

    private static void updateAndDeleteSplash(Activity activity, SdkDevice sdkDevice, String str) {
        ResourceManager.getManager().setApplication(activity.getApplication());
        ResourceManager.getManager().setDevice(sdkDevice);
        f48491SP = SystemUtils.getPreferences(activity, 0);
        getSplashFromInternet(activity.getApplicationContext(), str);
        ScreenAdManager.getInstance().deleteExpiredResource(activity.getApplication());
    }

    private static void randomShow(DSplashResource dSplashResource) {
        int i = 0;
        while (i < dSplashResource.data.size() && dSplashResource.data.get(0).dataDetail.lastShowTime == dSplashResource.data.get(i).dataDetail.lastShowTime) {
            i++;
        }
        if (i != 1) {
            int nextInt = new Random().nextInt(i);
            dSplashResource.data.add(0, dSplashResource.data.remove(nextInt));
        }
    }

    private static IBffProxy.Ability requestBaseResource(String str, String str2, int i, String str3, HttpHelper.RequestCallBack requestCallBack) {
        RCRequestParams rcRequestParams = ResourceManager.getManager().getRcRequestParams();
        HashMap<String, Object> createSig = createSig(rcRequestParams, str2, i);
        if (rcRequestParams != null && !TextUtils.isEmpty(rcRequestParams.groupType)) {
            createSig.put("groupType", rcRequestParams.groupType);
        }
        return RequestUtils.requestPopup(str, str3, createSig, requestCallBack);
    }

    private static HashMap<String, Object> createSig(RCRequestParams rCRequestParams, String str, int i) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_NAME, str);
        hashMap.put(DownloadManager.KEY_APP_KEY, ResourceManager.getAppKey());
        hashMap.put("business_id", String.valueOf(i));
        hashMap.put("imei", ResourceManager.IMEI);
        SdkDevice device = ResourceManager.getManager().getDevice();
        if (device != null) {
            hashMap.put("height", Integer.valueOf(device.resolutionLength));
            hashMap.put("width", Integer.valueOf(device.resolutionWidth));
            if (device.cityId > 0) {
                hashMap.put("city_id", Integer.valueOf(device.cityId));
            }
        }
        if (rCRequestParams != null) {
            hashMap.put("token", rCRequestParams.token);
            hashMap.put("lng", rCRequestParams.lng + "");
            hashMap.put("lat", rCRequestParams.lat + "");
        } else {
            AppUtils.log(TAG + "@requestBaseResource ================ rcRequestParams = null...");
        }
        hashMap.put("interface_tag", "notice_special");
        hashMap.put("sig", SecutityKey.getInstance().renderSignatureStr(hashMap, ResourceManager.SECRET));
        return hashMap;
    }

    public static void showPopUpAnyWhere(ConstantUtils.ResourceId resourceId, String str) {
        showPopUpCommercial(resourceId, RoamingManager.mapResourceName(str), 256, (OnPopUpCommercialShownCallback) null);
    }

    public static void showPopUpCommercial(ConstantUtils.ResourceId resourceId, String str, int i) {
        showPopUpCommercial(resourceId, RoamingManager.mapResourceName(str), i, (OnPopUpCommercialShownCallback) null);
    }

    public static void showPopupByService(ConstantUtils.ResourceId resourceId, String str, int i, String str2) {
        showPopupInner(resourceId, str, i, str2, (OnPopUpCommercialShownCallback) null);
    }

    private static void showPopupInner(final ConstantUtils.ResourceId resourceId, String str, int i, String str2, final OnPopUpCommercialShownCallback onPopUpCommercialShownCallback) {
        AppUtils.log("showPopUpCommercial resourceId = " + resourceId);
        prePopResource = null;
        sPopResourceId = resourceId;
        if (!ResourceManager.startActivityByCache(resourceId, 1003, ConstantUtils.POPWINDOW_RESOURCE) && !ResourceManager.startActivityByCache(resourceId, 1004, ConstantUtils.WEBVIEW_RESOURCE)) {
            mXCardManager.bindIXMLoaderCallback(POPUP_DIMENSION, new IXMLoaderCallback() {
                public void onTaskComplete(boolean z) {
                    if (ResourceManager.getManager().getActivity() != null && ResourceApi.prePopResource != null && ResourceApi.preparePopXmlList(ResourceApi.prePopResource.data) && ResourceApi.prePopResource.data != null && ResourceApi.prePopResource.data.length > 0) {
                        String access$300 = ResourceApi.TAG;
                        LogcatUtil.m35796i(access$300, "xml 已加载完成，开始展示弹窗， resourceId=" + resourceId.getId());
                        ResourceApi.mXCardManager.unBindIXMLoaderCallback(ResourceApi.POPUP_DIMENSION);
                        ResourceApi.startActivityByResourceId(ResourceApi.prePopResource, 1003, resourceId);
                    }
                }
            });
            if (resourceId == ConstantUtils.ResourceId.NOTICE_PUBLIC) {
                getPublicNotice(resourceId, i, str, str2);
                return;
            }
            mBusinessPopupAbility = requestBaseResource("passenger/pResGetRuledTag", RoamingManager.mapResourceName(str), i, str2, new HttpHelper.RequestCallBack() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onSuccess(com.didichuxing.publicservice.network.HttpHelper.HttpResult r6) {
                    /*
                        r5 = this;
                        java.lang.String r0 = "data"
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = " "
                        r1.append(r2)
                        java.lang.String r2 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                        r1.append(r2)
                        java.lang.String r2 = " ----- tab pop --- ======= showPopUpCommercial -> onSuccess : "
                        r1.append(r2)
                        r1.append(r6)
                        java.lang.String r1 = r1.toString()
                        com.didichuxing.publicservice.general.AppUtils.log(r1)
                        r1 = 0
                        com.android.didi.bfflib.IBffProxy.Ability unused = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mBusinessPopupAbility = r1
                        java.lang.String r2 = r6.getOriginJson()     // Catch:{ Exception -> 0x005a }
                        org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
                        r3.<init>(r2)     // Catch:{ Exception -> 0x005a }
                        org.json.JSONObject r2 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x005a }
                        if (r2 == 0) goto L_0x0050
                        org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x005a }
                        r4.<init>()     // Catch:{ Exception -> 0x005a }
                        r4.put(r2)     // Catch:{ Exception -> 0x005a }
                        r3.putOpt(r0, r4)     // Catch:{ Exception -> 0x005a }
                        java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x004e }
                        java.lang.Class<com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource> r0 = com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource.class
                        java.lang.Object r6 = com.didichuxing.publicservice.general.AppUtils.parseJson(r6, r0)     // Catch:{ Exception -> 0x004e }
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource r6 = (com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource) r6     // Catch:{ Exception -> 0x004e }
                        r1 = r6
                        goto L_0x0063
                    L_0x004e:
                        goto L_0x0063
                    L_0x0050:
                        java.lang.Class<com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource> r0 = com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource.class
                        java.lang.Object r0 = com.didichuxing.publicservice.general.AppUtils.parseResultData(r6, r0)     // Catch:{ Exception -> 0x005a }
                        r1 = r0
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource r1 = (com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource) r1     // Catch:{ Exception -> 0x005a }
                        goto L_0x0063
                    L_0x005a:
                        java.lang.Class<com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource> r0 = com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource.class
                        java.lang.Object r6 = com.didichuxing.publicservice.general.AppUtils.parseResultData(r6, r0)
                        r1 = r6
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource r1 = (com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource) r1
                    L_0x0063:
                        if (r1 == 0) goto L_0x0111
                        int r6 = r1.errno
                        if (r6 != 0) goto L_0x0111
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r6 = r1.data
                        if (r6 == 0) goto L_0x0111
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r6 = r1.data
                        int r6 = r6.length
                        if (r6 != 0) goto L_0x0074
                        goto L_0x0111
                    L_0x0074:
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource unused = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.prePopResource = r1
                        java.lang.StringBuilder r6 = new java.lang.StringBuilder
                        r6.<init>()
                        java.lang.String r0 = com.didichuxing.publicservice.general.ConstantUtils.POPWINDOW_RESOURCE
                        r6.append(r0)
                        com.didichuxing.publicservice.general.ConstantUtils$ResourceId r0 = r3
                        int r0 = r0.getId()
                        r6.append(r0)
                        java.lang.String r6 = r6.toString()
                        r0 = 1003(0x3eb, float:1.406E-42)
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r2 = r1.data
                        r3 = 0
                        r2 = r2[r3]
                        java.lang.Object r2 = r2.data
                        if (r2 == 0) goto L_0x00d7
                        com.didichuxing.publicservice.resourcecontrol.api.ResourceApi$OnPopUpCommercialShownCallback r2 = r7
                        if (r2 == 0) goto L_0x00d7
                        boolean r2 = r2.canShowPopUpCommercial(r1)
                        if (r2 != 0) goto L_0x00d7
                        com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager r2 = com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager.getManager()
                        android.app.Application r2 = r2.getApplication()
                        com.didichuxing.publicservice.general.AppUtils.setObjectToSPreference(r2, r6, r1)
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = ""
                        r1.append(r2)
                        java.lang.String r2 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                        r1.append(r2)
                        java.lang.String r2 = " set cache resource ,key = "
                        r1.append(r2)
                        r1.append(r6)
                        java.lang.String r6 = ", code = "
                        r1.append(r6)
                        r1.append(r0)
                        java.lang.String r6 = r1.toString()
                        com.didichuxing.publicservice.general.AppUtils.log(r6)
                        return
                    L_0x00d7:
                        com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r6 = r1.data
                        boolean r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.preparePopXmlList(r6)
                        r2 = 101(0x65, float:1.42E-43)
                        if (r6 == 0) goto L_0x00f5
                        java.lang.String r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                        java.lang.String r3 = "请求业务线弹窗, 数据准备完毕，开始展示弹窗资源位"
                        com.didichuxing.xpanel.util.LogcatUtil.m35796i(r6, r3)
                        com.didichuxing.publicservice.general.ConstantUtils$ResourceId r6 = r3
                        com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.startActivityByResourceId(r1, r0, r6)
                        android.os.Handler r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mResourceHandler
                        r6.removeMessages(r2)
                        goto L_0x0111
                    L_0x00f5:
                        java.lang.String r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                        java.lang.String r1 = "请求业务线弹窗, 数据准备未准备完毕存在cdn卡片 放置timer"
                        com.didichuxing.xpanel.util.LogcatUtil.m35796i(r6, r1)
                        android.os.Message r6 = android.os.Message.obtain()
                        r6.what = r2
                        r6.arg1 = r0
                        com.didichuxing.publicservice.general.ConstantUtils$ResourceId r0 = r3
                        r6.obj = r0
                        android.os.Handler r0 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mResourceHandler
                        r1 = 2500(0x9c4, double:1.235E-320)
                        r0.sendMessageDelayed(r6, r1)
                    L_0x0111:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.C162175.onSuccess(com.didichuxing.publicservice.network.HttpHelper$HttpResult):void");
                }

                public void onFail() {
                    AppUtils.log(" " + ResourceApi.TAG + " ----- tab pop --- ====== showPopUpCommercial -> onFail");
                }
            });
        }
    }

    public static void cancelGroupAbility() {
        IBffProxy.Ability ability = mPublicPopupAbility;
        if (ability != null && TextUtils.isEmpty(ability.getServiceId())) {
            LogcatUtil.m35796i(TAG, "@cancelGroupAbility, 取消公共弹窗请求ability");
            Bff.cancel(mPublicPopupAbility);
        }
        IBffProxy.Ability ability2 = mBusinessPopupAbility;
        if (ability2 != null && TextUtils.isEmpty(ability2.getServiceId())) {
            LogcatUtil.m35796i(TAG, "@cancelGroupAbility, 取消业务弹窗请求ability");
            Bff.cancel(mBusinessPopupAbility);
        }
    }

    public static void closePopupWindow() {
        DialogFragment dialogFragment;
        Activity activity = ResourceManager.getManager().getActivity();
        if (activity != null) {
            try {
                if ((activity instanceof FragmentActivity) && (dialogFragment = (DialogFragment) ((FragmentActivity) activity).getSupportFragmentManager().findFragmentByTag(AssetPopwindowDialogFragment.class.getSimpleName())) != null) {
                    dialogFragment.dismissAllowingStateLoss();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void showPopUpCommercial(ConstantUtils.ResourceId resourceId, String str, int i, OnPopUpCommercialShownCallback onPopUpCommercialShownCallback) {
        IBffProxy.Ability ability = mPublicPopupAbility;
        if (ability == null || TextUtils.isEmpty(ability.getServiceId())) {
            IBffProxy.Ability ability2 = mBusinessPopupAbility;
            if (ability2 == null || TextUtils.isEmpty(ability2.getServiceId())) {
                showPopupInner(resourceId, str, i, (String) null, onPopUpCommercialShownCallback);
            }
        }
    }

    public static void onApplicationExit() {
        if (ResourceManager.getManager().getApplication() != null) {
            ResourceManager.getManager().setApplication((Application) null);
        }
        isFromSlashActvity = false;
        ResourceManager.WINDOW_SHOWING = false;
    }

    private static void getPublicNotice(final ConstantUtils.ResourceId resourceId, int i, String str, String str2) {
        mHasUniversalPop = false;
        mPublicPopupAbility = requestBaseResource("passenger/pResGetRuledGlobal", str, i, str2, new HttpHelper.RequestCallBack() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(com.didichuxing.publicservice.network.HttpHelper.HttpResult r6) {
                /*
                    r5 = this;
                    java.lang.String r0 = "data"
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = " "
                    r1.append(r2)
                    java.lang.String r2 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                    r1.append(r2)
                    java.lang.String r2 = " ---------- public pop ----===== showPopUpCommercial -> onSuccess : "
                    r1.append(r2)
                    r1.append(r6)
                    java.lang.String r1 = r1.toString()
                    com.didichuxing.publicservice.general.AppUtils.log(r1)
                    r1 = 0
                    com.android.didi.bfflib.IBffProxy.Ability unused = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mPublicPopupAbility = r1
                    java.lang.String r2 = r6.getOriginJson()     // Catch:{ Exception -> 0x005a }
                    org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
                    r3.<init>(r2)     // Catch:{ Exception -> 0x005a }
                    org.json.JSONObject r2 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x005a }
                    if (r2 == 0) goto L_0x0050
                    org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x005a }
                    r4.<init>()     // Catch:{ Exception -> 0x005a }
                    r4.put(r2)     // Catch:{ Exception -> 0x005a }
                    r3.putOpt(r0, r4)     // Catch:{ Exception -> 0x005a }
                    java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x004e }
                    java.lang.Class<com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource> r0 = com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource.class
                    java.lang.Object r6 = com.didichuxing.publicservice.general.AppUtils.parseJson(r6, r0)     // Catch:{ Exception -> 0x004e }
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource r6 = (com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource) r6     // Catch:{ Exception -> 0x004e }
                    r1 = r6
                    goto L_0x0063
                L_0x004e:
                    goto L_0x0063
                L_0x0050:
                    java.lang.Class<com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource> r0 = com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource.class
                    java.lang.Object r0 = com.didichuxing.publicservice.general.AppUtils.parseResultData(r6, r0)     // Catch:{ Exception -> 0x005a }
                    r1 = r0
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource r1 = (com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource) r1     // Catch:{ Exception -> 0x005a }
                    goto L_0x0063
                L_0x005a:
                    java.lang.Class<com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource> r0 = com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource.class
                    java.lang.Object r6 = com.didichuxing.publicservice.general.AppUtils.parseResultData(r6, r0)
                    r1 = r6
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource r1 = (com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource) r1
                L_0x0063:
                    if (r1 == 0) goto L_0x00cb
                    int r6 = r1.errno
                    if (r6 != 0) goto L_0x00cb
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r6 = r1.data
                    if (r6 == 0) goto L_0x00cb
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r6 = r1.data
                    int r6 = r6.length
                    if (r6 != 0) goto L_0x0073
                    goto L_0x00cb
                L_0x0073:
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource unused = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.prePopResource = r1
                    com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource$DataBean[] r6 = r1.data
                    boolean r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.preparePopXmlList(r6)
                    r0 = 1003(0x3eb, float:1.406E-42)
                    r2 = 101(0x65, float:1.42E-43)
                    if (r6 == 0) goto L_0x00af
                    java.lang.String r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                    java.lang.String r3 = "@getPublicNotice, 数据准备完毕，开始展示弹窗资源位"
                    com.didichuxing.xpanel.util.LogcatUtil.m35796i(r6, r3)
                    r6 = 1
                    boolean unused = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mHasUniversalPop = r6
                    com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager r6 = com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager.getManager()
                    android.app.Application r6 = r6.getApplication()
                    long r3 = java.lang.System.currentTimeMillis()
                    java.lang.String r3 = java.lang.String.valueOf(r3)
                    java.lang.String r4 = "publicnotice_time"
                    com.didichuxing.publicservice.general.AppUtils.saveStringToPreference(r6, r4, r3)
                    com.didichuxing.publicservice.general.ConstantUtils$ResourceId r6 = r1
                    com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.startActivityByResourceId(r1, r0, r6)
                    android.os.Handler r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mResourceHandler
                    r6.removeMessages(r2)
                    goto L_0x00cb
                L_0x00af:
                    java.lang.String r6 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.TAG
                    java.lang.String r1 = "@getPublicNotice, 数据准备未准备完毕存在cdn卡片 放置timer"
                    com.didichuxing.xpanel.util.LogcatUtil.m35796i(r6, r1)
                    android.os.Message r6 = android.os.Message.obtain()
                    r6.what = r2
                    r6.arg1 = r0
                    com.didichuxing.publicservice.general.ConstantUtils$ResourceId r0 = r1
                    r6.obj = r0
                    android.os.Handler r0 = com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.mResourceHandler
                    r1 = 1500(0x5dc, double:7.41E-321)
                    r0.sendMessageDelayed(r6, r1)
                L_0x00cb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.publicservice.resourcecontrol.api.ResourceApi.C162186.onSuccess(com.didichuxing.publicservice.network.HttpHelper$HttpResult):void");
            }

            public void onFail() {
                AppUtils.log(" " + ResourceApi.TAG + " ---------- public pop ----===== showPopUpCommercial -> onFail");
            }
        });
    }

    /* access modifiers changed from: private */
    public static boolean isEmptyResouce(DSplashResource dSplashResource) {
        return dSplashResource == null || dSplashResource.data == null || dSplashResource.data.size() <= 0;
    }

    /* access modifiers changed from: private */
    public static boolean isEmptySplashResouce(DSplashResource dSplashResource) {
        return dSplashResource == null || dSplashResource.data == null || dSplashResource.data.size() <= 0;
    }

    /* access modifiers changed from: private */
    public static boolean prepareSplashXmlSingle(Context context, DSplashResource.DataBean dataBean) {
        if (dataBean == null || TextUtils.isEmpty(dataBean.cdn)) {
            return true;
        }
        boolean prepareToBuildSingleCard = mXCardManager.prepareToBuildSingleCard(SPLASH_DIMENSION, SPLASH_XML_TEMPLATE, dataBean.cdn, (IXMLLoaderTrackCallback) null);
        LogcatUtil.m35794d(ScreenAdManager.TAG, "@prepareSplashXmlList, singleCompleted: " + prepareToBuildSingleCard);
        if (prepareToBuildSingleCard) {
            AppUtils.log("ScreenAdManager by cdn  insert single resource|" + dataBean);
            ScreenAdManager.getInstance().insertSingleResourceSync(context, dataBean);
        }
        return prepareToBuildSingleCard;
    }

    /* access modifiers changed from: private */
    public static boolean preparePopXmlList(DPopResource.DataBean[] dataBeanArr) {
        boolean z = true;
        if (dataBeanArr != null) {
            for (DPopResource.DataBean dataBean : dataBeanArr) {
                if (dataBean != null) {
                    boolean prepareToBuildSingleCard = mXCardManager.prepareToBuildSingleCard(POPUP_DIMENSION, POPUP_XML_TEMPLATE, dataBean.cdn, (IXMLLoaderTrackCallback) null);
                    LogcatUtil.m35794d(ScreenAdManager.TAG, "@preparePopXmlList, singleCompleted: " + prepareToBuildSingleCard);
                    z &= prepareToBuildSingleCard;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static void startActivityByResourceId(DPopResource dPopResource, int i, ConstantUtils.ResourceId resourceId) {
        if (dPopResource == null) {
            AppUtils.logE("@startActivityByResourceId, popResource is null ");
            return;
        }
        ResourceManager.startActivityByResouceId(dPopResource.clone(), i, resourceId);
        ConstantUtils.ResourceId resourceId2 = sPopResourceId;
        if (resourceId2 != null && resourceId2.equals(resourceId)) {
            prePopResource = null;
            sPopResourceId = null;
        }
    }

    private static class ResourceHandler extends Handler {
        private ResourceHandler() {
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 20) {
                boolean unused = ResourceApi.mHasUniversalPop = false;
            } else if (i == 101) {
                LogcatUtil.m35796i(ResourceApi.TAG, "exec MSG_NOTIFY_POPUP_SHOW message");
                int i2 = message.arg1;
                ConstantUtils.ResourceId resourceId = (ConstantUtils.ResourceId) message.obj;
                if (resourceId == null || !resourceId.equals(ResourceApi.sPopResourceId)) {
                    String access$300 = ResourceApi.TAG;
                    LogcatUtil.m35796i(access$300, "resourceId changed, sPopResourceId=" + ResourceApi.sPopResourceId + ", resourceId=" + resourceId);
                    return;
                }
                ResourceApi.startActivityByResourceId(ResourceApi.prePopResource, i2, resourceId);
            } else if (i == 102) {
                LogcatUtil.m35796i(ResourceApi.TAG, "exec MSG_NOTIFY_SPLASH_SHOW message");
            }
        }
    }
}
