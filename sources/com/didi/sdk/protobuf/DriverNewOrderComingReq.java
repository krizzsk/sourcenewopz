package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class DriverNewOrderComingReq extends Message {
    public static final Integer DEFAULT_COMBO_TYPE = 0;
    public static final Long DEFAULT_DISPATCH_UUID = 0L;
    public static final Integer DEFAULT_FORCEPLAY = 0;
    public static final Integer DEFAULT_HISTORY_NUM = 0;
    public static final Integer DEFAULT_IS_BUSY = 0;
    public static final Integer DEFAULT_IS_CARPOLL = 0;
    public static final Integer DEFAULT_IS_GS_ORDER = 0;
    public static final Integer DEFAULT_IS_ONBOARD = 0;
    public static final Integer DEFAULT_IS_SERIAL = 0;
    public static final Integer DEFAULT_IS_ZHIPAI_ORDER = 0;
    public static final String DEFAULT_OID = "";
    public static final List<String> DEFAULT_OIDS = Collections.emptyList();
    public static final String DEFAULT_RECEIVE_LEVEL = "";
    public static final Integer DEFAULT_REQUIRE_LEVEL = 0;
    public static final Integer DEFAULT_SEND_NUM = 0;
    public static final Integer DEFAULT_SRC_TYPE = 0;
    public static final String DEFAULT_TOKEN = "";
    public static final Integer DEFAULT_TYPE = 0;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer combo_type;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long dispatch_uuid;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer forcePlay;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer history_num;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer is_busy;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer is_carpoll;
    @ProtoField(tag = 17, type = Message.Datatype.INT32)
    public final Integer is_gs_order;
    @ProtoField(tag = 15, type = Message.Datatype.INT32)
    public final Integer is_onboard;
    @ProtoField(tag = 14, type = Message.Datatype.INT32)
    public final Integer is_serial;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer is_zhipai_order;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(label = Message.Label.REPEATED, tag = 18, type = Message.Datatype.STRING)
    public final List<String> oids;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String receive_level;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer require_level;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer send_num;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer src_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String token;
    @ProtoField(label = Message.Label.REQUIRED, tag = 7, type = Message.Datatype.INT32)
    public final Integer type;

    public DriverNewOrderComingReq(String str, String str2, Integer num, Integer num2, Long l, Integer num3, Integer num4, String str3, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, List<String> list) {
        this.token = str;
        this.oid = str2;
        this.is_zhipai_order = num;
        this.history_num = num2;
        this.dispatch_uuid = l;
        this.send_num = num3;
        this.type = num4;
        this.receive_level = str3;
        this.require_level = num5;
        this.forcePlay = num6;
        this.is_carpoll = num7;
        this.combo_type = num8;
        this.src_type = num9;
        this.is_serial = num10;
        this.is_onboard = num11;
        this.is_busy = num12;
        this.is_gs_order = num13;
        this.oids = immutableCopyOf(list);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverNewOrderComingReq(com.didi.sdk.protobuf.DriverNewOrderComingReq.Builder r22) {
        /*
            r21 = this;
            r0 = r22
            r1 = r21
            java.lang.String r2 = r0.token
            java.lang.String r3 = r0.oid
            java.lang.Integer r4 = r0.is_zhipai_order
            java.lang.Integer r5 = r0.history_num
            java.lang.Long r6 = r0.dispatch_uuid
            java.lang.Integer r7 = r0.send_num
            java.lang.Integer r8 = r0.type
            java.lang.String r9 = r0.receive_level
            java.lang.Integer r10 = r0.require_level
            java.lang.Integer r11 = r0.forcePlay
            java.lang.Integer r12 = r0.is_carpoll
            java.lang.Integer r13 = r0.combo_type
            java.lang.Integer r14 = r0.src_type
            java.lang.Integer r15 = r0.is_serial
            r20 = r1
            java.lang.Integer r1 = r0.is_onboard
            r16 = r1
            java.lang.Integer r1 = r0.is_busy
            r17 = r1
            java.lang.Integer r1 = r0.is_gs_order
            r18 = r1
            java.util.List<java.lang.String> r1 = r0.oids
            r19 = r1
            r1 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r21.setBuilder(r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.DriverNewOrderComingReq.<init>(com.didi.sdk.protobuf.DriverNewOrderComingReq$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverNewOrderComingReq)) {
            return false;
        }
        DriverNewOrderComingReq driverNewOrderComingReq = (DriverNewOrderComingReq) obj;
        if (!equals((Object) this.token, (Object) driverNewOrderComingReq.token) || !equals((Object) this.oid, (Object) driverNewOrderComingReq.oid) || !equals((Object) this.is_zhipai_order, (Object) driverNewOrderComingReq.is_zhipai_order) || !equals((Object) this.history_num, (Object) driverNewOrderComingReq.history_num) || !equals((Object) this.dispatch_uuid, (Object) driverNewOrderComingReq.dispatch_uuid) || !equals((Object) this.send_num, (Object) driverNewOrderComingReq.send_num) || !equals((Object) this.type, (Object) driverNewOrderComingReq.type) || !equals((Object) this.receive_level, (Object) driverNewOrderComingReq.receive_level) || !equals((Object) this.require_level, (Object) driverNewOrderComingReq.require_level) || !equals((Object) this.forcePlay, (Object) driverNewOrderComingReq.forcePlay) || !equals((Object) this.is_carpoll, (Object) driverNewOrderComingReq.is_carpoll) || !equals((Object) this.combo_type, (Object) driverNewOrderComingReq.combo_type) || !equals((Object) this.src_type, (Object) driverNewOrderComingReq.src_type) || !equals((Object) this.is_serial, (Object) driverNewOrderComingReq.is_serial) || !equals((Object) this.is_onboard, (Object) driverNewOrderComingReq.is_onboard) || !equals((Object) this.is_busy, (Object) driverNewOrderComingReq.is_busy) || !equals((Object) this.is_gs_order, (Object) driverNewOrderComingReq.is_gs_order) || !equals((List<?>) this.oids, (List<?>) driverNewOrderComingReq.oids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.token;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.oid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.is_zhipai_order;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.history_num;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Long l = this.dispatch_uuid;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num3 = this.send_num;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.type;
        int hashCode7 = (hashCode6 + (num4 != null ? num4.hashCode() : 0)) * 37;
        String str3 = this.receive_level;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num5 = this.require_level;
        int hashCode9 = (hashCode8 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.forcePlay;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.is_carpoll;
        int hashCode11 = (hashCode10 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.combo_type;
        int hashCode12 = (hashCode11 + (num8 != null ? num8.hashCode() : 0)) * 37;
        Integer num9 = this.src_type;
        int hashCode13 = (hashCode12 + (num9 != null ? num9.hashCode() : 0)) * 37;
        Integer num10 = this.is_serial;
        int hashCode14 = (hashCode13 + (num10 != null ? num10.hashCode() : 0)) * 37;
        Integer num11 = this.is_onboard;
        int hashCode15 = (hashCode14 + (num11 != null ? num11.hashCode() : 0)) * 37;
        Integer num12 = this.is_busy;
        int hashCode16 = (hashCode15 + (num12 != null ? num12.hashCode() : 0)) * 37;
        Integer num13 = this.is_gs_order;
        if (num13 != null) {
            i2 = num13.hashCode();
        }
        int i3 = (hashCode16 + i2) * 37;
        List<String> list = this.oids;
        int hashCode17 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode17;
        return hashCode17;
    }

    public static final class Builder extends Message.Builder<DriverNewOrderComingReq> {
        public Integer combo_type;
        public Long dispatch_uuid;
        public Integer forcePlay;
        public Integer history_num;
        public Integer is_busy;
        public Integer is_carpoll;
        public Integer is_gs_order;
        public Integer is_onboard;
        public Integer is_serial;
        public Integer is_zhipai_order;
        public String oid;
        public List<String> oids;
        public String receive_level;
        public Integer require_level;
        public Integer send_num;
        public Integer src_type;
        public String token;
        public Integer type;

        public Builder() {
        }

        public Builder(DriverNewOrderComingReq driverNewOrderComingReq) {
            super(driverNewOrderComingReq);
            if (driverNewOrderComingReq != null) {
                this.token = driverNewOrderComingReq.token;
                this.oid = driverNewOrderComingReq.oid;
                this.is_zhipai_order = driverNewOrderComingReq.is_zhipai_order;
                this.history_num = driverNewOrderComingReq.history_num;
                this.dispatch_uuid = driverNewOrderComingReq.dispatch_uuid;
                this.send_num = driverNewOrderComingReq.send_num;
                this.type = driverNewOrderComingReq.type;
                this.receive_level = driverNewOrderComingReq.receive_level;
                this.require_level = driverNewOrderComingReq.require_level;
                this.forcePlay = driverNewOrderComingReq.forcePlay;
                this.is_carpoll = driverNewOrderComingReq.is_carpoll;
                this.combo_type = driverNewOrderComingReq.combo_type;
                this.src_type = driverNewOrderComingReq.src_type;
                this.is_serial = driverNewOrderComingReq.is_serial;
                this.is_onboard = driverNewOrderComingReq.is_onboard;
                this.is_busy = driverNewOrderComingReq.is_busy;
                this.is_gs_order = driverNewOrderComingReq.is_gs_order;
                this.oids = DriverNewOrderComingReq.copyOf(driverNewOrderComingReq.oids);
            }
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder is_zhipai_order(Integer num) {
            this.is_zhipai_order = num;
            return this;
        }

        public Builder history_num(Integer num) {
            this.history_num = num;
            return this;
        }

        public Builder dispatch_uuid(Long l) {
            this.dispatch_uuid = l;
            return this;
        }

        public Builder send_num(Integer num) {
            this.send_num = num;
            return this;
        }

        public Builder type(Integer num) {
            this.type = num;
            return this;
        }

        public Builder receive_level(String str) {
            this.receive_level = str;
            return this;
        }

        public Builder require_level(Integer num) {
            this.require_level = num;
            return this;
        }

        public Builder forcePlay(Integer num) {
            this.forcePlay = num;
            return this;
        }

        public Builder is_carpoll(Integer num) {
            this.is_carpoll = num;
            return this;
        }

        public Builder combo_type(Integer num) {
            this.combo_type = num;
            return this;
        }

        public Builder src_type(Integer num) {
            this.src_type = num;
            return this;
        }

        public Builder is_serial(Integer num) {
            this.is_serial = num;
            return this;
        }

        public Builder is_onboard(Integer num) {
            this.is_onboard = num;
            return this;
        }

        public Builder is_busy(Integer num) {
            this.is_busy = num;
            return this;
        }

        public Builder is_gs_order(Integer num) {
            this.is_gs_order = num;
            return this;
        }

        public Builder oids(List<String> list) {
            this.oids = checkForNulls(list);
            return this;
        }

        public DriverNewOrderComingReq build() {
            checkRequiredFields();
            return new DriverNewOrderComingReq(this);
        }
    }
}
