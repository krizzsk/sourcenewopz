package kotlin.p245io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: kotlin.io.LineReader */
/* compiled from: Console.kt */
public final class LineReader {
    public static final LineReader INSTANCE = new LineReader();

    /* renamed from: a */
    private static final int f59881a = 32;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static CharsetDecoder f59882b;

    /* renamed from: c */
    private static boolean f59883c;

    /* renamed from: d */
    private static final byte[] f59884d;

    /* renamed from: e */
    private static final char[] f59885e = new char[32];

    /* renamed from: f */
    private static final ByteBuffer f59886f;

    /* renamed from: g */
    private static final CharBuffer f59887g;

    /* renamed from: h */
    private static final StringBuilder f59888h = new StringBuilder();

    static {
        byte[] bArr = new byte[32];
        f59884d = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "ByteBuffer.wrap(bytes)");
        f59886f = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(f59885e);
        Intrinsics.checkNotNullExpressionValue(wrap2, "CharBuffer.wrap(chars)");
        f59887g = wrap2;
    }

    private LineReader() {
    }

    public static final /* synthetic */ CharsetDecoder access$getDecoder$p(LineReader lineReader) {
        CharsetDecoder charsetDecoder = f59882b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        return charsetDecoder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (f59888h.length() != 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r10 == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r0 != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2 != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r10 = m44142a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.charset(), (java.lang.Object) r11)) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String readLine(java.io.InputStream r10, java.nio.charset.Charset r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)     // Catch:{ all -> 0x00db }
            java.nio.charset.CharsetDecoder r0 = f59882b     // Catch:{ all -> 0x00db }
            r1 = 1
            if (r0 == 0) goto L_0x0024
            java.nio.charset.CharsetDecoder r0 = f59882b     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x0019
            java.lang.String r2 = "decoder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ all -> 0x00db }
        L_0x0019:
            java.nio.charset.Charset r0 = r0.charset()     // Catch:{ all -> 0x00db }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)     // Catch:{ all -> 0x00db }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0027
        L_0x0024:
            r9.m44144a((java.nio.charset.Charset) r11)     // Catch:{ all -> 0x00db }
        L_0x0027:
            r11 = 0
            r0 = 0
            r2 = 0
        L_0x002a:
            int r3 = r10.read()     // Catch:{ all -> 0x00db }
            r4 = 32
            r5 = 10
            r6 = -1
            if (r3 != r6) goto L_0x0050
            java.lang.StringBuilder r10 = f59888h     // Catch:{ all -> 0x00db }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x00db }
            int r10 = r10.length()     // Catch:{ all -> 0x00db }
            if (r10 != 0) goto L_0x0041
            r10 = 1
            goto L_0x0042
        L_0x0041:
            r10 = 0
        L_0x0042:
            if (r10 == 0) goto L_0x004b
            if (r0 != 0) goto L_0x004b
            if (r2 != 0) goto L_0x004b
            r10 = 0
            monitor-exit(r9)
            return r10
        L_0x004b:
            int r10 = r9.m44142a(r0, r2)     // Catch:{ all -> 0x00db }
            goto L_0x0080
        L_0x0050:
            byte[] r6 = f59884d     // Catch:{ all -> 0x00db }
            int r7 = r0 + 1
            byte r8 = (byte) r3     // Catch:{ all -> 0x00db }
            r6[r0] = r8     // Catch:{ all -> 0x00db }
            if (r3 == r5) goto L_0x0062
            if (r7 == r4) goto L_0x0062
            boolean r0 = f59883c     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r0 = r7
            goto L_0x002a
        L_0x0062:
            java.nio.ByteBuffer r0 = f59886f     // Catch:{ all -> 0x00db }
            r0.limit(r7)     // Catch:{ all -> 0x00db }
            java.nio.CharBuffer r0 = f59887g     // Catch:{ all -> 0x00db }
            r0.position(r2)     // Catch:{ all -> 0x00db }
            int r2 = r9.m44143a((boolean) r11)     // Catch:{ all -> 0x00db }
            if (r2 <= 0) goto L_0x00d5
            char[] r0 = f59885e     // Catch:{ all -> 0x00db }
            int r3 = r2 + -1
            char r0 = r0[r3]     // Catch:{ all -> 0x00db }
            if (r0 != r5) goto L_0x00d5
            java.nio.ByteBuffer r10 = f59886f     // Catch:{ all -> 0x00db }
            r10.position(r11)     // Catch:{ all -> 0x00db }
            r10 = r2
        L_0x0080:
            if (r10 <= 0) goto L_0x009a
            char[] r0 = f59885e     // Catch:{ all -> 0x00db }
            int r2 = r10 + -1
            char r0 = r0[r2]     // Catch:{ all -> 0x00db }
            if (r0 != r5) goto L_0x009a
            int r10 = r10 + -1
            if (r10 <= 0) goto L_0x009a
            char[] r0 = f59885e     // Catch:{ all -> 0x00db }
            int r2 = r10 + -1
            char r0 = r0[r2]     // Catch:{ all -> 0x00db }
            r2 = 13
            if (r0 != r2) goto L_0x009a
            int r10 = r10 + -1
        L_0x009a:
            java.lang.StringBuilder r0 = f59888h     // Catch:{ all -> 0x00db }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x00db }
            int r0 = r0.length()     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            if (r1 == 0) goto L_0x00b1
            char[] r0 = f59885e     // Catch:{ all -> 0x00db }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00db }
            r1.<init>(r0, r11, r10)     // Catch:{ all -> 0x00db }
            monitor-exit(r9)
            return r1
        L_0x00b1:
            java.lang.StringBuilder r0 = f59888h     // Catch:{ all -> 0x00db }
            char[] r1 = f59885e     // Catch:{ all -> 0x00db }
            r0.append(r1, r11, r10)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r10 = f59888h     // Catch:{ all -> 0x00db }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00db }
            java.lang.String r0 = "sb.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r0 = f59888h     // Catch:{ all -> 0x00db }
            int r0 = r0.length()     // Catch:{ all -> 0x00db }
            if (r0 <= r4) goto L_0x00ce
            r9.m44146c()     // Catch:{ all -> 0x00db }
        L_0x00ce:
            java.lang.StringBuilder r0 = f59888h     // Catch:{ all -> 0x00db }
            r0.setLength(r11)     // Catch:{ all -> 0x00db }
            monitor-exit(r9)
            return r10
        L_0x00d5:
            int r0 = r9.m44141a()     // Catch:{ all -> 0x00db }
            goto L_0x002a
        L_0x00db:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p245io.LineReader.readLine(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    /* renamed from: a */
    private final int m44143a(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = f59882b;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
            CoderResult decode = charsetDecoder.decode(f59886f, f59887g, z);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                m44145b();
                decode.throwException();
            }
            int position = f59887g.position();
            if (!decode.isOverflow()) {
                return position;
            }
            int i = position - 1;
            f59888h.append(f59885e, 0, i);
            f59887g.position(0);
            f59887g.limit(32);
            f59887g.put(f59885e[i]);
        }
    }

    /* renamed from: a */
    private final int m44141a() {
        ByteBuffer byteBuffer = f59886f;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    /* renamed from: a */
    private final int m44142a(int i, int i2) {
        f59886f.limit(i);
        f59887g.position(i2);
        int a = m44143a(true);
        CharsetDecoder charsetDecoder = f59882b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        f59886f.position(0);
        return a;
    }

    /* renamed from: a */
    private final void m44144a(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        f59882b = newDecoder;
        f59886f.clear();
        f59887g.clear();
        f59886f.put((byte) 10);
        f59886f.flip();
        CharsetDecoder charsetDecoder = f59882b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        boolean z = false;
        charsetDecoder.decode(f59886f, f59887g, false);
        if (f59887g.position() == 1 && f59887g.get(0) == 10) {
            z = true;
        }
        f59883c = z;
        m44145b();
    }

    /* renamed from: b */
    private final void m44145b() {
        CharsetDecoder charsetDecoder = f59882b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        f59886f.position(0);
        f59888h.setLength(0);
    }

    /* renamed from: c */
    private final void m44146c() {
        f59888h.setLength(32);
        f59888h.trimToSize();
    }
}
