package com.didi.map.global.component.collide.strategy1;

import android.graphics.Rect;
import com.didi.common.map.Map;
import java.util.List;

public interface IDMarkerContractV1 {

    /* renamed from: com.didi.map.global.component.collide.strategy1.IDMarkerContractV1$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getDefaultLabelPosition(IDMarkerContractV1 iDMarkerContractV1) {
            return 1;
        }

        public static List $default$getDisabledRect(IDMarkerContractV1 iDMarkerContractV1) {
            return null;
        }

        public static int $default$getEnableLabelPosition(IDMarkerContractV1 iDMarkerContractV1) {
            return 85;
        }

        public static int $default$getHot(IDMarkerContractV1 iDMarkerContractV1, String str) {
            return 0;
        }

        public static boolean $default$getIsLabelHideWhenPined(IDMarkerContractV1 iDMarkerContractV1) {
            return true;
        }

        public static boolean $default$isCanWork(IDMarkerContractV1 iDMarkerContractV1) {
            return true;
        }

        public static boolean $default$isLabelDirectClockwise(IDMarkerContractV1 iDMarkerContractV1) {
            return false;
        }

        public static boolean $default$isPined(IDMarkerContractV1 iDMarkerContractV1, String str) {
            return false;
        }

        public static boolean $default$isZoomConditionOnly(IDMarkerContractV1 iDMarkerContractV1) {
            return false;
        }

        public static void $default$setLabelDirect(IDMarkerContractV1 iDMarkerContractV1, String str, int i) {
        }

        public static void $default$setVisible(IDMarkerContractV1 iDMarkerContractV1, String str, boolean z) {
        }
    }

    int getDefaultLabelPosition();

    List<Rect> getDisabledRect();

    int getEnableLabelPosition();

    int getHot(String str);

    boolean getIsLabelHideWhenPined();

    Map getMap();

    boolean isCanWork();

    boolean isLabelDirectClockwise();

    boolean isPined(String str);

    boolean isZoomConditionOnly();

    void setLabelDirect(String str, int i);

    void setVisible(String str, boolean z);
}
