package com.didi.sdk.publicservice;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.log.Logger;
import com.didi.sdk.log.Printer;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.sidebar.setup.mutilocale.LocaleChangeListener;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.general.DeviceUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.pojo.RCRequestParams;
import com.didichuxing.publicservice.resourcecontrol.pojo.SdkDevice;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale;
import com.didichuxing.publicservice.screenAd.ScreenAdManager;

public class PublicServiceUtil {
    public static final String DIDI_PSG_APP_KEY = "passager";
    public static final String DIDI_PSG_NOTICE_RESOURCE_EN = "pas_notice_enUS";
    public static final String DIDI_PSG_NOTICE_RESOURCE_NAME = "pas_notice";
    public static final String DIDI_PSG_SPLASH_RESOURCE_NAME = "g_didipas_start_page";

    /* renamed from: a */
    private static boolean f36968a = false;

    /* renamed from: b */
    private static boolean f36969b = false;

    /* renamed from: c */
    private static boolean f36970c = false;

    /* renamed from: d */
    private static boolean f36971d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static ILocation.ILocationChangedListener f36972e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static double f36973f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static double f36974g;

    /* renamed from: h */
    private static LocaleChangeListener f36975h = new LocaleChangeListener() {
        public void onLocaleChange(String str, String str2) {
            ResourceApi.resetLanguage(str2);
        }
    };

    public static void initSDK(Activity activity) {
        Logger.m25813t("public_service_wang").normalLog("initSDK");
        if (activity != null && !f36968a) {
            f36968a = true;
            if (f36973f == 0.0d || f36974g == 0.0d) {
                Logger.m25813t("public_service_wang").normalLog("location is null");
                m26181b(activity);
                return;
            }
            m26182c(activity);
        }
    }

    /* renamed from: b */
    private static void m26181b(final Activity activity) {
        Logger.m25813t("public_service_wang").normalLog("add location listener");
        f36972e = new ILocation.ILocationChangedListener() {
            public void onLocationChanged(DIDILocation dIDILocation) {
                if (dIDILocation != null) {
                    Logger.m25813t("public_service_wang").normalLog("get location");
                    double unused = PublicServiceUtil.f36973f = dIDILocation.getLatitude();
                    double unused2 = PublicServiceUtil.f36974g = dIDILocation.getLongitude();
                    LocationPerformer.getInstance().removeLocationListener(PublicServiceUtil.f36972e);
                    PublicServiceUtil.m26182c(activity);
                }
            }
        };
        LocationPerformer.getInstance().addLocationListener(f36972e);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m26182c(Activity activity) {
        Printer t = Logger.m25813t("public_service_wang");
        t.normalLog(f36974g + " " + f36973f + ",isPublicPopShowed = " + f36969b);
        ResourceLocale.setResourceLocalIsGl(true);
        RCRequestParams rCRequestParams = new RCRequestParams();
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        String cityId = nationComponentData.getCityId();
        if (cityId == null) {
            cityId = "1";
        }
        rCRequestParams.cityId = Integer.parseInt(cityId);
        rCRequestParams.lat = f36973f;
        rCRequestParams.lng = f36974g;
        rCRequestParams.token = nationComponentData.getLoginInfo().getToken();
        rCRequestParams.appId = ConstantUtils.AppId.DIDI_PASSENGER;
        rCRequestParams.appKey = DIDI_PSG_APP_KEY;
        rCRequestParams.appKey = ConstantUtils.AppKey.ZH_APPKEY.getAppkey();
        rCRequestParams.params.put("locale", nationComponentData.getGLang());
        rCRequestParams.params.put("trip_country", nationComponentData.getLocCountry());
        ResourceApi.initResourceSDK(rCRequestParams, activity, m26183d(activity));
        if (!f36969b) {
            f36969b = true;
        }
        showPopViewApp(activity);
    }

    /* renamed from: d */
    private static SdkDevice m26183d(Activity activity) {
        SdkDevice sdkDevice = new SdkDevice();
        sdkDevice.resolutionLength = SystemUtil.getScreenHeight();
        sdkDevice.resolutionWidth = SystemUtil.getScreenWidth();
        sdkDevice.phoneType = Build.TYPE;
        sdkDevice.phoneModel = Build.MODEL;
        sdkDevice.appVersion = SystemUtil.getVersionName();
        sdkDevice.SDKVersion = DeviceUtils.getSDKVersion();
        sdkDevice.make = Build.MANUFACTURER;
        sdkDevice.OSType = "Android";
        sdkDevice.token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        sdkDevice.OSVersion = Build.VERSION.RELEASE;
        sdkDevice.ppi = SystemUtil.getScreenDpi();
        sdkDevice.carrier = "None";
        sdkDevice.connnectiontype = SystemUtil.getNetworkType();
        sdkDevice.IMEI = SystemUtil.getIMEI();
        sdkDevice.lang = NationTypeUtil.getNationComponentData().getGLang();
        sdkDevice.suuid = SecurityUtil.getSUUID();
        sdkDevice.uid = NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
        return sdkDevice;
    }

    public static void showPopViewApp(Activity activity) {
        showPopView(activity, ConstantUtils.ResourceId.NOTICE_PUBLIC, AppUtils.isBrazilApp(activity) ? 316 : 256);
    }

    public static void showPopView(Activity activity, ConstantUtils.ResourceId resourceId, int i) {
        ResourceApi.showPopUpCommercial(resourceId, AppUtils.isBrazilApp(activity) ? "pas_notice" : ConstantUtils.GLOBAL_RESOURCE_NAME, i, new ResourceApi.OnPopUpCommercialShownCallback() {
            public boolean canShowPopUpCommercial(DPopResource dPopResource) {
                return true;
            }
        });
    }

    public static void showSplash(Activity activity, ResourceApi.OnSplashListener onSplashListener) {
        Logger.m25813t("public_service_wang").normalLog("showSplash");
        SdkDevice sdkDevice = new SdkDevice();
        sdkDevice.resolutionLength = SystemUtil.getScreenHeight();
        sdkDevice.resolutionWidth = SystemUtil.getScreenWidth();
        sdkDevice.phoneType = Build.TYPE;
        sdkDevice.phoneModel = Build.MODEL;
        sdkDevice.appVersion = SystemUtil.getVersionName();
        sdkDevice.SDKVersion = DeviceUtils.getSDKVersion();
        sdkDevice.make = Build.MANUFACTURER;
        sdkDevice.OSType = "Android";
        sdkDevice.OSVersion = Build.VERSION.RELEASE;
        sdkDevice.ppi = SystemUtil.getScreenDpi();
        sdkDevice.carrier = "None";
        sdkDevice.connnectiontype = SystemUtil.getNetworkType();
        sdkDevice.IMEI = SystemUtil.getIMEI();
        sdkDevice.token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        sdkDevice.lang = NationTypeUtil.getNationComponentData().getGLang();
        String cityId = NationTypeUtil.getNationComponentData().getCityId();
        try {
            Logger.m25808d(ScreenAdManager.TAG, "showSplash, cityId=" + cityId);
            if (!TextUtils.isEmpty(cityId)) {
                sdkDevice.cityId = Integer.parseInt(cityId);
            }
        } catch (NumberFormatException unused) {
            Logger.m25809e("device.cityId  pares error, cityId=" + cityId, new Object[0]);
        }
        ResourceApi.showSplashComercial(activity, sdkDevice, ConstantUtils.ResourceId.SPLASH, DIDI_PSG_SPLASH_RESOURCE_NAME, onSplashListener);
    }
}
