package com.didi.trackupload.sdk.datachannel.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class UserConnInfo extends Message {
    public static final ByteString DEFAULT_IP = ByteString.EMPTY;
    public static final Integer DEFAULT_PORT = 0;
    public static final String DEFAULT_ZONE = "";
    @ProtoField(tag = 1, type = Message.Datatype.BYTES)

    /* renamed from: ip */
    public final ByteString f43988ip;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer port;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String zone;

    public UserConnInfo(ByteString byteString, Integer num, String str) {
        this.f43988ip = byteString;
        this.port = num;
        this.zone = str;
    }

    private UserConnInfo(Builder builder) {
        this(builder.f43989ip, builder.port, builder.zone);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserConnInfo)) {
            return false;
        }
        UserConnInfo userConnInfo = (UserConnInfo) obj;
        if (!equals((Object) this.f43988ip, (Object) userConnInfo.f43988ip) || !equals((Object) this.port, (Object) userConnInfo.port) || !equals((Object) this.zone, (Object) userConnInfo.zone)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        ByteString byteString = this.f43988ip;
        int i2 = 0;
        int hashCode = (byteString != null ? byteString.hashCode() : 0) * 37;
        Integer num = this.port;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.zone;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserConnInfo> {

        /* renamed from: ip */
        public ByteString f43989ip;
        public Integer port;
        public String zone;

        public Builder() {
        }

        public Builder(UserConnInfo userConnInfo) {
            super(userConnInfo);
            if (userConnInfo != null) {
                this.f43989ip = userConnInfo.f43988ip;
                this.port = userConnInfo.port;
                this.zone = userConnInfo.zone;
            }
        }

        /* renamed from: ip */
        public Builder mo109556ip(ByteString byteString) {
            this.f43989ip = byteString;
            return this;
        }

        public Builder port(Integer num) {
            this.port = num;
            return this;
        }

        public Builder zone(String str) {
            this.zone = str;
            return this;
        }

        public UserConnInfo build() {
            return new UserConnInfo(this);
        }
    }
}
