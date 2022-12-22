package org.xidea.p087el.json;

import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p071io.IOUtils;
import org.xidea.p087el.ExpressionSyntaxException;

/* renamed from: org.xidea.el.json.JSONTokenizer */
public class JSONTokenizer {
    protected final int end;
    protected int start;
    private boolean strict = false;
    protected String value;

    /* access modifiers changed from: protected */
    public char toLower(char c) {
        return (c < 65281 || c > 65374) ? c : (char) (c - 65248);
    }

    public JSONTokenizer(String str, boolean z) {
        String trim = str.trim();
        this.value = trim;
        if (trim.startsWith("﻿")) {
            this.value = this.value.substring(1);
        }
        this.end = this.value.length();
        this.strict = z;
    }

    /* access modifiers changed from: protected */
    public Object parse() {
        skipComment();
        char lower = toLower(this.value.charAt(this.start));
        if (lower == '\"' || lower == '\'') {
            return findString();
        }
        if (lower == '[') {
            return findList();
        }
        if (lower == '{') {
            return findMap();
        }
        if (lower == '-' || (lower >= '0' && lower <= '9')) {
            return findNumber();
        }
        String findId = findId();
        if ("true".equals(findId)) {
            return Boolean.TRUE;
        }
        if (SDKConsts.BOOLEAN_FALSE.equals(findId)) {
            return Boolean.FALSE;
        }
        if ("null".equals(findId)) {
            return null;
        }
        throw buildError("");
    }

