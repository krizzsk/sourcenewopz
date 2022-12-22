package com.didi.payment.base.view.webview;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.ILoadingable;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.didi.global.loading.app.LoadingDelegate;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.FusionInitConfig;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.payment.base.view.webview.fusion.FusionAgent;
import com.didi.payment.base.view.webview.fusion.model.ContactModule;
import com.didi.payment.base.view.webview.fusion.model.FusionBridgeModule;
import com.didi.payment.base.view.webview.fusion.model.WalletCommonModule;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletWebActivity extends PayBaseWebActivity implements ILoadingHolder, ILoadingable {
    public static final String CUSTOM_NAVIGATION_BAR = "custom_navigation_bar";
    public static final String TITLE_BAR_COLOR = "title_bar_color";

    /* renamed from: c */
    private static PermissionCallback f30042c = null;

    /* renamed from: d */
    private static final int f30043d = 100;

    /* renamed from: e */
    private static WalletWebCommonParamsProvider f30044e;

    /* renamed from: a */
    private LoadingDelegate f30045a;

    /* renamed from: b */
    private ArrayList<View> f30046b = new ArrayList<>();

    public static void launch(Context context, String str, String str2) {
        WalletWebCommonParamsProvider walletWebCommonParamsProvider = f30044e;
        if (walletWebCommonParamsProvider != null) {
            str2 = walletWebCommonParamsProvider.addCommonParams(str2);
        }
        WebModel webModel = new WebModel(str, str2);
        Intent intent = new Intent(context, WalletWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, String str, String str2, String str3) {
        WalletWebCommonParamsProvider walletWebCommonParamsProvider = f30044e;
        if (walletWebCommonParamsProvider != null) {
            str2 = walletWebCommonParamsProvider.addCommonParams(str2);
        }
        WebModel webModel = new WebModel(str, str2);
        Intent intent = new Intent(context, WalletWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_WEB_MODEL, webModel);
        intent.putExtra(TITLE_BAR_COLOR, str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void setProvider(WalletWebCommonParamsProvider walletWebCommonParamsProvider) {
        f30044e = walletWebCommonParamsProvider;
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m21038a(getApplication());
        FusionEngine.export("WalletCommonModule", WalletCommonModule.class);
        super.onCreate(bundle);
        this.mWebView.setNeedShowProgressBar(false);
        this.mWebTitleBar.setBackBtnImg(R.drawable.common_title_back_arrow);
        this.mWebTitleBar.setTitleBarLineVisible(8);
        Intent intent = getIntent();
        if (!(intent == null || intent.getStringExtra(TITLE_BAR_COLOR) == null)) {
            this.mWebTitleBar.setBackgroundColor(intent.getStringExtra(TITLE_BAR_COLOR));
            setStatusBar(intent.getStringExtra(TITLE_BAR_COLOR));
        }
        m21037a();
    }

    /* renamed from: a */
    private void m21038a(Application application) {
        FusionEngine.init(application, new FusionInitConfig.Builder().setBusinessAgent(new FusionAgent(application)).build());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void updateUI(String str, Object... objArr) {
        super.updateUI(str, objArr);
        if (!TextUtils.isEmpty(str) && objArr != null) {
            char c = 65535;
            int hashCode = str.hashCode();
            int i = 0;
            if (hashCode != -844359076) {
                if (hashCode == -797343315 && str.equals("web_title")) {
                    c = 0;
                }
            } else if (str.equals(FusionBridgeModule.UI_TARGET_HIDDEN_BACK)) {
                c = 1;
            }
            if (c != 0) {
                if (c == 1 && (objArr[0] instanceof Boolean)) {
                    boolean booleanValue = objArr[0].booleanValue();
                    WebTitleBar webTitleBar = this.mWebTitleBar;
                    if (booleanValue) {
                        i = 8;
                    }
                    webTitleBar.setBackBtnVisibility(i);
                    if (booleanValue) {
                        this.mWebTitleBar.setCloseBtnVisibility(8);
                    }
                }
            } else if (objArr[0] instanceof CharSequence) {
                this.mWebTitleBar.setTitleName(String.valueOf(objArr[0]));
            }
        }
    }

    public void onBackPressed() {
        if (this.mWebTitleBar.getLeftImgView().getVisibility() == 0) {
            super.onBackPressed();
        }
    }

    public void setStatusBar(String str) {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, Color.parseColor(str));
    }

    /* renamed from: a */
    private void m21037a() {
        this.mWebView.setWebChromeClient(new FusionWebChromeClient(this.mWebView));
        WebSettings settings = this.mWebView.getSettings();
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        setWebViewClient(new PayBaseWebActivity.IPayWebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                WalletWebActivity.this.showLoading();
            }

            public void onPageFinished(WebView webView, String str) {
                WalletWebActivity.this.hideLoading();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                WalletWebActivity.this.hideLoading();
            }
        });
        this.f30045a = new LoadingDelegate(this, this);
    }

    public View getFallbackView() {
        return this.mWebTitleBar;
    }

    public LoadingConfig getLoadingConfig() {
        LoadingConfig loadingConfig = new LoadingConfig();
        loadingConfig.setRenderType(LoadingRenderType.ANIMATION);
        return loadingConfig;
    }

    public void showLoading() {
        this.f30045a.showLoading();
    }

    public void showLoading(LoadingConfig loadingConfig) {
        this.f30045a.showLoading(loadingConfig);
    }

    public void hideLoading() {
        this.f30045a.hideLoading();
    }

    public boolean isLoading() {
        return this.f30045a.isLoading();
    }

    public void addViewToTitleBar(View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.mWebTitleBar != null && view != null) {
            this.mWebTitleBar.addView(view, layoutParams);
            this.f30046b.add(view);
        }
    }

    public void removeViewFromTitleBar(Object obj) {
        ArrayList<View> arrayList;
        if (this.mWebTitleBar != null && (arrayList = this.f30046b) != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next.getTag().equals(obj)) {
                    this.f30046b.remove(next);
                    this.mWebTitleBar.removeView(next);
                }
            }
        }
    }

    public void request(String[] strArr, PermissionCallback permissionCallback) {
        f30042c = permissionCallback;
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(strArr, 100);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ContactModule contactModule;
        super.onActivityResult(i, i2, intent);
        if (i == 102 && (contactModule = (ContactModule) this.mWebView.getExportModuleInstance(ContactModule.class)) != null) {
            contactModule.handleContactResult(i2, intent);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 100) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] != 0) {
                    f30042c.onPermissionReject(strArr[i2]);
                } else {
                    f30042c.onPermissionGranted();
                }
            }
        }
    }

    public void updateTitleBar(String str, String str2, int i, int i2) {
        if (this.mWebTitleBar != null) {
            this.mWebTitleBar.updateTitleBar(str, str2, i, i2);
            if (Build.VERSION.SDK_INT >= 21 && !TextUtils.isEmpty(str)) {
                getWindow().setStatusBarColor(Color.parseColor(str));
            }
        }
    }
}
