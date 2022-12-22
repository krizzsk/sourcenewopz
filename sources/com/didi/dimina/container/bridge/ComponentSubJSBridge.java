package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p106ui.custom.ComponentManager;
import com.didi.dimina.container.p106ui.custom.CustomComponent;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

@Deprecated
public class ComponentSubJSBridge {

    /* renamed from: a */
    private final DMPage f16564a;

    /* renamed from: b */
    private final WebViewEngine f16565b;

    /* renamed from: c */
    private final Context f16566c;

    /* renamed from: d */
    private final List<String> f16567d = new ArrayList();

    public ComponentSubJSBridge(Context context, DMPage dMPage) {
        this.f16564a = dMPage;
        this.f16565b = dMPage.getWebViewContainer().getWebView();
        this.f16566c = context;
        LogUtil.m13411i("ComponentSubJSBridge init");
    }

    public void comMounted(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("ComponentSubJSBridge comMounted: " + jSONObject);
        if (jSONObject.has("name") && jSONObject.has("id")) {
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("id");
            if (Objects.equals("MapView", optString)) {
                this.f16564a.getWebViewContainer().setMapInterceptFrameLayout(true);
                return;
            }
            CustomComponent orCreateComponent = ComponentManager.getOrCreateComponent(this.f16564a, optString, optString2);
            if (orCreateComponent != null) {
                synchronized (ComponentSubJSBridge.class) {
                    this.f16567d.add(optString2);
                }
                if (orCreateComponent.innerMounted(optString2, this.f16564a, jSONObject.optJSONObject("attributes")) != null) {
                    m12185a(orCreateComponent, jSONObject.optJSONObject("frame"));
                }
            }
        }
    }

    public void comUpdated(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CustomComponent orCreateComponent;
        LogUtil.m13411i("ComponentSubJSBridge comUpdated: " + jSONObject);
        if (jSONObject.has("name") && jSONObject.has("id") && (orCreateComponent = ComponentManager.getOrCreateComponent(this.f16564a, jSONObject.optString("name"), jSONObject.optString("id"))) != null) {
            orCreateComponent.onPropertiesUpdate(jSONObject.optJSONObject("attributes"));
            if (orCreateComponent.getView() != null) {
                m12185a(orCreateComponent, jSONObject.optJSONObject("frame"));
            }
        }
    }

    /* renamed from: a */
    private void m12185a(CustomComponent customComponent, JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("x", -1);
            int optInt2 = jSONObject.optInt(SameLayerRenderingUtil.KEY_COMP_Y, -1);
            int optInt3 = jSONObject.optInt("height", -1);
            int optInt4 = jSONObject.optInt("width", -1);
            if (optInt2 >= 0 && optInt >= 0) {
                float f = this.f16566c.getResources().getDisplayMetrics().density;
                if (optInt4 > 0) {
                    optInt4 = (int) ((((float) optInt4) * f) + 0.5f);
                }
                if (optInt3 > 0) {
                    optInt3 = (int) ((((float) optInt3) * f) + 0.5f);
                }
                ViewGroup.LayoutParams layoutParams = customComponent.getView().getLayoutParams();
                if (layoutParams == null) {
                    if (this.f16565b.getWebView() instanceof AbsoluteLayout) {
                        this.f16565b.getWebView().addView(customComponent.getView(), new AbsoluteLayout.LayoutParams(optInt4, optInt3, (int) ((((float) optInt) * f) + 0.5f), (int) ((((float) optInt2) * f) + 0.5f)));
                    }
                } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i = (int) ((((float) optInt) * f) + 0.5f);
                    int i2 = (int) ((((float) optInt2) * f) + 0.5f);
                    if (marginLayoutParams.leftMargin != i || marginLayoutParams.topMargin != i2 || marginLayoutParams.width != optInt4 || marginLayoutParams.height != optInt3) {
                        marginLayoutParams.leftMargin = i;
                        marginLayoutParams.topMargin = i2;
                        marginLayoutParams.height = optInt3;
                        marginLayoutParams.width = optInt4;
                        customComponent.getView().setLayoutParams(marginLayoutParams);
                        customComponent.getView().getParent().requestLayout();
                    }
                }
            }
        }
    }

    public void comDestroyed(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("ComponentSubJSBridge comDestroyed: " + jSONObject);
        if (jSONObject.has("name") && Objects.equals("MapView", Boolean.valueOf(jSONObject.has("name")))) {
            this.f16564a.getWebViewContainer().setMapInterceptFrameLayout(false);
        } else if (jSONObject.has("id")) {
            String optString = jSONObject.optString("id");
            if (!TextUtils.isEmpty(optString)) {
                m12186a(optString);
            }
        }
    }

    public void comOtherDestroy() {
        ArrayList arrayList;
        synchronized (ComponentSubJSBridge.class) {
            arrayList = new ArrayList(this.f16567d);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m12186a((String) it.next());
        }
    }

    /* renamed from: a */
    private void m12186a(String str) {
        CustomComponent destroyComponent = ComponentManager.destroyComponent(this.f16564a, str);
        if (destroyComponent != null) {
            synchronized (ComponentSubJSBridge.class) {
                this.f16567d.remove(str);
            }
            View view = destroyComponent.getView();
            if (!(view == null || view.getParent() == null)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            destroyComponent.onDestroyed();
        }
    }

    /* renamed from: a */
    private Map<String, Object> m12184a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.opt(next));
            }
        }
        return hashMap;
    }
}
