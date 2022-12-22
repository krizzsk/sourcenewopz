package com.didi.dimina.container.p106ui.custom;

import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.custom.SameLayerRenderingUtil */
public class SameLayerRenderingUtil {
    public static final int DOWNGRADE_VIEW_TYPE_H5 = 2;
    public static final int DOWNGRADE_VIEW_TYPE_NATIVE_VIEW = 1;
    public static final String EVENT_COMPONENT_ATTACH = "onComponentAttach";
    public static final String EVENT_NATIVE_RENDER_ERROR = "onNativeRenderError";
    public static final String KEY_CALL_FROM_D6 = "call_from_d6";
    public static final String KEY_COMP_HEIGHT = "height";
    public static final String KEY_COMP_ID = "id";
    public static final String KEY_COMP_TEMPLATE_TYPE = "comp_type";
    public static final String KEY_COMP_TYPE = "compType";
    public static final String KEY_COMP_WIDTH = "width";
    public static final String KEY_COMP_X = "x";
    public static final String KEY_COMP_Y = "y";
    public static final String KEY_COMP_ZINDEX = "z-index";
    public static final String KEY_DOWNGRADE_COMP_TYPE = "compType";
    public static final String KEY_DOWNGRADE_ID = "id";
    public static final String KEY_DOWNGRADE_NATIVE_RESULT = "result";
    public static final String KEY_DOWNGRADE_VIEW_TYPE = "downgradeType";

    /* renamed from: a */
    private static final String f17512a = "SameLayerRenderingUtil";

    public static void propertiesUpdate(JSONObject jSONObject, WebViewEngine webViewEngine) {
        LogUtil.m13408d("propertiesUpdate", jSONObject.toString());
        String optString = jSONObject.optString("id");
        CustomComponent orCreateComponent = ComponentManager.getOrCreateComponent(webViewEngine.getDmPage(), jSONObject.optString("compType"), optString);
        if (orCreateComponent != null) {
            View view = orCreateComponent.getView();
            if (view == null) {
                LogUtil.m13408d("propertiesUpdate", "view not create yet.");
                return;
            }
            m13013a(orCreateComponent, jSONObject, view);
            orCreateComponent.onPropertiesUpdate(jSONObject);
        }
    }

    public static void createComponent(JSONObject jSONObject, WebViewEngine webViewEngine) {
        View view;
        ViewGroup viewGroup;
        LogUtil.m13408d("createComponent:", jSONObject.toString());
        String optString = jSONObject.optString("id");
        String optString2 = jSONObject.optString("compType");
        CustomComponent orCreateComponent = ComponentManager.getOrCreateComponent(webViewEngine.getDmPage(), optString2, optString);
        if (orCreateComponent != null) {
            view = orCreateComponent.innerMounted(optString, webViewEngine.getDmPage(), jSONObject);
            if (view != null) {
                if (ComponentManager.inBottomLayer(optString2)) {
                    viewGroup = webViewEngine.getDmPage().getWebViewContainer().getBottomLayer();
                } else {
                    viewGroup = webViewEngine.getDmPage().getWebViewContainer().getTouchInterceptFrameLayout();
                }
                m13013a(orCreateComponent, jSONObject, view);
                m13014a(jSONObject, viewGroup, view);
            }
        } else {
            view = null;
        }
        sendNativeRenderResult(webViewEngine, optString, optString2, view);
        if (ComponentManager.inBottomLayer(optString2)) {
            webViewEngine.getContainer().setWebViewBackgroundTransparent();
            webViewEngine.getContainer().getTouchInterceptFrameLayout().setInterceptEnabled(true);
            if (TextUtils.equals(optString2, ComponentManager.DIMINA_MAP) && webViewEngine.getDmPage() != null && webViewEngine.getDmMina() != null && webViewEngine.getDmMina().getConfig().getAdapterConfig().getMapService().getMap() != null) {
                webViewEngine.getDmPage().setBackgroundColor(0);
                webViewEngine.getDmPage().setClickable(false);
            }
        }
    }

