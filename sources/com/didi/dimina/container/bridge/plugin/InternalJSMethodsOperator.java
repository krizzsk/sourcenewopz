package com.didi.dimina.container.bridge.plugin;

import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import java.util.ArrayList;
import java.util.List;

public class InternalJSMethodsOperator {

    /* renamed from: a */
    private final List<Class<? extends BaseServiceModule>> f16760a = new ArrayList();

    /* renamed from: b */
    private final List<JSModuleWrapper> f16761b = new ArrayList();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54763a(Class<? extends BaseServiceModule> cls) {
        DMServiceSubBridgeModule dMServiceSubBridgeModule = (DMServiceSubBridgeModule) cls.getAnnotation(DMServiceSubBridgeModule.class);
        String str = "DMServiceBridgeModule$Inner" + this.f16760a.size();
        boolean z = false;
        if (dMServiceSubBridgeModule != null) {
            if (dMServiceSubBridgeModule.level() <= 0) {
                z = true;
            }
            m12439a(str, cls, z);
            return;
        }
        m12439a(str, cls, false);
    }

    /* renamed from: a */
    private void m12439a(String str, Class<? extends BaseServiceModule> cls, boolean z) {
        if (z) {
            this.f16760a.add(cls);
            this.f16761b.add(new JSModuleWrapper(str, cls));
            return;
        }
        this.f16760a.add(0, cls);
        this.f16761b.add(0, new JSModuleWrapper(str, cls));
    }

    public List<JSModuleWrapper> getListInternalMethodsWrapper() {
        return this.f16761b;
    }
}
