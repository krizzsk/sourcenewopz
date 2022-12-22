package com.didi.entrega.uni_entrega_business.login;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.login.GLEUniLoginService;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniLoginServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniLoginService gLEUniLoginService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniLoginService.isLogin", new StandardMessageCodec());
        if (gLEUniLoginService != null) {
            UniAPI.registerModule(gLEUniLoginService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniLoginServiceRegister.m15481c(GLEUniLoginService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniLoginService.logout", new StandardMessageCodec());
        if (gLEUniLoginService != null) {
            UniAPI.registerModule(gLEUniLoginService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniLoginServiceRegister.m15480b(GLEUniLoginService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniLoginService.login", new StandardMessageCodec());
        if (gLEUniLoginService != null) {
            UniAPI.registerModule(gLEUniLoginService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniLoginServiceRegister.m15478a(GLEUniLoginService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m15481c(GLEUniLoginService gLEUniLoginService, Object obj, BasicMessageChannel.Reply reply) {
        try {
            Map map = (Map) obj;
            gLEUniLoginService.isLogin(new GLEUniLoginService.Result(new HashMap(), reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    GLEUniLoginServiceRegister.m15479a(this.f$0, this.f$1, (Boolean) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.login.GLEUniLoginServiceRegister", 31);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15479a(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m15480b(GLEUniLoginService gLEUniLoginService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniLoginService.logout(map.containsKey("reasion") ? (String) map.get("reasion") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.login.GLEUniLoginServiceRegister", 52);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15478a(GLEUniLoginService gLEUniLoginService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniLoginService.login(map.containsKey("type") ? ((Number) map.get("type")).longValue() : 0);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m15477a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.login.GLEUniLoginServiceRegister", 75);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m15477a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
