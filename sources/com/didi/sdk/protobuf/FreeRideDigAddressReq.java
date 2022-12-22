package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class FreeRideDigAddressReq extends Message {
    public static final String DEFAULT_ADDRESS = "";
    public static final String DEFAULT_ALERTTEXT = "";
    public static final Integer DEFAULT_EXPIRETIME = 0;
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final Integer DEFAULT_PUSHTIME = 0;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String address;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.STRING)
    public final String alertText;
    @ProtoField(label = Message.Label.REQUIRED, tag = 9, type = Message.Datatype.INT32)
    public final Integer expireTime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.INT32)
    public final Integer pushTime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
    }

    public FreeRideDigAddressReq(Double d, Double d2, CoordinateType coordinateType, String str, String str2, String str3, String str4, Integer num, Integer num2) {
        this.lng = d;
        this.lat = d2;
        this.type = coordinateType;
        this.address = str;
        this.title = str2;
        this.text = str3;
        this.alertText = str4;
        this.pushTime = num;
        this.expireTime = num2;
    }

    private FreeRideDigAddressReq(Builder builder) {
        this(builder.lng, builder.lat, builder.type, builder.address, builder.title, builder.text, builder.alertText, builder.pushTime, builder.expireTime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FreeRideDigAddressReq)) {
            return false;
        }
        FreeRideDigAddressReq freeRideDigAddressReq = (FreeRideDigAddressReq) obj;
        if (!equals((Object) this.lng, (Object) freeRideDigAddressReq.lng) || !equals((Object) this.lat, (Object) freeRideDigAddressReq.lat) || !equals((Object) this.type, (Object) freeRideDigAddressReq.type) || !equals((Object) this.address, (Object) freeRideDigAddressReq.address) || !equals((Object) this.title, (Object) freeRideDigAddressReq.title) || !equals((Object) this.text, (Object) freeRideDigAddressReq.text) || !equals((Object) this.alertText, (Object) freeRideDigAddressReq.alertText) || !equals((Object) this.pushTime, (Object) freeRideDigAddressReq.pushTime) || !equals((Object) this.expireTime, (Object) freeRideDigAddressReq.expireTime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Double d = this.lng;
        int i2 = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 37;
        Double d2 = this.lat;
        int hashCode2 = (hashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        CoordinateType coordinateType = this.type;
        int hashCode3 = (hashCode2 + (coordinateType != null ? coordinateType.hashCode() : 0)) * 37;
        String str = this.address;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.title;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.text;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.alertText;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num = this.pushTime;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.expireTime;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<FreeRideDigAddressReq> {
        public String address;
        public String alertText;
        public Integer expireTime;
        public Double lat;
        public Double lng;
        public Integer pushTime;
        public String text;
        public String title;
        public CoordinateType type;

        public Builder() {
        }

        public Builder(FreeRideDigAddressReq freeRideDigAddressReq) {
            super(freeRideDigAddressReq);
            if (freeRideDigAddressReq != null) {
                this.lng = freeRideDigAddressReq.lng;
                this.lat = freeRideDigAddressReq.lat;
                this.type = freeRideDigAddressReq.type;
                this.address = freeRideDigAddressReq.address;
                this.title = freeRideDigAddressReq.title;
                this.text = freeRideDigAddressReq.text;
                this.alertText = freeRideDigAddressReq.alertText;
                this.pushTime = freeRideDigAddressReq.pushTime;
                this.expireTime = freeRideDigAddressReq.expireTime;
            }
        }

        public Builder lng(Double d) {
            this.lng = d;
            return this;
        }

        public Builder lat(Double d) {
            this.lat = d;
            return this;
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
            return this;
        }

        public Builder address(String str) {
            this.address = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder alertText(String str) {
            this.alertText = str;
            return this;
        }

        public Builder pushTime(Integer num) {
            this.pushTime = num;
            return this;
        }

        public Builder expireTime(Integer num) {
            this.expireTime = num;
            return this;
        }

        public FreeRideDigAddressReq build() {
            checkRequiredFields();
            return new FreeRideDigAddressReq(this);
        }
    }
}
