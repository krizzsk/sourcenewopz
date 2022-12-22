package com.google.android.gms.internal.consent_sdk;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final /* synthetic */ class zzg implements Runnable {
    private final String zza;
    private final String zzb;
    private final zzi[] zzc;

    zzg(String str, String str2, zzi[] zziArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zziArr;
    }

    public final void run() {
        JSONObject jSONObject;
        String str = this.zza;
        String str2 = this.zzb;
        zzi[] zziArr = this.zzc;
        if (TextUtils.isEmpty(str)) {
            SystemUtils.log(3, "UserMessagingPlatform", "Error on action: empty action name", (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzg", 5);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.isEmpty(str2)) {
            jSONObject = new JSONObject();
        } else {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 32 + String.valueOf(str2).length());
                sb.append("Action[");
                sb.append(lowerCase);
                sb.append("]: failed to parse args: ");
                sb.append(str2);
                SystemUtils.log(3, "UserMessagingPlatform", sb.toString(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzg", 14);
                return;
            }
        }
        String valueOf = String.valueOf(jSONObject);
        StringBuilder sb2 = new StringBuilder(String.valueOf(lowerCase).length() + 10 + String.valueOf(valueOf).length());
        sb2.append("Action[");
        sb2.append(lowerCase);
        sb2.append("]: ");
        sb2.append(valueOf);
        SystemUtils.log(3, "UserMessagingPlatform", sb2.toString(), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzg", 17);
        int length = zziArr.length;
        int i = 0;
        while (i < length) {
            zzi zzi = zziArr[i];
            FutureTask futureTask = new FutureTask(new zzf(zzi, lowerCase, jSONObject));
            zzi.zza().execute(futureTask);
            try {
                if (!((Boolean) futureTask.get()).booleanValue()) {
                    i++;
                } else {
                    return;
                }
            } catch (ExecutionException e) {
                StringBuilder sb3 = new StringBuilder(String.valueOf(lowerCase).length() + 24);
                sb3.append("Failed to run Action[");
                sb3.append(lowerCase);
                sb3.append("]: ");
                zzca.zza(sb3.toString(), e.getCause());
            } catch (InterruptedException e2) {
                StringBuilder sb4 = new StringBuilder(String.valueOf(lowerCase).length() + 33);
                sb4.append("Thread interrupted for Action[");
                sb4.append(lowerCase);
                sb4.append("]: ");
                zzca.zza(sb4.toString(), e2);
            }
        }
    }
}
