package com.didi.sdk.push.log;

public class LogEventAdapter implements LogEventListener {
    public void onNetworkChange(NetworkChangeEvent networkChangeEvent) {
    }

    public void onPushLoadError(LoadErrorEvent loadErrorEvent) {
    }

    public void onPushNativeLog(NativeLogEvent nativeLogEvent) {
    }

    public void onPushRequest(RequestEvent requestEvent) {
    }

    public void onTrackAvailableRateEvent(AvailableRateLogEvent availableRateLogEvent) {
    }

    public void onTrackConnection(ConnEvent connEvent) {
    }

    public void onTrackConnectionV2(ConnEventV2 connEventV2) {
    }

    public void onTrackMsgAckEvent(MsgAckLogEvent msgAckLogEvent) {
    }

    public void onTrackMsgFluxEvent(MsgFluxLogEvent msgFluxLogEvent) {
    }

    public void onTrackPushQualityEvent(PushQualityLogEvent pushQualityLogEvent) {
    }

    public void onTrackTransaction(TransactionEvent transactionEvent) {
    }
}
