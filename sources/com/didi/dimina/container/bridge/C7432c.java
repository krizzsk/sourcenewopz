package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.navigationbar.NavigationBarButtonParams;
import com.didi.dimina.container.p106ui.statusbar.ImmersionBar;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.ColorUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.NavigateUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.c */
/* compiled from: NavigationBarSubJSBridge */
class C7432c {

    /* renamed from: a */
    private final DMMina f16696a;

    /* renamed from: b */
    private final Activity f16697b;

    C7432c(DMMina dMMina, Activity activity) {
        this.f16696a = dMMina;
        this.f16697b = activity;
        LogUtil.m13411i("NavigationBarSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54593a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("NavigationBarSubJSBridge setNavigationBarTitle: " + jSONObject);
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost != null) {
            DMPage page = curPageHost.getPage();
            if (jSONObject.has("title")) {
                page.getWebTitleBar().setTitleName(jSONObject.optString("title"));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONUtil.put(jSONObject2, "success", (Object) "true");
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54595b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("NavigationBarSubJSBridge setNavigationBarColor: " + jSONObject);
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost == null) {
            CallBackUtil.onFail("pageHost is created, not ready", callbackFunction);
            return;
        }
        DMPage page = curPageHost.getPage();
        if (page == null) {
            CallBackUtil.onFail("page is created, not ready", callbackFunction);
        } else if (jSONObject.has("frontColor")) {
            String optString = jSONObject.optString("frontColor");
            if ("#000000".equalsIgnoreCase(optString)) {
                page.getWebTitleBar().setContainerFrontColor(Color.parseColor(optString));
                page.setStatusBarDarkStyle(true);
                page.setCapsuleButtonColorBlack(true);
            } else if ("#ffffff".equalsIgnoreCase(optString)) {
                page.getWebTitleBar().setContainerFrontColor(Color.parseColor(optString));
                page.setStatusBarDarkStyle(false);
                page.setCapsuleButtonColorBlack(false);
            } else {
                CallBackUtil.onFail("setNavigationBarColor:fail invalid frontColor " + optString, callbackFunction);
            }
            if (jSONObject.has("backgroundColor")) {
                String optString2 = jSONObject.optString("backgroundColor");
                if (ColorUtil.isValidColorStr(optString2)) {
                    page.getWebTitleBar().setContainerBackgroundColor(Color.parseColor(ColorUtil.convert3To6(optString2)));
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtil.put(jSONObject2, "success", (Object) SDKConsts.BOOLEAN_FALSE);
                    callbackFunction.onCallBack(jSONObject2);
                    return;
                }
            }
            CallBackUtil.onSuccess(callbackFunction);
        } else {
            CallBackUtil.onFail("setNavigationBarColor:fail frontColor is null", callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54596c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("NavigationBarSubJSBridge setNavigationTitleColor: " + jSONObject);
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost != null) {
            DMPage page = curPageHost.getPage();
            if (jSONObject.has("titleColor")) {
                page.getWebTitleBar().setTitleBackgroundColor(Color.parseColor(jSONObject.optString("titleColor")));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54592a(JSONObject jSONObject) {
        LogUtil.m13411i("NavigationBarSubJSBridge show ");
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost != null) {
            curPageHost.getPage().showNavigationBar(jSONObject.optString("animation", "0").equals("1"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54594b(JSONObject jSONObject) {
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost != null) {
            DMPage page = curPageHost.getPage();
            LogUtil.m13411i("NavigationBarSubJSBridge hide ");
            page.hideNavigationBar(jSONObject.optString("animation", "0").equals("1"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo54597d(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("NavigationBarSubJSBridge setNavigationBarButton " + jSONObject);
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost != null) {
            curPageHost.getPage().getWebTitleBar().setNavigationBarButton((NavigationBarButtonParams) JSONUtil.jsonToObject(jSONObject.toString(), NavigationBarButtonParams.class), callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo54598e(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("NavigationBarSubJSBridge setNavigationBarClickListener " + jSONObject);
        IPageHost curPageHost = NavigateUtil.getCurPageHost(this.f16696a);
        if (curPageHost != null) {
            curPageHost.getPage().getWebTitleBar().setNavigationBarClickListener(jSONObject, callbackFunction);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public JSONObject mo54599f(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int statusBarHeight = ImmersionBar.getStatusBarHeight(this.f16697b);
        int px2dip = (PixUtil.px2dip(this.f16697b, (float) mo54591a()) - 12) - 87;
        int px2dip2 = PixUtil.px2dip(this.f16697b, (float) statusBarHeight) + 7;
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "width", 87);
        JSONUtil.put(jSONObject2, "height", 32);
        JSONUtil.put(jSONObject2, "left", px2dip);
        JSONUtil.put(jSONObject2, "top", px2dip2);
        JSONUtil.put(jSONObject2, "right", px2dip + 87);
        JSONUtil.put(jSONObject2, "bottom", px2dip2 + 32);
        return jSONObject2;
    }

    /* renamed from: a */
    public int mo54591a() {
        WindowManager windowManager = (WindowManager) this.f16697b.getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }
}
