package com.didi.map.global.component.slideCars;

import com.didi.common.map.model.LatLng;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.model.IDriverChangeListener;
import com.didi.map.sdk.component.IBaseComponent;
import com.didi.map.sdk.component.IDataComponent;
import java.util.List;

public interface ISlideCarsCompContract extends IBaseComponent<SlideCarsCompParams>, IDataComponent {
    List<LatLng> getDriverPoints();

    void reStart(CarNavigatorRequest carNavigatorRequest);

    void refreshCarIcon();

    void setCarVisible(boolean z);

    void setListener(IDriverChangeListener iDriverChangeListener);

    void updateLocationPosition(LatLng latLng);
}
