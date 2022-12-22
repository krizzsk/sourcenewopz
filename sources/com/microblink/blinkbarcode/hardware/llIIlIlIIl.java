package com.microblink.blinkbarcode.hardware;

import com.microblink.blinkbarcode.secured.IlIIIIIlll;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: line */
public class llIIlIlIIl {
    private lIlIIIIlIl IIlIIIllIl;
    private String IlIllIlIIl;
    private lIlIIIIlIl IlIllIlllI;
    private int IllIIIIllI = -1;
    private IlIIIIIlll.llIIlIlIIl IllIIIllII;
    private lIlIIIIlIl IllIIlIIII;
    private lIlIIIIlIl lIIIIIlIlI;
    private lIlIIIIlIl lIIIIIllll;
    private double lIlIIIIlIl = 0.0d;
    private IlIIIIIlll.llIIlIlIIl llIIIlllll;
    private double llIIlIIlll = 1.0d;
    private String llIIlIlIIl;
    private lIlIIIIlIl lllIIIlIlI;
    private lIlIIIIlIl lllIlIlIIl;

    public llIIlIlIIl(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Device and Model cannot be null");
        }
        this.llIIlIlIIl = str;
        this.IlIllIlIIl = str2;
    }

    public lIlIIIIlIl IIlIIIllIl() {
        return this.lIIIIIllll;
    }

    public lIlIIIIlIl IlIllIlIIl() {
        return this.IIlIIIllIl;
    }

    public lIlIIIIlIl IlIllIlllI() {
        return this.lllIlIlIIl;
    }

    public double IllIIIIllI() {
        return this.llIIlIIlll;
    }

    public lIlIIIIlIl IllIIIllII() {
        return this.lllIIIlIlI;
    }

    public String IllIIlIIII() {
        return this.llIIlIlIIl + "::" + this.IlIllIlIIl;
    }

    public IlIIIIIlll.llIIlIlIIl lIIIIIllll() {
        return this.IllIIIllII;
    }

    public lIlIIIIlIl lIlIIIIlIl() {
        return this.IlIllIlllI;
    }

    public lIlIIIIlIl llIIIlllll() {
        return this.IllIIlIIII;
    }

    public double llIIlIIlll() {
        return this.lIlIIIIlIl;
    }

    public int llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    public IlIIIIIlll.llIIlIlIIl lllIIIlIlI() {
        return this.llIIIlllll;
    }

    public lIlIIIIlIl lllIlIlIIl() {
        return this.lIIIIIlIlI;
    }

    public String toString() {
        return "DeviceInfo{mDevice='" + this.llIIlIlIIl + '\'' + ", mModel='" + this.IlIllIlIIl + '\'' + '}';
    }

    public llIIlIlIIl(JSONObject jSONObject, String str) throws JSONException {
        String[] split = str.split("::");
        this.IlIllIlIIl = split[1];
        this.llIIlIlIIl = split[0];
        if (jSONObject.has("backFacingPreviewSize")) {
            JSONArray jSONArray = jSONObject.getJSONArray("backFacingPreviewSize");
            this.IllIIIllII = new IlIIIIIlll.llIIlIlIIl(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("frontFacingPreviewSize")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("frontFacingPreviewSize");
            this.llIIIlllll = new IlIIIIIlll.llIIlIlIIl(jSONArray2.getInt(0), jSONArray2.getInt(1));
        }
        if (jSONObject.has("cameraInitDelayMs")) {
            this.IllIIIIllI = jSONObject.getInt("cameraInitDelayMs");
        }
        if (jSONObject.has("minZoomLevel")) {
            this.lIlIIIIlIl = jSONObject.getDouble("minZoomLevel");
        }
        if (jSONObject.has("maxZoomLevel")) {
            this.llIIlIIlll = jSONObject.getDouble("maxZoomLevel");
        }
        if (jSONObject.has("displayOrientationNotWorking")) {
            this.IIlIIIllIl = new lIlIIIIlIl(jSONObject.getString("displayOrientationNotWorking"));
        }
        if (jSONObject.has("naturalOrientationIsLandscapeLeft")) {
            this.lIIIIIllll = new lIlIIIIlIl(jSONObject.getString("naturalOrientationIsLandscapeLeft"));
        }
        if (jSONObject.has("focusUntrusty")) {
            this.lllIIIlIlI = new lIlIIIIlIl(jSONObject.getString("focusUntrusty"));
        }
        if (jSONObject.has("meteringNotWorking")) {
            this.IlIllIlllI = new lIlIIIIlIl(jSONObject.getString("meteringNotWorking"));
        }
        if (jSONObject.has("phaseAutoFocusSupported")) {
            this.lllIlIlIIl = new lIlIIIIlIl(jSONObject.getString("phaseAutoFocusSupported"));
        }
        if (jSONObject.has("forceUseLegacyCamera")) {
            this.IllIIlIIII = new lIlIIIIlIl(jSONObject.getString("forceUseLegacyCamera"));
        }
        if (jSONObject.has("preferTextureView")) {
            this.lIIIIIlIlI = new lIlIIIIlIl(jSONObject.getString("preferTextureView"));
        }
    }
}
