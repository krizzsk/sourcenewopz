package com.didi.map.sdk.proto.driver_gl;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class LegsInfo extends Message {
    public static final List<LegInfo> DEFAULT_LEGINFO = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = LegInfo.class, tag = 1)
    public final List<LegInfo> legInfo;

    public LegsInfo(List<LegInfo> list) {
        this.legInfo = immutableCopyOf(list);
    }

    private LegsInfo(Builder builder) {
        this(builder.legInfo);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LegsInfo)) {
            return false;
        }
        return equals((List<?>) this.legInfo, (List<?>) ((LegsInfo) obj).legInfo);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<LegInfo> list = this.legInfo;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<LegsInfo> {
        public List<LegInfo> legInfo;

        public Builder() {
        }

        public Builder(LegsInfo legsInfo) {
            super(legsInfo);
            if (legsInfo != null) {
                this.legInfo = LegsInfo.copyOf(legsInfo.legInfo);
            }
        }

        public Builder legInfo(List<LegInfo> list) {
            this.legInfo = checkForNulls(list);
            return this;
        }

        public LegsInfo build() {
            return new LegsInfo(this);
        }
    }
}
