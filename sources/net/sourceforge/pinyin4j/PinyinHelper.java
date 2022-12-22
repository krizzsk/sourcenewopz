package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinHelper {
    public static String[] toHanyuPinyinStringArray(char c) {
        return m3279a(c);
    }

    public static String[] toHanyuPinyinStringArray(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        return m3281a(c, hanyuPinyinOutputFormat);
    }

    /* renamed from: a */
    private static String[] m3281a(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String[] a = m3279a(c);
        if (a == null) {
            return null;
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = C2403b.m3290a(a[i], hanyuPinyinOutputFormat);
        }
        return a;
    }

    /* renamed from: a */
    private static String[] m3279a(char c) {
        return ChineseToPinyinResource.m3268a().mo24519a(c);
    }

    public static String[] toTongyongPinyinStringArray(char c) {
        return m3280a(c, C2405d.f5062e);
    }

    public static String[] toWadeGilesPinyinStringArray(char c) {
        return m3280a(c, C2405d.f5059b);
    }

    public static String[] toMPS2PinyinStringArray(char c) {
        return m3280a(c, C2405d.f5060c);
    }

    public static String[] toYalePinyinStringArray(char c) {
        return m3280a(c, C2405d.f5061d);
    }

    /* renamed from: a */
    private static String[] m3280a(char c, C2405d dVar) {
        String[] a = m3279a(c);
        if (a == null) {
            return null;
        }
        String[] strArr = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            strArr[i] = C2404c.m3291a(a[i], C2405d.f5058a, dVar);
        }
        return strArr;
    }

    public static String[] toGwoyeuRomatzyhStringArray(char c) {
        return m3283b(c);
    }

    /* renamed from: b */
    private static String[] m3283b(char c) {
        String[] a = m3279a(c);
        if (a == null) {
            return null;
        }
        String[] strArr = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            strArr[i] = C2402a.m3288a(a[i]);
        }
        return strArr;
    }

    public static String toHanyuPinyinString(String str, HanyuPinyinOutputFormat hanyuPinyinOutputFormat, String str2) throws BadHanyuPinyinOutputFormatCombination {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            String b = m3282b(str.charAt(i), hanyuPinyinOutputFormat);
            if (b != null) {
                stringBuffer.append(b);
                if (i != str.length() - 1) {
                    stringBuffer.append(str2);
                }
            } else {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private static String m3282b(char c, HanyuPinyinOutputFormat hanyuPinyinOutputFormat) throws BadHanyuPinyinOutputFormatCombination {
        String[] a = m3281a(c, hanyuPinyinOutputFormat);
        if (a == null || a.length <= 0) {
            return null;
        }
        return a[0];
    }

    private PinyinHelper() {
    }
}
