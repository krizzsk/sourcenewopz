package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class CommonMsgReq extends Message {
    public static final String DEFAULT_RECOMMOND_MSG = "";
    public static final Integer DEFAULT_RECOMMOND_TYPE = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String recommond_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer recommond_type;

    public CommonMsgReq(String str, Integer num) {
        this.recommond_msg = str;
        this.recommond_type = num;
    }

    private CommonMsgReq(Builder builder) {
        this(builder.recommond_msg, builder.recommond_type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CommonMsgReq)) {
            return false;
        }
        CommonMsgReq commonMsgReq = (CommonMsgReq) obj;
        if (!equals((Object) this.recommond_msg, (Object) commonMsgReq.recommond_msg) || !equals((Object) this.recommond_type, (Object) commonMsgReq.recommond_type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.recommond_msg;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.recommond_type;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CommonMsgReq> {
        public String recommond_msg;
        public Integer recommond_type;

        public Builder() {
        }

        public Builder(CommonMsgReq commonMsgReq) {
            super(commonMsgReq);
            if (commonMsgReq != null) {
                this.recommond_msg = commonMsgReq.recommond_msg;
                this.recommond_type = commonMsgReq.recommond_type;
            }
        }

        public Builder recommond_msg(String str) {
            this.recommond_msg = str;
            return this;
        }

        public Builder recommond_type(Integer num) {
            this.recommond_type = num;
            return this;
        }

        public CommonMsgReq build() {
            checkRequiredFields();
            return new CommonMsgReq(this);
        }
    }
}
