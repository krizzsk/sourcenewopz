package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.util.CallBackUtil;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u0004\u0018\u00010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/dimina/container/bridge/BridgeCheckBridge;", "", "mDMMina", "Lcom/didi/dimina/container/DMMina;", "(Lcom/didi/dimina/container/DMMina;)V", "checkBridgeExist", "", "paras", "Lorg/json/JSONObject;", "moduleName", "", "callback", "Lcom/didi/dimina/container/bridge/base/CallbackFunction;", "checkBridgeExistMethod", "", "dmMina", "methodName", "findMethodFromDMServiceSubModule", "Lcom/didi/dimina/container/messager/jsmodule/JSModuleWrapper;", "wrappers", "", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BridgeCheckBridge.kt */
public final class BridgeCheckBridge {

    /* renamed from: a */
    private final DMMina f16559a;

    public BridgeCheckBridge(DMMina dMMina) {
        Intrinsics.checkParameterIsNotNull(dMMina, "mDMMina");
        this.f16559a = dMMina;
    }

    public final void checkBridgeExist(JSONObject jSONObject, String str, CallbackFunction callbackFunction) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "paras");
        Intrinsics.checkParameterIsNotNull(str, "moduleName");
        String optString = jSONObject.optString("methodName");
        DMMina dMMina = this.f16559a;
        Intrinsics.checkExpressionValueIsNotNull(optString, "methodName");
        boolean a = m12183a(dMMina, str, optString);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("bridgeExist", a);
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        } catch (JSONException unused) {
            CallBackUtil.onFail$default((JSONObject) null, "查询失败", callbackFunction, 1, (Object) null);
        }
    }

    /* renamed from: a */
    private final boolean m12183a(DMMina dMMina, String str, String str2) {
        Method method;
        JSModuleWrapper jSModule = dMMina.getJSModule(str);
        Method method2 = null;
        BaseServiceModule baseServiceModule = null;
        if (jSModule != null) {
            if (Intrinsics.areEqual((Object) "DMServiceBridgeModule", (Object) str)) {
                List<JSModuleWrapper> dMServiceSubJSModuleWrapper = dMMina.getDMServiceSubJSModuleWrapper();
                Intrinsics.checkExpressionValueIsNotNull(dMServiceSubJSModuleWrapper, "diminaDMServiceSubModuleWrappers");
                JSModuleWrapper a = m12182a(dMServiceSubJSModuleWrapper, str2);
                if (a == null) {
                    List<JSModuleWrapper> dMServiceSubJSModuleWrapper2 = GlobalJSModuleManager.getDMServiceSubJSModuleWrapper(dMMina);
                    Intrinsics.checkExpressionValueIsNotNull(dMServiceSubJSModuleWrapper2, "globalDMServiceSubModuleWrappers");
                    a = m12182a(dMServiceSubJSModuleWrapper2, str2);
                }
                if (a != null) {
                    baseServiceModule = a.getServiceModuleInstance(dMMina);
                    method = a.getTargetMethod(str2);
                    if (method == null || baseServiceModule == null) {
                        method = jSModule.getTargetMethod(str2);
                        jSModule.getServiceModuleInstance(dMMina);
                    }
                    if (method == null || !Modifier.isStatic(method.getModifiers())) {
                        method2 = method;
                    }
                }
            }
            method = method2;
            method = jSModule.getTargetMethod(str2);
            jSModule.getServiceModuleInstance(dMMina);
            method2 = method;
        }
        return method2 != null;
    }

    /* renamed from: a */
    private final JSModuleWrapper m12182a(List<? extends JSModuleWrapper> list, String str) {
        for (JSModuleWrapper jSModuleWrapper : list) {
            Method targetMethod = jSModuleWrapper.getTargetMethod(str);
            if (targetMethod != null && !Modifier.isStatic(targetMethod.getModifiers())) {
                return jSModuleWrapper;
            }
        }
        return null;
    }
}
