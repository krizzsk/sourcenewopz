package com.didi.sdk.push;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

interface IPushCallback {

    public static class CallbackType {
        public static final int CONN_CHANNEL = 0;
        static final int HANDLE_HEADER = 6;
        public static final int LOG = 4;
        public static final int PROGRESS = 3;
        static final int PUSH_CALLBACK_CONN_CHANNEL_V2 = 11;
        public static final int RECEIVE = 2;
        public static final int REQUEST = 1;
        static final int REQUEST_ACK = 14;
        static final int TRACE_MSG_FLUX_EVENT = 15;
        static final int TRACK_AVAILABLE_STAT_EVENT = 10;
        static final int TRACK_CONNECTION_EVENT = 9;
        static final int TRACK_CONNECTION_EVENT_V2 = 12;
        static final int TRACK_MSG_ACK_EVENT = 13;
        static final int TRACK_PUSH_QUALITY_EVENT = 16;
        static final int TRACK_TRANSACTION_EVENT = 8;
    }

    public static class ProgressState {
        public static final int END = 2;
        public static final int RUNNING = 1;
        public static final int START = 0;
    }

    void onConnection(Connection connection);

    byte[] onHandleHeader(byte[] bArr);

    void onLog(int i, String str);

    void onProgress(byte[] bArr, int i, int i2);

    void onReceive(int i, byte[] bArr, byte[] bArr2);

    void onRequested(int i, int i2, byte[] bArr);

    void onTrackAvailableRate(AvailableRateEvent availableRateEvent);

    void onTrackConnection(SocketConnectionEvent socketConnectionEvent);

    void onTrackConnection(SocketConnectionEventV2 socketConnectionEventV2);

    void onTrackMsgAck(MsgAckEvent msgAckEvent);

    void onTrackMsgFlux(MsgFluxEvent msgFluxEvent);

    void onTrackPushQualityEvent(PushQualityEvent pushQualityEvent);

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

    public static class SocketTransactionEvent {
        public long down;
        public int msgType;
        public long seqId;
        public long time;
        public int tls;

        /* renamed from: up */
        public long f37076up;

        static SocketTransactionEvent fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            SocketTransactionEvent socketTransactionEvent = new SocketTransactionEvent();
            socketTransactionEvent.seqId = order.getLong();
            socketTransactionEvent.msgType = order.getInt();
            socketTransactionEvent.f37076up = order.getLong();
            socketTransactionEvent.down = order.getLong();
            socketTransactionEvent.time = order.getLong();
            socketTransactionEvent.tls = order.getInt();
            return socketTransactionEvent;
        }

