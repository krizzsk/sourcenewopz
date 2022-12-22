package com.didichuxing.mas.sdk.quality.report.analysis;

import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.utils.BloomFilter;
import com.xiaojuchefu.prism.monitor.PrismConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventFilter {
    private static List<String> blacklist;
    private static Map<String, Map<String, Integer>> specialMap;
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

    public static void putSpecial(Map<String, Map<String, Integer>> map) {
        if (map != null) {
            specialMap = map;
        }
    }

    public static boolean filter(Event event) {
        if (PrismConstants.Symbol.f56077H5.equals(event.getFrom())) {
            return false;
        }
        String eventId = event.getEventId();
        if (BloomFilter.getBloomFilter() == null || !BloomFilter.getBloomFilter().isInit()) {
            Map<String, Object> map = whiteMap;
            if (map == null) {
                List<String> list = blacklist;
                if (list != null) {
                    for (String equals : list) {
                        if (eventId.equals(equals)) {
                            return true;
                        }
                    }
                }
            } else if (!map.containsKey(eventId)) {
                return true;
            }
        } else if (!BloomFilter.getBloomFilter().contains(eventId)) {
            return true;
        }
        return false;
    }

    public static boolean isSampled(String str, float f) {
        StringBuilder sb = new StringBuilder();
        sb.append(PersistentInfoCollector.getOmegaId());
        sb.append(str);
        return ((int) (f * 10000.0f)) >= Math.abs(sb.toString().hashCode()) % 10000;
    }

    public static Map<String, Integer> getSpecial(String str) {
        Map<String, Map<String, Integer>> map = specialMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
