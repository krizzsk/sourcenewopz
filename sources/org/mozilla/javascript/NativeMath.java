package org.mozilla.javascript;

import org.mozilla.javascript.typedarrays.Conversions;

final class NativeMath extends IdScriptableObject {
    private static final int Id_E = 30;
    private static final int Id_LN10 = 32;
    private static final int Id_LN2 = 33;
    private static final int Id_LOG10E = 35;
    private static final int Id_LOG2E = 34;
    private static final int Id_PI = 31;
    private static final int Id_SQRT1_2 = 36;
    private static final int Id_SQRT2 = 37;
    private static final int Id_abs = 2;
    private static final int Id_acos = 3;
    private static final int Id_asin = 4;
    private static final int Id_atan = 5;
    private static final int Id_atan2 = 6;
    private static final int Id_cbrt = 20;
    private static final int Id_ceil = 7;
    private static final int Id_cos = 8;
    private static final int Id_cosh = 21;
    private static final int Id_exp = 9;
    private static final int Id_expm1 = 22;
    private static final int Id_floor = 10;
    private static final int Id_hypot = 23;
    private static final int Id_imul = 28;
    private static final int Id_log = 11;
    private static final int Id_log10 = 25;
    private static final int Id_log1p = 24;
    private static final int Id_max = 12;
    private static final int Id_min = 13;
    private static final int Id_pow = 14;
    private static final int Id_random = 15;
    private static final int Id_round = 16;
    private static final int Id_sin = 17;
    private static final int Id_sinh = 26;
    private static final int Id_sqrt = 18;
    private static final int Id_tan = 19;
    private static final int Id_tanh = 27;
    private static final int Id_toSource = 1;
    private static final int Id_trunc = 29;
    private static final int LAST_METHOD_ID = 29;
    private static final Object MATH_TAG = "Math";
    private static final int MAX_ID = 37;
    static final long serialVersionUID = -8838847185801131569L;

    public String getClassName() {
        return "Math";
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeMath nativeMath = new NativeMath();
        nativeMath.activatePrototypeMap(37);
        nativeMath.setPrototype(getObjectPrototype(scriptable));
        nativeMath.setParentScope(scriptable);
        if (z) {
            nativeMath.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "Math", nativeMath, 2);
    }

