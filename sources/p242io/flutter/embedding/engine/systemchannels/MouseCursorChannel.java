package p242io.flutter.embedding.engine.systemchannels;

import java.util.HashMap;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.MouseCursorChannel */
public class MouseCursorChannel {

    /* renamed from: a */
    private static final String f57713a = "MouseCursorChannel";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MouseCursorMethodHandler f57714b;

    /* renamed from: c */
    private final MethodChannel.MethodCallHandler f57715c = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (MouseCursorChannel.this.f57714b != null) {
                String str = methodCall.method;
                Log.m41140v(MouseCursorChannel.f57713a, "Received '" + str + "' message.");
                char c = 65535;
                try {
                    if (str.hashCode() == -1307105544) {
                        if (str.equals("activateSystemCursor")) {
                            c = 0;
                        }
                    }
                    if (c == 0) {
                        try {
                            MouseCursorChannel.this.f57714b.activateSystemCursor((String) ((HashMap) methodCall.arguments).get("kind"));
                            result.success(true);
                        } catch (Exception e) {
                            result.error("error", "Error when setting cursors: " + e.getMessage(), (Object) null);
                        }
                    }
                } catch (Exception e2) {
                    result.error("error", "Unhandled error: " + e2.getMessage(), (Object) null);
                }
            }
        }
    };
    public final MethodChannel channel;

    /* renamed from: io.flutter.embedding.engine.systemchannels.MouseCursorChannel$MouseCursorMethodHandler */
    public interface MouseCursorMethodHandler {
        void activateSystemCursor(String str);
    }

    public MouseCursorChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this.f57715c);
    }

    public void setMethodHandler(MouseCursorMethodHandler mouseCursorMethodHandler) {
        this.f57714b = mouseCursorMethodHandler;
    }

    public void synthesizeMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.f57715c.onMethodCall(methodCall, result);
    }
}
