package com.didi.flutter.nacho2.p115v2;

import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.AdminPermission;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.plugin.common.MethodChannel;

/* renamed from: com.didi.flutter.nacho2.v2.NachoLifecycleManager */
public class NachoLifecycleManager {
    public static final String LIFECYCLE_CHANNEL_METHOD = "lifecycleEvent";
    public static final String LIFECYCLE_CHANNEL_ON_CREATE = "com.didi.flutter.nacho2/onCreate";
    public static final String LIFECYCLE_CHANNEL_ON_DESTROY = "com.didi.flutter.nacho2/onDestroy";
    public static final String LIFECYCLE_CHANNEL_ON_RESUME = "com.didi.flutter.nacho2/onResume";
    public static final String LIFECYCLE_ON_CREATE = "onCreate";
    public static final String LIFECYCLE_ON_DESTROY = "onDestroy";
    public static final String LIFECYCLE_ON_RESUME = "onResume";

    protected static void registerLifecycleChannels(NachoAction nachoAction) {
        FlutterEngine engine = nachoAction.getEngine();
        MethodChannel methodChannel = new MethodChannel(engine.getDartExecutor().getBinaryMessenger(), LIFECYCLE_CHANNEL_ON_CREATE);
        MethodChannel methodChannel2 = new MethodChannel(engine.getDartExecutor().getBinaryMessenger(), LIFECYCLE_CHANNEL_ON_RESUME);
        MethodChannel methodChannel3 = new MethodChannel(engine.getDartExecutor().getBinaryMessenger(), LIFECYCLE_CHANNEL_ON_DESTROY);
        nachoAction.registerChannel(LIFECYCLE_CHANNEL_ON_CREATE, methodChannel);
        nachoAction.registerChannel(LIFECYCLE_CHANNEL_ON_RESUME, methodChannel2);
        nachoAction.registerChannel(LIFECYCLE_CHANNEL_ON_DESTROY, methodChannel3);
    }

    public static void sendLifecycleOnCreate(NachoAction nachoAction, String str, Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put("pageId", str);
        hashMap.put(AdminPermission.LIFECYCLE, LIFECYCLE_ON_CREATE);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("params", map2);
        nachoAction.getChannel(LIFECYCLE_CHANNEL_ON_CREATE).invokeMethod(LIFECYCLE_CHANNEL_METHOD, hashMap);
    }

    public static void sendLifecycleOnResume(NachoAction nachoAction, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("pageId", str);
        hashMap.put(AdminPermission.LIFECYCLE, "onResume");
        nachoAction.getChannel(LIFECYCLE_CHANNEL_ON_RESUME).invokeMethod(LIFECYCLE_CHANNEL_METHOD, hashMap);
    }

    public static void sendLifecycleOnDestroy(NachoAction nachoAction, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("pageId", str);
        hashMap.put(AdminPermission.LIFECYCLE, LIFECYCLE_ON_DESTROY);
        nachoAction.getChannel(LIFECYCLE_CHANNEL_ON_DESTROY).invokeMethod(LIFECYCLE_CHANNEL_METHOD, hashMap);
    }
}
