package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocDataDef */
public class LocDataDef {
    public static short calcStringLen(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return (short) str.length();
    }

    public static void fillStringToByteBuffer(String str, ByteBuffer byteBuffer) {
        if (str == null || str.length() == 0) {
            byteBuffer.putShort(0);
            return;
        }
        byte[] bArr = null;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (Exception unused) {
        }
        if (bArr == null || bArr.length != str.length()) {
            byteBuffer.putShort(0);
        } else {
            byteBuffer.putShort((short) str.length()).put(bArr);
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocWifiInfo */
    public static class LocWifiInfo implements Serializable {
        public boolean connect;
        long frequency;
        public long level;
        public String mac;
        public String ssid;
        public long time_diff;

        public String toJson() {
            return Const.joLeft + Const.js_req_wifi_mac + ":" + Const.formatString(this.mac) + "," + Const.js_req_wifi_level + ":" + this.level + "," + Const.js_req_wifi_ssid + ":" + Const.formatString(this.ssid) + "," + Const.js_req_wifi_frequency + ":" + this.frequency + "," + Const.js_req_wifi_connect + ":" + this.connect + "," + Const.js_req_time_diff + ":" + this.time_diff + "}";
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocCellInfo */
    public static class LocCellInfo implements Serializable {
        public long cellid_bsid;
        public long lac_nid;
        public double lat_cdma;
        public double lon_cdma;
        public long mcc;
        public long mnc_sid;
        public List<LocNeighboringCellInfo> neighcells = new ArrayList();
        public List<LocPreCellInfo> pre_cell = new ArrayList();
        public long rssi;
        public long type;

        public String toJson() {
            StringBuilder sb = new StringBuilder(Const.jaLeft);
            List<LocNeighboringCellInfo> list = this.neighcells;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.neighcells.size(); i++) {
                    if (i != 0) {
                        sb.append(",");
                    }
                    sb.append(this.neighcells.get(i).toJson());
                }
            }
            sb.append(Const.jaRight);
            StringBuilder sb2 = new StringBuilder(Const.jaLeft);
            List<LocPreCellInfo> list2 = this.pre_cell;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < this.pre_cell.size(); i2++) {
                    if (i2 != 0) {
                        sb2.append(",");
                    }
                    sb2.append(this.pre_cell.get(i2).toJson());
                }
            }
            sb2.append(Const.jaRight);
            return Const.joLeft + Const.js_req_cell_mcc + ":" + this.mcc + "," + Const.js_req_cell_mnc_sid + ":" + this.mnc_sid + "," + Const.js_req_cell_lac_nid + ":" + this.lac_nid + "," + Const.js_req_cell_cellid_bsid + ":" + this.cellid_bsid + "," + "\"rssi\"" + ":" + this.rssi + "," + "\"type\"" + ":" + this.type + "," + Const.js_req_cell_neighcells + ":" + sb + "," + Const.js_req_cell_precell + ":" + sb2 + "}";
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocNeighboringCellInfo */
    public static class LocNeighboringCellInfo implements Serializable {
        public long cid;
        public long lac;
        public long rssi;

        public String toJson() {
            return Const.joLeft + Const.js_req_cell_neigh_lac + ":" + this.lac + "," + Const.js_req_cell_neigh_cid + ":" + this.cid + "," + "\"rssi\"" + ":" + this.rssi + "}";
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.once.LocDataDef$LocPreCellInfo */
    public static class LocPreCellInfo implements Serializable {
        public long cellid_bsid;

        /* renamed from: dt */
        public long f46107dt;
        public long lac_nid;
        public long mcc;
        public long mnc_sid;
        public long rssi;
        public long type;

        public String toJson() {
            return Const.joLeft + Const.js_req_cell_mcc + ":" + this.mcc + "," + Const.js_req_cell_mnc_sid + ":" + this.mnc_sid + "," + Const.js_req_cell_lac_nid + ":" + this.lac_nid + "," + Const.js_req_cell_cellid_bsid + ":" + this.cellid_bsid + "," + "\"type\"" + ":" + this.type + "," + "\"dt\"" + ":" + this.f46107dt + "," + "\"rssi\"" + ":" + this.rssi + "}";
        }
    }
}
