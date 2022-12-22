package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class MapDriver extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final Long DEFAULT_DRIVERID = 0L;
    public static final Long DEFAULT_ENDTIME = 0L;
    public static final Long DEFAULT_STARTTIME = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer biztype;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long driverId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.UINT64)
    public final Long endTime;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.UINT64)
    public final Long startTime;

    public MapDriver(Long l, Integer num, Long l2, Long l3) {
        this.driverId = l;
        this.biztype = num;
        this.startTime = l2;
        this.endTime = l3;
    }

    private MapDriver(Builder builder) {
        this(builder.driverId, builder.biztype, builder.startTime, builder.endTime);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MapDriver)) {
            return false;
        }
        MapDriver mapDriver = (MapDriver) obj;
        if (!equals((Object) this.driverId, (Object) mapDriver.driverId) || !equals((Object) this.biztype, (Object) mapDriver.biztype) || !equals((Object) this.startTime, (Object) mapDriver.startTime) || !equals((Object) this.endTime, (Object) mapDriver.endTime)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.driverId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.biztype;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l2 = this.startTime;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.endTime;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<MapDriver> {
        public Integer biztype;
        public Long driverId;
        public Long endTime;
        public Long startTime;

        public Builder() {
        }

        public Builder(MapDriver mapDriver) {
            super(mapDriver);
            if (mapDriver != null) {
                this.driverId = mapDriver.driverId;
                this.biztype = mapDriver.biztype;
                this.startTime = mapDriver.startTime;
                this.endTime = mapDriver.endTime;
            }
        }

        public Builder driverId(Long l) {
            this.driverId = l;
            return this;
        }

        public Builder biztype(Integer num) {
            this.biztype = num;
            return this;
        }

        public Builder startTime(Long l) {
            this.startTime = l;
            return this;
        }

        public Builder endTime(Long l) {
            this.endTime = l;
            return this;
        }

        public MapDriver build() {
            checkRequiredFields();
            return new MapDriver(this);
        }
    }
}
