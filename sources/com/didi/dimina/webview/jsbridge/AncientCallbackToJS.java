package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class AncientCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private static final String f18261a = "javascript:%s.callback(%d, %d %s);";

    /* renamed from: b */
    private final WebViewJavascriptBridge f18262b;

    /* renamed from: c */
    private final String f18263c = "DidiJSBridge";

    /* renamed from: d */
    private final Integer f18264d;

    /* renamed from: e */
    private final String f18265e;

    public AncientCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, Integer num, String str) {
        this.f18262b = webViewJavascriptBridge;
        this.f18264d = num;
        this.f18265e = str;
    }

    public void onCallBack(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(",");
            boolean z = obj instanceof String;
            if (z) {
                sb.append(Const.jsQuote);
            }
            sb.append(obj);
            if (z) {
                sb.append(Const.jsQuote);
            }
        }
        this.f18262b.executeCallJS(String.format(f18261a, new Object[]{this.f18263c, this.f18264d, 0, sb.toString()}));
    }
}
