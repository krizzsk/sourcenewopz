package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class GalileoDriverLocResp extends Message {
    public static final String DEFAULT_ERRMSG = "";
    public static final Integer DEFAULT_ERRORNO = 0;
    public static final String DEFAULT_RESP = "";
    public static final Long DEFAULT_SERVER_TIME = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String errmsg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer errorno;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String resp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.INT64)
    public final Long server_time;

    public GalileoDriverLocResp(Integer num, String str, Long l, String str2) {
        this.errorno = num;
        this.errmsg = str;
        this.server_time = l;
        this.resp = str2;
    }

    private GalileoDriverLocResp(Builder builder) {
        this(builder.errorno, builder.errmsg, builder.server_time, builder.resp);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GalileoDriverLocResp)) {
            return false;
        }
        GalileoDriverLocResp galileoDriverLocResp = (GalileoDriverLocResp) obj;
        if (!equals((Object) this.errorno, (Object) galileoDriverLocResp.errorno) || !equals((Object) this.errmsg, (Object) galileoDriverLocResp.errmsg) || !equals((Object) this.server_time, (Object) galileoDriverLocResp.server_time) || !equals((Object) this.resp, (Object) galileoDriverLocResp.resp)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.errorno;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.errmsg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Long l = this.server_time;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.resp;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<GalileoDriverLocResp> {
        public String errmsg;
        public Integer errorno;
        public String resp;
        public Long server_time;

        public Builder() {
        }

        public Builder(GalileoDriverLocResp galileoDriverLocResp) {
            super(galileoDriverLocResp);
            if (galileoDriverLocResp != null) {
                this.errorno = galileoDriverLocResp.errorno;
                this.errmsg = galileoDriverLocResp.errmsg;
                this.server_time = galileoDriverLocResp.server_time;
                this.resp = galileoDriverLocResp.resp;
            }
        }

        public Builder errorno(Integer num) {
            this.errorno = num;
            return this;
        }

        public Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public Builder server_time(Long l) {
            this.server_time = l;
            return this;
        }

        public Builder resp(String str) {
            this.resp = str;
            return this;
        }

        public GalileoDriverLocResp build() {
            checkRequiredFields();
            return new GalileoDriverLocResp(this);
        }
    }
}
