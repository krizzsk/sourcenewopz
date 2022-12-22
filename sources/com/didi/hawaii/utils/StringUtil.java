package com.didi.hawaii.utils;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isMatched(String str, String str2) {
        return (str2 == null || str == null || str2.indexOf(str) != 0) ? false : true;
    }

    public static boolean isContains(String str, String str2) {
        if (str2 == null || str == null) {
            return false;
        }
        return str2.toLowerCase().contains(str.toLowerCase());
    }

    public static CharSequence buildMulColorText(String[] strArr, int[] iArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strArr[i]);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(iArr[i]), 0, spannableStringBuilder2.length(), 33);
            spannableStringBuilder.append(spannableStringBuilder2);
        }
        return spannableStringBuilder;
    }

    public static String toUTF8(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String fromUTF8(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String toGBK(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "gbk");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(256);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean isWordLikeMyLocation(String str) {
        if (isEmpty(str)) {
            return false;
        }
        if (str.equals("我的位置") || str.equals("当前位置") || str.equals("我在哪") || str.equals("我在哪儿") || str.equals("我在的位置") || str.equals("我的位置在哪") || str.equals("我的位置在哪儿")) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(String str) {
        try {
            return Pattern.compile("[0-9]*").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static int compareVersion(String str, String str2) {
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int i = 0;
            while (true) {
                if (i < (split.length > split2.length ? split2.length : split.length)) {
                    int intValue = Integer.valueOf(split[i]).intValue() - Integer.valueOf(split2[i]).intValue();
                    if (intValue != 0) {
                        return intValue;
                    }
                    i++;
                } else if (split.length != split2.length) {
                    return split.length - split2.length;
                } else {
                    return 0;
                }
            }
        } catch (NullPointerException unused) {
            if (str == null && str2 != null) {
                return -1;
            }
            if (str == null || str2 != null) {
                return 0;
            }
            return 1;
        }
    }

    public static String toDateFormat(long j) {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(Long.valueOf(j));
    }

    public static int StringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long stringToLong(String str) {
        try {
            return (long) Double.parseDouble(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static double stringToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static String halfToFull(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                charArray[i] = 12288;
            } else if ((charArray[i] > ' ' && charArray[i] <= '/') || ((charArray[i] >= ':' && charArray[i] <= '?') || (charArray[i] >= '{' && charArray[i] <= '~'))) {
                charArray[i] = (char) (charArray[i] + 65248);
            }
        }
        return new String(charArray);
    }

    public static String fullToHalf(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 12288) {
                charArray[i] = ' ';
            } else if (charArray[i] > 65280 && charArray[i] < 65375) {
                charArray[i] = (char) (charArray[i] - 65248);
            }
        }
        return new String(charArray);
    }

    public static int getLength(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static String unicodeToString(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append((char) i);
        }
        return sb.toString();
    }
}
