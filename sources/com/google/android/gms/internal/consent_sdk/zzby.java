package com.google.android.gms.internal.consent_sdk;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public final class zzby {
    public int zza = zzbu.zzg;
    public String zzb;
    public String zzc;
    public String zzd;
    public List<String> zze = Collections.emptyList();
    public List<zzbx> zzf = Collections.emptyList();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.consent_sdk.zzby zza(android.util.JsonReader r10) throws java.io.IOException {
        /*
            com.google.android.gms.internal.consent_sdk.zzby r0 = new com.google.android.gms.internal.consent_sdk.zzby
            r0.<init>()
            r10.beginObject()
        L_0x0008:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x0117
            java.lang.String r1 = r10.nextName()
            int r2 = r1.hashCode()
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = -1
            r9 = 1
            switch(r2) {
                case -2001388947: goto L_0x0053;
                case -1938755376: goto L_0x0049;
                case -1851537225: goto L_0x003f;
                case -1161803523: goto L_0x0035;
                case -986806987: goto L_0x002b;
                case -790907624: goto L_0x0021;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x005d
        L_0x0021:
            java.lang.String r2 = "consent_form_payload"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = 1
            goto L_0x005e
        L_0x002b:
            java.lang.String r2 = "request_info_keys"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = 4
            goto L_0x005e
        L_0x0035:
            java.lang.String r2 = "actions"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = 5
            goto L_0x005e
        L_0x003f:
            java.lang.String r2 = "consent_form_base_url"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = 2
            goto L_0x005e
        L_0x0049:
            java.lang.String r2 = "error_message"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = 3
            goto L_0x005e
        L_0x0053:
            java.lang.String r2 = "consent_signal"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005d
            r1 = 0
            goto L_0x005e
        L_0x005d:
            r1 = -1
        L_0x005e:
            if (r1 == 0) goto L_0x010f
            if (r1 == r9) goto L_0x0107
            if (r1 == r7) goto L_0x00ff
            if (r1 == r6) goto L_0x00f7
            if (r1 == r5) goto L_0x00d8
            if (r1 == r4) goto L_0x006e
            r10.skipValue()
            goto L_0x0008
        L_0x006e:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.zzf = r1
            r10.beginArray()
        L_0x0078:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00d3
            com.google.android.gms.internal.consent_sdk.zzbx r1 = new com.google.android.gms.internal.consent_sdk.zzbx
            r1.<init>()
            r10.beginObject()
        L_0x0086:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00ca
            java.lang.String r2 = r10.nextName()
            int r4 = r2.hashCode()
            r5 = -2105551094(0xffffffff827fd70a, float:-1.8796154E-37)
            if (r4 == r5) goto L_0x00a9
            r5 = 1583758243(0x5e663ba3, float:4.14750822E18)
            if (r4 == r5) goto L_0x009f
            goto L_0x00b3
        L_0x009f:
            java.lang.String r4 = "action_type"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00b3
            r2 = 0
            goto L_0x00b4
        L_0x00a9:
            java.lang.String r4 = "args_json"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00b3
            r2 = 1
            goto L_0x00b4
        L_0x00b3:
            r2 = -1
        L_0x00b4:
            if (r2 == 0) goto L_0x00c3
            if (r2 == r9) goto L_0x00bc
            r10.skipValue()
            goto L_0x0086
        L_0x00bc:
            java.lang.String r2 = r10.nextString()
            r1.zzb = r2
            goto L_0x0086
        L_0x00c3:
            int r2 = com.google.android.gms.internal.consent_sdk.zzbu.zza(r10)
            r1.zza = r2
            goto L_0x0086
        L_0x00ca:
            r10.endObject()
            java.util.List<com.google.android.gms.internal.consent_sdk.zzbx> r2 = r0.zzf
            r2.add(r1)
            goto L_0x0078
        L_0x00d3:
            r10.endArray()
            goto L_0x0008
        L_0x00d8:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.zze = r1
            r10.beginArray()
        L_0x00e2:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x00f2
            java.lang.String r1 = r10.nextString()
            java.util.List<java.lang.String> r2 = r0.zze
            r2.add(r1)
            goto L_0x00e2
        L_0x00f2:
            r10.endArray()
            goto L_0x0008
        L_0x00f7:
            java.lang.String r1 = r10.nextString()
            r0.zzd = r1
            goto L_0x0008
        L_0x00ff:
            java.lang.String r1 = r10.nextString()
            r0.zzc = r1
            goto L_0x0008
        L_0x0107:
            java.lang.String r1 = r10.nextString()
            r0.zzb = r1
            goto L_0x0008
        L_0x010f:
            int r1 = com.google.android.gms.internal.consent_sdk.zzbu.zzb(r10)
            r0.zza = r1
            goto L_0x0008
        L_0x0117:
            r10.endObject()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzby.zza(android.util.JsonReader):com.google.android.gms.internal.consent_sdk.zzby");
    }
}
