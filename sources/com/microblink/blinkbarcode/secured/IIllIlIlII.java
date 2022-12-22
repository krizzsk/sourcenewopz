package com.microblink.blinkbarcode.secured;

import android.os.Build;
import com.microblink.blinkbarcode.secured.IIIlIIIIlI;
import com.microblink.blinkbarcode.secured.IllIIlllIl;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: line */
class IIllIlIlII {

    /* compiled from: line */
    public static class IlIllIlIIl {
        private final int llIIlIlIIl;

        public IlIllIlIIl(int i) {
            this.llIIlIlIIl = i;
        }

        public boolean llIIlIlIIl() {
            return this.llIIlIlIIl == 201;
        }
    }

    /* compiled from: line */
    public static class llIIlIlIIl {
        public final String IIlIIIllIl;
        public final String IlIllIlIIl;
        public final String IllIIIIllI;
        public final String IllIIIllII;
        public final String lIIIIIllll = Build.VERSION.RELEASE;
        public final String lIlIIIIlIl;
        public final String llIIIlllll;
        public final IIIlIIIIll llIIlIIlll;
        public final String llIIlIlIIl;

        public llIIlIlIIl(IIIlIllllI iIIlIllllI, String str, IIIlIIIIll iIIlIIIIll, String str2, String str3, String str4) {
            this.llIIlIlIIl = iIIlIllllI.llIIlIlIIl().name();
            this.IlIllIlIIl = iIIlIllllI.IlIllIlIIl();
            this.lIlIIIIlIl = str;
            this.llIIlIIlll = iIIlIIIIll;
            this.IllIIIllII = str2;
            this.llIIIlllll = str3;
            this.IIlIIIllIl = str4;
            this.IllIIIIllI = llIIlIlIIl();
        }

        private String llIIlIlIIl() {
            String str;
            String str2 = Build.MANUFACTURER;
            String str3 = "";
            if (str2 == null) {
                str = str3;
            } else {
                str = str2.toUpperCase(Locale.US);
            }
            String str4 = Build.MODEL;
            if (str4 != null) {
                str3 = str4.toUpperCase(Locale.US);
            }
            return str + " - " + str3;
        }
    }

    public IlIllIlIIl llIIlIlIIl(llIIlIlIIl lliililiil) throws Exception {
        try {
            IIIlIIIIlI iIIlIIIIlI = new IIIlIIIIlI(new URL("https://ping.microblink.com/api/v1/ping"), "POST");
            iIIlIIIIlI.llIIlIlIIl(20000);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("product", lliililiil.llIIlIlIIl);
            jSONObject.put("productVersion", lliililiil.IlIllIlIIl);
            jSONObject.put("licensee", lliililiil.IllIIIllII);
            jSONObject.put("licenseId", lliililiil.llIIIlllll);
            jSONObject.put("userId", lliililiil.lIlIIIIlIl);
            jSONObject.put("scans", lliililiil.llIIlIIlll.IlIllIlIIl());
            jSONObject.put("successfulScans", lliililiil.llIIlIIlll.IllIIIllII());
            jSONObject.put("uncertainScans", lliililiil.llIIlIIlll.llIIIlllll());
            IlIlIlllIl llIIlIlIIl2 = lliililiil.llIIlIIlll.llIIlIlIIl();
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry next : llIIlIlIIl2.llIIlIlIIl().entrySet()) {
                IllIIlllIl illIIlllIl = (IllIIlllIl) next.getKey();
                lIIllIIlIl liilliilil = (lIIllIIlIl) next.getValue();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("recognizer", illIIlllIl.IlIllIlIIl());
                IllIIlllIl.llIIlIlIIl llIIlIlIIl3 = illIIlllIl.llIIlIlIIl();
                if (llIIlIlIIl3 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("country", llIIlIlIIl3.llIIlIlIIl());
                    jSONObject3.put("region", llIIlIlIIl3.IlIllIlIIl());
                    jSONObject3.put("type", llIIlIlIIl3.IllIIIllII());
                    jSONObject2.put("classInfo", jSONObject3);
                }
                jSONObject2.put("successfulScans", liilliilil.llIIlIlIIl());
                jSONObject2.put("unsuccessfulScans", liilliilil.IllIIIllII());
                jSONObject2.put("uncertainScans", liilliilil.IlIllIlIIl());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("recognizerScans", jSONArray);
            jSONObject.put("packageName", lliililiil.IIlIIIllIl);
            jSONObject.put("device", lliililiil.IllIIIIllI);
            jSONObject.put("osVersion", lliililiil.lIIIIIllll);
            jSONObject.put("platform", "ANDROID");
            iIIlIIIIlI.llIIlIlIIl(jSONObject);
            return new IlIllIlIIl(iIIlIIIIlI.IlIllIlIIl());
        } catch (Exception e) {
            throw new IIIlIIIIlI.llIIlIlIIl(e);
        }
    }
}
