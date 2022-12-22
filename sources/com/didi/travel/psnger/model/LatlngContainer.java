package com.didi.travel.psnger.model;

import com.didi.common.map.model.LatLng;
import java.io.Serializable;
import java.util.List;

public class LatlngContainer implements Serializable, Cloneable {
    public List<LatLng> positions;
}
