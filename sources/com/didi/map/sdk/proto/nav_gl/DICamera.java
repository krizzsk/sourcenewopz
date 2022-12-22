package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DICamera extends Message {
    public static final CameraKindEnum DEFAULT_KIND = CameraKindEnum.CameraKind_Unknown;
    public static final Integer DEFAULT_LIMITSPEEDVALUE = 0;
    public static final Integer DEFAULT_PRIORITY = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final CameraKindEnum kind;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer limitSpeedValue;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer priority;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DICamera(MapRoutePoint mapRoutePoint, CameraKindEnum cameraKindEnum, Integer num, Integer num2) {
        this.targetPos = mapRoutePoint;
        this.kind = cameraKindEnum;
        this.limitSpeedValue = num;
        this.priority = num2;
    }

    private DICamera(Builder builder) {
        this(builder.targetPos, builder.kind, builder.limitSpeedValue, builder.priority);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DICamera)) {
            return false;
        }
        DICamera dICamera = (DICamera) obj;
        if (!equals((Object) this.targetPos, (Object) dICamera.targetPos) || !equals((Object) this.kind, (Object) dICamera.kind) || !equals((Object) this.limitSpeedValue, (Object) dICamera.limitSpeedValue) || !equals((Object) this.priority, (Object) dICamera.priority)) {
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
        CameraKindEnum cameraKindEnum = this.kind;
        int hashCode2 = (hashCode + (cameraKindEnum != null ? cameraKindEnum.hashCode() : 0)) * 37;
        Integer num = this.limitSpeedValue;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.priority;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DICamera> {
        public CameraKindEnum kind;
        public Integer limitSpeedValue;
        public Integer priority;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DICamera dICamera) {
            super(dICamera);
            if (dICamera != null) {
                this.targetPos = dICamera.targetPos;
                this.kind = dICamera.kind;
                this.limitSpeedValue = dICamera.limitSpeedValue;
                this.priority = dICamera.priority;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder kind(CameraKindEnum cameraKindEnum) {
            this.kind = cameraKindEnum;
            return this;
        }

        public Builder limitSpeedValue(Integer num) {
            this.limitSpeedValue = num;
            return this;
        }

        public Builder priority(Integer num) {
            this.priority = num;
            return this;
        }

        public DICamera build() {
            checkRequiredFields();
            return new DICamera(this);
        }
    }
}
