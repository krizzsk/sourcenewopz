package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzha {
    static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) throws zzew {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                cArr[i] = (char) (((b & Ascii.f53593SI) << Ascii.f53586FF) | ((b2 & Utf8.REPLACEMENT_BYTE) << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzew.zzb();
    }

    static /* synthetic */ boolean zzd(byte b) {
        return b >= 0;
    }

    private static boolean zze(byte b) {
        return b > -65;
    }

    static /* synthetic */ void zza(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws zzew {
        if (zze(b2) || (((b << Ascii.f53587FS) + (b2 + 112)) >> 30) != 0 || zze(b3) || zze(b4)) {
            throw zzew.zzb();
        }
        byte b5 = ((b & 7) << Ascii.DC2) | ((b2 & Utf8.REPLACEMENT_BYTE) << Ascii.f53586FF) | ((b3 & Utf8.REPLACEMENT_BYTE) << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
        cArr[i] = (char) ((b5 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((b5 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) throws zzew {
        if (b < -62 || zze(b2)) {
            throw zzew.zzb();
        }
        cArr[i] = (char) (((b & Ascii.f53596US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }
}
