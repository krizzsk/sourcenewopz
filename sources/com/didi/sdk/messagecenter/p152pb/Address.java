package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.Address */
public final class Address extends Message {
    public static final String DEFAULT_CARRIER_OPERATOR = "";
    public static final Long DEFAULT_CITYID = 0L;
    public static final String DEFAULT_CLIENT_VER = "";
    public static final String DEFAULT_IP = "";
    public static final Boolean DEFAULT_IS_TLS = false;
    public static final String DEFAULT_NET_WORK = "";
    public static final String DEFAULT_OS_TYPE = "";
    public static final String DEFAULT_OS_VER = "";
    public static final Integer DEFAULT_PORT = 0;
    public static final Integer DEFAULT_ROLE = 0;
    public static final Boolean DEFAULT_SHOULD_STAT = false;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String carrier_operator;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long cityId;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String client_ver;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)

    /* renamed from: ip */
    public final String f36776ip;
    @ProtoField(tag = 7, type = Message.Datatype.BOOL)
    public final Boolean is_tls;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String net_work;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String os_type;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String os_ver;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer port;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean should_stat;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long timestamp;

    public Address(String str, Integer num, Long l, Boolean bool, Long l2, Integer num2, Boolean bool2, String str2, String str3, String str4, String str5, String str6) {
        this.f36776ip = str;
        this.port = num;
        this.timestamp = l;
        this.should_stat = bool;
        this.cityId = l2;
        this.role = num2;
        this.is_tls = bool2;
        this.os_type = str2;
        this.net_work = str3;
        this.os_ver = str4;
        this.client_ver = str5;
        this.carrier_operator = str6;
    }

    private Address(Builder builder) {
        this(builder.f36777ip, builder.port, builder.timestamp, builder.should_stat, builder.cityId, builder.role, builder.is_tls, builder.os_type, builder.net_work, builder.os_ver, builder.client_ver, builder.carrier_operator);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        if (!equals((Object) this.f36776ip, (Object) address.f36776ip) || !equals((Object) this.port, (Object) address.port) || !equals((Object) this.timestamp, (Object) address.timestamp) || !equals((Object) this.should_stat, (Object) address.should_stat) || !equals((Object) this.cityId, (Object) address.cityId) || !equals((Object) this.role, (Object) address.role) || !equals((Object) this.is_tls, (Object) address.is_tls) || !equals((Object) this.os_type, (Object) address.os_type) || !equals((Object) this.net_work, (Object) address.net_work) || !equals((Object) this.os_ver, (Object) address.os_ver) || !equals((Object) this.client_ver, (Object) address.client_ver) || !equals((Object) this.carrier_operator, (Object) address.carrier_operator)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.f36776ip;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.port;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.should_stat;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l2 = this.cityId;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num2 = this.role;
        int hashCode6 = (hashCode5 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool2 = this.is_tls;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str2 = this.os_type;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.net_work;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.os_ver;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.client_ver;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.carrier_operator;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.Address$Builder */
    public static final class Builder extends Message.Builder<Address> {
        public String carrier_operator;
        public Long cityId;
        public String client_ver;

        /* renamed from: ip */
        public String f36777ip;
        public Boolean is_tls;
        public String net_work;
        public String os_type;
        public String os_ver;
        public Integer port;
        public Integer role;
        public Boolean should_stat;
        public Long timestamp;

        public Builder() {
        }

        public Builder(Address address) {
            super(address);
            if (address != null) {
                this.f36777ip = address.f36776ip;
                this.port = address.port;
                this.timestamp = address.timestamp;
                this.should_stat = address.should_stat;
                this.cityId = address.cityId;
                this.role = address.role;
                this.is_tls = address.is_tls;
                this.os_type = address.os_type;
                this.net_work = address.net_work;
                this.os_ver = address.os_ver;
                this.client_ver = address.client_ver;
                this.carrier_operator = address.carrier_operator;
            }
        }

        /* renamed from: ip */
        public Builder mo92887ip(String str) {
            this.f36777ip = str;
            return this;
        }

        public Builder port(Integer num) {
            this.port = num;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder should_stat(Boolean bool) {
            this.should_stat = bool;
            return this;
        }

        public Builder cityId(Long l) {
            this.cityId = l;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder is_tls(Boolean bool) {
            this.is_tls = bool;
            return this;
        }

        public Builder os_type(String str) {
            this.os_type = str;
            return this;
        }

        public Builder net_work(String str) {
            this.net_work = str;
            return this;
        }

        public Builder os_ver(String str) {
            this.os_ver = str;
            return this;
        }

        public Builder client_ver(String str) {
            this.client_ver = str;
            return this;
        }

        public Builder carrier_operator(String str) {
            this.carrier_operator = str;
            return this;
        }

        public Address build() {
            checkRequiredFields();
            return new Address(this);
        }
    }
}
