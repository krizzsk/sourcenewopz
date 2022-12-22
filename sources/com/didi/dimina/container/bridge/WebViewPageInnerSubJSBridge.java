package com.didi.dimina.container.bridge;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.blankscreen.CheckBlankScreenManager;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p106ui.webview.DMWebViewScrollClient;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.PathUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.container.util.TimeUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import org.json.JSONArray;
import org.json.JSONObject;

public class WebViewPageInnerSubJSBridge {

    /* renamed from: a */
    private final DMMina f16671a;

    /* renamed from: b */
    private final DMPage f16672b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final WebViewEngine f16673c;

    WebViewPageInnerSubJSBridge(DMPage dMPage, DMMina dMMina, WebViewEngine webViewEngine) {
        this.f16672b = dMPage;
        this.f16671a = dMMina;
        this.f16673c = webViewEngine;
    }

    public void invokeWebViewReady(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (this.f16672b.poolMark != 4) {
            if (this.f16672b.poolMark == 3) {
                String str = this.f16672b.getNavigateConfig().packages;
                if (TextUtils.isEmpty(str)) {
                    str = "app";
                }
                String splitPath = HttpUtil.splitPath(this.f16672b.getNavigateConfig().url);
                StringBuilder sb = new StringBuilder();
                sb.append(Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_PREFIX);
                sb.append((splitPath.startsWith("/") ? splitPath.substring(1) : splitPath).replaceAll("/", "_"));
                String sb2 = sb.toString();
                String transform2AbsolutePath = BundleManager.getInstance().transform2AbsolutePath(this.f16671a, Constant.BundleConstant.SDK_MODULE_NAME, Constant.LAUNCHER_WEB_VIEW.PAGE_FRAME);
                StringBuilder sb3 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f16671a, str, Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME)));
                StringBuilder sb4 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f16671a, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_NAME)));
                StringBuilder sb5 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, BundleManager.getInstance().transform2AbsolutePath(this.f16671a, "app", Constant.LAUNCHER_JS.APP_WEB_VIEW_STYLE_NAME)));
                BundleManager instance = BundleManager.getInstance();
                DMMina dMMina = this.f16671a;
                StringBuilder sb6 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, instance.transform2AbsolutePath(dMMina, str, sb2 + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_SUFFIX)));
                BundleManager instance2 = BundleManager.getInstance();
                DMMina dMMina2 = this.f16671a;
                StringBuilder sb7 = new StringBuilder(PathUtil.resolveRelativePath(transform2AbsolutePath, instance2.transform2AbsolutePath(dMMina2, str, sb2 + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX)));
                JSONObject jSONObject2 = JSONUtil.toJSONObject(this.f16672b.getNavigateConfig().query);
                if (!SameLayerRenderingUtil.isSameLayerRenderingReady(this.f16673c)) {
                    JSONUtil.put(jSONObject2, SameLayerRenderingUtil.KEY_DOWNGRADE_VIEW_TYPE, 1);
                }
                JSONObject jSONObject3 = new JSONObject();
                JSONUtil.put(jSONObject3, MessageWrapperBuilder.ARG_WEB_VIEW_ID, this.f16672b.getWebViewId());
                JSONUtil.put(jSONObject3, "route", (Object) splitPath);
                JSONUtil.put(jSONObject3, "query", (Object) JSONUtil.combineJson(HttpUtil.parseUrlQueryJSONObject(this.f16671a.getConfig().getLaunchConfig().getAppId(), this.f16672b.getNavigateConfig().url), jSONObject2));
                JSONUtil.put(jSONObject3, "openType", (Object) this.f16672b.getNavigateConfig().openType);
                JSONUtil.put(jSONObject3, "appWebViewPath", (Object) sb3.toString());
                JSONUtil.put(jSONObject3, "mainAppWebViewPath", (Object) sb4.toString());
                JSONUtil.put(jSONObject3, "appStyleSheetPath", (Object) sb5.toString());
                JSONUtil.put(jSONObject3, "pageStyleSheetPath", (Object) sb6.toString());
                JSONUtil.put(jSONObject3, "pageJavascriptPath", (Object) sb7.toString());
                JSONObject build = new MessageWrapperBuilder().stackId(this.f16672b.getNavigator().getIndex()).data(jSONObject3).webViewId(this.f16672b.getWebViewId()).build();
                this.f16671a.getMessageTransfer().sendMessageToWebView(this.f16673c, "invokeParamsToWinDone", build);
                this.f16671a.getDmWebViewManager().put(Integer.valueOf(this.f16672b.getWebViewId()), this.f16673c);
                this.f16671a.getPerformance().markWinDone();
                int minaIndex = this.f16671a.getMinaIndex();
                TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.PAGE_INVOKE_PARAMS_TO_WIN_DONE, "from: invokeWebViewReady(), msg: " + build);
                return;
            }
            int webViewId = this.f16673c.getDmPage().getWebViewId();
            int minaIndex2 = this.f16671a.getMinaIndex();
            TraceUtil.trackEventCoreDotting(minaIndex2, Constant.CORE_DOTTING.PAGE_INVOKE_PRELOAD_WEB_VIEW_FINISH, "from: invokeWebViewReady(), webviewId: " + webViewId);
            this.f16671a.getDmPagePool().putDMPageToReady(webViewId);
            TraceUtil.traceInvokeWebViewReady(this.f16671a.getMinaIndex(), this.f16671a.getCurNavigator().getNavigator().getCurrentPage().getPage().getUrl(), TimeUtil.currentNanoMillis() - this.f16671a.getPerformance().getMarkJSPackageStart());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54550a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        IPageHost iPageHost;
        int minaIndex = this.f16671a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.DIMINA_PAGE_DOM_READY, "webViewId: " + this.f16673c.getDmPage().getWebViewId());
        this.f16673c.getDmPage().setRenderFinish();
        m12292a();
        Fragment host = this.f16672b.getHost();
        Fragment parentFragment = host.getParentFragment();
        if (parentFragment instanceof ITabBarPageHost) {
            iPageHost = (IPageHost) parentFragment;
        } else {
            iPageHost = host instanceof IPageHost ? (IPageHost) host : null;
        }
        if (iPageHost != null) {
            iPageHost.getClass();
            UIHandlerUtil.runOnUiThread(new Runnable() {
                public final void run() {
                    IPageHost.this.invokeDomReady();
                }
            });
            this.f16671a.getDmPagePool().genDMPage4DomReady();
            this.f16671a.getPerformance().markDOMReady(this.f16672b);
        }
    }

    /* renamed from: a */
    private void m12292a() {
        DMConfig.BlankScreenConfig checkScreenBlankConfig = this.f16671a.getConfig().getLaunchConfig().getCheckScreenBlankConfig();
        if (checkScreenBlankConfig != null) {
            CheckBlankScreenManager checkBlankScreenManager = new CheckBlankScreenManager();
            checkBlankScreenManager.config(checkScreenBlankConfig, this.f16671a).start(this.f16673c.getContainer());
            this.f16672b.setCheckBlankScreenManager(checkBlankScreenManager);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54551b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DMWebViewScrollClient diminaWebViewScrollClient = this.f16673c.getDiminaWebViewScrollClient();
        if (diminaWebViewScrollClient == null) {
            CallBackUtil.onFail("dmWebViewScrollClient is null.", callbackFunction);
            return;
        }
        diminaWebViewScrollClient.setOnPageScrollEmitToEngine(true);
        int optInt = jSONObject.optInt("throttle", -1);
        if (optInt > 0) {
            diminaWebViewScrollClient.setOnPageScrollThrottle(optInt);
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("keyScrollTop");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                int[] iArr = new int[length];
                for (int i = 0; i < length; i++) {
                    iArr[i] = ((Integer) optJSONArray.get(i)).intValue();
                }
                diminaWebViewScrollClient.setOnPageScrollTopKeys(iArr);
            }
            CallBackUtil.onSuccess(callbackFunction);
        } catch (Exception e) {
            diminaWebViewScrollClient.setOnPageScrollTopKeys((int[]) null);
            e.printStackTrace();
            CallBackUtil.onFail(e.getMessage(), callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54552c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject.has("scrollTop")) {
            try {
                if (this.f16673c.getDiminaWebViewScrollClient() != null) {
                    int optInt = jSONObject.optInt("scrollTop");
                    int optInt2 = jSONObject.optInt("duration", 0);
                    int dip2px = PixUtil.dip2px(Dimina.getConfig().getApp(), (float) optInt);
                    if (optInt2 > 16) {
                        final ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f16673c.getWebView().getScrollY(), dip2px});
                        ofInt.setDuration((long) optInt2);
                        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                WebViewPageInnerSubJSBridge.this.f16673c.getWebView().scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                            }
                        });
                        UIHandlerUtil.post(new Runnable() {
                            public void run() {
                                ofInt.start();
                            }
                        });
                        return;
                    }
                    this.f16673c.getWebView().scrollTo(0, dip2px);
                    CallBackUtil.onSuccess(callbackFunction);
                }
            } catch (Exception e) {
                e.printStackTrace();
                CallBackUtil.onFail(e.getMessage(), callbackFunction);
            }
        } else {
            CallBackUtil.onSuccess(callbackFunction);
        }
    }
}
