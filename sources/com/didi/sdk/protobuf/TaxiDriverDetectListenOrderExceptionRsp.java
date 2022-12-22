package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiDriverDetectListenOrderExceptionRsp extends Message {
    public static final Long DEFAULT_ID = 0L;
    public static final Boolean DEFAULT_ISOK = false;
    public static final Integer DEFAULT_LISTENORDEREXCEPTIONTYPE = 0;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_VCODE = "";
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)

    /* renamed from: id */
    public final Long f36954id;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean isOk;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer listenOrderExceptionType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String vcode;

    public TaxiDriverDetectListenOrderExceptionRsp(Integer num, Long l, String str, String str2, Boolean bool) {
        this.listenOrderExceptionType = num;
        this.f36954id = l;
        this.vcode = str;
        this.text = str2;
        this.isOk = bool;
    }

    private TaxiDriverDetectListenOrderExceptionRsp(Builder builder) {
        this(builder.listenOrderExceptionType, builder.f36955id, builder.vcode, builder.text, builder.isOk);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverDetectListenOrderExceptionRsp)) {
            return false;
        }
        TaxiDriverDetectListenOrderExceptionRsp taxiDriverDetectListenOrderExceptionRsp = (TaxiDriverDetectListenOrderExceptionRsp) obj;
        if (!equals((Object) this.listenOrderExceptionType, (Object) taxiDriverDetectListenOrderExceptionRsp.listenOrderExceptionType) || !equals((Object) this.f36954id, (Object) taxiDriverDetectListenOrderExceptionRsp.f36954id) || !equals((Object) this.vcode, (Object) taxiDriverDetectListenOrderExceptionRsp.vcode) || !equals((Object) this.text, (Object) taxiDriverDetectListenOrderExceptionRsp.text) || !equals((Object) this.isOk, (Object) taxiDriverDetectListenOrderExceptionRsp.isOk)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.listenOrderExceptionType;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.f36954id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.vcode;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.text;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.isOk;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiDriverDetectListenOrderExceptionRsp> {

        /* renamed from: id */
        public Long f36955id;
        public Boolean isOk;
        public Integer listenOrderExceptionType;
        public String text;
        public String vcode;

        public Builder() {
        }

        public Builder(TaxiDriverDetectListenOrderExceptionRsp taxiDriverDetectListenOrderExceptionRsp) {
            super(taxiDriverDetectListenOrderExceptionRsp);
            if (taxiDriverDetectListenOrderExceptionRsp != null) {
                this.listenOrderExceptionType = taxiDriverDetectListenOrderExceptionRsp.listenOrderExceptionType;
                this.f36955id = taxiDriverDetectListenOrderExceptionRsp.f36954id;
                this.vcode = taxiDriverDetectListenOrderExceptionRsp.vcode;
                this.text = taxiDriverDetectListenOrderExceptionRsp.text;
                this.isOk = taxiDriverDetectListenOrderExceptionRsp.isOk;
            }
        }

        public Builder listenOrderExceptionType(Integer num) {
            this.listenOrderExceptionType = num;
            return this;
        }

        /* renamed from: id */
        public Builder mo94835id(Long l) {
            this.f36955id = l;
            return this;
        }

        public Builder vcode(String str) {
            this.vcode = str;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder isOk(Boolean bool) {
            this.isOk = bool;
            return this;
        }

        public TaxiDriverDetectListenOrderExceptionRsp build() {
            return new TaxiDriverDetectListenOrderExceptionRsp(this);
        }
    }
}
