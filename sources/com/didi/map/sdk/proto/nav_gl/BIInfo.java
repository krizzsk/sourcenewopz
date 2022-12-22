package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BIInfo extends Message {
    public static final BIKindEnum DEFAULT_INFOKIND = BIKindEnum.BIKind_Arrive;
    @ProtoField(tag = 2)
    public final BIArrvie infoArrive;
    @ProtoField(tag = 4)
    public final BIDownloadEnlargeMap infoDownloadEnlargeMap;
    @ProtoField(tag = 3)
    public final BIHint infoHint;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.ENUM)
    public final BIKindEnum infoKind;

    public BIInfo(BIKindEnum bIKindEnum, BIArrvie bIArrvie, BIHint bIHint, BIDownloadEnlargeMap bIDownloadEnlargeMap) {
        this.infoKind = bIKindEnum;
        this.infoArrive = bIArrvie;
        this.infoHint = bIHint;
        this.infoDownloadEnlargeMap = bIDownloadEnlargeMap;
    }

    private BIInfo(Builder builder) {
        this(builder.infoKind, builder.infoArrive, builder.infoHint, builder.infoDownloadEnlargeMap);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BIInfo)) {
            return false;
        }
        BIInfo bIInfo = (BIInfo) obj;
        if (!equals((Object) this.infoKind, (Object) bIInfo.infoKind) || !equals((Object) this.infoArrive, (Object) bIInfo.infoArrive) || !equals((Object) this.infoHint, (Object) bIInfo.infoHint) || !equals((Object) this.infoDownloadEnlargeMap, (Object) bIInfo.infoDownloadEnlargeMap)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        BIKindEnum bIKindEnum = this.infoKind;
        int i2 = 0;
        int hashCode = (bIKindEnum != null ? bIKindEnum.hashCode() : 0) * 37;
        BIArrvie bIArrvie = this.infoArrive;
        int hashCode2 = (hashCode + (bIArrvie != null ? bIArrvie.hashCode() : 0)) * 37;
        BIHint bIHint = this.infoHint;
        int hashCode3 = (hashCode2 + (bIHint != null ? bIHint.hashCode() : 0)) * 37;
        BIDownloadEnlargeMap bIDownloadEnlargeMap = this.infoDownloadEnlargeMap;
        if (bIDownloadEnlargeMap != null) {
            i2 = bIDownloadEnlargeMap.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BIInfo> {
        public BIArrvie infoArrive;
        public BIDownloadEnlargeMap infoDownloadEnlargeMap;
        public BIHint infoHint;
        public BIKindEnum infoKind;

        public Builder() {
        }

        public Builder(BIInfo bIInfo) {
            super(bIInfo);
            if (bIInfo != null) {
                this.infoKind = bIInfo.infoKind;
                this.infoArrive = bIInfo.infoArrive;
                this.infoHint = bIInfo.infoHint;
                this.infoDownloadEnlargeMap = bIInfo.infoDownloadEnlargeMap;
            }
        }

        public Builder infoKind(BIKindEnum bIKindEnum) {
            this.infoKind = bIKindEnum;
            return this;
        }

        public Builder infoArrive(BIArrvie bIArrvie) {
            this.infoArrive = bIArrvie;
            return this;
        }

        public Builder infoHint(BIHint bIHint) {
            this.infoHint = bIHint;
            return this;
        }

        public Builder infoDownloadEnlargeMap(BIDownloadEnlargeMap bIDownloadEnlargeMap) {
            this.infoDownloadEnlargeMap = bIDownloadEnlargeMap;
            return this;
        }

        public BIInfo build() {
            checkRequiredFields();
            return new BIInfo(this);
        }
    }
}
