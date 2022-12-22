package com.didi.soda.customer.p165h5;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.HorizontalChangeHandler;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.PageBackHelper;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.share.ShareHelper;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridModule;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebChromeClient;
import com.didi.soda.customer.p165h5.hybird.CustomerHybridWebViewClient;
import com.didi.soda.customer.p165h5.hybird.WebChromeClientCallback;
import com.didi.soda.customer.p165h5.hybird.WebViewClientCallback;
import com.didi.soda.customer.p165h5.hybird.WebViewModelCallback;
import com.didi.soda.customer.p165h5.hybird.module.ContactModule;
import com.didi.soda.customer.p165h5.invokejs.TriggerJsHelper;
import com.didi.soda.customer.repo.CustomerActivityResultRepo;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.home.policy.HomePolicyHelper;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.pay.BindCardHelper;
import com.didi.soda.pay.PayOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.didi.soda.web.GlobalJsBridge;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.model.ShareToolModel;
import com.didi.soda.web.p168ui.IErrorLayout;
import com.didi.soda.web.page.WebPage;
import com.didi.soda.web.page.performance.PagePerformance;
import com.didi.soda.web.page.performance.PagePerformanceListener;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.didi.soda.web.widgets.SodaWebView;
import com.didi.soda.web.widgets.WebPageTitleBar;
import com.didi.universal.pay.biz.model.PayStatusModel;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@Route({"webPage"})
/* renamed from: com.didi.soda.customer.h5.CustomerWebPage */
public class CustomerWebPage extends WebPage implements WebChromeClientCallback, WebViewClientCallback, WebViewModelCallback {
    public static final String ARGS_KEY_REMOVES_FROM_VIEW_ON_PUSH = "removesFromViewOnPush";
    public static final int VALUE_FROM_TAB = 1;

    /* renamed from: a */
    private static final String f41289a = "CustomerWebPage";

    /* renamed from: b */
    private static final String f41290b = "isSuc";

    /* renamed from: c */
    private boolean f41291c = true;

    /* renamed from: d */
    private CustomerHybridWebViewClient f41292d;

    /* renamed from: e */
    private CustomerHybridModule f41293e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Subscription f41294f;

    /* renamed from: g */
    private CustomerWebErrorLayoutImp f41295g;

    /* renamed from: h */
    private TriggerJsHelper f41296h = new TriggerJsHelper();
    protected boolean mFromTab = false;

