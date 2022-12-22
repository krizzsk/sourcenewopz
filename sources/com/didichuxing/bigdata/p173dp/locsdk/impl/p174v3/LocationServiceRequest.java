package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.LocDataDef;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationServiceRequest */
/* compiled from: LocDataDef */
class LocationServiceRequest implements Serializable, Cloneable {
    String call_from = "default_page";
    LocDataDef.LocCellInfo cell = new LocDataDef.LocCellInfo();
    gps_info_t gps = new gps_info_t();
    String listeners_info;
    List<pre_gps_t> pre_gps = new ArrayList();
    List<pre_location_t> pre_locations = new ArrayList();
    List<pre_didi_nlp_t> pre_nlps = new ArrayList();
    String sdk_version;
    sys_nlp_t sys_nlp = new sys_nlp_t();
    String tencent_loc;
    long trace_id;
    location_user_info_t user_info = new location_user_info_t();
    user_sensors_info_t user_sensors_info = new user_sensors_info_t();
    long valid_flag;
    List<LocDataDef.LocWifiInfo> wifis = new ArrayList();

    LocationServiceRequest() {
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        LocationServiceRequest locationServiceRequest = (LocationServiceRequest) super.clone();
        locationServiceRequest.valid_flag = this.valid_flag;
        locationServiceRequest.user_info = new location_user_info_t();
        LocDataDef.LocCellInfo locCellInfo = new LocDataDef.LocCellInfo();
        locationServiceRequest.cell = locCellInfo;
        locCellInfo.mcc = this.cell.mcc;
        locationServiceRequest.cell.mnc_sid = this.cell.mnc_sid;
        locationServiceRequest.cell.lac_nid = this.cell.lac_nid;
        locationServiceRequest.cell.cellid_bsid = this.cell.cellid_bsid;
        locationServiceRequest.cell.rssi = this.cell.rssi;
        locationServiceRequest.cell.type = this.cell.type;
        locationServiceRequest.cell.lon_cdma = this.cell.lon_cdma;
        locationServiceRequest.cell.lat_cdma = this.cell.lat_cdma;
        locationServiceRequest.cell.neighcells = new ArrayList();
        locationServiceRequest.cell.neighcells.addAll(this.cell.neighcells);
        locationServiceRequest.cell.pre_cell = new ArrayList();
        locationServiceRequest.cell.pre_cell.addAll(this.cell.pre_cell);
        ArrayList arrayList = new ArrayList();
        locationServiceRequest.wifis = arrayList;
        arrayList.addAll(this.wifis);
        ArrayList arrayList2 = new ArrayList();
        locationServiceRequest.pre_gps = arrayList2;
        arrayList2.addAll(this.pre_gps);
        ArrayList arrayList3 = new ArrayList();
        locationServiceRequest.pre_nlps = arrayList3;
        arrayList3.addAll(this.pre_nlps);
        ArrayList arrayList4 = new ArrayList();
        locationServiceRequest.pre_locations = arrayList4;
        arrayList4.addAll(this.pre_locations);
        locationServiceRequest.user_sensors_info = new user_sensors_info_t();
        return locationServiceRequest;
    }

    /* access modifiers changed from: protected */
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
        return new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        String str = Const.jaLeft;
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < this.wifis.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(this.wifis.get(i).toJson());
        }
        sb.append(Const.jaRight);
        String str2 = str;
        for (int i2 = 0; i2 < this.pre_gps.size(); i2++) {
            if (i2 != 0) {
                str2 = str2 + ",";
            }
            str2 = str2 + this.pre_gps.get(i2).toJson();
        }
        String str3 = str2 + Const.jaRight;
        String str4 = str;
        for (int i3 = 0; i3 < this.pre_nlps.size(); i3++) {
            if (i3 != 0) {
                str4 = str4 + ",";
            }
            str4 = str4 + this.pre_nlps.get(i3).toJson();
        }
        String str5 = str4 + Const.jaRight;
        for (int i4 = 0; i4 < this.pre_locations.size(); i4++) {
            if (i4 != 0) {
                str = str + ",";
            }
            str = str + this.pre_locations.get(i4).toJson();
        }
        return Const.joLeft + Const.js_req_user_info + ":" + this.user_info.toJson() + "," + Const.js_req_cell + ":" + this.cell.toJson() + "," + Const.js_req_wifis + ":" + sb + "," + Const.js_req_pre_gps + ":" + str3 + "," + Const.js_req_pre_nlp + ":" + str5 + "," + Const.js_req_pre_locations + ":" + (str + Const.jaRight) + "," + Const.js_req_gps + ":" + this.gps.toJson() + "," + Const.js_req_sys_nlp + ":" + this.sys_nlp.toJson() + "," + Const.js_req_valid_flag + ":" + this.valid_flag + "," + Const.js_req_sdk_version + ":" + Const.formatString(this.sdk_version) + "," + Const.js_req_trace_id + ":" + this.trace_id + "," + Const.js_req_tencent_loc + ":" + Const.formatString(this.tencent_loc) + "," + Const.js_req_user_sensors_info + ":" + this.user_sensors_info.toJson() + "," + Const.js_req_listeners_info + ":" + Const.formatString(this.listeners_info) + "," + Const.js_req_call_from + ":" + Const.formatString(this.call_from) + "}";
    }

    /* access modifiers changed from: package-private */
    public String toBamaiLog() {
        String str = Const.jaLeft;
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (i < this.wifis.size() && i < 2) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(this.wifis.get(i).toJson());
            i++;
        }
        sb.append(Const.jaRight);
        for (int i2 = 0; i2 < this.pre_gps.size(); i2++) {
            if (i2 != 0) {
                str = str + ",";
            }
            str = str + this.pre_gps.get(i2).toJson();
        }
        return Const.joLeft + Const.js_req_user_info + ":" + this.user_info.toJson() + "," + Const.js_req_cell + ":" + this.cell.toJson() + "," + Const.js_req_wifis + ":" + sb + "," + Const.js_req_pre_gps + ":" + (str + Const.jaRight) + "," + Const.js_req_sdk_version + ":" + Const.formatString(this.sdk_version) + "," + Const.js_req_trace_id + ":" + this.trace_id + "," + Const.js_req_user_sensors_info + ":" + this.user_sensors_info.toBamaiLog() + "}";
    }
}
