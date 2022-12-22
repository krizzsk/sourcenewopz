package com.google.android.gms.internal.consent_sdk;

import android.util.JsonWriter;
import java.io.IOException;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzbu {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 1;
    public static final int zze = 2;
    public static final int zzf = 3;
    public static final int zzg = 1;
    public static final int zzh = 2;
    public static final int zzi = 3;
    public static final int zzj = 4;
    public static final int zzk = 5;
    public static final int zzl = 6;
    public static final int zzm = 7;
    public static final int zzn = 8;
    private static final /* synthetic */ int[] zzo = {1, 2, 3};
    private static final /* synthetic */ int[] zzp = {1, 2, 3};
    private static final /* synthetic */ int[] zzq = {1, 2, 3, 4, 5, 6, 7, 8};

    public static int[] zza() {
        return (int[]) zzo.clone();
    }

    public static void zza(int i, JsonWriter jsonWriter) throws IOException {
        if (i != 0) {
            int i2 = zzbq.zza[i - 1];
            if (i2 == 1) {
                jsonWriter.value("UNKNOWN");
            } else if (i2 == 2) {
                jsonWriter.value("ANDROID");
            } else if (i2 == 3) {
                jsonWriter.value("IOS");
            }
        } else {
            throw null;
        }
    }

    public static int[] zzb() {
        return (int[]) zzp.clone();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.util.JsonReader r4) throws java.io.IOException {
        /*
            java.lang.String r4 = r4.nextString()
            int r0 = r4.hashCode()
            r1 = 64208429(0x3d3be2d, float:1.2445128E-36)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002e
            r1 = 82862015(0x4f05fbf, float:5.6511658E-36)
            if (r0 == r1) goto L_0x0024
            r1 = 1856333582(0x6ea5670e, float:2.5594806E28)
            if (r0 == r1) goto L_0x001a
            goto L_0x0038
        L_0x001a:
            java.lang.String r0 = "UNKNOWN_ACTION_TYPE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0024:
            java.lang.String r0 = "WRITE"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x002e:
            java.lang.String r0 = "CLEAR"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0038
            r0 = 2
            goto L_0x0039
        L_0x0038:
            r0 = -1
        L_0x0039:
            if (r0 == 0) goto L_0x0061
            if (r0 == r3) goto L_0x005e
            if (r0 == r2) goto L_0x005b
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.Action.ActionTypefrom: "
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r2 = r4.length()
            if (r2 == 0) goto L_0x0052
            java.lang.String r4 = r1.concat(r4)
            goto L_0x0057
        L_0x0052:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1)
        L_0x0057:
            r0.<init>(r4)
            throw r0
        L_0x005b:
            int r4 = zzf
            return r4
        L_0x005e:
            int r4 = zze
            return r4
        L_0x0061:
            int r4 = zzd
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbu.zza(android.util.JsonReader):int");
    }

    public static int[] zzc() {
        return (int[]) zzq.clone();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(android.util.JsonReader r3) throws java.io.IOException {
        /*
            java.lang.String r3 = r3.nextString()
            int r0 = r3.hashCode()
            switch(r0) {
                case -2058725357: goto L_0x0052;
                case -1969035850: goto L_0x0048;
                case -1263695752: goto L_0x003e;
                case -954325659: goto L_0x0034;
                case -918677260: goto L_0x002a;
                case 429411856: goto L_0x0020;
                case 467888915: goto L_0x0016;
                case 1725474845: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x005c
        L_0x000c:
            java.lang.String r0 = "CONSENT_SIGNAL_NOT_REQUIRED"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 5
            goto L_0x005d
        L_0x0016:
            java.lang.String r0 = "CONSENT_SIGNAL_PERSONALIZED_ADS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 1
            goto L_0x005d
        L_0x0020:
            java.lang.String r0 = "CONSENT_SIGNAL_SUFFICIENT"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 3
            goto L_0x005d
        L_0x002a:
            java.lang.String r0 = "CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 7
            goto L_0x005d
        L_0x0034:
            java.lang.String r0 = "CONSENT_SIGNAL_NON_PERSONALIZED_ADS"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 2
            goto L_0x005d
        L_0x003e:
            java.lang.String r0 = "CONSENT_SIGNAL_UNKNOWN"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 0
            goto L_0x005d
        L_0x0048:
            java.lang.String r0 = "CONSENT_SIGNAL_ERROR"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 6
            goto L_0x005d
        L_0x0052:
            java.lang.String r0 = "CONSENT_SIGNAL_COLLECT_CONSENT"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x005c
            r0 = 4
            goto L_0x005d
        L_0x005c:
            r0 = -1
        L_0x005d:
            switch(r0) {
                case 0: goto L_0x0088;
                case 1: goto L_0x0085;
                case 2: goto L_0x0082;
                case 3: goto L_0x007f;
                case 4: goto L_0x007c;
                case 5: goto L_0x0079;
                case 6: goto L_0x0076;
                case 7: goto L_0x0073;
                default: goto L_0x0060;
            }
        L_0x0060:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.ConsentSignalfrom: "
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r2 = r3.length()
            if (r2 == 0) goto L_0x008b
            java.lang.String r3 = r1.concat(r3)
            goto L_0x0090
        L_0x0073:
            int r3 = zzn
            return r3
        L_0x0076:
            int r3 = zzm
            return r3
        L_0x0079:
            int r3 = zzl
            return r3
        L_0x007c:
            int r3 = zzk
            return r3
        L_0x007f:
            int r3 = zzj
            return r3
        L_0x0082:
            int r3 = zzi
            return r3
        L_0x0085:
            int r3 = zzh
            return r3
        L_0x0088:
            int r3 = zzg
            return r3
        L_0x008b:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1)
        L_0x0090:
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzbu.zzb(android.util.JsonReader):int");
    }
}
