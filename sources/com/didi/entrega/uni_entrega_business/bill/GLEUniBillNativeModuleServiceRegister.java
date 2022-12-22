package com.didi.entrega.uni_entrega_business.bill;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniBillNativeModuleServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniBillNativeModuleService gLEUniBillNativeModuleService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.saveBillInfo", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15465m(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.showBillTippage", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15464l(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.queryPayWithpageID", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15463k(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.createdSuccessOrderInsertPool", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15462j(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.updateOrderPool", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15461i(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.verifyRandomPayWithPayment", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15460h(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.routeToVerifyPageWithTypes", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15459g(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.showPriceRulePage", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15458f(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.enterCouponPage", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15456e(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.gotoPayMethodPage", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15454d(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.gotoTripPage", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15452c(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.isApplePaySupportedWithNetworks", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15449b(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniBillNativeModuleService.updatePayListWithPreInterface", new StandardMessageCodec());
        if (gLEUniBillNativeModuleService != null) {
            UniAPI.registerModule(gLEUniBillNativeModuleService);
            basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniBillNativeModuleServiceRegister.m15446a(GLEUniBillNativeModuleService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel13.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static /* synthetic */ void m15465m(GLEUniBillNativeModuleService gLEUniBillNativeModuleService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniBillNativeModuleService.saveBillInfo(map.containsKey("billInfoModelJson") ? (String) map.get("billInfoModelJson") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m15445a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister", 34);
        }
        reply.reply(hashMap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: l */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15464l(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "pageParamsJson"
            java.lang.String r1 = "pageID"
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
            com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$YeEyRhLa3GU2L2vwYy--ByhLLkw r7 = new com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$YeEyRhLa3GU2L2vwYy--ByhLLkw     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r6.showBillTippage(r1, r4, r7)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x005e
        L_0x0033:
            r6 = move-exception
            goto L_0x0036
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            java.util.Map r7 = m15445a(r6)
            java.lang.String r0 = "error"
            r2.put(r0, r7)
            r8.reply(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 57
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15464l(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m15457e(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15463k(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "orderDataJson"
            java.lang.String r1 = "pageID"
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
            com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$XrsnrqbIvIZjCrHYjzfsF5bUXEs r7 = new com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$XrsnrqbIvIZjCrHYjzfsF5bUXEs     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r6.queryPayWithpageID(r1, r4, r7)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x005e
        L_0x0033:
            r6 = move-exception
            goto L_0x0036
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            java.util.Map r7 = m15445a(r6)
            java.lang.String r0 = "error"
            r2.put(r0, r7)
            r8.reply(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 79
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15463k(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m15455d(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15462j(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "orderDataJson"
            java.lang.String r1 = "pageID"
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
            r9.createdSuccessOrderInsertPool(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.util.Map r10 = m15445a(r9)
            java.lang.String r0 = "error"
            r2.put(r0, r10)
            r11.reply(r2)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 102(0x66, float:1.43E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0060:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15462j(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: i */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15461i(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "orderID"
            java.lang.String r1 = "pageID"
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
            r9.updateOrderPool(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.util.Map r10 = m15445a(r9)
            java.lang.String r0 = "error"
            r2.put(r0, r10)
            r11.reply(r2)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 126(0x7e, float:1.77E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0060:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15461i(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15460h(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "paymentJson"
            java.lang.String r1 = "pageID"
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
            com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$9Gvl7iY1M3wS0u-dfYIpfMxdxaU r7 = new com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$9Gvl7iY1M3wS0u-dfYIpfMxdxaU     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r6.verifyRandomPayWithPayment(r1, r4, r7)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x005e
        L_0x0033:
            r6 = move-exception
            goto L_0x0036
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            java.util.Map r7 = m15445a(r6)
            java.lang.String r0 = "error"
            r2.put(r0, r7)
            r8.reply(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 149(0x95, float:2.09E-43)
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15460h(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15450b(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15459g(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "subList"
            java.lang.String r1 = "pageID"
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
            r9.routeToVerifyPageWithTypes(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.util.Map r10 = m15445a(r9)
            java.lang.String r0 = "error"
            r2.put(r0, r10)
            r11.reply(r2)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 172(0xac, float:2.41E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0060:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15459g(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15458f(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "priceRuleJson"
            java.lang.String r1 = "pageID"
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
            r9.showPriceRulePage(r1, r4)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0037, RuntimeException -> 0x0035 }
            goto L_0x0060
        L_0x0035:
            r9 = move-exception
            goto L_0x0038
        L_0x0037:
            r9 = move-exception
        L_0x0038:
            java.util.Map r10 = m15445a(r9)
            java.lang.String r0 = "error"
            r2.put(r0, r10)
            r11.reply(r2)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 196(0xc4, float:2.75E-43)
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0060:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15458f(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15456e(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "counponParamsJson"
            java.lang.String r1 = "pageID"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            boolean r3 = r7.containsKey(r1)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001b
            java.lang.Object r1 = r7.get(r1)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            goto L_0x001c
        L_0x001b:
            r1 = r4
        L_0x001c:
            boolean r3 = r7.containsKey(r0)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            r4 = r7
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
        L_0x0029:
            com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$qmUPnOLF0yqsdckP2-4jF11gT3s r7 = new com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$qmUPnOLF0yqsdckP2-4jF11gT3s     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            r6.enterCouponPage(r1, r4, r7)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            goto L_0x005d
        L_0x0032:
            r6 = move-exception
            goto L_0x0035
        L_0x0034:
            r6 = move-exception
        L_0x0035:
            java.util.Map r7 = m15445a(r6)
            java.lang.String r0 = "error"
            r2.put(r0, r7)
            r8.reply(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 219(0xdb, float:3.07E-43)
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15456e(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m15453c(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15454d(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r11, java.lang.Object r12, p242io.flutter.plugin.common.BasicMessageChannel.Reply r13) {
        /*
            java.lang.String r0 = "fromPage"
            java.lang.String r1 = "userPayInfoJson"
            java.lang.String r2 = "userPayGroupJson"
            java.lang.String r3 = "pageID"
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            boolean r5 = r12.containsKey(r3)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x0021
            java.lang.Object r3 = r12.get(r3)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            goto L_0x0022
        L_0x0021:
            r3 = r6
        L_0x0022:
            boolean r5 = r12.containsKey(r2)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            if (r5 == 0) goto L_0x0030
            java.lang.Object r2 = r12.get(r2)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            r7 = r2
            goto L_0x0031
        L_0x0030:
            r7 = r6
        L_0x0031:
            boolean r2 = r12.containsKey(r1)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            if (r2 == 0) goto L_0x003f
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            r8 = r1
            goto L_0x0040
        L_0x003f:
            r8 = r6
        L_0x0040:
            boolean r1 = r12.containsKey(r0)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            if (r1 == 0) goto L_0x004d
            java.lang.Object r12 = r12.get(r0)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            r6 = r12
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
        L_0x004d:
            r9 = r6
            com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$bYlXgv8MSKUrO64BC5DrL5jsdcQ r10 = new com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$bYlXgv8MSKUrO64BC5DrL5jsdcQ     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            r10.<init>(r4, r13)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            r5 = r11
            r6 = r3
            r5.gotoPayMethodPage(r6, r7, r8, r9, r10)     // Catch:{ Error -> 0x005b, RuntimeException -> 0x0059 }
            goto L_0x0084
        L_0x0059:
            r11 = move-exception
            goto L_0x005c
        L_0x005b:
            r11 = move-exception
        L_0x005c:
            java.util.Map r12 = m15445a(r11)
            java.lang.String r0 = "error"
            r4.put(r0, r12)
            r13.reply(r4)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "error: "
            r12.append(r13)
            r12.append(r11)
            java.lang.String r2 = r12.toString()
            r0 = 3
            r3 = 0
            r5 = 243(0xf3, float:3.4E-43)
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15454d(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15451b(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15452c(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "orderInfo"
            java.lang.String r1 = "pageID"
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
            com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$_w-vkIgY7jSKJpIOD78ECXRfMS0 r7 = new com.didi.entrega.uni_entrega_business.bill.-$$Lambda$GLEUniBillNativeModuleServiceRegister$_w-vkIgY7jSKJpIOD78ECXRfMS0     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            r6.gotoTripPage(r1, r4, r7)     // Catch:{ Error -> 0x0035, RuntimeException -> 0x0033 }
            goto L_0x005e
        L_0x0033:
            r6 = move-exception
            goto L_0x0036
        L_0x0035:
            r6 = move-exception
        L_0x0036:
            java.util.Map r7 = m15445a(r6)
            java.lang.String r0 = "error"
            r2.put(r0, r7)
            r8.reply(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "error: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r2 = r7.toString()
            r0 = 3
            r3 = 0
            r5 = 265(0x109, float:3.71E-43)
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15452c(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15448a(Map map, BasicMessageChannel.Reply reply, String str) {
        map.put("result", str);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15449b(GLEUniBillNativeModuleService gLEUniBillNativeModuleService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniBillNativeModuleService.isApplePaySupportedWithNetworks(map.containsKey("supportedNetworks") ? (String) map.get("supportedNetworks") : "", new GLEUniBillNativeModuleService.Result(hashMap, reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    GLEUniBillNativeModuleServiceRegister.m15447a(this.f$0, this.f$1, (Boolean) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m15445a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister", 286);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15447a(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15446a(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "userPayInfoJson"
            java.lang.String r1 = "userPayGroupJson"
            java.lang.String r2 = "pageID"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001f
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            goto L_0x0020
        L_0x001f:
            r2 = r5
        L_0x0020:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            if (r4 == 0) goto L_0x002d
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            goto L_0x002e
        L_0x002d:
            r1 = r5
        L_0x002e:
            boolean r4 = r11.containsKey(r0)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            if (r4 == 0) goto L_0x003b
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
        L_0x003b:
            r10.updatePayListWithPreInterface(r2, r1, r5)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0048, RuntimeException -> 0x0046 }
            goto L_0x0071
        L_0x0046:
            r10 = move-exception
            goto L_0x0049
        L_0x0048:
            r10 = move-exception
        L_0x0049:
            java.util.Map r11 = m15445a(r10)
            java.lang.String r0 = "error"
            r3.put(r0, r11)
            r12.reply(r3)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 310(0x136, float:4.34E-43)
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0071:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleServiceRegister.m15446a(com.didi.entrega.uni_entrega_business.bill.GLEUniBillNativeModuleService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* renamed from: a */
    private static Map<String, Object> m15445a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
