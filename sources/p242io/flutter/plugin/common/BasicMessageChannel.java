package p242io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
import p242io.flutter.Log;
import p242io.flutter.plugin.common.BinaryMessenger;

/* renamed from: io.flutter.plugin.common.BasicMessageChannel */
public final class BasicMessageChannel<T> {
    public static final String CHANNEL_BUFFERS_CHANNEL = "dev.flutter/channel-buffers";

    /* renamed from: a */
    private static final String f57743a = "BasicMessageChannel#";

    /* renamed from: b */
    private final BinaryMessenger f57744b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f57745c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final MessageCodec<T> f57746d;

    /* renamed from: e */
    private final BinaryMessenger.TaskQueue f57747e;

    /* renamed from: io.flutter.plugin.common.BasicMessageChannel$MessageHandler */
    public interface MessageHandler<T> {
        void onMessage(T t, Reply<T> reply);
    }

    /* renamed from: io.flutter.plugin.common.BasicMessageChannel$Reply */
    public interface Reply<T> {
        void reply(T t);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec) {
        this(binaryMessenger, str, messageCodec, (BinaryMessenger.TaskQueue) null);
    }

    public BasicMessageChannel(BinaryMessenger binaryMessenger, String str, MessageCodec<T> messageCodec, BinaryMessenger.TaskQueue taskQueue) {
        this.f57744b = binaryMessenger;
        this.f57745c = str;
        this.f57746d = messageCodec;
        this.f57747e = taskQueue;
    }

    public void send(T t) {
        send(t, (Reply) null);
    }

    public void send(T t, Reply<T> reply) {
        BinaryMessenger binaryMessenger = this.f57744b;
        String str = this.f57745c;
        ByteBuffer encodeMessage = this.f57746d.encodeMessage(t);
        IncomingReplyHandler incomingReplyHandler = null;
        if (reply != null) {
            incomingReplyHandler = new IncomingReplyHandler(reply);
        }
        binaryMessenger.send(str, encodeMessage, incomingReplyHandler);
    }

    public void setMessageHandler(MessageHandler<T> messageHandler) {
        IncomingMessageHandler incomingMessageHandler = null;
        if (this.f57747e != null) {
            BinaryMessenger binaryMessenger = this.f57744b;
            String str = this.f57745c;
            if (messageHandler != null) {
                incomingMessageHandler = new IncomingMessageHandler(messageHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingMessageHandler, this.f57747e);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.f57744b;
        String str2 = this.f57745c;
        if (messageHandler != null) {
            incomingMessageHandler = new IncomingMessageHandler(messageHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingMessageHandler);
    }

    public void resizeChannelBuffer(int i) {
        m41517a(this.f57744b, this.f57745c, i);
    }

    /* renamed from: a */
    static void m41517a(BinaryMessenger binaryMessenger, String str, int i) {
        binaryMessenger.send(CHANNEL_BUFFERS_CHANNEL, ByteBuffer.wrap(String.format(Locale.US, "resize\r%s\r%d", new Object[]{str, Integer.valueOf(i)}).getBytes(Charset.forName("UTF-8"))));
    }

    /* renamed from: io.flutter.plugin.common.BasicMessageChannel$IncomingReplyHandler */
    private final class IncomingReplyHandler implements BinaryMessenger.BinaryReply {
        private final Reply<T> callback;

        private IncomingReplyHandler(Reply<T> reply) {
            this.callback = reply;
        }

        public void reply(ByteBuffer byteBuffer) {
            try {
                this.callback.reply(BasicMessageChannel.this.f57746d.decodeMessage(byteBuffer));
            } catch (RuntimeException e) {
                Log.m41137e(BasicMessageChannel.f57743a + BasicMessageChannel.this.f57745c, "Failed to handle message reply", e);
            }
        }
    }

    /* renamed from: io.flutter.plugin.common.BasicMessageChannel$IncomingMessageHandler */
    private final class IncomingMessageHandler implements BinaryMessenger.BinaryMessageHandler {
        private final MessageHandler<T> handler;

        private IncomingMessageHandler(MessageHandler<T> messageHandler) {
            this.handler = messageHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, final BinaryMessenger.BinaryReply binaryReply) {
            try {
                this.handler.onMessage(BasicMessageChannel.this.f57746d.decodeMessage(byteBuffer), new Reply<T>() {
                    public void reply(T t) {
                        binaryReply.reply(BasicMessageChannel.this.f57746d.encodeMessage(t));
                    }
                });
            } catch (RuntimeException e) {
                Log.m41137e(BasicMessageChannel.f57743a + BasicMessageChannel.this.f57745c, "Failed to handle message", e);
                binaryReply.reply((ByteBuffer) null);
            }
        }
    }
}
