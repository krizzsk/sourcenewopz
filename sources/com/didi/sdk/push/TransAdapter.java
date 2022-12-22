package com.didi.sdk.push;

import com.didi.sdk.protobuf.MsgType;
import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.PushKey;
import com.didi.sdk.push.PushRequest;
import didinet.LocalIPStack;
import didinet.PushAPI;
import diditransreq.p231pb.PushMessageType;
import diditransreq.p231pb.PushMsg;

public class TransAdapter implements PushAPI {
    public boolean isPushInited() {
        return PushInitedListener.hasInited;
    }

    public boolean isConnected() {
        return PushClient.getClient().isConnected();
    }

    public LocalIPStack getLocalIPStack() {
        int localIPStackDetect = PushClient.getClient().localIPStackDetect();
        if (localIPStackDetect == 0) {
            return LocalIPStack.None;
        }
        if (localIPStackDetect == 1) {
            return LocalIPStack.IPv4;
        }
        if (localIPStackDetect == 2) {
            return LocalIPStack.IPv6;
        }
        if (localIPStackDetect != 3) {
            return LocalIPStack.IPv4;
        }
        return LocalIPStack.Dual;
    }

    public int request(int i, byte[] bArr, int i2, byte[] bArr2, boolean z) {
        PushRequest.Builder builder = new PushRequest.Builder();
        builder.msgType(i).data(bArr).priority(i2).seqIdOut(bArr2).needResponse(z);
        return PushClient.getClient().sendRequest(builder.build());
    }

    public void addPushCallback(final PushAPI.PushCallback pushCallback) {
        PushClient.getClient().registerMessageListener(PushKey.Creator.createAppPushMsgKey(PushMessageType.kPushMessageTypeTransBackendRsp.getValue()), new PushReceiveListener<PushMsgResponse>() {
            public void onReceive(PushMsgResponse pushMsgResponse) {
                PushMsg pushMsg = pushMsgResponse.getPushMsg();
                byte[] seqId = pushMsgResponse.getSeqId();
                if (pushMsg != null) {
                    PushMsg.Builder builder = new PushMsg.Builder();
                    builder.activity_id(pushMsg.activity_id).msg_id(pushMsg.msg_id).need_rsp(pushMsg.need_rsp).p_id(pushMsg.p_id).payload(pushMsg.payload).product(pushMsg.product).task_id(pushMsg.task_id).type(pushMsg.type);
                    pushCallback.response(MsgType.kMsgTypeAppPushMessageReq.getValue(), PushMessageType.kPushMessageTypeTransBackendRsp.getValue(), seqId, builder.build());
                }
            }
        });
        PushClient.getClient().registerMessageListener(PushKey.Creator.createPushMsgKey(MsgType.kMsgTypeTransRsp.getValue()), new PushReceiveListener<ByteArrayPushResponse>() {
            public void onReceive(ByteArrayPushResponse byteArrayPushResponse) {
                pushCallback.response(MsgType.kMsgTypeTransRsp.getValue(), 0, byteArrayPushResponse.getSeqId(), (diditransreq.p231pb.PushMsg) null);
            }
        });
    }

    public PushAPI.PushParam getPushParam() {
        PushAPI.PushParam pushParam = new PushAPI.PushParam();
        pushParam.pushHost = PushClient.getClient().getConnectIp();
        pushParam.pushPort = PushClient.getClient().getConnectPort();
        pushParam.tls = PushSelector.getDefault().isTLSOpen();
        pushParam.pushVer = PushSelector.getDefault().getPushVer();
        pushParam.isMulti = PushSelector.getDefault().getRouteType() == RouteType.MULTI_ADDRESS ? 1 : 0;
        pushParam.confVer = PushSelector.getDefault().getConfVersion();
        return pushParam;
    }
}
