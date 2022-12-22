package com.didi.rlab.uni_foundation.diface;

import com.didi.rlab.uni_foundation.UniAPI;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class DiFaceServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, DiFaceService diFaceService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DiFaceService.startDiFaceRecognition", new StandardMessageCodec());
        if (diFaceService != null) {
            UniAPI.registerModule(diFaceService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DiFaceServiceRegister.m24032a(DiFaceService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24032a(com.didi.rlab.uni_foundation.diface.DiFaceService r6, java.lang.Object r7, p242io.flutter.plugin.common.BasicMessageChannel.Reply r8) {
        /*
            java.lang.String r0 = "bizCode"
            java.lang.String r1 = "sessionID"
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            boolean r3 = r7.containsKey(r1)     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x001a
            java.lang.Object r1 = r7.get(r1)     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            goto L_0x001b
        L_0x001a:
            r1 = r4
        L_0x001b:
            boolean r3 = r7.containsKey(r0)     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            if (r3 == 0) goto L_0x0028
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            r4 = r7
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
        L_0x0028:
            com.didi.rlab.uni_foundation.diface.-$$Lambda$DiFaceServiceRegister$khYCam46HA0-mug0VNG3j2fPC-E r7 = new com.didi.rlab.uni_foundation.diface.-$$Lambda$DiFaceServiceRegister$khYCam46HA0-mug0VNG3j2fPC-E     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            r7.<init>(r2, r8)     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            r6.startDiFaceRecognition(r1, r4, r7)     // Catch:{ Error -> 0x0033, RuntimeException -> 0x0031 }
            goto L_0x0050
        L_0x0031:
            r6 = move-exception
            goto L_0x0034
        L_0x0033:
            r6 = move-exception
        L_0x0034:
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
            java.lang.String r4 = "com.didi.rlab.uni_foundation.diface.DiFaceServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.diface.DiFaceServiceRegister.m24032a(com.didi.rlab.uni_foundation.diface.DiFaceService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24033a(Map map, BasicMessageChannel.Reply reply, Map map2) {
        map.put("result", map2);
        reply.reply(map);
    }

    /* renamed from: a */
    private static Map<String, Object> m24031a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
