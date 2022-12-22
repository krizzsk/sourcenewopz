package com.didi.entrega.order;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.rpc.ApiErrorConst;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.order.CreateOrderErrorHandler;
import com.didi.entrega.security.model.RiskControlModel;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000 '2\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J.\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&J\u001a\u0010\u001c\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\u001d\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH&J\b\u0010 \u001a\u00020\bH&J\b\u0010!\u001a\u00020\bH&J\u0012\u0010\"\u001a\u00020\b2\b\b\u0002\u0010#\u001a\u00020$H&J\u0012\u0010%\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006("}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderErrorHandler;", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "closeBill", "", "consumeError", "errorModel", "Lcom/didi/entrega/order/CreateOrderErrorHandler$Companion$PayErrorModel;", "dealDuplicated", "existingOrderId", "", "dealRiskControl", "msg", "risk", "Lcom/didi/entrega/security/model/RiskControlModel;", "cid", "doCall", "phoneNumber", "goToOrder", "orderId", "goToPayMethod", "cartId", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "gotoPayment", "gotoSecurity", "bundle", "Landroid/os/Bundle;", "login", "popToRoot", "recreateOrder", "duplicateOrderConfirm", "", "refreshBill", "validateCard", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderErrorHandler.kt */
public abstract class CreateOrderErrorHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ScopeContext scopeContext;

    /* access modifiers changed from: private */
    /* renamed from: dealRiskControl$lambda-7  reason: not valid java name */
    public static final void m46381dealRiskControl$lambda7(RFDialog rFDialog) {
    }

    public abstract void closeBill();

    public abstract void doCall(String str);

    public abstract void goToOrder(String str);

    public abstract void goToPayMethod(String str, PayChannel payChannel);

    public abstract void gotoSecurity(String str, Bundle bundle);

    public abstract void login();

    public abstract void popToRoot();

    public abstract void recreateOrder(int i);

    public abstract void refreshBill(String str);

    public abstract void validateCard(PayChannel payChannel);

    public CreateOrderErrorHandler(ScopeContext scopeContext2) {
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        this.scopeContext = scopeContext2;
    }

    public final ScopeContext getScopeContext() {
        return this.scopeContext;
    }

    public static /* synthetic */ void recreateOrder$default(CreateOrderErrorHandler createOrderErrorHandler, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            createOrderErrorHandler.recreateOrder(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: recreateOrder");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.didi.entrega.security.model.RiskControlModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.didi.entrega.security.model.RiskControlModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.didi.entrega.security.model.RiskControlModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.didi.entrega.security.model.RiskControlModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.didi.entrega.security.model.RiskControlModel} */
    /* JADX WARNING: type inference failed for: r1v11, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008f, code lost:
        login();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
        r0 = r5.getRiskMsg();
        r2 = r5.getOrderEntity();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ad, code lost:
        if (r2 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b0, code lost:
        r1 = r2.getRiskControl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b4, code lost:
        dealRiskControl(r0, r1, r5.getCartId(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bc, code lost:
        com.didi.entrega.customer.foundation.util.DialogUtil.showErrorDialog(r5.getMsg(), getScopeContext());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c8, code lost:
        gotoPayment(r5.getMsg(), r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void consumeError(com.didi.entrega.order.CreateOrderErrorHandler.Companion.PayErrorModel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "errorModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "tech_sailing_c_e_cart_createorder_error"
            com.didi.entrega.customer.foundation.tracker.error.ErrorTracker$Builder r0 = com.didi.entrega.customer.foundation.tracker.error.ErrorTracker.create(r0)
            com.didi.entrega.customer.foundation.util.ApiErrorUtil$Companion r1 = com.didi.entrega.customer.foundation.util.ApiErrorUtil.Companion
            int r2 = r5.getCode()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r1 = r1.getErrorType(r2)
            com.didi.entrega.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addErrorType(r1)
            java.lang.String r1 = r5.getPreOrderId()
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r1 = r2
        L_0x0028:
            java.lang.String r3 = "pre_order_id"
            com.didi.entrega.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addParam(r3, r1)
            java.lang.String r1 = r5.getMsg()
            if (r1 == 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r1 = r2
        L_0x0037:
            com.didi.entrega.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addErrorMsg(r1)
            java.lang.String r1 = "bill"
            com.didi.entrega.customer.foundation.tracker.error.ErrorTracker$Builder r0 = r0.addModuleName(r1)
            com.didi.entrega.customer.foundation.tracker.error.ErrorTracker r0 = r0.build()
            r0.trackError()
            int r0 = r5.getCode()
            switch(r0) {
                case 41038: goto L_0x00c8;
                case 41039: goto L_0x00bc;
                default: goto L_0x004f;
            }
        L_0x004f:
            r1 = 0
            switch(r0) {
                case 41044: goto L_0x00bc;
                case 41060: goto L_0x00a5;
                case 41066: goto L_0x00a5;
                case 46900: goto L_0x0093;
                case 50004: goto L_0x008f;
                default: goto L_0x0053;
            }
        L_0x0053:
            switch(r0) {
                case 41051: goto L_0x0083;
                case 41052: goto L_0x0083;
                case 41053: goto L_0x0083;
                case 41054: goto L_0x0083;
                case 41055: goto L_0x0083;
                default: goto L_0x0056;
            }
        L_0x0056:
            switch(r0) {
                case 41063: goto L_0x0078;
                case 41064: goto L_0x00a5;
                default: goto L_0x0059;
            }
        L_0x0059:
            switch(r0) {
                case 41400: goto L_0x00c8;
                case 41401: goto L_0x0070;
                case 41402: goto L_0x00bc;
                case 41403: goto L_0x00c8;
                case 41404: goto L_0x00bc;
                case 41405: goto L_0x00bc;
                case 41406: goto L_0x00bc;
                case 41407: goto L_0x00bc;
                case 41408: goto L_0x00bc;
                case 41409: goto L_0x00bc;
                case 41410: goto L_0x00bc;
                case 41411: goto L_0x00bc;
                case 41412: goto L_0x00bc;
                case 41413: goto L_0x00bc;
                case 41414: goto L_0x00bc;
                case 41415: goto L_0x00bc;
                default: goto L_0x005c;
            }
        L_0x005c:
            switch(r0) {
                case 50001: goto L_0x008f;
                case 50002: goto L_0x008f;
                default: goto L_0x005f;
            }
        L_0x005f:
            java.lang.String r0 = r5.getMsg()
            com.didi.app.nova.skeleton.ScopeContext r1 = r4.getScopeContext()
            com.didi.entrega.order.-$$Lambda$CreateOrderErrorHandler$5bU-vq6XalxsaKeUmkFK3MuMiDM r2 = new com.didi.entrega.order.-$$Lambda$CreateOrderErrorHandler$5bU-vq6XalxsaKeUmkFK3MuMiDM
            r2.<init>(r5)
            com.didi.entrega.customer.foundation.util.DialogUtil.showErrorDialog(r0, r1, r2)
            goto L_0x00cf
        L_0x0070:
            java.lang.String r0 = r5.getRiskMsg()
            r4.gotoPayment(r0, r5)
            goto L_0x00cf
        L_0x0078:
            com.didi.entrega.customer.foundation.rpc.entity.PayChannel r5 = r5.getPayChannel()
            if (r5 != 0) goto L_0x007f
            goto L_0x00cf
        L_0x007f:
            r4.validateCard(r5)
            goto L_0x00cf
        L_0x0083:
            java.lang.String r5 = r5.getRiskMsg()
            com.didi.app.nova.skeleton.ScopeContext r0 = r4.getScopeContext()
            com.didi.entrega.customer.foundation.util.DialogUtil.showErrorDialog(r5, r0)
            goto L_0x00cf
        L_0x008f:
            r4.login()
            goto L_0x00cf
        L_0x0093:
            com.didi.entrega.foundation.rpc.entity.OrderCreateEntity r5 = r5.getOrderEntity()
            if (r5 != 0) goto L_0x009a
            goto L_0x009e
        L_0x009a:
            java.lang.String r1 = r5.getProgressingOrderId()
        L_0x009e:
            if (r1 == 0) goto L_0x00a1
            r2 = r1
        L_0x00a1:
            r4.dealDuplicated(r2)
            goto L_0x00cf
        L_0x00a5:
            java.lang.String r0 = r5.getRiskMsg()
            com.didi.entrega.foundation.rpc.entity.OrderCreateEntity r2 = r5.getOrderEntity()
            if (r2 != 0) goto L_0x00b0
            goto L_0x00b4
        L_0x00b0:
            com.didi.entrega.security.model.RiskControlModel r1 = r2.getRiskControl()
        L_0x00b4:
            java.lang.String r2 = r5.getCartId()
            r4.dealRiskControl(r0, r1, r2, r5)
            goto L_0x00cf
        L_0x00bc:
            java.lang.String r5 = r5.getMsg()
            com.didi.app.nova.skeleton.ScopeContext r0 = r4.getScopeContext()
            com.didi.entrega.customer.foundation.util.DialogUtil.showErrorDialog(r5, r0)
            goto L_0x00cf
        L_0x00c8:
            java.lang.String r0 = r5.getMsg()
            r4.gotoPayment(r0, r5)
        L_0x00cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.order.CreateOrderErrorHandler.consumeError(com.didi.entrega.order.CreateOrderErrorHandler$Companion$PayErrorModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: consumeError$lambda-2$lambda-1  reason: not valid java name */
    public static final void m46377consumeError$lambda2$lambda1(CreateOrderErrorHandler createOrderErrorHandler, Companion.PayErrorModel payErrorModel, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Intrinsics.checkNotNullParameter(payErrorModel, "$this_apply");
        OrderCreateEntity orderEntity = payErrorModel.getOrderEntity();
        createOrderErrorHandler.refreshBill(orderEntity == null ? null : orderEntity.getOrderId());
    }

    private final void gotoPayment(String str, Companion.PayErrorModel payErrorModel) {
        DialogUtil.showErrorDialog(str, R.string.FoodC_up_Confirmation_hKaf, R.string.FoodC_up_Cancel_anHR, this.scopeContext, new RFDialogInterface.OnClickListener(payErrorModel) {
            public final /* synthetic */ CreateOrderErrorHandler.Companion.PayErrorModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(RFDialog rFDialog) {
                CreateOrderErrorHandler.m46383gotoPayment$lambda3(CreateOrderErrorHandler.this, this.f$1, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: gotoPayment$lambda-3  reason: not valid java name */
    public static final void m46383gotoPayment$lambda3(CreateOrderErrorHandler createOrderErrorHandler, Companion.PayErrorModel payErrorModel, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Intrinsics.checkNotNullParameter(payErrorModel, "$errorModel");
        createOrderErrorHandler.goToPayMethod(payErrorModel.getCartId(), payErrorModel.getPayChannel());
    }

    private final void dealDuplicated(String str) {
        DialogUtil.showDuplicateOrderDialog(this.scopeContext, new RFDialogInterface.OnClickListener(str) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(RFDialog rFDialog) {
                CreateOrderErrorHandler.m46378dealDuplicated$lambda4(CreateOrderErrorHandler.this, this.f$1, rFDialog);
            }
        }, new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                CreateOrderErrorHandler.m46379dealDuplicated$lambda5(CreateOrderErrorHandler.this, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: dealDuplicated$lambda-4  reason: not valid java name */
    public static final void m46378dealDuplicated$lambda4(CreateOrderErrorHandler createOrderErrorHandler, String str, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Intrinsics.checkNotNullParameter(str, "$existingOrderId");
        createOrderErrorHandler.goToOrder(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: dealDuplicated$lambda-5  reason: not valid java name */
    public static final void m46379dealDuplicated$lambda5(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.recreateOrder(1);
    }

    private final void dealRiskControl(String str, RiskControlModel riskControlModel, String str2, Companion.PayErrorModel payErrorModel) {
        if (riskControlModel != null) {
            switch (riskControlModel.riskCode) {
                case 100007:
                    DialogUtil.showErrorDialog(str, this.scopeContext);
                    return;
                case 100008:
                    DialogUtil.showVerifyErrorDialog(this.scopeContext, new RFDialogInterface.OnClickListener(this, str2) {
                        public final /* synthetic */ CreateOrderErrorHandler f$1;
                        public final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(RFDialog rFDialog) {
                            CreateOrderErrorHandler.m46380dealRiskControl$lambda6(RiskControlModel.this, this.f$1, this.f$2, rFDialog);
                        }
                    }, $$Lambda$CreateOrderErrorHandler$uLMO6It4UdrG1UXDPl2ZEjONHgA.INSTANCE);
                    return;
                case ApiErrorConst.OrderRiskType.RISK_GO_TO_PAY_METHOD:
                    gotoPayment(str, payErrorModel);
                    return;
                default:
                    DialogUtil.showErrorDialog(riskControlModel.frontMsg, R.string.FoodC_up_Confirmation_hKaf, this.scopeContext, new RFDialogInterface.OnClickListener() {
                        public final void onClick(RFDialog rFDialog) {
                            CreateOrderErrorHandler.m46382dealRiskControl$lambda8(CreateOrderErrorHandler.this, rFDialog);
                        }
                    });
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dealRiskControl$lambda-6  reason: not valid java name */
    public static final void m46380dealRiskControl$lambda6(RiskControlModel riskControlModel, CreateOrderErrorHandler createOrderErrorHandler, String str, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (riskControlModel.subCodeList != null) {
            arrayList.addAll(riskControlModel.subCodeList);
        }
        bundle.putIntegerArrayList("securitylist", arrayList);
        createOrderErrorHandler.gotoSecurity(str, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: dealRiskControl$lambda-8  reason: not valid java name */
    public static final void m46382dealRiskControl$lambda8(CreateOrderErrorHandler createOrderErrorHandler, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderErrorHandler, "this$0");
        createOrderErrorHandler.closeBill();
    }

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderErrorHandler$Companion;", "", "()V", "PayErrorModel", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderErrorHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\r¨\u0006%"}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderErrorHandler$Companion$PayErrorModel;", "", "preOrderId", "", "exception", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "billEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "(Ljava/lang/String;Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;)V", "cartId", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "code", "", "getCode", "()I", "msg", "getMsg", "setMsg", "orderEntity", "Lcom/didi/entrega/foundation/rpc/entity/OrderCreateEntity;", "getOrderEntity", "()Lcom/didi/entrega/foundation/rpc/entity/OrderCreateEntity;", "setOrderEntity", "(Lcom/didi/entrega/foundation/rpc/entity/OrderCreateEntity;)V", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "getPayChannel", "()Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "setPayChannel", "(Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;)V", "getPreOrderId", "riskMsg", "getRiskMsg", "setRiskMsg", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: CreateOrderErrorHandler.kt */
        public static final class PayErrorModel {
            private String cartId;
            private final int code;
            private String msg;
            private OrderCreateEntity orderEntity;
            private PayChannel payChannel;
            private final String preOrderId;
            private String riskMsg;

            /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public PayErrorModel(java.lang.String r4, com.didi.entrega.customer.foundation.rpc.net.SFRpcException r5, com.didi.entrega.customer.foundation.rpc.entity.BillEntity r6) {
                /*
                    r3 = this;
                    java.lang.String r0 = "billEntity"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                    r3.<init>()
                    r3.preOrderId = r4
                    r4 = 0
                    if (r5 != 0) goto L_0x000f
                L_0x000d:
                    r0 = 0
                    goto L_0x001a
                L_0x000f:
                    com.didi.entrega.customer.foundation.rpc.net.SFRpcResult r0 = r5.getResult()
                    if (r0 != 0) goto L_0x0016
                    goto L_0x000d
                L_0x0016:
                    int r0 = r0.getCode()
                L_0x001a:
                    r3.code = r0
                    java.lang.String r0 = r6.getCartId()
                    r3.cartId = r0
                    r0 = 0
                    if (r5 != 0) goto L_0x0027
                    r1 = r0
                    goto L_0x002b
                L_0x0027:
                    java.lang.String r1 = r5.getMessage()
                L_0x002b:
                    r3.msg = r1
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    r2 = 1
                    if (r1 == 0) goto L_0x003b
                    int r1 = r1.length()
                    if (r1 != 0) goto L_0x0039
                    goto L_0x003b
                L_0x0039:
                    r1 = 0
                    goto L_0x003c
                L_0x003b:
                    r1 = 1
                L_0x003c:
                    if (r1 == 0) goto L_0x0047
                    r1 = 2131952171(0x7f13022b, float:1.9540777E38)
                    java.lang.String r1 = com.didi.entrega.customer.foundation.util.ResourceHelper.getString(r1)
                    r3.msg = r1
                L_0x0047:
                    if (r5 != 0) goto L_0x004b
                L_0x0049:
                    r5 = r0
                    goto L_0x0063
                L_0x004b:
                    com.didi.entrega.customer.foundation.rpc.net.SFRpcResult r5 = r5.getResult()
                    if (r5 != 0) goto L_0x0052
                    goto L_0x0049
                L_0x0052:
                    java.lang.Object r5 = r5.getData()
                    if (r5 != 0) goto L_0x0059
                    goto L_0x0049
                L_0x0059:
                    boolean r1 = r5 instanceof com.didi.entrega.foundation.rpc.entity.OrderCreateEntity
                    if (r1 == 0) goto L_0x0060
                    com.didi.entrega.foundation.rpc.entity.OrderCreateEntity r5 = (com.didi.entrega.foundation.rpc.entity.OrderCreateEntity) r5
                    goto L_0x0063
                L_0x0060:
                    r5 = r0
                    com.didi.entrega.foundation.rpc.entity.OrderCreateEntity r5 = (com.didi.entrega.foundation.rpc.entity.OrderCreateEntity) r5
                L_0x0063:
                    r3.orderEntity = r5
                    java.util.List r5 = r6.getSections()
                    if (r5 != 0) goto L_0x006e
                L_0x006b:
                    r4 = r0
                    goto L_0x00ec
                L_0x006e:
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.util.ArrayList r6 = new java.util.ArrayList
                    r6.<init>()
                    java.util.Collection r6 = (java.util.Collection) r6
                    java.util.Iterator r5 = r5.iterator()
                L_0x007b:
                    boolean r1 = r5.hasNext()
                    if (r1 == 0) goto L_0x0091
                    java.lang.Object r1 = r5.next()
                    com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity r1 = (com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity) r1
                    java.util.List r1 = r1.getComponents()
                    if (r1 == 0) goto L_0x007b
                    r6.add(r1)
                    goto L_0x007b
                L_0x0091:
                    java.util.List r6 = (java.util.List) r6
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.util.ArrayList r5 = new java.util.ArrayList
                    r5.<init>()
                    java.util.Collection r5 = (java.util.Collection) r5
                    java.util.Iterator r6 = r6.iterator()
                L_0x00a0:
                    boolean r1 = r6.hasNext()
                    if (r1 == 0) goto L_0x00b2
                    java.lang.Object r1 = r6.next()
                    java.util.List r1 = (java.util.List) r1
                    java.lang.Iterable r1 = (java.lang.Iterable) r1
                    kotlin.collections.CollectionsKt.addAll(r5, r1)
                    goto L_0x00a0
                L_0x00b2:
                    java.util.List r5 = (java.util.List) r5
                    java.lang.Iterable r5 = (java.lang.Iterable) r5
                    java.util.Iterator r5 = r5.iterator()
                L_0x00ba:
                    boolean r6 = r5.hasNext()
                    if (r6 == 0) goto L_0x00db
                    java.lang.Object r6 = r5.next()
                    r1 = r6
                    com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity r1 = (com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity) r1
                    com.didi.entrega.customer.foundation.rpc.entity.BillExtraData r1 = r1.getData()
                    if (r1 != 0) goto L_0x00cf
                    r1 = r0
                    goto L_0x00d3
                L_0x00cf:
                    com.didi.entrega.customer.foundation.rpc.entity.PayChannel r1 = r1.getPayChannel()
                L_0x00d3:
                    if (r1 == 0) goto L_0x00d7
                    r1 = 1
                    goto L_0x00d8
                L_0x00d7:
                    r1 = 0
                L_0x00d8:
                    if (r1 == 0) goto L_0x00ba
                    goto L_0x00dc
                L_0x00db:
                    r6 = r0
                L_0x00dc:
                    com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity r6 = (com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity) r6
                    if (r6 != 0) goto L_0x00e1
                    goto L_0x006b
                L_0x00e1:
                    com.didi.entrega.customer.foundation.rpc.entity.BillExtraData r4 = r6.getData()
                    if (r4 != 0) goto L_0x00e8
                    goto L_0x006b
                L_0x00e8:
                    com.didi.entrega.customer.foundation.rpc.entity.PayChannel r4 = r4.getPayChannel()
                L_0x00ec:
                    r3.payChannel = r4
                    com.didi.entrega.foundation.rpc.entity.OrderCreateEntity r4 = r3.orderEntity
                    if (r4 != 0) goto L_0x00f3
                    goto L_0x00fc
                L_0x00f3:
                    com.didi.entrega.security.model.RiskControlModel r4 = r4.getRiskControl()
                    if (r4 != 0) goto L_0x00fa
                    goto L_0x00fc
                L_0x00fa:
                    java.lang.String r0 = r4.frontMsg
                L_0x00fc:
                    if (r0 != 0) goto L_0x0100
                    java.lang.String r0 = r3.msg
                L_0x0100:
                    r3.riskMsg = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.order.CreateOrderErrorHandler.Companion.PayErrorModel.<init>(java.lang.String, com.didi.entrega.customer.foundation.rpc.net.SFRpcException, com.didi.entrega.customer.foundation.rpc.entity.BillEntity):void");
            }

            public final String getPreOrderId() {
                return this.preOrderId;
            }

            public final int getCode() {
                return this.code;
            }

            public final String getMsg() {
                return this.msg;
            }

            public final void setMsg(String str) {
                this.msg = str;
            }

            public final String getRiskMsg() {
                return this.riskMsg;
            }

            public final void setRiskMsg(String str) {
                this.riskMsg = str;
            }

            public final String getCartId() {
                return this.cartId;
            }

            public final void setCartId(String str) {
                this.cartId = str;
            }

            public final PayChannel getPayChannel() {
                return this.payChannel;
            }

            public final void setPayChannel(PayChannel payChannel2) {
                this.payChannel = payChannel2;
            }

            public final OrderCreateEntity getOrderEntity() {
                return this.orderEntity;
            }

            public final void setOrderEntity(OrderCreateEntity orderCreateEntity) {
                this.orderEntity = orderCreateEntity;
            }
        }

        private Companion() {
        }
    }
}
