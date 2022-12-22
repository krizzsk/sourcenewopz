package com.didichuxing.bigdata.p173dp.locsdk.once;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.once.location_user_info_t */
/* compiled from: LocDataDef */
class location_user_info_t implements Serializable {
    String app_id;
    String app_version;
    String didi_uid;
    String imei;
    String modellevel;
    String phone;
    long timestamp;
    String user_id;

    location_user_info_t() {
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return Const.joLeft + "\"timestamp\"" + ":" + this.timestamp + "," + Const.js_req_user_imei + ":" + Const.formatString(this.imei) + "," + Const.js_req_user_app_id + ":" + Const.formatString(this.app_id) + "," + Const.js_req_user_user_id + ":" + Const.formatString(this.user_id) + "," + Const.js_req_user_didi_uid + ":" + Const.formatString(this.didi_uid) + "," + Const.js_req_user_phone + ":" + Const.formatString(this.phone) + "," + Const.js_req_user_modellevel + ":" + Const.formatString(this.modellevel) + "," + Const.js_req_app_version + ":" + Const.formatString(this.app_version) + "}";
    }

    static location_user_info_t toObject(String str) {
        try {
            location_user_info_t location_user_info_t = new location_user_info_t();
            location_user_info_t.timestamp = Long.parseLong(Const.getJsonObject(str, "\"timestamp\""));
            location_user_info_t.imei = Const.getJsonObjectString(str, Const.js_req_user_imei);
            location_user_info_t.app_id = Const.getJsonObjectString(str, Const.js_req_user_app_id);
            location_user_info_t.user_id = Const.getJsonObjectString(str, Const.js_req_user_user_id);
            location_user_info_t.phone = Const.getJsonObjectString(str, Const.js_req_user_phone);
            return location_user_info_t;
        } catch (Exception e) {
            DLog.m32737d(e.toString());
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(getByteLen());
        allocate.putLong(this.timestamp);
        LocDataDef.fillStringToByteBuffer(this.imei, allocate);
        LocDataDef.fillStringToByteBuffer(this.app_id, allocate);
        LocDataDef.fillStringToByteBuffer(this.user_id, allocate);
        LocDataDef.fillStringToByteBuffer(this.phone, allocate);
        return allocate.array();
    }

    /* access modifiers changed from: package-private */
    public short getByteLen() {
        return (short) (LocDataDef.calcStringLen(this.imei) + 10 + 2 + LocDataDef.calcStringLen(this.app_id) + 2 + LocDataDef.calcStringLen(this.user_id) + 2 + LocDataDef.calcStringLen(this.phone));
    }
}
