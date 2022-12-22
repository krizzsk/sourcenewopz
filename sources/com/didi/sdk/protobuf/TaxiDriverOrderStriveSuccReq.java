package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class TaxiDriverOrderStriveSuccReq extends Message {
    public static final String DEFAULT_CONSULTID = "";
    public static final String DEFAULT_ID = "";
    public static final List<TaxiSuccOrderInfo> DEFAULT_ORDERS = Collections.emptyList();
    public static final String DEFAULT_RSTTTS = "";
    public static final Integer DEFAULT_RWITHINORDER = 0;
    public static final Integer DEFAULT_SHOWTYPE = 0;
    public static final Integer DEFAULT_STRIVEDPOLL = 0;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String consultId;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)

    /* renamed from: id */
    public final String f36958id;
    @ProtoField(label = Message.Label.REPEATED, messageType = TaxiSuccOrderInfo.class, tag = 10)
    public final List<TaxiSuccOrderInfo> orders;
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer rWithinorder;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String rstTts;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer showType;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer strivedPoll;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 9)
    public final TaxiTripInfo tripInfo;

    public TaxiDriverOrderStriveSuccReq(String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, Integer num3, TaxiTripInfo taxiTripInfo, List<TaxiSuccOrderInfo> list) {
        this.f36958id = str;
        this.text = str2;
        this.title = str3;
        this.consultId = str4;
        this.rstTts = str5;
        this.showType = num;
        this.strivedPoll = num2;
        this.rWithinorder = num3;
        this.tripInfo = taxiTripInfo;
        this.orders = immutableCopyOf(list);
    }

    private TaxiDriverOrderStriveSuccReq(Builder builder) {
        this(builder.f36959id, builder.text, builder.title, builder.consultId, builder.rstTts, builder.showType, builder.strivedPoll, builder.rWithinorder, builder.tripInfo, builder.orders);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverOrderStriveSuccReq)) {
            return false;
        }
        TaxiDriverOrderStriveSuccReq taxiDriverOrderStriveSuccReq = (TaxiDriverOrderStriveSuccReq) obj;
        if (!equals((Object) this.f36958id, (Object) taxiDriverOrderStriveSuccReq.f36958id) || !equals((Object) this.text, (Object) taxiDriverOrderStriveSuccReq.text) || !equals((Object) this.title, (Object) taxiDriverOrderStriveSuccReq.title) || !equals((Object) this.consultId, (Object) taxiDriverOrderStriveSuccReq.consultId) || !equals((Object) this.rstTts, (Object) taxiDriverOrderStriveSuccReq.rstTts) || !equals((Object) this.showType, (Object) taxiDriverOrderStriveSuccReq.showType) || !equals((Object) this.strivedPoll, (Object) taxiDriverOrderStriveSuccReq.strivedPoll) || !equals((Object) this.rWithinorder, (Object) taxiDriverOrderStriveSuccReq.rWithinorder) || !equals((Object) this.tripInfo, (Object) taxiDriverOrderStriveSuccReq.tripInfo) || !equals((List<?>) this.orders, (List<?>) taxiDriverOrderStriveSuccReq.orders)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.f36958id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.consultId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.rstTts;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.showType;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.strivedPoll;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.rWithinorder;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 37;
        TaxiTripInfo taxiTripInfo = this.tripInfo;
        if (taxiTripInfo != null) {
            i2 = taxiTripInfo.hashCode();
        }
        int i3 = (hashCode8 + i2) * 37;
        List<TaxiSuccOrderInfo> list = this.orders;
        int hashCode9 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode9;
        return hashCode9;
    }

    public static final class Builder extends Message.Builder<TaxiDriverOrderStriveSuccReq> {
        public String consultId;

        /* renamed from: id */
        public String f36959id;
        public List<TaxiSuccOrderInfo> orders;
        public Integer rWithinorder;
        public String rstTts;
        public Integer showType;
        public Integer strivedPoll;
        public String text;
        public String title;
        public TaxiTripInfo tripInfo;

        public Builder() {
        }

        public Builder(TaxiDriverOrderStriveSuccReq taxiDriverOrderStriveSuccReq) {
            super(taxiDriverOrderStriveSuccReq);
            if (taxiDriverOrderStriveSuccReq != null) {
                this.f36959id = taxiDriverOrderStriveSuccReq.f36958id;
                this.text = taxiDriverOrderStriveSuccReq.text;
                this.title = taxiDriverOrderStriveSuccReq.title;
                this.consultId = taxiDriverOrderStriveSuccReq.consultId;
                this.rstTts = taxiDriverOrderStriveSuccReq.rstTts;
                this.showType = taxiDriverOrderStriveSuccReq.showType;
                this.strivedPoll = taxiDriverOrderStriveSuccReq.strivedPoll;
                this.rWithinorder = taxiDriverOrderStriveSuccReq.rWithinorder;
                this.tripInfo = taxiDriverOrderStriveSuccReq.tripInfo;
                this.orders = TaxiDriverOrderStriveSuccReq.copyOf(taxiDriverOrderStriveSuccReq.orders);
            }
        }

        /* renamed from: id */
        public Builder mo94897id(String str) {
            this.f36959id = str;
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

        public Builder consultId(String str) {
            this.consultId = str;
            return this;
        }

        public Builder rstTts(String str) {
            this.rstTts = str;
            return this;
        }

        public Builder showType(Integer num) {
            this.showType = num;
            return this;
        }

        public Builder strivedPoll(Integer num) {
            this.strivedPoll = num;
            return this;
        }

        public Builder rWithinorder(Integer num) {
            this.rWithinorder = num;
            return this;
        }

        public Builder tripInfo(TaxiTripInfo taxiTripInfo) {
            this.tripInfo = taxiTripInfo;
            return this;
        }

        public Builder orders(List<TaxiSuccOrderInfo> list) {
            this.orders = checkForNulls(list);
            return this;
        }

        public TaxiDriverOrderStriveSuccReq build() {
            return new TaxiDriverOrderStriveSuccReq(this);
        }
    }
}
