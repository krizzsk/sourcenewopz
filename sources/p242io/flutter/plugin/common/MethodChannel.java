package p242io.flutter.plugin.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import p242io.flutter.Log;
import p242io.flutter.plugin.common.BinaryMessenger;

/* renamed from: io.flutter.plugin.common.MethodChannel */
public class MethodChannel {

    /* renamed from: a */
    private static final String f57756a = "MethodChannel#";

    /* renamed from: b */
    private final BinaryMessenger f57757b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f57758c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MethodCodec f57759d;

    /* renamed from: e */
    private final BinaryMessenger.TaskQueue f57760e;

    /* renamed from: io.flutter.plugin.common.MethodChannel$MethodCallHandler */
    public interface MethodCallHandler {
        void onMethodCall(MethodCall methodCall, Result result);
    }

    /* renamed from: io.flutter.plugin.common.MethodChannel$Result */
    public interface Result {
        void error(String str, String str2, Object obj);

        void notImplemented();

        void success(Object obj);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, (BinaryMessenger.TaskQueue) null);
    }

    public MethodChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec, BinaryMessenger.TaskQueue taskQueue) {
        this.f57757b = binaryMessenger;
        this.f57758c = str;
        this.f57759d = methodCodec;
        this.f57760e = taskQueue;
    }

    public void invokeMethod(String str, Object obj) {
        invokeMethod(str, obj, (Result) null);
    }

    public void invokeMethod(String str, Object obj, Result result) {
        IncomingResultHandler incomingResultHandler;
        BinaryMessenger binaryMessenger = this.f57757b;
        String str2 = this.f57758c;
        ByteBuffer encodeMethodCall = this.f57759d.encodeMethodCall(new MethodCall(str, obj));
        if (result == null) {
            incomingResultHandler = null;
        } else {
            incomingResultHandler = new IncomingResultHandler(result);
        }
        binaryMessenger.send(str2, encodeMethodCall, incomingResultHandler);
    }

    public void setMethodCallHandler(MethodCallHandler methodCallHandler) {
        IncomingMethodCallHandler incomingMethodCallHandler = null;
        if (this.f57760e != null) {
            BinaryMessenger binaryMessenger = this.f57757b;
            String str = this.f57758c;
            if (methodCallHandler != null) {
                incomingMethodCallHandler = new IncomingMethodCallHandler(methodCallHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMethodCallHandler, this.f57760e);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.f57757b;
        String str2 = this.f57758c;
        if (methodCallHandler != null) {
            incomingMethodCallHandler = new IncomingMethodCallHandler(methodCallHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMethodCallHandler);
    }

    public void resizeChannelBuffer(int i) {
        BasicMessageChannel.m41517a(this.f57757b, this.f57758c, i);
    }

    /* renamed from: io.flutter.plugin.common.MethodChannel$IncomingResultHandler */
    private final class IncomingResultHandler implements BinaryMessenger.BinaryReply {
        private final Result callback;

        IncomingResultHandler(Result result) {
            this.callback = result;
        }

        public void reply(ByteBuffer byteBuffer) {
            if (byteBuffer == null) {
                try {
                    this.callback.notImplemented();
                } catch (RuntimeException e) {
                    Log.m41137e(MethodChannel.f57756a + MethodChannel.this.f57758c, "Failed to handle method call result", e);
                }
            } else {
                try {
                    this.callback.success(MethodChannel.this.f57759d.decodeEnvelope(byteBuffer));
                } catch (FlutterException e2) {
                    this.callback.error(e2.code, e2.getMessage(), e2.details);
                }
            }
        }
    }

    /* renamed from: io.flutter.plugin.common.MethodChannel$IncomingMethodCallHandler */
    private final class IncomingMethodCallHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MethodCallHandler handler;

        IncomingMethodCallHandler(MethodCallHandler methodCallHandler) {
            this.handler = methodCallHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMethodCall(MethodChannel.this.f57759d.decodeMethodCall(byteBuffer), new Result() {
                    public void success(Object obj) {
                        binaryReply.reply(MethodChannel.this.f57759d.encodeSuccessEnvelope(obj));
                    }

                    public void error(String str, String str2, Object obj) {
                        binaryReply.reply(MethodChannel.this.f57759d.encodeErrorEnvelope(str, str2, obj));
                    }

                    public void notImplemented() {
                        binaryReply.reply((ByteBuffer) null);
                    }
                });
            } catch (RuntimeException e) {
                Log.m41137e(MethodChannel.f57756a + MethodChannel.this.f57758c, "Failed to handle method call", e);
                binaryReply.reply(MethodChannel.this.f57759d.encodeErrorEnvelopeWithStacktrace("error", e.getMessage(), (Object) null, getStackTrace(e)));
            }
        }

        private String getStackTrace(Exception exc) {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
    }
}
