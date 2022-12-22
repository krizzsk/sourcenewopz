package com.didi.soda.address.component.search.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.address.component.search.binder.AddressSearchBinder;
import com.didi.soda.address.model.AddressSearchRvModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class AddressSearchBinder extends ItemBinder<AddressSearchRvModel, ViewHolder> {

    /* renamed from: a */
    private OnSelectAddressListener f38695a;

    public interface OnSelectAddressListener {
        void onAddressSelected(AddressSearchRvModel addressSearchRvModel, int i);
    }

    public AddressSearchBinder(OnSelectAddressListener onSelectAddressListener) {
        this.f38695a = onSelectAddressListener;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_item_address_search_result, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, AddressSearchRvModel addressSearchRvModel) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(addressSearchRvModel, viewHolder) {
            public final /* synthetic */ AddressSearchRvModel f$1;
            public final /* synthetic */ AddressSearchBinder.ViewHolder f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                AddressSearchBinder.this.m27413a(this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27413a(AddressSearchRvModel addressSearchRvModel, ViewHolder viewHolder, View view) {
        this.f38695a.onAddressSelected(addressSearchRvModel, viewHolder.getAdapterPosition());
    }

    public Class<AddressSearchRvModel> bindDataType() {
        return AddressSearchRvModel.class;
    }

    class ViewHolder extends ItemViewHolder<AddressSearchRvModel> {
        private TextView mAddressDetailView;
        private TextView mAddressDistanceView;
        private TextView mAddressNameView;
        private View mContentView;
        private View mDivider;

        public ViewHolder(View view) {
            super(view);
            this.mContentView = view.findViewById(R.id.customer_cl_address_search_item_content);
            this.mAddressNameView = (TextView) view.findViewById(R.id.customer_tv_address_search_name);
            this.mAddressDistanceView = (TextView) view.findViewById(R.id.customer_tv_address_search_distance);
            this.mAddressDetailView = (TextView) view.findViewById(R.id.customer_tv_address_detail);
            this.mDivider = view.findViewById(R.id.customer_v_address_search_divider);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressNameView, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressDistanceView, IToolsService.FontType.LIGHT);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mAddressDetailView, IToolsService.FontType.LIGHT);
        }

        public void setItem(AddressSearchRvModel addressSearchRvModel) {
            super.setItem(addressSearchRvModel);
            dealStyle(addressSearchRvModel);
            if (addressSearchRvModel.mAddress == null || addressSearchRvModel.mAddress.poi == null) {
                this.mAddressNameView.setText("");
                this.mAddressDistanceView.setText("");
                this.mAddressDetailView.setText("");
                return;
            }
            AddressEntity.PoiEntity poiEntity = addressSearchRvModel.mAddress.poi;
            this.mAddressNameView.setText(poiEntity.displayName);
            this.mAddressDistanceView.setText(poiEntity.distStr);
            if (!TextUtils.isEmpty(poiEntity.addressAllDisplay)) {
                this.mAddressDetailView.setText(poiEntity.addressAllDisplay);
                this.mAddressDetailView.setVisibility(0);
                return;
            }
            this.mAddressDetailView.setVisibility(8);
        }

        private void dealStyle(AddressSearchRvModel addressSearchRvModel) {
            this.mContentView.setBackgroundResource(R.drawable.customer_selector_search_item);
            this.mDivider.setVisibility(0);
            int adapterPosition = getAdapterPosition();
            if (adapterPosition == 0) {
                this.mContentView.setBackgroundResource(R.drawable.customer_selector_search_item_radius_up);
                this.mDivider.setVisibility(4);
            }
            if (addressSearchRvModel.isLast) {
                this.mContentView.setBackgroundResource(R.drawable.customer_selector_search_item_radius_below);
                ((ViewGroup.MarginLayoutParams) this.mContentView.getLayoutParams()).bottomMargin = DisplayUtils.dip2px(this.mContentView.getContext(), 10.0f);
            } else {
                ((ViewGroup.MarginLayoutParams) this.mContentView.getLayoutParams()).bottomMargin = DisplayUtils.dip2px(this.mContentView.getContext(), 0.0f);
            }
            if (addressSearchRvModel.isLast && adapterPosition == 0) {
                this.mContentView.setBackgroundResource(R.drawable.customer_selector_search_item_radius);
            }
        }
    }
}
