package com.didi.entrega.uni_entrega_business.map;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniMapServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniMapService gLEUniMapService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniMapService.updateBillMapWithBillAddressInfo", new StandardMessageCodec());
        if (gLEUniMapService != null) {
            UniAPI.registerModule(gLEUniMapService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniMapServiceRegister.m15485c(GLEUniMapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniMapService.removeMapMarker", new StandardMessageCodec());
        if (gLEUniMapService != null) {
            UniAPI.registerModule(gLEUniMapService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniMapServiceRegister.m15484b(GLEUniMapService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniMapService.mapBestRectEdgeBottom", new StandardMessageCodec());
        if (gLEUniMapService != null) {
            UniAPI.registerModule(gLEUniMapService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniMapServiceRegister.m15483a(GLEUniMapService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m15485c(com.didi.entrega.uni_entrega_business.map.GLEUniMapService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "pageID"
            java.lang.String r1 = "addressInfoJson"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            boolean r3 = r10.containsKey(r1)     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001b
            java.lang.Object r1 = r10.get(r1)     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            goto L_0x001c
        L_0x001b:
            r1 = r4
        L_0x001c:
            boolean r3 = r10.containsKey(r0)     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            if (r3 == 0) goto L_0x0029
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
        L_0x0029:
            r9.updateBillMapWithBillAddressInfo(r1, r4)     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0036, RuntimeException -> 0x0034 }
            goto L_0x005f
        L_0x0034:
            r9 = move-exception
            goto L_0x0037
        L_0x0036:
            r9 = move-exception
        L_0x0037:
            java.util.Map r10 = m15482a(r9)
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
            r8 = 35
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.entrega.uni_entrega_business.map.GLEUniMapServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x005f:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.uni_entrega_business.map.GLEUniMapServiceRegister.m15485c(com.didi.entrega.uni_entrega_business.map.GLEUniMapService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15484b(GLEUniMapService gLEUniMapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniMapService.removeMapMarker(map.containsKey("pageID") ? (String) map.get("pageID") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m15482a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.map.GLEUniMapServiceRegister", 58);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15483a(GLEUniMapService gLEUniMapService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("topViewHeight") ? ((Double) map.get("topViewHeight")).doubleValue() : 0.0d;
            if (map.containsKey("bottomViewHeight")) {
                d = ((Double) map.get("bottomViewHeight")).doubleValue();
            }
            gLEUniMapService.mapBestRectEdgeBottom(doubleValue, d, map.containsKey("pageID") ? (String) map.get("pageID") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m15482a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.map.GLEUniMapServiceRegister", 83);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m15482a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
