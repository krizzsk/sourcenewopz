package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbt extends zzerl {
    private Date zzdd;
    private Date zzde;
    private long zzdf;
    private long zzdg;
    private double zzdh = 1.0d;
    private float zzdi = 1.0f;
    private zzerv zzdj = zzerv.zzjeu;
    private long zzdk;
    private int zzdl;
    private int zzdm;
    private int zzdn;
    private int zzdo;
    private int zzdp;
    private int zzdq;

    public zzbt() {
        super("mvhd");
    }

    public final long zzr() {
        return this.zzdf;
    }

    public final long getDuration() {
        return this.zzdg;
    }

    public final void zzl(ByteBuffer byteBuffer) {
        zzr(byteBuffer);
        if (getVersion() == 1) {
            this.zzdd = zzero.zzfv(zzbp.zzh(byteBuffer));
            this.zzde = zzero.zzfv(zzbp.zzh(byteBuffer));
            this.zzdf = zzbp.zzf(byteBuffer);
            this.zzdg = zzbp.zzh(byteBuffer);
        } else {
            this.zzdd = zzero.zzfv(zzbp.zzf(byteBuffer));
            this.zzde = zzero.zzfv(zzbp.zzf(byteBuffer));
            this.zzdf = zzbp.zzf(byteBuffer);
            this.zzdg = zzbp.zzf(byteBuffer);
        }
        this.zzdh = zzbp.zzi(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzdi = ((float) ((short) ((bArr[1] & 255) | ((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)))))) / 256.0f;
        zzbp.zzg(byteBuffer);
        zzbp.zzf(byteBuffer);
        zzbp.zzf(byteBuffer);
        this.zzdj = zzerv.zzs(byteBuffer);
        this.zzdl = byteBuffer.getInt();
        this.zzdm = byteBuffer.getInt();
        this.zzdn = byteBuffer.getInt();
        this.zzdo = byteBuffer.getInt();
        this.zzdp = byteBuffer.getInt();
        this.zzdq = byteBuffer.getInt();
        this.zzdk = zzbp.zzf(byteBuffer);
    }

    public final String toString() {
        return "MovieHeaderBox[" + "creationTime=" + this.zzdd + ";" + "modificationTime=" + this.zzde + ";" + "timescale=" + this.zzdf + ";" + "duration=" + this.zzdg + ";" + "rate=" + this.zzdh + ";" + "volume=" + this.zzdi + ";" + "matrix=" + this.zzdj + ";" + "nextTrackId=" + this.zzdk + Const.jaRight;
    }
}
