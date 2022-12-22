package com.didi.sdk.push;

import android.text.TextUtils;
import com.didi.sdk.push.IPushCallback;
import com.didi.sdk.push.PushRequestCallback;
import com.didi.sdk.push.log.AvailableRateLogEvent;
import com.didi.sdk.push.log.ConnEvent;
import com.didi.sdk.push.log.ConnEventV2;
import com.didi.sdk.push.log.ExtendConnEvent;
import com.didi.sdk.push.log.MsgAckLogEvent;
import com.didi.sdk.push.log.MsgFluxLogEvent;
import com.didi.sdk.push.log.NativeLogEvent;
import com.didi.sdk.push.log.PushQualityLogEvent;
import com.didi.sdk.push.log.TransactionEvent;

class PushCallback implements IPushCallback {
    public static final String TAG = "push-debug";

    public byte[] onHandleHeader(byte[] bArr) {
        return null;
    }

    public void onProgress(byte[] bArr, int i, int i2) {
    }

    public void onConnection(IPushCallback.Connection connection) {
        if (connection != null) {
            PushLog.m26280d(TAG, String.format("onConnection() called with (retCode = %d, subCode=%d)", new Object[]{Integer.valueOf(connection.code), Integer.valueOf(connection.subCode)}));
            if (!TextUtils.isEmpty(connection.f37072ip)) {
                PushClient.getClient().setConnectIp(connection.f37072ip);
                PushClient.getClient().setConnectPort(connection.port);
            }
            PushConnResult pushConnResult = new PushConnResult();
            pushConnResult.setRetCode(connection.code);
            pushConnResult.setSubCode(connection.subCode);
            pushConnResult.setExtraMsg(connection.extraMsg);
            if (!(connection.code == 0 && connection.subCode == 0)) {
                PushConnectionDispatcher.getInstance().notifyConnection(pushConnResult);
            }
            ConnEvent.Builder builder = new ConnEvent.Builder();
            builder.errorCode(connection.code).subCode(connection.subCode).extraMsg(connection.extraMsg);
            LogEventManager.getInstance().onTrackConnection(builder.build());
        }
    }

