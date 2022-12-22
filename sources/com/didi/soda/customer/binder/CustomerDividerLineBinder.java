package com.didi.soda.customer.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.binder.model.CustomerDividerLineRvModel;
import com.taxis99.R;

public class CustomerDividerLineBinder extends ItemBinder<CustomerDividerLineRvModel, ViewHolder> {
    public void bind(ViewHolder viewHolder, CustomerDividerLineRvModel customerDividerLineRvModel) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewHolder.mDividerLine.getLayoutParams();
        layoutParams.height = customerDividerLineRvModel.mHeight;
        layoutParams.leftMargin = customerDividerLineRvModel.mHorizontalPadding;
        layoutParams.rightMargin = customerDividerLineRvModel.mHorizontalPadding;
        layoutParams.topMargin = customerDividerLineRvModel.mVerticalPadding;
        layoutParams.bottomMargin = customerDividerLineRvModel.mVerticalPadding;
        viewHolder.mDividerLine.setLayoutParams(layoutParams);
        viewHolder.mDividerLine.setBackgroundColor(customerDividerLineRvModel.mColor);
    }

    public Class<CustomerDividerLineRvModel> bindDataType() {
        return CustomerDividerLineRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item_customer_divider_line, viewGroup, false));
    }

    static class ViewHolder extends ItemViewHolder<CustomerDividerLineRvModel> {
        View mDividerLine = ((View) findViewById(R.id.divider_line_view));

        ViewHolder(View view) {
            super(view);
        }
    }
}
