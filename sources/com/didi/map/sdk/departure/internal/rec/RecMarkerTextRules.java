package com.didi.map.sdk.departure.internal.rec;

import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.sdk.util.TextUtil;
import java.util.ArrayList;
import org.osgi.framework.VersionRange;

public class RecMarkerTextRules {

    /* renamed from: a */
    private static final int f28218a = 9;

    /* renamed from: b */
    private static final int f28219b = 18;

    public static int sp2px(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    public static String rule(String str, int[] iArr) {
        if (!TextUtil.isEmpty(str)) {
            return breakLine(str, iArr);
        }
        iArr[0] = 0;
        return str;
    }

    public static String breakLine(String str, int[] iArr) {
        String str2;
        String str3 = "";
        if (TextUtil.isEmpty(str)) {
            return str3;
        }
        int length = str.length();
        if (length <= 9) {
            return str;
        }
        int i = (10 > length || length > 12) ? 9 : 7;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str.substring(0, i));
        arrayList.add(str.substring(i));
        String str4 = (String) arrayList.get(0);
        StringBuilder sb = new StringBuilder();
        int length2 = str4.length() - 1;
        char charAt = str4.charAt(length2);
        String str5 = (String) arrayList.get(1);
        if ('(' == charAt) {
            str4 = str4.substring(0, length2);
            str3 = VersionRange.LEFT_OPEN + str5;
        } else if (')' == str5.charAt(0)) {
            str4 = str4 + ")";
            if (str5.length() > 1) {
                str3 = str5.substring(1);
            }
        } else {
            str3 = str5;
        }
        sb.append(str4);
        int length3 = str3.length();
        if (length3 > 0) {
            sb.append("\n");
            if (length3 >= 9 && (length != 18 || length3 != 10 || !str3.startsWith("(") || !str3.contains(")"))) {
                if (length == 19 && length3 == 9) {
                    str2 = str3.substring(0, 8);
                } else {
                    str2 = str3.substring(0, 9);
                }
                str3 = str2 + "...";
            }
            sb.append(str3);
            iArr[0] = 2;
        } else {
            iArr[0] = 1;
        }
        return sb.toString();
    }

    public static String[] breakLine(String str) {
        if (TextUtil.isEmpty(str)) {
            return new String[]{""};
        }
        if (str.length() <= 15) {
            return new String[]{str};
        } else if (str.substring(0, 15).contains(" ")) {
            return new String[]{str};
        } else {
            StringBuilder sb = new StringBuilder();
            if (str.substring(14, 15).contains("(")) {
                sb.append(str.substring(0, 14));
                sb.append("\n");
                String substring = str.substring(14, str.length());
                if (substring.length() <= 15) {
                    sb.append(substring);
                    return new String[]{sb.toString(), SameLayerRenderingUtil.KEY_COMP_Y};
                }
                sb.append(substring.substring(0, 13));
                sb.append("...");
                return new String[]{sb.toString(), SameLayerRenderingUtil.KEY_COMP_Y};
            } else if (str.substring(14, 16).indexOf(" ") == -1) {
                sb.append(str.substring(0, 15));
                sb.append("\n");
                String substring2 = str.substring(15, str.length());
                if (substring2.length() <= 15) {
                    sb.append(substring2);
                    return new String[]{sb.toString(), SameLayerRenderingUtil.KEY_COMP_Y};
                }
                sb.append(substring2.substring(0, 13));
                sb.append("...");
                return new String[]{sb.toString(), SameLayerRenderingUtil.KEY_COMP_Y};
            } else {
                return new String[]{sb.toString()};
            }
        }
    }
}
