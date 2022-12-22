package com.didi.entrega.address.list.component.feed.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.address.list.component.feed.binder.DeliveryAddressBinder;
import com.didi.entrega.address.list.component.feed.listener.OnAddressClickListener;
import com.didi.entrega.address.list.component.feed.listener.OnAddressDeleteClickListener;
import com.didi.entrega.address.list.component.feed.listener.OnAddressLocationListener;
import com.didi.entrega.address.list.component.feed.model.DeliveryAddressRvModel;
import com.didi.entrega.address.utils.AddressUtil;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.taxis99.R;

public abstract class DeliveryAddressBinder extends ItemBinder<DeliveryAddressRvModel, ViewHolder> implements OnAddressClickListener, OnAddressDeleteClickListener, OnAddressLocationListener {
    public DeliveryAddressBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public Class<DeliveryAddressRvModel> bindDataType() {
        return DeliveryAddressRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_address_recommend_item_address, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        int i = 4;
        if (deliveryAddressRvModel.addressType == 4) {
            bindLocation(viewHolder, deliveryAddressRvModel);
        } else {
            bindAddress(viewHolder, deliveryAddressRvModel);
        }
        boolean z = deliveryAddressRvModel.mIsFirst;
        if (deliveryAddressRvModel.addressType == 4) {
            z = true;
        }
        setStyle(viewHolder, z, deliveryAddressRvModel.mIsLast, deliveryAddressRvModel);
        View view = viewHolder.mDividerView;
        if (!z) {
            i = 0;
        }
        view.setVisibility(i);
    }

    private void setStyle(ViewHolder viewHolder, boolean z, boolean z2, DeliveryAddressRvModel deliveryAddressRvModel) {
        if (z && z2) {
            viewHolder.itemView.setBackgroundResource(R.drawable.entrega_customer_shape_bg_address_top_bottom_card);
        } else if (z) {
            viewHolder.itemView.setBackgroundResource(R.drawable.entrega_customer_shape_bg_address_top_card);
        } else if (z2) {
            viewHolder.itemView.setBackgroundResource(R.drawable.entrega_customer_shape_bg_address_bottom_card);
        } else {
            viewHolder.itemView.setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
        }
    }

