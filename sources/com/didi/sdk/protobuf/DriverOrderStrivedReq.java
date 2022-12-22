package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverOrderStrivedReq extends Message {
    public static final String DEFAULT_DINFO = "";
    public static final String DEFAULT_MSG = "";
    public static final String DEFAULT_OID = "";
    public static final DriverMessageTipShowType DEFAULT_SHOWTYPE = DriverMessageTipShowType.DriverMessageTipShowTypeWindow;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String dInfo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.ENUM)
    public final DriverMessageTipShowType showType;

    public DriverOrderStrivedReq(String str, String str2, String str3, DriverMessageTipShowType driverMessageTipShowType) {
        this.oid = str;
        this.dInfo = str2;
        this.msg = str3;
        this.showType = driverMessageTipShowType;
    }

    private DriverOrderStrivedReq(Builder builder) {
        this(builder.oid, builder.dInfo, builder.msg, builder.showType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderStrivedReq)) {
            return false;
        }
        DriverOrderStrivedReq driverOrderStrivedReq = (DriverOrderStrivedReq) obj;
        if (!equals((Object) this.oid, (Object) driverOrderStrivedReq.oid) || !equals((Object) this.dInfo, (Object) driverOrderStrivedReq.dInfo) || !equals((Object) this.msg, (Object) driverOrderStrivedReq.msg) || !equals((Object) this.showType, (Object) driverOrderStrivedReq.showType)) {
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
        String str2 = this.dInfo;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.msg;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        DriverMessageTipShowType driverMessageTipShowType = this.showType;
        if (driverMessageTipShowType != null) {
            i2 = driverMessageTipShowType.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverOrderStrivedReq> {
        public String dInfo;
        public String msg;
        public String oid;
        public DriverMessageTipShowType showType;

        public Builder() {
        }

        public Builder(DriverOrderStrivedReq driverOrderStrivedReq) {
            super(driverOrderStrivedReq);
            if (driverOrderStrivedReq != null) {
                this.oid = driverOrderStrivedReq.oid;
                this.dInfo = driverOrderStrivedReq.dInfo;
                this.msg = driverOrderStrivedReq.msg;
                this.showType = driverOrderStrivedReq.showType;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder dInfo(String str) {
            this.dInfo = str;
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

        public DriverOrderStrivedReq build() {
            checkRequiredFields();
            return new DriverOrderStrivedReq(this);
        }
    }
}
