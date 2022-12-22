package com.didi.soda.goodsV2.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.taxis99.R;

public class EmptyHeightBinder extends ItemBinder<HeightData, ViewHolder> {
    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_empty, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, HeightData heightData) {
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        layoutParams.height = heightData.mHeight;
        viewHolder.itemView.setLayoutParams(layoutParams);
    }

    public Class<HeightData> bindDataType() {
        return HeightData.class;
    }

    public static class ViewHolder extends ItemViewHolder<HeightData> {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public static class HeightData {
        public int mHeight;

        public HeightData(int i) {
            this.mHeight = i;
        }
    }
}
