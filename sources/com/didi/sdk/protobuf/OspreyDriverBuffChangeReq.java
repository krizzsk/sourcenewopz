package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OspreyDriverBuffChangeReq extends Message {
    public static final String DEFAULT_BUFF_STR = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String buff_str;

    public OspreyDriverBuffChangeReq(String str) {
        this.buff_str = str;
    }

    private OspreyDriverBuffChangeReq(Builder builder) {
        this(builder.buff_str);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OspreyDriverBuffChangeReq)) {
            return false;
        }
        return equals((Object) this.buff_str, (Object) ((OspreyDriverBuffChangeReq) obj).buff_str);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.buff_str;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<OspreyDriverBuffChangeReq> {
        public String buff_str;

        public Builder() {
        }

        public Builder(OspreyDriverBuffChangeReq ospreyDriverBuffChangeReq) {
            super(ospreyDriverBuffChangeReq);
            if (ospreyDriverBuffChangeReq != null) {
                this.buff_str = ospreyDriverBuffChangeReq.buff_str;
            }
        }

        public Builder buff_str(String str) {
            this.buff_str = str;
            return this;
        }

        public OspreyDriverBuffChangeReq build() {
            checkRequiredFields();
            return new OspreyDriverBuffChangeReq(this);
        }
    }
}
