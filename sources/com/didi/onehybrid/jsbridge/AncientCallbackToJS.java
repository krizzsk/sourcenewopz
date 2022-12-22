package com.didi.onehybrid.jsbridge;

import com.didi.onehybrid.devmode.FusionRuntimeInfo;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class AncientCallbackToJS implements CallbackFunction {

    /* renamed from: a */
    private static final String f29596a = "javascript:%s.callback(%d, %d %s);";

    /* renamed from: b */
    private WebViewJavascriptBridge f29597b;

    /* renamed from: c */
    private final String f29598c = "DidiJSBridge";

    /* renamed from: d */
    private final Integer f29599d;

    /* renamed from: e */
    private FusionRuntimeInfo f29600e;

    /* renamed from: f */
    private String f29601f;

    public AncientCallbackToJS(WebViewJavascriptBridge webViewJavascriptBridge, Integer num, String str) {
        this.f29597b = webViewJavascriptBridge;
        this.f29599d = num;
        this.f29601f = str;
        this.f29600e = webViewJavascriptBridge.getFusionRuntimeInfo();
    }

    public void onCallBack(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(",");
            boolean z = obj instanceof String;
            if (z) {
                sb.append(Const.jsQuote);
            }
            sb.append(String.valueOf(obj));
            if (z) {
                sb.append(Const.jsQuote);
            }
        }
        String format = String.format(f29596a, new Object[]{this.f29598c, this.f29599d, 0, sb.toString()});
        this.f29597b.executeCallJS(format);
        this.f29600e.recordBridgeCallback(this.f29601f, format);
    }
}
