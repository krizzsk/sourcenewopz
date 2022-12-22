package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class ConnSvrConnectReq extends Message {
    public static final OldRole DEFAULT_OLD_ROLE = OldRole.OldUnknown;
    public static final String DEFAULT_PHONE_NUM = "";
    public static final Integer DEFAULT_ROLE = 0;
    public static final ByteString DEFAULT_SECRET_CHAP = ByteString.EMPTY;
    public static final ByteString DEFAULT_USER_AGENT = ByteString.EMPTY;
    @ProtoField(tag = 2, type = Message.Datatype.ENUM)
    public final OldRole old_role;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.BYTES)
    public final ByteString secret_chap;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString user_agent;

    public ConnSvrConnectReq(String str, OldRole oldRole, ByteString byteString, ByteString byteString2, Integer num) {
        this.phone_num = str;
        this.old_role = oldRole;
        this.secret_chap = byteString;
        this.user_agent = byteString2;
        this.role = num;
    }

    private ConnSvrConnectReq(Builder builder) {
        this(builder.phone_num, builder.old_role, builder.secret_chap, builder.user_agent, builder.role);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnSvrConnectReq)) {
            return false;
        }
        ConnSvrConnectReq connSvrConnectReq = (ConnSvrConnectReq) obj;
        if (!equals((Object) this.phone_num, (Object) connSvrConnectReq.phone_num) || !equals((Object) this.old_role, (Object) connSvrConnectReq.old_role) || !equals((Object) this.secret_chap, (Object) connSvrConnectReq.secret_chap) || !equals((Object) this.user_agent, (Object) connSvrConnectReq.user_agent) || !equals((Object) this.role, (Object) connSvrConnectReq.role)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone_num;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        OldRole oldRole = this.old_role;
        int hashCode2 = (hashCode + (oldRole != null ? oldRole.hashCode() : 0)) * 37;
        ByteString byteString = this.secret_chap;
        int hashCode3 = (hashCode2 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        ByteString byteString2 = this.user_agent;
        int hashCode4 = (hashCode3 + (byteString2 != null ? byteString2.hashCode() : 0)) * 37;
        Integer num = this.role;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ConnSvrConnectReq> {
        public OldRole old_role;
        public String phone_num;
        public Integer role;
        public ByteString secret_chap;
        public ByteString user_agent;

        public Builder() {
        }

        public Builder(ConnSvrConnectReq connSvrConnectReq) {
            super(connSvrConnectReq);
            if (connSvrConnectReq != null) {
                this.phone_num = connSvrConnectReq.phone_num;
                this.old_role = connSvrConnectReq.old_role;
                this.secret_chap = connSvrConnectReq.secret_chap;
                this.user_agent = connSvrConnectReq.user_agent;
                this.role = connSvrConnectReq.role;
            }
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder old_role(OldRole oldRole) {
            this.old_role = oldRole;
            return this;
        }

        public Builder secret_chap(ByteString byteString) {
            this.secret_chap = byteString;
            return this;
        }

        public Builder user_agent(ByteString byteString) {
            this.user_agent = byteString;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public ConnSvrConnectReq build() {
            checkRequiredFields();
            return new ConnSvrConnectReq(this);
        }
    }
}
