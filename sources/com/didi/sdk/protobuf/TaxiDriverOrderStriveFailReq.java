package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiDriverOrderStriveFailReq extends Message {
    public static final Integer DEFAULT_FAILREASON = 0;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_RSTTTS = "";
    public static final Integer DEFAULT_SHOWTYPE = 0;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(tag = 8, type = Message.Datatype.INT32)
    public final Integer failReason;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)

    /* renamed from: id */
    public final String f36956id;
    @ProtoField(tag = 6)
    public final TaxiFailDriverInfo loser;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String rstTts;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer showType;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 7)
    public final TaxiSucessDriverInfo winner;

    public TaxiDriverOrderStriveFailReq(String str, String str2, String str3, String str4, Integer num, TaxiFailDriverInfo taxiFailDriverInfo, TaxiSucessDriverInfo taxiSucessDriverInfo, Integer num2) {
        this.f36956id = str;
        this.text = str2;
        this.title = str3;
        this.rstTts = str4;
        this.showType = num;
        this.loser = taxiFailDriverInfo;
        this.winner = taxiSucessDriverInfo;
        this.failReason = num2;
    }

    private TaxiDriverOrderStriveFailReq(Builder builder) {
        this(builder.f36957id, builder.text, builder.title, builder.rstTts, builder.showType, builder.loser, builder.winner, builder.failReason);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiDriverOrderStriveFailReq)) {
            return false;
        }
        TaxiDriverOrderStriveFailReq taxiDriverOrderStriveFailReq = (TaxiDriverOrderStriveFailReq) obj;
        if (!equals((Object) this.f36956id, (Object) taxiDriverOrderStriveFailReq.f36956id) || !equals((Object) this.text, (Object) taxiDriverOrderStriveFailReq.text) || !equals((Object) this.title, (Object) taxiDriverOrderStriveFailReq.title) || !equals((Object) this.rstTts, (Object) taxiDriverOrderStriveFailReq.rstTts) || !equals((Object) this.showType, (Object) taxiDriverOrderStriveFailReq.showType) || !equals((Object) this.loser, (Object) taxiDriverOrderStriveFailReq.loser) || !equals((Object) this.winner, (Object) taxiDriverOrderStriveFailReq.winner) || !equals((Object) this.failReason, (Object) taxiDriverOrderStriveFailReq.failReason)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.f36956id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.rstTts;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Integer num = this.showType;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        TaxiFailDriverInfo taxiFailDriverInfo = this.loser;
        int hashCode6 = (hashCode5 + (taxiFailDriverInfo != null ? taxiFailDriverInfo.hashCode() : 0)) * 37;
        TaxiSucessDriverInfo taxiSucessDriverInfo = this.winner;
        int hashCode7 = (hashCode6 + (taxiSucessDriverInfo != null ? taxiSucessDriverInfo.hashCode() : 0)) * 37;
        Integer num2 = this.failReason;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiDriverOrderStriveFailReq> {
        public Integer failReason;

        /* renamed from: id */
        public String f36957id;
        public TaxiFailDriverInfo loser;
        public String rstTts;
        public Integer showType;
        public String text;
        public String title;
        public TaxiSucessDriverInfo winner;

        public Builder() {
        }

        public Builder(TaxiDriverOrderStriveFailReq taxiDriverOrderStriveFailReq) {
            super(taxiDriverOrderStriveFailReq);
            if (taxiDriverOrderStriveFailReq != null) {
                this.f36957id = taxiDriverOrderStriveFailReq.f36956id;
                this.text = taxiDriverOrderStriveFailReq.text;
                this.title = taxiDriverOrderStriveFailReq.title;
                this.rstTts = taxiDriverOrderStriveFailReq.rstTts;
                this.showType = taxiDriverOrderStriveFailReq.showType;
                this.loser = taxiDriverOrderStriveFailReq.loser;
                this.winner = taxiDriverOrderStriveFailReq.winner;
                this.failReason = taxiDriverOrderStriveFailReq.failReason;
            }
        }

        /* renamed from: id */
        public Builder mo94887id(String str) {
            this.f36957id = str;
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

        public Builder rstTts(String str) {
            this.rstTts = str;
            return this;
        }

        public Builder showType(Integer num) {
            this.showType = num;
            return this;
        }

        public Builder loser(TaxiFailDriverInfo taxiFailDriverInfo) {
            this.loser = taxiFailDriverInfo;
            return this;
        }

        public Builder winner(TaxiSucessDriverInfo taxiSucessDriverInfo) {
            this.winner = taxiSucessDriverInfo;
            return this;
        }

        public Builder failReason(Integer num) {
            this.failReason = num;
            return this;
        }

        public TaxiDriverOrderStriveFailReq build() {
            return new TaxiDriverOrderStriveFailReq(this);
        }
    }
}
