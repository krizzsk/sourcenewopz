package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UserAgent extends Message {
    public static final String DEFAULT_CARRIER_OPERATOR = "";
    public static final String DEFAULT_CLIENT_VER = "";
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_MODEL = "";
    public static final String DEFAULT_NETWORK = "";
    public static final String DEFAULT_OS_TYPE = "";
    public static final String DEFAULT_OS_VER = "";
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String carrier_operator;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String client_ver;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String location;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String model;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String network;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String os_type;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String os_ver;

    public UserAgent(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.os_type = str;
        this.os_ver = str2;
        this.model = str3;
        this.client_ver = str4;
        this.network = str5;
        this.location = str6;
        this.carrier_operator = str7;
    }

    private UserAgent(Builder builder) {
        this(builder.os_type, builder.os_ver, builder.model, builder.client_ver, builder.network, builder.location, builder.carrier_operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAgent)) {
            return false;
        }
        UserAgent userAgent = (UserAgent) obj;
        if (!equals((Object) this.os_type, (Object) userAgent.os_type) || !equals((Object) this.os_ver, (Object) userAgent.os_ver) || !equals((Object) this.model, (Object) userAgent.model) || !equals((Object) this.client_ver, (Object) userAgent.client_ver) || !equals((Object) this.network, (Object) userAgent.network) || !equals((Object) this.location, (Object) userAgent.location) || !equals((Object) this.carrier_operator, (Object) userAgent.carrier_operator)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.os_type;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.os_ver;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.model;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.client_ver;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.network;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.location;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.carrier_operator;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserAgent> {
        public String carrier_operator;
        public String client_ver;
        public String location;
        public String model;
        public String network;
        public String os_type;
        public String os_ver;

        public Builder() {
        }

        public Builder(UserAgent userAgent) {
            super(userAgent);
            if (userAgent != null) {
                this.os_type = userAgent.os_type;
                this.os_ver = userAgent.os_ver;
                this.model = userAgent.model;
                this.client_ver = userAgent.client_ver;
                this.network = userAgent.network;
                this.location = userAgent.location;
                this.carrier_operator = userAgent.carrier_operator;
            }
        }

        public Builder os_type(String str) {
            this.os_type = str;
            return this;
        }

        public Builder os_ver(String str) {
            this.os_ver = str;
            return this;
        }

        public Builder model(String str) {
            this.model = str;
            return this;
        }

        public Builder client_ver(String str) {
            this.client_ver = str;
            return this;
        }

        public Builder network(String str) {
            this.network = str;
            return this;
        }

        public Builder location(String str) {
            this.location = str;
            return this;
        }

        public Builder carrier_operator(String str) {
            this.carrier_operator = str;
            return this;
        }

        public UserAgent build() {
            return new UserAgent(this);
        }
    }
}
