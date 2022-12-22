package p092super;

import androidx.exifinterface.media.ExifInterface;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.facebook.AuthenticationTokenClaims;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: super.break */
/* compiled from: MathEval */
public class C3089break {

    /* renamed from: a */
    private static final C3093new f6859a = new C3093new(0, 0, 0, 66, false, (C3094try) null);

    /* renamed from: b */
    private C3093new[] f6860b = new C3093new[256];

    /* renamed from: c */
    private final SortedMap<String, Double> f6861c;

    /* renamed from: d */
    private final SortedMap<String, Double> f6862d;

    /* renamed from: e */
    private final SortedMap<String, C3091for> f6863e;

    /* renamed from: f */
    private final SortedMap<String, C3091for> f6864f;

    /* renamed from: g */
    private boolean f6865g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f6866h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f6867i;

    /* renamed from: super.break$do */
    /* compiled from: MathEval */
    public final class C3090do {

        /* renamed from: do */
        final int f6868do;

        /* renamed from: if */
        int f6869if;

        C3090do(int i, int i2) {
            this.f6868do = i2;
            this.f6869if = i + 1;
            this.f6869if = C3089break.this.m3899a(C3089break.this.f6866h, this.f6869if, i2 - 1);
        }

        /* renamed from: do */
        private double m3920do() {
            if (C3089break.this.f6866h.charAt(this.f6869if) == ',') {
                this.f6869if++;
            }
            double a = C3089break.this.m3896a(this.f6869if, this.f6868do);
            this.f6869if = C3089break.this.f6867i;
            return a;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m46187for() {
            return C3089break.this.f6866h.charAt(this.f6869if) != ')';
        }

        /* access modifiers changed from: package-private */
        /* renamed from: if */
        public int mo38564if() {
            return this.f6869if;
        }

        /* renamed from: new  reason: not valid java name */
        public double m46188new() {
            if (m46187for()) {
                return m3920do();
            }
            throw C3089break.this.m3904a(this.f6869if, "Function has too few arguments");
        }
    }

    /* renamed from: super.break$for */
    /* compiled from: MathEval */
    public interface C3091for {
        /* renamed from: do */
        double mo38554do(String str, C3090do doVar) throws C3096do;
    }

    /* renamed from: super.break$new */
    /* compiled from: MathEval */
    public static final class C3093new {

        /* renamed from: case  reason: not valid java name */
        final C3094try f61691case;

        /* renamed from: do */
        final char f6872do;

        /* renamed from: for  reason: not valid java name */
        final int f61692for;

        /* renamed from: if */
        final int f6873if;

        /* renamed from: new  reason: not valid java name */
        final int f61693new;

        /* renamed from: try  reason: not valid java name */
        final boolean f61694try;

        public C3093new(char c, int i, C3094try tryR) {
            this(c, i, i, 66, false, tryR);
        }

        public String toString() {
            return "MathOperator['" + this.f6872do + "']";
        }

        C3093new(char c, int i, int i2, int i3, boolean z, C3094try tryR) {
            this.f6872do = c;
            this.f6873if = i;
            this.f61692for = i2;
            this.f61693new = i3;
            this.f61694try = z;
            this.f61691case = tryR;
        }
    }

    /* renamed from: super.break$try */
    /* compiled from: MathEval */
    public interface C3094try {
        /* renamed from: do */
        double mo38553do(double d, char c, double d2) throws C3096do;
    }

    static {
        C3092if ifVar = C3092if.f6870do;
    }

    public C3089break() {
        C3092if.m3924if(this);
        this.f6861c = new TreeMap();
        this.f6862d = new TreeMap();
        mo38556do(ExifInterface.LONGITUDE_EAST, 2.718281828459045d);
        mo38556do("Euler", 0.577215664901533d);
        mo38556do("LN2", 0.693147180559945d);
        mo38556do("LN10", 2.302585092994046d);
        mo38556do("LOG2E", 1.442695040888963d);
        mo38556do("LOG10E", 0.434294481903252d);
        mo38556do("PHI", 1.618033988749895d);
        mo38556do("PI", 3.141592653589793d);
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.f6863e = new TreeMap(comparator);
        this.f6864f = new TreeMap(comparator);
        C3092if.m3923do(this);
        this.f6865g = false;
        this.f6867i = 0;
    }

