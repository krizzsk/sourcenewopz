package com.didi.global.fintech.cashier.threeds;

import com.adyen.checkout.components.ActionComponentData;
import com.didi.global.fintech.cashier.model.net.request.PrepayRequest;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.threeds.spi.GlobalCashier3DSActionHandlerKt;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsResultOf3ds;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J5\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\u000e\"\u0004\b\u0001\u0010\r2\u0006\u0010\n\u001a\u0002H\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\r0\u0010H\u0007¢\u0006\u0002\u0010\u0011JI\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\r2\u0006\u0010\u0005\u001a\u0002H\u00122\u0006\u0010\u0007\u001a\u0002H\u00132\u0018\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\r0\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/threeds/ThreeDSDataParser;", "", "()V", "ActionComponentDataToAdyen3DSModel", "Lcom/didi/global/fintech/cashier/model/net/response/GlobalCashierAdyen3DSModel;", "src1", "Lcom/adyen/checkout/components/ActionComponentData;", "src2", "ThreedsCybsDataToThreeDSV2", "Lcom/didi/global/fintech/cashier/model/net/request/PrepayRequest$ThreeDSV2;", "src", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;", "parseData", "R", "T", "transformer", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "T1", "T2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "cashier_threeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreeDSDataParser.kt */
public final class ThreeDSDataParser {
    public static final ThreeDSDataParser INSTANCE = new ThreeDSDataParser();

    private ThreeDSDataParser() {
    }

    @JvmStatic
    public static final <T, R> R parseData(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "transformer");
        return function1.invoke(t);
    }

    @JvmStatic
    public static final <T1, T2, R> R parseData(T1 t1, T2 t2, Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "transformer");
        return function2.invoke(t1, t2);
    }

    @JvmStatic
    public static final PrepayRequest.ThreeDSV2 ThreedsCybsDataToThreeDSV2(ThreedsCybsDataResponse threedsCybsDataResponse) {
        String str;
        Boolean bool;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        ThreedsResultOf3ds resultOf3ds;
        ThreedsResultOf3ds resultOf3ds2;
        ThreedsResultOf3ds resultOf3ds3;
        ThreedsResultOf3ds resultOf3ds4;
        ThreedsResultOf3ds resultOf3ds5;
        PrepayRequest.ThreeDSV2 threeDSV2 = new PrepayRequest.ThreeDSV2();
        String str9 = null;
        if (threedsCybsDataResponse == null) {
            str = null;
        } else {
            str = threedsCybsDataResponse.getDescription();
        }
        threeDSV2.setDescription(str);
        if (threedsCybsDataResponse == null) {
            bool = null;
        } else {
            bool = threedsCybsDataResponse.getLiabilityShift();
        }
        threeDSV2.setLiabilityShift(bool);
        if (threedsCybsDataResponse == null) {
            str2 = null;
        } else {
            str2 = threedsCybsDataResponse.getStatus();
        }
        threeDSV2.setStatus(str2);
        if (threedsCybsDataResponse == null) {
            str3 = null;
        } else {
            str3 = threedsCybsDataResponse.getVersion();
        }
        threeDSV2.setVersion(str3);
        if (threedsCybsDataResponse == null) {
            str4 = null;
        } else {
            str4 = threedsCybsDataResponse.getChannelNameOf3ds();
        }
        threeDSV2.setChannelNameOf3ds(str4);
        PrepayRequest.ThreeDSV2Result threeDSV2Result = new PrepayRequest.ThreeDSV2Result((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
        if (threedsCybsDataResponse == null || (resultOf3ds5 = threedsCybsDataResponse.getResultOf3ds()) == null) {
            str5 = null;
        } else {
            str5 = resultOf3ds5.getAuthenResponse();
        }
        threeDSV2Result.setAuthenResponse(str5);
        if (threedsCybsDataResponse == null || (resultOf3ds4 = threedsCybsDataResponse.getResultOf3ds()) == null) {
            str6 = null;
        } else {
            str6 = resultOf3ds4.getCavv();
        }
        threeDSV2Result.setCavv(str6);
        if (threedsCybsDataResponse == null || (resultOf3ds3 = threedsCybsDataResponse.getResultOf3ds()) == null) {
            str7 = null;
        } else {
            str7 = resultOf3ds3.getEci();
        }
        threeDSV2Result.setEci(str7);
        if (threedsCybsDataResponse == null || (resultOf3ds2 = threedsCybsDataResponse.getResultOf3ds()) == null) {
            str8 = null;
        } else {
            str8 = resultOf3ds2.getTransactionId();
        }
        threeDSV2Result.setTransactionId(str8);
        if (!(threedsCybsDataResponse == null || (resultOf3ds = threedsCybsDataResponse.getResultOf3ds()) == null)) {
            str9 = resultOf3ds.getXid();
        }
        threeDSV2Result.setXid(str9);
        Unit unit = Unit.INSTANCE;
        threeDSV2.setResultOf3ds(threeDSV2Result);
        return threeDSV2;
    }

    @JvmStatic
    public static final GlobalCashierAdyen3DSModel ActionComponentDataToAdyen3DSModel(ActionComponentData actionComponentData, GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel) {
        String str;
        String str2;
        String str3;
        Integer num;
        GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel2 = new GlobalCashierAdyen3DSModel((String) null, (String) null, (String) null, (Integer) null, (Map) null, (String) null, 63, (DefaultConstructorMarker) null);
        String str4 = null;
        if (globalCashierAdyen3DSModel == null) {
            str = null;
        } else {
            str = globalCashierAdyen3DSModel.getReference();
        }
        globalCashierAdyen3DSModel2.setReference(str);
        if (globalCashierAdyen3DSModel == null) {
            str2 = null;
        } else {
            str2 = globalCashierAdyen3DSModel.getVendor();
        }
        globalCashierAdyen3DSModel2.setVendor(str2);
        if (globalCashierAdyen3DSModel == null) {
            str3 = null;
        } else {
            str3 = globalCashierAdyen3DSModel.getShopper();
        }
        globalCashierAdyen3DSModel2.setShopper(str3);
        if (globalCashierAdyen3DSModel == null) {
            num = null;
        } else {
            num = globalCashierAdyen3DSModel.getChannelId();
        }
        globalCashierAdyen3DSModel2.setChannelId(num);
        if (actionComponentData != null) {
            str4 = GlobalCashier3DSActionHandlerKt.trans(actionComponentData);
        }
        globalCashierAdyen3DSModel2.setAuth_details(str4);
        return globalCashierAdyen3DSModel2;
    }
}
