package org.mozilla.javascript;

import kotlin.text.Typography;
import org.apache.commons.p071io.IOUtils;

public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 165;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    private static final boolean printSource = false;
    private char[] sourceBuffer = new char[128];
    private int sourceTop;

    /* access modifiers changed from: package-private */
    public String getEncodedSource() {
        return sourceToString(0);
    }

    /* access modifiers changed from: package-private */
    public int getCurrentOffset() {
        return this.sourceTop;
    }

    /* access modifiers changed from: package-private */
    public int markFunctionStart(int i) {
        int currentOffset = getCurrentOffset();
        addToken(109);
        append((char) i);
        return currentOffset;
    }

    /* access modifiers changed from: package-private */
    public int markFunctionEnd(int i) {
        int currentOffset = getCurrentOffset();
        append(165);
        return currentOffset;
    }

    /* access modifiers changed from: package-private */
    public void addToken(int i) {
        if (i < 0 || i > 164) {
            throw new IllegalArgumentException();
        }
        append((char) i);
    }

    /* access modifiers changed from: package-private */
    public void addEOL(int i) {
        if (i < 0 || i > 164) {
            throw new IllegalArgumentException();
        }
        append((char) i);
        append(1);
    }

    /* access modifiers changed from: package-private */
    public void addName(String str) {
        addToken(39);
        appendString(str);
    }

    /* access modifiers changed from: package-private */
    public void addString(String str) {
        addToken(41);
        appendString(str);
    }

    /* access modifiers changed from: package-private */
    public void addRegexp(String str, String str2) {
        addToken(48);
        appendString(IOUtils.DIR_SEPARATOR_UNIX + str + IOUtils.DIR_SEPARATOR_UNIX + str2);
    }

    /* access modifiers changed from: package-private */
    public void addNumber(double d) {
        addToken(40);
        long j = (long) d;
        if (((double) j) != d) {
            long doubleToLongBits = Double.doubleToLongBits(d);
            append('D');
            append((char) ((int) (doubleToLongBits >> 48)));
            append((char) ((int) (doubleToLongBits >> 32)));
            append((char) ((int) (doubleToLongBits >> 16)));
            append((char) ((int) doubleToLongBits));
            return;
        }
        if (j < 0) {
            Kit.codeBug();
        }
        if (j <= 65535) {
            append('S');
            append((char) ((int) j));
            return;
        }
        append('J');
        append((char) ((int) (j >> 48)));
        append((char) ((int) (j >> 32)));
        append((char) ((int) (j >> 16)));
        append((char) ((int) j));
    }

    private void appendString(String str) {
        int length = str.length();
        int i = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i > this.sourceBuffer.length) {
            increaseSourceCapacity(i);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i2 = this.sourceTop;
            cArr[i2] = (char) (32768 | (length >>> 16));
            this.sourceTop = i2 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr2[i3] = (char) length;
        int i4 = i3 + 1;
        this.sourceTop = i4;
        str.getChars(0, length, cArr2, i4);
        this.sourceTop = i;
    }

    private void append(char c) {
        int i = this.sourceTop;
        if (i == this.sourceBuffer.length) {
            increaseSourceCapacity(i + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i2 = this.sourceTop;
        cArr[i2] = c;
        this.sourceTop = i2 + 1;
    }

    private void increaseSourceCapacity(int i) {
        if (i <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        int length = this.sourceBuffer.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr = new char[i];
        System.arraycopy(this.sourceBuffer, 0, cArr, 0, this.sourceTop);
        this.sourceBuffer = cArr;
    }

    private String sourceToString(int i) {
        if (i < 0 || this.sourceTop < i) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i, this.sourceTop - i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0228, code lost:
        if (r6 != 165) goto L_0x0488;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decompile(java.lang.String r18, int r19, org.mozilla.javascript.UintMap r20) {
        /*
            r0 = r18
            r1 = r20
            int r2 = r18.length()
            if (r2 != 0) goto L_0x000d
            java.lang.String r0 = ""
            return r0
        L_0x000d:
            r3 = 1
            r4 = 0
            int r5 = r1.getInt(r3, r4)
            if (r5 < 0) goto L_0x04ae
            r6 = 2
            r7 = 4
            int r8 = r1.getInt(r6, r7)
            if (r8 < 0) goto L_0x04a8
            r9 = 3
            int r1 = r1.getInt(r9, r6)
            if (r1 < 0) goto L_0x04a2
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r10 = r19 & 1
            if (r10 == 0) goto L_0x002f
            r10 = 1
            goto L_0x0030
        L_0x002f:
            r10 = 0
        L_0x0030:
            r11 = r19 & 2
            if (r11 == 0) goto L_0x0036
            r11 = 1
            goto L_0x0037
        L_0x0036:
            r11 = 0
        L_0x0037:
            char r12 = r0.charAt(r4)
            r13 = 136(0x88, float:1.9E-43)
            if (r12 != r13) goto L_0x0042
            r12 = -1
            r13 = 1
            goto L_0x0047
        L_0x0042:
            char r12 = r0.charAt(r3)
            r13 = 0
        L_0x0047:
            r14 = 40
            r15 = 10
            r4 = 32
            if (r11 != 0) goto L_0x005b
            r9.append(r15)
            r15 = 0
        L_0x0053:
            if (r15 >= r5) goto L_0x0060
            r9.append(r4)
            int r15 = r15 + 1
            goto L_0x0053
        L_0x005b:
            if (r12 != r6) goto L_0x0060
            r9.append(r14)
        L_0x0060:
            r15 = 0
            r17 = 0
        L_0x0063:
            if (r13 >= r2) goto L_0x048b
            char r14 = r0.charAt(r13)
            r6 = 39
            if (r14 == r3) goto L_0x0435
            if (r14 == r7) goto L_0x0422
            r7 = 50
            if (r14 == r7) goto L_0x0419
            r7 = 66
            if (r14 == r7) goto L_0x0410
            r7 = 72
            if (r14 == r7) goto L_0x0407
            r7 = 160(0xa0, float:2.24E-43)
            if (r14 == r7) goto L_0x03fe
            r7 = 163(0xa3, float:2.28E-43)
            if (r14 == r7) goto L_0x00db
            r7 = 165(0xa5, float:2.31E-43)
            if (r14 == r7) goto L_0x01fe
            r7 = 52
            if (r14 == r7) goto L_0x03cf
            r7 = 53
            if (r14 == r7) goto L_0x03c6
            r7 = 143(0x8f, float:2.0E-43)
            if (r14 == r7) goto L_0x03bd
            r7 = 144(0x90, float:2.02E-43)
            if (r14 == r7) goto L_0x03b4
            r7 = 146(0x92, float:2.05E-43)
            if (r14 == r7) goto L_0x03ab
            r7 = 147(0x93, float:2.06E-43)
            if (r14 == r7) goto L_0x03a2
            switch(r14) {
                case 9: goto L_0x0399;
                case 10: goto L_0x0390;
                case 11: goto L_0x0387;
                case 12: goto L_0x037e;
                case 13: goto L_0x0375;
                case 14: goto L_0x036c;
                case 15: goto L_0x0363;
                case 16: goto L_0x035a;
                case 17: goto L_0x0351;
                case 18: goto L_0x0348;
                case 19: goto L_0x033f;
                case 20: goto L_0x0336;
                case 21: goto L_0x032d;
                case 22: goto L_0x0324;
                case 23: goto L_0x031b;
                case 24: goto L_0x0312;
                case 25: goto L_0x0309;
                case 26: goto L_0x0300;
                case 27: goto L_0x02f7;
                case 28: goto L_0x02ee;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02dc;
                case 31: goto L_0x02d3;
                case 32: goto L_0x02ca;
                default: goto L_0x00a2;
            }
        L_0x00a2:
            switch(r14) {
                case 39: goto L_0x02bc;
                case 40: goto L_0x02b3;
                case 41: goto L_0x02aa;
                case 42: goto L_0x02a1;
                case 43: goto L_0x0298;
                case 44: goto L_0x028f;
                case 45: goto L_0x0286;
                case 46: goto L_0x027d;
                case 47: goto L_0x0274;
                case 48: goto L_0x02bc;
                default: goto L_0x00a5;
            }
        L_0x00a5:
            switch(r14) {
                case 81: goto L_0x026b;
                case 82: goto L_0x0259;
                case 83: goto L_0x0250;
                case 84: goto L_0x0247;
                case 85: goto L_0x0235;
                case 86: goto L_0x0209;
                case 87: goto L_0x0202;
                case 88: goto L_0x01ee;
                case 89: goto L_0x01e8;
                case 90: goto L_0x01e2;
                case 91: goto L_0x01dc;
                case 92: goto L_0x01d6;
                case 93: goto L_0x01d0;
                case 94: goto L_0x01ca;
                case 95: goto L_0x01c4;
                case 96: goto L_0x01be;
                case 97: goto L_0x01b8;
                case 98: goto L_0x01b2;
                case 99: goto L_0x01ac;
                case 100: goto L_0x01a6;
                case 101: goto L_0x01a0;
                case 102: goto L_0x019a;
                case 103: goto L_0x0186;
                case 104: goto L_0x017f;
                case 105: goto L_0x0178;
                case 106: goto L_0x0171;
                case 107: goto L_0x016a;
                case 108: goto L_0x0163;
                case 109: goto L_0x015a;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            switch(r14) {
                case 112: goto L_0x0153;
                case 113: goto L_0x014c;
                case 114: goto L_0x0145;
                case 115: goto L_0x013e;
                case 116: goto L_0x0137;
                case 117: goto L_0x0130;
                case 118: goto L_0x0129;
                case 119: goto L_0x0122;
                case 120: goto L_0x0112;
                case 121: goto L_0x0102;
                case 122: goto L_0x00fb;
                case 123: goto L_0x00f4;
                case 124: goto L_0x00ed;
                case 125: goto L_0x00e6;
                case 126: goto L_0x00df;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            switch(r14) {
                case 151: goto L_0x00db;
                case 152: goto L_0x00db;
                case 153: goto L_0x00d4;
                case 154: goto L_0x00cd;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Token: "
            r2.append(r3)
            char r0 = r0.charAt(r13)
            java.lang.String r0 = org.mozilla.javascript.Token.name(r0)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x00cd:
            java.lang.String r6 = "const "
            r9.append(r6)
            goto L_0x01fe
        L_0x00d4:
            java.lang.String r6 = "let "
            r9.append(r6)
            goto L_0x01fe
        L_0x00db:
            r7 = 40
            goto L_0x03d8
        L_0x00df:
            java.lang.String r6 = "void "
            r9.append(r6)
            goto L_0x01fe
        L_0x00e6:
            java.lang.String r6 = "finally "
            r9.append(r6)
            goto L_0x01fe
        L_0x00ed:
            java.lang.String r6 = "catch "
            r9.append(r6)
            goto L_0x01fe
        L_0x00f4:
            java.lang.String r6 = "with "
            r9.append(r6)
            goto L_0x01fe
        L_0x00fb:
            java.lang.String r6 = "var "
            r9.append(r6)
            goto L_0x01fe
        L_0x0102:
            java.lang.String r7 = "continue"
            r9.append(r7)
            int r7 = getNext(r0, r2, r13)
            if (r6 != r7) goto L_0x01fe
            r9.append(r4)
            goto L_0x01fe
        L_0x0112:
            java.lang.String r7 = "break"
            r9.append(r7)
            int r7 = getNext(r0, r2, r13)
            if (r6 != r7) goto L_0x01fe
            r9.append(r4)
            goto L_0x01fe
        L_0x0122:
            java.lang.String r6 = "for "
            r9.append(r6)
            goto L_0x01fe
        L_0x0129:
            java.lang.String r6 = "do "
            r9.append(r6)
            goto L_0x01fe
        L_0x0130:
            java.lang.String r6 = "while "
            r9.append(r6)
            goto L_0x01fe
        L_0x0137:
            java.lang.String r6 = "default"
            r9.append(r6)
            goto L_0x01fe
        L_0x013e:
            java.lang.String r6 = "case "
            r9.append(r6)
            goto L_0x01fe
        L_0x0145:
            java.lang.String r6 = "switch "
            r9.append(r6)
            goto L_0x01fe
        L_0x014c:
            java.lang.String r6 = "else "
            r9.append(r6)
            goto L_0x01fe
        L_0x0153:
            java.lang.String r6 = "if "
            r9.append(r6)
            goto L_0x01fe
        L_0x015a:
            int r13 = r13 + 1
            java.lang.String r6 = "function "
            r9.append(r6)
            goto L_0x0488
        L_0x0163:
            r6 = 46
            r9.append(r6)
            goto L_0x01fe
        L_0x016a:
            java.lang.String r6 = "--"
            r9.append(r6)
            goto L_0x01fe
        L_0x0171:
            java.lang.String r6 = "++"
            r9.append(r6)
            goto L_0x01fe
        L_0x0178:
            java.lang.String r6 = " && "
            r9.append(r6)
            goto L_0x01fe
        L_0x017f:
            java.lang.String r6 = " || "
            r9.append(r6)
            goto L_0x01fe
        L_0x0186:
            int r6 = getNext(r0, r2, r13)
            if (r3 != r6) goto L_0x0193
            r6 = 58
            r9.append(r6)
            goto L_0x01fe
        L_0x0193:
            java.lang.String r6 = " : "
            r9.append(r6)
            goto L_0x01fe
        L_0x019a:
            java.lang.String r6 = " ? "
            r9.append(r6)
            goto L_0x01fe
        L_0x01a0:
            java.lang.String r6 = " %= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01a6:
            java.lang.String r6 = " /= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01ac:
            java.lang.String r6 = " *= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01b2:
            java.lang.String r6 = " -= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01b8:
            java.lang.String r6 = " += "
            r9.append(r6)
            goto L_0x01fe
        L_0x01be:
            java.lang.String r6 = " >>>= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01c4:
            java.lang.String r6 = " >>= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01ca:
            java.lang.String r6 = " <<= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01d0:
            java.lang.String r6 = " &= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01d6:
            java.lang.String r6 = " ^= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01dc:
            java.lang.String r6 = " |= "
            r9.append(r6)
            goto L_0x01fe
        L_0x01e2:
            java.lang.String r6 = " = "
            r9.append(r6)
            goto L_0x01fe
        L_0x01e8:
            java.lang.String r6 = ", "
            r9.append(r6)
            goto L_0x01fe
        L_0x01ee:
            r6 = 41
            r9.append(r6)
            r6 = 85
            int r7 = getNext(r0, r2, r13)
            if (r6 != r7) goto L_0x01fe
            r9.append(r4)
        L_0x01fe:
            r7 = 40
            goto L_0x0488
        L_0x0202:
            r7 = 40
            r9.append(r7)
            goto L_0x0488
        L_0x0209:
            r7 = 40
            int r15 = r15 + -1
            if (r10 == 0) goto L_0x0213
            if (r15 != 0) goto L_0x0213
            goto L_0x0488
        L_0x0213:
            r6 = 125(0x7d, float:1.75E-43)
            r9.append(r6)
            int r6 = getNext(r0, r2, r13)
            if (r6 == r3) goto L_0x0232
            r14 = 113(0x71, float:1.58E-43)
            if (r6 == r14) goto L_0x022c
            r14 = 117(0x75, float:1.64E-43)
            if (r6 == r14) goto L_0x022c
            r14 = 165(0xa5, float:2.31E-43)
            if (r6 == r14) goto L_0x0232
            goto L_0x0488
        L_0x022c:
            int r5 = r5 - r8
            r9.append(r4)
            goto L_0x0488
        L_0x0232:
            int r5 = r5 - r8
            goto L_0x0488
        L_0x0235:
            r7 = 40
            int r15 = r15 + 1
            int r6 = getNext(r0, r2, r13)
            if (r3 != r6) goto L_0x0240
            int r5 = r5 + r8
        L_0x0240:
            r6 = 123(0x7b, float:1.72E-43)
            r9.append(r6)
            goto L_0x0488
        L_0x0247:
            r7 = 40
            r6 = 93
            r9.append(r6)
            goto L_0x0488
        L_0x0250:
            r7 = 40
            r6 = 91
            r9.append(r6)
            goto L_0x0488
        L_0x0259:
            r7 = 40
            r6 = 59
            r9.append(r6)
            int r6 = getNext(r0, r2, r13)
            if (r3 == r6) goto L_0x0488
            r9.append(r4)
            goto L_0x0488
        L_0x026b:
            r7 = 40
            java.lang.String r6 = "try "
            r9.append(r6)
            goto L_0x0488
        L_0x0274:
            r7 = 40
            java.lang.String r6 = " !== "
            r9.append(r6)
            goto L_0x0488
        L_0x027d:
            r7 = 40
            java.lang.String r6 = " === "
            r9.append(r6)
            goto L_0x0488
        L_0x0286:
            r7 = 40
            java.lang.String r6 = "true"
            r9.append(r6)
            goto L_0x0488
        L_0x028f:
            r7 = 40
            java.lang.String r6 = "false"
            r9.append(r6)
            goto L_0x0488
        L_0x0298:
            r7 = 40
            java.lang.String r6 = "this"
            r9.append(r6)
            goto L_0x0488
        L_0x02a1:
            r7 = 40
            java.lang.String r6 = "null"
            r9.append(r6)
            goto L_0x0488
        L_0x02aa:
            r7 = 40
            int r13 = r13 + 1
            int r13 = printSourceString(r0, r13, r3, r9)
            goto L_0x02c5
        L_0x02b3:
            r7 = 40
            int r13 = r13 + 1
            int r13 = printSourceNumber(r0, r13, r9)
            goto L_0x02c5
        L_0x02bc:
            r7 = 40
            int r13 = r13 + 1
            r6 = 0
            int r13 = printSourceString(r0, r13, r6, r9)
        L_0x02c5:
            r7 = 4
            r14 = 40
            goto L_0x0063
        L_0x02ca:
            r7 = 40
            java.lang.String r6 = "typeof "
            r9.append(r6)
            goto L_0x0488
        L_0x02d3:
            r7 = 40
            java.lang.String r6 = "delete "
            r9.append(r6)
            goto L_0x0488
        L_0x02dc:
            r7 = 40
            java.lang.String r6 = "new "
            r9.append(r6)
            goto L_0x0488
        L_0x02e5:
            r7 = 40
            r6 = 45
            r9.append(r6)
            goto L_0x0488
        L_0x02ee:
            r7 = 40
            r6 = 43
            r9.append(r6)
            goto L_0x0488
        L_0x02f7:
            r7 = 40
            r6 = 126(0x7e, float:1.77E-43)
            r9.append(r6)
            goto L_0x0488
        L_0x0300:
            r7 = 40
            r6 = 33
            r9.append(r6)
            goto L_0x0488
        L_0x0309:
            r7 = 40
            java.lang.String r6 = " % "
            r9.append(r6)
            goto L_0x0488
        L_0x0312:
            r7 = 40
            java.lang.String r6 = " / "
            r9.append(r6)
            goto L_0x0488
        L_0x031b:
            r7 = 40
            java.lang.String r6 = " * "
            r9.append(r6)
            goto L_0x0488
        L_0x0324:
            r7 = 40
            java.lang.String r6 = " - "
            r9.append(r6)
            goto L_0x0488
        L_0x032d:
            r7 = 40
            java.lang.String r6 = " + "
            r9.append(r6)
            goto L_0x0488
        L_0x0336:
            r7 = 40
            java.lang.String r6 = " >>> "
            r9.append(r6)
            goto L_0x0488
        L_0x033f:
            r7 = 40
            java.lang.String r6 = " >> "
            r9.append(r6)
            goto L_0x0488
        L_0x0348:
            r7 = 40
            java.lang.String r6 = " << "
            r9.append(r6)
            goto L_0x0488
        L_0x0351:
            r7 = 40
            java.lang.String r6 = " >= "
            r9.append(r6)
            goto L_0x0488
        L_0x035a:
            r7 = 40
            java.lang.String r6 = " > "
            r9.append(r6)
            goto L_0x0488
        L_0x0363:
            r7 = 40
            java.lang.String r6 = " <= "
            r9.append(r6)
            goto L_0x0488
        L_0x036c:
            r7 = 40
            java.lang.String r6 = " < "
            r9.append(r6)
            goto L_0x0488
        L_0x0375:
            r7 = 40
            java.lang.String r6 = " != "
            r9.append(r6)
            goto L_0x0488
        L_0x037e:
            r7 = 40
            java.lang.String r6 = " == "
            r9.append(r6)
            goto L_0x0488
        L_0x0387:
            r7 = 40
            java.lang.String r6 = " & "
            r9.append(r6)
            goto L_0x0488
        L_0x0390:
            r7 = 40
            java.lang.String r6 = " ^ "
            r9.append(r6)
            goto L_0x0488
        L_0x0399:
            r7 = 40
            java.lang.String r6 = " | "
            r9.append(r6)
            goto L_0x0488
        L_0x03a2:
            r7 = 40
            r6 = 64
            r9.append(r6)
            goto L_0x0488
        L_0x03ab:
            r7 = 40
            java.lang.String r6 = ".("
            r9.append(r6)
            goto L_0x0488
        L_0x03b4:
            r7 = 40
            java.lang.String r6 = "::"
            r9.append(r6)
            goto L_0x0488
        L_0x03bd:
            r7 = 40
            java.lang.String r6 = ".."
            r9.append(r6)
            goto L_0x0488
        L_0x03c6:
            r7 = 40
            java.lang.String r6 = " instanceof "
            r9.append(r6)
            goto L_0x0488
        L_0x03cf:
            r7 = 40
            java.lang.String r6 = " in "
            r9.append(r6)
            goto L_0x0488
        L_0x03d8:
            char r6 = r0.charAt(r13)
            r14 = 151(0x97, float:2.12E-43)
            if (r6 != r14) goto L_0x03e6
            java.lang.String r6 = "get "
            r9.append(r6)
            goto L_0x03f3
        L_0x03e6:
            char r6 = r0.charAt(r13)
            r14 = 152(0x98, float:2.13E-43)
            if (r6 != r14) goto L_0x03f3
            java.lang.String r6 = "set "
            r9.append(r6)
        L_0x03f3:
            int r13 = r13 + 1
            int r13 = r13 + r3
            r6 = 0
            int r13 = printSourceString(r0, r13, r6, r9)
            int r13 = r13 + r3
            goto L_0x0488
        L_0x03fe:
            r7 = 40
            java.lang.String r6 = "debugger;\n"
            r9.append(r6)
            goto L_0x0488
        L_0x0407:
            r7 = 40
            java.lang.String r6 = "yield "
            r9.append(r6)
            goto L_0x0488
        L_0x0410:
            r7 = 40
            java.lang.String r6 = ": "
            r9.append(r6)
            goto L_0x0488
        L_0x0419:
            r7 = 40
            java.lang.String r6 = "throw "
            r9.append(r6)
            goto L_0x0488
        L_0x0422:
            r7 = 40
            java.lang.String r6 = "return"
            r9.append(r6)
            r6 = 82
            int r14 = getNext(r0, r2, r13)
            if (r6 == r14) goto L_0x0488
            r9.append(r4)
            goto L_0x0488
        L_0x0435:
            r7 = 40
            if (r11 == 0) goto L_0x043a
            goto L_0x0488
        L_0x043a:
            r14 = 0
            if (r17 != 0) goto L_0x044b
            if (r10 == 0) goto L_0x0446
            r9.setLength(r14)
            int r5 = r5 - r8
            r16 = 0
            goto L_0x0448
        L_0x0446:
            r16 = 1
        L_0x0448:
            r17 = 1
            goto L_0x044d
        L_0x044b:
            r16 = 1
        L_0x044d:
            if (r16 == 0) goto L_0x0454
            r7 = 10
            r9.append(r7)
        L_0x0454:
            int r7 = r13 + 1
            if (r7 >= r2) goto L_0x0488
            char r7 = r0.charAt(r7)
            r14 = 115(0x73, float:1.61E-43)
            if (r7 == r14) goto L_0x047e
            r14 = 116(0x74, float:1.63E-43)
            if (r7 != r14) goto L_0x0465
            goto L_0x047e
        L_0x0465:
            r14 = 86
            if (r7 != r14) goto L_0x046a
            goto L_0x047a
        L_0x046a:
            if (r7 != r6) goto L_0x047c
            int r6 = r13 + 2
            int r6 = getSourceStringEnd(r0, r6)
            char r6 = r0.charAt(r6)
            r7 = 103(0x67, float:1.44E-43)
            if (r6 != r7) goto L_0x047c
        L_0x047a:
            r6 = r8
            goto L_0x0480
        L_0x047c:
            r6 = 0
            goto L_0x0480
        L_0x047e:
            int r6 = r8 - r1
        L_0x0480:
            if (r6 >= r5) goto L_0x0488
            r9.append(r4)
            int r6 = r6 + 1
            goto L_0x0480
        L_0x0488:
            int r13 = r13 + r3
            goto L_0x02c5
        L_0x048b:
            if (r11 != 0) goto L_0x0495
            if (r10 != 0) goto L_0x049d
            r0 = 10
            r9.append(r0)
            goto L_0x049d
        L_0x0495:
            r0 = 2
            if (r12 != r0) goto L_0x049d
            r0 = 41
            r9.append(r0)
        L_0x049d:
            java.lang.String r0 = r9.toString()
            return r0
        L_0x04a2:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x04a8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        L_0x04ae:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.Decompiler.decompile(java.lang.String, int, org.mozilla.javascript.UintMap):java.lang.String");
    }

    private static int getNext(String str, int i, int i2) {
        int i3 = i2 + 1;
        if (i3 < i) {
            return str.charAt(i3);
        }
        return 0;
    }

    private static int getSourceStringEnd(String str, int i) {
        return printSourceString(str, i, false, (StringBuilder) null);
    }

    private static int printSourceString(String str, int i, boolean z, StringBuilder sb) {
        char charAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & charAt) != 0) {
            charAt = ((charAt & 32767) << 16) | str.charAt(i2);
            i2++;
        }
        if (sb != null) {
            String substring = str.substring(i2, i2 + charAt);
            if (!z) {
                sb.append(substring);
            } else {
                sb.append(Typography.quote);
                sb.append(ScriptRuntime.escapeString(substring));
                sb.append(Typography.quote);
            }
        }
        return i2 + charAt;
    }

    private static int printSourceNumber(String str, int i, StringBuilder sb) {
        int i2;
        char charAt = str.charAt(i);
        int i3 = i + 1;
        double d = 0.0d;
        if (charAt == 'S') {
            if (sb != null) {
                d = (double) str.charAt(i3);
            }
            i2 = i3 + 1;
        } else if (charAt == 'J' || charAt == 'D') {
            if (sb != null) {
                long charAt2 = (((long) str.charAt(i3)) << 48) | (((long) str.charAt(i3 + 1)) << 32) | (((long) str.charAt(i3 + 2)) << 16) | ((long) str.charAt(i3 + 3));
                if (charAt == 'J') {
                    d = (double) charAt2;
                } else {
                    d = Double.longBitsToDouble(charAt2);
                }
            }
            i2 = i3 + 4;
        } else {
            throw new RuntimeException();
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(d, 10));
        }
        return i2;
    }
}
