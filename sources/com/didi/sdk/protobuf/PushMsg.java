package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class PushMsg extends Message {
    public static final Long DEFAULT_ACTIVITY_ID = 0L;
    public static final ByteString DEFAULT_MSG_ID = ByteString.EMPTY;
    public static final Boolean DEFAULT_NEED_RSP = false;
    public static final ByteString DEFAULT_PAYLOAD = ByteString.EMPTY;
    public static final Integer DEFAULT_PRODUCT = 0;
    public static final Long DEFAULT_P_ID = 0L;
    public static final Long DEFAULT_TASK_ID = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long activity_id;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString msg_id;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean need_rsp;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long p_id;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString payload;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer product;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long task_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;

    public PushMsg(Integer num, ByteString byteString, Long l, ByteString byteString2, Boolean bool, Integer num2, Long l2, Long l3) {
        this.type = num;
        this.payload = byteString;
        this.task_id = l;
        this.msg_id = byteString2;
        this.need_rsp = bool;
        this.product = num2;
        this.activity_id = l2;
        this.p_id = l3;
    }

    private PushMsg(Builder builder) {
        this(builder.type, builder.payload, builder.task_id, builder.msg_id, builder.need_rsp, builder.product, builder.activity_id, builder.p_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushMsg)) {
            return false;
        }
        PushMsg pushMsg = (PushMsg) obj;
        if (!equals((Object) this.type, (Object) pushMsg.type) || !equals((Object) this.payload, (Object) pushMsg.payload) || !equals((Object) this.task_id, (Object) pushMsg.task_id) || !equals((Object) this.msg_id, (Object) pushMsg.msg_id) || !equals((Object) this.need_rsp, (Object) pushMsg.need_rsp) || !equals((Object) this.product, (Object) pushMsg.product) || !equals((Object) this.activity_id, (Object) pushMsg.activity_id) || !equals((Object) this.p_id, (Object) pushMsg.p_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        ByteString byteString = this.payload;
        int hashCode2 = (hashCode + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Long l = this.task_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        ByteString byteString2 = this.msg_id;
        int hashCode4 = (hashCode3 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        Boolean bool = this.need_rsp;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num2 = this.product;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.activity_id;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.p_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushMsg> {
        public Long activity_id;
        public ByteString msg_id;
        public Boolean need_rsp;
        public Long p_id;
        public ByteString payload;
        public Integer product;
        public Long task_id;
        public Integer type;

        public Builder() {
        }

        public Builder(PushMsg pushMsg) {
            super(pushMsg);
            if (pushMsg != null) {
                this.type = pushMsg.type;
                this.payload = pushMsg.payload;
                this.task_id = pushMsg.task_id;
                this.msg_id = pushMsg.msg_id;
                this.need_rsp = pushMsg.need_rsp;
                this.product = pushMsg.product;
                this.activity_id = pushMsg.activity_id;
                this.p_id = pushMsg.p_id;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder payload(ByteString byteString) {
            this.payload = byteString;
            return this;
        }

        public Builder task_id(Long l) {
            this.task_id = l;
            return this;
        }

        public Builder msg_id(ByteString byteString) {
            this.msg_id = byteString;
            return this;
        }

        public Builder need_rsp(Boolean bool) {
            this.need_rsp = bool;
            return this;
        }

        public Builder product(Integer num) {
            this.product = num;
            return this;
        }

        public Builder activity_id(Long l) {
            this.activity_id = l;
            return this;
        }

        public Builder p_id(Long l) {
            this.p_id = l;
            return this;
        }

        public PushMsg build() {
            checkRequiredFields();
            return new PushMsg(this);
        }
    }
}
