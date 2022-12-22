package com.didichuxing.mas.sdk.quality.collect.perfromacedetect.mem;

import com.didi.raven.config.RavenKey;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FdUtil {
    public static final String TAG = "FdUtil";

    public static String censusFdInfo(String str) {
        try {
            String[] split = str.split("\n");
            StringBuilder sb = new StringBuilder();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (String str2 : split) {
                if (!str2.split(":")[0].equals(str2)) {
                    if (!str2.contains("number of FDs")) {
                        String str3 = str2.split(":")[1];
                        i = Math.max(str3.length(), i);
                        if (linkedHashMap.containsKey(str3)) {
                            linkedHashMap.put(str3, Integer.valueOf(((Integer) linkedHashMap.get(str3)).intValue() + 1));
                        } else {
                            linkedHashMap.put(str3, 1);
                        }
                    }
                }
                sb.append(str2);
                sb.append("\n");
            }
            return m34353a(sortFdMapByValue(linkedHashMap), sb, i);
        } catch (Exception e) {
            OLog.m34419e("XCrashHelper censusFdInfo", e);
            return "";
        }
    }

    public static String censusFdInfo(Map<String, Object> map) {
        try {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> value : map.entrySet()) {
                String str = (String) value.getValue();
                i = Math.max(str.length(), i);
                if (linkedHashMap.containsKey(str)) {
                    linkedHashMap.put(str, Integer.valueOf(((Integer) linkedHashMap.get(str)).intValue() + 1));
                } else {
                    linkedHashMap.put(str, 1);
                }
            }
            sb.append("(number of FDs: ");
            sb.append(map.size());
            sb.append(")\n\n");
            return m34353a(sortFdMapByValue(linkedHashMap), sb, i);
        } catch (Exception e) {
            OLog.m34419e("XCrashHelper censusFdInfo", e);
            return "";
        }
    }

    public static LinkedHashMap<String, Integer> sortFdMapByValue(LinkedHashMap<String, Integer> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return null;
        }
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>();
        ArrayList<Map.Entry> arrayList = new ArrayList<>(linkedHashMap.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                return entry2.getValue().intValue() - entry.getValue().intValue();
            }
        });
        for (Map.Entry entry : arrayList) {
            linkedHashMap2.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap2;
    }

    /* renamed from: a */
    private static String m34353a(LinkedHashMap<String, Integer> linkedHashMap, StringBuilder sb, int i) {
        String str = "%-" + i + RavenKey.STACK;
        sb.append(String.format(str, new Object[]{"NAME"}));
        sb.append(String.format("%8s", new Object[]{"COUNT"}));
        sb.append("\n");
        Iterator<Map.Entry<String, Integer>> it = linkedHashMap.entrySet().iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((long) i2) > MASConfig.FD_INFO_REPORT_LINE_LIMIT_NUM) {
                OLog.m34420i("FdUtiloutFdInfo-> break: curAppendLine =" + i2);
                break;
            }
            sb.append(String.format(str, new Object[]{next.getKey()}));
            sb.append(String.format("%8s", new Object[]{next.getValue()}));
            sb.append("\n");
            i2++;
        }
        return sb.toString();
    }
}
