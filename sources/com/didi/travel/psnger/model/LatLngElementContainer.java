package com.didi.travel.psnger.model;

import com.didi.common.map.model.LatLng;
import java.io.Serializable;
import java.util.List;

public class LatLngElementContainer implements Serializable, Cloneable {
    public List<String> elements;
    public List<LatLng> positions;
}
