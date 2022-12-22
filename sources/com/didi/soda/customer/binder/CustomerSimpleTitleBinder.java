package com.didi.soda.customer.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.StaggerItemViewHolder;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.binder.model.CustomerSimpleTitleRvModel;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class CustomerSimpleTitleBinder extends ItemBinder<CustomerSimpleTitleRvModel, ViewHolder> {
    public void onBind(View view, View view2) {
    }

    public void bind(ViewHolder viewHolder, CustomerSimpleTitleRvModel customerSimpleTitleRvModel) {
        viewHolder.mTitleTxt.setText(customerSimpleTitleRvModel.mTitle);
        if (customerSimpleTitleRvModel.mPaddingTopDp >= 0) {
            viewHolder.mContainerRl.setPadding(viewHolder.mContainerRl.getPaddingLeft(), DisplayUtils.dip2px(GlobalContext.getContext(), (float) customerSimpleTitleRvModel.mPaddingTopDp), viewHolder.mContainerRl.getPaddingRight(), viewHolder.mContainerRl.getPaddingBottom());
        } else {
            viewHolder.mContainerRl.setPadding(viewHolder.mContainerRl.getPaddingLeft(), DisplayUtils.dip2px(GlobalContext.getContext(), 11.0f), viewHolder.mContainerRl.getPaddingRight(), viewHolder.mContainerRl.getPaddingBottom());
        }
        if (customerSimpleTitleRvModel.mIconId != 0) {
            viewHolder.mIconIv.setVisibility(0);
            viewHolder.mIconIv.setText(customerSimpleTitleRvModel.mIconId);
        } else {
            viewHolder.mIconIv.setVisibility(8);
        }
        if (customerSimpleTitleRvModel.mTitleSizeDp > 0) {
            viewHolder.mTitleTxt.setTextSize(1, (float) customerSimpleTitleRvModel.mTitleSizeDp);
        } else {
            viewHolder.mTitleTxt.setTextSize(1, 24.0f);
        }
        if (customerSimpleTitleRvModel.mFontType != null) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mTitleTxt, customerSimpleTitleRvModel.mFontType);
        } else {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mTitleTxt, IToolsService.FontType.BOLD);
        }
        if (customerSimpleTitleRvModel.mIconId > 0) {
            onBind(viewHolder.itemView, viewHolder.itemView.findViewById(R.id.customer_iv_icon));
        }
    }

    public Class<CustomerSimpleTitleRvModel> bindDataType() {
        return CustomerSimpleTitleRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_home_feed_title, viewGroup, false));
    }

    static class ViewHolder extends StaggerItemViewHolder<CustomerSimpleTitleRvModel> {
        RelativeLayout mContainerRl = ((RelativeLayout) findViewById(R.id.customer_rl_title_container));
        IconTextView mIconIv = ((IconTextView) findViewById(R.id.customer_iv_icon));
        TextView mTitleTxt = ((TextView) findViewById(R.id.customer_tv_txt_title));

        ViewHolder(View view) {
            super(view);
        }
    }
}
