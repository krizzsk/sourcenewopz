package com.didi.dimina.webview.jsbridge;

import com.didi.dimina.container.bridge.base.JsInterface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

public class ExportNamespace {

    /* renamed from: a */
    private static final String f18273a = ExportNamespace.class.getName();

    /* renamed from: b */
    private final String f18274b;

    /* renamed from: c */
    private final Class f18275c;

    /* renamed from: d */
    private Map<String, Method> f18276d;

    public ExportNamespace(String str, Class cls) {
        this.f18274b = str;
        this.f18275c = cls;
    }

    public String getExportModuleName() {
        return this.f18274b;
    }

    public Class getExportClass() {
        return this.f18275c;
    }

    public Method getTargetMethod(String str) {
        if (this.f18276d == null) {
            this.f18276d = m13594a();
        }
        return this.f18276d.get(str);
    }

    public JSONArray getExportMethodNames() {
        JSONArray jSONArray = new JSONArray();
        if (this.f18276d == null) {
            this.f18276d = m13594a();
        }
        for (String put : this.f18276d.keySet()) {
            jSONArray.put(put);
        }
        return jSONArray;
    }

    /* renamed from: a */
    private Map<String, Method> m13594a() {
        HashMap hashMap = new HashMap();
        for (Method method : this.f18275c.getMethods()) {
            JsInterface jsInterface = (JsInterface) method.getAnnotation(JsInterface.class);
            if (jsInterface != null) {
                for (String put : jsInterface.value()) {
                    hashMap.put(put, method);
                }
            }
        }
        return hashMap;
    }
}
