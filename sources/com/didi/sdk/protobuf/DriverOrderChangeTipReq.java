package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverOrderChangeTipReq extends Message {
    public static final String DEFAULT_OID = "";
    public static final DriverMessageTipShowType DEFAULT_SHOWTYPE = DriverMessageTipShowType.DriverMessageTipShowTypeWindow;
    public static final Integer DEFAULT_TIP = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final DriverMessageTipShowType showType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer tip;

    public DriverOrderChangeTipReq(String str, Integer num, DriverMessageTipShowType driverMessageTipShowType) {
        this.oid = str;
        this.tip = num;
        this.showType = driverMessageTipShowType;
    }

    private DriverOrderChangeTipReq(Builder builder) {
        this(builder.oid, builder.tip, builder.showType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderChangeTipReq)) {
            return false;
        }
        DriverOrderChangeTipReq driverOrderChangeTipReq = (DriverOrderChangeTipReq) obj;
        if (!equals((Object) this.oid, (Object) driverOrderChangeTipReq.oid) || !equals((Object) this.tip, (Object) driverOrderChangeTipReq.tip) || !equals((Object) this.showType, (Object) driverOrderChangeTipReq.showType)) {
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
        Integer num = this.tip;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        DriverMessageTipShowType driverMessageTipShowType = this.showType;
        if (driverMessageTipShowType != null) {
            i2 = driverMessageTipShowType.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverOrderChangeTipReq> {
        public String oid;
        public DriverMessageTipShowType showType;
        public Integer tip;

        public Builder() {
        }

        public Builder(DriverOrderChangeTipReq driverOrderChangeTipReq) {
            super(driverOrderChangeTipReq);
            if (driverOrderChangeTipReq != null) {
                this.oid = driverOrderChangeTipReq.oid;
                this.tip = driverOrderChangeTipReq.tip;
                this.showType = driverOrderChangeTipReq.showType;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder tip(Integer num) {
            this.tip = num;
            return this;
        }

        public Builder showType(DriverMessageTipShowType driverMessageTipShowType) {
            this.showType = driverMessageTipShowType;
            return this;
        }

        public DriverOrderChangeTipReq build() {
            checkRequiredFields();
            return new DriverOrderChangeTipReq(this);
        }
    }
}
