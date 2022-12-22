package com.didichuxing.bigdata.p173dp.locsdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.didi.map.certificateencryption.CertificateEncryptionUtils;
import com.didi.map.nettransformation.UrlRpcInterceptorV2;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.common.net.HttpHeaders;
import java.io.IOException;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.net.NetUtils */
public class NetUtils {

    /* renamed from: a */
    private static HttpRpcClient f45996a = null;

    /* renamed from: b */
    private static int f45997b = 10000;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.net.NetUtils$HttpResponse */
    public static class HttpResponse {
        public String body = null;
        public int httpRespCode = 0;
    }

    public static void init(Context context) {
        f45996a = (HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http");
    }

    public static boolean isInited() {
        return f45996a != null;
    }

    public static String post3(String str, String str2) throws IOException {
        try {
            HttpRpcRequest build = new HttpRpcRequest.Builder().setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.parse("application/x-www-form-urlencoded"), str2.getBytes("UTF-8"))).build();
            HttpRpcClient.Builder newBuilder = f45996a.newBuilder();
            newBuilder.setConnectTimeout((long) f45997b).setReadTimeout((long) f45997b).addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new UrlRpcInterceptorV2());
            HttpRpcResponse httpRpcResponse = (HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(newBuilder).build().newRpc(build).execute();
            if (httpRpcResponse.isSuccessful()) {
                HttpEntity entity = httpRpcResponse.getEntity();
                String deserialize = new StringDeserializer().deserialize(entity.getContent());
                entity.close();
                return deserialize;
            }
            throw new IOException("http request failed, status code is " + httpRpcResponse.getStatus());
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static HttpResponse post4(String str, byte[] bArr) throws IOException {
        try {
            HttpRpcRequest build = new HttpRpcRequest.Builder().setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.parse("application/x-www-form-urlencoded"), bArr)).addHeader(HttpHeaders.CONTENT_ENCODING, "gzip").addHeader("Encode-Version", "1.0").build();
            HttpRpcClient.Builder newBuilder = f45996a.newBuilder();
            newBuilder.setConnectTimeout((long) f45997b).setReadTimeout((long) f45997b).addInterceptor((RpcInterceptor<HttpRpcRequest, HttpRpcResponse>) new UrlRpcInterceptorV2());
            HttpRpcResponse httpRpcResponse = (HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(newBuilder).build().newRpc(build).execute();
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.httpRespCode = httpRpcResponse.getStatus();
            HttpEntity entity = httpRpcResponse.getEntity();
            httpResponse.body = new StringDeserializer().deserialize(entity.getContent());
            entity.close();
            return httpResponse;
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static boolean isNetWorkConnected(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null)) {
                for (NetworkInfo state : allNetworkInfo) {
                    if (state.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
