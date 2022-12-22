package com.didi.soda.address.component.feed.binder;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.didi.rfusion.widget.button.RFGhostButton;
import com.didi.soda.address.component.feed.binder.AddressAnimUtil;
import com.didi.soda.address.component.feed.binder.DeliveryAddressBinder;
import com.didi.soda.address.component.feed.listener.OnAddressClickListener;
import com.didi.soda.address.component.feed.listener.OnAddressHandleListener;
import com.didi.soda.address.component.feed.listener.OnAddressLocationListener;
import com.didi.soda.address.component.feed.view.AddressItemViewHolder;
import com.didi.soda.address.manager.AddressMessageRepo;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public abstract class DeliveryAddressBinder extends ItemBinder<DeliveryAddressRvModel, ViewHolder> implements OnAddressClickListener, OnAddressHandleListener, OnAddressLocationListener {
    public DeliveryAddressBinder(ItemDecorator itemDecorator) {
        super(itemDecorator);
    }

    public Class<DeliveryAddressRvModel> bindDataType() {
        return DeliveryAddressRvModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(layoutInflater.inflate(R.layout.customer_address_recommend_item_address, viewGroup, false));
    }

    public void bind(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        if (deliveryAddressRvModel.addressType == 8) {
            bindLocation(viewHolder, deliveryAddressRvModel);
        } else {
            bindAddress(viewHolder, deliveryAddressRvModel);
        }
        TextView textView = viewHolder.mAddressAllTv;
        boolean z = deliveryAddressRvModel.mIsChecked;
        int i = R.color.rf_color_brands_1_100;
        textView.setTextColor(ResourceHelper.getColor(z ? R.color.rf_color_brands_1_100 : R.color.rf_color_gery_1_0_000000));
        TextView textView2 = viewHolder.mAddressNameTv;
        if (!deliveryAddressRvModel.mIsChecked) {
            i = R.color.rf_color_gery_1_0_000000;
        }
        textView2.setTextColor(ResourceHelper.getColor(i));
        boolean z2 = false;
        if (!deliveryAddressRvModel.mIsChecked || TextUtils.isEmpty(deliveryAddressRvModel.mAddressTipContent)) {
            viewHolder.mAddressTipContainer.setVisibility(8);
        } else {
            viewHolder.mAddressTip.setText(deliveryAddressRvModel.mAddressTipContent);
            viewHolder.mAddressTipContainer.setVisibility(0);
        }
        viewHolder.mAddressDeleteView.setVisibility(deliveryAddressRvModel.isDeletable() ? 0 : 8);
        viewHolder.mAddressDeleteView.setOnClickListener(new View.OnClickListener(deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressRvModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                DeliveryAddressBinder.this.lambda$bind$0$DeliveryAddressBinder(this.f$1, view);
            }
        });
        if (deliveryAddressRvModel.addressType == 8) {
            z2 = true;
        }
        setStyle(viewHolder, z2, deliveryAddressRvModel.mIsLast, deliveryAddressRvModel);
        viewHolder.mMaskView.setEnabled(true);
        viewHolder.mMaskView.setOnClickListener(new View.OnClickListener(deliveryAddressRvModel, viewHolder) {
            public final /* synthetic */ DeliveryAddressRvModel f$1;
            public final /* synthetic */ DeliveryAddressBinder.ViewHolder f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DeliveryAddressBinder.this.lambda$bind$1$DeliveryAddressBinder(this.f$1, this.f$2, view);
            }
        });
    }

    public /* synthetic */ void lambda$bind$0$DeliveryAddressBinder(DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        onAddressDeleteClick(deliveryAddressRvModel, deliveryAddressRvModel.addressType);
    }

    public /* synthetic */ void lambda$bind$1$DeliveryAddressBinder(DeliveryAddressRvModel deliveryAddressRvModel, ViewHolder viewHolder, View view) {
        onAddressClick(deliveryAddressRvModel.mAddress, deliveryAddressRvModel.addressType, viewHolder.getAdapterPosition());
    }

    private void setStyle(ViewHolder viewHolder, boolean z, boolean z2, DeliveryAddressRvModel deliveryAddressRvModel) {
        if (z && z2) {
            viewHolder.mMaskView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_bottom_12_corners);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_shape_bg_address_top_bottom_card);
        } else if (z) {
            viewHolder.mMaskView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_top_12_corners);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_shape_bg_address_top_card);
        } else if (z2) {
            viewHolder.mMaskView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0_bottom_12_corners);
            viewHolder.itemView.setBackgroundResource(R.drawable.customer_shape_bg_address_bottom_card);
        } else {
            viewHolder.mMaskView.setBackgroundResource(R.drawable.customer_selector_trans_to_f0);
            viewHolder.itemView.setBackgroundResource(R.color.rf_color_white_100_FFFFFF);
        }
        if (!z) {
            AddressAnimUtil.showEditGuideAnim(viewHolder.itemView, viewHolder.mAddressDeleteView);
        }
        AddressAnimUtil.resetMoveStatus(viewHolder, deliveryAddressRvModel);
    }

    private void bindAddress(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        int i = 0;
        viewHolder.mAddressEdit.setVisibility(deliveryAddressRvModel.isEditable() ? 0 : 8);
        viewHolder.mAddressEdit.setOnClickListener(new View.OnClickListener(viewHolder, deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressBinder.ViewHolder f$1;
            public final /* synthetic */ DeliveryAddressRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DeliveryAddressBinder.this.lambda$bindAddress$2$DeliveryAddressBinder(this.f$1, this.f$2, view);
            }
        });
        viewHolder.mAddressSlideEditView.setVisibility(8);
        viewHolder.mLoadingView.setVisibility(8);
        viewHolder.mOpenLocation.setVisibility(8);
        if (deliveryAddressRvModel.mAddress != null) {
            AddressEntity addressEntity = deliveryAddressRvModel.mAddress;
            if (!TextUtils.isEmpty(addressEntity.houseNumber) || !TextUtils.isEmpty(addressEntity.buildingName)) {
                viewHolder.mHouseNumber.setVisibility(0);
                viewHolder.mHouseNumber.setText(addressEntity.getAptAndBuildingName());
                viewHolder.mHouseNumber.setTextColor(ResourceHelper.getColor(deliveryAddressRvModel.mIsChecked ? R.color.rf_color_brands_1_100 : R.color.rf_color_gery_1_0_000000));
            } else {
                viewHolder.mHouseNumber.setVisibility(8);
            }
            if (!TextUtils.isEmpty(addressEntity.getAidTypeName())) {
                viewHolder.mAddressTagTv.setVisibility(0);
                viewHolder.mAddressTagTv.setText(addressEntity.getAidTypeName());
            } else {
                viewHolder.mAddressTagTv.setVisibility(8);
            }
            if (addressEntity.poi != null) {
                viewHolder.mAddressNameTv.setText(addressEntity.getPoiDisplayName());
                viewHolder.mAddressAllTv.setText(addressEntity.poi.addressAllDisplay);
                TextView textView = viewHolder.mAddressAllTv;
                if (TextUtils.isEmpty(addressEntity.poi.addressAllDisplay)) {
                    i = 8;
                }
                textView.setVisibility(i);
            }
        }
    }

    public /* synthetic */ void lambda$bindAddress$2$DeliveryAddressBinder(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        viewHolder.onMoveIn();
        onAddressEditClick(deliveryAddressRvModel, deliveryAddressRvModel.addressType);
    }

    private void bindLocation(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel) {
        if (viewHolder.mLoadingView.isAnimating()) {
            viewHolder.mLoadingView.stop();
        }
        viewHolder.mAddressEdit.setVisibility(8);
        viewHolder.mAddressSlideEditView.setVisibility(deliveryAddressRvModel.isEditable() ? 0 : 8);
        viewHolder.mAddressSlideEditView.setOnClickListener(new View.OnClickListener(viewHolder, deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressBinder.ViewHolder f$1;
            public final /* synthetic */ DeliveryAddressRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DeliveryAddressBinder.this.lambda$bindLocation$3$DeliveryAddressBinder(this.f$1, this.f$2, view);
            }
        });
        viewHolder.mHouseNumber.setVisibility(8);
        viewHolder.mAddressTagTv.setVisibility(8);
        viewHolder.mLoadingView.setVisibility(8);
        viewHolder.mAddressAllTv.setVisibility(0);
        if (!deliveryAddressRvModel.mGpsEnable || !deliveryAddressRvModel.mLocationPermissionOpen) {
            viewHolder.mAddressNameTv.setText(ResourceHelper.getString(R.string.FoodC_homepage_No_authorized_cuWA));
            viewHolder.mOpenLocation.setVisibility(0);
            viewHolder.mAddressAllTv.setText(deliveryAddressRvModel.mLocationPermissionOpen ? R.string.customer_address_location_service_unless : R.string.customer_address_location_permission_unless);
            viewHolder.mOpenLocation.setText(ResourceHelper.getString(R.string.customer_address_gps_enable_open));
            viewHolder.mOpenLocation.setOnClickListener(new View.OnClickListener(deliveryAddressRvModel) {
                public final /* synthetic */ DeliveryAddressRvModel f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    DeliveryAddressBinder.this.lambda$bindLocation$5$DeliveryAddressBinder(this.f$1, view);
                }
            });
            return;
        }
        if (AddressUtil.checkAddressValid(deliveryAddressRvModel.mAddress)) {
            viewHolder.mAddressNameTv.setText(ResourceHelper.getString(R.string.customer_address_location_title));
            AddressEntity.PoiEntity poiEntity = deliveryAddressRvModel.mAddress.poi;
            if (!TextUtils.isEmpty(poiEntity.addressAll)) {
                viewHolder.mAddressAllTv.setText(poiEntity.addressAll);
            } else {
                viewHolder.mAddressAllTv.setText(poiEntity.displayName);
            }
        } else {
            viewHolder.mAddressNameTv.setText(ResourceHelper.getString(R.string.FoodC_homepage_Unable_to_ybHC));
            viewHolder.mAddressAllTv.setText(R.string.customer_address_gps_no_location);
        }
        viewHolder.mOpenLocation.setVisibility(0);
        viewHolder.mOpenLocation.setText(ResourceHelper.getString(R.string.FoodC_Collection__BjDl));
        viewHolder.mOpenLocation.setOnClickListener(new View.OnClickListener(viewHolder, deliveryAddressRvModel) {
            public final /* synthetic */ DeliveryAddressBinder.ViewHolder f$1;
            public final /* synthetic */ DeliveryAddressRvModel f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                DeliveryAddressBinder.this.lambda$bindLocation$4$DeliveryAddressBinder(this.f$1, this.f$2, view);
            }
        });
    }

    public /* synthetic */ void lambda$bindLocation$3$DeliveryAddressBinder(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        viewHolder.onMoveIn();
        onAddressEditClick(deliveryAddressRvModel, deliveryAddressRvModel.addressType);
    }

    public /* synthetic */ void lambda$bindLocation$4$DeliveryAddressBinder(ViewHolder viewHolder, DeliveryAddressRvModel deliveryAddressRvModel, View view) {
        viewHolder.mLoadingView.setVisibility(0);
        onLocationClick(deliveryAddressRvModel.mGpsEnable, deliveryAddressRvModel.mLocationPermissionOpen);
        viewHolder.mLoadingView.start();
        viewHolder.mOpenLocation.setVisibility(4);
        viewHolder.mMaskView.setEnabled(false);
    }

    public /* synthetic */ void lambda$bindLocation$5$DeliveryAddressBinder(DeliveryAddressRvModel deliveryAddressRvModel, View view) {
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
        TextView mAddressAllTv = ((TextView) findViewById(R.id.customer_tv_address_all));
        View mAddressDeleteView = ((View) findViewById(R.id.customer_ib_address_delete));
        View mAddressEdit = ((View) findViewById(R.id.customer_tv_address_edit));
        TextView mAddressNameTv = ((TextView) findViewById(R.id.customer_tv_address_name));
        View mAddressSlideEditView = ((View) findViewById(R.id.customer_ib_address_slide_edit));
        TextView mAddressTagTv = ((TextView) findViewById(R.id.customer_tv_address_tag));
        TextView mAddressTip = ((TextView) findViewById(R.id.customer_tv_address_tip));
        View mAddressTipContainer = ((View) findViewById(R.id.customer_ctl_address_tip));
        private ValueAnimator mAnimation;
        TextView mHouseNumber = ((TextView) findViewById(R.id.customer_tv_address_house));
        LottieLoadingView mLoadingView = ((LottieLoadingView) findViewById(R.id.customer_widget_address_loading));
        View mMaskView = ((View) findViewById(R.id.customer_cl_address_view_container_mark));
        RFGhostButton mOpenLocation = ((RFGhostButton) findViewById(R.id.customer_tv_address_des));

        public int getMoveDirections() {
            return 12;
        }

        ViewHolder(View view) {
            super(view);
        }

        public int getMaxMoveX() {
            int i = 0;
            int width = (!((DeliveryAddressRvModel) getItem()).isEditable() || this.mAddressSlideEditView.getVisibility() != 0) ? 0 : this.mAddressSlideEditView.getWidth();
            if (((DeliveryAddressRvModel) getItem()).isDeletable() && this.mAddressDeleteView.getVisibility() == 0) {
                i = this.mAddressDeleteView.getWidth();
            }
            return width + i;
        }

        public boolean isMovable() {
            return super.isMovable() && !isInAnimation() && ((DeliveryAddressRvModel) getItem()).isEditable();
        }

        public void onMove(int i, float f, int i2, float f2) {
            if (i != 4) {
                if (i == 8 && ((DeliveryAddressRvModel) getItem()).isDragOut()) {
                    this.itemView.scrollTo(getMaxMoveX() - ((int) f), 0);
                }
            } else if (!((DeliveryAddressRvModel) getItem()).isDragOut()) {
                this.itemView.scrollTo((int) f, 0);
            }
        }

        public void onMoveIn() {
            cancelAnimation();
            startAnim(0);
        }

        public void onMoveFinished() {
            int maxMoveX = getMaxMoveX();
            int scrollX = this.itemView.getScrollX();
            int i = 1;
            if (!((DeliveryAddressRvModel) getItem()).isDragOut() ? scrollX <= maxMoveX / 8 : scrollX <= (maxMoveX * 7) / 8) {
                i = 0;
            }
            startAnim(i);
        }

        public void cancelAnimation() {
            if (isInAnimation()) {
                this.mAnimation.cancel();
            }
        }

        private void startAnim(int i) {
            ValueAnimator recoverAnimator = AddressAnimUtil.getRecoverAnimator(this.itemView, ((DeliveryAddressRvModel) getItem()).isDeletable() ? 600 : 300, i, getMaxMoveX(), new AddressAnimUtil.Callback() {
                public final void onSaveState(int i) {
                    DeliveryAddressBinder.ViewHolder.this.lambda$startAnim$0$DeliveryAddressBinder$ViewHolder(i);
                }
            });
            this.mAnimation = recoverAnimator;
            recoverAnimator.start();
        }

        public /* synthetic */ void lambda$startAnim$0$DeliveryAddressBinder$ViewHolder(int i) {
            ((AddressMessageRepo) RepoFactory.getRepo(AddressMessageRepo.class)).setAddressDragStatus((DeliveryAddressRvModel) getItem(), i);
        }

        private boolean isInAnimation() {
            ValueAnimator valueAnimator = this.mAnimation;
            return valueAnimator != null && valueAnimator.isRunning();
        }
    }
}
