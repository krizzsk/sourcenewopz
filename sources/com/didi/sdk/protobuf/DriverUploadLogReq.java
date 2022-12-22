package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoEnum;
import com.squareup.wire.ProtoField;

public final class DriverUploadLogReq extends Message {
    public static final Integer DEFAULT_COLLECTTYPE = 0;
    public static final Integer DEFAULT_LOGENABLE = 0;
    public static final Integer DEFAULT_LOGTYPE = 0;
    public static final Integer DEFAULT_UPLOAD = 0;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer collectType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer logEnable;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer logType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer upload;

    public DriverUploadLogReq(Integer num, Integer num2, Integer num3, Integer num4) {
        this.upload = num;
        this.logEnable = num2;
        this.logType = num3;
        this.collectType = num4;
    }

    private DriverUploadLogReq(Builder builder) {
        this(builder.upload, builder.logEnable, builder.logType, builder.collectType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverUploadLogReq)) {
            return false;
        }
        DriverUploadLogReq driverUploadLogReq = (DriverUploadLogReq) obj;
        if (!equals((Object) this.upload, (Object) driverUploadLogReq.upload) || !equals((Object) this.logEnable, (Object) driverUploadLogReq.logEnable) || !equals((Object) this.logType, (Object) driverUploadLogReq.logType) || !equals((Object) this.collectType, (Object) driverUploadLogReq.collectType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.upload;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.logEnable;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.logType;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.collectType;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverUploadLogReq> {
        public Integer collectType;
        public Integer logEnable;
        public Integer logType;
        public Integer upload;

        public Builder() {
        }

        public Builder(DriverUploadLogReq driverUploadLogReq) {
            super(driverUploadLogReq);
            if (driverUploadLogReq != null) {
                this.upload = driverUploadLogReq.upload;
                this.logEnable = driverUploadLogReq.logEnable;
                this.logType = driverUploadLogReq.logType;
                this.collectType = driverUploadLogReq.collectType;
            }
        }

        public Builder upload(Integer num) {
            this.upload = num;
            return this;
        }

        public Builder logEnable(Integer num) {
            this.logEnable = num;
            return this;
        }

        public Builder logType(Integer num) {
            this.logType = num;
            return this;
        }

        public Builder collectType(Integer num) {
            this.collectType = num;
            return this;
        }

        public DriverUploadLogReq build() {
            checkRequiredFields();
            return new DriverUploadLogReq(this);
        }
    }

    public enum CollectType implements ProtoEnum {
        kCollectTypeCommon(1),
        kCollectTypePush(2),
        kCollectTypeLoc(4),
        kCollectTypeNet(8);
        
        private final int value;

        private CollectType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
