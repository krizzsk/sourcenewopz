package com.didi.addressnew.util;

import android.content.Context;
import com.didi.address.FromType;
import com.didi.common.map.util.DLog;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.omega.sdk.feedback.FeedbackConfig;
import com.sdk.poibase.model.AddressParam;

public class CheckParamUtil {
    public static void checkAddressParam(AddressParam addressParam, FromType fromType) {
        if (addressParam != null) {
            DLog.m7384d("Sug", "CheckParamUtil checkAddressParam() start, fromType: " + fromType, new Object[0]);
            if (fromType == null) {
                throw new RuntimeException("AddressParam.fromType = null");
            } else if (addressParam.addressType < 0) {
                throw new RuntimeException("AddressParam.addressType is not set");
            } else if ((fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(fromType)) && addressParam.targetAddress == null) {
                throw new RuntimeException("AddressParam.targetAddress is not set");
            } else {
                if (addressParam.currentAddress == null) {
                    DLog.m7384d(FeedbackConfig.FT_SUG, "AddressParam.currentAddress = null", new Object[0]);
                } else if (!CommonUtils.isValidLocation(addressParam.currentAddress)) {
                    DLog.m7384d(FeedbackConfig.FT_SUG, "AddressParam.currentAddress is invalid location", new Object[0]);
                }
                if (addressParam.targetAddress == null) {
                    DLog.m7384d(FeedbackConfig.FT_SUG, "AddressParam.targetAddress = null", new Object[0]);
                } else if (!CommonUtils.isValidLocation(addressParam.targetAddress)) {
                    DLog.m7384d(FeedbackConfig.FT_SUG, "AddressParam.targetAddress is invalid location", new Object[0]);
                }
                DLog.m7384d("Sug", "CheckParamUtil checkAddressParam() end, fromType: " + fromType, new Object[0]);
            }
        } else {
            throw new RuntimeException("AddressParam = null");
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
