package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.RefundInfoReq */
public final class RefundInfoReq extends Message {
    public static final String DEFAULT_REFUND_LINK = "";
    public static final Integer DEFAULT_REFUND_STATUS = 0;
    public static final String DEFAULT_REFUND_TIP = "";
    public static final String DEFAULT_REFUND_TITLE = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String refund_link;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer refund_status;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String refund_tip;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String refund_title;

    public RefundInfoReq(Integer num, String str, String str2, String str3) {
        this.refund_status = num;
        this.refund_title = str;
        this.refund_link = str2;
        this.refund_tip = str3;
    }

    private RefundInfoReq(Builder builder) {
        this(builder.refund_status, builder.refund_title, builder.refund_link, builder.refund_tip);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RefundInfoReq)) {
            return false;
        }
        RefundInfoReq refundInfoReq = (RefundInfoReq) obj;
        if (!equals((Object) this.refund_status, (Object) refundInfoReq.refund_status) || !equals((Object) this.refund_title, (Object) refundInfoReq.refund_title) || !equals((Object) this.refund_link, (Object) refundInfoReq.refund_link) || !equals((Object) this.refund_tip, (Object) refundInfoReq.refund_tip)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.refund_status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.refund_title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.refund_link;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.refund_tip;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.RefundInfoReq$Builder */
    public static final class Builder extends Message.Builder<RefundInfoReq> {
        public String refund_link;
        public Integer refund_status;
        public String refund_tip;
        public String refund_title;

        public Builder() {
        }

        public Builder(RefundInfoReq refundInfoReq) {
            super(refundInfoReq);
            if (refundInfoReq != null) {
                this.refund_status = refundInfoReq.refund_status;
                this.refund_title = refundInfoReq.refund_title;
                this.refund_link = refundInfoReq.refund_link;
                this.refund_tip = refundInfoReq.refund_tip;
            }
        }

        public Builder refund_status(Integer num) {
            this.refund_status = num;
            return this;
        }

        public Builder refund_title(String str) {
            this.refund_title = str;
            return this;
        }

        public Builder refund_link(String str) {
            this.refund_link = str;
            return this;
        }

        public Builder refund_tip(String str) {
            this.refund_tip = str;
            return this;
        }

        public RefundInfoReq build() {
            return new RefundInfoReq(this);
        }
    }
}
