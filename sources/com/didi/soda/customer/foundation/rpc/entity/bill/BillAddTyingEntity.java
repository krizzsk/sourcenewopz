package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import java.util.List;

public class BillAddTyingEntity implements IEntity {
    private static final long serialVersionUID = -7670306536531985407L;
    public List<ItemNodeEntity> nodeList;
    public String shopId;
    public int tyingItemsFlag = 2;
    public int wineConfirm = 0;
}
