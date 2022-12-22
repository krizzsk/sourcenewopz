package com.p222hp.hpl.sparta;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

/* renamed from: com.hp.hpl.sparta.g */
/* compiled from: ParseByteStream */
class C19749g implements ParseSource {

    /* renamed from: a */
    private C19750h f53913a;

    public C19749g(String str, InputStream inputStream, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, IOException {
        String str3 = str;
        InputStream inputStream2 = inputStream;
        ParseLog parseLog2 = parseLog == null ? DEFAULT_LOG : parseLog;
        if (inputStream.markSupported()) {
            inputStream2.mark(MAXLOOKAHEAD);
            byte[] bArr = new byte[4];
            String a = str2 == null ? m38573a(str3, bArr, inputStream2.read(bArr), parseLog2) : str2;
            try {
                inputStream.reset();
                try {
                    this.f53913a = new C19750h(str, (Reader) new InputStreamReader(inputStream2, m38572a(a)), parseLog2, a, parseHandler);
                } catch (IOException unused) {
                    parseLog2.note("Problem reading with assumed encoding of " + a + " so restarting with " + "euc-jp", str3, 1);
                    inputStream.reset();
                    this.f53913a = new C19750h(str, (Reader) new InputStreamReader(inputStream2, m38572a("euc-jp")), parseLog2, (String) null, parseHandler);
                }
            } catch (UnsupportedEncodingException unused2) {
                throw new ParseException(parseLog2, str, 1, 0, "euc-jp", Const.jsQuote + "euc-jp" + "\" is not a supported encoding");
            } catch (EncodingMismatchException e) {
                String declaredEncoding = e.getDeclaredEncoding();
                parseLog2.note("Encoding declaration of " + declaredEncoding + " is different that assumed " + a + " so restarting the parsing with the new encoding", str3, 1);
                inputStream.reset();
                try {
                    this.f53913a = new C19750h(str, (Reader) new InputStreamReader(inputStream2, m38572a(declaredEncoding)), parseLog2, (String) null, parseHandler);
                } catch (UnsupportedEncodingException unused3) {
                    throw new ParseException(parseLog2, str, 1, 0, declaredEncoding, Const.jsQuote + declaredEncoding + "\" is not a supported encoding");
                }
            }
        } else {
            throw new Error("Precondition violation: the InputStream passed to ParseByteStream must support mark");
        }
    }

    public String toString() {
        return this.f53913a.toString();
    }

    public String getSystemId() {
        return this.f53913a.getSystemId();
    }

    public int getLineNumber() {
        return this.f53913a.getLineNumber();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m38573a(java.lang.String r5, byte[] r6, int r7, com.p222hp.hpl.sparta.ParseLog r8) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "UTF-8"
            r3 = 4
            if (r7 == r3) goto L_0x002d
            if (r7 > 0) goto L_0x000c
            java.lang.String r7 = "no characters in input"
            goto L_0x0027
        L_0x000c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "less than 4 characters in input: \""
            r3.append(r4)
            java.lang.String r4 = new java.lang.String
            r4.<init>(r6, r0, r7)
            r3.append(r4)
            java.lang.String r7 = "\""
            r3.append(r7)
            java.lang.String r7 = r3.toString()
        L_0x0027:
            r8.error(r7, r5, r1)
        L_0x002a:
            r7 = r2
            goto L_0x00b2
        L_0x002d:
            r7 = 65279(0xfeff, float:9.1475E-41)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = -131072(0xfffffffffffe0000, float:NaN)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 65534(0xfffe, float:9.1833E-41)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 60
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 1006632960(0x3c000000, float:0.0078125)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 15360(0x3c00, float:2.1524E-41)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 != 0) goto L_0x00b0
            r7 = 3932160(0x3c0000, float:5.51013E-39)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x0070
            goto L_0x00b0
        L_0x0070:
            r7 = 3932223(0x3c003f, float:5.510218E-39)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "UTF-16BE"
            goto L_0x00b2
        L_0x007c:
            r7 = 1006649088(0x3c003f00, float:0.00782752)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x0088
            java.lang.String r7 = "UTF-16LE"
            goto L_0x00b2
        L_0x0088:
            r7 = 1010792557(0x3c3f786d, float:0.011686427)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x0092
            goto L_0x002a
        L_0x0092:
            r7 = 1282385812(0x4c6fa794, float:6.2824016E7)
            boolean r7 = m38574a((byte[]) r6, (int) r7)
            if (r7 == 0) goto L_0x009e
            java.lang.String r7 = "EBCDIC"
            goto L_0x00b2
        L_0x009e:
            r7 = -2
            boolean r7 = m38575a((byte[]) r6, (short) r7)
            if (r7 != 0) goto L_0x00ad
            r7 = -257(0xfffffffffffffeff, float:NaN)
            boolean r7 = m38575a((byte[]) r6, (short) r7)
            if (r7 == 0) goto L_0x002a
        L_0x00ad:
            java.lang.String r7 = "UTF-16"
            goto L_0x00b2
        L_0x00b0:
            java.lang.String r7 = "UCS-4"
        L_0x00b2:
            boolean r2 = r7.equals(r2)
            if (r2 != 0) goto L_0x0102
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "From start "
            r2.append(r3)
            byte r0 = r6[r0]
            java.lang.String r0 = m38571a((byte) r0)
            r2.append(r0)
            java.lang.String r0 = " "
            r2.append(r0)
            byte r3 = r6[r1]
            java.lang.String r3 = m38571a((byte) r3)
            r2.append(r3)
            r2.append(r0)
            r3 = 2
            byte r3 = r6[r3]
            java.lang.String r3 = m38571a((byte) r3)
            r2.append(r3)
            r2.append(r0)
            r0 = 3
            byte r6 = r6[r0]
            java.lang.String r6 = m38571a((byte) r6)
            r2.append(r6)
            java.lang.String r6 = " deduced encoding = "
            r2.append(r6)
            r2.append(r7)
            java.lang.String r6 = r2.toString()
            r8.note(r6, r5, r1)
        L_0x0102:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p222hp.hpl.sparta.C19749g.m38573a(java.lang.String, byte[], int, com.hp.hpl.sparta.ParseLog):java.lang.String");
    }

    /* renamed from: a */
    private static String m38571a(byte b) {
        String hexString = Integer.toHexString(b);
        int length = hexString.length();
        if (length != 1) {
            return length != 2 ? hexString.substring(hexString.length() - 2) : hexString;
        }
        return "0" + hexString;
    }

    /* renamed from: a */
    private static boolean m38574a(byte[] bArr, int i) {
        return bArr[0] == ((byte) (i >>> 24)) && bArr[1] == ((byte) ((i >>> 16) & 255)) && bArr[2] == ((byte) ((i >>> 8) & 255)) && bArr[3] == ((byte) (i & 255));
    }

    /* renamed from: a */
    private static boolean m38575a(byte[] bArr, short s) {
        return bArr[0] == ((byte) (s >>> 8)) && bArr[1] == ((byte) (s & 255));
    }

    /* renamed from: a */
    private static String m38572a(String str) {
        return str.toLowerCase().equals("utf8") ? "UTF-8" : str;
    }
}
