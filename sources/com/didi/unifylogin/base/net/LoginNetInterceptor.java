package com.didi.unifylogin.base.net;

import android.text.TextUtils;
import com.didi.unifylogin.base.log.TraceLogBiz;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.StringUtil;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcInterceptor;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;

@ServiceProvider({RpcInterceptor.class})
public class LoginNetInterceptor implements HttpRpcInterceptor {

    /* renamed from: a */
    private static final String f44684a = " url:";

    /* renamed from: b */
    private static final String f44685b = ", body:";

    /* renamed from: c */
    private static final String f44686c = ", response:";

    /* renamed from: d */
    private static final String f44687d = "passport";

    /* renamed from: e */
    private static final String f44688e = "\"uid\":";

    /* renamed from: f */
    private static final String f44689f = "\"ticket\":";

    /* renamed from: g */
    private static final String f44690g = "\"password\":";

    /* renamed from: h */
    private static final String f44691h = "\"new_password\":";

    /* renamed from: i */
    private static final String f44692i = "LoginSDK";

    /* renamed from: j */
    private static final String f44693j = "\"didi\"";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcResponse proceed = rpcChain.proceed(request);
        if (!m31730b(request)) {
            return proceed;
        }
        m31729a(request);
        return m31726a(proceed);
    }

    /* renamed from: a */
    private HttpRpcResponse m31726a(final HttpRpcResponse httpRpcResponse) throws IOException {
        try {
            final Buffer buffer = new Buffer();
            buffer.readFrom(httpRpcResponse.getEntity().getContent());
            buffer.request(Long.MAX_VALUE);
            String deserialize = new StringDeserializer().deserialize(buffer.clone().inputStream());
            TraceLogBiz instance = TraceLogBiz.getInstance();
            instance.addLogWithTab(f44684a + httpRpcResponse.getUrl() + f44686c + m31727a(deserialize));
            return httpRpcResponse.newBuilder().setEntity((HttpEntity) new HttpBody() {
                public void close() throws IOException {
                    buffer.close();
                }

                public MimeType getContentType() {
                    return httpRpcResponse.getEntity().getContentType();
                }

                public InputStream getContent() throws IOException {
                    return buffer.inputStream();
                }
            }).build();
        } catch (Exception e) {
            e.printStackTrace();
            return httpRpcResponse;
        }
    }

    /* renamed from: a */
    private void m31729a(HttpRpcRequest httpRpcRequest) throws IOException {
        try {
            if (httpRpcRequest.getEntity() != null) {
                String readFully = Streams.readFully((Reader) new InputStreamReader(httpRpcRequest.getEntity().getContent()));
                TraceLogBiz instance = TraceLogBiz.getInstance();
                instance.addLogWithTab(f44684a + httpRpcRequest.getUrl() + f44685b + m31727a(readFully));
                LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil("tech_passport_net_request_sw");
                loginOmegaUtil.add("path", StringUtil.getPath(httpRpcRequest.getUrl()));
                loginOmegaUtil.add("is_release", Integer.valueOf(LoginStore.isDebug ? 0 : 1));
                loginOmegaUtil.add("base_url", StringUtil.getBaseUrl(httpRpcRequest.getUrl()));
                loginOmegaUtil.send();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m31727a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(f44688e);
        arrayList.add(f44689f);
        arrayList.add(f44690g);
        arrayList.add(f44691h);
        String a = m31728a(str, arrayList);
        if (a.endsWith("}")) {
            return a;
        }
        return a + "}";
    }

    /* renamed from: b */
    private boolean m31730b(HttpRpcRequest httpRpcRequest) {
        try {
            if (new URI(httpRpcRequest.getUrl()).getHost().contains(f44687d)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private String m31728a(String str, List<String> list) {
        for (String next : list) {
            if (str.contains(next)) {
                String[] split = str.split(next);
                if (split[1] != null) {
                    str = str.replace(split[1].split(",")[0], f44693j);
                }
            }
        }
        return str;
    }
}
