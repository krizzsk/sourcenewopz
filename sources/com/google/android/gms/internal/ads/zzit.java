package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzit {
    private static boolean zzakb = false;
    private static boolean zzakc = false;
    private int streamType;
    private zzhz zzafp;
    private int zzahz;
    private final zzig zzakd = null;
    private final zzja zzake;
    private final zzjj zzakf;
    private final zzij[] zzakg;
    private final zziz zzakh;
    /* access modifiers changed from: private */
    public final ConditionVariable zzaki;
    private final long[] zzakj;
    private final zziv zzakk;
    private final LinkedList<zziy> zzakl;
    private AudioTrack zzakm;
    private int zzakn;
    private int zzako;
    private int zzakp;
    private boolean zzakq;
    private int zzakr;
    private long zzaks;
    private zzhz zzakt;
    private long zzaku;
    private long zzakv;
    private ByteBuffer zzakw;
    private int zzakx;
    private int zzaky;
    private int zzakz;
    private long zzala;
    private long zzalb;
    private boolean zzalc;
    private long zzald;
    private Method zzale;
    private int zzalf;
    private long zzalg;
    private long zzalh;
    private int zzali;
    private long zzalj;
    private long zzalk;
    private int zzall;
    private int zzalm;
    private long zzaln;
    private long zzalo;
    private long zzalp;
    private zzij[] zzalq;
    private ByteBuffer[] zzalr;
    private ByteBuffer zzals;
    private ByteBuffer zzalt;
    private byte[] zzalu;
    private int zzalv;
    private int zzalw;
    private boolean zzalx;
    private boolean zzaly;
    private int zzalz;
    private boolean zzama;
    private boolean zzamb;
    private long zzamc;
    private float zzdi;

    public zzit(zzig zzig, zzij[] zzijArr, zziz zziz) {
        this.zzakh = zziz;
        this.zzaki = new ConditionVariable(true);
        if (zzpt.SDK_INT >= 18) {
            try {
                this.zzale = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzpt.SDK_INT >= 19) {
            this.zzakk = new zziu();
        } else {
            this.zzakk = new zziv((zzis) null);
        }
        this.zzake = new zzja();
        this.zzakf = new zzjj();
        zzij[] zzijArr2 = new zzij[(zzijArr.length + 3)];
        this.zzakg = zzijArr2;
        zzijArr2[0] = new zzjh();
        zzij[] zzijArr3 = this.zzakg;
        zzijArr3[1] = this.zzake;
        System.arraycopy(zzijArr, 0, zzijArr3, 2, zzijArr.length);
        this.zzakg[zzijArr.length + 2] = this.zzakf;
        this.zzakj = new long[10];
        this.zzdi = 1.0f;
        this.zzalm = 0;
        this.streamType = 3;
        this.zzalz = 0;
        this.zzafp = zzhz.zzaik;
        this.zzalw = -1;
        this.zzalq = new zzij[0];
        this.zzalr = new ByteBuffer[0];
        this.zzakl = new LinkedList<>();
    }

    public final long zzk(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!(isInitialized() && this.zzalm != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzakm.getPlayState() == 3) {
            long zzgg = this.zzakk.zzgg();
            if (zzgg != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzalb >= 30000) {
                    long[] jArr = this.zzakj;
                    int i = this.zzaky;
                    jArr[i] = zzgg - nanoTime;
                    this.zzaky = (i + 1) % 10;
                    int i2 = this.zzakz;
                    if (i2 < 10) {
                        this.zzakz = i2 + 1;
                    }
                    this.zzalb = nanoTime;
                    this.zzala = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzakz;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzala += this.zzakj[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzgb() && nanoTime - this.zzald >= 500000) {
                    boolean zzgc = this.zzakk.zzgc();
                    this.zzalc = zzgc;
                    if (zzgc) {
                        long zzgd = this.zzakk.zzgd() / 1000;
                        long zzge = this.zzakk.zzge();
                        if (zzgd < this.zzalo) {
                            this.zzalc = false;
                        } else if (Math.abs(zzgd - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(zzge);
                            sb.append(", ");
                            sb.append(zzgd);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(zzgg);
                            SystemUtils.log(5, "AudioTrack", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzit", 60);
                            this.zzalc = false;
                        } else if (Math.abs(zzdw(zzge) - zzgg) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(zzge);
                            sb2.append(", ");
                            sb2.append(zzgd);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(zzgg);
                            SystemUtils.log(5, "AudioTrack", sb2.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzit", 64);
                            this.zzalc = false;
                        }
                    }
                    Method method = this.zzale;
                    if (method != null && !this.zzakq) {
                        try {
                            long intValue = (((long) ((Integer) method.invoke(this.zzakm, (Object[]) null)).intValue()) * 1000) - this.zzaks;
                            this.zzalp = intValue;
                            long max = Math.max(intValue, 0);
                            this.zzalp = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                SystemUtils.log(5, "AudioTrack", sb3.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzit", 70);
                                this.zzalp = 0;
                            }
                        } catch (Exception unused) {
                            this.zzale = null;
                        }
                    }
                    this.zzald = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzalc) {
            j = zzdw(this.zzakk.zzge() + zzdx(nanoTime2 - (this.zzakk.zzgd() / 1000)));
        } else {
            if (this.zzakz == 0) {
                j = this.zzakk.zzgg();
            } else {
                j = nanoTime2 + this.zzala;
            }
            if (!z) {
                j -= this.zzalp;
            }
        }
        long j5 = this.zzaln;
        while (!this.zzakl.isEmpty() && j >= this.zzakl.getFirst().zzagu) {
            zziy remove = this.zzakl.remove();
            this.zzafp = remove.zzafp;
            this.zzakv = remove.zzagu;
            this.zzaku = remove.zzamp - this.zzaln;
        }
        if (this.zzafp.zzail == 1.0f) {
            j2 = (j + this.zzaku) - this.zzakv;
        } else {
            if (!this.zzakl.isEmpty() || this.zzakf.zzgp() < 1024) {
                j3 = this.zzaku;
                j4 = (long) (((double) this.zzafp.zzail) * ((double) (j - this.zzakv)));
            } else {
                j3 = this.zzaku;
                j4 = zzpt.zza(j - this.zzakv, this.zzakf.zzgo(), this.zzakf.zzgp());
            }
            j2 = j4 + j3;
        }
        return j5 + j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0122 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r18, int r19, int r20, int r21, int r22, int[] r23) throws com.google.android.gms.internal.ads.zzix {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r20
            java.lang.String r3 = "audio/raw"
            boolean r3 = r3.equals(r0)
            r4 = 1
            r3 = r3 ^ r4
            r5 = 7
            r6 = 6
            r7 = 5
            r8 = 3
            r9 = 2
            if (r3 == 0) goto L_0x0058
            r11 = -1
            int r12 = r18.hashCode()
            switch(r12) {
                case -1095064472: goto L_0x003c;
                case 187078296: goto L_0x0032;
                case 1504578661: goto L_0x0028;
                case 1505942594: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0045
        L_0x001e:
            java.lang.String r12 = "audio/vnd.dts.hd"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0045
            r11 = 3
            goto L_0x0045
        L_0x0028:
            java.lang.String r12 = "audio/eac3"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0045
            r11 = 1
            goto L_0x0045
        L_0x0032:
            java.lang.String r12 = "audio/ac3"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0045
            r11 = 0
            goto L_0x0045
        L_0x003c:
            java.lang.String r12 = "audio/vnd.dts"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0045
            r11 = 2
        L_0x0045:
            if (r11 == 0) goto L_0x0056
            if (r11 == r4) goto L_0x0054
            if (r11 == r9) goto L_0x0052
            if (r11 == r8) goto L_0x004f
            r0 = 0
            goto L_0x005a
        L_0x004f:
            r0 = 8
            goto L_0x005a
        L_0x0052:
            r0 = 7
            goto L_0x005a
        L_0x0054:
            r0 = 6
            goto L_0x005a
        L_0x0056:
            r0 = 5
            goto L_0x005a
        L_0x0058:
            r0 = r21
        L_0x005a:
            r11 = r19
            if (r3 != 0) goto L_0x009b
            r12 = r21
            int r12 = com.google.android.gms.internal.ads.zzpt.zzi(r12, r11)
            r1.zzalf = r12
            com.google.android.gms.internal.ads.zzja r12 = r1.zzake
            r13 = r23
            r12.zzb(r13)
            com.google.android.gms.internal.ads.zzij[] r12 = r1.zzakg
            int r13 = r12.length
            r14 = 0
            r15 = 0
        L_0x0072:
            if (r14 >= r13) goto L_0x0095
            r10 = r12[r14]
            boolean r16 = r10.zzb(r2, r11, r0)     // Catch:{ zzii -> 0x008d }
            r15 = r15 | r16
            boolean r16 = r10.isActive()
            if (r16 == 0) goto L_0x008a
            int r11 = r10.zzfn()
            int r0 = r10.zzfo()
        L_0x008a:
            int r14 = r14 + 1
            goto L_0x0072
        L_0x008d:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzix r0 = new com.google.android.gms.internal.ads.zzix
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0095:
            if (r15 == 0) goto L_0x009c
            r17.zzfr()
            goto L_0x009c
        L_0x009b:
            r15 = 0
        L_0x009c:
            r12 = 12
            switch(r11) {
                case 1: goto L_0x00cf;
                case 2: goto L_0x00cc;
                case 3: goto L_0x00c9;
                case 4: goto L_0x00c6;
                case 5: goto L_0x00c3;
                case 6: goto L_0x00c0;
                case 7: goto L_0x00bd;
                case 8: goto L_0x00ba;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            com.google.android.gms.internal.ads.zzix r0 = new com.google.android.gms.internal.ads.zzix
            r2 = 38
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unsupported channel count: "
            r3.append(r2)
            r3.append(r11)
            java.lang.String r2 = r3.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x00ba:
            int r13 = com.google.android.gms.internal.ads.zzhf.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00d0
        L_0x00bd:
            r13 = 1276(0x4fc, float:1.788E-42)
            goto L_0x00d0
        L_0x00c0:
            r13 = 252(0xfc, float:3.53E-43)
            goto L_0x00d0
        L_0x00c3:
            r13 = 220(0xdc, float:3.08E-43)
            goto L_0x00d0
        L_0x00c6:
            r13 = 204(0xcc, float:2.86E-43)
            goto L_0x00d0
        L_0x00c9:
            r13 = 28
            goto L_0x00d0
        L_0x00cc:
            r13 = 12
            goto L_0x00d0
        L_0x00cf:
            r13 = 4
        L_0x00d0:
            int r14 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r10 = 23
            if (r14 > r10) goto L_0x00f7
            java.lang.String r10 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r14 = "foster"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x00f7
            java.lang.String r10 = com.google.android.gms.internal.ads.zzpt.MANUFACTURER
            java.lang.String r14 = "NVIDIA"
            boolean r10 = r14.equals(r10)
            if (r10 == 0) goto L_0x00f7
            if (r11 == r8) goto L_0x00f4
            if (r11 == r7) goto L_0x00f4
            if (r11 == r5) goto L_0x00f1
            goto L_0x00f7
        L_0x00f1:
            int r10 = com.google.android.gms.internal.ads.zzhf.CHANNEL_OUT_7POINT1_SURROUND
            goto L_0x00f8
        L_0x00f4:
            r10 = 252(0xfc, float:3.53E-43)
            goto L_0x00f8
        L_0x00f7:
            r10 = r13
        L_0x00f8:
            int r5 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r8 = 25
            if (r5 > r8) goto L_0x010d
            java.lang.String r5 = com.google.android.gms.internal.ads.zzpt.DEVICE
            java.lang.String r8 = "fugu"
            boolean r5 = r8.equals(r5)
            if (r5 == 0) goto L_0x010d
            if (r3 == 0) goto L_0x010d
            if (r11 != r4) goto L_0x010d
            goto L_0x010e
        L_0x010d:
            r12 = r10
        L_0x010e:
            if (r15 != 0) goto L_0x0123
            boolean r5 = r17.isInitialized()
            if (r5 == 0) goto L_0x0123
            int r5 = r1.zzako
            if (r5 != r0) goto L_0x0123
            int r5 = r1.zzahz
            if (r5 != r2) goto L_0x0123
            int r5 = r1.zzakn
            if (r5 != r12) goto L_0x0123
            return
        L_0x0123:
            r17.reset()
            r1.zzako = r0
            r1.zzakq = r3
            r1.zzahz = r2
            r1.zzakn = r12
            if (r3 == 0) goto L_0x0131
            goto L_0x0132
        L_0x0131:
            r0 = 2
        L_0x0132:
            r1.zzakp = r0
            int r0 = com.google.android.gms.internal.ads.zzpt.zzi(r9, r11)
            r1.zzali = r0
            if (r3 == 0) goto L_0x014a
            int r0 = r1.zzakp
            if (r0 == r7) goto L_0x0147
            if (r0 != r6) goto L_0x0143
            goto L_0x0147
        L_0x0143:
            r0 = 49152(0xc000, float:6.8877E-41)
            goto L_0x0180
        L_0x0147:
            r0 = 20480(0x5000, float:2.8699E-41)
            goto L_0x0180
        L_0x014a:
            int r0 = r1.zzakp
            int r0 = android.media.AudioTrack.getMinBufferSize(r2, r12, r0)
            r2 = -2
            if (r0 == r2) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r4 = 0
        L_0x0155:
            com.google.android.gms.internal.ads.zzpg.checkState(r4)
            int r2 = r0 << 2
            r4 = 250000(0x3d090, double:1.235164E-318)
            long r4 = r1.zzdx(r4)
            int r5 = (int) r4
            int r4 = r1.zzali
            int r4 = r4 * r5
            long r5 = (long) r0
            r7 = 750000(0xb71b0, double:3.70549E-318)
            long r7 = r1.zzdx(r7)
            int r0 = r1.zzali
            long r9 = (long) r0
            long r7 = r7 * r9
            long r5 = java.lang.Math.max(r5, r7)
            int r0 = (int) r5
            if (r2 >= r4) goto L_0x017c
            r0 = r4
            goto L_0x0180
        L_0x017c:
            if (r2 <= r0) goto L_0x017f
            goto L_0x0180
        L_0x017f:
            r0 = r2
        L_0x0180:
            r1.zzakr = r0
            if (r3 == 0) goto L_0x018a
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x0192
        L_0x018a:
            int r2 = r1.zzali
            int r0 = r0 / r2
            long r2 = (long) r0
            long r2 = r1.zzdw(r2)
        L_0x0192:
            r1.zzaks = r2
            com.google.android.gms.internal.ads.zzhz r0 = r1.zzafp
            r1.zzb(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void zzfr() {
        ArrayList arrayList = new ArrayList();
        for (zzij zzij : this.zzakg) {
            if (zzij.isActive()) {
                arrayList.add(zzij);
            } else {
                zzij.flush();
            }
        }
        int size = arrayList.size();
        this.zzalq = (zzij[]) arrayList.toArray(new zzij[size]);
        this.zzalr = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzij zzij2 = this.zzalq[i];
            zzij2.flush();
            this.zzalr[i] = zzij2.zzfq();
        }
    }

    public final void play() {
        this.zzaly = true;
        if (isInitialized()) {
            this.zzalo = System.nanoTime() / 1000;
            this.zzakm.play();
        }
    }

    public final void zzfs() {
        if (this.zzalm == 1) {
            this.zzalm = 2;
        }
    }

    public final boolean zzb(ByteBuffer byteBuffer, long j) throws zziw, zzjb {
        int i;
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        ByteBuffer byteBuffer3 = this.zzals;
        zzpg.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (!isInitialized()) {
            this.zzaki.block();
            if (this.zzama) {
                this.zzakm = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzakn).setEncoding(this.zzakp).setSampleRate(this.zzahz).build(), this.zzakr, 1, this.zzalz);
            } else if (this.zzalz == 0) {
                this.zzakm = new AudioTrack(this.streamType, this.zzahz, this.zzakn, this.zzakp, this.zzakr, 1);
            } else {
                this.zzakm = new AudioTrack(this.streamType, this.zzahz, this.zzakn, this.zzakp, this.zzakr, 1, this.zzalz);
            }
            int state = this.zzakm.getState();
            if (state == 1) {
                int audioSessionId = this.zzakm.getAudioSessionId();
                if (this.zzalz != audioSessionId) {
                    this.zzalz = audioSessionId;
                    this.zzakh.zzaa(audioSessionId);
                }
                this.zzakk.zza(this.zzakm, zzgb());
                zzfy();
                this.zzamb = false;
                if (this.zzaly) {
                    play();
                }
            } else {
                try {
                    this.zzakm.release();
                } catch (Exception unused) {
                } finally {
                    this.zzakm = null;
                }
                throw new zziw(state, this.zzahz, this.zzakn, this.zzakr);
            }
        }
        if (zzgb()) {
            if (this.zzakm.getPlayState() == 2) {
                this.zzamb = false;
                return false;
            } else if (this.zzakm.getPlayState() == 1 && this.zzakk.zzgf() != 0) {
                return false;
            }
        }
        boolean z = this.zzamb;
        boolean zzfv = zzfv();
        this.zzamb = zzfv;
        if (z && !zzfv && this.zzakm.getPlayState() != 1) {
            this.zzakh.zzc(this.zzakr, zzhf.zzdo(this.zzaks), SystemClock.elapsedRealtime() - this.zzamc);
        }
        if (this.zzals == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzakq && this.zzall == 0) {
                int i3 = this.zzakp;
                if (i3 == 7 || i3 == 8) {
                    i2 = zzjd.zzo(byteBuffer);
                } else if (i3 == 5) {
                    i2 = zzih.zzfm();
                } else if (i3 == 6) {
                    i2 = zzih.zzm(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzall = i2;
            }
            if (this.zzakt != null) {
                if (!zzfu()) {
                    return false;
                }
                LinkedList<zziy> linkedList = this.zzakl;
                zziy zziy = r11;
                zziy zziy2 = new zziy(this.zzakt, Math.max(0, j2), zzdw(zzfz()), (zzis) null);
                linkedList.add(zziy);
                this.zzakt = null;
                zzfr();
            }
            if (this.zzalm == 0) {
                this.zzaln = Math.max(0, j2);
                this.zzalm = 1;
            } else {
                long zzdw = this.zzaln + zzdw(this.zzakq ? this.zzalh : this.zzalg / ((long) this.zzalf));
                if (this.zzalm != 1 || Math.abs(zzdw - j2) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzdw);
                    sb2.append(", got ");
                    sb2.append(j2);
                    sb2.append(Const.jaRight);
                    SystemUtils.log(6, "AudioTrack", sb2.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzit", 290);
                    i = 2;
                    this.zzalm = 2;
                }
                if (this.zzalm == i) {
                    this.zzaln += j2 - zzdw;
                    this.zzalm = 1;
                    this.zzakh.zzen();
                }
            }
            if (this.zzakq) {
                this.zzalh += (long) this.zzall;
            } else {
                this.zzalg += (long) byteBuffer.remaining();
            }
            this.zzals = byteBuffer2;
        }
        if (this.zzakq) {
            zzc(this.zzals, j2);
        } else {
            zzdv(j2);
        }
        if (this.zzals.hasRemaining()) {
            return false;
        }
        this.zzals = null;
        return true;
    }

    private final void zzdv(long j) throws zzjb {
        ByteBuffer byteBuffer;
        int length = this.zzalq.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzalr[i - 1];
            } else {
                byteBuffer = this.zzals;
                if (byteBuffer == null) {
                    byteBuffer = zzij.zzajm;
                }
            }
            if (i == length) {
                zzc(byteBuffer, j);
            } else {
                zzij zzij = this.zzalq[i];
                zzij.zzn(byteBuffer);
                ByteBuffer zzfq = zzij.zzfq();
                this.zzalr[i] = zzfq;
                if (zzfq.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d7, code lost:
        if (r11 < r10) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzc(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzjb {
        /*
            r8 = this;
            boolean r0 = r9.hasRemaining()
            r1 = 1
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.nio.ByteBuffer r0 = r8.zzalt
            r2 = 21
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r9) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            com.google.android.gms.internal.ads.zzpg.checkArgument(r0)
            goto L_0x003b
        L_0x0018:
            r8.zzalt = r9
            int r0 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r0 >= r2) goto L_0x003b
            int r0 = r9.remaining()
            byte[] r4 = r8.zzalu
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r8.zzalu = r4
        L_0x002d:
            int r4 = r9.position()
            byte[] r5 = r8.zzalu
            r9.get(r5, r3, r0)
            r9.position(r4)
            r8.zzalv = r3
        L_0x003b:
            int r0 = r9.remaining()
            int r4 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            if (r4 >= r2) goto L_0x0079
            long r10 = r8.zzalj
            com.google.android.gms.internal.ads.zziv r2 = r8.zzakk
            long r4 = r2.zzgf()
            int r2 = r8.zzali
            long r6 = (long) r2
            long r4 = r4 * r6
            long r10 = r10 - r4
            int r11 = (int) r10
            int r10 = r8.zzakr
            int r10 = r10 - r11
            if (r10 <= 0) goto L_0x0076
            int r10 = java.lang.Math.min(r0, r10)
            android.media.AudioTrack r11 = r8.zzakm
            byte[] r2 = r8.zzalu
            int r4 = r8.zzalv
            int r10 = r11.write(r2, r4, r10)
            if (r10 <= 0) goto L_0x00f0
            int r11 = r8.zzalv
            int r11 = r11 + r10
            r8.zzalv = r11
            int r11 = r9.position()
            int r11 = r11 + r10
            r9.position(r11)
            goto L_0x00f0
        L_0x0076:
            r10 = 0
            goto L_0x00f0
        L_0x0079:
            boolean r2 = r8.zzama
            if (r2 == 0) goto L_0x00ea
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0088
            r2 = 1
            goto L_0x0089
        L_0x0088:
            r2 = 0
        L_0x0089:
            com.google.android.gms.internal.ads.zzpg.checkState(r2)
            android.media.AudioTrack r2 = r8.zzakm
            java.nio.ByteBuffer r4 = r8.zzakw
            if (r4 != 0) goto L_0x00a7
            r4 = 16
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)
            r8.zzakw = r4
            java.nio.ByteOrder r5 = java.nio.ByteOrder.BIG_ENDIAN
            r4.order(r5)
            java.nio.ByteBuffer r4 = r8.zzakw
            r5 = 1431633921(0x55550001, float:1.46372496E13)
            r4.putInt(r5)
        L_0x00a7:
            int r4 = r8.zzakx
            if (r4 != 0) goto L_0x00c3
            java.nio.ByteBuffer r4 = r8.zzakw
            r5 = 4
            r4.putInt(r5, r0)
            java.nio.ByteBuffer r4 = r8.zzakw
            r5 = 8
            r6 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 * r6
            r4.putLong(r5, r10)
            java.nio.ByteBuffer r10 = r8.zzakw
            r10.position(r3)
            r8.zzakx = r0
        L_0x00c3:
            java.nio.ByteBuffer r10 = r8.zzakw
            int r10 = r10.remaining()
            if (r10 <= 0) goto L_0x00da
            java.nio.ByteBuffer r11 = r8.zzakw
            int r11 = r2.write(r11, r10, r1)
            if (r11 >= 0) goto L_0x00d7
            r8.zzakx = r3
            r10 = r11
            goto L_0x00f0
        L_0x00d7:
            if (r11 >= r10) goto L_0x00da
            goto L_0x0076
        L_0x00da:
            int r9 = r2.write(r9, r0, r1)
            if (r9 >= 0) goto L_0x00e3
            r8.zzakx = r3
            goto L_0x00e8
        L_0x00e3:
            int r10 = r8.zzakx
            int r10 = r10 - r9
            r8.zzakx = r10
        L_0x00e8:
            r10 = r9
            goto L_0x00f0
        L_0x00ea:
            android.media.AudioTrack r10 = r8.zzakm
            int r10 = r10.write(r9, r0, r1)
        L_0x00f0:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r8.zzamc = r4
            if (r10 < 0) goto L_0x0115
            boolean r9 = r8.zzakq
            if (r9 != 0) goto L_0x0102
            long r4 = r8.zzalj
            long r6 = (long) r10
            long r4 = r4 + r6
            r8.zzalj = r4
        L_0x0102:
            if (r10 != r0) goto L_0x0114
            boolean r9 = r8.zzakq
            if (r9 == 0) goto L_0x0110
            long r9 = r8.zzalk
            int r11 = r8.zzall
            long r2 = (long) r11
            long r9 = r9 + r2
            r8.zzalk = r9
        L_0x0110:
            r9 = 0
            r8.zzalt = r9
            return r1
        L_0x0114:
            return r3
        L_0x0115:
            com.google.android.gms.internal.ads.zzjb r9 = new com.google.android.gms.internal.ads.zzjb
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zzc(java.nio.ByteBuffer, long):boolean");
    }

    public final void zzft() throws zzjb {
        if (!this.zzalx && isInitialized() && zzfu()) {
            this.zzakk.zzdy(zzfz());
            this.zzakx = 0;
            this.zzalx = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzfu() throws com.google.android.gms.internal.ads.zzjb {
        /*
            r9 = this;
            int r0 = r9.zzalw
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x0014
            boolean r0 = r9.zzakq
            if (r0 == 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzij[] r0 = r9.zzalq
            int r0 = r0.length
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r9.zzalw = r0
        L_0x0012:
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            int r4 = r9.zzalw
            com.google.android.gms.internal.ads.zzij[] r5 = r9.zzalq
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x0038
            r4 = r5[r4]
            if (r0 == 0) goto L_0x0028
            r4.zzfp()
        L_0x0028:
            r9.zzdv(r7)
            boolean r0 = r4.zzfi()
            if (r0 != 0) goto L_0x0032
            return r3
        L_0x0032:
            int r0 = r9.zzalw
            int r0 = r0 + r2
            r9.zzalw = r0
            goto L_0x0012
        L_0x0038:
            java.nio.ByteBuffer r0 = r9.zzalt
            if (r0 == 0) goto L_0x0044
            r9.zzc(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzalt
            if (r0 == 0) goto L_0x0044
            return r3
        L_0x0044:
            r9.zzalw = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzit.zzfu():boolean");
    }

    public final boolean zzfi() {
        if (isInitialized()) {
            return this.zzalx && !zzfv();
        }
        return true;
    }

    public final boolean zzfv() {
        if (isInitialized()) {
            if (zzfz() <= this.zzakk.zzgf()) {
                if (zzgb() && this.zzakm.getPlayState() == 2 && this.zzakm.getPlaybackHeadPosition() == 0) {
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public final zzhz zzb(zzhz zzhz) {
        if (this.zzakq) {
            zzhz zzhz2 = zzhz.zzaik;
            this.zzafp = zzhz2;
            return zzhz2;
        }
        zzhz zzhz3 = new zzhz(this.zzakf.zzb(zzhz.zzail), this.zzakf.zzc(zzhz.zzaim));
        zzhz zzhz4 = this.zzakt;
        if (zzhz4 == null) {
            if (!this.zzakl.isEmpty()) {
                zzhz4 = this.zzakl.getLast().zzafp;
            } else {
                zzhz4 = this.zzafp;
            }
        }
        if (!zzhz3.equals(zzhz4)) {
            if (isInitialized()) {
                this.zzakt = zzhz3;
            } else {
                this.zzafp = zzhz3;
            }
        }
        return this.zzafp;
    }

    public final zzhz zzfw() {
        return this.zzafp;
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            if (!this.zzama) {
                reset();
                this.zzalz = 0;
            }
        }
    }

    public final void zzfx() {
        if (this.zzama) {
            this.zzama = false;
            this.zzalz = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.zzdi != f) {
            this.zzdi = f;
            zzfy();
        }
    }

    private final void zzfy() {
        if (!isInitialized()) {
            return;
        }
        if (zzpt.SDK_INT >= 21) {
            this.zzakm.setVolume(this.zzdi);
            return;
        }
        AudioTrack audioTrack = this.zzakm;
        float f = this.zzdi;
        audioTrack.setStereoVolume(f, f);
    }

    public final void pause() {
        this.zzaly = false;
        if (isInitialized()) {
            zzga();
            this.zzakk.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzalg = 0;
            this.zzalh = 0;
            this.zzalj = 0;
            this.zzalk = 0;
            this.zzall = 0;
            zzhz zzhz = this.zzakt;
            if (zzhz != null) {
                this.zzafp = zzhz;
                this.zzakt = null;
            } else if (!this.zzakl.isEmpty()) {
                this.zzafp = this.zzakl.getLast().zzafp;
            }
            this.zzakl.clear();
            this.zzaku = 0;
            this.zzakv = 0;
            this.zzals = null;
            this.zzalt = null;
            int i = 0;
            while (true) {
                zzij[] zzijArr = this.zzalq;
                if (i >= zzijArr.length) {
                    break;
                }
                zzij zzij = zzijArr[i];
                zzij.flush();
                this.zzalr[i] = zzij.zzfq();
                i++;
            }
            this.zzalx = false;
            this.zzalw = -1;
            this.zzakw = null;
            this.zzakx = 0;
            this.zzalm = 0;
            this.zzalp = 0;
            zzga();
            if (this.zzakm.getPlayState() == 3) {
                this.zzakm.pause();
            }
            AudioTrack audioTrack = this.zzakm;
            this.zzakm = null;
            this.zzakk.zza((AudioTrack) null, false);
            this.zzaki.close();
            new zzis(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzij reset : this.zzakg) {
            reset.reset();
        }
        this.zzalz = 0;
        this.zzaly = false;
    }

    private final boolean isInitialized() {
        return this.zzakm != null;
    }

    private final long zzdw(long j) {
        return (j * 1000000) / ((long) this.zzahz);
    }

    private final long zzdx(long j) {
        return (j * ((long) this.zzahz)) / 1000000;
    }

    private final long zzfz() {
        return this.zzakq ? this.zzalk : this.zzalj / ((long) this.zzali);
    }

    private final void zzga() {
        this.zzala = 0;
        this.zzakz = 0;
        this.zzaky = 0;
        this.zzalb = 0;
        this.zzalc = false;
        this.zzald = 0;
    }

    private final boolean zzgb() {
        if (zzpt.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzakp;
        return i == 5 || i == 6;
    }
}
