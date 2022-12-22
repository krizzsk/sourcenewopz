package com.didi.sdk.push.log;

public interface LogEventListener {
    void onNetworkChange(NetworkChangeEvent networkChangeEvent);

    void onPushLoadError(LoadErrorEvent loadErrorEvent);

    void onPushNativeLog(NativeLogEvent nativeLogEvent);

    void onPushRequest(RequestEvent requestEvent);

    void onTrackAvailableRateEvent(AvailableRateLogEvent availableRateLogEvent);

    void onTrackConnection(ConnEvent connEvent);

    void onTrackConnectionV2(ConnEventV2 connEventV2);

    void onTrackMsgAckEvent(MsgAckLogEvent msgAckLogEvent);

    void onTrackMsgFluxEvent(MsgFluxLogEvent msgFluxLogEvent);

    void onTrackPushQualityEvent(PushQualityLogEvent pushQualityLogEvent);

    void onTrackTransaction(TransactionEvent transactionEvent);
}
