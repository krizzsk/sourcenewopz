package com.didi.soda.customer.biz.sliding.p163pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.BinaryMsg */
public final class BinaryMsg extends Message {
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long city_id;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString payload;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long product_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;

    public BinaryMsg(Integer num, ByteString byteString, Long l, Long l2) {
        this.type = num;
        this.payload = byteString;
        this.city_id = l;
        this.product_id = l2;
    }

    private BinaryMsg(Builder builder) {
        this(builder.type, builder.payload, builder.city_id, builder.product_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BinaryMsg)) {
            return false;
        }
        BinaryMsg binaryMsg = (BinaryMsg) obj;
        if (!equals((Object) this.type, (Object) binaryMsg.type) || !equals((Object) this.payload, (Object) binaryMsg.payload) || !equals((Object) this.city_id, (Object) binaryMsg.city_id) || !equals((Object) this.product_id, (Object) binaryMsg.product_id)) {
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
        Long l = this.city_id;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.product_id;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.soda.customer.biz.sliding.pb.BinaryMsg$Builder */
    public static final class Builder extends Message.Builder<BinaryMsg> {
        public Long city_id;
        public ByteString payload;
        public Long product_id;
        public Integer type;

        public Builder() {
        }

        public Builder(BinaryMsg binaryMsg) {
            super(binaryMsg);
            if (binaryMsg != null) {
                this.type = binaryMsg.type;
                this.payload = binaryMsg.payload;
                this.city_id = binaryMsg.city_id;
                this.product_id = binaryMsg.product_id;
            }
        }

        public BinaryMsg build() {
            checkRequiredFields();
            return new BinaryMsg(this);
        }

        public Builder city_id(Long l) {
            this.city_id = l;
            return this;
        }

        public Builder payload(ByteString byteString) {
            this.payload = byteString;
            return this;
        }

        public Builder product_id(Long l) {
            this.product_id = l;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }
    }
}
