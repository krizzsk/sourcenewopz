package com.didi.payment.kycservice.net;

import android.content.Context;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.payment.base.interceptor.RequestMonitorInterceptor;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.net.WNetCallback;
import com.didi.payment.commonsdk.net.WNetModel;
import com.didi.payment.kycservice.key.create.response.PixKeyCreateResp;
import com.didi.payment.kycservice.key.create.response.PollStatusResp;
import com.didi.payment.kycservice.key.detail.response.PixKeyDetailResp;
import com.didi.payment.kycservice.key.list.response.PixKeyListResp;
import com.didi.payment.kycservice.key.migrateout.response.PixKeyMigrateOutListResp;
import com.didi.payment.kycservice.kyc.fragment.FullKycExtraFragment;
import com.didi.payment.kycservice.kyc.response.CPFCheckResp;
import com.didi.payment.kycservice.kyc.response.DoorGodResp;
import com.didi.payment.kycservice.kyc.response.FaceInitInfoResp;
import com.didi.payment.kycservice.kyc.response.FaceResultResp;
import com.didi.payment.kycservice.kyc.response.GuidesInfoResp;
import com.didi.payment.kycservice.kyc.response.HumanCheckResp;
import com.didi.payment.kycservice.kyc.response.JumioCheckResp;
import com.didi.payment.kycservice.kyc.response.PixChooseTypeListResp;
import com.didi.payment.kycservice.kyc.response.PixKeyMigrateInResp;
import com.didi.payment.kycservice.net.response.AddressZipCodeResp;
import com.didi.payment.kycservice.net.response.FaceSessionResp;
import com.didi.payment.kycservice.net.response.JumioCreateResultResp;
import com.didi.payment.kycservice.net.response.JumioGuideResp;
import com.didi.payment.kycservice.net.response.PixGetApplyInfoResp;
import com.didi.payment.kycservice.net.response.PixOrderDetailResp;
import com.didi.payment.kycservice.net.response.PixTopUpOptionResp;
import com.didi.payment.kycservice.net.response.SubmitKycInfoV1Resp;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.gson.GsonSerializer;
import com.didichuxing.foundation.net.rpc.http.FormSerializer;
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
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001gB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ4\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\rJ$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\rJ(\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rJ(\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001d0\rJ$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\rJ\u0014\u0010\u001f\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020 0\rJ$\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020$0\rJ$\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020'0\rJ\u001c\u0010(\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020)0\r2\u0006\u0010*\u001a\u00020\u000bJ\u0014\u0010+\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020,0\rJ\u0014\u0010-\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020.0\rJ$\u0010/\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002000\rJ\u0014\u00101\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002020\rJ\u0014\u00103\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020504J\u0014\u00106\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020.0\rJ\u0014\u00107\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002080\rJ,\u00109\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020;0\rJ\u001c\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020>0\rJ$\u0010?\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\rJ8\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020C0\rJ$\u0010D\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ,\u0010F\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\t2\u0006\u0010*\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020G0\rJ,\u0010H\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020$0\rJ$\u0010I\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020J04J$\u0010K\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ$\u0010L\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001c\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020O0\rJ$\u0010P\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\\\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJt\u0010Z\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000b2\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u001c\u0010`\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020a0\rJT\u0010b\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ6\u0010c\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020f0\r¨\u0006h"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/PixNetModel;", "Lcom/didi/payment/commonsdk/net/WNetModel;", "Lcom/didi/payment/kycservice/net/PixNetModel$PixRpcService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelPixKeyMigrateOut", "", "keyType", "", "keyVal", "", "callback", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "checkAuthCode", "code", "srcFrom", "Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp;", "checkCPF", "Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp;", "checkJumio", "count", "workflowId", "callBack", "Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp;", "createJumio", "guidanceSource", "fromPrimary", "Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp;", "createPixKey", "getApplyInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp;", "getFaceResult", "sessionId", "externalId", "Lcom/didi/payment/kycservice/kyc/response/FaceResultResp;", "getFaceSession", "bizCode", "Lcom/didi/payment/kycservice/net/response/FaceSessionResp;", "getGuidesInfo", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp;", "source", "getJumioGuide", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp;", "getPixIDTypeList", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp;", "getPixKeyDetail", "Lcom/didi/payment/kycservice/key/detail/response/PixKeyDetailResp;", "getPixKeyList", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp;", "getPixKeyMigrateOutList", "Lcom/didi/payment/commonsdk/net/WNetCallback;", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp;", "getPixKeyTypeList", "getPixTopUpOptions", "Lcom/didi/payment/kycservice/net/response/PixTopUpOptionResp;", "pollPixKeyStatus", "pollType", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "queryPixQrCode", "qrCode", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp;", "reqAuthCode", "reqDoorGodInitInfo", "faceType", "faceScene", "Lcom/didi/payment/kycservice/kyc/response/DoorGodResp;", "reqDoorGodResult", "keepId", "reqFaceInitInfo", "Lcom/didi/payment/kycservice/kyc/response/FaceInitInfoResp;", "reqFaceResult", "reqPixKeyMigrateIn", "Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp;", "reqPixKeyMigrateOut", "reqUnbindPixKey", "requestAddress", "zipCode", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp;", "setPixKeyDefault", "submitAddressVerification", "incomeType", "street", "number", "more", "district", "state", "city", "blockId", "submitFullKycInfo", "name", "birthDate", "taxId", "email", "motherName", "submitHumanCheck", "Lcom/didi/payment/kycservice/kyc/response/HumanCheckResp;", "submitKycAddressInfo", "submitKycInfoV1", "birth_date", "tax_id", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp;", "PixRpcService", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixNetModel.kt */
public final class PixNetModel extends WNetModel<PixRpcService> {

    @Timeout(connectTimeout = 30000)
    @Metadata(mo175977d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'JD\u0010\u000b\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH'J.\u0010\r\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH'J>\u0010\u000f\u001a\u00020\u00102$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00130\tH'J>\u0010\u0014\u001a\u00020\u00102$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00150\tH'JD\u0010\u0016\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH'J.\u0010\u0017\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00180\tH'J.\u0010\u0019\u001a\u00020\u00102\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH'J.\u0010\u001b\u001a\u00020\u00102\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001c0\tH'J>\u0010\u001d\u001a\u00020\u00102$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001e0\tH'J>\u0010\u001f\u001a\u00020\u00102$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020 0\tH'J.\u0010!\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\"0\tH'J.\u0010#\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020$0\tH'J.\u0010%\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020&0\tH'J.\u0010'\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020(0\tH'J.\u0010)\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\"0\tH'J>\u0010*\u001a\u00020\u00102$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020+0\tH'J>\u0010,\u001a\u00020\u00032$\b\u0001\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\tH'J.\u00100\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u0002010\tH'Jd\u00102\u001a\u00020\u00032$\b\u0001\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010.\u001a\b\u0012\u0004\u0012\u0002040\tH'JD\u00105\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\f0\tH'J.\u00106\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u0002070\tH'J.\u00108\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J.\u00109\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020:0\tH'J.\u0010;\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u001a0\tH'JD\u0010<\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020=0\tH'JD\u0010>\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'JD\u0010?\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'J.\u0010@\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020A0\tH'JD\u0010B\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'Jd\u0010C\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122$\b\u0001\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'Jd\u0010D\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122$\b\u0001\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'JD\u0010E\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020F0\tH'Jd\u0010G\u001a\u00020\u00032$\b\u0001\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122$\b\u0001\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0011j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003`\u00122\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH'JD\u0010H\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0001\u0010\b\u001a\b\u0012\u0004\u0012\u00020I0\tH'¨\u0006J"}, mo175978d2 = {"Lcom/didi/payment/kycservice/net/PixNetModel$PixRpcService;", "Lcom/didichuxing/foundation/rpc/RpcService;", "cancelPixKeyMigrateOut", "", "params", "", "", "body", "callBack", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "checkAuthCode", "Lcom/didi/payment/kycservice/key/create/response/PixKeyCreateResp;", "checkCPF", "Lcom/didi/payment/kycservice/kyc/response/CPFCheckResp;", "checkJumio", "", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lcom/didi/payment/kycservice/kyc/response/JumioCheckResp;", "createJumio", "Lcom/didi/payment/kycservice/net/response/JumioCreateResultResp;", "createPixKey", "getApplyInfo", "Lcom/didi/payment/kycservice/net/response/PixGetApplyInfoResp;", "getFaceResult", "Lcom/didi/payment/kycservice/kyc/response/FaceResultResp;", "getFaceSession", "Lcom/didi/payment/kycservice/net/response/FaceSessionResp;", "getGuides", "Lcom/didi/payment/kycservice/kyc/response/GuidesInfoResp;", "getJumioGuide", "Lcom/didi/payment/kycservice/net/response/JumioGuideResp;", "getPixIDTypeList", "Lcom/didi/payment/kycservice/kyc/response/PixChooseTypeListResp;", "getPixKeyDetail", "Lcom/didi/payment/kycservice/key/detail/response/PixKeyDetailResp;", "getPixKeyList", "Lcom/didi/payment/kycservice/key/list/response/PixKeyListResp;", "getPixKeyMigrateOutList", "Lcom/didi/payment/kycservice/key/migrateout/response/PixKeyMigrateOutListResp;", "getPixKeyTypeList", "getPixTopUpOptions", "Lcom/didi/payment/kycservice/net/response/PixTopUpOptionResp;", "orderDetail", "queryParams", "callback", "Lcom/didi/payment/kycservice/net/response/PixOrderDetailResp;", "pollPixKeyStatus", "Lcom/didi/payment/kycservice/key/create/response/PollStatusResp;", "queryQrCode", "commomnParams", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp;", "reqAuthCode", "reqDoorGodInfo", "Lcom/didi/payment/kycservice/kyc/response/DoorGodResp;", "reqDoorGodResult", "reqFaceInfo", "Lcom/didi/payment/kycservice/kyc/response/FaceInitInfoResp;", "reqFaceResult", "reqPixKeyMigrateIn", "Lcom/didi/payment/kycservice/kyc/response/PixKeyMigrateInResp;", "reqPixKeyMigrateOut", "reqUnbindPixKey", "requestAddress", "Lcom/didi/payment/kycservice/net/response/AddressZipCodeResp;", "setPixKeyDefault", "submitAddressVerification", "submitFullKycInfo", "submitHumanCheck", "Lcom/didi/payment/kycservice/kyc/response/HumanCheckResp;", "submitKycAddressInfo", "submitKycInfoV1", "Lcom/didi/payment/kycservice/net/response/SubmitKycInfoV1Resp;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    @Interception({RequestMonitorInterceptor.class})
    /* compiled from: PixNetModel.kt */
    public interface PixRpcService extends RpcService {
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/migrateOut/cancel")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object cancelPixKeyMigrateOut(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/verifyCode")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object checkAuthCode(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyCreateResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/cpf/check")
        @Deserialization(GsonDeserializer.class)
        Object checkCPF(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<CPFCheckResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/jumio/check")
        @Deserialization(GsonDeserializer.class)
        void checkJumio(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<JumioCheckResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/jumio/create")
        @Deserialization(GsonDeserializer.class)
        void createJumio(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<JumioCreateResultResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/create")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object createPixKey(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyCreateResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/kyc")
        @Deserialization(GsonDeserializer.class)
        Object getApplyInfo(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixGetApplyInfoResp> callback);

        @Get
        @Serialization(FormSerializer.class)
        @Path("/api/v0/identity/open/faceVerity/check")
        @Deserialization(GsonDeserializer.class)
        void getFaceResult(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<FaceResultResp> callback);

        @Get
        @Serialization(FormSerializer.class)
        @Path("/api/v0/identity/open/faceVerity")
        @Deserialization(GsonDeserializer.class)
        void getFaceSession(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<FaceSessionResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/guidance")
        @Deserialization(GsonDeserializer.class)
        void getGuides(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<GuidesInfoResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/jumio/channel")
        @Deserialization(GsonDeserializer.class)
        void getJumioGuide(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<JumioGuideResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/channel")
        @Deserialization(GsonDeserializer.class)
        Object getPixIDTypeList(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixChooseTypeListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/status")
        @Deserialization(GsonDeserializer.class)
        Object getPixKeyDetail(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyDetailResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/manage")
        @Deserialization(GsonDeserializer.class)
        Object getPixKeyList(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/migrateOut")
        @Deserialization(GsonDeserializer.class)
        Object getPixKeyMigrateOutList(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyMigrateOutListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/getKeyRegistration")
        @Deserialization(GsonDeserializer.class)
        Object getPixKeyTypeList(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixChooseTypeListResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/cashin/pix/toup/option")
        @Deserialization(GsonDeserializer.class)
        void getPixTopUpOptions(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixTopUpOptionResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/order/detail")
        @Deserialization(GsonDeserializer.class)
        Object orderDetail(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixOrderDetailResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/receive/status")
        @Deserialization(GsonDeserializer.class)
        Object pollPixKeyStatus(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<PollStatusResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/transfer/query/qr")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object queryQrCode(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixQrCodeQueryResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/reSend")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object reqAuthCode(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyCreateResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/doorgod")
        @Deserialization(GsonDeserializer.class)
        Object reqDoorGodInfo(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<DoorGodResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/doorgod/check")
        @Deserialization(GsonDeserializer.class)
        Object reqDoorGodResult(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/faceverity")
        @Deserialization(GsonDeserializer.class)
        Object reqFaceInfo(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<FaceInitInfoResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/faceverity/check")
        @Deserialization(GsonDeserializer.class)
        Object reqFaceResult(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<FaceResultResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/createPortability")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object reqPixKeyMigrateIn(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<PixKeyMigrateInResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/migrateOut/confirm")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object reqPixKeyMigrateOut(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/delete")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object reqUnbindPixKey(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Get
        @Serialization(GsonSerializer.class)
        @Path("/api/v0/address/detail")
        @Deserialization(GsonDeserializer.class)
        Object requestAddress(@QueryParameter("") Map<String, ? extends Object> map, @TargetThread(ThreadType.MAIN) RpcService.Callback<AddressZipCodeResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/pix/key/setDefault")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object setPixKeyDefault(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/verification/info/submit")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object submitAddressVerification(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/full/create")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object submitFullKycInfo(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/identity/appeal")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object submitHumanCheck(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<HumanCheckResp> callback);

        @Serialization(GsonSerializer.class)
        @Path("/api/v0/account/addition")
        @Post(contentType = "application/json")
        @Deserialization(GsonDeserializer.class)
        Object submitKycAddressInfo(@QueryParameter("") HashMap<String, Object> hashMap, @BodyParameter("") HashMap<String, Object> hashMap2, @TargetThread(ThreadType.MAIN) RpcService.Callback<WBaseResp> callback);

        @Serialization(FormSerializer.class)
        @Path("/api/v0/account")
        @Post(contentType = "application/x-www-form-urlencoded")
        @Deserialization(GsonDeserializer.class)
        Object submitKycInfoV1(@QueryParameter("") Map<String, ? extends Object> map, @BodyParameter("") Map<String, ? extends Object> map2, @TargetThread(ThreadType.MAIN) RpcService.Callback<SubmitKycInfoV1Resp> callback);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixNetModel(Context context) {
        super(context, PixRpcService.class);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void createPixKey(int i, String str, RpcService.Callback<PixKeyCreateResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).createPixKey(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void reqAuthCode(int i, String str, RpcService.Callback<PixKeyCreateResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).reqAuthCode(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void checkAuthCode(int i, String str, String str2, int i2, RpcService.Callback<PixKeyCreateResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(str2, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        linkedHashMap.put("pix_key_code", str2);
        linkedHashMap.put("pix_key_from", Integer.valueOf(i2));
        ((PixRpcService) getService()).checkAuthCode(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void getPixKeyDetail(int i, String str, RpcService.Callback<PixKeyDetailResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("pix_key_type", Integer.valueOf(i));
        commonParam.put("pix_key_value", str);
        ((PixRpcService) getService()).getPixKeyDetail(commonParam, callback);
    }

    public final void reqUnbindPixKey(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).reqUnbindPixKey(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void setPixKeyDefault(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).setPixKeyDefault(getCommonParam(getContext()), linkedHashMap, callback);
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

    public final void reqFaceInitInfo(int i, int i2, int i3, RpcService.Callback<FaceInitInfoResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("face_type", Integer.valueOf(i));
        commonParam.put("face_source", Integer.valueOf(i2));
        commonParam.put("face_scene", Integer.valueOf(i3));
        ((PixRpcService) getService()).reqFaceInfo(commonParam, callback);
    }

    public final void reqFaceResult(String str, int i, int i2, RpcService.Callback<FaceResultResp> callback) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("session_id", str);
        commonParam.put("face_source", Integer.valueOf(i));
        commonParam.put("face_scene", Integer.valueOf(i2));
        ((PixRpcService) getService()).reqFaceResult(commonParam, callback);
    }

    public final void submitHumanCheck(String str, RpcService.Callback<HumanCheckResp> callback) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("session_id", str);
        ((PixRpcService) getService()).submitHumanCheck(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public static /* synthetic */ void reqDoorGodInitInfo$default(PixNetModel pixNetModel, int i, int i2, String str, int i3, RpcService.Callback callback, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str = "2";
        }
        pixNetModel.reqDoorGodInitInfo(i, i2, str, (i4 & 8) != 0 ? 0 : i3, callback);
    }

    public final void reqDoorGodInitInfo(int i, int i2, String str, int i3, RpcService.Callback<DoorGodResp> callback) {
        Intrinsics.checkNotNullParameter(str, "guidanceSource");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("face_type", Integer.valueOf(i));
        commonParam.put("face_scene", Integer.valueOf(i2));
        commonParam.put("guidanceSource", str);
        commonParam.put("fromPrimary", Integer.valueOf(i3));
        ((PixRpcService) getService()).reqDoorGodInfo(commonParam, callback);
    }

    public final void reqDoorGodResult(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keepId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("keeper_id", str);
        commonParam.put("face_type", Integer.valueOf(i));
        ((PixRpcService) getService()).reqDoorGodResult(commonParam, callback);
    }

    public final void getGuidesInfo(RpcService.Callback<GuidesInfoResp> callback, String str) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(str, "source");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        Map map = commonParam;
        if ((str.length() == 0) || Intrinsics.areEqual((Object) str, (Object) "0")) {
            str = "2";
        }
        map.put("source", str);
        ((PixRpcService) getService()).getGuides(commonParam, callback);
    }

    public final void getApplyInfo(RpcService.Callback<PixGetApplyInfoResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("isNewKyc", 1);
        ((PixRpcService) getService()).getApplyInfo(commonParam, callback);
    }

    public static /* synthetic */ void submitKycInfoV1$default(PixNetModel pixNetModel, String str, String str2, String str3, String str4, RpcService.Callback callback, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = "2";
        }
        pixNetModel.submitKycInfoV1(str, str2, str3, str4, callback);
    }

    public final void submitKycInfoV1(String str, String str2, String str3, String str4, RpcService.Callback<SubmitKycInfoV1Resp> callback) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "birth_date");
        Intrinsics.checkNotNullParameter(str3, "tax_id");
        Intrinsics.checkNotNullParameter(str4, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", str);
        linkedHashMap.put("birth_date", str2);
        linkedHashMap.put("tax_id", str3);
        linkedHashMap.put("guidanceSource", str4);
        linkedHashMap.put("isNewKyc", 1);
        ((PixRpcService) getService()).submitKycInfoV1(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void getFaceSession(String str, String str2, RpcService.Callback<FaceSessionResp> callback) {
        Intrinsics.checkNotNullParameter(str, "bizCode");
        Intrinsics.checkNotNullParameter(str2, "externalId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("bizCode", str);
        commonParam.put("externalId", str2);
        ((PixRpcService) getService()).getFaceSession(commonParam, callback);
    }

    public final void getFaceResult(String str, String str2, RpcService.Callback<FaceResultResp> callback) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "externalId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("sessionId", str);
        commonParam.put("externalId", str2);
        ((PixRpcService) getService()).getFaceResult(commonParam, callback);
    }

    public final void getPixIDTypeList(RpcService.Callback<PixChooseTypeListResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((PixRpcService) getService()).getPixIDTypeList(getCommonParam(getContext()), callback);
    }

    public final void getPixKeyTypeList(RpcService.Callback<PixChooseTypeListResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((PixRpcService) getService()).getPixKeyTypeList(getCommonParam(getContext()), callback);
    }

    public final void getPixKeyList(RpcService.Callback<PixKeyListResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((PixRpcService) getService()).getPixKeyList(getCommonParam(getContext()), callback);
    }

    public final void checkCPF(int i, String str, RpcService.Callback<CPFCheckResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("pix_key_type", Integer.valueOf(i));
        commonParam.put("pix_key_value", str);
        ((PixRpcService) getService()).checkCPF(commonParam, callback);
    }

    public final void getPixKeyMigrateOutList(WNetCallback<PixKeyMigrateOutListResp> wNetCallback) {
        Intrinsics.checkNotNullParameter(wNetCallback, "callback");
        ((PixRpcService) getService()).getPixKeyMigrateOutList(getCommonParam(getContext()), wNetCallback);
    }

    public final void reqPixKeyMigrateOut(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).reqPixKeyMigrateOut(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void cancelPixKeyMigrateOut(int i, String str, RpcService.Callback<WBaseResp> callback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).cancelPixKeyMigrateOut(getCommonParam(getContext()), linkedHashMap, callback);
    }

    public final void reqPixKeyMigrateIn(int i, String str, WNetCallback<PixKeyMigrateInResp> wNetCallback) {
        Intrinsics.checkNotNullParameter(str, "keyVal");
        Intrinsics.checkNotNullParameter(wNetCallback, "callback");
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pix_key_type", Integer.valueOf(i));
        linkedHashMap.put("pix_key_value", str);
        ((PixRpcService) getService()).reqPixKeyMigrateIn(getCommonParam(getContext()), linkedHashMap, wNetCallback);
    }

    public final void queryPixQrCode(String str, RpcService.Callback<PixQrCodeQueryResp> callback) {
        Intrinsics.checkNotNullParameter(str, "qrCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        hashMap.put("QRCode", str);
        ((PixRpcService) getService()).queryQrCode(getCommonParam(getContext()), hashMap, callback);
    }

    public final void requestAddress(String str, RpcService.Callback<AddressZipCodeResp> callback) {
        Intrinsics.checkNotNullParameter(str, "zipCode");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Map commonParam = getCommonParam(getContext());
        commonParam.put("zip_code", str);
        ((PixRpcService) getService()).requestAddress(commonParam, callback);
    }

    public final void submitKycAddressInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, RpcService.Callback<WBaseResp> callback) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        String str16 = str8;
        RpcService.Callback<WBaseResp> callback2 = callback;
        Intrinsics.checkNotNullParameter(str9, "incomeType");
        Intrinsics.checkNotNullParameter(str10, "zipCode");
        Intrinsics.checkNotNullParameter(str11, "street");
        Intrinsics.checkNotNullParameter(str12, "number");
        Intrinsics.checkNotNullParameter(str13, "more");
        Intrinsics.checkNotNullParameter(str14, ParamKeys.PARAM_DISTRICT);
        Intrinsics.checkNotNullParameter(str15, "state");
        Intrinsics.checkNotNullParameter(str16, "city");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("incomeType", str9);
        map.put("zipCode", str10);
        map.put("streetName", str11);
        map.put("number", str12);
        map.put("complement", str13);
        map.put("neighborhood", str14);
        map.put("state", str15);
        map.put("city", str16);
        map.put("isNewKyc", 1);
        ((PixRpcService) getService()).submitKycAddressInfo(getCommonParam(getContext()), hashMap, callback2);
    }

    public final void submitAddressVerification(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, RpcService.Callback<WBaseResp> callback) {
        String str10 = str;
        String str11 = str2;
        String str12 = str3;
        String str13 = str4;
        String str14 = str5;
        String str15 = str6;
        String str16 = str7;
        String str17 = str8;
        Intrinsics.checkNotNullParameter(str10, "incomeType");
        Intrinsics.checkNotNullParameter(str11, "zipCode");
        Intrinsics.checkNotNullParameter(str12, "street");
        Intrinsics.checkNotNullParameter(str13, "number");
        Intrinsics.checkNotNullParameter(str14, "more");
        Intrinsics.checkNotNullParameter(str15, ParamKeys.PARAM_DISTRICT);
        Intrinsics.checkNotNullParameter(str16, "state");
        Intrinsics.checkNotNullParameter(str17, "city");
        Intrinsics.checkNotNullParameter(str9, FullKycExtraFragment.BLOCK_ID);
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("incomeType", str10);
        map.put("zipCode", str11);
        map.put("streetName", str12);
        map.put("number", str13);
        map.put("complement", str14);
        map.put("neighborhood", str15);
        map.put("state", str16);
        map.put("city", str17);
        map.put(FullKycExtraFragment.BLOCK_ID, str9);
        ((PixRpcService) getService()).submitAddressVerification(getCommonParam(getContext()), hashMap, callback);
    }

    public final void submitFullKycInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, RpcService.Callback<WBaseResp> callback) {
        String str13 = str;
        String str14 = str2;
        String str15 = str3;
        String str16 = str4;
        String str17 = str6;
        String str18 = str7;
        String str19 = str8;
        String str20 = str9;
        String str21 = str10;
        String str22 = str11;
        String str23 = str12;
        Intrinsics.checkNotNullParameter(str13, "name");
        Intrinsics.checkNotNullParameter(str14, "birthDate");
        Intrinsics.checkNotNullParameter(str15, "taxId");
        Intrinsics.checkNotNullParameter(str16, "email");
        Intrinsics.checkNotNullParameter(str5, "motherName");
        Intrinsics.checkNotNullParameter(str17, "zipCode");
        Intrinsics.checkNotNullParameter(str18, "street");
        Intrinsics.checkNotNullParameter(str19, "number");
        Intrinsics.checkNotNullParameter(str20, "more");
        Intrinsics.checkNotNullParameter(str21, ParamKeys.PARAM_DISTRICT);
        Intrinsics.checkNotNullParameter(str22, "state");
        Intrinsics.checkNotNullParameter(str23, "city");
        Intrinsics.checkNotNullParameter(callback, "callback");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("name", str13);
        map.put("birth_date", str14);
        map.put("tax_id", str15);
        map.put("email", str16);
        map.put("motherName", str5);
        map.put("zipCode", str17);
        map.put("streetName", str18);
        map.put("number", str19);
        map.put("complement", str20);
        map.put("neighborhood", str21);
        map.put("state", str22);
        map.put("city", str23);
        ((PixRpcService) getService()).submitFullKycInfo(getCommonParam(getContext()), hashMap, callback);
    }

    public final void getPixTopUpOptions(RpcService.Callback<PixTopUpOptionResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((PixRpcService) getService()).getPixTopUpOptions(getCommonParam(getContext()), callback);
    }

    public static /* synthetic */ void createJumio$default(PixNetModel pixNetModel, String str, int i, RpcService.Callback callback, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "2";
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        pixNetModel.createJumio(str, i, callback);
    }

    public final void createJumio(String str, int i, RpcService.Callback<JumioCreateResultResp> callback) {
        Intrinsics.checkNotNullParameter(str, "guidanceSource");
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        Map map = commonParam;
        map.put("guidanceSource", str);
        map.put("fromPrimary", Integer.valueOf(i));
        ((PixRpcService) getService()).createJumio(commonParam, callback);
    }

    public static /* synthetic */ void checkJumio$default(PixNetModel pixNetModel, int i, String str, RpcService.Callback callback, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        pixNetModel.checkJumio(i, str, callback);
    }

    public final void checkJumio(int i, String str, RpcService.Callback<JumioCheckResp> callback) {
        Intrinsics.checkNotNullParameter(str, "workflowId");
        Intrinsics.checkNotNullParameter(callback, "callBack");
        HashMap<String, Object> commonParam = getCommonParam(getContext());
        Map map = commonParam;
        map.put("workflowId", str);
        map.put(Const.PageParams.COUNT, Integer.valueOf(i));
        ((PixRpcService) getService()).checkJumio(commonParam, callback);
    }

    public final void getJumioGuide(RpcService.Callback<JumioGuideResp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callBack");
        ((PixRpcService) getService()).getJumioGuide(getCommonParam(getContext()), callback);
    }
}