    public void finishedLoadHtml() {
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void shouldInterceptRequest(WebView webView, String str) {
    }

    public CustomerWebPage() {
        DiRouter.registerHub("webPage", this);
    }

    public void cancelOrder(String str, String str2, String str3, String str4) {
        int parseInt = Integer.parseInt(str2);
        if (!TextUtils.isEmpty(str) && parseInt == 901) {
            ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(str);
        }
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

    public void onInitialize() {
        super.onInitialize();
        Bundle args = getArgs();
        if (args != null) {
            boolean z = false;
            if (args.getInt(Const.PageParams.WEBPAGE_FROM_TAB, 0) == 1) {
                z = true;
            }
            this.mFromTab = z;
        }
    }

    public void onCreate(View view) {
        try {
            super.onCreate(view);
            GlobalContext.getTitleAndBizBarManager().hideTitleBar();
            CustomerSystemUtil.setStatusBarBgLightning(false);
            m29244a();
            m29249b();
            m29251c();
            AndroidBug5497Workaround.getInstance((Activity) getBaseContext()).assistComponent(getScopeContext(), getView());
            setPagePerformanceListener(new PagePerformanceListener() {
                public void onPagePerformance(PagePerformance pagePerformance) {
                    LogUtil.m29100d(CustomerWebPage.f41289a, "pagePerformance totalTime: " + pagePerformance.totalTime + " url: " + pagePerformance.url);
                    PerformanceOmegaHelper.getInstance().trackWebViewPerformance(pagePerformance.url, pagePerformance.totalTime);
                }
            });
            this.f41296h.attach(getScopeContext(), this);
        } catch (Exception unused) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        CustomerHybridModule customerHybridModule = this.f41293e;
        if (customerHybridModule != null) {
            customerHybridModule.setWebViewCallback((WebViewModelCallback) null);
        }
        Subscription subscription = this.f41294f;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f41294f = null;
        }
        HomePolicyHelper.getInstance().checkReShowPolicyDialog();
        this.f41296h.detach();
    }

    public IErrorLayout getCustomerErrorLayout() {
        if (!this.mFromTab) {
            return super.getCustomerErrorLayout();
        }
        if (this.f41295g == null) {
            this.f41295g = new CustomerWebErrorLayoutImp(this, (ErrorCallback) null, true);
        }
        return this.f41295g;
    }

    public View getPageRootView() {
        return getView();
    }

    public void onEntranceClick(List<ShareToolModel> list, CallbackFunction callbackFunction) {
        super.onEntranceClick(list, callbackFunction);
    }

    /* renamed from: a */
    private boolean m29247a(String str, String str2) {
        try {
            Uri parse = Uri.parse(str);
            Uri parse2 = Uri.parse(str2);
            if (!TextUtils.equals(parse.getScheme(), parse2.getScheme()) || !TextUtils.equals(parse.getHost(), parse2.getHost()) || !TextUtils.equals(parse.getPath(), parse2.getPath())) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onPageFinished(WebView webView, String str) {
        m29248b("onPageFinished", "c-state|").setOtherParam("Url", str).build().info();
        if (getWebTitleBar() != null) {
            getWebTitleBar().setCloseBtnVisibility(8);
            if (!m29247a(this.mWebConfig.url, str)) {
                if (!this.f41291c && !this.mFromTab) {
                    getWebTitleBar().setCloseBtnVisibility(0);
                    getWebTitleBar().setCloseBtnListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CustomerWebPage.this.m29245a(view);
                        }
                    });
                }
                if (this.f41291c) {
                    getWebTitleBar().setBackBtnVisibility(0);
                }
            } else if (this.f41291c) {
                getWebTitleBar().setBackBtnVisibility(0);
            } else {
                getWebTitleBar().setBackBtnVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29245a(View view) {
        finishPage();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        m29248b("onPageStarted", "c-state|").setOtherParam("Url", str).build().info();
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
                LogUtil.m29104i(f41289a, "onConsoleMessage url: " + url + ", msg: " + message + ", resUrl: " + sb + "lineNumber =" + consoleMessage.lineNumber() + "messageLevel =" + consoleMessage.messageLevel());
                ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HYBRID_JS_ERROR).addModuleName("hybrid").addErrorMsg(message).addParam("url", url).addParam("resUrl", sb.toString()).addParam("sourceId", sourceId).build().trackError();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        m29248b("onReceivedError", "c-state|").setOtherParam(Constants.ERROR_CODE, Integer.valueOf(i)).setOtherParam("description", str).setOtherParam("failingUrl", str2).build().error();
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_HYBRID_PAGE_ERROR).addModuleName("hybrid").addErrorType(String.valueOf(i)).addErrorMsg(str).addParam("url", str2).build().trackError();
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (CustomerWebPage.this.getWebTitleBar() != null && !CustomerWebPage.this.mFromTab) {
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
                LogUtil.m29104i(f41289a, "onReceivedHttpError url: " + url2 + ", code: " + i + ", msg: " + str2 + ", sourceUrl: " + sb + ", mimeType: " + str);
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
        CustomerWebErrorLayoutImp customerWebErrorLayoutImp = this.f41295g;
        if (customerWebErrorLayoutImp != null) {
            customerWebErrorLayoutImp.onStart();
        }
    }

    public ScopeContext proviedScopeContext() {
        return getScopeContext();
    }

    public void selectCoupon(String str, String str2, int i, String str3) {
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(new CouponInfoEntity(str, 1, (String) null, (String) null, 0, (String) null, (String) null, i, str3));
        finish();
    }

    public void setRiskAuthResult(JSONObject jSONObject) {
        if (jSONObject != null) {
            Bundle bundle = new Bundle();
            bundle.putString("risk_auth_result", jSONObject.toString());
            finish(bundle);
        }
    }

    public void queryPayStatus(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
        payParamEntity.token = LoginUtil.getToken();
        String optString = jSONObject.optString("orderTransId", (String) null);
        if (!TextUtils.isEmpty(optString)) {
            payParamEntity.transId = optString;
            ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).getPayStatus((Activity) getBaseContext(), getScopeContext(), payParamEntity, new ICustomerPayManager.PayCallback() {
                public void onThirdPayStart(int i) {
                }

                public void payFail(int i, String str, PayStatusModel payStatusModel) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("statusCode", i);
                        jSONObject.put(ParamConst.PARAM_PAY_STATUS_MSG, str);
                        jSONObject.put(CustomerWebPage.f41290b, false);
                        CallBackModel callBackModel = new CallBackModel(jSONObject);
                        callBackModel.errno = 0;
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(callBackModel));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void paySucceed() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(CustomerWebPage.f41290b, true);
                        CallBackModel callBackModel = new CallBackModel(jSONObject);
                        callBackModel.errno = 0;
                        callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(callBackModel));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void bindCard(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 14;
        addCardParam.isShowLoading = true;
        addCardParam.isSignAfterOrder = true;
        addCardParam.productLine = AppConst.BUSINESS_ID;
        addCardParam.resourceId = Const.BindCardScene.ORDER_H5;
        BindCardHelper.bindCard(addCardParam, 1);
        Subscription subscription = this.f41294f;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f41294f = null;
        }
        this.f41294f = ((CustomerActivityResultRepo) RepoFactory.getRepo(CustomerActivityResultRepo.class)).subscribeResult(getScopeContext(), new Action1<CustomerActivityResultRepo.ActivityResult>() {
            public void call(CustomerActivityResultRepo.ActivityResult activityResult) {
                if (activityResult != null && activityResult.requestCode == 1) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(0, (JSONObject) null)));
                    PayOmegaHelper.bindCardResult(activityResult, "hybrid");
                }
                if (CustomerWebPage.this.f41294f != null) {
                    CustomerWebPage.this.f41294f.unsubscribe();
                    Subscription unused = CustomerWebPage.this.f41294f = null;
                }
            }
        }, 1);
    }

    public JSONObject registerTrigger(JSONObject jSONObject) {
        return this.f41296h.registerTrigger(jSONObject);
    }

    public void unregisterTrigger(JSONObject jSONObject) {
        this.f41296h.unregisterTrigger(jSONObject);
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
    private void m29244a() {
        Bundle args = getArgs();
        if (args != null) {
            this.f41291c = args.getBoolean("backbuttonshow", true);
        }
        LogUtil.m29104i(f41289a, "initParams, mBackBtnShow = " + this.f41291c + " mFromTab = " + this.mFromTab);
    }

    public boolean onHandleBack() {
        if (!this.mFromTab) {
            return super.onHandleBack();
        }
        super.onHandleBack();
        return true;
    }

    public void finishPage() {
        if (!this.mFromTab) {
            super.finishPage();
        }
    }

    public void finish() {
        if (!PageBackHelper.Companion.popBackStack(this, true)) {
            super.finish();
        }
    }

    public void finish(Bundle bundle) {
        if (!PageBackHelper.Companion.popBackStack(this, true)) {
            super.finish(bundle);
        }
    }

    /* renamed from: b */
    private void m29249b() {
        WebPageTitleBar webTitleBar = getWebTitleBar();
        if (webTitleBar != null) {
            if (this.f41291c) {
                webTitleBar.setBackBtnVisibility(0);
            } else {
                webTitleBar.setBackBtnVisibility(8);
            }
            if (this.mFromTab) {
                m29252c(webTitleBar);
            } else {
                m29250b(webTitleBar);
            }
        }
    }

    /* renamed from: a */
    private void m29246a(WebPageTitleBar webPageTitleBar) {
        try {
            TextView textView = (TextView) webPageTitleBar.findViewById(R.id.common_title_bar_middle_tv);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.removeRule(13);
            layoutParams.addRule(15);
            layoutParams.leftMargin = DisplayUtils.dip2px(webPageTitleBar.getContext(), 21.0f);
            textView.setLayoutParams(layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m29250b(WebPageTitleBar webPageTitleBar) {
        try {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface((TextView) webPageTitleBar.findViewById(R.id.common_title_bar_middle_tv), IToolsService.FontType.MEDIUM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m29252c(WebPageTitleBar webPageTitleBar) {
        try {
            m29246a(webPageTitleBar);
            TextView textView = (TextView) webPageTitleBar.findViewById(R.id.common_title_bar_middle_tv);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(textView, IToolsService.FontType.BOLD);
            textView.setTextSize(1, 24.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m29251c() {
        SodaWebView webView = getWebView();
        if (webView == null) {
            LogUtil.m29102e(f41289a, "iniJsFunctions - webPage fusionWebView is null");
            OmegaSDKAdapter.trackEvent("soda_c_x_webPage_webview_null");
            finish();
            return;
        }
        CustomerHybridWebViewClient customerHybridWebViewClient = new CustomerHybridWebViewClient(webView, this);
        this.f41292d = customerHybridWebViewClient;
        customerHybridWebViewClient.setWebPageStateListener(this);
        this.f41292d.setWebPageErrorListener(this);
        CustomerHybridWebChromeClient customerHybridWebChromeClient = new CustomerHybridWebChromeClient(webView, this);
        customerHybridWebChromeClient.setWebPageErrorListener(this);
        WebHelper.attachOmegaJS(webView, this.f41292d);
        webView.setWebViewClient(this.f41292d);
        webView.setWebChromeClient(customerHybridWebChromeClient);
        CustomerHybridModule customerHybridModule = (CustomerHybridModule) webView.getExportModuleInstance(CustomerHybridModule.class);
        this.f41293e = customerHybridModule;
        customerHybridModule.setWebViewCallback(this);
    }

    /* renamed from: b */
    private RecordTracker.Builder m29248b(String str, String str2) {
        return RecordTracker.Builder.create().setTag(f41289a).setMessage(str).setLogCategory(str2);
    }

    public void updateTitleBar(String str, String str2, int i, int i2, String str3) {
        WebPageTitleBar webTitleBar = getWebTitleBar();
        if (webTitleBar != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    webTitleBar.setTitleBarBgColor(Color.parseColor(str));
                }
                if (!TextUtils.isEmpty(str2)) {
                    webTitleBar.setTitleBarTextColor(Color.parseColor(str2));
                }
                webTitleBar.setBackImageColor(ResourceHelper.getColor(i == 0 ? R.color.rf_color_gery_1_0_000000 : R.color.rf_color_white_100_FFFFFF));
                if (TextUtils.equals(str3, "left")) {
                    m29246a(webTitleBar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ContactModule contactModule;
        super.onActivityResult(i, i2, intent);
        if (i == 102 && (contactModule = (ContactModule) getWebView().getExportModuleInstance(ContactModule.class)) != null) {
            contactModule.handleContactResult(i2, intent);
        }
    }
}
