package com.didi.entrega.address.list.component.feed.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.entrega.address.list.component.feed.model.AddressListTitleRvModel;
import com.taxis99.R;

public class DeliveryAddressTitleBinder extends ItemBinder<AddressListTitleRvModel, ViewHolder> {
    public Class<AddressListTitleRvModel> bindDataType() {
        return AddressListTitleRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_address_list_title, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, AddressListTitleRvModel addressListTitleRvModel) {
        if (addressListTitleRvModel != null && !TextUtils.isEmpty(addressListTitleRvModel.title)) {
            viewHolder.titleTv.setText(addressListTitleRvModel.title);
            viewHolder.firstSplitView.setVisibility(addressListTitleRvModel.isFirst ? 8 : 0);
        }
    }

    static class ViewHolder extends AddressItemViewHolder<AddressListTitleRvModel> {
        View firstSplitView;
        TextView titleTv;

        ViewHolder(View view) {
            super(view);
            this.titleTv = (TextView) view.findViewById(R.id.customer_component_tv_address_title);
            this.firstSplitView = view.findViewById(R.id.customer_view_top_first_split);
        }
    }
}
