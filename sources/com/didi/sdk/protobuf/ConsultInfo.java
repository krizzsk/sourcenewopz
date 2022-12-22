package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class ConsultInfo extends Message {
    public static final String DEFAULT_CONSULT_MIN = "";
    public static final String DEFAULT_DRIVER_TIPS = "";
    public static final String DEFAULT_SYSTEM_TIPS = "";
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String consult_min;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String driver_tips;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String system_tips;

    public ConsultInfo(String str, String str2, String str3) {
        this.consult_min = str;
        this.driver_tips = str2;
        this.system_tips = str3;
    }

    private ConsultInfo(Builder builder) {
        this(builder.consult_min, builder.driver_tips, builder.system_tips);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConsultInfo)) {
            return false;
        }
        ConsultInfo consultInfo = (ConsultInfo) obj;
        if (!equals((Object) this.consult_min, (Object) consultInfo.consult_min) || !equals((Object) this.driver_tips, (Object) consultInfo.driver_tips) || !equals((Object) this.system_tips, (Object) consultInfo.system_tips)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.consult_min;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.driver_tips;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.system_tips;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConsultInfo> {
        public String consult_min;
        public String driver_tips;
        public String system_tips;

        public Builder() {
        }

        public Builder(ConsultInfo consultInfo) {
            super(consultInfo);
            if (consultInfo != null) {
                this.consult_min = consultInfo.consult_min;
                this.driver_tips = consultInfo.driver_tips;
                this.system_tips = consultInfo.system_tips;
            }
        }

        public Builder consult_min(String str) {
            this.consult_min = str;
            return this;
        }

        public Builder driver_tips(String str) {
            this.driver_tips = str;
            return this;
        }

        public Builder system_tips(String str) {
            this.system_tips = str;
            return this;
        }

        public ConsultInfo build() {
            return new ConsultInfo(this);
        }
    }
}
