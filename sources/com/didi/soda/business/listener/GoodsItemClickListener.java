package com.didi.soda.business.listener;

import android.view.View;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;

public interface GoodsItemClickListener {
    void onGoodsAddClick(BusinessGoodsItemRvModel businessGoodsItemRvModel);

    void onGoodsImageClick(View view, BusinessGoodsItemRvModel businessGoodsItemRvModel);

    void onGoodsItemClick(BusinessGoodsItemRvModel businessGoodsItemRvModel);
}
