package com.didi.payment.pix.net;

import android.content.Context;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.net.WNetModel;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.key.create.response.PollStatusResp;
import com.didi.payment.pix.net.response.AddressZipCodeResp;
import com.didi.payment.pix.net.response.HistoryPixPayeeResp;
import com.didi.payment.pix.net.response.PixBankOptionResp;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.net.response.PixOrderCreateResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.net.response.PixOrderHistoryListResp;
import com.didi.payment.pix.net.response.PixQrChannelResp;
import com.didi.payment.pix.net.response.PixQrCodeGenResp;
import com.didi.payment.pix.net.response.PixRefundExtrasResp;
import com.didi.payment.pix.net.response.PixRefundResultResp;
import com.didi.payment.pix.net.response.PixTopUpOptionResp;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.wallet.dimina.DiminaLaunchModel;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.net.rpc.http.annotation.Post;
import com.didichuxing.foundation.rpc.RpcService;
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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.AdminPermission;

@Metadata(mo175977d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001JB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J<\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJB\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ4\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000fJ\u001c\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000fJ$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000fJ\u001c\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020%0\u000fJ\u0014\u0010&\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020'0\u000fJ\u0014\u0010(\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020)0\u000fJ\u0014\u0010*\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020+0\u000fJ\u0014\u0010,\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020-0\u000fJ&\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002010\u000fJ\u001c\u00102\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002010\u000fJ,\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002070\u000fJ,\u00108\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002090\u000fJ\u001c\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020<0\u000fJ\u001c\u0010=\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020>0\u000fJ\u001c\u0010?\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020@0\u000fJ,\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\t2\u0006\u0010$\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002010\u000fJ\u001c\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020F0\u000fJ$\u0010G\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\f2\u0006\u0010H\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020I0\u000f¨\u0006K"}, mo175978d2 = {"Lcom/didi/payment/pix/net/PixNetModel;", "Lcom/didi/payment/commonsdk/net/WNetModel;", "Lcom/didi/payment/pix/net/PixNetModel$PixRpcService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createPixTopUpOrder", "", "productLine", "", "orderType", "metadata", "", "passwordToken", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixOrderCreateResp;", "createTransferOrder", "bizContent", "genQRCode", "amount", "desc", "modified", "", "imageWidth", "callBack", "Lcom/didi/payment/pix/net/response/PixQrCodeGenResp;", "getBankOptionData", "source", "Lcom/didi/payment/pix/net/response/PixBankOptionResp;", "getHistoryPayee", "pageSize", "startIndex", "ck", "Lcom/didi/payment/pix/net/response/HistoryPixPayeeResp;", "getOrderDetail", "orderId", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp;", "getPixChannel", "Lcom/didi/payment/pix/home/PixChannelResp;", "getPixQrChannelList", "Lcom/didi/payment/pix/net/response/PixQrChannelResp;", "getPixTopUpOptions", "Lcom/didi/payment/pix/net/response/PixTopUpOptionResp;", "getTransferOptionInfo", "Lcom/didi/payment/pix/net/response/PixTransferOption;", "notifyTransferPush", "key", "type", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "orderRetry", "pollPixKeyStatus", "keyType", "keyVal", "pollType", "Lcom/didi/payment/pix/key/create/response/PollStatusResp;", "queryHistoryOrder", "Lcom/didi/payment/pix/net/response/PixOrderHistoryListResp;", "queryPixQrCode", "qrCode", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp;", "queryRefundDetail", "Lcom/didi/payment/pix/net/response/PixRefundResultResp;", "queryRefundOptions", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp;", "refundTransferMoney", "refundAmount", "reasonId", "requestAddress", "zipCode", "Lcom/didi/payment/pix/net/response/AddressZipCodeResp;", "verifyPixKey", "isExact", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp;", "PixRpcService", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixNetModel.kt */
public final class PixNetModel extends WNetModel<PixRpcService> {

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'Jd\u0010\u000b\u001a\u00020\u00032$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH'J>\u0010\u000f\u001a\u00020\u00032$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00100\tH'JT\u0010\u0011\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u0014\b\u0001\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00132\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\tH'J>\u0010\u0015\u001a\u00020\u00032$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00160\tH'J>\u0010\u0017\u001a\u00020\u00182$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH'Jd\u0010\u001b\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072$\b\u0001\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001d0\tH'J>\u0010\u001e\u001a\u00020\u00032$\b\u0001\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020 0\tH'Jd\u0010!\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072$\b\u0001\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\"0\tH'J>\u0010#\u001a\u00020\u00032$\b\u0001\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH'J.\u0010$\u001a\u00020\u00032\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00132\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020%0\tH'J.\u0010&\u001a\u00020\u00032\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00132\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020'0\tH'Jd\u0010(\u001a\u00020\u00032$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020)0\tH'J>\u0010*\u001a\u00020\u00032$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020+0\tH'Jd\u0010,\u001a\u00020\u00032$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020-0\tH'Jd\u0010.\u001a\u00020\u00032$\b\u0001\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072$\b\u0001\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH'J.\u0010/\u001a\u00020\u00032\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00132\u000e\b\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002000\tH'J>\u00101\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u0002020\tH'J>\u00103\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00072\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u0002040\tH'¨\u00065"}, mo175978d2 = {"Lcom/didi/payment/pix/net/PixNetModel$PixRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "bankOptions", "", "commonParam", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/pix/net/response/PixBankOptionResp;", "doRefundOrder", "commomnParams", "params", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "genQrCode", "Lcom/didi/payment/pix/net/response/PixQrCodeGenResp;", "getHistoryPayee", "body", "", "Lcom/didi/payment/pix/net/response/HistoryPixPayeeResp;", "getPixQrChannelList", "Lcom/didi/payment/pix/net/response/PixQrChannelResp;", "getPixTopUpOptions", "", "callBack", "Lcom/didi/payment/pix/net/response/PixTopUpOptionResp;", "orderCreate", "bodyParam", "Lcom/didi/payment/pix/net/response/PixOrderCreateResp;", "orderDetail", "queryParams", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp;", "orderHistory", "Lcom/didi/payment/pix/net/response/PixOrderHistoryListResp;", "orderRetry", "pollPixKeyStatus", "Lcom/didi/payment/pix/key/create/response/PollStatusResp;", "queryPixHomeData", "Lcom/didi/payment/pix/home/PixChannelResp;", "queryQrCode", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp;", "queryRefundDetail", "Lcom/didi/payment/pix/net/response/PixRefundResultResp;", "queryRefundOptions", "Lcom/didi/payment/pix/net/response/PixRefundExtrasResp;", "realtimePushTransfer", "requestAddress", "Lcom/didi/payment/pix/net/response/AddressZipCodeResp;", "transferOption", "Lcom/didi/payment/pix/net/response/PixTransferOption;", "verifyPixkey", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: PixNetModel.kt */
    public interface PixRpcService extends RpcService {
        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/bank/option")
        @Deserialization(GsonDeserializer.class)
        Object bankOptions(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixBankOptionResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/order/refund")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object doRefundOrder(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/gen/qr")
        @Deserialization(GsonDeserializer.class)
        Object genQrCode(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixQrCodeGenResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/payee")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object getHistoryPayee(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<HistoryPixPayeeResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/scan/channel")
        @Deserialization(GsonDeserializer.class)
        Object getPixQrChannelList(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixQrChannelResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/pix/toup/option")
        @Deserialization(GsonDeserializer.class)
        void getPixTopUpOptions(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixTopUpOptionResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/didipay/order")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object orderCreate(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixOrderCreateResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/order/detail")
        @Deserialization(GsonDeserializer.class)
        Object orderDetail(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixOrderDetailResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/order/list")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object orderHistory(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixOrderHistoryListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/retry")
        @Deserialization(GsonDeserializer.class)
        Object orderRetry(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/receive/status")
        @Deserialization(GsonDeserializer.class)
        Object pollPixKeyStatus(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PollStatusResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/channel")
        @Deserialization(GsonDeserializer.class)
        Object queryPixHomeData(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixChannelResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/query/qr")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object queryQrCode(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixQrCodeQueryResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/refund/detail")
        @Deserialization(GsonDeserializer.class)
        Object queryRefundDetail(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixRefundResultResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/refund/option")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object queryRefundOptions(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixRefundExtrasResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/push")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object realtimePushTransfer(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/address/detail")
        @Deserialization(GsonDeserializer.class)
        Object requestAddress(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AddressZipCodeResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/option")
        @Deserialization(GsonDeserializer.class)
        Object transferOption(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixTransferOption> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/detail")
        @Deserialization(GsonDeserializer.class)
        Object verifyPixkey(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyVerifyResp> callback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixNetModel(Context context) {
        super(context, PixRpcService.class);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void pollPixKeyStatus(int i, String str, int i2, RpcService.Callback<PollStatusResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("pix_key_type", Integer.valueOf(i));
        commonParam.put("pix_key_value", str);
        commonParam.put("pix_key_action", Integer.valueOf(i2));
        ((PixRpcService) getService()).pollPixKeyStatus(commonParam, callback);
    }

    public final void getPixChannel(RpcService.Callback<PixChannelResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((PixRpcService) getService()).queryPixHomeData(getCommonParam(getContext()), callback);
    }

    public final void getHistoryPayee(int i, int i2, RpcService.Callback<HistoryPixPayeeResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "ck");
        HashMap hashMap = new HashMap();
        hashMap.put("pageSize", Integer.valueOf(i));
        hashMap.put("startIndex", Integer.valueOf(i2));
        ((PixRpcService) getService()).getHistoryPayee(getCommonParam(getContext()), hashMap, callback);
    }

    public final void verifyPixKey(String str, boolean z, RpcService.Callback<PixKeyVerifyResp> callback) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(callback, "ck");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("key", str);
        map.put("isExact", Boolean.valueOf(z));
        hashMap.putAll(getCommonParam(getContext()));
        ((PixRpcService) getService()).verifyPixkey(hashMap, callback);
    }

    public final void getTransferOptionInfo(RpcService.Callback<PixTransferOption> callback) {
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap hashMap = new HashMap();
        hashMap.putAll(getCommonParam(getContext()));
        ((PixRpcService) getService()).transferOption(hashMap, callback);
    }

    public final void getOrderDetail(String str, RpcService.Callback<PixOrderDetailResp> callback) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap hashMap = new HashMap();
        hashMap.put("bizOrderId", str);
        hashMap.putAll(getCommonParam(getContext()));
        ((PixRpcService) getService()).orderDetail(hashMap, callback);
    }

    public final void orderRetry(String str, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        commonParam.put("order_id", str);
        ((PixRpcService) getService()).orderRetry(commonParam, callback);
    }

    public final void getPixQrChannelList(RpcService.Callback<PixQrChannelResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        hashMap.putAll(getCommonParam(getContext()));
        ((PixRpcService) getService()).getPixQrChannelList(hashMap, callback);
    }

    public final void queryPixQrCode(String str, RpcService.Callback<PixQrCodeQueryResp> callback) {
        Intrinsics.checkNotNullParameter(str, "qrCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        hashMap.put("QRCode", str);
        ((PixRpcService) getService()).queryQrCode(getCommonParam(getContext()), hashMap, callback);
    }

    public static /* synthetic */ void createTransferOrder$default(PixNetModel pixNetModel, int i, int i2, String str, String str2, String str3, RpcService.Callback callback, int i3, Object obj) {
        int i4 = (i3 & 2) != 0 ? 0 : i2;
        if ((i3 & 16) != 0) {
            str3 = null;
        }
        pixNetModel.createTransferOrder(i, i4, str, str2, str3, callback);
    }

    public final void createTransferOrder(int i, int i2, String str, String str2, String str3, RpcService.Callback<PixOrderCreateResp> callback) {
        Intrinsics.checkNotNullParameter(str, AdminPermission.METADATA);
        Intrinsics.checkNotNullParameter(str2, Const.PayParams.BIZ_CONTENT);
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        map.put(AdminPermission.METADATA, str);
        map.put("orderType", Integer.valueOf(i2));
        map.put(Const.PayParams.BIZ_CONTENT, str2);
        CharSequence charSequence = str3;
        if (!(charSequence == null || charSequence.length() == 0)) {
            map.put("passwordToken", str3);
        }
        ((PixRpcService) getService()).orderCreate(getCommonParam(getContext()), hashMap, callback);
    }

    public static /* synthetic */ void createPixTopUpOrder$default(PixNetModel pixNetModel, int i, int i2, String str, String str2, RpcService.Callback callback, int i3, Object obj) {
        int i4 = (i3 & 1) != 0 ? 650 : i;
        int i5 = (i3 & 2) != 0 ? 0 : i2;
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        pixNetModel.createPixTopUpOrder(i4, i5, str, str2, callback);
    }

    public final void createPixTopUpOrder(int i, int i2, String str, String str2, RpcService.Callback<PixOrderCreateResp> callback) {
        Intrinsics.checkNotNullParameter(str, AdminPermission.METADATA);
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put(DiminaLaunchModel.PRODUCT_LINE, Integer.valueOf(i));
        map.put("orderType", Integer.valueOf(i2));
        map.put(AdminPermission.METADATA, str);
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            map.put("passwordToken", str2);
        }
        ((PixRpcService) getService()).orderCreate(getCommonParam(getContext()), hashMap, callback);
    }

    public final void queryHistoryOrder(int i, int i2, int i3, RpcService.Callback<PixOrderHistoryListResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("startIndex", Integer.valueOf(i2));
        map.put("pageSize", 20);
        if (i3 >= 0) {
            map.put("order_type", Integer.valueOf(i3));
        }
        ((PixRpcService) getService()).orderHistory(getCommonParam(getContext()), hashMap, callback);
    }

    public final void refundTransferMoney(int i, String str, String str2, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "reasonId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("amount", Integer.valueOf(i));
        map.put("orderId", str);
        map.put("reasonId", str2);
        ((PixRpcService) getService()).doRefundOrder(getCommonParam(getContext()), hashMap, callback);
    }

    public final void queryRefundDetail(String str, RpcService.Callback<PixRefundResultResp> callback) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        commonParam.put("order_id", str);
        ((PixRpcService) getService()).queryRefundDetail(commonParam, callback);
    }

    public final void getBankOptionData(int i, RpcService.Callback<PixBankOptionResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        commonParam.put("source", Integer.valueOf(i));
        ((PixRpcService) getService()).bankOptions(commonParam, callback);
    }

    public final void genQRCode(String str, String str2, boolean z, int i, RpcService.Callback<PixQrCodeGenResp> callback) {
        Intrinsics.checkNotNullParameter(str, "amount");
        Intrinsics.checkNotNullParameter(str2, "desc");
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        Map map = commonParam;
        map.put("amount", str);
        map.put("desc", str2);
        map.put("modified", Boolean.valueOf(z));
        map.put(BlocksConst.WIDGET_PARAMS_IMAGE_WIDTH, Integer.valueOf(i));
        ((PixRpcService) getService()).genQrCode(commonParam, callback);
    }

    public final void queryRefundOptions(String str, RpcService.Callback<PixRefundExtrasResp> callback) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        hashMap.put("orderId", str);
        ((PixRpcService) getService()).queryRefundOptions(getCommonParam(getContext()), hashMap, callback);
    }

    public static /* synthetic */ void notifyTransferPush$default(PixNetModel pixNetModel, String str, int i, RpcService.Callback callback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        pixNetModel.notifyTransferPush(str, i, callback);
    }

    public final void notifyTransferPush(String str, int i, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("key", str);
        map.put("type", Integer.valueOf(i));
        ((PixRpcService) getService()).realtimePushTransfer(getCommonParam(getContext()), hashMap, callback);
    }

    public final void requestAddress(String str, RpcService.Callback<AddressZipCodeResp> callback) {
        Intrinsics.checkNotNullParameter(str, "zipCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("zip_code", str);
        ((PixRpcService) getService()).requestAddress(commonParam, callback);
    }

    public final void getPixTopUpOptions(RpcService.Callback<PixTopUpOptionResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((PixRpcService) getService()).getPixTopUpOptions(getCommonParam(getContext()), callback);
    }
}
