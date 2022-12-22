package com.didi.travel.psnger.common.net.base;

import android.content.Context;
import android.os.Build;
import androidx.collection.ArrayMap;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.IClientConfig;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.utils.GsonUtil;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.WindowUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.Map;

public abstract class BaseRequest {
    private static final String SIGN_KEY = "*&didi@";

    public static Map<String, Object> createCommonParams(Context context) {
        ArrayMap arrayMap = new ArrayMap(32);
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(context).getLastKnownLocation();
        if (lastKnownLocation != null) {
            arrayMap.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
            arrayMap.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
            arrayMap.put("userlat", Double.valueOf(lastKnownLocation.getLatitude()));
            arrayMap.put("userlng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        if (TEBridge.clientConfig() != null) {
            IClientConfig clientConfig = TEBridge.clientConfig();
            arrayMap.put("origin_id", clientConfig.originId());
            arrayMap.put("map_type", clientConfig.mapType());
            arrayMap.put("maptype", clientConfig.mapType());
            arrayMap.put("token", clientConfig.token());
            arrayMap.put("lang", clientConfig.locale());
            arrayMap.put("idfa", clientConfig.idfa());
            arrayMap.put("cityIid", Integer.valueOf(clientConfig.cityId()));
        }
        arrayMap.put("app_version", SystemUtil.getVersionName());
        arrayMap.put("client_type", 1);
        arrayMap.put("channel", SystemUtil.getChannelId());
        arrayMap.put("mix_flag", Integer.valueOf(MixFlagUtil.getMixFlag(context)));
        arrayMap.put("imei", SystemUtil.getIMEI());
        arrayMap.put("suuid", SecurityUtil.getSUUID());
        arrayMap.put("model", SystemUtil.getModel());
        arrayMap.put("os", Build.VERSION.RELEASE);
        arrayMap.put("brand", Build.BRAND);
        arrayMap.put("wifi_mac", "");
        arrayMap.put("pixels", WindowUtil.getScreenPixels());
        arrayMap.put("android_id", SecurityUtil.getAndroidID());
        arrayMap.put("networkType", SystemUtil.getNetworkType());
        arrayMap.put("vcode", Integer.valueOf(SystemUtil.getVersionCode()));
        arrayMap.put("dviceid", SecurityUtil.getDeviceId());
        arrayMap.put("device_id", SecurityUtil.getDeviceId());
        arrayMap.put("appversion", SystemUtil.getVersionName());
        arrayMap.put("datatype", 1);
        arrayMap.put("data_type", "android");
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(MD5.toMD5(SUUIDHelper.getDiDiSUUID() + SIGN_KEY).toLowerCase());
        arrayMap.put("cancel", sb.toString());
        arrayMap.put("sig", SecurityUtil.generateSignature(arrayMap));
        arrayMap.put("uuid", SecurityUtil.getUUID());
        return arrayMap;
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> createBaseParams(Context context) {
        return createCommonParams(context);
    }

    /* access modifiers changed from: protected */
    public RpcService.Callback<String> getRpcCallback(final ResponseListener responseListener, final BaseObject baseObject) {
        return new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                baseObject.parse(str);
                if (responseListener != null) {
                    if (!baseObject.isAvailable()) {
                        responseListener.onFail(baseObject);
                        responseListener.onFinish(baseObject);
                        return;
                    }
                    responseListener.onSuccess(baseObject);
                    responseListener.onFinish(baseObject);
                }
            }

            public void onFailure(IOException iOException) {
                baseObject.setErrorCode(-1);
                baseObject.setThrowable(iOException);
                ResponseListener responseListener = responseListener;
                if (responseListener != null) {
                    responseListener.onError(baseObject);
                    responseListener.onFinish(baseObject);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public <T> RpcService.Callback<String> getGsonRpcCallback(final ResponseListener<T> responseListener, final Class<T> cls) {
        return new RpcService.Callback<String>() {
            /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|15) */
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
                r2.printStackTrace();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
                r2.onError(r3.newInstance());
                r2.onFinish(r3.newInstance());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
                r2 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0031, code lost:
                r2.printStackTrace();
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0019 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onSuccess(java.lang.String r2) {
                /*
                    r1 = this;
                    com.didi.travel.psnger.utils.LogUtil.m31426d(r2)
                    java.lang.Class r0 = r3     // Catch:{ Exception -> 0x0019 }
                    java.lang.Object r2 = com.didi.travel.psnger.utils.GsonUtil.objectFromJson(r2, r0)     // Catch:{ Exception -> 0x0019 }
                    com.didi.travel.psnger.common.net.base.ResponseListener r0 = r2     // Catch:{ Exception -> 0x0019 }
                    if (r0 != 0) goto L_0x000e
                    return
                L_0x000e:
                    com.didi.travel.psnger.common.net.base.ResponseListener r0 = r2     // Catch:{ Exception -> 0x0019 }
                    r0.onSuccess(r2)     // Catch:{ Exception -> 0x0019 }
                    com.didi.travel.psnger.common.net.base.ResponseListener r0 = r2     // Catch:{ Exception -> 0x0019 }
                    r0.onFinish(r2)     // Catch:{ Exception -> 0x0019 }
                    goto L_0x0039
                L_0x0019:
                    com.didi.travel.psnger.common.net.base.ResponseListener r2 = r2     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    java.lang.Class r0 = r3     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    java.lang.Object r0 = r0.newInstance()     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    r2.onError(r0)     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    com.didi.travel.psnger.common.net.base.ResponseListener r2 = r2     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    java.lang.Class r0 = r3     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    java.lang.Object r0 = r0.newInstance()     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    r2.onFinish(r0)     // Catch:{ InstantiationException -> 0x0035, IllegalAccessException -> 0x0030 }
                    goto L_0x0039
                L_0x0030:
                    r2 = move-exception
                    r2.printStackTrace()
                    goto L_0x0039
                L_0x0035:
                    r2 = move-exception
                    r2.printStackTrace()
                L_0x0039:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.common.net.base.BaseRequest.C143092.onSuccess(java.lang.String):void");
            }

            public void onFailure(IOException iOException) {
                ResponseListener responseListener = responseListener;
                if (responseListener != null) {
                    try {
                        responseListener.onError(cls.newInstance());
                        responseListener.onFinish(cls.newInstance());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public <T> RpcService.Callback<String> getGsonRpcCallback(final GsonResponseListener<T> gsonResponseListener, final Class<T> cls) {
        return new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                LogUtil.m31426d(str);
                try {
                    Object objectFromJson = GsonUtil.objectFromJson(str, cls);
                    if (gsonResponseListener != null) {
                        gsonResponseListener.onSuccess(objectFromJson);
                        gsonResponseListener.onFinish();
                    }
                } catch (Exception unused) {
                    gsonResponseListener.onError(-1);
                }
            }

            public void onFailure(IOException iOException) {
                GsonResponseListener gsonResponseListener = gsonResponseListener;
                if (gsonResponseListener != null) {
                    gsonResponseListener.onError(-1);
                    gsonResponseListener.onFinish();
                }
            }
        };
    }
}
