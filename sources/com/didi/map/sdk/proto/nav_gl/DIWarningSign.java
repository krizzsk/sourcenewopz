package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DIWarningSign extends Message {
    public static final WarningSignKindEnum DEFAULT_KIND = WarningSignKindEnum.WarningSignKind_LeftStrongCurve;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.ENUM)
    public final WarningSignKindEnum kind;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final MapRoutePoint targetPos;

    public DIWarningSign(MapRoutePoint mapRoutePoint, WarningSignKindEnum warningSignKindEnum) {
        this.targetPos = mapRoutePoint;
        this.kind = warningSignKindEnum;
    }

    private DIWarningSign(Builder builder) {
        this(builder.targetPos, builder.kind);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIWarningSign)) {
            return false;
        }
        DIWarningSign dIWarningSign = (DIWarningSign) obj;
        if (!equals((Object) this.targetPos, (Object) dIWarningSign.targetPos) || !equals((Object) this.kind, (Object) dIWarningSign.kind)) {
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
        WarningSignKindEnum warningSignKindEnum = this.kind;
        if (warningSignKindEnum != null) {
            i2 = warningSignKindEnum.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DIWarningSign> {
        public WarningSignKindEnum kind;
        public MapRoutePoint targetPos;

        public Builder() {
        }

        public Builder(DIWarningSign dIWarningSign) {
            super(dIWarningSign);
            if (dIWarningSign != null) {
                this.targetPos = dIWarningSign.targetPos;
                this.kind = dIWarningSign.kind;
            }
        }

        public Builder targetPos(MapRoutePoint mapRoutePoint) {
            this.targetPos = mapRoutePoint;
            return this;
        }

        public Builder kind(WarningSignKindEnum warningSignKindEnum) {
            this.kind = warningSignKindEnum;
            return this;
        }

        public DIWarningSign build() {
            checkRequiredFields();
            return new DIWarningSign(this);
        }
    }
}
