package com.didi.addressold.util;

import android.content.Context;
import com.didi.address.FromType;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.model.AddressParam;

public class CheckParamUtil {
    public static void checkAddressParam(AddressParam addressParam, FromType fromType) {
        if (addressParam != null) {
            LogUtils.logInfo("CheckParamUtil checkAddressParam() start, fromType: " + fromType);
            if (fromType == null) {
                throw new RuntimeException("AddressParam.fromType = null");
            } else if (addressParam.addressType < 0) {
                throw new RuntimeException("AddressParam.addressType is not set");
            } else if ((fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(fromType)) && addressParam.targetAddress == null) {
                throw new RuntimeException("AddressParam.targetAddress is not set");
            } else {
                if (addressParam.currentAddress == null) {
                    LogUtils.logWarn("AddressParam.currentAddress = null");
                } else if (!CommonUtils.isValidLocation(addressParam.currentAddress)) {
                    LogUtils.logWarn("AddressParam.currentAddress is invalid location");
                }
                if (addressParam.targetAddress == null) {
                    LogUtils.logWarn("AddressParam.targetAddress = null");
                } else if (!CommonUtils.isValidLocation(addressParam.targetAddress)) {
                    LogUtils.logWarn("AddressParam.targetAddress is invalid location");
                }
                LogUtils.logInfo("CheckParamUtil checkAddressParam() end, fromType: " + fromType);
            }
        } else {
            throw new RuntimeException("addressParam is null");
        }
    }

    public static void rescueAddressParam(Context context, String str, AddressParam addressParam) {
        String str2;
        String str3;
        if (context != null && !CommonUtils.isValidLocation(addressParam.currentAddress)) {
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(context);
            if (lastKnownLocation != null) {
                if (addressParam.currentAddress == null) {
                    addressParam.currentAddress = new Address();
                    str3 = "addressParam.currentAddress == null, ";
                } else {
                    str3 = "";
                }
                addressParam.currentAddress.latitude = lastKnownLocation.getLatitude();
                addressParam.currentAddress.longitude = lastKnownLocation.getLongitude();
                str2 = str3 + "Rescue success!";
            } else {
                str2 = "lastLocation == null";
            }
            AddressTrack.trackRescueAddressParamCurrentAddress(str, str2);
        }
    }
}
