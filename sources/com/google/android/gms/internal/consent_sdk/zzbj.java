package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzbj implements zzi {
    private final Application zza;
    private final zzbh zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzaj zzf;
    private final zzat zzg;

    zzbj(Application application, zzbh zzbh, Handler handler, Executor executor, zze zze2, zzaj zzaj, zzat zzat) {
        this.zza = application;
        this.zzb = zzbh;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zze2;
        this.zzf = zzaj;
        this.zzg = zzat;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str, String str2) {
        this.zzg.zza(new zzk(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", new Object[]{Integer.valueOf(i), str2, str})));
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        String valueOf = String.valueOf(str);
        SystemUtils.log(3, "UserMessagingPlatform", valueOf.length() != 0 ? "Receive consent action: ".concat(valueOf) : new String("Receive consent action: "), (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzbj", 16);
        Uri parse = Uri.parse(str);
        this.zze.zza(parse.getQueryParameter("action"), parse.getQueryParameter("args"), this, this.zzf);
    }

    public final Executor zza() {
        Handler handler = this.zzc;
        handler.getClass();
        return zzbm.zza(handler);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(java.lang.String r13, org.json.JSONObject r14) {
        /*
            r12 = this;
            int r0 = r13.hashCode()
            r1 = -1
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1370505102: goto L_0x002b;
                case -278739366: goto L_0x0021;
                case 150940456: goto L_0x0017;
                case 1671672458: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0035
        L_0x000d:
            java.lang.String r0 = "dismiss"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0035
            r13 = 1
            goto L_0x0036
        L_0x0017:
            java.lang.String r0 = "browser"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0035
            r13 = 2
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "configure_app_assets"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0035
            r13 = 3
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "load_complete"
            boolean r13 = r13.equals(r0)
            if (r13 == 0) goto L_0x0035
            r13 = 0
            goto L_0x0036
        L_0x0035:
            r13 = -1
        L_0x0036:
            if (r13 == 0) goto L_0x0118
            if (r13 == r5) goto L_0x00b8
            if (r13 == r4) goto L_0x004a
            if (r13 == r3) goto L_0x003f
            return r2
        L_0x003f:
            java.util.concurrent.Executor r13 = r12.zzd
            com.google.android.gms.internal.consent_sdk.zzbl r14 = new com.google.android.gms.internal.consent_sdk.zzbl
            r14.<init>(r12)
            r13.execute(r14)
            return r5
        L_0x004a:
            java.lang.String r13 = "url"
            java.lang.String r13 = r14.optString(r13)
            boolean r14 = android.text.TextUtils.isEmpty(r13)
            if (r14 == 0) goto L_0x0063
            r6 = 3
            r9 = 0
            r11 = 47
            java.lang.String r7 = "UserMessagingPlatform"
            java.lang.String r8 = "Action[browser]: empty url."
            java.lang.String r10 = "com.google.android.gms.internal.consent_sdk.zzbj"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x0063:
            android.net.Uri r14 = android.net.Uri.parse(r13)
            java.lang.String r0 = r14.getScheme()
            if (r0 != 0) goto L_0x0090
            java.lang.String r0 = "Action[browser]: empty scheme: "
            java.lang.String r1 = java.lang.String.valueOf(r13)
            int r2 = r1.length()
            if (r2 == 0) goto L_0x007f
            java.lang.String r0 = r0.concat(r1)
            r8 = r0
            goto L_0x0085
        L_0x007f:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r8 = r1
        L_0x0085:
            r6 = 3
            r9 = 0
            r11 = 51
            java.lang.String r7 = "UserMessagingPlatform"
            java.lang.String r10 = "com.google.android.gms.internal.consent_sdk.zzbj"
            com.didi.sdk.apm.SystemUtils.log(r6, r7, r8, r9, r10, r11)
        L_0x0090:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x009d }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1, r14)     // Catch:{ ActivityNotFoundException -> 0x009d }
            com.google.android.gms.internal.consent_sdk.zzbh r14 = r12.zzb     // Catch:{ ActivityNotFoundException -> 0x009d }
            r14.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x009d }
            goto L_0x00b7
        L_0x009d:
            r14 = move-exception
            java.lang.String r0 = "Action[browser]: can not open url: "
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r1 = r13.length()
            if (r1 == 0) goto L_0x00af
            java.lang.String r13 = r0.concat(r13)
            goto L_0x00b4
        L_0x00af:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r0)
        L_0x00b4:
            com.google.android.gms.internal.consent_sdk.zzca.zza(r13, r14)
        L_0x00b7:
            return r5
        L_0x00b8:
            java.lang.String r13 = "status"
            java.lang.String r13 = r14.optString(r13)
            int r14 = r13.hashCode()
            r0 = 4
            switch(r14) {
                case -954325659: goto L_0x00ef;
                case -258041904: goto L_0x00e5;
                case 429411856: goto L_0x00db;
                case 467888915: goto L_0x00d1;
                case 1666911234: goto L_0x00c7;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            goto L_0x00f8
        L_0x00c7:
            java.lang.String r14 = "non_personalized"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00f8
            r1 = 2
            goto L_0x00f8
        L_0x00d1:
            java.lang.String r14 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00f8
            r1 = 1
            goto L_0x00f8
        L_0x00db:
            java.lang.String r14 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00f8
            r1 = 4
            goto L_0x00f8
        L_0x00e5:
            java.lang.String r14 = "personalized"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00f8
            r1 = 0
            goto L_0x00f8
        L_0x00ef:
            java.lang.String r14 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00f8
            r1 = 3
        L_0x00f8:
            if (r1 == 0) goto L_0x0111
            if (r1 == r5) goto L_0x0111
            if (r1 == r4) goto L_0x010f
            if (r1 == r3) goto L_0x010f
            if (r1 == r0) goto L_0x0112
            com.google.android.gms.internal.consent_sdk.zzat r13 = r12.zzg
            com.google.android.gms.internal.consent_sdk.zzk r14 = new com.google.android.gms.internal.consent_sdk.zzk
            java.lang.String r0 = "We are getting something wrong with the webview."
            r14.<init>(r5, r0)
            r13.zzb(r14)
            goto L_0x0117
        L_0x010f:
            r2 = 1
            goto L_0x0112
        L_0x0111:
            r2 = 2
        L_0x0112:
            com.google.android.gms.internal.consent_sdk.zzat r13 = r12.zzg
            r13.zza((int) r3, (int) r2)
        L_0x0117:
            return r5
        L_0x0118:
            com.google.android.gms.internal.consent_sdk.zzat r13 = r12.zzg
            r13.zzb()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbj.zza(java.lang.String, org.json.JSONObject):boolean");
    }

    private static JSONObject zza(Context context) {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString());
            Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
            if (applicationIcon == null) {
                str = null;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String valueOf = String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                str = valueOf.length() != 0 ? "data:image/png;base64,".concat(valueOf) : new String("data:image/png;base64,");
            }
            jSONObject.put("app_icon", str);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        this.zzg.zza().zza("UMP_configureFormWithAppAssets", zza((Context) this.zza));
    }
}
