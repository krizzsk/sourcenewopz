package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class RunningReq extends Message {
    public static final String DEFAULT_BIND_MSG = "";
    public static final String DEFAULT_BIND_SUBJECT = "";
    public static final String DEFAULT_BIND_TITLE = "";
    public static final String DEFAULT_BUTTON_CANCEL = "";
    public static final String DEFAULT_BUTTON_CONFIRM = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String bind_msg;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String bind_subject;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String bind_title;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String button_cancel;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String button_confirm;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer type;

    public RunningReq(Integer num, String str, String str2, String str3, String str4, String str5) {
        this.type = num;
        this.bind_title = str;
        this.bind_subject = str2;
        this.bind_msg = str3;
        this.button_confirm = str4;
        this.button_cancel = str5;
    }

    private RunningReq(Builder builder) {
        this(builder.type, builder.bind_title, builder.bind_subject, builder.bind_msg, builder.button_confirm, builder.button_cancel);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RunningReq)) {
            return false;
        }
        RunningReq runningReq = (RunningReq) obj;
        if (!equals((Object) this.type, (Object) runningReq.type) || !equals((Object) this.bind_title, (Object) runningReq.bind_title) || !equals((Object) this.bind_subject, (Object) runningReq.bind_subject) || !equals((Object) this.bind_msg, (Object) runningReq.bind_msg) || !equals((Object) this.button_confirm, (Object) runningReq.button_confirm) || !equals((Object) this.button_cancel, (Object) runningReq.button_cancel)) {
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
        String str = this.bind_title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.bind_subject;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.bind_msg;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.button_confirm;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.button_cancel;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<RunningReq> {
        public String bind_msg;
        public String bind_subject;
        public String bind_title;
        public String button_cancel;
        public String button_confirm;
        public Integer type;

        public Builder() {
        }

        public Builder(RunningReq runningReq) {
            super(runningReq);
            if (runningReq != null) {
                this.type = runningReq.type;
                this.bind_title = runningReq.bind_title;
                this.bind_subject = runningReq.bind_subject;
                this.bind_msg = runningReq.bind_msg;
                this.button_confirm = runningReq.button_confirm;
                this.button_cancel = runningReq.button_cancel;
            }
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder bind_title(String str) {
            this.bind_title = str;
            return this;
        }

        public Builder bind_subject(String str) {
            this.bind_subject = str;
            return this;
        }

        public Builder bind_msg(String str) {
            this.bind_msg = str;
            return this;
        }

        public Builder button_confirm(String str) {
            this.button_confirm = str;
            return this;
        }

        public Builder button_cancel(String str) {
            this.button_cancel = str;
            return this;
        }

        public RunningReq build() {
            checkRequiredFields();
            return new RunningReq(this);
        }
    }
}
