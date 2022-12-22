package com.didi.dimina.container.mina;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.didi.dimina.container.util.UIHandlerUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.util.WeakHashMap;

public class DMMinaPerfRender {
    public static String OBJ_TAG = "renderPerf";
    public static String RENDER_TIMING_TAG = "timing";
    public static WeakHashMap<WebViewEngine, RenderPerf> renderPerfMap = new WeakHashMap<>();

    public interface OnRenderPerfRecorder {
        void record(String str, String str2);
    }

    public void addPerfObj2WebView(WebViewEngine webViewEngine) {
        RenderPerf renderPerf = new RenderPerf();
        webViewEngine.addJavascriptInterface(renderPerf, OBJ_TAG);
        renderPerfMap.put(webViewEngine, renderPerf);
    }

    public void evaluateJS4Timing(final WebViewEngine webViewEngine, final OnRenderPerfRecorder onRenderPerfRecorder) {
        UIHandlerUtil.post(new Runnable() {
            public void run() {
                RenderPerf renderPerf = DMMinaPerfRender.renderPerfMap.get(webViewEngine);
                if (renderPerf != null) {
                    renderPerf.recordCallBack = onRenderPerfRecorder;
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    WebViewEngine webViewEngine = webViewEngine;
                    webViewEngine.evaluateJavascript("javascript:" + DMMinaPerfRender.OBJ_TAG + ".record('" + DMMinaPerfRender.RENDER_TIMING_TAG + "',JSON.stringify(window.performance.timing));", (WebViewEngine.WebViewEngineValueCallback<String>) null);
                }
            }
        });
    }

    static class RenderPerf implements OnRenderPerfRecorder {
        OnRenderPerfRecorder recordCallBack;

        RenderPerf() {
        }

        @JavascriptInterface
        public void record(String str, String str2) {
            OnRenderPerfRecorder onRenderPerfRecorder = this.recordCallBack;
            if (onRenderPerfRecorder != null) {
                onRenderPerfRecorder.record(str, str2);
            }
            this.recordCallBack = null;
        }
    }
}
