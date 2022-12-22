package com.didi.map.global.component.collide.strategy3;

import android.graphics.Rect;
import com.didi.common.map.Map;
import com.didi.common.map.model.Padding;
import java.util.List;

public interface IDMarkerContractV3 {

    /* renamed from: com.didi.map.global.component.collide.strategy3.IDMarkerContractV3$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getDefaultLabelPosition(IDMarkerContractV3 iDMarkerContractV3) {
            return 64;
        }

        public static int $default$getEnableLabelPosition(IDMarkerContractV3 iDMarkerContractV3) {
            return 85;
        }

        public static boolean $default$isCanWork(IDMarkerContractV3 iDMarkerContractV3) {
            return true;
        }

        public static void $default$setLabelDirect(IDMarkerContractV3 iDMarkerContractV3, String str, int i) {
        }
    }

    List<Rect> getCollideAvoidRect();

    int getDefaultLabelPosition();

    int getEnableLabelPosition();

    Map getMap();

    Padding getPadding();

    boolean isCanWork();

    void setLabelDirect(String str, int i);
}
