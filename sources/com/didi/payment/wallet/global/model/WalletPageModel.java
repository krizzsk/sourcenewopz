package com.didi.payment.wallet.global.model;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.constant.GlobalServer;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;
import com.didi.payment.wallet.global.model.resp.WalletAccountStatus;
import com.didi.payment.wallet.global.model.resp.WalletCreateAccountResp;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderResp;
import com.didi.payment.wallet.global.model.resp.WalletCreateOrderRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletDriverATMResp;
import com.didi.payment.wallet.global.model.resp.WalletGetApplyInfoResp;
import com.didi.payment.wallet.global.model.resp.WalletGetCancelReasonResp;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet.global.model.resp.WalletPrePayResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpAmountItemsResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelRespOldServer;
import com.didi.payment.wallet.global.model.resp.WalletTopupOrderConfirmResp;
import com.didi.payment.wallet.global.model.resp.WalletUserProtocolsResp;
import com.didi.payment.wallet.global.prepaidcard.resp.CancelCardResp;
import com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp;
import com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit.BankCardResp;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModel;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
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
import com.didichuxing.foundation.rpc.annotation.Timeout;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.osgi.framework.AdminPermission;

public class WalletPageModel {

    /* renamed from: a */
    private static final String f31748a = "https://wallet.didiglobal.com";

    /* renamed from: b */
    private WalletPageRpcService f31749b;

    /* renamed from: c */
    private WalletPageRpcService f31750c;

    /* renamed from: d */
    private Context f31751d;

