package com.didi.dimina.container.jsengine.web;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.didi.dimina.container.jsengine.method.JSCallback;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.util.JSONUtil;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.jsengine.web.a */
/* compiled from: WebJSCallback */
class C7487a {

    /* renamed from: a */
    public static final String f16855a = "__WebJSEngine__";

    /* renamed from: b */
    private final String f16856b;

    /* renamed from: c */
    private final String f16857c;

    /* renamed from: d */
    private final JSCallback f16858d;

    C7487a(String str, JSCallback jSCallback) {
        this.f16856b = "";
        this.f16857c = str;
        this.f16858d = jSCallback;
    }

    C7487a(String str, String str2, JSCallback jSCallback) {
        this.f16856b = str;
        this.f16857c = str2;
        this.f16858d = jSCallback;
    }

    /* renamed from: a */
    public void mo54992a(boolean z, WebView webView, IDMCommonAction<Void> iDMCommonAction) {
        StringBuilder sb = new StringBuilder();
        if (z && !TextUtils.isEmpty(this.f16856b)) {
            sb.append("var " + this.f16856b + " = {}\n");
        }
        if (!TextUtils.isEmpty(this.f16856b)) {
            sb.append(this.f16856b + ".");
        }
        sb.append(this.f16857c + "= function() {\n    var args = [].slice.call(arguments);\n    let req = JSON.stringify(args);\n    let resp = " + f16855a + ".invoke('" + this.f16857c + "', req);\n    if (resp && typeof(resp)=='string' && resp.startsWith('__parse_mark__')) {\n        return JSON.parse(resp.slice('__parse_mark__'.length));\n    } else {\n        return resp;\n    }\n}");
        webView.evaluateJavascript(sb.toString(), new ValueCallback() {
            public final void onReceiveValue(Object obj) {
                C7487a.m12471b(IDMCommonAction.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m12471b(IDMCommonAction iDMCommonAction, String str) {
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
    }

    /* renamed from: a */
    public void mo54991a(WebView webView, IDMCommonAction<Void> iDMCommonAction) {
        webView.evaluateJavascript("function " + this.f16857c + "() {\n    var args = [].slice.call(arguments);\n    let req = JSON.stringify(args);\n    let resp = " + f16855a + ".invoke('" + this.f16857c + "', req);\n    if (resp && typeof(resp)=='string' && resp.startsWith('__parse_mark__')) {\n        return JSON.parse(resp.slice('__parse_mark__'.length));\n    } else {\n        return resp;\n    }\n}", new ValueCallback() {
            public final void onReceiveValue(Object obj) {
                C7487a.m12470a(IDMCommonAction.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m12470a(IDMCommonAction iDMCommonAction, String str) {
        if (iDMCommonAction != null) {
            iDMCommonAction.callback(null);
        }
    }

    /* renamed from: a */
    public Object mo54990a(String str) {
        try {
            return m12469a(this.f16858d.callback(new WebJSArray(new JSONArray(str), str)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private Object m12469a(Object obj) {
        if (obj instanceof Map) {
            return "__parse_mark__" + JSONUtil.toJson(obj);
        } else if (obj instanceof List) {
            return "__parse_mark__" + JSONUtil.toJson(obj);
        } else if (obj instanceof JSONObject) {
            return "__parse_mark__" + ((JSONObject) obj).toString();
        } else if (!(obj instanceof JSONArray)) {
            return obj;
        } else {
            return "__parse_mark__" + ((JSONArray) obj).toString();
        }
    }
}
