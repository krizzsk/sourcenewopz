package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class GuidePointInfo extends Message {
    public static final ByteString DEFAULT_GUIDE_POINT_RES_PACK = ByteString.EMPTY;
    public static final Long DEFAULT_LINKID = 0L;
    public static final ByteString DEFAULT_ORA_PACK = ByteString.EMPTY;
    public static final PointType DEFAULT_TYPE = PointType.BREAKOUT;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final ByteString guide_point_res_pack;
    @ProtoField(tag = 4, type = Message.Datatype.INT64)
    public final Long linkID;
    @ProtoField(tag = 5, type = Message.Datatype.BYTES)
    public final ByteString ora_pack;
    @ProtoField(tag = 1)
    public final DoublePoint point;
    @ProtoField(tag = 2, type = Message.Datatype.ENUM)
    public final PointType type;

    public GuidePointInfo(DoublePoint doublePoint, PointType pointType, ByteString byteString, Long l, ByteString byteString2) {
        this.point = doublePoint;
        this.type = pointType;
        this.guide_point_res_pack = byteString;
        this.linkID = l;
        this.ora_pack = byteString2;
    }

    private GuidePointInfo(Builder builder) {
        this(builder.point, builder.type, builder.guide_point_res_pack, builder.linkID, builder.ora_pack);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GuidePointInfo)) {
            return false;
        }
        GuidePointInfo guidePointInfo = (GuidePointInfo) obj;
        if (!equals((Object) this.point, (Object) guidePointInfo.point) || !equals((Object) this.type, (Object) guidePointInfo.type) || !equals((Object) this.guide_point_res_pack, (Object) guidePointInfo.guide_point_res_pack) || !equals((Object) this.linkID, (Object) guidePointInfo.linkID) || !equals((Object) this.ora_pack, (Object) guidePointInfo.ora_pack)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.point;
        int i2 = 0;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        PointType pointType = this.type;
        int hashCode2 = (hashCode + (pointType != null ? pointType.hashCode() : 0)) * 37;
        ByteString byteString = this.guide_point_res_pack;
        int hashCode3 = (hashCode2 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        Long l = this.linkID;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        ByteString byteString2 = this.ora_pack;
        if (byteString2 != null) {
            i2 = byteString2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GuidePointInfo> {
        public ByteString guide_point_res_pack;
        public Long linkID;
        public ByteString ora_pack;
        public DoublePoint point;
        public PointType type;

        public Builder() {
        }

        public Builder(GuidePointInfo guidePointInfo) {
            super(guidePointInfo);
            if (guidePointInfo != null) {
                this.point = guidePointInfo.point;
                this.type = guidePointInfo.type;
                this.guide_point_res_pack = guidePointInfo.guide_point_res_pack;
                this.linkID = guidePointInfo.linkID;
                this.ora_pack = guidePointInfo.ora_pack;
            }
        }

        public Builder point(DoublePoint doublePoint) {
            this.point = doublePoint;
            return this;
        }

        public Builder type(PointType pointType) {
            this.type = pointType;
            return this;
        }

        public Builder guide_point_res_pack(ByteString byteString) {
            this.guide_point_res_pack = byteString;
            return this;
        }

        public Builder linkID(Long l) {
            this.linkID = l;
            return this;
        }

        public Builder ora_pack(ByteString byteString) {
            this.ora_pack = byteString;
            return this;
        }

        public GuidePointInfo build() {
            return new GuidePointInfo(this);
        }
    }
}
