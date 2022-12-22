package com.didi.map.global.component.collide.strategy2;

import android.graphics.Rect;
import com.didi.common.map.Map;
import java.util.List;

public interface IDMarkerContractV2 {

    /* renamed from: com.didi.map.global.component.collide.strategy2.IDMarkerContractV2$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getDisabledLines(IDMarkerContractV2 iDMarkerContractV2) {
            return null;
        }

        public static List $default$getDisabledRect(IDMarkerContractV2 iDMarkerContractV2) {
            return null;
        }

        public static int $default$getHot(IDMarkerContractV2 iDMarkerContractV2, String str) {
            return 0;
        }

        public static boolean $default$isCanWork(IDMarkerContractV2 iDMarkerContractV2) {
            return false;
        }

        public static boolean $default$isLabelDirectClockwise(IDMarkerContractV2 iDMarkerContractV2) {
            return false;
        }
    }

    int getCurrentLabelPosition(String str);

    List<RouteInfo> getDisabledLines();

    List<Rect> getDisabledRect();

    int getEnableLabelPosition(String str);

    int getHot(String str);

    Map getMap();

    boolean isCanWork();

    boolean isLabelDirectClockwise();

    void setLabelDirect(String str, int i);
}
