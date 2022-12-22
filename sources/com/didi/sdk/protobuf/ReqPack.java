package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class ReqPack extends Message {
    public static final ByteString DEFAULT_BODY = ByteString.EMPTY;
    public static final List<String> DEFAULT_HEADER = Collections.emptyList();
    public static final String DEFAULT_METHOD = "";
    public static final String DEFAULT_URL = "";
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString body;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> header;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String method;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String url;

    public ReqPack(String str, String str2, List<String> list, ByteString byteString) {
        this.url = str;
        this.method = str2;
        this.header = immutableCopyOf(list);
        this.body = byteString;
    }

    private ReqPack(Builder builder) {
        this(builder.url, builder.method, builder.header, builder.body);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ReqPack)) {
            return false;
        }
        ReqPack reqPack = (ReqPack) obj;
        if (!equals((Object) this.url, (Object) reqPack.url) || !equals((Object) this.method, (Object) reqPack.method) || !equals((List<?>) this.header, (List<?>) reqPack.header) || !equals((Object) this.body, (Object) reqPack.body)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.method;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        List<String> list = this.header;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        ByteString byteString = this.body;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<ReqPack> {
        public ByteString body;
        public List<String> header;
        public String method;
        public String url;

        public Builder() {
        }

        public Builder(ReqPack reqPack) {
            super(reqPack);
            if (reqPack != null) {
                this.url = reqPack.url;
                this.method = reqPack.method;
                this.header = ReqPack.copyOf(reqPack.header);
                this.body = reqPack.body;
            }
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder method(String str) {
            this.method = str;
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

        public ReqPack build() {
            checkRequiredFields();
            return new ReqPack(this);
        }
    }
}
