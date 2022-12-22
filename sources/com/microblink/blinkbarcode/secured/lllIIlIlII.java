package com.microblink.blinkbarcode.secured;

import android.content.Context;
import com.microblink.blinkbarcode.secured.IllIIlllIl;
import com.microblink.blinkbarcode.util.IllIIIIllI;
import com.microblink.blinkbarcode.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: line */
class lllIIlIlII extends IllIIIIllI {
    public lllIIlIlII(Context context) {
        super(context, "com.microblink.blinkbarcode.ping.preferences");
        if (IllIIIllII("com.microblink.blinkbarcode.ping.preferences.userId") == null) {
            llIIlIlIIl("com.microblink.blinkbarcode.ping.preferences.userId", UUID.randomUUID().toString());
        }
    }

    public IIIlIIIIll IlIllIlIIl() {
        String IllIIIllII = IllIIIllII("com.microblink.blinkbarcode.ping.preferences.scansCount.V2");
        if (IllIIIllII == null) {
            return new IIIlIIIIll(0, 0, 0, new IlIlIlllIl(Collections.emptyList()));
        }
        try {
            JSONObject jSONObject = new JSONObject(IllIIIllII);
            return new IIIlIIIIll(jSONObject.getLong("totalScans"), jSONObject.getLong("totalSuccessfulScans"), jSONObject.getLong("totalUncertainScans"), new IlIlIlllIl(llIIlIlIIl(jSONObject.getJSONArray("recognizerScans"))));
        } catch (Exception unused) {
            return new IIIlIIIIll(0, 0, 0, new IlIlIlllIl(Collections.emptyList()));
        }
    }

    public String IllIIIllII() {
        return IllIIIllII("com.microblink.blinkbarcode.ping.preferences.userId");
    }

    public void llIIIlllll() {
        llIIIlllll("com.microblink.blinkbarcode.ping.preferences.scansCount.V2");
    }

    public void llIIlIlIIl(IIIlIIIIll iIIlIIIIll) {
        if (!iIIlIIIIll.IllIIIIllI()) {
            IIIlIIIIll llIIlIlIIl = IIIlIIIIll.llIIlIlIIl(IlIllIlIIl(), iIIlIIIIll);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("totalScans", llIIlIlIIl.IlIllIlIIl());
                jSONObject.put("totalSuccessfulScans", llIIlIlIIl.IllIIIllII());
                jSONObject.put("totalUncertainScans", llIIlIlIIl.llIIIlllll());
                jSONObject.put("recognizerScans", llIIlIlIIl(llIIlIlIIl.llIIlIlIIl()));
                llIIlIlIIl("com.microblink.blinkbarcode.ping.preferences.scansCount.V2", jSONObject.toString());
            } catch (JSONException e) {
                Log.m40230e(this, e, "PingStorage.setScanCount failed.", new Object[0]);
            }
        }
    }

    public void llIIlIlIIl(long j) {
        llIIlIlIIl("com.microblink.blinkbarcode.ping.preferences.lastPing", j);
    }

    public long llIIlIlIIl() {
        return IlIllIlIIl("com.microblink.blinkbarcode.ping.preferences.lastPing");
    }

    private static List<llIIllllIl> llIIlIlIIl(JSONArray jSONArray) throws JSONException {
        IllIIlllIl.llIIlIlIIl lliililiil;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.has("classInfo")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("classInfo");
                lliililiil = new IllIIlllIl.llIIlIlIIl(jSONObject2.getString("country"), jSONObject2.getString("region"), jSONObject2.getString("type"));
            } else {
                lliililiil = null;
            }
            arrayList.add(new llIIllllIl(new IllIIlllIl(jSONObject.getString("recognizerId"), lliililiil), new lIIllIIlIl(jSONObject.getLong("successfulScans"), jSONObject.getLong("unsuccessfulScans"), jSONObject.getLong("uncertainScans"))));
        }
        return arrayList;
    }

    private static JSONArray llIIlIlIIl(IlIlIlllIl ilIlIlllIl) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : ilIlIlllIl.llIIlIlIIl().entrySet()) {
            IllIIlllIl illIIlllIl = (IllIIlllIl) next.getKey();
            lIIllIIlIl liilliilil = (lIIllIIlIl) next.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("recognizerId", illIIlllIl.IlIllIlIIl());
            IllIIlllIl.llIIlIlIIl llIIlIlIIl = illIIlllIl.llIIlIlIIl();
            if (llIIlIlIIl != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("country", llIIlIlIIl.llIIlIlIIl());
                jSONObject2.put("region", llIIlIlIIl.IlIllIlIIl());
                jSONObject2.put("type", llIIlIlIIl.IllIIIllII());
                jSONObject.put("classInfo", jSONObject2);
            }
            jSONObject.put("successfulScans", liilliilil.llIIlIlIIl());
            jSONObject.put("unsuccessfulScans", liilliilil.IllIIIllII());
            jSONObject.put("uncertainScans", liilliilil.IlIllIlIIl());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
