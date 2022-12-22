package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class PassengerOrderStatusReq extends Message {
    public static final Integer DEFAULT_CAR_POOL = 0;
    public static final Integer DEFAULT_CONSULT_STATUS = 0;
    public static final Integer DEFAULT_COUNT_DOWN_TIME = 0;
    public static final Integer DEFAULT_DRIVER_NUM = 0;
    public static final String DEFAULT_EXT_INFO = "";
    public static final String DEFAULT_GET_LINE_MSG = "";
    public static final Integer DEFAULT_IS_ARRIVED = 0;
    public static final Boolean DEFAULT_IS_POST_ORDER_REC = false;
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_POST_ORDER_REC = "";
    public static final String DEFAULT_PUSH_PASSENGER_MSG = "";
    public static final Integer DEFAULT_STATUS = 0;
    public static final Integer DEFAULT_STRIVE_ORDER_DRIVER_NUM = 0;
    public static final Integer DEFAULT_SUB_STATUS = 0;
    public static final Integer DEFAULT_TIME_OUT = 0;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer car_pool;
    @ProtoField(tag = 9)
    public final ConsultInfo consult_info;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer consult_status;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer count_down_time;
    @ProtoField(tag = 4)
    public final DriverInfo driver_info;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer driver_num;
    @ProtoField(tag = 5)
    public final DriverPos driver_pos;
    @ProtoField(tag = 16, type = Message.Datatype.STRING)
    public final String ext_info;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String get_line_msg;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer is_arrived;
    @ProtoField(tag = 17, type = Message.Datatype.BOOL)
    public final Boolean is_post_order_rec;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 18, type = Message.Datatype.STRING)
    public final String post_order_rec;
    @ProtoField(tag = 13, type = Message.Datatype.STRING)
    public final String push_passenger_msg;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer status;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer strive_order_driver_num;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer sub_status;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.INT32)
    public final Integer time_out;

    public PassengerOrderStatusReq(Integer num, String str, Integer num2, DriverInfo driverInfo, DriverPos driverPos, Integer num3, Integer num4, Integer num5, ConsultInfo consultInfo, Integer num6, Integer num7, Integer num8, String str2, String str3, Integer num9, String str4, Boolean bool, String str5) {
        this.status = num;
        this.oid = str;
        this.driver_num = num2;
        this.driver_info = driverInfo;
        this.driver_pos = driverPos;
        this.time_out = num3;
        this.is_arrived = num4;
        this.consult_status = num5;
        this.consult_info = consultInfo;
        this.sub_status = num6;
        this.strive_order_driver_num = num7;
        this.count_down_time = num8;
        this.push_passenger_msg = str2;
        this.get_line_msg = str3;
        this.car_pool = num9;
        this.ext_info = str4;
        this.is_post_order_rec = bool;
        this.post_order_rec = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private PassengerOrderStatusReq(com.didi.sdk.protobuf.PassengerOrderStatusReq.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.Integer r2 = r0.status
            java.lang.String r3 = r0.oid
            java.lang.Integer r4 = r0.driver_num
            com.didi.sdk.protobuf.DriverInfo r5 = r0.driver_info
            com.didi.sdk.protobuf.DriverPos r6 = r0.driver_pos
            java.lang.Integer r7 = r0.time_out
            java.lang.Integer r8 = r0.is_arrived
            java.lang.Integer r9 = r0.consult_status
            com.didi.sdk.protobuf.ConsultInfo r10 = r0.consult_info
            java.lang.Integer r11 = r0.sub_status
            java.lang.Integer r12 = r0.strive_order_driver_num
            java.lang.Integer r13 = r0.count_down_time
            java.lang.String r14 = r0.push_passenger_msg
            java.lang.String r15 = r0.get_line_msg
            r20 = r1
            java.lang.Integer r1 = r0.car_pool
            r16 = r1
            java.lang.String r1 = r0.ext_info
            r17 = r1
            java.lang.Boolean r1 = r0.is_post_order_rec
            r18 = r1
            java.lang.String r1 = r0.post_order_rec
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.PassengerOrderStatusReq.<init>(com.didi.sdk.protobuf.PassengerOrderStatusReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassengerOrderStatusReq)) {
            return false;
        }
        PassengerOrderStatusReq passengerOrderStatusReq = (PassengerOrderStatusReq) obj;
        if (!equals((Object) this.status, (Object) passengerOrderStatusReq.status) || !equals((Object) this.oid, (Object) passengerOrderStatusReq.oid) || !equals((Object) this.driver_num, (Object) passengerOrderStatusReq.driver_num) || !equals((Object) this.driver_info, (Object) passengerOrderStatusReq.driver_info) || !equals((Object) this.driver_pos, (Object) passengerOrderStatusReq.driver_pos) || !equals((Object) this.time_out, (Object) passengerOrderStatusReq.time_out) || !equals((Object) this.is_arrived, (Object) passengerOrderStatusReq.is_arrived) || !equals((Object) this.consult_status, (Object) passengerOrderStatusReq.consult_status) || !equals((Object) this.consult_info, (Object) passengerOrderStatusReq.consult_info) || !equals((Object) this.sub_status, (Object) passengerOrderStatusReq.sub_status) || !equals((Object) this.strive_order_driver_num, (Object) passengerOrderStatusReq.strive_order_driver_num) || !equals((Object) this.count_down_time, (Object) passengerOrderStatusReq.count_down_time) || !equals((Object) this.push_passenger_msg, (Object) passengerOrderStatusReq.push_passenger_msg) || !equals((Object) this.get_line_msg, (Object) passengerOrderStatusReq.get_line_msg) || !equals((Object) this.car_pool, (Object) passengerOrderStatusReq.car_pool) || !equals((Object) this.ext_info, (Object) passengerOrderStatusReq.ext_info) || !equals((Object) this.is_post_order_rec, (Object) passengerOrderStatusReq.is_post_order_rec) || !equals((Object) this.post_order_rec, (Object) passengerOrderStatusReq.post_order_rec)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.status;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        String str = this.oid;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.driver_num;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        DriverInfo driverInfo = this.driver_info;
        int hashCode4 = (hashCode3 + (driverInfo != null ? driverInfo.hashCode() : 0)) * 37;
        DriverPos driverPos = this.driver_pos;
        int hashCode5 = (hashCode4 + (driverPos != null ? driverPos.hashCode() : 0)) * 37;
        Integer num3 = this.time_out;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.is_arrived;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.consult_status;
        int hashCode8 = (hashCode7 + (num5 != null ? num5.hashCode() : 0)) * 37;
        ConsultInfo consultInfo = this.consult_info;
        int hashCode9 = (hashCode8 + (consultInfo != null ? consultInfo.hashCode() : 0)) * 37;
        Integer num6 = this.sub_status;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.strive_order_driver_num;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.count_down_time;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str2 = this.push_passenger_msg;
        int hashCode13 = (hashCode12 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.get_line_msg;
        int hashCode14 = (hashCode13 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num9 = this.car_pool;
        int hashCode15 = (hashCode14 + (num9 != null ? num9.hashCode() : 0)) * 37;
        String str4 = this.ext_info;
        int hashCode16 = (hashCode15 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Boolean bool = this.is_post_order_rec;
        int hashCode17 = (hashCode16 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str5 = this.post_order_rec;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<PassengerOrderStatusReq> {
        public Integer car_pool;
        public ConsultInfo consult_info;
        public Integer consult_status;
        public Integer count_down_time;
        public DriverInfo driver_info;
        public Integer driver_num;
        public DriverPos driver_pos;
        public String ext_info;
        public String get_line_msg;
        public Integer is_arrived;
        public Boolean is_post_order_rec;
        public String oid;
        public String post_order_rec;
        public String push_passenger_msg;
        public Integer status;
        public Integer strive_order_driver_num;
        public Integer sub_status;
        public Integer time_out;

        public Builder() {
        }

        public Builder(PassengerOrderStatusReq passengerOrderStatusReq) {
            super(passengerOrderStatusReq);
            if (passengerOrderStatusReq != null) {
                this.status = passengerOrderStatusReq.status;
                this.oid = passengerOrderStatusReq.oid;
                this.driver_num = passengerOrderStatusReq.driver_num;
                this.driver_info = passengerOrderStatusReq.driver_info;
                this.driver_pos = passengerOrderStatusReq.driver_pos;
                this.time_out = passengerOrderStatusReq.time_out;
                this.is_arrived = passengerOrderStatusReq.is_arrived;
                this.consult_status = passengerOrderStatusReq.consult_status;
                this.consult_info = passengerOrderStatusReq.consult_info;
                this.sub_status = passengerOrderStatusReq.sub_status;
                this.strive_order_driver_num = passengerOrderStatusReq.strive_order_driver_num;
                this.count_down_time = passengerOrderStatusReq.count_down_time;
                this.push_passenger_msg = passengerOrderStatusReq.push_passenger_msg;
                this.get_line_msg = passengerOrderStatusReq.get_line_msg;
                this.car_pool = passengerOrderStatusReq.car_pool;
                this.ext_info = passengerOrderStatusReq.ext_info;
                this.is_post_order_rec = passengerOrderStatusReq.is_post_order_rec;
                this.post_order_rec = passengerOrderStatusReq.post_order_rec;
            }
        }

        public Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder driver_num(Integer num) {
            this.driver_num = num;
            return this;
        }

        public Builder driver_info(DriverInfo driverInfo) {
            this.driver_info = driverInfo;
            return this;
        }

        public Builder driver_pos(DriverPos driverPos) {
            this.driver_pos = driverPos;
            return this;
        }

        public Builder time_out(Integer num) {
            this.time_out = num;
            return this;
        }

        public Builder is_arrived(Integer num) {
            this.is_arrived = num;
            return this;
        }

        public Builder consult_status(Integer num) {
            this.consult_status = num;
            return this;
        }

        public Builder consult_info(ConsultInfo consultInfo) {
            this.consult_info = consultInfo;
            return this;
        }

        public Builder sub_status(Integer num) {
            this.sub_status = num;
            return this;
        }

        public Builder strive_order_driver_num(Integer num) {
            this.strive_order_driver_num = num;
            return this;
        }

        public Builder count_down_time(Integer num) {
            this.count_down_time = num;
            return this;
        }

        public Builder push_passenger_msg(String str) {
            this.push_passenger_msg = str;
            return this;
        }

        public Builder get_line_msg(String str) {
            this.get_line_msg = str;
            return this;
        }

        public Builder car_pool(Integer num) {
            this.car_pool = num;
            return this;
        }

        public Builder ext_info(String str) {
            this.ext_info = str;
            return this;
        }

        public Builder is_post_order_rec(Boolean bool) {
            this.is_post_order_rec = bool;
            return this;
        }

        public Builder post_order_rec(String str) {
            this.post_order_rec = str;
            return this;
        }

        public PassengerOrderStatusReq build() {
            checkRequiredFields();
            return new PassengerOrderStatusReq(this);
        }
    }
}
