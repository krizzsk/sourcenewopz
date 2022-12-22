package com.didi.addressold.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.addressold.vamos.Util.VamosGlobalVariableHub;
import com.didi.addressold.view.SugListViewContainer;
import com.didi.addressold.view.SugSearchView;
import com.didi.component.common.base.ComponentType;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.util.PermissionUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class AddressTrack {

    /* renamed from: a */
    private static Map<Integer, Integer> f7777a = new Hashtable();

    /* renamed from: b */
    private static boolean f7778b = true;

    /* renamed from: c */
    private static boolean f7779c = true;

    /* renamed from: d */
    private static boolean f7780d = true;
    public static boolean isInSelectDestination = false;
    public static boolean isInSelectStart = false;

    public enum ErrorType {
        no_result,
        network_abnormal,
        service_abnormal
    }

    /* renamed from: a */
    private static String m4952a(int i) {
        return i == 3 ? "home" : i == 4 ? ComponentType.COMPANY : i == 1 ? "origin" : i == 2 ? "dest" : "first_page";
    }

    public static void trackUserOperator(int i, int i2) {
        f7777a.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static int getAddressSrcByType(int i) {
        Integer num = f7777a.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static void trackSugLocationCheck(AddressParam addressParam, boolean z) {
        HashMap hashMap = new HashMap();
        if (!(addressParam == null || addressParam.currentAddress == null)) {
            hashMap.put("lat", Double.valueOf(addressParam.currentAddress.latitude));
            hashMap.put("lng", Double.valueOf(addressParam.currentAddress.longitude));
            hashMap.put("result", Integer.valueOf(z ^ true ? 1 : 0));
        }
        m4956a("map_sug_location_check", hashMap);
    }

    /* renamed from: com.didi.addressold.util.AddressTrack$1 */
    static /* synthetic */ class C34441 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$addressold$util$AddressTrack$StartFillFail;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.addressold.util.AddressTrack$StartFillFail[] r0 = com.didi.addressold.util.AddressTrack.StartFillFail.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$addressold$util$AddressTrack$StartFillFail = r0
                com.didi.addressold.util.AddressTrack$StartFillFail r1 = com.didi.addressold.util.AddressTrack.StartFillFail.no_permission     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$addressold$util$AddressTrack$StartFillFail     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.addressold.util.AddressTrack$StartFillFail r1 = com.didi.addressold.util.AddressTrack.StartFillFail.loc_fail     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.util.AddressTrack.C34441.<clinit>():void");
        }
    }

    public enum StartFillFail {
        no_permission,
        loc_fail;

        public String toString() {
            int i = C34441.$SwitchMap$com$didi$addressold$util$AddressTrack$StartFillFail[ordinal()];
            if (i == 1) {
                return "no_permission";
            }
            if (i != 2) {
                return null;
            }
            return "loc_fail";
        }
    }

    public static void trackError(AddressParam addressParam, boolean z, ErrorType errorType) {
        if (addressParam != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type_od", m4952a(addressParam.addressType));
            hashMap.put("type_error", errorType.toString());
            m4956a(z ? "tone_p_sug_error" : "tone_p_rec_error", hashMap);
        }
    }

    /* renamed from: a */
    private static void m4957a(String str, Map<String, Object> map, boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("【key:");
            sb.append(str);
            sb.append("】");
            if (map != null && map.size() > 0) {
                for (Map.Entry next : map.entrySet()) {
                    sb.append("\n");
                    sb.append((String) next.getKey());
                    sb.append(":");
                    sb.append(next.getValue());
                }
            }
            LogUtils.logInfo(sb.toString());
        }
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* renamed from: a */
    private static void m4956a(String str, Map<String, Object> map) {
        m4957a(str, map, false);
    }

    /* renamed from: a */
    private static void m4955a(String str) {
        OmegaSDKAdapter.trackEvent(str);
    }

    public static void trackSugFavoriteClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_faviritePlace_address_ck", hashMap);
    }

    public static void trackSettingsFavoriteClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_faviritePlace_editOtherAdrs_ck", hashMap);
    }

    public static void trackAddAddressItemClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_faviritePlace_adrs_lst_ck", hashMap);
    }

    public static void trackFavoriteDeleteClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_faviritePlace_delOtherAdrs_ck", hashMap);
    }

    public static void trackAddNewFavPlace(FromType fromType) {
        HashMap hashMap = new HashMap();
        boolean z = true;
        if (fromType == FromType.SETTING) {
            hashMap.put("fr", 2);
        } else if (fromType == FromType.HOME) {
            hashMap.put("fr", 1);
        } else {
            z = false;
        }
        getInstance().dumpAlltoAttrMap(hashMap);
        if (z) {
            m4956a("gp_faviritePlace_addNew_ck", hashMap);
        }
    }

    public static void trackEditHomeOrWorkAddress(int i, RpcCommonPoi rpcCommonPoi) {
        HashMap hashMap = new HashMap();
        boolean z = true;
        if (i == 4) {
            hashMap.put("type", 2);
        } else if (i == 3) {
            hashMap.put("type", 1);
        } else {
            z = false;
        }
        if (rpcCommonPoi == null || !TextUtils.isEmpty(rpcCommonPoi.address)) {
            hashMap.put("has_adrs", 1);
        } else {
            hashMap.put("has_adrs", 0);
        }
        getInstance().dumpAlltoAttrMap(hashMap);
        if (z) {
            m4956a("gp_faviritePlace_editAdrs_ck", hashMap);
        }
    }

    public static void trackShowWayPointTips(AddressParam addressParam) {
        HashMap hashMap = new HashMap();
        if (addressParam != null) {
            hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
            hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        }
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_editRoute_cancel_sw", hashMap);
    }

    public static void trackRecItemSelect(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("recpage_enter_num_key", Integer.valueOf(i));
        m4956a("recpage_click_num", hashMap);
    }

    public static void trackRecListEnter() {
        m4955a("recpage_enter_num");
    }

    public static void trackClickWayPointTips() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_editRoute_cancel_ck", hashMap);
    }

    public static String getCurrPage(int i, SugSearchView sugSearchView, SugListViewContainer sugListViewContainer) {
        if (i == 3) {
            String obj = sugSearchView.getCommonEditText().getText().toString();
            return (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj.trim())) ? "home_rec" : "home_sug";
        } else if (i == 4) {
            String obj2 = sugSearchView.getCommonEditText().getText().toString();
            return (TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj2.trim())) ? "company_rec" : "company_sug";
        } else {
            if (i == 1) {
                if (sugListViewContainer.mIsMapDragged) {
                    return "start_setpoint_a";
                }
                if (sugListViewContainer.getScrollY() != 0) {
                    return "start_setpoint_b";
                }
                if (sugSearchView.getStartEditText() != null) {
                    String obj3 = sugSearchView.getStartEditText().getText().toString();
                    return (TextUtils.isEmpty(obj3) || TextUtils.isEmpty(obj3.trim())) ? "start_rec" : "start_sug";
                }
            } else if (i == 2 && sugSearchView.getEndEditText() != null) {
                String obj4 = sugSearchView.getEndEditText().getText().toString();
                return (TextUtils.isEmpty(obj4) || TextUtils.isEmpty(obj4.trim())) ? "end_rec" : "end_sug";
            }
            return "";
        }
    }

    /* renamed from: a */
    private static HashMap<String, Object> m4954a(AddressParam addressParam) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (!(addressParam == null || addressParam.currentAddress == null)) {
            hashMap.put("lat", Double.valueOf(addressParam.currentAddress.latitude));
            hashMap.put("lng", Double.valueOf(addressParam.currentAddress.longitude));
            hashMap.put(Const.PageParams.LATITUDE, Double.valueOf(addressParam.currentAddress.latitude));
            hashMap.put(Const.PageParams.LONGITUDE, Double.valueOf(addressParam.currentAddress.longitude));
        }
        return hashMap;
    }

    /* renamed from: a */
    private static HashMap<String, Object> m4953a(Address address) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (address != null) {
            hashMap.put("poi_id", address.uid);
            hashMap.put("poi_lng", Double.valueOf(address.longitude));
            hashMap.put("poi_lat", Double.valueOf(address.latitude));
            hashMap.put("content", address.displayName);
            hashMap.put("address", address.address);
        }
        return hashMap;
    }

    public static void onViewCreated(SugParams sugParams, SugSearchView sugSearchView, SugListViewContainer sugListViewContainer) {
        if (!CommonUtils.isFromHomePage(sugParams.fromType)) {
            if (CommonUtils.isFromConfirmPage(sugParams.fromType)) {
                if (sugParams.addressParam.addressType == 1) {
                    trackStartPointViewClick(sugParams.addressParam, sugSearchView.getStartEditText().getText().toString().trim(), CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
                }
            } else if (!CommonUtils.isFromGetOnPage(sugParams.fromType) && !CommonUtils.isFromRouteEditor(sugParams.fromType)) {
                CommonUtils.isFromSetting(sugParams.fromType);
            }
        }
    }

    public static void onDestroyView() {
        f7779c = true;
        f7780d = true;
    }

    public static void trackStartPointViewClick(AddressParam addressParam, String str, String str2) {
        if (f7779c) {
            f7779c = false;
            HashMap<String, Object> a = m4954a(addressParam);
            a.put("country", addressParam.currentAddress == null ? "" : addressParam.currentAddress.countryCode);
            a.put("context", str);
            a.put("map_pageid", str2);
            getInstance().dumpAlltoAttrMap(a);
            m4956a("global_rec_origin_ck", a);
        }
    }

    public static void trackRecommendRequest(SugParams sugParams, RpcRecSug rpcRecSug, String str, int i) {
        HashMap<String, Object> a = m4954a(sugParams.addressParam);
        a.put(ServerParam.PARAMS_SEARCHID, rpcRecSug.search_id);
        a.put("searchname", rpcRecSug.search_name);
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
        a.put("resp_time", str);
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4956a("tone_p_x_adrs_fromrecominput_ck", a);
        } else if (i == 2) {
            m4956a("tone_p_x_adrs_torecominput_ck", a);
        }
    }

    public static void trackSuggestRequest(SugParams sugParams, RpcRecSug rpcRecSug, String str, String str2, int i) {
        HashMap<String, Object> a = m4954a(sugParams.addressParam);
        a.put("query", str);
        a.put(ServerParam.PARAMS_SEARCHID, rpcRecSug.search_id);
        a.put("searchname", rpcRecSug.search_name);
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
        a.put("resp_time", str2);
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            if (getInstance().isVamosNow) {
                m4956a("tone_p_x_adrs_fromqryinput_ck", a);
            } else if (!isInSelectStart) {
                m4956a("tone_p_x_adrs_fromqryinput_ck", a);
            }
        } else if (i == 2) {
            if (getInstance().isVamosNow) {
                m4956a("tone_p_x_adrs_toqryinput_ck", a);
            } else if (!isInSelectDestination) {
                m4956a("tone_p_x_adrs_toqryinput_ck", a);
            }
        }
        if (getInstance().isVamosNow && VamosGlobalVariableHub.isInFavoriteLyfeCycle && i == 5) {
            m4956a("gp_faviritePlace_adrs_qryinput_ck", a);
        }
    }

    public static void trackAddressClick(SugParams sugParams, RpcPoiBaseInfo rpcPoiBaseInfo, String str, String str2, String str3, RpcRecSug.TrackParameterForChild trackParameterForChild, int i) {
        if (sugParams != null && rpcPoiBaseInfo != null) {
            HashMap<String, Object> a = m4954a(sugParams.addressParam);
            a.put("address", rpcPoiBaseInfo.address);
            a.put("content", rpcPoiBaseInfo.displayname);
            a.put("rank", str2);
            a.put("rank_sub", str3);
            a.put("poi_id", rpcPoiBaseInfo.poi_id);
            a.put("poi_lng", Double.valueOf(rpcPoiBaseInfo.lng));
            a.put("poi_lat", Double.valueOf(rpcPoiBaseInfo.lat));
            a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
            a.put(DepartureConstants.SRCTAG, rpcPoiBaseInfo.srctag);
            if (trackParameterForChild != null) {
                a.put(ServerParam.PARAMS_SEARCHID, trackParameterForChild.search_id);
                a.put("searchname", trackParameterForChild.search_name);
            }
            getInstance().dumpAlltoAttrMap(a);
            if (i == 1) {
                if (TextUtils.isEmpty(str)) {
                    m4956a("tone_p_x_adrs_fromrecomlst_ck", a);
                    return;
                }
                a.put("query", str);
                if ("piconf_page".equals(CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam))) {
                    m4956a("com_map_QuStratSug_ck_global", a);
                    return;
                }
                if (sugParams != null) {
                    a.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
                    a.put("country_code", PaxEnvironment.getInstance().getCountryCode());
                }
                m4956a("tone_p_x_sug_fromsuglst_ck", a);
            } else if (i != 2) {
            } else {
                if (TextUtils.isEmpty(str)) {
                    m4956a("tone_p_x_adrs_torecomlst_ck", a);
                    return;
                }
                a.put("query", str);
                m4956a("tone_p_x_sug_tosuglst_ck", a);
            }
        }
    }

    public static void trackCloseButtonClick(SugParams sugParams, String str) {
        HashMap<String, Object> a = m4954a(sugParams.addressParam);
        a.put("page", str);
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
        getInstance().dumpAlltoAttrMap(a);
        m4956a("cancel_ck", a);
    }

    public static void trackHomeClick(SugParams sugParams, Address address, int i) {
        HashMap<String, Object> a = m4954a(sugParams.addressParam);
        a.putAll(m4953a(address));
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4956a("tone_p_x_adrs_fromhmaddr_ck", a);
        } else if (i == 2) {
            m4956a("tone_p_x_adrs_tohmaddr_ck", a);
        }
    }

    public static void trackCompanyClick(SugParams sugParams, Address address, int i) {
        HashMap<String, Object> a = m4954a(sugParams.addressParam);
        a.putAll(m4953a(address));
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4956a("tone_p_x_adrs_fromwkaddr_ck", a);
        } else if (i == 2) {
            m4956a("tone_p_x_adrs_towkaddr_ck", a);
        }
    }

    public static void trackCommonClick(SugParams sugParams, RpcCommonPoi rpcCommonPoi, int i, int i2) {
        HashMap<String, Object> a = m4954a(sugParams.addressParam);
        if (rpcCommonPoi != null) {
            a.put("poi_id", rpcCommonPoi.uid);
            a.put("poi_lng", Double.valueOf(rpcCommonPoi.longitude));
            a.put("poi_lat", Double.valueOf(rpcCommonPoi.latitude));
            a.put("content", rpcCommonPoi.displayName);
            a.put("address", rpcCommonPoi.address);
        }
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams.fromType, sugParams.addressParam));
        a.put("rank", Integer.valueOf(i2));
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4956a("tone_p_x_adrs_fromfpaddr_ck", a);
        } else if (i == 2) {
            m4956a("tone_p_x_adrs_tofpaddr_ck", a);
        }
    }

    public static void trackHomeBtnClickDirectly(AddressParam addressParam) {
        HashMap hashMap = new HashMap();
        if (addressParam != null) {
            hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
            hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        }
        m4956a("tone_p_x_adrs_home_btn_ck", hashMap);
    }

    public static void trackWorkBtnClickDirectly() {
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
        hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        m4956a("tone_p_x_adrs_work_btn_ck", hashMap);
    }

    public static void trackFavoritePlaceClick(boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
        hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        String str = "1";
        hashMap.put(ParamConst.PARAM_ADDRESS_HAS_HOME, z ? str : "0");
        if (!z2) {
            str = "0";
        }
        hashMap.put("has_work", str);
        getInstance().dumpAlltoAttrMap(hashMap);
        m4956a("gp_faviritePlace_btn_ck", hashMap);
    }

    private static class LatLng {
        public double lat;
        public double lng;

        public LatLng(double d, double d2) {
            this.lat = d;
            this.lng = d2;
        }
    }

    public static void trackFirstTimeRecList(AddressParam addressParam, String str, RpcRecSug rpcRecSug) {
        int i;
        String str2;
        if (f7780d) {
            f7780d = false;
            HashMap<String, Object> a = m4954a(addressParam);
            a.put("context", str);
            a.put("title", str);
            ArrayList arrayList = new ArrayList();
            String str3 = "0";
            if (rpcRecSug != null) {
                if (rpcRecSug.errno == 0) {
                    str3 = "1";
                }
                str2 = rpcRecSug.search_id;
                i = rpcRecSug.city_id;
                if (rpcRecSug.rec_poi_list != null && rpcRecSug.rec_poi_list.size() > 0) {
                    Iterator<RpcPoi> it = rpcRecSug.rec_poi_list.iterator();
                    while (it.hasNext()) {
                        RpcPoi next = it.next();
                        if (!(next == null || next.base_info == null)) {
                            arrayList.add(new LatLng(next.base_info.lat, next.base_info.lng));
                        }
                    }
                    str3 = "1";
                }
            } else {
                str2 = "";
                i = -1;
            }
            a.put("rec_list", new Gson().toJson((Object) arrayList));
            a.put("result", str3);
            a.put("search_id", str2);
            a.put("city_id", Integer.valueOf(i));
            getInstance().dumpAlltoAttrMap(a);
            m4956a("gp_adrs_recList_rsp", a);
        }
    }

    /* renamed from: b */
    private static String m4958b() {
        return !TextUtils.isEmpty(PaxEnvironment.getInstance().getPhoneNumber()) ? PaxEnvironment.getInstance().getPhoneNumber() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m4959c() {
        return !TextUtils.isEmpty(PaxEnvironment.getInstance().getUid()) ? PaxEnvironment.getInstance().getUid() : "";
    }

    public static void trackSelectDestinationInMap(AddressParam addressParam, String str, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        f7778b = !z;
        hashMap.put(ParamKeys.PARAM_PASSENGER_PHONE, m4958b());
        hashMap.put("passenger_id", m4959c());
        hashMap.put("query", str);
        hashMap.put("if_destination", Boolean.valueOf(z2));
        hashMap.put("if_sug", Boolean.valueOf(z));
        m4956a("select_destination_in_map", hashMap);
    }

    public static void trackSelectDestinationInMapConfirm(AddressParam addressParam, Address address, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_PASSENGER_PHONE, m4958b());
        hashMap.put("passenger_id", m4959c());
        hashMap.put("if_destination", Boolean.valueOf(z2));
        hashMap.put("if_sug", Boolean.valueOf(!f7778b));
        if (address != null) {
            hashMap.put("point_name", address.displayName);
            hashMap.put("point_lng", Double.valueOf(address.longitude));
            hashMap.put("point_lat", Double.valueOf(address.latitude));
        }
        m4956a("select_destination_in_map_confirm", hashMap);
    }

    public static void trackCheckAddressParam(Context context, AddressParam addressParam, FromType fromType) {
        if (context != null && addressParam != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("platform", "android");
            hashMap.put("app_version", SystemUtil.getVersionName());
            hashMap.put("is_location_permissions_granted", Integer.valueOf(PermissionUtil.isLocationPermissionsGranted(context) ? 1 : 0));
            hashMap.put("country_id", PaxEnvironment.getInstance().getCountryCode());
            hashMap.put(CashierParam.PARAM_FROM_TYPE, fromType != null ? fromType.name() : "null");
            hashMap.put(ParamConst.PARAM_CART_ADDRESS_TYPE, Integer.valueOf(addressParam.addressType));
            hashMap.put("phone_number", m4958b());
            if (addressParam.currentAddress == null) {
                hashMap.put("current_address_is_null", 1);
                hashMap.put("current_address_is_invalid", 1);
            } else {
                hashMap.put("current_address_is_null", 0);
                hashMap.put("current_address_is_invalid", Integer.valueOf(CommonUtils.isValidLocation(addressParam.currentAddress) ^ true ? 1 : 0));
            }
            if (addressParam.targetAddress == null) {
                hashMap.put("target_address_is_null", 1);
                hashMap.put("target_address_is_invalid", 1);
            } else {
                hashMap.put("target_address_is_null", 0);
                hashMap.put("target_address_is_invalid", Integer.valueOf(CommonUtils.isValidLocation(addressParam.targetAddress) ^ true ? 1 : 0));
            }
            m4957a("check_sug_page_address_param", hashMap, false);
        }
    }

    public static void trackRescueAddressParamCurrentAddress(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("app_version", SystemUtil.getVersionName());
        hashMap.put("tag", str);
        hashMap.put("tip", str2);
        m4957a("rescue_sug_page_address_param_current_address", hashMap, false);
    }

    public static VamosAttrs getInstance() {
        return VamosAttrs.attrs;
    }

    public static class VamosAttrs {
        private static final String CURRENT_PAGE_NAME = "page";
        private static final String CURRENT_PAGE_VALUE = "sug_page";
        public static final int DRIV_INT_VALUE = 1;
        public static final String DRIV_VALUE = "driver";
        private static final String FROM_PAGE_NAME = "entrance";
        private static final String ORDER_ID_NAME = "order_id";
        public static final int PASG_INT_VAULE = 0;
        public static final String PASG_VAULE = "rider";
        private static final String PRID_NAME = "product_id";
        private static final String TIME_STAMP_NAME = "timestamp";
        private static final String UID_NAME = "uid";
        private static final String USR_TYPE_NAME = "user_type";
        /* access modifiers changed from: private */
        public static final VamosAttrs attrs = new VamosAttrs();
        private boolean isUsrTypeInteger = true;
        /* access modifiers changed from: private */
        public boolean isVamosNow = false;
        private SugParams mParam;
        private String prid = "";
        private String uid = "";
        private String usrType = "";
        private int usrTypeInteger = -1;

        public void collectAllVamosAttrs(SugParams sugParams, String str) {
            if (sugParams == null) {
                this.isVamosNow = false;
                return;
            }
            this.mParam = sugParams;
            this.isVamosNow = true;
            this.prid = PaxEnvironment.getInstance().getProductId();
            if (!TextUtils.isEmpty(this.usrType)) {
                this.usrType = str;
                if (this.isUsrTypeInteger) {
                    if (str.equals("driver")) {
                        this.usrTypeInteger = 1;
                    } else if (this.usrType.equals("rider")) {
                        this.usrTypeInteger = 0;
                    }
                }
            }
            this.uid = AddressTrack.m4959c();
        }

        public void dumpAlltoAttrMap(Map<String, Object> map) {
            if (map != null && this.isVamosNow) {
                map.put("product_id", this.prid);
                map.put("uid", this.uid);
                map.put("user_type", this.isUsrTypeInteger ? Integer.valueOf(this.usrTypeInteger) : this.usrType);
                map.put("entrance", CommonUtils.getFromPageTrack(this.mParam.fromType, this.mParam.addressParam));
                map.put("page", CURRENT_PAGE_VALUE);
                map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                map.put("order_id", "null");
            }
        }
    }
}
