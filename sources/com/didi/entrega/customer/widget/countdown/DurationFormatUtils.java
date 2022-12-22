package com.didi.entrega.customer.widget.countdown;

import androidx.exifinterface.media.ExifInterface;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.raven.config.RavenKey;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DurationFormatUtils {
    public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";

    /* renamed from: a */
    static final Object f20388a = SameLayerRenderingUtil.KEY_COMP_Y;

    /* renamed from: b */
    static final Object f20389b = "M";

    /* renamed from: c */
    static final Object f20390c = "d";

    /* renamed from: d */
    static final Object f20391d = "H";

    /* renamed from: e */
    static final Object f20392e = "m";

    /* renamed from: f */
    static final Object f20393f = RavenKey.STACK;

    /* renamed from: g */
    static final Object f20394g = ExifInterface.LATITUDE_SOUTH;

    public static String formatDurationHMS(long j) {
        return formatDuration(j, "H:mm:ss.SSS");
    }

    public static String formatDurationISO(long j) {
        return formatDuration(j, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
    }

    public static String formatDuration(long j, String str) {
        return formatDuration(j, str, true);
    }

    public static String formatDuration(long j, String str, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        Token[] a = m14938a(str);
        if (Token.containsTokenWithValue(a, f20390c)) {
            int i5 = (int) (j / 86400000);
            j -= ((long) i5) * 86400000;
            i = i5;
        } else {
            i = 0;
        }
        if (Token.containsTokenWithValue(a, f20391d)) {
            int i6 = (int) (j / 3600000);
            j -= ((long) i6) * 3600000;
            i2 = i6;
        } else {
            i2 = 0;
        }
        if (Token.containsTokenWithValue(a, f20392e)) {
            int i7 = (int) (j / 60000);
            j -= ((long) i7) * 60000;
            i3 = i7;
        } else {
            i3 = 0;
        }
        if (Token.containsTokenWithValue(a, f20393f)) {
            int i8 = (int) (j / 1000);
            j -= ((long) i8) * 1000;
            i4 = i8;
        } else {
            i4 = 0;
        }
        return m14937a(a, 0, 0, i, i2, i3, i4, Token.containsTokenWithValue(a, f20394g) ? (int) j : 0, z);
    }

    public static String formatDurationWords(long j, boolean z, boolean z2) {
        String formatDuration = formatDuration(j, "d' days 'H' hours 'm' minutes 's' seconds'");
        if (z) {
            formatDuration = " " + formatDuration;
            String replaceOnce = replaceOnce(formatDuration, " 0 days", "");
            if (replaceOnce.length() != formatDuration.length()) {
                String replaceOnce2 = replaceOnce(replaceOnce, " 0 hours", "");
                if (replaceOnce2.length() != replaceOnce.length()) {
                    formatDuration = replaceOnce(replaceOnce2, " 0 minutes", "");
                    if (formatDuration.length() != formatDuration.length()) {
                        formatDuration = replaceOnce(formatDuration, " 0 seconds", "");
                    }
                } else {
                    formatDuration = replaceOnce;
                }
            }
            if (formatDuration.length() != 0) {
                formatDuration = formatDuration.substring(1);
            }
        }
        if (z2) {
            String replaceOnce3 = replaceOnce(formatDuration, " 0 seconds", "");
            if (replaceOnce3.length() != formatDuration.length()) {
                formatDuration = replaceOnce(replaceOnce3, " 0 minutes", "");
                if (formatDuration.length() != replaceOnce3.length()) {
                    String replaceOnce4 = replaceOnce(formatDuration, " 0 hours", "");
                    if (replaceOnce4.length() != formatDuration.length()) {
                        formatDuration = replaceOnce(replaceOnce4, " 0 days", "");
                    }
                } else {
                    formatDuration = replaceOnce3;
                }
            }
        }
        return replaceOnce(replaceOnce(replaceOnce(replaceOnce(" " + formatDuration, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }

    public static String formatPeriodISO(long j, long j2) {
        return formatPeriod(j, j2, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str) {
        return formatPeriod(j, j2, str, true, TimeZone.getDefault());
    }

    public static String formatPeriod(long j, long j2, String str, boolean z, TimeZone timeZone) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j3 = j;
        long j4 = j2;
        long j5 = j4 - j3;
        if (j5 < 2419200000L) {
            return formatDuration(j5, str, z);
        }
        String str2 = str;
        boolean z2 = z;
        Token[] a = m14938a(str);
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(new Date(j3));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.setTime(new Date(j4));
        int i6 = instance2.get(14) - instance.get(14);
        int i7 = instance2.get(13) - instance.get(13);
        int i8 = instance2.get(12) - instance.get(12);
        int i9 = instance2.get(11) - instance.get(11);
        int i10 = instance2.get(5) - instance.get(5);
        int i11 = instance2.get(2) - instance.get(2);
        int i12 = instance2.get(1) - instance.get(1);
        while (i6 < 0) {
            i6 += 1000;
            i7--;
        }
        while (i7 < 0) {
            i7 += 60;
            i8--;
        }
        while (i8 < 0) {
            i8 += 60;
            i9--;
        }
        while (i9 < 0) {
            i9 += 24;
            i10--;
        }
        while (i10 < 0) {
            i10 += 31;
            i11--;
        }
        int i13 = i12;
        while (i11 < 0) {
            i11 += 12;
            i13--;
        }
        int a2 = i6 - m14935a(instance, instance2, 14, i6);
        int a3 = i7 - m14935a(instance, instance2, 13, i7);
        int a4 = i8 - m14935a(instance, instance2, 12, i8);
        int a5 = i9 - m14935a(instance, instance2, 11, i9);
        int a6 = i10 - m14935a(instance, instance2, 5, i10);
        int a7 = i11 - m14935a(instance, instance2, 2, i11);
        int a8 = i13 - m14935a(instance, instance2, 1, i13);
        if (!Token.containsTokenWithValue(a, f20388a)) {
            if (Token.containsTokenWithValue(a, f20389b)) {
                a7 += a8 * 12;
            } else {
                a6 += a8 * 365;
            }
            i = 0;
        } else {
            i = a8;
        }
        if (!Token.containsTokenWithValue(a, f20389b)) {
            a6 += instance2.get(6) - instance.get(6);
            a7 = 0;
        }
        if (!Token.containsTokenWithValue(a, f20390c)) {
            a5 += a6 * 24;
            i2 = 0;
        } else {
            i2 = a6;
        }
        if (!Token.containsTokenWithValue(a, f20391d)) {
            a4 += a5 * 60;
            a5 = 0;
        }
        if (!Token.containsTokenWithValue(a, f20392e)) {
            a3 += a4 * 60;
            i3 = 0;
        } else {
            i3 = a4;
        }
        if (!Token.containsTokenWithValue(a, f20393f)) {
            i4 = a2 + (a3 * 1000);
            i5 = 0;
        } else {
            i4 = a2;
            i5 = a3;
        }
        return m14937a(a, i, a7, i2, a5, i3, i5, i4, z);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replace(String str, String str2, String str3, int i) {
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i == 0) {
            return str;
        }
        int i2 = 0;
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        int length = str2.length();
        int length2 = str3.length() - length;
        if (length2 < 0) {
            length2 = 0;
        }
        int i3 = 64;
        if (i < 0) {
            i3 = 16;
        } else if (i <= 64) {
            i3 = i;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + (length2 * i3));
        while (indexOf != -1) {
            stringBuffer.append(str.substring(i2, indexOf));
            stringBuffer.append(str3);
            i2 = indexOf + length;
            i--;
            if (i == 0) {
                break;
            }
            indexOf = str.indexOf(str2, i2);
        }
        stringBuffer.append(str.substring(i2));
        return stringBuffer.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return m14936a(i, str.charAt(0));
        }
        int i2 = length * i;
        if (length == 1) {
            char charAt = str.charAt(0);
            char[] cArr = new char[i2];
            for (int i3 = i - 1; i3 >= 0; i3--) {
                cArr[i3] = charAt;
            }
            return new String(cArr);
        } else if (length != 2) {
            StringBuffer stringBuffer = new StringBuffer(i2);
            for (int i4 = 0; i4 < i; i4++) {
                stringBuffer.append(str);
            }
            return stringBuffer.toString();
        } else {
            char charAt2 = str.charAt(0);
            char charAt3 = str.charAt(1);
            char[] cArr2 = new char[i2];
            for (int i5 = (i * 2) - 2; i5 >= 0; i5 = (i5 - 1) - 1) {
                cArr2[i5] = charAt2;
                cArr2[i5 + 1] = charAt3;
            }
            return new String(cArr2);
        }
    }

    public static String leftPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c));
        }
        return m14936a(length, c).concat(str);
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = " ";
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    /* renamed from: a */
    static String m14937a(Token[] tokenArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        StringBuffer stringBuffer = new StringBuffer();
        int i8 = i7;
        boolean z2 = false;
        for (Token token : tokenArr) {
            Object value = token.getValue();
            int count = token.getCount();
            if (value instanceof StringBuffer) {
                stringBuffer.append(value.toString());
            } else {
                if (value == f20388a) {
                    if (z) {
                        str8 = leftPad(Integer.toString(i), count, '0');
                    } else {
                        str8 = Integer.toString(i);
                    }
                    stringBuffer.append(str8);
                } else if (value == f20389b) {
                    if (z) {
                        str7 = leftPad(Integer.toString(i2), count, '0');
                    } else {
                        str7 = Integer.toString(i2);
                    }
                    stringBuffer.append(str7);
                } else if (value == f20390c) {
                    if (z) {
                        str6 = leftPad(Integer.toString(i3), count, '0');
                    } else {
                        str6 = Integer.toString(i3);
                    }
                    stringBuffer.append(str6);
                } else if (value == f20391d) {
                    if (z) {
                        str5 = leftPad(Integer.toString(i4), count, '0');
                    } else {
                        str5 = Integer.toString(i4);
                    }
                    stringBuffer.append(str5);
                } else if (value == f20392e) {
                    if (z) {
                        str4 = leftPad(Integer.toString(i5), count, '0');
                    } else {
                        str4 = Integer.toString(i5);
                    }
                    stringBuffer.append(str4);
                } else if (value == f20393f) {
                    if (z) {
                        str3 = leftPad(Integer.toString(i6), count, '0');
                    } else {
                        str3 = Integer.toString(i6);
                    }
                    stringBuffer.append(str3);
                    z2 = true;
                } else if (value == f20394g) {
                    if (z2) {
                        i8 += 1000;
                        if (z) {
                            str2 = leftPad(Integer.toString(i8), count, '0');
                        } else {
                            str2 = Integer.toString(i8);
                        }
                        stringBuffer.append(str2.substring(1));
                    } else {
                        if (z) {
                            str = leftPad(Integer.toString(i8), count, '0');
                        } else {
                            str = Integer.toString(i8);
                        }
                        stringBuffer.append(str);
                    }
                }
                z2 = false;
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static int m14935a(Calendar calendar, Calendar calendar2, int i, int i2) {
        calendar2.add(i, i2 * -1);
        int i3 = calendar2.get(i);
        int i4 = calendar.get(i);
        if (i3 >= i4) {
            return 0;
        }
        int i5 = i4 - i3;
        calendar2.add(i, i5);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0093 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.didi.entrega.customer.widget.countdown.DurationFormatUtils.Token[] m14938a(java.lang.String r10) {
        /*
            char[] r10 = r10.toCharArray()
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r10.length
            r0.<init>(r1)
            int r1 = r10.length
            r2 = 0
            r3 = 0
            r6 = r3
            r7 = r6
            r4 = 0
            r5 = 0
        L_0x0011:
            if (r4 >= r1) goto L_0x0097
            char r8 = r10[r4]
            r9 = 39
            if (r5 == 0) goto L_0x0020
            if (r8 == r9) goto L_0x0020
            r6.append(r8)
            goto L_0x0093
        L_0x0020:
            if (r8 == r9) goto L_0x0066
            r9 = 72
            if (r8 == r9) goto L_0x0063
            r9 = 77
            if (r8 == r9) goto L_0x0060
            r9 = 83
            if (r8 == r9) goto L_0x005d
            r9 = 100
            if (r8 == r9) goto L_0x005a
            r9 = 109(0x6d, float:1.53E-43)
            if (r8 == r9) goto L_0x0057
            r9 = 115(0x73, float:1.61E-43)
            if (r8 == r9) goto L_0x0054
            r9 = 121(0x79, float:1.7E-43)
            if (r8 == r9) goto L_0x0051
            if (r6 != 0) goto L_0x004d
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token r9 = new com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token
            r9.<init>(r6)
            r0.add(r9)
        L_0x004d:
            r6.append(r8)
            goto L_0x007a
        L_0x0051:
            java.lang.Object r8 = f20388a
            goto L_0x007b
        L_0x0054:
            java.lang.Object r8 = f20393f
            goto L_0x007b
        L_0x0057:
            java.lang.Object r8 = f20392e
            goto L_0x007b
        L_0x005a:
            java.lang.Object r8 = f20390c
            goto L_0x007b
        L_0x005d:
            java.lang.Object r8 = f20394g
            goto L_0x007b
        L_0x0060:
            java.lang.Object r8 = f20389b
            goto L_0x007b
        L_0x0063:
            java.lang.Object r8 = f20391d
            goto L_0x007b
        L_0x0066:
            if (r5 == 0) goto L_0x006c
            r6 = r3
            r8 = r6
            r5 = 0
            goto L_0x007b
        L_0x006c:
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token r5 = new com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token
            r5.<init>(r6)
            r0.add(r5)
            r5 = 1
        L_0x007a:
            r8 = r3
        L_0x007b:
            if (r8 == 0) goto L_0x0093
            if (r7 == 0) goto L_0x0089
            java.lang.Object r6 = r7.getValue()
            if (r6 != r8) goto L_0x0089
            r7.increment()
            goto L_0x0092
        L_0x0089:
            com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token r6 = new com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token
            r6.<init>(r8)
            r0.add(r6)
            r7 = r6
        L_0x0092:
            r6 = r3
        L_0x0093:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0097:
            com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token[] r10 = new com.didi.entrega.customer.widget.countdown.DurationFormatUtils.Token[r2]
            java.lang.Object[] r10 = r0.toArray(r10)
            com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token[] r10 = (com.didi.entrega.customer.widget.countdown.DurationFormatUtils.Token[]) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.widget.countdown.DurationFormatUtils.m14938a(java.lang.String):com.didi.entrega.customer.widget.countdown.DurationFormatUtils$Token[]");
    }

    /* renamed from: a */
    private static String m14936a(int i, char c) throws IndexOutOfBoundsException {
        if (i >= 0) {
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = c;
            }
            return new String(cArr);
        }
        throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + i);
    }

    public static class Token {
        private int count;
        private Object value;

        Token(Object obj) {
            this.value = obj;
            this.count = 1;
        }

        Token(Object obj, int i) {
            this.value = obj;
            this.count = i;
        }

        static boolean containsTokenWithValue(Token[] tokenArr, Object obj) {
            for (Token value2 : tokenArr) {
                if (value2.getValue() == obj) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.value.getClass() != token.value.getClass() || this.count != token.count) {
                return false;
            }
            Object obj2 = this.value;
            if (obj2 instanceof StringBuffer) {
                return obj2.toString().equals(token.value.toString());
            }
            if (obj2 instanceof Number) {
                return obj2.equals(token.value);
            }
            if (obj2 == token.value) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return DurationFormatUtils.repeat(this.value.toString(), this.count);
        }

        /* access modifiers changed from: package-private */
        public void increment() {
            this.count++;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* access modifiers changed from: package-private */
        public Object getValue() {
            return this.value;
        }
    }
}
