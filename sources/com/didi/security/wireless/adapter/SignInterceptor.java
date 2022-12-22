package com.didi.security.wireless.adapter;

import android.text.TextUtils;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.dfbasesdk.http.BizAccessInterceptor;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.rpc.RpcNetworkInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

@ServiceProvider(priority = 999, value = {RpcInterceptor.class})
public class SignInterceptor implements RpcNetworkInterceptor<HttpRpcRequest, HttpRpcResponse> {

    /* renamed from: a */
    private static final String f38606a = SignInterceptor.class.getSimpleName();

    /* renamed from: b */
    private static final String f38607b = "wsg_sig_global_toggle";

    /* renamed from: c */
    private static final String f38608c = "wsg_env_global_toggle";

    /* renamed from: d */
    private static final String f38609d = "wsg_check_header_env_toggle";

    /* renamed from: e */
    private static final String f38610e = "wsg_log_global_toggle";

    /* renamed from: f */
    private static final String f38611f = "wsg_ntp_global_toggle";

    /* renamed from: g */
    private static final String f38612g = "wsg_ntp_global_serverlist";

    /* renamed from: h */
    private static final String f38613h = "wsg_device_print";

    /* renamed from: i */
    private static final String f38614i = "sig";

    /* renamed from: j */
    private static final String f38615j = "WSGSIG";

    /* renamed from: k */
    private static final String f38616k = "GET";

    /* renamed from: l */
    private static final String f38617l = "POST";

    /* renamed from: m */
    private static final String f38618m = "gzip";

    /* renamed from: n */
    private static final String f38619n = "application/x-www-form-urlencoded";

    /* renamed from: o */
    private static final String f38620o = "application/json; charset=utf-8";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        try {
            boolean allow = Apollo.getToggle(f38608c, true).allow();
            C13358a.m27349a(f38606a, String.format("Apollo(%s) allowEnv => %b", new Object[]{f38608c, Boolean.valueOf(allow)}));
            if (allow) {
                if (!(Apollo.getToggle(f38609d, true).allow() ? "1".equals(request.getHeader(BizAccessInterceptor.WSG_NOT_COLLECT_WSGENV)) : false)) {
                    request = m27344a(request);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            boolean allow2 = Apollo.getToggle(f38607b, true).allow();
            C13358a.m27349a(f38606a, String.format("Apollo(%s) allowSig => %b", new Object[]{f38607b, Boolean.valueOf(allow2)}));
            if (allow2) {
                request = m27346b(request);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            boolean allow3 = Apollo.getToggle(f38613h, false).allow();
            C13358a.m27349a(f38606a, String.format("Apollo(%s) allowDid => %b", new Object[]{f38613h, Boolean.valueOf(allow3)}));
            if (allow3) {
                request = m27347c(request);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return rpcChain.proceed(request);
    }

    /* renamed from: a */
    private HttpRpcRequest m27344a(HttpRpcRequest httpRpcRequest) {
        try {
            String url = httpRpcRequest.getUrl();
            String doCollect = SecurityWrapper.doCollect(url);
            if (TextUtils.isEmpty(doCollect)) {
                return httpRpcRequest;
            }
            HttpRpcRequest.Builder newBuilder = httpRpcRequest.newBuilder();
            StringBuilder sb = new StringBuilder(url);
            if (url.indexOf("?") < 0) {
                sb.append('?');
            } else {
                sb.append(Typography.amp);
            }
            sb.append("wsgenv");
            sb.append('=');
            sb.append(URLEncoder.encode(doCollect, "utf-8"));
            newBuilder.setUrl(sb.toString());
            return newBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return httpRpcRequest;
        }
    }

    /* renamed from: b */
    private HttpRpcRequest m27346b(HttpRpcRequest httpRpcRequest) {
        HttpRpcRequest httpRpcRequest2;
        try {
            String url = httpRpcRequest.getUrl();
            byte[] d = m27348d(httpRpcRequest);
            if (d == null || d.length <= 0) {
                httpRpcRequest2 = httpRpcRequest;
            } else {
                httpRpcRequest2 = httpRpcRequest.newBuilder().setMethod(httpRpcRequest.getMethod(), HttpBody.newInstance(httpRpcRequest.getEntity().getContentType(), d)).build();
            }
            String prepareSign = SecurityWrapper.prepareSign(url, d);
            String doSign = SecurityWrapper.doSign(prepareSign);
            C13358a.m27349a(f38606a, String.format("[%s] sig => [%s]", new Object[]{f38606a, doSign}));
            m27345a(prepareSign, doSign);
            if (TextUtils.isEmpty(doSign)) {
                return httpRpcRequest;
            }
            HttpRpcRequest.Builder newBuilder = httpRpcRequest2.newBuilder();
            newBuilder.removeHeaders("wsgsig");
            newBuilder.addHeader("wsgsig", doSign);
            return newBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return httpRpcRequest;
        }
    }

    /* renamed from: c */
    private HttpRpcRequest m27347c(HttpRpcRequest httpRpcRequest) {
        String deviceId = DeviceTokenWrapper.getInstance().getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = "null";
        }
        try {
            C13358a.m27349a(f38606a, String.format("[%s] did => [%s]", new Object[]{f38606a, deviceId}));
            HttpRpcRequest.Builder newBuilder = httpRpcRequest.newBuilder();
            newBuilder.removeHeaders(SecurityWrapper.WSG_DID_KEY_NAME);
            if (deviceId == null) {
                deviceId = "";
            }
            newBuilder.addHeader(SecurityWrapper.WSG_DID_KEY_NAME, deviceId);
            return newBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return httpRpcRequest;
        }
    }

    /* renamed from: a */
    private static void m27345a(String str, String str2) {
        boolean allow = Apollo.getToggle(f38610e, false).allow();
        String str3 = f38606a;
        C13358a.m27349a(str3, String.format("[%s] Apollo(%s) allowSig => %b", new Object[]{str3, f38610e, Boolean.valueOf(allow)}));
        if (allow) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("data", str);
                hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
                hashMap.put("wsgsig", str2);
                LoggerFactory.getLogger("sig").warnEvent(f38615j, (Map<?, ?>) hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        if (r3 == null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r3 != null) goto L_0x0025;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m27348d(com.didichuxing.foundation.net.rpc.http.HttpRpcRequest r6) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r1]
            r3 = 0
            com.didichuxing.foundation.net.http.HttpEntity r6 = r6.getEntity()     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            java.io.InputStream r3 = r6.getContent()     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            if (r3 == 0) goto L_0x0023
        L_0x0014:
            r6 = 0
            int r4 = r3.read(r2, r6, r1)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            r5 = -1
            if (r4 == r5) goto L_0x0020
            r0.write(r2, r6, r4)     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
            goto L_0x0014
        L_0x0020:
            r0.flush()     // Catch:{ Exception -> 0x0030, all -> 0x0029 }
        L_0x0023:
            if (r3 == 0) goto L_0x0033
        L_0x0025:
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0033
        L_0x0029:
            r6 = move-exception
            if (r3 == 0) goto L_0x002f
            r3.close()     // Catch:{ IOException -> 0x002f }
        L_0x002f:
            throw r6
        L_0x0030:
            if (r3 == 0) goto L_0x0033
            goto L_0x0025
        L_0x0033:
            byte[] r6 = r0.toByteArray()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.security.wireless.adapter.SignInterceptor.m27348d(com.didichuxing.foundation.net.rpc.http.HttpRpcRequest):byte[]");
    }
}
