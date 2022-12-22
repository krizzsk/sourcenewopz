package com.didi.dimina.container.bridge;

import android.app.Activity;
import android.content.Context;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.KeyboardUtils;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.WeakHashMap;
import org.json.JSONObject;

class KeyboardSubJSBridge {

    /* renamed from: a */
    private static final WeakHashMap<Activity, SoftInputChangedListener> f16604a = new WeakHashMap<>();

    /* renamed from: b */
    private final Activity f16605b;

    /* renamed from: c */
    private final WebViewEngine f16606c;

    public KeyboardSubJSBridge(Activity activity, WebViewEngine webViewEngine) {
        LogUtil.m13411i("KeyboardSubJSBridge init");
        this.f16605b = activity;
        this.f16606c = webViewEngine;
        m12213a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54458a(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("KeyboardSubJSBridge hideKeyboard: " + jSONObject);
        KeyboardUtils.hideSoftInput(this.f16605b);
        if (callbackFunction != null) {
            CallBackUtil.onSuccess(callbackFunction);
        }
    }

    /* renamed from: a */
    private void m12213a() {
        LogUtil.m13411i("KeyboardSubJSBridge registerSoftInputChangedListener");
        if (f16604a.get(this.f16605b) == null) {
            SoftInputChangedListener softInputChangedListener = new SoftInputChangedListener(this.f16605b);
            f16604a.put(this.f16605b, softInputChangedListener);
            KeyboardUtils.registerSoftInputChangedListener(this.f16605b, (KeyboardUtils.OnSoftInputChangedListener) softInputChangedListener);
        }
    }

    /* renamed from: b */
    public void mo54459b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("KeyboardSubJSBridge showKeyboard: " + jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("inputBoundingRect");
        if (optJSONObject != null) {
            KeyboardUtils.focusedComponentY = (int) (((float) (optJSONObject.optInt("top") + optJSONObject.optInt("height"))) * this.f16606c.getWebView().getContext().getResources().getDisplayMetrics().density);
        } else {
            KeyboardUtils.focusedComponentY = 0;
        }
        KeyboardUtils.showSoftInput(this.f16606c.getWebView());
    }

    private static class SoftInputChangedListener implements KeyboardUtils.OnSoftInputChangedListener {
        private final Context ctx;

        private SoftInputChangedListener(Activity activity) {
            this.ctx = activity.getApplication();
        }

        public void onSoftInputChanged(int i) {
            JSONUtil.put(new JSONObject(), "height", PixUtil.px2dip(this.ctx, (float) i));
        }
    }
}
