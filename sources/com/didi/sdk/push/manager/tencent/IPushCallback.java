package com.didi.sdk.push.manager.tencent;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface IPushCallback {

    public static class CallbackType {
        static final int APOLLO_SWITCH = 7;
        public static final int CONN_CHANNEL = 0;
        static final int HANDLE_HEADER = 6;
        public static final int LOG = 4;
        public static final int PROGRESS = 3;
        static final int PUSH_TIMEOUT_CALLBACK = 10;
        public static final int RECEIVE = 2;
        public static final int REQUEST = 1;
        static final int STATISTICS = 5;
        static final int TRACK_CONNECTION_EVENT = 9;
        static final int TRACK_TRANSACTION_EVENT = 8;
    }

    public static class ProgressState {
        public static final int END = 2;
        public static final int RUNNING = 1;
        public static final int START = 0;
    }

    boolean onApolloSwitch(String str);

    void onConnection(int i, int i2);

    byte[] onHandleHeader(byte[] bArr);

    void onLog(int i, String str);

    void onProgress(byte[] bArr, int i, int i2);

    void onPushTimeout(int i);

    void onReceive(int i, byte[] bArr, byte[] bArr2);

    void onRequested(int i, int i2, byte[] bArr);

    void onStatistics(Stats stats);

    void onTrackConnection(SocketConnectionEvent socketConnectionEvent);

    void onTrackTransaction(SocketTransactionEvent socketTransactionEvent);

    public static class Message {
        public byte[] body;
        public int msgType;
        public byte[] seqId = new byte[8];

        public static Message fromBytes(byte[] bArr) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            Message message = new Message();
            message.msgType = order.getInt();
            int i = order.getInt();
            order.get(message.seqId);
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                message.body = bArr2;
                order.get(bArr2);
            }
            return message;
        }
    }

    public static class Progress {
        public int percent;
        public byte[] seqId = new byte[8];
        public int state;

        public static Progress fromBytes(byte[] bArr) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            Progress progress = new Progress();
            order.get(progress.seqId);
            progress.state = order.getInt();
            progress.percent = order.getInt();
            return progress;
        }
    }

    public static class Stats {
        public double connectedDuration;
        public double disconnectedDuration;
        public long disconnectedErrorCount;
        public long heartbeatRecvRspCount;
        public double heartbeatResponseAverageLag;
        public double heartbeatResponseTotalDuration;
        public long heartbeatSendReqCount;
        public double lastConnectedTimestamp;
        public double lastDisconnectedTimestamp;
        public double lastHeartbeatResponseLag;
        public long recvBytes;
        public long recvPackets;
        public long recvPacketsFailCount;
        public long sendBytes;
        public long sendPackets;
        public long sendPacketsFailBytes;
        public long sendPacketsFailCount;

        private Stats() {
        }

        public static Stats fromBytes(byte[] bArr) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            Stats stats = new Stats();
            stats.sendBytes = order.getLong();
            stats.sendPackets = order.getLong();
            stats.sendPacketsFailCount = order.getLong();
            stats.sendPacketsFailBytes = order.getLong();
            stats.recvBytes = order.getLong();
            stats.recvPackets = order.getLong();
            stats.recvPacketsFailCount = order.getLong();
            stats.lastConnectedTimestamp = order.getDouble();
            stats.lastDisconnectedTimestamp = order.getDouble();
            stats.connectedDuration = order.getDouble();
            stats.disconnectedDuration = order.getDouble();
            stats.disconnectedErrorCount = order.getLong();
            stats.heartbeatSendReqCount = order.getLong();
            stats.heartbeatRecvRspCount = order.getLong();
            stats.heartbeatResponseTotalDuration = order.getDouble();
            stats.lastHeartbeatResponseLag = order.getDouble();
            stats.heartbeatResponseAverageLag = order.getDouble();
            return stats;
        }

        public String toString() {
            return "Stats{sendBytes=" + this.sendBytes + ", sendPackets=" + this.sendPackets + ", sendPacketsFailCount=" + this.sendPacketsFailCount + ", sendPacketsFailBytes=" + this.sendPacketsFailBytes + ", recvBytes=" + this.recvBytes + ", recvPackets=" + this.recvPackets + ", recvPacketsFailCount=" + this.recvPacketsFailCount + ", lastConnectedTimestamp=" + this.lastConnectedTimestamp + ", lastDisconnectedTimestamp=" + this.lastDisconnectedTimestamp + ", connectedDuration=" + this.connectedDuration + ", disconnectedDuration=" + this.disconnectedDuration + ", disconnectedErrorCount=" + this.disconnectedErrorCount + ", heartbeatSendReqCount=" + this.heartbeatSendReqCount + ", heartbeatRecvRspCount=" + this.heartbeatRecvRspCount + ", heartbeatResponseTotalDuration=" + this.heartbeatResponseTotalDuration + ", lastHeartbeatResponseLag=" + this.lastHeartbeatResponseLag + ", heartbeatResponseAverageLag=" + this.heartbeatResponseAverageLag + '}';
        }
    }

    public static class SocketTransactionEvent {
        public long down;
        public int msgType;
        public long seqId;
        public long time;
        public int tls;

        /* renamed from: up */
        public long f37089up;

        static SocketTransactionEvent fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            SocketTransactionEvent socketTransactionEvent = new SocketTransactionEvent();
            socketTransactionEvent.seqId = order.getLong();
            socketTransactionEvent.msgType = order.getInt();
            socketTransactionEvent.f37089up = order.getLong();
            socketTransactionEvent.down = order.getLong();
            socketTransactionEvent.time = order.getLong();
            socketTransactionEvent.tls = order.getInt();
            return socketTransactionEvent;
        }

        public String toString() {
            return "SocketTransactionEvent{seqId=" + this.seqId + ",msgType = " + this.msgType + ",up = " + this.f37089up + ",down = " + this.down + ",time = " + this.time + ",tls = " + this.tls + "}";
        }
    }

    public static class SocketConnectionEvent {
        public long appStartDuration;
        public long connectDuration;
        public int errorCode;
        public long failedTimes;
        public long maintainDuration;
        public int subCode;
        public int tls;
        public int type;

        static SocketConnectionEvent fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            SocketConnectionEvent socketConnectionEvent = new SocketConnectionEvent();
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            socketConnectionEvent.errorCode = order.getInt();
            socketConnectionEvent.subCode = order.getInt();
            socketConnectionEvent.type = order.getInt();
            socketConnectionEvent.tls = order.getInt();
            socketConnectionEvent.connectDuration = order.getLong();
            socketConnectionEvent.appStartDuration = order.getLong();
            socketConnectionEvent.failedTimes = order.getLong();
            socketConnectionEvent.maintainDuration = order.getLong();
            return socketConnectionEvent;
        }

        public String toString() {
            return "SocketConnectionEvent{errorCode=" + this.errorCode + ",subCode = " + this.subCode + ",type = " + this.type + ",tls = " + this.tls + ",connectDuration = " + this.connectDuration + ",appStartDuration = " + this.appStartDuration + ",failedTimes = " + this.failedTimes + ",maintainDuration = " + this.maintainDuration + "}";
        }
    }
}
