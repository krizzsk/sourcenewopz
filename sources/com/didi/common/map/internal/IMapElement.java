package com.didi.common.map.internal;

import android.os.Bundle;
import com.didi.common.map.model.LatLng;
import java.util.List;

public interface IMapElement {
    List<LatLng> getBounderPoints();

    Bundle getBundle();

    Object getData();

    Object getElement();

    String getId();

    IMapElementOptions getOptions();

    int getZIndex();

    boolean isClickable();

    boolean isVisible();

    void remove();

    void setBundle(Bundle bundle);

    void setData(Object obj);

    void setOptions(IMapElementOptions iMapElementOptions);

    void setVisible(boolean z);

    void setZIndex(int i);
}
