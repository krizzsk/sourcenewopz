package com.didi.entrega.customer.timemachine;

import com.didi.entrega.customer.foundation.util.CollectionsUtil;
import com.didichuxing.foundation.net.http.HttpHeader;
import java.util.List;

public final class TmUtil {
    private TmUtil() {
    }

    public static boolean isIncludeString(String str, List<String> list) {
        if (!(list == null || list.isEmpty() || str == null)) {
            for (String contains : list) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String httpHeadersToString(List<HttpHeader> list) {
        StringBuilder sb = new StringBuilder();
        if (!CollectionsUtil.isEmpty(list)) {
            for (HttpHeader next : list) {
                if (next != null) {
                    String str = "";
                    sb.append(next.getName() != null ? next.getName() : str);
                    sb.append(":");
                    if (next.getValue() != null) {
                        str = next.getValue();
                    }
                    sb.append(str);
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }
}
