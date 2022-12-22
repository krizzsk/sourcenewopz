package com.didi.soda.customer.widget.goodsV2;

import android.os.Bundle;
import android.view.View;

public interface GoodsQuantityListener {
    void onAddGoodsClick(String str, View view, Bundle bundle);

    void onSubtractGoodsClick(String str, Bundle bundle);
}
