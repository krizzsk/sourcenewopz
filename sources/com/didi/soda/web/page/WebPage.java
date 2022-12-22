package com.didi.soda.web.page;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.support.util.BundleBuilder;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.soda.web.UpdateUIHandlerImp;
import com.didi.soda.web.WebFileProvider;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.p168ui.WebMenuListPopup;
import com.didi.soda.web.page.performance.PagePerformanceDelegate;
import com.didi.soda.web.page.performance.PagePerformanceListener;
import com.didi.soda.web.proxy.WebProxy;
import com.didi.soda.web.scan.QrCodeScanPage;
import com.didi.soda.web.tools.KeyboardTool;
import com.didi.soda.web.tools.LogUtil;
import com.didi.soda.web.tools.ScreenOrientationMonitor;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.didi.sofa.utils.ToastUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebPage extends Page implements UpdateUIHandlerImp, SodaWebView.FileChooserListener, SodaWebView.WebPageErrorListener, SodaWebView.WebPageStateListener {

    /* renamed from: a */
    private static final int f43895a = 1005;

    /* renamed from: b */
    private static final int f43896b = 1006;

    /* renamed from: c */
    private static final String f43897c = "web_temp.jpg";

    /* renamed from: d */
    private FrameLayout f43898d;

    /* renamed from: e */
    private ScreenOrientationMonitor f43899e;

    /* renamed from: f */
    private ValueCallback<Uri> f43900f;

    /* renamed from: g */
    private ValueCallback<Uri[]> f43901g;

    /* renamed from: h */
    private File f43902h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WebMenuListPopup f43903i;

    /* renamed from: j */
    private int f43904j;

    /* renamed from: k */
    private PagePerformanceDelegate f43905k;

    /* renamed from: l */
    private WebProxy f43906l;

    /* renamed from: m */
    private WebMenuListPopup.MenuListClickListener f43907m;
    protected WebConfig mWebConfig;

    public IErrorLayout getCustomerErrorLayout() {
        return null;
    }

    public void hideEntrance() {
    }

    /* access modifiers changed from: protected */
    public View inflateTitleBar() {
        return null;
    }

    /* access modifiers changed from: protected */
    public SodaWebView inflateWebView() {
        return null;
    }

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    /* access modifiers changed from: protected */
    public boolean remoteDebuggingEnable() {
        return false;
    }

    public WebPage() {
        this.f43907m = new WebMenuListPopup.MenuListClickListener() {
            public void onMenuCancel() {
                WebPage.this.f43903i.dismiss();
                WebPage.this.m31236a();
            }

            public void onStartCamera() {
                WebPage.this.m31242c();
            }

            public void onStartAlbum() {
                WebPage.this.m31239b();
            }
        };
    }

    public WebPage(WebConfig webConfig) {
        this(new BundleBuilder(new Bundle()).putParcelable(WebConstant.WEB_MODEL, webConfig).build());
    }

    public WebPage(Bundle bundle) {
        super(bundle);
        this.f43907m = new WebMenuListPopup.MenuListClickListener() {
            public void onMenuCancel() {
                WebPage.this.f43903i.dismiss();
                WebPage.this.m31236a();
            }

            public void onStartCamera() {
                WebPage.this.m31242c();
            }

            public void onStartAlbum() {
                WebPage.this.m31239b();
            }
        };
    }

    public void onCreate(View view) {
        super.onCreate(view);
        ScreenOrientationMonitor screenOrientationMonitor = new ScreenOrientationMonitor((Activity) getBaseContext());
        this.f43899e = screenOrientationMonitor;
        screenOrientationMonitor.onCreate();
        this.f43906l = new WebProxy(this, inflateWebView(), inflateTitleBar(), this.f43898d, getCustomerErrorLayout(), this.mWebConfig);
        this.f43902h = new File(getExternalCacheDir(), "web_temp.jpg");
        getWebView().setFileChooserListener(this);
        getWebView().setWebPageErrorListener(this);
        WebMenuListPopup webMenuListPopup = new WebMenuListPopup(getBaseContext(), getScopeContext());
        this.f43903i = webMenuListPopup;
        webMenuListPopup.setListener(this.f43907m);
        this.f43905k = new PagePerformanceDelegate();
    }

    public void onInitialize() {
        super.onInitialize();
        if (getArgs().containsKey(WebConstant.WEB_MODEL)) {
            WebConfig webConfig = (WebConfig) getArgs().getParcelable(WebConstant.WEB_MODEL);
            this.mWebConfig = webConfig;
            webConfig.remoteDebuggable = remoteDebuggingEnable();
            if (TextUtils.isEmpty(this.mWebConfig.url)) {
                finish();
                return;
            }
            return;
        }
        finish();
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.nova_web_page_hybrid, viewGroup, false);
        this.f43898d = frameLayout;
        return frameLayout;
    }

    public void updateUI(String str, Object... objArr) {
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.updateUI(str, objArr);
        }
    }

    public WebPageTitleBar getWebTitleBar() {
        WebProxy webProxy = this.f43906l;
        if (webProxy == null) {
            return null;
        }
        return webProxy.getWebTitleBar();
    }

    /* access modifiers changed from: protected */
    public SodaWebView getWebView() {
        WebProxy webProxy = this.f43906l;
        if (webProxy == null) {
            return null;
        }
        return webProxy.getWebView();
    }

    public boolean getIsUserNativeTitleBar() {
        return this.mWebConfig.isUseNativeTitltBar;
    }

    public void invokeJSMethod(String str, String str2, Object... objArr) {
        if (getWebView() != null) {
            getWebView().getJavascriptBridge().invokeJSMethod(str, str2, objArr);
        }
    }

    public void cancelProgressDialog() {
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.cancelProgressDialog();
        }
    }

    public boolean onInterceptedToNative(String str) {
        LogUtil.info("InterceptedToNative : " + str);
        return false;
    }

    public void onWebPageStarted(WebView webView, String str, Bitmap bitmap) {
        LogUtil.info("onWebPageStarted");
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.onWebPageStarted();
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f43905k;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onWebPageStarted(str);
        }
    }

    public void onWebPageFinished(WebView webView, String str) {
        LogUtil.info("onWebPageFinished : title = " + webView.getTitle());
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.onWebPageFinished(webView, str);
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f43905k;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onWebPageFinished(str);
        }
    }

    public void onWebPageReceivedError(WebView webView, int i, String str, String str2) {
        LogUtil.info("onWebPageReceivedError");
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.onWebPageReceivedError(i, str2);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        LogUtil.info("openFileChooser");
        this.f43900f = valueCallback;
        this.f43903i.show();
    }

    public void onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        LogUtil.info("onShowFileChooser");
        this.f43901g = valueCallback;
        this.f43903i.show();
    }

    public boolean onHandleBack() {
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            return webProxy.onBack();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31236a() {
        ValueCallback<Uri> valueCallback = this.f43900f;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
            this.f43900f = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.f43901g;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue((Object) null);
            this.f43901g = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31239b() {
        this.f43904j = 2;
        requestPermissions(new String[]{Permission.WRITE_EXTERNAL_STORAGE});
    }

    public void onPermissionDenied(String[] strArr) {
        super.onPermissionDenied(strArr);
        finish();
    }

    public void onPermissionGranted() {
        super.onPermissionGranted();
        m31237a(this.f43904j);
    }

    /* renamed from: a */
    private void m31237a(int i) {
        try {
            Intent intent = new Intent();
            int i2 = 0;
            if (i == 1) {
                i2 = 1006;
                intent.setAction("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", m31234a(intent, this.f43902h));
            } else if (i == 2) {
                i2 = 1005;
                intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
                intent.setAction("android.intent.action.GET_CONTENT");
            }
            if (intent.resolveActivity(getPackageManager()) != null) {
                this.f43903i.dismiss();
                startActivityForResult(intent, i2);
            } else if (Build.VERSION.SDK_INT >= 30) {
                this.f43903i.dismiss();
                startActivityForResult(intent, i2);
            } else {
                ToastUtils.show(getBaseContext(), (CharSequence) "can not find target page");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m31242c() {
        this.f43904j = 1;
        requestPermissions(new String[]{Permission.CAMERA});
    }

    /* renamed from: a */
    private Uri m31234a(Intent intent, File file) {
        if (Build.VERSION.SDK_INT <= 23) {
            return Uri.fromFile(file);
        }
        Context baseContext = getBaseContext();
        Uri uriForFile = WebFileProvider.getUriForFile(baseContext, getBaseContext().getPackageName() + WebConstant.WEB_FILE_PATH, file);
        for (ResolveInfo resolveInfo : getBaseContext().getPackageManager().queryIntentActivities(intent, 65536)) {
            getBaseContext().grantUriPermission(resolveInfo.activityInfo.packageName, uriForFile, 3);
        }
        return uriForFile;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1005 && i != 1006) {
            return;
        }
        if (this.f43901g != null) {
            m31240b(i, i2, intent);
        } else {
            m31238a(i, i2, intent);
        }
    }

    public void reLoad(String str) {
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.reLoadUrl(str);
        }
    }

    public void reLoadSelf() {
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.reloadSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r6 = r6.getDataString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m31238a(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            android.webkit.ValueCallback<android.net.Uri> r0 = r3.f43900f
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1005(0x3ed, float:1.408E-42)
            r1 = -1
            r2 = 0
            if (r4 != r0) goto L_0x0018
            if (r5 != r1) goto L_0x0018
            java.lang.String r6 = r6.getDataString()
            if (r6 == 0) goto L_0x0018
            android.net.Uri r6 = android.net.Uri.parse(r6)
            goto L_0x0019
        L_0x0018:
            r6 = r2
        L_0x0019:
            r0 = 1006(0x3ee, float:1.41E-42)
            if (r4 != r0) goto L_0x0027
            if (r5 != r1) goto L_0x0027
            java.io.File r4 = r3.f43902h
            if (r4 == 0) goto L_0x0027
            android.net.Uri r6 = android.net.Uri.fromFile(r4)
        L_0x0027:
            android.webkit.ValueCallback<android.net.Uri> r4 = r3.f43900f
            r4.onReceiveValue(r6)
            r3.f43900f = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.web.page.WebPage.m31238a(int, int, android.content.Intent):void");
    }

    /* renamed from: b */
    private void m31240b(int i, int i2, Intent intent) {
        Uri[] uriArr;
        File file;
        if (this.f43901g != null) {
            if (i == 1005 && i2 == -1 && intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        uriArr[i3] = clipData.getItemAt(i3).getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
            } else {
                uriArr = null;
            }
            if (i == 1006 && i2 == -1 && (file = this.f43902h) != null) {
                uriArr = new Uri[]{Uri.fromFile(file)};
            }
            this.f43901g.onReceiveValue(uriArr);
            this.f43901g = null;
        }
    }

    public void onDestroy() {
        ScreenOrientationMonitor screenOrientationMonitor = this.f43899e;
        if (screenOrientationMonitor != null) {
            screenOrientationMonitor.onDestroy();
        }
        WebProxy webProxy = this.f43906l;
        if (webProxy != null) {
            webProxy.destory();
        }
        PagePerformanceDelegate pagePerformanceDelegate = this.f43905k;
        if (pagePerformanceDelegate != null) {
            pagePerformanceDelegate.onDestroy();
        }
        super.onDestroy();
    }

    public void finishPage() {
        finish();
        KeyboardTool.hideSoftInput(getBaseContext(), (View) null);
    }

    public void launchScan(final CallbackFunction callbackFunction) {
        getScopeContext().getNavigator().push(new QrCodeScanPage() {
            public void provideScanResult(String str) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("message", str);
                    if (callbackFunction != null) {
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(jSONObject)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    CallbackFunction callbackFunction = callbackFunction;
                    if (callbackFunction != null) {
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                    }
                }
            }
        });
    }

    public void showEntrance(CallbackFunction callbackFunction, String str) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void onEntranceClick(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        invokeEntrance(list, callbackFunction);
    }

    public void invokeEntrance(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void showSystemEntrance(ShareToolModel shareToolModel, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void updateNav(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    public void setPagePerformanceListener(PagePerformanceListener pagePerformanceListener) {
        LogUtil.info("setPagePerformanceListener");
        PagePerformanceDelegate pagePerformanceDelegate = this.f43905k;
        if (pagePerformanceDelegate == null) {
            LogUtil.info("Delegate null");
        } else {
            pagePerformanceDelegate.setPerformanceListener(pagePerformanceListener);
        }
    }
}
