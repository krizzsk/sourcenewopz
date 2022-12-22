package com.cardinalcommerce.p060a;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.IOException;

/* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache */
final class setPersistentDrawingCache {

    /* renamed from: a */
    public static final cca_continue f2914a = new cca_continue((byte) 0);

    /* renamed from: b */
    public static final C2063init f2915b = new C2063init((byte) 0);

    /* renamed from: c */
    public static final getInstance f2916c = new getInstance((byte) 0);

    /* renamed from: d */
    public static final Cardinal f2917d = new Cardinal((byte) 0);

    /* renamed from: e */
    public static final C2062configure f2918e = new C2062configure((byte) 0);

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$cleanup */
    public interface cleanup {
        void cca_continue(String str, Appendable appendable);
    }

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$values */
    public interface values {
        boolean Cardinal(String str);
    }

    /* renamed from: a */
    public static boolean m2050a(char c) {
        return c == 13 || c == 10 || c == 9 || c == ' ';
    }

    /* renamed from: b */
    public static boolean m2052b(char c) {
        return c == 8 || c == 12 || c == 10;
    }

    /* renamed from: c */
    public static boolean m2053c(char c) {
        return c == '}' || c == ']' || c == ',' || c == ':';
    }

    /* renamed from: d */
    public static boolean m2054d(char c) {
        return c == '{' || c == '[' || c == ',' || c == '}' || c == ']' || c == ':' || c == '\'' || c == '\"';
    }

    /* renamed from: e */
    public static boolean m2055e(char c) {
        if (c >= 0 && c <= 31) {
            return true;
        }
        if (c < 127 || c > 159) {
            return c >= 8192 && c <= 8447;
        }
        return true;
    }

    setPersistentDrawingCache() {
    }

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$init */
    static class C2063init implements values {
        public final boolean Cardinal(String str) {
            return true;
        }

        private C2063init() {
        }

        /* synthetic */ C2063init(byte b) {
            this();
        }
    }

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$cca_continue */
    static class cca_continue implements values {
        private cca_continue() {
        }

        /* synthetic */ cca_continue(byte b) {
            this();
        }

