package com.didi.soda.business.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.model.ComponentModel;
import java.util.ArrayList;
import java.util.List;

public class BusinessExpandRvModel implements RecyclerModel {
    public List<ComponentModel> mComponentModelExpandList = new ArrayList();
    public List<BusinessGoodsItemRvModel> mExpandList = new ArrayList();
    public boolean mIsExpand = false;

    public static BusinessExpandRvModel create(boolean z, List<BusinessGoodsItemRvModel> list) {
        BusinessExpandRvModel businessExpandRvModel = new BusinessExpandRvModel();
        businessExpandRvModel.mIsExpand = z;
        businessExpandRvModel.mExpandList.addAll(list);
        return businessExpandRvModel;
    }

    public static BusinessExpandRvModel createForDy(boolean z, List<ComponentModel> list) {
        BusinessExpandRvModel businessExpandRvModel = new BusinessExpandRvModel();
        businessExpandRvModel.mIsExpand = z;
        businessExpandRvModel.mComponentModelExpandList.addAll(list);
        return businessExpandRvModel;
    }
}
