package com.didi.component.common.net;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.app.router.PageRouter;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.common.eventtracker.APIStatusTracker;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.login.LoginReason;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.store.DDTravelOrderStore;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.HttpBody;
import com.didichuxing.foundation.net.http.HttpEntity;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.p188io.Streams;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ServiceProvider({RpcInterceptor.class})
public class ApiBizStatusHandleInterceptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    private static final String TAG = "ApiBizStatusInterceptor";
    private static final String errno101 = "101";
    private Pattern errno_p = Pattern.compile("\"errno\":\\s*\"?(\\d+)\"?\\s*,?");
    private List<String> sUrlSuffixList = new ArrayList();
    private Pattern token_p = Pattern.compile("&token=(.+?)&");

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        RidGetterInterceptor.threadLocal.remove();
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcResponse proceed = rpcChain.proceed(request);
        if (request != null) {
            String pathFrom = getPathFrom(request.getUrl());
            String str = null;
            if (hitErrno101Track(pathFrom)) {
                str = getBodyFrom(proceed);
                checkToTrackErrno101(request, str);
            }
            if (hitAppApiResultTrack(pathFrom)) {
                if (str == null) {
                    str = getBodyFrom(proceed);
                }
                checkToTrackAppApiResult(pathFrom, proceed.getStatus(), str);
            }
            if (isBFFUrl(pathFrom)) {
                if (str == null) {
                    str = getBodyFrom(proceed);
                }
                handleError101(str, pathFrom);
            }
            if (str != null) {
                proceed = proceed.newBuilder().setEntity((HttpEntity) HttpBody.newInstance(proceed.getEntity().getContentType(), str)).build();
            }
            new RequestParamsChecker().checkRequestParams(pathFrom, request);
        }
        return proceed;
    }

    private String getPathFrom(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
    }

    private String getBodyFrom(HttpRpcResponse httpRpcResponse) throws IOException {
        HttpEntity entity = httpRpcResponse.getEntity();
        MimeType contentType = entity.getContentType();
        if (contentType == null || !httpRpcResponse.isSuccessful() || entity.getContentLength() == 0) {
            return "";
        }
        return ("text".equalsIgnoreCase(contentType.getType()) || "json".equalsIgnoreCase(contentType.getSubtype())) ? Streams.readFully((Reader) new InputStreamReader(entity.getContent())) : "";
    }

    private boolean hitErrno101Track(String str) {
        IToggle toggle = Apollo.getToggle("app_api_result_tracker");
        if (toggle != null && toggle.allow()) {
            String str2 = (String) toggle.getExperiment().getParam("hosts", "");
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            String[] split = str2.split(",");
            for (String contains : split) {
                if (str.contains(contains)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkToTrackErrno101(HttpRpcRequest httpRpcRequest, String str) {
        String str2;
        String token = OneLoginFacade.getStore().getToken();
        try {
            Matcher matcher = this.errno_p.matcher(str);
            if (matcher != null && matcher.find() && matcher.groupCount() >= 1) {
                String str3 = RidGetterInterceptor.threadLocal.get();
                String group = matcher.group(1);
                if (httpRpcRequest.getUrl().contains("/gulfstream/passenger/v2/")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("url", httpRpcRequest.getUrl());
                    hashMap.put(ParamConst.TRACE_ID, str3);
                    hashMap.put("err_no", group);
                    LoggerFactory.getLogger("GlobalAPI").info("api request:", (Map<?, ?>) hashMap);
                }
                if ("101".equals(group)) {
                    Matcher matcher2 = this.token_p.matcher(httpRpcRequest.getUrl());
                    String group2 = (!matcher2.find() || matcher2.groupCount() < 1) ? null : matcher2.group(1);
                    HttpEntity entity = httpRpcRequest.getEntity();
                    if (!(entity == null || entity.getContent() == null || entity.getContentLength() <= 0)) {
                        Matcher matcher3 = this.token_p.matcher(Streams.readFully((Reader) new InputStreamReader(httpRpcRequest.getEntity().getContent())));
                        if (matcher3.find() && matcher3.groupCount() >= 1) {
                            str2 = matcher3.group(1);
                            APIStatusTracker.getInstance().trackWhen101(httpRpcRequest.getUrl(), str3, token, group2, str2);
                        }
                    }
                    str2 = null;
                    APIStatusTracker.getInstance().trackWhen101(httpRpcRequest.getUrl(), str3, token, group2, str2);
                }
            }
        } catch (Exception e) {
            GLog.m7969e(TAG, "", e);
        }
    }

    private boolean hitAppApiResultTrack(String str) {
        if (!TextUtils.isEmpty(hitMonitorFor(str))) {
            return true;
        }
        if (getUrlSuffixList().size() <= 0 || !isBFFUrl(str)) {
            return false;
        }
        return true;
    }

    private boolean isBFFUrl(String str) {
        return str.contains("/halo/") || str.contains("/ability/");
    }

    private void handleError101(String str, final String str2) {
        Matcher matcher = this.errno_p.matcher(str);
        if (matcher != null && matcher.find() && matcher.groupCount() >= 1 && TextUtils.equals(matcher.group(1), "101")) {
            final String str3 = RidGetterInterceptor.threadLocal.get();
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    if (OneLoginFacade.getStore().isLoginNow() && GlobalApolloUtil.isBff101Repair()) {
                        OneLoginFacade.getAction().passiveLogout(DIDIBaseApplication.getAppContext(), LoginReason.SIGN_IN_OR_SIGN_OFF_KICK_OFF_SHORT_LINK, str2, str3);
                        FormStore.getInstance().clear();
                        DDTravelOrderStore.setOrder((ICarOrder) null);
                        Intent intent = new Intent();
                        intent.putExtra(Constant.LOGOUT_KEY, true);
                        intent.setFlags(268435456);
                        PageRouter.getInstance().startMainActivity(DIDIBaseApplication.getAppContext(), intent);
                    }
                }
            });
        }
    }

    private void checkToTrackAppApiResult(String str, int i, String str2) {
        try {
            String hitMonitorFor = hitMonitorFor(str);
            if (!TextUtils.isEmpty(hitMonitorFor)) {
                trackRsp(str, hitMonitorFor, i, str2);
            }
            List<String> bffAbilitiesFor = bffAbilitiesFor(str2);
            if (bffAbilitiesFor != null && bffAbilitiesFor.size() > 0) {
                for (String next : bffAbilitiesFor) {
                    String hitMonitorFor2 = hitMonitorFor(next);
                    if (!TextUtils.isEmpty(hitMonitorFor2)) {
                        trackRsp(str, hitMonitorFor2, i, new JSONObject(str2).getJSONObject("data").getJSONObject("abilities").getJSONObject(next).toString());
                    }
                }
            }
        } catch (JSONException e) {
            GLog.m7969e(TAG, "error", e);
        }
    }

    private String hitMonitorFor(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String next : getUrlSuffixList()) {
            if (str.endsWith(next)) {
                return next;
            }
        }
        return null;
    }

    private synchronized List<String> getUrlSuffixList() {
        IToggle toggle;
        if (this.sUrlSuffixList.size() == 0 && (toggle = Apollo.getToggle("request_rsp_monitor")) != null && toggle.allow()) {
            try {
                JSONArray jSONArray = new JSONArray((String) toggle.getExperiment().getParam("path_suffix_list", ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        this.sUrlSuffixList.add(optString);
                    }
                }
            } catch (Exception e) {
                GLog.m7969e(TAG, "", e);
            }
        }
        return this.sUrlSuffixList;
    }

    private List<String> bffAbilitiesFor(String str) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has("abilities") && (optJSONObject2 = optJSONObject.optJSONObject("abilities")) != null) {
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
            }
        } catch (JSONException e) {
            GLog.m7968e(TAG, "body = " + str);
            GLog.m7969e(TAG, "error", e);
        }
        return arrayList;
    }

    private void trackRsp(String str, String str2, int i, String str3) {
        Event newEvent = OmegaSDK.newEvent("app_api_result");
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (jSONObject.has("errno")) {
                newEvent.putAttr("errno", Integer.valueOf(jSONObject.optInt("errno")));
            }
        } catch (Exception e) {
            GLog.m7969e(TAG, "", e);
        }
        newEvent.putAttr("status", Integer.valueOf(i));
        newEvent.putAttr("network", SystemUtil.getNetworkType());
        newEvent.putAttr("url", str);
        newEvent.putAttr("url_flag", str2);
        newEvent.putAttr("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        OmegaSDKAdapter.trackEvent(newEvent);
        GLog.m7971i(TAG, "app_api_result: " + newEvent.toString());
    }
}
