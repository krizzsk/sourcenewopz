package com.didi.soda.goods.binder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.sdk.log.util.UiThreadHandler;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goods.GoodsMultiLevelContainerView;
import com.didi.soda.customer.widget.goods.stepper.GoodsQuantityAnimStepper;
import com.didi.soda.customer.widget.goods.stepper.GoodsStepperListener;
import com.didi.soda.goods.binder.GoodsSelectAmountSubItemBinder;
import com.didi.soda.goods.binder.logic.AbsPurchaseSubItemLogic;
import com.didi.soda.goods.binder.logic.PurchaseSubItemLogic;
import com.didi.soda.goods.contract.GoodsSubItemStateChangeListener;
import com.didi.soda.goods.model.GoodsPurchaseSubItemRvModel;
import com.taxis99.R;

public abstract class GoodsSelectAmountSubItemBinder extends CustomerLogicItemBinder<AbsPurchaseSubItemLogic, GoodsPurchaseSubItemRvModel, ViewHolder> implements GoodsSubItemStateChangeListener {
    public /* synthetic */ void showRemindAnimation(String str) {
        GoodsSubItemStateChangeListener.CC.$default$showRemindAnimation(this, str);
    }

    public GoodsSelectAmountSubItemBinder(ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
    }

    public AbsPurchaseSubItemLogic onCreateBinderLogic() {
        return new PurchaseSubItemLogic();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_goods_purchase_select_amount_subitem, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        viewHolder.mSubItemName.setText(goodsPurchaseSubItemRvModel.mSubItemName);
        if (TextUtils.isEmpty(goodsPurchaseSubItemRvModel.mSubItemDesc)) {
            viewHolder.mSubItemDesc.setVisibility(8);
        } else {
            viewHolder.mSubItemDesc.setVisibility(0);
            viewHolder.mSubItemDesc.setText(goodsPurchaseSubItemRvModel.mSubItemDesc);
        }
        if (goodsPurchaseSubItemRvModel.displayPriceNum > 0) {
            viewHolder.mAdditionalPrice.setVisibility(0);
            TextView textView = viewHolder.mAdditionalPrice;
            textView.setText("+" + LocalizationUtils.CurrencyUtils.getCurrency((long) goodsPurchaseSubItemRvModel.displayPriceNum, goodsPurchaseSubItemRvModel.currency));
        } else {
            viewHolder.mAdditionalPrice.setVisibility(8);
        }
        handleSelectionAction(viewHolder, goodsPurchaseSubItemRvModel);
        handleTextStyle(viewHolder.mSubItemName.getContext(), viewHolder, goodsPurchaseSubItemRvModel);
        handleMultiLevelContainer(viewHolder, goodsPurchaseSubItemRvModel);
    }

    public Class<GoodsPurchaseSubItemRvModel> bindDataType() {
        return GoodsPurchaseSubItemRvModel.class;
    }

    public boolean extraCanBindCondition(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        return goodsPurchaseSubItemRvModel.canSelectAmount;
    }

