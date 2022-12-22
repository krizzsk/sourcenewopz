package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class AMOilPopPaySuccessReq extends Message {
    public static final Long DEFAULT_ORDER_ID = 0L;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long order_id;

    public AMOilPopPaySuccessReq(Long l) {
        this.order_id = l;
    }

    private AMOilPopPaySuccessReq(Builder builder) {
        this(builder.order_id);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AMOilPopPaySuccessReq)) {
            return false;
        }
        return equals((Object) this.order_id, (Object) ((AMOilPopPaySuccessReq) obj).order_id);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            Long l = this.order_id;
            i = l != null ? l.hashCode() : 0;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<AMOilPopPaySuccessReq> {
        public Long order_id;

        public Builder() {
        }

        public Builder(AMOilPopPaySuccessReq aMOilPopPaySuccessReq) {
            super(aMOilPopPaySuccessReq);
            if (aMOilPopPaySuccessReq != null) {
                this.order_id = aMOilPopPaySuccessReq.order_id;
            }
        }

        public Builder order_id(Long l) {
            this.order_id = l;
            return this;
        }

        public AMOilPopPaySuccessReq build() {
            checkRequiredFields();
            return new AMOilPopPaySuccessReq(this);
        }
    }
}
