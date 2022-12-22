package com.didi.map.global.rpc.service;

import android.content.Context;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;

public class SimpleHttpService extends MapHttpService {

    /* renamed from: a */
    private HttpRpcClient f27355a = ((HttpRpcClient) this.mFactory.getRpcClient("http"));

    public SimpleHttpService(Context context) {
        super(context);
    }

    public byte[] doPost(String str, byte[] bArr) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) this.f27355a.newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public byte[] doGet(String str) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) this.f27355a.newRpc(builder.build()).execute()).getEntity().getContent());
    }
}
