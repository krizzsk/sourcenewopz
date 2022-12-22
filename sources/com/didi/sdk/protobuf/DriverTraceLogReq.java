package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverTraceLogReq extends Message {
    public static final Integer DEFAULT_TRACELOGENABLE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer traceLogEnable;

    public DriverTraceLogReq(Integer num) {
        this.traceLogEnable = num;
    }

    private DriverTraceLogReq(Builder builder) {
        this(builder.traceLogEnable);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverTraceLogReq)) {
            return false;
        }
        return equals((Object) this.traceLogEnable, (Object) ((DriverTraceLogReq) obj).traceLogEnable);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Integer num = this.traceLogEnable;
            i = num != null ? num.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DriverTraceLogReq> {
        public Integer traceLogEnable;

        public Builder() {
        }

        public Builder(DriverTraceLogReq driverTraceLogReq) {
            super(driverTraceLogReq);
            if (driverTraceLogReq != null) {
                this.traceLogEnable = driverTraceLogReq.traceLogEnable;
            }
        }

        public Builder traceLogEnable(Integer num) {
            this.traceLogEnable = num;
            return this;
        }

        public DriverTraceLogReq build() {
            checkRequiredFields();
            return new DriverTraceLogReq(this);
        }
    }
}
