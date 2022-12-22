package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UserLocation extends Message {
    public static final Double DEFAULT_ACCURACY = Double.valueOf(0.0d);
    public static final Integer DEFAULT_RET = 0;
    public static final LocationSource DEFAULT_SOURCE = LocationSource.GPS;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 6, type = Message.Datatype.DOUBLE)
    public final Double accuracy;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)
    public final LocationSource source;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long userId;
    @ProtoField(tag = 3)
    public final DoublePoint userLocation;

    public UserLocation(Integer num, Long l, DoublePoint doublePoint, Long l2, LocationSource locationSource, Double d) {
        this.ret = num;
        this.userId = l;
        this.userLocation = doublePoint;
        this.timestamp = l2;
        this.source = locationSource;
        this.accuracy = d;
    }

    private UserLocation(Builder builder) {
        this(builder.ret, builder.userId, builder.userLocation, builder.timestamp, builder.source, builder.accuracy);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLocation)) {
            return false;
        }
        UserLocation userLocation2 = (UserLocation) obj;
        if (!equals((Object) this.ret, (Object) userLocation2.ret) || !equals((Object) this.userId, (Object) userLocation2.userId) || !equals((Object) this.userLocation, (Object) userLocation2.userLocation) || !equals((Object) this.timestamp, (Object) userLocation2.timestamp) || !equals((Object) this.source, (Object) userLocation2.source) || !equals((Object) this.accuracy, (Object) userLocation2.accuracy)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.userId;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        DoublePoint doublePoint = this.userLocation;
        int hashCode3 = (hashCode2 + (doublePoint != null ? doublePoint.hashCode() : 0)) * 37;
        Long l2 = this.timestamp;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        LocationSource locationSource = this.source;
        int hashCode5 = (hashCode4 + (locationSource != null ? locationSource.hashCode() : 0)) * 37;
        Double d = this.accuracy;
        if (d != null) {
            i2 = d.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLocation> {
        public Double accuracy;
        public Integer ret;
        public LocationSource source;
        public Long timestamp;
        public Long userId;
        public DoublePoint userLocation;

        public Builder() {
        }

        public Builder(UserLocation userLocation2) {
            super(userLocation2);
            if (userLocation2 != null) {
                this.ret = userLocation2.ret;
                this.userId = userLocation2.userId;
                this.userLocation = userLocation2.userLocation;
                this.timestamp = userLocation2.timestamp;
                this.source = userLocation2.source;
                this.accuracy = userLocation2.accuracy;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder userLocation(DoublePoint doublePoint) {
            this.userLocation = doublePoint;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder source(LocationSource locationSource) {
            this.source = locationSource;
            return this;
        }

        public Builder accuracy(Double d) {
            this.accuracy = d;
            return this;
        }

        public UserLocation build() {
            checkRequiredFields();
            return new UserLocation(this);
        }
    }
}
