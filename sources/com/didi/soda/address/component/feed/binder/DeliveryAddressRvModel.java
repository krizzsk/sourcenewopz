package com.didi.soda.address.component.feed.binder;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressRvModel implements RecyclerModel {
    public int addressType;
    public AddressEntity mAddress;
    public String mAddressTipContent;
    public int mDragStatus = 0;
    public boolean mGpsEnable;
    public boolean mIsChecked;
    public boolean mIsLast;
    public boolean mLocationPermissionOpen;

    public static DeliveryAddressRvModel buildLocationAddressRvModel(HomeAddressEntity homeAddressEntity, boolean z, boolean z2, boolean z3, boolean z4) {
        DeliveryAddressRvModel deliveryAddressRvModel = new DeliveryAddressRvModel();
        if (homeAddressEntity != null) {
            deliveryAddressRvModel.mAddress = homeAddressEntity.address;
            if (!(homeAddressEntity.tipInfo == null || homeAddressEntity.tipInfo.mTip == null)) {
                deliveryAddressRvModel.mAddressTipContent = homeAddressEntity.tipInfo.mTip;
            }
        }
        deliveryAddressRvModel.mGpsEnable = z;
        deliveryAddressRvModel.mLocationPermissionOpen = z2;
        deliveryAddressRvModel.mIsLast = z4;
        deliveryAddressRvModel.mIsChecked = z3;
        deliveryAddressRvModel.addressType = 8;
        deliveryAddressRvModel.mDragStatus = 0;
        return deliveryAddressRvModel;
    }

    public static DeliveryAddressRvModel buildCurAddressRvModel(HomeAddressEntity homeAddressEntity, boolean z) {
        if (homeAddressEntity == null || !AddressUtil.checkAddressValid(homeAddressEntity.address)) {
            return null;
        }
        DeliveryAddressRvModel deliveryAddressRvModel = new DeliveryAddressRvModel();
        deliveryAddressRvModel.mAddress = homeAddressEntity.address;
        if (!(homeAddressEntity.tipInfo == null || homeAddressEntity.tipInfo.mTip == null)) {
            deliveryAddressRvModel.mAddressTipContent = homeAddressEntity.tipInfo.mTip;
        }
        deliveryAddressRvModel.mIsChecked = true;
        deliveryAddressRvModel.mIsLast = z;
        deliveryAddressRvModel.addressType = 7;
        deliveryAddressRvModel.mDragStatus = 0;
        return deliveryAddressRvModel;
    }

    public static DeliveryAddressRvModel buildAddressRvModel(AddressEntity addressEntity, boolean z, boolean z2) {
        if (addressEntity == null || !AddressUtil.checkAddressValid(addressEntity)) {
            return null;
        }
        DeliveryAddressRvModel deliveryAddressRvModel = new DeliveryAddressRvModel();
        deliveryAddressRvModel.mAddress = addressEntity;
        deliveryAddressRvModel.mAddressTipContent = null;
        deliveryAddressRvModel.mIsChecked = z;
        deliveryAddressRvModel.mIsLast = z2;
        if (addressEntity.type == 1) {
            deliveryAddressRvModel.addressType = 2;
        } else if (addressEntity.type == 2) {
            deliveryAddressRvModel.addressType = 3;
        } else {
            deliveryAddressRvModel.addressType = 1;
        }
        deliveryAddressRvModel.mDragStatus = 0;
        return deliveryAddressRvModel;
    }

    public static List<DeliveryAddressRvModel> buildHistoryAddressRvModelList(List<AddressEntity> list, String str) {
        int size = list == null ? 0 : list.size();
        if (size <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            AddressEntity addressEntity = list.get(i);
            if (!addressEntity.getAid().equals(str)) {
                DeliveryAddressRvModel buildAddressRvModel = buildAddressRvModel(addressEntity, false, size + -1 == i);
                if (buildAddressRvModel != null) {
                    arrayList.add(buildAddressRvModel);
                }
            }
            i++;
        }
        return arrayList;
    }

    public void setGpsEnable(boolean z, boolean z2, boolean z3) {
        this.mGpsEnable = z;
        this.mLocationPermissionOpen = z2;
        this.mIsLast = z3;
    }

    public boolean isDragOut() {
        return this.mDragStatus == 1;
    }

    public boolean isDeletable() {
        return !this.mIsChecked && this.addressType != 8;
    }

    public boolean isEditable() {
        return AddressUtil.checkAddressValid(this.mAddress);
    }
}
