package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzbao;
import com.google.android.gms.internal.ads.zzvx;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzzc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class ResponseInfo {
    private final zzzc zzaec;
    private final List<AdapterResponseInfo> zzaed = new ArrayList();

    private ResponseInfo(zzzc zzzc) {
        this.zzaec = zzzc;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbb)).booleanValue()) {
            try {
                List<zzvx> adapterResponses = this.zzaec.getAdapterResponses();
                if (adapterResponses != null) {
                    for (zzvx zza : adapterResponses) {
                        this.zzaed.add(AdapterResponseInfo.zza(zza));
                    }
                }
            } catch (RemoteException e) {
                zzbao.zzc("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzaec.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbao.zzc("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public final String getResponseId() {
        try {
            return this.zzaec.getResponseId();
        } catch (RemoteException e) {
            zzbao.zzc("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    public final List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzaed;
    }

    public final JSONObject zzds() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzds : this.zzaed) {
            jSONArray.put(zzds.zzds());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        return jSONObject;
    }

    public final String toString() {
        try {
            return zzds().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public static ResponseInfo zza(zzzc zzzc) {
        if (zzzc != null) {
            return new ResponseInfo(zzzc);
        }
        return null;
    }
}