    private NativeMath() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005e, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006e, code lost:
        r0 = r1;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0070, code lost:
        initPrototypeMethod(MATH_TAG, r4, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initPrototypeId(int r4) {
        /*
            r3 = this;
            r0 = 29
            if (r4 > r0) goto L_0x0076
            r0 = 0
            r1 = 2
            r2 = 1
            switch(r4) {
                case 1: goto L_0x006c;
                case 2: goto L_0x0069;
                case 3: goto L_0x0066;
                case 4: goto L_0x0063;
                case 5: goto L_0x0060;
                case 6: goto L_0x005c;
                case 7: goto L_0x0059;
                case 8: goto L_0x0056;
                case 9: goto L_0x0053;
                case 10: goto L_0x0050;
                case 11: goto L_0x004d;
                case 12: goto L_0x004a;
                case 13: goto L_0x0047;
                case 14: goto L_0x0044;
                case 15: goto L_0x0041;
                case 16: goto L_0x003e;
                case 17: goto L_0x003b;
                case 18: goto L_0x0038;
                case 19: goto L_0x0035;
                case 20: goto L_0x0032;
                case 21: goto L_0x002f;
                case 22: goto L_0x002c;
                case 23: goto L_0x0029;
                case 24: goto L_0x0026;
                case 25: goto L_0x0023;
                case 26: goto L_0x001f;
                case 27: goto L_0x001b;
                case 28: goto L_0x0018;
                case 29: goto L_0x0014;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.<init>(r4)
            throw r0
        L_0x0014:
            java.lang.String r0 = "trunc"
            goto L_0x0070
        L_0x0018:
            java.lang.String r0 = "imul"
            goto L_0x005e
        L_0x001b:
            java.lang.String r0 = "tanh"
            goto L_0x0070
        L_0x001f:
            java.lang.String r0 = "sinh"
            goto L_0x0070
        L_0x0023:
            java.lang.String r0 = "log10"
            goto L_0x0070
        L_0x0026:
            java.lang.String r0 = "log1p"
            goto L_0x0070
        L_0x0029:
            java.lang.String r0 = "hypot"
            goto L_0x005e
        L_0x002c:
            java.lang.String r0 = "expm1"
            goto L_0x0070
        L_0x002f:
            java.lang.String r0 = "cosh"
            goto L_0x0070
        L_0x0032:
            java.lang.String r0 = "cbrt"
            goto L_0x0070
        L_0x0035:
            java.lang.String r0 = "tan"
            goto L_0x0070
        L_0x0038:
            java.lang.String r0 = "sqrt"
            goto L_0x0070
        L_0x003b:
            java.lang.String r0 = "sin"
            goto L_0x0070
        L_0x003e:
            java.lang.String r0 = "round"
            goto L_0x0070
        L_0x0041:
            java.lang.String r1 = "random"
            goto L_0x006e
        L_0x0044:
            java.lang.String r0 = "pow"
            goto L_0x005e
        L_0x0047:
            java.lang.String r0 = "min"
            goto L_0x005e
        L_0x004a:
            java.lang.String r0 = "max"
            goto L_0x005e
        L_0x004d:
            java.lang.String r0 = "log"
            goto L_0x0070
        L_0x0050:
            java.lang.String r0 = "floor"
            goto L_0x0070
        L_0x0053:
            java.lang.String r0 = "exp"
            goto L_0x0070
        L_0x0056:
            java.lang.String r0 = "cos"
            goto L_0x0070
        L_0x0059:
            java.lang.String r0 = "ceil"
            goto L_0x0070
        L_0x005c:
            java.lang.String r0 = "atan2"
        L_0x005e:
            r2 = 2
            goto L_0x0070
        L_0x0060:
            java.lang.String r0 = "atan"
            goto L_0x0070
        L_0x0063:
            java.lang.String r0 = "asin"
            goto L_0x0070
        L_0x0066:
            java.lang.String r0 = "acos"
            goto L_0x0070
        L_0x0069:
            java.lang.String r0 = "abs"
            goto L_0x0070
        L_0x006c:
            java.lang.String r1 = "toSource"
        L_0x006e:
            r0 = r1
            r2 = 0
        L_0x0070:
            java.lang.Object r1 = MATH_TAG
            r3.initPrototypeMethod(r1, r4, r0, r2)
            goto L_0x00ca
        L_0x0076:
            switch(r4) {
                case 30: goto L_0x00bb;
                case 31: goto L_0x00b3;
                case 32: goto L_0x00ab;
                case 33: goto L_0x00a3;
                case 34: goto L_0x009b;
                case 35: goto L_0x0093;
                case 36: goto L_0x008b;
                case 37: goto L_0x0083;
                default: goto L_0x0079;
            }
        L_0x0079:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.<init>(r4)
            throw r0
        L_0x0083:
            r0 = 4609047870845172685(0x3ff6a09e667f3bcd, double:1.4142135623730951)
            java.lang.String r2 = "SQRT2"
            goto L_0x00c2
        L_0x008b:
            r0 = 4604544271217802189(0x3fe6a09e667f3bcd, double:0.7071067811865476)
            java.lang.String r2 = "SQRT1_2"
            goto L_0x00c2
        L_0x0093:
            r0 = 4601495173785380110(0x3fdbcb7b1526e50e, double:0.4342944819032518)
            java.lang.String r2 = "LOG10E"
            goto L_0x00c2
        L_0x009b:
            r0 = 4609176140021203710(0x3ff71547652b82fe, double:1.4426950408889634)
            java.lang.String r2 = "LOG2E"
            goto L_0x00c2
        L_0x00a3:
            r0 = 4604418534313441775(0x3fe62e42fefa39ef, double:0.6931471805599453)
            java.lang.String r2 = "LN2"
            goto L_0x00c2
        L_0x00ab:
            r0 = 4612367379483415830(0x40026bb1bbb55516, double:2.302585092994046)
            java.lang.String r2 = "LN10"
            goto L_0x00c2
        L_0x00b3:
            r0 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.String r2 = "PI"
            goto L_0x00c2
        L_0x00bb:
            r0 = 4613303445314885481(0x4005bf0a8b145769, double:2.718281828459045)
            java.lang.String r2 = "E"
        L_0x00c2:
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)
            r1 = 7
            r3.initPrototypeValue(r4, r2, r0, r1)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.initPrototypeId(int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        if (r10 != 0.0d) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d3, code lost:
        r10 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a9, code lost:
        return org.mozilla.javascript.ScriptRuntime.wrapNumber(r10);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r8, org.mozilla.javascript.Context r9, org.mozilla.javascript.Scriptable r10, org.mozilla.javascript.Scriptable r11, java.lang.Object[] r12) {
        /*
            r7 = this;
            java.lang.Object r0 = MATH_TAG
            boolean r0 = r8.hasTag(r0)
            if (r0 != 0) goto L_0x000d
            java.lang.Object r8 = super.execIdCall(r8, r9, r10, r11, r12)
            return r8
        L_0x000d:
            int r8 = r8.methodId()
            r9 = 1
            r10 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r0 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r4 = 0
            r6 = 0
            switch(r8) {
                case 1: goto L_0x01aa;
                case 2: goto L_0x0194;
                case 3: goto L_0x0171;
                case 4: goto L_0x0171;
                case 5: goto L_0x0168;
                case 6: goto L_0x015b;
                case 7: goto L_0x0152;
                case 8: goto L_0x013f;
                case 9: goto L_0x012a;
                case 10: goto L_0x0120;
                case 11: goto L_0x0111;
                case 12: goto L_0x00ea;
                case 13: goto L_0x00ea;
                case 14: goto L_0x00dc;
                case 15: goto L_0x00d6;
                case 16: goto L_0x00ac;
                case 17: goto L_0x0097;
                case 18: goto L_0x008d;
                case 19: goto L_0x0083;
                case 20: goto L_0x0079;
                case 21: goto L_0x006f;
                case 22: goto L_0x0065;
                case 23: goto L_0x005f;
                case 24: goto L_0x0055;
                case 25: goto L_0x004b;
                case 26: goto L_0x0041;
                case 27: goto L_0x0037;
                case 28: goto L_0x0032;
                case 29: goto L_0x0028;
                default: goto L_0x001e;
            }
        L_0x001e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r9.<init>(r8)
            throw r9
        L_0x0028:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = r7.js_trunc(r8)
            goto L_0x01a5
        L_0x0032:
            java.lang.Object r8 = r7.js_imul(r12)
            return r8
        L_0x0037:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.tanh(r8)
            goto L_0x01a5
        L_0x0041:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.sinh(r8)
            goto L_0x01a5
        L_0x004b:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.log10(r8)
            goto L_0x01a5
        L_0x0055:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.log1p(r8)
            goto L_0x01a5
        L_0x005f:
            double r10 = r7.js_hypot(r12)
            goto L_0x01a5
        L_0x0065:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.expm1(r8)
            goto L_0x01a5
        L_0x006f:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.cosh(r8)
            goto L_0x01a5
        L_0x0079:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.cbrt(r8)
            goto L_0x01a5
        L_0x0083:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.tan(r8)
            goto L_0x01a5
        L_0x008d:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.sqrt(r8)
            goto L_0x01a5
        L_0x0097:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r12 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x01a5
            int r12 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r12 != 0) goto L_0x00a5
            goto L_0x01a5
        L_0x00a5:
            double r8 = java.lang.Math.sin(r8)
        L_0x00a9:
            r10 = r8
            goto L_0x01a5
        L_0x00ac:
            double r10 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r8 = (r10 > r10 ? 1 : (r10 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x01a5
            int r8 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x01a5
            int r8 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x01a5
            long r8 = java.lang.Math.round(r10)
            r0 = 0
            int r12 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r12 == 0) goto L_0x00c8
            double r8 = (double) r8
            goto L_0x00a9
        L_0x00c8:
            int r8 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x00cf
            double r8 = org.mozilla.javascript.ScriptRuntime.negativeZero
            goto L_0x00a9
        L_0x00cf:
            int r8 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x01a5
        L_0x00d3:
            r10 = r4
            goto L_0x01a5
        L_0x00d6:
            double r10 = java.lang.Math.random()
            goto L_0x01a5
        L_0x00dc:
            double r10 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r9)
            double r10 = r7.js_pow(r10, r8)
            goto L_0x01a5
        L_0x00ea:
            r9 = 12
            if (r8 != r9) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r0 = r2
        L_0x00f0:
            int r10 = r12.length
            if (r6 == r10) goto L_0x010e
            r10 = r12[r6]
            double r10 = org.mozilla.javascript.ScriptRuntime.toNumber((java.lang.Object) r10)
            int r2 = (r10 > r10 ? 1 : (r10 == r10 ? 0 : -1))
            if (r2 == 0) goto L_0x00ff
            goto L_0x01a5
        L_0x00ff:
            if (r8 != r9) goto L_0x0106
            double r10 = java.lang.Math.max(r0, r10)
            goto L_0x010a
        L_0x0106:
            double r10 = java.lang.Math.min(r0, r10)
        L_0x010a:
            r0 = r10
            int r6 = r6 + 1
            goto L_0x00f0
        L_0x010e:
            r10 = r0
            goto L_0x01a5
        L_0x0111:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x011b
            goto L_0x01a5
        L_0x011b:
            double r8 = java.lang.Math.log(r8)
            goto L_0x00a9
        L_0x0120:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.floor(r8)
            goto L_0x01a5
        L_0x012a:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 != 0) goto L_0x0134
            goto L_0x00a9
        L_0x0134:
            int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r10 != 0) goto L_0x0139
            goto L_0x00d3
        L_0x0139:
            double r8 = java.lang.Math.exp(r8)
            goto L_0x00a9
        L_0x013f:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r12 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x01a5
            int r12 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r12 != 0) goto L_0x014c
            goto L_0x01a5
        L_0x014c:
            double r8 = java.lang.Math.cos(r8)
            goto L_0x00a9
        L_0x0152:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.ceil(r8)
            goto L_0x01a5
        L_0x015b:
            double r10 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r9)
            double r10 = java.lang.Math.atan2(r10, r8)
            goto L_0x01a5
        L_0x0168:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            double r10 = java.lang.Math.atan(r8)
            goto L_0x01a5
        L_0x0171:
            double r0 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r9 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r9 != 0) goto L_0x01a5
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r9 > 0) goto L_0x01a5
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 > 0) goto L_0x01a5
            r9 = 3
            if (r8 != r9) goto L_0x018e
            double r8 = java.lang.Math.acos(r0)
            goto L_0x00a9
        L_0x018e:
            double r8 = java.lang.Math.asin(r0)
            goto L_0x00a9
        L_0x0194:
            double r8 = org.mozilla.javascript.ScriptRuntime.toNumber(r12, r6)
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x019e
            goto L_0x00d3
        L_0x019e:
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a9
            double r8 = -r8
            goto L_0x00a9
        L_0x01a5:
            java.lang.Number r8 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r10)
            return r8
        L_0x01aa:
            java.lang.String r8 = "Math"
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0062, code lost:
        if (r23 < 1.0d) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x007b, code lost:
        if (r23 < 1.0d) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0085, code lost:
        if (r8 > 0) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009f, code lost:
        if (r8 > 0) goto L_0x0065;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double js_pow(double r23, double r25) {
        /*
            r22 = this;
            r0 = r25
            r2 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r4 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r6 = 0
            int r8 = (r0 > r0 ? 1 : (r0 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x0010
            r17 = r0
            goto L_0x00a4
        L_0x0010:
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0018
            r17 = r2
            goto L_0x00a4
        L_0x0018:
            r9 = -9223372036854775808
            r11 = 0
            r13 = 1
            r15 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            int r17 = (r23 > r6 ? 1 : (r23 == r6 ? 0 : -1))
            if (r17 != 0) goto L_0x0045
            double r2 = r2 / r23
            int r17 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r17 <= 0) goto L_0x002e
            if (r8 <= 0) goto L_0x0065
            r4 = r6
            goto L_0x0065
        L_0x002e:
            long r2 = (long) r0
            double r6 = (double) r2
            int r19 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r19 != 0) goto L_0x0040
            long r0 = r2 & r13
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0040
            if (r8 <= 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r9 = r15
        L_0x003e:
            r4 = r9
            goto L_0x0065
        L_0x0040:
            if (r8 <= 0) goto L_0x0065
            r4 = 0
            goto L_0x0065
        L_0x0045:
            double r6 = java.lang.Math.pow(r23, r25)
            int r19 = (r6 > r6 ? 1 : (r6 == r6 ? 0 : -1))
            if (r19 == 0) goto L_0x00a2
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r21 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r21 != 0) goto L_0x0068
            int r0 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r0 < 0) goto L_0x0065
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 >= 0) goto L_0x005c
            goto L_0x0065
        L_0x005c:
            int r0 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a2
            int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a2
            goto L_0x007e
        L_0x0065:
            r17 = r4
            goto L_0x00a4
        L_0x0068:
            int r21 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
            if (r21 != 0) goto L_0x0081
            int r0 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r0 < 0) goto L_0x007e
            int r0 = (r2 > r23 ? 1 : (r2 == r23 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
            goto L_0x007e
        L_0x0075:
            int r0 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a2
            int r0 = (r23 > r2 ? 1 : (r23 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a2
            goto L_0x0065
        L_0x007e:
            r17 = 0
            goto L_0x00a4
        L_0x0081:
            int r2 = (r23 > r4 ? 1 : (r23 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x0088
            if (r8 <= 0) goto L_0x007e
            goto L_0x0065
        L_0x0088:
            int r2 = (r23 > r15 ? 1 : (r23 == r15 ? 0 : -1))
            if (r2 != 0) goto L_0x00a2
            long r2 = (long) r0
            double r6 = (double) r2
            int r19 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r19 != 0) goto L_0x009f
            long r0 = r2 & r13
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x009f
            if (r8 <= 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r15 = r9
        L_0x009c:
            r17 = r15
            goto L_0x00a4
        L_0x009f:
            if (r8 <= 0) goto L_0x007e
            goto L_0x0065
        L_0x00a2:
            r17 = r6
        L_0x00a4:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.js_pow(double, double):double");
    }

    private double js_hypot(Object[] objArr) {
        double d = 0.0d;
        if (objArr == null) {
            return 0.0d;
        }
        for (Object number : objArr) {
            double number2 = ScriptRuntime.toNumber(number);
            if (number2 == ScriptRuntime.NaN) {
                return number2;
            }
            if (number2 == Double.POSITIVE_INFINITY || number2 == Double.NEGATIVE_INFINITY) {
                return Double.POSITIVE_INFINITY;
            }
            d += number2 * number2;
        }
        return Math.sqrt(d);
    }

    private double js_trunc(double d) {
        return d < 0.0d ? Math.ceil(d) : Math.floor(d);
    }

    private Object js_imul(Object[] objArr) {
        if (objArr == null || objArr.length < 2) {
            return ScriptRuntime.wrapNumber(ScriptRuntime.NaN);
        }
        long uint32 = (Conversions.toUint32(objArr[0]) * Conversions.toUint32(objArr[1])) % Conversions.THIRTYTWO_BIT;
        if (uint32 >= 2147483648L) {
            uint32 -= Conversions.THIRTYTWO_BIT;
        }
        return Double.valueOf(ScriptRuntime.toNumber((Object) Long.valueOf(uint32)));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r17.length()
            r2 = 4
            r3 = 114(0x72, float:1.6E-43)
            r4 = 78
            r5 = 109(0x6d, float:1.53E-43)
            r6 = 108(0x6c, float:1.51E-43)
            r7 = 105(0x69, float:1.47E-43)
            r8 = 116(0x74, float:1.63E-43)
            r9 = 112(0x70, float:1.57E-43)
            r10 = 101(0x65, float:1.42E-43)
            r11 = 76
            r12 = 111(0x6f, float:1.56E-43)
            r14 = 97
            r15 = 0
            r13 = 1
            switch(r1) {
                case 1: goto L_0x01e0;
                case 2: goto L_0x01cd;
                case 3: goto L_0x0100;
                case 4: goto L_0x00a6;
                case 5: goto L_0x0043;
                case 6: goto L_0x002f;
                case 7: goto L_0x0029;
                case 8: goto L_0x0024;
                default: goto L_0x0022;
            }
        L_0x0022:
            goto L_0x01eb
        L_0x0024:
            java.lang.String r1 = "toSource"
            r2 = 1
            goto L_0x01ed
        L_0x0029:
            r2 = 36
            java.lang.String r1 = "SQRT1_2"
            goto L_0x01ed
        L_0x002f:
            char r1 = r0.charAt(r15)
            if (r1 != r11) goto L_0x003b
            r2 = 35
            java.lang.String r1 = "LOG10E"
            goto L_0x01ed
        L_0x003b:
            if (r1 != r3) goto L_0x01eb
            r2 = 15
            java.lang.String r1 = "random"
            goto L_0x01ed
        L_0x0043:
            char r1 = r0.charAt(r15)
            if (r1 == r11) goto L_0x00a0
            r4 = 83
            if (r1 == r4) goto L_0x009a
            if (r1 == r14) goto L_0x0095
            r4 = 104(0x68, float:1.46E-43)
            if (r1 == r4) goto L_0x008f
            if (r1 == r6) goto L_0x0079
            if (r1 == r3) goto L_0x0073
            if (r1 == r8) goto L_0x006d
            if (r1 == r10) goto L_0x0067
            r2 = 102(0x66, float:1.43E-43)
            if (r1 == r2) goto L_0x0061
            goto L_0x01eb
        L_0x0061:
            r2 = 10
            java.lang.String r1 = "floor"
            goto L_0x01ed
        L_0x0067:
            r2 = 22
            java.lang.String r1 = "expm1"
            goto L_0x01ed
        L_0x006d:
            r2 = 29
            java.lang.String r1 = "trunc"
            goto L_0x01ed
        L_0x0073:
            r2 = 16
            java.lang.String r1 = "round"
            goto L_0x01ed
        L_0x0079:
            char r1 = r0.charAt(r2)
            r2 = 48
            if (r1 != r2) goto L_0x0087
            r2 = 25
            java.lang.String r1 = "log10"
            goto L_0x01ed
        L_0x0087:
            if (r1 != r9) goto L_0x01eb
            r2 = 24
            java.lang.String r1 = "log1p"
            goto L_0x01ed
        L_0x008f:
            r2 = 23
            java.lang.String r1 = "hypot"
            goto L_0x01ed
        L_0x0095:
            r2 = 6
            java.lang.String r1 = "atan2"
            goto L_0x01ed
        L_0x009a:
            r2 = 37
            java.lang.String r1 = "SQRT2"
            goto L_0x01ed
        L_0x00a0:
            r2 = 34
            java.lang.String r1 = "LOG2E"
            goto L_0x01ed
        L_0x00a6:
            char r1 = r0.charAt(r13)
            if (r1 == r4) goto L_0x00fa
            if (r1 == r10) goto L_0x00f5
            if (r1 == r7) goto L_0x00ef
            if (r1 == r5) goto L_0x00e9
            if (r1 == r12) goto L_0x00e3
            r3 = 113(0x71, float:1.58E-43)
            if (r1 == r3) goto L_0x00dd
            r3 = 115(0x73, float:1.61E-43)
            if (r1 == r3) goto L_0x00d9
            if (r1 == r8) goto L_0x00d4
            switch(r1) {
                case 97: goto L_0x00ce;
                case 98: goto L_0x00c8;
                case 99: goto L_0x00c3;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            goto L_0x01eb
        L_0x00c3:
            r2 = 3
            java.lang.String r1 = "acos"
            goto L_0x01ed
        L_0x00c8:
            r2 = 20
            java.lang.String r1 = "cbrt"
            goto L_0x01ed
        L_0x00ce:
            r2 = 27
            java.lang.String r1 = "tanh"
            goto L_0x01ed
        L_0x00d4:
            r2 = 5
            java.lang.String r1 = "atan"
            goto L_0x01ed
        L_0x00d9:
            java.lang.String r1 = "asin"
            goto L_0x01ed
        L_0x00dd:
            r2 = 18
            java.lang.String r1 = "sqrt"
            goto L_0x01ed
        L_0x00e3:
            r2 = 21
            java.lang.String r1 = "cosh"
            goto L_0x01ed
        L_0x00e9:
            r2 = 28
            java.lang.String r1 = "imul"
            goto L_0x01ed
        L_0x00ef:
            r2 = 26
            java.lang.String r1 = "sinh"
            goto L_0x01ed
        L_0x00f5:
            r2 = 7
            java.lang.String r1 = "ceil"
            goto L_0x01ed
        L_0x00fa:
            r2 = 32
            java.lang.String r1 = "LN10"
            goto L_0x01ed
        L_0x0100:
            char r1 = r0.charAt(r15)
            if (r1 == r11) goto L_0x01bb
            if (r1 == r14) goto L_0x01a8
            r2 = 99
            if (r1 == r2) goto L_0x0196
            r2 = 120(0x78, float:1.68E-43)
            if (r1 == r10) goto L_0x0185
            if (r1 == r9) goto L_0x0172
            if (r1 == r6) goto L_0x015f
            r3 = 110(0x6e, float:1.54E-43)
            if (r1 == r5) goto L_0x0142
            r4 = 115(0x73, float:1.61E-43)
            if (r1 == r4) goto L_0x0131
            if (r1 == r8) goto L_0x0120
            goto L_0x01eb
        L_0x0120:
            r1 = 2
            char r1 = r0.charAt(r1)
            if (r1 != r3) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r14) goto L_0x01eb
            r15 = 19
            goto L_0x01f9
        L_0x0131:
            r1 = 2
            char r1 = r0.charAt(r1)
            if (r1 != r3) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r7) goto L_0x01eb
            r15 = 17
            goto L_0x01f9
        L_0x0142:
            r1 = 2
            char r1 = r0.charAt(r1)
            if (r1 != r3) goto L_0x0153
            char r1 = r0.charAt(r13)
            if (r1 != r7) goto L_0x01eb
            r15 = 13
            goto L_0x01f9
        L_0x0153:
            if (r1 != r2) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r14) goto L_0x01eb
            r15 = 12
            goto L_0x01f9
        L_0x015f:
            r1 = 2
            char r1 = r0.charAt(r1)
            r2 = 103(0x67, float:1.44E-43)
            if (r1 != r2) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r12) goto L_0x01eb
            r15 = 11
            goto L_0x01f9
        L_0x0172:
            r1 = 2
            char r1 = r0.charAt(r1)
            r2 = 119(0x77, float:1.67E-43)
            if (r1 != r2) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r12) goto L_0x01eb
            r15 = 14
            goto L_0x01f9
        L_0x0185:
            r1 = 2
            char r1 = r0.charAt(r1)
            if (r1 != r9) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r2) goto L_0x01eb
            r15 = 9
            goto L_0x01f9
        L_0x0196:
            r1 = 2
            char r1 = r0.charAt(r1)
            r2 = 115(0x73, float:1.61E-43)
            if (r1 != r2) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r12) goto L_0x01eb
            r15 = 8
            goto L_0x01f9
        L_0x01a8:
            r1 = 2
            r2 = 115(0x73, float:1.61E-43)
            char r3 = r0.charAt(r1)
            if (r3 != r2) goto L_0x01eb
            char r2 = r0.charAt(r13)
            r3 = 98
            if (r2 != r3) goto L_0x01eb
            r15 = 2
            goto L_0x01f9
        L_0x01bb:
            r1 = 2
            char r1 = r0.charAt(r1)
            r2 = 50
            if (r1 != r2) goto L_0x01eb
            char r1 = r0.charAt(r13)
            if (r1 != r4) goto L_0x01eb
            r15 = 33
            goto L_0x01f9
        L_0x01cd:
            char r1 = r0.charAt(r15)
            r2 = 80
            if (r1 != r2) goto L_0x01eb
            char r1 = r0.charAt(r13)
            r2 = 73
            if (r1 != r2) goto L_0x01eb
            r15 = 31
            goto L_0x01f9
        L_0x01e0:
            char r1 = r0.charAt(r15)
            r2 = 69
            if (r1 != r2) goto L_0x01eb
            r15 = 30
            goto L_0x01f9
        L_0x01eb:
            r1 = 0
            r2 = 0
        L_0x01ed:
            if (r1 == 0) goto L_0x01f8
            if (r1 == r0) goto L_0x01f8
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x01f8
            goto L_0x01f9
        L_0x01f8:
            r15 = r2
        L_0x01f9:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeMath.findPrototypeId(java.lang.String):int");
    }
}
