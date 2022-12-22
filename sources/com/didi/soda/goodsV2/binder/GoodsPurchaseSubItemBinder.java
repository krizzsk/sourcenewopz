package com.didi.soda.goodsV2.binder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.locale.LocalizationUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.goodsV2.GoodsMultiLevelContainerView;
import com.didi.soda.goodsV2.binder.GoodsPurchaseSubItemBinder;
import com.didi.soda.goodsV2.binder.logic.AbsPurchaseSubItemLogic;
import com.didi.soda.goodsV2.binder.logic.PurchaseSubItemLogic;
import com.didi.soda.goodsV2.contract.GoodsSubItemStateChangeListener;
import com.didi.soda.goodsV2.model.GoodsPurchaseSubItemRvModel;
import com.taxis99.R;

public abstract class GoodsPurchaseSubItemBinder extends CustomerLogicItemBinder<AbsPurchaseSubItemLogic, GoodsPurchaseSubItemRvModel, ViewHolder> implements GoodsSubItemStateChangeListener {
    public /* synthetic */ void showRemindAnimation(String str) {
        GoodsSubItemStateChangeListener.CC.$default$showRemindAnimation(this, str);
    }

    public GoodsPurchaseSubItemBinder(ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
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
        handleSelectionState(viewHolder, goodsPurchaseSubItemRvModel);
        handleSelectionAction(viewHolder, goodsPurchaseSubItemRvModel);
        handleTextStyle(viewHolder.mSubItemName.getContext(), viewHolder, goodsPurchaseSubItemRvModel);
        handleMultiLevelContainer(viewHolder, goodsPurchaseSubItemRvModel);
    }

    public Class<GoodsPurchaseSubItemRvModel> bindDataType() {
        return GoodsPurchaseSubItemRvModel.class;
    }

    public boolean extraCanBindCondition(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        return !goodsPurchaseSubItemRvModel.canSelectAmount;
    }