    public static void sendNativeRenderResult(WebViewEngine webViewEngine, String str, String str2, View view) {
        boolean z = false;
        if (view == null) {
            int index = webViewEngine.getDmPage().getNavigator() == null ? 0 : webViewEngine.getDmPage().getNavigator().getIndex();
            JSONObject jSONObject = new JSONObject();
            JSONUtil.put(jSONObject, "id", (Object) str);
            JSONUtil.put(jSONObject, "compType", (Object) str2);
            JSONUtil.put(jSONObject, KEY_DOWNGRADE_VIEW_TYPE, 2);
            webViewEngine.getDmMina().getMessageTransfer().sendMessageToWebView(webViewEngine, EVENT_NATIVE_RENDER_ERROR, new MessageWrapperBuilder().data(jSONObject).webViewId(webViewEngine.getDmPage().getWebViewId()).stackId(index).build());
            LogUtil.m13408d("sendNativeRenderError", jSONObject.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "id", (Object) str);
        JSONUtil.put(jSONObject2, "compType", (Object) str2);
        if (view != null) {
            z = true;
        }
        JSONUtil.put(jSONObject2, "result", z);
        webViewEngine.getDmMina().getMessageTransfer().sendMessageToWebView(webViewEngine, EVENT_COMPONENT_ATTACH, new MessageWrapperBuilder().data(jSONObject2).webViewId(webViewEngine.getDmPage().getWebViewId()).stackId(webViewEngine.getDmPage().getNavigator().getIndex()).build());
    }

    /* renamed from: a */
    private static void m13014a(JSONObject jSONObject, ViewGroup viewGroup, View view) {
        if (view == null || view.getParent() != null) {
            SystemUtils.log(6, f17512a, "addNativeView return:" + jSONObject.optString("compType"), (Throwable) null, "com.didi.dimina.container.ui.custom.SameLayerRenderingUtil", 134);
            return;
        }
        String optString = jSONObject.optString(KEY_COMP_ZINDEX);
        int i = Integer.MAX_VALUE;
        if (!TextUtils.equals(optString, DebugKt.DEBUG_PROPERTY_VALUE_AUTO) && !TextUtils.isEmpty(optString)) {
            i = Integer.parseInt(optString);
        }
        int childCount = viewGroup.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount - 1) {
                break;
            }
            Object tag = viewGroup.getChildAt(i2).getTag(R.id.tag_native_view_zindex);
            if ((tag instanceof Integer) && ((Integer) tag).intValue() > i) {
                childCount = i2;
                break;
            }
            i2++;
        }
        if (jSONObject.optBoolean(KEY_CALL_FROM_D6, false)) {
            viewGroup.addView(view, 0);
        } else {
            viewGroup.addView(view, childCount);
        }
        view.setTag(R.id.tag_native_view_zindex, Integer.valueOf(i));
        SystemUtils.log(6, f17512a, "addNativeView ok:" + jSONObject.optString("compType"), (Throwable) null, "com.didi.dimina.container.ui.custom.SameLayerRenderingUtil", 166);
    }

    /* renamed from: a */
    private static void m13013a(CustomComponent customComponent, JSONObject jSONObject, View view) {
        boolean z = false;
        double d = (double) (jSONObject.optBoolean(KEY_CALL_FROM_D6, false) ? 1.0f : view.getContext().getResources().getDisplayMetrics().density);
        int ceil = (int) Math.ceil(jSONObject.optDouble("x") * d);
        int ceil2 = (int) Math.ceil(jSONObject.optDouble(KEY_COMP_Y) * d);
        int ceil3 = (int) Math.ceil(jSONObject.optDouble("width") * d);
        int ceil4 = (int) Math.ceil(jSONObject.optDouble("height") * d);
        boolean has = jSONObject.has("x");
        boolean has2 = jSONObject.has(KEY_COMP_Y);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        }
        Point componentViewExtraMargin = customComponent.getComponentViewExtraMargin();
        if (componentViewExtraMargin != null) {
            if (has && ceil <= 0) {
                ceil += componentViewExtraMargin.x;
            }
            if (has2 && ceil2 <= 0) {
                ceil2 += componentViewExtraMargin.y;
            }
        }
        boolean z2 = true;
        if (has && ceil != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = ceil;
            z = true;
        }
        if (has2 && ceil2 != marginLayoutParams.topMargin) {
            marginLayoutParams.topMargin = ceil2;
            z = true;
        }
        if (ceil3 > 0 && ceil3 != marginLayoutParams.width) {
            marginLayoutParams.width = ceil3;
            z = true;
        }
        if (ceil4 > 0 && ceil4 != marginLayoutParams.height) {
            marginLayoutParams.height = ceil4;
            z = true;
        }
        if (marginLayoutParams.width == 0 && marginLayoutParams.height == 0) {
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
        } else {
            z2 = z;
        }
        if (z2) {
            view.setLayoutParams(marginLayoutParams);
        } else {
            LogUtil.m13407d("重复设置宽高,已忽略");
        }
    }

    public static void destroyComponent(JSONObject jSONObject, WebViewEngine webViewEngine) {
        String optString = jSONObject.optString("id");
        CustomComponent component = ComponentManager.getComponent(webViewEngine.getDmPage(), optString);
        if (component != null) {
            component.onDestroyed();
            ComponentManager.destroyComponent(webViewEngine.getDmPage(), optString);
        }
    }

    public static boolean isSameLayerRenderingReady(WebViewEngine webViewEngine) {
        try {
            return webViewEngine.isSameLayerRenderingReady();
        } catch (Exception unused) {
            return false;
        }
    }

    public static JSONObject getSameLayerRenderComponentConfig(DMPage dMPage) {
        return dMPage.getDMMina().getConfig().getLaunchConfig().getSameRenderLayerComponentConfig();
    }
}
