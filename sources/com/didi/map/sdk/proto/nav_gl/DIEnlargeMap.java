package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DIEnlargeMap extends Message {
    public static final String DEFAULT_ARROWPICURL = "";
    public static final String DEFAULT_BKPICURL = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String arrowPicUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String bkPicUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DIEnlargeMap(MapRoutePoint mapRoutePoint, String str, String str2) {
        this.targetPos = mapRoutePoint;
        this.bkPicUrl = str;
        this.arrowPicUrl = str2;
    }

    private DIEnlargeMap(Builder builder) {
        this(builder.targetPos, builder.bkPicUrl, builder.arrowPicUrl);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIEnlargeMap)) {
            return false;
        }
        DIEnlargeMap dIEnlargeMap = (DIEnlargeMap) obj;
        if (!equals((Object) this.targetPos, (Object) dIEnlargeMap.targetPos) || !equals((Object) this.bkPicUrl, (Object) dIEnlargeMap.bkPicUrl) || !equals((Object) this.arrowPicUrl, (Object) dIEnlargeMap.arrowPicUrl)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        MapRoutePoint mapRoutePoint = this.targetPos;
        int i2 = 0;
        int hashCode = (mapRoutePoint != null ? mapRoutePoint.hashCode() : 0) * 37;
        String str = this.bkPicUrl;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.arrowPicUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DIEnlargeMap> {
        public String arrowPicUrl;
        public String bkPicUrl;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DIEnlargeMap dIEnlargeMap) {
            super(dIEnlargeMap);
            if (dIEnlargeMap != null) {
                this.targetPos = dIEnlargeMap.targetPos;
                this.bkPicUrl = dIEnlargeMap.bkPicUrl;
                this.arrowPicUrl = dIEnlargeMap.arrowPicUrl;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder bkPicUrl(String str) {
            this.bkPicUrl = str;
            return this;
        }

        public Builder arrowPicUrl(String str) {
            this.arrowPicUrl = str;
            return this;
        }

        public DIEnlargeMap build() {
            checkRequiredFields();
            return new DIEnlargeMap(this);
        }
    }
}
