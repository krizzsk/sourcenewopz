package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CdntSvrAddRelationReq extends Message {
    public static final List<PeerCoordinateRelation> DEFAULT_RELATIONS = Collections.emptyList();
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    public static final Long DEFAULT_USER_ID = 0L;
    @ProtoField(label = Message.Label.REPEATED, messageType = PeerCoordinateRelation.class, tag = 2)
    public final List<PeerCoordinateRelation> relations;
    @ProtoField(tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1, type = Message.Datatype.UINT64)
    public final Long user_id;

    public CdntSvrAddRelationReq(Long l, List<PeerCoordinateRelation> list, CoordinateType coordinateType) {
        this.user_id = l;
        this.relations = immutableCopyOf(list);
        this.type = coordinateType;
    }

    private CdntSvrAddRelationReq(Builder builder) {
        this(builder.user_id, builder.relations, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CdntSvrAddRelationReq)) {
            return false;
        }
        CdntSvrAddRelationReq cdntSvrAddRelationReq = (CdntSvrAddRelationReq) obj;
        if (!equals((Object) this.user_id, (Object) cdntSvrAddRelationReq.user_id) || !equals((List<?>) this.relations, (List<?>) cdntSvrAddRelationReq.relations) || !equals((Object) this.type, (Object) cdntSvrAddRelationReq.type)) {
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
        int i2 = 0;
        int hashCode = (l != null ? l.hashCode() : 0) * 37;
        List<PeerCoordinateRelation> list = this.relations;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        CoordinateType coordinateType = this.type;
        if (coordinateType != null) {
            i2 = coordinateType.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public static final class Builder extends Message.Builder<CdntSvrAddRelationReq> {
        public List<PeerCoordinateRelation> relations;
        public CoordinateType type;
        public Long user_id;

        public Builder() {
        }

        public Builder(CdntSvrAddRelationReq cdntSvrAddRelationReq) {
            super(cdntSvrAddRelationReq);
            if (cdntSvrAddRelationReq != null) {
                this.user_id = cdntSvrAddRelationReq.user_id;
                this.relations = CdntSvrAddRelationReq.copyOf(cdntSvrAddRelationReq.relations);
                this.type = cdntSvrAddRelationReq.type;
            }
        }

        public Builder user_id(Long l) {
            this.user_id = l;
            return this;
        }

        public Builder relations(List<PeerCoordinateRelation> list) {
            this.relations = checkForNulls(list);
            return this;
        }

        public Builder type(CoordinateType coordinateType) {
            this.type = coordinateType;
            return this;
        }

        public CdntSvrAddRelationReq build() {
            checkRequiredFields();
            return new CdntSvrAddRelationReq(this);
        }
    }
}