        public String toString() {
            return "SocketTransactionEvent{seqId=" + this.seqId + ",msgType = " + this.msgType + ",up = " + this.f37076up + ",down = " + this.down + ",time = " + this.time + ",tls = " + this.tls + "}";
        }
    }

    public static class SocketConnectionEvent {
        public long appStartDuration;
        public long connectDuration;
        public int errorCode;
        public long failedTimes;
        public long lastFailDuration;
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
            socketConnectionEvent.lastFailDuration = order.getLong();
            return socketConnectionEvent;
        }

        public String toString() {
            return "SocketConnectionEvent{errorCode=" + this.errorCode + ",subCode = " + this.subCode + ",type = " + this.type + ",tls = " + this.tls + ",connectDuration = " + this.connectDuration + ",appStartDuration = " + this.appStartDuration + ",failedTimes = " + this.failedTimes + ",maintainDuration = " + this.maintainDuration + ",lastFailDuration = " + this.lastFailDuration + "}";
        }
    }

    public static class AvailableRateEvent {
        public long availableRate;
        public long availableTime;
        public long connectSuccess;
        public long connectTotal;
        public long sleepTimes;
        public long totalSleepDuration;
        public long totalTime;

        static AvailableRateEvent formBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            AvailableRateEvent availableRateEvent = new AvailableRateEvent();
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            availableRateEvent.availableTime = order.getLong();
            availableRateEvent.totalTime = order.getLong();
            availableRateEvent.availableRate = order.getLong();
            availableRateEvent.sleepTimes = order.getLong();
            availableRateEvent.totalSleepDuration = order.getLong();
            availableRateEvent.connectSuccess = order.getLong();
            availableRateEvent.connectTotal = order.getLong();
            return availableRateEvent;
        }

        public String toString() {
            return "AvailableRateEvent{availableTime = " + this.availableTime + ", totalTime = " + this.totalTime + ", availableRate = " + this.availableRate + ", sleepTimes = " + this.sleepTimes + ", totalSleepDuration = " + this.totalSleepDuration + ", connectSuccess = " + this.connectSuccess + ", connectTotal = " + this.connectTotal + "}";
        }
    }

    public static class Connection {
        public int code;
        public String extraMsg;

        /* renamed from: ip */
        public String f37072ip;
        public int port;
        public int subCode;

        static Connection fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            Connection connection = new Connection();
            connection.code = order.getInt();
            connection.subCode = order.getInt();
            int i = order.getInt();
            connection.port = order.getInt();
            int i2 = order.getInt();
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                order.get(bArr2);
                connection.f37072ip = new String(bArr2);
            }
            if (i2 > 0) {
                byte[] bArr3 = new byte[i2];
                order.get(bArr3);
                connection.extraMsg = new String(bArr3);
            }
            return connection;
        }

        public String toString() {
            return "Connection{code = " + this.code + ", subCode = " + this.subCode + ", ip = " + this.f37072ip + ", port = " + this.port + ", extraMsg = " + this.extraMsg + "}";
        }
    }

    public static class SocketConnectionEventV2 {
        long confirmDur;

        /* renamed from: ip */
        String f37075ip;
        int isMulti;
        int port;
        long tcpHandshakeDur;
        long tlsHandshakeDur;

        static SocketConnectionEventV2 fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            int i = order.getInt();
            SocketConnectionEventV2 socketConnectionEventV2 = new SocketConnectionEventV2();
            socketConnectionEventV2.port = order.getInt();
            socketConnectionEventV2.tcpHandshakeDur = order.getLong();
            socketConnectionEventV2.confirmDur = order.getLong();
            socketConnectionEventV2.tlsHandshakeDur = order.getLong();
            socketConnectionEventV2.isMulti = order.getInt();
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                order.get(bArr2);
                socketConnectionEventV2.f37075ip = new String(bArr2);
            }
            return socketConnectionEventV2;
        }
    }

    public static class MsgAckEvent {
        long duration;

        /* renamed from: ip */
        String f37073ip;
        int msgCode;
        int msgSubType;
        int msgType;

        static MsgAckEvent fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            MsgAckEvent msgAckEvent = new MsgAckEvent();
            msgAckEvent.duration = order.getLong();
            msgAckEvent.msgType = order.getInt();
            msgAckEvent.msgSubType = order.getInt();
            msgAckEvent.msgCode = order.getInt();
            int i = order.getInt();
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                order.get(bArr2);
                msgAckEvent.f37073ip = new String(bArr2);
            }
            return msgAckEvent;
        }
    }

    public static class MsgFluxEvent {
        long flux;
        int fluxType;
        int msgType;

        static MsgFluxEvent fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            MsgFluxEvent msgFluxEvent = new MsgFluxEvent();
            msgFluxEvent.fluxType = order.getInt();
            msgFluxEvent.msgType = order.getInt();
            msgFluxEvent.flux = order.getLong();
            return msgFluxEvent;
        }
    }

    public static class PushQualityEvent {
        long appLiveDuration;
        long availableRate;
        long conLiveDuration;

        /* renamed from: ip */
        String f37074ip;
        long reconnectDuration;
        long reconnectTimes;
        int type;

        static PushQualityEvent fromBytes(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            PushQualityEvent pushQualityEvent = new PushQualityEvent();
            pushQualityEvent.type = order.getInt();
            int i = order.getInt();
            pushQualityEvent.conLiveDuration = order.getLong();
            pushQualityEvent.appLiveDuration = order.getLong();
            pushQualityEvent.availableRate = order.getLong();
            pushQualityEvent.reconnectTimes = order.getLong();
            pushQualityEvent.reconnectDuration = order.getLong();
            if (i > 0) {
                byte[] bArr2 = new byte[i];
                order.get(bArr2);
                pushQualityEvent.f37074ip = new String(bArr2);
            }
            return pushQualityEvent;
        }

        public String toString() {
            return "PushQualityEvent{type = " + this.type + ", ip = " + this.f37074ip + ", conLiveDuration = " + this.conLiveDuration + ", appLiveDuration = " + this.appLiveDuration + ", availableRate = " + this.availableRate + ", reconnectTimes = " + this.reconnectTimes + ", reconnectDuration = " + this.reconnectDuration + "}";
        }
    }
}
