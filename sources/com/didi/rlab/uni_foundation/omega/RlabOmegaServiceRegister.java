package com.didi.rlab.uni_foundation.omega;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class RlabOmegaServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, RlabOmegaService rlabOmegaService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.RlabOmegaService.traceEvent", new StandardMessageCodec());
        if (rlabOmegaService != null) {
            UniAPI.registerModule(rlabOmegaService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    RlabOmegaServiceRegister.m24127b(RlabOmegaService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.RlabOmegaService.trackError", new StandardMessageCodec());
        if (rlabOmegaService != null) {
            UniAPI.registerModule(rlabOmegaService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    RlabOmegaServiceRegister.m24126a(RlabOmegaService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24127b(RlabOmegaService rlabOmegaService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            rlabOmegaService.traceEvent(map.containsKey("model") ? EventTrackerModel.fromMap((Map) map.get("model")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.omega.RlabOmegaServiceRegister", 33);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24126a(RlabOmegaService rlabOmegaService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            rlabOmegaService.trackError(map.containsKey("model") ? ErrorTrackerModel.fromMap((Map) map.get("model")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.omega.RlabOmegaServiceRegister", 55);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24125a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