        public final boolean Cardinal(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char charAt2 = str.charAt(i);
                if (setPersistentDrawingCache.m2050a(charAt2) || setPersistentDrawingCache.m2054d(charAt2) || setPersistentDrawingCache.m2052b(charAt2) || setPersistentDrawingCache.m2055e(charAt2)) {
                    return true;
                }
            }
            return setPersistentDrawingCache.m2051a(str);
        }
    }

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$getInstance */
    static class getInstance implements values {
        private getInstance() {
        }

        /* synthetic */ getInstance(byte b) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
            if (r3 == '.') goto L_0x0061;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0056, code lost:
            if (r7 < r1) goto L_0x0059;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0059, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005d, code lost:
            if (r3 < '0') goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005f, code lost:
            if (r3 > '9') goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0061, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0063, code lost:
            if (r7 != r1) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0065, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
            if (r3 == 'E') goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x006c, code lost:
            if (r3 != 'e') goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x006e, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0070, code lost:
            if (r7 != r1) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0072, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0073, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0079, code lost:
            if (r3 == '+') goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x007b, code lost:
            if (r3 != '-') goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007d, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x007f, code lost:
            if (r7 != r1) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0081, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0082, code lost:
            if (r7 < r1) goto L_0x0085;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0085, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0089, code lost:
            if (r3 < '0') goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x008b, code lost:
            if (r3 > '9') goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x008d, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0090, code lost:
            if (r7 != r1) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0092, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean Cardinal(java.lang.String r10) {
            /*
                r9 = this;
                r0 = 0
                if (r10 != 0) goto L_0x0004
                return r0
            L_0x0004:
                int r1 = r10.length()
                r2 = 1
                if (r1 != 0) goto L_0x000c
                return r2
            L_0x000c:
                java.lang.String r3 = r10.trim()
                if (r3 == r10) goto L_0x0013
                return r2
            L_0x0013:
                char r3 = r10.charAt(r0)
                boolean r4 = com.cardinalcommerce.p060a.setPersistentDrawingCache.m2054d(r3)
                if (r4 != 0) goto L_0x00a9
                boolean r3 = com.cardinalcommerce.p060a.setPersistentDrawingCache.m2055e(r3)
                if (r3 == 0) goto L_0x0025
                goto L_0x00a9
            L_0x0025:
                r3 = 1
            L_0x0026:
                if (r3 < r1) goto L_0x0094
                boolean r3 = com.cardinalcommerce.p060a.setPersistentDrawingCache.m2051a((java.lang.String) r10)
                if (r3 == 0) goto L_0x002f
                return r2
            L_0x002f:
                char r3 = r10.charAt(r0)
                r4 = 45
                r5 = 57
                r6 = 48
                if (r3 < r6) goto L_0x003d
                if (r3 <= r5) goto L_0x003f
            L_0x003d:
                if (r3 != r4) goto L_0x0093
            L_0x003f:
                r7 = 1
            L_0x0040:
                if (r7 < r1) goto L_0x0043
                goto L_0x004e
            L_0x0043:
                char r3 = r10.charAt(r7)
                if (r3 < r6) goto L_0x004e
                if (r3 > r5) goto L_0x004e
                int r7 = r7 + 1
                goto L_0x0040
            L_0x004e:
                if (r7 != r1) goto L_0x0051
                return r2
            L_0x0051:
                r8 = 46
                if (r3 != r8) goto L_0x0056
                goto L_0x0061
            L_0x0056:
                if (r7 < r1) goto L_0x0059
                goto L_0x0063
            L_0x0059:
                char r3 = r10.charAt(r7)
                if (r3 < r6) goto L_0x0063
                if (r3 > r5) goto L_0x0063
            L_0x0061:
                int r7 = r7 + r2
                goto L_0x0056
            L_0x0063:
                if (r7 != r1) goto L_0x0066
                return r2
            L_0x0066:
                r8 = 69
                if (r3 == r8) goto L_0x006e
                r8 = 101(0x65, float:1.42E-43)
                if (r3 != r8) goto L_0x007f
            L_0x006e:
                int r7 = r7 + 1
                if (r7 != r1) goto L_0x0073
                return r0
            L_0x0073:
                char r3 = r10.charAt(r7)
                r8 = 43
                if (r3 == r8) goto L_0x007d
                if (r3 != r4) goto L_0x007f
            L_0x007d:
                int r7 = r7 + 1
            L_0x007f:
                if (r7 != r1) goto L_0x0082
                return r0
            L_0x0082:
                if (r7 < r1) goto L_0x0085
                goto L_0x0090
            L_0x0085:
                char r3 = r10.charAt(r7)
                if (r3 < r6) goto L_0x0090
                if (r3 > r5) goto L_0x0090
                int r7 = r7 + 1
                goto L_0x0082
            L_0x0090:
                if (r7 != r1) goto L_0x0093
                return r2
            L_0x0093:
                return r0
            L_0x0094:
                char r4 = r10.charAt(r3)
                boolean r5 = com.cardinalcommerce.p060a.setPersistentDrawingCache.m2053c(r4)
                if (r5 != 0) goto L_0x00a9
                boolean r4 = com.cardinalcommerce.p060a.setPersistentDrawingCache.m2055e(r4)
                if (r4 == 0) goto L_0x00a5
                goto L_0x00a9
            L_0x00a5:
                int r3 = r3 + 1
                goto L_0x0026
            L_0x00a9:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setPersistentDrawingCache.getInstance.Cardinal(java.lang.String):boolean");
        }
    }

    /* renamed from: a */
    public static boolean m2051a(String str) {
        if (str.length() < 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == 'n') {
            return str.equals("null");
        }
        if (charAt == 't') {
            return str.equals("true");
        }
        if (charAt == 'f') {
            return str.equals(SDKConsts.BOOLEAN_FALSE);
        }
        if (charAt == 'N') {
            return str.equals("NaN");
        }
        return false;
    }

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$Cardinal */
    static class Cardinal implements cleanup {
        private Cardinal() {
        }

        /* synthetic */ Cardinal(byte b) {
            this();
        }

        public final void cca_continue(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == 12) {
                        appendable.append("\\f");
                    } else if (charAt == 13) {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case 8:
                                appendable.append("\\b");
                                break;
                            case 9:
                                appendable.append("\\t");
                                break;
                            case 10:
                                appendable.append("\\n");
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append(C2382a.f4810a.charAt((charAt >> 12) & 15));
                                    appendable.append(C2382a.f4810a.charAt((charAt >> 8) & 15));
                                    appendable.append(C2382a.f4810a.charAt((charAt >> 4) & 15));
                                    appendable.append(C2382a.f4810a.charAt(charAt & 15));
                                    break;
                                } else {
                                    appendable.append(charAt);
                                    break;
                                }
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exeption");
            }
        }
    }

    /* renamed from: com.cardinalcommerce.a.setPersistentDrawingCache$configure */
    static class C2062configure implements cleanup {
        private C2062configure() {
        }

        /* synthetic */ C2062configure(byte b) {
            this();
        }

        public final void cca_continue(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == 12) {
                        appendable.append("\\f");
                    } else if (charAt == 13) {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt == '/') {
                        appendable.append("\\/");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case 8:
                                appendable.append("\\b");
                                break;
                            case 9:
                                appendable.append("\\t");
                                break;
                            case 10:
                                appendable.append("\\n");
                                break;
                            default:
                                if ((charAt >= 0 && charAt <= 31) || ((charAt >= 127 && charAt <= 159) || (charAt >= 8192 && charAt <= 8447))) {
                                    appendable.append("\\u");
                                    appendable.append(C2382a.f4810a.charAt((charAt >> 12) & 15));
                                    appendable.append(C2382a.f4810a.charAt((charAt >> 8) & 15));
                                    appendable.append(C2382a.f4810a.charAt((charAt >> 4) & 15));
                                    appendable.append(C2382a.f4810a.charAt(charAt & 15));
                                    break;
                                } else {
                                    appendable.append(charAt);
                                    break;
                                }
                                break;
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }
}
