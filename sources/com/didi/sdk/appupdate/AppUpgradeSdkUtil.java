package com.didi.sdk.appupdate;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.upgrade.IUpdateDialogCallback;
import com.didichuxing.upgrade.UpgradeConfig;
import com.didichuxing.upgrade.UpgradeSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/sdk/appupdate/AppUpgradeSdkUtil;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "startSyncUpgrade", "", "context", "Landroid/content/Context;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppUpgradeSdkUtil.kt */
public final class AppUpgradeSdkUtil {
    public AppUpgradeSdkUtil(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        UpgradeSDK instance = UpgradeSDK.Companion.getInstance();
        Application appContext = DIDIApplicationDelegate.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        instance.init(appContext, new UpgradeConfig.IConfig() {
            public String getCustomHost() {
                return "";
            }

            public boolean showCustomDialog(String str, String str2, String str3, String str4, boolean z, IUpdateDialogCallback iUpdateDialogCallback) {
                return false;
            }

            public String getUid() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getUid();
            }

            public void OmegaTrackEvent(String str, Map<String, Object> map) {
                OmegaSDKAdapter.trackEvent(str, map);
            }

            public Activity getUpdateContext() {
                return activity;
            }

            public String getCountryCode() {
                return NationTypeUtil.getNationComponentData().getLocCountry();
            }

            public void openWebView(String str) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
            }

            public String getCityId() {
                return NationTypeUtil.getNationComponentData().getCityId();
            }

            public String getPhone() {
                return NationTypeUtil.getNationComponentData().getLoginInfo().getPhone();
            }

            public String getAppLanguage() {
                return NationTypeUtil.getNationComponentData().getLocaleCode();
            }
        });
        UpgradeSDK.Companion.getInstance().enableLog(false);
    }

    public final void startSyncUpgrade(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        UpgradeSDK.Companion.getInstance().syncUpdates(context);
    }
}
