package com.didi.sdk.app;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.didi.app.GeneralPageRouter;
import com.didi.app.VisitTrackManager;
import com.didi.app.router.DRouterUrlInterceptor;
import com.didi.drouter.api.DRouter;
import com.didi.one.netdetect.DetectionTaskManager;
import com.didi.one.netdetect.model.DetectionParam;
import com.didi.one.netdetect.security.SignGenerator;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.appupdate.AppUpdateManager;
import com.didi.sdk.appupdate.AppUpgradeSdkUtil;
import com.didi.sdk.home.model.TopBarData;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.map.MapFragment;
import com.didi.sdk.misconfig.MisConfigInitializationer;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.p146ad.AdManager;
import com.didi.sdk.p146ad.AdUtil;
import com.didi.sdk.p146ad.IAdObserver;
import com.didi.sdk.p146ad.event.AdEvent;
import com.didi.sdk.p146ad.model.AdConfigItem;
import com.didi.sdk.p146ad.model.AdResponseKey;
import com.didi.sdk.p146ad.operation.HomeAdOperation;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.tasks.OnFailureListener;
import com.didi.sdk.p154ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.p161sa.SaManager;
import com.didi.sdk.push.DPushHelper;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.sidebar.fragment.HomeNavDrawerFragment;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleUtil;
import com.didi.sdk.splash.SplashActivity;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.GoogleDynamicDeepLinkConstants;
import com.didi.sdk.util.RunTimeStatistics;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.security.wireless.ISecurityConf;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.util.IdGenrator;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseMainActivity extends MainActivity {
    protected static final String ENTRANCE_URI = (NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://%s/entrance");
    protected static Logger log = LoggerFactory.getLogger("MainActivity");

    /* renamed from: a */
    OnToggleStateChangeListener f35115a = new ToggleStatusListener();

    /* renamed from: b */
    private ActivityLifecycleManager.AppStateListener f35116b;

    /* renamed from: c */
    private String f35117c;

    /* renamed from: d */
    private AppUpdateManager f35118d;
    protected String dynamicLinkUrl = "";

    /* renamed from: e */
    private boolean f35119e = false;

    /* renamed from: f */
    private IAdObserver f35120f = new IAdObserver() {
        public String type() {
            return AdResponseKey.NORMAL_AFTER_PASSPORT;
        }

        public void observe(AdConfigItem adConfigItem) {
            SystemUtils.log(3, HomeAdOperation.TAG, new Gson().toJson((Object) adConfigItem), (Throwable) null, "com.didi.sdk.app.BaseMainActivity$1", 123);
            BaseMainActivity.this.m24815a(adConfigItem);
        }
    };
    protected boolean killApp;
    protected AdConfigItem mAdConfigItem;
    protected boolean mIsReportTabShow = false;
    protected MapFragment mMapFragment;

    public abstract HomeNavDrawerFragment getDrawerFragment();

    public abstract Fragment getHomeBizNarFragment();

    public abstract Fragment getTitleBarFragment();

    public abstract void mapCallBack();

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24815a(AdConfigItem adConfigItem) {
        if (!adConfigItem.isInvalidUrl()) {
            boolean isInRideEntrance = AdUtil.INSTANCE.isInRideEntrance();
            SystemUtils.log(3, HomeAdOperation.TAG, "inRideEntrance:" + isInRideEntrance, (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 140);
            boolean z = false;
            if (!isInRideEntrance) {
                HashMap hashMap = new HashMap();
                hashMap.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
                hashMap.put("is_in_index", 0);
                AdUtil.INSTANCE.track("tech_ddl_execute_start", adConfigItem.getDdlType(), hashMap);
                return;
            }
            Uri parse = Uri.parse(adConfigItem.getLandingPageLink());
            if (adConfigItem.needWaitTopBanner()) {
                String ddlType = adConfigItem.getDdlType();
                if (AdUtil.INSTANCE.hadTopBarBanner() != 1) {
                    z = true;
                }
                m24814a(parse, true, ddlType, z);
                return;
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
            hashMap2.put("is_in_index", Integer.valueOf(AdUtil.INSTANCE.isInRideEntrance() ? 1 : 0));
            AdUtil.INSTANCE.track("tech_ddl_execute_start", adConfigItem.getDdlType(), hashMap2);
            DRouter.build(adConfigItem.getLandingPageLink()).start();
            AdUtil.INSTANCE.track("tech_ddl_execute_result", adConfigItem.getDdlType(), (HashMap<String, Object>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void startAppUpdateCheck() {
        AppUpdateManager appUpdateManager = new AppUpdateManager(this);
        this.f35118d = appUpdateManager;
        appUpdateManager.startAppCheckUpdate();
        new AppUpgradeSdkUtil(this).startSyncUpgrade(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        AppUpdateManager appUpdateManager = this.f35118d;
        if (appUpdateManager != null) {
            appUpdateManager.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        AppUpdateManager appUpdateManager = this.f35118d;
        if (appUpdateManager != null) {
            appUpdateManager.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.setLocale(MultiLocaleStore.getInstance().getLocaleHelper().getLocale());
            super.attachBaseContext(context.createConfigurationContext(configuration));
            return;
        }
        super.attachBaseContext(context);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f35119e = true;
        AppUpdateManager appUpdateManager = this.f35118d;
        if (appUpdateManager != null) {
            appUpdateManager.onDestroy();
        }
        GeneralPageRouter.getInstance().unregister();
        Apollo.removeToggleStateChangeListener(this.f35115a);
    }

    /* access modifiers changed from: protected */
    public void initPush() {
        DPushHelper helper = DPushHelper.getHelper();
        helper.initPush(getApplicationContext());
        helper.uploadCidForFcm();
    }

    /* access modifiers changed from: protected */
    public void initNetDetect() {
        if (Apollo.getToggle(AppUtils.isBrazilApp(getApplicationContext()) ? "net_detect_experiments_brazil_passenger" : "net_detect_experiments_global_passenger").allow()) {
            SystemUtils.log(3, "OND_APOLLO", "allow", (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 226);
            this.f35116b = new ActivityLifecycleManager.AppStateListener() {
                public void onStateChanged(int i) {
                    if (i == 1) {
                        DetectionTaskManager.getInstance().resumeDetection();
                    } else if (i == 0) {
                        DetectionTaskManager.getInstance().stopDetection();
                    }
                }
            };
            ActivityLifecycleManager.getInstance().addAppStateListener(this.f35116b);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
                    if (nationComponentData != null) {
                        DetectionParam detectionParam = new DetectionParam();
                        detectionParam.cityId = ConfProxy.getInstance().getCityId();
                        detectionParam.datatype = AppUtils.isBrazilApp(BaseMainActivity.this.getApplicationContext()) ? "100482" : "100579";
                        detectionParam.apolloName = AppUtils.isBrazilApp(BaseMainActivity.this.getApplicationContext()) ? "net_detect_experiments_brazil_passenger" : "net_detect_experiments_global_passenger";
                        detectionParam.tripCountry = nationComponentData.getLocCountry();
                        if (nationComponentData.getLoginInfo().isLoginNow()) {
                            detectionParam.uid = nationComponentData.getLoginInfo().getUid();
                        }
                        LocationPerformer.getInstance().getLastKnownLocation(BaseMainActivity.this.getApplicationContext());
                        detectionParam.appVersion = SystemUtil.getVersionName(BaseMainActivity.this.getApplicationContext());
                        detectionParam.suuid = SecurityUtil.getSUUID();
                        detectionParam.traceId = IdGenrator.generate();
                        DetectionTaskManager.getInstance().init(BaseMainActivity.this.getApplicationContext(), detectionParam, (SignGenerator) null);
                        DetectionTaskManager.getInstance().startDetection();
                    }
                }
            }, 180000);
            return;
        }
        SystemUtils.log(3, "OND_APOLLO", "not allowed", (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 275);
    }

    /* access modifiers changed from: protected */
    public void addLaunchingSliceTimeStatistics() {
        if (!RunTimeStatistics.isReset(RunTimeStatistics.SliceGroup.APP_LAUNCHING_TIME)) {
            RunTimeStatistics.SliceTime sliceTime = new RunTimeStatistics.SliceTime();
            sliceTime.setStart(DIDIApplicationDelegate.launchingTime);
            sliceTime.setEnd(System.currentTimeMillis());
            sliceTime.setSliceName("app_launch_time");
            RunTimeStatistics.addSliceTime(RunTimeStatistics.SliceGroup.APP_LAUNCHING_TIME, sliceTime);
            LinkedList<RunTimeStatistics.SliceTime> listSliceTime = RunTimeStatistics.getSliceTimesByGroup(RunTimeStatistics.SliceGroup.APP_LAUNCHING_TIME).getListSliceTime();
            HashMap hashMap = new HashMap();
            Iterator it = listSliceTime.iterator();
            while (it.hasNext()) {
                RunTimeStatistics.SliceTime sliceTime2 = (RunTimeStatistics.SliceTime) it.next();
                hashMap.put(sliceTime2.getSliceName(), Long.valueOf(sliceTime2.getEnd() - sliceTime2.getStart()));
            }
            Logger logger = log;
            logger.info("启动时间信息:" + RunTimeStatistics.SliceGroup.APP_LAUNCHING_TIME.name() + "：===" + hashMap.toString(), new Object[0]);
            OmegaSDKAdapter.trackEvent(RunTimeStatistics.SliceGroup.APP_LAUNCHING_TIME.name(), "", hashMap);
            RunTimeStatistics.reset(RunTimeStatistics.SliceGroup.APP_LAUNCHING_TIME);
        }
    }

    /* access modifiers changed from: protected */
    public void reportTabShow(int i) {
        TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
        if (topBarData != null) {
            List<TopCarGroupWrapper> list = topBarData.dataList;
            String groupIdArrayString = topBarData.getGroupIdArrayString();
            int i2 = 0;
            if (groupIdArrayString != null && !groupIdArrayString.equalsIgnoreCase(this.f35117c)) {
                this.f35117c = groupIdArrayString;
                this.mIsReportTabShow = false;
            }
            if (!this.mIsReportTabShow) {
                this.mIsReportTabShow = true;
                HashMap hashMap = new HashMap();
                if (list != null && list.size() > 0) {
                    while (true) {
                        if (i2 >= list.size()) {
                            break;
                        } else if (list.get(i2).isSelected) {
                            hashMap.put("business_type", list.get(i2).carGrop.getGroupType());
                            hashMap.put("defaultTabOrder", Integer.valueOf(i2));
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                hashMap.put("defaultTabList", topBarData.getGroupTypeArrayString());
                hashMap.put("tab_sense", Integer.valueOf(i));
                OmegaSDKAdapter.trackEvent("gp_Business_sw", (Map<String, Object>) hashMap);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reportClick(CarGrop carGrop, CarGrop carGrop2, int i, String str) {
        TopBarData topBarData = ConfProxy.getInstance().getTopBarData();
        HashMap hashMap = new HashMap();
        hashMap.put("from_business_type", carGrop.getGroupType());
        hashMap.put("from_config_business_type", carGrop.getA_T());
        hashMap.put("to_business_type", carGrop2.getGroupType());
        hashMap.put("to_config_business_type", carGrop2.getA_T());
        hashMap.put("defaultTabList", topBarData != null ? topBarData.getGroupTypeArrayString() : null);
        hashMap.put("business_type", ConfProxy.getInstance().getDefaultSelectedType());
        hashMap.put("label", Integer.valueOf(i));
        if (str != null) {
            hashMap.put("type", str);
        }
        OmegaSDKAdapter.trackEvent("gp_changeBusiness_ck", (Map<String, Object>) hashMap);
    }

    public void onMapLowMemory() {
        MapFragment mapFragment;
        if (Apollo.getToggle("global_passenger_map_low_memory").allow() && (mapFragment = this.mMapFragment) != null) {
            mapFragment.onLowMemory();
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        MapFragment mapFragment = this.mMapFragment;
        if (mapFragment != null) {
            mapFragment.onLowMemory();
        }
    }

    /* renamed from: a */
    private void m24813a() {
        AdManager.INSTANCE.registerObserver(this.f35120f);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        SaManager.INSTANCE.request();
        m24820b();
        VisitTrackManager.INSTANCE.setShowMainMain(true);
        m24826h();
        m24827i();
        Apollo.addToggleStateChangeListener(this.f35115a);
        m24813a();
        m24825g();
        m24822d();
        m24821c();
        ActivityLifecycleManager.getInstance().addAppStateListener(new ActivityLifecycleManager.AppStateListener() {
            public void onStateChanged(int i) {
                if (i == 1) {
                    BaseMainActivity.this.m24822d();
                }
            }
        });
        GeneralPageRouter.getInstance().register();
    }

    /* renamed from: b */
    private void m24820b() {
        HashMap hashMap = new HashMap();
        hashMap.put("sa", Integer.valueOf(SaApolloUtil.INSTANCE.getSaTypeValue()));
        hashMap.put("sa1.0", Integer.valueOf(SaApolloUtil.INSTANCE.getSaOneTypeValue()));
        PubSIDManager.getInstance().setPubSID(hashMap);
    }

    /* renamed from: a */
    private String m24812a(Uri uri) {
        if (uri == null) {
            return "";
        }
        if (!GoogleDynamicDeepLinkConstants.DYNAMIC_DEEPLINK_MATCH_URL.equals(uri.getHost())) {
            return uri.toString();
        }
        String queryParameter = uri.getQueryParameter(GoogleDynamicDeepLinkConstants.PARAMS_URL);
        if (TextUtils.isEmpty(queryParameter)) {
            return "";
        }
        Uri parse = Uri.parse(queryParameter);
        Object[] array = uri.getQueryParameterNames().toArray();
        Uri.Builder buildUpon = parse.buildUpon();
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                if (!GoogleDynamicDeepLinkConstants.PARAMS_URL.equals(obj) && (obj instanceof String)) {
                    String str = (String) obj;
                    buildUpon.appendQueryParameter(str, uri.getQueryParameter(str));
                }
            }
        }
        return buildUpon.build().toString();
    }

    /* access modifiers changed from: protected */
    public void tryHandleDynamicLinkAgain() {
        if (!TextUtils.isEmpty(this.dynamicLinkUrl)) {
            DRouter.build(this.dynamicLinkUrl).start(this);
            if (AdUtil.INSTANCE.getFromDdl()) {
                AdUtil.INSTANCE.setFromDdl(false);
                AdUtil.INSTANCE.track("tech_ddl_execute_result", AdUtil.INSTANCE.getDdlType(), (HashMap<String, Object>) null);
            }
            SystemUtils.log(3, "dynamiclink", "tryHandleDynamicLinkAgain:" + this.dynamicLinkUrl, (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 444);
            this.dynamicLinkUrl = "";
        }
    }

    /* renamed from: a */
    private boolean m24819a(String str) {
        TopBarData topBarData;
        if (str.startsWith("http")) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("groupType");
        String host = parse.getHost();
        String path = parse.getPath();
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(host)) {
            stringBuffer.append(host);
        }
        if (!TextUtils.isEmpty(path)) {
            stringBuffer.append(path);
        }
        String stringBuffer2 = stringBuffer.toString();
        boolean z = TextUtils.equals(stringBuffer2, DRouterUrlInterceptor.BIZ_SWITCH) || TextUtils.equals(stringBuffer2, DRouterUrlInterceptor.ONE_PRODUCT_SWITCH);
        SystemUtils.log(3, "dynamiclink", "needWaitSwitchBusiness:" + z, (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 465);
        if (!z || (topBarData = ConfProxy.getInstance().getTopBarData()) == null || (!topBarData.containsType(queryParameter) && !topBarData.containsType(host))) {
            return z;
        }
        return false;
    }

    /* renamed from: c */
    private void m24821c() {
        HashMap hashMap = new HashMap();
        Locale locale = MultiLocaleUtil.sysLocale;
        hashMap.put("app_lang", MultiLocaleUtil.getLanguageModel().getLang());
        hashMap.put("app_locale", MultiLocaleUtil.getLanguageModel().getLocale());
        hashMap.put("sys_lang", MultiLocaleUtil.locale2Code(locale));
        hashMap.put("sys_locale", locale.toString());
        OmegaSDKAdapter.trackEvent("tech_ibt_gp_language_data", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24814a(Uri uri, boolean z, String str, boolean z2) {
        if (uri != null) {
            String a = m24812a(uri);
            if (TextUtils.isEmpty(a)) {
                a = uri.toString();
            }
            if (!TextUtils.isEmpty(a)) {
                SystemUtils.log(3, "dynamiclink", a, (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 496);
                boolean a2 = m24819a(a);
                SystemUtils.log(3, "dynamiclink", "needWait:" + a2, (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 498);
                if (z) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("had_top_banner", Integer.valueOf(AdUtil.INSTANCE.hadTopBarBanner()));
                    hashMap.put("is_in_index", Integer.valueOf(AdUtil.INSTANCE.isInRideEntrance() ? 1 : 0));
                    AdUtil.INSTANCE.track("tech_ddl_execute_start", str, hashMap);
                }
                if (a2 || z2) {
                    this.dynamicLinkUrl = a;
                    AdUtil.INSTANCE.setFromDdl(z);
                    AdUtil.INSTANCE.setDdlType(str);
                    return;
                }
                DRouter.build(a).start(this);
                if (z) {
                    AdUtil.INSTANCE.track("tech_ddl_execute_result", str, (HashMap<String, Object>) null);
                    return;
                }
                return;
            }
            return;
        }
        SystemUtils.log(6, "dynamiclink", "url is null", (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 516);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m24822d() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
                if (iCollector == null || !iCollector.isSupportDeferredDeepLink()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("collector = ");
                    sb.append(iCollector);
                    sb.append(", collector.isSupportDeferredDeepLink = ");
                    sb.append(iCollector != null && iCollector.isSupportDeferredDeepLink());
                    SystemUtils.log(6, "dynamiclink", sb.toString(), (Throwable) null, "com.didi.sdk.app.BaseMainActivity$5", 538);
                    return;
                }
                BaseMainActivity baseMainActivity = BaseMainActivity.this;
                iCollector.createDeferredDeepLinkTask(baseMainActivity, baseMainActivity.getIntent(), new OnSuccessListener<Uri>() {
                    public void onSuccess(Uri uri) {
                        BaseMainActivity.this.m24814a(uri, false, "", false);
                    }
                }, new OnFailureListener() {
                    public void onFailure(Exception exc) {
                        SystemUtils.log(6, "dynamiclink", "getDynamicLink:onFailure", exc, "com.didi.sdk.app.BaseMainActivity$5$2", 534);
                    }
                });
            }
        }, 300);
    }

    private class ToggleStatusListener implements OnToggleStateChangeListener {
        private ToggleStatusListener() {
        }

        public void onStateChanged() {
            BaseMainActivity.this.m24822d();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m24822d();
    }

    /* renamed from: e */
    private int m24823e() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null) {
            return defaultAdapter.isEnabled() ? 1 : 2;
        }
        return 3;
    }

    /* renamed from: f */
    private boolean m24824f() {
        List<Sensor> sensorList;
        Object systemService = getSystemService(ISecurityConf.KEY_SENSOR);
        if (!(systemService instanceof SensorManager) || (sensorList = ((SensorManager) systemService).getSensorList(4)) == null || sensorList.isEmpty()) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    private void m24825g() {
        HashMap hashMap = new HashMap();
        hashMap.put("model", Build.BRAND);
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("networktype", SystemUtil.getNetworkType());
        if (!LocationPerformer.getInstance().isPermDenied()) {
            hashMap.put("gps", 2);
        } else {
            hashMap.put("gps", 3);
        }
        hashMap.put("bluetoolth", Integer.valueOf(m24823e()));
        if (m24824f()) {
            hashMap.put("gyroscope", 1);
        } else {
            hashMap.put("gyroscope", 0);
        }
        if (NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow()) {
            hashMap.put("logined", 1);
        } else {
            hashMap.put("logined", 2);
        }
        OmegaSDKAdapter.trackEvent("ibt_device_info_bt", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void killAppOnDestory() {
        if (!this.killApp) {
            return;
        }
        if (Apollo.getToggle("global_app_exit_mode_change").allow()) {
            ApmThreadPool.excuteOnUiThread(new Runnable() {
                public void run() {
                    if (!SplashActivity.isResumed()) {
                        System.exit(0);
                    } else {
                        BaseMainActivity.log.warn("splash is resumed", new Object[0]);
                    }
                }
            });
        } else {
            System.exit(0);
        }
    }

    /* access modifiers changed from: protected */
    public void trackFragmentError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("stack", Log.getStackTraceString(exc));
        OmegaSDKAdapter.trackEvent("tech_pax_fragment_error", (Map<String, Object>) hashMap);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onAdEvent(AdEvent adEvent) {
        SystemUtils.log(3, HomeAdOperation.TAG, "AdEvent", (Throwable) null, "com.didi.sdk.app.BaseMainActivity", 641);
        if (adEvent.getAdConfigItem() != null && TextUtils.equals(adEvent.getType(), AdResponseKey.NORMAL_AFTER_PASSPORT)) {
            this.mAdConfigItem = adEvent.getAdConfigItem();
        }
    }

    /* access modifiers changed from: protected */
    public void tryHandleAd() {
        AdConfigItem adConfigItem = this.mAdConfigItem;
        if (adConfigItem != null) {
            m24815a(adConfigItem);
            this.mAdConfigItem = null;
        }
    }

    /* renamed from: h */
    private void m24826h() {
        MisConfigInitializationer.getInstance().init();
    }

    /* renamed from: i */
    private void m24827i() {
        OneMessageInit.init(getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        if (isFinishing() || this.f35119e) {
            Omega.trackError("activity_resume", new Exception("BadTokenException"));
        }
    }
}
