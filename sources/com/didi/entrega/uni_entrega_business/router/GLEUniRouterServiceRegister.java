package com.didi.entrega.uni_entrega_business.router;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniRouterServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniRouterService gLEUniRouterService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniRouterService.openDIDIRouterPage", new StandardMessageCodec());
        if (gLEUniRouterService != null) {
            UniAPI.registerModule(gLEUniRouterService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniRouterServiceRegister.m15507a(GLEUniRouterService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15507a(GLEUniRouterService gLEUniRouterService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniRouterService.openDIDIRouterPage(map.containsKey("url") ? (String) map.get("url") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.router.GLEUniRouterServiceRegister", 33);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m15506a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
