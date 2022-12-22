package com.didi.travel.psnger.model.response;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: DriverPosition */
class DriverPositionProto extends DriverPositionRaw {
    @SerializedName("peer_coordinate_infos")
    public List<PeerCoordinate> peerCoordinateInfos;

    DriverPositionProto() {
    }
}