    private void handleTextStyle(Context context, ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
            viewHolder.mSubItemName.setTextColor(context.getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            viewHolder.mSubItemDesc.setTextColor(context.getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            viewHolder.mAdditionalPrice.setTextColor(context.getResources().getColor(R.color.rf_color_gery_4_80_CCCCCC));
            return;
        }
        viewHolder.mSubItemName.setTextColor(context.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        viewHolder.mSubItemDesc.setTextColor(context.getResources().getColor(R.color.rf_color_gery_1_0_000000));
        viewHolder.mAdditionalPrice.setTextColor(context.getResources().getColor(R.color.rf_color_gery_1_0_000000));
    }

    private void handleSelectionAction(final ViewHolder viewHolder, final GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
            goodsPurchaseSubItemRvModel.setAddEnable(false);
            viewHolder.mGoodsStepper.initState(goodsPurchaseSubItemRvModel.getGoodsStepperModel());
            viewHolder.mGoodsStepper.setGoodsStepperListener((GoodsStepperListener) null);
            viewHolder.mEachView.setVisibility(8);
            return;
        }
        goodsPurchaseSubItemRvModel.setAddEnable(!goodsPurchaseSubItemRvModel.exceedLimit);
        viewHolder.mGoodsStepper.initState(goodsPurchaseSubItemRvModel.getGoodsStepperModel());
        if (goodsPurchaseSubItemRvModel.displayPriceNum <= 0 || goodsPurchaseSubItemRvModel.getCurrentAmount() < 2) {
            viewHolder.mEachView.setVisibility(8);
        } else {
            viewHolder.mEachView.setVisibility(0);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(goodsPurchaseSubItemRvModel) {
            public final /* synthetic */ GoodsPurchaseSubItemRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                GoodsSelectAmountSubItemBinder.this.lambda$handleSelectionAction$0$GoodsSelectAmountSubItemBinder(this.f$1, view);
            }
        });
        viewHolder.mGoodsStepper.setGoodsStepperListener(new GoodsStepperListener() {
            public void onAddClick() {
                if (goodsPurchaseSubItemRvModel.exceedLimit) {
                    GoodsSelectAmountSubItemBinder.this.showRemindAnimation(goodsPurchaseSubItemRvModel.mContentId);
                } else if (!GoodsSelectAmountSubItemBinder.this.canSubItemSelected(goodsPurchaseSubItemRvModel.mContentId)) {
                    GoodsSelectAmountSubItemBinder.this.showRemindAnimation(goodsPurchaseSubItemRvModel.mContentId);
                } else if (!goodsPurchaseSubItemRvModel.isMultiLevel || goodsPurchaseSubItemRvModel.hasSelectedMultiLevel()) {
                    GoodsSelectAmountSubItemBinder.this.selectSubItem(viewHolder, goodsPurchaseSubItemRvModel);
                } else {
                    ((AbsPurchaseSubItemLogic) GoodsSelectAmountSubItemBinder.this.getBinderLogic()).goMultiLevelPage(goodsPurchaseSubItemRvModel);
                }
            }

            public void onSubtractClick() {
                goodsPurchaseSubItemRvModel.decreaseAmount();
                viewHolder.mGoodsStepper.updateState(goodsPurchaseSubItemRvModel.getGoodsStepperModel());
                boolean z = true;
                if (goodsPurchaseSubItemRvModel.getCurrentAmount() > 0) {
                    goodsPurchaseSubItemRvModel.updateSelectedState(true);
                } else {
                    goodsPurchaseSubItemRvModel.resetSelectionState();
                }
                if (goodsPurchaseSubItemRvModel.getSelectedAmount() <= 0) {
                    z = false;
                }
                UiThreadHandler.postDelayed(new Runnable(goodsPurchaseSubItemRvModel, z) {
                    public final /* synthetic */ GoodsPurchaseSubItemRvModel f$1;
                    public final /* synthetic */ boolean f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        GoodsSelectAmountSubItemBinder.C139051.this.lambda$onSubtractClick$0$GoodsSelectAmountSubItemBinder$1(this.f$1, this.f$2);
                    }
                }, 300);
            }

            public /* synthetic */ void lambda$onSubtractClick$0$GoodsSelectAmountSubItemBinder$1(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel, boolean z) {
                GoodsSelectAmountSubItemBinder.this.onSelectionStateChanged(goodsPurchaseSubItemRvModel.mContentId, goodsPurchaseSubItemRvModel.mSubItemId, z);
            }
        });
    }

    public /* synthetic */ void lambda$handleSelectionAction$0$GoodsSelectAmountSubItemBinder(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel, View view) {
        if (goodsPurchaseSubItemRvModel.isMultiLevel && goodsPurchaseSubItemRvModel.getSelectedAmount() > 0) {
            ((AbsPurchaseSubItemLogic) getBinderLogic()).goMultiLevelPage(goodsPurchaseSubItemRvModel);
        }
    }

    /* access modifiers changed from: private */
    public void selectSubItem(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        goodsPurchaseSubItemRvModel.increaseAmount();
        viewHolder.mGoodsStepper.updateState(goodsPurchaseSubItemRvModel.getGoodsStepperModel());
        goodsPurchaseSubItemRvModel.updateSelectedState(true);
        UiThreadHandler.postDelayed(new Runnable(goodsPurchaseSubItemRvModel) {
            public final /* synthetic */ GoodsPurchaseSubItemRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                GoodsSelectAmountSubItemBinder.this.lambda$selectSubItem$1$GoodsSelectAmountSubItemBinder(this.f$1);
            }
        }, 300);
    }

    public /* synthetic */ void lambda$selectSubItem$1$GoodsSelectAmountSubItemBinder(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        onSelectionStateChanged(goodsPurchaseSubItemRvModel.mContentId, goodsPurchaseSubItemRvModel.mSubItemId, true);
    }

    private void handleMultiLevelContainer(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        int i = 8;
        if (goodsPurchaseSubItemRvModel == null || CollectionsUtil.isEmpty(goodsPurchaseSubItemRvModel.mMultiSubItemDesc)) {
            viewHolder.mMultiLeveContainer.setVisibility(8);
            return;
        }
        viewHolder.mMultiLeveContainer.setDate(goodsPurchaseSubItemRvModel.mMultiSubItemDesc);
        GoodsMultiLevelContainerView goodsMultiLevelContainerView = viewHolder.mMultiLeveContainer;
        if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.SELECTED) {
            i = 0;
        }
        goodsMultiLevelContainerView.setVisibility(i);
    }

    static class ViewHolder extends ItemViewHolder<GoodsPurchaseSubItemRvModel> {
        TextView mAdditionalPrice;
        TextView mEachView;
        GoodsQuantityAnimStepper mGoodsStepper;
        GoodsMultiLevelContainerView mMultiLeveContainer;
        TextView mSubItemDesc;
        TextView mSubItemName;

        ViewHolder(View view) {
            super(view);
            this.mSubItemName = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_name);
            this.mSubItemDesc = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_desc);
            this.mAdditionalPrice = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_additional_price);
            this.mEachView = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_each);
            this.mGoodsStepper = (GoodsQuantityAnimStepper) view.findViewById(R.id.customer_custom_stepper);
            this.mMultiLeveContainer = (GoodsMultiLevelContainerView) view.findViewById(R.id.customer_custom_subitem_multi_level_container);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mSubItemName, IToolsService.FontType.NORMAL);
        }
    }
}
