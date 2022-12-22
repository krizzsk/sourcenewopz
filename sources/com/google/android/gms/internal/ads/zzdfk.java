package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdfk implements zzdhe<zzdfh> {
    private final PackageInfo zzdvo;
    private final zzf zzecl;
    private final zzdpm zzfzg;
    private final zzebs zzgka;

    public zzdfk(zzebs zzebs, zzdpm zzdpm, PackageInfo packageInfo, zzf zzf) {
        this.zzgka = zzebs;
        this.zzfzg = zzdpm;
        this.zzdvo = packageInfo;
        this.zzecl = zzf;
    }

    public final zzebt<zzdfh> zzatu() {
        return this.zzgka.zze(new zzdfj(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fc, code lost:
        if (r9 == 3) goto L_0x0123;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.String r0 = "native_version"
            r1 = 3
            r10.putInt(r0, r1)
            java.lang.String r0 = "native_templates"
            r10.putStringArrayList(r0, r9)
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            java.util.ArrayList<java.lang.String> r9 = r9.zzhoa
            java.lang.String r0 = "native_custom_templates"
            r10.putStringArrayList(r0, r9)
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzabq.zzctw
            com.google.android.gms.internal.ads.zzabm r0 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r9 = r0.zzd(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.String r0 = "landscape"
            java.lang.String r2 = "portrait"
            java.lang.String r3 = "any"
            java.lang.String r4 = "unknown"
            r5 = 2
            r6 = 1
            if (r9 == 0) goto L_0x0063
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzaei r9 = r9.zzdpr
            int r9 = r9.versionCode
            if (r9 <= r1) goto L_0x0063
            java.lang.String r9 = "enable_native_media_orientation"
            r10.putBoolean(r9, r6)
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzaei r9 = r9.zzdpr
            int r9 = r9.zzbod
            if (r9 == r6) goto L_0x0057
            if (r9 == r5) goto L_0x0055
            if (r9 == r1) goto L_0x0053
            r7 = 4
            if (r9 == r7) goto L_0x004f
            r9 = r4
            goto L_0x0058
        L_0x004f:
            java.lang.String r9 = "square"
            goto L_0x0058
        L_0x0053:
            r9 = r2
            goto L_0x0058
        L_0x0055:
            r9 = r0
            goto L_0x0058
        L_0x0057:
            r9 = r3
        L_0x0058:
            boolean r7 = r4.equals(r9)
            if (r7 != 0) goto L_0x0063
            java.lang.String r7 = "native_media_orientation"
            r10.putString(r7, r9)
        L_0x0063:
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzaei r9 = r9.zzdpr
            int r9 = r9.zzboc
            if (r9 == 0) goto L_0x0073
            if (r9 == r6) goto L_0x0071
            if (r9 == r5) goto L_0x0074
            r0 = r4
            goto L_0x0074
        L_0x0071:
            r0 = r2
            goto L_0x0074
        L_0x0073:
            r0 = r3
        L_0x0074:
            boolean r9 = r4.equals(r0)
            if (r9 != 0) goto L_0x007f
            java.lang.String r9 = "native_image_orientation"
            r10.putString(r9, r0)
        L_0x007f:
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzaei r9 = r9.zzdpr
            boolean r9 = r9.zzboe
            java.lang.String r0 = "native_multiple_images"
            r10.putBoolean(r0, r9)
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzaei r9 = r9.zzdpr
            boolean r9 = r9.zzboh
            java.lang.String r0 = "use_custom_mute"
            r10.putBoolean(r0, r9)
            android.content.pm.PackageInfo r9 = r8.zzdvo
            if (r9 != 0) goto L_0x009c
            r9 = 0
            goto L_0x009e
        L_0x009c:
            int r9 = r9.versionCode
        L_0x009e:
            com.google.android.gms.ads.internal.util.zzf r0 = r8.zzecl
            int r0 = r0.zzzf()
            if (r9 <= r0) goto L_0x00b0
            com.google.android.gms.ads.internal.util.zzf r0 = r8.zzecl
            r0.zzzl()
            com.google.android.gms.ads.internal.util.zzf r0 = r8.zzecl
            r0.zzdi(r9)
        L_0x00b0:
            com.google.android.gms.ads.internal.util.zzf r9 = r8.zzecl
            org.json.JSONObject r9 = r9.zzzk()
            if (r9 == 0) goto L_0x00c7
            com.google.android.gms.internal.ads.zzdpm r0 = r8.zzfzg
            java.lang.String r0 = r0.zzhny
            org.json.JSONArray r9 = r9.optJSONArray(r0)
            if (r9 == 0) goto L_0x00c7
            java.lang.String r9 = r9.toString()
            goto L_0x00c8
        L_0x00c7:
            r9 = 0
        L_0x00c8:
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L_0x00d3
            java.lang.String r0 = "native_advanced_settings"
            r10.putString(r0, r9)
        L_0x00d3:
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            int r9 = r9.zzhby
            if (r9 <= r6) goto L_0x00e2
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            int r9 = r9.zzhby
            java.lang.String r0 = "max_num_ads"
            r10.putInt(r0, r9)
        L_0x00e2:
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzajy r9 = r9.zzdxd
            if (r9 == 0) goto L_0x0135
            java.lang.String r0 = r9.zzdkh
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0129
            int r0 = r9.versionCode
            java.lang.String r2 = "p"
            java.lang.String r3 = "l"
            if (r0 < r5) goto L_0x00ff
            int r9 = r9.zzbod
            if (r9 == r5) goto L_0x0122
            if (r9 == r1) goto L_0x0123
            goto L_0x0122
        L_0x00ff:
            int r0 = r9.zzdkg
            if (r0 == r6) goto L_0x0122
            if (r0 == r5) goto L_0x0123
            int r9 = r9.zzdkg
            r0 = 52
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Instream ad video aspect ratio "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r9 = " is wrong."
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            com.google.android.gms.internal.ads.zzbao.zzex(r9)
        L_0x0122:
            r2 = r3
        L_0x0123:
            java.lang.String r9 = "ia_var"
            r10.putString(r9, r2)
            goto L_0x0130
        L_0x0129:
            java.lang.String r9 = r9.zzdkh
            java.lang.String r0 = "ad_tag"
            r10.putString(r0, r9)
        L_0x0130:
            java.lang.String r9 = "instr"
            r10.putBoolean(r9, r6)
        L_0x0135:
            com.google.android.gms.internal.ads.zzdpm r9 = r8.zzfzg
            com.google.android.gms.internal.ads.zzagm r9 = r9.zzawb()
            if (r9 == 0) goto L_0x0142
            java.lang.String r9 = "has_delayed_banner_listener"
            r10.putBoolean(r9, r6)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdfk.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfh zzauh() throws Exception {
        ArrayList<String> arrayList = this.zzfzg.zzhnz;
        if (arrayList == null) {
            return zzdfm.zzhfg;
        }
        if (arrayList.isEmpty()) {
            return zzdfl.zzhfg;
        }
        return new zzdfo(this, arrayList);
    }
}
