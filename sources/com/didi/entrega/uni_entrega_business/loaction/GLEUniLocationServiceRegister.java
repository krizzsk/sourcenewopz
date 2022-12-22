package com.didi.entrega.uni_entrega_business.loaction;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniLocationServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniLocationService gLEUniLocationService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniLocationService.updateCityPoi", new StandardMessageCodec());
        if (gLEUniLocationService != null) {
            UniAPI.registerModule(gLEUniLocationService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniLocationServiceRegister.m15476a(GLEUniLocationService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15476a(GLEUniLocationService gLEUniLocationService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniLocationService.updateCityPoi(map.containsKey("poiInfo") ? (Map) map.get("poiInfo") : new HashMap());
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.loaction.GLEUniLocationServiceRegister", 33);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m15475a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
