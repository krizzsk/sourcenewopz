package org.mozilla.javascript.regexp;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.RegExpProxy;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

public class RegExpImpl implements RegExpProxy {
    protected String input;
    protected SubString lastMatch;
    protected SubString lastParen;
    protected SubString leftContext;
    protected boolean multiline;
    protected SubString[] parens;
    protected SubString rightContext;

    public boolean isRegExp(Scriptable scriptable) {
        return scriptable instanceof NativeRegExp;
    }

    public Object compileRegExp(Context context, String str, String str2) {
        return NativeRegExp.compileRE(context, str, str2, false);
    }

    public Scriptable wrapRegExp(Context context, Scriptable scriptable, Object obj) {
        return new NativeRegExp(scriptable, (RECompiled) obj);
    }

    public Object action(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, int i) {
        NativeRegExp nativeRegExp;
        String str;
        String str2;
        Function function;
        int i2;
        Object obj;
        GlobData globData = new GlobData();
        globData.mode = i;
        globData.str = ScriptRuntime.toString((Object) scriptable2);
        if (i == 1) {
            return globData.arrayobj == null ? matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, createRegExp(context, scriptable, objArr, 1, false)) : globData.arrayobj;
        } else if (i == 2) {
            boolean z = (objArr.length > 0 && (objArr[0] instanceof NativeRegExp)) || objArr.length > 2;
            if (z) {
                nativeRegExp = createRegExp(context, scriptable, objArr, 2, true);
                str = null;
            } else {
                str = ScriptRuntime.toString(objArr.length < 1 ? Undefined.instance : objArr[0]);
                nativeRegExp = null;
            }
            Object obj2 = objArr.length < 2 ? Undefined.instance : objArr[1];
            if (obj2 instanceof Function) {
                function = (Function) obj2;
                str2 = null;
            } else {
                str2 = ScriptRuntime.toString(obj2);
                function = null;
            }
            globData.lambda = function;
            globData.repstr = str2;
            if (str2 == null) {
                i2 = -1;
            } else {
                i2 = str2.indexOf(36);
            }
            globData.dollar = i2;
            globData.charBuf = null;
            globData.leftIndex = 0;
            if (z) {
                obj = matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, nativeRegExp);
            } else {
                String str3 = globData.str;
                int indexOf = str3.indexOf(str);
                if (indexOf >= 0) {
                    int length = str.length();
                    this.lastParen = null;
                    this.leftContext = new SubString(str3, 0, indexOf);
                    this.lastMatch = new SubString(str3, indexOf, length);
                    this.rightContext = new SubString(str3, indexOf + length, (str3.length() - indexOf) - length);
                    obj = Boolean.TRUE;
                } else {
                    obj = Boolean.FALSE;
                }
            }
            if (globData.charBuf == null) {
                if (globData.f61858global || obj == null || !obj.equals(Boolean.TRUE)) {
                    return globData.str;
                }
                SubString subString = this.leftContext;
                replace_glob(globData, context, scriptable, this, subString.index, subString.length);
            }
            SubString subString2 = this.rightContext;
            globData.charBuf.append(subString2.str, subString2.index, subString2.index + subString2.length);
            return globData.charBuf.toString();
        } else if (i == 3) {
            return matchOrReplace(context, scriptable, scriptable2, objArr, this, globData, createRegExp(context, scriptable, objArr, 1, false));
        } else {
            throw Kit.codeBug();
        }
    }

    private static NativeRegExp createRegExp(Context context, Scriptable scriptable, Object[] objArr, int i, boolean z) {
        NativeRegExp nativeRegExp;
        String str;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        if (objArr.length == 0 || objArr[0] == Undefined.instance) {
            nativeRegExp = new NativeRegExp(topLevelScope, NativeRegExp.compileRE(context, "", "", false));
        } else if (objArr[0] instanceof NativeRegExp) {
            return objArr[0];
        } else {
            String scriptRuntime = ScriptRuntime.toString(objArr[0]);
            if (i < objArr.length) {
                objArr[0] = scriptRuntime;
                str = ScriptRuntime.toString(objArr[i]);
            } else {
                str = null;
            }
            nativeRegExp = new NativeRegExp(topLevelScope, NativeRegExp.compileRE(context, scriptRuntime, str, z));
        }
        return nativeRegExp;
    }

    private static Object matchOrReplace(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr, RegExpImpl regExpImpl, GlobData globData, NativeRegExp nativeRegExp) {
        RegExpImpl regExpImpl2 = regExpImpl;
        GlobData globData2 = globData;
        String str = globData2.str;
        globData2.f61858global = (nativeRegExp.getFlags() & 1) != 0;
        int[] iArr = {0};
        Object obj = null;
        if (globData2.mode == 3) {
            Object executeRegExp = nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, 0);
            if (executeRegExp == null || !executeRegExp.equals(Boolean.TRUE)) {
                return -1;
            }
            return Integer.valueOf(regExpImpl2.leftContext.length);
        } else if (globData2.f61858global) {
            nativeRegExp.lastIndex = Double.valueOf(0.0d);
            int i = 0;
            while (iArr[0] <= str.length()) {
                Object executeRegExp2 = nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, 0);
                if (executeRegExp2 != null && executeRegExp2.equals(Boolean.TRUE)) {
                    if (globData2.mode == 1) {
                        match_glob(globData2, context, scriptable, i, regExpImpl2);
                    } else {
                        Context context2 = context;
                        Scriptable scriptable3 = scriptable;
                        if (globData2.mode != 2) {
                            Kit.codeBug();
                        }
                        SubString subString = regExpImpl2.lastMatch;
                        int i2 = globData2.leftIndex;
                        int i3 = subString.index - i2;
                        globData2.leftIndex = subString.index + subString.length;
                        replace_glob(globData, context, scriptable, regExpImpl, i2, i3);
                    }
                    if (regExpImpl2.lastMatch.length == 0) {
                        if (iArr[0] != str.length()) {
                            iArr[0] = iArr[0] + 1;
                        }
                    }
                    i++;
                    obj = executeRegExp2;
                }
                return executeRegExp2;
            }
            return obj;
        } else {
            NativeRegExp nativeRegExp2 = nativeRegExp;
            return nativeRegExp.executeRegExp(context, scriptable, regExpImpl, str, iArr, globData2.mode == 2 ? 0 : 1);
        }
    }

    public int find_split(Context context, Scriptable scriptable, String str, String str2, Scriptable scriptable2, int[] iArr, int[] iArr2, boolean[] zArr, String[][] strArr) {
        int i;
        int i2 = iArr[0];
        int length = str.length();
        int languageVersion = context.getLanguageVersion();
        NativeRegExp nativeRegExp = (NativeRegExp) scriptable2;
        while (true) {
            int i3 = iArr[0];
            iArr[0] = i2;
            if (nativeRegExp.executeRegExp(context, scriptable, this, str, iArr, 0) != Boolean.TRUE) {
                iArr[0] = i3;
                iArr2[0] = 1;
                zArr[0] = false;
                return length;
            }
            i = iArr[0];
            iArr[0] = i3;
            zArr[0] = true;
            iArr2[0] = this.lastMatch.length;
            if (iArr2[0] != 0 || i != iArr[0]) {
                i -= iArr2[0];
            } else if (i != length) {
                i2 = i + 1;
            } else if (languageVersion == 120) {
                iArr2[0] = 1;
            } else {
                i = -1;
            }
        }
        i -= iArr2[0];
        SubString[] subStringArr = this.parens;
        int length2 = subStringArr == null ? 0 : subStringArr.length;
        strArr[0] = new String[length2];
        for (int i4 = 0; i4 < length2; i4++) {
            strArr[0][i4] = getParenSubString(i4).toString();
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public SubString getParenSubString(int i) {
        SubString subString;
        SubString[] subStringArr = this.parens;
        if (subStringArr == null || i >= subStringArr.length || (subString = subStringArr[i]) == null) {
            return SubString.emptySubString;
        }
        return subString;
    }

    private static void match_glob(GlobData globData, Context context, Scriptable scriptable, int i, RegExpImpl regExpImpl) {
        if (globData.arrayobj == null) {
            globData.arrayobj = context.newArray(scriptable, 0);
        }
        globData.arrayobj.put(i, globData.arrayobj, (Object) regExpImpl.lastMatch.toString());
    }

    /* JADX INFO: finally extract failed */
    private static void replace_glob(GlobData globData, Context context, Scriptable scriptable, RegExpImpl regExpImpl, int i, int i2) {
        String str;
        int i3;
        int i4;
        int i5;
        if (globData.lambda != null) {
            SubString[] subStringArr = regExpImpl.parens;
            if (subStringArr == null) {
                i5 = 0;
            } else {
                i5 = subStringArr.length;
            }
            Object[] objArr = new Object[(i5 + 3)];
            objArr[0] = regExpImpl.lastMatch.toString();
            for (int i6 = 0; i6 < i5; i6++) {
                SubString subString = subStringArr[i6];
                if (subString != null) {
                    objArr[i6 + 1] = subString.toString();
                } else {
                    objArr[i6 + 1] = Undefined.instance;
                }
            }
            objArr[i5 + 1] = Integer.valueOf(regExpImpl.leftContext.length);
            objArr[i5 + 2] = globData.str;
            if (regExpImpl != ScriptRuntime.getRegExpProxy(context)) {
                Kit.codeBug();
            }
            RegExpImpl regExpImpl2 = new RegExpImpl();
            regExpImpl2.multiline = regExpImpl.multiline;
            regExpImpl2.input = regExpImpl.input;
            ScriptRuntime.setRegExpProxy(context, regExpImpl2);
            try {
                Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
                str = ScriptRuntime.toString(globData.lambda.call(context, topLevelScope, topLevelScope, objArr));
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                i3 = str.length();
            } catch (Throwable th) {
                ScriptRuntime.setRegExpProxy(context, regExpImpl);
                throw th;
            }
        } else {
            str = null;
            i3 = globData.repstr.length();
            if (globData.dollar >= 0) {
                int[] iArr = new int[1];
                int i7 = globData.dollar;
                do {
                    SubString interpretDollar = interpretDollar(context, regExpImpl, globData.repstr, i7, iArr);
                    if (interpretDollar != null) {
                        i3 += interpretDollar.length - iArr[0];
                        i4 = i7 + iArr[0];
                    } else {
                        i4 = i7 + 1;
                    }
                    i7 = globData.repstr.indexOf(36, i4);
                } while (i7 >= 0);
            }
        }
        int i8 = i3 + i2 + regExpImpl.rightContext.length;
        StringBuilder sb = globData.charBuf;
        if (sb == null) {
            sb = new StringBuilder(i8);
            globData.charBuf = sb;
        } else {
            sb.ensureCapacity(globData.charBuf.length() + i8);
        }
        sb.append(regExpImpl.leftContext.str, i, i2 + i);
        if (globData.lambda != null) {
            sb.append(str);
        } else {
            do_replace(globData, context, regExpImpl);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.mozilla.javascript.regexp.SubString interpretDollar(org.mozilla.javascript.Context r7, org.mozilla.javascript.regexp.RegExpImpl r8, java.lang.String r9, int r10, int[] r11) {
        /*
            char r0 = r9.charAt(r10)
            r1 = 36
            if (r0 == r1) goto L_0x000b
            org.mozilla.javascript.Kit.codeBug()
        L_0x000b:
            int r7 = r7.getLanguageVersion()
            r0 = 140(0x8c, float:1.96E-43)
            r2 = 0
            if (r7 == 0) goto L_0x0023
            if (r7 > r0) goto L_0x0023
            if (r10 <= 0) goto L_0x0023
            int r3 = r10 + -1
            char r3 = r9.charAt(r3)
            r4 = 92
            if (r3 != r4) goto L_0x0023
            return r2
        L_0x0023:
            int r3 = r9.length()
            int r4 = r10 + 1
            if (r4 < r3) goto L_0x002c
            return r2
        L_0x002c:
            char r4 = r9.charAt(r4)
            boolean r5 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r4)
            r6 = 0
            if (r5 == 0) goto L_0x008d
            r1 = 48
            if (r7 == 0) goto L_0x005a
            if (r7 > r0) goto L_0x005a
            if (r4 != r1) goto L_0x0040
            return r2
        L_0x0040:
            r7 = r10
            r0 = 0
        L_0x0042:
            int r7 = r7 + 1
            if (r7 >= r3) goto L_0x0083
            char r1 = r9.charAt(r7)
            boolean r2 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r1)
            if (r2 == 0) goto L_0x0083
            int r2 = r0 * 10
            int r1 = r1 + -48
            int r2 = r2 + r1
            if (r2 >= r0) goto L_0x0058
            goto L_0x0083
        L_0x0058:
            r0 = r2
            goto L_0x0042
        L_0x005a:
            org.mozilla.javascript.regexp.SubString[] r7 = r8.parens
            if (r7 != 0) goto L_0x0060
            r7 = 0
            goto L_0x0061
        L_0x0060:
            int r7 = r7.length
        L_0x0061:
            int r4 = r4 - r1
            if (r4 <= r7) goto L_0x0065
            return r2
        L_0x0065:
            int r0 = r10 + 2
            if (r0 >= r3) goto L_0x007e
            char r9 = r9.charAt(r0)
            boolean r3 = org.mozilla.javascript.regexp.NativeRegExp.isDigit(r9)
            if (r3 == 0) goto L_0x007e
            int r3 = r4 * 10
            int r9 = r9 - r1
            int r3 = r3 + r9
            if (r3 > r7) goto L_0x007e
            int r0 = r0 + 1
            r7 = r0
            r0 = r3
            goto L_0x0080
        L_0x007e:
            r7 = r0
            r0 = r4
        L_0x0080:
            if (r0 != 0) goto L_0x0083
            return r2
        L_0x0083:
            int r0 = r0 + -1
            int r7 = r7 - r10
            r11[r6] = r7
            org.mozilla.javascript.regexp.SubString r7 = r8.getParenSubString(r0)
            return r7
        L_0x008d:
            r9 = 2
            r11[r6] = r9
            if (r4 == r1) goto L_0x00bf
            r9 = 43
            if (r4 == r9) goto L_0x00bc
            r9 = 96
            if (r4 == r9) goto L_0x00a9
            r7 = 38
            if (r4 == r7) goto L_0x00a6
            r7 = 39
            if (r4 == r7) goto L_0x00a3
            return r2
        L_0x00a3:
            org.mozilla.javascript.regexp.SubString r7 = r8.rightContext
            return r7
        L_0x00a6:
            org.mozilla.javascript.regexp.SubString r7 = r8.lastMatch
            return r7
        L_0x00a9:
            r9 = 120(0x78, float:1.68E-43)
            if (r7 != r9) goto L_0x00b9
            org.mozilla.javascript.regexp.SubString r7 = r8.leftContext
            r7.index = r6
            org.mozilla.javascript.regexp.SubString r7 = r8.leftContext
            org.mozilla.javascript.regexp.SubString r9 = r8.lastMatch
            int r9 = r9.index
            r7.length = r9
        L_0x00b9:
            org.mozilla.javascript.regexp.SubString r7 = r8.leftContext
            return r7
        L_0x00bc:
            org.mozilla.javascript.regexp.SubString r7 = r8.lastParen
            return r7
        L_0x00bf:
            org.mozilla.javascript.regexp.SubString r7 = new org.mozilla.javascript.regexp.SubString
            java.lang.String r8 = "$"
            r7.<init>(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.interpretDollar(org.mozilla.javascript.Context, org.mozilla.javascript.regexp.RegExpImpl, java.lang.String, int, int[]):org.mozilla.javascript.regexp.SubString");
    }

    private static void do_replace(GlobData globData, Context context, RegExpImpl regExpImpl) {
        int i;
        StringBuilder sb = globData.charBuf;
        String str = globData.repstr;
        int i2 = globData.dollar;
        int i3 = 0;
        if (i2 != -1) {
            int[] iArr = new int[1];
            int i4 = 0;
            do {
                sb.append(str.substring(i4, i2));
                SubString interpretDollar = interpretDollar(context, regExpImpl, str, i2, iArr);
                if (interpretDollar != null) {
                    int i5 = interpretDollar.length;
                    if (i5 > 0) {
                        sb.append(interpretDollar.str, interpretDollar.index, interpretDollar.index + i5);
                    }
                    i4 = iArr[0] + i2;
                    i = i2 + iArr[0];
                } else {
                    i4 = i2;
                    i = i2 + 1;
                }
                i2 = str.indexOf(36, i);
            } while (i2 >= 0);
            i3 = i4;
        }
        int length = str.length();
        if (length > i3) {
            sb.append(str.substring(i3, length));
        }
    }

    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r22v2 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=boolean, code=?, for r22v0, types: [boolean] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object js_split(org.mozilla.javascript.Context r28, org.mozilla.javascript.Scriptable r29, java.lang.String r30, java.lang.Object[] r31) {
        /*
            r27 = this;
            r11 = r30
            r0 = r31
            r12 = 0
            r13 = r28
            r14 = r29
            org.mozilla.javascript.Scriptable r15 = r13.newArray((org.mozilla.javascript.Scriptable) r14, (int) r12)
            int r1 = r0.length
            r10 = 1
            if (r1 <= r10) goto L_0x001a
            r1 = r0[r10]
            java.lang.Object r2 = org.mozilla.javascript.Undefined.instance
            if (r1 == r2) goto L_0x001a
            r16 = 1
            goto L_0x001c
        L_0x001a:
            r16 = 0
        L_0x001c:
            r1 = 0
            if (r16 == 0) goto L_0x0035
            r1 = r0[r10]
            long r1 = org.mozilla.javascript.ScriptRuntime.toUint32((java.lang.Object) r1)
            int r3 = r30.length()
            long r3 = (long) r3
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0035
            int r1 = r30.length()
            int r1 = r1 + r10
            long r1 = (long) r1
        L_0x0035:
            r17 = r1
            int r1 = r0.length
            if (r1 < r10) goto L_0x0121
            r1 = r0[r12]
            java.lang.Object r2 = org.mozilla.javascript.Undefined.instance
            if (r1 != r2) goto L_0x0042
            goto L_0x0121
        L_0x0042:
            int[] r9 = new int[r10]
            r1 = r0[r12]
            boolean r1 = r1 instanceof org.mozilla.javascript.Scriptable
            r2 = 0
            if (r1 == 0) goto L_0x0065
            org.mozilla.javascript.RegExpProxy r1 = org.mozilla.javascript.ScriptRuntime.getRegExpProxy(r28)
            if (r1 == 0) goto L_0x0060
            r3 = r0[r12]
            org.mozilla.javascript.Scriptable r3 = (org.mozilla.javascript.Scriptable) r3
            boolean r4 = r1.isRegExp(r3)
            if (r4 == 0) goto L_0x0060
            r19 = r1
            r20 = r3
            goto L_0x0069
        L_0x0060:
            r19 = r1
            r20 = r2
            goto L_0x0069
        L_0x0065:
            r19 = r2
            r20 = r19
        L_0x0069:
            if (r20 != 0) goto L_0x007a
            r0 = r0[r12]
            java.lang.String r0 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r0)
            int r1 = r0.length()
            r9[r12] = r1
            r21 = r0
            goto L_0x007c
        L_0x007a:
            r21 = r2
        L_0x007c:
            int[] r8 = new int[r10]
            r8[r12] = r12
            boolean[] r7 = new boolean[r10]
            r7[r12] = r12
            java.lang.String[][] r6 = new java.lang.String[r10][]
            r6[r12] = r2
            int r5 = r28.getLanguageVersion()
            r4 = 0
        L_0x008d:
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r21
            r12 = r4
            r4 = r5
            r13 = r5
            r5 = r19
            r23 = r6
            r6 = r20
            r24 = r7
            r7 = r8
            r25 = r8
            r8 = r9
            r26 = r9
            r9 = r24
            r14 = 1
            r10 = r23
            int r0 = find_split(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            if (r0 < 0) goto L_0x0120
            if (r16 == 0) goto L_0x00b8
            long r1 = (long) r12
            int r3 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r3 >= 0) goto L_0x0120
        L_0x00b8:
            int r1 = r30.length()
            if (r0 <= r1) goto L_0x00c0
            goto L_0x0120
        L_0x00c0:
            int r1 = r30.length()
            if (r1 != 0) goto L_0x00ca
            r1 = r11
            r22 = 0
            goto L_0x00d2
        L_0x00ca:
            r22 = 0
            r1 = r25[r22]
            java.lang.String r1 = r11.substring(r1, r0)
        L_0x00d2:
            r15.put((int) r12, (org.mozilla.javascript.Scriptable) r15, (java.lang.Object) r1)
            int r4 = r12 + 1
            if (r20 == 0) goto L_0x00f9
            boolean r1 = r24[r22]
            if (r1 != r14) goto L_0x00f9
            r1 = r23[r22]
            int r1 = r1.length
            r2 = 0
        L_0x00e1:
            if (r2 >= r1) goto L_0x00f7
            if (r16 == 0) goto L_0x00eb
            long r5 = (long) r4
            int r3 = (r5 > r17 ? 1 : (r5 == r17 ? 0 : -1))
            if (r3 < 0) goto L_0x00eb
            goto L_0x00f7
        L_0x00eb:
            r3 = r23[r22]
            r3 = r3[r2]
            r15.put((int) r4, (org.mozilla.javascript.Scriptable) r15, (java.lang.Object) r3)
            int r4 = r4 + 1
            int r2 = r2 + 1
            goto L_0x00e1
        L_0x00f7:
            r24[r22] = r22
        L_0x00f9:
            r1 = r26[r22]
            int r0 = r0 + r1
            r25[r22] = r0
            r0 = 130(0x82, float:1.82E-43)
            if (r13 >= r0) goto L_0x010f
            if (r13 == 0) goto L_0x010f
            if (r16 != 0) goto L_0x010f
            r0 = r25[r22]
            int r1 = r30.length()
            if (r0 != r1) goto L_0x010f
            goto L_0x0120
        L_0x010f:
            r14 = r29
            r5 = r13
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = 1
            r12 = 0
            r13 = r28
            goto L_0x008d
        L_0x0120:
            return r15
        L_0x0121:
            r0 = 0
            r15.put((int) r0, (org.mozilla.javascript.Scriptable) r15, (java.lang.Object) r11)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.js_split(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0096, code lost:
        r0 = r13.indexOf(r14, r18[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int find_split(org.mozilla.javascript.Context r11, org.mozilla.javascript.Scriptable r12, java.lang.String r13, java.lang.String r14, int r15, org.mozilla.javascript.RegExpProxy r16, org.mozilla.javascript.Scriptable r17, int[] r18, int[] r19, boolean[] r20, java.lang.String[][] r21) {
        /*
            r3 = r13
            r4 = r14
            r0 = r15
            r1 = 0
            r2 = r18[r1]
            int r5 = r13.length()
            r6 = 120(0x78, float:1.68E-43)
            r7 = -1
            r8 = 1
            if (r0 != r6) goto L_0x0059
            if (r17 != 0) goto L_0x0059
            int r9 = r14.length()
            if (r9 != r8) goto L_0x0059
            char r9 = r14.charAt(r1)
            r10 = 32
            if (r9 != r10) goto L_0x0059
            if (r2 != 0) goto L_0x0033
        L_0x0022:
            if (r2 >= r5) goto L_0x0031
            char r0 = r13.charAt(r2)
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0031
            int r2 = r2 + 1
            goto L_0x0022
        L_0x0031:
            r18[r1] = r2
        L_0x0033:
            if (r2 != r5) goto L_0x0036
            return r7
        L_0x0036:
            if (r2 >= r5) goto L_0x0045
            char r0 = r13.charAt(r2)
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 != 0) goto L_0x0045
            int r2 = r2 + 1
            goto L_0x0036
        L_0x0045:
            r0 = r2
        L_0x0046:
            if (r0 >= r5) goto L_0x0055
            char r4 = r13.charAt(r0)
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 == 0) goto L_0x0055
            int r0 = r0 + 1
            goto L_0x0046
        L_0x0055:
            int r0 = r0 - r2
            r19[r1] = r0
            return r2
        L_0x0059:
            if (r2 <= r5) goto L_0x005c
            return r7
        L_0x005c:
            if (r17 == 0) goto L_0x0073
            r0 = r16
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r17
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            int r0 = r0.find_split(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0073:
            if (r0 == 0) goto L_0x007c
            r9 = 130(0x82, float:1.82E-43)
            if (r0 >= r9) goto L_0x007c
            if (r5 != 0) goto L_0x007c
            return r7
        L_0x007c:
            int r9 = r14.length()
            if (r9 != 0) goto L_0x0091
            if (r0 != r6) goto L_0x008b
            if (r2 != r5) goto L_0x0089
            r19[r1] = r8
            return r2
        L_0x0089:
            int r2 = r2 + r8
            return r2
        L_0x008b:
            if (r2 != r5) goto L_0x008e
            goto L_0x0090
        L_0x008e:
            int r7 = r2 + 1
        L_0x0090:
            return r7
        L_0x0091:
            r0 = r18[r1]
            if (r0 < r5) goto L_0x0096
            return r5
        L_0x0096:
            r0 = r18[r1]
            int r0 = r13.indexOf(r14, r0)
            if (r0 == r7) goto L_0x009f
            r5 = r0
        L_0x009f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.regexp.RegExpImpl.find_split(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.String, java.lang.String, int, org.mozilla.javascript.RegExpProxy, org.mozilla.javascript.Scriptable, int[], int[], boolean[], java.lang.String[][]):int");
    }
}
