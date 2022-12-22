package diditransreq.p231pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: diditransreq.pb.MsgType */
public enum MsgType implements ProtoEnum {
    kMsgTypeAppPushMessageReq(263),
    kMsgTypeTransTypeMin(3840),
    kMsgTypeTransReq(3841),
    kMsgTypeTransRsp(3842),
    kMsgTypeTransTypeMax(4095);
    
    private final int value;

    private MsgType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
