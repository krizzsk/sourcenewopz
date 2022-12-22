package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.OrderTotalFeeReq */
public final class OrderTotalFeeReq extends Message {
    public static final List<FeeInfoItem> DEFAULT_BASICFEEINFOLIST = Collections.emptyList();
    public static final String DEFAULT_CARFEE_TITLE = "";
    public static final String DEFAULT_CARFEE_TOTAL = "";
    public static final String DEFAULT_EXTRA_INFO = "";
    public static final String DEFAULT_EXT_MSG = "";
    public static final List<FeeInfoItem> DEFAULT_FAVOURFEEINFOLIST = Collections.emptyList();
    public static final String DEFAULT_FAVOUR_TITLE = "";
    public static final String DEFAULT_FAVOUR_TOTAL = "";
    public static final String DEFAULT_FEE_OBJECTION_ENTRANCE = "";
    public static final String DEFAULT_FEE_OBJECTION_PAGE = "";
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_ORDER_PAY_MSG = "";
    public static final Integer DEFAULT_ORDER_PAY_STATUS = 0;
    public static final String DEFAULT_ORDER_PAY_SUBJECT = "";
    public static final String DEFAULT_ORDER_PAY_TITLE = "";
    public static final List<Payments> DEFAULT_PAYMENTS = Collections.emptyList();
    public static final String DEFAULT_PAY_BUTTON_TITLE = "";
    public static final String DEFAULT_PAY_BUTTON_TITLE_LABEL = "";
    public static final String DEFAULT_PAY_TITLE = "";
    public static final Integer DEFAULT_PAY_TYPE = 0;
    public static final Integer DEFAULT_PENNY_FLAG = 0;
    public static final String DEFAULT_WXAGENT_PAYINFO = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeInfoItem.class, tag = 4)
    public final List<FeeInfoItem> basicFeeInfoList;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String carfee_title;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String carfee_total;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String ext_msg;
    @ProtoField(tag = 21, type = Message.Datatype.STRING)
    public final String extra_info;
    @ProtoField(label = Message.Label.REPEATED, messageType = FeeInfoItem.class, tag = 5)
    public final List<FeeInfoItem> favourFeeInfoList;
    @ProtoField(tag = 19, type = Message.Datatype.STRING)
    public final String favour_title;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String favour_total;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String fee_objection_entrance;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String fee_objection_page;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 12, type = Message.Datatype.STRING)
    public final String order_pay_msg;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer order_pay_status;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String order_pay_subject;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String order_pay_title;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String pay_button_title;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String pay_button_title_label;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String pay_title;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer pay_type;
    @ProtoField(label = Message.Label.REPEATED, messageType = Payments.class, tag = 15)
    public final List<Payments> payments;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer penny_flag;
    @ProtoField(tag = 13)
    public final RefundInfoReq refund_info;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String wxagent_payinfo;

    public OrderTotalFeeReq(String str, String str2, String str3, List<FeeInfoItem> list, List<FeeInfoItem> list2, Integer num, Integer num2, String str4, Integer num3, String str5, String str6, String str7, RefundInfoReq refundInfoReq, String str8, List<Payments> list3, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this.oid = str;
        this.pay_title = str2;
        this.pay_button_title = str3;
        this.basicFeeInfoList = immutableCopyOf(list);
        this.favourFeeInfoList = immutableCopyOf(list2);
        this.pay_type = num;
        this.penny_flag = num2;
        this.ext_msg = str4;
        this.order_pay_status = num3;
        this.order_pay_title = str5;
        this.order_pay_subject = str6;
        this.order_pay_msg = str7;
        this.refund_info = refundInfoReq;
        this.pay_button_title_label = str8;
        this.payments = immutableCopyOf(list3);
        this.favour_total = str9;
        this.carfee_title = str10;
        this.carfee_total = str11;
        this.favour_title = str12;
        this.wxagent_payinfo = str13;
        this.extra_info = str14;
        this.fee_objection_entrance = str15;
        this.fee_objection_page = str16;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private OrderTotalFeeReq(com.didi.sdk.messagecenter.p152pb.OrderTotalFeeReq.Builder r27) {
        /*
            r26 = this;
            r0 = r27
            r1 = r26
            java.lang.String r2 = r0.oid
            java.lang.String r3 = r0.pay_title
            java.lang.String r4 = r0.pay_button_title
            java.util.List<com.didi.sdk.messagecenter.pb.FeeInfoItem> r5 = r0.basicFeeInfoList
            java.util.List<com.didi.sdk.messagecenter.pb.FeeInfoItem> r6 = r0.favourFeeInfoList
            java.lang.Integer r7 = r0.pay_type
            java.lang.Integer r8 = r0.penny_flag
            java.lang.String r9 = r0.ext_msg
            java.lang.Integer r10 = r0.order_pay_status
            java.lang.String r11 = r0.order_pay_title
            java.lang.String r12 = r0.order_pay_subject
            java.lang.String r13 = r0.order_pay_msg
            com.didi.sdk.messagecenter.pb.RefundInfoReq r14 = r0.refund_info
            java.lang.String r15 = r0.pay_button_title_label
            r25 = r1
            java.util.List<com.didi.sdk.messagecenter.pb.Payments> r1 = r0.payments
            r16 = r1
            java.lang.String r1 = r0.favour_total
            r17 = r1
            java.lang.String r1 = r0.carfee_title
            r18 = r1
            java.lang.String r1 = r0.carfee_total
            r19 = r1
            java.lang.String r1 = r0.favour_title
            r20 = r1
            java.lang.String r1 = r0.wxagent_payinfo
            r21 = r1
            java.lang.String r1 = r0.extra_info
            r22 = r1
            java.lang.String r1 = r0.fee_objection_entrance
            r23 = r1
            java.lang.String r1 = r0.fee_objection_page
            r24 = r1
            r1 = r25
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r26.setBuilder(r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.messagecenter.p152pb.OrderTotalFeeReq.<init>(com.didi.sdk.messagecenter.pb.OrderTotalFeeReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderTotalFeeReq)) {
            return false;
        }
        OrderTotalFeeReq orderTotalFeeReq = (OrderTotalFeeReq) obj;
        if (!equals((Object) this.oid, (Object) orderTotalFeeReq.oid) || !equals((Object) this.pay_title, (Object) orderTotalFeeReq.pay_title) || !equals((Object) this.pay_button_title, (Object) orderTotalFeeReq.pay_button_title) || !equals((List<?>) this.basicFeeInfoList, (List<?>) orderTotalFeeReq.basicFeeInfoList) || !equals((List<?>) this.favourFeeInfoList, (List<?>) orderTotalFeeReq.favourFeeInfoList) || !equals((Object) this.pay_type, (Object) orderTotalFeeReq.pay_type) || !equals((Object) this.penny_flag, (Object) orderTotalFeeReq.penny_flag) || !equals((Object) this.ext_msg, (Object) orderTotalFeeReq.ext_msg) || !equals((Object) this.order_pay_status, (Object) orderTotalFeeReq.order_pay_status) || !equals((Object) this.order_pay_title, (Object) orderTotalFeeReq.order_pay_title) || !equals((Object) this.order_pay_subject, (Object) orderTotalFeeReq.order_pay_subject) || !equals((Object) this.order_pay_msg, (Object) orderTotalFeeReq.order_pay_msg) || !equals((Object) this.refund_info, (Object) orderTotalFeeReq.refund_info) || !equals((Object) this.pay_button_title_label, (Object) orderTotalFeeReq.pay_button_title_label) || !equals((List<?>) this.payments, (List<?>) orderTotalFeeReq.payments) || !equals((Object) this.favour_total, (Object) orderTotalFeeReq.favour_total) || !equals((Object) this.carfee_title, (Object) orderTotalFeeReq.carfee_title) || !equals((Object) this.carfee_total, (Object) orderTotalFeeReq.carfee_total) || !equals((Object) this.favour_title, (Object) orderTotalFeeReq.favour_title) || !equals((Object) this.wxagent_payinfo, (Object) orderTotalFeeReq.wxagent_payinfo) || !equals((Object) this.extra_info, (Object) orderTotalFeeReq.extra_info) || !equals((Object) this.fee_objection_entrance, (Object) orderTotalFeeReq.fee_objection_entrance) || !equals((Object) this.fee_objection_page, (Object) orderTotalFeeReq.fee_objection_page)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.oid;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.pay_title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.pay_button_title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<FeeInfoItem> list = this.basicFeeInfoList;
        int i3 = 1;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 1)) * 37;
        List<FeeInfoItem> list2 = this.favourFeeInfoList;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 1)) * 37;
        Integer num = this.pay_type;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.penny_flag;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.ext_msg;
        int hashCode8 = (hashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num3 = this.order_pay_status;
        int hashCode9 = (hashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        String str5 = this.order_pay_title;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.order_pay_subject;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.order_pay_msg;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        RefundInfoReq refundInfoReq = this.refund_info;
        int hashCode13 = (hashCode12 + (refundInfoReq != null ? refundInfoReq.hashCode() : 0)) * 37;
        String str8 = this.pay_button_title_label;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 37;
        List<Payments> list3 = this.payments;
        if (list3 != null) {
            i3 = list3.hashCode();
        }
        int i4 = (hashCode14 + i3) * 37;
        String str9 = this.favour_total;
        int hashCode15 = (i4 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.carfee_title;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.carfee_total;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.favour_title;
        int hashCode18 = (hashCode17 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.wxagent_payinfo;
        int hashCode19 = (hashCode18 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.extra_info;
        int hashCode20 = (hashCode19 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.fee_objection_entrance;
        int hashCode21 = (hashCode20 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.fee_objection_page;
        if (str16 != null) {
            i2 = str16.hashCode();
        }
        int i5 = hashCode21 + i2;
        this.hashCode = i5;
        return i5;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.OrderTotalFeeReq$Builder */
    public static final class Builder extends Message.Builder<OrderTotalFeeReq> {
        public List<FeeInfoItem> basicFeeInfoList;
        public String carfee_title;
        public String carfee_total;
        public String ext_msg;
        public String extra_info;
        public List<FeeInfoItem> favourFeeInfoList;
        public String favour_title;
        public String favour_total;
        public String fee_objection_entrance;
        public String fee_objection_page;
        public String oid;
        public String order_pay_msg;
        public Integer order_pay_status;
        public String order_pay_subject;
        public String order_pay_title;
        public String pay_button_title;
        public String pay_button_title_label;
        public String pay_title;
        public Integer pay_type;
        public List<Payments> payments;
        public Integer penny_flag;
        public RefundInfoReq refund_info;
        public String wxagent_payinfo;

        public Builder() {
        }

        public Builder(OrderTotalFeeReq orderTotalFeeReq) {
            super(orderTotalFeeReq);
            if (orderTotalFeeReq != null) {
                this.oid = orderTotalFeeReq.oid;
                this.pay_title = orderTotalFeeReq.pay_title;
                this.pay_button_title = orderTotalFeeReq.pay_button_title;
                this.basicFeeInfoList = OrderTotalFeeReq.copyOf(orderTotalFeeReq.basicFeeInfoList);
                this.favourFeeInfoList = OrderTotalFeeReq.copyOf(orderTotalFeeReq.favourFeeInfoList);
                this.pay_type = orderTotalFeeReq.pay_type;
                this.penny_flag = orderTotalFeeReq.penny_flag;
                this.ext_msg = orderTotalFeeReq.ext_msg;
                this.order_pay_status = orderTotalFeeReq.order_pay_status;
                this.order_pay_title = orderTotalFeeReq.order_pay_title;
                this.order_pay_subject = orderTotalFeeReq.order_pay_subject;
                this.order_pay_msg = orderTotalFeeReq.order_pay_msg;
                this.refund_info = orderTotalFeeReq.refund_info;
                this.pay_button_title_label = orderTotalFeeReq.pay_button_title_label;
                this.payments = OrderTotalFeeReq.copyOf(orderTotalFeeReq.payments);
                this.favour_total = orderTotalFeeReq.favour_total;
                this.carfee_title = orderTotalFeeReq.carfee_title;
                this.carfee_total = orderTotalFeeReq.carfee_total;
                this.favour_title = orderTotalFeeReq.favour_title;
                this.wxagent_payinfo = orderTotalFeeReq.wxagent_payinfo;
                this.extra_info = orderTotalFeeReq.extra_info;
                this.fee_objection_entrance = orderTotalFeeReq.fee_objection_entrance;
                this.fee_objection_page = orderTotalFeeReq.fee_objection_page;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder pay_title(String str) {
            this.pay_title = str;
            return this;
        }

        public Builder pay_button_title(String str) {
            this.pay_button_title = str;
            return this;
        }

        public Builder basicFeeInfoList(List<FeeInfoItem> list) {
            this.basicFeeInfoList = checkForNulls(list);
            return this;
        }

        public Builder favourFeeInfoList(List<FeeInfoItem> list) {
            this.favourFeeInfoList = checkForNulls(list);
            return this;
        }

        public Builder pay_type(Integer num) {
            this.pay_type = num;
            return this;
        }

        public Builder penny_flag(Integer num) {
            this.penny_flag = num;
            return this;
        }

        public Builder ext_msg(String str) {
            this.ext_msg = str;
            return this;
        }

        public Builder order_pay_status(Integer num) {
            this.order_pay_status = num;
            return this;
        }

        public Builder order_pay_title(String str) {
            this.order_pay_title = str;
            return this;
        }

        public Builder order_pay_subject(String str) {
            this.order_pay_subject = str;
            return this;
        }

        public Builder order_pay_msg(String str) {
            this.order_pay_msg = str;
            return this;
        }

        public Builder refund_info(RefundInfoReq refundInfoReq) {
            this.refund_info = refundInfoReq;
            return this;
        }

        public Builder pay_button_title_label(String str) {
            this.pay_button_title_label = str;
            return this;
        }

        public Builder payments(List<Payments> list) {
            this.payments = checkForNulls(list);
            return this;
        }

        public Builder favour_total(String str) {
            this.favour_total = str;
            return this;
        }

        public Builder carfee_title(String str) {
            this.carfee_title = str;
            return this;
        }

        public Builder carfee_total(String str) {
            this.carfee_total = str;
            return this;
        }

        public Builder favour_title(String str) {
            this.favour_title = str;
            return this;
        }

        public Builder wxagent_payinfo(String str) {
            this.wxagent_payinfo = str;
            return this;
        }

        public Builder extra_info(String str) {
            this.extra_info = str;
            return this;
        }

        public Builder fee_objection_entrance(String str) {
            this.fee_objection_entrance = str;
            return this;
        }

        public Builder fee_objection_page(String str) {
            this.fee_objection_page = str;
            return this;
        }

        public OrderTotalFeeReq build() {
            checkRequiredFields();
            return new OrderTotalFeeReq(this);
        }
    }
}
