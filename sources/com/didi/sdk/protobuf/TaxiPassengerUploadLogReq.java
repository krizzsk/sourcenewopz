package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiPassengerUploadLogReq extends Message {
    public static final String DEFAULT_REMARK = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String remark;

    public TaxiPassengerUploadLogReq(String str) {
        this.remark = str;
    }

    private TaxiPassengerUploadLogReq(Builder builder) {
        this(builder.remark);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiPassengerUploadLogReq)) {
            return false;
        }
        return equals((Object) this.remark, (Object) ((TaxiPassengerUploadLogReq) obj).remark);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.remark;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TaxiPassengerUploadLogReq> {
        public String remark;

        public Builder() {
        }

        public Builder(TaxiPassengerUploadLogReq taxiPassengerUploadLogReq) {
            super(taxiPassengerUploadLogReq);
            if (taxiPassengerUploadLogReq != null) {
                this.remark = taxiPassengerUploadLogReq.remark;
            }
        }

        public Builder remark(String str) {
            this.remark = str;
            return this;
        }

        public TaxiPassengerUploadLogReq build() {
            return new TaxiPassengerUploadLogReq(this);
        }
    }
}
