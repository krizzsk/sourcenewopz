package com.didi.soda.goodsV2.helper;

import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.goods.repo.SelectSubItemState;
import java.util.List;

public final class OfflineCalculateHelper {
    private OfflineCalculateHelper() {
    }

    public static int getOriginalPrice(int i, List<GoodsSubItemEntity> list, int i2) {
        if (!CollectionsUtil.isEmpty(list)) {
            for (GoodsSubItemEntity next : list) {
                i += next.price * next.amount;
            }
        }
        return i * i2;
    }

    public static int getOriginalPriceWithStates(int i, List<SelectSubItemState> list, int i2) {
        if (!CollectionsUtil.isEmpty(list)) {
            for (SelectSubItemState next : list) {
                i += next.price * next.node.amount;
            }
        }
        return i * i2;
    }

    public static int getDiscountPrice(int i, int i2, List<GoodsSubItemEntity> list, int i3, int i4) {
        int i5 = 0;
        if (i3 <= i4) {
            int i6 = i * i3;
            if (CollectionsUtil.isEmpty(list)) {
                return i6;
            }
            for (GoodsSubItemEntity next : list) {
                i5 += next.price * next.amount;
            }
            return i6 + (i5 * i3);
        }
        int i7 = i * i4;
        if (CollectionsUtil.isEmpty(list)) {
            return i7 + (i2 * (i3 - i4));
        }
        for (GoodsSubItemEntity next2 : list) {
            i5 += next2.price * next2.amount;
        }
        return i7 + (i5 * i4) + ((i2 + i5) * (i3 - i4));
    }

    public static int getDiscountPriceWithStates(int i, int i2, List<SelectSubItemState> list, int i3, int i4) {
        int i5 = 0;
        if (i3 <= i4) {
            int i6 = i * i3;
            if (CollectionsUtil.isEmpty(list)) {
                return i6;
            }
            for (SelectSubItemState next : list) {
                i5 += next.price * next.node.amount;
            }
            return i6 + (i5 * i3);
        }
        int i7 = i * i4;
        if (CollectionsUtil.isEmpty(list)) {
            return i7 + (i2 * (i3 - i4));
        }
        for (SelectSubItemState next2 : list) {
            i5 += next2.price * next2.node.amount;
        }
        return i7 + (i5 * i4) + ((i2 + i5) * (i3 - i4));
    }
}
