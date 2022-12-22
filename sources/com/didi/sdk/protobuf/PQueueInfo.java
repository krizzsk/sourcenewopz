package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PQueueInfo extends Message {
    public static final Integer DEFAULT_ETA = 0;
    public static final Integer DEFAULT_IS_QUEUE = 0;
    public static final Integer DEFAULT_LEN = 0;
    public static final String DEFAULT_TEXT = "";
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer is_queue;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer len;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String text;

    public PQueueInfo(String str, Integer num, Integer num2, Integer num3) {
        this.text = str;
        this.is_queue = num;
        this.eta = num2;
        this.len = num3;
    }

    private PQueueInfo(Builder builder) {
        this(builder.text, builder.is_queue, builder.eta, builder.len);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PQueueInfo)) {
            return false;
        }
        PQueueInfo pQueueInfo = (PQueueInfo) obj;
        if (!equals((Object) this.text, (Object) pQueueInfo.text) || !equals((Object) this.is_queue, (Object) pQueueInfo.is_queue) || !equals((Object) this.eta, (Object) pQueueInfo.eta) || !equals((Object) this.len, (Object) pQueueInfo.len)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.text;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Integer num = this.is_queue;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.eta;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.len;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PQueueInfo> {
        public Integer eta;
        public Integer is_queue;
        public Integer len;
        public String text;

        public Builder() {
        }

        public Builder(PQueueInfo pQueueInfo) {
            super(pQueueInfo);
            if (pQueueInfo != null) {
                this.text = pQueueInfo.text;
                this.is_queue = pQueueInfo.is_queue;
                this.eta = pQueueInfo.eta;
                this.len = pQueueInfo.len;
            }
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder is_queue(Integer num) {
            this.is_queue = num;
            return this;
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder len(Integer num) {
            this.len = num;
            return this;
        }

        public PQueueInfo build() {
            checkRequiredFields();
            return new PQueueInfo(this);
        }
    }
}
