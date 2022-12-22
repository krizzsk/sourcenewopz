package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class TransHttpRsp extends Message {
    public static final ByteString DEFAULT_BODY = ByteString.EMPTY;
    public static final List<String> DEFAULT_HEADER = Collections.emptyList();
    public static final Integer DEFAULT_SC = 0;
    @ProtoField(tag = 3, type = Message.Datatype.BYTES)
    public final ByteString body;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> header;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)

    /* renamed from: sc */
    public final Integer f36964sc;

    public TransHttpRsp(Integer num, List<String> list, ByteString byteString) {
        this.f36964sc = num;
        this.header = immutableCopyOf(list);
        this.body = byteString;
    }

    private TransHttpRsp(Builder builder) {
        this(builder.f36965sc, builder.header, builder.body);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransHttpRsp)) {
            return false;
        }
        TransHttpRsp transHttpRsp = (TransHttpRsp) obj;
        if (!equals((Object) this.f36964sc, (Object) transHttpRsp.f36964sc) || !equals((List<?>) this.header, (List<?>) transHttpRsp.header) || !equals((Object) this.body, (Object) transHttpRsp.body)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.f36964sc;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        List<String> list = this.header;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        ByteString byteString = this.body;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TransHttpRsp> {
        public ByteString body;
        public List<String> header;

        /* renamed from: sc */
        public Integer f36965sc;

        public Builder() {
        }

        public Builder(TransHttpRsp transHttpRsp) {
            super(transHttpRsp);
            if (transHttpRsp != null) {
                this.f36965sc = transHttpRsp.f36964sc;
                this.header = TransHttpRsp.copyOf(transHttpRsp.header);
                this.body = transHttpRsp.body;
            }
        }

        /* renamed from: sc */
        public Builder mo95049sc(Integer num) {
            this.f36965sc = num;
            return this;
        }

        public Builder header(List<String> list) {
            this.header = checkForNulls(list);
            return this;
        }

        public Builder body(ByteString byteString) {
            this.body = byteString;
            return this;
        }

        public TransHttpRsp build() {
            checkRequiredFields();
            return new TransHttpRsp(this);
        }
    }
}
