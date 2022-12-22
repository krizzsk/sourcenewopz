package com.didi.map.global.component;

import com.didi.common.map.internal.IMapElement;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.List;

public interface ICircleTipComponent extends IBaseComponent<CircleTipParam> {
    List<IMapElement> getBestViewElements();
}
