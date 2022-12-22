package com.google.android.gms.ads;

import android.os.IBinder;
import com.google.android.gms.internal.ads.zzvh;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int code;
    private final String zzacu;
    private final String zzacv;
    private final AdError zzacw;

    public AdError(int i, String str, String str2) {
        this.code = i;
        this.zzacu = str;
        this.zzacv = str2;
        this.zzacw = null;
    }

    public AdError(int i, String str, String str2, AdError adError) {
        this.code = i;
        this.zzacu = str;
        this.zzacv = str2;
        this.zzacw = adError;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.zzacu;
    }

    public String getDomain() {
        return this.zzacv;
    }

    public AdError getCause() {
        return this.zzacw;
    }

    public final zzvh zzdr() {
        zzvh zzvh;
        AdError adError = this.zzacw;
        if (adError == null) {
            zzvh = null;
        } else {
            zzvh = new zzvh(adError.code, adError.zzacu, adError.zzacv, (zzvh) null, (IBinder) null);
        }
        return new zzvh(this.code, this.zzacu, this.zzacv, zzvh, (IBinder) null);
    }

    public JSONObject zzds() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.code);
        jSONObject.put("Message", this.zzacu);
        jSONObject.put("Domain", this.zzacv);
        AdError adError = this.zzacw;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzds());
        }
        return jSONObject;
    }

    public String toString() {
        try {
            return zzds().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }
}
