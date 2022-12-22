package com.didi.dimina.container.messager;

import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.messager.MessageHandler;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.webengine.WebViewEngine;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public class MessageHandler {
    public static final String PARAM_ENABLE_ALL_BRIDGE_LISTENER = "param_enable_all_bridge_listener";
    public static final String PARAM_ENABLE_FIRST_DOM_READY_BRIDGE_LISTENER = "param_enable_first_dom_ready_bridge_listener";
    public static final String TAG = "MessageHandler";
    public static final String TAG_NATIVE_BRIDGE = "Dimina-Native-Bridge";

    /* renamed from: a */
    private static final Object f16868a = new JSONObject();

    /* renamed from: b */
    private static final DMConfig.OnBridgeCallbackListener f16869b = new AllBridgeListener();

    /* renamed from: c */
    private static final DMConfig.OnBridgeCallbackListener f16870c = new FirstDomReadyBridgeListener();
    public static boolean sEnableAllBridgeListener = false;
    public static boolean sEnableFirstDomReadyBridgeListener = false;

    public interface Callback {
        void onResult(JSONObject jSONObject);
    }

    public static void handleFromWebView(DMMina dMMina, String str, String str2, JSONObject jSONObject, WebViewEngine webViewEngine, Callback callback) {
        if (jSONObject != null) {
            DMConfig.OnBridgeCallbackListener onBridgeCallbackListener = null;
            if (!(dMMina.getConfig() == null || dMMina.getConfig().getCallbackConfig() == null)) {
                onBridgeCallbackListener = dMMina.getConfig().getCallbackConfig().getBridgeCallbackListener();
            }
            Object obj = new Object();
            if (!"DMWebViewBridgeModule".equals(str)) {
                DMMina dMMina2 = dMMina;
                String str3 = str2;
                Object obj2 = obj;
                Object a = m12494a(dMMina2, str, str3, jSONObject, m12491a(dMMina2, callback, str3, str, onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM.SERVICE, obj2), onBridgeCallbackListener, obj2);
                if (a != null && a != f16868a && onBridgeCallbackListener != null) {
                    onBridgeCallbackListener.onBridgeCallback(DMConfig.OnBridgeCallbackListener.FROM.SERVICE, DMConfig.OnBridgeCallbackListener.TYPE.SYNC, str, str2, a, obj);
                    return;
                }
                return;
            }
            DMMina dMMina3 = dMMina;
            Object a2 = m12493a(dMMina3, webViewEngine, str, str2, jSONObject, m12491a(dMMina3, callback, str2, str, onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM.WEB_VIEW, obj), onBridgeCallbackListener, obj);
            if (a2 != null && a2 != f16868a) {
                m12495a(dMMina, onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM.WEB_VIEW, DMConfig.OnBridgeCallbackListener.TYPE.SYNC, str, str2, a2, obj);
                return;
            }
            return;
        }
        LogUtil.m13411i("try handle JSBridge event but param data is invalidate");
    }

    public static Object handleFromService(DMMina dMMina, String str, String str2, JSONObject jSONObject, Callback callback) {
        if (jSONObject != null) {
            DMConfig.OnBridgeCallbackListener onBridgeCallbackListener = null;
            if (!(dMMina.getConfig() == null || dMMina.getConfig().getCallbackConfig() == null)) {
                onBridgeCallbackListener = dMMina.getConfig().getCallbackConfig().getBridgeCallbackListener();
            }
            Object obj = new Object();
            DMMina dMMina2 = dMMina;
            String str3 = str2;
            Object obj2 = obj;
            Object a = m12494a(dMMina2, str, str3, jSONObject, m12491a(dMMina2, callback, str3, str, onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM.SERVICE, obj2), onBridgeCallbackListener, obj2);
            if (!(a == null || a == f16868a)) {
                m12495a(dMMina, onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM.SERVICE, DMConfig.OnBridgeCallbackListener.TYPE.SYNC, str, str2, a, obj);
                return a;
            }
        } else {
            LogUtil.m13411i("try handle JSBridge event but param data is invalidate");
        }
        return f16868a;
    }

    /* renamed from: a */
    private static CallbackFunction m12491a(DMMina dMMina, Callback callback, String str, String str2, DMConfig.OnBridgeCallbackListener onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM from, Object obj) {
        return new CallbackFunction(dMMina, onBridgeCallbackListener, from, str2, str, obj) {
            public final /* synthetic */ DMMina f$1;
            public final /* synthetic */ DMConfig.OnBridgeCallbackListener f$2;
            public final /* synthetic */ DMConfig.OnBridgeCallbackListener.FROM f$3;
            public final /* synthetic */ String f$4;
            public final /* synthetic */ String f$5;
            public final /* synthetic */ Object f$6;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
                this.f$5 = r6;
                this.f$6 = r7;
            }

            public final void onCallBack(Object[] objArr) {
                MessageHandler.m12498a(MessageHandler.Callback.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, objArr);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m12498a(Callback callback, DMMina dMMina, DMConfig.OnBridgeCallbackListener onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM from, String str, String str2, Object obj, Object[] objArr) {
        if (callback != null && objArr != null && objArr.length > 0 && (objArr[0] instanceof JSONObject)) {
            JSONObject jSONObject = objArr[0];
            m12495a(dMMina, onBridgeCallbackListener, from, DMConfig.OnBridgeCallbackListener.TYPE.ASYNC, str, str2, (Object) jSONObject, obj);
            callback.onResult(jSONObject);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070 A[SYNTHETIC, Splitter:B:28:0x0070] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m12493a(com.didi.dimina.container.DMMina r17, com.didi.dimina.container.webengine.WebViewEngine r18, java.lang.String r19, java.lang.String r20, org.json.JSONObject r21, com.didi.dimina.container.bridge.base.CallbackFunction r22, com.didi.dimina.container.DMConfig.OnBridgeCallbackListener r23, java.lang.Object r24) {
        /*
            r8 = r17
            r0 = r18
            r9 = r19
            r10 = r20
            r11 = r22
            java.lang.String r12 = ""
            com.didi.dimina.container.messager.jsmodule.JSModuleWrapper r13 = r8.getJSModule(r9)
            java.lang.reflect.Method r14 = r13.getTargetMethod(r10)
            if (r14 == 0) goto L_0x00a1
            int r1 = r14.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 != 0) goto L_0x00ab
            r7 = 1
            r16 = 0
            com.didi.dimina.container.DMConfig$OnBridgeCallbackListener$FROM r3 = com.didi.dimina.container.DMConfig.OnBridgeCallbackListener.FROM.WEB_VIEW     // Catch:{ Exception -> 0x0057 }
            r1 = r17
            r2 = r23
            r4 = r19
            r5 = r20
            r6 = r21
            r15 = 1
            r7 = r24
            m12496a((com.didi.dimina.container.DMMina) r1, (com.didi.dimina.container.DMConfig.OnBridgeCallbackListener) r2, (com.didi.dimina.container.DMConfig.OnBridgeCallbackListener.FROM) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0055 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x0055 }
            r1[r16] = r0     // Catch:{ Exception -> 0x0055 }
            com.didi.dimina.container.bridge.base.BaseHybridModule r0 = r13.getWebViewModuleInstance(r0, r1)     // Catch:{ Exception -> 0x0055 }
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0053 }
            r2[r16] = r21     // Catch:{ Exception -> 0x0055 }
            r2[r15] = r11     // Catch:{ Exception -> 0x0055 }
            java.lang.Object r0 = r14.invoke(r0, r2)     // Catch:{ Exception -> 0x0055 }
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x004f
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0055 }
            return r0
        L_0x004f:
            if (r0 != 0) goto L_0x0052
            return r12
        L_0x0052:
            return r0
        L_0x0053:
            r0 = move-exception
            goto L_0x005a
        L_0x0055:
            r0 = move-exception
            goto L_0x0059
        L_0x0057:
            r0 = move-exception
            r15 = 1
        L_0x0059:
            r1 = 2
        L_0x005a:
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r16] = r10
            java.lang.String r2 = r0.getMessage()
            r1[r15] = r2
            java.lang.String r2 = "try handle method %s occurred unexpected exception: %s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            com.didi.dimina.container.util.LogUtil.m13409e(r1)
            if (r21 == 0) goto L_0x0074
            java.lang.String r12 = r21.toString()     // Catch:{ Exception -> 0x00ab }
        L_0x0074:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x00ab }
            r1.<init>()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r2 = "module"
            r1.put(r2, r9)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r2 = "method"
            r1.put(r2, r10)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r2 = "params"
            r1.put(r2, r12)     // Catch:{ Exception -> 0x00ab }
            java.lang.String r2 = "error"
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ Exception -> 0x00ab }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x00ab }
            int r0 = r17.getMinaIndex()     // Catch:{ Exception -> 0x00ab }
            java.lang.String r2 = "BridgeException"
            r3 = 1002(0x3ea, float:1.404E-42)
            java.lang.String r1 = com.didi.dimina.container.util.JSONUtil.toJson(r1)     // Catch:{ Exception -> 0x00ab }
            com.didi.dimina.container.util.TraceUtil.trackEventError(r0, r2, r3, r1)     // Catch:{ Exception -> 0x00ab }
            goto L_0x00ab
        L_0x00a1:
            int r0 = r17.getMinaIndex()
            com.didi.dimina.container.util.TraceUtil.traceUnrealizedBridge(r0, r9, r10)
            m12497a(r8, r9, r10, r11)
        L_0x00ab:
            java.lang.Object r0 = f16868a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.messager.MessageHandler.m12493a(com.didi.dimina.container.DMMina, com.didi.dimina.container.webengine.WebViewEngine, java.lang.String, java.lang.String, org.json.JSONObject, com.didi.dimina.container.bridge.base.CallbackFunction, com.didi.dimina.container.DMConfig$OnBridgeCallbackListener, java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    private static JSModuleWrapper m12492a(List<JSModuleWrapper> list, String str) {
        for (JSModuleWrapper next : list) {
            Method targetMethod = next.getTargetMethod(str);
            if (targetMethod != null && !Modifier.isStatic(targetMethod.getModifiers())) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b1 A[SYNTHETIC, Splitter:B:38:0x00b1] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object m12494a(com.didi.dimina.container.DMMina r16, java.lang.String r17, java.lang.String r18, org.json.JSONObject r19, com.didi.dimina.container.bridge.base.CallbackFunction r20, com.didi.dimina.container.DMConfig.OnBridgeCallbackListener r21, java.lang.Object r22) {
        /*
            r8 = r16
            r9 = r17
            r10 = r18
            r0 = r20
            java.lang.String r11 = ""
            com.didi.dimina.container.messager.jsmodule.JSModuleWrapper r1 = r16.getJSModule(r17)
            if (r1 == 0) goto L_0x00ec
            java.lang.String r2 = "DMServiceBridgeModule"
            boolean r2 = r2.equals(r9)
            r3 = 0
            if (r2 == 0) goto L_0x0036
            java.util.List r2 = r16.getDMServiceSubJSModuleWrapper()
            com.didi.dimina.container.messager.jsmodule.JSModuleWrapper r2 = m12492a(r2, r10)
            if (r2 != 0) goto L_0x002b
            java.util.List r2 = com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager.getDMServiceSubJSModuleWrapper(r16)
            com.didi.dimina.container.messager.jsmodule.JSModuleWrapper r2 = m12492a(r2, r10)
        L_0x002b:
            if (r2 == 0) goto L_0x0036
            com.didi.dimina.container.messager.jsmodule.BaseServiceModule r4 = r2.getServiceModuleInstance(r8)
            java.lang.reflect.Method r2 = r2.getTargetMethod(r10)
            goto L_0x0038
        L_0x0036:
            r2 = r3
            r4 = r2
        L_0x0038:
            if (r2 == 0) goto L_0x003c
            if (r4 != 0) goto L_0x0044
        L_0x003c:
            java.lang.reflect.Method r2 = r1.getTargetMethod(r10)
            com.didi.dimina.container.messager.jsmodule.BaseServiceModule r4 = r1.getServiceModuleInstance(r8)
        L_0x0044:
            r12 = r4
            if (r2 == 0) goto L_0x0053
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x0053
            r13 = r3
            goto L_0x0054
        L_0x0053:
            r13 = r2
        L_0x0054:
            if (r13 == 0) goto L_0x00e2
            if (r12 == 0) goto L_0x00e2
            r15 = 0
            r7 = 2
            com.didi.dimina.container.DMConfig$OnBridgeCallbackListener$FROM r3 = com.didi.dimina.container.DMConfig.OnBridgeCallbackListener.FROM.SERVICE     // Catch:{ Exception -> 0x0084 }
            r1 = r16
            r2 = r21
            r4 = r17
            r5 = r18
            r6 = r19
            r14 = 2
            r7 = r22
            m12496a((com.didi.dimina.container.DMMina) r1, (com.didi.dimina.container.DMConfig.OnBridgeCallbackListener) r2, (com.didi.dimina.container.DMConfig.OnBridgeCallbackListener.FROM) r3, (java.lang.String) r4, (java.lang.String) r5, (org.json.JSONObject) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x0082 }
            java.lang.Object[] r1 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0082 }
            r1[r15] = r19     // Catch:{ Exception -> 0x0082 }
            r2 = 1
            r1[r2] = r0     // Catch:{ Exception -> 0x0082 }
            java.lang.Object r0 = r13.invoke(r12, r1)     // Catch:{ Exception -> 0x0082 }
            boolean r1 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0082 }
            if (r1 == 0) goto L_0x007e
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0082 }
            return r0
        L_0x007e:
            if (r0 != 0) goto L_0x0081
            return r11
        L_0x0081:
            return r0
        L_0x0082:
            r0 = move-exception
            goto L_0x0086
        L_0x0084:
            r0 = move-exception
            r14 = 2
        L_0x0086:
            java.lang.Object[] r1 = new java.lang.Object[r14]
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            java.lang.String r3 = ":"
            r2.append(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r1[r15] = r2
            java.lang.String r2 = android.util.Log.getStackTraceString(r0)
            r3 = 1
            r1[r3] = r2
            java.lang.String r2 = "try handle method %s occurred unexpected exception: %s"
            java.lang.String r1 = java.lang.String.format(r2, r1)
            com.didi.dimina.container.util.LogUtil.m13409e(r1)
            if (r19 == 0) goto L_0x00b5
            java.lang.String r11 = r19.toString()     // Catch:{ Exception -> 0x00ec }
        L_0x00b5:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x00ec }
            r1.<init>()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r2 = "module"
            r1.put(r2, r9)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r2 = "method"
            r1.put(r2, r10)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r2 = "params"
            r1.put(r2, r11)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r2 = "error"
            java.lang.String r0 = android.util.Log.getStackTraceString(r0)     // Catch:{ Exception -> 0x00ec }
            r1.put(r2, r0)     // Catch:{ Exception -> 0x00ec }
            int r0 = r16.getMinaIndex()     // Catch:{ Exception -> 0x00ec }
            java.lang.String r2 = "BridgeException"
            r3 = 1001(0x3e9, float:1.403E-42)
            java.lang.String r1 = com.didi.dimina.container.util.JSONUtil.toJson(r1)     // Catch:{ Exception -> 0x00ec }
            com.didi.dimina.container.util.TraceUtil.trackEventError(r0, r2, r3, r1)     // Catch:{ Exception -> 0x00ec }
            goto L_0x00ec
        L_0x00e2:
            int r1 = r16.getMinaIndex()
            com.didi.dimina.container.util.TraceUtil.traceUnrealizedBridge(r1, r9, r10)
            m12497a(r8, r9, r10, r0)
        L_0x00ec:
            java.lang.Object r0 = f16868a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.messager.MessageHandler.m12494a(com.didi.dimina.container.DMMina, java.lang.String, java.lang.String, org.json.JSONObject, com.didi.dimina.container.bridge.base.CallbackFunction, com.didi.dimina.container.DMConfig$OnBridgeCallbackListener, java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    private static void m12496a(DMMina dMMina, DMConfig.OnBridgeCallbackListener onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM from, String str, String str2, JSONObject jSONObject, Object obj) {
        if (onBridgeCallbackListener != null) {
            onBridgeCallbackListener.onBridgeCalled(from, str, str2, jSONObject, obj);
        }
        if (sEnableAllBridgeListener) {
            f16869b.onBridgeCalled(from, str, str2, jSONObject, obj);
        }
        if (dMMina != null && dMMina.getPerformance() != null && !dMMina.getPerformance().isFirstDomReady() && sEnableFirstDomReadyBridgeListener) {
            f16870c.onBridgeCalled(from, str, str2, jSONObject, obj);
        }
    }

    /* renamed from: a */
    private static void m12495a(DMMina dMMina, DMConfig.OnBridgeCallbackListener onBridgeCallbackListener, DMConfig.OnBridgeCallbackListener.FROM from, DMConfig.OnBridgeCallbackListener.TYPE type, String str, String str2, Object obj, Object obj2) {
        if (onBridgeCallbackListener != null) {
            onBridgeCallbackListener.onBridgeCallback(from, type, str, str2, obj, obj2);
        }
        if (sEnableAllBridgeListener) {
            f16869b.onBridgeCallback(from, type, str, str2, obj, obj2);
        }
        if (dMMina != null && dMMina.getPerformance() != null && !dMMina.getPerformance().isFirstDomReady() && sEnableFirstDomReadyBridgeListener) {
            f16870c.onBridgeCallback(from, type, str, str2, obj, obj2);
        }
    }

    /* renamed from: a */
    private static void m12497a(DMMina dMMina, String str, String str2, CallbackFunction callbackFunction) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "module", (Object) str);
        JSONUtil.put(jSONObject, "method", (Object) str2);
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "data", (Object) jSONObject);
        LogUtil.eRelease(TAG, "dealWithUnrealizedBridge() 未实现该bridge, 向service层发送消息:" + jSONObject2);
        dMMina.getMessageTransfer().sendMessageToServiceFromNative("noTargetApiCall", jSONObject2);
    }

    public static class AllBridgeListener implements DMConfig.OnBridgeCallbackListener {
        public void onBridgeCalled(DMConfig.OnBridgeCallbackListener.FROM from, String str, String str2, JSONObject jSONObject, Object obj) {
            LogUtil.iRelease(MessageHandler.TAG_NATIVE_BRIDGE, "Bridge Called: [" + obj + "] method: " + str + "@" + str2 + ", data: " + jSONObject);
        }

        public void onBridgeCallback(DMConfig.OnBridgeCallbackListener.FROM from, DMConfig.OnBridgeCallbackListener.TYPE type, String str, String str2, Object obj, Object obj2) {
            if (type == DMConfig.OnBridgeCallbackListener.TYPE.ASYNC) {
                LogUtil.iRelease(MessageHandler.TAG_NATIVE_BRIDGE, "Bridge CallbackAsync: [" + obj2 + "] method: " + str + "@" + str2 + ", data: " + obj);
                return;
            }
            LogUtil.iRelease(MessageHandler.TAG_NATIVE_BRIDGE, "Bridge CallbackSync: [" + obj2 + "] method: " + str + "@" + str2 + ", data: " + obj);
        }
    }

    public static class FirstDomReadyBridgeListener implements DMConfig.OnBridgeCallbackListener {
        List<String> sIgnoreMethodList = new ArrayList(Arrays.asList(new String[]{InternalJSMethod.SHOW_CAPSULE_BUTTON, InternalJSMethod.HIDE_CAPSULE_BUTTON, "launch", InternalJSMethod.RELAUNCH, InternalJSMethod.REDIRECT_TO, InternalJSMethod.NAVIGATE_TO, InternalJSMethod.NAVIGATE_BACK, InternalJSMethod.GET_CURRENT_PAGES, InternalJSMethod.SWITCH_TAB, InternalJSMethod.CLOSE_DIMINA, InternalJSMethod.LOG_DEBUG, InternalJSMethod.LOG_INFO, InternalJSMethod.LOG_WARN, InternalJSMethod.LOG_ERROR, InternalJSMethod.ENABLE_APOLLO, InternalJSMethod.DATA_FROM_APOLLO, "trace", InternalJSMethod.REPORT_ANALYTICS, InternalJSMethod.GET_SDK_REPORT_POINT, InternalJSMethod.TRACE_RAVEN, InternalJSMethod.GET_IMAGE_INFO, InternalJSMethod.SAVE_IMAGE_TO_PHOTOS_ALBUM, InternalJSMethod.SET_NAVIGATION_BAR_TITLE, InternalJSMethod.SET_NAVIGATION_BAR_COLOR, InternalJSMethod.SET_NAVIGATION_TITLE_COLOR, InternalJSMethod.SHOW_NAVIGATION_BAR, InternalJSMethod.HIDE_NAVIGATION_BAR, InternalJSMethod.SET_NAVIGATION_BAR_BUTTON, InternalJSMethod.SET_NAVIGATION_BAR_CLICK_LISTENER, InternalJSMethod.GET_MENU_BUTTON_BOUNDING_CLIENT_RECT, InternalJSMethod.INVOKE_SERVICE_READY, InternalJSMethod.INVOKE_BUSINESS_READY, InternalJSMethod.LOAD_JS_FILE_TO_DATA_THREAD, InternalJSMethod.PRELOAD_SUB_PACKAGE, InternalJSMethod.LOAD_SUB_PACKAGE}));

        public void onBridgeCalled(DMConfig.OnBridgeCallbackListener.FROM from, String str, String str2, JSONObject jSONObject, Object obj) {
            if (!checkIgnore(str, str2)) {
                LogUtil.iRelease(MessageHandler.TAG_NATIVE_BRIDGE, "First DomReady Bridge Called: [" + obj + "] method: " + str + "@" + str2 + ", data: " + jSONObject);
            }
        }

        public void onBridgeCallback(DMConfig.OnBridgeCallbackListener.FROM from, DMConfig.OnBridgeCallbackListener.TYPE type, String str, String str2, Object obj, Object obj2) {
            if (!checkIgnore(str, str2)) {
                if (type == DMConfig.OnBridgeCallbackListener.TYPE.ASYNC) {
                    LogUtil.iRelease(MessageHandler.TAG_NATIVE_BRIDGE, "First DomReady Bridge CallbackAsync: [" + obj2 + "] method: " + str + "@" + str2 + ", data: " + obj);
                    return;
                }
                LogUtil.iRelease(MessageHandler.TAG_NATIVE_BRIDGE, "First DomReady Bridge CallbackSync: [" + obj2 + "] method: " + str + "@" + str2 + ", data: " + obj);
            }
        }

        private boolean checkIgnore(String str, String str2) {
            if (!"DMWebViewBridgeModule".equals(str) && !this.sIgnoreMethodList.contains(str2)) {
                return false;
            }
            return true;
        }
    }
}
