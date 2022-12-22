package com.didi.sdk.webview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.FusionEngine;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.container.UpdateUIHandler;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.fusionbridge.FusionTimeRecorder;
import com.didi.sdk.fusionbridge.FusionUtil;
import com.didi.sdk.fusionbridge.module.FusionBridgeModule;
import com.didi.sdk.fusionbridge.module.ShareEntranceModule;
import com.didi.sdk.fusionbridge.module.ShareModule;
import com.didi.sdk.home.BizEntranceFragment;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.CommonParamsUtil;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.webview.BaseWebView;
import com.didi.sdk.webview.WebBackInterceptor;
import com.didi.sdk.webview.store.WebConfigStore;
import com.didi.sdk.webview.tool.WebToolCallBack;
import com.didi.sdk.webview.tool.WebViewToolDialog;
import com.didi.sdk.webview.tool.WebViewToolModel;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebFragment extends BizEntranceFragment implements UpdateUIHandler {
    public static final String KEY_WEB_VIEW_MODEL = "web_view_model";
    public static final String KEY_WEB_VIEW_URL = "web_view_url";

    /* renamed from: a */
    private View f38404a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f38405b;
    protected WebBackInterceptor.BackClickInterceptor backClickInterceptor;

    /* renamed from: c */
    private ImageView f38406c;

    /* renamed from: d */
    private TextView f38407d;

    /* renamed from: e */
    private List<WebViewToolModel> f38408e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Logger f38409f = LoggerFactory.getLogger("WebFragment");
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OverrideUrlLoaderSet f38410g = new OverrideUrlLoaderSet();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public FusionTimeRecorder f38411h;

    /* renamed from: i */
    private View.OnClickListener f38412i = new View.OnClickListener() {
        private long mLastClickTime = 0;

        public void onClick(View view) {
            String str;
            AutoTrackHelper.trackViewOnClick(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastClickTime >= 3000) {
                String url = WebFragment.this.mWebView.getUrl();
                if (TextUtils.equals(url, "about:blank")) {
                    WebBackForwardList copyBackForwardList = WebFragment.this.mWebView.copyBackForwardList();
                    int i = -1;
                    while (true) {
                        if (!WebFragment.this.mWebView.canGoBackOrForward(i)) {
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
                    WebFragment.this.mWebView.loadUrl(url);
                    WebFragment.this.f38405b.setVisibility(8);
                } else {
                    WebFragment webFragment = WebFragment.this;
                    webFragment.openUrl(webFragment.mWebViewModel.url);
                }
                this.mLastClickTime = currentTimeMillis;
            }
        }
    };
    protected FusionBridgeModule mJsBridge;
    protected LinearLayout mProgressLayout;
    protected BaseWebView mWebView;
    protected WebViewModel mWebViewModel;

    public int getRootLayoutId() {
        return R.layout.f_webview_fragment;
    }

    public void initCustomerView(View view) {
    }

    public boolean needShowProgressBar() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog(String str) {
    }

    public void setBackClickInterceptor(WebBackInterceptor.BackClickInterceptor backClickInterceptor2) {
        this.backClickInterceptor = backClickInterceptor2;
    }

    public boolean needBackInterceptor() {
        WebBackInterceptor.BackClickInterceptor backClickInterceptor2 = this.backClickInterceptor;
        if (backClickInterceptor2 == null) {
            return false;
        }
        backClickInterceptor2.onInterceptor();
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(getRootLayoutId(), viewGroup, false);
        this.f38404a = inflate;
        initCustomerView(inflate);
        m27173a();
        return this.f38404a;
    }

    /* renamed from: a */
    private void m27173a() {
        BaseWebView baseWebView = (BaseWebView) this.f38404a.findViewById(R.id.web_view);
        this.mWebView = baseWebView;
        baseWebView.setUpdateUIHandler(this);
        this.mWebView.setNeedShowProgressBar(needShowProgressBar());
        this.mProgressLayout = (LinearLayout) this.f38404a.findViewById(R.id.progress_view);
        this.f38405b = this.f38404a.findViewById(R.id.web_error_view);
        this.f38406c = (ImageView) this.f38404a.findViewById(R.id.web_error_image);
        this.f38407d = (TextView) this.f38404a.findViewById(R.id.web_error_text);
        initArgument();
        m27180b();
        addOverrideUrlLoader(new CommonUrlOverrider());
    }

    /* access modifiers changed from: protected */
    public void initArgument() {
        Bundle arguments = getArguments();
        this.mWebViewModel = new WebViewModel();
        if (arguments != null) {
            if (arguments.containsKey("web_view_model")) {
                this.mWebViewModel = (WebViewModel) arguments.getSerializable("web_view_model");
            }
            if (arguments.containsKey(KEY_WEB_VIEW_URL)) {
                this.mWebViewModel.url = arguments.getString(KEY_WEB_VIEW_URL);
                this.mWebViewModel.isSupportCache = true;
            }
        }
    }

    /* renamed from: b */
    private void m27180b() {
        if (!TextUtils.isEmpty(this.mWebViewModel.url)) {
            FusionTimeRecorder fusionTimeRecorder = new FusionTimeRecorder(this.mWebViewModel.url, FusionEngine.getBusinessAgent().shouldIntercept(getContext(), this.mWebViewModel.url));
            this.f38411h = fusionTimeRecorder;
            fusionTimeRecorder.activityStarted();
            this.mWebView.setWebViewSetting(this.mWebViewModel);
            this.mWebView.setWebViewClient(new InnerWebViewClient(this.mWebView));
            this.mWebView.setVerticalScrollBarEnabled(false);
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mJsBridge = this.mWebView.getFusionBridge();
            if (NetUtil.isAvailable(getContext())) {
                openUrl(this.mWebViewModel.url);
            } else {
                m27174a(-6, "没网络", this.mWebViewModel.url);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void refresh() {
        openUrl(this.mWebViewModel.url);
    }

    public void openUrl(String str) {
        if (this.mWebView != null) {
            FusionTimeRecorder fusionTimeRecorder = this.f38411h;
            if (fusionTimeRecorder != null) {
                fusionTimeRecorder.beginLoadUrl();
            }
            showProgress();
            WebViewModel webViewModel = this.mWebViewModel;
            if (webViewModel != null && webViewModel.isAddCommonParam) {
                str = m27172a(str);
            }
            WebViewModel webViewModel2 = this.mWebViewModel;
            if (!(webViewModel2 == null || webViewModel2.queryParamMap == null || this.mWebViewModel.queryParamMap.size() <= 0)) {
                StringBuilder sb = new StringBuilder();
                for (String next : this.mWebViewModel.queryParamMap.keySet()) {
                    sb.append(next);
                    sb.append("=");
                    sb.append(this.mWebViewModel.queryParamMap.get(next));
                }
                if (str.indexOf("?") == -1) {
                    str = str + "?" + sb.toString();
                } else {
                    str = str + ParamKeys.SIGN_AND + sb.toString();
                }
            }
            View view = this.f38405b;
            if (view != null) {
                view.setVisibility(8);
            }
            this.mWebView.loadUrl(str);
        }
    }

    /* renamed from: a */
    private String m27172a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (WebConfigStore.getInstance().isWhiteUrl(str, getActivity())) {
            String replace = CommonParamsUtil.createCommonParamString(getActivity()).replace("token=0", "token=");
            if (str.endsWith("?")) {
                str = str + replace;
            } else if (str.indexOf("?") <= 1) {
                str = str + "?" + replace;
            } else if (str.endsWith(ParamKeys.SIGN_AND)) {
                str = str + replace;
            } else {
                str = str + ParamKeys.SIGN_AND + replace;
            }
        }
        return m27179b(str);
    }

    /* renamed from: b */
    private String m27179b(String str) {
        String str2 = "top_bar_height=" + FusionUtil.getTopBarHeight();
        if (str.indexOf("?") == -1) {
            return str + "?" + str2;
        } else if (str.endsWith(ParamKeys.SIGN_AND)) {
            return str + str2;
        } else {
            return str + ParamKeys.SIGN_AND + str2;
        }
    }

    /* access modifiers changed from: protected */
    public void showProgress() {
        if (this.mProgressLayout.getVisibility() != 0) {
            this.mProgressLayout.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void hideProgress() {
        if (this.mProgressLayout.getVisibility() == 0) {
            this.mProgressLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27174a(int i, String str, String str2) {
        WebTrackUtil.trackError(i, str, str2);
        this.f38405b.setVisibility(0);
        if (i == -14) {
            this.f38406c.setImageResource(R.drawable.icon_webview_error_notfound);
            this.f38407d.setText(R.string.webview_error_notfound);
            this.f38405b.setOnClickListener((View.OnClickListener) null);
        } else if (i == -2 || i == -6 || i == -5) {
            this.f38406c.setImageResource(R.drawable.icon_webview_error_connectfail);
            this.f38407d.setText(R.string.webview_error_connectfail);
            this.f38405b.setOnClickListener(this.f38412i);
        } else if (i == -8) {
            this.f38406c.setImageResource(R.drawable.icon_webview_error_busy);
            this.f38407d.setText(R.string.webview_error_busy);
            this.f38405b.setOnClickListener((View.OnClickListener) null);
        } else {
            this.f38406c.setImageResource(R.drawable.icon_webview_error_connectfail);
            this.f38407d.setText(R.string.webview_error_connectfail);
            this.f38405b.setOnClickListener(this.f38412i);
        }
    }

    /* access modifiers changed from: protected */
    public void invokeEntrance(final CallbackFunction callbackFunction) {
        this.f38409f.debug("invokeEntrance", new Object[0]);
        WebViewToolDialog webViewToolDialog = new WebViewToolDialog();
        List<WebViewToolModel> list = this.f38408e;
        if (list != null && !list.isEmpty()) {
            OmegaWebUtil.trackSharePagedShow(this.f38408e, this.mWebView.getUrl());
            webViewToolDialog.show(getActivity(), this.f38408e, new WebToolCallBack() {
                public void webRedirect(WebViewToolModel webViewToolModel) {
                }

                public void showShareView(final OneKeyShareModel oneKeyShareModel) {
                    final JSONObject jSONObject = new JSONObject();
                    OmegaWebUtil.trackShareChannelClick(oneKeyShareModel.getPlatform(), WebFragment.this.mWebView.getUrl());
                    ShareApi.show((Activity) WebFragment.this.getActivity(), oneKeyShareModel, (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback() {
                        public void onComplete(SharePlatform sharePlatform) {
                            WebFragment.this.m27177a(oneKeyShareModel.getPlatform(), jSONObject, 0, callbackFunction);
                        }

                        public void onError(SharePlatform sharePlatform) {
                            WebFragment.this.m27177a(oneKeyShareModel.getPlatform(), jSONObject, 1, callbackFunction);
                        }

                        public void onCancel(SharePlatform sharePlatform) {
                            WebFragment.this.m27177a(oneKeyShareModel.getPlatform(), jSONObject, 2, callbackFunction);
                        }
                    });
                }

                public void close() {
                    Intent intent = new Intent();
                    intent.setAction(BaseWebActivity.ACTION_INTENT_BROADCAST_CLOSE);
                    WebFragment.this.getActivity().sendBroadcast(intent);
                }

                public void refresh() {
                    WebFragment webFragment = WebFragment.this;
                    webFragment.showProgressDialog(webFragment.getString(R.string.webview_refreshing));
                    WebFragment.this.mWebView.reload();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27177a(String str, JSONObject jSONObject, int i, CallbackFunction callbackFunction) {
        try {
            jSONObject.put("share_result", 2);
            jSONObject.put("channel", ShareModule.getChannelName(str));
        } catch (JSONException unused) {
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(jSONObject);
        }
    }

    public void updateUI(String str, Object... objArr) {
        if (ShareEntranceModule.UI_TARGET_INVOKE_ENTRANCE.equals(str)) {
            invokeEntrance(objArr[0]);
        }
    }

    protected class InnerWebViewClient extends BaseWebView.WebViewClientEx {
        public InnerWebViewClient(HybridableContainer hybridableContainer) {
            super(hybridableContainer);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebFragment.this.f38411h.pageStarted();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            WebFragment.this.f38411h.pageFinished();
            WebFragment.this.f38411h.flush(WebFragment.this.getContext());
            webView.getSettings().setBlockNetworkImage(false);
            WebFragment.this.hideProgress();
            if (Build.VERSION.SDK_INT >= 24 && WebFragment.this.getActivity() != null) {
                MultiLocaleStore.getInstance().getLocaleHelper().refreshAppLocale(WebFragment.this.getActivity());
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            WebFragment.this.hideProgress();
            if (Build.VERSION.SDK_INT < 18) {
                webView.clearView();
            } else {
                webView.loadUrl("about:blank");
            }
            WebFragment.this.m27174a(i, str, str2);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger c = WebFragment.this.f38409f;
            c.debug("shouldOverrideUrlLoading url = " + str, new Object[0]);
            if (WebFragment.this.f38410g.shouldOverrideUrlLoading(webView, str)) {
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    /* access modifiers changed from: protected */
    public void addOverrideUrlLoader(OverrideUrlLoader overrideUrlLoader) {
        this.f38410g.addOverrideUrlLoader(overrideUrlLoader);
    }
}
