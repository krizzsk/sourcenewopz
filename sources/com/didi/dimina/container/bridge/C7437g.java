package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.page.ITabBarPageHost;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.NavigateUtil;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.g */
/* compiled from: TabBarSubJSBridge */
class C7437g {

    /* renamed from: a */
    private static final int f16731a = -1000;

    /* renamed from: b */
    private static final int f16732b = -1001;

    /* renamed from: c */
    private final DMMina f16733c;

    C7437g(DMMina dMMina) {
        this.f16733c = dMMina;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54713a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c != null) {
            boolean tabBarStyle = c.setTabBarStyle(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = tabBarStyle ? m12416a() : m12417a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54715b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c != null) {
            boolean tabBarItem = c.setTabBarItem(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = tabBarItem ? m12416a() : m12417a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54716c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c != null) {
            boolean showTabBarRedDot = c.showTabBarRedDot(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = showTabBarRedDot ? m12416a() : m12417a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo54717d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c != null) {
            boolean hideTabBarRedDot = c.hideTabBarRedDot(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = hideTabBarRedDot ? m12416a() : m12417a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo54718e(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c != null) {
            boolean tabBarBadge = c.setTabBarBadge(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = tabBarBadge ? m12416a() : m12417a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo54719f(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c != null) {
            boolean removeTabBarBadge = c.removeTabBarBadge(jSONObject);
            Object[] objArr = new Object[1];
            objArr[0] = removeTabBarBadge ? m12416a() : m12417a(-1001, "the parameter index is invalid");
            callbackFunction.onCallBack(objArr);
        }
    }

    /* renamed from: a */
    public void mo54712a(CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c == null) {
            CallBackUtil.onFail("showTabBar failed", callbackFunction);
        } else if (c.showTabBar()) {
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("showTabBar failed", callbackFunction);
        }
    }

    /* renamed from: b */
    public void mo54714b(CallbackFunction callbackFunction) {
        ITabBarPageHost c = m12418c(callbackFunction);
        if (c == null) {
            CallBackUtil.onFail("hideTabBar failed", callbackFunction);
        } else if (c.hideTabBar()) {
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("hideTabBar failed", callbackFunction);
        }
    }

    /* renamed from: c */
    private ITabBarPageHost m12418c(CallbackFunction callbackFunction) {
        DMMinaNavigatorDelegate curNavigator = NavigateUtil.getCurNavigator(this.f16733c);
        if (curNavigator == null) {
            return null;
        }
        List<IPageHost> currentPages = curNavigator.getCurrentPages();
        if (currentPages == null || currentPages.size() > 1) {
            callbackFunction.onCallBack(m12417a(-1000, "只能在TabBar页面内调用"));
            return null;
        }
        IPageHost currentPage = curNavigator.getCurrentPage();
        if (currentPage == null) {
            callbackFunction.onCallBack(m12417a(-1000, "堆栈内没有任何页面"));
            return null;
        } else if (currentPage instanceof ITabBarPageHost) {
            return (ITabBarPageHost) currentPage;
        } else {
            callbackFunction.onCallBack(m12417a(-1000, "没有配置tabBar"));
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m12416a() {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", true);
        return jSONObject;
    }

    /* renamed from: a */
    private static JSONObject m12417a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", false);
        JSONUtil.put(jSONObject, "code", i);
        JSONUtil.put(jSONObject, "error", (Object) str);
        return jSONObject;
    }
}
