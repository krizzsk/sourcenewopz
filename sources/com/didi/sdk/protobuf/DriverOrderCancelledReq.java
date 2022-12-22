package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverOrderCancelledReq extends Message {
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_PIN_ID = "";
    public static final DriverMessageTipShowType DEFAULT_SHOWTYPE = DriverMessageTipShowType.DriverMessageTipShowTypeWindow;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String pin_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final DriverMessageTipShowType showType;

    public DriverOrderCancelledReq(String str, String str2, DriverMessageTipShowType driverMessageTipShowType, String str3) {
        this.oid = str;
        this.msg = str2;
        this.showType = driverMessageTipShowType;
        this.pin_id = str3;
    }

    private DriverOrderCancelledReq(Builder builder) {
        this(builder.oid, builder.msg, builder.showType, builder.pin_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderCancelledReq)) {
            return false;
        }
        DriverOrderCancelledReq driverOrderCancelledReq = (DriverOrderCancelledReq) obj;
        if (!equals((Object) this.oid, (Object) driverOrderCancelledReq.oid) || !equals((Object) this.msg, (Object) driverOrderCancelledReq.msg) || !equals((Object) this.showType, (Object) driverOrderCancelledReq.showType) || !equals((Object) this.pin_id, (Object) driverOrderCancelledReq.pin_id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.oid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.msg;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        DriverMessageTipShowType driverMessageTipShowType = this.showType;
        int hashCode3 = (hashCode2 + (driverMessageTipShowType != null ? driverMessageTipShowType.hashCode() : 0)) * 37;
        String str3 = this.pin_id;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverOrderCancelledReq> {
        public String msg;
        public String oid;
        public String pin_id;
        public DriverMessageTipShowType showType;

        public Builder() {
        }

        public Builder(DriverOrderCancelledReq driverOrderCancelledReq) {
            super(driverOrderCancelledReq);
            if (driverOrderCancelledReq != null) {
                this.oid = driverOrderCancelledReq.oid;
                this.msg = driverOrderCancelledReq.msg;
                this.showType = driverOrderCancelledReq.showType;
                this.pin_id = driverOrderCancelledReq.pin_id;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder showType(DriverMessageTipShowType driverMessageTipShowType) {
            this.showType = driverMessageTipShowType;
            return this;
        }

        public Builder pin_id(String str) {
            this.pin_id = str;
            return this;
        }

        public DriverOrderCancelledReq build() {
            checkRequiredFields();
            return new DriverOrderCancelledReq(this);
        }
    }
}
