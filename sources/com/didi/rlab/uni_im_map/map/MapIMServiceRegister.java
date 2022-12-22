package com.didi.rlab.uni_im_map.map;

import com.didi.rlab.uni_im_map.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class MapIMServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, MapIMService mapIMService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.sendMapIMLocation", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24192l(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.setMapIMRecenter", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24191k(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.startOverView", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24190j(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.setCamera", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24189i(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.setMapIMPadding", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24188h(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.setMapIMDropMarker", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24187g(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.notHandleMapEvents", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24186f(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.distanceBetween", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24185e(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.startPoiRequest", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24184d(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.getCustomerOrderInfo", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24183c(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel10.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.closeImMapPage", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24182b(MapIMService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel11.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapIMService.getLocationInfo", new StandardMessageCodec());
        if (mapIMService != null) {
            UniAPI.registerModule(mapIMService);
            basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapIMServiceRegister.m24181a(MapIMService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel12.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static /* synthetic */ void m24192l(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapIMService.sendMapIMLocation(map.containsKey("markerInfo") ? IMMapMarkerBubble.fromMap((Map) map.get("markerInfo")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 33);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static /* synthetic */ void m24191k(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapIMService.setMapIMRecenter();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 54);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public static /* synthetic */ void m24190j(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat") ? ((Double) map.get("lat")).doubleValue() : 0.0d;
            if (map.containsKey("lng")) {
                d = ((Double) map.get("lng")).doubleValue();
            }
            mapIMService.startOverView(doubleValue, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 77);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static /* synthetic */ void m24189i(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat") ? ((Double) map.get("lat")).doubleValue() : 0.0d;
            if (map.containsKey("lng")) {
                d = ((Double) map.get("lng")).doubleValue();
            }
            mapIMService.setCamera(doubleValue, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 100);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static /* synthetic */ void m24188h(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
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
            mapIMService.setMapIMPadding(doubleValue, doubleValue2, doubleValue3, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 125);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m24187g(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapIMService.setMapIMDropMarker(map.containsKey("marker") ? IMMapMarkerBubble.fromMap((Map) map.get("marker")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 147);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m24186f(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapIMService.notHandleMapEvents(map.containsKey("handling") ? ((Boolean) map.get("handling")).booleanValue() : false);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 169);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m24185e(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat1") ? ((Double) map.get("lat1")).doubleValue() : 0.0d;
            double doubleValue2 = map.containsKey("lng1") ? ((Double) map.get("lng1")).doubleValue() : 0.0d;
            double doubleValue3 = map.containsKey("lat2") ? ((Double) map.get("lat2")).doubleValue() : 0.0d;
            if (map.containsKey("lng2")) {
                d = ((Double) map.get("lng2")).doubleValue();
            }
            hashMap.put("result", Double.valueOf(mapIMService.distanceBetween(doubleValue, doubleValue2, doubleValue3, d)));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 194);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24184d(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            double d = 0.0d;
            double doubleValue = map.containsKey("lat") ? ((Double) map.get("lat")).doubleValue() : 0.0d;
            if (map.containsKey("lng")) {
                d = ((Double) map.get("lng")).doubleValue();
            }
            mapIMService.startPoiRequest(doubleValue, d);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 217);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24183c(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapIMService.getCustomerOrderInfo(map.containsKey("orderId") ? (String) map.get("orderId") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 239);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24182b(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapIMService.closeImMapPage();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 260);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24181a(MapIMService mapIMService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            IMLocationResult locationInfo = mapIMService.getLocationInfo();
            hashMap.put("result", locationInfo != null ? locationInfo.toMap() : null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_im_map.map.MapIMServiceRegister", 281);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24180a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
