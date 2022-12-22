package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UserLocationReq extends Message {
    public static final String DEFAULT_PHONENUM = "";
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    public static final List<UserInfo> DEFAULT_USERS = Collections.emptyList();
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String phoneNum;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserInfo.class, tag = 1)
    public final List<UserInfo> users;

    public UserLocationReq(List<UserInfo> list, String str, String str2, Integer num) {
        this.users = immutableCopyOf(list);
        this.token = str;
        this.phoneNum = str2;
        this.type = num;
    }

    private UserLocationReq(Builder builder) {
        this(builder.users, builder.token, builder.phoneNum, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLocationReq)) {
            return false;
        }
        UserLocationReq userLocationReq = (UserLocationReq) obj;
        if (!equals((List<?>) this.users, (List<?>) userLocationReq.users) || !equals((Object) this.token, (Object) userLocationReq.token) || !equals((Object) this.phoneNum, (Object) userLocationReq.phoneNum) || !equals((Object) this.type, (Object) userLocationReq.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<UserInfo> list = this.users;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        String str = this.token;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.phoneNum;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLocationReq> {
        public String phoneNum;
        public String token;
        public Integer type;
        public List<UserInfo> users;

        public Builder() {
        }

        public Builder(UserLocationReq userLocationReq) {
            super(userLocationReq);
            if (userLocationReq != null) {
                this.users = UserLocationReq.copyOf(userLocationReq.users);
                this.token = userLocationReq.token;
                this.phoneNum = userLocationReq.phoneNum;
                this.type = userLocationReq.type;
            }
        }

        public Builder users(List<UserInfo> list) {
            this.users = checkForNulls(list);
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder phoneNum(String str) {
            this.phoneNum = str;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public UserLocationReq build() {
            checkRequiredFields();
            return new UserLocationReq(this);
        }
    }
}
