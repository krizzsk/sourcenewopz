package com.didi.map.sdk.proto.nav_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;

public final class BIArrvie extends Message {
    public static final Integer DEFAULT_DESTNO = 0;
    public static final Boolean DEFAULT_ISTERMINAL = false;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT32)
    public final Integer destNo;
    @ProtoField(label = Message.Label.REQUIRED, tag = 2, type = Message.Datatype.BOOL)
    public final Boolean isTerminal;

    public BIArrvie(Integer num, Boolean bool) {
        this.destNo = num;
        this.isTerminal = bool;
    }

    private BIArrvie(Builder builder) {
        this(builder.destNo, builder.isTerminal);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BIArrvie)) {
            return false;
        }
        BIArrvie bIArrvie = (BIArrvie) obj;
        if (!equals((Object) this.destNo, (Object) bIArrvie.destNo) || !equals((Object) this.isTerminal, (Object) bIArrvie.isTerminal)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Integer num = this.destNo;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 37;
        Boolean bool = this.isTerminal;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<BIArrvie> {
        public Integer destNo;
        public Boolean isTerminal;

        public Builder() {
        }

        public Builder(BIArrvie bIArrvie) {
            super(bIArrvie);
            if (bIArrvie != null) {
                this.destNo = bIArrvie.destNo;
                this.isTerminal = bIArrvie.isTerminal;
            }
        }

        public Builder destNo(Integer num) {
            this.destNo = num;
            return this;
        }

        public Builder isTerminal(Boolean bool) {
            this.isTerminal = bool;
            return this;
        }

        public BIArrvie build() {
            checkRequiredFields();
            return new BIArrvie(this);
        }
    }
}