    private void bindAddress(ViewHolder viewHolder, final DeliveryAddressRvModel deliveryAddressRvModel) {
        if (viewHolder.mLoadingView.isAnimating()) {
            viewHolder.mLoadingView.stop();
        }
        viewHolder.mLoadingView.setVisibility(8);
        viewHolder.mOpenLocation.setVisibility(8);
        viewHolder.mAddressDetailView.setVisibility(0);
        viewHolder.mAddressNameTv.setVisibility(0);
        if (deliveryAddressRvModel.addressType == 3) {
            viewHolder.mDeleteView.setVisibility(0);
            viewHolder.mDeleteView.setOnClickListener(new View.OnClickListener(deliveryAddressRvModel) {
                public final /* synthetic */ DeliveryAddressRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DeliveryAddressBinder.this.lambda$bindAddress$0$DeliveryAddressBinder(this.f$1, view);
                }
            });
            updateUserInfo(viewHolder, deliveryAddressRvModel);
            viewHolder.mAddressDistanceView.setVisibility(4);
        } else if (deliveryAddressRvModel.addressType == 2) {
            updateUserInfo(viewHolder, deliveryAddressRvModel);
            viewHolder.mDeleteView.setOnClickListener((View.OnClickListener) null);
            viewHolder.mDeleteView.setVisibility(4);
            viewHolder.mAddressDistanceView.setVisibility(4);
        } else {
            viewHolder.mDeleteView.setOnClickListener((View.OnClickListener) null);
            viewHolder.mDeleteView.setVisibility(4);
            viewHolder.mAddressDistanceView.setVisibility(0);
            viewHolder.mAddressUserNameTv.setVisibility(8);
            viewHolder.mAddressUserPhoneTv.setVisibility(8);
        }
        if (AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            AddressEntity.PoiEntity poiEntity = deliveryAddressRvModel.mAddress.poi;
            viewHolder.mAddressNameTv.setText(poiEntity.displayName);
            viewHolder.mAddressDistanceView.setText(poiEntity.distStr);
            if (deliveryAddressRvModel.addressType == 2 || deliveryAddressRvModel.addressType == 3) {
                if (deliveryAddressRvModel.mAddress == null || TextUtils.isEmpty(deliveryAddressRvModel.mAddress.houseNumber)) {
                    viewHolder.mAddressDetailView.setVisibility(8);
                } else {
                    viewHolder.mAddressDetailView.setText(deliveryAddressRvModel.mAddress.houseNumber);
                }
            } else if (!TextUtils.isEmpty(poiEntity.addressAllDisplay)) {
                viewHolder.mAddressDetailView.setText(poiEntity.addressAllDisplay);
            } else {
                viewHolder.mAddressDetailView.setVisibility(8);
            }
            viewHolder.mParentView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DeliveryAddressBinder.this.onAddressClick(deliveryAddressRvModel);
                }
            });
            return;
        }
        viewHolder.mAddressNameTv.setText("");
        viewHolder.mAddressDistanceView.setText("");
        viewHolder.mAddressDetailView.setText("");
        viewHolder.mParentView.setOnClickListener((View.OnClickListener) null);
    }

    public /* synthetic */ void lambda$bindAddress$0$DeliveryAddressBinder(DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        onAddressDeleteClick(deliveryAddressRvModel);
    }

    private void updateUserInfo(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        String userName = getUserName(deliveryAddressRvModel);
        if (TextUtils.isEmpty(userName)) {
            viewHolder.mAddressUserNameTv.setVisibility(8);
        } else {
            viewHolder.mAddressUserNameTv.setText(userName);
            viewHolder.mAddressUserNameTv.setVisibility(0);
        }
        String userPhone = getUserPhone(deliveryAddressRvModel);
        if (TextUtils.isEmpty(userPhone)) {
            viewHolder.mAddressUserPhoneTv.setVisibility(8);
            return;
        }
        viewHolder.mAddressUserPhoneTv.setText(userPhone);
        viewHolder.mAddressUserPhoneTv.setVisibility(0);
    }

    private String getUserName(DeliveryAddressRvModel deliveryAddressRvModel) {
        if (deliveryAddressRvModel == null || deliveryAddressRvModel.mAddress == null) {
            return null;
        }
        String str = "";
        if (!TextUtils.isEmpty(deliveryAddressRvModel.mAddress.firstName)) {
            str = str + deliveryAddressRvModel.mAddress.firstName;
        }
        if (TextUtils.isEmpty(deliveryAddressRvModel.mAddress.lastName)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + " ";
        }
        return str + deliveryAddressRvModel.mAddress.lastName;
    }

    private String getUserPhone(DeliveryAddressRvModel deliveryAddressRvModel) {
        if (deliveryAddressRvModel == null || deliveryAddressRvModel.mAddress == null || TextUtils.isEmpty(deliveryAddressRvModel.mAddress.phone)) {
            return null;
        }
        String str = "";
        if (!TextUtils.isEmpty(deliveryAddressRvModel.mAddress.callingCode)) {
            str = str + deliveryAddressRvModel.mAddress.callingCode;
        }
        if (TextUtils.isEmpty(deliveryAddressRvModel.mAddress.phone)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            str = str + "-";
        }
        return str + deliveryAddressRvModel.mAddress.phone;
    }

    private void bindLocation(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        if (viewHolder.mLoadingView.isAnimating()) {
            viewHolder.mLoadingView.stop();
        }
        viewHolder.mLoadingView.setVisibility(8);
        viewHolder.mAddressNameTv.setVisibility(0);
        viewHolder.mAddressDetailView.setVisibility(0);
        if (!deliveryAddressRvModel.mGpsEnable || !deliveryAddressRvModel.mLocationPermissionOpen) {
            viewHolder.mAddressDistanceView.setVisibility(8);
            viewHolder.mOpenLocation.setVisibility(0);
            viewHolder.mAddressNameTv.setText(deliveryAddressRvModel.mGpsEnable ? R.string.FoodC_search_Unauthorized_location_WySd : R.string.FoodC_search_Automatic_Location_jUlm);
            viewHolder.mAddressDetailView.setText(deliveryAddressRvModel.mGpsEnable ? R.string.FoodC_search_Authorization_synonymous_azEw : R.string.FoodC_search_Open_automatic_PBOq);
            viewHolder.mOpenLocation.setText(ResourceHelper.getString(R.string.FoodC_search_Open_vHZD));
            viewHolder.mOpenLocation.setOnClickListener(new View.OnClickListener(deliveryAddressRvModel) {
                public final /* synthetic */ DeliveryAddressRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DeliveryAddressBinder.this.lambda$bindLocation$2$DeliveryAddressBinder(this.f$1, view);
                }
            });
            return;
        }
        viewHolder.mAddressDistanceView.setVisibility(8);
        viewHolder.mOpenLocation.setVisibility(0);
        viewHolder.mOpenLocation.setText(ResourceHelper.getString(R.string.FoodC_search_Try_again_AciX));
        viewHolder.mOpenLocation.setOnClickListener(new View.OnClickListener(viewHolder, deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressBinder.ViewHolder f$1;
            public final /* synthetic */ DeliveryAddressRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DeliveryAddressBinder.this.lambda$bindLocation$1$DeliveryAddressBinder(this.f$1, this.f$2, view);
            }
        });
        viewHolder.mAddressNameTv.setText(R.string.FoodC_search_Unable_to_UwcS);
        viewHolder.mAddressDetailView.setText(R.string.FoodC_search_Trying_to_lsIK);
    }

    public /* synthetic */ void lambda$bindLocation$1$DeliveryAddressBinder(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        viewHolder.mLoadingView.setVisibility(0);
        onLocationClick(deliveryAddressRvModel.mGpsEnable, deliveryAddressRvModel.mLocationPermissionOpen);
        viewHolder.mLoadingView.start();
        viewHolder.mOpenLocation.setVisibility(4);
    }

    public /* synthetic */ void lambda$bindLocation$2$DeliveryAddressBinder(DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        onLocationClick(deliveryAddressRvModel.mGpsEnable, deliveryAddressRvModel.mLocationPermissionOpen);
    }

    private void onLocationClick(boolean z, boolean z2) {
        if (!z2) {
            onOpenLocationPermission();
        } else if (!z) {
            onOpenLocation();
        } else {
            onRetryLocation();
        }
    }

    static class ViewHolder extends AddressItemViewHolder<DeliveryAddressRvModel> {
        TextView mAddressDetailView = ((TextView) findViewById(R.id.customer_tv_address_all));
        TextView mAddressDistanceView = ((TextView) findViewById(R.id.customer_tv_address_distance));
        TextView mAddressNameTv = ((TextView) findViewById(R.id.customer_tv_address_name));
        TextView mAddressUserNameTv = ((TextView) findViewById(R.id.customer_tv_address_user_name));
        TextView mAddressUserPhoneTv = ((TextView) findViewById(R.id.customer_tv_address_user_phone));
        View mDeleteView = ((View) findViewById(R.id.customer_iv_address_delete));
        View mDividerView = ((View) findViewById(R.id.customer_v_address_search_divider));
        LottieLoadingView mLoadingView = ((LottieLoadingView) findViewById(R.id.customer_widget_address_loading));
        RFGhostButton mOpenLocation = ((RFGhostButton) findViewById(R.id.customer_tv_address_des));
        View mParentView = ((View) findViewById(R.id.customer_cl_address_search_item_content));

        ViewHolder(View view) {
            super(view);
        }
    }
}
