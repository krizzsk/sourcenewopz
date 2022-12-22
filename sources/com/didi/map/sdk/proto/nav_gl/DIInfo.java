package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DIInfo extends Message {
    public static final DIKindEnum DEFAULT_INFOKIND = DIKindEnum.DIKind_Intersection;
    @ProtoField(tag = 12)
    public final DICamera infoDICamera;
    @ProtoField(tag = 13)
    public final DIDestination infoDIDest;
    @ProtoField(tag = 3)
    public final DIEnlargeMap infoDIEnlargeMap;
    @ProtoField(tag = 2)
    public final DIIntersection infoDIIntersection;
    @ProtoField(tag = 7)
    public final DIJunction infoDIJunction;
    @ProtoField(tag = 5)
    public final DILane infoDILane;
    @ProtoField(tag = 11)
    public final DILimitSpeedSection infoDILimitSpeedSection;
    @ProtoField(tag = 14)
    public final DIMarker infoDIMarker;
    @ProtoField(tag = 9)
    public final DISA infoDISA;
    @ProtoField(tag = 4)
    public final DITollgate infoDITollgate;
    @ProtoField(tag = 8)
    public final DITrafficPoint infoDITrafficPoint;
    @ProtoField(tag = 6)
    public final DITunnel infoDITunnel;
    @ProtoField(tag = 10)
    public final DIWarningSign infoDIWarningSign;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final DIKindEnum infoKind;

    public DIInfo(DIKindEnum dIKindEnum, DIIntersection dIIntersection, DIEnlargeMap dIEnlargeMap, DITollgate dITollgate, DILane dILane, DITunnel dITunnel, DIJunction dIJunction, DITrafficPoint dITrafficPoint, DISA disa, DIWarningSign dIWarningSign, DILimitSpeedSection dILimitSpeedSection, DICamera dICamera, DIDestination dIDestination, DIMarker dIMarker) {
        this.infoKind = dIKindEnum;
        this.infoDIIntersection = dIIntersection;
        this.infoDIEnlargeMap = dIEnlargeMap;
        this.infoDITollgate = dITollgate;
        this.infoDILane = dILane;
        this.infoDITunnel = dITunnel;
        this.infoDIJunction = dIJunction;
        this.infoDITrafficPoint = dITrafficPoint;
        this.infoDISA = disa;
        this.infoDIWarningSign = dIWarningSign;
        this.infoDILimitSpeedSection = dILimitSpeedSection;
        this.infoDICamera = dICamera;
        this.infoDIDest = dIDestination;
        this.infoDIMarker = dIMarker;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DIInfo(com.didi.map.sdk.proto.nav_gl.DIInfo.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            com.didi.map.sdk.proto.nav_gl.DIKindEnum r2 = r0.infoKind
            com.didi.map.sdk.proto.nav_gl.DIIntersection r3 = r0.infoDIIntersection
            com.didi.map.sdk.proto.nav_gl.DIEnlargeMap r4 = r0.infoDIEnlargeMap
            com.didi.map.sdk.proto.nav_gl.DITollgate r5 = r0.infoDITollgate
            com.didi.map.sdk.proto.nav_gl.DILane r6 = r0.infoDILane
            com.didi.map.sdk.proto.nav_gl.DITunnel r7 = r0.infoDITunnel
            com.didi.map.sdk.proto.nav_gl.DIJunction r8 = r0.infoDIJunction
            com.didi.map.sdk.proto.nav_gl.DITrafficPoint r9 = r0.infoDITrafficPoint
            com.didi.map.sdk.proto.nav_gl.DISA r10 = r0.infoDISA
            com.didi.map.sdk.proto.nav_gl.DIWarningSign r11 = r0.infoDIWarningSign
            com.didi.map.sdk.proto.nav_gl.DILimitSpeedSection r12 = r0.infoDILimitSpeedSection
            com.didi.map.sdk.proto.nav_gl.DICamera r13 = r0.infoDICamera
            com.didi.map.sdk.proto.nav_gl.DIDestination r14 = r0.infoDIDest
            com.didi.map.sdk.proto.nav_gl.DIMarker r15 = r0.infoDIMarker
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.proto.nav_gl.DIInfo.<init>(com.didi.map.sdk.proto.nav_gl.DIInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DIInfo)) {
            return false;
        }
        DIInfo dIInfo = (DIInfo) obj;
        if (!equals((Object) this.infoKind, (Object) dIInfo.infoKind) || !equals((Object) this.infoDIIntersection, (Object) dIInfo.infoDIIntersection) || !equals((Object) this.infoDIEnlargeMap, (Object) dIInfo.infoDIEnlargeMap) || !equals((Object) this.infoDITollgate, (Object) dIInfo.infoDITollgate) || !equals((Object) this.infoDILane, (Object) dIInfo.infoDILane) || !equals((Object) this.infoDITunnel, (Object) dIInfo.infoDITunnel) || !equals((Object) this.infoDIJunction, (Object) dIInfo.infoDIJunction) || !equals((Object) this.infoDITrafficPoint, (Object) dIInfo.infoDITrafficPoint) || !equals((Object) this.infoDISA, (Object) dIInfo.infoDISA) || !equals((Object) this.infoDIWarningSign, (Object) dIInfo.infoDIWarningSign) || !equals((Object) this.infoDILimitSpeedSection, (Object) dIInfo.infoDILimitSpeedSection) || !equals((Object) this.infoDICamera, (Object) dIInfo.infoDICamera) || !equals((Object) this.infoDIDest, (Object) dIInfo.infoDIDest) || !equals((Object) this.infoDIMarker, (Object) dIInfo.infoDIMarker)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DIKindEnum dIKindEnum = this.infoKind;
        int i2 = 0;
        int hashCode = (dIKindEnum != null ? dIKindEnum.hashCode() : 0) * 37;
        DIIntersection dIIntersection = this.infoDIIntersection;
        int hashCode2 = (hashCode + (dIIntersection != null ? dIIntersection.hashCode() : 0)) * 37;
        DIEnlargeMap dIEnlargeMap = this.infoDIEnlargeMap;
        int hashCode3 = (hashCode2 + (dIEnlargeMap != null ? dIEnlargeMap.hashCode() : 0)) * 37;
        DITollgate dITollgate = this.infoDITollgate;
        int hashCode4 = (hashCode3 + (dITollgate != null ? dITollgate.hashCode() : 0)) * 37;
        DILane dILane = this.infoDILane;
        int hashCode5 = (hashCode4 + (dILane != null ? dILane.hashCode() : 0)) * 37;
        DITunnel dITunnel = this.infoDITunnel;
        int hashCode6 = (hashCode5 + (dITunnel != null ? dITunnel.hashCode() : 0)) * 37;
        DIJunction dIJunction = this.infoDIJunction;
        int hashCode7 = (hashCode6 + (dIJunction != null ? dIJunction.hashCode() : 0)) * 37;
        DITrafficPoint dITrafficPoint = this.infoDITrafficPoint;
        int hashCode8 = (hashCode7 + (dITrafficPoint != null ? dITrafficPoint.hashCode() : 0)) * 37;
        DISA disa = this.infoDISA;
        int hashCode9 = (hashCode8 + (disa != null ? disa.hashCode() : 0)) * 37;
        DIWarningSign dIWarningSign = this.infoDIWarningSign;
        int hashCode10 = (hashCode9 + (dIWarningSign != null ? dIWarningSign.hashCode() : 0)) * 37;
        DILimitSpeedSection dILimitSpeedSection = this.infoDILimitSpeedSection;
        int hashCode11 = (hashCode10 + (dILimitSpeedSection != null ? dILimitSpeedSection.hashCode() : 0)) * 37;
        DICamera dICamera = this.infoDICamera;
        int hashCode12 = (hashCode11 + (dICamera != null ? dICamera.hashCode() : 0)) * 37;
        DIDestination dIDestination = this.infoDIDest;
        int hashCode13 = (hashCode12 + (dIDestination != null ? dIDestination.hashCode() : 0)) * 37;
        DIMarker dIMarker = this.infoDIMarker;
        if (dIMarker != null) {
            i2 = dIMarker.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DIInfo> {
        public DICamera infoDICamera;
        public DIDestination infoDIDest;
        public DIEnlargeMap infoDIEnlargeMap;
        public DIIntersection infoDIIntersection;
        public DIJunction infoDIJunction;
        public DILane infoDILane;
        public DILimitSpeedSection infoDILimitSpeedSection;
        public DIMarker infoDIMarker;
        public DISA infoDISA;
        public DITollgate infoDITollgate;
        public DITrafficPoint infoDITrafficPoint;
        public DITunnel infoDITunnel;
        public DIWarningSign infoDIWarningSign;
        public DIKindEnum infoKind;

        public Builder() {
        }

        public Builder(DIInfo dIInfo) {
            super(dIInfo);
            if (dIInfo != null) {
                this.infoKind = dIInfo.infoKind;
                this.infoDIIntersection = dIInfo.infoDIIntersection;
                this.infoDIEnlargeMap = dIInfo.infoDIEnlargeMap;
                this.infoDITollgate = dIInfo.infoDITollgate;
                this.infoDILane = dIInfo.infoDILane;
                this.infoDITunnel = dIInfo.infoDITunnel;
                this.infoDIJunction = dIInfo.infoDIJunction;
                this.infoDITrafficPoint = dIInfo.infoDITrafficPoint;
                this.infoDISA = dIInfo.infoDISA;
                this.infoDIWarningSign = dIInfo.infoDIWarningSign;
                this.infoDILimitSpeedSection = dIInfo.infoDILimitSpeedSection;
                this.infoDICamera = dIInfo.infoDICamera;
                this.infoDIDest = dIInfo.infoDIDest;
                this.infoDIMarker = dIInfo.infoDIMarker;
            }
        }

        public Builder infoKind(DIKindEnum dIKindEnum) {
            this.infoKind = dIKindEnum;
            return this;
        }

        public Builder infoDIIntersection(DIIntersection dIIntersection) {
            this.infoDIIntersection = dIIntersection;
            return this;
        }

        public Builder infoDIEnlargeMap(DIEnlargeMap dIEnlargeMap) {
            this.infoDIEnlargeMap = dIEnlargeMap;
            return this;
        }

        public Builder infoDITollgate(DITollgate dITollgate) {
            this.infoDITollgate = dITollgate;
            return this;
        }

        public Builder infoDILane(DILane dILane) {
            this.infoDILane = dILane;
            return this;
        }

        public Builder infoDITunnel(DITunnel dITunnel) {
            this.infoDITunnel = dITunnel;
            return this;
        }

        public Builder infoDIJunction(DIJunction dIJunction) {
            this.infoDIJunction = dIJunction;
            return this;
        }

        public Builder infoDITrafficPoint(DITrafficPoint dITrafficPoint) {
            this.infoDITrafficPoint = dITrafficPoint;
            return this;
        }

        public Builder infoDISA(DISA disa) {
            this.infoDISA = disa;
            return this;
        }

        public Builder infoDIWarningSign(DIWarningSign dIWarningSign) {
            this.infoDIWarningSign = dIWarningSign;
            return this;
        }

        public Builder infoDILimitSpeedSection(DILimitSpeedSection dILimitSpeedSection) {
            this.infoDILimitSpeedSection = dILimitSpeedSection;
            return this;
        }

        public Builder infoDICamera(DICamera dICamera) {
            this.infoDICamera = dICamera;
            return this;
        }

        public Builder infoDIDest(DIDestination dIDestination) {
            this.infoDIDest = dIDestination;
            return this;
        }

        public Builder infoDIMarker(DIMarker dIMarker) {
            this.infoDIMarker = dIMarker;
            return this;
        }

        public DIInfo build() {
            checkRequiredFields();
            return new DIInfo(this);
        }
    }
}
