package com.didi.entrega.bill;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.event.EventConst;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.customer.foundation.util.ApiErrorUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u001f\u0010\u0016\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015JC\u0010\u001a\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\u0006\u0010)\u001a\u00020\u0007J\"\u0010*\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u00122\b\u0010,\u001a\u0004\u0018\u00010\u0012J\u0006\u0010-\u001a\u00020\u0007J\u000e\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004J\u0016\u00100\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J\u0016\u00103\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, mo175978d2 = {"Lcom/didi/entrega/bill/BillOmegaHelper;", "", "()V", "mRfType", "", "mToType", "billGlideContextError", "", "buildCommonParams", "builder", "Lcom/didi/entrega/customer/foundation/tracker/OmegaTracker$Builder;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "needAdr", "", "getAddressFillType", "isPoiReturn", "addressEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "tracePayMethodAddCardCk", "cartId", "", "tracePayMethodCK", "channelId", "(Ljava/lang/String;Ljava/lang/Integer;)V", "tracePayMethodSW", "tracePayResult", "isSuc", "orderId", "errorCode", "errorMsg", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "trackBillClick", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "clickType", "trackBillInfoError", "ex", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "trackBillPoiReceiverCk", "trackBillPoiReturnCk", "trackBillPoiSenderCk", "trackBillPoiSw", "senderAddress", "receiverAddress", "trackBillPoiTransferCk", "trackBillRecover", "eventType", "trackBillSw", "pageSource", "trackBillUpdateError", "trackPayClick", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillOmegaHelper.kt */
public final class BillOmegaHelper {
    public static final BillOmegaHelper INSTANCE = new BillOmegaHelper();

    /* renamed from: a */
    private static int f19462a;

    /* renamed from: b */
    private static int f19463b;

    public final void billGlideContextError() {
    }

    private BillOmegaHelper() {
    }

    /* renamed from: a */
    static /* synthetic */ void m14569a(BillOmegaHelper billOmegaHelper, OmegaTracker.Builder builder, BillEntity billEntity, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        billOmegaHelper.m14570a(builder, billEntity, z);
    }

    /* renamed from: a */
    private final void m14570a(OmegaTracker.Builder builder, BillEntity billEntity, boolean z) {
        Map mapOf = MapsKt.mapOf(TuplesKt.m42317to(16, z ? new BillOmegaHelper$buildCommonParams$1(builder) : null), TuplesKt.m42317to(17, new BillOmegaHelper$buildCommonParams$addPackageInfoAction$1(builder)), TuplesKt.m42317to(4, new BillOmegaHelper$buildCommonParams$addPayChannelAction$1(builder)), TuplesKt.m42317to(6, new BillOmegaHelper$buildCommonParams$addPriceInfoAction$1(builder)), TuplesKt.m42317to(7, new BillOmegaHelper$buildCommonParams$addTipInfoAction$1(builder)), TuplesKt.m42317to(10, new BillOmegaHelper$buildCommonParams$addCouponAction$1(builder)));
        List<BillSectionEntity> sections = billEntity.getSections();
        if (sections != null) {
            for (BillSectionEntity components : sections) {
                List<BillComponentEntity> components2 = components.getComponents();
                if (components2 != null) {
                    for (BillComponentEntity billComponentEntity : components2) {
                        Function1 function1 = (Function1) mapOf.get(Integer.valueOf(billComponentEntity.getType()));
                        if (function1 != null) {
                            function1.invoke(billComponentEntity);
                        }
                    }
                }
            }
        }
    }

    public final void trackBillSw(BillEntity billEntity, int i) {
        Intrinsics.checkNotNullParameter(billEntity, "entity");
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_SW);
        String cartId = billEntity.getCartId();
        if (cartId == null) {
            cartId = "";
        }
        create.addEventParam("cart_id", cartId);
        create.addEventParam("discount_price", Integer.valueOf(billEntity.getPriceSumOri() - billEntity.getRealPayPrice()));
        create.addEventParam(ParamConst.PARAM_TOTAL_PRICE, Integer.valueOf(billEntity.getPriceSumOri()));
        create.addEventParam("price", Integer.valueOf(billEntity.getRealPayPrice()));
        create.addEventParam("page_source", Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(create, "builder");
        m14569a(this, create, billEntity, false, 4, (Object) null);
        create.build().track();
    }

