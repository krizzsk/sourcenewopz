package com.didichuxing.omega.sdk.corelink.node;

import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.BloomFilter;
import com.xiaojuchefu.prism.monitor.PrismConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventFilterNode {
    private static List<String> blacklist;
    private static Map<String, Object> whiteMap;

    public static void putBlack(List<String> list) {
        blacklist = list;
    }

    public static void putWhite(List<String> list) {
        if (list != null && list.size() > 0) {
            if (whiteMap == null) {
                whiteMap = new HashMap();
            }
            for (String put : list) {
                whiteMap.put(put, 1);
            }
        }
    }

    public static boolean filter(Event event) {
        String eventId = event.getEventId();
        if (PrismConstants.Symbol.f56077H5.equals(event.getFrom())) {
            List<String> list = blacklist;
            if (list != null) {
                for (String equals : list) {
                    if (eventId.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        } else if (BloomFilter.getBloomFilter() != null && BloomFilter.getBloomFilter().isInit() && !BloomFilter.getBloomFilter().contains(eventId)) {
            return true;
        } else {
            List<String> list2 = blacklist;
            if (list2 != null) {
                for (String equals2 : list2) {
                    if (eventId.equals(equals2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
