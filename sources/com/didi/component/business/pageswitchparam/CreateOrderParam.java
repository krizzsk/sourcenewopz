package com.didi.component.business.pageswitchparam;

import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import java.io.Serializable;
import java.util.List;

public class CreateOrderParam implements Serializable {
    public List<AnyCarGroup> groups;
    public List<AnyCarEstimateItemModel> mAllCar;
    public List<AnyCarEstimateItemModel> mAnyCarSelectedItemModels;
    public boolean mIsAnyCar;
    public int mPreference;
    public AnyCarEstimateItemModel mSelectedSingleModel;
    public String mTraceId;
}
