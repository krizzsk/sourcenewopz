package com.didi.dimina.container.p106ui.canvas;

import android.content.Context;
import android.view.View;
import com.didi.dimina.container.bridge.DMServiceJSModuleLazyParameter;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.canvas.CanvasSubJsBridge;
import com.didi.dimina.container.bridge.canvas.CanvasViewManager;
import com.didi.dimina.container.p106ui.custom.CustomComponent;
import com.didi.dimina.container.util.LogUtil;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.canvas.CanvasViewComponent */
public class CanvasViewComponent extends CustomComponent {

    /* renamed from: a */
    private CanvasSubJsBridge f17508a;

    /* renamed from: b */
    private String f17509b;

    /* renamed from: a */
    private void m13012a() {
        this.f17508a = ((DMServiceJSModuleLazyParameter) this.mDMPage.getDMMina().invokeServiceJSModuleMethod("DMServiceBridgeModule", InternalJSMethod.GET_JS_MODULE_LAZY_PARAMETER, new Object[0])).getCanvas();
    }

    public View onMounted(Context context, JSONObject jSONObject) {
        LogUtil.m13411i("CanvasComponent onMounted");
        m13012a();
        if (jSONObject == null || !jSONObject.has("id")) {
            return null;
        }
        String optString = jSONObject.optString("id");
        this.f17509b = optString;
        if (optString.isEmpty()) {
            return null;
        }
        int optInt = jSONObject.optInt("width", 0);
        int optInt2 = jSONObject.optInt("height", 0);
        if (optInt <= 0 || optInt2 <= 0) {
            return null;
        }
        if (optInt > this.mWebView.getWebView().getWidth()) {
            optInt = this.mWebView.getWebView().getWidth();
        }
        if (optInt2 > this.mWebView.getWebView().getHeight()) {
            optInt2 = this.mWebView.getWebView().getHeight();
        }
        CanvasViewManager.getCanvasViewManager().createCanvasView(this.f17509b, new CanvasView(context, optInt, optInt2));
        this.f17508a.setCreate(this.f17509b);
        return CanvasViewManager.getCanvasViewManager().getCanvasView(this.f17509b);
    }

    public void onPropertiesUpdate(JSONObject jSONObject) {
        LogUtil.m13411i("CanvasComponent onUpdate");
        super.onPropertiesUpdate(jSONObject);
    }

    public void onDestroyed() {
        LogUtil.m13411i("CanvasComponent onDestroyed");
        CanvasViewManager.getCanvasViewManager().clearCanvasView(this.f17509b);
        this.f17508a.removeCanvasList(this.f17509b);
    }
}
