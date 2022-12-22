package com.didi.dimina.container.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.dimina.container.p106ui.webview.TouchInterceptFrame;
import com.didi.dimina.container.p106ui.webview.TouchInterceptFrameLayout;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.bridge.i */
/* compiled from: TouchViewSubJSBridge */
class C7439i {

    /* renamed from: a */
    private final WebViewEngine f16736a;

    /* renamed from: b */
    private final Map<String, List<TouchInterceptFrame>> f16737b = new HashMap();

    /* renamed from: c */
    private final Context f16738c;

    C7439i(Context context, WebViewEngine webViewEngine) {
        this.f16738c = context;
        this.f16736a = webViewEngine;
        LogUtil.m13411i("TouchViewSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54722a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        mo54723b(jSONObject, callbackFunction);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54723b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("TouchViewSubJSBridge updated: " + jSONObject);
        if (jSONObject.has("id")) {
            String optString = jSONObject.optString("id", "");
            ArrayList arrayList = new ArrayList();
            if (jSONObject.has("subFrames")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("subFrames");
                int i = 0;
                while (optJSONArray != null && i < optJSONArray.length()) {
                    try {
                        TouchInterceptFrame a = m12429a(optString, optJSONArray.getJSONObject(i));
                        if (a != null) {
                            arrayList.add(a);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            } else if (jSONObject.has("frame")) {
                arrayList.add(m12429a(optString, jSONObject.optJSONObject("frame")));
            }
            this.f16737b.put(optString, arrayList);
            m12430a();
        }
    }

    /* renamed from: a */
    private TouchInterceptFrame m12429a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int optInt = jSONObject.optInt("x", -1);
        int optInt2 = jSONObject.optInt(SameLayerRenderingUtil.KEY_COMP_Y, -1);
        int optInt3 = jSONObject.optInt("height", -1);
        int optInt4 = jSONObject.optInt("width", -1);
        if (optInt2 < 0 || optInt < 0 || optInt3 < 0 || optInt4 < 0) {
            return null;
        }
        TouchInterceptFrame touchInterceptFrame = new TouchInterceptFrame();
        touchInterceptFrame.f17866id = str;
        float f = this.f16738c.getResources().getDisplayMetrics().density;
        touchInterceptFrame.height = (int) ((((float) optInt3) * f) + 0.5f);
        touchInterceptFrame.width = (int) ((((float) optInt4) * f) + 0.5f);
        touchInterceptFrame.f17867x = (int) ((((float) optInt) * f) + 0.5f);
        touchInterceptFrame.f17868y = (int) ((((float) optInt2) * f) + 0.5f);
        return touchInterceptFrame;
    }

    /* renamed from: a */
    private void m12430a() {
        TouchInterceptFrameLayout touchInterceptFrameLayout = this.f16736a.getContainer().getTouchInterceptFrameLayout();
        if (touchInterceptFrameLayout != null) {
            touchInterceptFrameLayout.updateInterceptFrame(this.f16737b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54724c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("TouchViewSubJSBridge destroyed: " + jSONObject);
        if (jSONObject.has("id")) {
            String optString = jSONObject.optString("id", "");
            if (!TextUtils.isEmpty(optString)) {
                this.f16737b.remove(optString);
                m12430a();
            }
        }
    }
}
