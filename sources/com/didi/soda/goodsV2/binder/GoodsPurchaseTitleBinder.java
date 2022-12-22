package com.didi.soda.goodsV2.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.goodsV2.model.GoodsPurchaseTitleRvModel;
import com.taxis99.R;

public class GoodsPurchaseTitleBinder extends ItemBinder<GoodsPurchaseTitleRvModel, ViewHolder> {
    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_goods_purchase_title, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, GoodsPurchaseTitleRvModel goodsPurchaseTitleRvModel) {
        viewHolder.mTitleTv.setText(goodsPurchaseTitleRvModel.mTitle);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mTitleTv, IToolsService.FontType.MEDIUM);
    }

    public Class<GoodsPurchaseTitleRvModel> bindDataType() {
        return GoodsPurchaseTitleRvModel.class;
    }

    class ViewHolder extends ItemViewHolder<GoodsPurchaseTitleRvModel> {
        TextView mTitleTv;

        ViewHolder(View view) {
            super(view);
            this.mTitleTv = (TextView) view.findViewById(R.id.customer_tv_goods_purchase_title);
        }
    }
}
