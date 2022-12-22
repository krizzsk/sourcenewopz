package com.didi.soda.search.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.search.binder.model.SearchAdjustableTitleRvModel;
import com.taxis99.R;

public abstract class SearchAdjustableTitleBinder extends ItemBinder<SearchAdjustableTitleRvModel, ViewHolder> implements SearchAdjustableTitleListener {
    public void bind(ViewHolder viewHolder, final SearchAdjustableTitleRvModel searchAdjustableTitleRvModel) {
        if (!StringUtils.isEmpty(searchAdjustableTitleRvModel.title)) {
            viewHolder.mTitleTxt.setVisibility(0);
            viewHolder.mTitleTxt.setText(searchAdjustableTitleRvModel.title);
        } else {
            viewHolder.mTitleTxt.setVisibility(8);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SearchAdjustableTitleBinder.this.onAdjustableTitleExpend(searchAdjustableTitleRvModel.type);
            }
        });
    }

    public Class<SearchAdjustableTitleRvModel> bindDataType() {
        return SearchAdjustableTitleRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_search_collapse_title, viewGroup, false));
    }

    static class ViewHolder extends StaggerItemViewHolder<SearchAdjustableTitleRvModel> {
        TextView mTitleTxt = ((TextView) findViewById(R.id.customer_tv_title));

        ViewHolder(View view) {
            super(view);
        }
    }
}
