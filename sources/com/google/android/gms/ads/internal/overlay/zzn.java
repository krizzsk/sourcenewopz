package com.google.android.gms.ads.internal.overlay;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzn implements Parcelable.Creator<AdOverlayInfoParcel> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r29) {
        /*
            r28 = this;
            r0 = r29
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r29)
            r2 = 0
            r3 = 0
            r5 = r3
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r12 = r10
            r13 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r23 = r22
            r24 = r23
            r25 = r24
            r26 = r25
            r27 = r26
            r11 = 0
            r14 = 0
            r15 = 0
        L_0x002b:
            int r2 = r29.dataPosition()
            if (r2 >= r1) goto L_0x00c8
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r29)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x00bd;
                case 3: goto L_0x00b7;
                case 4: goto L_0x00b1;
                case 5: goto L_0x00ab;
                case 6: goto L_0x00a6;
                case 7: goto L_0x00a1;
                case 8: goto L_0x009c;
                case 9: goto L_0x0097;
                case 10: goto L_0x0092;
                case 11: goto L_0x008d;
                case 12: goto L_0x0088;
                case 13: goto L_0x0083;
                case 14: goto L_0x0078;
                case 15: goto L_0x003c;
                case 16: goto L_0x0073;
                case 17: goto L_0x0068;
                case 18: goto L_0x0063;
                case 19: goto L_0x005e;
                case 20: goto L_0x0059;
                case 21: goto L_0x0054;
                case 22: goto L_0x004f;
                case 23: goto L_0x004a;
                case 24: goto L_0x0045;
                case 25: goto L_0x0040;
                default: goto L_0x003c;
            }
        L_0x003c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x002b
        L_0x0040:
            java.lang.String r27 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x0045:
            java.lang.String r26 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x004a:
            android.os.IBinder r25 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x004f:
            android.os.IBinder r24 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x0054:
            android.os.IBinder r23 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x0059:
            android.os.IBinder r22 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x005e:
            java.lang.String r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x0063:
            android.os.IBinder r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x0068:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.zzk> r3 = com.google.android.gms.ads.internal.zzk.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r19 = r2
            com.google.android.gms.ads.internal.zzk r19 = (com.google.android.gms.ads.internal.zzk) r19
            goto L_0x002b
        L_0x0073:
            java.lang.String r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x0078:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbar> r3 = com.google.android.gms.internal.ads.zzbar.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r17 = r2
            com.google.android.gms.internal.ads.zzbar r17 = (com.google.android.gms.internal.ads.zzbar) r17
            goto L_0x002b
        L_0x0083:
            java.lang.String r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x0088:
            int r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x002b
        L_0x008d:
            int r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x002b
        L_0x0092:
            android.os.IBinder r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x0097:
            java.lang.String r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x009c:
            boolean r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x002b
        L_0x00a1:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x002b
        L_0x00a6:
            android.os.IBinder r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x00ab:
            android.os.IBinder r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x00b1:
            android.os.IBinder r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x00b7:
            android.os.IBinder r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x002b
        L_0x00bd:
            android.os.Parcelable$Creator<com.google.android.gms.ads.internal.overlay.zzb> r3 = com.google.android.gms.ads.internal.overlay.zzb.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r5 = r2
            com.google.android.gms.ads.internal.overlay.zzb r5 = (com.google.android.gms.ads.internal.overlay.zzb) r5
            goto L_0x002b
        L_0x00c8:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzn.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
