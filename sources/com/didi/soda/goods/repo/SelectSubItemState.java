package com.didi.soda.goods.repo;

import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.util.CloneUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SelectSubItemState implements Serializable {
    private static final long serialVersionUID = 3228869237613662935L;
    public String contentId;
    public String currency;
    public MultiSubItemDesc desc;
    public String itemName;
    public int level;
    public ItemNodeEntity node;
    public SelectSubItemState parentState;
    public int price;
    public List<SelectSubItemState> selectedSubItemStates;
    public String subItemId;
    public String uniqueId;

    public static SelectSubItemState newInstance(GoodsSubItemEntity goodsSubItemEntity, int i) {
        SelectSubItemState selectSubItemState = new SelectSubItemState();
        selectSubItemState.node = goodsSubItemEntity.node.copy();
        selectSubItemState.level = i;
        selectSubItemState.uniqueId = goodsSubItemEntity.node.nodeId;
        selectSubItemState.node.amount = goodsSubItemEntity.amount;
        selectSubItemState.desc = new MultiSubItemDesc(goodsSubItemEntity.itemName, goodsSubItemEntity.price, goodsSubItemEntity.currency);
        selectSubItemState.subItemId = goodsSubItemEntity.itemId;
        selectSubItemState.contentId = goodsSubItemEntity.contentId;
        selectSubItemState.price = goodsSubItemEntity.price;
        selectSubItemState.currency = goodsSubItemEntity.currency;
        selectSubItemState.itemName = goodsSubItemEntity.itemName;
        return selectSubItemState;
    }

    public HashMap<String, SelectSubItemState> getSelectedSubItemStates() {
        HashMap<String, SelectSubItemState> hashMap = new HashMap<>();
        if (isSelect()) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(this);
            while (!linkedList.isEmpty()) {
                SelectSubItemState selectSubItemState = (SelectSubItemState) linkedList.poll();
                if (selectSubItemState.recursiveSelect()) {
                    hashMap.put(selectSubItemState.uniqueId, selectSubItemState);
                }
                if (!CollectionsUtil.isEmpty(selectSubItemState.selectedSubItemStates)) {
                    linkedList.addAll(selectSubItemState.selectedSubItemStates);
                }
            }
        }
        return hashMap;
    }

    public SelectSubItemState copy() {
        Object deepClone = CloneUtil.deepClone(this);
        if (deepClone instanceof SelectSubItemState) {
            return (SelectSubItemState) deepClone;
        }
        return null;
    }

    public void clear() {
        this.node.amount = 0;
        if (!CollectionsUtil.isEmpty(this.selectedSubItemStates)) {
            for (SelectSubItemState clear : this.selectedSubItemStates) {
                clear.clear();
            }
        }
    }

    public List<MultiSubItemDesc> getDescList() {
        if (CollectionsUtil.isEmpty(this.selectedSubItemStates)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SelectSubItemState next : this.selectedSubItemStates) {
            if (next.isSelect()) {
                arrayList.add(bfs(next));
            }
        }
        return arrayList;
    }

    public boolean isSelect() {
        return this.node.amount > 0;
    }

    public boolean canAddToCart() {
        return recursiveSelect() && !isSubItemsSelect();
    }

    public boolean recursiveSelect() {
        if (this.parentState == null) {
            return isSelect();
        }
        return isSelect() && this.parentState.recursiveSelect();
    }

    public boolean isSubItemsSelect() {
        if (CollectionsUtil.isEmpty(this.selectedSubItemStates)) {
            return false;
        }
        for (SelectSubItemState isSelect : this.selectedSubItemStates) {
            if (isSelect.isSelect()) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SelectSubItemState)) {
            return false;
        }
        SelectSubItemState selectSubItemState = (SelectSubItemState) obj;
        if (this.level != selectSubItemState.level) {
            return false;
        }
        String str = this.uniqueId;
        String str2 = selectSubItemState.uniqueId;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.level * 31;
        String str = this.uniqueId;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "SelectSubItemState{parentState=" + this.parentState + ", itemName='" + this.itemName + '\'' + '}';
    }

    private MultiSubItemDesc bfs(SelectSubItemState selectSubItemState) {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList();
        linkedList.add(selectSubItemState);
        int i = 0;
        while (!linkedList.isEmpty()) {
            SelectSubItemState selectSubItemState2 = (SelectSubItemState) linkedList.poll();
            sb.append(selectSubItemState2.desc.desc);
            if (selectSubItemState2.node.amount > 1) {
                sb.append(ResourceHelper.getString(R.string.customer_order_amount, Integer.valueOf(selectSubItemState2.node.amount)));
            }
            sb.append(ResourceHelper.getString(R.string.customer_global_slash));
            i += selectSubItemState2.price * selectSubItemState2.node.amount;
            if (!CollectionsUtil.isEmpty(selectSubItemState2.selectedSubItemStates)) {
                for (SelectSubItemState next : selectSubItemState2.selectedSubItemStates) {
                    if (next.isSelect()) {
                        linkedList.add(next);
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return new MultiSubItemDesc(sb.toString(), i, selectSubItemState.currency);
    }

    public static class MultiSubItemDesc implements Serializable {
        private static final long serialVersionUID = 5517704854528227251L;
        public String currency;
        public String desc;
        public int price;

        public MultiSubItemDesc(String str, int i, String str2) {
            this.desc = str;
            this.price = i;
            this.currency = str2;
        }

        public MultiSubItemDesc() {
        }

        public static MultiSubItemDesc copy(MultiSubItemDesc multiSubItemDesc) {
            return new MultiSubItemDesc(multiSubItemDesc.desc, multiSubItemDesc.price, multiSubItemDesc.currency);
        }

        public String toString() {
            return "MultiSubItemDesc{desc='" + this.desc + '\'' + ", price=" + this.price + '}';
        }
    }
}
