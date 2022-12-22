package p242io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterJNI;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.plugin.common.BasicMessageChannel;
import p242io.flutter.plugin.common.StandardMessageCodec;
import p242io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.embedding.engine.systemchannels.AccessibilityChannel */
public class AccessibilityChannel {

    /* renamed from: a */
    private static final String f57701a = "AccessibilityChannel";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AccessibilityMessageHandler f57702b;

    /* renamed from: c */
    private final BasicMessageChannel.MessageHandler<Object> f57703c = new BasicMessageChannel.MessageHandler<Object>() {
        public void onMessage(Object obj, BasicMessageChannel.Reply<Object> reply) {
            String str;
            if (AccessibilityChannel.this.f57702b != null) {
                HashMap hashMap = (HashMap) obj;
                String str2 = (String) hashMap.get("type");
                HashMap hashMap2 = (HashMap) hashMap.get("data");
                Log.m41140v(AccessibilityChannel.f57701a, "Received " + str2 + " message.");
                char c = 65535;
                switch (str2.hashCode()) {
                    case -1140076541:
                        if (str2.equals("tooltip")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -649620375:
                        if (str2.equals("announce")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 114595:
                        if (str2.equals("tap")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 114203431:
                        if (str2.equals("longPress")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                if (c == 0) {
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        AccessibilityChannel.this.f57702b.announce(str3);
                    }
                } else if (c == 1) {
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        AccessibilityChannel.this.f57702b.onTap(num.intValue());
                    }
                } else if (c == 2) {
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        AccessibilityChannel.this.f57702b.onLongPress(num2.intValue());
                    }
                } else if (c == 3 && (str = (String) hashMap2.get("message")) != null) {
                    AccessibilityChannel.this.f57702b.onTooltip(str);
                }
                reply.reply(null);
            }
        }
    };
    public final BasicMessageChannel<Object> channel;
    public final FlutterJNI flutterJNI;

    /* renamed from: io.flutter.embedding.engine.systemchannels.AccessibilityChannel$AccessibilityMessageHandler */
    public interface AccessibilityMessageHandler extends FlutterJNI.AccessibilityDelegate {
        void announce(String str);

        void onLongPress(int i);

        void onTap(int i);

        void onTooltip(String str);
    }

    public AccessibilityChannel(DartExecutor dartExecutor, FlutterJNI flutterJNI2) {
        BasicMessageChannel<Object> basicMessageChannel = new BasicMessageChannel<>(dartExecutor, "flutter/accessibility", StandardMessageCodec.INSTANCE);
        this.channel = basicMessageChannel;
        basicMessageChannel.setMessageHandler(this.f57703c);
        this.flutterJNI = flutterJNI2;
    }

    public void onAndroidAccessibilityEnabled() {
        this.flutterJNI.setSemanticsEnabled(true);
    }

    public void onAndroidAccessibilityDisabled() {
        this.flutterJNI.setSemanticsEnabled(false);
    }

    public void setAccessibilityFeatures(int i) {
        this.flutterJNI.setAccessibilityFeatures(i);
    }

    public void dispatchSemanticsAction(int i, AccessibilityBridge.Action action) {
        this.flutterJNI.dispatchSemanticsAction(i, action);
    }

    public void dispatchSemanticsAction(int i, AccessibilityBridge.Action action, Object obj) {
        this.flutterJNI.dispatchSemanticsAction(i, action, obj);
    }

    public void setAccessibilityMessageHandler(AccessibilityMessageHandler accessibilityMessageHandler) {
        this.f57702b = accessibilityMessageHandler;
        this.flutterJNI.setAccessibilityDelegate(accessibilityMessageHandler);
    }
}
