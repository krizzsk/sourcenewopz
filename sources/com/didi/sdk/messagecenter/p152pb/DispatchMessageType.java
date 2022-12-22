package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: com.didi.sdk.messagecenter.pb.DispatchMessageType */
public enum DispatchMessageType implements ProtoEnum {
    kDispatchMessageTypeDriverOrderGetReq(1),
    kDispatchMessageTypeMonitorResultReq(2),
    kDispatchMessageTypeOnlineModeConnectReq(3),
    kDispatchMessageTypeOnlineModeDisconnectReq(4),
    kDispatchMessageTypePassengerOrderGetReq(5),
    kDispatchMessageTypeDriverOrderMoneyGetReq(6),
    kDispatchMessageTypePassengerPayStatusReq(7),
    kDispatchMessageTypeDriverFilterOrderReq(8),
    kDispatchMessageTypePassengerDiverLocGetByLocReq(9),
    kDispatchMessageTypePassengerDiverLocGetByIdReq(10),
    kDispatchMessageTypeESMessageReq(11),
    kDispatchMessageTypeGovMessageReq(12),
    kDispatchMessageTypeTravelDriverOrderMoneyGetReq(16),
    kDispatchMessageTypeTaxiDriverDetectListenOrderExceptionReq(17),
    kDispatchMessageTypeReportSecureCheckResultReq(18),
    kDispatchMessageTypeGalileoDlocReq(19),
    kDispatchMessageTypeDriverDenyOrderReq(20),
    kDispatchMessageTypeDriverGrabOrderReq(21),
    kDispatchMessageTypeTaxiDriverFilterOrderReq(22),
    kDispatchMessageTypeMapPassengerOrderRouteReq(23),
    kDispatchMessageTypeDriverOrderMoneyGetReqV2(24),
    kDispatchMessageTypeGovDriverMessageReq(25),
    kDispatchMessageTypeTaxiDriverAntiCheatReq(26),
    kDispatchMessageTypeDriverDispatchResp(27),
    KDispatchMessageTypeMapPassengerMultiRouteListReq(28);
    
    private final int value;

    private DispatchMessageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
