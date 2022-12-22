package com.didi.entrega.address.utils;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;

public final class AddressUtil {
    public static boolean isSenderAddressSelected(int i) {
        return (i == 2 || i == 4 || i == 6) ? false : true;
    }

    private AddressUtil() {
    }

    public static boolean checkAddressValid(AddressEntity addressEntity) {
        return (addressEntity == null || addressEntity.poi == null || TextUtils.isEmpty(addressEntity.poi.poiId)) ? false : true;
    }
}
