package com.didi.dimina.container.bridge;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bean.JSAppConfig;
import com.didi.dimina.container.bean.NavigateConfig;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMLaunchLifecycleManager;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;
import com.didi.dimina.container.util.TraceUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NavigateSubJSBridge {

    /* renamed from: b */
    private static final String f16615b = "NavigateSubJSBridge";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final DMMina f16616a;

    NavigateSubJSBridge(DMMina dMMina) {
        LogUtil.m13411i("NavigateSubJSBridge init");
        this.f16616a = dMMina;
    }

    public void coreRequestFinished(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.f16616a.getPerformance().traceInteractionTime(jSONObject.optString("page", ""));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54467a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_LAUNCH, "params: " + jSONObject);
        this.f16616a.getPerformance().markWebViewOpen();
        if (this.f16616a.checkAndDoExitInMiniLaunch()) {
            CallBackUtil.onFail("启动中退出小程序", callbackFunction);
        } else if (TextUtils.equals(jSONObject.optString("openType", ""), "appLaunchStack")) {
            UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
                public final /* synthetic */ JSONObject f$1;
                public final /* synthetic */ CallbackFunction f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    NavigateSubJSBridge.this.m12243j(this.f$1, this.f$2);
                }
            });
        } else {
            DMLaunchLifecycleManager.getInstance().hookFirstPageLaunch(this.f16616a);
            this.f16616a.getPerformance().markWebViewOpenFirst();
            String optString = jSONObject.optString("url", "");
            if (inMainTabs(this.f16616a, jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1), optString)) {
                UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
                    public final /* synthetic */ JSONObject f$1;
                    public final /* synthetic */ CallbackFunction f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        NavigateSubJSBridge.this.m12242i(this.f$1, this.f$2);
                    }
                });
            } else {
                this.f16616a.getDmPagePool().requireReadyDMPageCreated(new IDMCommonAction(jSONObject, callbackFunction) {
                    public final /* synthetic */ JSONObject f$1;
                    public final /* synthetic */ CallbackFunction f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void callback(Object obj) {
                        NavigateSubJSBridge.this.m12238a(this.f$1, this.f$2, (Void) obj);
                    }
                }, optString);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void m12243j(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease("Dimina-Core-Dotting", "appLaunchStack");
        m12239a(jSONObject, false, callbackFunction);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m12242i(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease("Dimina-Core-Dotting", "appLaunch main tab");
        m12239a(jSONObject, true, callbackFunction);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12238a(JSONObject jSONObject, CallbackFunction callbackFunction, Void voidR) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                NavigateSubJSBridge.this.m12241h(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m12241h(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease("Dimina-Core-Dotting", "appLaunch page");
        m12239a(jSONObject, true, callbackFunction);
    }

    /* renamed from: a */
    private void m12239a(JSONObject jSONObject, boolean z, CallbackFunction callbackFunction) {
        if (jSONObject.has("url")) {
            String optString = jSONObject.optString("url");
            int minaIndex = this.f16616a.getMinaIndex();
            String splitPath = HttpUtil.splitPath(optString);
            if (splitPath.startsWith("/")) {
                splitPath = splitPath.substring(1);
            }
            if (this.f16616a.getJSAppConfig().containPath(splitPath)) {
                NavigateConfig navigateConfig = new NavigateConfig();
                navigateConfig.url = optString;
                navigateConfig.isLaunch = z;
                navigateConfig.openType = jSONObject.optString("openType", "appLaunch");
                navigateConfig.packages = jSONObject.optString("package", "");
                navigateConfig.query = jSONObject.optString("query", "{}");
                DMMinaNavigatorDelegate a = m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtil.put(jSONObject2, "success", false);
                    JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "堆栈为空");
                    callbackFunction.onCallBack(jSONObject2);
                    return;
                }
                a.hideLaunchView(minaIndex);
                if (a.launch(minaIndex, a.getIndex(), navigateConfig)) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONUtil.put(jSONObject3, "success", true);
                    callbackFunction.onCallBack(jSONObject3);
                    return;
                }
                JSONObject jSONObject4 = new JSONObject();
                JSONUtil.put(jSONObject4, "success", false);
                JSONUtil.put(jSONObject4, DMWebSocketListener.KEY_ERR_MSG, (Object) "启动失败");
                callbackFunction.onCallBack(jSONObject4);
                return;
            }
            JSONObject jSONObject5 = new JSONObject();
            JSONUtil.put(jSONObject5, "success", false);
            JSONUtil.put(jSONObject5, DMWebSocketListener.KEY_ERR_MSG, (Object) "未找到指定页面，无法跳转");
            callbackFunction.onCallBack(jSONObject5);
            return;
        }
        JSONObject jSONObject6 = new JSONObject();
        JSONUtil.put(jSONObject6, "success", false);
        JSONUtil.put(jSONObject6, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错");
        callbackFunction.onCallBack(jSONObject6);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54468b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_RELAUNCH, "params: " + jSONObject);
        this.f16616a.getPerformance().markWebViewOpen();
        UIHandlerUtil.safePost(this.f16616a, new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                NavigateSubJSBridge.this.m12240g(this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m12240g(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease("Dimina-Core-Dotting", InternalJSMethod.RELAUNCH);
        LogUtil.m13411i("NavigateSubJSBridge reLaunch: " + jSONObject);
        if (jSONObject.has("url")) {
            NavigateConfig navigateConfig = new NavigateConfig();
            navigateConfig.url = jSONObject.optString("url");
            navigateConfig.isLaunch = true;
            navigateConfig.openType = jSONObject.optString("openType", InternalJSMethod.RELAUNCH);
            navigateConfig.packages = jSONObject.optString("package", "");
            navigateConfig.query = jSONObject.optString("query", "{}");
            DMMinaNavigatorDelegate a = m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
            if (a == null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONUtil.put(jSONObject2, "success", false);
                JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "堆栈为空");
                callbackFunction.onCallBack(jSONObject2);
                return;
            }
            a.reLaunch(this.f16616a.getMinaIndex(), a.getIndex(), navigateConfig);
            IPageHost currentPage = a.getCurrentPage();
            if (currentPage == null) {
                JSONObject jSONObject3 = new JSONObject();
                JSONUtil.put(jSONObject3, "success", false);
                JSONUtil.put(jSONObject3, DMWebSocketListener.KEY_ERR_MSG, (Object) "操作失败");
                callbackFunction.onCallBack(jSONObject3);
                return;
            }
            if (currentPage instanceof ITabBarPageHost) {
                currentPage = ((ITabBarPageHost) currentPage).getCurrentPage();
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONUtil.put(jSONObject4, "success", true);
            if (!(currentPage == null || currentPage.getPage() == null)) {
                JSONUtil.put(jSONObject4, MessageWrapperBuilder.ARG_WEB_VIEW_ID, currentPage.getPage().getWebViewId());
            }
            callbackFunction.onCallBack(jSONObject4);
            return;
        }
        JSONObject jSONObject5 = new JSONObject();
        JSONUtil.put(jSONObject5, "success", false);
        JSONUtil.put(jSONObject5, DMWebSocketListener.KEY_ERR_MSG, (Object) "操作失败");
        callbackFunction.onCallBack(jSONObject5);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54469c(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_REDIRECT_TO, "params: " + jSONObject);
        this.f16616a.getPerformance().markWebViewOpen();
        UIHandlerUtil.safePost(this.f16616a, new Runnable() {
            public void run() {
                LogUtil.iRelease("Dimina-Core-Dotting", InternalJSMethod.REDIRECT_TO);
                if (jSONObject.has("url")) {
                    String optString = jSONObject.optString("url");
                    int minaIndex = NavigateSubJSBridge.this.f16616a.getMinaIndex();
                    if (NavigateSubJSBridge.this.f16616a.getJSAppConfig().containPath(optString)) {
                        NavigateConfig navigateConfig = new NavigateConfig();
                        navigateConfig.url = optString;
                        navigateConfig.openType = jSONObject.optString("openType", InternalJSMethod.REDIRECT_TO);
                        navigateConfig.packages = jSONObject.optString("package", "");
                        navigateConfig.query = jSONObject.optString("query", "{}");
                        DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                        if (a == null) {
                            JSONObject jSONObject = new JSONObject();
                            JSONUtil.put(jSONObject, "success", false);
                            JSONUtil.put(jSONObject, DMWebSocketListener.KEY_ERR_MSG, (Object) "堆栈为空");
                            callbackFunction.onCallBack(jSONObject);
                        } else if (a.redirectTo(minaIndex, a.getIndex(), navigateConfig)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONUtil.put(jSONObject2, "success", true);
                            callbackFunction.onCallBack(jSONObject2);
                        } else {
                            JSONObject jSONObject3 = new JSONObject();
                            JSONUtil.put(jSONObject3, "success", false);
                            JSONUtil.put(jSONObject3, DMWebSocketListener.KEY_ERR_MSG, (Object) "启动失败");
                            callbackFunction.onCallBack(jSONObject3);
                        }
                    } else {
                        JSONObject jSONObject4 = new JSONObject();
                        JSONUtil.put(jSONObject4, "success", false);
                        JSONUtil.put(jSONObject4, DMWebSocketListener.KEY_ERR_MSG, (Object) "未找到指定页面，无法跳转");
                        callbackFunction.onCallBack(jSONObject4);
                    }
                } else {
                    JSONObject jSONObject5 = new JSONObject();
                    JSONUtil.put(jSONObject5, "success", false);
                    JSONUtil.put(jSONObject5, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错");
                    callbackFunction.onCallBack(jSONObject5);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo54472d(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_NAVIGATE_TO, "params: " + jSONObject);
        this.f16616a.getPerformance().markWebViewOpen();
        UIHandlerUtil.safePost(this.f16616a, new Runnable() {
            public void run() {
                LogUtil.iRelease("Dimina-Core-Dotting", InternalJSMethod.NAVIGATE_TO);
                DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a == null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "success", false);
                    JSONUtil.put(jSONObject, DMWebSocketListener.KEY_ERR_MSG, (Object) "堆栈为空");
                    callbackFunction.onCallBack(jSONObject);
                } else if (jSONObject.has("url")) {
                    String optString = jSONObject.optString("url");
                    if (optString.startsWith("/")) {
                        optString = optString.substring(1);
                    }
                    int minaIndex = NavigateSubJSBridge.this.f16616a.getMinaIndex();
                    if (!NavigateSubJSBridge.this.f16616a.getJSAppConfig().containPath(optString)) {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONUtil.put(jSONObject2, "success", false);
                        JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "未找到指定页面，无法跳转");
                        callbackFunction.onCallBack(jSONObject2);
                    } else if (a.getCurrentPages().size() >= NavigateSubJSBridge.this.f16616a.getConfig().getLaunchConfig().getMaxPageSize()) {
                        LogUtil.m13411i("stop navigateTo，the limitation of page size is " + NavigateSubJSBridge.this.f16616a.getConfig().getLaunchConfig().getMaxPageSize());
                        JSONObject jSONObject3 = new JSONObject();
                        JSONUtil.put(jSONObject3, "success", false);
                        JSONUtil.put(jSONObject3, DMWebSocketListener.KEY_ERR_MSG, (Object) "页面栈超过指定数量");
                        callbackFunction.onCallBack(jSONObject3);
                    } else {
                        NavigateConfig navigateConfig = new NavigateConfig();
                        navigateConfig.url = optString;
                        navigateConfig.openType = jSONObject.optString("openType", InternalJSMethod.NAVIGATE_TO);
                        navigateConfig.packages = jSONObject.optString("package", "");
                        navigateConfig.query = jSONObject.optString("query", "{}");
                        if (a.navigateTo(minaIndex, a.getIndex(), navigateConfig)) {
                            JSONObject jSONObject4 = new JSONObject();
                            JSONUtil.put(jSONObject4, "success", true);
                            callbackFunction.onCallBack(jSONObject4);
                            return;
                        }
                        JSONObject jSONObject5 = new JSONObject();
                        JSONUtil.put(jSONObject5, "success", false);
                        JSONUtil.put(jSONObject5, DMWebSocketListener.KEY_ERR_MSG, (Object) "启动失败");
                        callbackFunction.onCallBack(jSONObject5);
                    }
                } else {
                    JSONObject jSONObject6 = new JSONObject();
                    JSONUtil.put(jSONObject6, "success", false);
                    JSONUtil.put(jSONObject6, DMWebSocketListener.KEY_ERR_MSG, (Object) "参数出错");
                    callbackFunction.onCallBack(jSONObject6);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo54473e(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_NAVIGATE_BACK, "params: " + jSONObject);
        UIHandlerUtil.safePost(this.f16616a, new Runnable() {
            public void run() {
                LogUtil.iRelease(NavigateSubJSBridge.f16615b, " navigateBack: " + jSONObject);
                int i = -1;
                DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a == null) {
                    JSONObject jSONObject = new JSONObject();
                    JSONUtil.put(jSONObject, "success", false);
                    JSONUtil.put(jSONObject, DMWebSocketListener.KEY_ERR_MSG, (Object) "堆栈为空");
                    callbackFunction.onCallBack(jSONObject);
                    return;
                }
                int optInt = jSONObject.optInt("delta", 1);
                int minaIndex = NavigateSubJSBridge.this.f16616a.getMinaIndex();
                List<IPageHost> currentPages = a.getCurrentPages();
                IPageHost currentPage = a.getCurrentPage();
                if (currentPage == null) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtil.put(jSONObject2, "success", false);
                    JSONUtil.put(jSONObject2, DMWebSocketListener.KEY_ERR_MSG, (Object) "回退失败");
                    callbackFunction.onCallBack(jSONObject2);
                } else if (currentPage.getPage() == null) {
                    JSONObject jSONObject3 = new JSONObject();
                    JSONUtil.put(jSONObject3, "success", false);
                    JSONUtil.put(jSONObject3, DMWebSocketListener.KEY_ERR_MSG, (Object) "回退失败");
                    callbackFunction.onCallBack(jSONObject3);
                } else {
                    int size = currentPages.size();
                    currentPage.getPage().getUrl();
                    if (size <= optInt) {
                        if (size == 1) {
                            JSONObject jSONObject4 = new JSONObject();
                            JSONUtil.put(jSONObject4, "success", false);
                            JSONUtil.put(jSONObject4, DMWebSocketListener.KEY_ERR_MSG, (Object) "navigateBack:fail cannot navigate back at first page.");
                        } else {
                            optInt = currentPages.size() - 1;
                        }
                    }
                    if (a.navigateBack(minaIndex, a.getIndex(), optInt)) {
                        List<IPageHost> currentPages2 = a.getCurrentPages();
                        JSONObject jSONObject5 = new JSONObject();
                        if (currentPages2 == null || currentPages2.isEmpty()) {
                            JSONUtil.put(jSONObject5, "success", false);
                            JSONUtil.put(jSONObject5, DMWebSocketListener.KEY_ERR_MSG, (Object) "回退失败");
                        } else {
                            JSONUtil.put(jSONObject5, "success", true);
                            if (!(currentPages2.get(currentPages2.size() - 1) == null || currentPages2.get(currentPages2.size() - 1).getPage() == null)) {
                                i = currentPages2.get(currentPages2.size() - 1).getPage().getWebViewId();
                            }
                            JSONUtil.put(jSONObject5, MessageWrapperBuilder.ARG_WEB_VIEW_ID, i);
                        }
                        callbackFunction.onCallBack(jSONObject5);
                        return;
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    JSONUtil.put(jSONObject6, "success", false);
                    JSONUtil.put(jSONObject6, DMWebSocketListener.KEY_ERR_MSG, (Object) "回退失败");
                    callbackFunction.onCallBack(jSONObject6);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo54475f(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_GET_CURRENT_PAGES, "params: " + jSONObject);
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                LogUtil.m13411i("NavigateSubJSBridge getCurrentPages");
                DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a != null) {
                    List<IPageHost> currentPages = a.getCurrentPages();
                    JSONArray jSONArray = new JSONArray();
                    for (IPageHost next : currentPages) {
                        if (!(next == null || next.getPage() == null)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONUtil.put(jSONObject, MessageWrapperBuilder.ARG_WEB_VIEW_ID, next.getPage().getWebViewId());
                            JSONUtil.put(jSONObject, "url", (Object) next.getPage().getUrl());
                            JSONUtil.put(jSONArray, jSONObject);
                        }
                    }
                    callbackFunction.onCallBack(jSONArray);
                }
            }
        });
    }

    public void switchTab(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_SWITCH_TAB, "params: " + jSONObject);
        UIHandlerUtil.safePost(this.f16616a, new Runnable() {
            public void run() {
                LogUtil.iRelease("Dimina-Core-Dotting", InternalJSMethod.SWITCH_TAB);
                DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a != null) {
                    NavigateSubJSBridge.this.f16616a.getPerformance().markWebViewOpen();
                    int minaIndex = NavigateSubJSBridge.this.f16616a.getMinaIndex();
                    NavigateConfig navigateConfig = new NavigateConfig();
                    navigateConfig.url = jSONObject.optString("url");
                    navigateConfig.openType = jSONObject.optString("openType", InternalJSMethod.SWITCH_TAB);
                    navigateConfig.packages = jSONObject.optString("package", "");
                    navigateConfig.query = jSONObject.optString("query", "{}");
                    if (a.switchTab(minaIndex, a.getIndex(), navigateConfig)) {
                        CallBackUtil.onSuccess(callbackFunction);
                    } else {
                        CallBackUtil.onFail("switchTab fail", callbackFunction);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public DMMinaNavigatorDelegate m12236a(int i) {
        DMMinaNavigatorDelegate navigator = this.f16616a.getNavigator(i);
        return navigator == null ? NavigateUtil.getCurNavigator(this.f16616a) : navigator;
    }

    public void exitMiniProgram(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                boolean z;
                DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a != null) {
                    z = a.closeDimina();
                    DMMinaPool.remove(NavigateSubJSBridge.this.f16616a.getMinaIndex(), true);
                } else {
                    z = false;
                }
                if (z) {
                    CallBackUtil.onSuccess(callbackFunction);
                } else {
                    CallBackUtil.onFail("exitMiniProgram fail", callbackFunction);
                }
            }
        });
    }

    public void closeDimina(final JSONObject jSONObject, final CallbackFunction callbackFunction) {
        int minaIndex = this.f16616a.getMinaIndex();
        TraceUtil.trackEventCoreDotting(minaIndex, Constant.CORE_DOTTING.NAVIGATE_CLOSE_DIMINA, "params: " + jSONObject);
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                DMMinaNavigatorDelegate a = NavigateSubJSBridge.this.m12236a(jSONObject.optInt(MessageWrapperBuilder.ARG_STACK_ID, -1));
                if (a != null ? a.closeDimina() : false) {
                    CallBackUtil.onSuccess(callbackFunction);
                } else {
                    CallBackUtil.onFail("closeDimina fail", callbackFunction);
                }
            }
        });
    }

    public static boolean inMainTabs(DMMina dMMina, int i, String str) {
        if (dMMina.getNavigator(i) == null) {
            return false;
        }
        List<IPageHost> currentPages = dMMina.getNavigator(i).getCurrentPages();
        if (currentPages != null && currentPages.size() > 0) {
            return false;
        }
        JSAppConfig jSAppConfig = dMMina.getJSAppConfig();
        if (!(jSAppConfig.tabBar == null || jSAppConfig.tabBar.list == null || jSAppConfig.tabBar.list.size() <= 0)) {
            for (JSAppConfig.TabBar.Item item : jSAppConfig.tabBar.list) {
                if (TextUtils.equals(item.pagePath, str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
