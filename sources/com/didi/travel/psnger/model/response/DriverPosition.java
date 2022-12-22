package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.gson.PostProcessable;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import java.util.Iterator;

public class DriverPosition extends DriverPositionProto implements PostProcessable<DriverPosition> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public double getLngDouble() {
        if (TextUtil.isEmpty(this.lng)) {
            return 0.0d;
        }
        return Double.parseDouble(this.lng);
    }

    public Double getLatDouble() {
        if (TextUtil.isEmpty(this.lat)) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.parseDouble(this.lat));
    }

    public DriverPosition gsonPostProcess() {
        Coord coord;
        if (this.peerCoordinateInfos != null && !this.peerCoordinateInfos.isEmpty()) {
            PeerCoordinate peerCoordinate = null;
            ICarOrder order = DDTravelOrderStore.getOrder();
            Iterator it = this.peerCoordinateInfos.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PeerCoordinate peerCoordinate2 = (PeerCoordinate) it.next();
                if (order != null && peerCoordinate2 != null && TextUtils.equals(order.getOid(), peerCoordinate2.localId)) {
                    peerCoordinate = peerCoordinate2;
                    break;
                }
            }
            if (!(peerCoordinate == null || (coord = peerCoordinate.coordinate) == null)) {
                this.lng = String.valueOf(coord.f44217x);
                this.lat = String.valueOf(coord.f44218y);
                this.distance = String.valueOf(peerCoordinate.distance);
                this.arrivedTime = peerCoordinate.waitTime;
            }
        }
        return this;
    }
}
