package com.didi.sdk.messagecenter.p152pb;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

/* renamed from: com.didi.sdk.messagecenter.pb.FeeBottom */
public final class FeeBottom extends Message {
    public static final String DEFAULT_FEE_LABEL = "";
    private static final long serialVersionUID = 0;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String fee_label;

    public FeeBottom(String str) {
        this.fee_label = str;
    }

    private FeeBottom(Builder builder) {
        this(builder.fee_label);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FeeBottom)) {
            return false;
        }
        return equals((Object) this.fee_label, (Object) ((FeeBottom) obj).fee_label);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            String str = this.fee_label;
            i = str != null ? str.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    /* renamed from: com.didi.sdk.messagecenter.pb.FeeBottom$Builder */
    public static final class Builder extends Message.Builder<FeeBottom> {
        public String fee_label;

        public Builder() {
        }

        public Builder(FeeBottom feeBottom) {
            super(feeBottom);
            if (feeBottom != null) {
                this.fee_label = feeBottom.fee_label;
            }
        }

        public Builder fee_label(String str) {
            this.fee_label = str;
            return this;
        }

        public FeeBottom build() {
            return new FeeBottom(this);
        }
    }
}
