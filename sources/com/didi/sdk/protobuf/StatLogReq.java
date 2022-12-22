package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class StatLogReq extends Message {
    public static final Integer DEFAULT_EVENT = 0;
    public static final Long DEFAULT_GAP_US = 0L;
    public static final Integer DEFAULT_MSG_TYPE = 0;
    public static final Long DEFAULT_TASK_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer event;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long gap_us;
    @ProtoField(tag = 3, type = Message.Datatype.UINT32)
    public final Integer msg_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT64)
    public final Long task_id;

    public StatLogReq(Integer num, Long l, Integer num2, Long l2) {
        this.event = num;
        this.task_id = l;
        this.msg_type = num2;
        this.gap_us = l2;
    }

    private StatLogReq(Builder builder) {
        this(builder.event, builder.task_id, builder.msg_type, builder.gap_us);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StatLogReq)) {
            return false;
        }
        StatLogReq statLogReq = (StatLogReq) obj;
        if (!equals((Object) this.event, (Object) statLogReq.event) || !equals((Object) this.task_id, (Object) statLogReq.task_id) || !equals((Object) this.msg_type, (Object) statLogReq.msg_type) || !equals((Object) this.gap_us, (Object) statLogReq.gap_us)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.event;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Long l = this.task_id;
        int hashCode2 = (hashCode + (l != null ? l.hashCode() : 0)) * 37;
        Integer num2 = this.msg_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l2 = this.gap_us;
        if (l2 != null) {
            i2 = l2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<StatLogReq> {
        public Integer event;
        public Long gap_us;
        public Integer msg_type;
        public Long task_id;

        public Builder() {
        }

        public Builder(StatLogReq statLogReq) {
            super(statLogReq);
            if (statLogReq != null) {
                this.event = statLogReq.event;
                this.task_id = statLogReq.task_id;
                this.msg_type = statLogReq.msg_type;
                this.gap_us = statLogReq.gap_us;
            }
        }

        public Builder event(Integer num) {
            this.event = num;
            return this;
        }

        public Builder task_id(Long l) {
            this.task_id = l;
            return this;
        }

        public Builder msg_type(Integer num) {
            this.msg_type = num;
            return this;
        }

        public Builder gap_us(Long l) {
            this.gap_us = l;
            return this;
        }

        public StatLogReq build() {
            checkRequiredFields();
            return new StatLogReq(this);
        }
    }
}
