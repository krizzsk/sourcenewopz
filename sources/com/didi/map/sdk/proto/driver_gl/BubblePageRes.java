package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BubblePageRes extends Message {
    public static final String DEFAULT_DEBUGMSG = "";
    public static final Long DEFAULT_LOGID = 0L;
    public static final String DEFAULT_MSG = "";
    public static final Integer DEFAULT_RET = -1;
    public static final String DEFAULT_TRACEID = "";
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String debugMsg;
    @ProtoField(tag = 4)
    public final EstimateInfo estimateInfo;
    @ProtoField(tag = 3, type = Message.Datatype.UINT64)
    public final Long logId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String msg;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer ret;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String traceId;

    public BubblePageRes(Integer num, String str, Long l, EstimateInfo estimateInfo2, String str2, String str3) {
        this.ret = num;
        this.msg = str;
        this.logId = l;
        this.estimateInfo = estimateInfo2;
        this.traceId = str2;
        this.debugMsg = str3;
    }

    private BubblePageRes(Builder builder) {
        this(builder.ret, builder.msg, builder.logId, builder.estimateInfo, builder.traceId, builder.debugMsg);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BubblePageRes)) {
            return false;
        }
        BubblePageRes bubblePageRes = (BubblePageRes) obj;
        if (!equals((Object) this.ret, (Object) bubblePageRes.ret) || !equals((Object) this.msg, (Object) bubblePageRes.msg) || !equals((Object) this.logId, (Object) bubblePageRes.logId) || !equals((Object) this.estimateInfo, (Object) bubblePageRes.estimateInfo) || !equals((Object) this.traceId, (Object) bubblePageRes.traceId) || !equals((Object) this.debugMsg, (Object) bubblePageRes.debugMsg)) {
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
        Long l = this.logId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        EstimateInfo estimateInfo2 = this.estimateInfo;
        int hashCode4 = (hashCode3 + (estimateInfo2 != null ? estimateInfo2.hashCode() : 0)) * 37;
        String str2 = this.traceId;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.debugMsg;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BubblePageRes> {
        public String debugMsg;
        public EstimateInfo estimateInfo;
        public Long logId;
        public String msg;
        public Integer ret;
        public String traceId;

        public Builder() {
        }

        public Builder(BubblePageRes bubblePageRes) {
            super(bubblePageRes);
            if (bubblePageRes != null) {
                this.ret = bubblePageRes.ret;
                this.msg = bubblePageRes.msg;
                this.logId = bubblePageRes.logId;
                this.estimateInfo = bubblePageRes.estimateInfo;
                this.traceId = bubblePageRes.traceId;
                this.debugMsg = bubblePageRes.debugMsg;
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

        public Builder logId(Long l) {
            this.logId = l;
            return this;
        }

        public Builder estimateInfo(EstimateInfo estimateInfo2) {
            this.estimateInfo = estimateInfo2;
            return this;
        }

        public Builder traceId(String str) {
            this.traceId = str;
            return this;
        }

        public Builder debugMsg(String str) {
            this.debugMsg = str;
            return this;
        }

        public BubblePageRes build() {
            return new BubblePageRes(this);
        }
    }
}
