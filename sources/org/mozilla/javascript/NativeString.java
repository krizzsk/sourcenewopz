package org.mozilla.javascript;

import kotlin.text.Typography;

final class NativeString extends IdScriptableObject {
    private static final int ConstructorId_charAt = -5;
    private static final int ConstructorId_charCodeAt = -6;
    private static final int ConstructorId_concat = -14;
    private static final int ConstructorId_equalsIgnoreCase = -30;
    private static final int ConstructorId_fromCharCode = -1;
    private static final int ConstructorId_indexOf = -7;
    private static final int ConstructorId_lastIndexOf = -8;
    private static final int ConstructorId_localeCompare = -34;
    private static final int ConstructorId_match = -31;
    private static final int ConstructorId_replace = -33;
    private static final int ConstructorId_search = -32;
    private static final int ConstructorId_slice = -15;
    private static final int ConstructorId_split = -9;
    private static final int ConstructorId_substr = -13;
    private static final int ConstructorId_substring = -10;
    private static final int ConstructorId_toLocaleLowerCase = -35;
    private static final int ConstructorId_toLowerCase = -11;
    private static final int ConstructorId_toUpperCase = -12;
    private static final int Id_anchor = 28;
    private static final int Id_big = 21;
    private static final int Id_blink = 22;
    private static final int Id_bold = 16;
    private static final int Id_charAt = 5;
    private static final int Id_charCodeAt = 6;
    private static final int Id_codePointAt = 45;
    private static final int Id_concat = 14;
    private static final int Id_constructor = 1;
    private static final int Id_endsWith = 42;
    private static final int Id_equals = 29;
    private static final int Id_equalsIgnoreCase = 30;
    private static final int Id_fixed = 18;
    private static final int Id_fontcolor = 26;
    private static final int Id_fontsize = 25;
    private static final int Id_includes = 40;
    private static final int Id_indexOf = 7;
    private static final int Id_italics = 17;
    private static final int Id_lastIndexOf = 8;
    private static final int Id_length = 1;
    private static final int Id_link = 27;
    private static final int Id_localeCompare = 34;
    private static final int Id_match = 31;
    private static final int Id_normalize = 43;
    private static final int Id_repeat = 44;
    private static final int Id_replace = 33;
    private static final int Id_search = 32;
    private static final int Id_slice = 15;
    private static final int Id_small = 20;
    private static final int Id_split = 9;
    private static final int Id_startsWith = 41;
    private static final int Id_strike = 19;
    private static final int Id_sub = 24;
    private static final int Id_substr = 13;
    private static final int Id_substring = 10;
    private static final int Id_sup = 23;
    private static final int Id_toLocaleLowerCase = 35;
    private static final int Id_toLocaleUpperCase = 36;
    private static final int Id_toLowerCase = 11;
    private static final int Id_toSource = 3;
    private static final int Id_toString = 2;
    private static final int Id_toUpperCase = 12;
    private static final int Id_trim = 37;
    private static final int Id_trimLeft = 38;
    private static final int Id_trimRight = 39;
    private static final int Id_valueOf = 4;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PROTOTYPE_ID = 45;
    private static final Object STRING_TAG = "String";
    static final long serialVersionUID = 920268368584188687L;
    private CharSequence string;

    public String getClassName() {
        return "String";
    }

