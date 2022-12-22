package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class UserLocationRes extends Message {
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final List<UserLocation> DEFAULT_USERLOCATIONS = Collections.emptyList();
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserLocation.class, tag = 3)
    public final List<UserLocation> userLocations;

    public UserLocationRes(Integer num, String str, List<UserLocation> list, Long l) {
        this.ret = num;
        this.msg = str;
        this.userLocations = immutableCopyOf(list);
        this.logId = l;
    }

    private UserLocationRes(Builder builder) {
        this(builder.ret, builder.msg, builder.userLocations, builder.logId);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserLocationRes)) {
            return false;
        }
        UserLocationRes userLocationRes = (UserLocationRes) obj;
        if (!equals((Object) this.ret, (Object) userLocationRes.ret) || !equals((Object) this.msg, (Object) userLocationRes.msg) || !equals((List<?>) this.userLocations, (List<?>) userLocationRes.userLocations) || !equals((Object) this.logId, (Object) userLocationRes.logId)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<UserLocation> list = this.userLocations;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.logId;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<UserLocationRes> {
        public Long logId;
        public String msg;
        public Integer ret;
        public List<UserLocation> userLocations;

        public Builder() {
        }

        public Builder(UserLocationRes userLocationRes) {
            super(userLocationRes);
            if (userLocationRes != null) {
                this.ret = userLocationRes.ret;
                this.msg = userLocationRes.msg;
                this.userLocations = UserLocationRes.copyOf(userLocationRes.userLocations);
                this.logId = userLocationRes.logId;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder userLocations(List<UserLocation> list) {
            this.userLocations = checkForNulls(list);
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public UserLocationRes build() {
            checkRequiredFields();
            return new UserLocationRes(this);
        }
    }
}
