package com.didi.rlab.uni_foundation.heatmap;

import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.app.constant.Const;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class MapElementServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, MapElementService mapElementService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.drawPolygon", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24045i(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.drawLine", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24044h(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.drawMarkerBubble", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24043g(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.setFocusCenter", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24042f(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.getShapePoints", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24041e(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.removePolygon", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24040d(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.removeLine", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24039c(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.removeMarker", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24038b(MapElementService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.MapElementService.removeAll", new StandardMessageCodec());
        if (mapElementService != null) {
            UniAPI.registerModule(mapElementService);
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    MapElementServiceRegister.m24037a(MapElementService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel9.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public static /* synthetic */ void m24045i(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.drawPolygon(map.containsKey("data") ? PolygonModel.fromMap((Map) map.get("data")) : null, map.containsKey("tag") ? (String) map.get("tag") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 34);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public static /* synthetic */ void m24044h(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.drawLine(map.containsKey("data") ? LineModel.fromMap((Map) map.get("data")) : null, map.containsKey("tag") ? (String) map.get("tag") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 57);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public static /* synthetic */ void m24043g(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            MapMarkerOptions fromMap = map.containsKey(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS) ? MapMarkerOptions.fromMap((Map) map.get(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS)) : null;
            MapMarkerBubble fromMap2 = map.containsKey(Const.BUBBLE) ? MapMarkerBubble.fromMap((Map) map.get(Const.BUBBLE)) : null;
            double d = 0.0d;
            double doubleValue = map.containsKey(Const.PageParams.LATITUDE) ? ((Double) map.get(Const.PageParams.LATITUDE)).doubleValue() : 0.0d;
            if (map.containsKey(Const.PageParams.LONGITUDE)) {
                d = ((Double) map.get(Const.PageParams.LONGITUDE)).doubleValue();
            }
            mapElementService.drawMarkerBubble(fromMap, fromMap2, doubleValue, d, map.containsKey("tag") ? (String) map.get("tag") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 83);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m24042f(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.setFocusCenter(map.containsKey("data") ? LineModel.fromMap((Map) map.get("data")) : null);
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 105);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m24041e(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            PositionModel shapePoints = mapElementService.getShapePoints(map.containsKey("areaId") ? (String) map.get("areaId") : "");
            hashMap.put("result", shapePoints != null ? shapePoints.toMap() : null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 127);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24040d(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.removePolygon(map.containsKey("tag") ? (String) map.get("tag") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 149);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24039c(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.removeLine(map.containsKey("tag") ? (String) map.get("tag") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 171);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24038b(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.removeMarker(map.containsKey("tag") ? (String) map.get("tag") : "");
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 193);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24037a(MapElementService mapElementService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            mapElementService.removeAll();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.heatmap.MapElementServiceRegister", 214);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24036a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
