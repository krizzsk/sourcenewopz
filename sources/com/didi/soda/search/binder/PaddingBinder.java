package com.didi.soda.search.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.soda.search.binder.model.PaddingRvModel;
import com.taxis99.R;

public class PaddingBinder extends ItemBinder<PaddingRvModel, ViewHolder> {
    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_padding, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, PaddingRvModel paddingRvModel) {
        viewHolder.mPaddingView.setLayoutParams(new FrameLayout.LayoutParams(-1, paddingRvModel.mPadding));
    }

    public Class<PaddingRvModel> bindDataType() {
        return PaddingRvModel.class;
    }

    static class ViewHolder extends StaggerItemViewHolder<PaddingRvModel> {
        View mPaddingView;

        ViewHolder(View view) {
            super(view);
            this.mPaddingView = view.findViewById(R.id.customer_view_padding);
        }
    }
}
