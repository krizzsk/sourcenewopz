package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class BinaryMsg extends Message {
    public static final Long DEFAULT_CITY_ID = 0L;
    public static final String DEFAULT_HINT_CONTENT = "";
    public static final String DEFAULT_LOCATION_CITYID = "";
    public static final String DEFAULT_LOCATION_COUNTRY = "";
    public static final ByteString DEFAULT_PAYLOAD = ByteString.EMPTY;
    public static final Long DEFAULT_PRODUCT_ID = 0L;
    public static final String DEFAULT_TRIP_CITYID = "";
    public static final String DEFAULT_TRIP_COUNTRY = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long city_id;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String hint_content;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String location_cityid;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String location_country;
    @ProtoField(tag = 2, type = Message.Datatype.BYTES)
    public final ByteString payload;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long product_id;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String trip_cityid;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String trip_country;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;

    public BinaryMsg(Integer num, ByteString byteString, Long l, Long l2, String str, String str2, String str3, String str4, String str5) {
        this.type = num;
        this.payload = byteString;
        this.city_id = l;
        this.product_id = l2;
        this.hint_content = str;
        this.trip_country = str2;
        this.trip_cityid = str3;
        this.location_country = str4;
        this.location_cityid = str5;
    }

    private BinaryMsg(Builder builder) {
        this(builder.type, builder.payload, builder.city_id, builder.product_id, builder.hint_content, builder.trip_country, builder.trip_cityid, builder.location_country, builder.location_cityid);
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
        if (!equals((Object) this.type, (Object) binaryMsg.type) || !equals((Object) this.payload, (Object) binaryMsg.payload) || !equals((Object) this.city_id, (Object) binaryMsg.city_id) || !equals((Object) this.product_id, (Object) binaryMsg.product_id) || !equals((Object) this.hint_content, (Object) binaryMsg.hint_content) || !equals((Object) this.trip_country, (Object) binaryMsg.trip_country) || !equals((Object) this.trip_cityid, (Object) binaryMsg.trip_cityid) || !equals((Object) this.location_country, (Object) binaryMsg.location_country) || !equals((Object) this.location_cityid, (Object) binaryMsg.location_cityid)) {
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
        String str = this.hint_content;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.trip_country;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.trip_cityid;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.location_country;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.location_cityid;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BinaryMsg> {
        public Long city_id;
        public String hint_content;
        public String location_cityid;
        public String location_country;
        public ByteString payload;
        public Long product_id;
        public String trip_cityid;
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
                this.hint_content = binaryMsg.hint_content;
                this.trip_country = binaryMsg.trip_country;
                this.trip_cityid = binaryMsg.trip_cityid;
                this.location_country = binaryMsg.location_country;
                this.location_cityid = binaryMsg.location_cityid;
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

        public Builder hint_content(String str) {
            this.hint_content = str;
            return this;
        }

        public Builder trip_country(String str) {
            this.trip_country = str;
            return this;
        }

        public Builder trip_cityid(String str) {
            this.trip_cityid = str;
            return this;
        }

        public Builder location_country(String str) {
            this.location_country = str;
            return this;
        }

        public Builder location_cityid(String str) {
            this.location_cityid = str;
            return this;
        }

        public BinaryMsg build() {
            checkRequiredFields();
            return new BinaryMsg(this);
        }
    }
}
