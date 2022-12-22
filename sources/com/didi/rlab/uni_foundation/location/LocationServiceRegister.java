package com.didi.rlab.uni_foundation.location;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class LocationServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, LocationService locationService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LocationService.checkLocationPermissions", new StandardMessageCodec());
        if (locationService != null) {
            UniAPI.registerModule(locationService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LocationServiceRegister.m24066c(LocationService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LocationService.getCurrentLocation", new StandardMessageCodec());
        if (locationService != null) {
            UniAPI.registerModule(locationService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LocationServiceRegister.m24065b(LocationService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.LocationService.distanceBetween", new StandardMessageCodec());
        if (locationService != null) {
            UniAPI.registerModule(locationService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    LocationServiceRegister.m24064a(LocationService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24066c(LocationService locationService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            locationService.checkLocationPermissions();
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.location.LocationServiceRegister", 32);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24065b(LocationService locationService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            LocationResult currentLocation = locationService.getCurrentLocation();
            hashMap.put("result", currentLocation != null ? currentLocation.toMap() : null);
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.location.LocationServiceRegister", 53);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24064a(LocationService locationService, Object obj, BasicMessageChannel.Reply reply) {
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
            hashMap.put("result", Double.valueOf(locationService.distanceBetween(doubleValue, doubleValue2, doubleValue3, d)));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.location.LocationServiceRegister", 78);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24063a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
