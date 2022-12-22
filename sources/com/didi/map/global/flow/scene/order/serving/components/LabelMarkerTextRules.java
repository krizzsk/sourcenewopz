package com.didi.map.global.flow.scene.order.serving.components;

import com.didi.sdk.util.TextUtil;
import java.util.ArrayList;
import org.osgi.framework.VersionRange;

public class LabelMarkerTextRules {

    /* renamed from: a */
    private static final int f26769a = 9;

    /* renamed from: b */
    private static final int f26770b = 18;

    public static int sp2px(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    public static String rule(String str, int[] iArr) {
        if (!TextUtil.isEmpty(str)) {
            return m18915a(str, iArr);
        }
        iArr[0] = 0;
        return str;
    }

    /* renamed from: a */
    private static String m18915a(String str, int[] iArr) {
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
}
