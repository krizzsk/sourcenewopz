package com.didi.rlab.uni_foundation.p143im;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.rlab.uni_foundation.p143im.IMService;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

/* renamed from: com.didi.rlab.uni_foundation.im.IMServiceRegister */
public class IMServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, IMService iMService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.IMService.sendMessage", new StandardMessageCodec());
        if (iMService != null) {
            UniAPI.registerModule(iMService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    IMServiceRegister.m24060e(IMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.IMService.getUnreadCount", new StandardMessageCodec());
        if (iMService != null) {
            UniAPI.registerModule(iMService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    IMServiceRegister.m24059d(IMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.IMService.getAllUnreadCount", new StandardMessageCodec());
        if (iMService != null) {
            UniAPI.registerModule(iMService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    IMServiceRegister.m24058c(IMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.IMService.openChat", new StandardMessageCodec());
        if (iMService != null) {
            UniAPI.registerModule(iMService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    IMServiceRegister.m24056b(IMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.IMService.closeChat", new StandardMessageCodec());
        if (iMService != null) {
            UniAPI.registerModule(iMService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    IMServiceRegister.m24053a(IMService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m24060e(IMService iMService, Object obj, BasicMessageChannel.Reply reply) {
        try {
            Map map = (Map) obj;
            iMService.sendMessage(map.containsKey("param") ? (Map) map.get("param") : new HashMap(), new IMService.Result(new HashMap(), reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    IMServiceRegister.m24054a(this.f$0, this.f$1, (Boolean) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.im.IMServiceRegister", 32);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24054a(Map map, BasicMessageChannel.Reply reply, Boolean bool) {
        map.put("result", bool);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24059d(IMService iMService, Object obj, BasicMessageChannel.Reply reply) {
        try {
            Map map = (Map) obj;
            iMService.getUnreadCount(map.containsKey("param") ? (Map) map.get("param") : new HashMap(), new IMService.Result(new HashMap(), reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    IMServiceRegister.m24057b(this.f$0, this.f$1, (Long) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.im.IMServiceRegister", 52);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24057b(Map map, BasicMessageChannel.Reply reply, Long l) {
        map.put("result", l);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24058c(IMService iMService, Object obj, BasicMessageChannel.Reply reply) {
        try {
            Map map = (Map) obj;
            iMService.getAllUnreadCount(map.containsKey("param") ? (Map) map.get("param") : new HashMap(), new IMService.Result(new HashMap(), reply) {
                public final /* synthetic */ Map f$0;
                public final /* synthetic */ BasicMessageChannel.Reply f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void success(Object obj) {
                    IMServiceRegister.m24055a(this.f$0, this.f$1, (Long) obj);
                }
            });
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.im.IMServiceRegister", 72);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24055a(Map map, BasicMessageChannel.Reply reply, Long l) {
        map.put("result", l);
        reply.reply(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24056b(IMService iMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            iMService.openChat(map.containsKey("param") ? (Map) map.get("param") : new HashMap());
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.im.IMServiceRegister", 93);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24053a(IMService iMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            iMService.closeChat(map.containsKey("param") ? (Map) map.get("param") : new HashMap());
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.im.IMServiceRegister", 115);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24052a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
