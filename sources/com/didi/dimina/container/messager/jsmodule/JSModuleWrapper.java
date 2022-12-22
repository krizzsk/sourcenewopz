package com.didi.dimina.container.messager.jsmodule;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.BaseHybridModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class JSModuleWrapper {

    /* renamed from: a */
    private final String f16874a;

    /* renamed from: b */
    private final Class<?> f16875b;

    /* renamed from: c */
    private Map<String, Method> f16876c;

    /* renamed from: d */
    private BaseServiceModule f16877d;

    /* renamed from: e */
    private WeakHashMap<WebViewEngine, BaseHybridModule> f16878e;

    public JSModuleWrapper(String str, Class<?> cls) {
        this.f16874a = str;
        this.f16875b = cls;
    }

    public String getJSModuleName() {
        return this.f16874a;
    }

    public Class<?> getJSModuleClass() {
        return this.f16875b;
    }

    public Collection<String> getMethodNames() {
        if (this.f16876c == null) {
            this.f16876c = m12499a();
        }
        return this.f16876c.keySet();
    }

    public Method getTargetMethod(String str) {
        if (this.f16876c == null) {
            this.f16876c = m12499a();
        }
        return this.f16876c.get(str);
    }

    /* renamed from: a */
    private Map<String, Method> m12499a() {
        HashMap hashMap = new HashMap();
        for (Method method : this.f16875b.getMethods()) {
            JsInterface jsInterface = (JsInterface) method.getAnnotation(JsInterface.class);
            if (jsInterface != null) {
                for (String put : jsInterface.value()) {
                    hashMap.put(put, method);
                }
            }
        }
        return hashMap;
    }

    public BaseServiceModule getServiceModuleInstance(DMMina dMMina) {
        if (this.f16877d == null) {
            Object[] objArr = {dMMina};
            Class[] clsArr = new Class[1];
            for (int i = 0; i < 1; i++) {
                clsArr[i] = objArr[i].getClass();
            }
            try {
                this.f16877d = (BaseServiceModule) this.f16875b.getConstructor(clsArr).newInstance(objArr);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return this.f16877d;
    }

    public void releaseServiceModuleInstance() {
        BaseServiceModule baseServiceModule = this.f16877d;
        if (baseServiceModule != null) {
            try {
                baseServiceModule.onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public BaseHybridModule getWebViewModuleInstance(WebViewEngine webViewEngine, Object[] objArr) {
        if (this.f16878e == null) {
            this.f16878e = new WeakHashMap<>();
        }
        BaseHybridModule baseHybridModule = this.f16878e.get(webViewEngine);
        if (baseHybridModule == null) {
            try {
                baseHybridModule = (BaseHybridModule) this.f16875b.getConstructor(new Class[]{WebViewEngine.class}).newInstance(objArr);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
            if (baseHybridModule != null) {
                this.f16878e.put(webViewEngine, baseHybridModule);
            }
        }
        return baseHybridModule;
    }

    public void releaseWebViewModuleInstance(WebViewEngine webViewEngine) {
        BaseHybridModule remove;
        WeakHashMap<WebViewEngine, BaseHybridModule> weakHashMap = this.f16878e;
        if (weakHashMap != null && (remove = weakHashMap.remove(webViewEngine)) != null) {
            try {
                remove.onDestroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
