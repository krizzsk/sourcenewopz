package org.xidea.p087el.p088fn;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xidea.p087el.Invocable;

/* renamed from: org.xidea.el.fn.JSString */
class JSString extends JSObject implements Invocable {
    JSString() {
    }

    public String fromCharCode(String str, Object[] objArr) {
        int length = objArr.length;
        char[] cArr = new char[length];
        int i = length - 1;
        while (i >= 0) {
            cArr[i] = (char) ECMA262Impl.ToNumber(objArr[i]).intValue();
        }
        return new String(cArr);
    }

    public char charAt(String str, int i) {
        return str.charAt(i);
    }

    public int charCodeAt(String str, int i) {
        return str.charAt(i);
    }

    public String concat(String str, Object[] objArr) {
        StringBuilder sb = new StringBuilder(str);
        int length = objArr.length - 1;
        while (length >= 0) {
            sb.append(ECMA262Impl.ToString(objArr[length]));
        }
        return sb.toString();
    }

    public int indexOf(String str, String str2, int i) {
        return str.indexOf(str2, i);
    }

    public int lastIndexOf(String str, Object[] objArr) {
        if (objArr.length > 1) {
            return str.lastIndexOf(ECMA262Impl.ToString(objArr[0]), ECMA262Impl.ToNumber(objArr[0]).intValue());
        }
        return str.lastIndexOf(ECMA262Impl.ToString(objArr[0]));
    }

    public String replace(String str, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return str;
        }
        String valueOf = String.valueOf(JSObject.getStringArg(objArr, 1, "undefined"));
        if (objArr[0] instanceof Pattern) {
            return objArr[0].matcher(str).replaceAll(valueOf);
        }
        return Pattern.compile(String.valueOf(objArr[0]), 16).matcher(str).replaceFirst(Matcher.quoteReplacement(valueOf));
    }

    public String slice(String str, Object[] objArr) {
        int length = str.length();
        int sliceRange = JSArray.toSliceRange(JSObject.getIntArg(objArr, 0, 0), length);
        int sliceRange2 = JSArray.toSliceRange(JSObject.getIntArg(objArr, 1, Integer.valueOf(length)), length);
        return sliceRange < sliceRange2 ? str.substring(sliceRange, sliceRange2) : "";
    }

    public String[] split(String str, Object[] objArr) {
        String stringArg = JSObject.getStringArg(objArr, 0, (String) null);
        if (stringArg == null) {
            return new String[]{str};
        }
        return str.split(Pattern.quote(stringArg), JSObject.getIntArg(objArr, 0, -1));
    }

    static int toSubstringRange(int i, int i2) {
        return Math.min(Math.max(i, 0), i2);
    }

    public String substring(String str, Object[] objArr) {
        int length = str.length();
        int substringRange = toSubstringRange(JSObject.getIntArg(objArr, 0, 0), length);
        int substringRange2 = toSubstringRange(JSObject.getIntArg(objArr, 1, Integer.valueOf(length)), length);
        return str.substring(Math.min(substringRange, substringRange2), Math.max(substringRange, substringRange2));
    }

    public String substr(String str, Object[] objArr) {
        int length = str.length();
        int substringRange = toSubstringRange(JSObject.getIntArg(objArr, 0, 0), length);
        int intArg = JSObject.getIntArg(objArr, 1, Integer.valueOf(length - substringRange));
        return intArg > 0 ? str.substring(substringRange, Math.min(length, intArg + substringRange)) : "";
    }

    public String toLowerCase(String str, Object[] objArr) {
        return str.toLowerCase();
    }

    public String toLocaleLowerCase(String str, Object[] objArr) {
        return str.toLowerCase(Locale.getDefault());
    }

    public String toUpperCase(String str, Object[] objArr) {
        return str.toUpperCase(Locale.getDefault());
    }

    public String toLocaleUpperCase(String str, Object[] objArr) {
        return str.toUpperCase(Locale.getDefault());
    }
}
