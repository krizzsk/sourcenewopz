package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class DriverInfo extends Message {
    public static final String DEFAULT_CAR_TYPE = "";
    public static final Integer DEFAULT_CNT_ORDER = 0;
    public static final Integer DEFAULT_CNT_POSITIVE = 0;
    public static final String DEFAULT_DRIVER_CARD = "";
    public static final String DEFAULT_DRIVER_CAR_IMAGE = "";
    public static final String DEFAULT_DRIVER_COMPANY = "";
    public static final String DEFAULT_DRIVER_HEADPIC = "";
    public static final Long DEFAULT_DRIVER_ID = 0L;
    public static final String DEFAULT_DRIVER_NAME = "";
    public static final String DEFAULT_DRIVER_PHONE = "";
    public static final Integer DEFAULT_IS_PROTECT = 0;
    public static final Integer DEFAULT_IS_TIMEOUT = 0;
    public static final Integer DEFAULT_LEVEL = 0;
    public static final Float DEFAULT_LEVEL_NEW = Float.valueOf(0.0f);
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String car_type;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer cnt_order;
    @ProtoField(tag = 9, type = Message.Datatype.INT32)
    public final Integer cnt_positive;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String driver_car_image;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String driver_card;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String driver_company;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)
    public final String driver_headPic;
    @ProtoField(tag = 6, type = Message.Datatype.UINT64)
    public final Long driver_id;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String driver_name;
    @ProtoField(label = Message.Label.REQUIRED, tag = 5, type = Message.Datatype.STRING)
    public final String driver_phone;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer is_protect;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer is_timeout;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer level;
    @ProtoField(tag = 11, type = Message.Datatype.FLOAT)
    public final Float level_new;

    public DriverInfo(String str, String str2, String str3, String str4, String str5, Long l, String str6, Integer num, Integer num2, Integer num3, Float f, Integer num4, Integer num5, String str7) {
        this.driver_name = str;
        this.driver_card = str2;
        this.driver_company = str3;
        this.driver_headPic = str4;
        this.driver_phone = str5;
        this.driver_id = l;
        this.car_type = str6;
        this.cnt_order = num;
        this.cnt_positive = num2;
        this.level = num3;
        this.level_new = f;
        this.is_protect = num4;
        this.is_timeout = num5;
        this.driver_car_image = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DriverInfo(com.didi.sdk.protobuf.DriverInfo.Builder r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r2 = r0.driver_name
            java.lang.String r3 = r0.driver_card
            java.lang.String r4 = r0.driver_company
            java.lang.String r5 = r0.driver_headPic
            java.lang.String r6 = r0.driver_phone
            java.lang.Long r7 = r0.driver_id
            java.lang.String r8 = r0.car_type
            java.lang.Integer r9 = r0.cnt_order
            java.lang.Integer r10 = r0.cnt_positive
            java.lang.Integer r11 = r0.level
            java.lang.Float r12 = r0.level_new
            java.lang.Integer r13 = r0.is_protect
            java.lang.Integer r14 = r0.is_timeout
            java.lang.String r15 = r0.driver_car_image
            r1 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r16.setBuilder(r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.protobuf.DriverInfo.<init>(com.didi.sdk.protobuf.DriverInfo$Builder):void");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverInfo)) {
            return false;
        }
        DriverInfo driverInfo = (DriverInfo) obj;
        if (!equals((Object) this.driver_name, (Object) driverInfo.driver_name) || !equals((Object) this.driver_card, (Object) driverInfo.driver_card) || !equals((Object) this.driver_company, (Object) driverInfo.driver_company) || !equals((Object) this.driver_headPic, (Object) driverInfo.driver_headPic) || !equals((Object) this.driver_phone, (Object) driverInfo.driver_phone) || !equals((Object) this.driver_id, (Object) driverInfo.driver_id) || !equals((Object) this.car_type, (Object) driverInfo.car_type) || !equals((Object) this.cnt_order, (Object) driverInfo.cnt_order) || !equals((Object) this.cnt_positive, (Object) driverInfo.cnt_positive) || !equals((Object) this.level, (Object) driverInfo.level) || !equals((Object) this.level_new, (Object) driverInfo.level_new) || !equals((Object) this.is_protect, (Object) driverInfo.is_protect) || !equals((Object) this.is_timeout, (Object) driverInfo.is_timeout) || !equals((Object) this.driver_car_image, (Object) driverInfo.driver_car_image)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.driver_name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.driver_card;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.driver_company;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.driver_headPic;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.driver_phone;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l = this.driver_id;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        String str6 = this.car_type;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        Integer num = this.cnt_order;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.cnt_positive;
        int hashCode9 = (hashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.level;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Float f = this.level_new;
        int hashCode11 = (hashCode10 + (f != null ? f.hashCode() : 0)) * 37;
        Integer num4 = this.is_protect;
        int hashCode12 = (hashCode11 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.is_timeout;
        int hashCode13 = (hashCode12 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str7 = this.driver_car_image;
        if (str7 != null) {
            i2 = str7.hashCode();
        }
        int i3 = hashCode13 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<DriverInfo> {
        public String car_type;
        public Integer cnt_order;
        public Integer cnt_positive;
        public String driver_car_image;
        public String driver_card;
        public String driver_company;
        public String driver_headPic;
        public Long driver_id;
        public String driver_name;
        public String driver_phone;
        public Integer is_protect;
        public Integer is_timeout;
        public Integer level;
        public Float level_new;

        public Builder() {
        }

        public Builder(DriverInfo driverInfo) {
            super(driverInfo);
            if (driverInfo != null) {
                this.driver_name = driverInfo.driver_name;
                this.driver_card = driverInfo.driver_card;
                this.driver_company = driverInfo.driver_company;
                this.driver_headPic = driverInfo.driver_headPic;
                this.driver_phone = driverInfo.driver_phone;
                this.driver_id = driverInfo.driver_id;
                this.car_type = driverInfo.car_type;
                this.cnt_order = driverInfo.cnt_order;
                this.cnt_positive = driverInfo.cnt_positive;
                this.level = driverInfo.level;
                this.level_new = driverInfo.level_new;
                this.is_protect = driverInfo.is_protect;
                this.is_timeout = driverInfo.is_timeout;
                this.driver_car_image = driverInfo.driver_car_image;
            }
        }

        public Builder driver_name(String str) {
            this.driver_name = str;
            return this;
        }

        public Builder driver_card(String str) {
            this.driver_card = str;
            return this;
        }

        public Builder driver_company(String str) {
            this.driver_company = str;
            return this;
        }

        public Builder driver_headPic(String str) {
            this.driver_headPic = str;
            return this;
        }

        public Builder driver_phone(String str) {
            this.driver_phone = str;
            return this;
        }

        public Builder driver_id(Long l) {
            this.driver_id = l;
            return this;
        }

        public Builder car_type(String str) {
            this.car_type = str;
            return this;
        }

        public Builder cnt_order(Integer num) {
            this.cnt_order = num;
            return this;
        }

        public Builder cnt_positive(Integer num) {
            this.cnt_positive = num;
            return this;
        }

        public Builder level(Integer num) {
            this.level = num;
            return this;
        }

        public Builder level_new(Float f) {
            this.level_new = f;
            return this;
        }

        public Builder is_protect(Integer num) {
            this.is_protect = num;
            return this;
        }

        public Builder is_timeout(Integer num) {
            this.is_timeout = num;
            return this;
        }

        public Builder driver_car_image(String str) {
            this.driver_car_image = str;
            return this;
        }

        public DriverInfo build() {
            checkRequiredFields();
            return new DriverInfo(this);
        }
    }
}
