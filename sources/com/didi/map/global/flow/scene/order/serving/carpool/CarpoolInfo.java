package com.didi.map.global.flow.scene.order.serving.carpool;

import java.util.Objects;

public class CarpoolInfo {
    public static final int TYPE_DROP_OFF = 1;
    public static final int TYPE_PICK_UP = 0;
    public String msg;
    public String orderId;
    public int type;

    public CarpoolInfo(String str, int i, String str2) {
        this.orderId = str;
        this.type = i;
        this.msg = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CarpoolInfo carpoolInfo = (CarpoolInfo) obj;
        if (this.type == carpoolInfo.type && Objects.equals(this.orderId, carpoolInfo.orderId)) {
            return Objects.equals(this.msg, carpoolInfo.msg);
        }
        return false;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
        String str2 = this.msg;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CarpoolInfo{msg='" + this.msg + '\'' + '}';
    }
}
