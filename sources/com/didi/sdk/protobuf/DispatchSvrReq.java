package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import okio.ByteString;

public final class DispatchSvrReq extends Message {
    public static final String DEFAULT_CONTENT_TYPE = "";
    public static final String DEFAULT_PATH = "";
    public static final ByteString DEFAULT_POST_DATA = ByteString.EMPTY;
    public static final List<Param> DEFAULT_QUERY_PARAMS = Collections.emptyList();
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String content_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String path;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString post_data;
    @ProtoField(label = Message.Label.REPEATED, messageType = Param.class, tag = 2)
    public final List<Param> query_params;

    public DispatchSvrReq(String str, List<Param> list, String str2, ByteString byteString) {
        this.path = str;
        this.query_params = immutableCopyOf(list);
        this.content_type = str2;
        this.post_data = byteString;
    }

    private DispatchSvrReq(Builder builder) {
        this(builder.path, builder.query_params, builder.content_type, builder.post_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DispatchSvrReq)) {
            return false;
        }
        DispatchSvrReq dispatchSvrReq = (DispatchSvrReq) obj;
        if (!equals((Object) this.path, (Object) dispatchSvrReq.path) || !equals((List<?>) this.query_params, (List<?>) dispatchSvrReq.query_params) || !equals((Object) this.content_type, (Object) dispatchSvrReq.content_type) || !equals((Object) this.post_data, (Object) dispatchSvrReq.post_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.path;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        List<Param> list = this.query_params;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str2 = this.content_type;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        ByteString byteString = this.post_data;
        if (byteString != null) {
            i2 = byteString.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DispatchSvrReq> {
        public String content_type;
        public String path;
        public ByteString post_data;
        public List<Param> query_params;

        public Builder() {
        }

        public Builder(DispatchSvrReq dispatchSvrReq) {
            super(dispatchSvrReq);
            if (dispatchSvrReq != null) {
                this.path = dispatchSvrReq.path;
                this.query_params = DispatchSvrReq.copyOf(dispatchSvrReq.query_params);
                this.content_type = dispatchSvrReq.content_type;
                this.post_data = dispatchSvrReq.post_data;
            }
        }

        public Builder path(String str) {
            this.path = str;
            return this;
        }

        public Builder query_params(List<Param> list) {
            this.query_params = checkForNulls(list);
            return this;
        }

        public Builder content_type(String str) {
            this.content_type = str;
            return this;
        }

        public Builder post_data(ByteString byteString) {
            this.post_data = byteString;
            return this;
        }

        public DispatchSvrReq build() {
            checkRequiredFields();
            return new DispatchSvrReq(this);
        }
    }
}