    public void onRequested(int i, int i2, byte[] bArr) {
        PushLog.m26280d(TAG, String.format("onRequest called with retCode = [%d], msgType = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        PushOnRequestDispatcher.getInstance().dispatch(new PushRequestCallback.CallbackInfo(i, i2, bArr));
    }

    public void onReceive(int i, byte[] bArr, byte[] bArr2) {
        PushMessageDispatcher.getInstance().dispatcherMessage(i, bArr, bArr2);
    }

    public void onLog(int i, String str) {
        PushLog.m26280d(TAG, String.format("native log : level = [%d], msg = [%s]", new Object[]{Integer.valueOf(i), str}));
        NativeLogEvent nativeLogEvent = new NativeLogEvent();
        nativeLogEvent.setLevel(i);
        nativeLogEvent.setMsg(str);
        LogEventManager.getInstance().onPushNativeLog(nativeLogEvent);
    }

    public void onTrackTransaction(IPushCallback.SocketTransactionEvent socketTransactionEvent) {
        if (socketTransactionEvent != null) {
            PushLog.m26280d("TransactionEvent", socketTransactionEvent.toString());
            TransactionEvent.Builder builder = new TransactionEvent.Builder();
            builder.seqId(socketTransactionEvent.seqId).msgType(socketTransactionEvent.msgType).mo95708up(socketTransactionEvent.f37076up).down(socketTransactionEvent.down).time(socketTransactionEvent.time).tls(socketTransactionEvent.tls);
            LogEventManager.getInstance().onTrackTransaction(builder.build());
        }
    }

    public void onTrackConnection(IPushCallback.SocketConnectionEvent socketConnectionEvent) {
        if (socketConnectionEvent != null) {
            PushLog.m26280d("ConnEvent", socketConnectionEvent.toString());
            ExtendConnEvent.Builder builder = new ExtendConnEvent.Builder();
            builder.errorCode(socketConnectionEvent.errorCode).subCode(socketConnectionEvent.subCode).type(socketConnectionEvent.type).tls(socketConnectionEvent.tls).connectDuration(socketConnectionEvent.connectDuration).appStartDuration(socketConnectionEvent.appStartDuration).failedTimes(socketConnectionEvent.failedTimes).maintainDuration(socketConnectionEvent.maintainDuration).lastFailDuration(socketConnectionEvent.lastFailDuration);
            LogEventManager.getInstance().onTrackConnection(builder.build());
        }
    }

    public void onTrackConnection(IPushCallback.SocketConnectionEventV2 socketConnectionEventV2) {
        if (socketConnectionEventV2 != null) {
            ConnEventV2.Builder builder = new ConnEventV2.Builder();
            builder.mo95652ip(socketConnectionEventV2.f37075ip).port(socketConnectionEventV2.port).tcpHandshakeDur(socketConnectionEventV2.tcpHandshakeDur).confirmDur(socketConnectionEventV2.confirmDur).tlsHandshakeDur(socketConnectionEventV2.tlsHandshakeDur).isMulti(socketConnectionEventV2.isMulti);
            LogEventManager.getInstance().onTrackConnectionV2(builder.build());
        }
    }

    public void onTrackAvailableRate(IPushCallback.AvailableRateEvent availableRateEvent) {
        if (availableRateEvent != null) {
            PushLog.m26280d("AvailableRateEvent", availableRateEvent.toString());
            AvailableRateLogEvent.Builder builder = new AvailableRateLogEvent.Builder();
            builder.availableRate(availableRateEvent.availableRate).availableTime(availableRateEvent.availableTime).connectSuccess(availableRateEvent.connectSuccess).connectTotal(availableRateEvent.connectTotal).sleepTimes(availableRateEvent.sleepTimes).totalSleepDuration(availableRateEvent.totalSleepDuration).totalTime(availableRateEvent.totalTime);
            LogEventManager.getInstance().onTrackAvailableRate(builder.build());
        }
    }

    public void onTrackMsgAck(IPushCallback.MsgAckEvent msgAckEvent) {
        if (msgAckEvent != null) {
            MsgAckLogEvent.Builder builder = new MsgAckLogEvent.Builder();
            builder.duration(msgAckEvent.duration).msgType(msgAckEvent.msgType).msgSubType(msgAckEvent.msgSubType).msgCode(msgAckEvent.msgCode).mo95676ip(msgAckEvent.f37073ip);
            LogEventManager.getInstance().onTrackMsgAckEvent(builder.build());
        }
    }

    public void onTrackMsgFlux(IPushCallback.MsgFluxEvent msgFluxEvent) {
        if (msgFluxEvent != null) {
            PushLog.m26280d("MsgFluxEvent", msgFluxEvent.toString());
            MsgFluxLogEvent.Builder builder = new MsgFluxLogEvent.Builder();
            builder.flux(msgFluxEvent.flux).fluxType(msgFluxEvent.fluxType).msgType(msgFluxEvent.msgType);
            LogEventManager.getInstance().onTrackMsgFluxEvent(builder.build());
        }
    }

    public void onTrackPushQualityEvent(IPushCallback.PushQualityEvent pushQualityEvent) {
        if (pushQualityEvent != null) {
            PushLog.m26280d("PushQualityEvent", pushQualityEvent.toString());
            PushQualityLogEvent.Builder builder = new PushQualityLogEvent.Builder();
            builder.type(pushQualityEvent.type).mo95692ip(pushQualityEvent.f37074ip).appLiveDuration(pushQualityEvent.appLiveDuration).availableRate(pushQualityEvent.availableRate).conLiveDuration(pushQualityEvent.conLiveDuration).reconnectDuration(pushQualityEvent.reconnectDuration).reconnectTimes(pushQualityEvent.reconnectTimes);
            LogEventManager.getInstance().onTrackPushQualityEvent(builder.build());
        }
    }
}
