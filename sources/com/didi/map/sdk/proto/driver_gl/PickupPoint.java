package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PickupPoint extends Message {
    public static final String DEFAULT_ADDRESS = "";
    public static final String DEFAULT_DISPLAYNAME = "";
    public static final String DEFAULT_FULLNAME = "";
    public static final Double DEFAULT_LAT;
    public static final Double DEFAULT_LNG;
    public static final String DEFAULT_POIID = "";
    public static final String DEFAULT_SRCTAG = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String address;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String displayName;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.STRING)
    public final String fullName;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.DOUBLE)
    public final Double lat;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.DOUBLE)
    public final Double lng;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String poiId;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String srcTag;

    static {
        Double valueOf = Double.valueOf(0.0d);
        DEFAULT_LNG = valueOf;
        DEFAULT_LAT = valueOf;
    }

    public PickupPoint(Double d, Double d2, String str, String str2, String str3, String str4, String str5) {
        this.lng = d;
        this.lat = d2;
        this.poiId = str;
        this.displayName = str2;
        this.address = str3;
        this.fullName = str4;
        this.srcTag = str5;
    }

    private PickupPoint(Builder builder) {
        this(builder.lng, builder.lat, builder.poiId, builder.displayName, builder.address, builder.fullName, builder.srcTag);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickupPoint)) {
            return false;
        }
        PickupPoint pickupPoint = (PickupPoint) obj;
        if (!equals((Object) this.lng, (Object) pickupPoint.lng) || !equals((Object) this.lat, (Object) pickupPoint.lat) || !equals((Object) this.poiId, (Object) pickupPoint.poiId) || !equals((Object) this.displayName, (Object) pickupPoint.displayName) || !equals((Object) this.address, (Object) pickupPoint.address) || !equals((Object) this.fullName, (Object) pickupPoint.fullName) || !equals((Object) this.srcTag, (Object) pickupPoint.srcTag)) {
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
        String str = this.poiId;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.displayName;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.address;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.fullName;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.srcTag;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PickupPoint> {
        public String address;
        public String displayName;
        public String fullName;
        public Double lat;
        public Double lng;
        public String poiId;
        public String srcTag;

        public Builder() {
        }

        public Builder(PickupPoint pickupPoint) {
            super(pickupPoint);
            if (pickupPoint != null) {
                this.lng = pickupPoint.lng;
                this.lat = pickupPoint.lat;
                this.poiId = pickupPoint.poiId;
                this.displayName = pickupPoint.displayName;
                this.address = pickupPoint.address;
                this.fullName = pickupPoint.fullName;
                this.srcTag = pickupPoint.srcTag;
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

        public Builder poiId(String str) {
            this.poiId = str;
            return this;
        }

        public Builder displayName(String str) {
            this.displayName = str;
            return this;
        }

        public Builder address(String str) {
            this.address = str;
            return this;
        }

        public Builder fullName(String str) {
            this.fullName = str;
            return this;
        }

        public Builder srcTag(String str) {
            this.srcTag = str;
            return this;
        }

        public PickupPoint build() {
            checkRequiredFields();
            return new PickupPoint(this);
        }
    }
}
