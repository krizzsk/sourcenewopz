package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import okio.ByteString;

public final class Header extends Message {
    public static final Long DEFAULT_AUTH_USER_ID = 0L;
    public static final Long DEFAULT_CITY_ID = 0L;
    public static final Integer DEFAULT_FLOW_TAG = 0;
    public static final ByteString DEFAULT_LOG_ID = ByteString.EMPTY;
    public static final Long DEFAULT_MSG_ID = 0L;
    public static final Long DEFAULT_TIMESTAMP = 0L;
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long auth_user_id;
    @ProtoField(tag = 8, type = Message.Datatype.UINT64)
    public final Long city_id;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer flow_tag;
    @ProtoField(tag = 4, type = Message.Datatype.BYTES)
    public final ByteString log_id;
    @ProtoField(tag = 2, type = Message.Datatype.UINT64)
    public final Long msg_id;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long timestamp;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 5)
    public final UserAgent user_agent;
    @ProtoField(tag = 7)
    public final UserConnInfo user_conn_info;

    public Header(Integer num, Long l, Long l2, ByteString byteString, UserAgent userAgent, Long l3, UserConnInfo userConnInfo, Long l4, Integer num2) {
        this.type = num;
        this.msg_id = l;
        this.auth_user_id = l2;
        this.log_id = byteString;
        this.user_agent = userAgent;
        this.timestamp = l3;
        this.user_conn_info = userConnInfo;
        this.city_id = l4;
        this.flow_tag = num2;
    }

    private Header(Builder builder) {
        this(builder.type, builder.msg_id, builder.auth_user_id, builder.log_id, builder.user_agent, builder.timestamp, builder.user_conn_info, builder.city_id, builder.flow_tag);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        if (!equals((Object) this.type, (Object) header.type) || !equals((Object) this.msg_id, (Object) header.msg_id) || !equals((Object) this.auth_user_id, (Object) header.auth_user_id) || !equals((Object) this.log_id, (Object) header.log_id) || !equals((Object) this.user_agent, (Object) header.user_agent) || !equals((Object) this.timestamp, (Object) header.timestamp) || !equals((Object) this.user_conn_info, (Object) header.user_conn_info) || !equals((Object) this.city_id, (Object) header.city_id) || !equals((Object) this.flow_tag, (Object) header.flow_tag)) {
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
        Long l = this.msg_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.auth_user_id;
        int hashCode3 = (hashCode2 + (l2 != null ? l2.hashCode() : 0)) * 37;
        ByteString byteString = this.log_id;
        int hashCode4 = (hashCode3 + (byteString != null ? byteString.hashCode() : 0)) * 37;
        UserAgent userAgent = this.user_agent;
        int hashCode5 = (hashCode4 + (userAgent != null ? userAgent.hashCode() : 0)) * 37;
        Long l3 = this.timestamp;
        int hashCode6 = (hashCode5 + (l3 != null ? l3.hashCode() : 0)) * 37;
        UserConnInfo userConnInfo = this.user_conn_info;
        int hashCode7 = (hashCode6 + (userConnInfo != null ? userConnInfo.hashCode() : 0)) * 37;
        Long l4 = this.city_id;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num2 = this.flow_tag;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<Header> {
        public Long auth_user_id;
        public Long city_id;
        public Integer flow_tag;
        public ByteString log_id;
        public Long msg_id;
        public Long timestamp;
        public Integer type;
        public UserAgent user_agent;
        public UserConnInfo user_conn_info;

        public Builder() {
        }

        public Builder(Header header) {
            super(header);
            if (header != null) {
                this.type = header.type;
                this.msg_id = header.msg_id;
                this.auth_user_id = header.auth_user_id;
                this.log_id = header.log_id;
                this.user_agent = header.user_agent;
                this.timestamp = header.timestamp;
                this.user_conn_info = header.user_conn_info;
                this.city_id = header.city_id;
                this.flow_tag = header.flow_tag;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder msg_id(Long l) {
            this.msg_id = l;
            return this;
        }

        public Builder auth_user_id(Long l) {
            this.auth_user_id = l;
            return this;
        }

        public Builder log_id(ByteString byteString) {
            this.log_id = byteString;
            return this;
        }

        public Builder user_agent(UserAgent userAgent) {
            this.user_agent = userAgent;
            return this;
        }

        public Builder timestamp(Long l) {
            this.timestamp = l;
            return this;
        }

        public Builder user_conn_info(UserConnInfo userConnInfo) {
            this.user_conn_info = userConnInfo;
            return this;
        }

        public Builder city_id(Long l) {
            this.city_id = l;
            return this;
        }

        public Builder flow_tag(Integer num) {
            this.flow_tag = num;
            return this;
        }

        public Header build() {
            checkRequiredFields();
            return new Header(this);
        }
    }
}
