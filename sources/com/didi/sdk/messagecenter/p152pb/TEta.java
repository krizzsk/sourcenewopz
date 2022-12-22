package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.TEta */
public final class TEta extends Message {
    public static final Integer DEFAULT_ETA = 0;
    public static final Integer DEFAULT_ETA_DISTANCE = 0;
    public static final String DEFAULT_ETA_STR = "";
    private static final long serialVersionUID = 0;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.INT32)
    public final Integer eta;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.INT32)
    public final Integer eta_distance;
    @ProtoField(label = Message.Label.REQUIRED, tag = 3, type = Message.Datatype.STRING)
    public final String eta_str;

    public TEta(Integer num, Integer num2, String str) {
        this.eta = num;
        this.eta_distance = num2;
        this.eta_str = str;
    }

    private TEta(Builder builder) {
        this(builder.eta, builder.eta_distance, builder.eta_str);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TEta)) {
            return false;
        }
        TEta tEta = (TEta) obj;
        if (!equals((Object) this.eta, (Object) tEta.eta) || !equals((Object) this.eta_distance, (Object) tEta.eta_distance) || !equals((Object) this.eta_str, (Object) tEta.eta_str)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.eta;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.eta_distance;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str = this.eta_str;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.TEta$Builder */
    public static final class Builder extends Message.Builder<TEta> {
        public Integer eta;
        public Integer eta_distance;
        public String eta_str;

        public Builder() {
        }

        public Builder(TEta tEta) {
            super(tEta);
            if (tEta != null) {
                this.eta = tEta.eta;
                this.eta_distance = tEta.eta_distance;
                this.eta_str = tEta.eta_str;
            }
        }

        public Builder eta(Integer num) {
            this.eta = num;
            return this;
        }

        public Builder eta_distance(Integer num) {
            this.eta_distance = num;
            return this;
        }

        public Builder eta_str(String str) {
            this.eta_str = str;
            return this;
        }

        public TEta build() {
            checkRequiredFields();
            return new TEta(this);
        }
    }
}
