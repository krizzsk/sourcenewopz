package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PushStat extends Message {
    public static final Integer DEFAULT_GT60S_RECV_CNT = 0;
    public static final Integer DEFAULT_IN10S_RECV_CNT = 0;
    public static final Integer DEFAULT_IN1S_RECV_CNT = 0;
    public static final Integer DEFAULT_IN30S_RECV_CNT = 0;
    public static final Integer DEFAULT_IN3S_RECV_CNT = 0;
    public static final Integer DEFAULT_IN60S_RECV_CNT = 0;
    public static final Integer DEFAULT_IN6S_RECV_CNT = 0;
    public static final Integer DEFAULT_RECV_CNT = 0;
    public static final Integer DEFAULT_SEND_CNT = 0;
    public static final Long DEFAULT_TASK_ID = 0L;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer gt60s_recv_cnt;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer in10s_recv_cnt;
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer in1s_recv_cnt;
    @ProtoField(tag = 8, type = Message.Datatype.UINT32)
    public final Integer in30s_recv_cnt;
    @ProtoField(tag = 5, type = Message.Datatype.UINT32)
    public final Integer in3s_recv_cnt;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer in60s_recv_cnt;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer in6s_recv_cnt;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer recv_cnt;
    @ProtoField(tag = 2, type = Message.Datatype.UINT32)
    public final Integer send_cnt;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long task_id;

    public PushStat(Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9) {
        this.task_id = l;
        this.send_cnt = num;
        this.recv_cnt = num2;
        this.in1s_recv_cnt = num3;
        this.in3s_recv_cnt = num4;
        this.in6s_recv_cnt = num5;
        this.in10s_recv_cnt = num6;
        this.in30s_recv_cnt = num7;
        this.in60s_recv_cnt = num8;
        this.gt60s_recv_cnt = num9;
    }

    private PushStat(Builder builder) {
        this(builder.task_id, builder.send_cnt, builder.recv_cnt, builder.in1s_recv_cnt, builder.in3s_recv_cnt, builder.in6s_recv_cnt, builder.in10s_recv_cnt, builder.in30s_recv_cnt, builder.in60s_recv_cnt, builder.gt60s_recv_cnt);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushStat)) {
            return false;
        }
        PushStat pushStat = (PushStat) obj;
        if (!equals((Object) this.task_id, (Object) pushStat.task_id) || !equals((Object) this.send_cnt, (Object) pushStat.send_cnt) || !equals((Object) this.recv_cnt, (Object) pushStat.recv_cnt) || !equals((Object) this.in1s_recv_cnt, (Object) pushStat.in1s_recv_cnt) || !equals((Object) this.in3s_recv_cnt, (Object) pushStat.in3s_recv_cnt) || !equals((Object) this.in6s_recv_cnt, (Object) pushStat.in6s_recv_cnt) || !equals((Object) this.in10s_recv_cnt, (Object) pushStat.in10s_recv_cnt) || !equals((Object) this.in30s_recv_cnt, (Object) pushStat.in30s_recv_cnt) || !equals((Object) this.in60s_recv_cnt, (Object) pushStat.in60s_recv_cnt) || !equals((Object) this.gt60s_recv_cnt, (Object) pushStat.gt60s_recv_cnt)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.task_id;
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        Integer num = this.send_cnt;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.recv_cnt;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.in1s_recv_cnt;
        int hashCode4 = (hashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.in3s_recv_cnt;
        int hashCode5 = (hashCode4 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.in6s_recv_cnt;
        int hashCode6 = (hashCode5 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.in10s_recv_cnt;
        int hashCode7 = (hashCode6 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.in30s_recv_cnt;
        int hashCode8 = (hashCode7 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.in60s_recv_cnt;
        int hashCode9 = (hashCode8 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.gt60s_recv_cnt;
        if (num9 != null) {
            i2 = num9.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushStat> {
        public Integer gt60s_recv_cnt;
        public Integer in10s_recv_cnt;
        public Integer in1s_recv_cnt;
        public Integer in30s_recv_cnt;
        public Integer in3s_recv_cnt;
        public Integer in60s_recv_cnt;
        public Integer in6s_recv_cnt;
        public Integer recv_cnt;
        public Integer send_cnt;
        public Long task_id;

        public Builder() {
        }

        public Builder(PushStat pushStat) {
            super(pushStat);
            if (pushStat != null) {
                this.task_id = pushStat.task_id;
                this.send_cnt = pushStat.send_cnt;
                this.recv_cnt = pushStat.recv_cnt;
                this.in1s_recv_cnt = pushStat.in1s_recv_cnt;
                this.in3s_recv_cnt = pushStat.in3s_recv_cnt;
                this.in6s_recv_cnt = pushStat.in6s_recv_cnt;
                this.in10s_recv_cnt = pushStat.in10s_recv_cnt;
                this.in30s_recv_cnt = pushStat.in30s_recv_cnt;
                this.in60s_recv_cnt = pushStat.in60s_recv_cnt;
                this.gt60s_recv_cnt = pushStat.gt60s_recv_cnt;
            }
        }

        public Builder task_id(Long l) {
            this.task_id = l;
            return this;
        }

        public Builder send_cnt(Integer num) {
            this.send_cnt = num;
            return this;
        }

        public Builder recv_cnt(Integer num) {
            this.recv_cnt = num;
            return this;
        }

        public Builder in1s_recv_cnt(Integer num) {
            this.in1s_recv_cnt = num;
            return this;
        }

        public Builder in3s_recv_cnt(Integer num) {
            this.in3s_recv_cnt = num;
            return this;
        }

        public Builder in6s_recv_cnt(Integer num) {
            this.in6s_recv_cnt = num;
            return this;
        }

        public Builder in10s_recv_cnt(Integer num) {
            this.in10s_recv_cnt = num;
            return this;
        }

        public Builder in30s_recv_cnt(Integer num) {
            this.in30s_recv_cnt = num;
            return this;
        }

        public Builder in60s_recv_cnt(Integer num) {
            this.in60s_recv_cnt = num;
            return this;
        }

        public Builder gt60s_recv_cnt(Integer num) {
            this.gt60s_recv_cnt = num;
            return this;
        }

        public PushStat build() {
            checkRequiredFields();
            return new PushStat(this);
        }
    }
}
