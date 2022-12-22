package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverCoordinateUploadReq extends Message {
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public DriverCoordinateUploadReq(Integer num) {
        this.type = num;
    }

    private DriverCoordinateUploadReq(Builder builder) {
        this(builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverCoordinateUploadReq)) {
            return false;
        }
        return equals((Object) this.type, (Object) ((DriverCoordinateUploadReq) obj).type);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.type;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DriverCoordinateUploadReq> {
        public Integer type;

        public Builder() {
        }

        public Builder(DriverCoordinateUploadReq driverCoordinateUploadReq) {
            super(driverCoordinateUploadReq);
            if (driverCoordinateUploadReq != null) {
                this.type = driverCoordinateUploadReq.type;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public DriverCoordinateUploadReq build() {
            checkRequiredFields();
            return new DriverCoordinateUploadReq(this);
        }
    }
}
