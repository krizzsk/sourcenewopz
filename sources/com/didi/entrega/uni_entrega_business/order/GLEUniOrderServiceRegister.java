package com.didi.entrega.uni_entrega_business.order;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniOrderServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniOrderService gLEUniOrderService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.getOrderDataByLocal", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15497g(GLEUniOrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.requestOrderDataByService", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15496f(GLEUniOrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.shareData", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15495e(GLEUniOrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.onMapReset", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15494d(GLEUniOrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.contactByProtectedCall", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15493c(GLEUniOrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.contactByIm", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15491b(GLEUniOrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniOrderService.contactByCall", new StandardMessageCodec());
        if (gLEUniOrderService != null) {
            UniAPI.registerModule(gLEUniOrderService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniOrderServiceRegister.m15489a(GLEUniOrderService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15497g(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "orderId"
            java.lang.String r1 = "pageId"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            boolean r3 = r7.containsKey(r1)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001c
            java.lang.Object r1 = r7.get(r1)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x001d
        L_0x001c:
            r1 = r4
        L_0x001d:
            boolean r3 = r7.containsKey(r0)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            if (r3 == 0) goto L_0x002a
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r4 = r7
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
        L_0x002a:
            com.didi.entrega.uni_entrega_business.order.-$$Lambda$GLEUniOrderServiceRegister$oziPuk5Thh9baxDN1Dj4wDhANSs r7 = new com.didi.entrega.uni_entrega_business.order.-$$Lambda$GLEUniOrderServiceRegister$oziPuk5Thh9baxDN1Dj4wDhANSs     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r6.getOrderDataByLocal(r1, r4, r7)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x0052
        L_0x0033:
            r6 = move-exception
            goto L_0x0036
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 33
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister.m15497g(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15492b(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15496f(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "orderId"
            java.lang.String r1 = "pageId"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            boolean r3 = r7.containsKey(r1)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001c
            java.lang.Object r1 = r7.get(r1)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x001d
        L_0x001c:
            r1 = r4
        L_0x001d:
            boolean r3 = r7.containsKey(r0)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            if (r3 == 0) goto L_0x002a
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r4 = r7
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
        L_0x002a:
            com.didi.entrega.uni_entrega_business.order.-$$Lambda$GLEUniOrderServiceRegister$7m_5isxLwe88E7nmcuXYUSiygr8 r7 = new com.didi.entrega.uni_entrega_business.order.-$$Lambda$GLEUniOrderServiceRegister$7m_5isxLwe88E7nmcuXYUSiygr8     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r6.requestOrderDataByService(r1, r4, r7)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x0052
        L_0x0033:
            r6 = move-exception
            goto L_0x0036
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 54
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister.m15496f(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15490a(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m15495e(GLEUniOrderService gLEUniOrderService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniOrderService.shareData(map.containsKey("pageId") ? (String) map.get("pageId") : "", map.containsKey("data") ? (Map) map.get("data") : new HashMap());
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister", 76);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m15494d(GLEUniOrderService gLEUniOrderService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniOrderService.onMapReset(map.containsKey("pageId") ? (String) map.get("pageId") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister", 98);
        }
        reply.reply(hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15493c(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "orderId"
            java.lang.String r1 = "pageId"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            boolean r3 = r10.containsKey(r1)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001c
            java.lang.Object r1 = r10.get(r1)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x001d
        L_0x001c:
            r1 = r4
        L_0x001d:
            boolean r3 = r10.containsKey(r0)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            if (r3 == 0) goto L_0x002a
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
        L_0x002a:
            r9.contactByProtectedCall(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0054
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 121(0x79, float:1.7E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0054:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister.m15493c(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15491b(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "orderId"
            java.lang.String r1 = "pageId"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            boolean r3 = r10.containsKey(r1)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001c
            java.lang.Object r1 = r10.get(r1)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x001d
        L_0x001c:
            r1 = r4
        L_0x001d:
            boolean r3 = r10.containsKey(r0)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            if (r3 == 0) goto L_0x002a
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
        L_0x002a:
            r9.contactByIm(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0054
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 144(0x90, float:2.02E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0054:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister.m15491b(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15489a(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "phoneNumber"
            java.lang.String r1 = "pageId"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            boolean r3 = r10.containsKey(r1)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001c
            java.lang.Object r1 = r10.get(r1)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x001d
        L_0x001c:
            r1 = r4
        L_0x001d:
            boolean r3 = r10.containsKey(r0)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            if (r3 == 0) goto L_0x002a
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
        L_0x002a:
            r9.contactByCall(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0054
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 167(0xa7, float:2.34E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0054:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.order.GLEUniOrderServiceRegister.m15489a(com.didi.entrega.uni_entrega_business.order.GLEUniOrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* renamed from: a */
    private static Map<String, Object> m15488a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
