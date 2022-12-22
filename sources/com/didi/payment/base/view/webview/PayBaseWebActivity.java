package com.didi.payment.base.view.webview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.onehybrid.BusinessAgent;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.container.BaseHybridableActivity;
import com.didi.onehybrid.container.FusionWebChromeClient;
import com.didi.onehybrid.container.FusionWebView;
import com.didi.onehybrid.container.FusionWebViewClient;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.view.webview.overrider.CommonUrlOverrider;
import com.didi.payment.base.view.webview.overrider.OverrideUrlLoader;
import com.didi.payment.base.view.webview.overrider.OverrideUrlLoaderSet;
import com.didi.payment.base.view.webview.overrider.TicketUrlOverrider;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.webview.BaseWebActivity;
import com.didiglobal.pay.paysecure.prepaidcard.UrlUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class PayBaseWebActivity extends BaseHybridableActivity {
    public static final String EXTRA_TITLE = "TITLE";
    public static final String EXTRA_URL = "URL";
    public static final String EXTRA_WEB_MODEL = "WEB_MODEL";
    private BroadcastReceiver mBroadcastReceiver;
    private ImageView mErrorImage;
    private TextView mErrorText;
    /* access modifiers changed from: private */
    public View mErrorView;
    private View.OnClickListener mOnBackClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            PayBaseWebActivity.this.goBack(true);
        }
    };
    private View.OnClickListener mOnCloseClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            PayBaseWebActivity.this.finishWithResultCodeOK();
        }
    };
    private Intent mResultIntent;
    protected View mRootView;
    /* access modifiers changed from: private */
    public OverrideUrlLoaderSet mUrlOverriders = new OverrideUrlLoaderSet();
    protected WebTitleBar mWebTitleBar;
    protected FusionWebView mWebView;
    /* access modifiers changed from: private */
    public IPayWebViewClient mWebViewClient;
    protected WebModel mWebViewModel;
    private View.OnClickListener onClickListenerReload = new View.OnClickListener() {
        private long mLastClickTime = 0;

        public void onClick(View view) {
            String str;
            AutoTrackHelper.trackViewOnClick(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime >= 3000) {
                String url = PayBaseWebActivity.this.mWebView.getUrl();
                if (TextUtils.equals(url, "about:blank")) {
                    WebBackForwardList copyBackForwardList = PayBaseWebActivity.this.mWebView.copyBackForwardList();
                    int i = -1;
                    while (true) {
                        if (!PayBaseWebActivity.this.mWebView.canGoBackOrForward(i)) {
                            url = "";
                            break;
                        }
                        WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
                        if (itemAtIndex == null) {
                            str = null;
                        } else {
                            str = itemAtIndex.getUrl();
                        }
                        if (str != null && !str.equals("about:blank")) {
                            url = str;
                            break;
                        }
                        i--;
                    }
                }
                if (!TextUtils.isEmpty(url)) {
                    PayBaseWebActivity.this.mWebView.loadUrl(url);
                    PayBaseWebActivity.this.mErrorView.setVisibility(8);
                } else {
                    PayBaseWebActivity.this.loadUrl();
                    PayBaseWebActivity.this.mErrorView.setVisibility(8);
                }
                this.mLastClickTime = currentTimeMillis;
            }
        }
    };

    public interface IPayWebViewClient {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str, Bitmap bitmap);

        void onReceivedError(WebView webView, int i, String str, String str2);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getHeaders() {
        return null;
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        setActivityTheme();
        setActivityStatusBar();
        super.onCreate(bundle);
        startPendingTransition();
        registerBroadcastReceiver();
        if (initData()) {
            initView();
            loadUrl();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FusionWebView fusionWebView = this.mWebView;
        if (fusionWebView != null) {
            fusionWebView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        FusionWebView fusionWebView = this.mWebView;
        if (fusionWebView != null) {
            fusionWebView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        FusionWebView fusionWebView = this.mWebView;
        if (fusionWebView != null) {
            if (fusionWebView.getParent() != null && (this.mWebView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.mWebView.getParent()).removeView(this.mWebView);
            }
            this.mWebView.removeAllViews();
            this.mWebView.destroy();
        }
        unregisterBroadcastReceiver();
    }

    public void finish() {
        super.finish();
        finishPendingTransition();
    }

    public void onBackPressed() {
        goBack(true);
    }

    public FusionWebView getWebView() {
        return this.mWebView;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public WebTitleBar getWebTitleBar() {
        return this.mWebTitleBar;
    }

    private boolean initData() {
        Intent intent = getIntent();
        if (intent == null) {
            finishWithResultCodeCanceled();
            return false;
        }
        if (intent.hasExtra(EXTRA_WEB_MODEL)) {
            this.mWebViewModel = (WebModel) intent.getSerializableExtra(EXTRA_WEB_MODEL);
        } else if (!intent.hasExtra(EXTRA_URL)) {
            finishWithResultCodeCanceled();
            return false;
        } else {
            WebModel webModel = new WebModel();
            this.mWebViewModel = webModel;
            webModel.url = intent.getStringExtra(EXTRA_URL);
            if (intent.hasExtra("TITLE")) {
                this.mWebViewModel.title = intent.getStringExtra("TITLE");
            }
        }
        WebModel webModel2 = this.mWebViewModel;
        if (webModel2 != null && !TextUtils.isEmpty(webModel2.url)) {
            return true;
        }
        finishWithResultCodeCanceled();
        return false;
    }

    private void initView() {
        setContentView((int) R.layout.pay_base_activity_web);
        this.mRootView = findViewById(R.id.root_view);
        this.mWebTitleBar = (WebTitleBar) findViewById(R.id.web_title_bar);
        WebModel webModel = this.mWebViewModel;
        if (webModel != null && !TextUtils.isEmpty(webModel.title)) {
            this.mWebTitleBar.setTitleName(this.mWebViewModel.title);
        }
        this.mWebTitleBar.setCloseBtnVisibility(8);
        this.mWebTitleBar.setMoreBtnVisibility(8);
        this.mWebTitleBar.setOnBackClickListener(this.mOnBackClickListener);
        this.mWebTitleBar.setOnCloseClickListener(this.mOnCloseClickListener);
        this.mErrorView = findViewById(R.id.web_error_view);
        this.mErrorImage = (ImageView) findViewById(R.id.web_error_image);
        this.mErrorText = (TextView) findViewById(R.id.web_error_text);
        FusionWebView fusionWebView = (FusionWebView) findViewById(R.id.web_view);
        this.mWebView = fusionWebView;
        fusionWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.BROWSABLE");
                    intent.setData(Uri.parse(str));
                    PayBaseWebActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.mWebView.setWebViewClient(new FusionWebViewClient(this.mWebView) {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (PayBaseWebActivity.this.mUrlOverriders.shouldOverrideUrlLoading(webView, str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (PayBaseWebActivity.this.mWebViewClient != null) {
                    PayBaseWebActivity.this.mWebViewClient.onPageStarted(webView, str, bitmap);
                }
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (PayBaseWebActivity.this.mWebViewClient != null) {
                    PayBaseWebActivity.this.mWebViewClient.onPageFinished(webView, str);
                }
                if (PayBaseWebActivity.this.mWebView.canGoBack()) {
                    PayBaseWebActivity.this.mWebTitleBar.setCloseBtnVisibility(0);
                } else {
                    PayBaseWebActivity.this.mWebTitleBar.setCloseBtnVisibility(8);
                }
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (Build.VERSION.SDK_INT < 18) {
                    webView.clearView();
                } else {
                    webView.loadUrl("about:blank");
                }
                if (PayBaseWebActivity.this.mWebViewClient != null) {
                    PayBaseWebActivity.this.mWebViewClient.onReceivedError(webView, i, str, str2);
                }
                PayBaseWebActivity.this.showErrorView(i, str, str2);
            }
        });
        this.mWebView.setWebChromeClient(new FusionWebChromeClient(this.mWebView) {
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                PayBaseWebActivity.this.mWebTitleBar.setTitleName(str);
            }
        });
        addOverrideUrlLoader(new CommonUrlOverrider());
        addOverrideUrlLoader(new TicketUrlOverrider(this));
        showUI();
    }

    private void showUI() {
        if (NetUtil.isAvailable(this)) {
            loadUrl();
        } else {
            showErrorView(-6, (String) null, (String) null);
        }
    }

    private void registerBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter(BaseWebActivity.ACTION_INTENT_BROADCAST_CLOSE);
        C105287 r1 = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                PayBaseWebActivity.this.finishWithResultCodeOK();
            }
        };
        this.mBroadcastReceiver = r1;
        try {
            registerReceiver(r1, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    private void unregisterBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.mBroadcastReceiver = null;
        }
    }

    /* access modifiers changed from: private */
    public void loadUrl() {
        if (this.mWebViewModel != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("appversion", PayBaseParamUtil.getStringParam(this, "appversion"));
            this.mWebViewModel.url = UrlUtils.Companion.buildParamsUrl(this.mWebViewModel.url, hashMap);
            Map<String, String> headers = getHeaders();
            if (headers == null || headers.isEmpty()) {
                this.mWebView.loadUrl(this.mWebViewModel.url);
            } else {
                loadUrlWithHeaders(this.mWebViewModel.url, headers);
            }
        }
    }

    private void loadUrlWithHeaders(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || str.startsWith("javascript:") || map == null) {
            this.mWebView.loadUrl(str);
            return;
        }
        BusinessAgent businessAgent = FusionEngine.getBusinessAgent();
        String addCommonQuery = businessAgent.addCommonQuery(str);
        Map<String, String> commonHeaders = businessAgent.getCommonHeaders();
        if (commonHeaders != null && !commonHeaders.isEmpty()) {
            map.putAll(commonHeaders);
        }
        this.mWebView.loadUrl(addCommonQuery, map);
    }

    /* access modifiers changed from: private */
    public void showErrorView(int i, String str, String str2) {
        this.mErrorView.setVisibility(0);
        if (i == -14) {
            this.mErrorImage.setImageResource(R.drawable.pay_base_icon_webview_error_notfound);
            this.mErrorText.setText(R.string.pay_base_webview_error_notfound);
            this.mErrorView.setOnClickListener((View.OnClickListener) null);
        } else if (i == -2 || i == -6 || i == -5) {
            this.mErrorImage.setImageResource(R.drawable.pay_base_icon_webview_error_connectfail);
            this.mErrorText.setText(R.string.pay_base_webview_error_connectfail);
            this.mErrorView.setOnClickListener(this.onClickListenerReload);
        } else if (i == -8) {
            this.mErrorImage.setImageResource(R.drawable.pay_base_icon_webview_error_busy);
            this.mErrorText.setText(R.string.pay_base_webview_error_busy);
            this.mErrorView.setOnClickListener((View.OnClickListener) null);
        } else {
            this.mErrorImage.setImageResource(R.drawable.pay_base_icon_webview_error_connectfail);
            this.mErrorText.setText(R.string.pay_base_webview_error_connectfail);
            this.mErrorView.setOnClickListener(this.onClickListenerReload);
        }
    }

    public boolean goBack(boolean z) {
        String str;
        hideEntrance();
        View view = this.mErrorView;
        if (view != null) {
            view.setVisibility(8);
        }
        WebBackForwardList copyBackForwardList = this.mWebView.copyBackForwardList();
        boolean z2 = false;
        String url = this.mWebView.getUrl();
        int i = -1;
        while (true) {
            if (this.mWebView.canGoBackOrForward(i)) {
                if (TextUtils.equals(url, "about:blank") && !NetUtil.isAvailable(this)) {
                    finishWithResultCodeOK();
                    break;
                }
                WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
                if (itemAtIndex == null) {
                    str = null;
                } else {
                    str = itemAtIndex.getUrl();
                }
                if (str != null && !TextUtils.equals(str, url) && !TextUtils.equals(str, "about:blank")) {
                    this.mWebView.goBackOrForward(i);
                    break;
                }
                i--;
            } else {
                break;
            }
        }
        z2 = true;
        if (!z2 && z) {
            finishWithResultCodeOK();
        }
        return z2;
    }

    private void hideEntrance() {
        this.mWebTitleBar.setMoreBtnVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void setActivityTheme() {
        setTheme(R.style.GlobalActivityTheme);
    }

    /* access modifiers changed from: protected */
    public void setActivityStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: protected */
    public void startPendingTransition() {
        overridePendingTransition(R.anim.pay_base_slide_in, R.anim.pay_base_slide_out);
    }

    /* access modifiers changed from: protected */
    public void finishPendingTransition() {
        overridePendingTransition(0, R.anim.pay_base_slide_out);
    }

    /* access modifiers changed from: protected */
    public void finishWithResultCodeOK() {
        setResult(-1, this.mResultIntent);
        finish();
    }

    public void finishWithResultCodeCanceled() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void addOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        this.mUrlOverriders.addOverrideUrlLoader(overrideUrlLoader);
    }

    public void setWebViewClient(IPayWebViewClient iPayWebViewClient) {
        this.mWebViewClient = iPayWebViewClient;
    }

    public void setResultIntent(Intent intent) {
        this.mResultIntent = intent;
    }
}
