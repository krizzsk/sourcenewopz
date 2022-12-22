package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AdsorbLocInfo extends Message {
    public static final Integer DEFAULT_GEODISTANCEM = 0;
    public static final Integer DEFAULT_GEOINDEX = -1;
    public static final Long DEFAULT_LINKID = 0L;
    public static final String DEFAULT_MAPVERSION = "";
    public static final Long DEFAULT_ROUTEID = 0L;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer geoDistanceM;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer geoIndex;
    @ProtoField(tag = 5, type = Message.Datatype.INT64)
    public final Long linkID;
    @ProtoField(tag = 1)
    public final DriverLoc loc;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String mapVersion;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long routeID;

    public AdsorbLocInfo(DriverLoc driverLoc, Long l, Integer num, Integer num2, Long l2, String str) {
        this.loc = driverLoc;
        this.routeID = l;
        this.geoIndex = num;
        this.geoDistanceM = num2;
        this.linkID = l2;
        this.mapVersion = str;
    }

    private AdsorbLocInfo(Builder builder) {
        this(builder.loc, builder.routeID, builder.geoIndex, builder.geoDistanceM, builder.linkID, builder.mapVersion);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdsorbLocInfo)) {
            return false;
        }
        AdsorbLocInfo adsorbLocInfo = (AdsorbLocInfo) obj;
        if (!equals((Object) this.loc, (Object) adsorbLocInfo.loc) || !equals((Object) this.routeID, (Object) adsorbLocInfo.routeID) || !equals((Object) this.geoIndex, (Object) adsorbLocInfo.geoIndex) || !equals((Object) this.geoDistanceM, (Object) adsorbLocInfo.geoDistanceM) || !equals((Object) this.linkID, (Object) adsorbLocInfo.linkID) || !equals((Object) this.mapVersion, (Object) adsorbLocInfo.mapVersion)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DriverLoc driverLoc = this.loc;
        int i2 = 0;
        int hashCode = (driverLoc != null ? driverLoc.hashCode() : 0) * 37;
        Long l = this.routeID;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.geoIndex;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.geoDistanceM;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.linkID;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str = this.mapVersion;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<AdsorbLocInfo> {
        public Integer geoDistanceM;
        public Integer geoIndex;
        public Long linkID;
        public DriverLoc loc;
        public String mapVersion;
        public Long routeID;

        public Builder() {
        }

        public Builder(AdsorbLocInfo adsorbLocInfo) {
            super(adsorbLocInfo);
            if (adsorbLocInfo != null) {
                this.loc = adsorbLocInfo.loc;
                this.routeID = adsorbLocInfo.routeID;
                this.geoIndex = adsorbLocInfo.geoIndex;
                this.geoDistanceM = adsorbLocInfo.geoDistanceM;
                this.linkID = adsorbLocInfo.linkID;
                this.mapVersion = adsorbLocInfo.mapVersion;
            }
        }

        public Builder loc(DriverLoc driverLoc) {
            this.loc = driverLoc;
            return this;
        }

        public Builder routeID(Long l) {
            this.routeID = l;
            return this;
        }

        public Builder geoIndex(Integer num) {
            this.geoIndex = num;
            return this;
        }

        public Builder geoDistanceM(Integer num) {
            this.geoDistanceM = num;
            return this;
        }

        public Builder linkID(Long l) {
            this.linkID = l;
            return this;
        }

        public Builder mapVersion(String str) {
            this.mapVersion = str;
            return this;
        }

        public AdsorbLocInfo build() {
            return new AdsorbLocInfo(this);
        }
    }
}
