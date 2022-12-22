package com.didi.soda.goodsV2.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.common.map.util.CollectionUtil;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.widget.goodsV2.stepper.GoodsStepperModel;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.didi.soda.goodsV2.helper.GoodsDataHelper;
import java.util.Collection;
import java.util.List;

public class GoodsPurchaseSubItemRvModel extends BaseGoodsPurchaseRvModel implements RecyclerModel {

    /* renamed from: a */
    private int f42523a;

    /* renamed from: b */
    private int f42524b;

    /* renamed from: c */
    private int f42525c;
    public boolean canSelectAmount = false;
    public String currency;

    /* renamed from: d */
    private GoodsStepperModel f42526d;
    public int displayPriceNum;
    public boolean exceedLimit = false;
    public boolean isMultiLevel;
    public String mContentId;
    public boolean mIsMultipleSelection;
    public boolean mIsObliged;
    public List<SelectSubItemState.MultiSubItemDesc> mMultiSubItemDesc;
    public String mPrice;
    public int mPriceNum;
    public SelectionState mSelectState = SelectionState.UNSELECTED;
    public String mSubItemDesc;
    public String mSubItemId;
    public CharSequence mSubItemName;
    public String nodeId;
    public GoodsSubItemEntity subItemEntity;

    public enum SelectionState {
        DISABLED,
        UNSELECTED,
        SELECTED
    }

    public static GoodsPurchaseSubItemRvModel newInstance(GoodsSubItemEntity goodsSubItemEntity, int i, int i2) {
        GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel = new GoodsPurchaseSubItemRvModel();
        goodsPurchaseSubItemRvModel.mSubItemId = goodsSubItemEntity.itemId;
        goodsPurchaseSubItemRvModel.isMultiLevel = GoodsDataHelper.isMultiLevelSubItem(goodsSubItemEntity);
        goodsPurchaseSubItemRvModel.mSubItemName = goodsSubItemEntity.itemName;
        goodsPurchaseSubItemRvModel.mSubItemDesc = goodsSubItemEntity.shortDesc;
        goodsPurchaseSubItemRvModel.mPriceNum = goodsSubItemEntity.price;
        goodsPurchaseSubItemRvModel.displayPriceNum = goodsSubItemEntity.price;
        goodsPurchaseSubItemRvModel.nodeId = goodsSubItemEntity.node.nodeId;
        goodsPurchaseSubItemRvModel.mPrice = "+" + LocalizationUtils.CurrencyUtils.getCurrencyDisplay(goodsSubItemEntity.priceDisplay, (long) goodsSubItemEntity.price, goodsSubItemEntity.currency, ErrorConst.ModuleName.SKU);
        goodsPurchaseSubItemRvModel.f42523a = goodsSubItemEntity.status;
        goodsPurchaseSubItemRvModel.f42524b = i;
        goodsPurchaseSubItemRvModel.f42525c = i2;
        goodsPurchaseSubItemRvModel.resetSelectionState();
        goodsPurchaseSubItemRvModel.f42526d = new GoodsStepperModel();
        if (goodsPurchaseSubItemRvModel.mSelectState == SelectionState.DISABLED) {
            goodsPurchaseSubItemRvModel.f42526d.mIsAddEnabled = false;
        } else {
            goodsPurchaseSubItemRvModel.f42526d.mIsAddEnabled = !goodsPurchaseSubItemRvModel.exceedLimit;
        }
        goodsPurchaseSubItemRvModel.subItemEntity = goodsSubItemEntity;
        goodsPurchaseSubItemRvModel.currency = goodsSubItemEntity.currency;
        return goodsPurchaseSubItemRvModel;
    }

    public int getSelectedAmount() {
        if (this.mSelectState != SelectionState.SELECTED) {
            return 0;
        }
        if (this.canSelectAmount) {
            return this.f42526d.mCurQuantityNumber;
        }
        return 1;
    }

    public int getSelectedType() {
        if (this.canSelectAmount) {
            return 3;
        }
        return this.mIsMultipleSelection ? 2 : 1;
    }

    public boolean needGoMultiLevelPage() {
        return this.isMultiLevel && !hasSelectedMultiLevel();
    }

    public void setAddEnable(boolean z) {
        this.f42526d.mIsAddEnabled = z;
    }

    public void increaseAmount() {
        this.f42526d.mCurQuantityNumber++;
    }

    public void decreaseAmount() {
        GoodsStepperModel goodsStepperModel = this.f42526d;
        goodsStepperModel.mCurQuantityNumber--;
    }

    public int getCurrentAmount() {
        return this.f42526d.mCurQuantityNumber;
    }

    public void initAmount(int i) {
        this.f42526d.mCurQuantityNumber = i;
    }

    public GoodsStepperModel getGoodsStepperModel() {
        return this.f42526d;
    }

    public void disableSelectionState() {
        this.mSelectState = SelectionState.DISABLED;
    }

    public void resetSelectionState() {
        SelectionState selectionState;
        if (GoodsDataHelper.getGoodsItemState(this.f42524b, this.f42525c) == GoodsItemState.FOR_SALE) {
            if (this.f42523a == 1) {
                selectionState = SelectionState.UNSELECTED;
            } else {
                selectionState = SelectionState.DISABLED;
            }
            this.mSelectState = selectionState;
            return;
        }
        this.mSelectState = SelectionState.DISABLED;
    }

    public void updateFromState(SelectSubItemState selectSubItemState) {
        this.mMultiSubItemDesc = selectSubItemState.getDescList();
        if (selectSubItemState.isSelect()) {
            if (this.canSelectAmount) {
                initAmount(selectSubItemState.node.amount);
            }
            this.mSelectState = SelectionState.SELECTED;
            this.displayPriceNum = m29983a();
            return;
        }
        resetSelectionState();
        this.displayPriceNum = this.mPriceNum;
    }

    public void updateSelectedState(boolean z) {
        if (z) {
            this.mSelectState = SelectionState.SELECTED;
            this.displayPriceNum = m29983a();
            return;
        }
        this.mSelectState = SelectionState.UNSELECTED;
        this.displayPriceNum = this.mPriceNum;
    }

    public boolean hasSelectedMultiLevel() {
        return !CollectionUtil.isEmpty((Collection<?>) this.mMultiSubItemDesc);
    }

    /* renamed from: a */
    private int m29983a() {
        if (CollectionsUtil.isEmpty(this.mMultiSubItemDesc)) {
            return this.mPriceNum;
        }
        int i = this.mPriceNum;
        for (SelectSubItemState.MultiSubItemDesc next : this.mMultiSubItemDesc) {
            if (next != null) {
                i += next.price;
            }
        }
        return i;
    }
}
