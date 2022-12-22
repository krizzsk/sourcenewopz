package com.didi.sdk.splash;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.appsflyer.AppsFlyerLib;
import com.didi.app.delegate.MapViewHolder;
import com.didi.app.router.PageRouter;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.apm.utils.ApmThreadPool;
import com.didi.sdk.app.DDLaunchTaskManage;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.app.DidiLoadDexActivity;
import com.didi.sdk.app.OneMessageInit;
import com.didi.sdk.global.DidiGlobalPayApiImpl;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.guide.CardsBindGuideActivity;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.logtime.DiDiLaunchingLogTimer;
import com.didi.sdk.logtime.DiDiLogLaunchTimer;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.MisConfigInitializationer;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.type.IMSType;
import com.didi.sdk.p154ms.common.utils.LogUtil;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.publicservice.PublicServiceUtil;
import com.didi.sdk.push.DPushHelper;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.GuideUtil;
import com.didi.sdk.util.LogTimer;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.WeakReferenceUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.p194ms.appflyer.DDAppFlyerLib;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale;
import com.didichuxing.publicservice.screenAd.ScreenAdManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends FragmentActivity {

    /* renamed from: j */
    private static boolean f37519j = false;

    /* renamed from: a */
    private final int f37520a = 9000;

    /* renamed from: b */
    private final String f37521b = "SplashActivity";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Logger f37522c = LoggerFactory.getLogger("SplashActivity");

    /* renamed from: d */
    private final int f37523d = 2000;

    /* renamed from: e */
    private final String f37524e = "remove_delay";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C13140a f37525f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ILocation.ILocationChangedListener f37526g;

    /* renamed from: h */
    private LogTimer.ElapsedTime f37527h = new LogTimer.ElapsedTime();

    /* renamed from: i */
    private MainActivityOperator f37528i = new MainActivityOperator(this);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        DiDiLaunchingLogTimer.get().methodStart(DiDiLogLaunchTimer.KEY_TIME_LAUNCHING);
        m26653q();
        DIDIApplicationDelegate.delayInitHttpDns(getApplication());
        DPushHelper.getHelper().initPush(getApplicationContext());
        DPushHelper.getHelper().registerOneConfListener();
        DPushHelper.getHelper().uploadCidForFcm();
        m26654r();
        m26632b();
        requestWindowFeature(1);
        if (Build.VERSION.SDK_INT >= 24) {
            MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(this);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.getDecorView().setSystemUiVisibility(256);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        }
        ResourceLocale.setResourceLocalIsGl(true);
        long currentTimeMillis = System.currentTimeMillis();
        boolean m = m26649m();
        long currentTimeMillis2 = System.currentTimeMillis();
        Logger logger = this.f37522c;
        logger.debug("checkEndTime-checkStartTime:" + (currentTimeMillis2 - currentTimeMillis), new Object[0]);
        if (m) {
            m26639e();
            m26635c();
        }
        m26626a();
        m26652p();
        PrivacyDisclosureManager.getInstance().uploadIfNeeded(this);
        PrivacyDisclosureManager.getInstance().syncApolloToSp(this, PrivacyTypeEnum.LOCATION);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        f37519j = true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        f37519j = false;
    }

    /* renamed from: a */
    private void m26626a() {
        IToggle toggle = Apollo.getToggle("global_notification_clear_all_at_splash");
        if (toggle != null && toggle.allow()) {
            ((NotificationManager) getSystemService("notification")).cancelAll();
        }
    }

    /* renamed from: b */
    private void m26632b() {
        Omega.init(getApplicationContext());
        DDAppFlyerLib.delayUploadCustomerId(getApplication(), Omega.getOmegaIdSafety());
    }

    /* renamed from: c */
    private void m26635c() {
        ApmThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                SplashActivity splashActivity = SplashActivity.this;
                C13140a unused = splashActivity.f37525f = new C13140a(splashActivity.getApplicationContext());
                ILocation.ILocationChangedListener unused2 = SplashActivity.this.f37526g = new ILocation.ILocationChangedListener() {
                    public void onLocationChanged(DIDILocation dIDILocation) {
                        OneConfStore.getInstance().getOneConf(SplashActivity.this.getApplicationContext(), dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    }
                };
                LocationPerformer.getInstance().addLocationListener(SplashActivity.this.f37526g);
                LocationPerformer.getInstance().start(SplashActivity.this.getApplicationContext());
            }
        });
    }

    /* renamed from: d */
    private void m26636d() {
        if (this.f37526g != null) {
            LocationPerformer.getInstance().removeLocationListener(this.f37526g);
        }
    }

    /* renamed from: e */
    private void m26639e() {
        m26640f();
        m26646j();
        Pair<Integer, String> h = m26644h();
        boolean isLoginNow = NationTypeUtil.getNationComponentData().getLoginInfo().isLoginNow();
        boolean finishInputInfo = LoginStore.getInstance().getFinishInputInfo();
        if ((isLoginNow || !GuideUtil.needGuide(this)) && finishInputInfo) {
            m26643g();
            m26651o();
            return;
        }
        m26629a(isLoginNow, finishInputInfo);
        if (TextUtils.equals("remove_delay", (CharSequence) h.second)) {
            m26645i();
        } else {
            m26627a(h);
        }
    }

    /* renamed from: f */
    private void m26640f() {
        IToggle toggle = Apollo.getToggle("global_passenger_map_init_rollback");
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
        if (toggle != null && toggle.allow() && ((Integer) toggle.getExperiment().getParam("initmode", 0)).intValue() == 1) {
            if ((iCollector == null || iCollector.isHMSupportPreInitMap()) && MapViewHolder.getInstance().getMapView() == null) {
                MapViewHolder.getInstance().postInitMap(DIDIApplicationDelegate.getAppContext());
            }
        }
    }

    /* renamed from: a */
    private void m26629a(boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", LoginStore.getInstance().getToken());
        hashMap.put("isLoginNow", Boolean.valueOf(z));
        hashMap.put("loginFinish", Boolean.valueOf(z2));
        OmegaSDKAdapter.trackEvent("tech_re_login_when_app_killed", (Map<String, Object>) hashMap);
    }

    /* renamed from: g */
    private void m26643g() {
        LogTimer.get().methodStart(this.f37527h, "showSplash");
        if (!isFinishing()) {
            LogTimer logTimer = LogTimer.get();
            LogTimer.ElapsedTime elapsedTime = this.f37527h;
            logTimer.methodStart(elapsedTime, "showSplash" + MultiLocaleStore.getInstance().isEnglish());
            PublicServiceUtil.showSplash(this, this.f37528i);
            LogTimer.get().methodEnd(this.f37527h, "showSplash runnableToMainActivity");
        }
    }

    /* renamed from: h */
    private Pair<Integer, String> m26644h() {
        IToggle toggle = Apollo.getToggle("global_remove_delay_splash_view_toggle");
        if (toggle == null) {
            return new Pair<>(2000, "");
        }
        IExperiment experiment = toggle.getExperiment();
        if (experiment == null) {
            return new Pair<>(2000, "");
        }
        return new Pair<>(Integer.valueOf(((Integer) experiment.getParam("delay_time", 2000)).intValue()), (String) experiment.getParam("remove_flag", ""));
    }

    /* renamed from: a */
    private void m26627a(Pair<Integer, String> pair) {
        UiThreadHandler.postDelayed(new StaticRunnable(this), (long) ((Integer) pair.first).intValue());
    }

    private static class StaticRunnable implements Runnable {
        private WeakReference<SplashActivity> mWeakSplashActivity;

        public StaticRunnable(SplashActivity splashActivity) {
            this.mWeakSplashActivity = new WeakReference<>(splashActivity);
        }

        public void run() {
            SplashActivity splashActivity = (SplashActivity) WeakReferenceUtils.getObj(this.mWeakSplashActivity);
            if (splashActivity != null) {
                splashActivity.m26645i();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m26645i() {
        OneLoginFacade.getFunction().addLoginJumpListener(new StaticLoginJumpListener(this));
        OneLoginFacade.getFunction().addLoginListener(new LoginListeners.LoginListener() {
            public void onSuccess(Activity activity, String str) {
                GuideUtil.setNeedGuide(SplashActivity.this, false);
                OneLoginFacade.getFunction().removeLoginListener(this);
                OneLoginFacade.getConfigApi().setHomeCanBack(true);
                if (SplashActivity.this.f37525f != null) {
                    SplashActivity.this.f37525f.mo96546a(false);
                }
                if (!OneLoginFacade.getStore().isNewUser()) {
                    SplashActivity.this.m26650n();
                    return;
                }
                int e = SplashActivity.this.m26647k();
                if (e == 0) {
                    SplashActivity.this.m26650n();
                } else if (e == 1) {
                    SplashActivity.this.finish();
                    SplashActivity.this.goToPayment();
                } else if (e == 2) {
                    SplashActivity.this.finish();
                    SplashActivity.this.m26648l();
                }
            }

            public void onCancel() {
                if (SplashActivity.this.f37525f != null) {
                    SplashActivity.this.f37525f.mo96546a(false);
                }
                OneLoginFacade.getFunction().removeLoginListener(this);
                SplashActivity.this.finish();
            }
        });
        OneLoginFacade.getAction().go2Login(this);
    }

    /* renamed from: j */
    private void m26646j() {
        if (DDLaunchTaskManage.isAllowed()) {
            DDLaunchTaskManage.getInstance().notifyLoadForground();
        }
    }

    private static class StaticLoginJumpListener implements LoginListeners.LoginJumpListener {
        private WeakReference<SplashActivity> mWeakSplashActivity;

        public StaticLoginJumpListener(SplashActivity splashActivity) {
            this.mWeakSplashActivity = new WeakReference<>(splashActivity);
        }

        public void jump(Activity activity) {
            SplashActivity splashActivity = (SplashActivity) WeakReferenceUtils.getObj(this.mWeakSplashActivity);
            if (splashActivity != null) {
                GuideUtil.setNeedGuide(splashActivity, false);
                if (splashActivity.f37525f != null) {
                    splashActivity.f37525f.mo96546a(false);
                }
                OneLoginFacade.getFunction().removeLoginJumpListener(this);
                splashActivity.finish();
                splashActivity.m26650n();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public int m26647k() {
        IToggle toggle;
        if (OneLoginFacade.getStore() == null || OneLoginFacade.getStore().getAreaCode() == null || OneConfStore.getInstance() == null) {
            return 0;
        }
        if ("AU".equals(OneLoginFacade.getStore().getAreaCode())) {
            return 1;
        }
        int countryId = OneConfStore.getInstance().getCountryId();
        if (("JP".equals(OneLoginFacade.getStore().getAreaCode()) || countryId == 81) && (toggle = Apollo.getToggle("jp_regaddcard_gated")) != null && toggle.allow()) {
            return 2;
        }
        return 0;
    }

    public void goToPayment() {
        DidiGlobalPayApiImpl didiGlobalPayApiImpl = new DidiGlobalPayApiImpl();
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_GUIDE);
        payMethodListParam.skipAction = getResources().getString(R.string.app_mainactivity_action);
        payMethodListParam.nextAction = getResources().getString(R.string.app_mainactivity_action);
        didiGlobalPayApiImpl.startPayMethodListActivity((Activity) this, 1, payMethodListParam);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m26648l() {
        OmegaSDKAdapter.trackEvent("pas_add_card_intro_enter");
        startActivity(new Intent(this, CardsBindGuideActivity.class));
    }

    /* renamed from: m */
    private boolean m26649m() {
        ICollector iCollector = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.GMS);
        if (iCollector != null) {
            LogUtil.m26099i("SplashActivity", "checkMobileServicesAvailable : gmsCollector is load");
            return m26630a(iCollector, false);
        }
        ICollector iCollector2 = (ICollector) ServiceUtil.getServiceImp(ICollector.class, IMSType.HMS);
        if (iCollector2 != null) {
            LogUtil.m26099i("SplashActivity", "checkMobileServicesAvailable : hmsCollector is load");
            return m26630a(iCollector2, true);
        }
        LogUtil.m26101w("SplashActivity", "checkMobileServicesAvailable : no Collector is load");
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m26630a(final ICollector iCollector, final boolean z) {
        if (iCollector == null) {
            m26628a(z, -1, -1);
            return false;
        }
        String str = z ? "HuaweiPlayServices" : "GooglePlayServices";
        int mSAvailableStatusCode = iCollector.getMSAvailableStatusCode(this);
        Logger logger = this.f37522c;
        logger.info(str + " statusCode: " + mSAvailableStatusCode, new Object[0]);
        if (mSAvailableStatusCode == iCollector.getMSAvailableSuccessCode()) {
            m26628a(z, 1, mSAvailableStatusCode);
            return true;
        } else if (iCollector.isUserResolvableError(mSAvailableStatusCode)) {
            Logger logger2 = this.f37522c;
            logger2.info(str + " show error dialog", new Object[0]);
            m26628a(z, 2, mSAvailableStatusCode);
            SystemUtils.showDialog(iCollector.getErrorDialog(this, mSAvailableStatusCode, 9000, new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    boolean unused = SplashActivity.this.m26630a(iCollector, z);
                }
            }));
            return false;
        } else {
            m26628a(z, 3, mSAvailableStatusCode);
            Logger logger3 = this.f37522c;
            logger3.info(str + " show alert dialog", new Object[0]);
            AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this);
            builder.setMessage(getResources().getString(z ? R.string.splash_huaweiservice_available : R.string.splash_googleservice_available));
            builder.setCancelable(false);
            builder.setNegativeButton((CharSequence) getResources().getString(R.string.fine), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    SplashActivity.this.f37522c.info("AlertDialog onClick", new Object[0]);
                    SplashActivity.this.finish();
                }
            });
            builder.create().show(getSupportFragmentManager(), "");
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m26650n() {
        Intent intent = new Intent();
        intent.putExtra("no_res", true);
        intent.setPackage(getPackageName());
        PageRouter.getInstance().startMainActivity(this, intent);
        finish();
        overridePendingTransition(17432576, 17432577);
        DiDiLaunchingLogTimer.get().methodEnd(DiDiLogLaunchTimer.KEY_TIME_LAUNCHING);
    }

    /* renamed from: o */
    private void m26651o() {
        HashMap hashMap = new HashMap();
        hashMap.put("afid", AppsFlyerLib.getInstance().getAppsFlyerUID(getBaseContext()));
        OmegaSDKAdapter.trackEvent("global_app_launch", "global_app_launch", hashMap);
    }

    /* renamed from: a */
    private void m26628a(boolean z, int i, int i2) {
        StringBuilder sb = new StringBuilder("Pkg_");
        if (AppUtils.isBrazilApp(this)) {
            sb.append("Brazil");
        } else if (AppUtils.isGlobalApp(this)) {
            sb.append("Global");
        } else {
            sb.append("UNKNOWN");
        }
        sb.append("_");
        String mobileServiceFlavor = AnalysisAPK.getMobileServiceFlavor(this);
        boolean equals = "hms".equals(mobileServiceFlavor);
        String str = IMSType.GMS;
        if (equals) {
            sb.append(IMSType.HMS);
        } else if ("gms".equals(mobileServiceFlavor)) {
            sb.append(str);
        } else {
            sb.append("UNKNOWN");
        }
        sb.append("_");
        if (AnalysisAPK.CHANNEL_HUAWEI_PRE_INSTALL.equals(AnalysisAPK.getChannelFlavor(this))) {
            sb.append("HWPreInstall");
        } else {
            sb.append("UNKNOWN");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pkg_type", sb.toString());
        if (z) {
            str = IMSType.HMS;
        }
        hashMap.put("check_ms_type", str);
        hashMap.put("available_type", Integer.valueOf(i));
        hashMap.put("available_code", Integer.valueOf(i2));
        OmegaSDKAdapter.trackEvent("ibt_app_start_mobile_service_available_state_bt", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Logger logger = this.f37522c;
        logger.info("onActivityResult: " + i + "|" + i2 + "|" + intent, new Object[0]);
        if (i != 9000) {
            return;
        }
        if (i2 == -1) {
            m26639e();
        } else {
            m26649m();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        m26636d();
        f37519j = false;
    }

    private static class MainActivityOperator implements ResourceApi.OnSplashListener {
        private WeakReference<SplashActivity> mWeakSplashActivity;

        public MainActivityOperator(SplashActivity splashActivity) {
            this.mWeakSplashActivity = new WeakReference<>(splashActivity);
        }

        public synchronized void onDisplaySplash() {
            SplashActivity splashActivity = (SplashActivity) WeakReferenceUtils.getObj(this.mWeakSplashActivity);
            if (splashActivity != null) {
                splashActivity.f37522c.debug(ScreenAdManager.TAG, "onDisplaySplash,SPLASH_NOT_SPLASH_TIME = 0");
            }
            OmegaSDKAdapter.trackEvent("tone_p_x_load_start_sw");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void onSplashCloseOrAbsent() {
            /*
                r6 = this;
                monitor-enter(r6)
                java.lang.ref.WeakReference<com.didi.sdk.splash.SplashActivity> r0 = r6.mWeakSplashActivity     // Catch:{ all -> 0x002a }
                java.lang.Object r0 = com.didi.sdk.util.WeakReferenceUtils.getObj(r0)     // Catch:{ all -> 0x002a }
                com.didi.sdk.splash.SplashActivity r0 = (com.didi.sdk.splash.SplashActivity) r0     // Catch:{ all -> 0x002a }
                if (r0 == 0) goto L_0x0028
                com.didi.sdk.logging.Logger r1 = r0.f37522c     // Catch:{ all -> 0x002a }
                java.lang.String r2 = "ScreenAdManager"
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x002a }
                r4 = 0
                java.lang.String r5 = "onSplashCloseOrAbsent,SPLASH_NOT_SPLASH_TIME = 0"
                r3[r4] = r5     // Catch:{ all -> 0x002a }
                r1.debug((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x002a }
                boolean r1 = r0.isFinishing()     // Catch:{ all -> 0x002a }
                if (r1 == 0) goto L_0x0025
                monitor-exit(r6)
                return
            L_0x0025:
                r0.m26650n()     // Catch:{ all -> 0x002a }
            L_0x0028:
                monitor-exit(r6)
                return
            L_0x002a:
                r0 = move-exception
                monitor-exit(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.splash.SplashActivity.MainActivityOperator.onSplashCloseOrAbsent():void");
        }
    }

    /* renamed from: p */
    private void m26652p() {
        int intExtra = getIntent().getIntExtra(DidiLoadDexActivity.PARAM_LOCATION_ALLOW, -1);
        if (intExtra != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put("location", Integer.valueOf(intExtra));
            OmegaSDKAdapter.trackEvent("tech_pax_permission", (Map<String, Object>) hashMap);
        }
    }

    public static boolean isResumed() {
        return f37519j;
    }

    /* renamed from: q */
    private void m26653q() {
        MisConfigInitializationer.getInstance().init();
    }

    /* renamed from: r */
    private void m26654r() {
        OneMessageInit.init(getApplicationContext());
    }
}
