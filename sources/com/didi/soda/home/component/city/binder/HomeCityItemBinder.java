package com.didi.soda.home.component.city.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.home.component.city.model.HomeCityItemRvModel;
import com.taxis99.R;

public abstract class HomeCityItemBinder extends ItemBinder<HomeCityItemRvModel, ViewHolder> {
    public abstract void clickCity(HomeCityItemRvModel homeCityItemRvModel);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_home_city_item, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, HomeCityItemRvModel homeCityItemRvModel) {
        viewHolder.mName.setText(homeCityItemRvModel.mCityName);
        viewHolder.mDivider.setVisibility(homeCityItemRvModel.mShowDivider ? 0 : 8);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(homeCityItemRvModel) {
            public final /* synthetic */ HomeCityItemRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                HomeCityItemBinder.this.lambda$bind$0$HomeCityItemBinder(this.f$1, view);
            }
        });
    }

    public /* synthetic */ void lambda$bind$0$HomeCityItemBinder(HomeCityItemRvModel homeCityItemRvModel, View view) {
        clickCity(homeCityItemRvModel);
    }

    public Class<HomeCityItemRvModel> bindDataType() {
        return HomeCityItemRvModel.class;
    }

    static class ViewHolder extends ItemViewHolder<HomeCityItemRvModel> {
        /* access modifiers changed from: private */
        public View mDivider;
        /* access modifiers changed from: private */
        public TextView mName;

        ViewHolder(View view) {
            super(view);
            this.mName = (TextView) view.findViewById(R.id.customer_tv_name);
            this.mDivider = view.findViewById(R.id.customer_view_divider);
        }
    }
}
