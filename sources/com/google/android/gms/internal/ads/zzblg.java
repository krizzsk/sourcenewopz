package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblg implements zzaml<zzblk> {
    private final Context context;
    private final PowerManager zzaaj;
    private final zzqt zzful;

    public zzblg(Context context2, zzqt zzqt) {
        this.context = context2;
        this.zzful = zzqt;
        this.zzaaj = (PowerManager) context2.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzi(zzblk zzblk) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzblk.zzfva == null) {
            jSONObject = new JSONObject();
        } else {
            zzqx zzqx = zzblk.zzfva;
            if (this.zzful.zzmb() != null) {
                boolean z2 = zzqx.zzbsf;
                JSONObject jSONObject3 = new JSONObject();
                JSONObject put = jSONObject3.put("afmaVersion", this.zzful.zzma()).put("activeViewJSON", this.zzful.zzmb()).put("timestamp", zzblk.timestamp).put("adFormat", this.zzful.zzlz()).put("hashCode", this.zzful.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzblk.zzfux).put("isNative", this.zzful.isNative());
                if (Build.VERSION.SDK_INT >= 20) {
                    z = this.zzaaj.isInteractive();
                } else {
                    z = this.zzaaj.isScreenOn();
                }
                put.put("isScreenOn", z).put("appMuted", zzr.zzla().zzrh()).put("appVolume", (double) zzr.zzla().zzrg()).put("deviceVolume", (double) zzae.zzbj(this.context.getApplicationContext()));
                Rect rect = new Rect();
                Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
                rect.right = defaultDisplay.getWidth();
                rect.bottom = defaultDisplay.getHeight();
                jSONObject3.put("windowVisibility", zzqx.zzaaq).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put("top", zzqx.zzbsg.top).put("bottom", zzqx.zzbsg.bottom).put("left", zzqx.zzbsg.left).put("right", zzqx.zzbsg.right)).put("adBox", new JSONObject().put("top", zzqx.zzbsh.top).put("bottom", zzqx.zzbsh.bottom).put("left", zzqx.zzbsh.left).put("right", zzqx.zzbsh.right)).put("globalVisibleBox", new JSONObject().put("top", zzqx.zzbsi.top).put("bottom", zzqx.zzbsi.bottom).put("left", zzqx.zzbsi.left).put("right", zzqx.zzbsi.right)).put("globalVisibleBoxVisible", zzqx.zzbsj).put("localVisibleBox", new JSONObject().put("top", zzqx.zzbsk.top).put("bottom", zzqx.zzbsk.bottom).put("left", zzqx.zzbsk.left).put("right", zzqx.zzbsk.right)).put("localVisibleBoxVisible", zzqx.zzbsl).put("hitBox", new JSONObject().put("top", zzqx.zzbsm.top).put("bottom", zzqx.zzbsm.bottom).put("left", zzqx.zzbsm.left).put("right", zzqx.zzbsm.right)).put("screenDensity", (double) this.context.getResources().getDisplayMetrics().density);
                jSONObject3.put("isVisible", zzblk.zzbrt);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcrj)).booleanValue()) {
                    JSONArray jSONArray2 = new JSONArray();
                    if (zzqx.zzbso != null) {
                        for (Rect next : zzqx.zzbso) {
                            jSONArray2.put(new JSONObject().put("top", next.top).put("bottom", next.bottom).put("left", next.left).put("right", next.right));
                        }
                    }
                    jSONObject3.put("scrollableContainerBoxes", jSONArray2);
                }
                if (!TextUtils.isEmpty(zzblk.zzfuz)) {
                    jSONObject3.put("doneReasonCode", "u");
                }
                jSONObject = jSONObject3;
            } else {
                throw new JSONException("Active view Info cannot be null.");
            }
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
