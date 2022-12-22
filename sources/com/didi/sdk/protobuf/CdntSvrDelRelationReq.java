package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CdntSvrDelRelationReq extends Message {
    public static final List<String> DEFAULT_LOCAL_IDS = Collections.emptyList();
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.STRING)
    public final List<String> local_ids;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public CdntSvrDelRelationReq(Long l, List<String> list) {
        this.user_id = l;
        this.local_ids = immutableCopyOf(list);
    }

    private CdntSvrDelRelationReq(Builder builder) {
        this(builder.user_id, builder.local_ids);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CdntSvrDelRelationReq)) {
            return false;
        }
        CdntSvrDelRelationReq cdntSvrDelRelationReq = (CdntSvrDelRelationReq) obj;
        if (!equals((Object) this.user_id, (Object) cdntSvrDelRelationReq.user_id) || !equals((List<?>) this.local_ids, (List<?>) cdntSvrDelRelationReq.local_ids)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        Long l = this.user_id;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<String> list = this.local_ids;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CdntSvrDelRelationReq> {
        public List<String> local_ids;
        public Long user_id;

        public Builder() {
        }

        public Builder(CdntSvrDelRelationReq cdntSvrDelRelationReq) {
            super(cdntSvrDelRelationReq);
            if (cdntSvrDelRelationReq != null) {
                this.user_id = cdntSvrDelRelationReq.user_id;
                this.local_ids = CdntSvrDelRelationReq.copyOf(cdntSvrDelRelationReq.local_ids);
            }
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder local_ids(List<String> list) {
            this.local_ids = checkForNulls(list);
            return this;
        }

        public CdntSvrDelRelationReq build() {
            checkRequiredFields();
            return new CdntSvrDelRelationReq(this);
        }
    }
}
