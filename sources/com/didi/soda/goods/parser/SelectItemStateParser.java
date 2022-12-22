package com.didi.soda.goods.parser;

import android.util.SparseArray;
import com.didi.soda.customer.foundation.rpc.entity.GoodsContentEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.goods.repo.SelectItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerGoodsManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public final class SelectItemStateParser {
    private SelectItemStateParser() {
    }

    public static ArrayList<ItemNodeEntity> mapStateRepoToCartParams(String str) {
        ArrayList<ItemNodeEntity> arrayList = new ArrayList<>();
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(str);
        if (selectItemState != null) {
            arrayList.add(selectItemState.node);
            if (selectItemState.totalLevel > selectItemState.level && selectItemState.selectedStateMap != null) {
                for (int i = selectItemState.totalLevel; i > selectItemState.level; i--) {
                    List<SelectSubItemState> levelSubItemStateList = getLevelSubItemStateList(str, i);
                    if (!CollectionsUtil.isEmpty(levelSubItemStateList)) {
                        for (SelectSubItemState next : levelSubItemStateList) {
                            if (next.canAddToCart()) {
                                arrayList.add(next.node);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static SelectItemState mapGoodsEntityToStateRepo(GoodsItemEntity goodsItemEntity) {
        SparseArray sparseArray = new SparseArray();
        if (CollectionsUtil.isEmpty(goodsItemEntity.contentList)) {
            return SelectItemState.newInstance(sparseArray, goodsItemEntity.node);
        }
        int i = goodsItemEntity.node.level + 1;
        ArrayList arrayList = new ArrayList();
        for (GoodsContentEntity next : goodsItemEntity.contentList) {
            if (!GoodsDataHelper.isContentEntityEmpty(next)) {
                m29909a(next, i, arrayList, sparseArray, (SelectSubItemState) null);
            }
        }
        return SelectItemState.newInstance(sparseArray, goodsItemEntity.node);
    }

    public static SelectSubItemState getSubItemState(String str, int i, String str2) {
        HashMap hashMap;
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(str);
        if (selectItemState == null || i > selectItemState.totalLevel || (hashMap = selectItemState.selectedStateMap.get(i)) == null || !hashMap.containsKey(str2)) {
            return null;
        }
        return (SelectSubItemState) hashMap.get(str2);
    }

    public static List<SelectSubItemState> getLevelSubItemStateList(String str, int i) {
        HashMap hashMap;
        SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(str);
        if (selectItemState == null || i > selectItemState.totalLevel || (hashMap = selectItemState.selectedStateMap.get(i)) == null) {
            return null;
        }
        return new ArrayList(hashMap.values());
    }

    public static void replaceSubItemState(String str, SelectSubItemState selectSubItemState, SelectSubItemState selectSubItemState2) {
        if (selectSubItemState2 != null) {
            SelectSubItemState subItemState = getSubItemState(str, selectSubItemState2.level, selectSubItemState2.uniqueId);
            if (selectSubItemState != null) {
                selectSubItemState.selectedSubItemStates.remove(subItemState);
                selectSubItemState.selectedSubItemStates.add(selectSubItemState2);
                selectSubItemState2.parentState = selectSubItemState;
            }
            replaceSubItemStateInMap(str, selectSubItemState2);
        }
    }

    public static void replaceSubItemStateInMap(String str, SelectSubItemState selectSubItemState) {
        if (selectSubItemState != null) {
            SelectItemState selectItemState = ((ICustomerGoodsManager) CustomerManagerLoader.loadManager(ICustomerGoodsManager.class)).getSelectItemState(str);
            if (selectItemState != null) {
                selectItemState.selectedStateMap.get(selectSubItemState.level).put(selectSubItemState.uniqueId, selectSubItemState);
            }
            if (!CollectionsUtil.isEmpty(selectSubItemState.selectedSubItemStates)) {
                for (SelectSubItemState replaceSubItemStateInMap : selectSubItemState.selectedSubItemStates) {
                    replaceSubItemStateInMap(str, replaceSubItemStateInMap);
                }
            }
        }
    }

    public static List<SelectSubItemState> filterCalculatePriceStates(Collection<SelectSubItemState> collection) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionsUtil.isEmpty(collection)) {
            for (SelectSubItemState next : collection) {
                if (next != null && next.recursiveSelect()) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m29909a(GoodsContentEntity goodsContentEntity, int i, List<SelectSubItemState> list, SparseArray<HashMap<String, SelectSubItemState>> sparseArray, SelectSubItemState selectSubItemState) {
        for (GoodsSubItemEntity next : goodsContentEntity.subItemList) {
            SelectSubItemState newInstance = SelectSubItemState.newInstance(next, i);
            newInstance.parentState = selectSubItemState;
            if (GoodsDataHelper.isMultiLevelSubItem(next)) {
                ArrayList arrayList = new ArrayList();
                for (GoodsContentEntity next2 : next.contentList) {
                    if (!GoodsDataHelper.isContentEntityEmpty(next2)) {
                        m29909a(next2, i + 1, arrayList, sparseArray, newInstance);
                    }
                }
                newInstance.selectedSubItemStates = arrayList;
            }
            list.add(newInstance);
            if (sparseArray.get(i) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put(newInstance.uniqueId, newInstance);
                sparseArray.put(i, hashMap);
            } else {
                sparseArray.get(i).put(newInstance.uniqueId, newInstance);
            }
        }
    }
}
