package com.didi.rlab.uni_foundation.apollo;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.apollo.model.ApolloModel;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class ApolloServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, ApolloService apolloService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.ApolloService.fetchApolloData", new StandardMessageCodec());
        if (apolloService != null) {
            UniAPI.registerModule(apolloService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    ApolloServiceRegister.m24023a(ApolloService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24023a(ApolloService apolloService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            ApolloModel fetchApolloData = apolloService.fetchApolloData(map.containsKey("name") ? (String) map.get("name") : "");
            hashMap.put("result", fetchApolloData != null ? fetchApolloData.toMap() : null);
        } catch (Error | RuntimeException e) {
            hashMap.put("error", m24022a(e));
            reply.reply(hashMap);
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.apollo.ApolloServiceRegister", 35);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24022a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
