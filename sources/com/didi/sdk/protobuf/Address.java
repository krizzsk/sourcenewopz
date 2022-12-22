package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class Address extends Message {
    public static final String DEFAULT_IP = "";
    public static final Integer DEFAULT_PORT = 0;
    public static final Boolean DEFAULT_SHOULD_STAT = false;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)

    /* renamed from: ip */
    public final String f36932ip;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer port;
    @ProtoField(tag = 4, type = Message.Datatype.BOOL)
    public final Boolean should_stat;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long timestamp;

    public Address(String str, Integer num, Long l, Boolean bool) {
        this.f36932ip = str;
        this.port = num;
        this.timestamp = l;
        this.should_stat = bool;
    }

    private Address(Builder builder) {
        this(builder.f36933ip, builder.port, builder.timestamp, builder.should_stat);
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
        if (!equals((Object) this.f36932ip, (Object) address.f36932ip) || !equals((Object) this.port, (Object) address.port) || !equals((Object) this.timestamp, (Object) address.timestamp) || !equals((Object) this.should_stat, (Object) address.should_stat)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.f36932ip;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.port;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Long l = this.timestamp;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.should_stat;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Address> {

        /* renamed from: ip */
        public String f36933ip;
        public Integer port;
        public Boolean should_stat;
        public Long timestamp;

        public Builder() {
        }

        public Builder(Address address) {
            super(address);
            if (address != null) {
                this.f36933ip = address.f36932ip;
                this.port = address.port;
                this.timestamp = address.timestamp;
                this.should_stat = address.should_stat;
            }
        }

        /* renamed from: ip */
        public Builder mo94098ip(String str) {
            this.f36933ip = str;
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

        public Address build() {
            checkRequiredFields();
            return new Address(this);
        }
    }
}
