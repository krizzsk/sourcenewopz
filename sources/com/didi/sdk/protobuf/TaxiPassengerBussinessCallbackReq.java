package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiPassengerBussinessCallbackReq extends Message {
    public static final String DEFAULT_REDIRECT_URL = "";
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.STRING)
    public final String redirect_url;

    public TaxiPassengerBussinessCallbackReq(String str) {
        this.redirect_url = str;
    }

    private TaxiPassengerBussinessCallbackReq(Builder builder) {
        this(builder.redirect_url);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiPassengerBussinessCallbackReq)) {
            return false;
        }
        return equals((Object) this.redirect_url, (Object) ((TaxiPassengerBussinessCallbackReq) obj).redirect_url);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.redirect_url;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<TaxiPassengerBussinessCallbackReq> {
        public String redirect_url;

        public Builder() {
        }

        public Builder(TaxiPassengerBussinessCallbackReq taxiPassengerBussinessCallbackReq) {
            super(taxiPassengerBussinessCallbackReq);
            if (taxiPassengerBussinessCallbackReq != null) {
                this.redirect_url = taxiPassengerBussinessCallbackReq.redirect_url;
            }
        }

        public Builder redirect_url(String str) {
            this.redirect_url = str;
            return this;
        }

        public TaxiPassengerBussinessCallbackReq build() {
            checkRequiredFields();
            return new TaxiPassengerBussinessCallbackReq(this);
        }
    }
}
