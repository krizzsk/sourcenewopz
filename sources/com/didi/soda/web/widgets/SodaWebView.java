package com.didi.soda.web.widgets;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.soda.web.BizAgent;
import com.didi.soda.web.SodaFusionEngine;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.overriders.IUrlOverriders;
import com.didi.soda.web.tools.SystemUtils;
import com.didi.sofa.utils.ToastUtils;
import java.util.LinkedHashSet;

public class SodaWebView extends FusionWebView {

    /* renamed from: a */
    private Context f43945a;

    /* renamed from: b */
    private final LinkedHashSet<IUrlOverriders> f43946b = new LinkedHashSet<>();

    /* renamed from: c */
    private FileChooserListener f43947c;

    /* renamed from: d */
    private SodaWebViewClient f43948d;

    /* renamed from: e */
    private SodaWebChromeClient f43949e;

    public interface FileChooserListener {
        void onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams);

        void openFileChooser(ValueCallback<Uri> valueCallback);
    }

    public interface WebPageErrorListener {
        void onConsoleMessage(ConsoleMessage consoleMessage);

        void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);
    }

    public interface WebPageStateListener {
        boolean onInterceptedToNative(String str);

        void onWebPageFinished(WebView webView, String str);

        void onWebPageReceivedError(WebView webView, int i, String str, String str2);

        void onWebPageStarted(WebView webView, String str, Bitmap bitmap);
    }

    /* access modifiers changed from: protected */
    public void alert(String str) {
    }

    public SodaWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31267a(context);
    }

    public SodaWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31267a(context);
    }

    public SodaWebView(Context context) {
        super(context);
        m31267a(context);
    }

    /* renamed from: a */
    private void m31267a(final Context context) {
        String appUserAgent;
        this.f43945a = context;
        this.f43948d = new SodaWebViewClient(this);
        this.f43949e = new SodaWebChromeClient(this);
        setWebViewClient(this.f43948d);
        setWebChromeClient(this.f43949e);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setData(Uri.parse(str));
                if (intent.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent);
                } else if (Build.VERSION.SDK_INT >= 30) {
                    context.startActivity(intent);
                } else {
                    ToastUtils.show(SodaWebView.this.getContext(), (CharSequence) "can not find browser");
                }
            }
        });
        WebSettings settings = getSettings();
        if (settings != null) {
            settings.setTextZoom(100);
        }
        BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
        if ((businessAgent instanceof BizAgent) && (appUserAgent = ((BizAgent) businessAgent).getAppUserAgent()) != null) {
            appendUserAgent(appUserAgent + "/" + SystemUtils.getVersionName(getActivity()));
        }
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    public void loadUrl(String str) {
        super.loadUrl(SodaFusionEngine.getBusinessAgent().addCommonQuery(str));
    }

    public UpdateUIHandler getUpdateUIHandler() {
        return super.getUpdateUIHandler();
    }

    public void setWebViewSetting(WebConfig webConfig) {
        WebSettings settings = getSettings();
        if (webConfig != null && settings != null) {
            if (webConfig.isSupportCache) {
                settings.setCacheMode(-1);
            } else {
                settings.setCacheMode(2);
            }
            BusinessAgent businessAgent = SodaFusionEngine.getBusinessAgent();
            if ((businessAgent instanceof BizAgent) && Build.VERSION.SDK_INT >= 21) {
                if (((BizAgent) businessAgent).isAllowMixContent(webConfig.url)) {
                    settings.setMixedContentMode(2);
                } else {
                    settings.setMixedContentMode(1);
                }
            }
        }
    }

    public void addUrlOverriders(IUrlOverriders iUrlOverriders) {
        this.f43948d.addUrlOverriders(iUrlOverriders);
    }

    public void setWebPageStateListener(WebPageStateListener webPageStateListener) {
        this.f43948d.setWebPageStateListener(webPageStateListener);
    }

    public void setFileChooserListener(FileChooserListener fileChooserListener) {
        this.f43949e.setFileChooserListener(fileChooserListener);
    }

    public void setWebPageErrorListener(WebPageErrorListener webPageErrorListener) {
        this.f43949e.setWebPageErrorListener(webPageErrorListener);
        this.f43948d.setWebPageErrorListener(webPageErrorListener);
    }

    public boolean doBack() {
        String str;
        WebBackForwardList copyBackForwardList = copyBackForwardList();
        String url = getUrl();
        int i = -1;
        while (canGoBackOrForward(i)) {
            if (TextUtils.equals(url, "about:blank") && !SystemUtils.isNetWorkAvailable(this.f43945a)) {
                return true;
            }
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
            if (itemAtIndex == null) {
                str = null;
            } else {
                str = itemAtIndex.getUrl();
            }
            if (str == null || TextUtils.equals(str, url) || TextUtils.equals(str, "about:blank")) {
                i--;
            } else {
                goBackOrForward(i);
                return true;
            }
        }
        return false;
    }

    public void destroy() {
        setWebPageStateListener((WebPageStateListener) null);
        setFileChooserListener((FileChooserListener) null);
        stopLoading();
        clearCache(true);
        clearFormData();
        clearMatches();
        clearSslPreferences();
        clearDisappearingChildren();
        clearHistory();
        clearAnimation();
        loadUrl("about:blank");
        removeAllViews();
        freeMemory();
        super.destroy();
    }
}