    @Timeout(connectTimeout = 30000)
    @Interception({RequestMonitorInterceptor.class})
    interface WalletPageRpcService extends RpcService {
        public static final String stagingURL = "/didipay_staging";

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/cancel")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        CancelCardResp cancelCard(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/v0/account/status")
        @Deserialization(GsonDeserializer.class)
        Object checkAccountStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletAccountStatus> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/driverATM/status")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object checkDriverATMStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletDriverATMResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order/close")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object closeOrder(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order/confirm")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object confirmTopupOrder(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletTopupOrderConfirmResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object createAccount(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletCreateAccountResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object createOrder(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletCreateOrderResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/web_wallet/international/external/wallet/v1/didipay/createOrder")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object createOrderOldServer(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletCreateOrderRespOldServer> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/kyc")
        @Deserialization(GsonDeserializer.class)
        Object getApplyInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletGetApplyInfoResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/bankCard/list")
        @Deserialization(GsonDeserializer.class)
        Object getBankCardList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<BankCardResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order/getCancelReason")
        @Deserialization(GsonDeserializer.class)
        Object getCancelReason(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletGetCancelReasonResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order/history")
        @Deserialization(GsonDeserializer.class)
        Object getHistoryList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CsHistoryListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order/status")
        @Deserialization(GsonDeserializer.class)
        Object getOrderStatus(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletPayResultResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/latour/popUp")
        @Deserialization(GsonDeserializer.class)
        Object getPopUpWindowInfo(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletPopUpWindowResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v1/user/protocols")
        @Deserialization(GsonDeserializer.class)
        Object getUserRequiredAcceptProtocols(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletUserProtocolsResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v2/home")
        @Deserialization(GsonDeserializer.class)
        Object getWalletHomeV2Info(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletHomeModel> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/open/session")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        OpenSessionResp openSession(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/apply/check")
        @Deserialization(GsonDeserializer.class)
        PreApplyCardResp preApplyCard(@QueryParameter("") Map<String, Object> map);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/boleto/prePay")
        @Deserialization(GsonDeserializer.class)
        Object prePay(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletPrePayResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/query/qr")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object queryQrCode(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixQrCodeQueryResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/driverATM/remindExit")
        @Deserialization(GsonDeserializer.class)
        Object remindExit(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v1/home")
        @Deserialization(GsonDeserializer.class)
        Object requestHomeData(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletHomeResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/home")
        @Deserialization(GsonDeserializer.class)
        Object requestPayMethodList(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletPageQueryResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/web_wallet/international/external/wallet/v2/all_entries/query")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object requestPayMethodListOldServer(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletPageQueryResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/online/items")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object requestTopUpAmountItems(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletTopUpAmountItemsResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/channels")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object requestTopUpChannel(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletTopUpChannelResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/web_wallet/international/external/wallet/v1/topup/channels")
        @Post
        @Deserialization(GsonDeserializer.class)
        Object requestTopUpChannelOldServer(@QueryParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletTopUpChannelRespOldServer> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/crash/remindMe")
        @Deserialization(GsonDeserializer.class)
        Object subscribeRecoverNotice(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v1/user/protocol/confirm")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object updateUserAcceptedProtocol(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") Map<String, Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WalletUserProtocolsResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/card/verify/password")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        WBaseResp verifyPassword(@QueryParameter("") Map<String, Object> map, @BodyParameter("") Map<String, Object> map2);
    }

    public WalletPageModel(Context context) {
        this.f31751d = context;
        this.f31749b = (WalletPageRpcService) new RpcServiceFactory(context).newRpcService(WalletPageRpcService.class, "https://wallet.didiglobal.com");
        this.f31750c = (WalletPageRpcService) new RpcServiceFactory(context).newRpcService(WalletPageRpcService.class, GlobalServer.GLOBAL_ONLINE_ORIGIN_URL);
    }

    public void getApplyInfo(RpcService.Callback<WalletGetApplyInfoResp> callback) {
        this.f31749b.getApplyInfo(m22519a(this.f31751d), callback);
    }

    public void createAccount(String str, String str2, String str3, String str4, RpcService.Callback<WalletCreateAccountResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("name", str);
        a.put("birth_date", str2);
        a.put("tax_id", str3);
        a.put("email", str4);
        this.f31749b.createAccount(a, callback);
    }

    public void requestWalletHomeData(RpcService.Callback<WalletHomeResp> callback) {
        this.f31749b.requestHomeData(m22519a(this.f31751d), callback);
    }

    public void requestWalletPageList(RpcService.Callback<WalletPageQueryResp> callback) {
        this.f31749b.requestPayMethodList(m22519a(this.f31751d), callback);
    }

    public void requestWalletPageListOldServer(RpcService.Callback<WalletPageQueryResp> callback) {
        this.f31750c.requestPayMethodListOldServer(m22519a(this.f31751d), callback);
    }

    public void requestWalletTopUpChannelOldServer(RpcService.Callback<WalletTopUpChannelRespOldServer> callback) {
        this.f31750c.requestTopUpChannelOldServer(m22519a(this.f31751d), callback);
    }

    public void requestWalletTopUpChannel(RpcService.Callback<WalletTopUpChannelResp> callback) {
        this.f31749b.requestTopUpChannel(m22519a(this.f31751d), callback);
    }

    public void checkDriverATMStatus(int i, RpcService.Callback<WalletDriverATMResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        this.f31749b.checkDriverATMStatus(a, callback);
    }

    public void requestWalletTopupAmountItems(String str, RpcService.Callback<WalletTopUpAmountItemsResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        if (!TextUtils.isEmpty(str)) {
            a.put("extMetadata", str);
        }
        this.f31749b.requestTopUpAmountItems(a, callback);
    }

    public void createOrder(int i, int i2, String str, String str2, RpcService.Callback<WalletCreateOrderResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        hashMap.put(AdminPermission.METADATA, str);
        if (i2 >= 0) {
            hashMap.put("orderType", Integer.valueOf(i2));
        }
        if (!TextUtil.isEmpty(str2)) {
            hashMap.put("extMetadata", str2);
        }
        this.f31749b.createOrder(a, hashMap, callback);
    }

    public void createOrder(Map<String, Object> map, RpcService.Callback<WalletCreateOrderResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            hashMap.putAll(map);
        }
        this.f31749b.createOrder(a, hashMap, callback);
    }

    public void closeOrder(int i, String str, RpcService.Callback<WBaseResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        a.put("order_id", str);
        this.f31749b.closeOrder(a, callback);
    }

    public void remindExt() {
        this.f31749b.remindExit(m22519a(this.f31751d), new RpcService.Callback<WBaseResp>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(WBaseResp wBaseResp) {
            }
        });
    }

    public void getOrderStatus(int i, String str, RpcService.Callback<WalletPayResultResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        a.put("order_id", str);
        this.f31749b.getOrderStatus(a, callback);
    }

    public void sendTopupOrder2Driver(int i, String str, RpcService.Callback<WalletTopupOrderConfirmResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        a.put("order_id", str);
        this.f31749b.confirmTopupOrder(a, callback);
    }

    public void createOrderOldServer(String str, String str2, String str3, RpcService.Callback<WalletCreateOrderRespOldServer> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put(ErrorConst.ModuleName.SKU, str);
        hashMap.put("currency", str2);
        hashMap.put("extend_params", str3);
        this.f31750c.createOrderOldServer(a, hashMap, callback);
    }

    public void getHistoryList(int i, int i2, int i3, int i4, RpcService.Callback<CsHistoryListResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        a.put("start_index", Integer.valueOf(i2));
        a.put("page_size", 20);
        if (i3 >= 0) {
            a.put("order_type", Integer.valueOf(i3));
        }
        a.put("order_category", Integer.valueOf(i4));
        this.f31749b.getHistoryList(a, callback);
    }

    public void prePay(int i, String str, RpcService.Callback<WalletPrePayResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        a.put("order_id", str);
        this.f31749b.prePay(a, callback);
    }

    public void getCancelReason(int i, RpcService.Callback<WalletGetCancelReasonResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("product_line", Integer.valueOf(i));
        this.f31749b.getCancelReason(a, callback);
    }

    public void checkAccountStatus(RpcService.Callback<WalletAccountStatus> callback) {
        this.f31749b.checkAccountStatus(m22519a(this.f31751d), callback);
    }

    public void queryPixQrCode(String str, RpcService.Callback<PixQrCodeQueryResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put("QRCode", str);
        this.f31749b.queryQrCode(a, hashMap, callback);
    }

    public void getUserRequiredAcceptProtocols(String str, RpcService.Callback<WalletUserProtocolsResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("protocolType", str);
        this.f31749b.getUserRequiredAcceptProtocols(a, callback);
    }

    public void updateUserAcceptedProtocol(String str, String str2, RpcService.Callback<WalletUserProtocolsResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        hashMap.put("version", str2);
        this.f31749b.updateUserAcceptedProtocol(a, hashMap, callback);
    }

    public void getPopUpWindowInfo(boolean z, RpcService.Callback<WalletPopUpWindowResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("hasShown", Boolean.valueOf(z));
        this.f31749b.getPopUpWindowInfo(a, callback);
    }

    public void getWalletHomeV2Info(String str, RpcService.Callback<WalletHomeModel> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put(InvitationPageActivity.RESOURCE_ID, str);
        this.f31749b.getWalletHomeV2Info(a, callback);
    }

    public void getBankCardList(RpcService.Callback<BankCardResp> callback) {
        this.f31749b.getBankCardList(m22519a(this.f31751d), callback);
    }

    public void subscribeRecoverNotice(String str, RpcService.Callback<WBaseResp> callback) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("crashType", str);
        this.f31749b.subscribeRecoverNotice(a, callback);
    }

    public OpenSessionResp openSession(String str, String str2) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put("scene", str);
        hashMap.put("cardId", str2);
        return this.f31749b.openSession(a, hashMap);
    }

    public CancelCardResp cancelCard(String str, String str2, String str3) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put("cardId", str);
        hashMap.put("source", str2);
        hashMap.put("sessionId", str3);
        return this.f31749b.cancelCard(a, hashMap);
    }

    public PreApplyCardResp preApplyCard(String str) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        a.put("type", str);
        return this.f31749b.preApplyCard(a);
    }

    public WBaseResp verifyPassword(String str, String str2, String str3, String str4, String str5) {
        HashMap<String, Object> a = m22519a(this.f31751d);
        HashMap hashMap = new HashMap();
        hashMap.put("passwordType", str4);
        hashMap.put("payPasswordToken", str5);
        hashMap.put("cardId", str);
        hashMap.put("sessionId", str2);
        hashMap.put("scene", str3);
        return this.f31749b.verifyPassword(a, hashMap);
    }

    /* renamed from: a */
    private HashMap<String, Object> m22519a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }
}
