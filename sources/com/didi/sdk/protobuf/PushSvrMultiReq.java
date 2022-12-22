package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PushSvrMultiReq extends Message {
    public static final Integer DEFAULT_EXPIRE_SECONDS = 0;
    public static final String DEFAULT_LOG_STR = "";
    public static final PushStrategy DEFAULT_PUSH_STRATEGY = PushStrategy.kPushStrategyNoResponse;
    public static final String DEFAULT_SMS_MSG = "";
    public static final Integer DEFAULT_TIMEOUT_TO_SMS = 0;
    public static final List<UserId> DEFAULT_USERS = Collections.emptyList();
    @ProtoField(tag = 4, type = Message.Datatype.UINT32)
    public final Integer expire_seconds;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String log_str;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2)
    public final PushMsg push_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final PushStrategy push_strategy;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String sms_msg;
    @ProtoField(tag = 7, type = Message.Datatype.UINT32)
    public final Integer timeout_to_sms;
    @ProtoField(label = Message.Label.REPEATED, messageType = UserId.class, tag = 1)
    public final List<UserId> users;

    public PushSvrMultiReq(List<UserId> list, PushMsg pushMsg, PushStrategy pushStrategy, Integer num, String str, String str2, Integer num2) {
        this.users = immutableCopyOf(list);
        this.push_msg = pushMsg;
        this.push_strategy = pushStrategy;
        this.expire_seconds = num;
        this.log_str = str;
        this.sms_msg = str2;
        this.timeout_to_sms = num2;
    }

    private PushSvrMultiReq(Builder builder) {
        this(builder.users, builder.push_msg, builder.push_strategy, builder.expire_seconds, builder.log_str, builder.sms_msg, builder.timeout_to_sms);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushSvrMultiReq)) {
            return false;
        }
        PushSvrMultiReq pushSvrMultiReq = (PushSvrMultiReq) obj;
        if (!equals((List<?>) this.users, (List<?>) pushSvrMultiReq.users) || !equals((Object) this.push_msg, (Object) pushSvrMultiReq.push_msg) || !equals((Object) this.push_strategy, (Object) pushSvrMultiReq.push_strategy) || !equals((Object) this.expire_seconds, (Object) pushSvrMultiReq.expire_seconds) || !equals((Object) this.log_str, (Object) pushSvrMultiReq.log_str) || !equals((Object) this.sms_msg, (Object) pushSvrMultiReq.sms_msg) || !equals((Object) this.timeout_to_sms, (Object) pushSvrMultiReq.timeout_to_sms)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        List<UserId> list = this.users;
        int hashCode = (list != null ? list.hashCode() : 1) * 37;
        PushMsg pushMsg = this.push_msg;
        int i2 = 0;
        int hashCode2 = (hashCode + (pushMsg != null ? pushMsg.hashCode() : 0)) * 37;
        PushStrategy pushStrategy = this.push_strategy;
        int hashCode3 = (hashCode2 + (pushStrategy != null ? pushStrategy.hashCode() : 0)) * 37;
        Integer num = this.expire_seconds;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.log_str;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.sms_msg;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num2 = this.timeout_to_sms;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PushSvrMultiReq> {
        public Integer expire_seconds;
        public String log_str;
        public PushMsg push_msg;
        public PushStrategy push_strategy;
        public String sms_msg;
        public Integer timeout_to_sms;
        public List<UserId> users;

        public Builder() {
        }

        public Builder(PushSvrMultiReq pushSvrMultiReq) {
            super(pushSvrMultiReq);
            if (pushSvrMultiReq != null) {
                this.users = PushSvrMultiReq.copyOf(pushSvrMultiReq.users);
                this.push_msg = pushSvrMultiReq.push_msg;
                this.push_strategy = pushSvrMultiReq.push_strategy;
                this.expire_seconds = pushSvrMultiReq.expire_seconds;
                this.log_str = pushSvrMultiReq.log_str;
                this.sms_msg = pushSvrMultiReq.sms_msg;
                this.timeout_to_sms = pushSvrMultiReq.timeout_to_sms;
            }
        }

        public Builder users(List<UserId> list) {
            this.users = checkForNulls(list);
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

        public Builder expire_seconds(Integer num) {
            this.expire_seconds = num;
            return this;
        }

        public Builder log_str(String str) {
            this.log_str = str;
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

        public PushSvrMultiReq build() {
            checkRequiredFields();
            return new PushSvrMultiReq(this);
        }
    }

    public static final class UserId extends Message {
        public static final OldRole DEFAULT_OLD_ROLE = OldRole.OldUnknown;
        public static final String DEFAULT_PHONE_NUM = "";
        public static final Integer DEFAULT_ROLE = 0;
        public static final Long DEFAULT_USER_ID = 0L;
        @ProtoField(tag = 1, type = Message.Datatype.ENUM)
        public final OldRole old_role;
        @ProtoField(tag = 2, type = Message.Datatype.STRING)
        public final String phone_num;
        @ProtoField(tag = 4, type = Message.Datatype.INT32)
        public final Integer role;
        @ProtoField(tag = 3, type = Message.Datatype.UINT64)
        public final Long user_id;

        public UserId(OldRole oldRole, String str, Long l, Integer num) {
            this.old_role = oldRole;
            this.phone_num = str;
            this.user_id = l;
            this.role = num;
        }

        private UserId(Builder builder) {
            this(builder.old_role, builder.phone_num, builder.user_id, builder.role);
            setBuilder(builder);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserId)) {
                return false;
            }
            UserId userId = (UserId) obj;
            if (!equals((Object) this.old_role, (Object) userId.old_role) || !equals((Object) this.phone_num, (Object) userId.phone_num) || !equals((Object) this.user_id, (Object) userId.user_id) || !equals((Object) this.role, (Object) userId.role)) {
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
            Long l = this.user_id;
            int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
            Integer num = this.role;
            if (num != null) {
                i2 = num.hashCode();
            }
            int i3 = hashCode3 + i2;
            this.hashCode = i3;
            return i3;
        }

        public static final class Builder extends Message.Builder<UserId> {
            public OldRole old_role;
            public String phone_num;
            public Integer role;
            public Long user_id;

            public Builder() {
            }

            public Builder(UserId userId) {
                super(userId);
                if (userId != null) {
                    this.old_role = userId.old_role;
                    this.phone_num = userId.phone_num;
                    this.user_id = userId.user_id;
                    this.role = userId.role;
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

            public Builder user_id(Long l) {
                this.user_id = l;
                return this;
            }

            public Builder role(Integer num) {
                this.role = num;
                return this;
            }

            public UserId build() {
                return new UserId(this);
            }
        }
    }
}
