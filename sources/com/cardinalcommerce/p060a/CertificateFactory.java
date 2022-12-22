package com.cardinalcommerce.p060a;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cardinalcommerce.a.CertificateFactory */
public final class CertificateFactory {

    /* renamed from: a */
    private final C1890configure[] f2349a;

    /* renamed from: com.cardinalcommerce.a.CertificateFactory$configure */
    class C1890configure {
        private final String cca_continue;
        private final String init;

        /* synthetic */ C1890configure(CertificateFactory certificateFactory, String str) {
            this(str);
        }

        private C1890configure(String str) {
            StringBuilder sb = new StringBuilder("-----BEGIN ");
            sb.append(str);
            sb.append("-----");
            this.cca_continue = sb.toString();
            StringBuilder sb2 = new StringBuilder("-----END ");
            sb2.append(str);
            sb2.append("-----");
            this.init = sb2.toString();
        }

        public final boolean Cardinal(String str) {
            return str.startsWith(this.cca_continue);
        }

        public final boolean getInstance(String str) {
            return str.startsWith(this.init);
        }
    }

    public CertificateFactory(String str) {
        this.f2349a = new C1890configure[]{new C1890configure(this, str), new C1890configure(this, "X509 ".concat(String.valueOf(str))), new C1890configure(this, "PKCS7")};
    }

    /* renamed from: a */
    private C1890configure m1796a(String str) {
        C1890configure configure;
        int i = 0;
        while (true) {
            C1890configure[] configureArr = this.f2349a;
            if (i == configureArr.length) {
                return null;
            }
            configure = configureArr[i];
            if (configure.Cardinal(str) || configure.getInstance(str)) {
                return configure;
            }
            i++;
        }
        return configure;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m1797a(java.io.InputStream r5) throws java.io.IOException {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
        L_0x0005:
            int r1 = r5.read()
            r2 = 10
            r3 = 13
            if (r1 == r3) goto L_0x0018
            if (r1 == r2) goto L_0x0018
            if (r1 < 0) goto L_0x0018
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0005
        L_0x0018:
            if (r1 < 0) goto L_0x0020
            int r4 = r0.length()
            if (r4 == 0) goto L_0x0005
        L_0x0020:
            if (r1 >= 0) goto L_0x002f
            int r5 = r0.length()
            if (r5 != 0) goto L_0x002a
            r5 = 0
            return r5
        L_0x002a:
            java.lang.String r5 = r0.toString()
            return r5
        L_0x002f:
            if (r1 != r3) goto L_0x0043
            r1 = 1
            r5.mark(r1)
            int r3 = r5.read()
            if (r3 != r2) goto L_0x003e
            r5.mark(r1)
        L_0x003e:
            if (r3 <= 0) goto L_0x0043
            r5.reset()
        L_0x0043:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.CertificateFactory.m1797a(java.io.InputStream):java.lang.String");
    }

    public final setThreeDSRequestorAppURL configure(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        C1890configure configure = null;
        while (configure == null) {
            String a = m1797a(inputStream);
            if (a == null) {
                break;
            }
            configure = m1796a(a);
            if (configure != null && !configure.Cardinal(a)) {
                throw new IOException("malformed PEM data: found footer where header was expected");
            }
        }
        if (configure != null) {
            C1890configure configure2 = null;
            while (configure2 == null) {
                String a2 = m1797a(inputStream);
                if (a2 == null) {
                    break;
                }
                configure2 = m1796a(a2);
                if (configure2 == null) {
                    stringBuffer.append(a2);
                } else if (!configure.getInstance(a2)) {
                    throw new IOException("malformed PEM data: header/footer mismatch");
                }
            }
            if (configure2 == null) {
                throw new IOException("malformed PEM data: no footer found");
            } else if (stringBuffer.length() == 0) {
                return null;
            } else {
                try {
                    return setThreeDSRequestorAppURL.cca_continue((Object) setOnSystemUiVisibilityChangeListener.cca_continue(stringBuffer.toString()));
                } catch (Exception unused) {
                    throw new IOException("malformed PEM data encountered");
                }
            }
        } else {
            throw new IOException("malformed PEM data: no header found");
        }
    }
}
