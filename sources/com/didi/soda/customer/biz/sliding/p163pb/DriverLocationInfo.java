package com.didi.soda.customer.biz.sliding.p163pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.soda.customer.biz.sliding.pb.DriverLocationInfo */
public final class DriverLocationInfo extends Message {
    public static final List<Coordinate> DEFAULT_COORDS = Collections.emptyList();
    public static final Long DEFAULT_DIRVERID = 0L;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer channel;
    @ProtoField(label = Message.Label.REPEATED, messageType = Coordinate.class, tag = 3)
    public final List<Coordinate> coords;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer debug_status;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String debug_status_detail;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT64)
    public final Long dirverId;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer type;

    public DriverLocationInfo(Long l, Integer num, List<Coordinate> list, Integer num2, Integer num3, String str, Integer num4) {
        this.dirverId = l;
        this.type = num;
        this.coords = immutableCopyOf(list);
        this.status = num2;
        this.debug_status = num3;
        this.debug_status_detail = str;
        this.channel = num4;
    }

    private DriverLocationInfo(Builder builder) {
        this(builder.dirverId, builder.type, builder.coords, builder.status, builder.debug_status, builder.debug_status_detail, builder.channel);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverLocationInfo)) {
            return false;
        }
        DriverLocationInfo driverLocationInfo = (DriverLocationInfo) obj;
        if (!equals((Object) this.dirverId, (Object) driverLocationInfo.dirverId) || !equals((Object) this.type, (Object) driverLocationInfo.type) || !equals((List<?>) this.coords, (List<?>) driverLocationInfo.coords) || !equals((Object) this.status, (Object) driverLocationInfo.status) || !equals((Object) this.debug_status, (Object) driverLocationInfo.debug_status) || !equals((Object) this.debug_status_detail, (Object) driverLocationInfo.debug_status_detail) || !equals((Object) this.channel, (Object) driverLocationInfo.channel)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.dirverId;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        List<Coordinate> list = this.coords;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Integer num2 = this.status;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.debug_status;
        int hashCode5 = (hashCode4 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str = this.debug_status_detail;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num4 = this.channel;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.soda.customer.biz.sliding.pb.DriverLocationInfo$Builder */
    public static final class Builder extends Message.Builder<DriverLocationInfo> {
        public Integer channel;
        public List<Coordinate> coords;
        public Integer debug_status;
        public String debug_status_detail;
        public Long dirverId;
        public Integer status;
        public Integer type;

        public Builder() {
        }

        public Builder(DriverLocationInfo driverLocationInfo) {
            super(driverLocationInfo);
            if (driverLocationInfo != null) {
                this.dirverId = driverLocationInfo.dirverId;
                this.type = driverLocationInfo.type;
                this.coords = DriverLocationInfo.copyOf(driverLocationInfo.coords);
                this.status = driverLocationInfo.status;
                this.debug_status = driverLocationInfo.debug_status;
                this.debug_status_detail = driverLocationInfo.debug_status_detail;
                this.channel = driverLocationInfo.channel;
            }
        }

        public DriverLocationInfo build() {
            checkRequiredFields();
            return new DriverLocationInfo(this);
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }
    }
}
