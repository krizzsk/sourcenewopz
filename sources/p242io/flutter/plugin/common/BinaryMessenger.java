package p242io.flutter.plugin.common;

import java.nio.ByteBuffer;

/* renamed from: io.flutter.plugin.common.BinaryMessenger */
public interface BinaryMessenger {

    /* renamed from: io.flutter.plugin.common.BinaryMessenger$BinaryMessageHandler */
    public interface BinaryMessageHandler {
        void onMessage(ByteBuffer byteBuffer, BinaryReply binaryReply);
    }

    /* renamed from: io.flutter.plugin.common.BinaryMessenger$BinaryReply */
    public interface BinaryReply {
        void reply(ByteBuffer byteBuffer);
    }

    /* renamed from: io.flutter.plugin.common.BinaryMessenger$TaskQueue */
    public interface TaskQueue {
    }

    void disableBufferingIncomingMessages();

    void enableBufferingIncomingMessages();

    TaskQueue makeBackgroundTaskQueue();

    TaskQueue makeBackgroundTaskQueue(TaskQueueOptions taskQueueOptions);

    void send(String str, ByteBuffer byteBuffer);

    void send(String str, ByteBuffer byteBuffer, BinaryReply binaryReply);

    void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler);

    void setMessageHandler(String str, BinaryMessageHandler binaryMessageHandler, TaskQueue taskQueue);

    /* renamed from: io.flutter.plugin.common.BinaryMessenger$TaskQueueOptions */
    public static class TaskQueueOptions {
        private boolean isSerial = true;

        public boolean getIsSerial() {
            return this.isSerial;
        }

        public TaskQueueOptions setIsSerial(boolean z) {
            this.isSerial = z;
            return this;
        }
    }

    /* renamed from: io.flutter.plugin.common.BinaryMessenger$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static TaskQueue $default$makeBackgroundTaskQueue(BinaryMessenger _this) {
            return _this.makeBackgroundTaskQueue(new TaskQueueOptions());
        }

        public static TaskQueue $default$makeBackgroundTaskQueue(BinaryMessenger _this, TaskQueueOptions taskQueueOptions) {
            throw new UnsupportedOperationException("makeBackgroundTaskQueue not implemented.");
        }

        public static void $default$setMessageHandler(BinaryMessenger _this, String str, BinaryMessageHandler binaryMessageHandler, TaskQueue taskQueue) {
            if (taskQueue == null) {
                _this.setMessageHandler(str, binaryMessageHandler);
                return;
            }
            throw new UnsupportedOperationException("setMessageHandler called with nonnull taskQueue is not supported.");
        }

        public static void $default$enableBufferingIncomingMessages(BinaryMessenger _this) {
            throw new UnsupportedOperationException("enableBufferingIncomingMessages not implemented.");
        }

        public static void $default$disableBufferingIncomingMessages(BinaryMessenger _this) {
            throw new UnsupportedOperationException("disableBufferingIncomingMessages not implemented.");
        }
    }
}
