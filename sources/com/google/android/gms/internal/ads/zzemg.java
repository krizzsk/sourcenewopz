package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzemg extends zzemb {
    private final byte[] buffer;
    private int pos;
    private int zzakr;
    private int zzipu;
    private int zzipw;
    private int zzipx;
    private final InputStream zzipy;
    private int zzipz;
    private zzemf zziqa;

    private zzemg(InputStream inputStream, int i) {
        super();
        this.zzipx = Integer.MAX_VALUE;
        this.zziqa = null;
        zzenc.zza(inputStream, "input");
        this.zzipy = inputStream;
        this.buffer = new byte[4096];
        this.zzakr = 0;
        this.pos = 0;
        this.zzipz = 0;
    }

    public final int zzbhr() throws IOException {
        if (zzbih()) {
            this.zzipw = 0;
            return 0;
        }
        int zzbij = zzbij();
        this.zzipw = zzbij;
        if ((zzbij >>> 3) != 0) {
            return zzbij;
        }
        throw zzenn.zzbkc();
    }

    public final void zzgl(int i) throws zzenn {
        if (this.zzipw != i) {
            throw zzenn.zzbkd();
        }
    }

    public final boolean zzgm(int i) throws IOException {
        int zzbhr;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzakr - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzenn.zzbkb();
            }
            while (i3 < 10) {
                if (zzbio() < 0) {
                    i3++;
                }
            }
            throw zzenn.zzbkb();
            return true;
        } else if (i2 == 1) {
            zzgq(8);
            return true;
        } else if (i2 == 2) {
            zzgq(zzbij());
            return true;
        } else if (i2 == 3) {
            do {
                zzbhr = zzbhr();
                if (zzbhr == 0 || !zzgm(zzbhr)) {
                    zzgl(((i >>> 3) << 3) | 4);
                }
                zzbhr = zzbhr();
                break;
            } while (!zzgm(zzbhr));
            zzgl(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzgq(4);
                return true;
            }
            throw zzenn.zzbke();
        }
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzbim());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzbil());
    }

    public final long zzbhs() throws IOException {
        return zzbik();
    }

    public final long zzbht() throws IOException {
        return zzbik();
    }

    public final int zzbhu() throws IOException {
        return zzbij();
    }

    public final long zzbhv() throws IOException {
        return zzbim();
    }

    public final int zzbhw() throws IOException {
        return zzbil();
    }

    public final boolean zzbhx() throws IOException {
        return zzbik() != 0;
    }

    public final String readString() throws IOException {
        int zzbij = zzbij();
        if (zzbij > 0 && zzbij <= this.zzakr - this.pos) {
            String str = new String(this.buffer, this.pos, zzbij, zzenc.UTF_8);
            this.pos += zzbij;
            return str;
        } else if (zzbij == 0) {
            return "";
        } else {
            if (zzbij > this.zzakr) {
                return new String(zzg(zzbij, false), zzenc.UTF_8);
            }
            zzgr(zzbij);
            String str2 = new String(this.buffer, this.pos, zzbij, zzenc.UTF_8);
            this.pos += zzbij;
            return str2;
        }
    }

    public final String zzbhy() throws IOException {
        byte[] bArr;
        int zzbij = zzbij();
        int i = this.pos;
        if (zzbij <= this.zzakr - i && zzbij > 0) {
            bArr = this.buffer;
            this.pos = i + zzbij;
        } else if (zzbij == 0) {
            return "";
        } else {
            if (zzbij <= this.zzakr) {
                zzgr(zzbij);
                bArr = this.buffer;
                this.pos = zzbij;
            } else {
                bArr = zzg(zzbij, false);
            }
            i = 0;
        }
        return zzeqj.zzo(bArr, i, zzbij);
    }

    public final zzelq zzbhz() throws IOException {
        int zzbij = zzbij();
        int i = this.zzakr;
        int i2 = this.pos;
        if (zzbij <= i - i2 && zzbij > 0) {
            zzelq zzi = zzelq.zzi(this.buffer, i2, zzbij);
            this.pos += zzbij;
            return zzi;
        } else if (zzbij == 0) {
            return zzelq.zzipc;
        } else {
            byte[] zzgt = zzgt(zzbij);
            if (zzgt != null) {
                return zzelq.zzt(zzgt);
            }
            int i3 = this.pos;
            int i4 = this.zzakr;
            int i5 = i4 - i3;
            this.zzipz += i4;
            this.pos = 0;
            this.zzakr = 0;
            List<byte[]> zzgu = zzgu(zzbij - i5);
            byte[] bArr = new byte[zzbij];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] next : zzgu) {
                System.arraycopy(next, 0, bArr, i5, next.length);
                i5 += next.length;
            }
            return zzelq.zzu(bArr);
        }
    }

    public final int zzbia() throws IOException {
        return zzbij();
    }

    public final int zzbib() throws IOException {
        return zzbij();
    }

    public final int zzbic() throws IOException {
        return zzbil();
    }

    public final long zzbid() throws IOException {
        return zzbim();
    }

    public final int zzbie() throws IOException {
        return zzgp(zzbij());
    }

    public final long zzbif() throws IOException {
        return zzfh(zzbik());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzbij() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzakr
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzbig()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemg.zzbij():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbik() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzakr
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zzbig()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemg.zzbik():long");
    }

    /* access modifiers changed from: package-private */
    public final long zzbig() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbio = zzbio();
            j |= ((long) (zzbio & Byte.MAX_VALUE)) << i;
            if ((zzbio & 128) == 0) {
                return j;
            }
        }
        throw zzenn.zzbkb();
    }

    private final int zzbil() throws IOException {
        int i = this.pos;
        if (this.zzakr - i < 4) {
            zzgr(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzbim() throws IOException {
        int i = this.pos;
        if (this.zzakr - i < 8) {
            zzgr(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final int zzgn(int i) throws zzenn {
        if (i >= 0) {
            int i2 = i + this.zzipz + this.pos;
            int i3 = this.zzipx;
            if (i2 <= i3) {
                this.zzipx = i2;
                zzbin();
                return i3;
            }
            throw zzenn.zzbjz();
        }
        throw zzenn.zzbka();
    }

    private final void zzbin() {
        int i = this.zzakr + this.zzipu;
        this.zzakr = i;
        int i2 = this.zzipz + i;
        int i3 = this.zzipx;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzipu = i4;
            this.zzakr = i - i4;
            return;
        }
        this.zzipu = 0;
    }

    public final void zzgo(int i) {
        this.zzipx = i;
        zzbin();
    }

    public final boolean zzbih() throws IOException {
        return this.pos == this.zzakr && !zzgs(1);
    }

    public final int zzbii() {
        return this.zzipz + this.pos;
    }

    private final void zzgr(int i) throws IOException {
        if (zzgs(i)) {
            return;
        }
        if (i > (this.zzipq - this.zzipz) - this.pos) {
            throw zzenn.zzbkf();
        }
        throw zzenn.zzbjz();
    }

    private final boolean zzgs(int i) throws IOException {
        while (this.pos + i > this.zzakr) {
            int i2 = this.zzipq;
            int i3 = this.zzipz;
            int i4 = this.pos;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zzipx) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzakr;
                if (i5 > i4) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzipz += i4;
                this.zzakr -= i4;
                this.pos = 0;
            }
            InputStream inputStream = this.zzipy;
            byte[] bArr2 = this.buffer;
            int i6 = this.zzakr;
            int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.zzipq - this.zzipz) - this.zzakr));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzipy.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzakr += read;
                zzbin();
                if (this.zzakr >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte zzbio() throws IOException {
        if (this.pos == this.zzakr) {
            zzgr(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzg(int i, boolean z) throws IOException {
        byte[] zzgt = zzgt(i);
        if (zzgt != null) {
            return zzgt;
        }
        int i2 = this.pos;
        int i3 = this.zzakr;
        int i4 = i3 - i2;
        this.zzipz += i3;
        this.pos = 0;
        this.zzakr = 0;
        List<byte[]> zzgu = zzgu(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] next : zzgu) {
            System.arraycopy(next, 0, bArr, i4, next.length);
            i4 += next.length;
        }
        return bArr;
    }

    private final byte[] zzgt(int i) throws IOException {
        if (i == 0) {
            return zzenc.zzipi;
        }
        if (i >= 0) {
            int i2 = this.zzipz + this.pos + i;
            if (i2 - this.zzipq <= 0) {
                int i3 = this.zzipx;
                if (i2 <= i3) {
                    int i4 = this.zzakr - this.pos;
                    int i5 = i - i4;
                    if (i5 >= 4096 && i5 > this.zzipy.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
                    this.zzipz += this.zzakr;
                    this.pos = 0;
                    this.zzakr = 0;
                    while (i4 < i) {
                        int read = this.zzipy.read(bArr, i4, i - i4);
                        if (read != -1) {
                            this.zzipz += read;
                            i4 += read;
                        } else {
                            throw zzenn.zzbjz();
                        }
                    }
                    return bArr;
                }
                zzgq((i3 - this.zzipz) - this.pos);
                throw zzenn.zzbjz();
            }
            throw zzenn.zzbkf();
        }
        throw zzenn.zzbka();
    }

    private final List<byte[]> zzgu(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zzipy.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzipz += read;
                    i2 += read;
                } else {
                    throw zzenn.zzbjz();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzgq(int i) throws IOException {
        int i2 = this.zzakr;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zzipz;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zzipx;
            if (i6 <= i7) {
                this.zzipz = i4 + i5;
                int i8 = this.zzakr - i5;
                this.zzakr = 0;
                this.pos = 0;
                while (i8 < i) {
                    try {
                        long j = (long) (i - i8);
                        long skip = this.zzipy.skip(j);
                        int i9 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i9 >= 0 && skip <= j) {
                            if (i9 == 0) {
                                break;
                            }
                            i8 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zzipy.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.zzipz += i8;
                        zzbin();
                        throw th;
                    }
                }
                this.zzipz += i8;
                zzbin();
                if (i8 < i) {
                    int i10 = this.zzakr;
                    int i11 = i10 - this.pos;
                    this.pos = i10;
                    zzgr(1);
                    while (true) {
                        int i12 = i - i11;
                        int i13 = this.zzakr;
                        if (i12 > i13) {
                            i11 += i13;
                            this.pos = i13;
                            zzgr(1);
                        } else {
                            this.pos = i12;
                            return;
                        }
                    }
                }
            } else {
                zzgq((i7 - i4) - i5);
                throw zzenn.zzbjz();
            }
        } else {
            throw zzenn.zzbka();
        }
    }
}
