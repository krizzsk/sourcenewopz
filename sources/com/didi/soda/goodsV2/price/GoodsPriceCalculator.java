package com.didi.soda.goodsV2.price;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.goods.repo.SelectSubItemState;
import java.io.Serializable;
import java.util.List;

public abstract class GoodsPriceCalculator implements Serializable {
    private static final long serialVersionUID = 2588378938804825231L;
    int mCartItemAmount;
    GoodsItemEntity mGoodsItemEntity;

    public abstract int calculateCurPriceWithStates(List<SelectSubItemState> list, int i, int i2);

    public abstract int calculateOriPriceWithStates(List<SelectSubItemState> list, int i);

    public abstract GoodsPriceCalculator copy();

    public GoodsPriceCalculator() {
    }

    public GoodsPriceCalculator(GoodsItemEntity goodsItemEntity) {
        this(goodsItemEntity, 0);
    }

    public GoodsPriceCalculator(GoodsItemEntity goodsItemEntity, int i) {
        this.mGoodsItemEntity = goodsItemEntity;
        this.mCartItemAmount = i;
    }
}
