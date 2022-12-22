package com.didi.rlab.uni_customer_business.order_service;

import com.didi.rlab.uni_customer_business.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class OrderServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, OrderService orderService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.onMapReset", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24021g(OrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.contactByCall", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24020f(OrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.contactByIm", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24019e(OrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.goAppStoreRate", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24018d(OrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.sendReceipt", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24017c(OrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.refreshIMUnreadCount", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24016b(OrderService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.OrderService.dismissFloatingPage", new StandardMessageCodec());
        if (orderService != null) {
            UniAPI.registerModule(orderService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    OrderServiceRegister.m24014a(OrderService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m24021g(OrderService orderService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            orderService.onMapReset(map.containsKey("pageId") ? (String) map.get("pageId") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister", 33);
        }
        reply.reply(hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24020f(com.didi.rlab.uni_customer_business.order_service.OrderService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "contactRole"
            java.lang.String r1 = "orderId"
            java.lang.String r2 = "pageId"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
        L_0x002a:
            boolean r1 = r11.containsKey(r0)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            if (r1 == 0) goto L_0x003b
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            long r0 = r11.longValue()     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            goto L_0x003d
        L_0x003b:
            r0 = 0
        L_0x003d:
            r10.contactByCall(r2, r5, r0)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            goto L_0x0066
        L_0x0047:
            r10 = move-exception
            goto L_0x004a
        L_0x0049:
            r10 = move-exception
        L_0x004a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 57
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0066:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister.m24020f(com.didi.rlab.uni_customer_business.order_service.OrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24019e(com.didi.rlab.uni_customer_business.order_service.OrderService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "contactRole"
            java.lang.String r1 = "orderId"
            java.lang.String r2 = "pageId"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
        L_0x002a:
            boolean r1 = r11.containsKey(r0)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            if (r1 == 0) goto L_0x003b
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            long r0 = r11.longValue()     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            goto L_0x003d
        L_0x003b:
            r0 = 0
        L_0x003d:
            r10.contactByIm(r2, r5, r0)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0049, RuntimeException -> 0x0047 }
            goto L_0x0066
        L_0x0047:
            r10 = move-exception
            goto L_0x004a
        L_0x0049:
            r10 = move-exception
        L_0x004a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 81
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0066:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister.m24019e(com.didi.rlab.uni_customer_business.order_service.OrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24018d(OrderService orderService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            orderService.goAppStoreRate(map.containsKey("pageId") ? (String) map.get("pageId") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister", 103);
        }
        reply.reply(hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24017c(com.didi.rlab.uni_customer_business.order_service.OrderService r8, java.lang.Object r9, p242io.flutter.plugin.common.BasicMessageChannel.Reply r10) {
        /*
            java.lang.String r0 = "status"
            java.lang.String r1 = "orderId"
            java.lang.String r2 = "pageId"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r9 = (java.util.Map) r9     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            boolean r4 = r9.containsKey(r2)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r9.get(r2)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r9.containsKey(r1)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r9.get(r1)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
        L_0x002a:
            boolean r1 = r9.containsKey(r0)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            if (r1 == 0) goto L_0x003b
            java.lang.Object r9 = r9.get(r0)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            long r0 = r9.longValue()     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            goto L_0x003d
        L_0x003b:
            r0 = 0
        L_0x003d:
            r6 = r0
            com.didi.rlab.uni_customer_business.order_service.-$$Lambda$OrderServiceRegister$ux3QWw34OgDqoFfgv5YRLTbBoLQ r9 = new com.didi.rlab.uni_customer_business.order_service.-$$Lambda$OrderServiceRegister$ux3QWw34OgDqoFfgv5YRLTbBoLQ     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            r9.<init>(r3, r10)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            r0 = r8
            r1 = r2
            r2 = r5
            r3 = r6
            r5 = r9
            r0.sendReceipt(r1, r2, r3, r5)     // Catch:{ Error -> 0x004e, RuntimeException -> 0x004c }
            goto L_0x006b
        L_0x004c:
            r8 = move-exception
            goto L_0x004f
        L_0x004e:
            r8 = move-exception
        L_0x004f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "error: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r2 = r9.toString()
            r0 = 3
            r3 = 0
            r5 = 126(0x7e, float:1.77E-43)
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister.m24017c(com.didi.rlab.uni_customer_business.order_service.OrderService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24015a(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24016b(OrderService orderService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            orderService.refreshIMUnreadCount(map.containsKey("pageId") ? (String) map.get("pageId") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister", 147);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24014a(OrderService orderService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            orderService.dismissFloatingPage(map.containsKey("pageId") ? (String) map.get("pageId") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_customer_business.order_service.OrderServiceRegister", 169);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24013a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
