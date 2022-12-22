package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzpv {
    private final int height;
    private final int width;
    public final List<byte[]> zzahq;
    public final int zzata;
    public final float zzbki;

    public static zzpv zzg(zzpn zzpn) throws zzhw {
        float f;
        int i;
        int i2;
        try {
            zzpn.zzbm(4);
            int readUnsignedByte = (zzpn.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzpn.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    arrayList.add(zzh(zzpn));
                }
                int readUnsignedByte3 = zzpn.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    arrayList.add(zzh(zzpn));
                }
                if (readUnsignedByte2 > 0) {
                    zzpl zzd = zzpm.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzd.width;
                    int i6 = zzd.height;
                    f = zzd.zzbki;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new zzpv(arrayList, readUnsignedByte, i2, i, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzhw("Error parsing AVC config", e);
        }
    }

    private zzpv(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzahq = list;
        this.zzata = i;
        this.width = i2;
        this.height = i3;
        this.zzbki = f;
    }

    private static byte[] zzh(zzpn zzpn) {
        int readUnsignedShort = zzpn.readUnsignedShort();
        int position = zzpn.getPosition();
        zzpn.zzbm(readUnsignedShort);
        return zzpf.zzc(zzpn.data, position, readUnsignedShort);
    }
}
