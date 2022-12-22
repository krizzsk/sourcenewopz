package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BIDownloadEnlargeMap extends Message {
    public static final String DEFAULT_ARROWURL = "";
    public static final String DEFAULT_BKURL = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.STRING)
    public final String arrowUrl;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String bkUrl;

    public BIDownloadEnlargeMap(String str, String str2) {
        this.bkUrl = str;
        this.arrowUrl = str2;
    }

    private BIDownloadEnlargeMap(Builder builder) {
        this(builder.bkUrl, builder.arrowUrl);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BIDownloadEnlargeMap)) {
            return false;
        }
        BIDownloadEnlargeMap bIDownloadEnlargeMap = (BIDownloadEnlargeMap) obj;
        if (!equals((Object) this.bkUrl, (Object) bIDownloadEnlargeMap.bkUrl) || !equals((Object) this.arrowUrl, (Object) bIDownloadEnlargeMap.arrowUrl)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        String str = this.bkUrl;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 37;
        String str2 = this.arrowUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BIDownloadEnlargeMap> {
        public String arrowUrl;
        public String bkUrl;

        public Builder() {
        }

        public Builder(BIDownloadEnlargeMap bIDownloadEnlargeMap) {
            super(bIDownloadEnlargeMap);
            if (bIDownloadEnlargeMap != null) {
                this.bkUrl = bIDownloadEnlargeMap.bkUrl;
                this.arrowUrl = bIDownloadEnlargeMap.arrowUrl;
            }
        }

        public Builder bkUrl(String str) {
            this.bkUrl = str;
            return this;
        }

        public Builder arrowUrl(String str) {
            this.arrowUrl = str;
            return this;
        }

        public BIDownloadEnlargeMap build() {
            checkRequiredFields();
            return new BIDownloadEnlargeMap(this);
        }
    }
}
