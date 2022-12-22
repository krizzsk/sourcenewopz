package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CdntSvrGetRelationRsp extends Message {
    public static final List<PeerCoordinateRelation> DEFAULT_RELATIONS = Collections.emptyList();
    public static final CoordinateType DEFAULT_TYPE = CoordinateType.BD_09;
    @ProtoField(label = Message.Label.REPEATED, messageType = PeerCoordinateRelation.class, tag = 2)
    public final List<PeerCoordinateRelation> relations;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;
    @ProtoField(tag = 3, type = Message.Datatype.ENUM)
    public final CoordinateType type;

    public CdntSvrGetRelationRsp(RspMsg rspMsg, List<PeerCoordinateRelation> list, CoordinateType coordinateType) {
        this.rsp_msg = rspMsg;
        this.relations = immutableCopyOf(list);
        this.type = coordinateType;
    }

    private CdntSvrGetRelationRsp(Builder builder) {
        this(builder.rsp_msg, builder.relations, builder.type);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CdntSvrGetRelationRsp)) {
            return false;
        }
        CdntSvrGetRelationRsp cdntSvrGetRelationRsp = (CdntSvrGetRelationRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) cdntSvrGetRelationRsp.rsp_msg) || !equals((List<?>) this.relations, (List<?>) cdntSvrGetRelationRsp.relations) || !equals((Object) this.type, (Object) cdntSvrGetRelationRsp.type)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        RspMsg rspMsg = this.rsp_msg;
        int i2 = 0;
        int hashCode = (rspMsg != null ? rspMsg.hashCode() : 0) * 37;
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

    public static final class Builder extends Message.Builder<CdntSvrGetRelationRsp> {
        public List<PeerCoordinateRelation> relations;
        public RspMsg rsp_msg;
        public CoordinateType type;

        public Builder() {
        }

        public Builder(CdntSvrGetRelationRsp cdntSvrGetRelationRsp) {
            super(cdntSvrGetRelationRsp);
            if (cdntSvrGetRelationRsp != null) {
                this.rsp_msg = cdntSvrGetRelationRsp.rsp_msg;
                this.relations = CdntSvrGetRelationRsp.copyOf(cdntSvrGetRelationRsp.relations);
                this.type = cdntSvrGetRelationRsp.type;
            }
        }

        public Builder rsp_msg(RspMsg rspMsg) {
            this.rsp_msg = rspMsg;
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

        public CdntSvrGetRelationRsp build() {
            checkRequiredFields();
            return new CdntSvrGetRelationRsp(this);
        }
    }
}
