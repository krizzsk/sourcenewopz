package com.didi.sdk.push;

import com.didi.sdk.protobuf.MsgType;

/* compiled from: PushKey */
class AppPushMsgKey extends PushMsgKey {
    private int payloadType;

    AppPushMsgKey(int i) {
        super(MsgType.kMsgTypeAppPushMessageReq.getValue());
        this.payloadType = i;
    }

    public long generateKey() {
        return Utils.msgTypeAndpushType2Key(this.msgType, this.payloadType);
    }
}
