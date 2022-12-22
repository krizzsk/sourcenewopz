package com.didi.soda.goodsV2.price;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import com.didi.soda.goodsV2.helper.OfflineCalculateHelper;
import java.util.List;

public class BuyGiftGoodsPriceCalculator extends GoodsPriceCalculator {
    private static final long serialVersionUID = -422890898365041074L;

    public BuyGiftGoodsPriceCalculator(GoodsItemEntity goodsItemEntity) {
        super(goodsItemEntity);
    }

    public BuyGiftGoodsPriceCalculator(GoodsItemEntity goodsItemEntity, int i) {
        super(goodsItemEntity, i);
    }

    public int calculateCurPriceWithStates(List<SelectSubItemState> list, int i, int i2) {
        return OfflineCalculateHelper.getOriginalPriceWithStates(this.mGoodsItemEntity.price, list, i);
    }

    public int calculateOriPriceWithStates(List<SelectSubItemState> list, int i) {
        if (!GoodsDataHelper.hasBuyGiftActivityInfo(this.mGoodsItemEntity)) {
            return 0;
        }
        int i2 = this.mGoodsItemEntity.activityInfo.buyGift.buyNum;
        int i3 = this.mGoodsItemEntity.activityInfo.buyGift.getNum - i2;
        int i4 = (this.mCartItemAmount % (i2 + i3)) + i;
        if (i4 < i2) {
            return 0;
        }
        return OfflineCalculateHelper.getOriginalPriceWithStates(this.mGoodsItemEntity.price, list, ((i4 / i2) * i3) + i);
    }

    public GoodsPriceCalculator copy() {
        return new BuyGiftGoodsPriceCalculator(this.mGoodsItemEntity, this.mCartItemAmount);
    }
}
