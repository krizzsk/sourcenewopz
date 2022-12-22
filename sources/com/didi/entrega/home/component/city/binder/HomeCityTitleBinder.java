package com.didi.entrega.home.component.city.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.home.component.city.model.HomeCityTitleRvModel;
import com.taxis99.R;

public class HomeCityTitleBinder extends ItemBinder<HomeCityTitleRvModel, ViewHolder> {
    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_item_home_city_title, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, HomeCityTitleRvModel homeCityTitleRvModel) {
        viewHolder.mName.setText(homeCityTitleRvModel.mCountryName);
    }

    public Class<HomeCityTitleRvModel> bindDataType() {
        return HomeCityTitleRvModel.class;
    }

    static class ViewHolder extends ItemViewHolder<HomeCityTitleRvModel> {
        /* access modifiers changed from: private */
        public TextView mName;

        ViewHolder(View view) {
            super(view);
            this.mName = (TextView) view.findViewById(R.id.entrega_city_title);
        }
    }
}
