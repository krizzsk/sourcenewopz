package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverMonitorInfoReq extends Message {
    public static final String DEFAULT_INFO = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String info;

    public DriverMonitorInfoReq(String str) {
        this.info = str;
    }

    private DriverMonitorInfoReq(Builder builder) {
        this(builder.info);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverMonitorInfoReq)) {
            return false;
        }
        return equals((Object) this.info, (Object) ((DriverMonitorInfoReq) obj).info);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.info;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<DriverMonitorInfoReq> {
        public String info;

        public Builder() {
        }

        public Builder(DriverMonitorInfoReq driverMonitorInfoReq) {
            super(driverMonitorInfoReq);
            if (driverMonitorInfoReq != null) {
                this.info = driverMonitorInfoReq.info;
            }
        }

        public Builder info(String str) {
            this.info = str;
            return this;
        }

        public DriverMonitorInfoReq build() {
            checkRequiredFields();
            return new DriverMonitorInfoReq(this);
        }
    }
}
