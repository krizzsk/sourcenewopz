package com.didi.entrega.customer.p113h5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.HorizontalChangeHandler;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.log.RecordTracker;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.CouponInfo;
import com.didi.entrega.customer.foundation.share.ShareHelper;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.entrega.customer.foundation.util.AndroidBug5497Workaround;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.GsonUtil;
import com.didi.entrega.customer.p113h5.hybird.CustomerHybridModule;
import com.didi.entrega.customer.p113h5.hybird.CustomerHybridWebChromeClient;
import com.didi.entrega.customer.p113h5.hybird.CustomerHybridWebViewClient;
import com.didi.entrega.customer.p113h5.hybird.WebChromeClientCallback;
import com.didi.entrega.customer.p113h5.hybird.WebViewClientCallback;
import com.didi.entrega.customer.p113h5.hybird.WebViewModelCallback;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillFlutterModuleService;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.web.GlobalJsBridge;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.page.WebPage;
import com.didi.soda.web.page.performance.PagePerformance;
import com.didi.soda.web.page.performance.PagePerformanceListener;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Route({"webPage"})
/* renamed from: com.didi.entrega.customer.h5.CustomerWebPage */
public class CustomerWebPage extends WebPage implements WebChromeClientCallback, WebViewClientCallback, WebViewModelCallback {
    public static final String ARGS_KEY_REMOVES_FROM_VIEW_ON_PUSH = "removesFromViewOnPush";

    /* renamed from: a */
    private static final String f20165a = "CustomerWebPage";

    /* renamed from: b */
    private static final String f20166b = "isSuc";

    /* renamed from: c */
    private boolean f20167c = true;

    /* renamed from: d */
    private CustomerHybridWebViewClient f20168d;

    /* renamed from: e */
    private CustomerHybridModule f20169e;

