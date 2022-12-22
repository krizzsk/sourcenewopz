package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class DispatchSvrRsp extends Message {
    public static final ByteString DEFAULT_BODY = ByteString.EMPTY;
    public static final Integer DEFAULT_HTTP_STATUS_CODE = 0;
    public static final Integer DEFAULT_SYS_CODE = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final ByteString body;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer http_status_code;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer sys_code;

    public DispatchSvrRsp(Integer num, Integer num2, ByteString byteString) {
        this.sys_code = num;
        this.http_status_code = num2;
        this.body = byteString;
    }

    private DispatchSvrRsp(Builder builder) {
        this(builder.sys_code, builder.http_status_code, builder.body);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DispatchSvrRsp)) {
            return false;
        }
        DispatchSvrRsp dispatchSvrRsp = (DispatchSvrRsp) obj;
        if (!equals((Object) this.sys_code, (Object) dispatchSvrRsp.sys_code) || !equals((Object) this.http_status_code, (Object) dispatchSvrRsp.http_status_code) || !equals((Object) this.body, (Object) dispatchSvrRsp.body)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.sys_code;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.http_status_code;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        ByteString byteString = this.body;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DispatchSvrRsp> {
        public ByteString body;
        public Integer http_status_code;
        public Integer sys_code;

        public Builder() {
        }

        public Builder(DispatchSvrRsp dispatchSvrRsp) {
            super(dispatchSvrRsp);
            if (dispatchSvrRsp != null) {
                this.sys_code = dispatchSvrRsp.sys_code;
                this.http_status_code = dispatchSvrRsp.http_status_code;
                this.body = dispatchSvrRsp.body;
            }
        }

        public Builder sys_code(Integer num) {
            this.sys_code = num;
            return this;
        }

        public Builder http_status_code(Integer num) {
            this.http_status_code = num;
            return this;
        }

        public Builder body(ByteString byteString) {
            this.body = byteString;
            return this;
        }

        public DispatchSvrRsp build() {
            checkRequiredFields();
            return new DispatchSvrRsp(this);
        }
    }
}
