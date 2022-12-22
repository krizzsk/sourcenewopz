package com.didi.sdk.net;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.BusinessParamsUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.net.rpc.http.HttpRpcRequest;
import com.didichuxing.foundation.net.rpc.http.HttpRpcResponse;
import com.didichuxing.foundation.rpc.RpcInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import didihttp.HttpUrl;
import java.io.IOException;

@ServiceProvider({RpcInterceptor.class})
public class EasternGlobalCommonParamsIntercedptor implements RpcInterceptor<HttpRpcRequest, HttpRpcResponse> {
    private static final String TAG = "EGCPIntercedptor";

    public HttpRpcResponse intercept(RpcInterceptor.RpcChain<HttpRpcRequest, HttpRpcResponse> rpcChain) throws IOException {
        HttpRpcRequest request = rpcChain.getRequest();
        HttpRpcRequest.Builder newBuilder = request.newBuilder();
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        String selectedType = ConfProxy.getInstance().getSelectedType();
        String url = request.getUrl();
        HttpUrl.Builder newBuilder2 = HttpUrl.parse(url).newBuilder();
        String paramValue = getParamValue(url, "product_id");
        if (!url.contains("product_id") || TextUtils.isEmpty(paramValue) || "0".equals(paramValue) || "-1".equals(paramValue)) {
            newBuilder2.addEncodedQueryParameter("product_id", String.valueOf(BusinessParamsUtil.getProductId(selectedType)));
        } else {
            if (url.indexOf("?") > 0) {
                SystemUtils.log(3, TAG, "url:" + url.substring(0, url.indexOf("?")), (Throwable) null, "com.didi.sdk.net.EasternGlobalCommonParamsIntercedptor", 55);
            }
            SystemUtils.log(3, TAG, "url productId:" + paramValue, (Throwable) null, "com.didi.sdk.net.EasternGlobalCommonParamsIntercedptor", 57);
            SystemUtils.log(3, TAG, "getProductId:" + BusinessParamsUtil.getProductId(selectedType), (Throwable) null, "com.didi.sdk.net.EasternGlobalCommonParamsIntercedptor", 58);
        }
        newBuilder.setUrl(newBuilder2.addEncodedQueryParameter("trip_country", BusinessParamsUtil.getTripCountry(selectedType, nationComponentData)).addEncodedQueryParameter("trip_cityid", BusinessParamsUtil.getTripCityId(selectedType, nationComponentData)).build().toString());
        return rpcChain.proceed(newBuilder.build());
    }

    private static String getParamValue(String str, String str2) {
        try {
            int indexOf = str.indexOf(str2);
            int length = str2.length() + indexOf + 1;
            if (indexOf <= 0 || str.length() <= length) {
                return null;
            }
            String substring = str.substring(length);
            int indexOf2 = substring.indexOf(ParamKeys.SIGN_AND);
            return indexOf2 > 0 ? substring.substring(0, indexOf2) : substring;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
