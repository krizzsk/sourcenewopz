package com.didi.soda.goodsV2.helper;

import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.SentenceUtil;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GoodsPurchaseOmegaModel {
    public String mCartId;
    public String mCartInfo;
    public String mCurContentId;
    public int mCurContentIsMust;
    public String mCurContentType;
    public String mCurSelectedSubItemId;
    public int mCurSelectedSubItemType;
    public GoodsSelectedOmegaModel mGoodsSelectOmegaModel = new GoodsSelectedOmegaModel();
    public int mHasMultiContents;
    public Map<String, String> mInvalidSubItemIdMap = new HashMap();
    public int mIsMultiLevel;
    public int mRequiredSelections;
    public int mSelectType;
    public int mUnRequiredSelections;
    public Map<String, String> mValidSubItemIdMap = new HashMap();

    public void setCartId(String str) {
        this.mCartId = str;
    }

    public void setCartInfo(CartInfoEntity cartInfoEntity) {
        int i;
        JsonObject jsonObject = new JsonObject();
        int i2 = 0;
        if (!CollectionsUtil.isEmpty(cartInfoEntity.getItems())) {
            i = 0;
            for (CartItemEntity amount : cartInfoEntity.getItems()) {
                i += amount.getAmount();
            }
        } else {
            i = 0;
        }
        if (cartInfoEntity.getPrices() != null) {
            i2 = cartInfoEntity.getPrices().getCartFavorPrice();
        }
        jsonObject.addProperty("amount", (Number) Integer.valueOf(i));
        jsonObject.addProperty("price", (Number) Integer.valueOf(i2));
        this.mCartInfo = jsonObject.toString();
    }

    public void setRequiredSelections(int i) {
        this.mRequiredSelections = i;
    }

    public void setUnRequiredSelections(int i) {
        this.mUnRequiredSelections = i;
    }

    public void setSelectOmegaModel(Set<GoodsSubItemEntity> set) {
        if (!CollectionsUtil.isEmpty(set)) {
            HashMap hashMap = new HashMap();
            for (GoodsSubItemEntity next : set) {
                if (!hashMap.containsKey(next.contentId)) {
                    hashMap.put(next.contentId, new ArrayList());
                }
                ((List) hashMap.get(next.contentId)).add(next);
            }
            for (String str : hashMap.keySet()) {
                GoodsContentOmegaModel goodsContentOmegaModel = new GoodsContentOmegaModel();
                goodsContentOmegaModel.mContentId = str;
                goodsContentOmegaModel.mSubItemId = SentenceUtil.foldStringList(GoodsSubItemEntity.transformEntityToId((List) hashMap.get(str)), ",");
                this.mGoodsSelectOmegaModel.mSelectedSubItemList.add(goodsContentOmegaModel);
            }
        }
    }

    public class GoodsSelectedOmegaModel implements Serializable {
        private static final long serialVersionUID = -3635652630561004317L;
        @SerializedName("selected_subitems")
        List<GoodsContentOmegaModel> mSelectedSubItemList = new ArrayList();

        public GoodsSelectedOmegaModel() {
        }
    }

    public class GoodsContentOmegaModel implements Serializable {
        private static final long serialVersionUID = 8625544499516073617L;
        @SerializedName("content_id")
        String mContentId;
        @SerializedName("subitem_id")
        String mSubItemId;

        public GoodsContentOmegaModel() {
        }
    }
}
