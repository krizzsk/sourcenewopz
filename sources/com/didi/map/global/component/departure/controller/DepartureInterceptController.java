package com.didi.map.global.component.departure.controller;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.fence.FenceController;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public class DepartureInterceptController {

    /* renamed from: a */
    private String f25032a = "DepartureController";

    /* renamed from: b */
    private Map f25033b;

    /* renamed from: c */
    private boolean f25034c = false;

    /* renamed from: d */
    private Context f25035d;

    /* renamed from: e */
    private FenceController f25036e;

    /* renamed from: f */
    private DepartureControllerParams f25037f;

    /* renamed from: g */
    private OrderInterceptMode f25038g = OrderInterceptMode.MODE_NORMAL;

    /* renamed from: h */
    private int f25039h = 0;

    /* renamed from: i */
    private IInterceptListener f25040i;

    /* renamed from: j */
    private String f25041j;

    /* renamed from: k */
    private boolean f25042k = false;

    /* renamed from: l */
    private DepartureAddress f25043l;

    /* renamed from: m */
    private DIDILocation f25044m;

    public interface IInterceptListener {
        void onContinue();

        void onIntercept(OrderInterceptMode orderInterceptMode, boolean z);

        void onStart();
    }

    public DepartureInterceptController(DepartureControllerParams departureControllerParams) {
        if (departureControllerParams != null) {
            this.f25033b = departureControllerParams.getMap();
            this.f25035d = departureControllerParams.getContext();
            this.f25036e = departureControllerParams.getFenceController();
            this.f25037f = departureControllerParams;
        }
    }

    public boolean isHasDragged() {
        return this.f25042k;
    }

    public void setHasDragged(boolean z) {
        this.f25042k = z;
    }

    public void updateNewRequestLocation(DepartureAddress departureAddress, String str) {
        DepartureAddress departureAddress2;
        if (this.f25040i != null && this.f25034c) {
            this.f25034c = false;
            if (departureAddress == null || (departureAddress2 = this.f25043l) == null || LatLngUtils.isSameLatLng(departureAddress2.getPosition(), departureAddress.getPosition())) {
                this.f25040i.onIntercept(this.f25038g, false);
            } else {
                this.f25040i.onIntercept(this.f25038g, true);
            }
        }
        this.f25043l = departureAddress;
        DLog.m7384d(this.f25032a, "更新 departure address", new Object[0]);
        if (str == null || str.isEmpty()) {
            this.f25041j = "verybad";
        } else {
            this.f25041j = str;
        }
    }

    public void upDateCurrentLocation(DIDILocation dIDILocation) {
        this.f25044m = dIDILocation;
    }

    public void addInterceptListener(IInterceptListener iInterceptListener) {
        if (m17885a()) {
            DLog.m7384d(this.f25032a, "new intercept", new Object[0]);
            addInterceptListenerNew(iInterceptListener);
            return;
        }
        DLog.m7384d(this.f25032a, "old intercept", new Object[0]);
        addInterceptListenerOld(iInterceptListener);
    }

    /* renamed from: a */
    private boolean m17885a() {
        IExperiment experiment;
        try {
            IToggle toggle = Apollo.getToggle("global_pickup_intercept_fix_ab");
            if (!(toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null)) {
                int intValue = ((Integer) experiment.getParam("enable", 0)).intValue();
                DLog.m7384d("global_pickup_intercept_fix_ab", "" + intValue, new Object[0]);
                if (intValue == 1) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            DLog.m7384d("global_pickup_intercept_fix_ab", "" + e.toString(), new Object[0]);
            e.printStackTrace();
        }
        return false;
    }

    public void addInterceptListenerNew(IInterceptListener iInterceptListener) {
        this.f25040i = iInterceptListener;
        if (this.f25037f == null || iInterceptListener == null || this.f25034c) {
            DLog.m7384d(this.f25032a, "param=null || listener==null || mIsIntercept=true", new Object[0]);
            return;
        }
        DepartureAddress departureAddress = this.f25043l;
        if (departureAddress == null || departureAddress.getAddress() == null || this.f25043l.getPosition() == null) {
            DLog.m7384d(this.f25032a, "departureAddress 位置参数为空", new Object[0]);
            iInterceptListener.onContinue();
            return;
        }
        LatLng position = this.f25043l.getPosition();
        this.f25039h = this.f25043l.getAddress().operationType;
        if (m17886a(position)) {
            iInterceptListener.onContinue();
            return;
        }
        String str = this.f25032a;
        DLog.m7384d(str, "当前位置定位精度" + this.f25041j, new Object[0]);
        String str2 = this.f25032a;
        DLog.m7384d(str2, "interceptSceneType = 获取选点类型" + this.f25039h, new Object[0]);
        if (isHasDragged()) {
            DLog.m7384d(this.f25032a, "用户拖拽地图", new Object[0]);
            this.f25039h = 1;
        }
        if (m17889b(position)) {
            OrderInterceptMode orderInterceptMode = OrderInterceptMode.MODE_START_NEAR_END;
            this.f25038g = orderInterceptMode;
            iInterceptListener.onIntercept(orderInterceptMode, false);
            return;
        }
        if (this.f25044m == null) {
            this.f25044m = LocationHelper2.getLastKnownLocation(this.f25035d, LocationRegisterParam.LocType.FLP);
        }
        DIDILocation dIDILocation = this.f25044m;
        if (dIDILocation == null) {
            DLog.m7384d(this.f25032a, "定位位置参数为空", new Object[0]);
            iInterceptListener.onContinue();
            return;
        }
        LatLng latLng = new LatLng(dIDILocation.getLatitude(), this.f25044m.getLongitude());
        if (this.f25039h == 0) {
            if (m17887a(latLng, position)) {
                this.f25034c = true;
                DLog.m7384d(this.f25032a, "默认场景触发重新请求上车点", new Object[0]);
                iInterceptListener.onStart();
                return;
            }
            iInterceptListener.onContinue();
        } else if (m17888a(this.f25044m, latLng, position)) {
            OrderInterceptMode orderInterceptMode2 = OrderInterceptMode.MODE_START_POSITION_TO_FAR;
            this.f25038g = orderInterceptMode2;
            iInterceptListener.onIntercept(orderInterceptMode2, false);
        } else {
            iInterceptListener.onContinue();
        }
    }

    public void addInterceptListenerOld(IInterceptListener iInterceptListener) {
        this.f25040i = iInterceptListener;
        if (this.f25037f == null || iInterceptListener == null || this.f25034c) {
            DLog.m7384d(this.f25032a, "param=null || listener==null || mIsIntercept=true", new Object[0]);
            return;
        }
        DepartureAddress departureAddress = this.f25043l;
        if (departureAddress == null || departureAddress.getAddress() == null || this.f25043l.getPosition() == null || this.f25044m == null) {
            DLog.m7384d(this.f25032a, "departureAddress 位置参数为空", new Object[0]);
            iInterceptListener.onContinue();
            return;
        }
        LatLng position = this.f25043l.getPosition();
        LatLng latLng = new LatLng(this.f25044m.getLatitude(), this.f25044m.getLongitude());
        this.f25039h = this.f25043l.getAddress().operationType;
        if (m17886a(position)) {
            iInterceptListener.onContinue();
            return;
        }
        String str = this.f25032a;
        DLog.m7384d(str, "当前位置定位精度" + this.f25041j, new Object[0]);
        String str2 = this.f25032a;
        DLog.m7384d(str2, "interceptSceneType = 获取选点类型" + this.f25039h, new Object[0]);
        if (isHasDragged()) {
            DLog.m7384d(this.f25032a, "用户拖拽地图", new Object[0]);
            this.f25039h = 1;
        }
        if (m17889b(position)) {
            OrderInterceptMode orderInterceptMode = OrderInterceptMode.MODE_START_NEAR_END;
            this.f25038g = orderInterceptMode;
            iInterceptListener.onIntercept(orderInterceptMode, false);
        } else if (this.f25039h == 0) {
            if (m17887a(latLng, position)) {
                this.f25034c = true;
                DLog.m7384d(this.f25032a, "默认场景触发重新请求上车点", new Object[0]);
                iInterceptListener.onStart();
                return;
            }
            iInterceptListener.onContinue();
        } else if (m17888a(this.f25044m, latLng, position)) {
            OrderInterceptMode orderInterceptMode2 = OrderInterceptMode.MODE_START_POSITION_TO_FAR;
            this.f25038g = orderInterceptMode2;
            iInterceptListener.onIntercept(orderInterceptMode2, false);
        } else {
            iInterceptListener.onContinue();
        }
    }

    /* renamed from: a */
    private boolean m17888a(DIDILocation dIDILocation, LatLng latLng, LatLng latLng2) {
        DepartureAddress departureAddress;
        String str = this.f25032a;
        DLog.m7384d(str, "非默认场景用户移动速度： " + dIDILocation.getSpeed(), new Object[0]);
        if (dIDILocation.getSpeed() < ((float) InterceptConfig.getInstance().filter_loc_speed)) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
            String str2 = this.f25032a;
            DLog.m7384d(str2, "非默认场景，两点距离：" + computeDistanceBetween, new Object[0]);
            if (computeDistanceBetween > InterceptConfig.getInstance().filter_sel_min_start_loc_dist && computeDistanceBetween < InterceptConfig.getInstance().filter_sel_max_start_loc_dist && InterceptConfig.getInstance().allow_loc_acc_level.contains(this.f25041j) && (departureAddress = this.f25043l) != null && departureAddress.getAddress() != null) {
                String str3 = this.f25032a;
                DLog.m7384d(str3, "非默认场景- 是否有定点完单" + this.f25043l.getAddress().getPickupPointOrderStatus(), new Object[0]);
                if (this.f25043l.getAddress().getPickupPointOrderStatus() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17886a(LatLng latLng) {
        if (latLng == null) {
            DLog.m7384d(this.f25032a, "departure ==null", new Object[0]);
            return true;
        } else if (this.f25033b == null || this.f25037f == null || this.f25036e == null) {
            DLog.m7384d(this.f25032a, "必要参数为null，不拦截", new Object[0]);
            return true;
        } else if (!InterceptConfig.getInstance().enable) {
            DLog.m7384d(this.f25032a, "appllo 控制器设置不拦截", new Object[0]);
            return true;
        } else if (!DepartureDataStore.getInstance().isInterceptTimeInvalid()) {
            DLog.m7384d(this.f25032a, "时间频次不符 不拦截", new Object[0]);
            return true;
        } else if (this.f25036e.isInFence(latLng) == 0 || this.f25036e.isInFence(latLng) == 1) {
            String str = this.f25032a;
            DLog.m7384d(str, " 当前点在场站/禁停围栏内，不拦截" + this.f25036e.isInFence(latLng), new Object[0]);
            return true;
        } else if (this.f25037f.getSceneType() != 1) {
            return false;
        } else {
            DLog.m7384d(this.f25032a, "拼车不拦截", new Object[0]);
            return true;
        }
    }

    /* renamed from: b */
    private boolean m17889b(LatLng latLng) {
        DepartureControllerParams departureControllerParams;
        if (!(latLng == null || (departureControllerParams = this.f25037f) == null || departureControllerParams.getEndPoint() == null || this.f25037f.isHasWayPoint())) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(this.f25037f.getEndPoint(), latLng);
            String str = this.f25032a;
            DLog.m7384d(str, "start position" + latLng.toString(), new Object[0]);
            String str2 = this.f25032a;
            DLog.m7384d(str2, "end position" + this.f25037f.getEndPoint().toString(), new Object[0]);
            String str3 = this.f25032a;
            DLog.m7384d(str3, "拦截判断起终点直线距离:" + computeDistanceBetween, new Object[0]);
            if (computeDistanceBetween < InterceptConfig.getInstance().filter_start_end_dist) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m17887a(LatLng latLng, LatLng latLng2) {
        DLog.m7384d(this.f25032a, "默认场景判断开始- ", new Object[0]);
        if (InterceptConfig.getInstance().allow_loc_acc_level.contains(this.f25041j)) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(latLng, latLng2);
            String str = this.f25032a;
            DLog.m7384d(str, "默认场景上车点推荐过远- distance =" + computeDistanceBetween, new Object[0]);
            DepartureAddress departureAddress = this.f25043l;
            if (departureAddress == null || departureAddress.getAddress() == null) {
                return false;
            }
            String str2 = this.f25032a;
            DLog.m7384d(str2, "默认场景上车点推荐过远- has_pickup_point_order =" + this.f25043l.getAddress().getPickupPointOrderStatus(), new Object[0]);
            if (computeDistanceBetween <= InterceptConfig.getInstance().filter_rec_start_loc_dist || this.f25043l.getAddress().getPickupPointOrderStatus() != 0) {
                return false;
            }
            this.f25038g = OrderInterceptMode.MODE_REC_POSITION_TO_FAR;
        } else if (!InterceptConfig.getInstance().allow_loc_acc_level_bad.equalsIgnoreCase(this.f25041j)) {
            return false;
        } else {
            this.f25038g = OrderInterceptMode.MODE_REC_POSITION_LEVEL_BAD;
            DLog.m7384d(this.f25032a, "定位精度极差-", new Object[0]);
        }
        return true;
    }
}
