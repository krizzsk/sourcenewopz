package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzerv {
    public static final zzerv zzjeu = new zzerv(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzerv zzjev = new zzerv(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzerv zzjew = new zzerv(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzerv zzjex = new zzerv(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a */
    private final double f52596a;

    /* renamed from: b */
    private final double f52597b;

    /* renamed from: c */
    private final double f52598c;

    /* renamed from: d */
    private final double f52599d;

    /* renamed from: w */
    private final double f52600w;
    private final double zzjeq;
    private final double zzjer;
    private final double zzjes;
    private final double zzjet;

    private zzerv(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zzjeq = d5;
        this.zzjer = d6;
        this.f52600w = d7;
        this.f52596a = d;
        this.f52597b = d2;
        this.f52598c = d3;
        this.f52599d = d4;
        this.zzjes = d8;
        this.zzjet = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzerv zzerv = (zzerv) obj;
        return Double.compare(zzerv.f52596a, this.f52596a) == 0 && Double.compare(zzerv.f52597b, this.f52597b) == 0 && Double.compare(zzerv.f52598c, this.f52598c) == 0 && Double.compare(zzerv.f52599d, this.f52599d) == 0 && Double.compare(zzerv.zzjes, this.zzjes) == 0 && Double.compare(zzerv.zzjet, this.zzjet) == 0 && Double.compare(zzerv.zzjeq, this.zzjeq) == 0 && Double.compare(zzerv.zzjer, this.zzjer) == 0 && Double.compare(zzerv.f52600w, this.f52600w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzjeq);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzjer);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f52600w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f52596a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f52597b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f52598c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f52599d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzjes);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzjet);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzjeu)) {
            return "Rotate 0°";
        }
        if (equals(zzjev)) {
            return "Rotate 90°";
        }
        if (equals(zzjew)) {
            return "Rotate 180°";
        }
        if (equals(zzjex)) {
            return "Rotate 270°";
        }
        double d = this.zzjeq;
        double d2 = this.zzjer;
        double d3 = this.f52600w;
        double d4 = this.f52596a;
        double d5 = this.f52597b;
        double d6 = this.f52598c;
        double d7 = this.f52599d;
        double d8 = this.zzjes;
        double d9 = this.zzjet;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    public static zzerv zzs(ByteBuffer byteBuffer) {
        double zzi = zzbp.zzi(byteBuffer);
        double zzi2 = zzbp.zzi(byteBuffer);
        double zzj = zzbp.zzj(byteBuffer);
        return new zzerv(zzi, zzi2, zzbp.zzi(byteBuffer), zzbp.zzi(byteBuffer), zzj, zzbp.zzj(byteBuffer), zzbp.zzj(byteBuffer), zzbp.zzi(byteBuffer), zzbp.zzi(byteBuffer));
    }
}