    public AbsPurchaseSubItemLogic onCreateBinderLogic() {
        return new PurchaseSubItemLogic();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_goods_purchase_subitem_v2, viewGroup, false));
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

    private void handleSelectionAction(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        if (goodsPurchaseSubItemRvModel.mSelectState != GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(goodsPurchaseSubItemRvModel, viewHolder) {
                public final /* synthetic */ GoodsPurchaseSubItemRvModel f$1;
                public final /* synthetic */ GoodsPurchaseSubItemBinder.ViewHolder f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    GoodsPurchaseSubItemBinder.this.lambda$handleSelectionAction$0$GoodsPurchaseSubItemBinder(this.f$1, this.f$2, view);
                }
            });
            viewHolder.mSelectionIv.setOnClickListener(new View.OnClickListener(goodsPurchaseSubItemRvModel, viewHolder) {
                public final /* synthetic */ GoodsPurchaseSubItemRvModel f$1;
                public final /* synthetic */ GoodsPurchaseSubItemBinder.ViewHolder f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    GoodsPurchaseSubItemBinder.this.lambda$handleSelectionAction$1$GoodsPurchaseSubItemBinder(this.f$1, this.f$2, view);
                }
            });
            return;
        }
        viewHolder.itemView.setOnClickListener((View.OnClickListener) null);
        viewHolder.mSelectionIv.setOnClickListener((View.OnClickListener) null);
    }

    public /* synthetic */ void lambda$handleSelectionAction$0$GoodsPurchaseSubItemBinder(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel, ViewHolder viewHolder, View view) {
        if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
            viewHolder.mSelectionIv.setOnClickListener((View.OnClickListener) null);
        } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.UNSELECTED) {
            selectSubItem(viewHolder, goodsPurchaseSubItemRvModel);
        } else if (goodsPurchaseSubItemRvModel.mSelectState != GoodsPurchaseSubItemRvModel.SelectionState.SELECTED) {
        } else {
            if (goodsPurchaseSubItemRvModel.isMultiLevel) {
                ((AbsPurchaseSubItemLogic) getBinderLogic()).goMultiLevelPage(goodsPurchaseSubItemRvModel);
            } else if (goodsPurchaseSubItemRvModel.mIsMultipleSelection || !goodsPurchaseSubItemRvModel.mIsObliged) {
                goodsPurchaseSubItemRvModel.updateSelectedState(false);
                handleSelectionState(viewHolder, goodsPurchaseSubItemRvModel);
                onSelectionStateChanged(goodsPurchaseSubItemRvModel.mContentId, goodsPurchaseSubItemRvModel.mSubItemId, false);
            }
        }
    }

    public /* synthetic */ void lambda$handleSelectionAction$1$GoodsPurchaseSubItemBinder(GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel, ViewHolder viewHolder, View view) {
        if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
            viewHolder.mSelectionIv.setOnClickListener((View.OnClickListener) null);
        } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.SELECTED) {
            unSelectSubItem(viewHolder, goodsPurchaseSubItemRvModel);
        } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.UNSELECTED) {
            selectSubItem(viewHolder, goodsPurchaseSubItemRvModel);
        }
    }

    private void selectSubItem(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        if (canSubItemSelected(goodsPurchaseSubItemRvModel.mContentId)) {
            actualSelectSubItem(viewHolder, goodsPurchaseSubItemRvModel);
        } else if (!goodsPurchaseSubItemRvModel.mIsMultipleSelection) {
            if (goodsPurchaseSubItemRvModel.needGoMultiLevelPage()) {
                resetSelectionState(goodsPurchaseSubItemRvModel.mContentId, true);
            } else {
                resetSelectionState(goodsPurchaseSubItemRvModel.mContentId, false);
            }
            actualSelectSubItem(viewHolder, goodsPurchaseSubItemRvModel);
        } else {
            showRemindAnimation(goodsPurchaseSubItemRvModel.mContentId);
        }
    }

    private void actualSelectSubItem(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        if (goodsPurchaseSubItemRvModel.needGoMultiLevelPage()) {
            ((AbsPurchaseSubItemLogic) getBinderLogic()).goMultiLevelPage(goodsPurchaseSubItemRvModel);
            return;
        }
        goodsPurchaseSubItemRvModel.updateSelectedState(true);
        handleSelectionState(viewHolder, goodsPurchaseSubItemRvModel);
        onSelectionStateChanged(goodsPurchaseSubItemRvModel.mContentId, goodsPurchaseSubItemRvModel.mSubItemId, true);
    }

    private void unSelectSubItem(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        if (goodsPurchaseSubItemRvModel.mIsMultipleSelection || !goodsPurchaseSubItemRvModel.mIsObliged) {
            goodsPurchaseSubItemRvModel.updateSelectedState(false);
            handleSelectionState(viewHolder, goodsPurchaseSubItemRvModel);
            onSelectionStateChanged(goodsPurchaseSubItemRvModel.mContentId, goodsPurchaseSubItemRvModel.mSubItemId, false);
        }
    }

    private void handleSelectionState(ViewHolder viewHolder, GoodsPurchaseSubItemRvModel goodsPurchaseSubItemRvModel) {
        boolean z = goodsPurchaseSubItemRvModel.mIsMultipleSelection;
        int i = R.drawable.customer_ic_goods_multiple_unselected_arrow_v2;
        int i2 = R.drawable.customer_ic_goods_multiple_selection_arrow_disabled_v2;
        if (z) {
            if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
                ImageView imageView = viewHolder.mSelectionIv;
                if (!goodsPurchaseSubItemRvModel.isMultiLevel) {
                    i2 = R.drawable.customer_ic_goods_multiple_selection_disabled_v2;
                }
                imageView.setImageResource(i2);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mAdditionalPrice, IToolsService.FontType.NORMAL);
            } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.UNSELECTED) {
                ImageView imageView2 = viewHolder.mSelectionIv;
                if (!goodsPurchaseSubItemRvModel.isMultiLevel) {
                    i = R.drawable.customer_ic_goods_multiple_unselected_v2;
                }
                imageView2.setImageResource(i);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mAdditionalPrice, IToolsService.FontType.NORMAL);
            } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.SELECTED) {
                viewHolder.mSelectionIv.setImageResource(R.drawable.customer_ic_goods_multiple_selected_v2);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mAdditionalPrice, IToolsService.FontType.BOLD);
            }
        } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.DISABLED) {
            ImageView imageView3 = viewHolder.mSelectionIv;
            if (!goodsPurchaseSubItemRvModel.isMultiLevel) {
                i2 = R.drawable.customer_ic_goods_single_selection_disabled_v2;
            }
            imageView3.setImageResource(i2);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mAdditionalPrice, IToolsService.FontType.NORMAL);
        } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.UNSELECTED) {
            ImageView imageView4 = viewHolder.mSelectionIv;
            if (!goodsPurchaseSubItemRvModel.isMultiLevel) {
                i = R.drawable.customer_ic_goods_single_unselected_v2;
            }
            imageView4.setImageResource(i);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mAdditionalPrice, IToolsService.FontType.NORMAL);
        } else if (goodsPurchaseSubItemRvModel.mSelectState == GoodsPurchaseSubItemRvModel.SelectionState.SELECTED) {
            viewHolder.mSelectionIv.setImageResource(R.drawable.customer_ic_goods_single_selected_v2);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mAdditionalPrice, IToolsService.FontType.BOLD);
        }
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
        GoodsMultiLevelContainerView mMultiLeveContainer;
        ImageView mSelectionIv;
        TextView mSubItemDesc;
        TextView mSubItemName;

        ViewHolder(View view) {
            super(view);
            this.mSelectionIv = (ImageView) view.findViewById(R.id.customer_iv_goods_sub_item_select_icon);
            this.mSubItemName = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_name);
            this.mSubItemDesc = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_desc);
            this.mAdditionalPrice = (TextView) view.findViewById(R.id.customer_tv_goods_sub_item_additional_price);
            this.mMultiLeveContainer = (GoodsMultiLevelContainerView) view.findViewById(R.id.customer_custom_subitem_multi_level_container);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mSubItemName, IToolsService.FontType.NORMAL);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAdditionalPrice, IToolsService.FontType.NORMAL);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mSubItemDesc, IToolsService.FontType.NORMAL);
        }
    }
}
