package com.didi.map.sdk.nav.car;

import com.didi.common.map.model.LatLng;

public class AnimateNode {
    public int index;
    public boolean isNeedErase;
    public LatLng latLng;
    public int offSet;

    public AnimateNode(LatLng latLng2, int i, int i2, boolean z) {
        this.latLng = latLng2;
        this.offSet = i2;
        this.isNeedErase = z;
        this.index = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LatLng latLng2 = this.latLng;
        sb.append(latLng2 == null ? "lat/lng: (null)" : latLng2.toString());
        sb.append(",destOffSet=" + this.offSet);
        sb.append(",isNeedErase=" + this.isNeedErase);
        sb.append(",destIndex=" + this.index);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r0 = r6.latLng;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean compare(com.didi.map.sdk.nav.car.AnimateNode r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x002e
            int r0 = r6.index
            int r1 = r5.index
            if (r0 != r1) goto L_0x002e
            int r0 = r6.offSet
            int r1 = r5.offSet
            if (r0 != r1) goto L_0x002e
            com.didi.common.map.model.LatLng r0 = r6.latLng
            if (r0 == 0) goto L_0x002e
            com.didi.common.map.model.LatLng r1 = r5.latLng
            if (r1 == 0) goto L_0x002e
            double r0 = r0.longitude
            com.didi.common.map.model.LatLng r2 = r5.latLng
            double r2 = r2.longitude
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x002e
            com.didi.common.map.model.LatLng r6 = r6.latLng
            double r0 = r6.latitude
            com.didi.common.map.model.LatLng r6 = r5.latLng
            double r2 = r6.latitude
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x002e
            r6 = 1
            return r6
        L_0x002e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.sdk.nav.car.AnimateNode.compare(com.didi.map.sdk.nav.car.AnimateNode):boolean");
    }
}
