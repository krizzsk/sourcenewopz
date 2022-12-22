package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzlh implements zzka {
    private static final zzkb zzapu = new zzlk();
    private static final int zzaxt = zzpt.zzbh("seig");
    private static final byte[] zzaxu = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private final int flags;
    private long zzaiz;
    private final zzpn zzaqb;
    private int zzarq;
    private int zzarr;
    private zzkc zzaru;
    private final zzls zzaxv;
    private final SparseArray<zzlm> zzaxw;
    private final zzpn zzaxx;
    private final zzpn zzaxy;
    private final zzpn zzaxz;
    private final zzpr zzaya;
    private final zzpn zzayb;
    private final byte[] zzayc;
    private final Stack<zzkv> zzayd;
    private final LinkedList<zzlj> zzaye;
    private int zzayf;
    private int zzayg;
    private long zzayh;
    private int zzayi;
    private zzpn zzayj;
    private long zzayk;
    private int zzayl;
    private long zzaym;
    private zzlm zzayn;
    private int zzayo;
    private boolean zzayp;
    private zzkh zzayq;
    private zzkh[] zzayr;
    private boolean zzays;

    public zzlh() {
        this(0);
    }

    public final void release() {
    }

    private zzlh(int i) {
        this(0, (zzpr) null);
    }

    private zzlh(int i, zzpr zzpr) {
        this(0, (zzpr) null, (zzls) null);
    }

    private zzlh(int i, zzpr zzpr, zzls zzls) {
        this.flags = 0;
        this.zzaya = null;
        this.zzaxv = null;
        this.zzayb = new zzpn(16);
        this.zzaqb = new zzpn(zzpm.zzbkd);
        this.zzaxx = new zzpn(5);
        this.zzaxy = new zzpn();
        this.zzaxz = new zzpn(1);
        this.zzayc = new byte[16];
        this.zzayd = new Stack<>();
        this.zzaye = new LinkedList<>();
        this.zzaxw = new SparseArray<>();
        this.zzaiz = -9223372036854775807L;
        this.zzaym = -9223372036854775807L;
        zzhf();
    }

    public final boolean zza(zzjz zzjz) throws IOException, InterruptedException {
        return zzlp.zzd(zzjz);
    }

    public final void zza(zzkc zzkc) {
        this.zzaru = zzkc;
    }

    public final void zzc(long j, long j2) {
        int size = this.zzaxw.size();
        for (int i = 0; i < size; i++) {
            this.zzaxw.valueAt(i).reset();
        }
        this.zzaye.clear();
        this.zzayl = 0;
        this.zzayd.clear();
        zzhf();
    }

    /* JADX WARNING: Removed duplicated region for block: B:254:0x029d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x05e6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0004 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r27, com.google.android.gms.internal.ads.zzkg r28) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
        L_0x0004:
            int r2 = r0.zzayf
            r3 = 2
            r5 = 8
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0459
            r8 = 4
            if (r2 == r6) goto L_0x02fa
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11 = 3
            if (r2 == r3) goto L_0x029e
            if (r2 != r11) goto L_0x0112
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            if (r2 != 0) goto L_0x008c
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r12 = r2.size()
            r13 = 0
            r14 = 0
        L_0x0026:
            if (r13 >= r12) goto L_0x0049
            java.lang.Object r15 = r2.valueAt(r13)
            com.google.android.gms.internal.ads.zzlm r15 = (com.google.android.gms.internal.ads.zzlm) r15
            int r11 = r15.zzbag
            com.google.android.gms.internal.ads.zzlu r4 = r15.zzbab
            int r4 = r4.zzbbc
            if (r11 == r4) goto L_0x0045
            com.google.android.gms.internal.ads.zzlu r4 = r15.zzbab
            long[] r4 = r4.zzbbd
            int r11 = r15.zzbag
            r17 = r4[r11]
            int r4 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0045
            r14 = r15
            r9 = r17
        L_0x0045:
            int r13 = r13 + 1
            r11 = 3
            goto L_0x0026
        L_0x0049:
            if (r14 != 0) goto L_0x0067
            long r2 = r0.zzayk
            long r4 = r27.getPosition()
            long r2 = r2 - r4
            int r3 = (int) r2
            if (r3 < 0) goto L_0x005f
            r1.zzaj(r3)
            r26.zzhf()
            r3 = 0
            r6 = 0
            goto L_0x029b
        L_0x005f:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Offset to end of mdat was negative."
            r1.<init>(r2)
            throw r1
        L_0x0067:
            com.google.android.gms.internal.ads.zzlu r2 = r14.zzbab
            long[] r2 = r2.zzbbd
            int r4 = r14.zzbag
            r9 = r2[r4]
            long r11 = r27.getPosition()
            long r9 = r9 - r11
            int r2 = (int) r9
            if (r2 >= 0) goto L_0x0087
            r17 = 5
            r20 = 0
            r22 = 213(0xd5, float:2.98E-43)
            java.lang.String r18 = "FragmentedMp4Extractor"
            java.lang.String r19 = "Ignoring negative offset to sample data."
            java.lang.String r21 = "com.google.android.gms.internal.ads.zzlh"
            com.didi.sdk.apm.SystemUtils.log(r17, r18, r19, r20, r21, r22)
            r2 = 0
        L_0x0087:
            r1.zzaj(r2)
            r0.zzayn = r14
        L_0x008c:
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            com.google.android.gms.internal.ads.zzlu r2 = r2.zzbab
            int[] r2 = r2.zzbbf
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            int r4 = r4.zzbae
            r2 = r2[r4]
            r0.zzayo = r2
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            com.google.android.gms.internal.ads.zzlu r2 = r2.zzbab
            boolean r2 = r2.zzbbj
            if (r2 == 0) goto L_0x00fc
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            com.google.android.gms.internal.ads.zzlu r4 = r2.zzbab
            com.google.android.gms.internal.ads.zzpn r9 = r4.zzbbn
            com.google.android.gms.internal.ads.zzlg r10 = r4.zzbay
            int r10 = r10.zzaxs
            com.google.android.gms.internal.ads.zzlr r11 = r4.zzbbl
            if (r11 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzlr r10 = r4.zzbbl
            goto L_0x00b9
        L_0x00b3:
            com.google.android.gms.internal.ads.zzls r11 = r2.zzbac
            com.google.android.gms.internal.ads.zzlr[] r11 = r11.zzbau
            r10 = r11[r10]
        L_0x00b9:
            int r10 = r10.zzbaq
            boolean[] r4 = r4.zzbbk
            int r11 = r2.zzbae
            boolean r4 = r4[r11]
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzaxz
            byte[] r11 = r11.data
            if (r4 == 0) goto L_0x00ca
            r12 = 128(0x80, float:1.794E-43)
            goto L_0x00cb
        L_0x00ca:
            r12 = 0
        L_0x00cb:
            r12 = r12 | r10
            byte r12 = (byte) r12
            r11[r7] = r12
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzaxz
            r11.zzbl(r7)
            com.google.android.gms.internal.ads.zzkh r2 = r2.zzasz
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzaxz
            r2.zza(r11, r6)
            r2.zza(r9, r10)
            if (r4 != 0) goto L_0x00e3
            int r10 = r10 + 1
            goto L_0x00f4
        L_0x00e3:
            int r4 = r9.readUnsignedShort()
            r11 = -2
            r9.zzbm(r11)
            int r4 = r4 * 6
            int r4 = r4 + r3
            r2.zza(r9, r4)
            int r10 = r10 + 1
            int r10 = r10 + r4
        L_0x00f4:
            r0.zzarr = r10
            int r2 = r0.zzayo
            int r2 = r2 + r10
            r0.zzayo = r2
            goto L_0x00fe
        L_0x00fc:
            r0.zzarr = r7
        L_0x00fe:
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            com.google.android.gms.internal.ads.zzls r2 = r2.zzbac
            int r2 = r2.zzbat
            if (r2 != r6) goto L_0x010e
            int r2 = r0.zzayo
            int r2 = r2 - r5
            r0.zzayo = r2
            r1.zzaj(r5)
        L_0x010e:
            r0.zzayf = r8
            r0.zzarq = r7
        L_0x0112:
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            com.google.android.gms.internal.ads.zzlu r2 = r2.zzbab
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            com.google.android.gms.internal.ads.zzls r4 = r4.zzbac
            com.google.android.gms.internal.ads.zzlm r5 = r0.zzayn
            com.google.android.gms.internal.ads.zzkh r9 = r5.zzasz
            com.google.android.gms.internal.ads.zzlm r5 = r0.zzayn
            int r5 = r5.zzbae
            int r10 = r4.zzata
            r11 = 1000(0x3e8, double:4.94E-321)
            if (r10 == 0) goto L_0x01e3
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzaxx
            byte[] r10 = r10.data
            r10[r7] = r7
            r10[r6] = r7
            r10[r3] = r7
            int r3 = r4.zzata
            int r3 = r3 + r6
            int r13 = r4.zzata
            int r13 = 4 - r13
        L_0x0139:
            int r14 = r0.zzarr
            int r15 = r0.zzayo
            if (r14 >= r15) goto L_0x01f5
            int r14 = r0.zzarq
            if (r14 != 0) goto L_0x0184
            r1.readFully(r10, r13, r3)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxx
            r14.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxx
            int r14 = r14.zzje()
            int r14 = r14 - r6
            r0.zzarq = r14
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaqb
            r14.zzbl(r7)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaqb
            r9.zza(r14, r8)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxx
            r9.zza(r14, r6)
            com.google.android.gms.internal.ads.zzkh[] r14 = r0.zzayr
            if (r14 == 0) goto L_0x0175
            com.google.android.gms.internal.ads.zzht r14 = r4.zzaij
            java.lang.String r14 = r14.zzaho
            byte r15 = r10[r8]
            boolean r14 = com.google.android.gms.internal.ads.zzpm.zza(r14, r15)
            if (r14 == 0) goto L_0x0175
            r14 = 1
            goto L_0x0176
        L_0x0175:
            r14 = 0
        L_0x0176:
            r0.zzayp = r14
            int r14 = r0.zzarr
            int r14 = r14 + 5
            r0.zzarr = r14
            int r14 = r0.zzayo
            int r14 = r14 + r13
            r0.zzayo = r14
            goto L_0x0139
        L_0x0184:
            boolean r15 = r0.zzayp
            if (r15 == 0) goto L_0x01cf
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaxy
            r15.reset(r14)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxy
            byte[] r14 = r14.data
            int r15 = r0.zzarq
            r1.readFully(r14, r7, r15)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaxy
            int r15 = r0.zzarq
            r9.zza(r14, r15)
            int r14 = r0.zzarq
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaxy
            byte[] r15 = r15.data
            com.google.android.gms.internal.ads.zzpn r8 = r0.zzaxy
            int r8 = r8.limit()
            int r8 = com.google.android.gms.internal.ads.zzpm.zzb(r15, r8)
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaxy
            com.google.android.gms.internal.ads.zzht r6 = r4.zzaij
            java.lang.String r6 = r6.zzaho
            java.lang.String r7 = "video/hevc"
            boolean r6 = r7.equals(r6)
            r15.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzaxy
            r6.zzbk(r8)
            long r6 = r2.zzay(r5)
            long r6 = r6 * r11
            com.google.android.gms.internal.ads.zzpn r8 = r0.zzaxy
            com.google.android.gms.internal.ads.zzkh[] r15 = r0.zzayr
            com.google.android.gms.internal.ads.zznw.zza(r6, r8, r15)
            goto L_0x01d4
        L_0x01cf:
            r6 = 0
            int r14 = r9.zza(r1, r14, r6)
        L_0x01d4:
            int r6 = r0.zzarr
            int r6 = r6 + r14
            r0.zzarr = r6
            int r6 = r0.zzarq
            int r6 = r6 - r14
            r0.zzarq = r6
            r6 = 1
            r7 = 0
            r8 = 4
            goto L_0x0139
        L_0x01e3:
            int r3 = r0.zzarr
            int r6 = r0.zzayo
            if (r3 >= r6) goto L_0x01f5
            int r6 = r6 - r3
            r3 = 0
            int r6 = r9.zza(r1, r6, r3)
            int r3 = r0.zzarr
            int r3 = r3 + r6
            r0.zzarr = r3
            goto L_0x01e3
        L_0x01f5:
            long r6 = r2.zzay(r5)
            long r6 = r6 * r11
            boolean r3 = r2.zzbbj
            if (r3 == 0) goto L_0x0202
            r3 = 1073741824(0x40000000, float:2.0)
            goto L_0x0203
        L_0x0202:
            r3 = 0
        L_0x0203:
            boolean[] r8 = r2.zzbbi
            boolean r5 = r8[r5]
            r12 = r3 | r5
            boolean r3 = r2.zzbbj
            if (r3 == 0) goto L_0x0231
            com.google.android.gms.internal.ads.zzlr r3 = r2.zzbbl
            if (r3 == 0) goto L_0x0214
            com.google.android.gms.internal.ads.zzlr r3 = r2.zzbbl
            goto L_0x021c
        L_0x0214:
            com.google.android.gms.internal.ads.zzlr[] r3 = r4.zzbau
            com.google.android.gms.internal.ads.zzlg r4 = r2.zzbay
            int r4 = r4.zzaxs
            r3 = r3[r4]
        L_0x021c:
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            com.google.android.gms.internal.ads.zzlr r4 = r4.zzbai
            if (r3 == r4) goto L_0x022b
            com.google.android.gms.internal.ads.zzkk r4 = new com.google.android.gms.internal.ads.zzkk
            byte[] r5 = r3.zzbar
            r8 = 1
            r4.<init>(r8, r5)
            goto L_0x022f
        L_0x022b:
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            com.google.android.gms.internal.ads.zzkk r4 = r4.zzbah
        L_0x022f:
            r15 = r4
            goto L_0x0233
        L_0x0231:
            r3 = 0
            r15 = 0
        L_0x0233:
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            r4.zzbah = r15
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            r4.zzbai = r3
            int r13 = r0.zzayo
            r14 = 0
            r10 = r6
            r9.zza(r10, r12, r13, r14, r15)
        L_0x0242:
            java.util.LinkedList<com.google.android.gms.internal.ads.zzlj> r3 = r0.zzaye
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0269
            java.util.LinkedList<com.google.android.gms.internal.ads.zzlj> r3 = r0.zzaye
            java.lang.Object r3 = r3.removeFirst()
            com.google.android.gms.internal.ads.zzlj r3 = (com.google.android.gms.internal.ads.zzlj) r3
            int r4 = r0.zzayl
            int r5 = r3.size
            int r4 = r4 - r5
            r0.zzayl = r4
            com.google.android.gms.internal.ads.zzkh r8 = r0.zzayq
            long r4 = r3.zzayw
            long r9 = r6 + r4
            r11 = 1
            int r12 = r3.size
            int r13 = r0.zzayl
            r14 = 0
            r8.zza(r9, r11, r12, r13, r14)
            goto L_0x0242
        L_0x0269:
            com.google.android.gms.internal.ads.zzlm r3 = r0.zzayn
            int r4 = r3.zzbae
            r5 = 1
            int r4 = r4 + r5
            r3.zzbae = r4
            com.google.android.gms.internal.ads.zzlm r3 = r0.zzayn
            int r4 = r3.zzbaf
            int r4 = r4 + r5
            r3.zzbaf = r4
            com.google.android.gms.internal.ads.zzlm r3 = r0.zzayn
            int r3 = r3.zzbaf
            int[] r2 = r2.zzbbe
            com.google.android.gms.internal.ads.zzlm r4 = r0.zzayn
            int r4 = r4.zzbag
            r2 = r2[r4]
            if (r3 != r2) goto L_0x0296
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            int r3 = r2.zzbag
            int r3 = r3 + r5
            r2.zzbag = r3
            com.google.android.gms.internal.ads.zzlm r2 = r0.zzayn
            r3 = 0
            r2.zzbaf = r3
            r2 = 0
            r0.zzayn = r2
            goto L_0x0297
        L_0x0296:
            r3 = 0
        L_0x0297:
            r2 = 3
            r0.zzayf = r2
            r6 = 1
        L_0x029b:
            if (r6 == 0) goto L_0x0004
            return r3
        L_0x029e:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L_0x02a6:
            if (r3 >= r2) goto L_0x02cb
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r5 = r0.zzaxw
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzlm r5 = (com.google.android.gms.internal.ads.zzlm) r5
            com.google.android.gms.internal.ads.zzlu r5 = r5.zzbab
            boolean r6 = r5.zzbbo
            if (r6 == 0) goto L_0x02c8
            long r6 = r5.zzbbb
            int r8 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x02c8
            long r4 = r5.zzbbb
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r6 = r0.zzaxw
            java.lang.Object r6 = r6.valueAt(r3)
            com.google.android.gms.internal.ads.zzlm r6 = (com.google.android.gms.internal.ads.zzlm) r6
            r9 = r4
            r4 = r6
        L_0x02c8:
            int r3 = r3 + 1
            goto L_0x02a6
        L_0x02cb:
            if (r4 != 0) goto L_0x02d2
            r2 = 3
            r0.zzayf = r2
            goto L_0x0004
        L_0x02d2:
            long r2 = r27.getPosition()
            long r9 = r9 - r2
            int r2 = (int) r9
            if (r2 < 0) goto L_0x02f2
            r1.zzaj(r2)
            com.google.android.gms.internal.ads.zzlu r2 = r4.zzbab
            com.google.android.gms.internal.ads.zzpn r3 = r2.zzbbn
            byte[] r3 = r3.data
            int r4 = r2.zzbbm
            r5 = 0
            r1.readFully(r3, r5, r4)
            com.google.android.gms.internal.ads.zzpn r3 = r2.zzbbn
            r3.zzbl(r5)
            r2.zzbbo = r5
            goto L_0x0004
        L_0x02f2:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Offset to encryption data was negative."
            r1.<init>(r2)
            throw r1
        L_0x02fa:
            long r6 = r0.zzayh
            int r2 = (int) r6
            int r4 = r0.zzayi
            int r2 = r2 - r4
            com.google.android.gms.internal.ads.zzpn r4 = r0.zzayj
            if (r4 == 0) goto L_0x044d
            byte[] r4 = r4.data
            r1.readFully(r4, r5, r2)
            com.google.android.gms.internal.ads.zzky r2 = new com.google.android.gms.internal.ads.zzky
            int r4 = r0.zzayg
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzayj
            r2.<init>(r4, r6)
            long r6 = r27.getPosition()
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r4 = r0.zzayd
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x032b
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r3 = r0.zzayd
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzkv r3 = (com.google.android.gms.internal.ads.zzkv) r3
            r3.zza((com.google.android.gms.internal.ads.zzky) r2)
            goto L_0x0450
        L_0x032b:
            int r4 = r2.type
            int r8 = com.google.android.gms.internal.ads.zzkw.zzauh
            if (r4 != r8) goto L_0x03f3
            com.google.android.gms.internal.ads.zzpn r2 = r2.zzaxd
            r2.zzbl(r5)
            int r4 = r2.readInt()
            int r4 = com.google.android.gms.internal.ads.zzkw.zzau(r4)
            r5 = 4
            r2.zzbm(r5)
            long r14 = r2.zzjb()
            if (r4 != 0) goto L_0x0351
            long r4 = r2.zzjb()
            long r8 = r2.zzjb()
            goto L_0x0359
        L_0x0351:
            long r4 = r2.zzjf()
            long r8 = r2.zzjf()
        L_0x0359:
            long r6 = r6 + r8
            r10 = 1000000(0xf4240, double:4.940656E-318)
            r8 = r4
            r12 = r14
            long r20 = com.google.android.gms.internal.ads.zzpt.zza((long) r8, (long) r10, (long) r12)
            r2.zzbm(r3)
            int r3 = r2.readUnsignedShort()
            int[] r12 = new int[r3]
            long[] r13 = new long[r3]
            long[] r10 = new long[r3]
            long[] r11 = new long[r3]
            r22 = r20
            r8 = 0
        L_0x0375:
            if (r8 >= r3) goto L_0x03cb
            int r9 = r2.readInt()
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r16 = r9 & r16
            if (r16 != 0) goto L_0x03c3
            long r24 = r2.zzjb()
            r16 = 2147483647(0x7fffffff, float:NaN)
            r9 = r9 & r16
            r12[r8] = r9
            r13[r8] = r6
            r11[r8] = r22
            long r4 = r4 + r24
            r22 = 1000000(0xf4240, double:4.940656E-318)
            r19 = r8
            r8 = r4
            r28 = r3
            r24 = r4
            r3 = r10
            r4 = r11
            r10 = r22
            r5 = r12
            r1 = r13
            r12 = r14
            long r22 = com.google.android.gms.internal.ads.zzpt.zza((long) r8, (long) r10, (long) r12)
            r8 = r4[r19]
            long r8 = r22 - r8
            r3[r19] = r8
            r8 = 4
            r2.zzbm(r8)
            r9 = r5[r19]
            long r9 = (long) r9
            long r6 = r6 + r9
            int r9 = r19 + 1
            r13 = r1
            r10 = r3
            r11 = r4
            r12 = r5
            r8 = r9
            r4 = r24
            r1 = r27
            r3 = r28
            goto L_0x0375
        L_0x03c3:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unhandled indirect reference"
            r1.<init>(r2)
            throw r1
        L_0x03cb:
            r3 = r10
            r4 = r11
            r5 = r12
            r1 = r13
            java.lang.Long r2 = java.lang.Long.valueOf(r20)
            com.google.android.gms.internal.ads.zzjy r6 = new com.google.android.gms.internal.ads.zzjy
            r6.<init>(r5, r1, r3, r4)
            android.util.Pair r1 = android.util.Pair.create(r2, r6)
            java.lang.Object r2 = r1.first
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r0.zzaym = r2
            com.google.android.gms.internal.ads.zzkc r2 = r0.zzaru
            java.lang.Object r1 = r1.second
            com.google.android.gms.internal.ads.zzkf r1 = (com.google.android.gms.internal.ads.zzkf) r1
            r2.zza(r1)
            r1 = 1
            r0.zzays = r1
            goto L_0x044a
        L_0x03f3:
            int r1 = r2.type
            int r3 = com.google.android.gms.internal.ads.zzkw.zzawn
            if (r1 != r3) goto L_0x044a
            com.google.android.gms.internal.ads.zzpn r1 = r2.zzaxd
            com.google.android.gms.internal.ads.zzkh r2 = r0.zzayq
            if (r2 == 0) goto L_0x044a
            r2 = 12
            r1.zzbl(r2)
            r1.zzjg()
            r1.zzjg()
            long r7 = r1.zzjb()
            long r3 = r1.zzjb()
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = com.google.android.gms.internal.ads.zzpt.zza((long) r3, (long) r5, (long) r7)
            r1.zzbl(r2)
            int r9 = r1.zziz()
            com.google.android.gms.internal.ads.zzkh r2 = r0.zzayq
            r2.zza(r1, r9)
            long r1 = r0.zzaym
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x043b
            com.google.android.gms.internal.ads.zzkh r5 = r0.zzayq
            long r6 = r1 + r3
            r8 = 1
            r10 = 0
            r11 = 0
            r5.zza(r6, r8, r9, r10, r11)
            goto L_0x044a
        L_0x043b:
            java.util.LinkedList<com.google.android.gms.internal.ads.zzlj> r1 = r0.zzaye
            com.google.android.gms.internal.ads.zzlj r2 = new com.google.android.gms.internal.ads.zzlj
            r2.<init>(r3, r9)
            r1.addLast(r2)
            int r1 = r0.zzayl
            int r1 = r1 + r9
            r0.zzayl = r1
        L_0x044a:
            r1 = r27
            goto L_0x0450
        L_0x044d:
            r1.zzaj(r2)
        L_0x0450:
            long r2 = r27.getPosition()
            r0.zzeb(r2)
            goto L_0x0004
        L_0x0459:
            int r2 = r0.zzayi
            if (r2 != 0) goto L_0x0482
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            byte[] r2 = r2.data
            r4 = 1
            r6 = 0
            boolean r2 = r1.zza(r2, r6, r5, r4)
            if (r2 != 0) goto L_0x046b
            goto L_0x05e4
        L_0x046b:
            r0.zzayi = r5
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            r2.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            long r6 = r2.zzjb()
            r0.zzayh = r6
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            int r2 = r2.readInt()
            r0.zzayg = r2
        L_0x0482:
            long r6 = r0.zzayh
            r8 = 1
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x049e
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            byte[] r2 = r2.data
            r1.readFully(r2, r5, r5)
            int r2 = r0.zzayi
            int r2 = r2 + r5
            r0.zzayi = r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            long r6 = r2.zzjf()
            r0.zzayh = r6
        L_0x049e:
            long r6 = r0.zzayh
            int r2 = r0.zzayi
            long r8 = (long) r2
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x05f0
            long r6 = r27.getPosition()
            int r2 = r0.zzayi
            long r8 = (long) r2
            long r6 = r6 - r8
            int r2 = r0.zzayg
            int r4 = com.google.android.gms.internal.ads.zzkw.zzaur
            if (r2 != r4) goto L_0x04d1
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r2 = r2.size()
            r4 = 0
        L_0x04bc:
            if (r4 >= r2) goto L_0x04d1
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r8 = r0.zzaxw
            java.lang.Object r8 = r8.valueAt(r4)
            com.google.android.gms.internal.ads.zzlm r8 = (com.google.android.gms.internal.ads.zzlm) r8
            com.google.android.gms.internal.ads.zzlu r8 = r8.zzbab
            r8.zzbaz = r6
            r8.zzbbb = r6
            r8.zzbba = r6
            int r4 = r4 + 1
            goto L_0x04bc
        L_0x04d1:
            int r2 = r0.zzayg
            int r4 = com.google.android.gms.internal.ads.zzkw.zzato
            if (r2 != r4) goto L_0x04f7
            r2 = 0
            r0.zzayn = r2
            long r4 = r0.zzayh
            long r6 = r6 + r4
            r0.zzayk = r6
            boolean r2 = r0.zzays
            if (r2 != 0) goto L_0x04f2
            com.google.android.gms.internal.ads.zzkc r2 = r0.zzaru
            com.google.android.gms.internal.ads.zzki r4 = new com.google.android.gms.internal.ads.zzki
            long r5 = r0.zzaiz
            r4.<init>(r5)
            r2.zza(r4)
            r2 = 1
            r0.zzays = r2
        L_0x04f2:
            r0.zzayf = r3
        L_0x04f4:
            r2 = 1
            goto L_0x05e3
        L_0x04f7:
            int r2 = r0.zzayg
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaui
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauk
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaul
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaum
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaun
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaur
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaus
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaut
            if (r2 == r3) goto L_0x0520
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauw
            if (r2 != r3) goto L_0x051e
            goto L_0x0520
        L_0x051e:
            r2 = 0
            goto L_0x0521
        L_0x0520:
            r2 = 1
        L_0x0521:
            if (r2 == 0) goto L_0x054a
            long r2 = r27.getPosition()
            long r4 = r0.zzayh
            long r2 = r2 + r4
            r4 = 8
            long r2 = r2 - r4
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r4 = r0.zzayd
            com.google.android.gms.internal.ads.zzkv r5 = new com.google.android.gms.internal.ads.zzkv
            int r6 = r0.zzayg
            r5.<init>(r6, r2)
            r4.add(r5)
            long r4 = r0.zzayh
            int r6 = r0.zzayi
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0546
            r0.zzeb(r2)
            goto L_0x04f4
        L_0x0546:
            r26.zzhf()
            goto L_0x04f4
        L_0x054a:
            int r2 = r0.zzayg
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauz
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauy
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauj
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauh
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzava
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaud
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaue
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauv
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauf
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaug
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavb
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavj
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavk
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavo
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavn
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavl
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzavm
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaux
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzauu
            if (r2 == r3) goto L_0x059f
            int r3 = com.google.android.gms.internal.ads.zzkw.zzawn
            if (r2 != r3) goto L_0x059d
            goto L_0x059f
        L_0x059d:
            r2 = 0
            goto L_0x05a0
        L_0x059f:
            r2 = 1
        L_0x05a0:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r2 == 0) goto L_0x05d7
            int r2 = r0.zzayi
            if (r2 != r5) goto L_0x05cf
            long r6 = r0.zzayh
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x05c7
            com.google.android.gms.internal.ads.zzpn r2 = new com.google.android.gms.internal.ads.zzpn
            int r3 = (int) r6
            r2.<init>((int) r3)
            r0.zzayj = r2
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzayb
            byte[] r2 = r2.data
            com.google.android.gms.internal.ads.zzpn r3 = r0.zzayj
            byte[] r3 = r3.data
            r4 = 0
            java.lang.System.arraycopy(r2, r4, r3, r4, r5)
            r2 = 1
            r0.zzayf = r2
            goto L_0x05e3
        L_0x05c7:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Leaf atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x05cf:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Leaf atom defines extended atom size (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x05d7:
            long r5 = r0.zzayh
            int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x05e8
            r2 = 0
            r0.zzayj = r2
            r2 = 1
            r0.zzayf = r2
        L_0x05e3:
            r6 = 1
        L_0x05e4:
            if (r6 != 0) goto L_0x0004
            r1 = -1
            return r1
        L_0x05e8:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Skipping atom with length > 2147483647 (unsupported)."
            r1.<init>(r2)
            throw r1
        L_0x05f0:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Atom size less than header length (unsupported)."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkg):int");
    }

    private final void zzhf() {
        this.zzayf = 0;
        this.zzayi = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:157:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03e2  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03f0  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0656  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzeb(long r53) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r52 = this;
            r0 = r52
        L_0x0002:
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r1 = r0.zzayd
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x06f5
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r1 = r0.zzayd
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzkv r1 = (com.google.android.gms.internal.ads.zzkv) r1
            long r1 = r1.zzate
            int r3 = (r1 > r53 ? 1 : (r1 == r53 ? 0 : -1))
            if (r3 != 0) goto L_0x06f5
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r1 = r0.zzayd
            java.lang.Object r1 = r1.pop()
            com.google.android.gms.internal.ads.zzkv r1 = (com.google.android.gms.internal.ads.zzkv) r1
            int r2 = r1.type
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaui
            r4 = 0
            r5 = 12
            r6 = 4
            r7 = 8
            r9 = 1
            if (r2 != r3) goto L_0x01c8
            java.lang.String r2 = "Unexpected moov box."
            com.google.android.gms.internal.ads.zzpg.checkState(r9, r2)
            java.util.List<com.google.android.gms.internal.ads.zzky> r2 = r1.zzatf
            com.google.android.gms.internal.ads.zzjo r2 = zzb(r2)
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaut
            com.google.android.gms.internal.ads.zzkv r3 = r1.zzat(r3)
            android.util.SparseArray r15 = new android.util.SparseArray
            r15.<init>()
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.gms.internal.ads.zzky> r12 = r3.zzatf
            int r12 = r12.size()
            r16 = r10
            r10 = 0
        L_0x0051:
            if (r10 >= r12) goto L_0x00be
            java.util.List<com.google.android.gms.internal.ads.zzky> r11 = r3.zzatf
            java.lang.Object r11 = r11.get(r10)
            com.google.android.gms.internal.ads.zzky r11 = (com.google.android.gms.internal.ads.zzky) r11
            int r13 = r11.type
            int r14 = com.google.android.gms.internal.ads.zzkw.zzauf
            if (r13 != r14) goto L_0x0098
            com.google.android.gms.internal.ads.zzpn r11 = r11.zzaxd
            r11.zzbl(r5)
            int r13 = r11.readInt()
            int r14 = r11.zzje()
            int r14 = r14 - r9
            int r5 = r11.zzje()
            int r8 = r11.zzje()
            int r11 = r11.readInt()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            com.google.android.gms.internal.ads.zzlg r9 = new com.google.android.gms.internal.ads.zzlg
            r9.<init>(r14, r5, r8, r11)
            android.util.Pair r5 = android.util.Pair.create(r13, r9)
            java.lang.Object r8 = r5.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r5 = r5.second
            com.google.android.gms.internal.ads.zzlg r5 = (com.google.android.gms.internal.ads.zzlg) r5
            r15.put(r8, r5)
            goto L_0x00b8
        L_0x0098:
            int r5 = r11.type
            int r8 = com.google.android.gms.internal.ads.zzkw.zzauu
            if (r5 != r8) goto L_0x00b8
            com.google.android.gms.internal.ads.zzpn r5 = r11.zzaxd
            r5.zzbl(r7)
            int r8 = r5.readInt()
            int r8 = com.google.android.gms.internal.ads.zzkw.zzau(r8)
            if (r8 != 0) goto L_0x00b2
            long r8 = r5.zzjb()
            goto L_0x00b6
        L_0x00b2:
            long r8 = r5.zzjf()
        L_0x00b6:
            r16 = r8
        L_0x00b8:
            int r10 = r10 + 1
            r5 = 12
            r9 = 1
            goto L_0x0051
        L_0x00be:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzkv> r5 = r1.zzatg
            int r5 = r5.size()
            r8 = 0
        L_0x00ca:
            if (r8 >= r5) goto L_0x00fa
            java.util.List<com.google.android.gms.internal.ads.zzkv> r9 = r1.zzatg
            java.lang.Object r9 = r9.get(r8)
            r10 = r9
            com.google.android.gms.internal.ads.zzkv r10 = (com.google.android.gms.internal.ads.zzkv) r10
            int r9 = r10.type
            int r11 = com.google.android.gms.internal.ads.zzkw.zzauk
            if (r9 != r11) goto L_0x00f3
            int r9 = com.google.android.gms.internal.ads.zzkw.zzauj
            com.google.android.gms.internal.ads.zzky r11 = r1.zzas(r9)
            r9 = 0
            r12 = r16
            r14 = r2
            r7 = r15
            r15 = r9
            com.google.android.gms.internal.ads.zzls r9 = com.google.android.gms.internal.ads.zzkx.zza((com.google.android.gms.internal.ads.zzkv) r10, (com.google.android.gms.internal.ads.zzky) r11, (long) r12, (com.google.android.gms.internal.ads.zzjo) r14, (boolean) r15)
            if (r9 == 0) goto L_0x00f4
            int r10 = r9.f52604id
            r3.put(r10, r9)
            goto L_0x00f4
        L_0x00f3:
            r7 = r15
        L_0x00f4:
            int r8 = r8 + 1
            r15 = r7
            r7 = 8
            goto L_0x00ca
        L_0x00fa:
            r7 = r15
            int r1 = r3.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r2 = r2.size()
            if (r2 != 0) goto L_0x0199
            r2 = 0
        L_0x0108:
            if (r2 >= r1) goto L_0x013c
            java.lang.Object r5 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzls r5 = (com.google.android.gms.internal.ads.zzls) r5
            com.google.android.gms.internal.ads.zzlm r8 = new com.google.android.gms.internal.ads.zzlm
            com.google.android.gms.internal.ads.zzkc r9 = r0.zzaru
            int r10 = r5.type
            com.google.android.gms.internal.ads.zzkh r9 = r9.zze(r2, r10)
            r8.<init>(r9)
            int r9 = r5.f52604id
            java.lang.Object r9 = r7.get(r9)
            com.google.android.gms.internal.ads.zzlg r9 = (com.google.android.gms.internal.ads.zzlg) r9
            r8.zza(r5, r9)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r9 = r0.zzaxw
            int r10 = r5.f52604id
            r9.put(r10, r8)
            long r8 = r0.zzaiz
            long r10 = r5.zzaiz
            long r8 = java.lang.Math.max(r8, r10)
            r0.zzaiz = r8
            int r2 = r2 + 1
            goto L_0x0108
        L_0x013c:
            int r1 = r0.flags
            r1 = r1 & r6
            if (r1 == 0) goto L_0x0161
            com.google.android.gms.internal.ads.zzkh r1 = r0.zzayq
            if (r1 != 0) goto L_0x0161
            com.google.android.gms.internal.ads.zzkc r1 = r0.zzaru
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r2 = r2.size()
            com.google.android.gms.internal.ads.zzkh r1 = r1.zze(r2, r6)
            r0.zzayq = r1
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.String r5 = "application/x-emsg"
            com.google.android.gms.internal.ads.zzht r2 = com.google.android.gms.internal.ads.zzht.zza((java.lang.String) r4, (java.lang.String) r5, (long) r2)
            r1.zze(r2)
        L_0x0161:
            int r1 = r0.flags
            r2 = 8
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0192
            com.google.android.gms.internal.ads.zzkh[] r1 = r0.zzayr
            if (r1 != 0) goto L_0x0192
            com.google.android.gms.internal.ads.zzkc r1 = r0.zzaru
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 + r3
            r3 = 3
            com.google.android.gms.internal.ads.zzkh r1 = r1.zze(r2, r3)
            r2 = 0
            r4 = 0
            r5 = -1
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r3 = "application/cea-608"
            com.google.android.gms.internal.ads.zzht r2 = com.google.android.gms.internal.ads.zzht.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (int) r6, (java.lang.String) r7, (com.google.android.gms.internal.ads.zzjo) r8)
            r1.zze(r2)
            r2 = 1
            com.google.android.gms.internal.ads.zzkh[] r2 = new com.google.android.gms.internal.ads.zzkh[r2]
            r3 = 0
            r2[r3] = r1
            r0.zzayr = r2
        L_0x0192:
            com.google.android.gms.internal.ads.zzkc r1 = r0.zzaru
            r1.zzgw()
            goto L_0x0002
        L_0x0199:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r2 = r2.size()
            if (r2 != r1) goto L_0x01a3
            r9 = 1
            goto L_0x01a4
        L_0x01a3:
            r9 = 0
        L_0x01a4:
            com.google.android.gms.internal.ads.zzpg.checkState(r9)
            r8 = 0
        L_0x01a8:
            if (r8 >= r1) goto L_0x0002
            java.lang.Object r2 = r3.valueAt(r8)
            com.google.android.gms.internal.ads.zzls r2 = (com.google.android.gms.internal.ads.zzls) r2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r4 = r0.zzaxw
            int r5 = r2.f52604id
            java.lang.Object r4 = r4.get(r5)
            com.google.android.gms.internal.ads.zzlm r4 = (com.google.android.gms.internal.ads.zzlm) r4
            int r5 = r2.f52604id
            java.lang.Object r5 = r7.get(r5)
            com.google.android.gms.internal.ads.zzlg r5 = (com.google.android.gms.internal.ads.zzlg) r5
            r4.zza(r2, r5)
            int r8 = r8 + 1
            goto L_0x01a8
        L_0x01c8:
            int r2 = r1.type
            int r3 = com.google.android.gms.internal.ads.zzkw.zzaur
            if (r2 != r3) goto L_0x06de
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r2 = r0.zzaxw
            int r3 = r0.flags
            byte[] r5 = r0.zzayc
            java.util.List<com.google.android.gms.internal.ads.zzkv> r7 = r1.zzatg
            int r7 = r7.size()
            r8 = 0
        L_0x01db:
            if (r8 >= r7) goto L_0x06b2
            java.util.List<com.google.android.gms.internal.ads.zzkv> r9 = r1.zzatg
            java.lang.Object r9 = r9.get(r8)
            com.google.android.gms.internal.ads.zzkv r9 = (com.google.android.gms.internal.ads.zzkv) r9
            int r10 = r9.type
            int r11 = com.google.android.gms.internal.ads.zzkw.zzaus
            if (r10 != r11) goto L_0x0691
            int r10 = com.google.android.gms.internal.ads.zzkw.zzaue
            com.google.android.gms.internal.ads.zzky r10 = r9.zzas(r10)
            com.google.android.gms.internal.ads.zzpn r10 = r10.zzaxd
            r11 = 8
            r10.zzbl(r11)
            int r11 = r10.readInt()
            int r11 = com.google.android.gms.internal.ads.zzkw.zzav(r11)
            int r12 = r10.readInt()
            r13 = r3 & 16
            if (r13 != 0) goto L_0x0209
            goto L_0x020a
        L_0x0209:
            r12 = 0
        L_0x020a:
            java.lang.Object r12 = r2.get(r12)
            com.google.android.gms.internal.ads.zzlm r12 = (com.google.android.gms.internal.ads.zzlm) r12
            if (r12 != 0) goto L_0x0214
            r12 = r4
            goto L_0x025f
        L_0x0214:
            r13 = r11 & 1
            if (r13 == 0) goto L_0x0224
            long r13 = r10.zzjf()
            com.google.android.gms.internal.ads.zzlu r15 = r12.zzbab
            r15.zzbba = r13
            com.google.android.gms.internal.ads.zzlu r15 = r12.zzbab
            r15.zzbbb = r13
        L_0x0224:
            com.google.android.gms.internal.ads.zzlg r13 = r12.zzbad
            r14 = r11 & 2
            if (r14 == 0) goto L_0x0231
            int r14 = r10.zzje()
            r15 = 1
            int r14 = r14 - r15
            goto L_0x0233
        L_0x0231:
            int r14 = r13.zzaxs
        L_0x0233:
            r15 = r11 & 8
            if (r15 == 0) goto L_0x023c
            int r15 = r10.zzje()
            goto L_0x023e
        L_0x023c:
            int r15 = r13.duration
        L_0x023e:
            r16 = r11 & 16
            if (r16 == 0) goto L_0x0249
            int r16 = r10.zzje()
            r4 = r16
            goto L_0x024b
        L_0x0249:
            int r4 = r13.size
        L_0x024b:
            r11 = r11 & 32
            if (r11 == 0) goto L_0x0254
            int r10 = r10.zzje()
            goto L_0x0256
        L_0x0254:
            int r10 = r13.flags
        L_0x0256:
            com.google.android.gms.internal.ads.zzlu r11 = r12.zzbab
            com.google.android.gms.internal.ads.zzlg r13 = new com.google.android.gms.internal.ads.zzlg
            r13.<init>(r14, r15, r4, r10)
            r11.zzbay = r13
        L_0x025f:
            if (r12 == 0) goto L_0x0691
            com.google.android.gms.internal.ads.zzlu r4 = r12.zzbab
            long r10 = r4.zzbbp
            r12.reset()
            int r13 = com.google.android.gms.internal.ads.zzkw.zzaud
            com.google.android.gms.internal.ads.zzky r13 = r9.zzas(r13)
            if (r13 == 0) goto L_0x0295
            r13 = r3 & 2
            if (r13 != 0) goto L_0x0295
            int r10 = com.google.android.gms.internal.ads.zzkw.zzaud
            com.google.android.gms.internal.ads.zzky r10 = r9.zzas(r10)
            com.google.android.gms.internal.ads.zzpn r10 = r10.zzaxd
            r11 = 8
            r10.zzbl(r11)
            int r11 = r10.readInt()
            int r11 = com.google.android.gms.internal.ads.zzkw.zzau(r11)
            r13 = 1
            if (r11 != r13) goto L_0x0291
            long r10 = r10.zzjf()
            goto L_0x0295
        L_0x0291:
            long r10 = r10.zzjb()
        L_0x0295:
            java.util.List<com.google.android.gms.internal.ads.zzky> r13 = r9.zzatf
            int r14 = r13.size()
            r19 = r2
            r2 = 0
            r6 = 0
            r15 = 0
        L_0x02a0:
            if (r15 >= r14) goto L_0x02ce
            java.lang.Object r20 = r13.get(r15)
            r21 = r7
            r7 = r20
            com.google.android.gms.internal.ads.zzky r7 = (com.google.android.gms.internal.ads.zzky) r7
            r22 = r10
            int r10 = r7.type
            int r11 = com.google.android.gms.internal.ads.zzkw.zzaug
            if (r10 != r11) goto L_0x02c5
            com.google.android.gms.internal.ads.zzpn r7 = r7.zzaxd
            r10 = 12
            r7.zzbl(r10)
            int r7 = r7.zzje()
            if (r7 <= 0) goto L_0x02c7
            int r2 = r2 + r7
            int r6 = r6 + 1
            goto L_0x02c7
        L_0x02c5:
            r10 = 12
        L_0x02c7:
            int r15 = r15 + 1
            r7 = r21
            r10 = r22
            goto L_0x02a0
        L_0x02ce:
            r21 = r7
            r22 = r10
            r7 = 0
            r10 = 12
            r12.zzbag = r7
            r12.zzbaf = r7
            r12.zzbae = r7
            com.google.android.gms.internal.ads.zzlu r7 = r12.zzbab
            r7.zzbbc = r6
            r7.zzaxm = r2
            int[] r11 = r7.zzbbe
            if (r11 == 0) goto L_0x02ea
            int[] r11 = r7.zzbbe
            int r11 = r11.length
            if (r11 >= r6) goto L_0x02f2
        L_0x02ea:
            long[] r11 = new long[r6]
            r7.zzbbd = r11
            int[] r6 = new int[r6]
            r7.zzbbe = r6
        L_0x02f2:
            int[] r6 = r7.zzbbf
            if (r6 == 0) goto L_0x02fb
            int[] r6 = r7.zzbbf
            int r6 = r6.length
            if (r6 >= r2) goto L_0x0313
        L_0x02fb:
            int r2 = r2 * 125
            int r2 = r2 / 100
            int[] r6 = new int[r2]
            r7.zzbbf = r6
            int[] r6 = new int[r2]
            r7.zzbbg = r6
            long[] r6 = new long[r2]
            r7.zzbbh = r6
            boolean[] r6 = new boolean[r2]
            r7.zzbbi = r6
            boolean[] r2 = new boolean[r2]
            r7.zzbbk = r2
        L_0x0313:
            r2 = 0
            r6 = 0
            r7 = 0
        L_0x0316:
            r24 = 0
            if (r2 >= r14) goto L_0x04af
            java.lang.Object r18 = r13.get(r2)
            r10 = r18
            com.google.android.gms.internal.ads.zzky r10 = (com.google.android.gms.internal.ads.zzky) r10
            int r15 = r10.type
            int r11 = com.google.android.gms.internal.ads.zzkw.zzaug
            if (r15 != r11) goto L_0x047f
            int r11 = r6 + 1
            com.google.android.gms.internal.ads.zzpn r10 = r10.zzaxd
            r15 = 8
            r10.zzbl(r15)
            int r15 = r10.readInt()
            int r15 = com.google.android.gms.internal.ads.zzkw.zzav(r15)
            r27 = r11
            com.google.android.gms.internal.ads.zzls r11 = r12.zzbac
            r28 = r13
            com.google.android.gms.internal.ads.zzlu r13 = r12.zzbab
            r29 = r14
            com.google.android.gms.internal.ads.zzlg r14 = r13.zzbay
            int[] r0 = r13.zzbbe
            int r30 = r10.zzje()
            r0[r6] = r30
            long[] r0 = r13.zzbbd
            r31 = r4
            r30 = r5
            long r4 = r13.zzbba
            r0[r6] = r4
            r0 = r15 & 1
            if (r0 == 0) goto L_0x036e
            long[] r0 = r13.zzbbd
            r4 = r0[r6]
            r32 = r1
            int r1 = r10.readInt()
            r33 = r8
            r34 = r9
            long r8 = (long) r1
            long r4 = r4 + r8
            r0[r6] = r4
            goto L_0x0374
        L_0x036e:
            r32 = r1
            r33 = r8
            r34 = r9
        L_0x0374:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x037a
            r0 = 1
            goto L_0x037b
        L_0x037a:
            r0 = 0
        L_0x037b:
            int r1 = r14.flags
            if (r0 == 0) goto L_0x0383
            int r1 = r10.zzje()
        L_0x0383:
            r4 = r15 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0389
            r4 = 1
            goto L_0x038a
        L_0x0389:
            r4 = 0
        L_0x038a:
            r5 = r15 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0390
            r5 = 1
            goto L_0x0391
        L_0x0390:
            r5 = 0
        L_0x0391:
            r8 = r15 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x0397
            r8 = 1
            goto L_0x0398
        L_0x0397:
            r8 = 0
        L_0x0398:
            r9 = r15 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x039e
            r9 = 1
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            long[] r15 = r11.zzbav
            if (r15 == 0) goto L_0x03c4
            long[] r15 = r11.zzbav
            int r15 = r15.length
            r35 = r1
            r1 = 1
            if (r15 != r1) goto L_0x03c6
            long[] r1 = r11.zzbav
            r15 = 0
            r36 = r1[r15]
            int r1 = (r36 > r24 ? 1 : (r36 == r24 ? 0 : -1))
            if (r1 != 0) goto L_0x03c6
            long[] r1 = r11.zzbaw
            r36 = r1[r15]
            r38 = 1000(0x3e8, double:4.94E-321)
            r15 = r2
            long r1 = r11.zzdf
            r40 = r1
            long r24 = com.google.android.gms.internal.ads.zzpt.zza((long) r36, (long) r38, (long) r40)
            goto L_0x03c7
        L_0x03c4:
            r35 = r1
        L_0x03c6:
            r15 = r2
        L_0x03c7:
            int[] r1 = r13.zzbbf
            int[] r2 = r13.zzbbg
            r36 = r12
            long[] r12 = r13.zzbbh
            r37 = r15
            boolean[] r15 = r13.zzbbi
            r38 = r15
            int r15 = r11.type
            r39 = r1
            r1 = 2
            if (r15 != r1) goto L_0x03e2
            r1 = r3 & 1
            if (r1 == 0) goto L_0x03e2
            r1 = 1
            goto L_0x03e3
        L_0x03e2:
            r1 = 0
        L_0x03e3:
            int[] r15 = r13.zzbbe
            r15 = r15[r6]
            int r15 = r15 + r7
            r26 = r12
            long r11 = r11.zzdf
            r40 = r7
            if (r6 <= 0) goto L_0x03f3
            long r6 = r13.zzbbp
            goto L_0x03f5
        L_0x03f3:
            r6 = r22
        L_0x03f5:
            r46 = r3
            r3 = r40
        L_0x03f9:
            if (r3 >= r15) goto L_0x0479
            if (r4 == 0) goto L_0x0406
            int r40 = r10.zzje()
            r47 = r4
            r4 = r40
            goto L_0x040a
        L_0x0406:
            r47 = r4
            int r4 = r14.duration
        L_0x040a:
            if (r5 == 0) goto L_0x0415
            int r40 = r10.zzje()
            r48 = r5
            r5 = r40
            goto L_0x0419
        L_0x0415:
            r48 = r5
            int r5 = r14.size
        L_0x0419:
            if (r3 != 0) goto L_0x0422
            if (r0 == 0) goto L_0x0422
            r49 = r0
            r0 = r35
            goto L_0x0431
        L_0x0422:
            if (r8 == 0) goto L_0x042d
            int r40 = r10.readInt()
            r49 = r0
            r0 = r40
            goto L_0x0431
        L_0x042d:
            r49 = r0
            int r0 = r14.flags
        L_0x0431:
            if (r9 == 0) goto L_0x0443
            r50 = r8
            int r8 = r10.readInt()
            int r8 = r8 * 1000
            r51 = r9
            long r8 = (long) r8
            long r8 = r8 / r11
            int r9 = (int) r8
            r2[r3] = r9
            goto L_0x044a
        L_0x0443:
            r50 = r8
            r51 = r9
            r8 = 0
            r2[r3] = r8
        L_0x044a:
            r42 = 1000(0x3e8, double:4.94E-321)
            r40 = r6
            r44 = r11
            long r8 = com.google.android.gms.internal.ads.zzpt.zza((long) r40, (long) r42, (long) r44)
            long r8 = r8 - r24
            r26[r3] = r8
            r39[r3] = r5
            r5 = 16
            int r0 = r0 >> r5
            r5 = 1
            r0 = r0 & r5
            if (r0 != 0) goto L_0x0467
            if (r1 == 0) goto L_0x0465
            if (r3 != 0) goto L_0x0467
        L_0x0465:
            r0 = 1
            goto L_0x0468
        L_0x0467:
            r0 = 0
        L_0x0468:
            r38[r3] = r0
            long r4 = (long) r4
            long r6 = r6 + r4
            int r3 = r3 + 1
            r4 = r47
            r5 = r48
            r0 = r49
            r8 = r50
            r9 = r51
            goto L_0x03f9
        L_0x0479:
            r13.zzbbp = r6
            r7 = r15
            r6 = r27
            goto L_0x0495
        L_0x047f:
            r32 = r1
            r37 = r2
            r46 = r3
            r31 = r4
            r30 = r5
            r40 = r7
            r33 = r8
            r34 = r9
            r36 = r12
            r28 = r13
            r29 = r14
        L_0x0495:
            int r2 = r37 + 1
            r0 = r52
            r13 = r28
            r14 = r29
            r5 = r30
            r4 = r31
            r1 = r32
            r8 = r33
            r9 = r34
            r12 = r36
            r3 = r46
            r10 = 12
            goto L_0x0316
        L_0x04af:
            r32 = r1
            r46 = r3
            r31 = r4
            r30 = r5
            r33 = r8
            r34 = r9
            r36 = r12
            int r0 = com.google.android.gms.internal.ads.zzkw.zzavj
            com.google.android.gms.internal.ads.zzky r0 = r9.zzas(r0)
            if (r0 == 0) goto L_0x0544
            r4 = r36
            com.google.android.gms.internal.ads.zzls r1 = r4.zzbac
            com.google.android.gms.internal.ads.zzlr[] r1 = r1.zzbau
            r2 = r31
            com.google.android.gms.internal.ads.zzlg r3 = r2.zzbay
            int r3 = r3.zzaxs
            r1 = r1[r3]
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzaxd
            int r1 = r1.zzbaq
            r3 = 8
            r0.zzbl(r3)
            int r4 = r0.readInt()
            int r4 = com.google.android.gms.internal.ads.zzkw.zzav(r4)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x04eb
            r0.zzbm(r3)
        L_0x04eb:
            int r3 = r0.readUnsignedByte()
            int r4 = r0.zzje()
            int r5 = r2.zzaxm
            if (r4 != r5) goto L_0x0521
            if (r3 != 0) goto L_0x050e
            boolean[] r3 = r2.zzbbk
            r5 = 0
            r6 = 0
        L_0x04fd:
            if (r5 >= r4) goto L_0x051d
            int r7 = r0.readUnsignedByte()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x0508
            r7 = 1
            goto L_0x0509
        L_0x0508:
            r7 = 0
        L_0x0509:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x04fd
        L_0x050e:
            if (r3 <= r1) goto L_0x0512
            r0 = 1
            goto L_0x0513
        L_0x0512:
            r0 = 0
        L_0x0513:
            int r3 = r3 * r4
            r1 = 0
            int r6 = r3 + 0
            boolean[] r3 = r2.zzbbk
            java.util.Arrays.fill(r3, r1, r4, r0)
        L_0x051d:
            r2.zzax(r6)
            goto L_0x0546
        L_0x0521:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            int r1 = r2.zzaxm
            r2 = 41
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Length mismatch: "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r2 = ", "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0544:
            r2 = r31
        L_0x0546:
            int r0 = com.google.android.gms.internal.ads.zzkw.zzavk
            com.google.android.gms.internal.ads.zzky r0 = r9.zzas(r0)
            if (r0 == 0) goto L_0x0598
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzaxd
            r1 = 8
            r0.zzbl(r1)
            int r3 = r0.readInt()
            int r4 = com.google.android.gms.internal.ads.zzkw.zzav(r3)
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0564
            r0.zzbm(r1)
        L_0x0564:
            int r1 = r0.zzje()
            if (r1 != r5) goto L_0x057f
            int r1 = com.google.android.gms.internal.ads.zzkw.zzau(r3)
            long r3 = r2.zzbbb
            if (r1 != 0) goto L_0x0577
            long r0 = r0.zzjb()
            goto L_0x057b
        L_0x0577:
            long r0 = r0.zzjf()
        L_0x057b:
            long r3 = r3 + r0
            r2.zzbbb = r3
            goto L_0x0598
        L_0x057f:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            r2 = 40
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected saio entry count: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0598:
            int r0 = com.google.android.gms.internal.ads.zzkw.zzavo
            com.google.android.gms.internal.ads.zzky r0 = r9.zzas(r0)
            if (r0 == 0) goto L_0x05a6
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzaxd
            r1 = 0
            zza(r0, r1, r2)
        L_0x05a6:
            int r0 = com.google.android.gms.internal.ads.zzkw.zzavl
            com.google.android.gms.internal.ads.zzky r0 = r9.zzas(r0)
            int r1 = com.google.android.gms.internal.ads.zzkw.zzavm
            com.google.android.gms.internal.ads.zzky r1 = r9.zzas(r1)
            if (r0 == 0) goto L_0x064b
            if (r1 == 0) goto L_0x064b
            com.google.android.gms.internal.ads.zzpn r0 = r0.zzaxd
            com.google.android.gms.internal.ads.zzpn r1 = r1.zzaxd
            r3 = 8
            r0.zzbl(r3)
            int r3 = r0.readInt()
            int r4 = r0.readInt()
            int r5 = zzaxt
            if (r4 != r5) goto L_0x064b
            int r3 = com.google.android.gms.internal.ads.zzkw.zzau(r3)
            r4 = 1
            if (r3 != r4) goto L_0x05d6
            r3 = 4
            r0.zzbm(r3)
        L_0x05d6:
            int r0 = r0.readInt()
            if (r0 != r4) goto L_0x0643
            r0 = 8
            r1.zzbl(r0)
            int r0 = r1.readInt()
            int r3 = r1.readInt()
            int r5 = zzaxt
            if (r3 != r5) goto L_0x0641
            int r0 = com.google.android.gms.internal.ads.zzkw.zzau(r0)
            if (r0 != r4) goto L_0x0606
            long r3 = r1.zzjb()
            int r0 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r0 == 0) goto L_0x05fe
            r0 = 4
            r3 = 2
            goto L_0x060f
        L_0x05fe:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>(r1)
            throw r0
        L_0x0606:
            r3 = 2
            if (r0 < r3) goto L_0x060e
            r0 = 4
            r1.zzbm(r0)
            goto L_0x060f
        L_0x060e:
            r0 = 4
        L_0x060f:
            long r4 = r1.zzjb()
            r6 = 1
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0639
            r1.zzbm(r3)
            int r3 = r1.readUnsignedByte()
            r4 = 1
            if (r3 != r4) goto L_0x064d
            int r3 = r1.readUnsignedByte()
            r5 = 16
            byte[] r6 = new byte[r5]
            r7 = 0
            r1.zze(r6, r7, r5)
            r2.zzbbj = r4
            com.google.android.gms.internal.ads.zzlr r1 = new com.google.android.gms.internal.ads.zzlr
            r1.<init>(r4, r3, r6)
            r2.zzbbl = r1
            goto L_0x064d
        L_0x0639:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x0641:
            r0 = 4
            goto L_0x064d
        L_0x0643:
            com.google.android.gms.internal.ads.zzhw r0 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>(r1)
            throw r0
        L_0x064b:
            r0 = 4
            r4 = 1
        L_0x064d:
            java.util.List<com.google.android.gms.internal.ads.zzky> r1 = r9.zzatf
            int r1 = r1.size()
            r3 = 0
        L_0x0654:
            if (r3 >= r1) goto L_0x068b
            java.util.List<com.google.android.gms.internal.ads.zzky> r5 = r9.zzatf
            java.lang.Object r5 = r5.get(r3)
            com.google.android.gms.internal.ads.zzky r5 = (com.google.android.gms.internal.ads.zzky) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzkw.zzavn
            if (r6 != r7) goto L_0x067f
            com.google.android.gms.internal.ads.zzpn r5 = r5.zzaxd
            r6 = 8
            r5.zzbl(r6)
            r7 = r30
            r8 = 16
            r10 = 0
            r5.zze(r7, r10, r8)
            byte[] r11 = zzaxu
            boolean r11 = java.util.Arrays.equals(r7, r11)
            if (r11 == 0) goto L_0x0686
            zza(r5, r8, r2)
            goto L_0x0686
        L_0x067f:
            r7 = r30
            r6 = 8
            r8 = 16
            r10 = 0
        L_0x0686:
            int r3 = r3 + 1
            r30 = r7
            goto L_0x0654
        L_0x068b:
            r7 = r30
            r6 = 8
            r10 = 0
            goto L_0x06a1
        L_0x0691:
            r32 = r1
            r19 = r2
            r46 = r3
            r21 = r7
            r33 = r8
            r0 = 4
            r4 = 1
            r6 = 8
            r10 = 0
            r7 = r5
        L_0x06a1:
            int r8 = r33 + 1
            r0 = r52
            r5 = r7
            r2 = r19
            r7 = r21
            r1 = r32
            r3 = r46
            r4 = 0
            r6 = 4
            goto L_0x01db
        L_0x06b2:
            r10 = 0
            java.util.List<com.google.android.gms.internal.ads.zzky> r0 = r1.zzatf
            com.google.android.gms.internal.ads.zzjo r0 = zzb(r0)
            r2 = r52
            if (r0 == 0) goto L_0x06f2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r1 = r2.zzaxw
            int r1 = r1.size()
            r8 = 0
        L_0x06c4:
            if (r8 >= r1) goto L_0x06f2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzlm> r3 = r2.zzaxw
            java.lang.Object r3 = r3.valueAt(r8)
            com.google.android.gms.internal.ads.zzlm r3 = (com.google.android.gms.internal.ads.zzlm) r3
            com.google.android.gms.internal.ads.zzkh r4 = r3.zzasz
            com.google.android.gms.internal.ads.zzls r3 = r3.zzbac
            com.google.android.gms.internal.ads.zzht r3 = r3.zzaij
            com.google.android.gms.internal.ads.zzht r3 = r3.zza((com.google.android.gms.internal.ads.zzjo) r0)
            r4.zze(r3)
            int r8 = r8 + 1
            goto L_0x06c4
        L_0x06de:
            r2 = r0
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r0 = r2.zzayd
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06f2
            java.util.Stack<com.google.android.gms.internal.ads.zzkv> r0 = r2.zzayd
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzkv r0 = (com.google.android.gms.internal.ads.zzkv) r0
            r0.zza((com.google.android.gms.internal.ads.zzkv) r1)
        L_0x06f2:
            r0 = r2
            goto L_0x0002
        L_0x06f5:
            r2 = r0
            r52.zzhf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzeb(long):void");
    }

    private static void zza(zzpn zzpn, int i, zzlu zzlu) throws zzhw {
        zzpn.zzbl(i + 8);
        int zzav = zzkw.zzav(zzpn.readInt());
        if ((zzav & 1) == 0) {
            boolean z = (zzav & 2) != 0;
            int zzje = zzpn.zzje();
            if (zzje == zzlu.zzaxm) {
                Arrays.fill(zzlu.zzbbk, 0, zzje, z);
                zzlu.zzax(zzpn.zziz());
                zzpn.zze(zzlu.zzbbn.data, 0, zzlu.zzbbm);
                zzlu.zzbbn.zzbl(0);
                zzlu.zzbbo = false;
                return;
            }
            int i2 = zzlu.zzaxm;
            StringBuilder sb = new StringBuilder(41);
            sb.append("Length mismatch: ");
            sb.append(zzje);
            sb.append(", ");
            sb.append(i2);
            throw new zzhw(sb.toString());
        }
        throw new zzhw("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzjo zzb(java.util.List<com.google.android.gms.internal.ads.zzky> r15) {
        /*
            int r0 = r15.size()
            r1 = 0
            r2 = 0
            r4 = r2
            r3 = 0
        L_0x0008:
            if (r3 >= r0) goto L_0x00c5
            java.lang.Object r5 = r15.get(r3)
            com.google.android.gms.internal.ads.zzky r5 = (com.google.android.gms.internal.ads.zzky) r5
            int r6 = r5.type
            int r7 = com.google.android.gms.internal.ads.zzkw.zzavb
            if (r6 != r7) goto L_0x00c1
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.google.android.gms.internal.ads.zzpn r5 = r5.zzaxd
            byte[] r5 = r5.data
            com.google.android.gms.internal.ads.zzpn r6 = new com.google.android.gms.internal.ads.zzpn
            r6.<init>((byte[]) r5)
            int r7 = r6.limit()
            r8 = 32
            if (r7 >= r8) goto L_0x0030
        L_0x002e:
            r6 = r2
            goto L_0x009f
        L_0x0030:
            r6.zzbl(r1)
            int r7 = r6.readInt()
            int r8 = r6.zziz()
            int r8 = r8 + 4
            if (r7 == r8) goto L_0x0040
            goto L_0x002e
        L_0x0040:
            int r7 = r6.readInt()
            int r8 = com.google.android.gms.internal.ads.zzkw.zzavb
            if (r7 == r8) goto L_0x0049
            goto L_0x002e
        L_0x0049:
            int r7 = r6.readInt()
            int r7 = com.google.android.gms.internal.ads.zzkw.zzau(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x0073
            r6 = 37
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r6)
            java.lang.String r6 = "Unsupported pssh version: "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r11 = r8.toString()
            r9 = 5
            r12 = 0
            r14 = 655(0x28f, float:9.18E-43)
            java.lang.String r10 = "PsshAtomUtil"
            java.lang.String r13 = "com.google.android.gms.internal.ads.zzlh"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
            goto L_0x002e
        L_0x0073:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.readLong()
            long r12 = r6.readLong()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x008b
            int r7 = r6.zzje()
            int r7 = r7 << 4
            r6.zzbm(r7)
        L_0x008b:
            int r7 = r6.zzje()
            int r8 = r6.zziz()
            if (r7 == r8) goto L_0x0096
            goto L_0x002e
        L_0x0096:
            byte[] r8 = new byte[r7]
            r6.zze(r8, r1, r7)
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x009f:
            if (r6 != 0) goto L_0x00a3
            r6 = r2
            goto L_0x00a7
        L_0x00a3:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x00a7:
            if (r6 != 0) goto L_0x00b7
            r7 = 5
            r10 = 0
            r12 = 673(0x2a1, float:9.43E-43)
            java.lang.String r8 = "FragmentedMp4Extractor"
            java.lang.String r9 = "Skipped pssh atom (failed to extract uuid)"
            java.lang.String r11 = "com.google.android.gms.internal.ads.zzlh"
            com.didi.sdk.apm.SystemUtils.log(r7, r8, r9, r10, r11, r12)
            goto L_0x00c1
        L_0x00b7:
            com.google.android.gms.internal.ads.zzjo$zza r7 = new com.google.android.gms.internal.ads.zzjo$zza
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5)
            r4.add(r7)
        L_0x00c1:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00c5:
            if (r4 != 0) goto L_0x00c8
            return r2
        L_0x00c8:
            com.google.android.gms.internal.ads.zzjo r15 = new com.google.android.gms.internal.ads.zzjo
            r15.<init>((java.util.List<com.google.android.gms.internal.ads.zzjo.zza>) r4)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlh.zzb(java.util.List):com.google.android.gms.internal.ads.zzjo");
    }
}
