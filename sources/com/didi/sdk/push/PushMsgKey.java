package com.didi.sdk.push;

/* compiled from: PushKey */
class PushMsgKey implements PushKey {
    int msgType;

    PushMsgKey(int i) {
        this.msgType = i;
    }

    public long generateKey() {
        return Utils.msgTypeAndpushType2Key(this.msgType, 0);
    }
}
