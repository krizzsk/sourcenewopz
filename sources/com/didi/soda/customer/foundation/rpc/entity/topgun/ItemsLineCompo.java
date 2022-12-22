package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

class ItemsLineCompo implements IEntity {
    private static final long serialVersionUID = 2468490688926237147L;
    @SerializedName("items")
    public List<GoodsItemEntity> mItems;

    ItemsLineCompo() {
    }
}
