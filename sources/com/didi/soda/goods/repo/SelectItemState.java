package com.didi.soda.goods.repo;

import android.util.SparseArray;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import java.io.Serializable;
import java.util.HashMap;

public final class SelectItemState implements Serializable {
    private static final long serialVersionUID = -4796524891307778173L;
    public int from;
    public String itemId;
    public int itemStatus;
    public int level;
    public String limitedTime;
    public int maxSale = Integer.MAX_VALUE;
    public ItemNodeEntity node;
    public SparseArray<HashMap<String, SelectSubItemState>> selectedStateMap;
    public String shopId;
    public int shopStatus;
    public int soldStatus;
    public int totalLevel;

    private SelectItemState() {
    }

    public static SelectItemState newInstance(SparseArray<HashMap<String, SelectSubItemState>> sparseArray, ItemNodeEntity itemNodeEntity) {
        SelectItemState selectItemState = new SelectItemState();
        selectItemState.selectedStateMap = sparseArray;
        selectItemState.node = itemNodeEntity.copy();
        selectItemState.level = itemNodeEntity.level;
        selectItemState.totalLevel = itemNodeEntity.totalLevel;
        return selectItemState;
    }
}
