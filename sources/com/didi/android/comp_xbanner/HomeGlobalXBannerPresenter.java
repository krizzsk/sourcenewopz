package com.didi.android.comp_xbanner;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p153v2.SecondConfProxy;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.xbanner.XBanner;
import com.didiglobal.xbanner.XBannerCallback;
import com.didiglobal.xbanner.net.model.BizParams;
import com.didiglobal.xbanner.template.view.XBannerNativeView;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class HomeGlobalXBannerPresenter extends AbsGlobalXBannerPresenter implements ILocation.ILocationChangedListener {
    public static final String TAG = "HomeRefactor";

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<String> f8104a = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            int a = HomeGlobalXBannerPresenter.this.m5265a(str2);
            SystemUtils.log(6, "xBannerReloadListener", str2, (Throwable) null, "com.didi.android.comp_xbanner.HomeGlobalXBannerPresenter$6", 436);
            GLog.m7965d(HomeGlobalXBannerPresenter.TAG, "refreshXBanner " + str2);
            HomeGlobalXBannerPresenter.this.m5267a(a);
        }
    };

    /* renamed from: b */
    BaseEventPublisher.OnEventListener<String> f8105b = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (HomeGlobalXBannerPresenter.this.f8107d != null && HomeGlobalXBannerPresenter.this.f8108e && !TextUtils.isEmpty(str2)) {
                HomeGlobalXBannerPresenter.this.f8107d.removeItemByCardid(str2);
            }
        }
    };

    /* renamed from: c */
    BaseEventPublisher.OnEventListener<Integer> f8106c = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            GLog.m7965d(HomeGlobalXBannerPresenter.TAG, "refreshXBanner " + num.toString());
            HomeGlobalXBannerPresenter.this.m5271a(LocationPerformer.getInstance().getLastLocation(), num.intValue());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public XBanner f8107d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f8108e;

    /* renamed from: f */
    private boolean f8109f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BizParams f8110g;

    /* renamed from: h */
    private int f8111h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public XBannerCallback f8112i;

    /* renamed from: j */
    private Activity f8113j;

    /* renamed from: k */
    private BusinessContext f8114k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f8115l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f8116m = 0;

    /* renamed from: n */
    private XEReqJSONParamsCallbackImpl f8117n = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("scene", "home");
            if (HomeGlobalXBannerPresenter.this.f8110g != null) {
                hashMap.put("select_lat", Float.valueOf(HomeGlobalXBannerPresenter.this.f8110g.select_lat));
                hashMap.put("select_lng", Float.valueOf(HomeGlobalXBannerPresenter.this.f8110g.select_lng));
                hashMap.put("user_loc_accuracy", Float.valueOf(HomeGlobalXBannerPresenter.this.f8110g.user_loc_accuracy));
                hashMap.put("user_loc_provider", HomeGlobalXBannerPresenter.this.f8110g.user_loc_provider);
                hashMap.put("page_state", Integer.valueOf(HomeGlobalXBannerPresenter.this.f8110g.page_state));
                hashMap.put("station_switch", Integer.valueOf(HomeGlobalXBannerPresenter.this.f8110g.station_switch));
            }
            return new JSONObject(hashMap);
        }
    };

    /* renamed from: p */
    private XEResponseCallback f8118p = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData.jsonObject != null) {
                HomeGlobalXBannerPresenter.this.f8107d.setXBannerData(xEngineData.jsonObject, true, true, HomeGlobalXBannerPresenter.this.f8112i);
                if (HomeGlobalXBannerPresenter.this.f8108e) {
                    XBannerNativeView e = HomeGlobalXBannerPresenter.this.m5275b();
                    HomeGlobalXBannerPresenter.this.f8107d.reloadXBannerAndNativeCheck(HomeGlobalXBannerPresenter.this.f8112i, xEngineData.jsonObject, e);
                }
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            if (HomeGlobalXBannerPresenter.this.f8112i != null) {
                HomeGlobalXBannerPresenter.this.f8112i.onFail(engineErrorException);
            }
        }
    };

    /* renamed from: q */
    private LatLng f8119q = new LatLng(0.0d, 0.0d);

    /* renamed from: r */
    private double f8120r = ((double) ((Integer) GlobalApolloUtil.getParam("xbanner_request_filter", "distance", 200)).intValue());

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<Integer> f8121s = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (str.equalsIgnoreCase(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED)) {
                int i = 0;
                if (!(HomeGlobalXBannerPresenter.this.mComponentParams == null || HomeGlobalXBannerPresenter.this.mComponentParams.bizCtx == null || HomeGlobalXBannerPresenter.this.mComponentParams.bizCtx.getBizBarHeight() <= 0)) {
                    i = HomeGlobalXBannerPresenter.this.mComponentParams.bizCtx.getBizBarHeight();
                }
                ((IGlobalXBannerView) HomeGlobalXBannerPresenter.this.mView).setTranslationY((-num.intValue()) - (i > 0 ? i - ResourcesHelper.getDimensionPixelSize(HomeGlobalXBannerPresenter.this.mContext, R.dimen.global_x_banner_normal_translate_offset) : -ResourcesHelper.getDimensionPixelSize(HomeGlobalXBannerPresenter.this.mContext, R.dimen.global_x_banner_no_bottom_banner_offset)));
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: b */
    public XBannerNativeView m5275b() {
        return null;
    }

    /* renamed from: d */
    private int m5280d() {
        return 1;
    }

    public HomeGlobalXBannerPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f8113j = componentParams.getActivity();
        this.f8114k = componentParams.bizCtx;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m5265a(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.hashCode()
            r1 = 0
            r2 = -1
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            switch(r0) {
                case -1277259252: goto L_0x004b;
                case -739238274: goto L_0x0041;
                case 19817269: goto L_0x0037;
                case 440214241: goto L_0x002d;
                case 1166410875: goto L_0x0023;
                case 1293241812: goto L_0x0019;
                case 1693861782: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0055
        L_0x000f:
            java.lang.String r0 = "home_not_open"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 1
            goto L_0x0056
        L_0x0019:
            java.lang.String r0 = "home_station"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 4
            goto L_0x0056
        L_0x0023:
            java.lang.String r0 = "home_keep_page_state"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 5
            goto L_0x0056
        L_0x002d:
            java.lang.String r0 = "home_default"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 6
            goto L_0x0056
        L_0x0037:
            java.lang.String r0 = "home_warm_up"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 2
            goto L_0x0056
        L_0x0041:
            java.lang.String r0 = "home_banned"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 0
            goto L_0x0056
        L_0x004b:
            java.lang.String r0 = "home_pause_service"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x0055
            r9 = 3
            goto L_0x0056
        L_0x0055:
            r9 = -1
        L_0x0056:
            if (r9 == 0) goto L_0x0068
            if (r9 == r7) goto L_0x0067
            if (r9 == r6) goto L_0x0066
            if (r9 == r5) goto L_0x0065
            if (r9 == r4) goto L_0x0064
            if (r9 == r3) goto L_0x0063
            return r1
        L_0x0063:
            return r2
        L_0x0064:
            return r3
        L_0x0065:
            return r4
        L_0x0066:
            return r5
        L_0x0067:
            return r6
        L_0x0068:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.android.comp_xbanner.HomeGlobalXBannerPresenter.m5265a(java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m5268a(this.f8113j);
        GLog.m7965d(TAG, "Xbanner onAdd");
        if (GlobalApolloUtil.isHomeEngine()) {
            if (this.f8107d != null) {
                m5272a((DIDILocation) null, this.f8113j);
            }
            XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_XBANNER, XERequestKey.SCENE_HOME, this.f8118p);
            xERegisterModel.requestParams = this.f8117n;
            XERegister.registerTemplate(xERegisterModel);
        }
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, this.f8104a);
        subscribe(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, this.f8106c);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f8121s);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_DELETCT_ITEM, this.f8105b);
    }

    /* renamed from: a */
    private void m5268a(Activity activity) {
        this.f8107d = new XBanner(activity, ((IGlobalXBannerView) this.mView).getXBannerView());
        LocationPerformer.getInstance().addLocationListener(this);
        this.f8115l = XBannerUtil.getItemHeight(activity) - activity.getResources().getDimensionPixelOffset(R.dimen.global_x_banner_default_bottom_dimen);
        this.f8112i = new XBannerCallback() {
            public void onSuccess(JsonObject jsonObject) {
                if (GlobalApolloUtil.isHomeEngine()) {
                    boolean unused = HomeGlobalXBannerPresenter.this.f8108e = true;
                }
                if (HomeGlobalXBannerPresenter.this.f8116m != HomeGlobalXBannerPresenter.this.f8115l) {
                    HomeGlobalXBannerPresenter homeGlobalXBannerPresenter = HomeGlobalXBannerPresenter.this;
                    int unused2 = homeGlobalXBannerPresenter.f8116m = homeGlobalXBannerPresenter.f8115l;
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, Integer.valueOf(HomeGlobalXBannerPresenter.this.f8115l));
                }
            }

            public void onFail(Exception exc) {
                if (HomeGlobalXBannerPresenter.this.f8116m != 0) {
                    int unused = HomeGlobalXBannerPresenter.this.f8116m = 0;
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, 0);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        LocationPerformer.getInstance().removeLocationListener(this);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_RELOAD_WITH_PAGE_STATE, this.f8104a);
        unsubscribe(BaseEventKeys.XBanner.EVENT_HOME_REFACTOR_XBANNER_RELOAD_WITH_PAGE_STATE, this.f8106c);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_HOME_DELETCT_ITEM, this.f8105b);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f8121s);
        if (GlobalApolloUtil.isHomeEngine()) {
            XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_XBANNER);
        }
    }

    /* renamed from: a */
    private void m5272a(DIDILocation dIDILocation, Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("initXBannerR location");
        sb.append(dIDILocation == null ? " null" : " not null");
        GLog.m7965d(TAG, sb.toString());
        m5270a(dIDILocation);
        this.f8107d.initXBanner(activity);
    }

    /* renamed from: a */
    private void m5270a(DIDILocation dIDILocation) {
        this.f8110g = new BizParams();
        if (dIDILocation == null) {
            dIDILocation = LocationController.getInstance().getLastKnownLocation(this.f8113j);
        }
        XBannerNativeView b = m5275b();
        if (b != null) {
            this.f8107d.addNativeView(b);
        }
        if (dIDILocation == null) {
            this.f8110g.select_lat = 0.0f;
            this.f8110g.select_lng = 0.0f;
            this.f8110g.user_loc_accuracy = 0.0f;
            this.f8110g.user_loc_provider = "";
        } else {
            this.f8110g.select_lat = (float) dIDILocation.getLatitude();
            this.f8110g.select_lng = (float) dIDILocation.getLongitude();
            this.f8110g.user_loc_accuracy = dIDILocation.getAccuracy();
            this.f8110g.user_loc_provider = dIDILocation.getProvider();
        }
        this.f8110g.page_state = this.f8111h;
        this.f8110g.station_switch = m5280d();
    }

    /* renamed from: b */
    private void m5277b(DIDILocation dIDILocation, Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("initXBanner location");
        sb.append(dIDILocation == null ? "null" : " not null");
        GLog.m7965d(TAG, sb.toString());
        this.f8110g = new BizParams();
        if (dIDILocation == null) {
            dIDILocation = LocationController.getInstance().getLastKnownLocation(this.f8113j);
        }
        XBannerNativeView b = m5275b();
        if (b != null) {
            this.f8107d.addNativeView(b);
        }
        if (dIDILocation == null) {
            this.f8110g.select_lat = 0.0f;
            this.f8110g.select_lng = 0.0f;
            this.f8110g.user_loc_accuracy = 0.0f;
            this.f8110g.user_loc_provider = "";
        } else {
            this.f8110g.select_lat = (float) dIDILocation.getLatitude();
            this.f8110g.select_lng = (float) dIDILocation.getLongitude();
            this.f8110g.user_loc_accuracy = dIDILocation.getAccuracy();
            this.f8110g.user_loc_provider = dIDILocation.getProvider();
        }
        this.f8110g.page_state = this.f8111h;
        this.f8110g.station_switch = m5280d();
        this.f8107d.initXBanner(activity, "home", this.f8110g, new XBannerCallback() {
            public void onSuccess(JsonObject jsonObject) {
                boolean unused = HomeGlobalXBannerPresenter.this.f8108e = true;
                if (HomeGlobalXBannerPresenter.this.f8112i != null) {
                    HomeGlobalXBannerPresenter.this.f8112i.onSuccess(jsonObject);
                }
            }

            public void onFail(Exception exc) {
                if (HomeGlobalXBannerPresenter.this.f8112i != null) {
                    HomeGlobalXBannerPresenter.this.f8112i.onFail(exc);
                }
            }
        });
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        GLog.m7965d(TAG, "onLocationChanged");
        if (GlobalApolloUtil.isHomeEngine()) {
            if (!this.f8109f) {
                m5272a(dIDILocation, this.f8113j);
                m5279c();
                this.f8109f = true;
                return;
            }
            LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (DDSphericalUtil.computeDistanceBetween(this.f8119q, latLng) > this.f8120r) {
                this.f8119q = latLng;
                GLog.m7965d(TAG, "refreshXBannerR onLocationChanged");
                m5271a(dIDILocation, this.f8111h);
            }
        } else if (!this.f8109f) {
            m5277b(dIDILocation, this.f8113j);
            this.f8109f = true;
        } else {
            LatLng latLng2 = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
            if (DDSphericalUtil.computeDistanceBetween(this.f8119q, latLng2) > this.f8120r) {
                this.f8119q = latLng2;
                GLog.m7965d(TAG, "refreshXBanner onLocationChanged");
                m5267a(this.f8111h);
            }
        }
    }

    /* renamed from: c */
    private void m5279c() {
        XEngineReq.simpleRequest(XERequestKey.SCENE_HOME, XERequestKey.REQUEST_KEY_XBANNER);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5271a(DIDILocation dIDILocation, int i) {
        this.f8111h = i;
        if (this.f8107d != null) {
            if (!this.f8108e) {
                m5272a(dIDILocation, this.f8113j);
            } else {
                m5270a(dIDILocation);
            }
            m5279c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5267a(int i) {
        if (FormStore.getInstance().isOrderBan() || FormStore.getInstance().isSafetyTrain()) {
            this.f8111h = 1;
        } else if (!BusinessUtils.isMisInvalid(this.f8114k)) {
            if (i == 5 || (i == -1 && this.f8111h == 5)) {
                this.f8111h = 5;
            } else {
                this.f8111h = 0;
            }
        } else if (!SecondConfProxy.getInstance().isCityOpen(this.f8114k.getBusinessGroupType())) {
            this.f8111h = 2;
        } else {
            BusinessContext businessContext = this.f8114k;
            if (businessContext == null || !BusinessUtils.isPreHeat(businessContext)) {
                this.f8111h = 4;
            } else {
                this.f8111h = 3;
            }
        }
        if (this.f8107d == null) {
            return;
        }
        if (!this.f8108e) {
            m5277b((DIDILocation) null, this.f8113j);
            return;
        }
        XBannerNativeView b = m5275b();
        this.f8110g.page_state = this.f8111h;
        this.f8107d.reloadXBannerAndNativeCheck(this.f8112i, "home", this.f8110g, b);
    }
}
