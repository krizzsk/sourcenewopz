package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PushSvrReq extends Message {
    public static final Integer DEFAULT_EXPIRE_SECONDS = 0;
    public static final String DEFAULT_LOG_STR = "";
    public static final OldRole DEFAULT_OLD_ROLE = OldRole.OldUnknown;
    public static final String DEFAULT_PHONE_NUM = "";
    public static final PushStrategy DEFAULT_PUSH_STRATEGY = PushStrategy.kPushStrategyNoResponse;
    public static final Integer DEFAULT_ROLE = 0;
    public static final String DEFAULT_SMS_MSG = "";
    public static final Integer DEFAULT_TIMEOUT_TO_SMS = 0;
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(tag = 6, type = Message.Datatype.UINT32)
    public final Integer expire_seconds;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String log_str;
    @ProtoField(tag = 1, type = Message.Datatype.ENUM)
    public final OldRole old_role;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String phone_num;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3)
    public final PushMsg push_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.ENUM)
    public final PushStrategy push_strategy;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer role;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String sms_msg;
    @ProtoField(tag = 10, type = Message.Datatype.UINT32)
    public final Integer timeout_to_sms;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long user_id;

    public PushSvrReq(OldRole oldRole, String str, PushMsg pushMsg, PushStrategy pushStrategy, Long l, Integer num, String str2, Integer num2, String str3, Integer num3) {
        this.old_role = oldRole;
        this.phone_num = str;
        this.push_msg = pushMsg;
        this.push_strategy = pushStrategy;
        this.user_id = l;
        this.expire_seconds = num;
        this.log_str = str2;
        this.role = num2;
        this.sms_msg = str3;
        this.timeout_to_sms = num3;
    }

    private PushSvrReq(Builder builder) {
        this(builder.old_role, builder.phone_num, builder.push_msg, builder.push_strategy, builder.user_id, builder.expire_seconds, builder.log_str, builder.role, builder.sms_msg, builder.timeout_to_sms);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushSvrReq)) {
            return false;
        }
        PushSvrReq pushSvrReq = (PushSvrReq) obj;
        if (!equals((Object) this.old_role, (Object) pushSvrReq.old_role) || !equals((Object) this.phone_num, (Object) pushSvrReq.phone_num) || !equals((Object) this.push_msg, (Object) pushSvrReq.push_msg) || !equals((Object) this.push_strategy, (Object) pushSvrReq.push_strategy) || !equals((Object) this.user_id, (Object) pushSvrReq.user_id) || !equals((Object) this.expire_seconds, (Object) pushSvrReq.expire_seconds) || !equals((Object) this.log_str, (Object) pushSvrReq.log_str) || !equals((Object) this.role, (Object) pushSvrReq.role) || !equals((Object) this.sms_msg, (Object) pushSvrReq.sms_msg) || !equals((Object) this.timeout_to_sms, (Object) pushSvrReq.timeout_to_sms)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        OldRole oldRole = this.old_role;
        int i2 = 0;
        int hashCode = (oldRole != null ? oldRole.hashCode() : 0) * 37;
        String str = this.phone_num;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        PushMsg pushMsg = this.push_msg;
        int hashCode3 = (hashCode2 + (pushMsg != null ? pushMsg.hashCode() : 0)) * 37;
        PushStrategy pushStrategy = this.push_strategy;
        int hashCode4 = (hashCode3 + (pushStrategy != null ? pushStrategy.hashCode() : 0)) * 37;
        Long l = this.user_id;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num = this.expire_seconds;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        String str2 = this.log_str;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.role;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str3 = this.sms_msg;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num3 = this.timeout_to_sms;
        if (num3 != null) {
            i2 = num3.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushSvrReq> {
        public Integer expire_seconds;
        public String log_str;
        public OldRole old_role;
        public String phone_num;
        public PushMsg push_msg;
        public PushStrategy push_strategy;
        public Integer role;
        public String sms_msg;
        public Integer timeout_to_sms;
        public Long user_id;

        public Builder() {
        }

        public Builder(PushSvrReq pushSvrReq) {
            super(pushSvrReq);
            if (pushSvrReq != null) {
                this.old_role = pushSvrReq.old_role;
                this.phone_num = pushSvrReq.phone_num;
                this.push_msg = pushSvrReq.push_msg;
                this.push_strategy = pushSvrReq.push_strategy;
                this.user_id = pushSvrReq.user_id;
                this.expire_seconds = pushSvrReq.expire_seconds;
                this.log_str = pushSvrReq.log_str;
                this.role = pushSvrReq.role;
                this.sms_msg = pushSvrReq.sms_msg;
                this.timeout_to_sms = pushSvrReq.timeout_to_sms;
            }
        }

        public Builder old_role(OldRole oldRole) {
            this.old_role = oldRole;
            return this;
        }

        public Builder phone_num(String str) {
            this.phone_num = str;
            return this;
        }

        public Builder push_msg(PushMsg pushMsg) {
            this.push_msg = pushMsg;
            return this;
        }

        public Builder push_strategy(PushStrategy pushStrategy) {
            this.push_strategy = pushStrategy;
            return this;
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder expire_seconds(Integer num) {
            this.expire_seconds = num;
            return this;
        }

        public Builder log_str(String str) {
            this.log_str = str;
            return this;
        }

        public Builder role(Integer num) {
            this.role = num;
            return this;
        }

        public Builder sms_msg(String str) {
            this.sms_msg = str;
            return this;
        }

        public Builder timeout_to_sms(Integer num) {
            this.timeout_to_sms = num;
            return this;
        }

        public PushSvrReq build() {
            checkRequiredFields();
            return new PushSvrReq(this);
        }
    }
}
