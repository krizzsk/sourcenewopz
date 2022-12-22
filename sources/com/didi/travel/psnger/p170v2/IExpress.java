package com.didi.travel.psnger.p170v2;

import com.didi.travel.p171v2.biz.IBiz;
import com.didi.travel.p171v2.biz.IIBiz;
import com.didi.travel.p171v2.biz.api.ApiInvokePolicy;
import com.didi.travel.p171v2.biz.api.IIApi;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.biz.bff.BffVersion;
import com.didi.travel.p171v2.biz.bff.IIBff;
import com.didi.travel.p171v2.biz.rpc.IIRpc;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.model.response.CancelOrder;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.p170v2.api.GetOrderDetailBffInvokeCallback;
import com.didi.travel.psnger.p170v2.api.GetOrderDetailRpcInvokeCallback;
import com.didi.travel.psnger.p170v2.host.ExpressRpcDynamicHostCallback;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.p188io.StringDeserializer;
import com.didichuxing.foundation.rpc.annotation.BodyParameter;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import java.util.Map;

@IIBiz(key = "Express", rpcDynamicHostImp = ExpressRpcDynamicHostCallback.class)
/* renamed from: com.didi.travel.psnger.v2.IExpress */
public interface IExpress extends IBiz {
    public static final String CERT_ROUTE = "-----BEGIN CERTIFICATE-----\nMIIEaTCCA1GgAwIBAgILBAAAAAABRE7wQkcwDQYJKoZIhvcNAQELBQAwVzELMAkG\nA1UEBhMCQkUxGTAXBgNVBAoTEEdsb2JhbFNpZ24gbnYtc2ExEDAOBgNVBAsTB1Jv\nb3QgQ0ExGzAZBgNVBAMTEkdsb2JhbFNpZ24gUm9vdCBDQTAeFw0xNDAyMjAxMDAw\nMDBaFw0yNDAyMjAxMDAwMDBaMGYxCzAJBgNVBAYTAkJFMRkwFwYDVQQKExBHbG9i\nYWxTaWduIG52LXNhMTwwOgYDVQQDEzNHbG9iYWxTaWduIE9yZ2FuaXphdGlvbiBW\nYWxpZGF0aW9uIENBIC0gU0hBMjU2IC0gRzIwggEiMA0GCSqGSIb3DQEBAQUAA4IB\nDwAwggEKAoIBAQDHDmw/I5N/zHClnSDDDlM/fsBOwphJykfVI+8DNIV0yKMCLkZc\nC33JiJ1Pi/D4nGyMVTXbv/Kz6vvjVudKRtkTIso21ZvBqOOWQ5PyDLzm+ebomchj\nSHh/VzZpGhkdWtHUfcKc1H/hgBKueuqI6lfYygoKOhJJomIZeg0k9zfrtHOSewUj\nmxK1zusp36QUArkBpdSmnENkiN74fv7j9R7l/tyjqORmMdlMJekYuYlZCa7pnRxt\nNw9KHjUgKOKv1CGLAcRFrW4rY6uSa2EKTSDtc7p8zv4WtdufgPDWi2zZCHlKT3hl\n2pK8vjX5s8T5J4BO/5ZS5gIg4Qdz6V0rvbLxAgMBAAGjggElMIIBITAOBgNVHQ8B\nAf8EBAMCAQYwEgYDVR0TAQH/BAgwBgEB/wIBADAdBgNVHQ4EFgQUlt5h8b0cFilT\nHMDMfTuDAEDmGnwwRwYDVR0gBEAwPjA8BgRVHSAAMDQwMgYIKwYBBQUHAgEWJmh0\ndHBzOi8vd3d3Lmdsb2JhbHNpZ24uY29tL3JlcG9zaXRvcnkvMDMGA1UdHwQsMCow\nKKAmoCSGImh0dHA6Ly9jcmwuZ2xvYmFsc2lnbi5uZXQvcm9vdC5jcmwwPQYIKwYB\nBQUHAQEEMTAvMC0GCCsGAQUFBzABhiFodHRwOi8vb2NzcC5nbG9iYWxzaWduLmNv\nbS9yb290cjEwHwYDVR0jBBgwFoAUYHtmGkUNl8qJUC99BM00qP/8/UswDQYJKoZI\nhvcNAQELBQADggEBAEYq7l69rgFgNzERhnF0tkZJyBAW/i9iIxerH4f4gu3K3w4s\n32R1juUYcqeMOovJrKV3UPfvnqTgoI8UV6MqX+x+bRDmuo2wCId2Dkyy2VG7EQLy\nXN0cvfNVlg/UBsD84iOKJHDTu/B5GqdhcIOKrwbFINihY9Bsrk8y1658GEV1BSl3\n30JAZGSGvip2CTFvHST0mdCF/vIhCPnG9vHQWe3WVjwIKANnuvD58ZAWR65n5ryA\nSOlCdjSXVWkkDoPWoC209fN5ikkodBpBocLTJIg1MGCUF7ThBCIxPTsvFwayuJ2G\nK1pp74P1S8SqtCr4fKGxhZSM9AyHDPSsQPhZSZg=\n-----END CERTIFICATE-----";

    @IIBff(ability = "passenger/pCancelOrder", dataType = CancelOrder.class, version = BffVersion.f44308V1)
    @IIApi(apiInvokePolicy = ApiInvokePolicy.BFF, key = "order_cancel_order")
    void cancelOrder(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RemoteCallback<CancelOrder> remoteCallback);

    @IIApi(apiInvokePolicy = ApiInvokePolicy.BFF, key = "order_get_realtime_price_info")
    @IIBff(ability = "passenger/pGetRealTimePrice", dataType = OrderRealtimePriceCount.class, version = BffVersion.f44308V1)
    @Path("other/pGetRealTimePrice")
    @Post
    @Deserialization(StringDeserializer.class)
    void getOnServiceRealtimePrice(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RemoteCallback<OrderRealtimePriceCount> remoteCallback);

    @IIBff(ability = "passenger/pOrderDetail", bffV1InvokeCallbackImp = GetOrderDetailBffInvokeCallback.class, dataType = DTSDKOrderDetail.class, version = BffVersion.f44308V1)
    @IIApi(apiInvokePolicy = ApiInvokePolicy.BFF, key = "order_get_order_detail_info")
    void getOrderDetailByBff(Map<String, Object> map, RemoteCallback<DTSDKOrderDetail> remoteCallback);

    @Get
    @IIApi(apiInvokePolicy = ApiInvokePolicy.RPC, key = "order_get_order_detail_info")
    @Path("core/pOrderDetail")
    @IIRpc(dataType = DTSDKOrderDetail.class, host = "https://api.didiglobal.com/", hostKey = "host_key_biz", rpcInvokeCallbackImp = GetOrderDetailRpcInvokeCallback.class, sharePath = "gulfstream/passenger/v2/")
    @Deserialization(StringDeserializer.class)
    Object getOrderDetailByRpc(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RemoteCallback<DTSDKOrderDetail> remoteCallback);

    @IIBff(ability = "passenger/pOrderStatus", dataType = DTSDKOrderStatus.class, version = BffVersion.f44308V1)
    @IIApi(apiInvokePolicy = ApiInvokePolicy.BFF, key = "order_get_order_status")
    void getOrderStatus(@QueryParameter("") @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RemoteCallback<DTSDKOrderStatus> remoteCallback);
}
