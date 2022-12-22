package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class IMMapLogServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, IMMapLogService iMMapLogService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.IMMapLogService.pHandleLogger", new StandardMessageCodec());
        if (iMMapLogService != null) {
            UniAPI.registerModule(iMMapLogService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    IMMapLogServiceRegister.m24164a(IMMapLogService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24164a(IMMapLogService iMMapLogService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            iMMapLogService.pHandleLogger(map.containsKey("level") ? (String) map.get("level") : "", map.containsKey("param") ? (Map) map.get("param") : new HashMap());
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.IMMapLogServiceRegister", 34);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24163a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
