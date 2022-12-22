package com.didi.map.global.component.myLocation;

import com.didi.common.map.internal.IMapElement;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.List;

public interface IMyLocationCompContract extends IBaseComponent<MyLocationCompParam> {
    List<IMapElement> getMyLocationMarkers();

    boolean isVisible();

    void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam);

    void setVisible(boolean z);

    void setZIndex(int i);
}
