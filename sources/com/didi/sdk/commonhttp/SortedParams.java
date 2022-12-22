package com.didi.sdk.commonhttp;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SortedParams extends HashMap<String, String> {
    SortedParams() {
    }

    public String getNormalSortedUrlParamsString() {
        List<Map.Entry<String, String>> sortListEntrySet = getSortListEntrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : sortListEntrySet) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (sb.length() > 0) {
                sb.append(ParamKeys.SIGN_AND);
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2);
        }
        return sb.toString();
    }

    private List<Map.Entry<String, String>> getSortListEntrySet() {
        ArrayList arrayList = new ArrayList(entrySet());
        Collections.sort(arrayList, new KVPairComparator());
        return arrayList;
    }

    class KVPairComparator implements Comparator<Map.Entry<String, String>> {
        KVPairComparator() {
        }

        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }
}
