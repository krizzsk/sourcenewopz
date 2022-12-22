package com.microblink.blinkbarcode.hardware;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: line */
class llIIIlllll {
    private final String IlIllIlIIl;
    private lIlIIIIlIl IllIIIIllI;
    private double IllIIIllII = 1.0d;
    private lIlIIIIlIl llIIIlllll;
    private final String llIIlIlIIl;

    public llIIIlllll(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Device and Model cannot be null");
        }
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
    }

    public double IlIllIlIIl() {
        return this.IllIIIllII;
    }

    public String IllIIIllII() {
        return this.llIIlIlIIl + "::" + this.IlIllIlIIl;
    }

    public lIlIIIIlIl llIIIlllll() {
        return this.llIIIlllll;
    }

    public lIlIIIIlIl llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    public llIIIlllll(JSONObject jSONObject, String str) throws JSONException {
        String[] split = str.split("::");
        this.IlIllIlIIl = split[1];
        this.llIIlIlIIl = split[0];
        if (jSONObject.has("zeroCopyBufferAllowed")) {
            this.llIIIlllll = new lIlIIIIlIl(jSONObject.getString("zeroCopyBufferAllowed"));
        }
        if (jSONObject.has("eglPbufferNotSupported")) {
            this.IllIIIIllI = new lIlIIIIlIl(jSONObject.getString("eglPbufferNotSupported"));
        }
        if (jSONObject.has("frameQualityFactor")) {
            this.IllIIIllII = jSONObject.getDouble("frameQualityFactor");
        }
    }
}
