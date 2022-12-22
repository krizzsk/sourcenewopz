package com.didi.travel.psnger.model;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.FlierPoolStationModel;
import com.didi.travel.psnger.model.response.WillWaitInfo;

public class FlierFeature extends BaseObject {
    public int carPool;
    public String carPrice;
    public FlierPoolStationModel flierPoolStationModel;
    public boolean isPoolStation;
    public int seatNum;
    public WillWaitInfo willWaitInfo;
}
