package com.didi.sdk.push;

import com.didi.sdk.protobuf.PushMsg;
import com.didi.sdk.push.PushResponse;

public class PushMsgResponse extends PushResponse {
    private PushMsg pushMsg;

    private PushMsgResponse(Builder builder) {
        this.msgType = builder.msgType;
        this.seqId = builder.seqId;
        this.pushMsg = builder.pushMsg;
    }

    public PushMsg getPushMsg() {
        return this.pushMsg;
    }

    public static final class Builder extends PushResponse.Builder<PushMsgResponse> {
        /* access modifiers changed from: private */
        public PushMsg pushMsg;

        public Builder msgType(int i) {
            this.msgType = i;
            return this;
        }

        public Builder seqId(byte[] bArr) {
            this.seqId = bArr;
            return this;
        }

        public Builder pushMsg(PushMsg pushMsg2) {
            this.pushMsg = pushMsg2;
            return this;
        }

        public PushMsgResponse build() {
            return new PushMsgResponse(this);
        }
    }
}
