package com.didi.dimina.container.secondparty.jsmodule.jsbridge.location;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.InternalJSMethod;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.mina.IDMCommonAction;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.location.LocationSubJSBridge;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.sdk.push.ServerParam;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class LocationSubJSBridge {
    public static final String TAG_LOCATION = "Location";

    /* renamed from: d */
    private static final int f17196d = -1000;

    /* renamed from: e */
    private static final int f17197e = -1001;

    /* renamed from: f */
    private static final int f17198f = -1002;

    /* renamed from: g */
    private static final int f17199g = -1003;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final LocationHelper f17200a;

    /* renamed from: b */
    private final AtomicBoolean f17201b = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Map<String, IDMCommonAction<DIDILocation>> f17202c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public volatile Long f17203h = 0L;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final AtomicBoolean f17204i = new AtomicBoolean(false);

    /* renamed from: j */
    private final Long f17205j = 10000L;

    /* renamed from: k */
    private final List<CallbackFunction> f17206k = new CopyOnWriteArrayList();

    /* renamed from: l */
    private final Context f17207l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public JSONObject f17208m = new JSONObject();

    /* renamed from: n */
    private final DMMina f17209n;

    public LocationSubJSBridge(DMMina dMMina, Context context) {
        this.f17207l = context;
        this.f17209n = dMMina;
        this.f17200a = new LocationHelper(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12767a(IDMCommonAction<CallbackFunction> iDMCommonAction) {
        List<CallbackFunction> list = this.f17206k;
        if (list != null) {
            try {
                for (CallbackFunction next : list) {
                    if (next != null) {
                        iDMCommonAction.callback(next);
                    }
                }
            } catch (Exception unused) {
            }
            this.f17206k.clear();
            LogUtil.iRelease("Location", "开始清空队列");
        }
        this.f17204i.set(false);
    }

    public void getLocation(final JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease("Location", "getLocation 开始");
        if (System.currentTimeMillis() - this.f17203h.longValue() > this.f17205j.longValue() || this.f17208m.optString("data").isEmpty()) {
            this.f17206k.add(callbackFunction);
            if (this.f17204i.get()) {
                LogUtil.iRelease("Location", "正在权限执行流程中，进入队列等待处理");
                return;
            }
            this.f17204i.set(true);
            this.f17203h = Long.valueOf(System.currentTimeMillis());
            PermissionUtil.INSTANCE.checkAndRequestPermissionsPersonalized(this.f17207l, Permission.ACCESS_FINE_LOCATION, DiminaPermissionDescDialog.createLocationDescInfo(this.f17209n), true, new SinglePermissionCallBack() {
                public void onDenied(String str) {
                    LocationSubJSBridge.this.m12767a((IDMCommonAction<CallbackFunction>) new IDMCommonAction() {
                        public final void callback(Object obj) {
                            LocationSubJSBridge.C75571.this.lambda$onDenied$0$LocationSubJSBridge$1((CallbackFunction) obj);
                        }
                    });
                }

                public /* synthetic */ void lambda$onDenied$0$LocationSubJSBridge$1(CallbackFunction callbackFunction) {
                    LogUtil.iRelease("Location", "已拒绝时权限校验耗时:" + (System.currentTimeMillis() - LocationSubJSBridge.this.f17203h.longValue()));
                    CallBackUtil.onFail("getLocation:fail auth denied", callbackFunction);
                    LogUtil.iRelease("Location", "onDenied");
                }

                public void onGranted(String str) {
                    LogUtil.iRelease("Location", "已授权时权限校验耗时:" + (System.currentTimeMillis() - LocationSubJSBridge.this.f17203h.longValue()));
                    boolean optBoolean = jSONObject.optBoolean("isHighAccuracy");
                    long optLong = jSONObject.optLong("highAccuracyExpireTime", 5000);
                    LogUtil.m13412i("Location", "getLocation called, type=" + "gcj02" + ", isHighAccuracy=" + optBoolean + ",highAccuracyExpireTime=" + optLong);
                    LocationSubJSBridge.this.f17200a.getOnceLocation("gcj02", optLong, new IDMCommonAction() {
                        public final void callback(Object obj) {
                            LocationSubJSBridge.C75571.this.lambda$onGranted$3$LocationSubJSBridge$1((DIDILocation) obj);
                        }
                    });
                    LocationSubJSBridge.this.f17204i.set(false);
                }

                public /* synthetic */ void lambda$onGranted$3$LocationSubJSBridge$1(DIDILocation dIDILocation) {
                    if (dIDILocation == null) {
                        LocationSubJSBridge.this.m12767a((IDMCommonAction<CallbackFunction>) $$Lambda$LocationSubJSBridge$1$7wxXmMQ5pmpprO1PiEc9l3XHJek.INSTANCE);
                        return;
                    }
                    LogUtil.iRelease("Location", "GetLocation实时定位成功");
                    LogUtil.iRelease("Location", dIDILocation.toString());
                    LocationSubJSBridge.this.m12767a((IDMCommonAction<CallbackFunction>) new IDMCommonAction(dIDILocation) {
                        public final /* synthetic */ DIDILocation f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void callback(Object obj) {
                            LocationSubJSBridge.C75571.this.lambda$null$2$LocationSubJSBridge$1(this.f$1, (CallbackFunction) obj);
                        }
                    });
                }

                static /* synthetic */ void lambda$null$1(CallbackFunction callbackFunction) {
                    LogUtil.iRelease("Location", "GetLocation实时定位失败");
                    CallBackUtil.onFail("once location request timeout...", callbackFunction);
                }

                public /* synthetic */ void lambda$null$2$LocationSubJSBridge$1(DIDILocation dIDILocation, CallbackFunction callbackFunction) {
                    LocationSubJSBridge locationSubJSBridge = LocationSubJSBridge.this;
                    JSONObject unused = locationSubJSBridge.f17208m = locationSubJSBridge.m12764a(callbackFunction, dIDILocation);
                }
            });
        } else if (callbackFunction != null) {
            callbackFunction.onCallBack(this.f17208m);
            LogUtil.iRelease("Location", "GetLocation命中Bridge缓存");
        }
    }

    public void startLocationUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!this.f17201b.compareAndSet(false, true)) {
            callbackFunction.onCallBack(m12763a(-1002, "实时定位已经开启了"));
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("isHighAccuracy", false);
        long optLong = jSONObject.optLong("minTime", 2000);
        long optLong2 = jSONObject.optLong("minDistance", 0);
        boolean startLocationUpdate = this.f17200a.startLocationUpdate("gcj02", optBoolean, optLong, (float) optLong2, new IDMCommonAction<DIDILocation>() {
            public void callback(DIDILocation dIDILocation) {
                for (Map.Entry value : LocationSubJSBridge.this.f17202c.entrySet()) {
                    ((IDMCommonAction) value.getValue()).callback(dIDILocation);
                }
            }
        });
        if (!startLocationUpdate) {
            callbackFunction.onCallBack(m12763a(-1000, "实时定位开启失败"));
        } else {
            CallBackUtil.onSuccess(callbackFunction);
        }
        LogUtil.m13412i("Location", "startLocationUpdate, started：" + startLocationUpdate);
    }

    public void onLocationChange(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        if (!this.f17201b.get()) {
            callbackFunction.onCallBack(m12763a(-1001, "请先开启实时定位"));
            return;
        }
        String optString = jSONObject.optString("requestId");
        if (TextUtils.isEmpty(optString)) {
            callbackFunction.onCallBack(m12763a(-1003, "requestId不能为空"));
            return;
        }
        if (!this.f17202c.containsKey(optString)) {
            this.f17202c.put(optString, new IDMCommonAction<DIDILocation>() {
                public void callback(DIDILocation dIDILocation) {
                    JSONObject unused = LocationSubJSBridge.this.m12764a(callbackFunction, dIDILocation);
                }
            });
        }
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void offLocationChange(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("requestId");
        if (TextUtils.isEmpty(optString)) {
            callbackFunction.onCallBack(m12763a(-1003, "requestId不能为空"));
            return;
        }
        this.f17202c.remove(optString);
        CallBackUtil.onSuccess(callbackFunction);
    }

    public void stopLocationUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13412i("Location", InternalJSMethod.STOP_LOCATION_UPDATE);
        this.f17200a.stopLocationUpdate();
        this.f17201b.set(false);
        CallBackUtil.onSuccess(callbackFunction);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m12764a(CallbackFunction callbackFunction, DIDILocation dIDILocation) {
        JSONObject jSONObject = new JSONObject();
        if (dIDILocation != null) {
            JSONUtil.put(jSONObject, Const.PageParams.LATITUDE, dIDILocation.getLatitude());
            JSONUtil.put(jSONObject, Const.PageParams.LONGITUDE, dIDILocation.getLongitude());
            JSONUtil.put(jSONObject, "altitude", dIDILocation.getAltitude());
            JSONUtil.put(jSONObject, ServerParam.PARAM_ACCURACY, (double) dIDILocation.getAccuracy());
            JSONUtil.put(jSONObject, "provider", (Object) dIDILocation.getProvider());
            JSONUtil.put(jSONObject, "timestamp", dIDILocation.getTime());
            JSONUtil.put(jSONObject, "speed", (double) dIDILocation.getSpeed());
            if (Build.VERSION.SDK_INT >= 26) {
                JSONUtil.put(jSONObject, FusedLocationProviderClient.KEY_VERTICAL_ACCURACY, (double) dIDILocation.getAccuracy());
                JSONUtil.put(jSONObject, "horizontalAccuracy", 0);
            }
        } else {
            JSONUtil.put(jSONObject, "success", false);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "success", true);
        JSONUtil.put(jSONObject2, "data", (Object) jSONObject);
        callbackFunction.onCallBack(jSONObject2);
        return jSONObject2;
    }

    /* renamed from: a */
    private static JSONObject m12763a(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "success", false);
        JSONUtil.put(jSONObject, "code", i);
        JSONUtil.put(jSONObject, DMWebSocketListener.KEY_ERR_MSG, (Object) str);
        return jSONObject;
    }
}
