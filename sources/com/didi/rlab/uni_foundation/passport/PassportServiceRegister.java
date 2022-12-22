package com.didi.rlab.uni_foundation.passport;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class PassportServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, PassportService passportService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.login", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24142h(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.resetPhoneNumber", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24141g(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.resetPassword", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24140f(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.deleteAccount", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24139e(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.resetEmail", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24138d(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.logout", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24137c(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.syncPassportInfo", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24136b(PassportService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.PassportService.getPassportInfo", new StandardMessageCodec());
        if (passportService != null) {
            UniAPI.registerModule(passportService);
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PassportServiceRegister.m24135a(PassportService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static /* synthetic */ void m24142h(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.login();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 32);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m24141g(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.resetPhoneNumber();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 53);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m24140f(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.resetPassword();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 74);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m24139e(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.deleteAccount();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 95);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24138d(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.resetEmail();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 116);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24137c(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.logout();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 137);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24136b(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            passportService.syncPassportInfo(map.containsKey("user") ? PassportInfo.fromMap((Map) map.get("user")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 159);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24135a(PassportService passportService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            PassportInfo passportInfo = passportService.getPassportInfo();
            hashMap.put("result", passportInfo != null ? passportInfo.toMap() : null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.passport.PassportServiceRegister", 180);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24134a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
