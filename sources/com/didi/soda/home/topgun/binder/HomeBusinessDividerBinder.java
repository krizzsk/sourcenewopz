package com.didi.soda.home.topgun.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.soda.home.topgun.binder.model.HomeBusinessDividerRvModel;
import com.taxis99.R;

public class HomeBusinessDividerBinder extends ItemBinder<HomeBusinessDividerRvModel, ViewHolder> {
    public HomeBusinessDividerBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_home_business_divider, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, HomeBusinessDividerRvModel homeBusinessDividerRvModel) {
        viewHolder.mName.setText(homeBusinessDividerRvModel.mDividerName);
    }

    public Class<HomeBusinessDividerRvModel> bindDataType() {
        return HomeBusinessDividerRvModel.class;
    }

    static class ViewHolder extends ItemViewHolder<HomeBusinessDividerRvModel> {
        /* access modifiers changed from: private */
        public TextView mName;

        ViewHolder(View view) {
            super(view);
            this.mName = (TextView) view.findViewById(R.id.customer_tv_divider_name);
        }
    }
}
