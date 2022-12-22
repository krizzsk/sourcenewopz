package com.didi.map.global.flow.model;

import android.graphics.drawable.Drawable;
import com.didi.common.map.Map;
import com.didi.sdk.address.address.entity.Address;
import java.util.List;

public class WayPointParam {
    public float anchorU;
    public float anchorV;
    public Map map;
    public List<Address> wayAddresses;
    public Drawable wayPointIcon;
}