    /* renamed from: c */
    private double m3911c(int i, int i2) {
        while (i < i2 && Character.isWhitespace(this.f6866h.charAt(i2))) {
            i2--;
        }
        String substring = this.f6866h.substring(i, i2 + 1);
        Double d = (Double) this.f6861c.get(substring);
        if (d != null) {
            return d.doubleValue();
        }
        Double d2 = (Double) this.f6862d.get(substring);
        if (d2 != null) {
            return d2.doubleValue();
        }
        if (this.f6865g) {
            return 0.0d;
        }
        throw m3904a(i, "Unrecognized constant or variable \"" + substring + Const.jsQuote);
    }

    /* renamed from: super.break$if */
    /* compiled from: MathEval */
    static class C3092if implements C3091for, C3094try {

        /* renamed from: break  reason: not valid java name */
        private static final C3093new f61680break;

        /* renamed from: case  reason: not valid java name */
        private static final C3093new f61681case;

        /* renamed from: catch  reason: not valid java name */
        private static final C3093new f61682catch;

        /* renamed from: class  reason: not valid java name */
        private static final C3093new f61683class;

        /* renamed from: const  reason: not valid java name */
        private static final C3093new f61684const;

        /* renamed from: do */
        static final C3092if f6870do;

        /* renamed from: else  reason: not valid java name */
        private static final C3093new f61685else;

        /* renamed from: for  reason: not valid java name */
        private static final C3093new f61686for;

        /* renamed from: goto  reason: not valid java name */
        private static final C3093new f61687goto;

        /* renamed from: if */
        private static final C3093new f6871if;

        /* renamed from: new  reason: not valid java name */
        private static final C3093new f61688new;

        /* renamed from: this  reason: not valid java name */
        private static final C3093new f61689this;

        /* renamed from: try  reason: not valid java name */
        private static final C3093new f61690try;

        static {
            C3092if ifVar = new C3092if();
            f6870do = ifVar;
            C3092if ifVar2 = ifVar;
            f6871if = new C3093new('=', 99, 99, 82, true, ifVar2);
            f61686for = new C3093new('^', 80, 81, 66, false, ifVar2);
            f61688new = new C3093new(Typography.plusMinus, 60, 60, 82, true, ifVar2);
            f61690try = new C3093new('*', 40, ifVar);
            f61681case = new C3093new(Typography.times, 40, ifVar);
            f61685else = new C3093new(Typography.middleDot, 40, ifVar);
            f61687goto = new C3093new(VersionRange.LEFT_OPEN, 40, ifVar);
            f61689this = new C3093new(IOUtils.DIR_SEPARATOR_UNIX, 40, ifVar);
            f61680break = new C3093new(247, 40, ifVar);
            f61682catch = new C3093new('%', 40, ifVar);
            f61683class = new C3093new('+', 20, ifVar);
            f61684const = new C3093new('-', 20, ifVar);
        }

        private C3092if() {
        }

        /* renamed from: if */
        static void m3924if(C3089break breakR) {
            breakR.mo38560do(f6871if);
            breakR.mo38560do(f61686for);
            breakR.mo38560do(f61688new);
            breakR.mo38560do(f61690try);
            breakR.mo38560do(f61681case);
            breakR.mo38560do(f61685else);
            breakR.mo38560do(f61687goto);
            breakR.mo38560do(f61689this);
            breakR.mo38560do(f61680break);
            breakR.mo38560do(f61682catch);
            breakR.mo38560do(f61683class);
            breakR.mo38560do(f61684const);
        }

        /* renamed from: do */
        public double mo38553do(double d, char c, double d2) {
            if (c == '%') {
                return d % d2;
            }
            if (c == '(') {
                return d * d2;
            }
            if (c == '-') {
                return d - d2;
            }
            if (c == '/') {
                return d / d2;
            }
            if (c == '=') {
                return d2;
            }
            if (c == '^') {
                return Math.pow(d, d2);
            }
            if (c == 177) {
                return -d2;
            }
            if (c == 183) {
                return d * d2;
            }
            if (c == 215) {
                return d * d2;
            }
            if (c == 247) {
                return d / d2;
            }
            if (c == '*') {
                return d * d2;
            }
            if (c == '+') {
                return d + d2;
            }
            throw new UnsupportedOperationException("MathEval internal operator setup is incorrect - internal operator \"" + c + "\" not handled");
        }

