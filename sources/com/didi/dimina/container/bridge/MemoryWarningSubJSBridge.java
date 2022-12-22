package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.messager.MessageWrapperBuilder;
import com.didi.dimina.container.mina.DMMemoryManager;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class MemoryWarningSubJSBridge {

    /* renamed from: a */
    WeakReference<DMMina> f16611a;

    public MemoryWarningSubJSBridge(DMMina dMMina) {
        this.f16611a = new WeakReference<>(dMMina);
        DMMemoryManager.getInstance().setMemoryManagerCallback(new DMMemoryManager.DiminaMemoryManagerCallback() {
            public final void onTrimMemory(int i) {
                MemoryWarningSubJSBridge.this.m12220a(i);
            }
        });
        LogUtil.m13411i("MemoryWarningSubJSBridge init");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m12220a(int i) {
        DMMina dMMina;
        WeakReference<DMMina> weakReference = this.f16611a;
        if (weakReference != null && (dMMina = (DMMina) weakReference.get()) != null) {
            if (i == 5 || i == 10 || i == 15) {
                LogUtil.m13407d("MemoryWarningSubJSBridge memory warning:" + i);
                JSONObject jSONObject = new JSONObject();
                JSONUtil.put(jSONObject, "level", i);
                dMMina.getMessageTransfer().sendMessageToServiceFromNative("onMemoryWarningReceive", new MessageWrapperBuilder().data(jSONObject).build());
            }
        }
    }
}
