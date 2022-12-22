package com.didi.unifylogin.utils;

import com.didichuxing.foundation.net.http.HttpHeader;
import java.util.List;
import java.util.ListIterator;

public class NetworkUtil {
    public static String getHeader(List<HttpHeader> list, String str) {
        if (!(list == null || list.size() == 0)) {
            ListIterator<HttpHeader> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                HttpHeader previous = listIterator.previous();
                if (previous.getName() != null && previous.getName().equalsIgnoreCase(str)) {
                    return previous.getValue();
                }
            }
        }
        return "";
    }
}
