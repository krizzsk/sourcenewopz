package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TgRes extends Message {
    public static final Boolean DEFAULT_ISENABLEMC = false;
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = 0;
    public static final List<String> DEFAULT_TRIPIDS = Collections.emptyList();
    @ProtoField(tag = 5, type = Message.Datatype.BOOL)
    public final Boolean isEnableMc;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(label = Message.Label.REPEATED, tag = 3, type = Message.Datatype.STRING)
    public final List<String> tripIds;

    public TgRes(Integer num, String str, List<String> list, Long l, Boolean bool) {
        this.ret = num;
        this.msg = str;
        this.tripIds = immutableCopyOf(list);
        this.logId = l;
        this.isEnableMc = bool;
    }

    private TgRes(Builder builder) {
        this(builder.ret, builder.msg, builder.tripIds, builder.logId, builder.isEnableMc);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TgRes)) {
            return false;
        }
        TgRes tgRes = (TgRes) obj;
        if (!equals((Object) this.ret, (Object) tgRes.ret) || !equals((Object) this.msg, (Object) tgRes.msg) || !equals((List<?>) this.tripIds, (List<?>) tgRes.tripIds) || !equals((Object) this.logId, (Object) tgRes.logId) || !equals((Object) this.isEnableMc, (Object) tgRes.isEnableMc)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.ret;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<String> list = this.tripIds;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        Long l = this.logId;
        int hashCode4 = (hashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        Boolean bool = this.isEnableMc;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TgRes> {
        public Boolean isEnableMc;
        public Long logId;
        public String msg;
        public Integer ret;
        public List<String> tripIds;

        public Builder() {
        }

        public Builder(TgRes tgRes) {
            super(tgRes);
            if (tgRes != null) {
                this.ret = tgRes.ret;
                this.msg = tgRes.msg;
                this.tripIds = TgRes.copyOf(tgRes.tripIds);
                this.logId = tgRes.logId;
                this.isEnableMc = tgRes.isEnableMc;
            }
        }

        public Builder ret(Integer num) {
            this.ret = num;
            return this;
        }

        public Builder msg(String str) {
            this.msg = str;
            return this;
        }

        public Builder tripIds(List<String> list) {
            this.tripIds = checkForNulls(list);
            return this;
        }

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder isEnableMc(Boolean bool) {
            this.isEnableMc = bool;
            return this;
        }

        public TgRes build() {
            checkRequiredFields();
            return new TgRes(this);
        }
    }
}