        /* renamed from: do */
        public double mo38554do(String str, C3090do doVar) throws C3096do {
            char lowerCase = Character.toLowerCase(str.charAt(0));
            if (lowerCase != 'a') {
                if (lowerCase != 'c') {
                    if (lowerCase != 'e') {
                        if (lowerCase != 'f') {
                            if (lowerCase != 'l') {
                                if (lowerCase != 'm') {
                                    switch (lowerCase) {
                                        case 'r':
                                            if (str.equalsIgnoreCase("random")) {
                                                return Math.random();
                                            }
                                            if (str.equalsIgnoreCase("round")) {
                                                return (double) Math.round(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("roundHE")) {
                                                return Math.rint(doVar.m46188new());
                                            }
                                            break;
                                        case 's':
                                            if (str.equalsIgnoreCase("signum")) {
                                                return Math.signum(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("sin")) {
                                                return Math.sin(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("sinh")) {
                                                return Math.sinh(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("sqrt")) {
                                                return Math.sqrt(doVar.m46188new());
                                            }
                                            break;
                                        case 't':
                                            if (str.equalsIgnoreCase("tan")) {
                                                return Math.tan(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("tanh")) {
                                                return Math.tanh(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("toDegrees")) {
                                                return Math.toDegrees(doVar.m46188new());
                                            }
                                            if (str.equalsIgnoreCase("toRadians")) {
                                                return Math.toRadians(doVar.m46188new());
                                            }
                                            break;
                                        case 'u':
                                            if (str.equalsIgnoreCase("ulp")) {
                                                return Math.ulp(doVar.m46188new());
                                            }
                                            break;
                                    }
                                } else if (str.equalsIgnoreCase("max")) {
                                    return Math.max(doVar.m46188new(), doVar.m46188new());
                                } else {
                                    if (str.equalsIgnoreCase("min")) {
                                        return Math.min(doVar.m46188new(), doVar.m46188new());
                                    }
                                }
                            } else if (str.equalsIgnoreCase("log")) {
                                return Math.log(doVar.m46188new());
                            } else {
                                if (str.equalsIgnoreCase("log10")) {
                                    return Math.log10(doVar.m46188new());
                                }
                                if (str.equalsIgnoreCase("log1p")) {
                                    return Math.log1p(doVar.m46188new());
                                }
                            }
                        } else if (str.equalsIgnoreCase("floor")) {
                            return Math.floor(doVar.m46188new());
                        }
                    } else if (str.equalsIgnoreCase(AuthenticationTokenClaims.JSON_KEY_EXP)) {
                        return Math.exp(doVar.m46188new());
                    } else {
                        if (str.equalsIgnoreCase("expm1")) {
                            return Math.expm1(doVar.m46188new());
                        }
                    }
                } else if (str.equalsIgnoreCase("cbrt")) {
                    return Math.cbrt(doVar.m46188new());
                } else {
                    if (str.equalsIgnoreCase("ceil")) {
                        return Math.ceil(doVar.m46188new());
                    }
                    if (str.equalsIgnoreCase("cos")) {
                        return Math.cos(doVar.m46188new());
                    }
                    if (str.equalsIgnoreCase("cosh")) {
                        return Math.cosh(doVar.m46188new());
                    }
                }
            } else if (str.equalsIgnoreCase("abs")) {
                return Math.abs(doVar.m46188new());
            } else {
                if (str.equalsIgnoreCase("acos")) {
                    return Math.acos(doVar.m46188new());
                }
                if (str.equalsIgnoreCase("asin")) {
                    return Math.asin(doVar.m46188new());
                }
                if (str.equalsIgnoreCase("atan")) {
                    return Math.atan(doVar.m46188new());
                }
            }
            throw new UnsupportedOperationException("MathEval internal function setup is incorrect - internal function \"" + str + "\" not handled");
        }

        /* renamed from: do */
        static void m3923do(C3089break breakR) {
            C3092if ifVar = f6870do;
            breakR.mo38558do("abs", (C3091for) ifVar);
            breakR.mo38558do("acos", (C3091for) ifVar);
            breakR.mo38558do("asin", (C3091for) ifVar);
            breakR.mo38558do("atan", (C3091for) ifVar);
            breakR.mo38558do("cbrt", (C3091for) ifVar);
            breakR.mo38558do("ceil", (C3091for) ifVar);
            breakR.mo38558do("cos", (C3091for) ifVar);
            breakR.mo38558do("cosh", (C3091for) ifVar);
            breakR.mo38558do(AuthenticationTokenClaims.JSON_KEY_EXP, (C3091for) ifVar);
            breakR.mo38558do("expm1", (C3091for) ifVar);
            breakR.mo38558do("floor", (C3091for) ifVar);
            breakR.mo38558do("log", (C3091for) ifVar);
            breakR.mo38558do("log10", (C3091for) ifVar);
            breakR.mo38558do("log1p", (C3091for) ifVar);
            breakR.mo38558do("max", (C3091for) ifVar);
            breakR.mo38558do("min", (C3091for) ifVar);
            breakR.mo38559do("random", ifVar, true);
            breakR.mo38558do("round", (C3091for) ifVar);
            breakR.mo38558do("roundHE", (C3091for) ifVar);
            breakR.mo38558do("signum", (C3091for) ifVar);
            breakR.mo38558do("sin", (C3091for) ifVar);
            breakR.mo38558do("sinh", (C3091for) ifVar);
            breakR.mo38558do("sqrt", (C3091for) ifVar);
            breakR.mo38558do("tan", (C3091for) ifVar);
            breakR.mo38558do("tanh", (C3091for) ifVar);
            breakR.mo38558do("toDegrees", (C3091for) ifVar);
            breakR.mo38558do("toRadians", (C3091for) ifVar);
            breakR.mo38558do("ulp", (C3091for) ifVar);
        }
    }

    /* renamed from: if */
    public C3089break mo38561if(String str, double d) {
        return mo38562if(str, Double.valueOf(d));
    }

    /* renamed from: if */
    public C3089break mo38562if(String str, Double d) {
        m3907a(str);
        if (d == null) {
            this.f6862d.remove(str);
        } else {
            this.f6862d.put(str, d);
        }
        return this;
    }

    /* renamed from: do */
    public C3089break mo38556do(String str, double d) {
        return mo38557do(str, Double.valueOf(d));
    }

    /* renamed from: do */
    public C3089break mo38557do(String str, Double d) {
        if (this.f6861c.get(str) == null) {
            m3907a(str);
            this.f6861c.put(str, d);
            return this;
        }
        throw new IllegalArgumentException("Constants may not be redefined");
    }

    /* renamed from: a */
    private void m3907a(String str) {
        if (!Character.isLetter(str.charAt(0))) {
            throw new IllegalArgumentException("Names for constants, variables and functions must start with a letter");
        } else if (str.indexOf(40) != -1 || str.indexOf(41) != -1) {
            throw new IllegalArgumentException("Names for constants, variables and functions may not contain a parenthesis");
        }
    }

    /* renamed from: do */
    public C3089break mo38560do(C3093new newR) {
        char c = newR.f6872do;
        C3093new[] newArr = this.f6860b;
        if (c >= newArr.length) {
            C3093new[] newArr2 = new C3093new[(c + (c % 255) + 1)];
            System.arraycopy(newArr, 0, newArr2, 0, newArr.length);
            this.f6860b = newArr2;
        }
        this.f6860b[newR.f6872do] = newR;
        return this;
    }

    /* renamed from: b */
    private double m3909b(int i, int i2) {
        int i3 = i;
        while (i3 <= i2 && this.f6866h.charAt(i3) != '(') {
            i3++;
        }
        String trim = this.f6866h.substring(i, i3).trim();
        C3090do doVar = new C3090do(i3, i2);
        try {
            C3091for forR = (C3091for) this.f6863e.get(trim);
            if (forR != null) {
                double d = forR.mo38554do(trim, doVar);
                if (!doVar.m46187for()) {
                    this.f6867i = doVar.mo38564if();
                    return d;
                }
                throw m3904a(doVar.mo38564if(), "Function has too many arguments");
            }
            C3091for forR2 = (C3091for) this.f6864f.get(trim);
            if (forR2 != null) {
                double d2 = forR2.mo38554do(trim, doVar);
                if (!doVar.m46187for()) {
                    this.f6867i = doVar.mo38564if();
                    return d2;
                }
                throw m3904a(doVar.mo38564if(), "Function has too many arguments");
            }
            throw m3904a(i, "Function \"" + trim + "\" not recognized");
        } catch (C3096do e) {
            throw e;
        } catch (NoSuchMethodError unused) {
            throw m3904a(i, "Function not supported in this JVM: \"" + trim + Const.jsQuote);
        } catch (UnsupportedOperationException e2) {
            throw m3904a(i, e2.getMessage());
        } catch (Throwable th) {
            throw m3905a(i, "Unexpected exception parsing function arguments", th);
        }
    }

    /* renamed from: do */
    public C3089break mo38558do(String str, C3091for forR) {
        return mo38559do(str, forR, false);
    }

    /* renamed from: do */
    public C3089break mo38559do(String str, C3091for forR, boolean z) {
        m3907a(str);
        if (forR == null) {
            this.f6863e.remove(str);
            this.f6864f.remove(str);
        } else if (z) {
            this.f6863e.remove(str);
            this.f6864f.put(str, forR);
        } else {
            this.f6863e.put(str, forR);
            this.f6864f.remove(str);
        }
        return this;
    }

    /* renamed from: do */
    public double mo38555do(String str) throws NumberFormatException, C3096do {
        this.f6866h = str;
        this.f6867i = 0;
        return m3896a(0, str.length() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public double m3896a(int i, int i2) throws NumberFormatException, C3096do {
        return m3897a(i, i2, 0.0d, f6859a, m3903a('='));
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0139 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double m3897a(int r22, int r23, double r24, p092super.C3089break.C3093new r26, p092super.C3089break.C3093new r27) throws java.lang.NumberFormatException, p092super.C3096do {
        /*
            r21 = this;
            r7 = r21
            r8 = r23
            super.break$new r0 = f6859a
            r1 = r22
            r9 = r24
            r11 = r27
            r2 = r0
            r0 = r1
        L_0x000e:
            java.lang.String r3 = r7.f6866h
            int r12 = r7.m3899a((java.lang.String) r3, (int) r0, (int) r8)
            r13 = 76
            if (r12 > r8) goto L_0x017d
            r0 = r12
        L_0x0019:
            if (r0 > r8) goto L_0x003b
            java.lang.String r1 = r7.f6866h
            char r1 = r1.charAt(r0)
            super.break$new r2 = r7.m3903a((char) r1)
            super.break$new r3 = f6859a
            if (r2 == r3) goto L_0x002f
            boolean r1 = r2.f61694try
            if (r1 == 0) goto L_0x003b
            r2 = r3
            goto L_0x0038
        L_0x002f:
            r3 = 41
            if (r1 == r3) goto L_0x003b
            r3 = 44
            if (r1 != r3) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x003b:
            java.lang.String r1 = r7.f6866h
            char r1 = r1.charAt(r12)
            boolean r3 = java.lang.Character.isLetter(r1)
            int r4 = r11.f61693new
            if (r4 == r13) goto L_0x005d
            r4 = 43
            if (r1 != r4) goto L_0x0053
            r3 = r9
            r9 = r2
            r2 = r26
            goto L_0x0151
        L_0x0053:
            r4 = 45
            if (r1 != r4) goto L_0x005d
            r2 = 177(0xb1, float:2.48E-43)
            super.break$new r2 = r7.m3903a((char) r2)
        L_0x005d:
            r14 = 82
            r15 = 40
            if (r12 != r0) goto L_0x0070
            int r4 = r11.f61693new
            if (r4 == r13) goto L_0x006b
            int r4 = r2.f61693new
            if (r4 != r14) goto L_0x0070
        L_0x006b:
            r3 = 9221120237041090560(0x7ff8000000000000, double:NaN)
        L_0x006d:
            r6 = r2
            goto L_0x00f0
        L_0x0070:
            if (r1 != r15) goto L_0x0095
            int r0 = r12 + 1
            double r0 = r7.m3896a((int) r0, (int) r8)
            java.lang.String r2 = r7.f6866h
            int r3 = r7.f6867i
            int r3 = r3 + 1
            int r2 = r7.m3899a((java.lang.String) r2, (int) r3, (int) r8)
            if (r2 > r8) goto L_0x008f
            java.lang.String r3 = r7.f6866h
            char r3 = r3.charAt(r2)
            super.break$new r3 = r7.m3903a((char) r3)
            goto L_0x0091
        L_0x008f:
            super.break$new r3 = f6859a
        L_0x0091:
            r6 = r3
            r3 = r0
            r0 = r2
            goto L_0x00f0
        L_0x0095:
            if (r3 == 0) goto L_0x00b9
            char r1 = r2.f6872do
            if (r1 != r15) goto L_0x00b9
            double r0 = r7.m3909b(r12, r8)
            java.lang.String r2 = r7.f6866h
            int r3 = r7.f6867i
            int r3 = r3 + 1
            int r2 = r7.m3899a((java.lang.String) r2, (int) r3, (int) r8)
            if (r2 > r8) goto L_0x00b6
            java.lang.String r3 = r7.f6866h
            char r3 = r3.charAt(r2)
            super.break$new r3 = r7.m3903a((char) r3)
            goto L_0x0091
        L_0x00b6:
            super.break$new r3 = f6859a
            goto L_0x0091
        L_0x00b9:
            if (r3 == 0) goto L_0x00c2
            int r1 = r0 + -1
            double r3 = r7.m3911c(r12, r1)
            goto L_0x006d
        L_0x00c2:
            java.lang.String r1 = r7.f6866h     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r3 = "0x"
            boolean r1 = r7.m3908a((java.lang.String) r1, (int) r12, (java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x0158 }
            if (r1 == 0) goto L_0x00e0
            java.lang.String r1 = r7.f6866h     // Catch:{ NumberFormatException -> 0x0158 }
            int r3 = r12 + 2
            java.lang.String r1 = r1.substring(r3, r0)     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x0158 }
            r3 = 16
            long r3 = java.lang.Long.parseLong(r1, r3)     // Catch:{ NumberFormatException -> 0x0158 }
            double r3 = (double) r3     // Catch:{ NumberFormatException -> 0x0158 }
            goto L_0x006d
        L_0x00e0:
            java.lang.String r1 = r7.f6866h     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.substring(r12, r0)     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x0158 }
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x0158 }
            goto L_0x006d
        L_0x00f0:
            int r1 = r7.m3900a((p092super.C3089break.C3093new) r11, (int) r13)
            int r2 = r7.m3900a((p092super.C3089break.C3093new) r6, (int) r14)
            if (r1 >= r2) goto L_0x011c
            int r1 = r0 + 1
            r0 = r21
            r2 = r23
            r5 = r11
            double r0 = r0.m3897a(r1, r2, r3, r5, r6)
            int r2 = r7.f6867i
            if (r2 > r8) goto L_0x0114
            java.lang.String r3 = r7.f6866h
            char r3 = r3.charAt(r2)
            super.break$new r3 = r7.m3903a((char) r3)
            goto L_0x0116
        L_0x0114:
            super.break$new r3 = f6859a
        L_0x0116:
            r17 = r0
            r16 = r2
            r5 = r3
            goto L_0x0121
        L_0x011c:
            r16 = r0
            r17 = r3
            r5 = r6
        L_0x0121:
            r0 = r21
            r1 = r12
            r2 = r9
            r4 = r11
            r9 = r5
            r5 = r17
            double r0 = r0.m3895a((int) r1, (double) r2, (p092super.C3089break.C3093new) r4, (double) r5)
            r2 = r26
            int r3 = r7.m3900a((p092super.C3089break.C3093new) r2, (int) r13)
            int r4 = r7.m3900a((p092super.C3089break.C3093new) r9, (int) r14)
            if (r3 < r4) goto L_0x0140
            r2 = r9
            r4 = r2
            r9 = r0
            r1 = r12
            r12 = r16
            goto L_0x017e
        L_0x0140:
            char r3 = r9.f6872do
            if (r3 != r15) goto L_0x014d
            int r3 = r16 + -1
            r11 = r9
            r19 = r0
            r0 = r3
            r3 = r19
            goto L_0x0151
        L_0x014d:
            r3 = r0
            r11 = r9
            r0 = r16
        L_0x0151:
            int r0 = r0 + 1
            r2 = r9
            r1 = r12
            r9 = r3
            goto L_0x000e
        L_0x0158:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid numeric value \""
            r1.append(r2)
            java.lang.String r2 = r7.f6866h
            java.lang.String r0 = r2.substring(r12, r0)
            java.lang.String r0 = r0.trim()
            r1.append(r0)
            java.lang.String r0 = "\""
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            super.do r0 = r7.m3904a((int) r12, (java.lang.String) r0)
            throw r0
        L_0x017d:
            r4 = r11
        L_0x017e:
            if (r12 <= r8) goto L_0x01af
            super.break$new r0 = f6859a
            if (r4 == r0) goto L_0x01af
            int r0 = r4.f61693new
            if (r0 != r13) goto L_0x0192
            r5 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r0 = r21
            r2 = r9
            double r9 = r0.m3895a((int) r1, (double) r2, (p092super.C3089break.C3093new) r4, (double) r5)
            goto L_0x01af
        L_0x0192:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expression ends with a blank operand after operator '"
            r0.append(r1)
            char r1 = r2.f6872do
            r0.append(r1)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            super.do r0 = r7.m3904a((int) r12, (java.lang.String) r0)
            throw r0
        L_0x01af:
            r7.f6867i = r12
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p092super.C3089break.m3897a(int, int, double, super.break$new, super.break$new):double");
    }

    /* renamed from: a */
    private C3093new m3903a(char c) {
        C3093new newR;
        C3093new[] newArr = this.f6860b;
        if (c >= newArr.length || (newR = newArr[c]) == null) {
            return f6859a;
        }
        return newR;
    }

    /* renamed from: a */
    private int m3900a(C3093new newR, int i) {
        if (newR == null) {
            return Integer.MIN_VALUE;
        }
        int i2 = newR.f61693new;
        if (i2 == 66 || i2 != i) {
            return i == 76 ? newR.f6873if : newR.f61692for;
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private double m3895a(int i, double d, C3093new newR, double d2) {
        if (newR.f61693new != 82 && Double.isNaN(d)) {
            throw m3904a(i, "Mathematical NaN detected in right-operand");
        } else if (newR.f61693new == 76 || !Double.isNaN(d2)) {
            try {
                return newR.f61691case.mo38553do(d, newR.f6872do, d2);
            } catch (C3096do e) {
                throw m3905a(i, "Mathematical expression \"" + this.f6866h + "\" failed to evaluate", (Throwable) e);
            } catch (UnsupportedOperationException unused) {
                while (i > 0 && m3903a(this.f6866h.charAt(i)) == null) {
                    i--;
                }
                throw m3904a(i, "Operator \"" + newR.f6872do + "\" not handled by math engine (Programmer error: The list of operators is inconsistent within the engine)");
            }
        } else {
            throw m3904a(i, "Mathematical NaN detected in left-operand");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3096do m3904a(int i, String str) {
        return new C3096do(str + " at offset " + i + " in expression \"" + this.f6866h + Const.jsQuote);
    }

    /* renamed from: a */
    private C3096do m3905a(int i, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" at offset ");
        sb.append(i);
        sb.append(" in expression \"");
        sb.append(this.f6866h);
        sb.append("\" (Cause: ");
        sb.append(th.getMessage() != null ? th.getMessage() : th.toString());
        sb.append(")");
        return new C3096do(sb.toString());
    }

    /* renamed from: a */
    private boolean m3908a(String str, int i, String str2) {
        return str.regionMatches(true, i, str2, 0, str2.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m3899a(String str, int i, int i2) {
        while (i <= i2 && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