    /* access modifiers changed from: protected */
    public ExpressionSyntaxException buildError(String str) {
        return new ExpressionSyntaxException("语法错误:" + str + "\n" + this.value + "@" + this.start);
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> findMap() {
        String str;
        this.start++;
        skipComment();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.value.charAt(this.start) == '}') {
            this.start++;
            return linkedHashMap;
        }
        while (true) {
            if (this.value.charAt(this.start) == '\"') {
                str = findString();
            } else {
                str = findId();
            }
            skipComment();
            String str2 = this.value;
            int i = this.start;
            this.start = i + 1;
            if (str2.charAt(i) == ':') {
                Object parse = parse();
                skipComment();
                String str3 = this.value;
                int i2 = this.start;
                this.start = i2 + 1;
                char charAt = str3.charAt(i2);
                if (charAt == '}') {
                    linkedHashMap.put(str, parse);
                    return linkedHashMap;
                } else if (charAt == ',') {
                    linkedHashMap.put(str, parse);
                    skipComment();
                } else {
                    throw buildError("无效对象语法");
                }
            } else {
                throw buildError("无效对象语法");
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<Object> findList() {
        ArrayList arrayList = new ArrayList();
        this.start++;
        skipComment();
        if (this.value.charAt(this.start) == ']') {
            this.start++;
            return arrayList;
        }
        arrayList.add(parse());
        while (true) {
            skipComment();
            String str = this.value;
            int i = this.start;
            this.start = i + 1;
            char charAt = str.charAt(i);
            if (charAt == ']') {
                return arrayList;
            }
            if (charAt == ',') {
                skipComment();
                arrayList.add(parse());
            } else {
                throw buildError("无效数组语法:");
            }
        }
    }

    private long parseHex() {
        long j;
        int i;
        int i2;
        long j2 = 0;
        while (true) {
            int i3 = this.start;
            if (i3 >= this.end) {
                break;
            }
            String str = this.value;
            this.start = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j = j2 << 4;
                    i = charAt - 'A';
                } else if (charAt < 'a' || charAt > 'f') {
                    this.start--;
                } else {
                    j = j2 << 4;
                    i = charAt - 'a';
                }
                i2 = i + 10;
            } else {
                j = j2 << 4;
                i2 = charAt - '0';
            }
            j2 = j + ((long) i2);
        }
        this.start--;
        return j2;
    }

    private int parseOctal() {
        int i = 0;
        while (true) {
            int i2 = this.start;
            if (i2 >= this.end) {
                break;
            }
            String str = this.value;
            this.start = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt >= '8') {
                this.start--;
            } else {
                i = (i << 3) + (charAt - '0');
            }
        }
        this.start--;
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekDecimal() {
        /*
            r3 = this;
        L_0x0000:
            int r0 = r3.start
            int r1 = r3.end
            if (r0 < r1) goto L_0x0007
            goto L_0x001f
        L_0x0007:
            java.lang.String r1 = r3.value
            int r2 = r0 + 1
            r3.start = r2
            char r0 = r1.charAt(r0)
            r1 = 48
            if (r0 < r1) goto L_0x0019
            r1 = 57
            if (r0 <= r1) goto L_0x0000
        L_0x0019:
            int r0 = r3.start
            int r0 = r0 + -1
            r3.start = r0
        L_0x001f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.json.JSONTokenizer.seekDecimal():void");
    }

    private void seekNegative() {
        String str = this.value;
        int i = this.start;
        this.start = i + 1;
        char charAt = str.charAt(i);
        if (charAt != '-' && charAt != '+') {
            this.start--;
        }
    }

    private Number parseZero(boolean z) {
        int i = this.start;
        if (i >= this.end) {
            return 0;
        }
        String str = this.value;
        this.start = i + 1;
        char charAt = str.charAt(i);
        if (charAt == 'x' || charAt == 'X') {
            if (!this.strict) {
                long parseHex = parseHex();
                if (z) {
                    parseHex = -parseHex;
                }
                return Long.valueOf(parseHex);
            }
            throw buildError("JSON未定义16进制数字");
        } else if (charAt <= '0' || charAt > '7') {
            if (charAt == '.') {
                int i2 = this.start - 1;
                this.start = i2;
                return parseFloat(i2 - 1);
            }
            this.start--;
            return 0;
        } else if (!this.strict) {
            this.start--;
            int parseOctal = parseOctal();
            if (z) {
                parseOctal = -parseOctal;
            }
            return Integer.valueOf(parseOctal);
        } else {
            throw buildError("JSON未定义8进制数字");
        }
    }

    private Number parseFloat(int i) {
        char charAt = this.value.charAt(this.start);
        boolean z = false;
        boolean z2 = true;
        if (charAt == '.') {
            int i2 = this.start + 1;
            this.start = i2;
            seekDecimal();
            int i3 = this.start;
            if (i3 == i2) {
                int i4 = i3 - 1;
                this.start = i4;
                return Long.valueOf(Long.parseLong(this.value.substring(i, i4)));
            }
            charAt = i3 < this.end ? this.value.charAt(i3) : 0;
            z = true;
        }
        if (charAt == 'E' || charAt == 'e') {
            this.start++;
            seekNegative();
            seekDecimal();
        } else {
            z2 = z;
        }
        String substring = this.value.substring(i, this.start);
        if (z2) {
            return Double.valueOf(Double.parseDouble(substring));
        }
        return Long.valueOf(Long.parseLong(substring));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        if (r1 == '.') goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0061, code lost:
        if (r1 != 'E') goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0064, code lost:
        r9.start--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        r9.start--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007a, code lost:
        return parseFloat(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Number findNumber() {
        /*
            r9 = this;
            int r0 = r9.start
            java.lang.String r1 = r9.value
            int r2 = r0 + 1
            r9.start = r2
            char r1 = r1.charAt(r0)
            r2 = 1
            r3 = 0
            r4 = 43
            if (r1 != r4) goto L_0x001f
            java.lang.String r1 = r9.value
            int r4 = r9.start
            int r5 = r4 + 1
            r9.start = r5
            char r1 = r1.charAt(r4)
            goto L_0x0030
        L_0x001f:
            r4 = 45
            if (r1 != r4) goto L_0x0030
            java.lang.String r1 = r9.value
            int r3 = r9.start
            int r4 = r3 + 1
            r9.start = r4
            char r1 = r1.charAt(r3)
            r3 = 1
        L_0x0030:
            r4 = 48
            if (r1 != r4) goto L_0x0039
            java.lang.Number r0 = r9.parseZero(r3)
            return r0
        L_0x0039:
            int r1 = r1 - r4
            long r5 = (long) r1
        L_0x003b:
            int r1 = r9.start
            int r7 = r9.end
            if (r1 < r7) goto L_0x0042
            goto L_0x0069
        L_0x0042:
            java.lang.String r7 = r9.value
            int r8 = r1 + 1
            r9.start = r8
            char r1 = r7.charAt(r1)
            if (r1 < r4) goto L_0x005b
            r7 = 57
            if (r1 > r7) goto L_0x005b
            r7 = 10
            long r5 = r5 * r7
            int r1 = r1 + -48
            long r7 = (long) r1
            long r5 = r5 + r7
            goto L_0x003b
        L_0x005b:
            r4 = 46
            if (r1 == r4) goto L_0x0071
            r4 = 69
            if (r1 != r4) goto L_0x0064
            goto L_0x0071
        L_0x0064:
            int r0 = r9.start
            int r0 = r0 - r2
            r9.start = r0
        L_0x0069:
            if (r3 == 0) goto L_0x006c
            long r5 = -r5
        L_0x006c:
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            return r0
        L_0x0071:
            int r1 = r9.start
            int r1 = r1 - r2
            r9.start = r1
            java.lang.Number r0 = r9.parseFloat(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.json.JSONTokenizer.findNumber():java.lang.Number");
    }

    /* access modifiers changed from: protected */
    public String findId() {
        int i = this.start;
        int i2 = i + 1;
        if (Character.isJavaIdentifierPart(this.value.charAt(i))) {
            while (i2 < this.end && Character.isJavaIdentifierPart(this.value.charAt(i2))) {
                i2++;
            }
            String str = this.value;
            int i3 = this.start;
            this.start = i2;
            return str.substring(i3, i2);
        }
        throw buildError("无效id");
    }

    /* access modifiers changed from: protected */
    public String findString() {
        String str = this.value;
        int i = this.start;
        this.start = i + 1;
        char charAt = str.charAt(i);
        if (!this.strict || charAt != '\'') {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int i2 = this.start;
                if (i2 < this.end) {
                    String str2 = this.value;
                    this.start = i2 + 1;
                    char charAt2 = str2.charAt(i2);
                    if (!(charAt2 == 10 || charAt2 == 13)) {
                        if (charAt2 != '\"' && charAt2 != '\'') {
                            if (charAt2 == '\\') {
                                String str3 = this.value;
                                int i3 = this.start;
                                this.start = i3 + 1;
                                char charAt3 = str3.charAt(i3);
                                if (charAt3 == ' ') {
                                    sb.append(' ');
                                } else if (charAt3 == '\"') {
                                    sb.append(Typography.quote);
                                } else if (charAt3 == '\'') {
                                    sb.append('\'');
                                } else if (charAt3 == '/') {
                                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                                } else if (charAt3 == '\\') {
                                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                                } else if (charAt3 == 'b') {
                                    sb.append(8);
                                } else if (charAt3 == 'f') {
                                    sb.append(12);
                                } else if (charAt3 == 'n') {
                                    sb.append(10);
                                } else if (charAt3 == 'r') {
                                    sb.append(CharUtils.f5620CR);
                                } else if (charAt3 != 'x') {
                                    switch (charAt3) {
                                        case 't':
                                            sb.append(9);
                                            break;
                                        case 'u':
                                            String str4 = this.value;
                                            int i4 = this.start;
                                            sb.append((char) Integer.parseInt(str4.substring(i4, i4 + 4), 16));
                                            this.start += 4;
                                            break;
                                        case 'v':
                                            sb.append(11);
                                            break;
                                        default:
                                            if (!this.strict) {
                                                sb.append(charAt2);
                                                sb.append(charAt3);
                                                break;
                                            } else {
                                                throw buildError("发现JSON 标准未定义转义字符");
                                            }
                                    }
                                } else {
                                    String str5 = this.value;
                                    int i5 = this.start;
                                    sb.append((char) Integer.parseInt(str5.substring(i5, i5 + 2), 16));
                                    this.start += 2;
                                }
                            }
                            sb.append(charAt2);
                        } else if (charAt2 == charAt) {
                            return sb.toString();
                        }
                    }
                    if (this.strict) {
                        throw buildError("JSON 标准字符串不能换行");
                    }
                    sb.append(charAt2);
                } else {
                    throw buildError("未结束字符串");
                }
            }
        } else {
            throw buildError("JSON标准 字符串应该是双引号\"...\")");
        }
    }

    /* access modifiers changed from: protected */
    public void skipComment() {
        while (true) {
            int i = this.start;
            if (i < this.end && Character.isWhitespace(this.value.charAt(i))) {
                this.start++;
            } else {
                int i2 = this.start;
                if (i2 < this.end && this.value.charAt(i2) == '/') {
                    if (!this.strict) {
                        int i3 = this.start + 1;
                        this.start = i3;
                        String str = this.value;
                        this.start = i3 + 1;
                        char charAt = str.charAt(i3);
                        if (charAt == '/') {
                            int indexOf = this.value.indexOf(10, this.start);
                            int indexOf2 = this.value.indexOf(13, this.start);
                            int min = Math.min(indexOf, indexOf2);
                            if (min < 0) {
                                min = Math.max(indexOf, indexOf2);
                            }
                            if (min > 0) {
                                this.start = min;
                            } else {
                                this.start = this.end;
                            }
                        } else if (charAt == '*') {
                            int i4 = this.start;
                            do {
                                i4 = this.value.indexOf(47, i4 + 1);
                                if (i4 <= 0) {
                                    throw buildError("未結束注釋");
                                }
                            } while (this.value.charAt(i4 - 1) != '*');
                            this.start = i4 + 1;
                        } else {
                            continue;
                        }
                    } else {
                        throw buildError("JSON 标准未定义注释");
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean skipSpace(int i) {
        int i2;
        while (true) {
            int i3 = this.start;
            if (i3 < this.end && Character.isWhitespace(this.value.charAt(i3))) {
                this.start++;
            }
        }
        if (i <= 0 || (i2 = this.start) >= this.end || i != this.value.charAt(i2)) {
            return false;
        }
        return true;
    }
}
