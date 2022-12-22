package com.didichuxing.omega.sdk.feedback.shake;

import android.app.Activity;
import android.app.Application;
import android.webkit.WebView;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.afanty.common.utils.OLog;
import com.didichuxing.omega.sdk.feedback.FloatingView;
import com.didichuxing.omega.sdk.feedback.util.SwarmUtil;
import com.didichuxing.omega.sdk.feedback.webview.WebAppInterface;
import com.taxis99.R;

public class ShakeSdk {
    private static ShakeDialog dialog;

    public static void addJavascriptInterface(WebView webView) {
        if (webView != null) {
            webView.addJavascriptInterface(new WebAppInterface(webView), ShakeConfig.JavascriptInterface);
        }
    }

    public static void removeJavascriptInterface() {
        WebAppInterface.setMyWebView((WebView) null);
    }

    public static void showdialog() {
        Application application = SwarmUtil.getApplication();
        if (application != null) {
            FloatingView.OmegaSDKinit(application);
            showshakedialog();
        }
    }

    private static void showshakedialog() {
        Activity currentActivity = SwarmUtil.getCurrentActivity();
        if (currentActivity == null) {
            OLog.m32669i("cur activity is null,so  nothing todo  ,just return.");
            return;
        }
        ShakeDialog shakeDialog = dialog;
        if (shakeDialog != null) {
            shakeDialog.dismiss();
        }
        ShakeDialog shakeDialog2 = new ShakeDialog(currentActivity, R.style.LoadingDialog);
        dialog = shakeDialog2;
        SystemUtils.showDialog(shakeDialog2);
    }
}
