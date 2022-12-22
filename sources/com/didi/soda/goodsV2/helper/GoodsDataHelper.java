package com.didi.soda.goodsV2.helper;

import com.didi.soda.business.manager.BusinessDataHelper;
import com.didi.soda.customer.foundation.rpc.entity.GoodsContentEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.contract.GoodsAmountModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class GoodsDataHelper {
    public static boolean isBuyGift(int i) {
        return i == 4;
    }

    public static boolean isEFO(int i) {
        return i == 100;
    }

    public static boolean isNormal(int i) {
        return i == 1;
    }

    public static boolean isRegularCustomer(int i) {
        return i == 101;
    }

    public static boolean isSpecialPrice(int i) {
        return i == 2;
    }

    private GoodsDataHelper() {
    }

    public static boolean hasMultipleContents(GoodsItemEntity goodsItemEntity) {
        return goodsItemEntity != null && !CollectionsUtil.isEmpty(goodsItemEntity.contentList);
    }

    public static boolean hasMultipleSelection(GoodsContentEntity goodsContentEntity) {
        return goodsContentEntity != null && goodsContentEntity.maxItemNum > 1;
    }

    public static boolean isContentObliged(GoodsContentEntity goodsContentEntity) {
        return goodsContentEntity != null && goodsContentEntity.isMust == 1;
    }

    public static boolean isMultiLevelSubItem(GoodsSubItemEntity goodsSubItemEntity) {
        return goodsSubItemEntity != null && !CollectionsUtil.isEmpty(goodsSubItemEntity.contentList);
    }

    public static boolean isContentEntityEmpty(GoodsContentEntity goodsContentEntity) {
        return goodsContentEntity == null || CollectionsUtil.isEmpty(goodsContentEntity.subItemList);
    }

    public static boolean isMultiLevelItem(GoodsItemEntity goodsItemEntity) {
        return (goodsItemEntity == null || goodsItemEntity.node == null || goodsItemEntity.node.totalLevel <= 2) ? false : true;
    }

    public static boolean hasActivity(GoodsItemEntity goodsItemEntity) {
        return goodsItemEntity.activityType > 0;
    }

    public static boolean hasEFOActivityInfo(GoodsItemEntity goodsItemEntity) {
        return (goodsItemEntity == null || goodsItemEntity.activityType != 100 || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.platSpecial == null) ? false : true;
    }

    public static boolean hasBuyGiftActivityInfo(GoodsItemEntity goodsItemEntity) {
        return (goodsItemEntity == null || !isBuyGift(goodsItemEntity.activityType) || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.buyGift == null) ? false : true;
    }

    public static boolean hasSpecialPriceActivityInfo(GoodsItemEntity goodsItemEntity) {
        return (goodsItemEntity == null || goodsItemEntity.activityType != 2 || goodsItemEntity.activityInfo == null || goodsItemEntity.activityInfo.special == null) ? false : true;
    }

    public static boolean isBuyGift(GoodsItemEntity goodsItemEntity) {
        return goodsItemEntity != null && goodsItemEntity.activityType == 4;
    }

    public static boolean canBuyMoreSubItems(GoodsContentEntity goodsContentEntity) {
        return goodsContentEntity != null && goodsContentEntity.buyMode == 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel> parseGoodsItemEntity(com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity r16, int r17, com.didi.soda.goods.repo.SelectItemState r18, java.util.Set<com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity> r19, java.util.HashMap<java.lang.String, com.didi.soda.goods.repo.SelectSubItemState> r20, java.lang.String r21) {
        /*
            r0 = r16
            r1 = r18
            r3 = 1
            if (r1 == 0) goto L_0x0018
            int r1 = r1.level
            int r1 = r1 + r3
            r4 = r21
            java.util.List r1 = com.didi.soda.goodsV2.parser.SelectItemStateParser.getLevelSubItemStateList(r4, r1)
            boolean r4 = com.didi.soda.customer.foundation.util.CollectionsUtil.isEmpty(r1)
            if (r4 != 0) goto L_0x0019
            r4 = 1
            goto L_0x001a
        L_0x0018:
            r1 = 0
        L_0x0019:
            r4 = 0
        L_0x001a:
            java.util.LinkedHashMap r5 = new java.util.LinkedHashMap
            r5.<init>()
            boolean r6 = hasMultipleContents(r16)
            if (r6 == 0) goto L_0x00f2
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.GoodsContentEntity> r6 = r0.contentList
            java.util.Iterator r6 = r6.iterator()
            r7 = 0
        L_0x002c:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x00f2
            java.lang.Object r8 = r6.next()
            com.didi.soda.customer.foundation.rpc.entity.GoodsContentEntity r8 = (com.didi.soda.customer.foundation.rpc.entity.GoodsContentEntity) r8
            boolean r9 = isContentEntityEmpty(r8)
            if (r9 == 0) goto L_0x003f
            goto L_0x002c
        L_0x003f:
            com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel r9 = com.didi.soda.goodsV2.model.GoodsPurchaseContentRvModel.newInstance(r8)
            r9.setRvIndex(r7)
            int r7 = r7 + 1
            if (r4 == 0) goto L_0x0052
            boolean r10 = canBuyMoreSubItems(r8)
            if (r10 == 0) goto L_0x0052
            r10 = 1
            goto L_0x0053
        L_0x0052:
            r10 = 0
        L_0x0053:
            java.util.List<com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity> r11 = r8.subItemList
            java.util.Iterator r11 = r11.iterator()
            r12 = 0
        L_0x005a:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x00c1
            java.lang.Object r13 = r11.next()
            com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity r13 = (com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity) r13
            int r14 = r0.status
            r15 = r17
            com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel r14 = com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel.newInstance(r13, r14, r15)
            if (r4 == 0) goto L_0x009e
            com.didi.soda.goods.repo.SelectSubItemState r2 = r13.filterState(r1)
            if (r2 == 0) goto L_0x009e
            r14.updateFromState(r2)
            int r0 = r13.status
            if (r0 != r3) goto L_0x009e
            boolean r0 = r2.isSelect()
            if (r0 == 0) goto L_0x009e
            java.lang.String r0 = r2.uniqueId
            r3 = r20
            r3.put(r0, r2)
            r0 = r19
            r0.add(r13)
            if (r10 == 0) goto L_0x00a2
            com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity r13 = r2.node
            int r13 = r13.amount
            r14.initAmount(r13)
            com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity r2 = r2.node
            int r2 = r2.amount
            int r12 = r12 + r2
            goto L_0x00a2
        L_0x009e:
            r0 = r19
            r3 = r20
        L_0x00a2:
            java.lang.String r2 = r8.contentId
            r14.mContentId = r2
            boolean r2 = hasMultipleSelection(r8)
            r14.mIsMultipleSelection = r2
            boolean r2 = r9.mIsObliged
            r14.mIsObliged = r2
            boolean r2 = canBuyMoreSubItems(r8)
            r14.canSelectAmount = r2
            java.util.List<com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel> r2 = r9.mSubItemList
            r2.add(r14)
            int r7 = r7 + 1
            r0 = r16
            r3 = 1
            goto L_0x005a
        L_0x00c1:
            r15 = r17
            r0 = r19
            r3 = r20
            if (r10 == 0) goto L_0x00e5
            int r2 = r9.mMaxItemNum
            if (r12 < r2) goto L_0x00cf
            r2 = 1
            goto L_0x00d0
        L_0x00cf:
            r2 = 0
        L_0x00d0:
            java.util.List<com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel> r8 = r9.mSubItemList
            java.util.Iterator r8 = r8.iterator()
        L_0x00d6:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x00e5
            java.lang.Object r10 = r8.next()
            com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel r10 = (com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel) r10
            r10.exceedLimit = r2
            goto L_0x00d6
        L_0x00e5:
            r9.updateSatisfiedState()
            java.lang.String r2 = r9.mContentId
            r5.put(r2, r9)
            r0 = r16
            r3 = 1
            goto L_0x002c
        L_0x00f2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.goodsV2.helper.GoodsDataHelper.parseGoodsItemEntity(com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity, int, com.didi.soda.goods.repo.SelectItemState, java.util.Set, java.util.HashMap, java.lang.String):java.util.Map");
    }

    public static Map<String, GoodsPurchaseContentRvModel> parseMultiLevelSubItem(GoodsSubItemEntity goodsSubItemEntity, int i, SelectSubItemState selectSubItemState, Set<GoodsSubItemEntity> set, HashMap<String, SelectSubItemState> hashMap) {
        SelectSubItemState filterState;
        GoodsSubItemEntity goodsSubItemEntity2 = goodsSubItemEntity;
        SelectSubItemState selectSubItemState2 = selectSubItemState;
        int i2 = 1;
        boolean z = selectSubItemState2 != null && !CollectionsUtil.isEmpty(selectSubItemState2.selectedSubItemStates);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = 0;
        for (GoodsContentEntity next : goodsSubItemEntity2.contentList) {
            if (!isContentEntityEmpty(next)) {
                GoodsPurchaseContentRvModel newInstance = GoodsPurchaseContentRvModel.newInstance(next);
                newInstance.setRvIndex(i3);
                i3++;
                boolean z2 = z && canBuyMoreSubItems(next);
                int i4 = 0;
                for (GoodsSubItemEntity next2 : next.subItemList) {
                    GoodsPurchaseSubItemRvModel newInstance2 = GoodsPurchaseSubItemRvModel.newInstance(next2, goodsSubItemEntity2.status, i);
                    if (z && (filterState = next2.filterState(selectSubItemState2.selectedSubItemStates)) != null) {
                        newInstance2.updateFromState(filterState);
                        if (next2.status == i2 && filterState.isSelect()) {
                            if (filterState.recursiveSelect()) {
                                hashMap.put(filterState.uniqueId, filterState);
                            } else {
                                HashMap<String, SelectSubItemState> hashMap2 = hashMap;
                            }
                            set.add(next2);
                            if (z2) {
                                newInstance2.initAmount(filterState.node.amount);
                                i4 += filterState.node.amount;
                            }
                            newInstance2.mContentId = next.contentId;
                            newInstance2.mIsMultipleSelection = hasMultipleSelection(next);
                            newInstance2.mIsObliged = newInstance.mIsObliged;
                            newInstance2.canSelectAmount = canBuyMoreSubItems(next);
                            newInstance.mSubItemList.add(newInstance2);
                            i3++;
                            goodsSubItemEntity2 = goodsSubItemEntity;
                            i2 = 1;
                        }
                    }
                    Set<GoodsSubItemEntity> set2 = set;
                    HashMap<String, SelectSubItemState> hashMap3 = hashMap;
                    newInstance2.mContentId = next.contentId;
                    newInstance2.mIsMultipleSelection = hasMultipleSelection(next);
                    newInstance2.mIsObliged = newInstance.mIsObliged;
                    newInstance2.canSelectAmount = canBuyMoreSubItems(next);
                    newInstance.mSubItemList.add(newInstance2);
                    i3++;
                    goodsSubItemEntity2 = goodsSubItemEntity;
                    i2 = 1;
                }
                int i5 = i;
                Set<GoodsSubItemEntity> set3 = set;
                HashMap<String, SelectSubItemState> hashMap4 = hashMap;
                if (z2) {
                    boolean z3 = i4 >= newInstance.mMaxItemNum;
                    for (GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel : newInstance.mSubItemList) {
                        goodsPurchaseSubItemRvModel.exceedLimit = z3;
                    }
                }
                newInstance.updateSatisfiedState();
                linkedHashMap.put(newInstance.mContentId, newInstance);
                goodsSubItemEntity2 = goodsSubItemEntity;
                i2 = 1;
            }
        }
        return linkedHashMap;
    }

    public static GoodsSubItemEntity findGoodsSubItemEntity(GoodsItemEntity goodsItemEntity, String str, String str2) {
        if (CollectionsUtil.isEmpty(goodsItemEntity.contentList)) {
            return null;
        }
        for (GoodsContentEntity next : goodsItemEntity.contentList) {
            if (str.equals(next.contentId) && !CollectionsUtil.isEmpty(next.subItemList)) {
                for (GoodsSubItemEntity next2 : next.subItemList) {
                    if (str2.equals(next2.itemId)) {
                        return next2;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static GoodsSubItemEntity filterSubItemEntity(GoodsContentEntity goodsContentEntity, String str) {
        if (goodsContentEntity != null && !CollectionsUtil.isEmpty(goodsContentEntity.subItemList)) {
            for (GoodsSubItemEntity next : goodsContentEntity.subItemList) {
                if (str != null && str.equals(next.itemId)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static GoodsSubItemEntity filterSubItemEntity(GoodsSubItemEntity goodsSubItemEntity, String str, String str2) {
        if (!isMultiLevelSubItem(goodsSubItemEntity)) {
            return null;
        }
        for (GoodsContentEntity next : goodsSubItemEntity.contentList) {
            if (next != null && next.contentId != null && next.contentId.equals(str) && !CollectionsUtil.isEmpty(next.subItemList)) {
                for (GoodsSubItemEntity next2 : next.subItemList) {
                    if (next2 != null && next2.itemId != null && next2.itemId.equals(str2)) {
                        return next2;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static GoodsItemState getGoodsItemState(int i, int i2) {
        return getGoodsItemState(i, -1, i2);
    }

    public static GoodsItemState getGoodsItemState(int i, int i2, int i3) {
        GoodsItemState goodsItemState = GoodsItemState.UNDEFINED;
        if (!BusinessDataHelper.checkBusinessStatusNormal(i3)) {
            return GoodsItemState.SHOP_DISABLED;
        }
        if (i == 1) {
            return GoodsItemState.FOR_SALE;
        }
        if (i != 2) {
            return goodsItemState;
        }
        return i2 == 3 ? GoodsItemState.LIMIT_SALE : GoodsItemState.SOLD_OUT;
    }

    public static GoodsItemState getGoodsItemState(int i) {
        return getGoodsItemState(i, 1);
    }

    public static GoodsItemState getGoodsItemState(GoodsItemEntity goodsItemEntity, int i) {
        return getGoodsItemState(goodsItemEntity.status, goodsItemEntity.soldStatus, i);
    }

    public static boolean hasGoodsAmountChanged(GoodsAmountModel goodsAmountModel, ItemState itemState, int i) {
        return goodsAmountModel.getCurrentAmount() != itemState.amount;
    }

    public static boolean isSoldOutOrLimitSale(GoodsItemState goodsItemState) {
        return goodsItemState == GoodsItemState.SOLD_OUT || goodsItemState == GoodsItemState.LIMIT_SALE;
    }
}
