package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18432ag;
import com.google.android.play.core.internal.C18490ck;
import java.io.File;

/* renamed from: com.google.android.play.core.assetpacks.bt */
final class C18337bt {

    /* renamed from: a */
    private static final C18432ag f52869a = new C18432ag("ExtractChunkTaskHandler");

    /* renamed from: b */
    private final byte[] f52870b = new byte[8192];

    /* renamed from: c */
    private final C18319bb f52871c;

    /* renamed from: d */
    private final C18490ck<C18415w> f52872d;

    /* renamed from: e */
    private final C18490ck<C18313aw> f52873e;

    /* renamed from: f */
    private final C18343bz f52874f;

    C18337bt(C18319bb bbVar, C18490ck<C18415w> ckVar, C18490ck<C18313aw> ckVar2, C18343bz bzVar) {
        this.f52871c = bbVar;
        this.f52872d = ckVar;
        this.f52873e = ckVar2;
        this.f52874f = bzVar;
    }

    /* renamed from: b */
    private final File m37567b(C18336bs bsVar) {
        File a = this.f52871c.mo148910a(bsVar.f52953k, bsVar.f52860a, bsVar.f52861b, bsVar.f52862c);
        if (!a.exists()) {
            a.mkdirs();
        }
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0180 A[Catch:{ all -> 0x0330, all -> 0x0336, IOException -> 0x033c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01a5 A[Catch:{ all -> 0x0330, all -> 0x0336, IOException -> 0x033c }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01d9 A[Catch:{ all -> 0x0330, all -> 0x0336, IOException -> 0x033c }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0294 A[SYNTHETIC, Splitter:B:93:0x0294] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo148965a(com.google.android.play.core.assetpacks.C18336bs r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            com.google.android.play.core.assetpacks.dr r0 = new com.google.android.play.core.assetpacks.dr
            com.google.android.play.core.assetpacks.bb r4 = r1.f52871c
            java.lang.String r5 = r2.f52953k
            int r6 = r2.f52860a
            long r7 = r2.f52861b
            java.lang.String r9 = r2.f52862c
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)
            com.google.android.play.core.assetpacks.bb r10 = r1.f52871c
            java.lang.String r11 = r2.f52953k
            int r12 = r2.f52860a
            long r13 = r2.f52861b
            java.lang.String r15 = r2.f52862c
            java.io.File r3 = r10.mo148932f(r11, r12, r13, r15)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x002b
            r3.mkdirs()
        L_0x002b:
            r11 = 3
            r12 = 2
            r13 = 1
            r14 = 0
            java.io.InputStream r3 = r2.f52868i     // Catch:{ IOException -> 0x033c }
            int r4 = r2.f52863d     // Catch:{ IOException -> 0x033c }
            if (r4 == r13) goto L_0x0037
            r15 = r3
            goto L_0x0040
        L_0x0037:
            java.util.zip.GZIPInputStream r4 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x033c }
            byte[] r5 = r1.f52870b     // Catch:{ IOException -> 0x033c }
            int r5 = r5.length     // Catch:{ IOException -> 0x033c }
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x033c }
            r15 = r4
        L_0x0040:
            int r3 = r2.f52864e     // Catch:{ all -> 0x0330 }
            r16 = 0
            if (r3 <= 0) goto L_0x017d
            com.google.android.play.core.assetpacks.dq r3 = r0.mo149023a()     // Catch:{ all -> 0x0330 }
            int r4 = r3.mo149019e()     // Catch:{ all -> 0x0330 }
            int r5 = r2.f52864e     // Catch:{ all -> 0x0330 }
            int r6 = r5 + -1
            if (r4 != r6) goto L_0x015d
            int r4 = r3.mo149015a()     // Catch:{ all -> 0x0330 }
            if (r4 == r13) goto L_0x00d9
            if (r4 == r12) goto L_0x009c
            if (r4 != r11) goto L_0x0082
            com.google.android.play.core.internal.ag r4 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r5 = "Resuming central directory from last chunk."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r4.mo149081a(r5, r6)     // Catch:{ all -> 0x0330 }
            long r3 = r3.mo149017c()     // Catch:{ all -> 0x0330 }
            r0.mo149026a((java.io.InputStream) r15, (long) r3)     // Catch:{ all -> 0x0330 }
            boolean r3 = r23.mo148964a()     // Catch:{ all -> 0x0330 }
            if (r3 == 0) goto L_0x0078
        L_0x0074:
            r4 = r16
            goto L_0x017e
        L_0x0078:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = "Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB."
            int r4 = r2.f52952j     // Catch:{ all -> 0x0330 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0330 }
            throw r0     // Catch:{ all -> 0x0330 }
        L_0x0082:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0330 }
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x0330 }
            int r3 = r3.mo149015a()     // Catch:{ all -> 0x0330 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0330 }
            r4[r14] = r3     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = "Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s."
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0330 }
            int r4 = r2.f52952j     // Catch:{ all -> 0x0330 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0330 }
            throw r0     // Catch:{ all -> 0x0330 }
        L_0x009c:
            com.google.android.play.core.internal.ag r3 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r4 = "Resuming zip entry from last chunk during local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r3.mo149081a(r4, r5)     // Catch:{ all -> 0x0330 }
            com.google.android.play.core.assetpacks.bb r3 = r1.f52871c     // Catch:{ all -> 0x0330 }
            java.lang.String r4 = r2.f52953k     // Catch:{ all -> 0x0330 }
            int r5 = r2.f52860a     // Catch:{ all -> 0x0330 }
            long r6 = r2.f52861b     // Catch:{ all -> 0x0330 }
            java.lang.String r8 = r2.f52862c     // Catch:{ all -> 0x0330 }
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r21 = r8
            java.io.File r3 = r16.mo148924d(r17, r18, r19, r21)     // Catch:{ all -> 0x0330 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0330 }
            if (r4 == 0) goto L_0x00cf
            java.io.SequenceInputStream r4 = new java.io.SequenceInputStream     // Catch:{ all -> 0x0330 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0330 }
            r5.<init>(r3)     // Catch:{ all -> 0x0330 }
            r4.<init>(r5, r15)     // Catch:{ all -> 0x0330 }
            goto L_0x017e
        L_0x00cf:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = "Checkpoint extension file not found."
            int r4 = r2.f52952j     // Catch:{ all -> 0x0330 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0330 }
            throw r0     // Catch:{ all -> 0x0330 }
        L_0x00d9:
            com.google.android.play.core.internal.ag r4 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x0330 }
            java.lang.String r6 = r3.mo149016b()     // Catch:{ all -> 0x0330 }
            r5[r14] = r6     // Catch:{ all -> 0x0330 }
            java.lang.String r6 = "Resuming zip entry from last chunk during file %s."
            r4.mo149081a(r6, r5)     // Catch:{ all -> 0x0330 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0330 }
            java.lang.String r5 = r3.mo149016b()     // Catch:{ all -> 0x0330 }
            r4.<init>(r5)     // Catch:{ all -> 0x0330 }
            boolean r5 = r4.exists()     // Catch:{ all -> 0x0330 }
            if (r5 == 0) goto L_0x0153
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0330 }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ all -> 0x0330 }
            long r6 = r3.mo149017c()     // Catch:{ all -> 0x0330 }
            r5.seek(r6)     // Catch:{ all -> 0x0330 }
            long r6 = r3.mo149018d()     // Catch:{ all -> 0x0330 }
        L_0x0109:
            byte[] r3 = r1.f52870b     // Catch:{ all -> 0x0330 }
            int r3 = r3.length     // Catch:{ all -> 0x0330 }
            long r8 = (long) r3     // Catch:{ all -> 0x0330 }
            long r8 = java.lang.Math.min(r6, r8)     // Catch:{ all -> 0x0330 }
            int r3 = (int) r8     // Catch:{ all -> 0x0330 }
            byte[] r8 = r1.f52870b     // Catch:{ all -> 0x0330 }
            int r8 = r15.read(r8, r14, r3)     // Catch:{ all -> 0x0330 }
            int r8 = java.lang.Math.max(r8, r14)     // Catch:{ all -> 0x0330 }
            if (r8 <= 0) goto L_0x0123
            byte[] r9 = r1.f52870b     // Catch:{ all -> 0x0330 }
            r5.write(r9, r14, r8)     // Catch:{ all -> 0x0330 }
        L_0x0123:
            long r10 = (long) r8     // Catch:{ all -> 0x0330 }
            long r9 = r6 - r10
            r6 = 0
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x0132
            if (r8 > 0) goto L_0x012f
            goto L_0x0132
        L_0x012f:
            r6 = r9
            r11 = 3
            goto L_0x0109
        L_0x0132:
            long r6 = r5.length()     // Catch:{ all -> 0x0330 }
            r5.close()     // Catch:{ all -> 0x0330 }
            if (r8 == r3) goto L_0x017d
            com.google.android.play.core.internal.ag r3 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r5 = "Chunk has ended while resuming the previous chunks file content."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r3.mo149081a(r5, r8)     // Catch:{ all -> 0x0330 }
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0330 }
            int r11 = r2.f52864e     // Catch:{ all -> 0x0330 }
            r3 = r0
            r5 = r6
            r7 = r9
            r9 = r11
            r3.mo149027a((java.lang.String) r4, (long) r5, (long) r7, (int) r9)     // Catch:{ all -> 0x0330 }
            goto L_0x0074
        L_0x0153:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = "Partial file specified in checkpoint does not exist. Corrupt directory."
            int r4 = r2.f52952j     // Catch:{ all -> 0x0330 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0330 }
            throw r0     // Catch:{ all -> 0x0330 }
        L_0x015d:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0330 }
            java.lang.String r4 = "Trying to resume with chunk number %s when previously processed chunk was number %s."
            java.lang.Object[] r6 = new java.lang.Object[r12]     // Catch:{ all -> 0x0330 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0330 }
            r6[r14] = r5     // Catch:{ all -> 0x0330 }
            int r3 = r3.mo149019e()     // Catch:{ all -> 0x0330 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0330 }
            r6[r13] = r3     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = java.lang.String.format(r4, r6)     // Catch:{ all -> 0x0330 }
            int r4 = r2.f52952j     // Catch:{ all -> 0x0330 }
            r0.<init>((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0330 }
            throw r0     // Catch:{ all -> 0x0330 }
        L_0x017d:
            r4 = r15
        L_0x017e:
            if (r4 == 0) goto L_0x028b
            com.google.android.play.core.assetpacks.bm r3 = new com.google.android.play.core.assetpacks.bm     // Catch:{ all -> 0x0330 }
            r3.<init>(r4)     // Catch:{ all -> 0x0330 }
            java.io.File r5 = r22.m37567b(r23)     // Catch:{ all -> 0x0330 }
        L_0x0189:
            com.google.android.play.core.assetpacks.dx r6 = r3.mo148954a()     // Catch:{ all -> 0x0330 }
            boolean r7 = r6.mo149044f()     // Catch:{ all -> 0x0330 }
            if (r7 != 0) goto L_0x01e0
            boolean r7 = r3.mo148956c()     // Catch:{ all -> 0x0330 }
            if (r7 != 0) goto L_0x01e0
            boolean r7 = r6.mo149039b()     // Catch:{ all -> 0x0330 }
            if (r7 == 0) goto L_0x01d9
            boolean r7 = r6.mo149038a()     // Catch:{ all -> 0x0330 }
            if (r7 != 0) goto L_0x01d9
            byte[] r7 = r6.mo149046h()     // Catch:{ all -> 0x0330 }
            r0.mo149028a((byte[]) r7)     // Catch:{ all -> 0x0330 }
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x0330 }
            java.lang.String r8 = r6.mo149040c()     // Catch:{ all -> 0x0330 }
            r7.<init>(r5, r8)     // Catch:{ all -> 0x0330 }
            java.io.File r8 = r7.getParentFile()     // Catch:{ all -> 0x0330 }
            r8.mkdirs()     // Catch:{ all -> 0x0330 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ all -> 0x0330 }
            r8.<init>(r7)     // Catch:{ all -> 0x0330 }
            byte[] r7 = r1.f52870b     // Catch:{ all -> 0x0330 }
            int r7 = r3.read(r7)     // Catch:{ all -> 0x0330 }
        L_0x01c7:
            if (r7 <= 0) goto L_0x01d5
            byte[] r9 = r1.f52870b     // Catch:{ all -> 0x0330 }
            r8.write(r9, r14, r7)     // Catch:{ all -> 0x0330 }
            byte[] r7 = r1.f52870b     // Catch:{ all -> 0x0330 }
            int r7 = r3.read(r7)     // Catch:{ all -> 0x0330 }
            goto L_0x01c7
        L_0x01d5:
            r8.close()     // Catch:{ all -> 0x0330 }
            goto L_0x01e0
        L_0x01d9:
            byte[] r7 = r6.mo149046h()     // Catch:{ all -> 0x0330 }
            r0.mo149030a((byte[]) r7, (java.io.InputStream) r3)     // Catch:{ all -> 0x0330 }
        L_0x01e0:
            boolean r7 = r3.mo148955b()     // Catch:{ all -> 0x0330 }
            if (r7 != 0) goto L_0x01ec
            boolean r7 = r3.mo148956c()     // Catch:{ all -> 0x0330 }
            if (r7 == 0) goto L_0x0189
        L_0x01ec:
            boolean r5 = r3.mo148956c()     // Catch:{ all -> 0x0330 }
            if (r5 == 0) goto L_0x0202
            com.google.android.play.core.internal.ag r5 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r7 = "Writing central directory metadata."
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r5.mo149081a(r7, r8)     // Catch:{ all -> 0x0330 }
            byte[] r5 = r6.mo149046h()     // Catch:{ all -> 0x0330 }
            r0.mo149030a((byte[]) r5, (java.io.InputStream) r4)     // Catch:{ all -> 0x0330 }
        L_0x0202:
            boolean r4 = r23.mo148964a()     // Catch:{ all -> 0x0330 }
            if (r4 != 0) goto L_0x028b
            boolean r4 = r6.mo149044f()     // Catch:{ all -> 0x0330 }
            if (r4 == 0) goto L_0x0221
            com.google.android.play.core.internal.ag r3 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r4 = "Writing slice checkpoint for partial local file header."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r3.mo149081a(r4, r5)     // Catch:{ all -> 0x0330 }
            byte[] r3 = r6.mo149046h()     // Catch:{ all -> 0x0330 }
            int r4 = r2.f52864e     // Catch:{ all -> 0x0330 }
            r0.mo149029a((byte[]) r3, (int) r4)     // Catch:{ all -> 0x0330 }
            goto L_0x028b
        L_0x0221:
            boolean r4 = r3.mo148956c()     // Catch:{ all -> 0x0330 }
            if (r4 == 0) goto L_0x0236
            com.google.android.play.core.internal.ag r3 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r4 = "Writing slice checkpoint for central directory."
            java.lang.Object[] r5 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r3.mo149081a(r4, r5)     // Catch:{ all -> 0x0330 }
            int r3 = r2.f52864e     // Catch:{ all -> 0x0330 }
            r0.mo149024a((int) r3)     // Catch:{ all -> 0x0330 }
            goto L_0x028b
        L_0x0236:
            int r4 = r6.mo149042e()     // Catch:{ all -> 0x0330 }
            if (r4 != 0) goto L_0x026c
            com.google.android.play.core.internal.ag r4 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r5 = "Writing slice checkpoint for partial file."
            java.lang.Object[] r7 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r4.mo149081a(r5, r7)     // Catch:{ all -> 0x0330 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0330 }
            java.io.File r5 = r22.m37567b(r23)     // Catch:{ all -> 0x0330 }
            java.lang.String r7 = r6.mo149040c()     // Catch:{ all -> 0x0330 }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x0330 }
            long r5 = r6.mo149041d()     // Catch:{ all -> 0x0330 }
            long r7 = r3.mo148957d()     // Catch:{ all -> 0x0330 }
            long r5 = r5 - r7
            long r7 = r4.length()     // Catch:{ all -> 0x0330 }
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0264
            goto L_0x027d
        L_0x0264:
            com.google.android.play.core.assetpacks.bv r0 = new com.google.android.play.core.assetpacks.bv     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = "Partial file is of unexpected size."
            r0.<init>(r3)     // Catch:{ all -> 0x0330 }
            throw r0     // Catch:{ all -> 0x0330 }
        L_0x026c:
            com.google.android.play.core.internal.ag r4 = f52869a     // Catch:{ all -> 0x0330 }
            java.lang.String r5 = "Writing slice checkpoint for partial unextractable file."
            java.lang.Object[] r6 = new java.lang.Object[r14]     // Catch:{ all -> 0x0330 }
            r4.mo149081a(r5, r6)     // Catch:{ all -> 0x0330 }
            java.io.File r4 = r0.mo149031b()     // Catch:{ all -> 0x0330 }
            long r5 = r4.length()     // Catch:{ all -> 0x0330 }
        L_0x027d:
            java.lang.String r4 = r4.getCanonicalPath()     // Catch:{ all -> 0x0330 }
            long r7 = r3.mo148957d()     // Catch:{ all -> 0x0330 }
            int r9 = r2.f52864e     // Catch:{ all -> 0x0330 }
            r3 = r0
            r3.mo149027a((java.lang.String) r4, (long) r5, (long) r7, (int) r9)     // Catch:{ all -> 0x0330 }
        L_0x028b:
            r15.close()     // Catch:{ IOException -> 0x033c }
            boolean r3 = r23.mo148964a()
            if (r3 == 0) goto L_0x02b4
            int r3 = r2.f52864e     // Catch:{ IOException -> 0x029a }
            r0.mo149032b(r3)     // Catch:{ IOException -> 0x029a }
            goto L_0x02b4
        L_0x029a:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = f52869a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "Writing extraction finished checkpoint failed with %s."
            r3.mo149083b(r5, r4)
            com.google.android.play.core.assetpacks.bv r3 = new com.google.android.play.core.assetpacks.bv
            int r2 = r2.f52952j
            java.lang.String r4 = "Writing extraction finished checkpoint failed."
            r3.<init>(r4, r0, r2)
            throw r3
        L_0x02b4:
            com.google.android.play.core.internal.ag r0 = f52869a
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            int r4 = r2.f52864e
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r14] = r4
            java.lang.String r4 = r2.f52862c
            r3[r13] = r4
            java.lang.String r4 = r2.f52953k
            r3[r12] = r4
            int r4 = r2.f52952j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 3
            r3[r5] = r4
            java.lang.String r4 = "Extraction finished for chunk %s of slice %s of pack %s of session %s."
            r0.mo149084c(r4, r3)
            com.google.android.play.core.internal.ck<com.google.android.play.core.assetpacks.w> r0 = r1.f52872d
            java.lang.Object r0 = r0.mo149139a()
            com.google.android.play.core.assetpacks.w r0 = (com.google.android.play.core.assetpacks.C18415w) r0
            int r3 = r2.f52952j
            java.lang.String r4 = r2.f52953k
            java.lang.String r5 = r2.f52862c
            int r6 = r2.f52864e
            r0.mo148894a(r3, r4, r5, r6)
            java.io.InputStream r0 = r2.f52868i     // Catch:{ IOException -> 0x02f0 }
            r0.close()     // Catch:{ IOException -> 0x02f0 }
            goto L_0x030a
        L_0x02f0:
            com.google.android.play.core.internal.ag r0 = f52869a
            r3 = 3
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r3 = r2.f52864e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r4[r14] = r3
            java.lang.String r3 = r2.f52862c
            r4[r13] = r3
            java.lang.String r3 = r2.f52953k
            r4[r12] = r3
            java.lang.String r3 = "Could not close file for chunk %s of slice %s of pack %s."
            r0.mo149085d(r3, r4)
        L_0x030a:
            int r0 = r2.f52867h
            r3 = 3
            if (r0 != r3) goto L_0x032f
            com.google.android.play.core.internal.ck<com.google.android.play.core.assetpacks.aw> r0 = r1.f52873e
            java.lang.Object r0 = r0.mo149139a()
            com.google.android.play.core.assetpacks.aw r0 = (com.google.android.play.core.assetpacks.C18313aw) r0
            java.lang.String r3 = r2.f52953k
            long r7 = r2.f52866g
            r4 = 3
            r5 = 0
            com.google.android.play.core.assetpacks.bz r6 = r1.f52874f
            double r9 = r6.mo148970a(r3, r2)
            r11 = 1
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r7
            com.google.android.play.core.assetpacks.AssetPackState r2 = com.google.android.play.core.assetpacks.AssetPackState.m37427a(r2, r3, r4, r5, r7, r9, r11)
            r0.mo148903a((com.google.android.play.core.assetpacks.AssetPackState) r2)
        L_0x032f:
            return
        L_0x0330:
            r0 = move-exception
            r3 = r0
            r15.close()     // Catch:{ all -> 0x0336 }
            goto L_0x033b
        L_0x0336:
            r0 = move-exception
            r4 = r0
            com.google.android.play.core.internal.C18489cj.m37906a(r3, r4)     // Catch:{ IOException -> 0x033c }
        L_0x033b:
            throw r3     // Catch:{ IOException -> 0x033c }
        L_0x033c:
            r0 = move-exception
            com.google.android.play.core.internal.ag r3 = f52869a
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.String r5 = r0.getMessage()
            r4[r14] = r5
            java.lang.String r5 = "IOException during extraction %s."
            r3.mo149083b(r5, r4)
            com.google.android.play.core.assetpacks.bv r3 = new com.google.android.play.core.assetpacks.bv
            r4 = 4
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r2.f52864e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r14] = r5
            java.lang.String r5 = r2.f52862c
            r4[r13] = r5
            java.lang.String r5 = r2.f52953k
            r4[r12] = r5
            int r5 = r2.f52952j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 3
            r4[r6] = r5
            java.lang.String r5 = "Error extracting chunk %s of slice %s of pack %s of session %s."
            java.lang.String r4 = java.lang.String.format(r5, r4)
            int r2 = r2.f52952j
            r3.<init>(r4, r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C18337bt.mo148965a(com.google.android.play.core.assetpacks.bs):void");
    }
}
