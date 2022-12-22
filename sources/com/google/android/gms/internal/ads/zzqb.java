package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzqb {
    public final List<byte[]> zzahq;
    public final int zzata;

    public static zzqb zzi(zzpn zzpn) throws zzhw {
        List list;
        try {
            zzpn.zzbm(21);
            int readUnsignedByte = zzpn.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzpn.readUnsignedByte();
            int position = zzpn.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                zzpn.zzbm(1);
                int readUnsignedShort = zzpn.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = zzpn.readUnsignedShort();
                    i += readUnsignedShort2 + 4;
                    zzpn.zzbm(readUnsignedShort2);
                }
            }
            zzpn.zzbl(position);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                zzpn.zzbm(1);
                int readUnsignedShort3 = zzpn.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                    int readUnsignedShort4 = zzpn.readUnsignedShort();
                    System.arraycopy(zzpm.zzbkd, 0, bArr, i4, zzpm.zzbkd.length);
                    int length = i4 + zzpm.zzbkd.length;
                    System.arraycopy(zzpn.data, zzpn.getPosition(), bArr, length, readUnsignedShort4);
                    i4 = length + readUnsignedShort4;
                    zzpn.zzbm(readUnsignedShort4);
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzqb(list, readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhw("Error parsing HEVC config", e);
        }
    }

    private zzqb(List<byte[]> list, int i) {
        this.zzahq = list;
        this.zzata = i;
    }
}
