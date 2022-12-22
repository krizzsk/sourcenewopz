package com.didi.addressnew.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.view.SugListViewContainer;
import com.didi.addressnew.view.SugSearchView;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.push.ServerParam;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.omega.sdk.feedback.FeedbackConfig;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.sdk.poibase.util.PermissionUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddressTrack {

    /* renamed from: a */
    private static Map<Integer, Integer> f7469a = new Hashtable();

    /* renamed from: b */
    private static boolean f7470b = true;

    /* renamed from: c */
    private static LIST_REQUEST_TYPE f7471c;

    /* renamed from: d */
    private static boolean f7472d = true;
    public static boolean isInSelectDestination = false;
    public static boolean isInSelectStart = false;
    public static int page_level_one = 1;
    public static int page_level_two = 2;
    public static String rec_resp_time = "";
    public static String sug_resp_time = "";

    public enum ErrorType {
        no_result,
        network_abnormal,
        service_abnormal
    }

    /* renamed from: a */
    private static String m4719a(int i) {
        return i == 3 ? "home" : i == 4 ? ComponentType.COMPANY : i == 1 ? "origin" : i == 2 ? "dest" : "first_page";
    }

    /* renamed from: b */
    private static int m4728b(int i) {
        if (i == 101 || i == 102) {
            return 3;
        }
        switch (i) {
            case 1:
            case 2:
                return i;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 3;
            default:
                return 0;
        }
    }

    public enum SUG_JUMP_TYPE {
        JUMP_NORMAL(1),
        JUMP_POI(2),
        JUMP_DROP_CONFIRM(3);
        
        /* access modifiers changed from: private */
        public final int value;

        private SUG_JUMP_TYPE(int i) {
            this.value = i;
        }
    }

    public enum SEARCH_CK_TYPE {
        SEARCH_LIST_CK(1),
        SEARCH_MAP_CK(2),
        POI_MAP_CK(3),
        POI_GROUP_CK(4),
        POI_CONFIRM(5),
        POI_BACK(6),
        MAP_BACK(7);
        
        /* access modifiers changed from: private */
        public final int value;

        private SEARCH_CK_TYPE(int i) {
            this.value = i;
        }
    }

    public enum SUG_MAP_PAGE {
        START_MAP_SELECT(1),
        END_MAP_SELECT(2),
        START_POI(3),
        END_POI(4);
        
        /* access modifiers changed from: private */
        public final int value;

        private SUG_MAP_PAGE(int i) {
            this.value = i;
        }
    }

    public enum LIST_REQUEST_TYPE {
        START_REC(1),
        START_SUG(2),
        END_REC(3),
        END_SUG(4);
        
        private final int value;

        private LIST_REQUEST_TYPE(int i) {
            this.value = i;
        }
    }

    public static void setListRequestType(LIST_REQUEST_TYPE list_request_type) {
        f7471c = list_request_type;
    }

    public static LIST_REQUEST_TYPE getmCurrentListType() {
        return f7471c;
    }

    public static void trackUserOperator(int i, int i2) {
        f7469a.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static int getAddressSrcByType(int i) {
        Integer num = f7469a.get(Integer.valueOf(i));
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
        m4725a("map_sug_location_check", (Map<String, Object>) hashMap);
    }

    /* renamed from: com.didi.addressnew.util.AddressTrack$1 */
    static /* synthetic */ class C33301 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$addressnew$util$AddressTrack$StartFillFail;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.addressnew.util.AddressTrack$StartFillFail[] r0 = com.didi.addressnew.util.AddressTrack.StartFillFail.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$addressnew$util$AddressTrack$StartFillFail = r0
                com.didi.addressnew.util.AddressTrack$StartFillFail r1 = com.didi.addressnew.util.AddressTrack.StartFillFail.no_permission     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$addressnew$util$AddressTrack$StartFillFail     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.addressnew.util.AddressTrack$StartFillFail r1 = com.didi.addressnew.util.AddressTrack.StartFillFail.loc_fail     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.util.AddressTrack.C33301.<clinit>():void");
        }
    }

    public enum StartFillFail {
        no_permission,
        loc_fail;

        public String toString() {
            int i = C33301.$SwitchMap$com$didi$addressnew$util$AddressTrack$StartFillFail[ordinal()];
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
            hashMap.put("type_od", m4719a(addressParam.addressType));
            hashMap.put("type_error", errorType.toString());
            m4725a(z ? "tone_p_sug_error" : "tone_p_rec_error", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private static void m4726a(String str, Map<String, Object> map, boolean z) {
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
            DLog.m7384d(FeedbackConfig.FT_SUG, sb.toString(), new Object[0]);
        }
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* renamed from: a */
    private static void m4725a(String str, Map<String, Object> map) {
        m4726a(str, map, false);
    }

    /* renamed from: a */
    private static void m4724a(String str) {
        OmegaSDKAdapter.trackEvent(str);
    }

    public static void trackSugFavoriteClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_faviritePlace_address_ck", (Map<String, Object>) hashMap);
    }

    public static void trackSettingsFavoriteClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_faviritePlace_editOtherAdrs_ck", (Map<String, Object>) hashMap);
    }

    public static void trackAddAddressItemClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_faviritePlace_adrs_lst_ck", (Map<String, Object>) hashMap);
    }

    public static void trackFavoriteDeleteClick() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_faviritePlace_delOtherAdrs_ck", (Map<String, Object>) hashMap);
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
            m4725a("gp_faviritePlace_addNew_ck", (Map<String, Object>) hashMap);
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
            m4725a("gp_faviritePlace_editAdrs_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackShowWayPointTips() {
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
        hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_editRoute_cancel_sw", (Map<String, Object>) hashMap);
    }

    public static void trackRecItemSelect(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("recpage_enter_num_key", Integer.valueOf(i));
        m4725a("recpage_click_num", (Map<String, Object>) hashMap);
    }

    public static void trackRecListEnter() {
        m4724a("recpage_enter_num");
    }

    public static void trackClickWayPointTips() {
        HashMap hashMap = new HashMap();
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_editRoute_cancel_ck", (Map<String, Object>) hashMap);
    }

    public static void trackWayPointAddCK(WayPointParam wayPointParam) {
        if (wayPointParam != null && !CollectionUtil.isEmpty((Collection<?>) wayPointParam.getWayPoints())) {
            boolean z = true;
            List<WayPoint> a = m4723a(wayPointParam.getWayPoints(), 1);
            boolean z2 = !CollectionUtil.isEmpty((Collection<?>) a) && CommonUtils.isValidLocation(a.get(0).getAddress());
            List<WayPoint> a2 = m4723a(wayPointParam.getWayPoints(), 3);
            if (CollectionUtil.isEmpty((Collection<?>) a2) || !CommonUtils.isValidLocation(a2.get(a2.size() - 1).getAddress())) {
                z = false;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("has_from_address", Boolean.valueOf(z2));
            hashMap.put("has_to_address", Boolean.valueOf(z));
            m4725a("ibt_gp_editroute_add_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackWayPointSW(WayPointParam wayPointParam) {
        boolean z;
        Address address;
        if (wayPointParam != null && !CollectionUtil.isEmpty((Collection<?>) wayPointParam.getWayPoints())) {
            boolean z2 = true;
            List<WayPoint> a = m4723a(wayPointParam.getWayPoints(), 1);
            Address address2 = null;
            if (CollectionUtil.isEmpty((Collection<?>) a) || !CommonUtils.isValidLocation(a.get(0).getAddress())) {
                address = null;
                z = false;
            } else {
                address = a.get(0).getAddress();
                z = true;
            }
            List<WayPoint> a2 = m4723a(wayPointParam.getWayPoints(), 3);
            if (CollectionUtil.isEmpty((Collection<?>) a2) || !CommonUtils.isValidLocation(a2.get(a2.size() - 1).getAddress())) {
                z2 = false;
            } else {
                address2 = a2.get(a2.size() - 1).getAddress();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("from_lat", "");
            hashMap.put("from_lng", "");
            hashMap.put("to_lat", "");
            hashMap.put("to_lng", "");
            if (CommonUtils.isValidLocation(address)) {
                hashMap.put("from_lat", Double.valueOf(address.latitude));
                hashMap.put("from_lng", Double.valueOf(address.longitude));
            }
            if (CommonUtils.isValidLocation(address2)) {
                hashMap.put("to_lat", Double.valueOf(address2.latitude));
                hashMap.put("to_lng", Double.valueOf(address2.longitude));
            }
            hashMap.put("has_from_address", Boolean.valueOf(z));
            hashMap.put("has_to_address", Boolean.valueOf(z2));
            m4725a("gp_editRoute_edit_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void trackWayPointViewCK(SugParams sugParams) {
        HashMap hashMap = new HashMap();
        if (!(sugParams == null || sugParams.addressParam == null)) {
            AddressParam addressParam = sugParams.addressParam;
            hashMap.put("city_id", addressParam.currentAddress == null ? "" : Integer.valueOf(addressParam.currentAddress.cityId));
            hashMap.put("country_code", (addressParam.currentAddress == null || TextUtils.isEmpty(addressParam.currentAddress.countryCode)) ? ContryConvertUtil.countryId2CountryCode(addressParam.countryId) : addressParam.currentAddress.countryCode);
            hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
        }
        m4725a("ibt_gp_editroute_toaddr_ck", (Map<String, Object>) hashMap);
    }

    public static void trackWayPointConfirmCK(List<WayPoint> list) {
        ArrayList arrayList;
        Address address;
        HashMap hashMap = new HashMap();
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            List<WayPoint> a = m4723a(list, 1);
            Address address2 = null;
            Address address3 = (CollectionUtil.isEmpty((Collection<?>) a) || !CommonUtils.isValidLocation(a.get(0).getAddress())) ? null : a.get(0).getAddress();
            List<WayPoint> a2 = m4723a(list, 2);
            if (a2 != null) {
                arrayList = new ArrayList();
                for (WayPoint next : a2) {
                    if (CommonUtils.isValidLocation(next.getAddress())) {
                        arrayList.add(next.getAddress());
                    }
                }
            } else {
                arrayList = null;
            }
            List<WayPoint> a3 = m4723a(list, 3);
            if (!CollectionUtil.isEmpty((Collection<?>) a3) && CommonUtils.isValidLocation(a3.get(a3.size() - 1).getAddress())) {
                address2 = a3.get(a3.size() - 1).getAddress();
            }
            if (address3 != null) {
                hashMap.put("from_lat", Double.valueOf(address3.getLatitude()));
                hashMap.put("from_lng", Double.valueOf(address3.getLongitude()));
            }
            if (address2 != null) {
                hashMap.put("to_lat", Double.valueOf(address2.getLatitude()));
                hashMap.put("to_lng", Double.valueOf(address2.getLongitude()));
            } else if (!CollectionUtil.isEmpty((Collection<?>) arrayList) && (address = (Address) arrayList.get(arrayList.size() - 1)) != null) {
                hashMap.put("to_lat", Double.valueOf(address.getLatitude()));
                hashMap.put("to_lng", Double.valueOf(address.getLongitude()));
            }
            if (arrayList != null) {
                if (address2 != null) {
                    hashMap.put("stopover_num", Integer.valueOf(arrayList.size()));
                } else {
                    hashMap.put("stopover_num", Integer.valueOf(-arrayList.size()));
                }
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    Address address4 = (Address) arrayList.get(i);
                    if (i != arrayList.size() - 1) {
                        sb.append(address4.getLatitude());
                        sb.append(",");
                        sb2.append(address4.getLongitude());
                        sb2.append(",");
                    } else {
                        sb.append(address4.getLatitude());
                        sb2.append(address4.getLongitude());
                    }
                }
                hashMap.put("stopover_lat_list", sb.toString());
                hashMap.put("stopover_lng_list", sb2.toString());
            }
            hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
            m4725a("gp_editRoute_submit_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackSugCancelCK(SugParams sugParams, int i) {
        HashMap hashMap = new HashMap();
        if (!(sugParams == null || sugParams.addressParam == null)) {
            hashMap.put("city_id", sugParams.addressParam.currentAddress == null ? "" : Integer.valueOf(sugParams.addressParam.currentAddress.cityId));
            hashMap.put("country_code", (sugParams.addressParam.currentAddress == null || TextUtils.isEmpty(sugParams.addressParam.currentAddress.countryCode)) ? ContryConvertUtil.countryId2CountryCode(sugParams.addressParam.countryId) : sugParams.addressParam.currentAddress.countryCode);
            hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
            hashMap.put("user_type", PaxEnvironment.getInstance().getRoleType().name());
            hashMap.put("entrance", m4720a(i, f7471c));
            int pageLevel = CommonUtils.getPageLevel(sugParams.fromType, i);
            boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(sugParams.fromType);
            int a = m4717a(i, pageLevel);
            hashMap.put("page_waypoint", Integer.valueOf(isFromRouteEditor ? 1 : 0));
            hashMap.put("page_level", Integer.valueOf(pageLevel));
            hashMap.put("second_source", Integer.valueOf(a));
        }
        m4725a("ibt_gp_searchaddr_cancel_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private static String m4720a(int i, LIST_REQUEST_TYPE list_request_type) {
        String str = "";
        if (i == 1) {
            return "searchdes";
        }
        if (i == 2) {
            if (list_request_type == LIST_REQUEST_TYPE.END_REC) {
                str = "reclist";
            }
            return list_request_type == LIST_REQUEST_TYPE.END_SUG ? "searchorigin" : str;
        } else if (i == 3) {
            return "home";
        } else {
            if (i == 4) {
                return "work";
            }
            if (i == 5) {
                return "favorite";
            }
            if (i == 101 || i == 102) {
                return "editroute";
            }
            return str;
        }
    }

    /* renamed from: a */
    private static List<WayPoint> m4723a(List<WayPoint> list, int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (WayPoint next : list) {
            if (Arrays.binarySearch(iArr, next.getWayPointType()) >= 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void trackMapPoiSelectEditCK(AddressParam addressParam, int i) {
        HashMap hashMap = new HashMap();
        if (addressParam != null) {
            hashMap.put("city_id", addressParam.currentAddress == null ? "" : Integer.valueOf(addressParam.currentAddress.cityId));
            hashMap.put("country_code", (addressParam.currentAddress == null || TextUtils.isEmpty(addressParam.currentAddress.countryCode)) ? ContryConvertUtil.countryId2CountryCode(addressParam.countryId) : addressParam.currentAddress.countryCode);
            hashMap.put("product_id", PaxEnvironment.getInstance().getProductId());
            hashMap.put("user_type", PaxEnvironment.getInstance().getRoleType().name());
            hashMap.put("uid", m4730c());
            hashMap.put("entrance", m4720a(i, f7471c));
        }
        m4725a("ibt_gp_sug_selectaddrinmap_search_ck", (Map<String, Object>) hashMap);
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
    private static HashMap<String, Object> m4722a(AddressParam addressParam) {
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
    private static HashMap<String, Object> m4721a(Address address) {
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
                    trackStartPointViewClick(sugParams.addressParam, sugSearchView.getStartEditText().getText().toString().trim(), CommonUtils.getFromPageTrack(sugParams));
                }
            } else if (!CommonUtils.isFromGetOnPage(sugParams.fromType) && !CommonUtils.isFromRouteEditor(sugParams.fromType)) {
                CommonUtils.isFromSetting(sugParams.fromType);
            }
        }
    }

    public static void onDestroyView() {
        f7472d = true;
    }

    public static void trackStartPointViewClick(AddressParam addressParam, String str, String str2) {
        if (f7472d) {
            f7472d = false;
            HashMap<String, Object> a = m4722a(addressParam);
            a.put("country", addressParam.currentAddress == null ? "" : addressParam.currentAddress.countryCode);
            a.put("context", str);
            a.put("map_pageid", str2);
            getInstance().dumpAlltoAttrMap(a);
            m4725a("global_rec_origin_ck", (Map<String, Object>) a);
        }
    }

    public static void trackRecommendRequest(SugParams sugParams, RpcRecSug rpcRecSug, String str, int i) {
        String str2;
        HashMap<String, Object> a = m4722a(sugParams.addressParam);
        String str3 = "";
        if (rpcRecSug == null) {
            str2 = str3;
        } else {
            str2 = rpcRecSug.search_id;
        }
        a.put(ServerParam.PARAMS_SEARCHID, str2);
        if (rpcRecSug != null) {
            str3 = rpcRecSug.search_name;
        }
        a.put("searchname", str3);
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
        a.put("resp_time", str);
        rec_resp_time = str;
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4725a("tone_p_x_adrs_fromrecominput_ck", (Map<String, Object>) a);
        } else if (i == 2) {
            m4725a("tone_p_x_adrs_torecominput_ck", (Map<String, Object>) a);
        }
    }

    public static void trackSuggestRequest(SugParams sugParams, RpcRecSug rpcRecSug, String str, String str2, int i) {
        String str3;
        if (sugParams != null) {
            HashMap<String, Object> a = m4722a(sugParams.addressParam);
            a.put("query", str);
            String str4 = "";
            if (rpcRecSug == null) {
                str3 = str4;
            } else {
                str3 = rpcRecSug.search_id;
            }
            a.put(ServerParam.PARAMS_SEARCHID, str3);
            if (rpcRecSug != null) {
                str4 = rpcRecSug.search_name;
            }
            a.put("searchname", str4);
            a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
            a.put("resp_time", str2);
            int pageLevel = CommonUtils.getPageLevel(sugParams.fromType, i);
            boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(sugParams.fromType);
            int a2 = m4717a(i, pageLevel);
            a.put("page_waypoint", Integer.valueOf(isFromRouteEditor ? 1 : 0));
            a.put("page_level", Integer.valueOf(pageLevel));
            a.put("second_source", Integer.valueOf(a2));
            sug_resp_time = str2;
            getInstance().dumpAlltoAttrMap(a);
            if (i == 1) {
                if (getInstance().isVamosNow) {
                    m4725a("tone_p_x_adrs_fromqryinput_ck", (Map<String, Object>) a);
                } else if (!isInSelectStart) {
                    m4725a("tone_p_x_adrs_fromqryinput_ck", (Map<String, Object>) a);
                }
            } else if (i == 2) {
                if (getInstance().isVamosNow) {
                    m4725a("tone_p_x_adrs_toqryinput_ck", (Map<String, Object>) a);
                } else if (!isInSelectDestination) {
                    m4725a("tone_p_x_adrs_toqryinput_ck", (Map<String, Object>) a);
                }
            } else if (i == 6 || i == 101 || i == 102) {
                m4725a("ibt_gp_editroute_toaddrinput_ck", (Map<String, Object>) a);
            }
            if (getInstance().isVamosNow && i == 5) {
                m4725a("gp_faviritePlace_adrs_qryinput_ck", (Map<String, Object>) a);
            }
        }
    }

    public static void trackAddressClick(SugParams sugParams, RpcPoiBaseInfo rpcPoiBaseInfo, String str, String str2, String str3, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, SUG_JUMP_TYPE sug_jump_type, int i2) {
        if (sugParams != null && rpcPoiBaseInfo != null) {
            HashMap<String, Object> a = m4722a(sugParams.addressParam);
            a.put("address", rpcPoiBaseInfo.address);
            a.put("content", rpcPoiBaseInfo.displayname);
            a.put("rank", str2);
            a.put("rank_sub", str3);
            a.put("poi_id", rpcPoiBaseInfo.poi_id);
            a.put("poi_lng", Double.valueOf(rpcPoiBaseInfo.lng));
            a.put("poi_lat", Double.valueOf(rpcPoiBaseInfo.lat));
            a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
            a.put(DepartureConstants.SRCTAG, rpcPoiBaseInfo.srctag);
            if (trackParameterForChild != null) {
                a.put(ServerParam.PARAMS_SEARCHID, trackParameterForChild.search_id);
                a.put("searchname", trackParameterForChild.search_name);
            }
            int pageLevel = CommonUtils.getPageLevel(sugParams.fromType, i);
            boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(sugParams.fromType);
            int a2 = m4717a(i, pageLevel);
            a.put("page_waypoint", Integer.valueOf(isFromRouteEditor ? 1 : 0));
            a.put("page_level", Integer.valueOf(pageLevel));
            a.put("second_source", Integer.valueOf(a2));
            a.put("jump_type", Integer.valueOf(sug_jump_type.value));
            getInstance().dumpAlltoAttrMap(a);
            if (i == 1) {
                a.put("query", str);
                a.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
                a.put("country_code", PaxEnvironment.getInstance().getCountryCode());
                a.put("resp_time", sug_resp_time);
                if (i2 == 3) {
                    m4725a("tone_p_x_sug_fromsuglst_ck", (Map<String, Object>) a);
                } else if (i2 == 2) {
                    m4725a("tone_p_x_adrs_fromrecomlst_ck", (Map<String, Object>) a);
                }
            } else if (i == 2) {
                a.put("query", str);
                a.put("resp_time", sug_resp_time);
                if (i2 == 3) {
                    m4725a("tone_p_x_sug_tosuglst_ck", (Map<String, Object>) a);
                } else if (i2 == 2) {
                    m4725a("tone_p_x_adrs_torecomlst_ck", (Map<String, Object>) a);
                }
            } else if (i == 6 || i == 101 || i == 102) {
                m4725a("ibt_gp_editroute_searchlist_ck", (Map<String, Object>) a);
            }
        }
    }

    public static void trackCloseButtonClick(SugParams sugParams, String str) {
        HashMap<String, Object> a = m4722a(sugParams.addressParam);
        a.put("page", str);
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
        getInstance().dumpAlltoAttrMap(a);
        m4725a("cancel_ck", (Map<String, Object>) a);
    }

    public static void trackHomeClick(SugParams sugParams, Address address, int i) {
        HashMap<String, Object> a = m4722a(sugParams.addressParam);
        a.putAll(m4721a(address));
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4725a("tone_p_x_adrs_fromhmaddr_ck", (Map<String, Object>) a);
        } else if (i == 2) {
            m4725a("tone_p_x_adrs_tohmaddr_ck", (Map<String, Object>) a);
        }
    }

    public static void trackCompanyClick(SugParams sugParams, Address address, int i) {
        HashMap<String, Object> a = m4722a(sugParams.addressParam);
        a.putAll(m4721a(address));
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4725a("tone_p_x_adrs_fromwkaddr_ck", (Map<String, Object>) a);
        } else if (i == 2) {
            m4725a("tone_p_x_adrs_towkaddr_ck", (Map<String, Object>) a);
        }
    }

    public static void trackCommonClick(SugParams sugParams, RpcCommonPoi rpcCommonPoi, int i, int i2) {
        HashMap<String, Object> a = m4722a(sugParams.addressParam);
        if (rpcCommonPoi != null) {
            a.put("poi_id", rpcCommonPoi.uid);
            a.put("poi_lng", Double.valueOf(rpcCommonPoi.longitude));
            a.put("poi_lat", Double.valueOf(rpcCommonPoi.latitude));
            a.put("content", rpcCommonPoi.displayName);
            a.put("address", rpcCommonPoi.address);
        }
        a.put("entrance", CommonUtils.getFromPageTrack(sugParams));
        a.put("rank", Integer.valueOf(i2));
        getInstance().dumpAlltoAttrMap(a);
        if (i == 1) {
            m4725a("tone_p_x_adrs_fromfpaddr_ck", (Map<String, Object>) a);
        } else if (i == 2) {
            m4725a("tone_p_x_adrs_tofpaddr_ck", (Map<String, Object>) a);
        }
    }

    public static void trackHomeBtnClickDirectly(AddressParam addressParam, int i, FromType fromType) {
        HashMap hashMap = new HashMap();
        if (addressParam != null) {
            hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
            hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
            hashMap.put("point_type", Integer.valueOf(i));
            if (fromType == FromType.SETTING) {
                hashMap.put("source", "sidebar");
            } else {
                hashMap.put("source", FeedbackConfig.FT_SUG);
            }
        }
        m4725a("tone_p_x_adrs_home_btn_ck", (Map<String, Object>) hashMap);
    }

    public static void trackWorkBtnClickDirectly(AddressParam addressParam, int i, FromType fromType) {
        HashMap hashMap = new HashMap();
        if (addressParam != null) {
            hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
            hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
            hashMap.put("point_type", Integer.valueOf(i));
            if (fromType == FromType.SETTING) {
                hashMap.put("source", "sidebar");
            } else {
                hashMap.put("source", FeedbackConfig.FT_SUG);
            }
        }
        m4725a("tone_p_x_adrs_work_btn_ck", (Map<String, Object>) hashMap);
    }

    public static void trackFavoritePlaceClick(boolean z, boolean z2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("city_id", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
        hashMap.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        String str = "1";
        hashMap.put(ParamConst.PARAM_ADDRESS_HAS_HOME, z ? str : "0");
        if (!z2) {
            str = "0";
        }
        hashMap.put("has_work", str);
        hashMap.put("point_type", Integer.valueOf(i));
        getInstance().dumpAlltoAttrMap(hashMap);
        m4725a("gp_faviritePlace_btn_ck", (Map<String, Object>) hashMap);
    }

    private static class LatLng {
        public double lat;
        public double lng;

        public LatLng(double d, double d2) {
            this.lat = d;
            this.lng = d2;
        }
    }

    public static void trackEndAddressRecList(AddressParam addressParam, String str, RpcRecSug rpcRecSug) {
        int i;
        String str2;
        HashMap<String, Object> a = m4722a(addressParam);
        a.put("context", str);
        a.put("title", str);
        ArrayList arrayList = new ArrayList();
        String str3 = "1";
        String str4 = "0";
        if (rpcRecSug != null) {
            if (rpcRecSug.errno == 0) {
                str4 = str3;
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
                a.put("rec_list", new Gson().toJson((Object) arrayList));
                a.put("result", str3);
                a.put("search_id", str2);
                a.put("city_id", Integer.valueOf(i));
                getInstance().dumpAlltoAttrMap(a);
                m4725a("gp_adrs_recList_rsp", (Map<String, Object>) a);
            }
        } else {
            str2 = "";
            i = -1;
        }
        str3 = str4;
        a.put("rec_list", new Gson().toJson((Object) arrayList));
        a.put("result", str3);
        a.put("search_id", str2);
        a.put("city_id", Integer.valueOf(i));
        getInstance().dumpAlltoAttrMap(a);
        m4725a("gp_adrs_recList_rsp", (Map<String, Object>) a);
    }

    /* renamed from: b */
    private static String m4729b() {
        return PaxEnvironment.getInstance().getPhoneNumber() != null ? PaxEnvironment.getInstance().getPhoneNumber() : "";
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static String m4730c() {
        return PaxEnvironment.getInstance().getUid() != null ? PaxEnvironment.getInstance().getUid() : "";
    }

    public static void trackSelectDestinationInMap(AddressParam addressParam, String str, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        f7470b = !z;
        hashMap.put(ParamKeys.PARAM_PASSENGER_PHONE, m4729b());
        hashMap.put("passenger_id", m4730c());
        hashMap.put("query", str);
        hashMap.put("if_destination", Boolean.valueOf(z2));
        hashMap.put("if_sug", Boolean.valueOf(z));
        m4725a("select_destination_in_map", (Map<String, Object>) hashMap);
    }

    public static void trackSelectDestinationInMapConfirm(AddressParam addressParam, Address address, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamKeys.PARAM_PASSENGER_PHONE, m4729b());
        hashMap.put("passenger_id", m4730c());
        hashMap.put("if_destination", Boolean.valueOf(z2));
        hashMap.put("if_sug", Boolean.valueOf(!f7470b));
        if (address != null) {
            hashMap.put("point_name", address.displayName);
            hashMap.put("point_lng", Double.valueOf(address.longitude));
            hashMap.put("point_lat", Double.valueOf(address.latitude));
        }
        m4725a("select_destination_in_map_confirm", (Map<String, Object>) hashMap);
    }

    public static void trackCheckAddressParam(Context context, AddressParam addressParam, FromType fromType) {
        if (context != null && addressParam != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("platform", "android");
            hashMap.put("app_version", PaxEnvironment.getInstance().getAppVersion());
            hashMap.put("is_location_permissions_granted", Integer.valueOf(PermissionUtil.isLocationPermissionsGranted(context) ? 1 : 0));
            hashMap.put("country_id", PaxEnvironment.getInstance().getCountryCode());
            hashMap.put(CashierParam.PARAM_FROM_TYPE, fromType != null ? fromType.name() : "null");
            hashMap.put(ParamConst.PARAM_CART_ADDRESS_TYPE, Integer.valueOf(addressParam.addressType));
            hashMap.put("phone_number", m4729b());
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
            m4726a("check_sug_page_address_param", hashMap, false);
        }
    }

    public static void trackRescueAddressParamCurrentAddress(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("app_version", SystemUtil.getVersionName());
        hashMap.put("tag", str);
        hashMap.put("tip", str2);
        m4726a("rescue_sug_page_address_param_current_address", hashMap, false);
    }

    public static void trackEndRecVisibleListItemCount(AddressParam addressParam, int i) {
        if (addressParam != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("num", Integer.valueOf(i));
            m4726a("ibt_gp_recdestination_num_bt", hashMap, false);
        }
    }

    public static void trackMapSelect(AddressParam addressParam, int i, boolean z) {
        HashMap hashMap = new HashMap();
        if (addressParam != null) {
            hashMap.put("entrance", m4720a(i, f7471c));
            m4726a("ibt_gp_sug_selectaddrinmap_ck", hashMap, false);
        }
    }

    public static void trackFromConfirmSelectStart(AddressParam addressParam, long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", Long.valueOf(j));
        hashMap.put("operationtype", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("tech_global_confirm_modify_start_sug_time", hashMap);
    }

    public static void trackStartLocationError(double d, double d2) {
        if (!LatLngUtils.locateCorrect(d, d2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("lat", Double.valueOf(d));
            hashMap.put("lng", Double.valueOf(d2));
            GlobalOmegaTracker.trackEvent("tech_global_sug_start_location_error", hashMap);
        }
    }

    public static int extractPoiErrType(RpcPoi rpcPoi) {
        if (!(rpcPoi == null || rpcPoi.base_info == null)) {
            if (TextUtils.isEmpty(rpcPoi.base_info.poi_id)) {
                return 1;
            }
            if (TextUtils.isEmpty(rpcPoi.base_info.displayname)) {
                return 2;
            }
            if (!LatLngUtils.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng)) {
                return 3;
            }
        }
        return -1;
    }

    public static void trackDiscountPoiShowOrClick(boolean z, String str, RpcPoi rpcPoi, RpcPoi rpcPoi2) {
        HashMap hashMap = new HashMap();
        hashMap.put("search_id", str);
        if (!(rpcPoi == null || rpcPoi.base_info == null)) {
            hashMap.put("poi_id", rpcPoi.base_info.poi_id);
            hashMap.put("poi_lng", Double.valueOf(rpcPoi.base_info.lng));
            hashMap.put("poi_lat", Double.valueOf(rpcPoi.base_info.lat));
            hashMap.put("poi_name", rpcPoi.base_info.displayname);
            hashMap.put("poi_address", rpcPoi.base_info.address);
        }
        if (!(rpcPoi2 == null || rpcPoi2.base_info == null)) {
            hashMap.put("low_poi_id", rpcPoi2.base_info.poi_id);
            hashMap.put("low_poi_lng", Double.valueOf(rpcPoi2.base_info.lng));
            hashMap.put("low_poi_lat", Double.valueOf(rpcPoi2.base_info.lat));
            hashMap.put("low_poi_name", rpcPoi2.base_info.address);
        }
        hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
        if (z) {
            m4725a("map_low_drop_sw", (Map<String, Object>) hashMap);
        } else {
            m4725a("map_low_drop_ck", (Map<String, Object>) hashMap);
        }
        DLog.m7384d(FeedbackConfig.FT_SUG, " discount poi item show = " + z, new Object[0]);
    }

    public static void trackMapConfirmTipClick(int i, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("search_id", str);
        hashMap.put("time", Long.valueOf(j));
        if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT) {
            m4725a("map_sug_lowrecall_ck", (Map<String, Object>) hashMap);
        } else if (i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
            m4725a("map_sug_similar_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackMapConfirmTipShow(int i, String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("search_id", str);
        hashMap.put("time", Long.valueOf(j));
        if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT) {
            m4725a("map_sug_lowrecall_sw", (Map<String, Object>) hashMap);
        } else if (i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
            m4725a("map_sug_similar_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void trackFuzzyMatchMapOrListCK(RpcPoi rpcPoi, AddressParam addressParam, int i, int i2, SEARCH_CK_TYPE search_ck_type) {
        HashMap hashMap = new HashMap();
        if (dumpCommonAttrToMap(hashMap, rpcPoi, addressParam)) {
            hashMap.put("click_type", Integer.valueOf(search_ck_type.value));
            hashMap.put("rank", Integer.valueOf(i));
            hashMap.put("rank_sub", Integer.valueOf(i2));
            int i3 = addressParam.addressType;
            if (i3 == 1) {
                m4725a("map_search_fromsuglst_ck", (Map<String, Object>) hashMap);
            }
            if (i3 == 2) {
                m4725a("map_search_tosuglst_ck", (Map<String, Object>) hashMap);
            }
        }
    }

    public static void trackFuzzyMatchBackOrConfirm(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, AddressParam addressParam, SEARCH_CK_TYPE search_ck_type) {
        if (addressParam != null && trackParameterForChild != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ServerParam.PARAMS_SEARCHID, trackParameterForChild.search_id);
            hashMap.put("place_type", Integer.valueOf(addressParam.addressType));
            hashMap.put("time", Long.valueOf(System.currentTimeMillis()));
            if (search_ck_type == SEARCH_CK_TYPE.MAP_BACK) {
                m4725a("map_search_listback_ck", (Map<String, Object>) hashMap);
            } else if (dumpCommonAttrToMap(hashMap, rpcPoi, addressParam)) {
                if (search_ck_type == SEARCH_CK_TYPE.POI_CONFIRM) {
                    m4725a("map_search_poiconfirm_ck", (Map<String, Object>) hashMap);
                } else if (search_ck_type == SEARCH_CK_TYPE.POI_BACK) {
                    m4725a("map_search_poiback_ck", (Map<String, Object>) hashMap);
                }
            }
        }
    }

    public static void trackFuzzyMatchAddMapMarker(RpcPoi rpcPoi, AddressParam addressParam, SUG_MAP_PAGE sug_map_page, boolean z) {
        HashMap hashMap = new HashMap();
        if (dumpCommonAttrToMap(hashMap, rpcPoi, addressParam)) {
            hashMap.put("map_page", Integer.valueOf(sug_map_page.value));
            hashMap.put("content", rpcPoi.base_info.displayname);
            hashMap.put("poi_id", rpcPoi.base_info.poi_id);
            hashMap.put("is_first", Boolean.valueOf(z));
            m4725a("map_search_longpress_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackSugPageSW(int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        m4727a(hashMap, i, i2, i3);
        m4725a("map_sug_sw", (Map<String, Object>) hashMap);
    }

    public static void trackSugInputFocus(int i, int i2, int i3, String str) {
        HashMap hashMap = new HashMap();
        m4727a(hashMap, i2, i3, i);
        hashMap.put("content", str);
        if (i == 1) {
            m4725a("map_from_focus_ck", (Map<String, Object>) hashMap);
        }
        if (i == 2) {
            m4725a("map_to_focus_ck", (Map<String, Object>) hashMap);
        }
        if (i == 6 || i == 101 || i == 102) {
            m4725a("map_waypoint_focus_ck", (Map<String, Object>) hashMap);
        }
        if (i == 3 || i == 5 || i == 4) {
            m4725a("map_other_focus_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void trackSugClear(int i, int i2, int i3, String str) {
        HashMap hashMap = new HashMap();
        m4727a(hashMap, i2, i3, i);
        hashMap.put("content", str);
        hashMap.put("box_type", Integer.valueOf(m4728b(i)));
        m4725a("map_suginput_clear_ck", (Map<String, Object>) hashMap);
    }

    public static void trackScrollCK(int i, int i2, int i3, String str, RpcRecSug.TrackParameterForChild trackParameterForChild, int i4, int i5, boolean z) {
        String str2;
        HashMap hashMap = new HashMap();
        m4727a(hashMap, i2, i3, i);
        String str3 = "";
        if (trackParameterForChild == null) {
            str2 = str3;
        } else {
            str2 = trackParameterForChild.search_id;
        }
        hashMap.put(ServerParam.PARAMS_SEARCHID, str2);
        if (trackParameterForChild != null) {
            str3 = trackParameterForChild.search_name;
        }
        hashMap.put("searchname", str3);
        hashMap.put("query", str);
        hashMap.put("list_type", Integer.valueOf(m4728b(i)));
        hashMap.put("index_from", Integer.valueOf(i4));
        hashMap.put("index_to", Integer.valueOf(i5));
        if (z) {
            m4725a("map_suglst_scrow_ck", (Map<String, Object>) hashMap);
        } else {
            m4725a("map_reclst_scrow_ck", (Map<String, Object>) hashMap);
        }
    }

    /* renamed from: a */
    private static void m4727a(Map<String, Object> map, int i, int i2, int i3) {
        int a = m4717a(i3, i2);
        map.put("page_waypoint", Integer.valueOf(i));
        map.put("page_level", Integer.valueOf(i2));
        map.put("second_source", Integer.valueOf(a));
        map.put("uid", m4730c());
        map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        map.put("country_code", PaxEnvironment.getInstance().getCountryCode());
    }

    /* renamed from: a */
    private static int m4717a(int i, int i2) {
        if (i2 == page_level_one) {
            return 0;
        }
        if (i == 101 || i == 102) {
            return 6;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return i;
            default:
                return 0;
        }
    }

    public static boolean dumpCommonAttrToMap(Map<String, Object> map, RpcPoi rpcPoi, AddressParam addressParam) {
        if (rpcPoi == null || rpcPoi.base_info == null || map == null) {
            return false;
        }
        map.put("address", rpcPoi.base_info.address);
        map.put("content", rpcPoi.base_info.displayname);
        map.put("country_code", PaxEnvironment.getInstance().getCountryCode());
        map.put("city_id", Integer.valueOf(rpcPoi.base_info.city_id));
        if (!(addressParam == null || addressParam.currentAddress == null)) {
            map.put("user_lng", Double.valueOf(addressParam.currentAddress.longitude));
            map.put("user_lat", Double.valueOf(addressParam.currentAddress.latitude));
            map.put("uid", m4730c());
        }
        map.put("poi_id", rpcPoi.base_info.poi_id);
        map.put("poi_lng", Double.valueOf(rpcPoi.base_info.lng));
        map.put("poi_lat", Double.valueOf(rpcPoi.base_info.lat));
        map.put("time", Long.valueOf(System.currentTimeMillis()));
        return true;
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
            this.prid = String.valueOf(PaxEnvironment.getInstance().getProductId());
            if (!TextUtils.isEmpty(str)) {
                this.usrType = str;
                if (this.isUsrTypeInteger) {
                    if (str.equals("driver")) {
                        this.usrTypeInteger = 1;
                    } else if (str.equals("rider")) {
                        this.usrTypeInteger = 0;
                    }
                }
            }
            this.uid = AddressTrack.m4730c();
        }

        public void dumpAlltoAttrMap(Map<String, Object> map) {
            if (map != null && this.isVamosNow) {
                map.put("product_id", this.prid);
                map.put("uid", this.uid);
                map.put("user_type", this.isUsrTypeInteger ? Integer.valueOf(this.usrTypeInteger) : this.usrType);
                map.put("entrance", CommonUtils.getFromPageTrack(this.mParam));
                map.put("page", CURRENT_PAGE_VALUE);
                map.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                map.put("order_id", "null");
            }
        }
    }
}
