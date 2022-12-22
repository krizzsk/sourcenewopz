package com.didi.dimina.container.bridge.plugin;

import android.text.TextUtils;
import com.didi.dimina.container.bridge.DMServiceJSModule;
import com.didi.dimina.container.bridge.DMWebViewJSModule;
import com.didi.dimina.container.bridge.plugin.exception.MinaBridgeModuleRegisteredException;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.util.LogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinaJSModuleManager {

    /* renamed from: a */
    private final Map<String, JSModuleWrapper> f16762a = new HashMap();

    /* renamed from: b */
    private final InternalJSMethodsOperator f16763b = new InternalJSMethodsOperator();

    public JSModuleWrapper getJSModule(String str) {
        return this.f16762a.get(str);
    }

    public void initDiminaJSModules() {
        try {
            registerJSModule("DMServiceBridgeModule", DMServiceJSModule.class);
        } catch (MinaBridgeModuleRegisteredException unused) {
            LogUtil.iRelease("MinaJSModuleManager", "DMServiceJSModule 注册失败");
        }
        this.f16762a.put("DMWebViewBridgeModule", new JSModuleWrapper("DMWebViewBridgeModule", DMWebViewJSModule.class));
    }

    public void registerDMServiceSubJSModule(Class<? extends BaseServiceModule> cls) {
        if (cls != null) {
            this.f16763b.mo54763a(cls);
        }
    }

    public void registerJSModule(String str, Class<? extends BaseServiceModule> cls) throws MinaBridgeModuleRegisteredException {
        if (TextUtils.isEmpty(str) || this.f16762a.containsKey(str)) {
            throw new MinaBridgeModuleRegisteredException("模块名称为空" + str + "模块已经被注册过");
        }
        this.f16762a.put(str, new JSModuleWrapper(str, cls));
    }

    public void release() {
        for (JSModuleWrapper next : this.f16762a.values()) {
            if (next != null) {
                next.releaseServiceModuleInstance();
            }
        }
        for (JSModuleWrapper next2 : getDMServiceSubJSModuleWrapper()) {
            if (next2 != null) {
                next2.releaseServiceModuleInstance();
            }
        }
    }

    public List<JSModuleWrapper> getDMServiceSubJSModuleWrapper() {
        return this.f16763b.getListInternalMethodsWrapper();
    }
}
