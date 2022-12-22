package com.didi.soda.business.binder.home;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.business.model.BusinessCategoryRvModel;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class BusinessCategoryItemBinder extends ItemBinder<BusinessCategoryRvModel, ViewHolder> {

    /* renamed from: a */
    int f39348a = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40);

    public void bind(ViewHolder viewHolder, BusinessCategoryRvModel businessCategoryRvModel) {
        viewHolder.bind(businessCategoryRvModel);
    }

    public Class<BusinessCategoryRvModel> bindDataType() {
        return BusinessCategoryRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_business_home_category, viewGroup, false));
    }

    public class ViewHolder extends ItemViewHolder<BusinessCategoryRvModel> {
        public BusinessCategoryRvModel item;
        public TextView mCategoryDescTv;
        TextView mCategoryNameTv;

        /* access modifiers changed from: package-private */
        public void bind(BusinessCategoryRvModel businessCategoryRvModel) {
            this.item = businessCategoryRvModel;
            this.mCategoryNameTv.setText(businessCategoryRvModel.mCategoryName);
            if (businessCategoryRvModel.isFirst) {
                bindFirstStyle(businessCategoryRvModel);
            } else {
                bindCommonStyle(businessCategoryRvModel);
            }
            this.mCategoryNameTv.setVisibility(0);
            if (TextUtils.isEmpty(businessCategoryRvModel.mCategoryDesc)) {
                this.mCategoryDescTv.setVisibility(8);
                return;
            }
            this.mCategoryDescTv.setText(businessCategoryRvModel.mCategoryDesc);
            this.mCategoryDescTv.setVisibility(0);
        }

        /* access modifiers changed from: package-private */
        public void bindFirstStyle(BusinessCategoryRvModel businessCategoryRvModel) {
            int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_32);
            if (3 == CustomerApolloUtil.getNewBusinessFeedType()) {
                dimensionPixelSize = -ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20);
            }
            if (businessCategoryRvModel.getAllDyDisplayGoods() == null || businessCategoryRvModel.getAllDyDisplayGoods().size() <= 0) {
                this.itemView.getRootView().setPadding(0, dimensionPixelSize, 0, BusinessCategoryItemBinder.this.f39348a);
                if (this.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
                    layoutParams.bottomMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20);
                    this.itemView.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.itemView.getRootView().setPadding(0, dimensionPixelSize, 0, 0);
            if (this.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                this.itemView.setLayoutParams(layoutParams2);
            }
        }

        /* access modifiers changed from: package-private */
        public void bindCommonStyle(BusinessCategoryRvModel businessCategoryRvModel) {
            if (businessCategoryRvModel.getAllDyDisplayGoods() == null || businessCategoryRvModel.getAllDyDisplayGoods().size() <= 0) {
                this.itemView.getRootView().setPadding(0, ResourceHelper.getDimensionPixelSize(R.dimen.customer_72px), 0, BusinessCategoryItemBinder.this.f39348a);
                if (this.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
                    layoutParams.bottomMargin = ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_20);
                    this.itemView.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            this.itemView.getRootView().setPadding(0, ResourceHelper.getDimensionPixelSize(R.dimen.customer_72px), 0, 0);
            if (this.itemView.getLayoutParams() instanceof RecyclerView.LayoutParams) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                this.itemView.setLayoutParams(layoutParams2);
            }
        }

        ViewHolder(View view) {
            super(view);
            this.mCategoryNameTv = (TextView) view.findViewById(R.id.customer_tv_business_home_category_name);
            this.mCategoryDescTv = (TextView) view.findViewById(R.id.customer_tv_business_home_category_desc);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mCategoryNameTv, IToolsService.FontType.BOLD);
        }
    }
}
