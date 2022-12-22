package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PickupHint extends Message {
    public static final List<IntersectionsHint> DEFAULT_INTERSECTIONSHINTS = Collections.emptyList();
    public static final String DEFAULT_PICKUPPOINTPOIID = "";
    @ProtoField(tag = 5)
    public final DriverBeyondPickupFunc driverBeyondPickupFunc;
    @ProtoField(label = Message.Label.REPEATED, messageType = IntersectionsHint.class, tag = 2)
    public final List<IntersectionsHint> intersectionsHints;
    @ProtoField(tag = 4)
    public final PickupGuideFunc pickupGuideFunc;
    @ProtoField(tag = 3)
    public final PickupNearbyHint pickupNearbyHint;
    @ProtoField(tag = 1)
    public final PickupPointHint pickupPointHint;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String pickupPointPoiID;

    public PickupHint(PickupPointHint pickupPointHint2, List<IntersectionsHint> list, PickupNearbyHint pickupNearbyHint2, PickupGuideFunc pickupGuideFunc2, DriverBeyondPickupFunc driverBeyondPickupFunc2, String str) {
        this.pickupPointHint = pickupPointHint2;
        this.intersectionsHints = immutableCopyOf(list);
        this.pickupNearbyHint = pickupNearbyHint2;
        this.pickupGuideFunc = pickupGuideFunc2;
        this.driverBeyondPickupFunc = driverBeyondPickupFunc2;
        this.pickupPointPoiID = str;
    }

    private PickupHint(Builder builder) {
        this(builder.pickupPointHint, builder.intersectionsHints, builder.pickupNearbyHint, builder.pickupGuideFunc, builder.driverBeyondPickupFunc, builder.pickupPointPoiID);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PickupHint)) {
            return false;
        }
        PickupHint pickupHint = (PickupHint) obj;
        if (!equals((Object) this.pickupPointHint, (Object) pickupHint.pickupPointHint) || !equals((List<?>) this.intersectionsHints, (List<?>) pickupHint.intersectionsHints) || !equals((Object) this.pickupNearbyHint, (Object) pickupHint.pickupNearbyHint) || !equals((Object) this.pickupGuideFunc, (Object) pickupHint.pickupGuideFunc) || !equals((Object) this.driverBeyondPickupFunc, (Object) pickupHint.driverBeyondPickupFunc) || !equals((Object) this.pickupPointPoiID, (Object) pickupHint.pickupPointPoiID)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        PickupPointHint pickupPointHint2 = this.pickupPointHint;
        int i2 = 0;
        int hashCode = (pickupPointHint2 != null ? pickupPointHint2.hashCode() : 0) * 37;
        List<IntersectionsHint> list = this.intersectionsHints;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        PickupNearbyHint pickupNearbyHint2 = this.pickupNearbyHint;
        int hashCode3 = (hashCode2 + (pickupNearbyHint2 != null ? pickupNearbyHint2.hashCode() : 0)) * 37;
        PickupGuideFunc pickupGuideFunc2 = this.pickupGuideFunc;
        int hashCode4 = (hashCode3 + (pickupGuideFunc2 != null ? pickupGuideFunc2.hashCode() : 0)) * 37;
        DriverBeyondPickupFunc driverBeyondPickupFunc2 = this.driverBeyondPickupFunc;
        int hashCode5 = (hashCode4 + (driverBeyondPickupFunc2 != null ? driverBeyondPickupFunc2.hashCode() : 0)) * 37;
        String str = this.pickupPointPoiID;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PickupHint> {
        public DriverBeyondPickupFunc driverBeyondPickupFunc;
        public List<IntersectionsHint> intersectionsHints;
        public PickupGuideFunc pickupGuideFunc;
        public PickupNearbyHint pickupNearbyHint;
        public PickupPointHint pickupPointHint;
        public String pickupPointPoiID;

        public Builder() {
        }

        public Builder(PickupHint pickupHint) {
            super(pickupHint);
            if (pickupHint != null) {
                this.pickupPointHint = pickupHint.pickupPointHint;
                this.intersectionsHints = PickupHint.copyOf(pickupHint.intersectionsHints);
                this.pickupNearbyHint = pickupHint.pickupNearbyHint;
                this.pickupGuideFunc = pickupHint.pickupGuideFunc;
                this.driverBeyondPickupFunc = pickupHint.driverBeyondPickupFunc;
                this.pickupPointPoiID = pickupHint.pickupPointPoiID;
            }
        }

        public Builder pickupPointHint(PickupPointHint pickupPointHint2) {
            this.pickupPointHint = pickupPointHint2;
            return this;
        }

        public Builder intersectionsHints(List<IntersectionsHint> list) {
            this.intersectionsHints = checkForNulls(list);
            return this;
        }

        public Builder pickupNearbyHint(PickupNearbyHint pickupNearbyHint2) {
            this.pickupNearbyHint = pickupNearbyHint2;
            return this;
        }

        public Builder pickupGuideFunc(PickupGuideFunc pickupGuideFunc2) {
            this.pickupGuideFunc = pickupGuideFunc2;
            return this;
        }

        public Builder driverBeyondPickupFunc(DriverBeyondPickupFunc driverBeyondPickupFunc2) {
            this.driverBeyondPickupFunc = driverBeyondPickupFunc2;
            return this;
        }

        public Builder pickupPointPoiID(String str) {
            this.pickupPointPoiID = str;
            return this;
        }

        public PickupHint build() {
            return new PickupHint(this);
        }
    }
}
