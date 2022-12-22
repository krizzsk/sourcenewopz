package com.didi.map.global.flow.scene.minibus.param;

import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import java.util.List;

public interface MiniBusParamInterface {
    List<CommonLineParam> getMiniBusLineParam();

    List<CommonMarkerParam> getMiniBusMarkerParam();
}
