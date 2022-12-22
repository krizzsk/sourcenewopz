package com.didi.common.map.util;

import android.content.Context;
import android.text.TextUtils;
import com.didi.map.certificateencryption.CertificateEncryptionUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.http.HttpMethod;
import com.didichuxing.foundation.net.rpc.http.HttpRpcClient;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.ByteArrayDeserializer;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import didihttp.Dns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class NetUtils {

    /* renamed from: a */
    private static HttpRpcClient f10952a = null;

    /* renamed from: b */
    private static final String f10953b = "global_net_transform_ssl_toggle";

    public static void init(Context context) {
        f10952a = (HttpRpcClient) new RpcServiceFactory(context).getRpcClient("http");
    }

    public static byte[] doPost(String str, byte[] bArr) throws Exception {
        if (Apollo.getToggle(f10953b).allow()) {
            List<String> ipsWithDNS = DNSUtil.getIpsWithDNS(str);
            if (!CollectionUtil.isEmpty((Collection<?>) ipsWithDNS)) {
                return doPostEx_DNS(str, bArr, ipsWithDNS);
            }
            return doPostEx(str, bArr);
        }
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(f10952a.newBuilder()).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doGet(String str) throws Exception {
        if (Apollo.getToggle(f10953b).allow()) {
            return doGetEx(str);
        }
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) CertificateEncryptionUtils.addSslSocketFactoryForBuilder(f10952a.newBuilder()).build().newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doPostEx(String str, byte[] bArr) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) f10952a.newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doPostEx_DNS(String str, byte[] bArr, final List<String> list) throws Exception {
        SystemUtils.log(6, "NetUtils", "doPostEx_DNS :" + str, (Throwable) null, "com.didi.common.map.util.NetUtils", 93);
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.POST, HttpBody.newInstance(MimeType.APPLICATION_OCTET_STREAM, bArr));
        HttpRpcClient httpRpcClient = f10952a;
        httpRpcClient.setDns(new Dns() {
            public List<InetAddress> lookup(final String str) throws UnknownHostException {
                if (str == null) {
                    return null;
                }
                SystemUtils.log(6, "NetUtils", "doPostEx_DNS lookup :" + str, (Throwable) null, "com.didi.common.map.util.NetUtils$1", 104);
                try {
                    FutureTask futureTask = new FutureTask(new Callable<List<InetAddress>>() {
                        public List<InetAddress> call() throws Exception {
                            return Arrays.asList(InetAddress.getAllByName(str));
                        }
                    });
                    new Thread(futureTask).start();
                    return (List) futureTask.get(100000, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    SystemUtils.log(6, "NetUtils", "doPostEx_DNS :" + e.toString(), (Throwable) null, "com.didi.common.map.util.NetUtils$1", 116);
                    ArrayList arrayList = new ArrayList();
                    if (!CollectionUtil.isEmpty((Collection<?>) list)) {
                        for (String str2 : list) {
                            if (!TextUtils.isEmpty(str2)) {
                                arrayList.add(InetAddress.getByName(str2));
                                SystemUtils.log(6, "NetUtils", "lookup:" + str2, (Throwable) null, "com.didi.common.map.util.NetUtils$1", 122);
                            }
                        }
                    }
                    return arrayList;
                }
            }
        });
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) httpRpcClient.newRpc(builder.build()).execute()).getEntity().getContent());
    }

    public static byte[] doGetEx(String str) throws Exception {
        HttpRpcRequest.Builder builder = new HttpRpcRequest.Builder();
        builder.setUrl(str).setMethod(HttpMethod.GET, (HttpEntity) null);
        return new ByteArrayDeserializer().deserialize(((HttpRpcResponse) f10952a.newRpc(builder.build()).execute()).getEntity().getContent());
    }
}
