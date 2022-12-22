package com.didi.sdk.protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;

public final class CdntSvrDownReq extends Message {
    public static final List<PeerCoordinateInfo> DEFAULT_PEER_COORDINATE_INFOS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, messageType = PeerCoordinateInfo.class, tag = 1)
    public final List<PeerCoordinateInfo> peer_coordinate_infos;

    public CdntSvrDownReq(List<PeerCoordinateInfo> list) {
        this.peer_coordinate_infos = immutableCopyOf(list);
    }

    private CdntSvrDownReq(Builder builder) {
        this(builder.peer_coordinate_infos);
        setBuilder(builder);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CdntSvrDownReq)) {
            return false;
        }
        return equals((List<?>) this.peer_coordinate_infos, (List<?>) ((CdntSvrDownReq) obj).peer_coordinate_infos);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            List<PeerCoordinateInfo> list = this.peer_coordinate_infos;
            i = list != null ? list.hashCode() : 1;
            this.hashCode = i;
        }
        return i;
    }

    public static final class Builder extends Message.Builder<CdntSvrDownReq> {
        public List<PeerCoordinateInfo> peer_coordinate_infos;

        public Builder() {
        }

        public Builder(CdntSvrDownReq cdntSvrDownReq) {
            super(cdntSvrDownReq);
            if (cdntSvrDownReq != null) {
                this.peer_coordinate_infos = CdntSvrDownReq.copyOf(cdntSvrDownReq.peer_coordinate_infos);
            }
        }

        public Builder peer_coordinate_infos(List<PeerCoordinateInfo> list) {
            this.peer_coordinate_infos = checkForNulls(list);
            return this;
        }

        public CdntSvrDownReq build() {
            return new CdntSvrDownReq(this);
        }
    }
}
