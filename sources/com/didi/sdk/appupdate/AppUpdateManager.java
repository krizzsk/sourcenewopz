package com.didi.sdk.appupdate;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.appupdate.AppUpdateAlertDialog;
import com.didi.sdk.p154ms.common.ICollector;
import com.didi.sdk.p154ms.common.tasks.OnFailureListener;
import com.didi.sdk.p154ms.common.tasks.OnSuccessListener;
import com.didi.sdk.p154ms.common.update.IAppUpdateInfo;
import com.didi.sdk.p154ms.common.update.IAppUpdateManager;
import com.didi.sdk.p154ms.common.update.IInstallState;
import com.didi.sdk.p154ms.common.update.StateUpdatedListener;
import com.didi.sdk.p154ms.common.utils.ServiceUtil;
import com.didi.sdk.util.AnalysisAPK;
import com.didi.sdk.util.AppUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUpdateManager {
    public static final String APP_UPDATE_TOGGLE = "force_app_update";
    public static final String APP_UPDATE_TOGGLE_BRAZIL = "force_app_update_brazil";
    public static final String APP_UPDATE_TOGGLE_HMS = "force_app_update_hms";

    /* renamed from: a */
    private static final String f35246a = "com.android.vending";

    /* renamed from: b */
    private static final String f35247b = "com.huawei.appmarket";

    /* renamed from: e */
    private static final int f35248e = 1099;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public FragmentActivity f35249c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AppUpdateAlertDialog f35250d;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f35251f = 0;

    /* renamed from: g */
    private ICollector f35252g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IAppUpdateManager f35253h;

    /* renamed from: i */
    private StateUpdatedListener<IInstallState> f35254i = new StateUpdatedListener<IInstallState>() {
        public void onStateUpdate(IInstallState iInstallState) {
            if (AppUpdateManager.this.f35253h != null && !AppUpdateManager.this.f35253h.isForceUpdate(AppUpdateManager.this.f35251f) && AppUpdateManager.this.f35253h.isDownloaded(iInstallState.installStatus())) {
                AppUpdateManager.this.f35253h.completeUpdate(AppUpdateManager.this.f35249c);
            }
        }
    };

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public AppUpdateManager(FragmentActivity fragmentActivity) {
        this.f35249c = fragmentActivity;
        this.f35252g = (ICollector) ServiceUtil.getServiceImp(ICollector.class);
        this.f35253h = (IAppUpdateManager) ServiceUtil.getServiceImp(IAppUpdateManager.class);
    }

    /* access modifiers changed from: protected */
    public void startAppUpdateCheck(boolean z, final FragmentActivity fragmentActivity) {
        IAppUpdateManager iAppUpdateManager;
        if (this.f35252g != null && (iAppUpdateManager = this.f35253h) != null) {
            this.f35251f = iAppUpdateManager.getAppUpdateType(z);
            this.f35253h.registerListener(this.f35249c, this.f35254i);
            this.f35253h.createAppUpdateInfoTask(this.f35249c, new OnSuccessListener<IAppUpdateInfo>() {
                public void onSuccess(IAppUpdateInfo iAppUpdateInfo) {
                    if (iAppUpdateInfo != null) {
                        if (!iAppUpdateInfo.isUpdateAvailable() || !iAppUpdateInfo.isUpdateTypeAllowed(AppUpdateManager.this.f35251f)) {
                            if (!iAppUpdateInfo.isUpdateDeveloperTriggeredInProgress()) {
                                return;
                            }
                            if (AppUpdateManager.this.f35253h.isForceUpdate(AppUpdateManager.this.f35251f) || !AppUpdateManager.this.f35253h.isDownloaded(iAppUpdateInfo.installStatus())) {
                                if (AppUpdateManager.this.f35253h.isForceUpdate(AppUpdateManager.this.f35251f) && AppUpdateManager.this.f35253h != null) {
                                    AppUpdateManager.this.f35253h.startUpdateFlowForResult(iAppUpdateInfo, AppUpdateManager.this.f35251f, AppUpdateManager.this.f35249c, 1099);
                                }
                            } else if (AppUpdateManager.this.f35253h != null) {
                                AppUpdateManager.this.f35253h.completeUpdate(AppUpdateManager.this.f35249c);
                            }
                        } else if (AppUpdateManager.this.f35253h != null) {
                            AppUpdateManager.this.f35253h.startUpdateFlowForResult(iAppUpdateInfo, AppUpdateManager.this.f35251f, fragmentActivity, 1099);
                        }
                    }
                }
            }, new OnFailureListener() {
                public void onFailure(Exception exc) {
                    exc.printStackTrace();
                }
            });
        }
    }

    public void onResume() {
        IAppUpdateManager iAppUpdateManager = this.f35253h;
        if (iAppUpdateManager != null) {
            iAppUpdateManager.createAppUpdateInfoTask(this.f35249c, new OnSuccessListener<IAppUpdateInfo>() {
                public void onSuccess(IAppUpdateInfo iAppUpdateInfo) {
                    if (iAppUpdateInfo != null && AppUpdateManager.this.f35253h != null) {
                        if (!AppUpdateManager.this.f35253h.isForceUpdate(AppUpdateManager.this.f35251f) && AppUpdateManager.this.f35253h.isDownloaded(iAppUpdateInfo.installStatus())) {
                            AppUpdateManager.this.f35253h.completeUpdate(AppUpdateManager.this.f35249c);
                        } else if (AppUpdateManager.this.f35253h.isForceUpdate(AppUpdateManager.this.f35251f) && iAppUpdateInfo.isUpdateDeveloperTriggeredInProgress()) {
                            AppUpdateManager.this.f35253h.startUpdateFlowForResult(iAppUpdateInfo, AppUpdateManager.this.f35251f, AppUpdateManager.this.f35249c, 1099);
                        }
                    }
                }
            }, (OnFailureListener) null);
        }
    }

    public void onDestroy() {
        IAppUpdateManager iAppUpdateManager = this.f35253h;
        if (iAppUpdateManager != null) {
            iAppUpdateManager.unregisterListener(this.f35249c, this.f35254i);
        }
    }

    public void startAppCheckUpdate() {
        AppUpdateInfo loadAppUpdateInfo = loadAppUpdateInfo();
        boolean z = false;
        if (isSupportPlayUpdate() && this.f35249c != null && m24963b(loadAppUpdateInfo)) {
            if (loadAppUpdateInfo.isForceUpdate == 1) {
                z = true;
            }
            startAppUpdateCheck(z, this.f35249c);
        } else if (startAppCheckUpdate(loadAppUpdateInfo) && m24963b(loadAppUpdateInfo)) {
            showAppUpdateDialog(loadAppUpdateInfo, false);
        }
    }

    public void startAppCheckUpdateByPlay(AppUpdateInfo appUpdateInfo) {
        if (this.f35249c != null && appUpdateInfo != null) {
            boolean z = true;
            if (appUpdateInfo.isForceUpdate != 1) {
                z = false;
            }
            startAppUpdateCheck(z, this.f35249c);
        }
    }

    public boolean startAppCheckUpdate(AppUpdateInfo appUpdateInfo) {
        FragmentActivity fragmentActivity = this.f35249c;
        if (fragmentActivity == null || appUpdateInfo == null || m24954a(appUpdateInfo.latestVersion) <= m24954a(m24956a((Context) fragmentActivity))) {
            return false;
        }
        return true;
    }

    public AppUpdateInfo loadAppUpdateInfo() {
        IToggle iToggle;
        if (AnalysisAPK.isGlobalHmsApk(this.f35249c)) {
            iToggle = Apollo.getToggle(APP_UPDATE_TOGGLE_HMS);
        } else if (AppUtils.isGlobalApp(this.f35249c)) {
            iToggle = Apollo.getToggle(APP_UPDATE_TOGGLE);
        } else {
            iToggle = AppUtils.isBrazilApp(this.f35249c) ? Apollo.getToggle(APP_UPDATE_TOGGLE_BRAZIL) : null;
        }
        return loadAppUpdateInfo(iToggle);
    }

    public AppUpdateInfo loadAppUpdateInfo(IToggle iToggle) {
        if (iToggle != null && iToggle.allow()) {
            IExperiment experiment = iToggle.getExperiment();
            AppUpdateInfo appUpdateInfo = new AppUpdateInfo();
            if (experiment != null) {
                appUpdateInfo.updateUrl = (String) experiment.getParam("update_url_android", "");
                appUpdateInfo.title = (String) experiment.getParam("title", "");
                appUpdateInfo.content = (String) experiment.getParam("content", "");
                if (!TextUtils.isEmpty(appUpdateInfo.content)) {
                    appUpdateInfo.content = appUpdateInfo.content.replace("\\n", "\n");
                }
                appUpdateInfo.cancelBtn = (String) experiment.getParam("cancel_btn", "");
                appUpdateInfo.ensureBtn = (String) experiment.getParam("ensure_btn", "");
                appUpdateInfo.isForceUpdate = ((Integer) experiment.getParam("is_force", 0)).intValue();
                appUpdateInfo.latestVersion = (String) experiment.getParam("latest_version", "");
                appUpdateInfo.promptDurationHour = ((Integer) experiment.getParam("prompt_duration_hour", 0)).intValue();
                if (isSupportPlayUpdate() || !m24959a(appUpdateInfo)) {
                    return appUpdateInfo;
                }
                return null;
            } else if (isSupportPlayUpdate()) {
                appUpdateInfo.isForceUpdate = 0;
                return appUpdateInfo;
            }
        }
        return null;
    }

    /* renamed from: a */
    private boolean m24959a(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo == null || TextUtils.isEmpty(appUpdateInfo.title) || TextUtils.isEmpty(appUpdateInfo.content) || TextUtils.isEmpty(appUpdateInfo.ensureBtn)) {
            return true;
        }
        if (m24960a(appUpdateInfo, false) || !TextUtils.isEmpty(appUpdateInfo.cancelBtn)) {
            return false;
        }
        return true;
    }

    public boolean isSupportPlayUpdate() {
        ICollector iCollector = this.f35252g;
        return (iCollector == null || !iCollector.isSupportPlayUpdate(this.f35249c) || this.f35253h == null) ? false : true;
    }

    public void showAppUpdateDialog(final AppUpdateInfo appUpdateInfo, final boolean z) {
        FragmentActivity fragmentActivity = this.f35249c;
        if (fragmentActivity != null && appUpdateInfo != null) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            AppUpdateAlertDialog.Builder builder = new AppUpdateAlertDialog.Builder(this.f35249c);
            builder.setTitle(appUpdateInfo.title).setMessage(appUpdateInfo.content).setPositiveButton(appUpdateInfo.ensureBtn, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    OmegaSDKAdapter.trackEvent("app_force_update_confirm_ck");
                    if (!AppUpdateManager.this.m24960a(appUpdateInfo, z) && AppUpdateManager.this.f35250d != null) {
                        AppUpdateManager.this.f35250d.dismiss();
                    }
                    AppUpdateManager.this.m24958a(appUpdateInfo.updateUrl, AnalysisAPK.isGlobalHmsApk(AppUpdateManager.this.f35249c) ? AppUpdateManager.f35247b : "com.android.vending");
                }
            });
            if (!m24960a(appUpdateInfo, z)) {
                builder.setNegativeButton(appUpdateInfo.cancelBtn, new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        OmegaSDKAdapter.trackEvent("app_force_update_cancel_ck");
                        if (AppUpdateManager.this.f35250d != null) {
                            AppUpdateManager.this.f35250d.dismiss();
                        }
                    }
                });
            }
            if (m24960a(appUpdateInfo, z)) {
                builder.setCancelable(false);
            }
            AppUpdateAlertDialog create = builder.create();
            this.f35250d = create;
            try {
                create.show(supportFragmentManager, (String) null);
                OmegaSDKAdapter.trackEvent("app_force_update_sw");
                this.f35249c.runOnUiThread(new Runnable() {
                    public void run() {
                        Dialog dialog = AppUpdateManager.this.f35250d.getDialog();
                        if (AppUpdateManager.this.m24960a(appUpdateInfo, z) && dialog != null) {
                            dialog.setCanceledOnTouchOutside(true);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m24960a(AppUpdateInfo appUpdateInfo, boolean z) {
        return appUpdateInfo != null && appUpdateInfo.isForceUpdate > 0 && !z;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24958a(String str, String str2) {
        if (this.f35249c != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!TextUtils.isEmpty(str2)) {
                    intent.setPackage(str2);
                }
                intent.addFlags(268435456);
                this.f35249c.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private int m24954a(String str) {
        try {
            Matcher matcher = Pattern.compile("^(\\d+\\.){2}\\d+$").matcher(str);
            if (matcher.find()) {
                String[] split = matcher.group().split("\\.");
                return (Integer.valueOf(split[0]).intValue() * 1000000) + (Integer.valueOf(split[1]).intValue() * 1000) + Integer.valueOf(split[2]).intValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /* renamed from: a */
    private String m24956a(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    private boolean m24963b(AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo == null) {
            return false;
        }
        AppUpdateSharedPreferences appUpdateSharedPreferences = new AppUpdateSharedPreferences(this.f35249c);
        if (System.currentTimeMillis() - appUpdateSharedPreferences.getAppUpdateLastTime() <= ((long) (appUpdateInfo.promptDurationHour * 60 * 60 * 1000))) {
            return false;
        }
        appUpdateSharedPreferences.setAppUpdateLastTime(System.currentTimeMillis());
        return true;
    }
}
