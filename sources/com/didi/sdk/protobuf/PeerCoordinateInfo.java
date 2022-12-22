package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PeerCoordinateInfo extends Message {
    public static final Integer DEFAULT_DISTANCE = 0;
    public static final Boolean DEFAULT_IS_ARRIVED_LIMITED = false;
    public static final String DEFAULT_LOCAL_ID = "";
    public static final Integer DEFAULT_WAIT_TIME = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final Coordinate coordinate;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT32)
    public final Integer distance;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean is_arrived_limited;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String local_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT32)
    public final Integer wait_time;

    public PeerCoordinateInfo(String str, Coordinate coordinate2, Integer num, Integer num2, Boolean bool) {
        this.local_id = str;
        this.coordinate = coordinate2;
        this.distance = num;
        this.wait_time = num2;
        this.is_arrived_limited = bool;
    }

    private PeerCoordinateInfo(Builder builder) {
        this(builder.local_id, builder.coordinate, builder.distance, builder.wait_time, builder.is_arrived_limited);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PeerCoordinateInfo)) {
            return false;
        }
        PeerCoordinateInfo peerCoordinateInfo = (PeerCoordinateInfo) obj;
        if (!equals((Object) this.local_id, (Object) peerCoordinateInfo.local_id) || !equals((Object) this.coordinate, (Object) peerCoordinateInfo.coordinate) || !equals((Object) this.distance, (Object) peerCoordinateInfo.distance) || !equals((Object) this.wait_time, (Object) peerCoordinateInfo.wait_time) || !equals((Object) this.is_arrived_limited, (Object) peerCoordinateInfo.is_arrived_limited)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.local_id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Coordinate coordinate2 = this.coordinate;
        int hashCode2 = (hashCode + (coordinate2 != null ? coordinate2.hashCode() : 0)) * 37;
        Integer num = this.distance;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.wait_time;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool = this.is_arrived_limited;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PeerCoordinateInfo> {
        public Coordinate coordinate;
        public Integer distance;
        public Boolean is_arrived_limited;
        public String local_id;
        public Integer wait_time;

        public Builder() {
        }

        public Builder(PeerCoordinateInfo peerCoordinateInfo) {
            super(peerCoordinateInfo);
            if (peerCoordinateInfo != null) {
                this.local_id = peerCoordinateInfo.local_id;
                this.coordinate = peerCoordinateInfo.coordinate;
                this.distance = peerCoordinateInfo.distance;
                this.wait_time = peerCoordinateInfo.wait_time;
                this.is_arrived_limited = peerCoordinateInfo.is_arrived_limited;
            }
        }

        public Builder local_id(String str) {
            this.local_id = str;
            return this;
        }

        public Builder coordinate(Coordinate coordinate2) {
            this.coordinate = coordinate2;
            return this;
        }

        public Builder distance(Integer num) {
            this.distance = num;
            return this;
        }

        public Builder wait_time(Integer num) {
            this.wait_time = num;
            return this;
        }

        public Builder is_arrived_limited(Boolean bool) {
            this.is_arrived_limited = bool;
            return this;
        }

        public PeerCoordinateInfo build() {
            checkRequiredFields();
            return new PeerCoordinateInfo(this);
        }
    }
}
