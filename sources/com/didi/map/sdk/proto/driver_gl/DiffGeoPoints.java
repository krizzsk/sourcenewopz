package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DiffGeoPoints extends Message {
    public static final List<Integer> DEFAULT_DLATS = Collections.emptyList();
    public static final List<Integer> DEFAULT_DLNGS = Collections.emptyList();
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final DoublePoint base;
    @ProtoField(label = Message.Label.PACKED, tag = 2, type = Message.Datatype.INT32)
    public final List<Integer> dlats;
    @ProtoField(label = Message.Label.PACKED, tag = 3, type = Message.Datatype.INT32)
    public final List<Integer> dlngs;

    public DiffGeoPoints(DoublePoint doublePoint, List<Integer> list, List<Integer> list2) {
        this.base = doublePoint;
        this.dlats = immutableCopyOf(list);
        this.dlngs = immutableCopyOf(list2);
    }

    private DiffGeoPoints(Builder builder) {
        this(builder.base, builder.dlats, builder.dlngs);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DiffGeoPoints)) {
            return false;
        }
        DiffGeoPoints diffGeoPoints = (DiffGeoPoints) obj;
        if (!equals((Object) this.base, (Object) diffGeoPoints.base) || !equals((List<?>) this.dlats, (List<?>) diffGeoPoints.dlats) || !equals((List<?>) this.dlngs, (List<?>) diffGeoPoints.dlngs)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        DoublePoint doublePoint = this.base;
        int hashCode = (doublePoint != null ? doublePoint.hashCode() : 0) * 37;
        List<Integer> list = this.dlats;
        int i2 = 1;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        List<Integer> list2 = this.dlngs;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DiffGeoPoints> {
        public DoublePoint base;
        public List<Integer> dlats;
        public List<Integer> dlngs;

        public Builder() {
        }

        public Builder(DiffGeoPoints diffGeoPoints) {
            super(diffGeoPoints);
            if (diffGeoPoints != null) {
                this.base = diffGeoPoints.base;
                this.dlats = DiffGeoPoints.copyOf(diffGeoPoints.dlats);
                this.dlngs = DiffGeoPoints.copyOf(diffGeoPoints.dlngs);
            }
        }

        public Builder base(DoublePoint doublePoint) {
            this.base = doublePoint;
            return this;
        }

        public Builder dlats(List<Integer> list) {
            this.dlats = checkForNulls(list);
            return this;
        }

        public Builder dlngs(List<Integer> list) {
            this.dlngs = checkForNulls(list);
            return this;
        }

        public DiffGeoPoints build() {
            checkRequiredFields();
            return new DiffGeoPoints(this);
        }
    }
}
