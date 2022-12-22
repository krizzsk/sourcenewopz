package com.didi.component.common.util;

import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.MapUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import java.util.HashMap;
import java.util.Map;

public class OnServiceOmegaUtil {
    public static final int NOT_SUPPORT_WAY_POINT_SCENE_CLICK = 2;
    public static final int NOT_SUPPORT_WAY_POINT_SCENE_SHOW = 1;

    /* renamed from: a */
    private static final String f11774a = "gp_changeFromAddress_edit_ck";

    /* renamed from: b */
    private static final String f11775b = "gp_changeFromAddress_map_sw";

    /* renamed from: c */
    private static final String f11776c = "gp_changeFromAddress_map_ck";

    /* renamed from: d */
    private static final String f11777d = "gp_changeFromAddress_success_sw";

    /* renamed from: e */
    private static final String f11778e = "gp_changeFromAddress_err_sw";

    /* renamed from: f */
    private static final String f11779f = "gp_changeFromAddress_popup_sw";

    /* renamed from: g */
    private static final String f11780g = "gp_changeFromAddress_mapBtn_ck";

    /* renamed from: h */
    private static final String f11781h = "gp_editRoute_dNotSupport_sw";

    /* renamed from: i */
    private static final String f11782i = "sub_status";

    /* renamed from: j */
    private static final String f11783j = "order_id";

    /* renamed from: k */
    private static final String f11784k = "bf_lat";

    /* renamed from: l */
    private static final String f11785l = "bf_lng";

    /* renamed from: m */
    private static final String f11786m = "bf_address";

    /* renamed from: n */
    private static final String f11787n = "af_lat";

    /* renamed from: o */
    private static final String f11788o = "af_lng";

    /* renamed from: p */
    private static final String f11789p = "af_address";

    /* renamed from: q */
    private static final String f11790q = "distance";

    /* renamed from: r */
    private static final String f11791r = "err_no";

    /* renamed from: s */
    private static final String f11792s = "driver_id";

    /* renamed from: t */
    private static final String f11793t = "scene";

    /* renamed from: u */
    private static final String f11794u = "channel";

    /* renamed from: v */
    private static final String f11795v = "map";

    /* renamed from: w */
    private static final String f11796w = "pre-cancel";

    /* renamed from: x */
    private static String f11797x = "map";

    public static void sendClickEditOmega() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            GlobalOmegaUtils.trackEvent(f11774a, (Map<String, Object>) hashMap);
        }
    }

    public static void sendClickUpdateButtonOmega() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put("channel", f11797x);
            GlobalOmegaUtils.trackEvent(f11780g, (Map<String, Object>) hashMap);
        }
    }

    public static void sendShowUpdatePickUpPageOmega() {
        if (!"pick".equals(OmegaSDK.getGlobalAttr("g_PageId"))) {
            GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            GlobalOmegaUtils.trackEvent(f11775b, (Map<String, Object>) hashMap);
        }
    }

    public static void sendClickUpdatePickUpAddressOmega() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            GlobalOmegaUtils.trackEvent(f11776c, (Map<String, Object>) hashMap);
        }
    }

    public static void sendUpdatePickUpSuccessOmega(Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        GlobalOmegaUtils.putGlobal("g_PageId", "pick");
        if (order != null && order.startAddress != null && address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put(f11784k, Double.valueOf(order.startAddress.latitude));
            hashMap.put(f11785l, Double.valueOf(order.startAddress.longitude));
            hashMap.put(f11786m, order.startAddress.address);
            hashMap.put("af_lat", Double.valueOf(address.latitude));
            hashMap.put(f11788o, Double.valueOf(address.longitude));
            hashMap.put(f11789p, address.address);
            hashMap.put("distance", Double.valueOf(MapUtils.getDistance(address, order.startAddress)));
            hashMap.put("channel", f11797x);
            GlobalOmegaUtils.trackEvent(f11777d, (Map<String, Object>) hashMap);
        }
    }

    public static void sendUpdatePickUpFailOutOfAreaOmega(Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.startAddress != null && address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put(f11784k, Double.valueOf(order.startAddress.latitude));
            hashMap.put(f11785l, Double.valueOf(order.startAddress.longitude));
            hashMap.put(f11786m, order.startAddress.address);
            hashMap.put("af_lat", Double.valueOf(address.latitude));
            hashMap.put(f11788o, Double.valueOf(address.longitude));
            hashMap.put(f11789p, address.address);
            hashMap.put("distance", Double.valueOf(MapUtils.getDistance(address, order.startAddress)));
            GlobalOmegaUtils.trackEvent(f11779f, (Map<String, Object>) hashMap);
        }
    }

    public static void sendUpdatePickUpFailOmega(int i, Address address) {
        CarOrder order = CarOrderHelper.getOrder();
        GlobalOmegaUtils.putGlobal("g_PageId", GPageIdConstant.G_PAGE_ID_PICONF);
        if (order != null && order.startAddress != null && address != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sub_status", Integer.valueOf(order.substatus));
            hashMap.put("order_id", order.oid);
            hashMap.put(f11784k, Double.valueOf(order.startAddress.latitude));
            hashMap.put(f11785l, Double.valueOf(order.startAddress.longitude));
            hashMap.put(f11786m, order.startAddress.address);
            hashMap.put("af_lat", Double.valueOf(address.latitude));
            hashMap.put(f11788o, Double.valueOf(address.longitude));
            hashMap.put(f11789p, address.address);
            hashMap.put("distance", Double.valueOf(MapUtils.getDistance(address, order.startAddress)));
            hashMap.put(f11791r, Integer.valueOf(i));
            hashMap.put("channel", f11797x);
            GlobalOmegaUtils.trackEvent(f11778e, (Map<String, Object>) hashMap);
        }
    }

    public static void sendNotSupportWayPointOmage(int i, CarOrder carOrder) {
        HashMap hashMap = new HashMap();
        hashMap.put("scene", Integer.valueOf(i));
        if (!(carOrder == null || carOrder.carDriver == null)) {
            hashMap.put("driver_id", carOrder.carDriver.did);
        }
        GlobalOmegaUtils.trackEvent(f11781h, (Map<String, Object>) hashMap);
    }

    public static void setOmegaParamUpdatePickUpChannelPreCancel() {
        f11797x = f11796w;
    }

    public static void setOmegaParamUpdatePickUpChannelMap() {
        f11797x = "map";
    }
}
