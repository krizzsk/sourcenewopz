package com.didi.rlab.uni_foundation.wsg;

import com.didi.rlab.uni_foundation.UniAPI;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class WSGServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, WSGService wSGService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.WSGService.send", new StandardMessageCodec());
        if (wSGService != null) {
            UniAPI.registerModule(wSGService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    WSGServiceRegister.m24162a(WSGService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24162a(com.didi.rlab.uni_foundation.wsg.WSGService r9, java.lang.Object r10, p242io.flutter.plugin.common.BasicMessageChannel.Reply r11) {
        /*
            java.lang.String r0 = "eventData"
            java.lang.String r1 = "eventType"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            boolean r3 = r10.containsKey(r1)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001a
            java.lang.Object r1 = r10.get(r1)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            goto L_0x001b
        L_0x001a:
            r1 = r4
        L_0x001b:
            boolean r3 = r10.containsKey(r0)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            if (r3 == 0) goto L_0x0028
            java.lang.Object r10 = r10.get(r0)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
        L_0x0028:
            r9.send(r1, r4)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            java.lang.String r9 = "result"
            r10 = 0
            r2.put(r9, r10)     // Catch:{ Error -> 0x0034, RuntimeException -> 0x0032 }
            goto L_0x0051
        L_0x0032:
            r9 = move-exception
            goto L_0x0035
        L_0x0034:
            r9 = move-exception
        L_0x0035:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "error: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r5 = r10.toString()
            r3 = 3
            r6 = 0
            r8 = 34
            java.lang.String r4 = "flutter"
            java.lang.String r7 = "com.didi.rlab.uni_foundation.wsg.WSGServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x0051:
            r11.reply(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.wsg.WSGServiceRegister.m24162a(com.didi.rlab.uni_foundation.wsg.WSGService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* renamed from: a */
    private static Map<String, Object> m24161a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
