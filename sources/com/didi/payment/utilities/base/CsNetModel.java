package com.didi.payment.utilities.base;

import android.content.Context;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.fastpay.FastPayUtils;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.utilities.resp.CsAccountStatus;
import com.didi.payment.utilities.resp.CsBoletoChannels;
import com.didi.payment.utilities.resp.CsCashbackResp;
import com.didi.payment.utilities.resp.CsCreateOrderResp;
import com.didi.payment.utilities.resp.CsGetBillResp;
import com.didi.payment.utilities.resp.CsOrderCashbackModel;
import com.didi.payment.utilities.resp.CsOrderCouponModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.wallet.dimina.DiminaLaunchModel;
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
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.AdminPermission;

public class CsNetModel {
    public static final String WALLET_URL = "https://wallet.didiglobal.com/api";

    /* renamed from: b */
    private static volatile CsNetModel f31548b;

    /* renamed from: a */
    private ConsumeService f31549a;

    /* renamed from: c */
    private Context f31550c;

    @Interception({RequestMonitorInterceptor.class})
    interface ConsumeService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/account/status")
        @Deserialization(GsonDeserializer.class)
        Object checkAccountStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsAccountStatus> callback);

        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/order/close")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object closeOrder(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/order")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object createOrder(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsCreateOrderResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/bill")
        @Deserialization(GsonDeserializer.class)
        Object getBillInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsGetBillResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/didipay/optimal/available")
        @Deserialization(GsonDeserializer.class)
        Object getCouponData(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsCashbackResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/boleto/channels")
        @Deserialization(GsonDeserializer.class)
        Object requestBoletoChannels(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsBoletoChannels> callback);
    }

    private CsNetModel(Context context) {
        this.f31550c = context;
        this.f31549a = (ConsumeService) new RpcServiceFactory(context.getApplicationContext()).newRpcService(ConsumeService.class, "https://wallet.didiglobal.com/api");
    }

    public static CsNetModel getIns(Context context) {
        if (f31548b == null) {
            synchronized (CsNetModel.class) {
                if (f31548b == null) {
                    f31548b = new CsNetModel(context);
                }
            }
        }
        return f31548b;
    }

    /* renamed from: a */
    private Map<String, Object> m22288a() {
        return PayBaseParamUtil.getHttpBaseParams(this.f31550c);
    }

    public void createUtilitiesOrder(int i, String str, String str2, Boolean bool, CsOrderCouponModel csOrderCouponModel, CsOrderCashbackModel csOrderCashbackModel, RpcService.Callback<CsCreateOrderResp> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        hashMap.put(AdminPermission.METADATA, str);
        hashMap.put(Const.PayParams.BIZ_CONTENT, str2);
        if (csOrderCouponModel.hasCoupons.equals("true")) {
            hashMap.put("couponData", new Gson().toJson((Object) csOrderCouponModel));
        }
        hashMap.put("useFastPay", bool);
        hashMap.put("thirdParty", FastPayUtils.INSTANCE.getThreeParty());
        hashMap.put("thirdPartyAbility", FastPayUtils.INSTANCE.getThreePartyAbility());
        if (csOrderCashbackModel.cashbackAmount > 0) {
            hashMap.put("cashback", new Gson().toJson((Object) csOrderCashbackModel));
        }
        hashMap.put("unpaidReminder", Integer.valueOf(WalletApolloUtil.isBoletoUnpaidBillReminder() ? 1 : 0));
        this.f31549a.createOrder(m22288a(), hashMap, callback);
    }

    public void getBillInfo(int i, String str, RpcService.Callback<CsGetBillResp> callback) {
        Map<String, Object> a = m22288a();
        a.put("product_line", Integer.valueOf(i));
        a.put("bar_code", str);
        this.f31549a.getBillInfo(a, callback);
    }

    public void getCouponData(int i, String str, String str2, String str3, RpcService.Callback<CsCashbackResp> callback) {
        Map<String, Object> a = m22288a();
        a.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        a.put("amount", str);
        a.put(Const.FlutterBundleKey.COUPON_ID, str2);
        a.put("excludeCoupon", str3);
        this.f31549a.getCouponData(a, callback);
    }

    public void requestBoletoChannels(RpcService.Callback<CsBoletoChannels> callback) {
        this.f31549a.requestBoletoChannels(m22288a(), callback);
    }

    public void checkAccountStatus(RpcService.Callback<CsAccountStatus> callback) {
        this.f31549a.checkAccountStatus(m22288a(), callback);
    }

    public void closeOrder(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Map<String, Object> a = m22288a();
        a.put("product_line", Integer.valueOf(i));
        a.put("order_id", str);
        this.f31549a.closeOrder(a, callback);
    }
}
