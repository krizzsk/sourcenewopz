package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class PushStatReq extends Message {
    public static final List<Long> DEFAULT_TASK_IDS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1, type = Message.Datatype.UINT64)
    public final List<Long> task_ids;

    public PushStatReq(List<Long> list) {
        this.task_ids = immutableCopyOf(list);
    }

    private PushStatReq(Builder builder) {
        this(builder.task_ids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PushStatReq)) {
            return false;
        }
        return equals((List<?>) this.task_ids, (List<?>) ((PushStatReq) obj).task_ids);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<Long> list = this.task_ids;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<PushStatReq> {
        public List<Long> task_ids;

        public Builder() {
        }

        public Builder(PushStatReq pushStatReq) {
            super(pushStatReq);
            if (pushStatReq != null) {
                this.task_ids = PushStatReq.copyOf(pushStatReq.task_ids);
            }
        }

        public Builder task_ids(List<Long> list) {
            this.task_ids = checkForNulls(list);
            return this;
        }

        public PushStatReq build() {
            return new PushStatReq(this);
        }
    }
}
