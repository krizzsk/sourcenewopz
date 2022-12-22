package com.didi.component.business.util;

import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.secondconf.RideConfImpl;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.model.WarmupActivity;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.List;

public class BusinessUtils {
    public static boolean isAngleSensitive(BusinessContext businessContext) {
        return true;
    }

    public static boolean isMisInvalid(BusinessContext businessContext) {
        if (businessContext == null) {
            return false;
        }
        return !SecondConfProxy.getInstance().isCityOpen(businessContext.getBusinessGroupType());
    }

    public static boolean isPreHeat(BusinessContext businessContext) {
        if (businessContext == null) {
            return false;
        }
        return RideConfImpl.getInstance().isPreHeat();
    }

    @Deprecated
    public static boolean isStopService(BusinessContext businessContext) {
        CarGrop groupByType;
        if (businessContext == null || businessContext.getCountryInfo() == null || (groupByType = ConfProxy.getInstance().getGroupByType(businessContext.getBusinessGroupType())) == null || groupByType.getOpenStatus() != 3) {
            return false;
        }
        return true;
    }

    public static String getPreHeatOrDisableText(BusinessContext businessContext) {
        CarGrop groupByType;
        if (businessContext == null || (groupByType = ConfProxy.getInstance().getGroupByType(businessContext.getBusinessGroupType())) == null) {
            return "";
        }
        return groupByType.getLinkText();
    }

    public static WarmupActivity getPreheatActivity(BusinessContext businessContext) {
        if (businessContext == null) {
            return null;
        }
        return ((RideConfImpl) SecondConfProxy.getInstance().getSecondConf(businessContext.getBusinessGroupType())).getWarmupActivity();
    }

    public static CarInfo getDefaultConfCarInfo(BusinessContext businessContext) {
        List<CarInfo> confCarInfoList;
        if (businessContext == null || (confCarInfoList = getConfCarInfoList(businessContext.getBusinessGroupType())) == null || confCarInfoList.size() == 0) {
            return null;
        }
        return confCarInfoList.get(0);
    }

    public static List<CarInfo> getConfCarInfoList(String str) {
        return RideConfImpl.getInstance().getCarInfo();
    }

    public static String getCarNameByBid(String str, int i) {
        return RideConfImpl.getInstance().getCarNameByBid(i);
    }

    public static int getDefaultBusinessId(String str) {
        return RideConfImpl.getInstance().getDefaultBusinessId();
    }

    @Deprecated
    public static CarInfo getCurrentCarInfoByCarIdAndIndex(BusinessContext businessContext) {
        CarGrop groupByType;
        List<CarInfo> carInfo;
        if (businessContext == null || (groupByType = ConfProxy.getInstance().getGroupByType(businessContext.getBusinessGroupType())) == null || (carInfo = groupByType.getCarInfo()) == null || carInfo.size() == 0) {
            return null;
        }
        String defaultCarId = groupByType.getDefaultCarId();
        if (!TextUtils.isEmpty(defaultCarId)) {
            for (CarInfo next : carInfo) {
                if (next != null && TextUtil.equals(defaultCarId, next.getCarId())) {
                    return next;
                }
            }
        }
        if (carInfo.size() <= groupByType.getDefaultCarIndex()) {
            return null;
        }
        return carInfo.get(groupByType.getDefaultCarIndex());
    }

    @Deprecated
    public static CarInfo getCarInfoByBid(int i, BusinessContext businessContext, int i2, int i3) {
        List<CarInfo> confCarInfoList;
        if (!(i == -1 || businessContext == null || (confCarInfoList = getConfCarInfoList(businessContext.getBusinessGroupType())) == null || confCarInfoList.size() == 0)) {
            for (int i4 = 0; i4 < confCarInfoList.size(); i4++) {
                CarInfo carInfo = confCarInfoList.get(i4);
                if (carInfo.getBusinessNumId() == i && carInfo.getComboType() == i2 && (carInfo.getComboType() != 4 || carInfo.getCarpoolOrderScene() == i3)) {
                    return carInfo;
                }
            }
        }
        return null;
    }

    public static String getCurrentSID(BusinessContext businessContext) {
        CarInfo defaultConfCarInfo;
        if (businessContext == null || (defaultConfCarInfo = getDefaultConfCarInfo(businessContext)) == null) {
            return "";
        }
        return defaultConfCarInfo.getBusinessId();
    }

    public static int getCurrentBID(BusinessContext businessContext) {
        CarInfo defaultConfCarInfo = getDefaultConfCarInfo(businessContext);
        if (defaultConfCarInfo != null) {
            return defaultConfCarInfo.getBusinessNumId();
        }
        return 0;
    }

    public static int getCurrentComboType(CarOrder carOrder, boolean z) {
        if (carOrder != null) {
            return carOrder.comboType;
        }
        if (z) {
            return FormStore.getInstance().getCurrentComboType();
        }
        return 0;
    }

    public static CountryInfo getCountryInfo(BusinessContext businessContext) {
        if (businessContext == null) {
            return null;
        }
        return businessContext.getCountryInfo();
    }

    public static String getCountryIsoCode(BusinessContext businessContext) {
        CountryInfo countryInfo = getCountryInfo(businessContext);
        String countryIsoCode = countryInfo != null ? countryInfo.getCountryIsoCode() : null;
        return countryIsoCode == null ? "" : countryIsoCode;
    }

    public static int getCurrentCityId(BusinessContext businessContext) {
        if (businessContext == null || businessContext.getCountryInfo() == null) {
            return -1;
        }
        return businessContext.getCountryInfo().getCityId();
    }

    public static CarInfo getCarInfo(BusinessContext businessContext, int i, int i2, int i3, int i4) {
        CarGrop groupByType = (businessContext == null || businessContext.getBusinessGroupType() == null) ? null : ConfProxy.getInstance().getGroupByType(businessContext.getBusinessGroupType());
        List<CarInfo> carInfo = groupByType != null ? groupByType.getCarInfo() : null;
        if (carInfo != null) {
            for (CarInfo next : carInfo) {
                if (next.getBusinessNumId() == i && next.getCarLevel() == i2) {
                    if ((next.getComboType() != 4 || next.getCarpoolOrderScene() == i4) && next.getComboType() == i3) {
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public static CarGrop getRiderGroup(BusinessContext businessContext) {
        return ConfProxy.getInstance().getGroupByType(businessContext.getBusinessGroupType());
    }
}
