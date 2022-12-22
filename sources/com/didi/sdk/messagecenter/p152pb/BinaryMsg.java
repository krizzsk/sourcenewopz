package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

/* renamed from: com.didi.sdk.messagecenter.pb.BinaryMsg */
public final class BinaryMsg extends Message {
    public static final Long DEFAULT_CITY_ID = 0L;
    public static final ByteString DEFAULT_PAYLOAD = ByteString.EMPTY;
    public static final Long DEFAULT_PRODUCT_ID = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long city_id;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString payload;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long product_id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String trip_country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;

    public BinaryMsg(Integer num, ByteString byteString, Long l, Long l2, String str) {
        this.type = num;
        this.payload = byteString;
        this.city_id = l;
        this.product_id = l2;
        this.trip_country = str;
    }

    private BinaryMsg(Builder builder) {
        this(builder.type, builder.payload, builder.city_id, builder.product_id, builder.trip_country);
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
        if (!equals((Object) this.type, (Object) binaryMsg.type) || !equals((Object) this.payload, (Object) binaryMsg.payload) || !equals((Object) this.city_id, (Object) binaryMsg.city_id) || !equals((Object) this.product_id, (Object) binaryMsg.product_id) || !equals((Object) this.trip_country, (Object) binaryMsg.trip_country)) {
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
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.trip_country;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.BinaryMsg$Builder */
    public static final class Builder extends Message.Builder<BinaryMsg> {
        public Long city_id;
        public ByteString payload;
        public Long product_id;
        public String trip_country;
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
                this.trip_country = binaryMsg.trip_country;
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

        public Builder city_id(Long l) {
            this.city_id = l;
            return this;
        }

        public Builder product_id(Long l) {
            this.product_id = l;
            return this;
        }

        public Builder trip_country(String str) {
            this.trip_country = str;
            return this;
        }

        public BinaryMsg build() {
            checkRequiredFields();
            return new BinaryMsg(this);
        }
    }
}
