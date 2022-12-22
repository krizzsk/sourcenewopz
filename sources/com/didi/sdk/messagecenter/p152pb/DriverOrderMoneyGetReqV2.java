package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.sdk.messagecenter.pb.DriverOrderMoneyGetReqV2 */
public final class DriverOrderMoneyGetReqV2 extends Message {
    public static final String DEFAULT_ID = "";
    public static final List<LocationInfo> DEFAULT_INFO = Collections.emptyList();
    public static final GulfstreamOrderType DEFAULT_ORDER_TYPE = GulfstreamOrderType.NONCARPOOL;
    public static final String DEFAULT_PHONE = "";
    public static final String DEFAULT_PLUTUS_DATA = "";
    public static final String DEFAULT_TOKEN = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.STRING)

    /* renamed from: id */
    public final String f36786id;
    @ProtoField(label = Message.Label.REPEATED, messageType = LocationInfo.class, tag = 5)
    public final List<LocationInfo> info;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.ENUM)
    public final GulfstreamOrderType order_type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String phone;
    @ProtoField(label = Message.Label.REQUIRED, tag = 6, type = Message.Datatype.STRING)
    public final String plutus_data;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String token;

    public DriverOrderMoneyGetReqV2(String str, String str2, GulfstreamOrderType gulfstreamOrderType, String str3, List<LocationInfo> list, String str4) {
        this.phone = str;
        this.token = str2;
        this.order_type = gulfstreamOrderType;
        this.f36786id = str3;
        this.info = immutableCopyOf(list);
        this.plutus_data = str4;
    }

    private DriverOrderMoneyGetReqV2(Builder builder) {
        this(builder.phone, builder.token, builder.order_type, builder.f36787id, builder.info, builder.plutus_data);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DriverOrderMoneyGetReqV2)) {
            return false;
        }
        DriverOrderMoneyGetReqV2 driverOrderMoneyGetReqV2 = (DriverOrderMoneyGetReqV2) obj;
        if (!equals((Object) this.phone, (Object) driverOrderMoneyGetReqV2.phone) || !equals((Object) this.token, (Object) driverOrderMoneyGetReqV2.token) || !equals((Object) this.order_type, (Object) driverOrderMoneyGetReqV2.order_type) || !equals((Object) this.f36786id, (Object) driverOrderMoneyGetReqV2.f36786id) || !equals((List<?>) this.info, (List<?>) driverOrderMoneyGetReqV2.info) || !equals((Object) this.plutus_data, (Object) driverOrderMoneyGetReqV2.plutus_data)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.phone;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.token;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        GulfstreamOrderType gulfstreamOrderType = this.order_type;
        int hashCode3 = (hashCode2 + (gulfstreamOrderType != null ? gulfstreamOrderType.hashCode() : 0)) * 37;
        String str3 = this.f36786id;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<LocationInfo> list = this.info;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 1)) * 37;
        String str4 = this.plutus_data;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.DriverOrderMoneyGetReqV2$Builder */
    public static final class Builder extends Message.Builder<DriverOrderMoneyGetReqV2> {

        /* renamed from: id */
        public String f36787id;
        public List<LocationInfo> info;
        public GulfstreamOrderType order_type;
        public String phone;
        public String plutus_data;
        public String token;

        public Builder() {
        }

        public Builder(DriverOrderMoneyGetReqV2 driverOrderMoneyGetReqV2) {
            super(driverOrderMoneyGetReqV2);
            if (driverOrderMoneyGetReqV2 != null) {
                this.phone = driverOrderMoneyGetReqV2.phone;
                this.token = driverOrderMoneyGetReqV2.token;
                this.order_type = driverOrderMoneyGetReqV2.order_type;
                this.f36787id = driverOrderMoneyGetReqV2.f36786id;
                this.info = DriverOrderMoneyGetReqV2.copyOf(driverOrderMoneyGetReqV2.info);
                this.plutus_data = driverOrderMoneyGetReqV2.plutus_data;
            }
        }

        public Builder phone(String str) {
            this.phone = str;
            return this;
        }

        public Builder token(String str) {
            this.token = str;
            return this;
        }

        public Builder order_type(GulfstreamOrderType gulfstreamOrderType) {
            this.order_type = gulfstreamOrderType;
            return this;
        }

        /* renamed from: id */
        public Builder mo93026id(String str) {
            this.f36787id = str;
            return this;
        }

        public Builder info(List<LocationInfo> list) {
            this.info = checkForNulls(list);
            return this;
        }

        public Builder plutus_data(String str) {
            this.plutus_data = str;
            return this;
        }

        public DriverOrderMoneyGetReqV2 build() {
            checkRequiredFields();
            return new DriverOrderMoneyGetReqV2(this);
        }
    }
}
