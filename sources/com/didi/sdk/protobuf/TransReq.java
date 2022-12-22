package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class TransReq extends Message {
    public static final Long DEFAULT_CITY_ID = 0L;
    public static final ByteString DEFAULT_COMPRESSED_PACK = ByteString.EMPTY;
    public static final Integer DEFAULT_COMPRESSION_FORMAT = 0;
    public static final Long DEFAULT_PRODUCT_ID = 0L;
    public static final Long DEFAULT_SEQID = 0L;
    public static final Integer DEFAULT_TIMEOUT_MS = 0;
    public static final Integer DEFAULT_VER = 0;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long city_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BYTES)
    public final ByteString compressed_pack;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT32)
    public final Integer compression_format;
    @ProtoField(tag = 7, type = Message.Datatype.UINT64)
    public final Long product_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long seqid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.INT32)
    public final Integer timeout_ms;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.INT32)
    public final Integer ver;

    public TransReq(Long l, ByteString byteString, Integer num, Integer num2, Integer num3, Long l2, Long l3) {
        this.seqid = l;
        this.compressed_pack = byteString;
        this.compression_format = num;
        this.timeout_ms = num2;
        this.ver = num3;
        this.city_id = l2;
        this.product_id = l3;
    }

    private TransReq(Builder builder) {
        this(builder.seqid, builder.compressed_pack, builder.compression_format, builder.timeout_ms, builder.ver, builder.city_id, builder.product_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransReq)) {
            return false;
        }
        TransReq transReq = (TransReq) obj;
        if (!equals((Object) this.seqid, (Object) transReq.seqid) || !equals((Object) this.compressed_pack, (Object) transReq.compressed_pack) || !equals((Object) this.compression_format, (Object) transReq.compression_format) || !equals((Object) this.timeout_ms, (Object) transReq.timeout_ms) || !equals((Object) this.ver, (Object) transReq.ver) || !equals((Object) this.city_id, (Object) transReq.city_id) || !equals((Object) this.product_id, (Object) transReq.product_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.seqid;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        ByteString byteString = this.compressed_pack;
        int hashCode2 = (hashCode + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Integer num = this.compression_format;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.timeout_ms;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.ver;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Long l2 = this.city_id;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.product_id;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TransReq> {
        public Long city_id;
        public ByteString compressed_pack;
        public Integer compression_format;
        public Long product_id;
        public Long seqid;
        public Integer timeout_ms;
        public Integer ver;

        public Builder() {
        }

        public Builder(TransReq transReq) {
            super(transReq);
            if (transReq != null) {
                this.seqid = transReq.seqid;
                this.compressed_pack = transReq.compressed_pack;
                this.compression_format = transReq.compression_format;
                this.timeout_ms = transReq.timeout_ms;
                this.ver = transReq.ver;
                this.city_id = transReq.city_id;
                this.product_id = transReq.product_id;
            }
        }

        public Builder seqid(Long l) {
            this.seqid = l;
            return this;
        }

        public Builder compressed_pack(ByteString byteString) {
            this.compressed_pack = byteString;
            return this;
        }

        public Builder compression_format(Integer num) {
            this.compression_format = num;
            return this;
        }

        public Builder timeout_ms(Integer num) {
            this.timeout_ms = num;
            return this;
        }

        public Builder ver(Integer num) {
            this.ver = num;
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

        public TransReq build() {
            checkRequiredFields();
            return new TransReq(this);
        }
    }
}
