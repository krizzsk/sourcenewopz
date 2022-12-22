package com.didi.entrega.home.manager;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.home.component.city.model.HomeCityItemRvModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/entrega/home/manager/HomeOtherOmegaHelper;", "", "()V", "trackExceptionCK", "", "type", "", "trackExceptionSW", "statu", "trackOpenedCityListCK", "city", "Lcom/didi/entrega/home/component/city/model/HomeCityItemRvModel;", "trackOpenedCityListSW", "trackServiceNotifyFloatCK", "trackServiceNotifyFloatSW", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeOtherOmegaHelper.kt */
public final class HomeOtherOmegaHelper {
    public static final HomeOtherOmegaHelper INSTANCE = new HomeOtherOmegaHelper();

    private HomeOtherOmegaHelper() {
    }

    @JvmStatic
    public static final void trackExceptionSW(int i) {
        OmegaTracker.Builder.create(EventConst.Home.EXCEPTION_SW).addEventParam(ParamConst.PARAMS_PAGE_STATU, Integer.valueOf(i)).build().track();
    }

    @JvmStatic
    public static final void trackExceptionCK(int i) {
        OmegaTracker.Builder.create(EventConst.Home.EXCEPTION_CK).addEventParam("click_type", Integer.valueOf(i)).build().track();
    }

    @JvmStatic
    public static final void trackOpenedCityListSW() {
        OmegaTracker.Builder.create(EventConst.Home.CITY_LIST_SW).build().track();
    }

    @JvmStatic
    public static final void trackOpenedCityListCK(HomeCityItemRvModel homeCityItemRvModel) {
        Intrinsics.checkNotNullParameter(homeCityItemRvModel, "city");
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Home.CITY_LIST_CK).addEventParam("city_id", Integer.valueOf(homeCityItemRvModel.mCityId));
        String str = homeCityItemRvModel.mCountryCode;
        if (str == null) {
            str = "";
        }
        addEventParam.addEventParam("country_id", str).addEventParam("index", Integer.valueOf(homeCityItemRvModel.mCityIndexInAllCountries)).build().track();
    }

    @JvmStatic
    public static final void trackServiceNotifyFloatSW() {
        OmegaTracker.Builder.create(EventConst.Home.SERVICE_NOTIFY_SW).build().track();
    }

    @JvmStatic
    public static final void trackServiceNotifyFloatCK(int i) {
        OmegaTracker.Builder.create(EventConst.Home.SERVICE_NOTIFY_CK).addEventParam("click_type", Integer.valueOf(i)).build().track();
    }
}
