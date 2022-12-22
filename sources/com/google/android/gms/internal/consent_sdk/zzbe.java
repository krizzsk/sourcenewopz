package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbe extends WebView {
    private final Handler zza;
    /* access modifiers changed from: private */
    public final zzbj zzb;
    /* access modifiers changed from: private */
    public boolean zzc = false;

    public zzbe(zzbh zzbh, Handler handler, zzbj zzbj) {
        super(zzbh);
        this.zza = handler;
        this.zzb = zzbj;
    }

    public final void zza(String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        this.zza.post(new zzbd(this, sb.toString()));
    }

    /* access modifiers changed from: private */
    public static boolean zza(String str) {
        return str != null && str.startsWith("consent://");
    }
}
