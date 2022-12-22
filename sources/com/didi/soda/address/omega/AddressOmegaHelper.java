package com.didi.soda.address.omega;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import com.didi.soda.customer.foundation.util.LocationUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class AddressOmegaHelper {
    private AddressOmegaHelper() {
    }

    public static void clickRefreshLocateAddress(AddressEntity addressEntity, int i) {
        String str = AddressUtil.checkAddressValid(addressEntity) ? addressEntity.poi.poiId : "";
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_REFRESH_LOCATION).addEventParam("has_location", Integer.valueOf(TextUtils.isEmpty(str) ? 2 : 1)).addEventParam("poi_id", str).addEventParam("from_page", Integer.valueOf(i)).build().track();
    }

    public static void getAddress(int i, int i2, String str, int i3, String str2) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_GET_ADDRESS).addEventParam(ParamConst.PARAM_IS_LOCATE_SUCCESS, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ADDRESS_LOCATE_FAILTURE_REASON, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_ADDRESS_LOCATE_SOURCE, str).addEventParam(ParamConst.PARAM_ADDRESS_LOCATE_TRIGGER_SCENE, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ADDRESS_RECID, str2).build().track();
    }

    public static void clickManuGetAddress(int i, int i2, boolean z) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_MANU_GET_ADDRESS).addEventParam(ParamConst.PARAM_ADDRESS_FAILURE_LOCATION_SOURCE, Integer.valueOf(i)).addEventParam("from_page", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(!z ? 4 : 1)).build().track();
    }

    public static void openAddressHomePage(ScopeContext scopeContext, int i, boolean z, boolean z2) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_OPEN_ADDRESS_HOME, scopeContext).addEventParam("from_page", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(!z ? 4 : !z2 ? 1 : LocationUtil.hasValidLocation() ? 3 : 2)).build().track();
    }

    public static void trackRealexposureSw(AddressPageListEntity addressPageListEntity) {
        int i;
        int i2;
        int i3 = 2;
        int i4 = 0;
        if (addressPageListEntity != null) {
            i4 = CollectionUtilsKt.sizeOrNull(addressPageListEntity.historyAddressList);
            i2 = CollectionUtilsKt.count(addressPageListEntity.historyAddressList, $$Lambda$AddressOmegaHelper$S46lVFo5zlGB9LQY4TFXBESAak.INSTANCE);
            i = CollectionUtilsKt.count(addressPageListEntity.historyAddressList, $$Lambda$AddressOmegaHelper$4WfVfGhXgSMK94tv6jvh2ldv93Y.INSTANCE);
            HomeAddressEntity homeAddressEntity = addressPageListEntity.locationAddress;
            if (homeAddressEntity != null && AddressUtil.checkAddressValid(homeAddressEntity.address)) {
                i3 = 1;
            }
        } else {
            i2 = 0;
            i = 0;
        }
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_REALEXPOSURE_SW).addEventParam(ParamConst.HISTORY_NUM, Integer.valueOf(i4)).addEventParam(ParamConst.HOME_NUM, Integer.valueOf(i2)).addEventParam(ParamConst.COMPANY_NUM, Integer.valueOf(i)).addEventParam("has_location", Integer.valueOf(i3)).build().track();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ Boolean m27492c(AddressEntity addressEntity) {
        boolean z = true;
        if (addressEntity.type != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ Boolean m27491b(AddressEntity addressEntity) {
        return Boolean.valueOf(addressEntity.type == 2);
    }

    public static void trackSearchAddressClick(int i, String str, int i2, int i3, AddressEntity.PoiEntity poiEntity) {
        String str2;
        String str3 = "";
        if (poiEntity != null) {
            str3 = poiEntity.poiId;
            str2 = poiEntity.poiType;
        } else {
            str2 = str3;
        }
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_SEARCH_CK).addEventParam(ParamConst.PARAM_ADDRESS_GPS_OPEN, Integer.valueOf(i)).addEventParam("search_term", str).addEventParam(ParamConst.PARAM_ADDRESS_SEARCH_RESULT_SIZE, Integer.valueOf(i2)).addEventParam("index", Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_POI_ID, str3).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_POI_TYPE, str2).build().track();
    }

    public static void trackAddressEditSw(String str, String str2, int i) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_COMPILER_SW).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_POI_ID, str).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_AID, str2).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_TYPE, Integer.valueOf(i)).build().track();
    }

    public static void trackAddressEditCk(String str, String str2, int i) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_COMPILER_CK).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_POI_ID, str).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_AID, str2).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_TYPE, Integer.valueOf(i)).build().track();
    }

    public static void trackAddressDeleteSw(String str, String str2, int i) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_DELETE_SW).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_POI_ID, str).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_AID, str2).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_TYPE, Integer.valueOf(i)).build().track();
    }

    public static void trackAddressDeleteCk(String str, String str2, int i) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_DELETE_CK).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_POI_ID, str).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_AID, str2).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_TYPE, Integer.valueOf(i)).build().track();
    }

    public static void searchAddress(ScopeContext scopeContext, int i, String str, int i2, int i3, boolean z, String str2, String str3, String str4) {
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_SEARCH, scopeContext).addEventParam(ParamConst.PARAM_ADDRESS_GPS_OPEN, Integer.valueOf(i)).addEventParam("search_term", str).addEventParam(ParamConst.PARAM_ADDRESS_SEARCH_RESULT_SIZE, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_ADDRESS_SEARCH_IS_DISTANCE, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ADDRESS_SEARCH_AID_LIST, str4).addEventParam("is_suc", Integer.valueOf(z ? 1 : 2)).addEventParam("error_code", str2);
        if (str3 == null) {
            str3 = "";
        }
        addEventParam.addEventParam("error_msg", str3).enableGuideParam().build().track();
    }

    public static void clickEditPoi(String str) {
        OmegaTracker.Builder.create(EventConst.Cart.EVENT_GOTO_ADDRESS).addEventParam(ParamConst.PARAM_POD_ID, str).build().track();
    }

    public static void chooseAddress(int i, String str, String str2, String str3, boolean z, int i2, int i3) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_SELECTED).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_AID, str2).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ADDRESS_SELETED_POI_ID, str).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_POI_TYPE, str3).addEventParam(ParamConst.PARAM_ADDRESS_SEARCH_RESULT_SIZE, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ADDRESS_GPS_OPEN, Integer.valueOf(z ? 1 : 0)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(i == 8 ? 1 : 2)).addEventParam(ParamConst.PARAM_ADDRESS_SELECTED_INDEX, Integer.valueOf(i2)).build().track();
    }

    public static void editAddressSw(int i, String str, boolean z, String str2, int i2, int i3) {
        int i4 = 2;
        int i5 = TextUtils.equals(str, Const.AddressLocationSource.SUG) ? 2 : 1;
        if (z) {
            i4 = 1;
        }
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_EDIT_SW).addEventParam("from_page", Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ADDRESS_EDIT_LOCATION_SOURCE, Integer.valueOf(i5)).addEventParam(ParamConst.PARAM_ADDRESS_EDIT_ADDRESS_PROMPT, Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_ADDRESS_PROMPT_SCENE, Integer.valueOf(i2));
        if (str2 == null) {
            str2 = "";
        }
        addEventParam.addEventParam(ParamConst.PARAM_POI_TYPE, str2).addEventParam("scene", Integer.valueOf(i3)).build().track();
    }

    public static void editAddress(String str, String str2, String str3, int i, int i2, String str4, String str5, int i3, int i4, int i5, String str6, String str7, String str8, String str9) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_EDIT);
        if (!(str == null || str2 == null)) {
            create.addEventParam("shop_id", str);
            create.addEventParam("cart_id", str2);
        }
        create.addEventParam(ParamConst.PARAM_ADDRESS_RESULT_AID, str3).addEventParam(ParamConst.PARAM_ADDRESS_ACTION_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_ADDRESS_EDIT_LOCATION_SOURCE, Integer.valueOf(i2)).addEventParam("user_fill_content", str4).addEventParam("building_number", str5).addEventParam(ParamConst.PARAM_ADDRESS_EDIT_ADDRESS_TYPE, Integer.valueOf(i3)).addEventParam(ParamConst.PARAM_ADDRESS_EDIT_SUCCESS, Integer.valueOf(i4)).addEventParam("has_name", Integer.valueOf(i5)).addEventParam("error_type", str6).addEventParam("error_msg", str7).addEventParam(ParamConst.PARAM_ADDRESS_RESULT_POI_ID, str8).addEventParam(ParamConst.PARAM_ADDRESS_RESULT_POI_TYPE, str9).build().track();
    }

    public static void editAddressPopSw(boolean z, int i, int i2) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_POPUP_SW).addEventParam(ParamConst.PARAM_IF_ADDRESS_TYPE, Integer.valueOf(z ? 1 : 0)).addEventParam("from_page", Integer.valueOf(i)).addEventParam("scene", Integer.valueOf(i2)).build().track();
    }

    public static void editAddressPopClick(boolean z, boolean z2, int i, int i2) {
        OmegaTracker.Builder.create(z ? EventConst.Address.EVENT_ADDRESS_POPUP_IGNORE_CK : EventConst.Address.EVENT_ADDRESS_POPUP_ADD_CK).addEventParam(ParamConst.PARAM_IF_ADDRESS_TYPE, Integer.valueOf(z2 ? 1 : 0)).addEventParam("from_page", Integer.valueOf(i)).addEventParam("scene", Integer.valueOf(i2)).build().track();
    }

    public static void cachePoiTipSw(int i, boolean z, boolean z2) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_POI_TIP_SW).addEventParam(ParamConst.PARAM_TIPS_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(!z ? 4 : !z2 ? 1 : 2)).build().track();
    }

    public static void cachePoiTipCk(int i) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_POI_TIP_CK).addEventParam(ParamConst.PARAM_TIPS_TYPE, Integer.valueOf(i)).build().track();
    }

    public static void cachePoiTipCloseCk(int i, int i2, boolean z, boolean z2) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_POI_TIP_CLOSE_CK).addEventParam(ParamConst.PARAM_TIPS_TYPE, Integer.valueOf(i)).addEventParam(ParamConst.CLOSE_TYPE, Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(!z ? 4 : !z2 ? 1 : 2)).build().track();
    }

    public static void cacheAddressDialogSW(AddressEntity addressEntity) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_CART_PAGE_SW);
        if (!(addressEntity == null || addressEntity.poi == null)) {
            create.addEventParam(ParamConst.PARAM_SHIPPING_POI_ID, addressEntity.poi.poiId).addEventParam(ParamConst.PARAM_SHIPPING_POI_LAT, Double.valueOf(addressEntity.poi.lat)).addEventParam(ParamConst.PARAM_SHIPPING_POI_LNG, Double.valueOf(addressEntity.poi.lng)).addEventParam(ParamConst.PARAM_SHIPPING_POI_CITY_ID, Integer.valueOf(addressEntity.poi.cityId));
        }
        create.build().track();
    }

    public static void cacheAddressDialogCK(AddressEntity addressEntity, int i) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Address.EVENT_ADDRESS_CART_PAGE_CK);
        if (!(addressEntity == null || addressEntity.poi == null)) {
            create.addEventParam(ParamConst.PARAM_SHIPPING_POI_ID, addressEntity.poi.poiId).addEventParam(ParamConst.PARAM_SHIPPING_POI_LAT, Double.valueOf(addressEntity.poi.lat)).addEventParam(ParamConst.PARAM_SHIPPING_POI_LNG, Double.valueOf(addressEntity.poi.lng)).addEventParam(ParamConst.PARAM_SHIPPING_POI_CITY_ID, Integer.valueOf(addressEntity.poi.cityId));
        }
        create.addEventParam("click_type", Integer.valueOf(i));
        create.build().track();
    }

    /* renamed from: a */
    private static String m27490a(AddressEntity addressEntity) {
        JSONObject jSONObject = new JSONObject();
        if (!(addressEntity == null || addressEntity.poi == null)) {
            try {
                jSONObject.put("poi_id", addressEntity.poi.poiId);
                jSONObject.put("poi_name", addressEntity.poi.displayName);
                jSONObject.put("poi_lat", addressEntity.poi.lat);
                jSONObject.put("poi_lng", addressEntity.poi.lng);
                jSONObject.put("poi_city", addressEntity.poi.cityId);
                jSONObject.put("rec_id", addressEntity.poi.searchId);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static void traceDeliveryCommonSW(String str) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ORDERPAGE_DELIVERY_COMMON_SW).addEventParam("order_id", str).build().track();
    }

    public static void traceDeliveryAddCK(String str) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ORDERPAGE_DELIVERY_ADD_CK).addEventParam("order_id", str).build().track();
    }

    public static void traceDeliveryEditCK(String str) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ORDERPAGE_DELIVERY_EDIT_CK).addEventParam("order_id", str).build().track();
    }

    public static void traceDeliveryConfirmCK(String str) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ORDERPAGE_DELIVERY_CONFIRM_CK).addEventParam("order_id", str).build().track();
    }

    public static void traceDeliveryConfirmChangeCK(Integer num) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ORDERPAGE_DELIVERY_CONFIRM_CHANGE_CK).addEventParam("button_type", num).build().track();
    }

    public static void traceDeliveryConfirmFailSW() {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_ORDERPAGE_DELIVERY_CONFIRM_FAIL_SW).build().track();
    }

    public static void traceCartAddressConfirmCK(Integer num, Integer num2) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_CART_ADDRESS_DETAIL_CONFIRM_CK).addEventParam("from_page", num).addEventParam(ParamConst.PARAM_ADDRESS_EDIT_LOCATION_SOURCE, num2).build().track();
    }

    public static void traceLocationSw(Integer num) {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_CART_ADDRESS_DETAIL_LOCATION_SW).addEventParam("button_type", num).build().track();
    }

    public static void traceLocationMapMove() {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_CART_ADDRESS_DETAIL_LOCATION_MOVE_CK).build().track();
    }

    public static void traceLocationRefreshCk() {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_CART_ADDRESS_DETAIL_LOCATION_REFRESH_CK).build().track();
    }

    public static void traceCartAddressPoiCk() {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_CART_ADDRESS_CART_ADDRESS_POI_CK).build().track();
    }

    public static void traceCartAddressLocationMoveCk() {
        OmegaTracker.Builder.create(EventConst.Address.EVENT_CART_ADDRESS_CART_LOCATION_MOVE_CK).build().track();
    }
}
