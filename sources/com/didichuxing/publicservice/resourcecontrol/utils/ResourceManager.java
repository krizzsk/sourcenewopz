package com.didichuxing.publicservice.resourcecontrol.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didichuxing.publicservice.BuildConfig;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.dialogfragments.BaseDialogFragment;
import com.didichuxing.publicservice.resourcecontrol.dialogfragments.DialogFragmentFactory;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import com.didichuxing.publicservice.resourcecontrol.pojo.Notices;
import com.didichuxing.publicservice.resourcecontrol.pojo.RCRequestParams;
import com.didichuxing.publicservice.resourcecontrol.pojo.SdkDevice;
import com.google.gson.Gson;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
    public static ConstantUtils.AppId APP_ID = null;
    public static int BUSINESS_ID = 0;
    public static String IMEI = "";
    public static final int MSG_CLOSE_ACTIVITY = 21;
    public static final int MSG_CLOSE_NOTICES_LIST = 20;
    public static final int MSG_CLOSE_SPLASH_DIALOG_FRAGMENT = 22;
    public static String RESOURCE_NAME = "";
    public static String SECRET = BuildConfig.PSG_SCT;
    public static String SECRET_DEBUG = "SSSSSSSSSSSSSSSS";
    public static String SECRET_ECO_RELEASE = BuildConfig.ECHO_SCT;
    public static String SECRET_PSG_RELEASE = BuildConfig.PSG_SCT;
    public static final String SP_KEY_DEVICE = "key_device";
    public static final String SP_KEY_IS_FIRST_TIME_ENTER_APP_AFTER_EXITTING = "key_is_the_first_time_enter_app_after_exitting";
    public static final String SP_KEY_IS_THE_FIRST_TIME_OPEN_APP = "key_is_the_first_time_open_this_app";
    public static final String SP_KEY_LAST_SHOW_SPLASH_TIME = "key_last_show_splash_time";
    public static final String SP_KEY_PARAMS = "key_params";
    public static final String SP_KEY_PUBLIC_NOTICE_TIME = "publicnotice_time";
    public static final String SP_KEY_RESOURCE_SPLASH_CACHE = "key_resource_splash_cache";
    /* access modifiers changed from: private */
    public static final String TAG = ResourceManager.class.getSimpleName();
    private static int VIEWPAGER_INTERVAL_TRAVELLING = 3;
    private static int VIEWPAGER_INTERVAL_WAITING = 3;
    public static volatile boolean WINDOW_SHOWING = false;
    private static String appKey;
    private static ConstantUtils.ResourceId currentResourceId;
    private static long lastClickTime;
    private static ResourceManager manager;
    private WeakReference<Activity> activityWeak;
    private Application application;
    private RCRequestParams cacheParams;
    private SdkDevice cachedDevice;
    private SdkDevice device;
    private Gson gson;
    public boolean isTheOne = false;
    public boolean mShowRedDot = false;
    private RCRequestParams params;

    public static String getAppKey() {
        if (!TextUtils.isEmpty(appKey)) {
            return appKey;
        }
        if (!ResourceLocale.isResourceLocaleIsPt()) {
            return ConstantUtils.AppKey.ZH_APPKEY.getAppkey();
        }
        return ConstantUtils.AppKey.BR_APPKEY.getAppkey();
    }

    private ResourceManager() {
        if (this.gson == null) {
            this.gson = new Gson();
        }
    }

    public static ResourceManager getManager() {
        if (manager == null) {
            synchronized (ResourceManager.class) {
                if (manager == null) {
                    manager = new ResourceManager();
                }
            }
        }
        return manager;
    }

    public void setApplication(Application application2) {
        this.application = application2;
        if (application2 != null) {
            application2.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    AppUtils.log(ResourceManager.TAG + " ===onActivityCreated===, activity:" + activity.getClass().getCanonicalName());
                    ResourceManager.WINDOW_SHOWING = false;
                }

                public void onActivityDestroyed(Activity activity) {
                    AppUtils.log(ResourceManager.TAG + " ===onActivityDestroyed===, activity:" + activity.getClass().getCanonicalName());
                    ResourceManager.WINDOW_SHOWING = false;
                }
            });
        }
    }

    public Application getApplication() {
        return this.application;
    }

    public void setDevice(SdkDevice sdkDevice) {
        this.device = sdkDevice;
        IMEI = sdkDevice.IMEI;
        AppUtils.saveStringToPreference(getApplication(), SP_KEY_DEVICE, this.gson.toJson((Object) sdkDevice));
    }

    public void setActivity(Activity activity) {
        WeakReference<Activity> weakReference = this.activityWeak;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.activityWeak = new WeakReference<>(activity);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.activityWeak;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public WeakReference getWeakRef() {
        return this.activityWeak;
    }

    public SdkDevice getDevice() {
        SdkDevice sdkDevice = this.device;
        if (sdkDevice != null) {
            return sdkDevice;
        }
        SdkDevice sdkDevice2 = (SdkDevice) this.gson.fromJson(AppUtils.getStringFromPreference(getApplication(), SP_KEY_DEVICE), SdkDevice.class);
        this.cachedDevice = sdkDevice2;
        return sdkDevice2;
    }

    public void setRcRequestParams(RCRequestParams rCRequestParams) {
        this.params = rCRequestParams;
        if (rCRequestParams != null) {
            AppUtils.saveStringToPreference(getApplication(), SP_KEY_PARAMS, this.gson.toJson((Object) rCRequestParams));
        }
    }

    public RCRequestParams getRcRequestParams() {
        String str;
        RCRequestParams rCRequestParams = this.params;
        if (rCRequestParams != null && (rCRequestParams.lat != 0.0d || this.params.lng != 0.0d)) {
            return this.params;
        }
        this.cacheParams = (RCRequestParams) this.gson.fromJson(AppUtils.getStringFromPreference(getApplication(), SP_KEY_PARAMS), RCRequestParams.class);
        StringBuilder sb = new StringBuilder();
        sb.append(TAG);
        sb.append(" ======== getRcRequestParams from cache =========== : ");
        RCRequestParams rCRequestParams2 = this.params;
        if (rCRequestParams2 == null) {
            str = "null";
        } else {
            str = rCRequestParams2.toString();
        }
        sb.append(str);
        AppUtils.log(sb.toString());
        return this.cacheParams;
    }

    public boolean isTheOne() {
        return this.isTheOne;
    }

    public void setIsTheOne(boolean z) {
        this.isTheOne = z;
    }

    public Map<String, Object> getPublicParams() {
        HashMap hashMap = new HashMap();
        SdkDevice device2 = getDevice();
        hashMap.put("platform_type", "2");
        if (device2 != null) {
            hashMap.put("appversion", device2.appVersion);
            hashMap.put("height", Integer.valueOf(device2.resolutionLength));
            hashMap.put("width", Integer.valueOf(device2.resolutionWidth));
            hashMap.put("os", String.valueOf(device2.OSVersion));
            hashMap.put("trip_country", device2.countryIsoCode);
            if (device2.cityId > 0) {
                hashMap.put("city_id", Integer.valueOf(device2.cityId));
            }
        }
        RCRequestParams rcRequestParams = getRcRequestParams();
        if (rcRequestParams != null) {
            hashMap.put("token", rcRequestParams.token);
            hashMap.put("lng", rcRequestParams.lng + "");
            hashMap.put("lat", rcRequestParams.lat + "");
            hashMap.putAll(rcRequestParams.params);
        } else {
            AppUtils.log(TAG + "  -> putRequestParams2Map ================ rcRequestParams = null or urlParams is null...");
        }
        hashMap.put("lang", device2.lang);
        return hashMap;
    }

    public void initBusinessInfo(RCRequestParams rCRequestParams) {
        APP_ID = rCRequestParams.appId;
        if (rCRequestParams.appId == ConstantUtils.AppId.DIDI_PASSENGER) {
            SECRET = BuildConfig.PSG_SCT;
        } else if (rCRequestParams.appId == ConstantUtils.AppId.ECHO_PASSENGER) {
            SECRET = BuildConfig.ECHO_SCT;
        }
        if (rCRequestParams.appKey != null) {
            appKey = rCRequestParams.appKey;
        }
    }

    public static synchronized boolean isFastClick() {
        synchronized (ResourceManager.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime < 500) {
                return true;
            }
            lastClickTime = currentTimeMillis;
            return false;
        }
    }

    public void displaySplashResource(DSplashResource dSplashResource, ResourceApi.OnSplashListener onSplashListener) {
        DialogFragmentFactory.setOnSplashListener(onSplashListener);
        startActivityByResouceId(dSplashResource, 1002, ConstantUtils.ResourceId.SPLASH);
        onSplashListener.onDisplaySplash();
    }

    public static boolean startActivityByCache(ConstantUtils.ResourceId resourceId, int i, String str) {
        currentResourceId = resourceId;
        Serializable serializable = null;
        if (i == 1003 || i == 1004) {
            Application application2 = getManager().getApplication();
            Object objectFromSPrerence = AppUtils.getObjectFromSPrerence(application2, str + resourceId.getId(), (Object) null);
            if (objectFromSPrerence != null && (objectFromSPrerence instanceof DPopResource)) {
                Application application3 = getManager().getApplication();
                serializable = (DPopResource) AppUtils.getObjectFromSPrerence(application3, str + resourceId.getId(), (Object) null);
            }
        } else if (i == 1001) {
            Application application4 = getManager().getApplication();
            serializable = (Notices) AppUtils.getObjectFromSPrerence(application4, str + resourceId.getId(), (Object) null);
        }
        AppUtils.log("startActivityByCache,load cache code = " + i + ",key = " + str + ",resourceId = " + resourceId + ",result = " + serializable);
        if (serializable == null) {
            return false;
        }
        AppUtils.log("读取缓存");
        startActivityByResouce(serializable, i, resourceId.getId(), str);
        return true;
    }

    public static synchronized void startActivityByResouce(Serializable serializable, int i, int i2, String str) {
        synchronized (ResourceManager.class) {
            if (!WINDOW_SHOWING) {
                if (i == 1003 || i == 1001 || i == 1002 || i == 1004) {
                    WINDOW_SHOWING = true;
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable(ConstantUtils.EXTRA_RESOURCE_STR, serializable);
                bundle.putInt(ConstantUtils.EXTRA_RESOURCE_TYPE, i);
                bundle.putInt(ConstantUtils.EXTRA_RESOURCE_ID, i2);
                if (!TextUtils.isEmpty(str)) {
                    String str2 = ConstantUtils.SHAREDPRERENCE_KEY;
                    bundle.putString(str2, str + i2);
                }
                Activity activity = getManager().getActivity();
                if (activity == null) {
                    AppUtils.log(TAG + " =============== application is null, cannot start activity.......");
                    WINDOW_SHOWING = false;
                } else if (activity.isFinishing()) {
                    WINDOW_SHOWING = false;
                } else if (activity instanceof FragmentActivity) {
                    AppUtils.log(TAG + " ============ startActivityByResouce -------> 展示广告~ ");
                    BaseDialogFragment createDialogFragment = DialogFragmentFactory.createDialogFragment(bundle);
                    try {
                        DialogFragmentFactory.showDialogFragment(((FragmentActivity) activity).getSupportFragmentManager(), createDialogFragment, createDialogFragment.getClass().getSimpleName());
                    } catch (Exception e) {
                        AppUtils.log(TAG + " " + e.toString());
                    }
                }
            }
        }
    }

    public static synchronized void startActivityByResouceId(Serializable serializable, int i, ConstantUtils.ResourceId resourceId) {
        synchronized (ResourceManager.class) {
            StringBuilder sb = new StringBuilder();
            sb.append("startActivityByResouceId, window showing = ");
            sb.append(WINDOW_SHOWING);
            sb.append(",currentResourceId = ");
            sb.append(currentResourceId != null ? Integer.valueOf(currentResourceId.getId()) : null);
            sb.append(",code = ");
            sb.append(i);
            sb.append(",resourceId = ");
            sb.append(resourceId);
            AppUtils.log(sb.toString());
            if (!WINDOW_SHOWING) {
                currentResourceId = resourceId;
            }
            if (resourceId == ConstantUtils.ResourceId.NOTICE_PUBLIC) {
                startActivityByResouce(serializable, i, resourceId.getId(), "");
            } else if (resourceId != currentResourceId) {
                if (i == 1003) {
                    Application application2 = getManager().getApplication();
                    AppUtils.setObjectToSPreference(application2, ConstantUtils.POPWINDOW_RESOURCE + resourceId.getId(), serializable);
                } else if (i == 1001) {
                    Application application3 = getManager().getApplication();
                    AppUtils.setObjectToSPreference(application3, ConstantUtils.NOTICE_RESOURCE + resourceId.getId(), serializable);
                }
                AppUtils.log("存储到缓存");
            } else {
                startActivityByResouce(serializable, i, resourceId.getId(), "");
            }
        }
    }
}
