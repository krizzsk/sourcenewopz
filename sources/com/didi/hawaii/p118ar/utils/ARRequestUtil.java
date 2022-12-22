package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCData;
import com.didi.hawaii.p118ar.jni.DARCHTTPMethod;
import com.didi.hawaii.p118ar.jni.DARCHTTPRequest;
import com.didi.hawaii.p118ar.jni.DARCHTTPResponse;
import com.didi.hawaii.p118ar.jni.DARCObject;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.http.SimpleHttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpc;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.hawaii.ar.utils.ARRequestUtil */
public class ARRequestUtil {
    private static final String ARURL_ONLINE = "https://ar-map-g.didiglobal.com";
    private static final String ARURL_TEST = "https://ar-map-g.didiglobal.com";
    private static final String CONTENT_TYPE_NAME = "Content-Type";
    private static HttpRpcClient client = null;
    private static boolean isInited = false;
    private static boolean isUseTestUrl = ARAPollo.isUseDEV();
    private static RpcServiceFactory sFactory;

    /* renamed from: com.didi.hawaii.ar.utils.ARRequestUtil$Callback */
    public interface Callback {
        void onFailed(int i, Exception exc);

        void onSuccess(byte[] bArr);
    }

    public static HttpRpcRequest convertDARCHTTPRequest2ARRequest(DARCHTTPRequest dARCHTTPRequest) {
        HashMap hashMap = new HashMap();
        AREngineJNI.GetDARCHTTPRequestHeaders_Wrap(dARCHTTPRequest, hashMap);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(new SimpleHttpHeader((String) entry.getKey(), (String) entry.getValue()));
        }
        boolean z = isUseTestUrl;
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        DARCData body = dARCHTTPRequest.getBody();
        DARCObject.gretain(body);
        builder.setUrl("https://ar-map-g.didiglobal.com" + dARCHTTPRequest.getURL()).setMethod(dARCHTTPRequest.getMethod() == DARCHTTPMethod.DARCHTTPMethod_Get ? HttpMethod.GET : HttpMethod.POST, HttpBody.newInstance(MimeType.parse((String) hashMap.get("Content-Type")), AREngineJNI.DARCDATA_getDataWrap(body))).addHeaders((Iterable) arrayList);
        return builder.build();
    }

    public static DARCHTTPResponse convertData2DARCHttpResponse(byte[] bArr, DARCHTTPRequest dARCHTTPRequest) {
        DARCHTTPResponse alloc = DARCHTTPResponse.alloc();
        if (bArr == null || bArr.length < 0) {
            alloc.setStatus(-1);
        } else {
            DARCData alloc2 = DARCData.alloc();
            alloc2.setData(bArr, (long) bArr.length);
            alloc.setBody(alloc2);
            alloc.setStatus(0);
        }
        alloc.setOriginalRequest(dARCHTTPRequest);
        return alloc;
    }

    public static void doAsyncHttpTask(HttpRpcRequest httpRpcRequest, final Callback callback) {
        HttpRpc newRpc = client.newRpc(httpRpcRequest);
        if (newRpc != null) {
            newRpc.enqueue(new HttpRpc.Callback() {
                public void onSuccess(HttpRpcResponse httpRpcResponse) {
                    try {
                        byte[] deserialize = new ByteArrayDeserializer().deserialize(httpRpcResponse.getEntity().getContent());
                        if (callback != null) {
                            callback.onSuccess(deserialize);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailed(-1, iOException);
                    }
                }
            });
        }
    }

    private static boolean isInited() {
        return (!isInited || sFactory == null || client == null) ? false : true;
    }

    public static void init(Context context) {
        synchronized (ARRequestUtil.class) {
            if (!isInited()) {
                RpcServiceFactory rpcServiceFactory = new RpcServiceFactory(context.getApplicationContext());
                sFactory = rpcServiceFactory;
                rpcServiceFactory.getRpcClient("http");
                HttpRpcClient httpRpcClient = (HttpRpcClient) sFactory.getRpcClient("http");
                client = httpRpcClient;
                client = CertificateEncryptionUtils.addSslSocketFactoryForBuilder(httpRpcClient.newBuilder()).build();
                isInited = true;
            }
        }
    }

    public static void setIsTestIP(boolean z) {
        isUseTestUrl = z;
    }

    public static void doAsyncHttpTask(String str, byte[] bArr, final Callback callback) {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        if (bArr != null) {
            builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        } else {
            builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        }
        CertificateEncryptionUtils.addSslSocketFactoryForBuilder(((HttpRpcClient) sFactory.getRpcClient("http")).newBuilder()).build().newRpc(builder.build()).enqueue(new HttpRpc.Callback() {
            public void onSuccess(HttpRpcResponse httpRpcResponse) {
                try {
                    byte[] deserialize = new ByteArrayDeserializer().deserialize(httpRpcResponse.getEntity().getContent());
                    if (callback != null) {
                        callback.onSuccess(deserialize);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(HttpRpcRequest httpRpcRequest, IOException iOException) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailed(-1, iOException);
                }
            }
        });
    }
}
