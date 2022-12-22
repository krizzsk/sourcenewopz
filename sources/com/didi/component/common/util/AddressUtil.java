package com.didi.component.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.address.model.AddressManagerCallback;
import com.didi.address.model.SugParams;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.util.Utils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didiglobal.travel.biz.experim.GlobalAbExperims;
import com.didiglobal.travel.util.Preconditions;
import com.sdk.poibase.model.AddressParam;
import java.io.Serializable;

public class AddressUtil {

    /* renamed from: a */
    private static GlobalAddressManagerCallback f11748a;

    public static SugParams createCommonAddressParam(Context context, Address address) {
        SugParams sugParams = new SugParams();
        sugParams.managerCallback = m7952a();
        sugParams.addressParam = new AddressParam();
        sugParams.addressParam.departure_time = String.valueOf(System.currentTimeMillis());
        if (LocationController.getInstance() != null) {
            Address address2 = new Address();
            address2.latitude = LocationController.getInstance().getLat(context);
            address2.longitude = LocationController.getInstance().getLng(context);
            address2.cityId = LocationController.getInstance().getReverseCityId();
            address2.cityName = LocationController.getInstance().getReverseCityName();
            address2.displayName = LocationController.getInstance().getReverseDisplayName();
            address2.address = LocationController.getInstance().getReverseAddressName();
            address2.uid = LocationController.getInstance().getReverseAddressUid();
            sugParams.addressParam.currentAddress = address2;
        } else {
            sugParams.addressParam.currentAddress = createCommonAddress();
        }
        sugParams.addressParam.uid = PaxEnvironment.getInstance().getUid();
        sugParams.addressParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        sugParams.addressParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        sugParams.addressParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        sugParams.addressParam.token = PaxEnvironment.getInstance().getToken();
        sugParams.addressParam.cityId = PaxEnvironment.getInstance().getCityId();
        sugParams.addressParam.productId = PaxEnvironment.getInstance().getProductId();
        sugParams.addressParam.mapType = NationComponentDataUtil.getMapTypeString();
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
        if (lastKnownLocation != null) {
            sugParams.addressParam.user_loc_lat = lastKnownLocation.getLatitude();
            sugParams.addressParam.user_loc_lng = lastKnownLocation.getLongitude();
            sugParams.addressParam.accuracy = lastKnownLocation.getAccuracy();
            sugParams.addressParam.provider = lastKnownLocation.getProvider();
        }
        if (Utils.isBrazilPackage(context)) {
            sugParams.addressParam.countryId = "55";
        } else {
            String phoneCountryCode = NationComponentDataUtil.getPhoneCountryCode();
            if (!TextUtils.isEmpty(phoneCountryCode)) {
                phoneCountryCode = phoneCountryCode.replace("+", "");
            }
            sugParams.addressParam.countryId = phoneCountryCode;
        }
        if (!Preconditions.nonNull(address)) {
            sugParams.addressParam.targetAddress = createCommonAddress();
        } else if (GlobalAbExperims.checkSugAddrPax()) {
            sugParams.addressParam.targetAddress = address.clone();
        } else {
            Address address3 = new Address();
            sugParams.addressParam.targetAddress = address3;
            address3.latitude = address.getLatitude();
            address3.longitude = address.getLongitude();
            address3.cityId = address.getCityId();
            address3.cityName = address.getCityName();
            address3.displayName = address.getDisplayName();
            address3.address = address.getAddress();
            address3.uid = address.getUid();
            address3.operationType = address.operationType;
        }
        return sugParams;
    }

    public static Address createCommonAddress() {
        Address address = new Address();
        address.latitude = 0.0d;
        address.longitude = 0.0d;
        address.cityId = 0;
        return address;
    }

    public static SugParams createSugPageAddressParam(Context context, int i, Address address) {
        return createSugPageAddressParam(context, i, address, BusinessDataUtil.getProductIdInt());
    }

    public static SugParams createSugPageAddressParam(Context context, int i, Address address, int i2) {
        SugParams createCommonAddressParam = createCommonAddressParam(context, address);
        createCommonAddressParam.addressParam.addressType = i;
        createCommonAddressParam.addressParam.mapType = NationComponentDataUtil.getMapTypeString();
        if (DIDILocationManager.getInstance(context).getLastKnownLocation() != null) {
            NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
            if (nationComponentData != null) {
                AddressParam addressParam = createCommonAddressParam.addressParam;
                addressParam.countryId = nationComponentData.getLocCountryId() + "";
            }
        } else if (Utils.isBrazilPackage(context)) {
            createCommonAddressParam.addressParam.countryId = "55";
        } else {
            String phoneCountryCode = NationComponentDataUtil.getPhoneCountryCode();
            if (!TextUtils.isEmpty(phoneCountryCode)) {
                phoneCountryCode = phoneCountryCode.replace("+", "");
            }
            createCommonAddressParam.addressParam.countryId = phoneCountryCode;
        }
        return createCommonAddressParam;
    }

    /* renamed from: a */
    private static GlobalAddressManagerCallback m7952a() {
        if (f11748a == null) {
            f11748a = new GlobalAddressManagerCallback();
        }
        return f11748a;
    }

    public static class GlobalAddressManagerCallback implements AddressManagerCallback, Serializable {
        public void toLogin(Context context, double d, double d2, String str) {
            NationComponentDataUtil.showLogin();
        }
    }

    public static String getTripCountry(NationComponentData nationComponentData) {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || TextUtils.isEmpty(order.tripCountry)) {
            str = nationComponentData != null ? nationComponentData.getLocCountry() : "";
        } else {
            str = order.tripCountry;
        }
        GLog.m7964d("TripCountry:" + str);
        return str;
    }

    public static String getTripCityId(NationComponentData nationComponentData) {
        String str;
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.startAddress == null || order.startAddress.cityId <= 0) {
            str = nationComponentData != null ? String.valueOf(nationComponentData.getCityId()) : "";
        } else {
            str = String.valueOf(order.startAddress.cityId);
        }
        GLog.m7964d("TripCityId:" + str);
        return str;
    }

    public static String getAddressDisplayName(Address address, String str) {
        return (address == null || TextUtils.isEmpty(address.getDisplayName())) ? str : address.getDisplayName();
    }
}
