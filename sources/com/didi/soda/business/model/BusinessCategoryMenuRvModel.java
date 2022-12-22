package com.didi.soda.business.model;

import com.didi.soda.customer.foundation.rpc.entity.BusinessCateEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class BusinessCategoryMenuRvModel extends BaseBusinessRvModel implements IEntity {
    private static final long serialVersionUID = 3004026827272478806L;
    public boolean isSelected = false;
    public String mCategoryId;
    public String mCategoryName;
    public int mItemCount;

    public static BusinessCategoryMenuRvModel newInstance(BusinessCateEntity businessCateEntity) {
        BusinessCategoryMenuRvModel businessCategoryMenuRvModel = new BusinessCategoryMenuRvModel();
        businessCategoryMenuRvModel.mCategoryId = businessCateEntity.cateId;
        businessCategoryMenuRvModel.mCategoryName = businessCateEntity.cateName;
        if (businessCateEntity.items != null) {
            businessCategoryMenuRvModel.mItemCount = businessCateEntity.items.size();
        }
        if (businessCateEntity.mJsonComponentList != null) {
            businessCategoryMenuRvModel.mItemCount = businessCateEntity.mJsonComponentList.size();
        }
        return businessCategoryMenuRvModel;
    }
}
