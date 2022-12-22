package com.didi.map.global.component.slideCars.api;

import android.content.Context;
import android.os.Build;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.model.omega.AlarmOmegaUtil;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class RequestManager {

    /* renamed from: a */
    private static RequestManager f26165a;

    /* renamed from: b */
    private Context f26166b;

    /* renamed from: c */
    private CarRpcService f26167c;

    /* renamed from: d */
    private String f26168d = "https://common.didiglobal.com/";

    /* renamed from: e */
    private final String f26169e = "*&didi@";

    private RequestManager(Context context) {
        this.f26166b = context;
        this.f26167c = (CarRpcService) new RpcServiceFactory(context).newRpcService(CarRpcService.class, this.f26168d);
    }

    public static RequestManager getInstance(Context context) {
        if (f26165a == null) {
            synchronized (RequestManager.class) {
                if (f26165a == null) {
                    f26165a = new RequestManager(context.getApplicationContext());
                }
            }
        }
        return f26165a;
    }

    public void getMultiCarNavigators(Map map, final ICarNavigatorCallback iCarNavigatorCallback, ClientConfigParam clientConfigParam) {
        Context context = this.f26166b;
        if (context != null) {
            final HashMap<String, Object> a = m18528a(context, clientConfigParam);
            a.putAll(map);
            CarRpcService carRpcService = this.f26167c;
            if (carRpcService != null) {
                carRpcService.getMultiCarNavigators(a, new RpcService.CallbackV2<NearDriver>() {
                    public void onSuccess(RpcResponseProxy<NearDriver> rpcResponseProxy) {
                        if (rpcResponseProxy != null) {
                            List<HttpHeader> headers = rpcResponseProxy.getHeaders();
                            NearDriver content = rpcResponseProxy.getContent();
                            ICarNavigatorCallback iCarNavigatorCallback = iCarNavigatorCallback;
                            if (iCarNavigatorCallback != null) {
                                if (content != null) {
                                    iCarNavigatorCallback.onSuccess(content.data);
                                } else {
                                    iCarNavigatorCallback.onSuccess((NearCarDriver) null);
                                }
                            }
                            RequestManager requestManager = RequestManager.this;
                            requestManager.m18530a(a, content, requestManager.getTraceId(headers));
                            return;
                        }
                        ICarNavigatorCallback iCarNavigatorCallback2 = iCarNavigatorCallback;
                        if (iCarNavigatorCallback2 != null) {
                            iCarNavigatorCallback2.onSuccess((NearCarDriver) null);
                        }
                    }

                    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                        ICarNavigatorCallback iCarNavigatorCallback = iCarNavigatorCallback;
                        if (iCarNavigatorCallback != null && iOException != null) {
                            iCarNavigatorCallback.onFails(iOException.getMessage());
                        }
                    }
                });
            }
        }
    }

    public String getTraceId(List<HttpHeader> list) {
        if (!(list == null || list.size() == 0)) {
            ListIterator<HttpHeader> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                HttpHeader previous = listIterator.previous();
                if (previous.getName() != null && previous.getName().equalsIgnoreCase("didi-header-rid")) {
                    return previous.getValue();
                }
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18530a(HashMap hashMap, NearDriver nearDriver, String str) {
        String str2;
        String str3;
        HashMap hashMap2 = hashMap;
        NearDriver nearDriver2 = nearDriver;
        LatLng latLng = null;
        try {
            if (hashMap2.containsKey("lat") && hashMap2.containsKey("lng")) {
                latLng = new LatLng(Double.valueOf((String) hashMap2.get("lat")).doubleValue(), Double.valueOf((String) hashMap2.get("lng")).doubleValue());
            }
            LatLng latLng2 = latLng;
            if (hashMap2.containsKey("product_id")) {
                str2 = (String) hashMap2.get("product_id");
            } else {
                str2 = "";
            }
            int intValue = hashMap2.containsKey("radius") ? Integer.valueOf((String) hashMap2.get("radius")).intValue() : 0;
            if (hashMap2.containsKey("phone_num")) {
                str3 = (String) hashMap2.get("phone_num");
            } else {
                str3 = "";
            }
            if (nearDriver2 != null || nearDriver2.data != null) {
                AlarmOmegaUtil.multiCarNavigatorAlarmOmega(latLng2, str2, intValue, str3, nearDriver2.errno, nearDriver2.data.eta, str);
            }
        } catch (Exception unused) {
            DLog.m7384d("checkMultiCarDate", "异常埋点发生异常", new Object[0]);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m18532b(java.util.HashMap r12, com.didi.map.global.component.slideCars.api.NearDriver r13, java.lang.String r14) {
        /*
            r11 = this;
            java.lang.String r0 = "phone_num"
            java.lang.String r1 = "diverIds"
            java.lang.String r2 = "product_id"
            boolean r3 = r12.containsKey(r2)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0018
            java.lang.Object r2 = r12.get(r2)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0047 }
            r5 = r2
            goto L_0x0019
        L_0x0018:
            r5 = r4
        L_0x0019:
            boolean r2 = r12.containsKey(r1)     // Catch:{ Exception -> 0x0047 }
            if (r2 == 0) goto L_0x0027
            java.lang.Object r1 = r12.get(r1)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0047 }
            r6 = r1
            goto L_0x0028
        L_0x0027:
            r6 = r4
        L_0x0028:
            boolean r1 = r12.containsKey(r0)     // Catch:{ Exception -> 0x0047 }
            if (r1 == 0) goto L_0x0035
            java.lang.Object r12 = r12.get(r0)     // Catch:{ Exception -> 0x0047 }
            r4 = r12
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0047 }
        L_0x0035:
            r7 = r4
            if (r13 == 0) goto L_0x0052
            com.didi.map.global.component.slideCars.api.NearCarDriver r12 = r13.data     // Catch:{ Exception -> 0x0047 }
            if (r12 == 0) goto L_0x0052
            int r8 = r13.errno     // Catch:{ Exception -> 0x0047 }
            com.didi.map.global.component.slideCars.api.NearCarDriver r12 = r13.data     // Catch:{ Exception -> 0x0047 }
            int r9 = r12.eta     // Catch:{ Exception -> 0x0047 }
            r10 = r14
            com.didi.map.global.model.omega.AlarmOmegaUtil.singleCarNavigatorAlarmOmega(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0047 }
            goto L_0x0052
        L_0x0047:
            r12 = 0
            java.lang.Object[] r12 = new java.lang.Object[r12]
            java.lang.String r13 = "checkSingleCarDate"
            java.lang.String r14 = "异常埋点发生异常"
            com.didi.common.map.util.DLog.m7384d(r13, r14, r12)
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.slideCars.api.RequestManager.m18532b(java.util.HashMap, com.didi.map.global.component.slideCars.api.NearDriver, java.lang.String):void");
    }

    public void getSingleCarNavigator(Map map, final ICarNavigatorCallback iCarNavigatorCallback, ClientConfigParam clientConfigParam) {
        Context context = this.f26166b;
        if (context != null) {
            final HashMap<String, Object> a = m18528a(context, clientConfigParam);
            a.putAll(map);
            CarRpcService carRpcService = this.f26167c;
            if (carRpcService != null) {
                carRpcService.getSingleCarNavigator(a, new RpcService.CallbackV2<NearDriver>() {
                    public void onSuccess(RpcResponseProxy<NearDriver> rpcResponseProxy) {
                        if (rpcResponseProxy != null) {
                            List<HttpHeader> headers = rpcResponseProxy.getHeaders();
                            NearDriver content = rpcResponseProxy.getContent();
                            ICarNavigatorCallback iCarNavigatorCallback = iCarNavigatorCallback;
                            if (iCarNavigatorCallback != null) {
                                if (content != null) {
                                    iCarNavigatorCallback.onSuccess(content.data);
                                } else {
                                    iCarNavigatorCallback.onSuccess((NearCarDriver) null);
                                }
                            }
                            RequestManager requestManager = RequestManager.this;
                            requestManager.m18532b(a, content, requestManager.getTraceId(headers));
                            return;
                        }
                        ICarNavigatorCallback iCarNavigatorCallback2 = iCarNavigatorCallback;
                        if (iCarNavigatorCallback2 != null) {
                            iCarNavigatorCallback2.onSuccess((NearCarDriver) null);
                        }
                    }

                    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                        ICarNavigatorCallback iCarNavigatorCallback = iCarNavigatorCallback;
                        if (iCarNavigatorCallback != null && iOException != null) {
                            iCarNavigatorCallback.onFails(iOException.getMessage());
                        }
                    }
                });
            }
        }
    }

    /* renamed from: a */
    private HashMap<String, Object> m18528a(Context context, ClientConfigParam clientConfigParam) {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
            if (lastKnownLocation != null) {
                hashMap.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
                hashMap.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
                hashMap.put("userlat", Double.valueOf(lastKnownLocation.getLatitude()));
                hashMap.put("userlng", Double.valueOf(lastKnownLocation.getLongitude()));
            }
            if (clientConfigParam != null) {
                hashMap.put("token", PaxEnvironment.getInstance().getToken());
                hashMap.put("cityIid", Integer.valueOf(PaxEnvironment.getInstance().getCityId()));
                hashMap.put("origin_id", clientConfigParam.getOriginId());
                hashMap.put("map_type", clientConfigParam.getMapType());
                hashMap.put("maptype", clientConfigParam.getMapType());
                hashMap.put("lang", clientConfigParam.getLocale());
                hashMap.put("idfa", clientConfigParam.getIdfa());
                hashMap.put("mix_flag", Integer.valueOf(clientConfigParam.getMixFlag()));
                hashMap.put(ServerParamConstant.KEY_A3_TOKEN, clientConfigParam.getA3Token());
            }
            hashMap.put("client_type", 1);
            hashMap.put("channel", SystemUtil.getChannelId());
            hashMap.put("imei", SystemUtil.getIMEI());
            hashMap.put("suuid", SecurityUtil.getSUUID());
            hashMap.put("model", SystemUtil.getModel());
            hashMap.put("os", Build.VERSION.RELEASE);
            hashMap.put("brand", Build.BRAND);
            hashMap.put("wifi_mac", "");
            hashMap.put("pixels", getScreenPixels());
            hashMap.put("app_version", SystemUtil.getVersionName());
            hashMap.put("android_id", SecurityUtil.getAndroidID());
            hashMap.put("networkType", SystemUtil.getNetworkType());
            hashMap.put("vcode", Integer.valueOf(SystemUtil.getVersionCode()));
            hashMap.put("dviceid", SecurityUtil.getDeviceId());
            hashMap.put("device_id", SecurityUtil.getDeviceId());
            hashMap.put("appversion", SystemUtil.getVersionName());
            hashMap.put("datatype", 1);
            hashMap.put("data_type", "android");
            StringBuilder sb = new StringBuilder();
            sb.append("test");
            sb.append(MD5.toMD5(SUUIDHelper.getDiDiSUUID() + "*&didi@").toLowerCase());
            hashMap.put("cancel", sb.toString());
            hashMap.put("sig", SecurityUtil.generateSignature(hashMap));
            hashMap.put("uuid", SecurityUtil.getUUID());
            return hashMap;
        } catch (Exception e) {
            DLog.m7384d("createCommonParams", "createCommonParams 出现异常" + e.toString(), new Object[0]);
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public String getScreenPixels() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SystemUtil.getScreenWidth());
        stringBuffer.append("*");
        stringBuffer.append(SystemUtil.getScreenHeight());
        return stringBuffer.toString();
    }
}
