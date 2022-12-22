package com.didi.entrega.address.list.component.feed.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.entrega.address.list.component.feed.model.AddressListSplitRvModel;
import com.taxis99.R;

public class DeliveryAddressSplitDecoratorBinder extends ItemBinder<AddressListSplitRvModel, ViewHolder> {
    public void bind(ViewHolder viewHolder, AddressListSplitRvModel addressListSplitRvModel) {
    }

    public Class<AddressListSplitRvModel> bindDataType() {
        return AddressListSplitRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_address_list_group_split, viewGroup, false));
    }

    static class ViewHolder extends AddressItemViewHolder<AddressListSplitRvModel> {
        ViewHolder(View view) {
            super(view);
        }
    }
}
