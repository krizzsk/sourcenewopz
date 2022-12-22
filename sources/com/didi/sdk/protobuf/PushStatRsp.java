package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PushStatRsp extends Message {
    public static final List<PushStat> DEFAULT_STATS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = PushStat.class, tag = 1)
    public final List<PushStat> stats;

    public PushStatRsp(List<PushStat> list) {
        this.stats = immutableCopyOf(list);
    }

    private PushStatRsp(Builder builder) {
        this(builder.stats);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushStatRsp)) {
            return false;
        }
        return equals((List<?>) this.stats, (List<?>) ((PushStatRsp) obj).stats);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<PushStat> list = this.stats;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<PushStatRsp> {
        public List<PushStat> stats;

        public Builder() {
        }

        public Builder(PushStatRsp pushStatRsp) {
            super(pushStatRsp);
            if (pushStatRsp != null) {
                this.stats = PushStatRsp.copyOf(pushStatRsp.stats);
            }
        }

        public Builder stats(List<PushStat> list) {
            this.stats = checkForNulls(list);
            return this;
        }

        public PushStatRsp build() {
            return new PushStatRsp(this);
        }
    }
}
