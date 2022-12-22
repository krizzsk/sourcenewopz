package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzkr {
    public int height;
    public int number;
    public int type;
    public int width;
    public zzjo zzahr;
    public int zzahv;
    public byte[] zzahw;
    public int zzahy;
    public int zzahz;
    /* access modifiers changed from: private */
    public String zzaif;
    public String zzarv;
    public int zzarw;
    public boolean zzarx;
    public byte[] zzary;
    public zzkk zzarz;
    public byte[] zzasa;
    public int zzasb;
    public int zzasc;
    public int zzasd;
    public boolean zzase;
    public int zzasf;
    public int zzasg;
    public int zzash;
    public int zzasi;
    public int zzasj;
    public float zzask;
    public float zzasl;
    public float zzasm;
    public float zzasn;
    public float zzaso;
    public float zzasp;
    public float zzasq;
    public float zzasr;
    public float zzass;
    public float zzast;
    public int zzasu;
    public long zzasv;
    public long zzasw;
    public boolean zzasx;
    public boolean zzasy;
    public zzkh zzasz;
    public int zzata;

    private zzkr() {
        this.width = -1;
        this.height = -1;
        this.zzasb = -1;
        this.zzasc = -1;
        this.zzasd = 0;
        this.zzahw = null;
        this.zzahv = -1;
        this.zzase = false;
        this.zzasf = -1;
        this.zzasg = -1;
        this.zzash = -1;
        this.zzasi = 1000;
        this.zzasj = 200;
        this.zzask = -1.0f;
        this.zzasl = -1.0f;
        this.zzasm = -1.0f;
        this.zzasn = -1.0f;
        this.zzaso = -1.0f;
        this.zzasp = -1.0f;
        this.zzasq = -1.0f;
        this.zzasr = -1.0f;
        this.zzass = -1.0f;
        this.zzast = -1.0f;
        this.zzahy = 1;
        this.zzasu = -1;
        this.zzahz = 8000;
        this.zzasv = 0;
        this.zzasw = 0;
        this.zzasy = true;
        this.zzaif = "eng";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0264, code lost:
        r1 = null;
        r26 = -1;
        r31 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0318, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0330, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0332, code lost:
        r26 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0334, code lost:
        r31 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0336, code lost:
        r2 = r0.zzasy | false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x033b, code lost:
        if (r0.zzasx == false) goto L_0x033f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x033d, code lost:
        r3 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x033f, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0340, code lost:
        r2 = r2 | r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0345, code lost:
        if (com.google.android.gms.internal.ads.zzpj.zzbc(r15) == false) goto L_0x036d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0347, code lost:
        r1 = com.google.android.gms.internal.ads.zzht.zza(java.lang.Integer.toString(r44), r15, (java.lang.String) null, -1, r31, r0.zzahy, r0.zzahz, r26, r1, r0.zzahr, r2 ? 1 : 0, r0.zzaif);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0371, code lost:
        if (com.google.android.gms.internal.ads.zzpj.zzbd(r15) == false) goto L_0x049c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0375, code lost:
        if (r0.zzasd != 0) goto L_0x0387;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0377, code lost:
        r2 = r0.zzasb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0379, code lost:
        if (r2 != -1) goto L_0x037d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x037b, code lost:
        r2 = r0.width;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x037d, code lost:
        r0.zzasb = r2;
        r2 = r0.zzasc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0381, code lost:
        if (r2 != -1) goto L_0x0385;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0383, code lost:
        r2 = r0.height;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0385, code lost:
        r0.zzasc = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0387, code lost:
        r2 = r0.zzasb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x038b, code lost:
        if (r2 == -1) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x038d, code lost:
        r4 = r0.zzasc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x038f, code lost:
        if (r4 == -1) goto L_0x039f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0391, code lost:
        r37 = ((float) (r0.height * r2)) / ((float) (r0.width * r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x039f, code lost:
        r37 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03a3, code lost:
        if (r0.zzase == false) goto L_0x0470;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x03a9, code lost:
        if (r0.zzask == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03af, code lost:
        if (r0.zzasl == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03b5, code lost:
        if (r0.zzasm == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03bb, code lost:
        if (r0.zzasn == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03c1, code lost:
        if (r0.zzaso == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03c7, code lost:
        if (r0.zzasp == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03cd, code lost:
        if (r0.zzasq == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03d3, code lost:
        if (r0.zzasr == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03d9, code lost:
        if (r0.zzass == -1.0f) goto L_0x0460;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03df, code lost:
        if (r0.zzast != -1.0f) goto L_0x03e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x03e3, code lost:
        r2 = new byte[25];
        r3 = java.nio.ByteBuffer.wrap(r2);
        r3.put((byte) 0);
        r3.putShort((short) ((int) ((r0.zzask * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzasl * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzasm * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzasn * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzaso * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzasp * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzasq * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) ((r0.zzasr * 50000.0f) + 0.5f)));
        r3.putShort((short) ((int) (r0.zzass + 0.5f)));
        r3.putShort((short) ((int) (r0.zzast + 0.5f)));
        r3.putShort((short) r0.zzasi);
        r3.putShort((short) r0.zzasj);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0460, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0462, code lost:
        r40 = new com.google.android.gms.internal.ads.zzpy(r0.zzasf, r0.zzash, r0.zzasg, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0470, code lost:
        r40 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0472, code lost:
        r1 = com.google.android.gms.internal.ads.zzht.zza(java.lang.Integer.toString(r44), r15, (java.lang.String) null, -1, r31, r0.width, r0.height, -1.0f, r1, -1, r37, r0.zzahw, r0.zzahv, r40, r0.zzahr);
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x04a0, code lost:
        if ("application/x-subrip".equals(r15) == false) goto L_0x04bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x04a2, code lost:
        r1 = com.google.android.gms.internal.ads.zzht.zza(java.lang.Integer.toString(r44), r15, (java.lang.String) null, -1, r2 ? 1 : 0, r0.zzaif, r0.zzahr);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04ba, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04c0, code lost:
        if ("application/vobsub".equals(r15) != false) goto L_0x04d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04c6, code lost:
        if ("application/pgs".equals(r15) != false) goto L_0x04d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04cc, code lost:
        if ("application/dvbsubs".equals(r15) == false) goto L_0x04cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04d6, code lost:
        throw new com.google.android.gms.internal.ads.zzhw("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04d7, code lost:
        r1 = com.google.android.gms.internal.ads.zzht.zza(java.lang.Integer.toString(r44), r15, (java.lang.String) null, -1, r1, r0.zzaif, r0.zzahr);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04f0, code lost:
        r2 = r43.zze(r0.number, r6);
        r0.zzasz = r2;
        r2.zze(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04fd, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01d2, code lost:
        r15 = "audio/x-unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01d5, code lost:
        r26 = r1;
        r1 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzkc r43, int r44) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r42 = this;
            r0 = r42
            java.lang.String r1 = r0.zzarv
            int r2 = r1.hashCode()
            r4 = 4
            r5 = 8
            r6 = 1
            r7 = 2
            r8 = 0
            r9 = 3
            r10 = -1
            switch(r2) {
                case -2095576542: goto L_0x014a;
                case -2095575984: goto L_0x0140;
                case -1985379776: goto L_0x0135;
                case -1784763192: goto L_0x012a;
                case -1730367663: goto L_0x011f;
                case -1482641358: goto L_0x0114;
                case -1482641357: goto L_0x0109;
                case -1373388978: goto L_0x00fe;
                case -933872740: goto L_0x00f3;
                case -538363189: goto L_0x00e8;
                case -538363109: goto L_0x00dd;
                case -425012669: goto L_0x00d1;
                case -356037306: goto L_0x00c5;
                case 62923557: goto L_0x00b9;
                case 62923603: goto L_0x00ad;
                case 62927045: goto L_0x00a1;
                case 82338133: goto L_0x0096;
                case 82338134: goto L_0x008b;
                case 99146302: goto L_0x007f;
                case 444813526: goto L_0x0073;
                case 542569478: goto L_0x0067;
                case 725957860: goto L_0x005b;
                case 855502857: goto L_0x0050;
                case 1422270023: goto L_0x0044;
                case 1809237540: goto L_0x0039;
                case 1950749482: goto L_0x002d;
                case 1950789798: goto L_0x0021;
                case 1951062397: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x0154
        L_0x0015:
            java.lang.String r2 = "A_OPUS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 11
            goto L_0x0155
        L_0x0021:
            java.lang.String r2 = "A_FLAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 21
            goto L_0x0155
        L_0x002d:
            java.lang.String r2 = "A_EAC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 16
            goto L_0x0155
        L_0x0039:
            java.lang.String r2 = "V_MPEG2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 2
            goto L_0x0155
        L_0x0044:
            java.lang.String r2 = "S_TEXT/UTF8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 24
            goto L_0x0155
        L_0x0050:
            java.lang.String r2 = "V_MPEGH/ISO/HEVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 7
            goto L_0x0155
        L_0x005b:
            java.lang.String r2 = "A_PCM/INT/LIT"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 23
            goto L_0x0155
        L_0x0067:
            java.lang.String r2 = "A_DTS/EXPRESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 19
            goto L_0x0155
        L_0x0073:
            java.lang.String r2 = "V_THEORA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 9
            goto L_0x0155
        L_0x007f:
            java.lang.String r2 = "S_HDMV/PGS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 26
            goto L_0x0155
        L_0x008b:
            java.lang.String r2 = "V_VP9"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 1
            goto L_0x0155
        L_0x0096:
            java.lang.String r2 = "V_VP8"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 0
            goto L_0x0155
        L_0x00a1:
            java.lang.String r2 = "A_DTS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 18
            goto L_0x0155
        L_0x00ad:
            java.lang.String r2 = "A_AC3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 15
            goto L_0x0155
        L_0x00b9:
            java.lang.String r2 = "A_AAC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 12
            goto L_0x0155
        L_0x00c5:
            java.lang.String r2 = "A_DTS/LOSSLESS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 20
            goto L_0x0155
        L_0x00d1:
            java.lang.String r2 = "S_VOBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 25
            goto L_0x0155
        L_0x00dd:
            java.lang.String r2 = "V_MPEG4/ISO/AVC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 6
            goto L_0x0155
        L_0x00e8:
            java.lang.String r2 = "V_MPEG4/ISO/ASP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 4
            goto L_0x0155
        L_0x00f3:
            java.lang.String r2 = "S_DVBSUB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 27
            goto L_0x0155
        L_0x00fe:
            java.lang.String r2 = "V_MS/VFW/FOURCC"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 8
            goto L_0x0155
        L_0x0109:
            java.lang.String r2 = "A_MPEG/L3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 14
            goto L_0x0155
        L_0x0114:
            java.lang.String r2 = "A_MPEG/L2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 13
            goto L_0x0155
        L_0x011f:
            java.lang.String r2 = "A_VORBIS"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 10
            goto L_0x0155
        L_0x012a:
            java.lang.String r2 = "A_TRUEHD"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 17
            goto L_0x0155
        L_0x0135:
            java.lang.String r2 = "A_MS/ACM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 22
            goto L_0x0155
        L_0x0140:
            java.lang.String r2 = "V_MPEG4/ISO/SP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 3
            goto L_0x0155
        L_0x014a:
            java.lang.String r2 = "V_MPEG4/ISO/AP"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0154
            r1 = 5
            goto L_0x0155
        L_0x0154:
            r1 = -1
        L_0x0155:
            java.lang.String r2 = "Unsupported PCM bit depth: "
            java.lang.String r11 = "application/dvbsubs"
            java.lang.String r12 = "application/pgs"
            java.lang.String r13 = "application/vobsub"
            java.lang.String r14 = "application/x-subrip"
            java.lang.String r15 = "audio/raw"
            r16 = 4096(0x1000, float:5.74E-42)
            java.lang.String r17 = "video/x-unknown"
            java.lang.String r3 = "audio/x-unknown"
            r18 = 0
            switch(r1) {
                case 0: goto L_0x032e;
                case 1: goto L_0x032b;
                case 2: goto L_0x0328;
                case 3: goto L_0x031a;
                case 4: goto L_0x031a;
                case 5: goto L_0x031a;
                case 6: goto L_0x0305;
                case 7: goto L_0x02f1;
                case 8: goto L_0x02cf;
                case 9: goto L_0x02cc;
                case 10: goto L_0x02bc;
                case 11: goto L_0x0276;
                case 12: goto L_0x026c;
                case 13: goto L_0x0262;
                case 14: goto L_0x025f;
                case 15: goto L_0x025b;
                case 16: goto L_0x0257;
                case 17: goto L_0x0253;
                case 18: goto L_0x024f;
                case 19: goto L_0x024f;
                case 20: goto L_0x024b;
                case 21: goto L_0x0241;
                case 22: goto L_0x01db;
                case 23: goto L_0x019e;
                case 24: goto L_0x019b;
                case 25: goto L_0x0192;
                case 26: goto L_0x018f;
                case 27: goto L_0x0174;
                default: goto L_0x016c;
            }
        L_0x016c:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>(r2)
            throw r1
        L_0x0174:
            byte[] r1 = new byte[r4]
            byte[] r2 = r0.zzasa
            byte r3 = r2[r8]
            r1[r8] = r3
            byte r3 = r2[r6]
            r1[r6] = r3
            byte r3 = r2[r7]
            r1[r7] = r3
            byte r2 = r2[r9]
            r1[r9] = r2
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r15 = r11
            goto L_0x0332
        L_0x018f:
            r15 = r12
            goto L_0x0330
        L_0x0192:
            byte[] r1 = r0.zzasa
            java.util.List r1 = java.util.Collections.singletonList(r1)
            r15 = r13
            goto L_0x0332
        L_0x019b:
            r15 = r14
            goto L_0x0330
        L_0x019e:
            int r1 = r0.zzasu
            int r1 = com.google.android.gms.internal.ads.zzpt.zzbr(r1)
            if (r1 != 0) goto L_0x01d5
            int r1 = r0.zzasu
            int r4 = r3.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            r5.append(r2)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r21 = r5.toString()
            r19 = 5
            r22 = 0
            r24 = 115(0x73, float:1.61E-43)
            java.lang.String r20 = "MatroskaExtractor"
            java.lang.String r23 = "com.google.android.gms.internal.ads.zzkr"
            com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)
        L_0x01d2:
            r15 = r3
            goto L_0x0330
        L_0x01d5:
            r26 = r1
            r1 = r18
            goto L_0x0334
        L_0x01db:
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r4 = r0.zzasa
            r1.<init>((byte[]) r4)
            boolean r1 = zzb(r1)
            if (r1 == 0) goto L_0x021d
            int r1 = r0.zzasu
            int r1 = com.google.android.gms.internal.ads.zzpt.zzbr(r1)
            if (r1 != 0) goto L_0x01d5
            int r1 = r0.zzasu
            int r4 = r3.length()
            int r4 = r4 + 60
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            r5.append(r2)
            r5.append(r1)
            java.lang.String r1 = ". Setting mimeType to "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r21 = r5.toString()
            r19 = 5
            r22 = 0
            r24 = 106(0x6a, float:1.49E-43)
            java.lang.String r20 = "MatroskaExtractor"
            java.lang.String r23 = "com.google.android.gms.internal.ads.zzkr"
            com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)
            goto L_0x01d2
        L_0x021d:
            java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
            int r2 = r3.length()
            if (r2 == 0) goto L_0x022c
            java.lang.String r1 = r1.concat(r3)
            r21 = r1
            goto L_0x0233
        L_0x022c:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r21 = r2
        L_0x0233:
            r19 = 5
            r22 = 0
            r24 = 108(0x6c, float:1.51E-43)
            java.lang.String r20 = "MatroskaExtractor"
            java.lang.String r23 = "com.google.android.gms.internal.ads.zzkr"
            com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)
            goto L_0x01d2
        L_0x0241:
            byte[] r1 = r0.zzasa
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r15 = "audio/x-flac"
            goto L_0x0332
        L_0x024b:
            java.lang.String r15 = "audio/vnd.dts.hd"
            goto L_0x0330
        L_0x024f:
            java.lang.String r15 = "audio/vnd.dts"
            goto L_0x0330
        L_0x0253:
            java.lang.String r15 = "audio/true-hd"
            goto L_0x0330
        L_0x0257:
            java.lang.String r15 = "audio/eac3"
            goto L_0x0330
        L_0x025b:
            java.lang.String r15 = "audio/ac3"
            goto L_0x0330
        L_0x025f:
            java.lang.String r15 = "audio/mpeg"
            goto L_0x0264
        L_0x0262:
            java.lang.String r15 = "audio/mpeg-L2"
        L_0x0264:
            r1 = r18
            r26 = -1
            r31 = 4096(0x1000, float:5.74E-42)
            goto L_0x0336
        L_0x026c:
            byte[] r1 = r0.zzasa
            java.util.List r1 = java.util.Collections.singletonList(r1)
            java.lang.String r15 = "audio/mp4a-latm"
            goto L_0x0332
        L_0x0276:
            r16 = 5760(0x1680, float:8.071E-42)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r9)
            byte[] r2 = r0.zzasa
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzasv
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r5)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            long r3 = r0.zzasw
            java.nio.ByteBuffer r2 = r2.putLong(r3)
            byte[] r2 = r2.array()
            r1.add(r2)
            java.lang.String r15 = "audio/opus"
            r26 = -1
            r31 = 5760(0x1680, float:8.071E-42)
            goto L_0x0336
        L_0x02bc:
            r16 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = r0.zzasa
            java.util.List r1 = zzd(r1)
            java.lang.String r15 = "audio/vorbis"
            r26 = -1
            r31 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0336
        L_0x02cc:
            r15 = r17
            goto L_0x0330
        L_0x02cf:
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r2 = r0.zzasa
            r1.<init>((byte[]) r2)
            java.util.List r1 = zza(r1)
            if (r1 == 0) goto L_0x02df
            java.lang.String r15 = "video/wvc1"
            goto L_0x0332
        L_0x02df:
            r19 = 5
            r22 = 0
            r24 = 58
            java.lang.String r20 = "MatroskaExtractor"
            java.lang.String r21 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            java.lang.String r23 = "com.google.android.gms.internal.ads.zzkr"
            com.didi.sdk.apm.SystemUtils.log(r19, r20, r21, r22, r23, r24)
            r15 = r17
            goto L_0x0332
        L_0x02f1:
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r2 = r0.zzasa
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzqb r1 = com.google.android.gms.internal.ads.zzqb.zzi(r1)
            java.util.List<byte[]> r2 = r1.zzahq
            int r1 = r1.zzata
            r0.zzata = r1
            java.lang.String r15 = "video/hevc"
            goto L_0x0318
        L_0x0305:
            com.google.android.gms.internal.ads.zzpn r1 = new com.google.android.gms.internal.ads.zzpn
            byte[] r2 = r0.zzasa
            r1.<init>((byte[]) r2)
            com.google.android.gms.internal.ads.zzpv r1 = com.google.android.gms.internal.ads.zzpv.zzg(r1)
            java.util.List<byte[]> r2 = r1.zzahq
            int r1 = r1.zzata
            r0.zzata = r1
            java.lang.String r15 = "video/avc"
        L_0x0318:
            r1 = r2
            goto L_0x0332
        L_0x031a:
            byte[] r1 = r0.zzasa
            if (r1 != 0) goto L_0x0321
            r1 = r18
            goto L_0x0325
        L_0x0321:
            java.util.List r1 = java.util.Collections.singletonList(r1)
        L_0x0325:
            java.lang.String r15 = "video/mp4v-es"
            goto L_0x0332
        L_0x0328:
            java.lang.String r15 = "video/mpeg2"
            goto L_0x0330
        L_0x032b:
            java.lang.String r15 = "video/x-vnd.on2.vp9"
            goto L_0x0330
        L_0x032e:
            java.lang.String r15 = "video/x-vnd.on2.vp8"
        L_0x0330:
            r1 = r18
        L_0x0332:
            r26 = -1
        L_0x0334:
            r31 = -1
        L_0x0336:
            boolean r2 = r0.zzasy
            r2 = r2 | r8
            boolean r3 = r0.zzasx
            if (r3 == 0) goto L_0x033f
            r3 = 2
            goto L_0x0340
        L_0x033f:
            r3 = 0
        L_0x0340:
            r2 = r2 | r3
            boolean r3 = com.google.android.gms.internal.ads.zzpj.zzbc(r15)
            if (r3 == 0) goto L_0x036d
            java.lang.String r19 = java.lang.Integer.toString(r44)
            r21 = 0
            r22 = -1
            int r3 = r0.zzahy
            int r4 = r0.zzahz
            com.google.android.gms.internal.ads.zzjo r5 = r0.zzahr
            java.lang.String r7 = r0.zzaif
            r20 = r15
            r23 = r31
            r24 = r3
            r25 = r4
            r27 = r1
            r28 = r5
            r29 = r2
            r30 = r7
            com.google.android.gms.internal.ads.zzht r1 = com.google.android.gms.internal.ads.zzht.zza(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            goto L_0x04f0
        L_0x036d:
            boolean r3 = com.google.android.gms.internal.ads.zzpj.zzbd(r15)
            if (r3 == 0) goto L_0x049c
            int r2 = r0.zzasd
            if (r2 != 0) goto L_0x0387
            int r2 = r0.zzasb
            if (r2 != r10) goto L_0x037d
            int r2 = r0.width
        L_0x037d:
            r0.zzasb = r2
            int r2 = r0.zzasc
            if (r2 != r10) goto L_0x0385
            int r2 = r0.height
        L_0x0385:
            r0.zzasc = r2
        L_0x0387:
            int r2 = r0.zzasb
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r10) goto L_0x039f
            int r4 = r0.zzasc
            if (r4 == r10) goto L_0x039f
            int r5 = r0.height
            int r5 = r5 * r2
            float r2 = (float) r5
            int r5 = r0.width
            int r5 = r5 * r4
            float r4 = (float) r5
            float r2 = r2 / r4
            r37 = r2
            goto L_0x03a1
        L_0x039f:
            r37 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x03a1:
            boolean r2 = r0.zzase
            if (r2 == 0) goto L_0x0470
            float r2 = r0.zzask
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzasl
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzasm
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzasn
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzaso
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzasp
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzasq
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzasr
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzass
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0460
            float r2 = r0.zzast
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x03e3
            goto L_0x0460
        L_0x03e3:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r2)
            r3.put(r8)
            float r4 = r0.zzask
            r5 = 1195593728(0x47435000, float:50000.0)
            float r4 = r4 * r5
            r6 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzasl
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzasm
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzasn
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzaso
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzasp
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzasq
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzasr
            float r4 = r4 * r5
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzass
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            float r4 = r0.zzast
            float r4 = r4 + r6
            int r4 = (int) r4
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.zzasi
            short r4 = (short) r4
            r3.putShort(r4)
            int r4 = r0.zzasj
            short r4 = (short) r4
            r3.putShort(r4)
            goto L_0x0462
        L_0x0460:
            r2 = r18
        L_0x0462:
            com.google.android.gms.internal.ads.zzpy r3 = new com.google.android.gms.internal.ads.zzpy
            int r4 = r0.zzasf
            int r5 = r0.zzash
            int r6 = r0.zzasg
            r3.<init>(r4, r5, r6, r2)
            r40 = r3
            goto L_0x0472
        L_0x0470:
            r40 = r18
        L_0x0472:
            java.lang.String r27 = java.lang.Integer.toString(r44)
            r29 = 0
            r30 = -1
            int r2 = r0.width
            int r3 = r0.height
            r34 = -1082130432(0xffffffffbf800000, float:-1.0)
            r36 = -1
            byte[] r4 = r0.zzahw
            int r5 = r0.zzahv
            com.google.android.gms.internal.ads.zzjo r6 = r0.zzahr
            r28 = r15
            r32 = r2
            r33 = r3
            r35 = r1
            r38 = r4
            r39 = r5
            r41 = r6
            com.google.android.gms.internal.ads.zzht r1 = com.google.android.gms.internal.ads.zzht.zza(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41)
            r6 = 2
            goto L_0x04f0
        L_0x049c:
            boolean r3 = r14.equals(r15)
            if (r3 == 0) goto L_0x04bc
            java.lang.String r19 = java.lang.Integer.toString(r44)
            r21 = 0
            r22 = -1
            java.lang.String r1 = r0.zzaif
            com.google.android.gms.internal.ads.zzjo r3 = r0.zzahr
            r20 = r15
            r23 = r2
            r24 = r1
            r25 = r3
            com.google.android.gms.internal.ads.zzht r1 = com.google.android.gms.internal.ads.zzht.zza((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (int) r22, (int) r23, (java.lang.String) r24, (com.google.android.gms.internal.ads.zzjo) r25)
        L_0x04ba:
            r6 = 3
            goto L_0x04f0
        L_0x04bc:
            boolean r2 = r13.equals(r15)
            if (r2 != 0) goto L_0x04d7
            boolean r2 = r12.equals(r15)
            if (r2 != 0) goto L_0x04d7
            boolean r2 = r11.equals(r15)
            if (r2 == 0) goto L_0x04cf
            goto L_0x04d7
        L_0x04cf:
            com.google.android.gms.internal.ads.zzhw r1 = new com.google.android.gms.internal.ads.zzhw
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>(r2)
            throw r1
        L_0x04d7:
            java.lang.String r19 = java.lang.Integer.toString(r44)
            r21 = 0
            r22 = -1
            java.lang.String r2 = r0.zzaif
            com.google.android.gms.internal.ads.zzjo r3 = r0.zzahr
            r20 = r15
            r23 = r1
            r24 = r2
            r25 = r3
            com.google.android.gms.internal.ads.zzht r1 = com.google.android.gms.internal.ads.zzht.zza((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (int) r22, (java.util.List<byte[]>) r23, (java.lang.String) r24, (com.google.android.gms.internal.ads.zzjo) r25)
            goto L_0x04ba
        L_0x04f0:
            int r2 = r0.number
            r3 = r43
            com.google.android.gms.internal.ads.zzkh r2 = r3.zze(r2, r6)
            r0.zzasz = r2
            r2.zze(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkr.zza(com.google.android.gms.internal.ads.zzkc, int):void");
    }

    private static List<byte[]> zza(zzpn zzpn) throws zzhw {
        try {
            zzpn.zzbm(16);
            if (zzpn.zzjc() != 826496599) {
                return null;
            }
            byte[] bArr = zzpn.data;
            for (int position = zzpn.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzhw("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> zzd(byte[] bArr) throws zzhw {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[(bArr.length - i9)];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhw("Error parsing vorbis codec private");
                    }
                    throw new zzhw("Error parsing vorbis codec private");
                }
                throw new zzhw("Error parsing vorbis codec private");
            }
            throw new zzhw("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing vorbis codec private");
        }
    }

    private static boolean zzb(zzpn zzpn) throws zzhw {
        try {
            int zzja = zzpn.zzja();
            if (zzja == 1) {
                return true;
            }
            if (zzja == 65534) {
                zzpn.zzbl(24);
                return zzpn.readLong() == zzkq.zzapx.getMostSignificantBits() && zzpn.readLong() == zzkq.zzapx.getLeastSignificantBits();
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhw("Error parsing MS/ACM codec private");
        }
    }

    /* synthetic */ zzkr(zzkp zzkp) {
        this();
    }
}
