package com.didi.soda.customer.binder.business;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.customer.base.binder.CustomerMvpItemBinder;
import com.didi.soda.customer.base.binder.EmptyItemLogic;
import com.didi.soda.customer.binder.business.BusinessItemView;
import com.didi.soda.customer.binder.model.business.BusinessInfoRvModel;
import com.taxis99.R;

public abstract class BusinessLargeItemBinder extends CustomerMvpItemBinder<BusinessInfoRvModel, BusinessItemView.LargeViewHolder, BusinessItemUnit, EmptyItemLogic> {
    public int getColumnCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int getItemViewLayoutId() {
        return R.layout.customer_item_feed_business_large;
    }

    public BusinessLargeItemBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public Class<BusinessInfoRvModel> bindDataType() {
        return BusinessInfoRvModel.class;
    }

    public Class bindItemLogicType() {
        return EmptyItemLogic.class;
    }

    public BusinessItemView.LargeViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new BusinessItemView.LargeViewHolder(getItemView(layoutInflater, viewGroup));
    }

    public boolean extraCanBindCondition(BusinessInfoRvModel businessInfoRvModel) {
        return businessInfoRvModel.mType == 1;
    }

    /* access modifiers changed from: protected */
    public BusinessItemUnit onCreateItemUnit() {
        return new BusinessItemUnit();
    }

    /* access modifiers changed from: protected */
    public Class<BusinessItemView.LargeViewHolder> bindHolderType() {
        return BusinessItemView.LargeViewHolder.class;
    }
}
