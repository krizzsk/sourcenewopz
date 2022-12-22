package com.didi.soda.goods.price;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.goods.helper.OfflineCalculateHelper;
import com.didi.soda.goods.repo.SelectSubItemState;
import java.util.List;

public class EFOGoodsPriceCalculator extends GoodsPriceCalculator {
    private static final long serialVersionUID = -2639087033193151361L;

    public EFOGoodsPriceCalculator(GoodsItemEntity goodsItemEntity) {
        super(goodsItemEntity);
    }

    public int calculateCurPriceWithStates(List<SelectSubItemState> list, int i, int i2) {
        return OfflineCalculateHelper.getDiscountPriceWithStates(this.mGoodsItemEntity.specialPrice, this.mGoodsItemEntity.price, list, i, 1);
    }

    public int calculateOriPriceWithStates(List<SelectSubItemState> list, int i) {
        return OfflineCalculateHelper.getOriginalPriceWithStates(this.mGoodsItemEntity.price, list, i);
    }

    public GoodsPriceCalculator copy() {
        return new EFOGoodsPriceCalculator(this.mGoodsItemEntity);
    }
}
