package com.didi.dimina.webview.dmwebview;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.p106ui.webview.FileChooser;
import com.didi.dimina.container.p106ui.webview.FileChooserOpener;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.dimina.container.util.ToastUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.dimina.webview.container.FusionWebChromeClient;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;

public class DMWebChromeClient extends FusionWebChromeClient {

    /* renamed from: a */
    private boolean f18241a = false;

    /* renamed from: b */
    private final DMWebView f18242b;

    /* renamed from: c */
    private FileChooser f18243c;

    /* renamed from: d */
    private WebViewEngine.OnTitleReceiveListener f18244d;

    public DMWebChromeClient(DMWebView dMWebView) {
        super(dMWebView);
        this.f18242b = dMWebView;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (i < 25) {
            if (this.f18241a) {
                this.f18241a = false;
            }
        } else if (!this.f18241a) {
            this.f18241a = true;
        }
        if (i < 100) {
            this.f18242b.showLoadProgress(i);
        } else {
            this.f18242b.hiddenLoadProgress();
        }
    }

    public boolean onShowFileChooser(WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient.FileChooserParams fileChooserParams) {
        final Context context = webView.getContext();
        PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(context, Permission.CAMERA, DiminaPermissionDescDialog.createCameraDescInfo(this.f18242b.getDmMina()), new SinglePermissionCallBack() {
            public void onDenied(String str) {
                Context context = context;
                ToastUtil.show(context, context.getString(R.string.dimina_permission_camera_grant_failed));
                valueCallback.onReceiveValue((Object) null);
            }

            public void onGranted(String str) {
                DMWebChromeClient.this.getFileChooser().showFileChooser(valueCallback, fileChooserParams);
            }
        });
        return true;
    }

    public FileChooser getFileChooser() {
        if (this.f18243c == null) {
            DMWebView dMWebView = this.f18242b;
            this.f18243c = new FileChooser(dMWebView, (FileChooserOpener) dMWebView.getDmPage().getHost());
        }
        return this.f18243c;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            if (Dimina.getConfig() == null || !Dimina.getConfig().isDebug()) {
                LogUtil.eRelease("webview_log", "[error] " + consoleMessage.message());
                LogUtil.eRelease("webview_log", "[error] sourceId = " + consoleMessage.sourceId());
                LogUtil.eRelease("webview_log", "[error] lineNumber = " + consoleMessage.lineNumber());
            } else {
                LogUtil.m13409e("tag_web_view | " + consoleMessage.message());
            }
        }
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.TIP) {
            LogUtil.m13411i("tag_web_view | " + consoleMessage.message());
        }
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.LOG) {
            LogUtil.m13411i("tag_web_view | " + consoleMessage.message());
        }
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.WARNING) {
            LogUtil.m13413w("tag_web_view | " + consoleMessage.message());
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.DEBUG) {
            return true;
        }
        LogUtil.m13407d("tag_web_view | " + consoleMessage.message());
        return true;
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (this.f18244d != null && !TextUtils.isEmpty(str) && !URLUtil.isNetworkUrl(str) && !str.endsWith(".html") && !str.endsWith(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)) {
            this.f18244d.onReceiveTitle(str);
        }
    }

    public void setOnTitleReceiveListener(WebViewEngine.OnTitleReceiveListener onTitleReceiveListener) {
        this.f18244d = onTitleReceiveListener;
    }
}
