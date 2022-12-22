package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TaxiDriverConsultResultReq extends Message {
    public static final String DEFAULT_CONSULTID = "";
    public static final String DEFAULT_CONSULTRESULT = "";
    public static final List<TaxiConsultOrderInfo> DEFAULT_ORDERS = Collections.emptyList();
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String consultId;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String consultResult;
    @ProtoField(label = Message.Label.REPEATED, messageType = TaxiConsultOrderInfo.class, tag = 6)
    public final List<TaxiConsultOrderInfo> orders;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 1)
    public final TaxiTripInfo trip;

    public TaxiDriverConsultResultReq(TaxiTripInfo taxiTripInfo, String str, String str2, String str3, String str4, List<TaxiConsultOrderInfo> list) {
        this.trip = taxiTripInfo;
        this.consultResult = str;
        this.consultId = str2;
        this.text = str3;
        this.title = str4;
        this.orders = immutableCopyOf(list);
    }

    private TaxiDriverConsultResultReq(Builder builder) {
        this(builder.trip, builder.consultResult, builder.consultId, builder.text, builder.title, builder.orders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverConsultResultReq)) {
            return false;
        }
        TaxiDriverConsultResultReq taxiDriverConsultResultReq = (TaxiDriverConsultResultReq) obj;
        if (!equals((Object) this.trip, (Object) taxiDriverConsultResultReq.trip) || !equals((Object) this.consultResult, (Object) taxiDriverConsultResultReq.consultResult) || !equals((Object) this.consultId, (Object) taxiDriverConsultResultReq.consultId) || !equals((Object) this.text, (Object) taxiDriverConsultResultReq.text) || !equals((Object) this.title, (Object) taxiDriverConsultResultReq.title) || !equals((List<?>) this.orders, (List<?>) taxiDriverConsultResultReq.orders)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        TaxiTripInfo taxiTripInfo = this.trip;
        int i2 = 0;
        int hashCode = (taxiTripInfo != null ? taxiTripInfo.hashCode() : 0) * 37;
        String str = this.consultResult;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.consultId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.text;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.title;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = (hashCode4 + i2) * 37;
        List<TaxiConsultOrderInfo> list = this.orders;
        int hashCode5 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode5;
        return hashCode5;
    }

    public static final class Builder extends Message.Builder<TaxiDriverConsultResultReq> {
        public String consultId;
        public String consultResult;
        public List<TaxiConsultOrderInfo> orders;
        public String text;
        public String title;
        public TaxiTripInfo trip;

        public Builder() {
        }

        public Builder(TaxiDriverConsultResultReq taxiDriverConsultResultReq) {
            super(taxiDriverConsultResultReq);
            if (taxiDriverConsultResultReq != null) {
                this.trip = taxiDriverConsultResultReq.trip;
                this.consultResult = taxiDriverConsultResultReq.consultResult;
                this.consultId = taxiDriverConsultResultReq.consultId;
                this.text = taxiDriverConsultResultReq.text;
                this.title = taxiDriverConsultResultReq.title;
                this.orders = TaxiDriverConsultResultReq.copyOf(taxiDriverConsultResultReq.orders);
            }
        }

        public Builder trip(TaxiTripInfo taxiTripInfo) {
            this.trip = taxiTripInfo;
            return this;
        }

        public Builder consultResult(String str) {
            this.consultResult = str;
            return this;
        }

        public Builder consultId(String str) {
            this.consultId = str;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder orders(List<TaxiConsultOrderInfo> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public TaxiDriverConsultResultReq build() {
            return new TaxiDriverConsultResultReq(this);
        }
    }
}
