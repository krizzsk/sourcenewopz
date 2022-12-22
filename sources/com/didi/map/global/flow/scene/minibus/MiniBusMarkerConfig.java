package com.didi.map.global.flow.scene.minibus;

import com.didi.common.map.util.CollectionUtil;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MiniBusMarkerConfig {
    public static List<CommonMarkerParam> getConfigMarkerParam(List<CommonMarkerParam> list) {
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return new ArrayList();
        }
        for (CommonMarkerParam next : list) {
            if (next != null) {
                switch (C96441.$SwitchMap$com$didi$map$global$flow$scene$param$MapElementId[next.getId().ordinal()]) {
                    case 1:
                        next.setZIndex(98);
                        break;
                    case 2:
                        next.setZIndex(204);
                        break;
                    case 3:
                        next.setZIndex(96);
                        break;
                    case 4:
                        next.setZIndex(202);
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        next.setZIndex(190);
                        break;
                    case 9:
                        next.setZIndex(198);
                        break;
                    case 10:
                        next.setZIndex(192);
                        break;
                }
            }
        }
        return list;
    }

    /* renamed from: com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig$1 */
    static /* synthetic */ class C96441 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.map.global.flow.scene.param.MapElementId[] r0 = com.didi.map.global.flow.scene.param.MapElementId.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId = r0
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_START_NAV     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_END_NAV     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_1     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_2     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT_3     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_PICK_UP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$map$global$flow$scene$param$MapElementId     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.map.global.flow.scene.param.MapElementId r1 = com.didi.map.global.flow.scene.param.MapElementId.ID_MARKER_DROP_OFF     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.minibus.MiniBusMarkerConfig.C96441.<clinit>():void");
        }
    }
}
