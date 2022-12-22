package com.didi.hawaii.net;

import android.content.Context;
import com.didi.hawaii.utils.CertificateEncryptionUtils;
import com.didi.hawaii.utils.HawaiiNetRpcInterceptor;
import com.didi.hawaii.utils.HawaiiUrlRpcInterceptor;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.util.Map;

public final class SyncTripCommonNetUtils {
    private static boolean isInited = false;
    private static HttpRpcClient sClient;

    private SyncTripCommonNetUtils() {
    }

    public static boolean isIsInited() {
        return isInited && sClient != null;
    }

    public static void init(Context context) {
        sClient = (HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http");
        isInited = true;
    }

    public static byte[] doPost(String str, byte[] bArr, Map<String, String> map) throws Exception {
        return doSyncHttpTask(str, bArr, map);
    }

    public static byte[] doPost(String str, byte[] bArr) throws Exception {
        return doSyncHttpTask(str, bArr, (Map<String, String>) null);
    }

    public static byte[] doGet(String str) throws Exception {
        return doSyncHttpTask(str, (byte[]) null, (Map<String, String>) null);
    }

    private static byte[] doSyncHttpTask(String str, byte[] bArr, Map<String, String> map) throws Exception {
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
        HttpRpcClient.Builder newBuilder = sClient.newBuilder();
        newBuilder.addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new HawaiiUrlRpcInterceptor());
        newBuilder.addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new HawaiiNetRpcInterceptor());
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(newBuilder).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }
}
