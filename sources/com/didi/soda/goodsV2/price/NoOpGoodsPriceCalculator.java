package com.didi.soda.goodsV2.price;

import com.didi.soda.goods.repo.SelectSubItemState;
import java.util.List;

public class NoOpGoodsPriceCalculator extends GoodsPriceCalculator {
    private static final long serialVersionUID = 6769967166446098249L;

    public int calculateCurPriceWithStates(List<SelectSubItemState> list, int i, int i2) {
        return 0;
    }

    public int calculateOriPriceWithStates(List<SelectSubItemState> list, int i) {
        return 0;
    }

    public GoodsPriceCalculator copy() {
        return new NoOpGoodsPriceCalculator();
    }
}
