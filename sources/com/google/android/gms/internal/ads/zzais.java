package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzais implements zzaig<Object> {
    private final Object lock = new Object();
    private final Map<String, zzaiu> zzdjr = new HashMap();

    public final void zza(String str, zzaiu zzaiu) {
        synchronized (this.lock) {
            this.zzdjr.put(str, zzaiu);
        }
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2 = map.get("id");
        String str3 = map.get("fail");
        String str4 = map.get("fail_reason");
        String str5 = map.get("fail_stack");
        String str6 = map.get("result");
        if (TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.lock) {
            zzaiu remove = this.zzdjr.remove(str2);
            if (remove == null) {
                String valueOf2 = String.valueOf(str2);
                zzd.zzez(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 == null) {
                remove.zzc((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zzd.zzyz()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzd.zzed(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e) {
                    remove.onFailure(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzalf> zzebt<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbe zzbbe = new zzbbe();
        zzr.zzkv();
        String zzzr = zzj.zzzr();
        zza(zzzr, (zzaiu) new zzaiv(this, zzbbe));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzzr);
            jSONObject2.put("args", jSONObject);
            enginet.zzb(str, jSONObject2);
        } catch (Exception e) {
            zzbbe.setException(e);
        }
        return zzbbe;
    }
}
