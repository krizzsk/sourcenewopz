package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzemi implements zzepc {
    private int tag;
    private final zzemb zziqc;
    private int zziqd;
    private int zziqe = 0;

    public static zzemi zza(zzemb zzemb) {
        if (zzemb.zzipr != null) {
            return zzemb.zzipr;
        }
        return new zzemi(zzemb);
    }

    private zzemi(zzemb zzemb) {
        zzemb zzemb2 = (zzemb) zzenc.zza(zzemb, "input");
        this.zziqc = zzemb2;
        zzemb2.zzipr = this;
    }

    public final int zzbip() throws IOException {
        int i = this.zziqe;
        if (i != 0) {
            this.tag = i;
            this.zziqe = 0;
        } else {
            this.tag = this.zziqc.zzbhr();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zziqd) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzbiq() throws IOException {
        int i;
        if (this.zziqc.zzbih() || (i = this.tag) == this.zziqd) {
            return false;
        }
        return this.zziqc.zzgm(i);
    }

    private final void zzgv(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzenn.zzbke();
        }
    }

    public final double readDouble() throws IOException {
        zzgv(1);
        return this.zziqc.readDouble();
    }

    public final float readFloat() throws IOException {
        zzgv(5);
        return this.zziqc.readFloat();
    }

    public final long zzbhs() throws IOException {
        zzgv(0);
        return this.zziqc.zzbhs();
    }

    public final long zzbht() throws IOException {
        zzgv(0);
        return this.zziqc.zzbht();
    }

    public final int zzbhu() throws IOException {
        zzgv(0);
        return this.zziqc.zzbhu();
    }

    public final long zzbhv() throws IOException {
        zzgv(1);
        return this.zziqc.zzbhv();
    }

    public final int zzbhw() throws IOException {
        zzgv(5);
        return this.zziqc.zzbhw();
    }

    public final boolean zzbhx() throws IOException {
        zzgv(0);
        return this.zziqc.zzbhx();
    }

    public final String readString() throws IOException {
        zzgv(2);
        return this.zziqc.readString();
    }

    public final String zzbhy() throws IOException {
        zzgv(2);
        return this.zziqc.zzbhy();
    }

    public final <T> T zza(zzepi<T> zzepi, zzemn zzemn) throws IOException {
        zzgv(2);
        return zzc(zzepi, zzemn);
    }

    public final <T> T zzb(zzepi<T> zzepi, zzemn zzemn) throws IOException {
        zzgv(3);
        return zzd(zzepi, zzemn);
    }

    private final <T> T zzc(zzepi<T> zzepi, zzemn zzemn) throws IOException {
        int zzbia = this.zziqc.zzbia();
        if (this.zziqc.zzipo < this.zziqc.zzipp) {
            int zzgn = this.zziqc.zzgn(zzbia);
            T newInstance = zzepi.newInstance();
            this.zziqc.zzipo++;
            zzepi.zza(newInstance, this, zzemn);
            zzepi.zzak(newInstance);
            this.zziqc.zzgl(0);
            zzemb zzemb = this.zziqc;
            zzemb.zzipo--;
            this.zziqc.zzgo(zzgn);
            return newInstance;
        }
        throw new zzenn("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzepi<T> zzepi, zzemn zzemn) throws IOException {
        int i = this.zziqd;
        this.zziqd = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzepi.newInstance();
            zzepi.zza(newInstance, this, zzemn);
            zzepi.zzak(newInstance);
            if (this.tag == this.zziqd) {
                return newInstance;
            }
            throw zzenn.zzbkg();
        } finally {
            this.zziqd = i;
        }
    }

    public final zzelq zzbhz() throws IOException {
        zzgv(2);
        return this.zziqc.zzbhz();
    }

    public final int zzbia() throws IOException {
        zzgv(0);
        return this.zziqc.zzbia();
    }

    public final int zzbib() throws IOException {
        zzgv(0);
        return this.zziqc.zzbib();
    }

    public final int zzbic() throws IOException {
        zzgv(5);
        return this.zziqc.zzbic();
    }

    public final long zzbid() throws IOException {
        zzgv(1);
        return this.zziqc.zzbid();
    }

    public final int zzbie() throws IOException {
        zzgv(0);
        return this.zziqc.zzbie();
    }

    public final long zzbif() throws IOException {
        zzgv(0);
        return this.zziqc.zzbif();
    }

    public final void zzm(List<Double> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeml) {
            zzeml zzeml = (zzeml) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzeml.zze(this.zziqc.readDouble());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgw(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzeml.zze(this.zziqc.readDouble());
                } while (this.zziqc.zzbii() < zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zziqc.readDouble()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbia2 = this.zziqc.zzbia();
                zzgw(zzbia2);
                int zzbii2 = this.zziqc.zzbii() + zzbia2;
                do {
                    list.add(Double.valueOf(this.zziqc.readDouble()));
                } while (this.zziqc.zzbii() < zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzn(List<Float> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzemz) {
            zzemz zzemz = (zzemz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgx(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzemz.zzh(this.zziqc.readFloat());
                } while (this.zziqc.zzbii() < zzbii);
            } else if (i == 5) {
                do {
                    zzemz.zzh(this.zziqc.readFloat());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbia2 = this.zziqc.zzbia();
                zzgx(zzbia2);
                int zzbii2 = this.zziqc.zzbii() + zzbia2;
                do {
                    list.add(Float.valueOf(this.zziqc.readFloat()));
                } while (this.zziqc.zzbii() < zzbii2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zziqc.readFloat()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzo(List<Long> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeob.zzfs(this.zziqc.zzbhs());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeob.zzfs(this.zziqc.zzbhs());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zziqc.zzbhs()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Long.valueOf(this.zziqc.zzbhs()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeob.zzfs(this.zziqc.zzbht());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeob.zzfs(this.zziqc.zzbht());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zziqc.zzbht()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Long.valueOf(this.zziqc.zzbht()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzq(List<Integer> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzend.zzhp(this.zziqc.zzbhu());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzend.zzhp(this.zziqc.zzbhu());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbhu()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbhu()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzr(List<Long> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzeob.zzfs(this.zziqc.zzbhv());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgw(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzeob.zzfs(this.zziqc.zzbhv());
                } while (this.zziqc.zzbii() < zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zziqc.zzbhv()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbia2 = this.zziqc.zzbia();
                zzgw(zzbia2);
                int zzbii2 = this.zziqc.zzbii() + zzbia2;
                do {
                    list.add(Long.valueOf(this.zziqc.zzbhv()));
                } while (this.zziqc.zzbii() < zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzs(List<Integer> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgx(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzend.zzhp(this.zziqc.zzbhw());
                } while (this.zziqc.zzbii() < zzbii);
            } else if (i == 5) {
                do {
                    zzend.zzhp(this.zziqc.zzbhw());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbia2 = this.zziqc.zzbia();
                zzgx(zzbia2);
                int zzbii2 = this.zziqc.zzbii() + zzbia2;
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbhw()));
                } while (this.zziqc.zzbii() < zzbii2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbhw()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzt(List<Boolean> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzelo) {
            zzelo zzelo = (zzelo) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzelo.addBoolean(this.zziqc.zzbhx());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzelo.addBoolean(this.zziqc.zzbhx());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zziqc.zzbhx()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Boolean.valueOf(this.zziqc.zzbhx()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzu(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzbhr;
        int zzbhr2;
        if ((this.tag & 7) != 2) {
            throw zzenn.zzbke();
        } else if (!(list instanceof zzenu) || z) {
            do {
                list.add(z ? zzbhy() : readString());
                if (!this.zziqc.zzbih()) {
                    zzbhr = this.zziqc.zzbhr();
                } else {
                    return;
                }
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
        } else {
            zzenu zzenu = (zzenu) list;
            do {
                zzenu.zzak(zzbhz());
                if (!this.zziqc.zzbih()) {
                    zzbhr2 = this.zziqc.zzbhr();
                } else {
                    return;
                }
            } while (zzbhr2 == this.tag);
            this.zziqe = zzbhr2;
        }
    }

    public final <T> void zza(List<T> list, zzepi<T> zzepi, zzemn zzemn) throws IOException {
        int zzbhr;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzepi, zzemn));
                if (!this.zziqc.zzbih() && this.zziqe == 0) {
                    zzbhr = this.zziqc.zzbhr();
                } else {
                    return;
                }
            } while (zzbhr == i);
            this.zziqe = zzbhr;
            return;
        }
        throw zzenn.zzbke();
    }

    public final <T> void zzb(List<T> list, zzepi<T> zzepi, zzemn zzemn) throws IOException {
        int zzbhr;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzepi, zzemn));
                if (!this.zziqc.zzbih() && this.zziqe == 0) {
                    zzbhr = this.zziqc.zzbhr();
                } else {
                    return;
                }
            } while (zzbhr == i);
            this.zziqe = zzbhr;
            return;
        }
        throw zzenn.zzbke();
    }

    public final void zzv(List<zzelq> list) throws IOException {
        int zzbhr;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzbhz());
                if (!this.zziqc.zzbih()) {
                    zzbhr = this.zziqc.zzbhr();
                } else {
                    return;
                }
            } while (zzbhr == this.tag);
            this.zziqe = zzbhr;
            return;
        }
        throw zzenn.zzbke();
    }

    public final void zzw(List<Integer> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzend.zzhp(this.zziqc.zzbia());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzend.zzhp(this.zziqc.zzbia());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbia()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbia()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzx(List<Integer> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzend.zzhp(this.zziqc.zzbib());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzend.zzhp(this.zziqc.zzbib());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbib()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbib()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzy(List<Integer> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgx(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzend.zzhp(this.zziqc.zzbic());
                } while (this.zziqc.zzbii() < zzbii);
            } else if (i == 5) {
                do {
                    zzend.zzhp(this.zziqc.zzbic());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbia2 = this.zziqc.zzbia();
                zzgx(zzbia2);
                int zzbii2 = this.zziqc.zzbii() + zzbia2;
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbic()));
                } while (this.zziqc.zzbii() < zzbii2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbic()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzz(List<Long> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzeob.zzfs(this.zziqc.zzbid());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbia = this.zziqc.zzbia();
                zzgw(zzbia);
                int zzbii = this.zziqc.zzbii() + zzbia;
                do {
                    zzeob.zzfs(this.zziqc.zzbid());
                } while (this.zziqc.zzbii() < zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zziqc.zzbid()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbia2 = this.zziqc.zzbia();
                zzgw(zzbia2);
                int zzbii2 = this.zziqc.zzbii() + zzbia2;
                do {
                    list.add(Long.valueOf(this.zziqc.zzbid()));
                } while (this.zziqc.zzbii() < zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzaa(List<Integer> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzend) {
            zzend zzend = (zzend) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzend.zzhp(this.zziqc.zzbie());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzend.zzhp(this.zziqc.zzbie());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbie()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Integer.valueOf(this.zziqc.zzbie()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    public final void zzab(List<Long> list) throws IOException {
        int zzbhr;
        int zzbhr2;
        if (list instanceof zzeob) {
            zzeob zzeob = (zzeob) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeob.zzfs(this.zziqc.zzbif());
                    if (!this.zziqc.zzbih()) {
                        zzbhr2 = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr2 == this.tag);
                this.zziqe = zzbhr2;
            } else if (i == 2) {
                int zzbii = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    zzeob.zzfs(this.zziqc.zzbif());
                } while (this.zziqc.zzbii() < zzbii);
                zzgy(zzbii);
            } else {
                throw zzenn.zzbke();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zziqc.zzbif()));
                    if (!this.zziqc.zzbih()) {
                        zzbhr = this.zziqc.zzbhr();
                    } else {
                        return;
                    }
                } while (zzbhr == this.tag);
                this.zziqe = zzbhr;
            } else if (i2 == 2) {
                int zzbii2 = this.zziqc.zzbii() + this.zziqc.zzbia();
                do {
                    list.add(Long.valueOf(this.zziqc.zzbif()));
                } while (this.zziqc.zzbii() < zzbii2);
                zzgy(zzbii2);
            } else {
                throw zzenn.zzbke();
            }
        }
    }

    private static void zzgw(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzenn.zzbkg();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzbiq() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.ads.zzenn("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.zzeoe<K, V> r9, com.google.android.gms.internal.ads.zzemn r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzgv(r0)
            com.google.android.gms.internal.ads.zzemb r1 = r7.zziqc
            int r1 = r1.zzbia()
            com.google.android.gms.internal.ads.zzemb r2 = r7.zziqc
            int r1 = r2.zzgn(r1)
            K r2 = r9.zzivo
            V r3 = r9.zzcmg
        L_0x0014:
            int r4 = r7.zzbip()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.ads.zzemb r5 = r7.zziqc     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzbih()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzbiq()     // Catch:{ zzenm -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.ads.zzenn r4 = new com.google.android.gms.internal.ads.zzenn     // Catch:{ zzenm -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzenm -> 0x004e }
            throw r4     // Catch:{ zzenm -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.ads.zzeqr r4 = r9.zzivp     // Catch:{ zzenm -> 0x004e }
            V r5 = r9.zzcmg     // Catch:{ zzenm -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzenm -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.ads.zzeqr) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzemn) r10)     // Catch:{ zzenm -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.ads.zzeqr r4 = r9.zzivn     // Catch:{ zzenm -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.ads.zzeqr) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzemn) r5)     // Catch:{ zzenm -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzbiq()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.ads.zzenn r8 = new com.google.android.gms.internal.ads.zzenn     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.ads.zzemb r8 = r7.zziqc
            r8.zzgo(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzemb r9 = r7.zziqc
            r9.zzgo(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemi.zza(java.util.Map, com.google.android.gms.internal.ads.zzeoe, com.google.android.gms.internal.ads.zzemn):void");
    }

    private final Object zza(zzeqr zzeqr, Class<?> cls, zzemn zzemn) throws IOException {
        switch (zzemh.zziqb[zzeqr.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbhx());
            case 2:
                return zzbhz();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbib());
            case 5:
                return Integer.valueOf(zzbhw());
            case 6:
                return Long.valueOf(zzbhv());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbhu());
            case 9:
                return Long.valueOf(zzbht());
            case 10:
                zzgv(2);
                return zzc(zzepb.zzble().zzj(cls), zzemn);
            case 11:
                return Integer.valueOf(zzbic());
            case 12:
                return Long.valueOf(zzbid());
            case 13:
                return Integer.valueOf(zzbie());
            case 14:
                return Long.valueOf(zzbif());
            case 15:
                return zzbhy();
            case 16:
                return Integer.valueOf(zzbia());
            case 17:
                return Long.valueOf(zzbhs());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzgx(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzenn.zzbkg();
        }
    }

    private final void zzgy(int i) throws IOException {
        if (this.zziqc.zzbii() != i) {
            throw zzenn.zzbjz();
        }
    }
}
