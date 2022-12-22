package com.didi.hawaii.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.didi.hawaii.basic.ApolloHawaii;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import didihttp.StatisticalCallback;
import didihttp.StatisticalContext;
import didinet.NetEngine;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class AsyncNetUtils {
    private static final int INIT_ERROR = 0;
    private static final int NETWORK_ERROR = 1;
    public static final String SCHEME = "http";
    /* access modifiers changed from: private */
    public static int currentIndex = 0;
    private static boolean isInited = false;
    private static final int maxDataIndex = 5;
    public static final SparseArray<String> netRequestMap = new SparseArray<>();
    /* access modifiers changed from: private */
    public static final HashMap<String, RequestForOmega> requestCountMap = new HashMap<>();
    private static RpcServiceFactory sFactory = null;

    public interface Callback {
        void onFailed(int i, Exception exc);

        void onSuccess(byte[] bArr);
    }

    static /* synthetic */ int access$012(int i) {
        int i2 = currentIndex + i;
        currentIndex = i2;
        return i2;
    }

    static {
        NetEngine.getInstance().addStatisticalCallback(new StatisticalCallback() {
            public void onStatisticalDataCallback(StatisticalContext statisticalContext) {
                String hostAndPath = statisticalContext.getRequest().url().hostAndPath();
                if (hostAndPath.contains("map") && !hostAndPath.contains("reportstatus")) {
                    int retryCount = statisticalContext.getRetryCount();
                    String str = "url:" + statisticalContext.getRequest().url().toString() + ",retryCount:" + retryCount + ",costTime:" + statisticalContext.getTotalTimeCost() + ",waitTime:" + statisticalContext.getWaitTimeCost() + ",transTime:" + statisticalContext.getTransAckCost();
                    if (AsyncNetUtils.currentIndex >= 5) {
                        int unused = AsyncNetUtils.currentIndex = 0;
                    }
                    AsyncNetUtils.netRequestMap.put(AsyncNetUtils.currentIndex, str);
                    AsyncNetUtils.access$012(1);
                    if (ApolloHawaii.getReportRequestLimitEnable()) {
                        if (hostAndPath.contains("trafficrenderapi") && hostAndPath.contains("render")) {
                            hostAndPath = statisticalContext.getRequest().url().queryParameter("tiles");
                        } else if (hostAndPath.contains("mapserver/map_3d")) {
                            hostAndPath = statisticalContext.getRequest().url().toString();
                        }
                        if (TextUtils.isEmpty(hostAndPath)) {
                            return;
                        }
                        if (AsyncNetUtils.requestCountMap.containsKey(hostAndPath)) {
                            RequestForOmega requestForOmega = (RequestForOmega) AsyncNetUtils.requestCountMap.get(hostAndPath);
                            if (System.currentTimeMillis() - requestForOmega.firstRequestTime > ((long) (ApolloHawaii.getReportRequestTime() * 1000))) {
                                AsyncNetUtils.requestCountMap.remove(hostAndPath);
                            } else if (requestForOmega.count >= ApolloHawaii.getReportRequestLimitCount()) {
                                OmegaUtils.reportRequestLimit(statisticalContext.getRequest().url().toString());
                                AsyncNetUtils.requestCountMap.remove(hostAndPath);
                            } else {
                                requestForOmega.count++;
                            }
                        } else {
                            RequestForOmega requestForOmega2 = new RequestForOmega();
                            requestForOmega2.firstRequestTime = System.currentTimeMillis();
                            requestForOmega2.count = 1;
                            AsyncNetUtils.requestCountMap.put(hostAndPath, requestForOmega2);
                        }
                    }
                }
            }
        });
    }

    private static class RequestForOmega {
        public int count;
        public long firstRequestTime;

        private RequestForOmega() {
        }
    }

    private AsyncNetUtils() {
    }

    private static boolean isInited() {
        return isInited && sFactory != null;
    }

    public static void init(Context context) {
        if (!isInited()) {
            sFactory = new RpcServiceFactory(context.getApplicationContext());
            isInited = true;
        }
    }

    public static void doPost(String str, byte[] bArr, Callback callback) {
        doAsyncHttpTask(str, bArr, callback, (Map<String, String>) null, 0);
    }

    public static void doPost(String str, byte[] bArr, Callback callback, Map<String, String> map) {
        doAsyncHttpTask(str, bArr, callback, map, 0);
    }

    public static Object doGet(String str, Callback callback) {
        return doAsyncHttpTask(str, (byte[]) null, callback, (Map<String, String>) null, 0);
    }

    public static Object doGet(String str, Callback callback, int i) {
        return doAsyncHttpTask(str, (byte[]) null, callback, (Map<String, String>) null, i);
    }

    private static Object doAsyncHttpTask(String str, byte[] bArr, final Callback callback, Map<String, String> map, int i) {
        try {
            if (!isInited()) {
                callback.onFailed(0, new IllegalStateException("Netutils has to be inited"));
                return null;
            }
            HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
            if (bArr != null) {
                builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
            } else {
                builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
            }
            if (map != null) {
                for (String next : map.keySet()) {
                    builder.addHeader(next, map.get(next));
                }
            }
            HttpRpcClient.Builder newBuilder = ((HttpRpcClient) sFactory.getRpcClient("http")).newBuilder();
            newBuilder.addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new HawaiiUrlRpcInterceptor());
            newBuilder.addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new HawaiiNetRpcInterceptor());
            if (i > 0) {
                newBuilder.setConnectTimeout((long) i);
            }
            return CertificateEncryptionUtils.addSslSocketFactoryForBuilder(newBuilder).build().newRpc(builder.build()).enqueue(new HttpRpc.Callback() {
                public void onSuccess(HttpRpcResponse httpRpcResponse) {
                    try {
                        byte[] deserialize = new ByteArrayDeserializer().deserialize(httpRpcResponse.getEntity().getContent());
                        if (Callback.this != null) {
                            Callback.this.onSuccess(deserialize);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                    Callback callback = Callback.this;
                    if (callback != null) {
                        callback.onFailed(1, iOException);
                    }
                }
            });
        } catch (Exception e) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_msg", e.getMessage());
            OmegaSDKAdapter.trackEvent("tech_map_global_didimap_load_status", (Map<String, Object>) hashMap);
            return null;
        }
    }

    public static void cancel(Object obj) {
        sFactory.getRpcClient("http").cancel(obj);
    }
}
