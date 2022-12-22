package p242io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p242io.flutter.Log;
import p242io.flutter.plugin.common.BinaryMessenger;

/* renamed from: io.flutter.plugin.common.EventChannel */
public final class EventChannel {

    /* renamed from: a */
    private static final String f57751a = "EventChannel#";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final BinaryMessenger f57752b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f57753c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MethodCodec f57754d;

    /* renamed from: e */
    private final BinaryMessenger.TaskQueue f57755e;

    /* renamed from: io.flutter.plugin.common.EventChannel$EventSink */
    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    /* renamed from: io.flutter.plugin.common.EventChannel$StreamHandler */
    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, (BinaryMessenger.TaskQueue) null);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec, BinaryMessenger.TaskQueue taskQueue) {
        this.f57752b = binaryMessenger;
        this.f57753c = str;
        this.f57754d = methodCodec;
        this.f57755e = taskQueue;
    }

    public void setStreamHandler(StreamHandler streamHandler) {
        IncomingStreamRequestHandler incomingStreamRequestHandler = null;
        if (this.f57755e != null) {
            BinaryMessenger binaryMessenger = this.f57752b;
            String str = this.f57753c;
            if (streamHandler != null) {
                incomingStreamRequestHandler = new IncomingStreamRequestHandler(streamHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingStreamRequestHandler, this.f57755e);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.f57752b;
        String str2 = this.f57753c;
        if (streamHandler != null) {
            incomingStreamRequestHandler = new IncomingStreamRequestHandler(streamHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingStreamRequestHandler);
    }

    /* renamed from: io.flutter.plugin.common.EventChannel$IncomingStreamRequestHandler */
    private final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        /* access modifiers changed from: private */
        public final AtomicReference<EventSink> activeSink = new AtomicReference<>((Object) null);
        private final StreamHandler handler;

        IncomingStreamRequestHandler(StreamHandler streamHandler) {
            this.handler = streamHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            MethodCall decodeMethodCall = EventChannel.this.f57754d.decodeMethodCall(byteBuffer);
            if (decodeMethodCall.method.equals("listen")) {
                onListen(decodeMethodCall.arguments, binaryReply);
            } else if (decodeMethodCall.method.equals("cancel")) {
                onCancel(decodeMethodCall.arguments, binaryReply);
            } else {
                binaryReply.reply((ByteBuffer) null);
            }
        }

        private void onListen(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            EventSinkImplementation eventSinkImplementation = new EventSinkImplementation();
            if (this.activeSink.getAndSet(eventSinkImplementation) != null) {
                try {
                    this.handler.onCancel((Object) null);
                } catch (RuntimeException e) {
                    Log.m41137e(EventChannel.f57751a + EventChannel.this.f57753c, "Failed to close existing event stream", e);
                }
            }
            try {
                this.handler.onListen(obj, eventSinkImplementation);
                binaryReply.reply(EventChannel.this.f57754d.encodeSuccessEnvelope((Object) null));
            } catch (RuntimeException e2) {
                this.activeSink.set((Object) null);
                Log.m41137e(EventChannel.f57751a + EventChannel.this.f57753c, "Failed to open event stream", e2);
                binaryReply.reply(EventChannel.this.f57754d.encodeErrorEnvelope("error", e2.getMessage(), (Object) null));
            }
        }

        private void onCancel(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            if (this.activeSink.getAndSet((Object) null) != null) {
                try {
                    this.handler.onCancel(obj);
                    binaryReply.reply(EventChannel.this.f57754d.encodeSuccessEnvelope((Object) null));
                } catch (RuntimeException e) {
                    Log.m41137e(EventChannel.f57751a + EventChannel.this.f57753c, "Failed to close event stream", e);
                    binaryReply.reply(EventChannel.this.f57754d.encodeErrorEnvelope("error", e.getMessage(), (Object) null));
                }
            } else {
                binaryReply.reply(EventChannel.this.f57754d.encodeErrorEnvelope("error", "No active stream to cancel", (Object) null));
            }
        }

        /* renamed from: io.flutter.plugin.common.EventChannel$IncomingStreamRequestHandler$EventSinkImplementation */
        private final class EventSinkImplementation implements EventSink {
            final AtomicBoolean hasEnded;

            private EventSinkImplementation() {
                this.hasEnded = new AtomicBoolean(false);
            }

            public void success(Object obj) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.f57752b.send(EventChannel.this.f57753c, EventChannel.this.f57754d.encodeSuccessEnvelope(obj));
                }
            }

            public void error(String str, String str2, Object obj) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.f57752b.send(EventChannel.this.f57753c, EventChannel.this.f57754d.encodeErrorEnvelope(str, str2, obj));
                }
            }

            public void endOfStream() {
                if (!this.hasEnded.getAndSet(true) && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.f57752b.send(EventChannel.this.f57753c, (ByteBuffer) null);
                }
            }
        }
    }
}
