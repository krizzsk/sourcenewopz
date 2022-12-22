package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiTripInfo extends Message {
    public static final String DEFAULT_STATUS = "";
    public static final String DEFAULT_TRIPID = "";
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String status;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String tripId;

    public TaxiTripInfo(String str, String str2) {
        this.tripId = str;
        this.status = str2;
    }

    private TaxiTripInfo(Builder builder) {
        this(builder.tripId, builder.status);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiTripInfo)) {
            return false;
        }
        TaxiTripInfo taxiTripInfo = (TaxiTripInfo) obj;
        if (!equals((Object) this.tripId, (Object) taxiTripInfo.tripId) || !equals((Object) this.status, (Object) taxiTripInfo.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.tripId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.status;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiTripInfo> {
        public String status;
        public String tripId;

        public Builder() {
        }

        public Builder(TaxiTripInfo taxiTripInfo) {
            super(taxiTripInfo);
            if (taxiTripInfo != null) {
                this.tripId = taxiTripInfo.tripId;
                this.status = taxiTripInfo.status;
            }
        }

        public Builder tripId(String str) {
            this.tripId = str;
            return this;
        }

        public Builder status(String str) {
            this.status = str;
            return this;
        }

        public TaxiTripInfo build() {
            return new TaxiTripInfo(this);
        }
    }
}
