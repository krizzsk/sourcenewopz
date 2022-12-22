package com.didi.entrega.address.list.component.feed.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.address.utils.AddressUtil;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressRvModel implements RecyclerModel {
    public int addressType;
    public AddressEntity mAddress;
    public String mAddressTipContent;
    public int mDragStatus = 0;
    public boolean mGpsEnable;
    public boolean mIsChecked;
    public boolean mIsFirst;
    public boolean mIsLast;
    public boolean mLocationPermissionOpen;
    public String title;

    public static DeliveryAddressRvModel buildLocationAddressRvModel(AddressEntity addressEntity, boolean z, boolean z2, boolean z3, boolean z4) {
        DeliveryAddressRvModel deliveryAddressRvModel = new DeliveryAddressRvModel();
        if (addressEntity != null) {
            deliveryAddressRvModel.mAddress = addressEntity;
        }
        deliveryAddressRvModel.mGpsEnable = z;
        deliveryAddressRvModel.mLocationPermissionOpen = z2;
        deliveryAddressRvModel.mIsLast = z4;
        deliveryAddressRvModel.mIsChecked = z3;
        deliveryAddressRvModel.addressType = 4;
        deliveryAddressRvModel.mDragStatus = 0;
        return deliveryAddressRvModel;
    }

    public static DeliveryAddressRvModel buildAddressRvModel(AddressEntity addressEntity, boolean z, boolean z2, boolean z3, int i) {
        if (addressEntity == null || !AddressUtil.checkAddressValid(addressEntity)) {
            return null;
        }
        DeliveryAddressRvModel deliveryAddressRvModel = new DeliveryAddressRvModel();
        deliveryAddressRvModel.mAddress = addressEntity;
        deliveryAddressRvModel.mAddressTipContent = null;
        deliveryAddressRvModel.mIsChecked = z;
        deliveryAddressRvModel.mIsLast = z3;
        deliveryAddressRvModel.mIsFirst = z2;
        deliveryAddressRvModel.addressType = i;
        deliveryAddressRvModel.mDragStatus = 0;
        return deliveryAddressRvModel;
    }

    public static List<DeliveryAddressRvModel> buildAddressRvModelList(List<AddressEntity> list, int i) {
        int size = list == null ? 0 : list.size();
        if (size <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < size) {
            AddressEntity addressEntity = list.get(i2);
            boolean z = true;
            boolean z2 = i2 == 0;
            if (size - 1 != i2) {
                z = false;
            }
            DeliveryAddressRvModel buildAddressRvModel = buildAddressRvModel(addressEntity, false, z2, z, i);
            if (buildAddressRvModel != null) {
                arrayList.add(buildAddressRvModel);
            }
            i2++;
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
        return !this.mIsChecked && this.addressType != 4;
    }

    public boolean isEditable() {
        return AddressUtil.checkAddressValid(this.mAddress);
    }
}
