package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RlabTripData extends Message {
    public static final Long DEFAULT_AREA_ID = 0L;
    public static final Long DEFAULT_CITY_ID = 0L;
    public static final String DEFAULT_EXTRA_DATA = "";
    public static final Long DEFAULT_RIDER_ID = 0L;
    public static final Long DEFAULT_TRIP_ID = 0L;
    public static final Long DEFAULT_WORK_STATUS = 0L;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long area_id;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long city_id;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String extra_data;
    @ProtoField(tag = 1, type = Message.Datatype.INT64)
    public final Long rider_id;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long trip_id;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long work_status;

    public RlabTripData(Long l, Long l2, Long l3, Long l4, Long l5, String str) {
        this.rider_id = l;
        this.city_id = l2;
        this.area_id = l3;
        this.work_status = l4;
        this.trip_id = l5;
        this.extra_data = str;
    }

    private RlabTripData(Builder builder) {
        this(builder.rider_id, builder.city_id, builder.area_id, builder.work_status, builder.trip_id, builder.extra_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RlabTripData)) {
            return false;
        }
        RlabTripData rlabTripData = (RlabTripData) obj;
        if (!equals((Object) this.rider_id, (Object) rlabTripData.rider_id) || !equals((Object) this.city_id, (Object) rlabTripData.city_id) || !equals((Object) this.area_id, (Object) rlabTripData.area_id) || !equals((Object) this.work_status, (Object) rlabTripData.work_status) || !equals((Object) this.trip_id, (Object) rlabTripData.trip_id) || !equals((Object) this.extra_data, (Object) rlabTripData.extra_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.rider_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Long l2 = this.city_id;
        int hashCode2 = (hashCode + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.area_id;
        int hashCode3 = (hashCode2 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.work_status;
        int hashCode4 = (hashCode3 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.trip_id;
        int hashCode5 = (hashCode4 + (l5 != null ? l5.hashCode() : 0)) * 37;
        String str = this.extra_data;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RlabTripData> {
        public Long area_id;
        public Long city_id;
        public String extra_data;
        public Long rider_id;
        public Long trip_id;
        public Long work_status;

        public Builder() {
        }

        public Builder(RlabTripData rlabTripData) {
            super(rlabTripData);
            if (rlabTripData != null) {
                this.rider_id = rlabTripData.rider_id;
                this.city_id = rlabTripData.city_id;
                this.area_id = rlabTripData.area_id;
                this.work_status = rlabTripData.work_status;
                this.trip_id = rlabTripData.trip_id;
                this.extra_data = rlabTripData.extra_data;
            }
        }

        public Builder rider_id(Long l) {
            this.rider_id = l;
            return this;
        }

        public Builder city_id(Long l) {
            this.city_id = l;
            return this;
        }

        public Builder area_id(Long l) {
            this.area_id = l;
            return this;
        }

        public Builder work_status(Long l) {
            this.work_status = l;
            return this;
        }

        public Builder trip_id(Long l) {
            this.trip_id = l;
            return this;
        }

        public Builder extra_data(String str) {
            this.extra_data = str;
            return this;
        }

        public RlabTripData build() {
            return new RlabTripData(this);
        }
    }
}
