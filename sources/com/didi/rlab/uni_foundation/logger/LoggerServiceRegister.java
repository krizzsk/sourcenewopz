package com.didi.rlab.uni_foundation.logger;

import com.didi.rlab.uni_foundation.UniAPI;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class LoggerServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, LoggerService loggerService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LoggerService.debug", new StandardMessageCodec());
        if (loggerService != null) {
            UniAPI.registerModule(loggerService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LoggerServiceRegister.m24071d(LoggerService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LoggerService.info", new StandardMessageCodec());
        if (loggerService != null) {
            UniAPI.registerModule(loggerService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LoggerServiceRegister.m24070c(LoggerService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LoggerService.error", new StandardMessageCodec());
        if (loggerService != null) {
            UniAPI.registerModule(loggerService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LoggerServiceRegister.m24069b(LoggerService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LoggerService.warn", new StandardMessageCodec());
        if (loggerService != null) {
            UniAPI.registerModule(loggerService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LoggerServiceRegister.m24068a(LoggerService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24071d(com.didi.rlab.uni_foundation.logger.LoggerService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "path"
            java.lang.String r1 = "log"
            java.lang.String r2 = "tag"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x002b
        L_0x002a:
            r1 = r5
        L_0x002b:
            boolean r4 = r11.containsKey(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x0038
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
        L_0x0038:
            r10.debug(r2, r1, r5)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x0061
        L_0x0042:
            r10 = move-exception
            goto L_0x0045
        L_0x0044:
            r10 = move-exception
        L_0x0045:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 35
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.rlab.uni_foundation.logger.LoggerServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0061:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.logger.LoggerServiceRegister.m24071d(com.didi.rlab.uni_foundation.logger.LoggerService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24070c(com.didi.rlab.uni_foundation.logger.LoggerService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "path"
            java.lang.String r1 = "log"
            java.lang.String r2 = "tag"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x002b
        L_0x002a:
            r1 = r5
        L_0x002b:
            boolean r4 = r11.containsKey(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x0038
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
        L_0x0038:
            r10.info(r2, r1, r5)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x0061
        L_0x0042:
            r10 = move-exception
            goto L_0x0045
        L_0x0044:
            r10 = move-exception
        L_0x0045:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 59
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.rlab.uni_foundation.logger.LoggerServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0061:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.logger.LoggerServiceRegister.m24070c(com.didi.rlab.uni_foundation.logger.LoggerService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24069b(com.didi.rlab.uni_foundation.logger.LoggerService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "path"
            java.lang.String r1 = "log"
            java.lang.String r2 = "tag"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x002b
        L_0x002a:
            r1 = r5
        L_0x002b:
            boolean r4 = r11.containsKey(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x0038
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
        L_0x0038:
            r10.error(r2, r1, r5)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x0061
        L_0x0042:
            r10 = move-exception
            goto L_0x0045
        L_0x0044:
            r10 = move-exception
        L_0x0045:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 83
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.rlab.uni_foundation.logger.LoggerServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0061:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.logger.LoggerServiceRegister.m24069b(com.didi.rlab.uni_foundation.logger.LoggerService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void m24068a(com.didi.rlab.uni_foundation.logger.LoggerService r10, java.lang.Object r11, p242io.flutter.plugin.common.BasicMessageChannel.Reply r12) {
        /*
            java.lang.String r0 = "path"
            java.lang.String r1 = "log"
            java.lang.String r2 = "tag"
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            boolean r4 = r11.containsKey(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x001c
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x001d
        L_0x001c:
            r2 = r5
        L_0x001d:
            boolean r4 = r11.containsKey(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x002a
            java.lang.Object r1 = r11.get(r1)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x002b
        L_0x002a:
            r1 = r5
        L_0x002b:
            boolean r4 = r11.containsKey(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            if (r4 == 0) goto L_0x0038
            java.lang.Object r11 = r11.get(r0)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            r5 = r11
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
        L_0x0038:
            r10.warn(r2, r1, r5)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            java.lang.String r10 = "result"
            r11 = 0
            r3.put(r10, r11)     // Catch:{ Error -> 0x0044, RuntimeException -> 0x0042 }
            goto L_0x0061
        L_0x0042:
            r10 = move-exception
            goto L_0x0045
        L_0x0044:
            r10 = move-exception
        L_0x0045:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "error: "
            r11.append(r0)
            r11.append(r10)
            java.lang.String r6 = r11.toString()
            r4 = 3
            r7 = 0
            r9 = 107(0x6b, float:1.5E-43)
            java.lang.String r5 = "flutter"
            java.lang.String r8 = "com.didi.rlab.uni_foundation.logger.LoggerServiceRegister"
            com.didi.sdk.apm.SystemUtils.log(r4, r5, r6, r7, r8, r9)
        L_0x0061:
            r12.reply(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rlab.uni_foundation.logger.LoggerServiceRegister.m24068a(com.didi.rlab.uni_foundation.logger.LoggerService, java.lang.Object, io.flutter.plugin.common.BasicMessageChannel$Reply):void");
    }

    /* renamed from: a */
    private static Map<String, Object> m24067a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
