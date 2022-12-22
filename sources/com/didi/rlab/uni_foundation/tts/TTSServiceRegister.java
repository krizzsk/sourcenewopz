package com.didi.rlab.uni_foundation.tts;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.tts.TTSService;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.LogFactory;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class TTSServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, TTSService tTSService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.TTSService.playText", new StandardMessageCodec());
        if (tTSService != null) {
            UniAPI.registerModule(tTSService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    TTSServiceRegister.m24160d(TTSService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.TTSService.playFile", new StandardMessageCodec());
        if (tTSService != null) {
            UniAPI.registerModule(tTSService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    TTSServiceRegister.m24159c(TTSService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.TTSService.stopPlayingAudio", new StandardMessageCodec());
        if (tTSService != null) {
            UniAPI.registerModule(tTSService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    TTSServiceRegister.m24157b(TTSService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.TTSService.playVibrate", new StandardMessageCodec());
        if (tTSService != null) {
            UniAPI.registerModule(tTSService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    TTSServiceRegister.m24155a(TTSService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24160d(TTSService tTSService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            String str = map.containsKey("text") ? (String) map.get("text") : "";
            long j = 0;
            long longValue = map.containsKey("time") ? ((Number) map.get("time")).longValue() : 0;
            if (map.containsKey(LogFactory.PRIORITY_KEY)) {
                j = ((Number) map.get(LogFactory.PRIORITY_KEY)).longValue();
            }
            tTSService.playText(str, longValue, j, new TTSService.Result(hashMap, reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    TTSServiceRegister.m24158b(this.f$0, this.f$1, (Long) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m24154a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.tts.TTSServiceRegister", 35);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24158b(Map map, BasicMessageChannel.Reply reply, Long l) {
        map.put("result", l);
        reply.reply(map);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24159c(com.didi.rlab.uni_foundation.tts.TTSService r13, java.lang.Object r14, p242io.flutter.plugin.common.BasicMessageChannel.Reply r15) {
        /*
            java.lang.String r0 = "priority"
            java.lang.String r1 = "backUpText"
            java.lang.String r2 = "time"
            java.lang.String r3 = "file"
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            boolean r5 = r14.containsKey(r3)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x001e
            java.lang.Object r3 = r14.get(r3)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            goto L_0x001f
        L_0x001e:
            r3 = r6
        L_0x001f:
            boolean r5 = r14.containsKey(r2)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            r7 = 0
            if (r5 == 0) goto L_0x0032
            java.lang.Object r2 = r14.get(r2)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            java.lang.Number r2 = (java.lang.Number) r2     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            long r9 = r2.longValue()     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            goto L_0x0033
        L_0x0032:
            r9 = r7
        L_0x0033:
            boolean r2 = r14.containsKey(r1)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r1 = r14.get(r1)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
        L_0x0040:
            r1 = r6
            boolean r2 = r14.containsKey(r0)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            if (r2 == 0) goto L_0x0053
            java.lang.Object r14 = r14.get(r0)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            java.lang.Number r14 = (java.lang.Number) r14     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            long r5 = r14.longValue()     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            r11 = r5
            goto L_0x0054
        L_0x0053:
            r11 = r7
        L_0x0054:
            com.didi.rlab.uni_foundation.tts.-$$Lambda$TTSServiceRegister$rbe2eR6pehmoecJOYiBWMSEwTeA r14 = new com.didi.rlab.uni_foundation.tts.-$$Lambda$TTSServiceRegister$rbe2eR6pehmoecJOYiBWMSEwTeA     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            r14.<init>(r4, r15)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            r5 = r13
            r6 = r3
            r7 = r9
            r9 = r1
            r10 = r11
            r12 = r14
            r5.playFile(r6, r7, r9, r10, r12)     // Catch:{ Error -> 0x0065, RuntimeException -> 0x0063 }
            goto L_0x008e
        L_0x0063:
            r13 = move-exception
            goto L_0x0066
        L_0x0065:
            r13 = move-exception
        L_0x0066:
            java.util.Map r14 = m24154a(r13)
            java.lang.String r0 = "error"
            r4.put(r0, r14)
            r15.reply(r4)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "error: "
            r14.append(r15)
            r14.append(r13)
            java.lang.String r2 = r14.toString()
            r0 = 3
            r3 = 0
            r5 = 59
            java.lang.String r1 = "flutter"
            java.lang.String r4 = "com.didi.rlab.uni_foundation.tts.TTSServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.tts.TTSServiceRegister.m24159c(com.didi.rlab.uni_foundation.tts.TTSService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24156a(Map map, BasicMessageChannel.Reply reply, Long l) {
        map.put("result", l);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24157b(TTSService tTSService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            tTSService.stopPlayingAudio();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m24154a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.tts.TTSServiceRegister", 80);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24155a(TTSService tTSService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            tTSService.playVibrate();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.tts.TTSServiceRegister", 101);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24154a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
