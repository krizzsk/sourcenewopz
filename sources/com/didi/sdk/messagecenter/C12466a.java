package com.didi.sdk.messagecenter;

import com.didi.sdk.messagecenter.p152pb.MsgType;
import com.didi.sdk.messagecenter.util.MLog;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushRequest;
import com.squareup.wire.Message;

/* renamed from: com.didi.sdk.messagecenter.a */
/* compiled from: MessageSender */
class C12466a {

    /* renamed from: a */
    private static final C12466a f36758a = new C12466a();

    /* renamed from: a */
    static C12466a m26019a() {
        return f36758a;
    }

    private C12466a() {
    }

    /* renamed from: a */
    public void mo92858a(Message message) {
        mo92859a(message, (PushCallback) null);
    }

    /* renamed from: a */
    public void mo92859a(Message message, PushCallback pushCallback) {
        mo92857a(MsgType.kMsgTypeDispatchSvrNoRspReq, message, pushCallback);
    }

    /* renamed from: a */
    public void mo92856a(MsgType msgType, Message message) {
        mo92857a(msgType, message, (PushCallback) null);
    }

    /* renamed from: a */
    public void mo92857a(MsgType msgType, Message message, PushCallback pushCallback) {
        if (message == null) {
            MLog.m26061w("send msg: message is null");
            return;
        }
        MLog.m26060i("send msg: " + msgType + "|" + message.getClass() + "|" + pushCallback);
        if (!PushClient.getClient().isConnected()) {
            MLog.m26061w("push client is not connected!");
            return;
        }
        PushRequest build = new PushRequest.Builder().msgType(msgType.getValue()).data(message.toByteArray()).needResponse(pushCallback != null).seqIdOut(new byte[8]).priority(0).build();
        if (pushCallback != null) {
            PushClient.getClient().sendRequest(build, new MessageSender$1(this, pushCallback));
        } else {
            PushClient.getClient().sendRequest(build);
        }
    }
}
