package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TimelyRemindReq extends Message {
    public static final String DEFAULT_CANCEL_BTN_TEXT = "";
    public static final String DEFAULT_CONFIRM_BTN_TEXT = "";
    public static final String DEFAULT_CONTENT = "";
    public static final Integer DEFAULT_MSG_ID = 0;
    public static final Integer DEFAULT_MSG_TYPE = 0;
    public static final String DEFAULT_MSG_VALUE = "";
    public static final String DEFAULT_ORDER_ID = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.STRING)
    public final String cancel_btn_text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 8, type = Message.Datatype.STRING)
    public final String confirm_btn_text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.STRING)
    public final String content;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer msg_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.UINT32)
    public final Integer msg_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String msg_value;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String order_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String title;

    public TimelyRemindReq(Integer num, Integer num2, String str, String str2, String str3, String str4, String str5, String str6) {
        this.msg_id = num;
        this.msg_type = num2;
        this.msg_value = str;
        this.order_id = str2;
        this.title = str3;
        this.content = str4;
        this.cancel_btn_text = str5;
        this.confirm_btn_text = str6;
    }

    private TimelyRemindReq(Builder builder) {
        this(builder.msg_id, builder.msg_type, builder.msg_value, builder.order_id, builder.title, builder.content, builder.cancel_btn_text, builder.confirm_btn_text);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimelyRemindReq)) {
            return false;
        }
        TimelyRemindReq timelyRemindReq = (TimelyRemindReq) obj;
        if (!equals((Object) this.msg_id, (Object) timelyRemindReq.msg_id) || !equals((Object) this.msg_type, (Object) timelyRemindReq.msg_type) || !equals((Object) this.msg_value, (Object) timelyRemindReq.msg_value) || !equals((Object) this.order_id, (Object) timelyRemindReq.order_id) || !equals((Object) this.title, (Object) timelyRemindReq.title) || !equals((Object) this.content, (Object) timelyRemindReq.content) || !equals((Object) this.cancel_btn_text, (Object) timelyRemindReq.cancel_btn_text) || !equals((Object) this.confirm_btn_text, (Object) timelyRemindReq.confirm_btn_text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.msg_id;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.msg_type;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.msg_value;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.order_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.title;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.content;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.cancel_btn_text;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.confirm_btn_text;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TimelyRemindReq> {
        public String cancel_btn_text;
        public String confirm_btn_text;
        public String content;
        public Integer msg_id;
        public Integer msg_type;
        public String msg_value;
        public String order_id;
        public String title;

        public Builder() {
        }

        public Builder(TimelyRemindReq timelyRemindReq) {
            super(timelyRemindReq);
            if (timelyRemindReq != null) {
                this.msg_id = timelyRemindReq.msg_id;
                this.msg_type = timelyRemindReq.msg_type;
                this.msg_value = timelyRemindReq.msg_value;
                this.order_id = timelyRemindReq.order_id;
                this.title = timelyRemindReq.title;
                this.content = timelyRemindReq.content;
                this.cancel_btn_text = timelyRemindReq.cancel_btn_text;
                this.confirm_btn_text = timelyRemindReq.confirm_btn_text;
            }
        }

        public Builder msg_id(Integer num) {
            this.msg_id = num;
            return this;
        }

        public Builder msg_type(Integer num) {
            this.msg_type = num;
            return this;
        }

        public Builder msg_value(String str) {
            this.msg_value = str;
            return this;
        }

        public Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder cancel_btn_text(String str) {
            this.cancel_btn_text = str;
            return this;
        }

        public Builder confirm_btn_text(String str) {
            this.confirm_btn_text = str;
            return this;
        }

        public TimelyRemindReq build() {
            checkRequiredFields();
            return new TimelyRemindReq(this);
        }
    }
}
