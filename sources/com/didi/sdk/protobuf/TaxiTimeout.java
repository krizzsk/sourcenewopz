package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class TaxiTimeout extends Message {
    public static final Integer DEFAULT_CONSULT = 0;
    public static final Integer DEFAULT_OSPREYPK = 0;
    public static final Integer DEFAULT_STRIVE = 0;
    public static final Integer DEFAULT_STRIVE4LOOK = 0;
    public static final Integer DEFAULT_WAITROB = 0;
    public static final Integer DEFAULT_WAITROBOB4LOOK = 0;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer consult;
    @ProtoField(tag = 4, type = Message.Datatype.INT32)
    public final Integer ospreyPK;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer strive;
    @ProtoField(tag = 5, type = Message.Datatype.INT32)
    public final Integer strive4look;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer waitRob;
    @ProtoField(tag = 6, type = Message.Datatype.INT32)
    public final Integer waitRobob4look;

    public TaxiTimeout(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.strive = num;
        this.consult = num2;
        this.waitRob = num3;
        this.ospreyPK = num4;
        this.strive4look = num5;
        this.waitRobob4look = num6;
    }

    private TaxiTimeout(Builder builder) {
        this(builder.strive, builder.consult, builder.waitRob, builder.ospreyPK, builder.strive4look, builder.waitRobob4look);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TaxiTimeout)) {
            return false;
        }
        TaxiTimeout taxiTimeout = (TaxiTimeout) obj;
        if (!equals((Object) this.strive, (Object) taxiTimeout.strive) || !equals((Object) this.consult, (Object) taxiTimeout.consult) || !equals((Object) this.waitRob, (Object) taxiTimeout.waitRob) || !equals((Object) this.ospreyPK, (Object) taxiTimeout.ospreyPK) || !equals((Object) this.strive4look, (Object) taxiTimeout.strive4look) || !equals((Object) this.waitRobob4look, (Object) taxiTimeout.waitRobob4look)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.strive;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Integer num2 = this.consult;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.waitRob;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.ospreyPK;
        int hashCode4 = (hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Integer num5 = this.strive4look;
        int hashCode5 = (hashCode4 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Integer num6 = this.waitRobob4look;
        if (num6 != null) {
            i2 = num6.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<TaxiTimeout> {
        public Integer consult;
        public Integer ospreyPK;
        public Integer strive;
        public Integer strive4look;
        public Integer waitRob;
        public Integer waitRobob4look;

        public Builder() {
        }

        public Builder(TaxiTimeout taxiTimeout) {
            super(taxiTimeout);
            if (taxiTimeout != null) {
                this.strive = taxiTimeout.strive;
                this.consult = taxiTimeout.consult;
                this.waitRob = taxiTimeout.waitRob;
                this.ospreyPK = taxiTimeout.ospreyPK;
                this.strive4look = taxiTimeout.strive4look;
                this.waitRobob4look = taxiTimeout.waitRobob4look;
            }
        }

        public Builder strive(Integer num) {
            this.strive = num;
            return this;
        }

        public Builder consult(Integer num) {
            this.consult = num;
            return this;
        }

        public Builder waitRob(Integer num) {
            this.waitRob = num;
            return this;
        }

        public Builder ospreyPK(Integer num) {
            this.ospreyPK = num;
            return this;
        }

        public Builder strive4look(Integer num) {
            this.strive4look = num;
            return this;
        }

        public Builder waitRobob4look(Integer num) {
            this.waitRobob4look = num;
            return this;
        }

        public TaxiTimeout build() {
            return new TaxiTimeout(this);
        }
    }
}
