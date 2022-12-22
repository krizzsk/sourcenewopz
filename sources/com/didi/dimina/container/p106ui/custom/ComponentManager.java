package com.didi.dimina.container.p106ui.custom;

import android.text.TextUtils;
import com.didi.dimina.container.p106ui.canvas.CanvasViewComponent;
import com.didi.dimina.container.p106ui.custom.input.InputComponent;
import com.didi.dimina.container.p106ui.custom.webview.WebViewComponent;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.util.LogUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.dimina.container.ui.custom.ComponentManager */
public class ComponentManager {
    public static String DIMINA_CAMERA = "dimina_camera";
    public static String DIMINA_MAP = "dimina_map";
    public static String DIMINA_VIDEO = "dimina_video";

    /* renamed from: a */
    private static final Map<String, Class<? extends CustomComponent>> f17510a = new HashMap();

    /* renamed from: b */
    private static final HashMap<DMPage, HashMap<String, CustomComponent>> f17511b = new HashMap<>();

    static {
        registerCustomComponent("WebView", WebViewComponent.class);
        registerCustomComponent("dimina_input", InputComponent.class);
        registerCustomComponent("dimina_canvas", CanvasViewComponent.class);
    }

    public static synchronized void registerCustomComponent(String str, Class<? extends CustomComponent> cls) {
        synchronized (ComponentManager.class) {
            LogUtil.m13411i("ComponentManager registerCustomComponent: name => " + str + ", class => " + cls);
            f17510a.put(str, cls);
        }
    }

    public static synchronized CustomComponent getOrCreateComponent(DMPage dMPage, String str, String str2) {
        synchronized (ComponentManager.class) {
            LogUtil.m13411i("ComponentManager create: name => " + str + ", id => " + str2);
            HashMap hashMap = f17511b.get(dMPage);
            if (hashMap == null || hashMap.get(str2) == null) {
                if (f17510a.containsKey(str)) {
                    try {
                        Class cls = f17510a.get(str);
                        if (cls != null) {
                            CustomComponent customComponent = (CustomComponent) cls.newInstance();
                            if (hashMap != null) {
                                hashMap.put(str2, customComponent);
                            } else {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put(str2, customComponent);
                                f17511b.put(dMPage, hashMap2);
                            }
                            LogUtil.m13412i("ComponentManager create:", "name:" + str + ",id:" + str2 + " create new instance:");
                            return customComponent;
                        }
                    } catch (Exception e) {
                        LogUtil.m13411i("ComponentManager create failed.");
                        e.printStackTrace();
                    }
                }
                LogUtil.m13412i("ComponentManager create:", "name:" + str + ",id" + str2 + "not exist");
                return null;
            }
            LogUtil.m13412i("ComponentManager create:", "name:" + str + ",id" + str2 + "is exist");
            CustomComponent customComponent2 = (CustomComponent) hashMap.get(str2);
            return customComponent2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.didi.dimina.container.p106ui.custom.CustomComponent destroyComponent(com.didi.dimina.container.page.DMPage r3, java.lang.String r4) {
        /*
            java.lang.Class<com.didi.dimina.container.ui.custom.ComponentManager> r0 = com.didi.dimina.container.p106ui.custom.ComponentManager.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003d }
            r1.<init>()     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "ComponentManager destroyComponent: id => "
            r1.append(r2)     // Catch:{ all -> 0x003d }
            r1.append(r4)     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003d }
            com.didi.dimina.container.util.LogUtil.m13411i(r1)     // Catch:{ all -> 0x003d }
            java.util.HashMap<com.didi.dimina.container.page.DMPage, java.util.HashMap<java.lang.String, com.didi.dimina.container.ui.custom.CustomComponent>> r1 = f17511b     // Catch:{ all -> 0x003d }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x003d }
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x003a
            java.lang.Object r2 = r1.get(r4)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x003a
            java.lang.Object r4 = r1.remove(r4)     // Catch:{ all -> 0x003d }
            com.didi.dimina.container.ui.custom.CustomComponent r4 = (com.didi.dimina.container.p106ui.custom.CustomComponent) r4     // Catch:{ all -> 0x003d }
            int r1 = r1.size()     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0038
            java.util.HashMap<com.didi.dimina.container.page.DMPage, java.util.HashMap<java.lang.String, com.didi.dimina.container.ui.custom.CustomComponent>> r1 = f17511b     // Catch:{ all -> 0x003d }
            r1.remove(r3)     // Catch:{ all -> 0x003d }
        L_0x0038:
            monitor-exit(r0)
            return r4
        L_0x003a:
            r3 = 0
            monitor-exit(r0)
            return r3
        L_0x003d:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.custom.ComponentManager.destroyComponent(com.didi.dimina.container.page.DMPage, java.lang.String):com.didi.dimina.container.ui.custom.CustomComponent");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r4 = r4.getDmPage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void destroyComponents(com.didi.dimina.container.webengine.WebViewEngine r4) {
        /*
            if (r4 == 0) goto L_0x004f
            com.didi.dimina.container.page.DMPage r0 = r4.getDmPage()
            if (r0 != 0) goto L_0x0009
            goto L_0x004f
        L_0x0009:
            com.didi.dimina.container.page.DMPage r4 = r4.getDmPage()
            java.util.HashMap<com.didi.dimina.container.page.DMPage, java.util.HashMap<java.lang.String, com.didi.dimina.container.ui.custom.CustomComponent>> r0 = f17511b
            java.lang.Object r0 = r0.get(r4)
            java.util.HashMap r0 = (java.util.HashMap) r0
            if (r0 == 0) goto L_0x004f
            int r1 = r0.size()
            if (r1 <= 0) goto L_0x004f
            java.util.Set r1 = r0.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0025:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            if (r3 == 0) goto L_0x0025
            java.lang.Object r3 = r2.getValue()
            com.didi.dimina.container.ui.custom.CustomComponent r3 = (com.didi.dimina.container.p106ui.custom.CustomComponent) r3
            r3.onDestroyed()
            java.lang.Object r2 = r2.getValue()
            com.didi.dimina.container.ui.custom.CustomComponent r2 = (com.didi.dimina.container.p106ui.custom.CustomComponent) r2
            java.lang.String r2 = r2.mId
            destroyComponent(r4, r2)
            goto L_0x0025
        L_0x004c:
            r0.clear()
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.custom.ComponentManager.destroyComponents(com.didi.dimina.container.webengine.WebViewEngine):void");
    }

    public static synchronized CustomComponent getComponent(DMPage dMPage, String str) {
        synchronized (ComponentManager.class) {
            HashMap hashMap = f17511b.get(dMPage);
            if (hashMap == null) {
                return null;
            }
            CustomComponent customComponent = (CustomComponent) hashMap.get(str);
            return customComponent;
        }
    }

    public static synchronized Collection<CustomComponent> getComponentByPage(DMPage dMPage) {
        synchronized (ComponentManager.class) {
            if (f17511b.get(dMPage) == null) {
                return null;
            }
            Collection<CustomComponent> values = f17511b.get(dMPage).values();
            return values;
        }
    }

    public static boolean inBottomLayer(String str) {
        return TextUtils.equals(str, DIMINA_MAP) || TextUtils.equals(str, DIMINA_VIDEO) || TextUtils.equals(str, DIMINA_CAMERA);
    }
}
