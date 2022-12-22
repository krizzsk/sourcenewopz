package com.didi.map.sdk.navtracker;

import android.content.Context;
import com.didi.map.certificateencryption.CertificateEncryptionUtils;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcServiceFactory;

public class TrackerNetUtils {

    /* renamed from: a */
    private static HttpRpcClient f28558a;

    public static void init(Context context) {
        f28558a = (HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http");
    }

    public static boolean isInitialized() {
        return f28558a != null;
    }

    public static byte[] doPost(String str, byte[] bArr) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(f28558a.newBuilder()).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doGet(String str) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(f28558a.newBuilder()).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doPostEx(String str, byte[] bArr) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) f28558a.newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doGetEx(String str) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) f28558a.newRpc(builder.build()).execute()).getEntity().getContent());
    }
}
