package com.didi.soda.business.listener;

import com.didi.soda.business.model.BusinessCategoryMenuRvModel;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import java.util.List;

public interface BusinessCategoryListener {
    void dismissCategory();

    void showCategory(List<BusinessCategoryRvModel> list, BusinessSelectedCallback businessSelectedCallback);

    void showDyCategory(List<BusinessCategoryMenuRvModel> list, BusinessSelectedCallback businessSelectedCallback);
}
