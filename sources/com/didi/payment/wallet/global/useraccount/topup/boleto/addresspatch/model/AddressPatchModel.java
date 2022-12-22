package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListCityResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListStateResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Interception;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.Serialization;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.util.HashMap;
import java.util.Map;

public class AddressPatchModel {

    /* renamed from: a */
    private static final String f31860a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private BoletoZipCodeRpcService f31861b;

    /* renamed from: c */
    private Context f31862c;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface BoletoZipCodeRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/address/detail")
        @Deserialization(GsonDeserializer.class)
        Object requestBoletoAddress(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AddressFromZipCodeResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/address/cities")
        @Deserialization(GsonDeserializer.class)
        Object requestCityList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AddressListCityResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/address/states")
        @Deserialization(GsonDeserializer.class)
        Object requestStateList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AddressListStateResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/address")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object submitBoletoAddressPatch(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<AddressPatchResp> callback);
    }

    public AddressPatchModel(Context context) {
        this.f31862c = context;
        this.f31861b = (BoletoZipCodeRpcService) new RpcServiceFactory(context).newRpcService(BoletoZipCodeRpcService.class, "https://wallet.didiglobal.com");
    }

    public void requestBoletoAddress(String str, RpcService.Callback<AddressFromZipCodeResp> callback) {
        HashMap<String, Object> a = m22573a(this.f31862c);
        a.put("zip_code", str);
        this.f31861b.requestBoletoAddress(a, callback);
    }

    public void submitBoletoAddressPatch(AddressFromZipCodeResp.DataBean dataBean, RpcService.Callback<AddressPatchResp> callback) {
        HashMap<String, Object> a = m22573a(this.f31862c);
        HashMap hashMap = new HashMap();
        String str = "";
        hashMap.put("zipCode", dataBean.zipCode == null ? str : dataBean.zipCode);
        hashMap.put("streetName", dataBean.streetName == null ? str : dataBean.streetName);
        hashMap.put("number", dataBean.number == null ? str : dataBean.number);
        hashMap.put("complement", dataBean.complement == null ? str : dataBean.complement);
        hashMap.put("neighborhood", dataBean.neighborhood == null ? str : dataBean.neighborhood);
        hashMap.put("state", dataBean.state == null ? str : dataBean.state);
        if (dataBean.city != null) {
            str = dataBean.city;
        }
        hashMap.put("city", str);
        this.f31861b.submitBoletoAddressPatch(a, hashMap, callback);
    }

    /* renamed from: a */
    private HashMap<String, Object> m22573a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public void requestState(ListFragmentExtraState listFragmentExtraState, RpcService.Callback<AddressListStateResp> callback) {
        HashMap<String, Object> a = m22573a(this.f31862c);
        a.put("country_code", listFragmentExtraState.countryCode);
        this.f31861b.requestStateList(a, callback);
    }

    public void requestCities(ListFragmentExtraCity listFragmentExtraCity, RpcService.Callback<AddressListCityResp> callback) {
        HashMap<String, Object> a = m22573a(this.f31862c);
        a.put("country_code", listFragmentExtraCity.countryCode);
        a.put("state_code", listFragmentExtraCity.stateCode);
        this.f31861b.requestCityList(a, callback);
    }
}
