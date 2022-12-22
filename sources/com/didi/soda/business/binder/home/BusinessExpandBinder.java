package com.didi.soda.business.binder.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.business.binder.home.BusinessExpandBinder;
import com.didi.soda.business.model.BusinessExpandRvModel;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;

public class BusinessExpandBinder extends ItemBinder<BusinessExpandRvModel, ViewHolder> {
    /* access modifiers changed from: protected */
    public void clickExpandAction(BusinessExpandRvModel businessExpandRvModel, int i) {
    }

    /* access modifiers changed from: protected */
    public void onExpandClickEvent(BusinessExpandRvModel businessExpandRvModel) {
    }

    /* access modifiers changed from: protected */
    public void onExpandShow(BusinessExpandRvModel businessExpandRvModel) {
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_business_home_expand, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, BusinessExpandRvModel businessExpandRvModel) {
        viewHolder.bind(businessExpandRvModel);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(businessExpandRvModel, viewHolder) {
            public final /* synthetic */ BusinessExpandRvModel f$1;
            public final /* synthetic */ BusinessExpandBinder.ViewHolder f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                BusinessExpandBinder.this.lambda$bind$0$BusinessExpandBinder(this.f$1, this.f$2, view);
            }
        });
        onExpandShow(businessExpandRvModel);
    }

    public /* synthetic */ void lambda$bind$0$BusinessExpandBinder(BusinessExpandRvModel businessExpandRvModel, ViewHolder viewHolder, View view) {
        onExpandClickEvent(businessExpandRvModel);
        businessExpandRvModel.mIsExpand = !businessExpandRvModel.mIsExpand;
        viewHolder.updateExpandState(businessExpandRvModel);
        clickExpandAction(businessExpandRvModel, viewHolder.getAdapterPosition());
        onExpandShow(businessExpandRvModel);
    }

    public Class<BusinessExpandRvModel> bindDataType() {
        return BusinessExpandRvModel.class;
    }

    class ViewHolder extends ItemViewHolder<BusinessExpandRvModel> {
        private TextView mExpandIconView;
        private TextView mExpandTextView;

        public ViewHolder(View view) {
            super(view);
            this.mExpandTextView = (TextView) view.findViewById(R.id.customer_tv_business_home_expand_name);
            this.mExpandIconView = (TextView) view.findViewById(R.id.customer_tv_expand_icon);
        }

        /* access modifiers changed from: package-private */
        public void bind(BusinessExpandRvModel businessExpandRvModel) {
            updateExpandState(businessExpandRvModel);
        }

        /* access modifiers changed from: package-private */
        public void updateExpandState(BusinessExpandRvModel businessExpandRvModel) {
            if (businessExpandRvModel.mIsExpand) {
                this.mExpandTextView.setText(ResourceHelper.getString(R.string.FoodC_page__KoEd));
                this.mExpandIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_small_outlined_spread));
                return;
            }
            int size = businessExpandRvModel.mExpandList.size();
            if (size <= 0) {
                size = businessExpandRvModel.mComponentModelExpandList.size();
            }
            this.mExpandTextView.setText(ResourceHelper.getPlurals(R.plurals.customer_show_all_sold_out, size + 1));
            this.mExpandIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_small_outlined_pickup));
        }
    }
}
