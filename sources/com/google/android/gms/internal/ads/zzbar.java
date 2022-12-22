package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzbar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbar> CREATOR = new zzbau();
    public String zzbrz;
    public int zzeka;
    public int zzekb;
    public boolean zzekc;
    public boolean zzekd;

    public zzbar(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzbar(int i, int i2, boolean z, boolean z2) {
        this(204890000, i2, true, false, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzbar(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x0005
            java.lang.String r11 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r11 = "1"
        L_0x0007:
            int r12 = r11.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            r0.append(r12)
            r0.append(r11)
            java.lang.String r2 = r0.toString()
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>((java.lang.String) r2, (int) r3, (int) r4, (boolean) r5, (boolean) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbar.<init>(int, int, boolean, boolean, boolean):void");
    }

    zzbar(String str, int i, int i2, boolean z, boolean z2) {
        this.zzbrz = str;
        this.zzeka = i;
        this.zzekb = i2;
        this.zzekc = z;
        this.zzekd = z2;
    }

    public static zzbar zzaau() {
        return new zzbar(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbrz, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzeka);
        SafeParcelWriter.writeInt(parcel, 4, this.zzekb);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzekc);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzekd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