    /* access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return 1;
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeString("").exportAsJSClass(45, scriptable, z);
    }

    NativeString(CharSequence charSequence) {
        this.string = charSequence;
    }

    /* access modifiers changed from: protected */
    public int findInstanceIdInfo(String str) {
        if (str.equals("length")) {
            return instanceIdInfo(7, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    /* access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        return i == 1 ? "length" : super.getInstanceIdName(i);
    }

    /* access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.wrapInt(this.string.length());
        }
        return super.getInstanceIdValue(i);
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        IdFunctionObject idFunctionObject2 = idFunctionObject;
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -1, "fromCharCode", 1);
        IdFunctionObject idFunctionObject3 = idFunctionObject;
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -5, "charAt", 2);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -6, "charCodeAt", 2);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -7, "indexOf", 2);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -8, "lastIndexOf", 2);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -9, "split", 3);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -10, "substring", 3);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -11, "toLowerCase", 1);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -12, "toUpperCase", 1);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -13, "substr", 3);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -14, "concat", 2);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -15, "slice", 3);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, -30, "equalsIgnoreCase", 2);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, -31, "match", 2);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, ConstructorId_search, "search", 2);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, ConstructorId_replace, "replace", 2);
        addIdFunctionProperty(idFunctionObject2, STRING_TAG, ConstructorId_localeCompare, "localeCompare", 2);
        addIdFunctionProperty(idFunctionObject3, STRING_TAG, ConstructorId_toLocaleLowerCase, "toLocaleLowerCase", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        r0 = r1;
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ab, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ac, code lost:
        initPrototypeMethod(STRING_TAG, r4, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initPrototypeId(int r4) {
        /*
            r3 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            switch(r4) {
                case 1: goto L_0x00a9;
                case 2: goto L_0x00a6;
                case 3: goto L_0x00a3;
                case 4: goto L_0x00a0;
                case 5: goto L_0x009d;
                case 6: goto L_0x009a;
                case 7: goto L_0x0097;
                case 8: goto L_0x0094;
                case 9: goto L_0x008f;
                case 10: goto L_0x008c;
                case 11: goto L_0x0089;
                case 12: goto L_0x0086;
                case 13: goto L_0x0083;
                case 14: goto L_0x0080;
                case 15: goto L_0x007d;
                case 16: goto L_0x007a;
                case 17: goto L_0x0077;
                case 18: goto L_0x0074;
                case 19: goto L_0x0071;
                case 20: goto L_0x006e;
                case 21: goto L_0x006b;
                case 22: goto L_0x0068;
                case 23: goto L_0x0065;
                case 24: goto L_0x0062;
                case 25: goto L_0x005f;
                case 26: goto L_0x005b;
                case 27: goto L_0x0057;
                case 28: goto L_0x0053;
                case 29: goto L_0x004f;
                case 30: goto L_0x004b;
                case 31: goto L_0x0047;
                case 32: goto L_0x0043;
                case 33: goto L_0x0040;
                case 34: goto L_0x003c;
                case 35: goto L_0x0038;
                case 36: goto L_0x0034;
                case 37: goto L_0x0030;
                case 38: goto L_0x002c;
                case 39: goto L_0x0028;
                case 40: goto L_0x0024;
                case 41: goto L_0x0020;
                case 42: goto L_0x001c;
                case 43: goto L_0x0018;
                case 44: goto L_0x0014;
                case 45: goto L_0x0010;
                default: goto L_0x0006;
            }
        L_0x0006:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.<init>(r4)
            throw r0
        L_0x0010:
            java.lang.String r0 = "codePointAt"
            goto L_0x00ab
        L_0x0014:
            java.lang.String r0 = "repeat"
            goto L_0x00ab
        L_0x0018:
            java.lang.String r0 = "normalize"
            goto L_0x00ac
        L_0x001c:
            java.lang.String r0 = "endsWith"
            goto L_0x00ab
        L_0x0020:
            java.lang.String r0 = "startsWith"
            goto L_0x00ab
        L_0x0024:
            java.lang.String r0 = "includes"
            goto L_0x00ab
        L_0x0028:
            java.lang.String r0 = "trimRight"
            goto L_0x00ac
        L_0x002c:
            java.lang.String r0 = "trimLeft"
            goto L_0x00ac
        L_0x0030:
            java.lang.String r0 = "trim"
            goto L_0x00ac
        L_0x0034:
            java.lang.String r0 = "toLocaleUpperCase"
            goto L_0x00ac
        L_0x0038:
            java.lang.String r0 = "toLocaleLowerCase"
            goto L_0x00ac
        L_0x003c:
            java.lang.String r0 = "localeCompare"
            goto L_0x00ab
        L_0x0040:
            java.lang.String r1 = "replace"
            goto L_0x0091
        L_0x0043:
            java.lang.String r0 = "search"
            goto L_0x00ab
        L_0x0047:
            java.lang.String r0 = "match"
            goto L_0x00ab
        L_0x004b:
            java.lang.String r0 = "equalsIgnoreCase"
            goto L_0x00ab
        L_0x004f:
            java.lang.String r0 = "equals"
            goto L_0x00ab
        L_0x0053:
            java.lang.String r0 = "anchor"
            goto L_0x00ac
        L_0x0057:
            java.lang.String r0 = "link"
            goto L_0x00ac
        L_0x005b:
            java.lang.String r0 = "fontcolor"
            goto L_0x00ac
        L_0x005f:
            java.lang.String r0 = "fontsize"
            goto L_0x00ac
        L_0x0062:
            java.lang.String r0 = "sub"
            goto L_0x00ac
        L_0x0065:
            java.lang.String r0 = "sup"
            goto L_0x00ac
        L_0x0068:
            java.lang.String r0 = "blink"
            goto L_0x00ac
        L_0x006b:
            java.lang.String r0 = "big"
            goto L_0x00ac
        L_0x006e:
            java.lang.String r0 = "small"
            goto L_0x00ac
        L_0x0071:
            java.lang.String r0 = "strike"
            goto L_0x00ac
        L_0x0074:
            java.lang.String r0 = "fixed"
            goto L_0x00ac
        L_0x0077:
            java.lang.String r0 = "italics"
            goto L_0x00ac
        L_0x007a:
            java.lang.String r0 = "bold"
            goto L_0x00ac
        L_0x007d:
            java.lang.String r1 = "slice"
            goto L_0x0091
        L_0x0080:
            java.lang.String r0 = "concat"
            goto L_0x00ab
        L_0x0083:
            java.lang.String r1 = "substr"
            goto L_0x0091
        L_0x0086:
            java.lang.String r0 = "toUpperCase"
            goto L_0x00ac
        L_0x0089:
            java.lang.String r0 = "toLowerCase"
            goto L_0x00ac
        L_0x008c:
            java.lang.String r1 = "substring"
            goto L_0x0091
        L_0x008f:
            java.lang.String r1 = "split"
        L_0x0091:
            r0 = r1
            r2 = 2
            goto L_0x00ac
        L_0x0094:
            java.lang.String r0 = "lastIndexOf"
            goto L_0x00ab
        L_0x0097:
            java.lang.String r0 = "indexOf"
            goto L_0x00ab
        L_0x009a:
            java.lang.String r0 = "charCodeAt"
            goto L_0x00ab
        L_0x009d:
            java.lang.String r0 = "charAt"
            goto L_0x00ab
        L_0x00a0:
            java.lang.String r0 = "valueOf"
            goto L_0x00ac
        L_0x00a3:
            java.lang.String r0 = "toSource"
            goto L_0x00ac
        L_0x00a6:
            java.lang.String r0 = "toString"
            goto L_0x00ac
        L_0x00a9:
            java.lang.String r0 = "constructor"
        L_0x00ab:
            r2 = 1
        L_0x00ac:
            java.lang.Object r1 = STRING_TAG
            r3.initPrototypeMethod(r1, r4, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.initPrototypeId(int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r3v21, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object execIdCall(org.mozilla.javascript.IdFunctionObject r17, org.mozilla.javascript.Context r18, org.mozilla.javascript.Scriptable r19, org.mozilla.javascript.Scriptable r20, java.lang.Object[] r21) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r3 = STRING_TAG
            boolean r3 = r0.hasTag(r3)
            if (r3 != 0) goto L_0x0013
            java.lang.Object r0 = super.execIdCall(r17, r18, r19, r20, r21)
            return r0
        L_0x0013:
            int r3 = r17.methodId()
            r4 = r20
            r5 = r21
        L_0x001b:
            java.lang.String r6 = ""
            r7 = -1
            r8 = 1
            r9 = 0
            if (r3 == r7) goto L_0x03b6
            switch(r3) {
                case -35: goto L_0x038e;
                case -34: goto L_0x038e;
                case -33: goto L_0x038e;
                case -32: goto L_0x038e;
                case -31: goto L_0x038e;
                case -30: goto L_0x038e;
                default: goto L_0x0025;
            }
        L_0x0025:
            switch(r3) {
                case -15: goto L_0x038e;
                case -14: goto L_0x038e;
                case -13: goto L_0x038e;
                case -12: goto L_0x038e;
                case -11: goto L_0x038e;
                case -10: goto L_0x038e;
                case -9: goto L_0x038e;
                case -8: goto L_0x038e;
                case -7: goto L_0x038e;
                case -6: goto L_0x038e;
                case -5: goto L_0x038e;
                default: goto L_0x0028;
            }
        L_0x0028:
            r10 = 3
            java.lang.String r11 = "a"
            java.lang.String r12 = "font"
            r13 = 0
            r15 = 0
            switch(r3) {
                case 1: goto L_0x0373;
                case 2: goto L_0x0363;
                case 3: goto L_0x033e;
                case 4: goto L_0x0363;
                case 5: goto L_0x0310;
                case 6: goto L_0x0310;
                case 7: goto L_0x0302;
                case 8: goto L_0x02f5;
                case 9: goto L_0x02e8;
                case 10: goto L_0x02df;
                case 11: goto L_0x02d4;
                case 12: goto L_0x02c9;
                case 13: goto L_0x02c0;
                case 14: goto L_0x02b7;
                case 15: goto L_0x02ae;
                case 16: goto L_0x02a7;
                case 17: goto L_0x02a0;
                case 18: goto L_0x0299;
                case 19: goto L_0x0292;
                case 20: goto L_0x028b;
                case 21: goto L_0x0284;
                case 22: goto L_0x027d;
                case 23: goto L_0x0276;
                case 24: goto L_0x026f;
                case 25: goto L_0x0268;
                case 26: goto L_0x0261;
                case 27: goto L_0x025a;
                case 28: goto L_0x0253;
                case 29: goto L_0x0239;
                case 30: goto L_0x0239;
                case 31: goto L_0x021c;
                case 32: goto L_0x021c;
                case 33: goto L_0x021c;
                case 34: goto L_0x01fc;
                case 35: goto L_0x01ef;
                case 36: goto L_0x01e2;
                case 37: goto L_0x01b7;
                case 38: goto L_0x019b;
                case 39: goto L_0x017e;
                case 40: goto L_0x0130;
                case 41: goto L_0x0130;
                case 42: goto L_0x0130;
                case 43: goto L_0x00d9;
                case 44: goto L_0x0075;
                case 45: goto L_0x004e;
                default: goto L_0x0033;
            }
        L_0x0033:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "String.prototype has no method: "
            r2.append(r3)
            java.lang.String r0 = r17.getFunctionName()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x004e:
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.requireObjectCoercible(r4, r0)
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r0)
            double r1 = org.mozilla.javascript.ScriptRuntime.toInteger(r5, r9)
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 < 0) goto L_0x0072
            int r3 = r0.length()
            double r3 = (double) r3
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0068
            goto L_0x0072
        L_0x0068:
            int r1 = (int) r1
            int r0 = r0.codePointAt(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0074
        L_0x0072:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
        L_0x0074:
            return r0
        L_0x0075:
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.requireObjectCoercible(r4, r0)
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r0)
            double r1 = org.mozilla.javascript.ScriptRuntime.toInteger(r5, r9)
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x0086
            return r6
        L_0x0086:
            int r3 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r3 < 0) goto L_0x00d2
            r3 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00d2
            int r3 = r0.length()
            long r3 = (long) r3
            long r5 = (long) r1
            long r3 = r3 * r5
            r5 = 4746794007244308480(0x41dfffffffc00000, double:2.147483647E9)
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a8
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x00a9
        L_0x00a8:
            r3 = r9
        L_0x00a9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r4 = (int) r3
            r5.<init>(r4)
            r5.append(r0)
        L_0x00b2:
            double r3 = (double) r8
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r1 / r6
            int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r9 > 0) goto L_0x00c1
            r5.append(r5)
            int r8 = r8 * 2
            goto L_0x00b2
        L_0x00c1:
            int r3 = r8 + 1
            double r6 = (double) r8
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00cd
            r5.append(r0)
            r8 = r3
            goto L_0x00c1
        L_0x00cd:
            java.lang.String r0 = r5.toString()
            return r0
        L_0x00d2:
            java.lang.String r0 = "Invalid count value"
            org.mozilla.javascript.EcmaError r0 = org.mozilla.javascript.ScriptRuntime.rangeError(r0)
            throw r0
        L_0x00d9:
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r5, r9)
            java.text.Normalizer$Form r2 = java.text.Normalizer.Form.NFD
            java.lang.String r2 = r2.name()
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x00ec
            java.text.Normalizer$Form r1 = java.text.Normalizer.Form.NFD
            goto L_0x0123
        L_0x00ec:
            java.text.Normalizer$Form r2 = java.text.Normalizer.Form.NFKC
            java.lang.String r2 = r2.name()
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x00fb
            java.text.Normalizer$Form r1 = java.text.Normalizer.Form.NFKC
            goto L_0x0123
        L_0x00fb:
            java.text.Normalizer$Form r2 = java.text.Normalizer.Form.NFKD
            java.lang.String r2 = r2.name()
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x010a
            java.text.Normalizer$Form r1 = java.text.Normalizer.Form.NFKD
            goto L_0x0123
        L_0x010a:
            java.text.Normalizer$Form r2 = java.text.Normalizer.Form.NFC
            java.lang.String r2 = r2.name()
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0121
            int r1 = r5.length
            if (r1 != 0) goto L_0x011a
            goto L_0x0121
        L_0x011a:
            java.lang.String r0 = "The normalization form should be one of NFC, NFD, NFKC, NFKD"
            org.mozilla.javascript.EcmaError r0 = org.mozilla.javascript.ScriptRuntime.rangeError(r0)
            throw r0
        L_0x0121:
            java.text.Normalizer$Form r1 = java.text.Normalizer.Form.NFC
        L_0x0123:
            org.mozilla.javascript.Scriptable r0 = org.mozilla.javascript.ScriptRuntime.requireObjectCoercible(r4, r0)
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r0)
            java.lang.String r0 = java.text.Normalizer.normalize(r0, r1)
            return r0
        L_0x0130:
            org.mozilla.javascript.Scriptable r1 = org.mozilla.javascript.ScriptRuntime.requireObjectCoercible(r4, r0)
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r1)
            int r2 = r5.length
            if (r2 <= 0) goto L_0x0153
            r2 = r5[r9]
            boolean r2 = r2 instanceof org.mozilla.javascript.regexp.NativeRegExp
            if (r2 != 0) goto L_0x0142
            goto L_0x0153
        L_0x0142:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r0 = r17.getFunctionName()
            java.lang.String r2 = "msg.first.arg.not.regexp"
            org.mozilla.javascript.EcmaError r0 = org.mozilla.javascript.ScriptRuntime.typeError2(r2, r1, r0)
            throw r0
        L_0x0153:
            int r0 = js_indexOf(r3, r1, r5)
            r1 = 40
            if (r3 != r1) goto L_0x0164
            if (r0 == r7) goto L_0x015e
            goto L_0x015f
        L_0x015e:
            r8 = 0
        L_0x015f:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            return r0
        L_0x0164:
            r1 = 41
            if (r3 != r1) goto L_0x0171
            if (r0 != 0) goto L_0x016b
            goto L_0x016c
        L_0x016b:
            r8 = 0
        L_0x016c:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            return r0
        L_0x0171:
            r1 = 42
            if (r3 != r1) goto L_0x02f5
            if (r0 == r7) goto L_0x0178
            goto L_0x0179
        L_0x0178:
            r8 = 0
        L_0x0179:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r8)
            return r0
        L_0x017e:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            char[] r1 = r0.toCharArray()
            int r2 = r1.length
        L_0x0187:
            if (r2 <= 0) goto L_0x0196
            int r3 = r2 + -1
            char r3 = r1[r3]
            boolean r3 = org.mozilla.javascript.ScriptRuntime.isJSWhitespaceOrLineTerminator(r3)
            if (r3 == 0) goto L_0x0196
            int r2 = r2 + -1
            goto L_0x0187
        L_0x0196:
            java.lang.String r0 = r0.substring(r9, r2)
            return r0
        L_0x019b:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            char[] r1 = r0.toCharArray()
        L_0x01a3:
            int r2 = r1.length
            if (r9 >= r2) goto L_0x01b1
            char r2 = r1[r9]
            boolean r2 = org.mozilla.javascript.ScriptRuntime.isJSWhitespaceOrLineTerminator(r2)
            if (r2 == 0) goto L_0x01b1
            int r9 = r9 + 1
            goto L_0x01a3
        L_0x01b1:
            int r1 = r1.length
            java.lang.String r0 = r0.substring(r9, r1)
            return r0
        L_0x01b7:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            char[] r1 = r0.toCharArray()
        L_0x01bf:
            int r2 = r1.length
            if (r9 >= r2) goto L_0x01cd
            char r2 = r1[r9]
            boolean r2 = org.mozilla.javascript.ScriptRuntime.isJSWhitespaceOrLineTerminator(r2)
            if (r2 == 0) goto L_0x01cd
            int r9 = r9 + 1
            goto L_0x01bf
        L_0x01cd:
            int r2 = r1.length
        L_0x01ce:
            if (r2 <= r9) goto L_0x01dd
            int r3 = r2 + -1
            char r3 = r1[r3]
            boolean r3 = org.mozilla.javascript.ScriptRuntime.isJSWhitespaceOrLineTerminator(r3)
            if (r3 == 0) goto L_0x01dd
            int r2 = r2 + -1
            goto L_0x01ce
        L_0x01dd:
            java.lang.String r0 = r0.substring(r9, r2)
            return r0
        L_0x01e2:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.util.Locale r1 = r18.getLocale()
            java.lang.String r0 = r0.toUpperCase(r1)
            return r0
        L_0x01ef:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.util.Locale r1 = r18.getLocale()
            java.lang.String r0 = r0.toLowerCase(r1)
            return r0
        L_0x01fc:
            java.util.Locale r0 = r18.getLocale()
            java.text.Collator r0 = java.text.Collator.getInstance(r0)
            r0.setStrength(r10)
            r0.setDecomposition(r8)
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.lang.String r2 = org.mozilla.javascript.ScriptRuntime.toString(r5, r9)
            int r0 = r0.compare(r1, r2)
            double r0 = (double) r0
            java.lang.Number r0 = org.mozilla.javascript.ScriptRuntime.wrapNumber(r0)
            return r0
        L_0x021c:
            r0 = 31
            if (r3 != r0) goto L_0x0222
            r10 = 1
            goto L_0x0229
        L_0x0222:
            r0 = 32
            if (r3 != r0) goto L_0x0227
            goto L_0x0229
        L_0x0227:
            r0 = 2
            r10 = 2
        L_0x0229:
            org.mozilla.javascript.RegExpProxy r0 = org.mozilla.javascript.ScriptRuntime.checkRegExpProxy(r18)
            r1 = r18
            r2 = r19
            r3 = r4
            r4 = r5
            r5 = r10
            java.lang.Object r0 = r0.action(r1, r2, r3, r4, r5)
            return r0
        L_0x0239:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString(r5, r9)
            r2 = 29
            if (r3 != r2) goto L_0x024a
            boolean r0 = r0.equals(r1)
            goto L_0x024e
        L_0x024a:
            boolean r0 = r0.equalsIgnoreCase(r1)
        L_0x024e:
            java.lang.Boolean r0 = org.mozilla.javascript.ScriptRuntime.wrapBoolean(r0)
            return r0
        L_0x0253:
            java.lang.String r0 = "name"
            java.lang.String r0 = tagify(r4, r11, r0, r5)
            return r0
        L_0x025a:
            java.lang.String r0 = "href"
            java.lang.String r0 = tagify(r4, r11, r0, r5)
            return r0
        L_0x0261:
            java.lang.String r0 = "color"
            java.lang.String r0 = tagify(r4, r12, r0, r5)
            return r0
        L_0x0268:
            java.lang.String r0 = "size"
            java.lang.String r0 = tagify(r4, r12, r0, r5)
            return r0
        L_0x026f:
            java.lang.String r0 = "sub"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x0276:
            java.lang.String r0 = "sup"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x027d:
            java.lang.String r0 = "blink"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x0284:
            java.lang.String r0 = "big"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x028b:
            java.lang.String r0 = "small"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x0292:
            java.lang.String r0 = "strike"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x0299:
            java.lang.String r0 = "tt"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x02a0:
            java.lang.String r0 = "i"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x02a7:
            java.lang.String r0 = "b"
            java.lang.String r0 = tagify(r4, r0, r15, r15)
            return r0
        L_0x02ae:
            java.lang.CharSequence r0 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r4)
            java.lang.CharSequence r0 = js_slice(r0, r5)
            return r0
        L_0x02b7:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.lang.String r0 = js_concat(r0, r5)
            return r0
        L_0x02c0:
            java.lang.CharSequence r0 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r4)
            java.lang.CharSequence r0 = js_substr(r0, r5)
            return r0
        L_0x02c9:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.util.Locale r1 = org.mozilla.javascript.ScriptRuntime.ROOT_LOCALE
            java.lang.String r0 = r0.toUpperCase(r1)
            return r0
        L_0x02d4:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.util.Locale r1 = org.mozilla.javascript.ScriptRuntime.ROOT_LOCALE
            java.lang.String r0 = r0.toLowerCase(r1)
            return r0
        L_0x02df:
            java.lang.CharSequence r0 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r4)
            java.lang.CharSequence r0 = js_substring(r1, r0, r5)
            return r0
        L_0x02e8:
            org.mozilla.javascript.RegExpProxy r0 = org.mozilla.javascript.ScriptRuntime.checkRegExpProxy(r18)
            java.lang.String r3 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            java.lang.Object r0 = r0.js_split(r1, r2, r3, r5)
            return r0
        L_0x02f5:
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            int r0 = js_lastIndexOf(r0, r5)
            java.lang.Integer r0 = org.mozilla.javascript.ScriptRuntime.wrapInt(r0)
            return r0
        L_0x0302:
            r0 = 7
            java.lang.String r1 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r4)
            int r0 = js_indexOf(r0, r1, r5)
            java.lang.Integer r0 = org.mozilla.javascript.ScriptRuntime.wrapInt(r0)
            return r0
        L_0x0310:
            java.lang.CharSequence r0 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r4)
            double r1 = org.mozilla.javascript.ScriptRuntime.toInteger(r5, r9)
            r4 = 5
            int r5 = (r1 > r13 ? 1 : (r1 == r13 ? 0 : -1))
            if (r5 < 0) goto L_0x0338
            int r5 = r0.length()
            double r7 = (double) r5
            int r5 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x0327
            goto L_0x0338
        L_0x0327:
            int r1 = (int) r1
            char r0 = r0.charAt(r1)
            if (r3 != r4) goto L_0x0333
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L_0x0333:
            java.lang.Integer r0 = org.mozilla.javascript.ScriptRuntime.wrapInt(r0)
            return r0
        L_0x0338:
            if (r3 != r4) goto L_0x033b
            return r6
        L_0x033b:
            java.lang.Double r0 = org.mozilla.javascript.ScriptRuntime.NaNobj
            return r0
        L_0x033e:
            org.mozilla.javascript.NativeString r0 = realThis(r4, r0)
            java.lang.CharSequence r0 = r0.string
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "(new String(\""
            r1.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.escapeString(r0)
            r1.append(r0)
            java.lang.String r0 = "\"))"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        L_0x0363:
            org.mozilla.javascript.NativeString r0 = realThis(r4, r0)
            java.lang.CharSequence r0 = r0.string
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L_0x036e
            goto L_0x0372
        L_0x036e:
            java.lang.String r0 = r0.toString()
        L_0x0372:
            return r0
        L_0x0373:
            int r0 = r5.length
            if (r0 < r8) goto L_0x037c
            r0 = r5[r9]
            java.lang.CharSequence r6 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r0)
        L_0x037c:
            if (r4 != 0) goto L_0x0384
            org.mozilla.javascript.NativeString r0 = new org.mozilla.javascript.NativeString
            r0.<init>(r6)
            return r0
        L_0x0384:
            boolean r0 = r6 instanceof java.lang.String
            if (r0 == 0) goto L_0x0389
            goto L_0x038d
        L_0x0389:
            java.lang.String r6 = r6.toString()
        L_0x038d:
            return r6
        L_0x038e:
            int r6 = r5.length
            if (r6 <= 0) goto L_0x03ab
            r4 = r5[r9]
            java.lang.CharSequence r4 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r4)
            org.mozilla.javascript.Scriptable r4 = org.mozilla.javascript.ScriptRuntime.toObject((org.mozilla.javascript.Context) r1, (org.mozilla.javascript.Scriptable) r2, (java.lang.Object) r4)
            int r6 = r5.length
            int r6 = r6 - r8
            java.lang.Object[] r7 = new java.lang.Object[r6]
        L_0x039f:
            if (r9 >= r6) goto L_0x03a9
            int r8 = r9 + 1
            r10 = r5[r8]
            r7[r9] = r10
            r9 = r8
            goto L_0x039f
        L_0x03a9:
            r5 = r7
            goto L_0x03b3
        L_0x03ab:
            java.lang.CharSequence r4 = org.mozilla.javascript.ScriptRuntime.toCharSequence(r4)
            org.mozilla.javascript.Scriptable r4 = org.mozilla.javascript.ScriptRuntime.toObject((org.mozilla.javascript.Context) r1, (org.mozilla.javascript.Scriptable) r2, (java.lang.Object) r4)
        L_0x03b3:
            int r3 = -r3
            goto L_0x001b
        L_0x03b6:
            int r0 = r5.length
            if (r0 >= r8) goto L_0x03ba
            return r6
        L_0x03ba:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
        L_0x03bf:
            if (r9 == r0) goto L_0x03cd
            r2 = r5[r9]
            char r2 = org.mozilla.javascript.ScriptRuntime.toUint16(r2)
            r1.append(r2)
            int r9 = r9 + 1
            goto L_0x03bf
        L_0x03cd:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.execIdCall(org.mozilla.javascript.IdFunctionObject, org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static NativeString realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeString) {
            return (NativeString) scriptable;
        }
        throw incompatibleCallError(idFunctionObject);
    }

    private static String tagify(Object obj, String str, String str2, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(obj);
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.less);
        sb.append(str);
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
            sb.append("=\"");
            sb.append(ScriptRuntime.toString(objArr, 0));
            sb.append(Typography.quote);
        }
        sb.append(Typography.greater);
        sb.append(scriptRuntime);
        sb.append("</");
        sb.append(str);
        sb.append(Typography.greater);
        return sb.toString();
    }

    public CharSequence toCharSequence() {
        return this.string;
    }

    public String toString() {
        CharSequence charSequence = this.string;
        return charSequence instanceof String ? (String) charSequence : charSequence.toString();
    }

    public Object get(int i, Scriptable scriptable) {
        if (i < 0 || i >= this.string.length()) {
            return super.get(i, scriptable);
        }
        return String.valueOf(this.string.charAt(i));
    }

    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.string.length()) {
            super.put(i, scriptable, obj);
        }
    }

    private static int js_indexOf(int i, String str, Object[] objArr) {
        int length;
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        double integer = ScriptRuntime.toInteger(objArr, 1);
        if (integer > ((double) str.length()) && i != 41 && i != 42) {
            return -1;
        }
        if (integer < 0.0d) {
            integer = 0.0d;
        } else {
            if (integer > ((double) str.length())) {
                length = str.length();
            } else if (i == 42 && (integer != integer || integer > ((double) str.length()))) {
                length = str.length();
            }
            integer = (double) length;
        }
        if (42 == i) {
            if (objArr.length == 0 || objArr.length == 1 || (objArr.length == 2 && objArr[1] == Undefined.instance)) {
                integer = (double) str.length();
            }
            if (str.substring(0, (int) integer).endsWith(scriptRuntime)) {
                return 0;
            }
            return -1;
        } else if (i != 41) {
            return str.indexOf(scriptRuntime, (int) integer);
        } else {
            if (str.startsWith(scriptRuntime, (int) integer)) {
                return 0;
            }
            return -1;
        }
    }

    private static int js_lastIndexOf(String str, Object[] objArr) {
        String scriptRuntime = ScriptRuntime.toString(objArr, 0);
        double number = ScriptRuntime.toNumber(objArr, 1);
        if (number != number || number > ((double) str.length())) {
            number = (double) str.length();
        } else if (number < 0.0d) {
            number = 0.0d;
        }
        return str.lastIndexOf(scriptRuntime, (int) number);
    }

    private static CharSequence js_substring(Context context, CharSequence charSequence, Object[] objArr) {
        int length = charSequence.length();
        double integer = ScriptRuntime.toInteger(objArr, 0);
        double d = 0.0d;
        if (integer < 0.0d) {
            integer = 0.0d;
        } else {
            double d2 = (double) length;
            if (integer > d2) {
                integer = d2;
            }
        }
        if (objArr.length <= 1 || objArr[1] == Undefined.instance) {
            d = (double) length;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            if (integer2 >= 0.0d) {
                d = (double) length;
                if (integer2 <= d) {
                    d = integer2;
                }
            }
            if (d < integer) {
                if (context.getLanguageVersion() != 120) {
                    double d3 = integer;
                    integer = d;
                    d = d3;
                } else {
                    d = integer;
                }
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    /* access modifiers changed from: package-private */
    public int getLength() {
        return this.string.length();
    }

    private static CharSequence js_substr(CharSequence charSequence, Object[] objArr) {
        double d;
        if (objArr.length < 1) {
            return charSequence;
        }
        double integer = ScriptRuntime.toInteger(objArr[0]);
        int length = charSequence.length();
        double d2 = 0.0d;
        if (integer < 0.0d) {
            integer += (double) length;
            if (integer < 0.0d) {
                integer = 0.0d;
            }
        } else {
            double d3 = (double) length;
            if (integer > d3) {
                integer = d3;
            }
        }
        if (objArr.length == 1) {
            d = (double) length;
        } else {
            double integer2 = ScriptRuntime.toInteger(objArr[1]);
            if (integer2 >= 0.0d) {
                d2 = integer2;
            }
            double d4 = d2 + integer;
            d = (double) length;
            if (d4 <= d) {
                d = d4;
            }
        }
        return charSequence.subSequence((int) integer, (int) d);
    }

    private static String js_concat(String str, Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return str;
        }
        if (length == 1) {
            return str.concat(ScriptRuntime.toString(objArr[0]));
        }
        int length2 = str.length();
        String[] strArr = new String[length];
        for (int i = 0; i != length; i++) {
            String scriptRuntime = ScriptRuntime.toString(objArr[i]);
            strArr[i] = scriptRuntime;
            length2 += scriptRuntime.length();
        }
        StringBuilder sb = new StringBuilder(length2);
        sb.append(str);
        for (int i2 = 0; i2 != length; i2++) {
            sb.append(strArr[i2]);
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        if (r6 < 0.0d) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r6 > r2) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.CharSequence js_slice(java.lang.CharSequence r9, java.lang.Object[] r10) {
        /*
            int r0 = r10.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0008
            r4 = r2
            goto L_0x000f
        L_0x0008:
            r0 = 0
            r0 = r10[r0]
            double r4 = org.mozilla.javascript.ScriptRuntime.toInteger((java.lang.Object) r0)
        L_0x000f:
            int r0 = r9.length()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x001f
            double r6 = (double) r0
            double r4 = r4 + r6
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x0025
            r4 = r2
            goto L_0x0025
        L_0x001f:
            double r6 = (double) r0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0025
            r4 = r6
        L_0x0025:
            int r6 = r10.length
            r7 = 2
            if (r6 < r7) goto L_0x004e
            r6 = r10[r1]
            java.lang.Object r7 = org.mozilla.javascript.Undefined.instance
            if (r6 != r7) goto L_0x0030
            goto L_0x004e
        L_0x0030:
            r10 = r10[r1]
            double r6 = org.mozilla.javascript.ScriptRuntime.toInteger((java.lang.Object) r10)
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0041
            double r0 = (double) r0
            double r6 = r6 + r0
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x0047
            goto L_0x0048
        L_0x0041:
            double r2 = (double) r0
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r2 = r6
        L_0x0048:
            int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x004f
            r2 = r4
            goto L_0x004f
        L_0x004e:
            double r2 = (double) r0
        L_0x004f:
            int r10 = (int) r4
            int r0 = (int) r2
            java.lang.CharSequence r9 = r9.subSequence(r10, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.js_slice(java.lang.CharSequence, java.lang.Object[]):java.lang.CharSequence");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r17.length()
            r2 = 8
            r3 = 85
            r4 = 76
            r5 = 102(0x66, float:1.43E-43)
            r6 = 99
            r7 = 6
            r10 = 100
            r14 = 2
            r15 = 101(0x65, float:1.42E-43)
            r13 = 110(0x6e, float:1.54E-43)
            r8 = 115(0x73, float:1.61E-43)
            r11 = 1
            r12 = 116(0x74, float:1.63E-43)
            r9 = 0
            switch(r1) {
                case 3: goto L_0x01b1;
                case 4: goto L_0x0194;
                case 5: goto L_0x0158;
                case 6: goto L_0x0103;
                case 7: goto L_0x00dd;
                case 8: goto L_0x00a7;
                case 9: goto L_0x0081;
                case 10: goto L_0x006e;
                case 11: goto L_0x0043;
                case 12: goto L_0x0021;
                case 13: goto L_0x003d;
                case 14: goto L_0x0021;
                case 15: goto L_0x0021;
                case 16: goto L_0x0037;
                case 17: goto L_0x0023;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x01f6
        L_0x0023:
            char r1 = r0.charAt(r2)
            if (r1 != r4) goto L_0x002f
            r2 = 35
            java.lang.String r1 = "toLocaleLowerCase"
            goto L_0x01f8
        L_0x002f:
            if (r1 != r3) goto L_0x01f6
            r2 = 36
            java.lang.String r1 = "toLocaleUpperCase"
            goto L_0x01f8
        L_0x0037:
            r2 = 30
            java.lang.String r1 = "equalsIgnoreCase"
            goto L_0x01f8
        L_0x003d:
            r2 = 34
            java.lang.String r1 = "localeCompare"
            goto L_0x01f8
        L_0x0043:
            char r1 = r0.charAt(r14)
            if (r1 == r4) goto L_0x0068
            if (r1 == r3) goto L_0x0062
            if (r1 == r10) goto L_0x005c
            if (r1 == r13) goto L_0x0057
            if (r1 == r8) goto L_0x0053
            goto L_0x01f6
        L_0x0053:
            java.lang.String r1 = "lastIndexOf"
            goto L_0x01f8
        L_0x0057:
            java.lang.String r1 = "constructor"
            r2 = 1
            goto L_0x01f8
        L_0x005c:
            r2 = 45
            java.lang.String r1 = "codePointAt"
            goto L_0x01f8
        L_0x0062:
            r2 = 12
            java.lang.String r1 = "toUpperCase"
            goto L_0x01f8
        L_0x0068:
            r2 = 11
            java.lang.String r1 = "toLowerCase"
            goto L_0x01f8
        L_0x006e:
            char r1 = r0.charAt(r9)
            if (r1 != r6) goto L_0x0079
            java.lang.String r1 = "charCodeAt"
            r2 = 6
            goto L_0x01f8
        L_0x0079:
            if (r1 != r8) goto L_0x01f6
            r2 = 41
            java.lang.String r1 = "startsWith"
            goto L_0x01f8
        L_0x0081:
            char r1 = r0.charAt(r9)
            if (r1 == r5) goto L_0x00a1
            if (r1 == r13) goto L_0x009b
            if (r1 == r8) goto L_0x0095
            if (r1 == r12) goto L_0x008f
            goto L_0x01f6
        L_0x008f:
            r2 = 39
            java.lang.String r1 = "trimRight"
            goto L_0x01f8
        L_0x0095:
            r2 = 10
            java.lang.String r1 = "substring"
            goto L_0x01f8
        L_0x009b:
            r2 = 43
            java.lang.String r1 = "normalize"
            goto L_0x01f8
        L_0x00a1:
            r2 = 26
            java.lang.String r1 = "fontcolor"
            goto L_0x01f8
        L_0x00a7:
            char r1 = r0.charAt(r7)
            if (r1 == r6) goto L_0x00d8
            if (r1 == r13) goto L_0x00d3
            if (r1 == r12) goto L_0x00cd
            r2 = 122(0x7a, float:1.71E-43)
            if (r1 == r2) goto L_0x00c7
            if (r1 == r15) goto L_0x00c1
            if (r1 == r5) goto L_0x00bb
            goto L_0x01f6
        L_0x00bb:
            r2 = 38
            java.lang.String r1 = "trimLeft"
            goto L_0x01f8
        L_0x00c1:
            r2 = 40
            java.lang.String r1 = "includes"
            goto L_0x01f8
        L_0x00c7:
            r2 = 25
            java.lang.String r1 = "fontsize"
            goto L_0x01f8
        L_0x00cd:
            r2 = 42
            java.lang.String r1 = "endsWith"
            goto L_0x01f8
        L_0x00d3:
            java.lang.String r1 = "toString"
            r2 = 2
            goto L_0x01f8
        L_0x00d8:
            r2 = 3
            java.lang.String r1 = "toSource"
            goto L_0x01f8
        L_0x00dd:
            char r1 = r0.charAt(r11)
            r2 = 97
            if (r1 == r2) goto L_0x00fe
            if (r1 == r15) goto L_0x00f8
            if (r1 == r13) goto L_0x00f3
            if (r1 == r12) goto L_0x00ed
            goto L_0x01f6
        L_0x00ed:
            r2 = 17
            java.lang.String r1 = "italics"
            goto L_0x01f8
        L_0x00f3:
            r2 = 7
            java.lang.String r1 = "indexOf"
            goto L_0x01f8
        L_0x00f8:
            r2 = 33
            java.lang.String r1 = "replace"
            goto L_0x01f8
        L_0x00fe:
            java.lang.String r1 = "valueOf"
            r2 = 4
            goto L_0x01f8
        L_0x0103:
            char r1 = r0.charAt(r11)
            if (r1 == r15) goto L_0x0142
            r2 = 104(0x68, float:1.46E-43)
            if (r1 == r2) goto L_0x013d
            r2 = 113(0x71, float:1.58E-43)
            if (r1 == r2) goto L_0x0137
            if (r1 == r13) goto L_0x0131
            r2 = 111(0x6f, float:1.56E-43)
            if (r1 == r2) goto L_0x012b
            if (r1 == r12) goto L_0x0125
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L_0x011f
            goto L_0x01f6
        L_0x011f:
            r2 = 13
            java.lang.String r1 = "substr"
            goto L_0x01f8
        L_0x0125:
            r2 = 19
            java.lang.String r1 = "strike"
            goto L_0x01f8
        L_0x012b:
            r2 = 14
            java.lang.String r1 = "concat"
            goto L_0x01f8
        L_0x0131:
            r2 = 28
            java.lang.String r1 = "anchor"
            goto L_0x01f8
        L_0x0137:
            r2 = 29
            java.lang.String r1 = "equals"
            goto L_0x01f8
        L_0x013d:
            r2 = 5
            java.lang.String r1 = "charAt"
            goto L_0x01f8
        L_0x0142:
            char r1 = r0.charAt(r9)
            r2 = 114(0x72, float:1.6E-43)
            if (r1 != r2) goto L_0x0150
            r2 = 44
            java.lang.String r1 = "repeat"
            goto L_0x01f8
        L_0x0150:
            if (r1 != r8) goto L_0x01f6
            r2 = 32
            java.lang.String r1 = "search"
            goto L_0x01f8
        L_0x0158:
            r1 = 4
            char r1 = r0.charAt(r1)
            if (r1 == r10) goto L_0x018f
            if (r1 == r15) goto L_0x0189
            r2 = 104(0x68, float:1.46E-43)
            if (r1 == r2) goto L_0x0183
            if (r1 == r12) goto L_0x017d
            r2 = 107(0x6b, float:1.5E-43)
            if (r1 == r2) goto L_0x0177
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 == r2) goto L_0x0171
            goto L_0x01f6
        L_0x0171:
            r2 = 20
            java.lang.String r1 = "small"
            goto L_0x01f8
        L_0x0177:
            r2 = 22
            java.lang.String r1 = "blink"
            goto L_0x01f8
        L_0x017d:
            r2 = 9
            java.lang.String r1 = "split"
            goto L_0x01f8
        L_0x0183:
            r2 = 31
            java.lang.String r1 = "match"
            goto L_0x01f8
        L_0x0189:
            r2 = 15
            java.lang.String r1 = "slice"
            goto L_0x01f8
        L_0x018f:
            r2 = 18
            java.lang.String r1 = "fixed"
            goto L_0x01f8
        L_0x0194:
            char r1 = r0.charAt(r9)
            r2 = 98
            if (r1 != r2) goto L_0x01a1
            r2 = 16
            java.lang.String r1 = "bold"
            goto L_0x01f8
        L_0x01a1:
            r2 = 108(0x6c, float:1.51E-43)
            if (r1 != r2) goto L_0x01aa
            r2 = 27
            java.lang.String r1 = "link"
            goto L_0x01f8
        L_0x01aa:
            if (r1 != r12) goto L_0x01f6
            r2 = 37
            java.lang.String r1 = "trim"
            goto L_0x01f8
        L_0x01b1:
            char r1 = r0.charAt(r14)
            r2 = 98
            if (r1 != r2) goto L_0x01ca
            char r1 = r0.charAt(r9)
            if (r1 != r8) goto L_0x01f6
            char r1 = r0.charAt(r11)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01f6
            r9 = 24
            goto L_0x0204
        L_0x01ca:
            r2 = 103(0x67, float:1.44E-43)
            if (r1 != r2) goto L_0x01e1
            char r1 = r0.charAt(r9)
            r2 = 98
            if (r1 != r2) goto L_0x01f6
            char r1 = r0.charAt(r11)
            r2 = 105(0x69, float:1.47E-43)
            if (r1 != r2) goto L_0x01f6
            r9 = 21
            goto L_0x0204
        L_0x01e1:
            r2 = 112(0x70, float:1.57E-43)
            if (r1 != r2) goto L_0x01f6
            char r1 = r0.charAt(r9)
            if (r1 != r8) goto L_0x01f6
            char r1 = r0.charAt(r11)
            r2 = 117(0x75, float:1.64E-43)
            if (r1 != r2) goto L_0x01f6
            r9 = 23
            goto L_0x0204
        L_0x01f6:
            r1 = 0
            r2 = 0
        L_0x01f8:
            if (r1 == 0) goto L_0x0203
            if (r1 == r0) goto L_0x0203
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0203
            goto L_0x0204
        L_0x0203:
            r9 = r2
        L_0x0204:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeString.findPrototypeId(java.lang.String):int");
    }
}
