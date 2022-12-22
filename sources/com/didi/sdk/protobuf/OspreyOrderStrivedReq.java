package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class OspreyOrderStrivedReq extends Message {
    public static final String DEFAULT_OID = "";
    public static final String DEFAULT_RST_TTS = "";
    public static final DriverMessageTipShowType DEFAULT_SHOWTYPE = DriverMessageTipShowType.DriverMessageTipShowTypeWindow;
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String oid;
    @ProtoField(tag = 6)
    public final OspreyDriverDiffInfo other_info;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String rst_tts;
    @ProtoField(tag = 5)
    public final OspreyDriverDiffInfo self_info;
    @ProtoField(label = Message.Label.REQUIRED, tag = 4, type = Message.Datatype.ENUM)
    public final DriverMessageTipShowType showType;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String text;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String title;

    public OspreyOrderStrivedReq(String str, String str2, String str3, DriverMessageTipShowType driverMessageTipShowType, OspreyDriverDiffInfo ospreyDriverDiffInfo, OspreyDriverDiffInfo ospreyDriverDiffInfo2, String str4) {
        this.oid = str;
        this.title = str2;
        this.text = str3;
        this.showType = driverMessageTipShowType;
        this.self_info = ospreyDriverDiffInfo;
        this.other_info = ospreyDriverDiffInfo2;
        this.rst_tts = str4;
    }

    private OspreyOrderStrivedReq(Builder builder) {
        this(builder.oid, builder.title, builder.text, builder.showType, builder.self_info, builder.other_info, builder.rst_tts);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OspreyOrderStrivedReq)) {
            return false;
        }
        OspreyOrderStrivedReq ospreyOrderStrivedReq = (OspreyOrderStrivedReq) obj;
        if (!equals((Object) this.oid, (Object) ospreyOrderStrivedReq.oid) || !equals((Object) this.title, (Object) ospreyOrderStrivedReq.title) || !equals((Object) this.text, (Object) ospreyOrderStrivedReq.text) || !equals((Object) this.showType, (Object) ospreyOrderStrivedReq.showType) || !equals((Object) this.self_info, (Object) ospreyOrderStrivedReq.self_info) || !equals((Object) this.other_info, (Object) ospreyOrderStrivedReq.other_info) || !equals((Object) this.rst_tts, (Object) ospreyOrderStrivedReq.rst_tts)) {
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
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.text;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 37;
        DriverMessageTipShowType driverMessageTipShowType = this.showType;
        int hashCode4 = (hashCode3 + (driverMessageTipShowType != null ? driverMessageTipShowType.hashCode() : 0)) * 37;
        OspreyDriverDiffInfo ospreyDriverDiffInfo = this.self_info;
        int hashCode5 = (hashCode4 + (ospreyDriverDiffInfo != null ? ospreyDriverDiffInfo.hashCode() : 0)) * 37;
        OspreyDriverDiffInfo ospreyDriverDiffInfo2 = this.other_info;
        int hashCode6 = (hashCode5 + (ospreyDriverDiffInfo2 != null ? ospreyDriverDiffInfo2.hashCode() : 0)) * 37;
        String str4 = this.rst_tts;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<OspreyOrderStrivedReq> {
        public String oid;
        public OspreyDriverDiffInfo other_info;
        public String rst_tts;
        public OspreyDriverDiffInfo self_info;
        public DriverMessageTipShowType showType;
        public String text;
        public String title;

        public Builder() {
        }

        public Builder(OspreyOrderStrivedReq ospreyOrderStrivedReq) {
            super(ospreyOrderStrivedReq);
            if (ospreyOrderStrivedReq != null) {
                this.oid = ospreyOrderStrivedReq.oid;
                this.title = ospreyOrderStrivedReq.title;
                this.text = ospreyOrderStrivedReq.text;
                this.showType = ospreyOrderStrivedReq.showType;
                this.self_info = ospreyOrderStrivedReq.self_info;
                this.other_info = ospreyOrderStrivedReq.other_info;
                this.rst_tts = ospreyOrderStrivedReq.rst_tts;
            }
        }

        public Builder oid(String str) {
            this.oid = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder text(String str) {
            this.text = str;
            return this;
        }

        public Builder showType(DriverMessageTipShowType driverMessageTipShowType) {
            this.showType = driverMessageTipShowType;
            return this;
        }

        public Builder self_info(OspreyDriverDiffInfo ospreyDriverDiffInfo) {
            this.self_info = ospreyDriverDiffInfo;
            return this;
        }

        public Builder other_info(OspreyDriverDiffInfo ospreyDriverDiffInfo) {
            this.other_info = ospreyDriverDiffInfo;
            return this;
        }

        public Builder rst_tts(String str) {
            this.rst_tts = str;
            return this;
        }

        public OspreyOrderStrivedReq build() {
            checkRequiredFields();
            return new OspreyOrderStrivedReq(this);
        }
    }
}
