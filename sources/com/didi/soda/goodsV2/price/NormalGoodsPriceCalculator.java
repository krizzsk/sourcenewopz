package com.didi.soda.goodsV2.price;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.helper.OfflineCalculateHelper;
import java.util.List;

public class NormalGoodsPriceCalculator extends GoodsPriceCalculator {
    private static final long serialVersionUID = 3364192652354836553L;

    public int calculateOriPriceWithStates(List<SelectSubItemState> list, int i) {
        return 0;
    }

    public NormalGoodsPriceCalculator(GoodsItemEntity goodsItemEntity) {
        super(goodsItemEntity);
    }

    public int calculateCurPriceWithStates(List<SelectSubItemState> list, int i, int i2) {
        return OfflineCalculateHelper.getOriginalPriceWithStates(this.mGoodsItemEntity.price, list, i);
    }

    public GoodsPriceCalculator copy() {
        return new NormalGoodsPriceCalculator(this.mGoodsItemEntity);
    }
}
