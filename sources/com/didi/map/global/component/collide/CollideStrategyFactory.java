package com.didi.map.global.component.collide;

import com.didi.map.global.component.collide.strategy1.CollideStrategyV1;
import com.didi.map.global.component.collide.strategy1.IDMarkerContractV1;
import com.didi.map.global.component.collide.strategy2.CollideStrategyV2;
import com.didi.map.global.component.collide.strategy2.IDMarkerContractV2;
import com.didi.map.global.component.collide.strategy3.CollideStrategyV3;
import com.didi.map.global.component.collide.strategy3.IDMarkerContractV3;

public class CollideStrategyFactory {
    public static ICollideStrategy getCollideStrategyV1(IDMarkerContractV1 iDMarkerContractV1) {
        if (iDMarkerContractV1 == null) {
            return null;
        }
        return new CollideStrategyV1(iDMarkerContractV1);
    }

    public static ICollideStrategy getCollideStrategyV2(IDMarkerContractV2 iDMarkerContractV2) {
        return new CollideStrategyV2(iDMarkerContractV2);
    }

    public static ICollideStrategy getCollideStrategyV3(IDMarkerContractV3 iDMarkerContractV3) {
        if (iDMarkerContractV3 == null) {
            return null;
        }
        return new CollideStrategyV3(iDMarkerContractV3);
    }
}
