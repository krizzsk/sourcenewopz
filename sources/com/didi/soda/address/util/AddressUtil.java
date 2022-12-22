package com.didi.soda.address.util;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.util.LocalPermissionHelper;
import com.didi.soda.customer.foundation.util.LocalPermissionHelperPatch;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;

public final class AddressUtil {
    private AddressUtil() {
    }

    public static boolean checkAddressValid(AddressEntity addressEntity) {
        return (addressEntity == null || addressEntity.poi == null || TextUtils.isEmpty(addressEntity.poi.poiId)) ? false : true;
    }

    public static boolean checkAddressEqualCurrent(AddressEntity addressEntity) {
        AddressEntity delieveryAddress = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        return checkAddressValid(delieveryAddress) && checkAddressValid(addressEntity) && delieveryAddress.poi.poiId.equals(addressEntity.poi.poiId) && delieveryAddress.getAid().equals(addressEntity.getAid()) && delieveryAddress.getHouseNumber().equals(addressEntity.getHouseNumber()) && delieveryAddress.getBuildingName().equals(addressEntity.getBuildingName());
    }

    public static boolean checkAddressValidWithPermission(AddressEntity addressEntity) {
        return (hasLocationPermission() && LocationUtil.hasValidLocation()) || checkAddressValid(addressEntity);
    }

    public static boolean hasLocationPermission() {
        if (GlobalContext.getContext() instanceof Activity) {
            return LocalPermissionHelper.checkoutPermission((Activity) GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
        }
        return LocalPermissionHelperPatch.checkoutPermission(GlobalContext.getContext(), LocalPermissionHelper.LOCATION_PERMISSIONS);
    }
}
