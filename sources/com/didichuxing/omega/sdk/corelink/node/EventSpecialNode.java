package com.didichuxing.omega.sdk.corelink.node;

import com.didi.raven.config.RavenConfigKey;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.Map;

public class EventSpecialNode {
    private static Map<String, Map<String, Integer>> specialMap;

    public static void putSpecial(Map<String, Map<String, Integer>> map) {
        if (map != null) {
            specialMap = map;
        }
    }

    public static Map<String, Integer> getSpecial(String str) {
        Map<String, Map<String, Integer>> map = specialMap;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r0.get(com.didi.raven.config.RavenKey.STACK);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean filterS(com.didichuxing.omega.sdk.common.record.Event r2) {
        /*
            java.lang.String r2 = r2.getEventId()
            java.util.Map r0 = getSpecial(r2)
            if (r0 == 0) goto L_0x0025
            java.lang.String r1 = "s"
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0025
            int r0 = r0.intValue()
            float r0 = (float) r0
            r1 = 1176256512(0x461c4000, float:10000.0)
            float r0 = r0 / r1
            boolean r2 = com.didichuxing.omega.sdk.corelink.node.EventSampleNode.isSampled(r2, r0)
            if (r2 != 0) goto L_0x0025
            r2 = 1
            return r2
        L_0x0025:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.corelink.node.EventSpecialNode.filterS(com.didichuxing.omega.sdk.common.record.Event):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.get("r");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean filterR(com.didichuxing.omega.sdk.common.record.Event r1) {
        /*
            java.lang.String r1 = r1.getEventId()
            java.util.Map r1 = getSpecial(r1)
            if (r1 == 0) goto L_0x001c
            java.lang.String r0 = "r"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L_0x001c
            int r1 = r1.intValue()
            r0 = 1
            if (r1 != r0) goto L_0x001c
            return r0
        L_0x001c:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.corelink.node.EventSpecialNode.filterR(com.didichuxing.omega.sdk.common.record.Event):boolean");
    }

    public static void filterP(Event event) {
        Integer num;
        Map<String, Integer> special = getSpecial(event.getEventId());
        if (special != null && (num = special.get(RavenConfigKey.PHONE)) != null) {
            if ((num.intValue() & 1) > 0) {
                event.putNetType();
            }
            if ((num.intValue() & 2) > 0) {
                event.putMemInfo();
            }
            if ((num.intValue() & 8) > 0) {
                event.putBatteryInfo();
            }
        }
    }
}
