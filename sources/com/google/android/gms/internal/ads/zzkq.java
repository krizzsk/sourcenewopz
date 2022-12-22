package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzjo;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzkq implements zzka {
    private static final zzkb zzapu = new zzkp();
    private static final byte[] zzapv = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzapw = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    /* access modifiers changed from: private */
    public static final UUID zzapx = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaiz;
    private final zzkt zzapm;
    private final zzko zzapy;
    private final SparseArray<zzkr> zzapz;
    private final boolean zzaqa;
    private final zzpn zzaqb;
    private final zzpn zzaqc;
    private final zzpn zzaqd;
    private final zzpn zzaqe;
    private final zzpn zzaqf;
    private final zzpn zzaqg;
    private final zzpn zzaqh;
    private final zzpn zzaqi;
    private final zzpn zzaqj;
    private ByteBuffer zzaqk;
    private long zzaql;
    private long zzaqm;
    private long zzaqn;
    private long zzaqo;
    private zzkr zzaqp;
    private boolean zzaqq;
    private int zzaqr;
    private long zzaqs;
    private boolean zzaqt;
    private long zzaqu;
    private long zzaqv;
    private long zzaqw;
    private zzph zzaqx;
    private zzph zzaqy;
    private boolean zzaqz;
    private int zzara;
    private long zzarb;
    private long zzarc;
    private int zzard;
    private int zzare;
    private int[] zzarf;
    private int zzarg;
    private int zzarh;
    private int zzari;
    private int zzarj;
    private boolean zzark;
    private boolean zzarl;
    private boolean zzarm;
    private boolean zzarn;
    private byte zzaro;
    private int zzarp;
    private int zzarq;
    private int zzarr;
    private boolean zzars;
    private boolean zzart;
    private zzkc zzaru;

    public zzkq() {
        this(0);
    }

    static int zzao(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    static boolean zzap(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public final void release() {
    }

    private zzkq(int i) {
        this(new zzkj(), 0);
    }

    private zzkq(zzko zzko, int i) {
        this.zzaqm = -1;
        this.zzaqn = -9223372036854775807L;
        this.zzaqo = -9223372036854775807L;
        this.zzaiz = -9223372036854775807L;
        this.zzaqu = -1;
        this.zzaqv = -1;
        this.zzaqw = -9223372036854775807L;
        this.zzapy = zzko;
        zzko.zza(new zzks(this, (zzkp) null));
        this.zzaqa = true;
        this.zzapm = new zzkt();
        this.zzapz = new SparseArray<>();
        this.zzaqd = new zzpn(4);
        this.zzaqe = new zzpn(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzaqf = new zzpn(4);
        this.zzaqb = new zzpn(zzpm.zzbkd);
        this.zzaqc = new zzpn(4);
        this.zzaqg = new zzpn();
        this.zzaqh = new zzpn();
        this.zzaqi = new zzpn(8);
        this.zzaqj = new zzpn();
    }

    public final boolean zza(zzjz zzjz) throws IOException, InterruptedException {
        return new zzku().zza(zzjz);
    }

    public final void zza(zzkc zzkc) {
        this.zzaru = zzkc;
    }

    public final void zzc(long j, long j2) {
        this.zzaqw = -9223372036854775807L;
        this.zzara = 0;
        this.zzapy.reset();
        this.zzapm.reset();
        zzgy();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0005 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzjz r9, com.google.android.gms.internal.ads.zzkg r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 0
            r8.zzars = r0
            r1 = 1
            r2 = 1
        L_0x0005:
            if (r2 == 0) goto L_0x003a
            boolean r3 = r8.zzars
            if (r3 != 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzko r2 = r8.zzapy
            boolean r2 = r2.zzb(r9)
            if (r2 == 0) goto L_0x0005
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaqt
            if (r5 == 0) goto L_0x0025
            r8.zzaqv = r3
            long r3 = r8.zzaqu
            r10.position = r3
            r8.zzaqt = r0
        L_0x0023:
            r3 = 1
            goto L_0x0037
        L_0x0025:
            boolean r3 = r8.zzaqq
            if (r3 == 0) goto L_0x0036
            long r3 = r8.zzaqv
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0036
            r10.position = r3
            r8.zzaqv = r5
            goto L_0x0023
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x0005
            return r1
        L_0x003a:
            if (r2 == 0) goto L_0x003d
            return r0
        L_0x003d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkq.zza(com.google.android.gms.internal.ads.zzjz, com.google.android.gms.internal.ads.zzkg):int");
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j, long j2) throws zzhw {
        if (i == 160) {
            this.zzart = false;
        } else if (i == 174) {
            this.zzaqp = new zzkr((zzkp) null);
        } else if (i == 187) {
            this.zzaqz = false;
        } else if (i == 19899) {
            this.zzaqr = -1;
            this.zzaqs = -1;
        } else if (i == 20533) {
            this.zzaqp.zzarx = true;
        } else if (i == 21968) {
            this.zzaqp.zzase = true;
        } else if (i == 408125543) {
            long j3 = this.zzaqm;
            if (j3 == -1 || j3 == j) {
                this.zzaqm = j;
                this.zzaql = j2;
                return;
            }
            throw new zzhw("Multiple Segment elements not supported");
        } else if (i == 475249515) {
            this.zzaqx = new zzph();
            this.zzaqy = new zzph();
        } else if (i != 524531317 || this.zzaqq) {
        } else {
            if (!this.zzaqa || this.zzaqu == -1) {
                this.zzaru.zza(new zzki(this.zzaiz));
                this.zzaqq = true;
                return;
            }
            this.zzaqt = true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzaq(int i) throws zzhw {
        zzkf zzkf;
        zzph zzph;
        zzph zzph2;
        int i2;
        int i3 = 0;
        if (i != 160) {
            if (i == 174) {
                String str = this.zzaqp.zzarv;
                if ("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    zzkr zzkr = this.zzaqp;
                    zzkr.zza(this.zzaru, zzkr.number);
                    this.zzapz.put(this.zzaqp.number, this.zzaqp);
                }
                this.zzaqp = null;
            } else if (i == 19899) {
                int i4 = this.zzaqr;
                if (i4 != -1) {
                    long j = this.zzaqs;
                    if (j != -1) {
                        if (i4 == 475249515) {
                            this.zzaqu = j;
                            return;
                        }
                        return;
                    }
                }
                throw new zzhw("Mandatory element SeekID or SeekPosition not found");
            } else if (i != 25152) {
                if (i != 28032) {
                    if (i == 357149030) {
                        if (this.zzaqn == -9223372036854775807L) {
                            this.zzaqn = 1000000;
                        }
                        long j2 = this.zzaqo;
                        if (j2 != -9223372036854775807L) {
                            this.zzaiz = zzea(j2);
                        }
                    } else if (i != 374648427) {
                        if (i == 475249515 && !this.zzaqq) {
                            zzkc zzkc = this.zzaru;
                            if (this.zzaqm == -1 || this.zzaiz == -9223372036854775807L || (zzph = this.zzaqx) == null || zzph.size() == 0 || (zzph2 = this.zzaqy) == null || zzph2.size() != this.zzaqx.size()) {
                                this.zzaqx = null;
                                this.zzaqy = null;
                                zzkf = new zzki(this.zzaiz);
                            } else {
                                int size = this.zzaqx.size();
                                int[] iArr = new int[size];
                                long[] jArr = new long[size];
                                long[] jArr2 = new long[size];
                                long[] jArr3 = new long[size];
                                for (int i5 = 0; i5 < size; i5++) {
                                    jArr3[i5] = this.zzaqx.get(i5);
                                    jArr[i5] = this.zzaqm + this.zzaqy.get(i5);
                                }
                                while (true) {
                                    i2 = size - 1;
                                    if (i3 >= i2) {
                                        break;
                                    }
                                    int i6 = i3 + 1;
                                    iArr[i3] = (int) (jArr[i6] - jArr[i3]);
                                    jArr2[i3] = jArr3[i6] - jArr3[i3];
                                    i3 = i6;
                                }
                                iArr[i2] = (int) ((this.zzaqm + this.zzaql) - jArr[i2]);
                                jArr2[i2] = this.zzaiz - jArr3[i2];
                                this.zzaqx = null;
                                this.zzaqy = null;
                                zzkf = new zzjy(iArr, jArr, jArr2, jArr3);
                            }
                            zzkc.zza(zzkf);
                            this.zzaqq = true;
                        }
                    } else if (this.zzapz.size() != 0) {
                        this.zzaru.zzgw();
                    } else {
                        throw new zzhw("No valid tracks were found");
                    }
                } else if (this.zzaqp.zzarx && this.zzaqp.zzary != null) {
                    throw new zzhw("Combining encryption and compression is not supported");
                }
            } else if (!this.zzaqp.zzarx) {
            } else {
                if (this.zzaqp.zzarz != null) {
                    this.zzaqp.zzahr = new zzjo(new zzjo.zza(zzhf.UUID_NIL, "video/webm", this.zzaqp.zzarz.zzaps));
                    return;
                }
                throw new zzhw("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.zzara == 2) {
            if (!this.zzart) {
                this.zzari |= 1;
            }
            zza(this.zzapz.get(this.zzarg), this.zzarb);
            this.zzara = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, long j) throws zzhw {
        if (i != 20529) {
            if (i != 20530) {
                boolean z = false;
                switch (i) {
                    case 131:
                        this.zzaqp.type = (int) j;
                        return;
                    case 136:
                        zzkr zzkr = this.zzaqp;
                        if (j == 1) {
                            z = true;
                        }
                        zzkr.zzasx = z;
                        return;
                    case 155:
                        this.zzarc = zzea(j);
                        return;
                    case 159:
                        this.zzaqp.zzahy = (int) j;
                        return;
                    case 176:
                        this.zzaqp.width = (int) j;
                        return;
                    case 179:
                        this.zzaqx.add(zzea(j));
                        return;
                    case 186:
                        this.zzaqp.height = (int) j;
                        return;
                    case 215:
                        this.zzaqp.number = (int) j;
                        return;
                    case 231:
                        this.zzaqw = zzea(j);
                        return;
                    case 241:
                        if (!this.zzaqz) {
                            this.zzaqy.add(j);
                            this.zzaqz = true;
                            return;
                        }
                        return;
                    case 251:
                        this.zzart = true;
                        return;
                    case 16980:
                        if (j != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j);
                            sb.append(" not supported");
                            throw new zzhw(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j < 1 || j > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j);
                            sb2.append(" not supported");
                            throw new zzhw(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j);
                            sb3.append(" not supported");
                            throw new zzhw(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j);
                            sb4.append(" not supported");
                            throw new zzhw(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j);
                            sb5.append(" not supported");
                            throw new zzhw(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.zzaqs = j + this.zzaqm;
                        return;
                    case 21432:
                        int i2 = (int) j;
                        if (i2 == 0) {
                            this.zzaqp.zzahv = 0;
                            return;
                        } else if (i2 == 1) {
                            this.zzaqp.zzahv = 2;
                            return;
                        } else if (i2 == 3) {
                            this.zzaqp.zzahv = 1;
                            return;
                        } else if (i2 == 15) {
                            this.zzaqp.zzahv = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.zzaqp.zzasb = (int) j;
                        return;
                    case 21682:
                        this.zzaqp.zzasd = (int) j;
                        return;
                    case 21690:
                        this.zzaqp.zzasc = (int) j;
                        return;
                    case 21930:
                        zzkr zzkr2 = this.zzaqp;
                        if (j == 1) {
                            z = true;
                        }
                        zzkr2.zzasy = z;
                        return;
                    case 22186:
                        this.zzaqp.zzasv = j;
                        return;
                    case 22203:
                        this.zzaqp.zzasw = j;
                        return;
                    case 25188:
                        this.zzaqp.zzasu = (int) j;
                        return;
                    case 2352003:
                        this.zzaqp.zzarw = (int) j;
                        return;
                    case 2807729:
                        this.zzaqn = j;
                        return;
                    default:
                        switch (i) {
                            case 21945:
                                int i3 = (int) j;
                                if (i3 == 1) {
                                    this.zzaqp.zzash = 2;
                                    return;
                                } else if (i3 == 2) {
                                    this.zzaqp.zzash = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i4 = (int) j;
                                if (i4 != 1) {
                                    if (i4 == 16) {
                                        this.zzaqp.zzasg = 6;
                                        return;
                                    } else if (i4 == 18) {
                                        this.zzaqp.zzasg = 7;
                                        return;
                                    } else if (!(i4 == 6 || i4 == 7)) {
                                        return;
                                    }
                                }
                                this.zzaqp.zzasg = 3;
                                return;
                            case 21947:
                                this.zzaqp.zzase = true;
                                int i5 = (int) j;
                                if (i5 == 1) {
                                    this.zzaqp.zzasf = 1;
                                    return;
                                } else if (i5 == 9) {
                                    this.zzaqp.zzasf = 6;
                                    return;
                                } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                    this.zzaqp.zzasf = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.zzaqp.zzasi = (int) j;
                                return;
                            case 21949:
                                this.zzaqp.zzasj = (int) j;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzhw(sb6.toString());
            }
        } else if (j != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j);
            sb7.append(" not supported");
            throw new zzhw(sb7.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, double d) {
        if (i == 181) {
            this.zzaqp.zzahz = (int) d;
        } else if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzaqp.zzask = (float) d;
                    return;
                case 21970:
                    this.zzaqp.zzasl = (float) d;
                    return;
                case 21971:
                    this.zzaqp.zzasm = (float) d;
                    return;
                case 21972:
                    this.zzaqp.zzasn = (float) d;
                    return;
                case 21973:
                    this.zzaqp.zzaso = (float) d;
                    return;
                case 21974:
                    this.zzaqp.zzasp = (float) d;
                    return;
                case 21975:
                    this.zzaqp.zzasq = (float) d;
                    return;
                case 21976:
                    this.zzaqp.zzasr = (float) d;
                    return;
                case 21977:
                    this.zzaqp.zzass = (float) d;
                    return;
                case 21978:
                    this.zzaqp.zzast = (float) d;
                    return;
                default:
                    return;
            }
        } else {
            this.zzaqo = (long) d;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, String str) throws zzhw {
        if (i == 134) {
            this.zzaqp.zzarv = str;
        } else if (i != 17026) {
            if (i == 2274716) {
                String unused = this.zzaqp.zzaif = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzhw(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ff, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(int r22, int r23, com.google.android.gms.internal.ads.zzjz r24) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = 161(0xa1, float:2.26E-43)
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            if (r1 == r4) goto L_0x0097
            if (r1 == r5) goto L_0x0097
            r4 = 16981(0x4255, float:2.3795E-41)
            if (r1 == r4) goto L_0x0089
            r4 = 18402(0x47e2, float:2.5787E-41)
            if (r1 == r4) goto L_0x007a
            r4 = 21419(0x53ab, float:3.0014E-41)
            if (r1 == r4) goto L_0x005b
            r4 = 25506(0x63a2, float:3.5742E-41)
            if (r1 == r4) goto L_0x004d
            r4 = 30322(0x7672, float:4.249E-41)
            if (r1 != r4) goto L_0x0034
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqp
            byte[] r4 = new byte[r2]
            r1.zzahw = r4
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqp
            byte[] r1 = r1.zzahw
            r3.readFully(r1, r6, r2)
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzhw r2 = new com.google.android.gms.internal.ads.zzhw
            r3 = 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Unexpected id: "
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.<init>(r1)
            throw r2
        L_0x004d:
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqp
            byte[] r4 = new byte[r2]
            r1.zzasa = r4
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqp
            byte[] r1 = r1.zzasa
            r3.readFully(r1, r6, r2)
            return
        L_0x005b:
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaqf
            byte[] r1 = r1.data
            java.util.Arrays.fill(r1, r6)
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaqf
            byte[] r1 = r1.data
            int r4 = 4 - r2
            r3.readFully(r1, r4, r2)
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaqf
            r1.zzbl(r6)
            com.google.android.gms.internal.ads.zzpn r1 = r0.zzaqf
            long r1 = r1.zzjb()
            int r2 = (int) r1
            r0.zzaqr = r2
            return
        L_0x007a:
            byte[] r1 = new byte[r2]
            r3.readFully(r1, r6, r2)
            com.google.android.gms.internal.ads.zzkr r2 = r0.zzaqp
            com.google.android.gms.internal.ads.zzkk r3 = new com.google.android.gms.internal.ads.zzkk
            r3.<init>(r7, r1)
            r2.zzarz = r3
            return
        L_0x0089:
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqp
            byte[] r4 = new byte[r2]
            r1.zzary = r4
            com.google.android.gms.internal.ads.zzkr r1 = r0.zzaqp
            byte[] r1 = r1.zzary
            r3.readFully(r1, r6, r2)
            return
        L_0x0097:
            int r4 = r0.zzara
            r8 = 8
            if (r4 != 0) goto L_0x00bc
            com.google.android.gms.internal.ads.zzkt r4 = r0.zzapm
            long r9 = r4.zza(r3, r6, r7, r8)
            int r4 = (int) r9
            r0.zzarg = r4
            com.google.android.gms.internal.ads.zzkt r4 = r0.zzapm
            int r4 = r4.zzha()
            r0.zzarh = r4
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zzarc = r9
            r0.zzara = r7
            com.google.android.gms.internal.ads.zzpn r4 = r0.zzaqd
            r4.reset()
        L_0x00bc:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzkr> r4 = r0.zzapz
            int r9 = r0.zzarg
            java.lang.Object r4 = r4.get(r9)
            com.google.android.gms.internal.ads.zzkr r4 = (com.google.android.gms.internal.ads.zzkr) r4
            if (r4 != 0) goto L_0x00d2
            int r1 = r0.zzarh
            int r1 = r2 - r1
            r3.zzaj(r1)
            r0.zzara = r6
            return
        L_0x00d2:
            int r9 = r0.zzara
            if (r9 != r7) goto L_0x0285
            r9 = 3
            r0.zzb(r3, r9)
            com.google.android.gms.internal.ads.zzpn r10 = r0.zzaqd
            byte[] r10 = r10.data
            r11 = 2
            byte r10 = r10[r11]
            r10 = r10 & 6
            int r10 = r10 >> r7
            r12 = 255(0xff, float:3.57E-43)
            if (r10 != 0) goto L_0x00fa
            r0.zzare = r7
            int[] r10 = r0.zzarf
            int[] r10 = zza((int[]) r10, (int) r7)
            r0.zzarf = r10
            int r13 = r0.zzarh
            int r2 = r2 - r13
            int r2 = r2 - r9
            r10[r6] = r2
            goto L_0x0213
        L_0x00fa:
            if (r1 != r5) goto L_0x027d
            r13 = 4
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaqd
            byte[] r14 = r14.data
            byte r14 = r14[r9]
            r14 = r14 & r12
            int r14 = r14 + r7
            r0.zzare = r14
            int[] r15 = r0.zzarf
            int[] r14 = zza((int[]) r15, (int) r14)
            r0.zzarf = r14
            if (r10 != r11) goto L_0x0120
            int r9 = r0.zzarh
            int r2 = r2 - r9
            int r2 = r2 - r13
            int r9 = r0.zzare
            int r2 = r2 / r9
            java.util.Arrays.fill(r14, r6, r9, r2)
            goto L_0x0213
        L_0x0120:
            if (r10 != r7) goto L_0x0157
            r9 = 0
            r10 = 0
        L_0x0124:
            int r14 = r0.zzare
            int r15 = r14 + -1
            if (r9 >= r15) goto L_0x014b
            int[] r14 = r0.zzarf
            r14[r9] = r6
        L_0x012e:
            int r13 = r13 + r7
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaqd
            byte[] r14 = r14.data
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r0.zzarf
            r16 = r15[r9]
            int r16 = r16 + r14
            r15[r9] = r16
            if (r14 == r12) goto L_0x012e
            r14 = r15[r9]
            int r10 = r10 + r14
            int r9 = r9 + 1
            goto L_0x0124
        L_0x014b:
            int[] r9 = r0.zzarf
            int r14 = r14 - r7
            int r15 = r0.zzarh
            int r2 = r2 - r15
            int r2 = r2 - r13
            int r2 = r2 - r10
            r9[r14] = r2
            goto L_0x0213
        L_0x0157:
            if (r10 != r9) goto L_0x0264
            r9 = 0
            r10 = 0
        L_0x015b:
            int r14 = r0.zzare
            int r15 = r14 + -1
            if (r9 >= r15) goto L_0x0208
            int[] r14 = r0.zzarf
            r14[r9] = r6
            int r13 = r13 + 1
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpn r14 = r0.zzaqd
            byte[] r14 = r14.data
            int r15 = r13 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0200
            r16 = 0
            r14 = 0
        L_0x0177:
            if (r14 >= r8) goto L_0x01cb
            int r18 = 7 - r14
            int r5 = r7 << r18
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzaqd
            byte[] r11 = r11.data
            byte r11 = r11[r15]
            r11 = r11 & r5
            if (r11 == 0) goto L_0x01c1
            int r13 = r13 + r14
            r0.zzb(r3, r13)
            com.google.android.gms.internal.ads.zzpn r11 = r0.zzaqd
            byte[] r11 = r11.data
            int r16 = r15 + 1
            byte r11 = r11[r15]
            r11 = r11 & r12
            int r5 = ~r5
            r5 = r5 & r11
            long r6 = (long) r5
            r5 = r16
            r16 = r6
        L_0x019a:
            if (r5 >= r13) goto L_0x01b3
            long r6 = r16 << r8
            com.google.android.gms.internal.ads.zzpn r15 = r0.zzaqd
            byte[] r15 = r15.data
            int r16 = r5 + 1
            byte r5 = r15[r5]
            r5 = r5 & r12
            long r11 = (long) r5
            long r5 = r6 | r11
            r12 = 255(0xff, float:3.57E-43)
            r19 = r5
            r5 = r16
            r16 = r19
            goto L_0x019a
        L_0x01b3:
            if (r9 <= 0) goto L_0x01cb
            int r14 = r14 * 7
            int r14 = r14 + 6
            r5 = 1
            long r11 = r5 << r14
            long r11 = r11 - r5
            long r16 = r16 - r11
            goto L_0x01cb
        L_0x01c1:
            int r14 = r14 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0177
        L_0x01cb:
            r5 = r16
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 < 0) goto L_0x01f8
            r11 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x01f8
            int r6 = (int) r5
            int[] r5 = r0.zzarf
            if (r9 != 0) goto L_0x01e1
            goto L_0x01e6
        L_0x01e1:
            int r7 = r9 + -1
            r7 = r5[r7]
            int r6 = r6 + r7
        L_0x01e6:
            r5[r9] = r6
            int[] r5 = r0.zzarf
            r5 = r5[r9]
            int r10 = r10 + r5
            int r9 = r9 + 1
            r5 = 163(0xa3, float:2.28E-43)
            r6 = 0
            r7 = 1
            r11 = 2
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x015b
        L_0x01f8:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "EBML lacing sample size out of range."
            r1.<init>(r2)
            throw r1
        L_0x0200:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "No valid varint length mask found"
            r1.<init>(r2)
            throw r1
        L_0x0208:
            int[] r5 = r0.zzarf
            r6 = 1
            int r14 = r14 - r6
            int r6 = r0.zzarh
            int r2 = r2 - r6
            int r2 = r2 - r13
            int r2 = r2 - r10
            r5[r14] = r2
        L_0x0213:
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaqd
            byte[] r2 = r2.data
            r5 = 0
            byte r2 = r2[r5]
            int r2 = r2 << r8
            com.google.android.gms.internal.ads.zzpn r5 = r0.zzaqd
            byte[] r5 = r5.data
            r6 = 1
            byte r5 = r5[r6]
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            r2 = r2 | r5
            long r5 = r0.zzaqw
            long r9 = (long) r2
            long r9 = r0.zzea(r9)
            long r5 = r5 + r9
            r0.zzarb = r5
            com.google.android.gms.internal.ads.zzpn r2 = r0.zzaqd
            byte[] r2 = r2.data
            r5 = 2
            byte r2 = r2[r5]
            r2 = r2 & r8
            if (r2 != r8) goto L_0x023c
            r2 = 1
            goto L_0x023d
        L_0x023c:
            r2 = 0
        L_0x023d:
            int r6 = r4.type
            if (r6 == r5) goto L_0x0253
            r6 = 163(0xa3, float:2.28E-43)
            if (r1 != r6) goto L_0x0251
            com.google.android.gms.internal.ads.zzpn r6 = r0.zzaqd
            byte[] r6 = r6.data
            byte r6 = r6[r5]
            r5 = 128(0x80, float:1.794E-43)
            r6 = r6 & r5
            if (r6 != r5) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r5 = 0
            goto L_0x0254
        L_0x0253:
            r5 = 1
        L_0x0254:
            if (r2 == 0) goto L_0x0259
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x025a
        L_0x0259:
            r2 = 0
        L_0x025a:
            r2 = r2 | r5
            r0.zzari = r2
            r2 = 2
            r0.zzara = r2
            r2 = 0
            r0.zzard = r2
            goto L_0x0285
        L_0x0264:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected lacing value: "
            r3.append(r2)
            r3.append(r10)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L_0x027d:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Lacing only supported in SimpleBlocks."
            r1.<init>(r2)
            throw r1
        L_0x0285:
            r2 = 163(0xa3, float:2.28E-43)
            if (r1 != r2) goto L_0x02b0
        L_0x0289:
            int r1 = r0.zzard
            int r2 = r0.zzare
            if (r1 >= r2) goto L_0x02ac
            int[] r2 = r0.zzarf
            r1 = r2[r1]
            r0.zza((com.google.android.gms.internal.ads.zzjz) r3, (com.google.android.gms.internal.ads.zzkr) r4, (int) r1)
            long r1 = r0.zzarb
            int r5 = r0.zzard
            int r6 = r4.zzarw
            int r5 = r5 * r6
            int r5 = r5 / 1000
            long r5 = (long) r5
            long r1 = r1 + r5
            r0.zza((com.google.android.gms.internal.ads.zzkr) r4, (long) r1)
            int r1 = r0.zzard
            r2 = 1
            int r1 = r1 + r2
            r0.zzard = r1
            goto L_0x0289
        L_0x02ac:
            r1 = 0
            r0.zzara = r1
            return
        L_0x02b0:
            r1 = 0
            int[] r2 = r0.zzarf
            r1 = r2[r1]
            r0.zza((com.google.android.gms.internal.ads.zzjz) r3, (com.google.android.gms.internal.ads.zzkr) r4, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkq.zza(int, int, com.google.android.gms.internal.ads.zzjz):void");
    }

    private final void zza(zzkr zzkr, long j) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(zzkr.zzarv)) {
            byte[] bArr2 = this.zzaqh.data;
            long j2 = this.zzarc;
            if (j2 == -9223372036854775807L) {
                bArr = zzapw;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (((long) i) * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - ((long) (60000000 * i2));
                int i3 = (int) (j4 / 1000000);
                bArr = zzpt.zzbg(String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - ((long) (1000000 * i3))) / 1000))}));
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            zzkh zzkh = zzkr.zzasz;
            zzpn zzpn = this.zzaqh;
            zzkh.zza(zzpn, zzpn.limit());
            this.zzarr += this.zzaqh.limit();
        }
        zzkr.zzasz.zza(j, this.zzari, this.zzarr, 0, zzkr.zzarz);
        this.zzars = true;
        zzgy();
    }

    private final void zzgy() {
        this.zzarj = 0;
        this.zzarr = 0;
        this.zzarq = 0;
        this.zzark = false;
        this.zzarl = false;
        this.zzarn = false;
        this.zzarp = 0;
        this.zzaro = 0;
        this.zzarm = false;
        this.zzaqg.reset();
    }

    private final void zzb(zzjz zzjz, int i) throws IOException, InterruptedException {
        if (this.zzaqd.limit() < i) {
            if (this.zzaqd.capacity() < i) {
                zzpn zzpn = this.zzaqd;
                zzpn.zzc(Arrays.copyOf(zzpn.data, Math.max(this.zzaqd.data.length << 1, i)), this.zzaqd.limit());
            }
            zzjz.readFully(this.zzaqd.data, this.zzaqd.limit(), i - this.zzaqd.limit());
            this.zzaqd.zzbk(i);
        }
    }

    private final void zza(zzjz zzjz, zzkr zzkr, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzkr.zzarv)) {
            int length = zzapv.length + i;
            if (this.zzaqh.capacity() < length) {
                this.zzaqh.data = Arrays.copyOf(zzapv, length + i);
            }
            zzjz.readFully(this.zzaqh.data, zzapv.length, i);
            this.zzaqh.zzbl(0);
            this.zzaqh.zzbk(length);
            return;
        }
        zzkh zzkh = zzkr.zzasz;
        if (!this.zzark) {
            if (zzkr.zzarx) {
                this.zzari &= -1073741825;
                int i3 = 128;
                if (!this.zzarl) {
                    zzjz.readFully(this.zzaqd.data, 0, 1);
                    this.zzarj++;
                    if ((this.zzaqd.data[0] & 128) != 128) {
                        this.zzaro = this.zzaqd.data[0];
                        this.zzarl = true;
                    } else {
                        throw new zzhw("Extension bit is set in signal byte");
                    }
                }
                byte b = this.zzaro;
                if ((b & 1) == 1) {
                    boolean z = (b & 2) == 2;
                    this.zzari |= 1073741824;
                    if (!this.zzarm) {
                        zzjz.readFully(this.zzaqi.data, 0, 8);
                        this.zzarj += 8;
                        this.zzarm = true;
                        byte[] bArr = this.zzaqd.data;
                        if (!z) {
                            i3 = 0;
                        }
                        bArr[0] = (byte) (i3 | 8);
                        this.zzaqd.zzbl(0);
                        zzkh.zza(this.zzaqd, 1);
                        this.zzarr++;
                        this.zzaqi.zzbl(0);
                        zzkh.zza(this.zzaqi, 8);
                        this.zzarr += 8;
                    }
                    if (z) {
                        if (!this.zzarn) {
                            zzjz.readFully(this.zzaqd.data, 0, 1);
                            this.zzarj++;
                            this.zzaqd.zzbl(0);
                            this.zzarp = this.zzaqd.readUnsignedByte();
                            this.zzarn = true;
                        }
                        int i4 = this.zzarp << 2;
                        this.zzaqd.reset(i4);
                        zzjz.readFully(this.zzaqd.data, 0, i4);
                        this.zzarj += i4;
                        short s = (short) ((this.zzarp / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzaqk;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.zzaqk = ByteBuffer.allocate(i5);
                        }
                        this.zzaqk.position(0);
                        this.zzaqk.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i2 = this.zzarp;
                            if (i6 >= i2) {
                                break;
                            }
                            int zzje = this.zzaqd.zzje();
                            if (i6 % 2 == 0) {
                                this.zzaqk.putShort((short) (zzje - i7));
                            } else {
                                this.zzaqk.putInt(zzje - i7);
                            }
                            i6++;
                            i7 = zzje;
                        }
                        int i8 = (i - this.zzarj) - i7;
                        if (i2 % 2 == 1) {
                            this.zzaqk.putInt(i8);
                        } else {
                            this.zzaqk.putShort((short) i8);
                            this.zzaqk.putInt(0);
                        }
                        this.zzaqj.zzc(this.zzaqk.array(), i5);
                        zzkh.zza(this.zzaqj, i5);
                        this.zzarr += i5;
                    }
                }
            } else if (zzkr.zzary != null) {
                this.zzaqg.zzc(zzkr.zzary, zzkr.zzary.length);
            }
            this.zzark = true;
        }
        int limit = i + this.zzaqg.limit();
        if (!"V_MPEG4/ISO/AVC".equals(zzkr.zzarv) && !"V_MPEGH/ISO/HEVC".equals(zzkr.zzarv)) {
            while (true) {
                int i9 = this.zzarj;
                if (i9 >= limit) {
                    break;
                }
                zza(zzjz, zzkh, limit - i9);
            }
        } else {
            byte[] bArr2 = this.zzaqc.data;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i10 = zzkr.zzata;
            int i11 = 4 - zzkr.zzata;
            while (this.zzarj < limit) {
                int i12 = this.zzarq;
                if (i12 == 0) {
                    int min = Math.min(i10, this.zzaqg.zziz());
                    zzjz.readFully(bArr2, i11 + min, i10 - min);
                    if (min > 0) {
                        this.zzaqg.zze(bArr2, i11, min);
                    }
                    this.zzarj += i10;
                    this.zzaqc.zzbl(0);
                    this.zzarq = this.zzaqc.zzje();
                    this.zzaqb.zzbl(0);
                    zzkh.zza(this.zzaqb, 4);
                    this.zzarr += 4;
                } else {
                    this.zzarq = i12 - zza(zzjz, zzkh, i12);
                }
            }
        }
        if ("A_VORBIS".equals(zzkr.zzarv)) {
            this.zzaqe.zzbl(0);
            zzkh.zza(this.zzaqe, 4);
            this.zzarr += 4;
        }
    }

    private final int zza(zzjz zzjz, zzkh zzkh, int i) throws IOException, InterruptedException {
        int i2;
        int zziz = this.zzaqg.zziz();
        if (zziz > 0) {
            i2 = Math.min(i, zziz);
            zzkh.zza(this.zzaqg, i2);
        } else {
            i2 = zzkh.zza(zzjz, i, false);
        }
        this.zzarj += i2;
        this.zzarr += i2;
        return i2;
    }

    private final long zzea(long j) throws zzhw {
        long j2 = this.zzaqn;
        if (j2 != -9223372036854775807L) {
            return zzpt.zza(j, j2, 1000);
        }
        throw new zzhw("Can't scale timecode prior to timecodeScale being set.");
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        if (iArr.length >= i) {
            return iArr;
        }
        return new int[Math.max(iArr.length << 1, i)];
    }
}
