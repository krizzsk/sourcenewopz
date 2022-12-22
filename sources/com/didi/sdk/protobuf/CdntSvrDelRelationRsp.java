package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CdntSvrDelRelationRsp extends Message {
    public static final List<PeerCoordinateRelation> DEFAULT_RELATIONS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = PeerCoordinateRelation.class, tag = 2)
    public final List<PeerCoordinateRelation> relations;
    @ProtoField(label = Message.Label.REQUIRED, tag = 1)
    public final RspMsg rsp_msg;

    public CdntSvrDelRelationRsp(RspMsg rspMsg, List<PeerCoordinateRelation> list) {
        this.rsp_msg = rspMsg;
        this.relations = immutableCopyOf(list);
    }

    private CdntSvrDelRelationRsp(Builder builder) {
        this(builder.rsp_msg, builder.relations);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CdntSvrDelRelationRsp)) {
            return false;
        }
        CdntSvrDelRelationRsp cdntSvrDelRelationRsp = (CdntSvrDelRelationRsp) obj;
        if (!equals((Object) this.rsp_msg, (Object) cdntSvrDelRelationRsp.rsp_msg) || !equals((List<?>) this.relations, (List<?>) cdntSvrDelRelationRsp.relations)) {
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
        int hashCode = (rspMsg != null ? rspMsg.hashCode() : 0) * 37;
        List<PeerCoordinateRelation> list = this.relations;
        int hashCode2 = hashCode + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public static final class Builder extends Message.Builder<CdntSvrDelRelationRsp> {
        public List<PeerCoordinateRelation> relations;
        public RspMsg rsp_msg;

        public Builder() {
        }

        public Builder(CdntSvrDelRelationRsp cdntSvrDelRelationRsp) {
            super(cdntSvrDelRelationRsp);
            if (cdntSvrDelRelationRsp != null) {
                this.rsp_msg = cdntSvrDelRelationRsp.rsp_msg;
                this.relations = CdntSvrDelRelationRsp.copyOf(cdntSvrDelRelationRsp.relations);
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

        public CdntSvrDelRelationRsp build() {
            checkRequiredFields();
            return new CdntSvrDelRelationRsp(this);
        }
    }
}
