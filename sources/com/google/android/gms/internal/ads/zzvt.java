package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzvt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvt> CREATOR = new zzvw();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzadd;
    public boolean zzadh;
    public final boolean zzbsb;
    public final boolean zzcir;
    public final zzvt[] zzcis;
    public final boolean zzcit;
    public boolean zzciu;
    public boolean zzciv;
    private boolean zzciw;
    public boolean zzcix;
    public boolean zzciy;

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzvt zzqk() {
        return new zzvt("320x50_mb", 0, 0, false, 0, 0, (zzvt[]) null, true, false, false, false, false, false, false, false);
    }

    public static zzvt zzql() {
        return new zzvt("reward_mb", 0, 0, true, 0, 0, (zzvt[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzvt zzqm() {
        return new zzvt("interstitial_mb", 0, 0, false, 0, 0, (zzvt[]) null, false, false, false, false, true, false, false, false);
    }

    public zzvt() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzvt[]) null, false, false, false, false, false, false, false, false);
    }

    public static zzvt zzqn() {
        return new zzvt("invalid", 0, 0, false, 0, 0, (zzvt[]) null, false, false, false, true, false, false, false, false);
    }

    public zzvt(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzvt(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.zzcir = r0
            boolean r2 = r1.isFluid()
            r12.zzcit = r2
            boolean r2 = com.google.android.gms.ads.zza.zzc(r1)
            r12.zzcix = r2
            boolean r2 = com.google.android.gms.ads.zza.zzd(r1)
            r12.zzciy = r2
            boolean r2 = com.google.android.gms.ads.zza.zza(r1)
            r12.zzadh = r2
            boolean r3 = r12.zzcit
            if (r3 == 0) goto L_0x0035
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r12.width = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
            r12.height = r2
            goto L_0x0061
        L_0x0035:
            boolean r3 = r12.zzciy
            if (r3 == 0) goto L_0x0046
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = com.google.android.gms.ads.zza.zze(r1)
            r12.height = r2
            goto L_0x0061
        L_0x0046:
            if (r2 == 0) goto L_0x0055
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = com.google.android.gms.ads.zza.zzb(r1)
            r12.height = r2
            goto L_0x0061
        L_0x0055:
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = r1.getHeight()
            r12.height = r2
        L_0x0061:
            int r2 = r12.width
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0069
            r2 = 1
            goto L_0x006a
        L_0x0069:
            r2 = 0
        L_0x006a:
            int r3 = r12.height
            r5 = -2
            if (r3 != r5) goto L_0x0071
            r3 = 1
            goto L_0x0072
        L_0x0071:
            r3 = 0
        L_0x0072:
            android.content.res.Resources r5 = r13.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r2 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzww.zzqw()
            boolean r6 = com.google.android.gms.internal.ads.zzbae.zzbs(r13)
            if (r6 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzww.zzqw()
            boolean r6 = com.google.android.gms.internal.ads.zzbae.zzbt(r13)
            if (r6 == 0) goto L_0x009b
            int r6 = r5.widthPixels
            com.google.android.gms.internal.ads.zzww.zzqw()
            int r7 = com.google.android.gms.internal.ads.zzbae.zzbu(r13)
            int r6 = r6 - r7
            r12.widthPixels = r6
            goto L_0x009f
        L_0x009b:
            int r6 = r5.widthPixels
            r12.widthPixels = r6
        L_0x009f:
            int r6 = r12.widthPixels
            float r6 = (float) r6
            float r7 = r5.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x00c2
            int r8 = r8 + 1
            goto L_0x00c2
        L_0x00b5:
            int r8 = r12.width
            com.google.android.gms.internal.ads.zzww.zzqw()
            int r6 = r12.width
            int r6 = com.google.android.gms.internal.ads.zzbae.zza((android.util.DisplayMetrics) r5, (int) r6)
            r12.widthPixels = r6
        L_0x00c2:
            if (r3 == 0) goto L_0x00c9
            int r6 = zzd(r5)
            goto L_0x00cb
        L_0x00c9:
            int r6 = r12.height
        L_0x00cb:
            com.google.android.gms.internal.ads.zzww.zzqw()
            int r5 = com.google.android.gms.internal.ads.zzbae.zza((android.util.DisplayMetrics) r5, (int) r6)
            r12.heightPixels = r5
            java.lang.String r5 = "_as"
            java.lang.String r7 = "x"
            r9 = 26
            if (r2 != 0) goto L_0x0114
            if (r3 == 0) goto L_0x00df
            goto L_0x0114
        L_0x00df:
            boolean r2 = r12.zzciy
            if (r2 != 0) goto L_0x00f8
            boolean r2 = r12.zzadh
            if (r2 == 0) goto L_0x00e8
            goto L_0x00f8
        L_0x00e8:
            boolean r2 = r12.zzcit
            if (r2 == 0) goto L_0x00f1
            java.lang.String r1 = "320x50_mb"
            r12.zzadd = r1
            goto L_0x012b
        L_0x00f1:
            java.lang.String r1 = r1.toString()
            r12.zzadd = r1
            goto L_0x012b
        L_0x00f8:
            int r1 = r12.width
            int r2 = r12.height
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r9)
            r3.append(r1)
            r3.append(r7)
            r3.append(r2)
            r3.append(r5)
            java.lang.String r1 = r3.toString()
            r12.zzadd = r1
            goto L_0x012b
        L_0x0114:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            r1.append(r8)
            r1.append(r7)
            r1.append(r6)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r12.zzadd = r1
        L_0x012b:
            int r1 = r14.length
            if (r1 <= r4) goto L_0x0145
            int r1 = r14.length
            com.google.android.gms.internal.ads.zzvt[] r1 = new com.google.android.gms.internal.ads.zzvt[r1]
            r12.zzcis = r1
            r1 = 0
        L_0x0134:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x0148
            com.google.android.gms.internal.ads.zzvt[] r2 = r12.zzcis
            com.google.android.gms.internal.ads.zzvt r3 = new com.google.android.gms.internal.ads.zzvt
            r4 = r14[r1]
            r3.<init>((android.content.Context) r13, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0134
        L_0x0145:
            r13 = 0
            r12.zzcis = r13
        L_0x0148:
            r12.zzbsb = r0
            r12.zzciu = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvt.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    zzvt(String str, int i, int i2, boolean z, int i3, int i4, zzvt[] zzvtArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.zzadd = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzcir = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzcis = zzvtArr;
        this.zzbsb = z2;
        this.zzcit = z3;
        this.zzciu = z4;
        this.zzciv = z5;
        this.zzciw = z6;
        this.zzcix = z7;
        this.zzciy = z8;
        this.zzadh = z9;
    }

    public final AdSize zzqo() {
        return zza.zza(this.width, this.height, this.zzadd);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzadd, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcir);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzcis, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbsb);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzcit);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzciu);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzciv);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzciw);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzcix);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzciy);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzadh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
