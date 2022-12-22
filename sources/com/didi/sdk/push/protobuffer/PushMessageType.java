package com.didi.sdk.push.protobuffer;

import com.squareup.wire.ProtoEnum;

public enum PushMessageType implements ProtoEnum {
    kPushMessageTypeDriverOrderComingReq(1),
    kPushMessageTypeDriverOrderStrivedReq(4),
    kPushMessageTypeDriverOrderCancelledReq(6),
    kPushMessageTypeDriverOrderChangeTipReq(8),
    kPushMessageTypeDriverMsgBroadcastReq(10),
    kPushMessageTypeDriverUploadLogReq(12),
    kPushMessageTypeDriverTraceLogReq(13),
    kPushMessageTypeDriverMonitorInfoReq(14),
    kPushMessageTypeDriverCoordinateUploadReq(15),
    kPushMessageTypeDriverAppCheckReq(16),
    kPushMessageTypeMessageSvrNotification(17),
    kPushMessageTypeDriverAppRestartReq(18),
    kPushMessageTypeDriverMsgPayReq(19),
    kPushMessageTypePassengerOrderStatusReq(20),
    kPushMessageTypeOrderTotalCountReq(21),
    kPushMessageTypeOrderRealtimeCountReq(22),
    kPushMessageTypeCommonMsgReq(23),
    kPushMessageTypeOrderPaySuccReq(24),
    kPushMessageTypeOrderChargeSuccReq(25),
    kPushMessageTypeOspreyOrderStriveSuccReq(26),
    kPushMessageTypeOspreyOrderStriveFailReq(27),
    kPushMessageTypeOspreyOrderStrivedReq(28),
    kPushMessageTypeOspreyDriverBuffChangeReq(29),
    kPushMessageTypeWxAgentReq(30),
    kPushMessageTypeTimelyRemindReq(48),
    kPushMessageTypePassengerPaySuccReq(49),
    kPushMessageTypeFreeRideDigAddressReq(50),
    kPushMessageTypeTaxiDriverLetPayReq(51),
    kPushMessageTypeTaxiDriverHasGetCashReq(52),
    kPushMessageTypeTaxiPassengerTerminateOrderReq(53),
    kPushMessageTypeTaxiPassengerPaySuccReq(54),
    kPushMessageTypeTaxiDriverShareTripLetPayReq(55),
    kPushMessageTypeTaxiPassengerTerminateOrderNoticeTripFriendReq(56),
    kPushMessageTypeTaxiDriverOrderComingReq(64),
    kPushMessageTypeTaxiDriverOrderStriveSuccReq(65),
    kPushMessageTypeTaxiDriverOrderStriveFailReq(66),
    kPushMessageTypeTaxiDriverConsultResultReq(67),
    kPushMessageTypeTaxiPassengerChargeReq(81),
    kPushMessageTypeTaxiPassengerBussinessCallbackReq(82),
    kPushMessageTypeTaxiPassengerUploadLogReq(144),
    kPushMessageTypeTaxiPassengerOrderEventReq(96),
    kPushMessageTypeBusinessPassengerGameRecommendReq(256),
    kPushMessageTypeBusinessPassengerGameRemindReq(257),
    kPushMessageTypeBeatlesOrderDataChangedTipReq(512),
    kPushMessageTypeBeatlesDriverNewOrderTipReq(513),
    kPushMessageTypeBeatlesNewOrderPushReq(514),
    kPushMessageTypeBeatlesRoutePushReq(515),
    kPushMessageTypeBeatlesReportControlPushReq(516),
    kPushMessageTypeOrderRealtimeFeeReq(128),
    kPushMessageTypeOrderTotalFeeReq(129),
    kPushMessageTypeGulfstreamPassengerDriverLocReq(258),
    kPushMessageTypeGulfstreamPassengerDriverLocByIdsReq(259),
    kPushMessageTypeSecurityCommonClientCheckReq(274),
    kPushMessageTypeNovaPassengerOrderNoticeTipReq(1025),
    kPushMessageTypeNovaDriverOrderNoticeTipReq(1026),
    kPushMessageTypeNovaPassengerWaitingOrderTipReq(1027),
    kPushMessageTypeNovaDriverPushOrderTipReq(1028),
    kPushMessageTypeIM(4096),
    kPushMessageTypeNovaPriceNoticeTipReq(1030),
    kPushMessageTypeMsgCenterNotificationReq(1536),
    kPushMessageTypeTransBackendRsp(2048),
    kPushMessageTypeXProxyBackendReq(2049);
    
    private final int value;

    private PushMessageType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
