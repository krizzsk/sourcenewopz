package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class SessionRes extends Message {
    public static final Long DEFAULT_SEQ = 0L;
    public static final String DEFAULT_SESSIONID = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long seq;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String sessionId;

    public SessionRes(String str, Long l) {
        this.sessionId = str;
        this.seq = l;
    }

    private SessionRes(Builder builder) {
        this(builder.sessionId, builder.seq);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SessionRes)) {
            return false;
        }
        SessionRes sessionRes = (SessionRes) obj;
        if (!equals((Object) this.sessionId, (Object) sessionRes.sessionId) || !equals((Object) this.seq, (Object) sessionRes.seq)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.sessionId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        Long l = this.seq;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<SessionRes> {
        public Long seq;
        public String sessionId;

        public Builder() {
        }

        public Builder(SessionRes sessionRes) {
            super(sessionRes);
            if (sessionRes != null) {
                this.sessionId = sessionRes.sessionId;
                this.seq = sessionRes.seq;
            }
        }

        public Builder sessionId(String str) {
            this.sessionId = str;
            return this;
        }

        public Builder seq(Long l) {
            this.seq = l;
            return this;
        }

        public SessionRes build() {
            return new SessionRes(this);
        }
    }
}
