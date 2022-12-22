package com.didi.unifylogin.base.net;

import android.text.TextUtils;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.StringUtil;
import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.util.Iterator;
import org.json.JSONObject;

public abstract class LoginRpcCallbackV2<T extends BaseResponse> implements RpcService.CallbackV2<T> {
    /* access modifiers changed from: protected */
    public void addCustomTrackParams(LoginOmegaUtil loginOmegaUtil) {
    }

    public void onSuccess(RpcResponseProxy<T> rpcResponseProxy) {
        try {
            trackSuccess(rpcResponseProxy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        try {
            trackFailure(rpcRequest, iOException);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void trackSuccess(RpcResponseProxy<T> rpcResponseProxy) {
        BaseResponse baseResponse = (BaseResponse) rpcResponseProxy.getContent();
        LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil("tech_passport_net_response_sw");
        loginOmegaUtil.add("errno", Integer.valueOf(baseResponse.errno));
        if (TextUtils.isEmpty(baseResponse.traceId)) {
            Iterator<HttpHeader> it = rpcResponseProxy.getHeaders().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                HttpHeader next = it.next();
                if (next.getName().equals("didi-header-rid")) {
                    loginOmegaUtil.add("trace", next.getValue());
                    break;
                }
            }
        } else {
            loginOmegaUtil.add("trace", baseResponse.traceId);
        }
        loginOmegaUtil.add("is_valid_rsp", Integer.valueOf(baseResponse.errno == -1 ? 0 : 1));
        loginOmegaUtil.add("path", StringUtil.getPath(rpcResponseProxy.getRequest().getUrl()));
        loginOmegaUtil.add("is_release", Integer.valueOf(LoginStore.isDebug ^ true ? 1 : 0));
        loginOmegaUtil.add("base_url", StringUtil.getBaseUrl(rpcResponseProxy.getRequest().getUrl()));
        if (baseResponse.errno == -1) {
            loginOmegaUtil.add("invalid_json_rsp", rpcResponseProxy.getContent());
        }
        try {
            String readFully = Streams.readFully((Reader) new InputStreamReader(((HttpRpcRequest) rpcResponseProxy.getRequest()).getEntity().getContent()));
            if (readFully.contains("auth_channel")) {
                loginOmegaUtil.add("auth_channel", (String) new JSONObject(URLDecoder.decode(readFully, "UTF-8").replaceAll("q=", "")).get("auth_channel"));
            }
        } catch (Exception unused) {
        }
        addCustomTrackParams(loginOmegaUtil);
        loginOmegaUtil.send();
    }

    private void trackFailure(RpcRequest rpcRequest, IOException iOException) {
        LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil("tech_passport_net_response_sw");
        loginOmegaUtil.add("errno", -1);
        if (iOException instanceof LoginJsonException) {
            loginOmegaUtil.add("is_valid_rsp", 0);
        } else {
            loginOmegaUtil.add("is_valid_rsp", 2);
        }
        loginOmegaUtil.add("path", StringUtil.getPath(rpcRequest.getUrl()));
        loginOmegaUtil.add("is_release", Integer.valueOf(LoginStore.isDebug ^ true ? 1 : 0));
        loginOmegaUtil.add("base_url", StringUtil.getBaseUrl(rpcRequest.getUrl()));
        loginOmegaUtil.send();
    }
}
