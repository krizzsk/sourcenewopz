package com.didi.soda.order.binder.receipt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.model.OrderReceiptHeaderRvModel;
import com.taxis99.R;

public abstract class OrderReceiptHeaderBinder extends ItemBinder<OrderReceiptHeaderRvModel, ViewHolder> {
    public abstract void onBind(View view, TextView textView);

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_binder_receipt_header, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, OrderReceiptHeaderRvModel orderReceiptHeaderRvModel) {
        onBind(viewHolder.itemView, viewHolder.mReceiptTitleTv);
    }

    public Class<OrderReceiptHeaderRvModel> bindDataType() {
        return OrderReceiptHeaderRvModel.class;
    }

    public static class ViewHolder extends ItemViewHolder<OrderReceiptHeaderRvModel> {
        /* access modifiers changed from: private */
        public TextView mReceiptTitleTv;

        public ViewHolder(View view) {
            super(view);
            this.mReceiptTitleTv = (TextView) view.findViewById(R.id.customer_tv_send_receipt);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mReceiptTitleTv, IToolsService.FontType.MEDIUM);
        }
    }
}