    public final void trackBillClick(ScopeContext scopeContext, String str) {
        Intrinsics.checkNotNullParameter(str, "clickType");
        String str2 = "";
        String cartId = scopeContext != null ? BillRepo.Companion.get(scopeContext).getCartId() : str2;
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_UPDATE_CK);
        if (cartId != null) {
            str2 = cartId;
        }
        create.addEventParam("cart_id", str2).addEventParam("click_type", str).build().track();
    }

    public final void trackPayClick(BillEntity billEntity, int i) {
        Intrinsics.checkNotNullParameter(billEntity, "entity");
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_PAY_BTN_CK);
        String cartId = billEntity.getCartId();
        if (cartId == null) {
            cartId = "";
        }
        create.addEventParam("cart_id", cartId);
        Intrinsics.checkNotNullExpressionValue(create, "builder");
        m14570a(create, billEntity, false);
        create.addEventParam("discount_price", Integer.valueOf(billEntity.getPriceSumOri() - billEntity.getRealPayPrice()));
        create.addEventParam(ParamConst.PARAM_TOTAL_PRICE, Integer.valueOf(billEntity.getPriceSumOri()));
        create.addEventParam("price", Integer.valueOf(billEntity.getRealPayPrice()));
        create.addEventParam("page_source", Integer.valueOf(i));
        create.build().track();
    }

    public static /* synthetic */ void tracePayResult$default(BillOmegaHelper billOmegaHelper, String str, Integer num, String str2, Integer num2, String str3, int i, Object obj) {
        String str4 = (i & 4) != 0 ? "" : str2;
        if ((i & 8) != 0) {
            num2 = 0;
        }
        billOmegaHelper.tracePayResult(str, num, str4, num2, (i & 16) != 0 ? "" : str3);
    }

    public final void tracePayResult(String str, Integer num, String str2, Integer num2, String str3) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_PAY_CALLBACK_CK);
        if (str == null) {
            str = "";
        }
        OmegaTracker.Builder addEventParam = create.addEventParam("cart_id", str);
        if (str2 == null) {
            str2 = "";
        }
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("order_id", str2).addEventParam("is_suc", Integer.valueOf(BillExtKt.orZero(num))).addEventParam("error_code", Integer.valueOf(BillExtKt.orZero(num2)));
        if (str3 == null) {
            str3 = "";
        }
        addEventParam2.addEventParam("error_msg", str3).build().track();
    }

    public final void tracePayMethodSW(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_PAY_METHOD_COMMON_SW);
        if (str == null) {
            str = "";
        }
        create.addEventParam("cart_id", str).build().track();
    }

    public final void tracePayMethodCK(String str, Integer num) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_PAY_METHOD_COMMON_CK);
        if (str == null) {
            str = "";
        }
        create.addEventParam("cart_id", str).addEventParam("pay_method", Integer.valueOf(BillExtKt.orZero(num))).build().track();
    }

    public final void tracePayMethodAddCardCk(String str) {
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_PAY_METHOD_ADD_CARD_CK);
        if (str == null) {
            str = "";
        }
        create.addEventParam("cart_id", str).build().track();
    }

    public final void trackBillInfoError(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.BILL_INFO_ERROR).addErrorType(ApiErrorUtil.Companion.getErrorType(String.valueOf(sFRpcException.getCode())));
        String message = sFRpcException.getMessage();
        if (message == null) {
            message = "";
        }
        addErrorType.addErrorMsg(message).addModuleName("bill").build().trackError();
    }

    public final void trackBillUpdateError(SFRpcException sFRpcException) {
        Intrinsics.checkNotNullParameter(sFRpcException, "ex");
        ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.BILL_UPDATE_ERROR).addErrorType(ApiErrorUtil.Companion.getErrorType(String.valueOf(sFRpcException.getCode())));
        String message = sFRpcException.getMessage();
        if (message == null) {
            message = "";
        }
        addErrorType.addErrorMsg(message).addModuleName("bill").build().trackError();
    }

    public final void trackBillRecover(int i) {
        OmegaTracker.Builder.create(ErrorConst.ErrorName.BILL_RECOVER).addEventParam("event_type", Integer.valueOf(i)).build().track();
    }

    public final void trackBillPoiSw(boolean z, AddressEntity addressEntity, AddressEntity addressEntity2) {
        int a = m14568a(z, addressEntity);
        int a2 = m14568a(z, addressEntity2);
        OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Bill.BILL_POI_SW);
        if (addressEntity != null) {
            create.addEventParam(ParamConst.PARAM_FR_POI_FILL_TYPE, Integer.valueOf(a));
            f19462a = a;
        }
        if (addressEntity2 != null) {
            create.addEventParam(ParamConst.PARAM_TO_POI_FILL_TYPE, Integer.valueOf(a2));
            f19463b = a2;
        }
        create.build().track();
    }

    /* renamed from: a */
    private final int m14568a(boolean z, AddressEntity addressEntity) {
        boolean z2;
        boolean z3 = true;
        if (z) {
            if ((addressEntity == null ? null : addressEntity.poi) != null && !TextUtils.isEmpty(addressEntity.poi.poiId)) {
                if (TextUtils.isEmpty(addressEntity.phone)) {
                    return 1;
                }
                if (addressEntity.bizLine == 2) {
                    return 2;
                }
                if (addressEntity.bizLine == 1) {
                    return 3;
                }
            }
            return 0;
        }
        if (addressEntity != null && addressEntity.bizLine == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return 2;
        }
        if (addressEntity == null || addressEntity.bizLine != 1) {
            z3 = false;
        }
        if (z3) {
            return 3;
        }
        return 4;
    }

    public final void trackBillPoiReturnCk() {
        OmegaTracker.Builder.create(EventConst.Bill.BILL_POI_RETURN_CK).addEventParam(ParamConst.PARAM_FR_POI_FILL_TYPE, Integer.valueOf(f19462a)).addEventParam(ParamConst.PARAM_TO_POI_FILL_TYPE, Integer.valueOf(f19463b)).build().track();
    }

    public final void trackBillPoiTransferCk() {
        OmegaTracker.Builder.create(EventConst.Bill.BILL_POI_TRANSFER_CK).build().track();
    }

    public final void trackBillPoiSenderCk() {
        OmegaTracker.Builder.create(EventConst.Bill.BILL_POI_SENDER_CK).build().track();
    }

    public final void trackBillPoiReceiverCk() {
        OmegaTracker.Builder.create(EventConst.Bill.BILL_POI_RECEIVER_CK).build().track();
    }
}
