package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BusinessPassengerGameRemindReq extends Message {
    public static final String DEFAULT_H5_URL = "";
    public static final String DEFAULT_ICON_URL = "";
    public static final String DEFAULT_TITLE = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String h5_url;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String icon_url;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer type;

    public BusinessPassengerGameRemindReq(Integer num, String str, String str2, String str3) {
        this.type = num;
        this.h5_url = str;
        this.icon_url = str2;
        this.title = str3;
    }

    private BusinessPassengerGameRemindReq(Builder builder) {
        this(builder.type, builder.h5_url, builder.icon_url, builder.title);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BusinessPassengerGameRemindReq)) {
            return false;
        }
        BusinessPassengerGameRemindReq businessPassengerGameRemindReq = (BusinessPassengerGameRemindReq) obj;
        if (!equals((Object) this.type, (Object) businessPassengerGameRemindReq.type) || !equals((Object) this.h5_url, (Object) businessPassengerGameRemindReq.h5_url) || !equals((Object) this.icon_url, (Object) businessPassengerGameRemindReq.icon_url) || !equals((Object) this.title, (Object) businessPassengerGameRemindReq.title)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.type;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.h5_url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.icon_url;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.title;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BusinessPassengerGameRemindReq> {
        public String h5_url;
        public String icon_url;
        public String title;
        public Integer type;

        public Builder() {
        }

        public Builder(BusinessPassengerGameRemindReq businessPassengerGameRemindReq) {
            super(businessPassengerGameRemindReq);
            if (businessPassengerGameRemindReq != null) {
                this.type = businessPassengerGameRemindReq.type;
                this.h5_url = businessPassengerGameRemindReq.h5_url;
                this.icon_url = businessPassengerGameRemindReq.icon_url;
                this.title = businessPassengerGameRemindReq.title;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder h5_url(String str) {
            this.h5_url = str;
            return this;
        }

        public Builder icon_url(String str) {
            this.icon_url = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public BusinessPassengerGameRemindReq build() {
            checkRequiredFields();
            return new BusinessPassengerGameRemindReq(this);
        }
    }
}
