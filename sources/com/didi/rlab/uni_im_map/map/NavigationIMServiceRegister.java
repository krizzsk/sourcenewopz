package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class NavigationIMServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, NavigationIMService navigationIMService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.startMapNavigation", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24205l(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.setNavigationPadding", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24204k(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.closeMapNavigation", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24203j(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.setMapNavigationRecenter", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24202i(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.setMapNavigationBestView", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24201h(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.setMapNavigationOverView", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24200g(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.openMapOutAppNavigation", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24199f(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.gotoDownloadMapApp", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24198e(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.selectNavigationType", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24197d(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.canNavGoogle", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24196c(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.canNavWaze", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24195b(NavigationIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.NavigationIMService.getUserSettingNavigationType", new StandardMessageCodec());
        if (navigationIMService != null) {
            UniAPI.registerModule(navigationIMService);
            basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    NavigationIMServiceRegister.m24194a(NavigationIMService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static /* synthetic */ void m24205l(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat") ? ((Double) map.get("lat")).doubleValue() : 0.0d;
            if (map.containsKey("lng")) {
                d = ((Double) map.get("lng")).doubleValue();
            }
            navigationIMService.startMapNavigation(doubleValue, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 34);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static /* synthetic */ void m24204k(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("top") ? ((Double) map.get("top")).doubleValue() : 0.0d;
            double doubleValue2 = map.containsKey("left") ? ((Double) map.get("left")).doubleValue() : 0.0d;
            double doubleValue3 = map.containsKey("bottom") ? ((Double) map.get("bottom")).doubleValue() : 0.0d;
            if (map.containsKey("right")) {
                d = ((Double) map.get("right")).doubleValue();
            }
            navigationIMService.setNavigationPadding(doubleValue, doubleValue2, doubleValue3, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 59);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static /* synthetic */ void m24203j(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            navigationIMService.closeMapNavigation();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 80);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static /* synthetic */ void m24202i(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            navigationIMService.setMapNavigationRecenter();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 101);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static /* synthetic */ void m24201h(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            navigationIMService.setMapNavigationBestView();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 122);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m24200g(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            navigationIMService.setMapNavigationOverView();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 143);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m24199f(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat") ? ((Double) map.get("lat")).doubleValue() : 0.0d;
            if (map.containsKey("lng")) {
                d = ((Double) map.get("lng")).doubleValue();
            }
            navigationIMService.openMapOutAppNavigation(doubleValue, d, map.containsKey("directionsMode") ? (String) map.get("directionsMode") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 167);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m24198e(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            navigationIMService.gotoDownloadMapApp(map.containsKey("type") ? ((Number) map.get("type")).longValue() : 0);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 189);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24197d(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            navigationIMService.selectNavigationType(map.containsKey("type") ? ((Number) map.get("type")).longValue() : 0);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 211);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24196c(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Boolean.valueOf(navigationIMService.canNavGoogle()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 232);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24195b(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Boolean.valueOf(navigationIMService.canNavWaze()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 253);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24194a(NavigationIMService navigationIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Long.valueOf(navigationIMService.getUserSettingNavigationType()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.NavigationIMServiceRegister", 274);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24193a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