    /* renamed from: f */
    private Subscription f20170f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m14855a(Void voidR) {
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void shouldInterceptRequest(WebView webView, String str) {
    }

    public CustomerWebPage() {
        DiRouter.registerHub("webPage", this);
    }

    public void invokeEntrance(List<ShareToolModel> list, final CallbackFunction callbackFunction) {
        super.invokeEntrance(list, callbackFunction);
        ShareHelper.getInstance().showSharePlatform(getBaseContext(), (ArrayList<ShareToolModel>) (ArrayList) list, (ICallback.IShareCallback) new ICallback.IShareCallback() {
            public void onCancel() {
                GlobalJsBridge.createResultJson("", callbackFunction, 2);
            }

            public void onCancel(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 2);
            }

            public void onComplete(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 0);
            }

            public void onError(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 1);
            }
        });
    }

    public void onCreate(View view) {
        try {
            super.onCreate(view);
            GlobalContext.getTitleAndBizBarManager().hideTitleBar();
            CustomerSystemUtil.setStatusBarBgLightning(false);
            m14854a();
            m14856b();
            m14857c();
            AndroidBug5497Workaround.getInstance((Activity) getBaseContext()).assistComponent(getScopeContext(), getView());
            setPagePerformanceListener(new PagePerformanceListener() {
                public void onPagePerformance(PagePerformance pagePerformance) {
                    LogUtil.m14761d(CustomerWebPage.f20165a, "pagePerformance totalTime: " + pagePerformance.totalTime + " url: " + pagePerformance.url);
                    PerformanceOmegaHelper.getInstance().trackWebViewPerformance(pagePerformance.url, pagePerformance.totalTime);
                }
            });
        } catch (Exception unused) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CustomerHybridModule customerHybridModule = this.f20169e;
        if (customerHybridModule != null) {
            customerHybridModule.setWebViewCallback((WebViewModelCallback) null);
        }
        Subscription subscription = this.f20170f;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f20170f = null;
        }
    }

    public void onEntranceClick(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        super.onEntranceClick(list, callbackFunction);
    }

    public void onPageFinished(WebView webView, String str) {
        m14853a("onPageFinished", "c-state|").setOtherParam("Url", str).build().info();
        if (getWebTitleBar() != null) {
            getWebTitleBar().setCloseBtnVisibility(8);
            if (!this.mWebConfig.url.equals(str)) {
                if (!this.f20167c) {
                    getWebTitleBar().setCloseBtnVisibility(0);
                }
                getWebTitleBar().setBackBtnVisibility(0);
            } else if (this.f20167c) {
                getWebTitleBar().setBackBtnVisibility(0);
            } else {
                getWebTitleBar().setBackBtnVisibility(8);
            }
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        m14853a("onPageStarted", "c-state|").setOtherParam("Url", str).build().info();
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_HYBRID_PAGE_START).addEventParam("url", str).build().track();
    }

    public void onConsoleMessage(ConsoleMessage consoleMessage) {
        try {
            if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
                String sourceId = consoleMessage.sourceId();
                String message = consoleMessage.message();
                StringBuilder sb = new StringBuilder();
                if (!TextUtils.isEmpty(sourceId)) {
                    Uri parse = Uri.parse(sourceId);
                    sb.append(parse.getScheme());
                    sb.append(HWMapConstant.HTTP.SEPARATOR);
                    sb.append(parse.getHost());
                    sb.append(parse.getPath());
                }
                if (TextUtils.isEmpty(message)) {
                    message = "unknown";
                }
                String url = getWebView().getUrl();
                LogUtil.m14765i(f20165a, "onConsoleMessage url: " + url + ", msg: " + message + ", resUrl: " + sb + "lineNumber =" + consoleMessage.lineNumber() + "messageLevel =" + consoleMessage.messageLevel());
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HYBRID_JS_ERROR).addModuleName("hybrid").addErrorMsg(message).addParam("url", url).addParam("resUrl", sb.toString()).addParam("sourceId", sourceId).build().trackError();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        m14853a("onReceivedError", "c-state|").setOtherParam(Constants.ERROR_CODE, Integer.valueOf(i)).setOtherParam("description", str).setOtherParam("failingUrl", str2).build().error();
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HYBRID_PAGE_ERROR).addModuleName("hybrid").addErrorType(String.valueOf(i)).addErrorMsg(str).addParam("url", str2).build().trackError();
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (CustomerWebPage.this.getWebTitleBar() != null) {
                    CustomerWebPage.this.getWebTitleBar().setCloseBtnVisibility(0);
                }
            }
        }, 500);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Uri url = webResourceRequest.getUrl();
                StringBuilder sb = new StringBuilder();
                if (url != null) {
                    sb.append(url.getScheme());
                    sb.append(HWMapConstant.HTTP.SEPARATOR);
                    sb.append(url.getHost());
                    sb.append(url.getPath());
                }
                int i = 0;
                String str2 = "";
                if (webResourceResponse != null) {
                    i = webResourceResponse.getStatusCode();
                    str2 = webResourceResponse.getReasonPhrase();
                    str = webResourceResponse.getMimeType();
                } else {
                    str = str2;
                }
                String url2 = webView.getUrl();
                LogUtil.m14765i(f20165a, "onReceivedHttpError url: " + url2 + ", code: " + i + ", msg: " + str2 + ", sourceUrl: " + sb + ", mimeType: " + str);
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HYBRID_HTTP_ERROR).addModuleName("hybrid").addErrorType(String.valueOf(i)).addErrorMsg(str2).addParam("url", url2).addParam("resUrl", sb.toString()).addParam("mimeType", str).build().trackError();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        if (!TextUtils.isEmpty(str) && !str.contains(".com") && !str.contains("html") && !str.contains("/") && !str.contains("?") && getWebTitleBar() != null) {
            getWebTitleBar().setTitle(str);
        }
    }

    public void onStart() {
        super.onStart();
        if (getView() != null) {
            getView().setPadding(getView().getPaddingLeft(), getStatusBarHeight(), getView().getPaddingRight(), getView().getPaddingBottom());
        }
    }

    public ScopeContext proviedScopeContext() {
        return getScopeContext();
    }

    public void selectCoupon(String str, int i, String str2) {
        HashMap hashMap = new HashMap();
        CouponInfo couponInfo = new CouponInfo();
        couponInfo.setCouponId(str);
        couponInfo.setSelected(1);
        hashMap.put(Const.BundleKey.SELECT_COUPON, GsonUtil.toJson(couponInfo));
        ((GLEUniBillFlutterModuleService) UniAPI.get(GLEUniBillFlutterModuleService.class)).updateBillInfoData(GsonUtil.toJson(hashMap), $$Lambda$CustomerWebPage$eqMBJ5auA4s0sFgvET6hNRqyFcU.INSTANCE);
        finish();
    }

    public ControllerChangeHandler getPushHandler() {
        Bundle bundle;
        Bundle args = getArgs();
        boolean z = true;
        if (!(args == null || (bundle = args.getBundle("webpagebundle")) == null)) {
            z = bundle.getBoolean("removesFromViewOnPush", true);
        }
        return new HorizontalChangeHandler(z);
    }

    public void showSystemEntrance(ShareToolModel shareToolModel, final CallbackFunction callbackFunction) {
        super.showSystemEntrance(shareToolModel, callbackFunction);
        ShareHelper.getInstance().systemShare(GlobalContext.getContext(), shareToolModel, new ICallback.IShareCallback() {
            public void onCancel() {
                GlobalJsBridge.createResultJson("", callbackFunction, 2);
            }

            public void onCancel(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 2);
            }

            public void onComplete(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 0);
            }

            public void onError(SharePlatform sharePlatform) {
                GlobalJsBridge.createResultJson(sharePlatform.platformName(), callbackFunction, 1);
            }
        });
    }

    /* access modifiers changed from: protected */
    public boolean remoteDebuggingEnable() {
        return CustomerToolBoxUtil.DEBUG;
    }

    /* access modifiers changed from: protected */
    public int getStatusBarHeight() {
        return CustomerSystemUtil.getImmersiveStatusBarHeight(getBaseContext());
    }

    /* renamed from: a */
    private void m14854a() {
        Bundle args = getArgs();
        if (args != null) {
            this.f20167c = args.getBoolean("backbuttonshow", true);
        }
        LogUtil.m14765i(f20165a, "initParams, mBackBtnShow = " + this.f20167c);
    }

    /* renamed from: b */
    private void m14856b() {
        WebPageTitleBar webTitleBar = getWebTitleBar();
        if (webTitleBar == null) {
            return;
        }
        if (this.f20167c) {
            webTitleBar.setBackBtnVisibility(0);
        } else {
            webTitleBar.setBackBtnVisibility(8);
        }
    }

    /* renamed from: c */
    private void m14857c() {
        SodaWebView webView = getWebView();
        if (webView == null) {
            LogUtil.m14763e(f20165a, "iniJsFunctions - webPage fusionWebView is null");
            OmegaSDKAdapter.trackEvent("soda_c_x_webPage_webview_null");
            finish();
            return;
        }
        CustomerHybridWebViewClient customerHybridWebViewClient = new CustomerHybridWebViewClient(webView, this);
        this.f20168d = customerHybridWebViewClient;
        customerHybridWebViewClient.setWebPageStateListener(this);
        this.f20168d.setWebPageErrorListener(this);
        CustomerHybridWebChromeClient customerHybridWebChromeClient = new CustomerHybridWebChromeClient(webView, this);
        customerHybridWebChromeClient.setWebPageErrorListener(this);
        WebHelper.attachOmegaJS(webView, this.f20168d);
        webView.setWebViewClient(this.f20168d);
        webView.setWebChromeClient(customerHybridWebChromeClient);
        CustomerHybridModule customerHybridModule = (CustomerHybridModule) webView.getExportModuleInstance(CustomerHybridModule.class);
        this.f20169e = customerHybridModule;
        customerHybridModule.setWebViewCallback(this);
    }

    /* renamed from: a */
    private RecordTracker.Builder m14853a(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f20165a).setMessage(str).setLogCategory(str2);
    }
}
