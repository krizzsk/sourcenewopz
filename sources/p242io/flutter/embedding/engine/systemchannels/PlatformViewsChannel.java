package p242io.flutter.embedding.engine.systemchannels;

import com.didi.security.uuid.Constants;
import com.didi.soda.blocks.constant.Const;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel */
public class PlatformViewsChannel {

    /* renamed from: a */
    private static final String f57724a = "PlatformViewsChannel";

    /* renamed from: b */
    private final MethodChannel f57725b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PlatformViewsHandler f57726c;

    /* renamed from: d */
    private final MethodChannel.MethodCallHandler f57727d = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (PlatformViewsChannel.this.f57726c != null) {
                Log.m41140v(PlatformViewsChannel.f57724a, "Received '" + methodCall.method + "' message.");
                String str = methodCall.method;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1352294148:
                        if (str.equals(Constants.CREATE_NAME)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -934437708:
                        if (str.equals(Const.BlockParamConst.RESIZE)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -756050293:
                        if (str.equals("clearFocus")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -308988850:
                        if (str.equals("synchronizeToNativeViewHierarchy")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 110550847:
                        if (str.equals("touch")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 576796989:
                        if (str.equals("setDirection")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1671767583:
                        if (str.equals("dispose")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        create(methodCall, result);
                        return;
                    case 1:
                        dispose(methodCall, result);
                        return;
                    case 2:
                        resize(methodCall, result);
                        return;
                    case 3:
                        touch(methodCall, result);
                        return;
                    case 4:
                        setDirection(methodCall, result);
                        return;
                    case 5:
                        clearFocus(methodCall, result);
                        return;
                    case 6:
                        synchronizeToNativeViewHierarchy(methodCall, result);
                        return;
                    default:
                        result.notImplemented();
                        return;
                }
            }
        }

        private void create(MethodCall methodCall, MethodChannel.Result result) {
            double d;
            MethodChannel.Result result2 = result;
            Map map = (Map) methodCall.arguments();
            boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            double d2 = 0.0d;
            if (z) {
                d = 0.0d;
            } else {
                d = ((Double) map.get("width")).doubleValue();
            }
            if (!z) {
                d2 = ((Double) map.get("height")).doubleValue();
            }
            PlatformViewCreationRequest platformViewCreationRequest = new PlatformViewCreationRequest(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), d, d2, ((Integer) map.get(Const.YogaConst.YOGA_DIRECTION)).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null);
            if (z) {
                try {
                    PlatformViewsChannel.this.f57726c.createAndroidViewForPlatformView(platformViewCreationRequest);
                    result2.success((Object) null);
                } catch (IllegalStateException e) {
                    result2.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
                }
            } else {
                result2.success(Long.valueOf(PlatformViewsChannel.this.f57726c.createVirtualDisplayForPlatformView(platformViewCreationRequest)));
            }
        }

        private void dispose(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            int intValue = ((Integer) map.get("id")).intValue();
            if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                try {
                    PlatformViewsChannel.this.f57726c.disposeAndroidViewForPlatformView(intValue);
                } catch (IllegalStateException e) {
                    result.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
                    return;
                }
            } else {
                PlatformViewsChannel.this.f57726c.disposeVirtualDisplayForPlatformView(intValue);
            }
            result.success((Object) null);
        }

        private void resize(MethodCall methodCall, final MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.f57726c.resizePlatformView(new PlatformViewResizeRequest(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new Runnable() {
                    public void run() {
                        result.success((Object) null);
                    }
                });
            } catch (IllegalStateException e) {
                result.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
            }
        }

        private void touch(MethodCall methodCall, MethodChannel.Result result) {
            MethodChannel.Result result2;
            MethodChannel.Result result3 = result;
            List list = (List) methodCall.arguments();
            PlatformViewTouch platformViewTouch = r2;
            PlatformViewTouch platformViewTouch2 = platformViewTouch;
            PlatformViewTouch platformViewTouch3 = new PlatformViewTouch(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue());
            try {
                PlatformViewsChannel.this.f57726c.onTouch(platformViewTouch);
                result2 = result;
                try {
                    result2.success((Object) null);
                } catch (IllegalStateException e) {
                    e = e;
                }
            } catch (IllegalStateException e2) {
                e = e2;
                result2 = result;
                result2.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
            }
        }

        private void setDirection(MethodCall methodCall, MethodChannel.Result result) {
            Map map = (Map) methodCall.arguments();
            try {
                PlatformViewsChannel.this.f57726c.setDirection(((Integer) map.get("id")).intValue(), ((Integer) map.get(Const.YogaConst.YOGA_DIRECTION)).intValue());
                result.success((Object) null);
            } catch (IllegalStateException e) {
                result.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
            }
        }

        private void clearFocus(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.f57726c.clearFocus(((Integer) methodCall.arguments()).intValue());
                result.success((Object) null);
            } catch (IllegalStateException e) {
                result.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
            }
        }

        private void synchronizeToNativeViewHierarchy(MethodCall methodCall, MethodChannel.Result result) {
            try {
                PlatformViewsChannel.this.f57726c.synchronizeToNativeViewHierarchy(((Boolean) methodCall.arguments()).booleanValue());
                result.success((Object) null);
            } catch (IllegalStateException e) {
                result.error("error", PlatformViewsChannel.m41504b(e), (Object) null);
            }
        }
    };

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$PlatformViewsHandler */
    public interface PlatformViewsHandler {
        void clearFocus(int i);

        void createAndroidViewForPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        long createVirtualDisplayForPlatformView(PlatformViewCreationRequest platformViewCreationRequest);

        void disposeAndroidViewForPlatformView(int i);

        void disposeVirtualDisplayForPlatformView(int i);

        void onTouch(PlatformViewTouch platformViewTouch);

        void resizePlatformView(PlatformViewResizeRequest platformViewResizeRequest, Runnable runnable);

        void setDirection(int i, int i2);

        void synchronizeToNativeViewHierarchy(boolean z);
    }

    public void invokeViewFocused(int i) {
        MethodChannel methodChannel = this.f57725b;
        if (methodChannel != null) {
            methodChannel.invokeMethod("viewFocused", Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static String m41504b(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public PlatformViewsChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
        this.f57725b = methodChannel;
        methodChannel.setMethodCallHandler(this.f57727d);
    }

    public void setPlatformViewsHandler(PlatformViewsHandler platformViewsHandler) {
        this.f57726c = platformViewsHandler;
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$PlatformViewCreationRequest */
    public static class PlatformViewCreationRequest {
        public final int direction;
        public final double logicalHeight;
        public final double logicalWidth;
        public final ByteBuffer params;
        public final int viewId;
        public final String viewType;

        public PlatformViewCreationRequest(int i, String str, double d, double d2, int i2, ByteBuffer byteBuffer) {
            this.viewId = i;
            this.viewType = str;
            this.logicalWidth = d;
            this.logicalHeight = d2;
            this.direction = i2;
            this.params = byteBuffer;
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$PlatformViewResizeRequest */
    public static class PlatformViewResizeRequest {
        public final double newLogicalHeight;
        public final double newLogicalWidth;
        public final int viewId;

        public PlatformViewResizeRequest(int i, double d, double d2) {
            this.viewId = i;
            this.newLogicalWidth = d;
            this.newLogicalHeight = d2;
        }
    }

    /* renamed from: io.flutter.embedding.engine.systemchannels.PlatformViewsChannel$PlatformViewTouch */
    public static class PlatformViewTouch {
        public final int action;
        public final int buttonState;
        public final int deviceId;
        public final Number downTime;
        public final int edgeFlags;
        public final Number eventTime;
        public final int flags;
        public final int metaState;
        public final long motionEventId;
        public final int pointerCount;
        public final Object rawPointerCoords;
        public final Object rawPointerPropertiesList;
        public final int source;
        public final int viewId;
        public final float xPrecision;
        public final float yPrecision;

        public PlatformViewTouch(int i, Number number, Number number2, int i2, int i3, Object obj, Object obj2, int i4, int i5, float f, float f2, int i6, int i7, int i8, int i9, long j) {
            this.viewId = i;
            this.downTime = number;
            this.eventTime = number2;
            this.action = i2;
            this.pointerCount = i3;
            this.rawPointerPropertiesList = obj;
            this.rawPointerCoords = obj2;
            this.metaState = i4;
            this.buttonState = i5;
            this.xPrecision = f;
            this.yPrecision = f2;
            this.deviceId = i6;
            this.edgeFlags = i7;
            this.source = i8;
            this.flags = i9;
            this.motionEventId = j;
        }
    }
}
