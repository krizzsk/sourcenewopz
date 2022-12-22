package com.google.android.gms.internal.ads;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzatt implements Parcelable.Creator<zzatq> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzatq[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v10, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r69) {
        /*
            r68 = this;
            r0 = r69
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r69)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r28 = r2
            r35 = r28
            r9 = r6
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r18 = r17
            r19 = r18
            r21 = r19
            r22 = r21
            r27 = r22
            r30 = r27
            r31 = r30
            r32 = r31
            r33 = r32
            r34 = r33
            r37 = r34
            r43 = r37
            r44 = r43
            r47 = r44
            r48 = r47
            r49 = r48
            r51 = r49
            r52 = r51
            r53 = r52
            r54 = r53
            r56 = r54
            r57 = r56
            r58 = r57
            r63 = r58
            r64 = r63
            r65 = r64
            r66 = r65
            r67 = r66
            r8 = 0
            r20 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r45 = 0
            r46 = 0
            r50 = 0
            r55 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
        L_0x0077:
            int r2 = r69.dataPosition()
            if (r2 >= r1) goto L_0x0201
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r69)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x01fb;
                case 2: goto L_0x01f5;
                case 3: goto L_0x01ea;
                case 4: goto L_0x01df;
                case 5: goto L_0x01d9;
                case 6: goto L_0x01ce;
                case 7: goto L_0x01c3;
                case 8: goto L_0x01bd;
                case 9: goto L_0x01b7;
                case 10: goto L_0x01b1;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019f;
                case 13: goto L_0x0199;
                case 14: goto L_0x0193;
                case 15: goto L_0x018d;
                case 16: goto L_0x0187;
                case 17: goto L_0x0088;
                case 18: goto L_0x0181;
                case 19: goto L_0x017b;
                case 20: goto L_0x0175;
                case 21: goto L_0x016f;
                case 22: goto L_0x0088;
                case 23: goto L_0x0088;
                case 24: goto L_0x0088;
                case 25: goto L_0x0169;
                case 26: goto L_0x0163;
                case 27: goto L_0x015d;
                case 28: goto L_0x0157;
                case 29: goto L_0x014b;
                case 30: goto L_0x0145;
                case 31: goto L_0x013f;
                case 32: goto L_0x0088;
                case 33: goto L_0x0139;
                case 34: goto L_0x0133;
                case 35: goto L_0x012d;
                case 36: goto L_0x0127;
                case 37: goto L_0x0121;
                case 38: goto L_0x0088;
                case 39: goto L_0x011b;
                case 40: goto L_0x0115;
                case 41: goto L_0x010f;
                case 42: goto L_0x0109;
                case 43: goto L_0x0103;
                case 44: goto L_0x00fd;
                case 45: goto L_0x00f7;
                case 46: goto L_0x00ec;
                case 47: goto L_0x00e7;
                case 48: goto L_0x00e2;
                case 49: goto L_0x00dd;
                case 50: goto L_0x00d8;
                case 51: goto L_0x00d3;
                case 52: goto L_0x00ce;
                case 53: goto L_0x00c9;
                case 54: goto L_0x00c4;
                case 55: goto L_0x00bf;
                case 56: goto L_0x00ba;
                case 57: goto L_0x00b5;
                case 58: goto L_0x00b0;
                case 59: goto L_0x00ab;
                case 60: goto L_0x00a6;
                case 61: goto L_0x00a1;
                case 62: goto L_0x0088;
                case 63: goto L_0x0096;
                case 64: goto L_0x0091;
                case 65: goto L_0x008c;
                default: goto L_0x0088;
            }
        L_0x0088:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0077
        L_0x008c:
            android.os.Bundle r67 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0077
        L_0x0091:
            java.lang.String r66 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x0096:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzajy> r3 = com.google.android.gms.internal.ads.zzajy.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r65 = r2
            com.google.android.gms.internal.ads.zzajy r65 = (com.google.android.gms.internal.ads.zzajy) r65
            goto L_0x0077
        L_0x00a1:
            java.lang.String r64 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x00a6:
            java.util.ArrayList r63 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0077
        L_0x00ab:
            boolean r62 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x00b0:
            boolean r61 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x00b5:
            boolean r60 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x00ba:
            int r59 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x00bf:
            java.util.ArrayList r58 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0077
        L_0x00c4:
            java.lang.String r57 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x00c9:
            java.util.ArrayList r56 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntegerList(r0, r2)
            goto L_0x0077
        L_0x00ce:
            boolean r55 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x00d3:
            java.lang.String r54 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x00d8:
            java.lang.String r53 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x00dd:
            java.lang.String r52 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x00e2:
            android.os.Bundle r51 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0077
        L_0x00e7:
            boolean r50 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x00ec:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzzj> r3 = com.google.android.gms.internal.ads.zzzj.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r49 = r2
            com.google.android.gms.internal.ads.zzzj r49 = (com.google.android.gms.internal.ads.zzzj) r49
            goto L_0x0077
        L_0x00f7:
            java.lang.String r48 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x00fd:
            android.os.Bundle r47 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0077
        L_0x0103:
            int r46 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x0109:
            boolean r45 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x010f:
            java.lang.String r44 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x0115:
            boolean r39 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x011b:
            java.lang.String r43 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x0121:
            boolean r42 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x0127:
            int r41 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x012d:
            int r40 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x0133:
            float r38 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x0077
        L_0x0139:
            java.lang.String r37 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x013f:
            long r35 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0077
        L_0x0145:
            java.util.ArrayList r34 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0077
        L_0x014b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaei> r3 = com.google.android.gms.internal.ads.zzaei.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r33 = r2
            com.google.android.gms.internal.ads.zzaei r33 = (com.google.android.gms.internal.ads.zzaei) r33
            goto L_0x0077
        L_0x0157:
            java.lang.String r32 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x015d:
            java.util.ArrayList r31 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0077
        L_0x0163:
            java.lang.String r30 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x0169:
            long r28 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0077
        L_0x016f:
            java.lang.String r27 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x0175:
            float r26 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x0077
        L_0x017b:
            int r25 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x0181:
            int r24 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x0187:
            boolean r23 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0077
        L_0x018d:
            android.os.Bundle r22 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0077
        L_0x0193:
            java.util.ArrayList r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x0077
        L_0x0199:
            int r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x019f:
            android.os.Bundle r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0077
        L_0x01a5:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzbar> r3 = com.google.android.gms.internal.ads.zzbar.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r18 = r2
            com.google.android.gms.internal.ads.zzbar r18 = (com.google.android.gms.internal.ads.zzbar) r18
            goto L_0x0077
        L_0x01b1:
            java.lang.String r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x01b7:
            java.lang.String r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x01bd:
            java.lang.String r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x01c3:
            android.os.Parcelable$Creator r3 = android.content.pm.PackageInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            android.content.pm.PackageInfo r14 = (android.content.pm.PackageInfo) r14
            goto L_0x0077
        L_0x01ce:
            android.os.Parcelable$Creator r3 = android.content.pm.ApplicationInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r13 = r2
            android.content.pm.ApplicationInfo r13 = (android.content.pm.ApplicationInfo) r13
            goto L_0x0077
        L_0x01d9:
            java.lang.String r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0077
        L_0x01df:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvt> r3 = com.google.android.gms.internal.ads.zzvt.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r11 = r2
            com.google.android.gms.internal.ads.zzvt r11 = (com.google.android.gms.internal.ads.zzvt) r11
            goto L_0x0077
        L_0x01ea:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzvq> r3 = com.google.android.gms.internal.ads.zzvq.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r10 = r2
            com.google.android.gms.internal.ads.zzvq r10 = (com.google.android.gms.internal.ads.zzvq) r10
            goto L_0x0077
        L_0x01f5:
            android.os.Bundle r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x0077
        L_0x01fb:
            int r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0077
        L_0x0201:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.internal.ads.zzatq r0 = new com.google.android.gms.internal.ads.zzatq
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatt.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
