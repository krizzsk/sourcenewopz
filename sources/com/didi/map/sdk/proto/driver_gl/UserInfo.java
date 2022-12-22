package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class UserInfo extends Message {
    public static final Integer DEFAULT_BIZTYPE = 0;
    public static final String DEFAULT_ORDERID = "";
    public static final String DEFAULT_TRAVELID = "";
    public static final Long DEFAULT_USERID = 0L;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer bizType;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String orderId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String travelId;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long userId;

    public UserInfo(String str, String str2, Long l, Integer num) {
        this.orderId = str;
        this.travelId = str2;
        this.userId = l;
        this.bizType = num;
    }

    private UserInfo(Builder builder) {
        this(builder.orderId, builder.travelId, builder.userId, builder.bizType);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (!equals((Object) this.orderId, (Object) userInfo.orderId) || !equals((Object) this.travelId, (Object) userInfo.travelId) || !equals((Object) this.userId, (Object) userInfo.userId) || !equals((Object) this.bizType, (Object) userInfo.bizType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.orderId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.travelId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.userId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.bizType;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserInfo> {
        public Integer bizType;
        public String orderId;
        public String travelId;
        public Long userId;

        public Builder() {
        }

        public Builder(UserInfo userInfo) {
            super(userInfo);
            if (userInfo != null) {
                this.orderId = userInfo.orderId;
                this.travelId = userInfo.travelId;
                this.userId = userInfo.userId;
                this.bizType = userInfo.bizType;
            }
        }

        public Builder orderId(String str) {
            this.orderId = str;
            return this;
        }

        public Builder travelId(String str) {
            this.travelId = str;
            return this;
        }

        public Builder userId(Long l) {
            this.userId = l;
            return this;
        }

        public Builder bizType(Integer num) {
            this.bizType = num;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }
    }
}
