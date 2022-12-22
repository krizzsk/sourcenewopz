package com.didi.soda.customer.map.model;

import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import java.util.LinkedList;
import java.util.List;

public class BestViewModel {
    public final List<LatLng> mIncludes = new LinkedList();
    public Padding mPadding;
    public final List<IMapElement> mapElements = new LinkedList();
    public LatLng zoomCenter;
}
