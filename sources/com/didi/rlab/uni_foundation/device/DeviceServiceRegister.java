package com.didi.rlab.uni_foundation.device;

import com.didi.rlab.uni_foundation.UniAPI;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.StandardMessageCodec;

public class DeviceServiceRegister {
    public static void setup(BinaryMessenger binaryMessenger, DeviceService deviceService) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DeviceService.outputVolume", new StandardMessageCodec());
        if (deviceService != null) {
            UniAPI.registerModule(deviceService);
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DeviceServiceRegister.m24030f(DeviceService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DeviceService.batteryLevel", new StandardMessageCodec());
        if (deviceService != null) {
            UniAPI.registerModule(deviceService);
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DeviceServiceRegister.m24029e(DeviceService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DeviceService.model", new StandardMessageCodec());
        if (deviceService != null) {
            UniAPI.registerModule(deviceService);
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DeviceServiceRegister.m24028d(DeviceService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DeviceService.brand", new StandardMessageCodec());
        if (deviceService != null) {
            UniAPI.registerModule(deviceService);
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DeviceServiceRegister.m24027c(DeviceService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DeviceService.screenWidth", new StandardMessageCodec());
        if (deviceService != null) {
            UniAPI.registerModule(deviceService);
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DeviceServiceRegister.m24026b(DeviceService.this, obj, reply);
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "com.didi.rlab.uni_api.DeviceService.screenHeight", new StandardMessageCodec());
        if (deviceService != null) {
            UniAPI.registerModule(deviceService);
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() {
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    DeviceServiceRegister.m24025a(DeviceService.this, obj, reply);
                }
            });
            return;
        }
        basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ void m24030f(DeviceService deviceService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Double.valueOf(deviceService.outputVolume()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.device.DeviceServiceRegister", 32);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ void m24029e(DeviceService deviceService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Double.valueOf(deviceService.batteryLevel()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.device.DeviceServiceRegister", 53);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m24028d(DeviceService deviceService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", deviceService.model());
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.device.DeviceServiceRegister", 74);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ void m24027c(DeviceService deviceService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", deviceService.brand());
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.device.DeviceServiceRegister", 95);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m24026b(DeviceService deviceService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Long.valueOf(deviceService.screenWidth()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.device.DeviceServiceRegister", 116);
        }
        reply.reply(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m24025a(DeviceService deviceService, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            Map map = (Map) obj;
            hashMap.put("result", Long.valueOf(deviceService.screenHeight()));
        } catch (Error | RuntimeException e) {
            SystemUtils.log(3, "flutter", "error: " + e, (Throwable) null, "com.didi.rlab.uni_foundation.device.DeviceServiceRegister", 137);
        }
        reply.reply(hashMap);
    }

    /* renamed from: a */
    private static Map<String, Object> m24024a(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
