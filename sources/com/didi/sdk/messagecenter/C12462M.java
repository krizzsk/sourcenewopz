package com.didi.sdk.messagecenter;

import com.didi.sdk.messagecenter.annotations.Subscriber;
import com.didi.sdk.messagecenter.model.BaseMessage;
import com.didi.sdk.messagecenter.p152pb.CdntSvrDownReq;
import com.didi.sdk.messagecenter.p152pb.CommonMsgReq;
import com.didi.sdk.messagecenter.p152pb.GulfstreamPassengerDriverLocReq;
import com.didi.sdk.messagecenter.p152pb.MsgType;
import com.didi.sdk.messagecenter.p152pb.OrderPaySuccReq;
import com.didi.sdk.messagecenter.p152pb.OrderRealtimeFeeReq;
import com.didi.sdk.messagecenter.p152pb.OrderTotalFeeReq;
import com.didi.sdk.messagecenter.p152pb.POPEActionReq;
import com.didi.sdk.messagecenter.p152pb.PreAuthResultReq;
import com.didi.sdk.messagecenter.p152pb.PushMessageType;
import com.didi.sdk.messagecenter.p152pb.UnifyReq;
import com.squareup.wire.Message;

/* renamed from: com.didi.sdk.messagecenter.M */
public class C12462M {

    @Subscriber(alternativeTopic = {MsgType.kMsgTypeCdntSvrDownReq})
    /* renamed from: com.didi.sdk.messagecenter.M$CdntSvrDownMsg */
    public static class CdntSvrDownMsg extends BaseMessage<CdntSvrDownReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeCommonMsgReq})
    /* renamed from: com.didi.sdk.messagecenter.M$CommonMsg */
    public static class CommonMsg extends BaseMessage<CommonMsgReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeGulfstreamPassengerDriverLocByIdsReq})
    /* renamed from: com.didi.sdk.messagecenter.M$DriverLocByIdMsg */
    public static class DriverLocByIdMsg extends BaseMessage<GulfstreamPassengerDriverLocReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeGulfstreamPassengerDriverLocReq})
    /* renamed from: com.didi.sdk.messagecenter.M$DriverLocMsg */
    public static class DriverLocMsg extends BaseMessage<GulfstreamPassengerDriverLocReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypePassengerMultiRouteRes})
    /* renamed from: com.didi.sdk.messagecenter.M$MultiRouteMsg */
    public static class MultiRouteMsg extends BaseMessage<Message> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeOrderPaySuccReq})
    /* renamed from: com.didi.sdk.messagecenter.M$OrderPaySucMsg */
    public static class OrderPaySucMsg extends BaseMessage<OrderPaySuccReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeOrderRealtimeFeeReq})
    /* renamed from: com.didi.sdk.messagecenter.M$OrderRealtimeFeeMsg */
    public static class OrderRealtimeFeeMsg extends BaseMessage<OrderRealtimeFeeReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeMapPassengerOrderRouteNotifyReq})
    /* renamed from: com.didi.sdk.messagecenter.M$OrderRouteNotifyReqMsg */
    public static class OrderRouteNotifyReqMsg extends BaseMessage<Message> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeMapPassengerOrderRouteRes})
    /* renamed from: com.didi.sdk.messagecenter.M$OrderRouteResMsg */
    public static class OrderRouteResMsg extends BaseMessage<Message> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeOrderTotalFeeReq})
    /* renamed from: com.didi.sdk.messagecenter.M$OrderTotalFeeMsg */
    public static class OrderTotalFeeMsg extends BaseMessage<OrderTotalFeeReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypePOPEActionReq})
    /* renamed from: com.didi.sdk.messagecenter.M$PopeActionMsg */
    public static class PopeActionMsg extends BaseMessage<POPEActionReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypePreAuthResultReq})
    /* renamed from: com.didi.sdk.messagecenter.M$PreAuthResultMsg */
    public static class PreAuthResultMsg extends BaseMessage<PreAuthResultReq> {
    }

    @Subscriber(topic = {PushMessageType.kPushMessageTypeUnifyReq})
    /* renamed from: com.didi.sdk.messagecenter.M$UnifyMsg */
    public static class UnifyMsg extends BaseMessage<UnifyReq> {
    }
}
