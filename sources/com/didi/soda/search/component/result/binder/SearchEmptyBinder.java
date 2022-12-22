package com.didi.soda.search.component.result.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.search.component.result.SearchEmptyRvModel;
import com.taxis99.R;

public class SearchEmptyBinder extends ItemBinder<SearchEmptyRvModel, ViewHolder> {
    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_search_empty, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, SearchEmptyRvModel searchEmptyRvModel) {
        viewHolder.mDesTextView.setText(searchEmptyRvModel.mText);
    }

    public Class<SearchEmptyRvModel> bindDataType() {
        return SearchEmptyRvModel.class;
    }

    class ViewHolder extends StaggerItemViewHolder<SearchEmptyRvModel> {
        public CustomerAppCompatTextView mDesTextView;

        public ViewHolder(View view) {
            super(view);
            this.mDesTextView = (CustomerAppCompatTextView) view.findViewById(R.id.customer_search_empty_des);
        }
    }
}
