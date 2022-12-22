package com.didi.entrega.uni_entrega_business.common;

import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class GLEUniCommonServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, GLEUniCommonService gLEUniCommonService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.GLEUniCommonService.showToast", new StandardMessageCodec());
        if (gLEUniCommonService != null) {
            UniAPI.registerModule(gLEUniCommonService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    GLEUniCommonServiceRegister.m15467a(GLEUniCommonService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m15467a(GLEUniCommonService gLEUniCommonService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            gLEUniCommonService.showToast(map.containsKey("msg") ? (String) map.get("msg") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.entrega.uni_entrega_business.common.GLEUniCommonServiceRegister", 33);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m15466a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
