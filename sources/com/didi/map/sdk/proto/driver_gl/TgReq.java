package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TgReq extends Message {
    public static final String DEFAULT_APINAME = "";
    public static final Boolean DEFAULT_ISSUPPORTMC = false;
    public static final List<OidPidPair> DEFAULT_OIDPIDPAIRS = Collections.emptyList();
    public static final String DEFAULT_SCENES = "";
    public static final String DEFAULT_TOKEN = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String apiname;
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean isSupportMc;
    @ProtoField(label = Message.Label.REPEATED, messageType = OidPidPair.class, tag = 4)
    public final List<OidPidPair> oidPidPairs;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String scenes;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String token;

    public TgReq(String str, String str2, String str3, List<OidPidPair> list, Boolean bool) {
        this.apiname = str;
        this.scenes = str2;
        this.token = str3;
        this.oidPidPairs = immutableCopyOf(list);
        this.isSupportMc = bool;
    }

    private TgReq(Builder builder) {
        this(builder.apiname, builder.scenes, builder.token, builder.oidPidPairs, builder.isSupportMc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TgReq)) {
            return false;
        }
        TgReq tgReq = (TgReq) obj;
        if (!equals((Object) this.apiname, (Object) tgReq.apiname) || !equals((Object) this.scenes, (Object) tgReq.scenes) || !equals((Object) this.token, (Object) tgReq.token) || !equals((List<?>) this.oidPidPairs, (List<?>) tgReq.oidPidPairs) || !equals((Object) this.isSupportMc, (Object) tgReq.isSupportMc)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.apiname;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.scenes;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.token;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<OidPidPair> list = this.oidPidPairs;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        Boolean bool = this.isSupportMc;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TgReq> {
        public String apiname;
        public Boolean isSupportMc;
        public List<OidPidPair> oidPidPairs;
        public String scenes;
        public String token;

        public Builder() {
        }

        public Builder(TgReq tgReq) {
            super(tgReq);
            if (tgReq != null) {
                this.apiname = tgReq.apiname;
                this.scenes = tgReq.scenes;
                this.token = tgReq.token;
                this.oidPidPairs = TgReq.copyOf(tgReq.oidPidPairs);
                this.isSupportMc = tgReq.isSupportMc;
            }
        }

        public Builder apiname(String str) {
            this.apiname = str;
            return this;
        }

        public Builder scenes(String str) {
            this.scenes = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder oidPidPairs(List<OidPidPair> list) {
            this.oidPidPairs = checkForNulls(list);
            return this;
        }

        public Builder isSupportMc(Boolean bool) {
            this.isSupportMc = bool;
            return this;
        }

        public TgReq build() {
            checkRequiredFields();
            return new TgReq(this);
        }
    }
}
