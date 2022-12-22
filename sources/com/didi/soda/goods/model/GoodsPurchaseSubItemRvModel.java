package com.didi.soda.goods.model;

import android.content.res.Resources;
import android.text.SpannableString;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.common.map.util.CollectionUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.GoodsSubItemEntity;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.CustomerRadiusEdgeBgSpan;
import com.didi.soda.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.stepper.GoodsStepperModel;
import com.didi.soda.goods.contract.GoodsItemState;
import com.didi.soda.goods.helper.GoodsDataHelper;
import com.didi.soda.goods.repo.SelectSubItemState;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class GoodsPurchaseSubItemRvModel extends BaseGoodsPurchaseRvModel implements RecyclerModel {

    /* renamed from: a */
    private int f42429a;

    /* renamed from: b */
    private int f42430b;

    /* renamed from: c */
    private int f42431c;
    public boolean canSelectAmount = false;
    public String currency;

    /* renamed from: d */
    private GoodsStepperModel f42432d;
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
        Resources resources = GlobalContext.getContext().getResources();
        boolean isMultiLevelSubItem = GoodsDataHelper.isMultiLevelSubItem(goodsSubItemEntity);
        goodsPurchaseSubItemRvModel.isMultiLevel = isMultiLevelSubItem;
        if (isMultiLevelSubItem) {
            SpannableString spannableString = new SpannableString(goodsSubItemEntity.itemName + " " + resources.getString(R.string.customer_goods_purchase_multi_tag));
            CustomerRadiusEdgeBgSpan customerRadiusEdgeBgSpan = new CustomerRadiusEdgeBgSpan(resources.getDimensionPixelOffset(R.dimen.customer_text_size_22px), resources.getColor(R.color.rf_color_gery_1_0_000000), resources.getColor(R.color.rf_color_gery_4_80_CCCCCC), resources.getDimensionPixelOffset(R.dimen.customer_4px), resources.getDimensionPixelOffset(R.dimen.customer_12px), resources.getDimensionPixelOffset(R.dimen.customer_36px));
            spannableString.setSpan(customerRadiusEdgeBgSpan, (goodsSubItemEntity.itemName + " ").length(), spannableString.length(), 33);
            CustomerTypeFaceSpan customerTypeFaceSpan = new CustomerTypeFaceSpan(((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.NORMAL));
            spannableString.setSpan(customerTypeFaceSpan, (goodsSubItemEntity.itemName + " ").length(), spannableString.length(), 33);
            goodsPurchaseSubItemRvModel.mSubItemName = spannableString;
        } else {
            goodsPurchaseSubItemRvModel.mSubItemName = goodsSubItemEntity.itemName;
        }
        goodsPurchaseSubItemRvModel.mSubItemDesc = goodsSubItemEntity.shortDesc;
        goodsPurchaseSubItemRvModel.mPriceNum = goodsSubItemEntity.price;
        goodsPurchaseSubItemRvModel.displayPriceNum = goodsSubItemEntity.price;
        goodsPurchaseSubItemRvModel.nodeId = goodsSubItemEntity.node.nodeId;
        goodsPurchaseSubItemRvModel.mPrice = "+" + LocalizationUtils.CurrencyUtils.getCurrencyDisplay(goodsSubItemEntity.priceDisplay, (long) goodsSubItemEntity.price, goodsSubItemEntity.currency, ErrorConst.ModuleName.SKU);
        goodsPurchaseSubItemRvModel.f42429a = goodsSubItemEntity.status;
        goodsPurchaseSubItemRvModel.f42430b = i;
        goodsPurchaseSubItemRvModel.f42431c = i2;
        goodsPurchaseSubItemRvModel.resetSelectionState();
        goodsPurchaseSubItemRvModel.f42432d = new GoodsStepperModel();
        if (goodsPurchaseSubItemRvModel.mSelectState == SelectionState.DISABLED) {
            goodsPurchaseSubItemRvModel.f42432d.mIsAddEnabled = false;
        } else {
            goodsPurchaseSubItemRvModel.f42432d.mIsAddEnabled = !goodsPurchaseSubItemRvModel.exceedLimit;
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
            return this.f42432d.mCurQuantityNumber;
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
        this.f42432d.mIsAddEnabled = z;
    }

    public void increaseAmount() {
        this.f42432d.mCurQuantityNumber++;
    }

    public void decreaseAmount() {
        GoodsStepperModel goodsStepperModel = this.f42432d;
        goodsStepperModel.mCurQuantityNumber--;
    }

    public int getCurrentAmount() {
        return this.f42432d.mCurQuantityNumber;
    }

    public void initAmount(int i) {
        this.f42432d.mCurQuantityNumber = i;
    }

    public GoodsStepperModel getGoodsStepperModel() {
        return this.f42432d;
    }

    public void disableSelectionState() {
        this.mSelectState = SelectionState.DISABLED;
    }

    public void resetSelectionState() {
        SelectionState selectionState;
        if (GoodsDataHelper.getGoodsItemState(this.f42430b, this.f42431c) == GoodsItemState.FOR_SALE) {
            if (this.f42429a == 1) {
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
            this.displayPriceNum = m29908a();
            return;
        }
        resetSelectionState();
        this.displayPriceNum = this.mPriceNum;
    }

    public void updateSelectedState(boolean z) {
        if (z) {
            this.mSelectState = SelectionState.SELECTED;
            this.displayPriceNum = m29908a();
            return;
        }
        this.mSelectState = SelectionState.UNSELECTED;
        this.displayPriceNum = this.mPriceNum;
    }

    public boolean hasSelectedMultiLevel() {
        return !CollectionUtil.isEmpty((Collection<?>) this.mMultiSubItemDesc);
    }

    /* renamed from: a */
    private int m29908a() {
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
