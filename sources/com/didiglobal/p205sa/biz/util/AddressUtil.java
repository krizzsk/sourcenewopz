package com.didiglobal.p205sa.biz.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.address.model.AddressManagerCallback;
import com.didi.address.model.SugParams;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.sdk.poibase.model.AddressParam;
import java.io.Serializable;

/* renamed from: com.didiglobal.sa.biz.util.AddressUtil */
public class AddressUtil {

    /* renamed from: a */
    private static GlobalAddressManagerCallback f51262a;

    public static SugParams createCommonAddressParam(Context context, Address address) {
        SugParams sugParams = new SugParams();
        sugParams.managerCallback = m36707a();
        sugParams.addressParam = new AddressParam();
        sugParams.addressParam.departure_time = String.valueOf(System.currentTimeMillis());
        if (DIDILocationManager.getInstance(context) != null) {
            Address address2 = new Address();
            if (DIDILocationManager.getInstance(context).getLastKnownLocation() != null) {
                address2.latitude = DIDILocationManager.getInstance(context).getLastKnownLocation().getLatitude();
                address2.longitude = DIDILocationManager.getInstance(context).getLastKnownLocation().getLongitude();
            }
            address2.cityId = NationTypeUtil.getNationComponentData().getLocCountryId();
            address2.cityName = NationTypeUtil.getNationComponentData().getCityName();
            if (ReverseLocationStore.getsInstance().getCurAddress() != null) {
                address2.displayName = ReverseLocationStore.getsInstance().getCurAddress().displayName;
                address2.address = ReverseLocationStore.getsInstance().getCurAddress().getAddress();
                address2.uid = ReverseLocationStore.getsInstance().getCurAddress().getAddress();
            }
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
        sugParams.addressParam.mapType = NationTypeUtil.getNationComponentData().getMapTypeString();
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
        if (lastKnownLocation != null) {
            sugParams.addressParam.user_loc_lat = lastKnownLocation.getLatitude();
            sugParams.addressParam.user_loc_lng = lastKnownLocation.getLongitude();
            sugParams.addressParam.accuracy = lastKnownLocation.getAccuracy();
            sugParams.addressParam.provider = lastKnownLocation.getProvider();
        }
        String phoneCountryCode = NationTypeUtil.getNationComponentData().getLoginInfo().getPhoneCountryCode();
        if (!TextUtils.isEmpty(phoneCountryCode)) {
            phoneCountryCode = phoneCountryCode.replace("+", "");
        }
        sugParams.addressParam.countryId = phoneCountryCode;
        if (address != null) {
            Address address3 = new Address();
            address3.latitude = address.getLatitude();
            address3.longitude = address.getLongitude();
            address3.cityId = address.getCityId();
            address3.cityName = address.getCityName();
            address3.displayName = address.getDisplayName();
            address3.address = address.getAddress();
            address3.uid = address.getUid();
            address3.operationType = address.operationType;
            sugParams.addressParam.targetAddress = address3;
        } else {
            sugParams.addressParam.targetAddress = createCommonAddress();
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
        SugParams createCommonAddressParam = createCommonAddressParam(context, address);
        createCommonAddressParam.addressParam.addressType = i;
        createCommonAddressParam.addressParam.mapType = NationTypeUtil.getNationComponentData().getMapTypeString();
        return createCommonAddressParam;
    }

    /* renamed from: a */
    private static GlobalAddressManagerCallback m36707a() {
        if (f51262a == null) {
            f51262a = new GlobalAddressManagerCallback();
        }
        return f51262a;
    }

    /* renamed from: com.didiglobal.sa.biz.util.AddressUtil$GlobalAddressManagerCallback */
    public static class GlobalAddressManagerCallback implements AddressManagerCallback, Serializable {
        public void toLogin(Context context, double d, double d2, String str) {
            NationTypeUtil.getNationComponentData().getLoginAction().go2Login();
        }
    }
}
