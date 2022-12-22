package com.didichuxing.dfbasesdk.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static final String SP_DATA_COUNT = "dataNum";
    public static final String SP_DATA_ITEM = "item_";
    public static ArrayList<String> stringArrayList = new ArrayList<>();

    public static String getShowIdCard(String str) {
        return str.substring(0, 3) + "***********" + str.substring(14);
    }

    public static String getShowName(String str) {
        String str2 = "";
        for (int i = 1; i < str.length(); i++) {
            str2 = str2 + "*";
        }
        return str.substring(0, 1) + str2;
    }

    public static SpannableString makeSpannableString(String str, List<String> list, String str2) {
        SpannableString spannableString = new SpannableString(str);
        for (String next : list) {
            int indexOf = str.indexOf(next);
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), indexOf, next.length() + indexOf, 33);
        }
        return spannableString;
    }

    public static void checkProtocolStatus(String str) {
        if (!stringArrayList.contains(str)) {
            if (stringArrayList.size() == 5) {
                stringArrayList.remove(0);
            }
            ArrayList<String> arrayList = stringArrayList;
            arrayList.add(arrayList.size(), str);
            return;
        }
        int i = 0;
        while (i < stringArrayList.size()) {
            if (!str.equals(stringArrayList.get(i)) || i >= stringArrayList.size() - 1) {
                i++;
            } else {
                while (i < stringArrayList.size() - 1) {
                    ArrayList<String> arrayList2 = stringArrayList;
                    int i2 = i + 1;
                    arrayList2.set(i, arrayList2.get(i2));
                    i = i2;
                }
                ArrayList<String> arrayList3 = stringArrayList;
                arrayList3.set(arrayList3.size() - 1, str);
                for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                    SystemUtils.log(3, "martin", "arrayList i : " + stringArrayList.get(i3), (Throwable) null, "com.didichuxing.dfbasesdk.utils.StringUtils", 81);
                }
                return;
            }
        }
    }

    public static void updateProtocolStatus(String str) {
        if (!stringArrayList.isEmpty()) {
            int i = 0;
            while (i < stringArrayList.size()) {
                if (!str.equals(stringArrayList.get(i)) || i >= stringArrayList.size() - 1) {
                    i++;
                } else {
                    while (i < stringArrayList.size() - 1) {
                        ArrayList<String> arrayList = stringArrayList;
                        int i2 = i + 1;
                        arrayList.set(i, arrayList.get(i2));
                        i = i2;
                    }
                    ArrayList<String> arrayList2 = stringArrayList;
                    arrayList2.set(arrayList2.size() - 1, str);
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        SystemUtils.log(3, "martin", "arrayList i : " + stringArrayList.get(i3), (Throwable) null, "com.didichuxing.dfbasesdk.utils.StringUtils", 100);
                    }
                    return;
                }
            }
        }
    }

    public static void addProtocolStatus(String str, ArrayList<String> arrayList) {
        if (arrayList.size() == 5) {
            arrayList.remove(0);
        }
        arrayList.add(arrayList.size(), str);
    }
}
