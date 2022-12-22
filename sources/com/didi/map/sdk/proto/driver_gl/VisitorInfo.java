package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class VisitorInfo extends Message {
    public static final String DEFAULT_DIDIVERSION = "";
    public static final String DEFAULT_IMEI = "";
    public static final enumOSType DEFAULT_OS = enumOSType.Android;
    public static final String DEFAULT_PHONENUM = "";
    public static final Long DEFAULT_TIMESTAMPSEC = 0L;
    public static final String DEFAULT_TOKEN = "";
    @ProtoField(tag = 5, type = Message.Datatype.ENUM)

    /* renamed from: OS */
    public final enumOSType f28608OS;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String didiVersion;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String imei;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(tag = 6, type = Message.Datatype.INT64)
    public final Long timeStampSec;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public VisitorInfo(String str, String str2, String str3, String str4, enumOSType enumostype, Long l) {
        this.imei = str;
        this.token = str2;
        this.didiVersion = str3;
        this.phoneNum = str4;
        this.f28608OS = enumostype;
        this.timeStampSec = l;
    }

    private VisitorInfo(Builder builder) {
        this(builder.imei, builder.token, builder.didiVersion, builder.phoneNum, builder.f28609OS, builder.timeStampSec);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VisitorInfo)) {
            return false;
        }
        VisitorInfo visitorInfo = (VisitorInfo) obj;
        if (!equals((Object) this.imei, (Object) visitorInfo.imei) || !equals((Object) this.token, (Object) visitorInfo.token) || !equals((Object) this.didiVersion, (Object) visitorInfo.didiVersion) || !equals((Object) this.phoneNum, (Object) visitorInfo.phoneNum) || !equals((Object) this.f28608OS, (Object) visitorInfo.f28608OS) || !equals((Object) this.timeStampSec, (Object) visitorInfo.timeStampSec)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.imei;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.didiVersion;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.phoneNum;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        enumOSType enumostype = this.f28608OS;
        int hashCode5 = (hashCode4 + (enumostype != null ? enumostype.hashCode() : 0)) * 37;
        Long l = this.timeStampSec;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<VisitorInfo> {

        /* renamed from: OS */
        public enumOSType f28609OS;
        public String didiVersion;
        public String imei;
        public String phoneNum;
        public Long timeStampSec;
        public String token;

        public Builder() {
        }

        public Builder(VisitorInfo visitorInfo) {
            super(visitorInfo);
            if (visitorInfo != null) {
                this.imei = visitorInfo.imei;
                this.token = visitorInfo.token;
                this.didiVersion = visitorInfo.didiVersion;
                this.phoneNum = visitorInfo.phoneNum;
                this.f28609OS = visitorInfo.f28608OS;
                this.timeStampSec = visitorInfo.timeStampSec;
            }
        }

        public Builder imei(String str) {
            this.imei = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder didiVersion(String str) {
            this.didiVersion = str;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        /* renamed from: OS */
        public Builder mo78915OS(enumOSType enumostype) {
            this.f28609OS = enumostype;
            return this;
        }

        public Builder timeStampSec(Long l) {
            this.timeStampSec = l;
            return this;
        }

        public VisitorInfo build() {
            checkRequiredFields();
            return new VisitorInfo(this);
        }
    }
}
