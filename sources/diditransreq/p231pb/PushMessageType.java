package diditransreq.p231pb;

import com.squareup.wire.ProtoEnum;

/* renamed from: diditransreq.pb.PushMessageType */
public enum PushMessageType implements ProtoEnum {
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
