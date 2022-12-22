package com.didichuxing.afanty.common.record;

public class ChanceRecord extends Record {
    public void putLogcat(byte[] bArr) {
        put("logcat", bArr);
    }

    public byte[] getLogcat() {
        return (byte[]) get("logcat");
    }

    public String toJson() {
        Object remove = this.f45567a.remove("screenshots");
        Object remove2 = this.f45567a.remove("logcat");
        String json = super.toJson();
        if (remove != null) {
            this.f45567a.put("screenshots", remove);
        }
        if (remove2 != null) {
            this.f45567a.put("logcat", remove2);
        }
        return json;
    }
}
