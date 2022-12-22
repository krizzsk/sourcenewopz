package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationServiceResponse */
/* compiled from: LocDataDef */
class LocationServiceResponse implements Serializable {
    private final String RSP_COORDINATE_GCJ02 = "gcj02ll";
    private final String RSP_COORDINATE_WGS84 = "wgs84ll";
    private String coord_system;
    List<location_info_t> locations = new ArrayList();
    int ret_code;
    String ret_msg;
    long timestamp;

    LocationServiceResponse() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCoordinateType() {
        /*
            r6 = this;
            java.lang.String r0 = r6.coord_system
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            r2 = -1
            r3 = 1
            if (r0 != 0) goto L_0x0038
            java.lang.String r0 = r6.coord_system
            int r4 = r0.hashCode()
            r5 = -142740720(0xfffffffff77df310, float:-5.150707E33)
            if (r4 == r5) goto L_0x0026
            r5 = 1295484831(0x4d37879f, float:1.92444912E8)
            if (r4 == r5) goto L_0x001c
            goto L_0x0030
        L_0x001c:
            java.lang.String r4 = "wgs84ll"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0030
            r0 = 0
            goto L_0x0031
        L_0x0026:
            java.lang.String r4 = "gcj02ll"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r1 = 1
            goto L_0x0039
        L_0x0038:
            r1 = -1
        L_0x0039:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.LocationServiceResponse.getCoordinateType():int");
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        StringBuilder sb = new StringBuilder(Const.jaLeft);
        for (int i = 0; i < this.locations.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(this.locations.get(i).toJson());
        }
        sb.append(Const.jaRight);
        return Const.joLeft + Const.js_rsp_ret_code + ":" + this.ret_code + "," + Const.js_rsp_ret_msg + ":" + Const.formatString(this.ret_msg) + "," + "\"timestamp\"" + ":" + this.timestamp + "," + Const.js_rsp_coord_system + ":" + this.coord_system + "," + Const.js_rsp_locations + ":" + sb + "}";
    }

    static LocationServiceResponse toObject(String str) {
        try {
            LocationServiceResponse locationServiceResponse = new LocationServiceResponse();
            String jsonObject = Const.getJsonObject(str, Const.js_rsp_ret_code);
            String jsonObject2 = Const.getJsonObject(str, "\"timestamp\"");
            if (jsonObject.length() != 0) {
                if (jsonObject2.length() != 0) {
                    locationServiceResponse.ret_code = Integer.parseInt(jsonObject);
                    locationServiceResponse.ret_msg = Const.getJsonObjectString(str, Const.js_rsp_ret_msg);
                    locationServiceResponse.timestamp = Long.parseLong(jsonObject2);
                    locationServiceResponse.coord_system = Const.getJsonObjectString(str, Const.js_rsp_coord_system);
                    Iterator<String> it = Const.getJsonArrayObjects(Const.getJsonObject(str, Const.js_rsp_locations)).iterator();
                    while (it.hasNext()) {
                        location_info_t object = location_info_t.toObject(it.next());
                        if (object != null) {
                            locationServiceResponse.locations.add(object);
                        }
                    }
                    return locationServiceResponse;
                }
            }
            return null;
        } catch (Exception e) {
            DLog.m32737d(e.toString());
            return null;
        }
    }
}
