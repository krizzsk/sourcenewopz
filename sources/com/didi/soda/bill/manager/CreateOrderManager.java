package com.didi.soda.bill.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.BillEventToJS;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.manager.CreateOrderDispatcher;
import com.didi.soda.bill.manager.CreateOrderErrorHandler;
import com.didi.soda.bill.manager.CreateOrderState;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RiskControlEntity;
import com.didi.soda.customer.foundation.tracker.AppsFlyerTrackHelper;
import com.didi.soda.customer.foundation.tracker.FirebaseAnalyticsHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.ApiErrorUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.manager.base.ICustomerPayManager;
import com.didi.soda.order.manager.OrderHistoryRefreshRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J)\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0018H\u0002J1\u0010 \u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00162\b\u0010#\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006&"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderManager;", "Lcom/didi/soda/bill/manager/CreateOrderCallback;", "()V", "createOrderState", "Lcom/didi/soda/bill/manager/CreateOrderState;", "dispatcher", "Lcom/didi/soda/bill/manager/CreateOrderDispatcher;", "errorHandler", "Lcom/didi/soda/bill/manager/CreateOrderErrorHandler;", "payHandler", "Lcom/didi/soda/bill/manager/CreateOrderPayHandler;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "createOrder", "", "notifyHomeForEFO", "onCreateOrderError", "state", "onCreateOrderIng", "onCreateOrderSuccess", "payButtonFail", "errCode", "", "errMsg", "", "(Lcom/didi/soda/bill/manager/CreateOrderState;Ljava/lang/Integer;Ljava/lang/String;)V", "payButtonLoading", "saveOrder", "order", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderInfoEntity;", "syncCart", "shopId", "tracePayCallback", "success", "errorCode", "errorMsg", "(Lcom/didi/soda/bill/manager/CreateOrderState;ILjava/lang/Integer;Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
public final class CreateOrderManager implements CreateOrderCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "CreateOrderManager";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ScopeContext f39010a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CreateOrderDispatcher f39011b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CreateOrderErrorHandler f39012c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CreateOrderPayHandler f39013d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CreateOrderState f39014e;

    public /* synthetic */ CreateOrderManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CreateOrderManager() {
    }

    public final void createOrder() {
        CreateOrderDispatcher createOrderDispatcher = this.f39011b;
        CreateOrderState createOrderState = null;
        if (createOrderDispatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            createOrderDispatcher = null;
        }
        CreateOrderDispatcher.Companion companion = CreateOrderDispatcher.Companion;
        CreateOrderState createOrderState2 = this.f39014e;
        if (createOrderState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createOrderState");
        } else {
            createOrderState = createOrderState2;
        }
        createOrderDispatcher.dispatch(companion.createOrder(createOrderState));
    }

    public void onCreateOrderIng(CreateOrderState createOrderState) {
        Intrinsics.checkNotNullParameter(createOrderState, "state");
        m27730b();
        if (createOrderState.getPayChannelEntity() != null) {
            PayChannelEntity payChannelEntity = createOrderState.getPayChannelEntity();
            boolean z = false;
            if (payChannelEntity != null && payChannelEntity.clientPayType == 1) {
                z = true;
            }
            if (z) {
                return;
            }
        }
        CreateOrderPayHandler createOrderPayHandler = this.f39013d;
        if (createOrderPayHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payHandler");
            createOrderPayHandler = null;
        }
        createOrderPayHandler.startPayTimeout(createOrderState, new CreateOrderManager$onCreateOrderIng$1(this));
    }

    public void onCreateOrderSuccess(CreateOrderState createOrderState) {
        Intrinsics.checkNotNullParameter(createOrderState, "state");
        AppsFlyerTrackHelper.trackCreateOrder(GlobalContext.getContext());
        FirebaseAnalyticsHelper.trackCreateOrder(GlobalContext.getContext());
        OrderInfoEntity order = createOrderState.getOrder();
        if (order != null) {
            m27728a(order);
            CreateOrderPayHandler createOrderPayHandler = this.f39013d;
            if (createOrderPayHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payHandler");
                createOrderPayHandler = null;
            }
            createOrderPayHandler.goPay(createOrderState, order);
            LogUtil.m29104i("CreateOrderManager", Intrinsics.stringPlus("onCreateOrderSuccess -> orderId: ", order.orderId));
        }
        m27729a(createOrderState.getShopId());
        m27725a();
        m27726a(createOrderState, 1, 0, "");
        BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 4, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
    }

    public void onCreateOrderError(CreateOrderState createOrderState) {
        int i;
        Intrinsics.checkNotNullParameter(createOrderState, "state");
        CreateOrderState.OrderErrorState errorState = createOrderState.getErrorState();
        String str = "";
        if (errorState == null) {
            i = -1;
        } else {
            String mErrorMessage = errorState.getMErrorMessage();
            if (mErrorMessage != null) {
                str = mErrorMessage;
            }
            i = errorState.getMErrorCode();
        }
        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_CART_CREATEORDER_ERROR).addErrorType(ApiErrorUtil.Companion.getErrorType(String.valueOf(i))).addErrorMsg(str).addModuleName(ErrorConst.ModuleName.CART).build().trackError();
        CreateOrderErrorHandler createOrderErrorHandler = this.f39012c;
        CreateOrderPayHandler createOrderPayHandler = null;
        if (createOrderErrorHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorHandler");
            createOrderErrorHandler = null;
        }
        ScopeContext scopeContext = this.f39010a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        createOrderErrorHandler.handle(createOrderState, scopeContext);
        CreateOrderPayHandler createOrderPayHandler2 = this.f39013d;
        if (createOrderPayHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payHandler");
        } else {
            createOrderPayHandler = createOrderPayHandler2;
        }
        createOrderPayHandler.stopPayTimeout();
        m27727a(createOrderState, Integer.valueOf(i), str);
        LogUtil.m29104i("CreateOrderManager", "onCreateOrderError -> errCode: " + i + " errMsg: " + str);
        BillEventToJS.triggerEvent$default(BillEventToJS.INSTANCE, 5, (Integer) null, (String) null, (IEntity) null, 14, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27725a() {
        ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).activityInvalidedRefreshHome();
        ((OrderHistoryRefreshRepo) RepoFactory.getRepo(OrderHistoryRefreshRepo.class)).setValue(1);
    }

    /* renamed from: a */
    private final void m27726a(CreateOrderState createOrderState, int i, Integer num, String str) {
        int i2;
        RiskControlEntity mRisk;
        ScopeContext scopeContext = this.f39010a;
        String str2 = null;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        String str3 = "";
        String string = scopeContext.getBundle().getString("from_page", str3);
        String appInstanceID = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getAppInstanceID();
        CreateOrderOmegaBuilder createOrderOmegaBuilder = new CreateOrderOmegaBuilder();
        if (string == null) {
            string = str3;
        }
        CreateOrderOmegaBuilder fromPage = createOrderOmegaBuilder.fromPage(string);
        String cartId = createOrderState.getCartId();
        if (cartId == null) {
            cartId = str3;
        }
        CreateOrderOmegaBuilder cartId2 = fromPage.cartId(cartId);
        String shopId = createOrderState.getShopId();
        if (shopId == null) {
            shopId = str3;
        }
        CreateOrderOmegaBuilder shopId2 = cartId2.shopId(shopId);
        String itemDetail = createOrderState.getItemDetail();
        if (itemDetail == null) {
            itemDetail = str3;
        }
        CreateOrderOmegaBuilder itemDetail2 = shopId2.itemDetail(itemDetail);
        PayChannelEntity payChannelEntity = createOrderState.getPayChannelEntity();
        int i3 = 0;
        CreateOrderOmegaBuilder payMethod = itemDetail2.payMethod(Integer.valueOf(payChannelEntity == null ? 0 : payChannelEntity.channelId));
        OrderInfoEntity order = createOrderState.getOrder();
        if (order != null) {
            str2 = order.orderId;
        }
        if (str2 == null) {
            str2 = str3;
        }
        CreateOrderOmegaBuilder orderId = payMethod.orderId(str2);
        String preOrderId = createOrderState.getPreOrderId();
        if (preOrderId == null) {
            preOrderId = str3;
        }
        CreateOrderOmegaBuilder isSuc = orderId.preOrderId(preOrderId).isSuc(Integer.valueOf(i));
        if (num == null) {
            i2 = 0;
        } else {
            i2 = num.intValue();
        }
        CreateOrderOmegaBuilder failureReason = isSuc.failureReason(Integer.valueOf(i2));
        if (str == null) {
            str = str3;
        }
        CreateOrderOmegaBuilder errorMsg = failureReason.errorMsg(str);
        CreateOrderState.OrderErrorState errorState = createOrderState.getErrorState();
        CreateOrderOmegaBuilder riskCode = errorMsg.riskCode(Integer.valueOf((errorState == null || (mRisk = errorState.getMRisk()) == null) ? 0 : mRisk.riskCode));
        Integer deliveryType = createOrderState.getDeliveryType();
        if (deliveryType != null) {
            i3 = deliveryType.intValue();
        }
        CreateOrderOmegaBuilder deliveryType2 = riskCode.deliveryType(Integer.valueOf(i3));
        if (appInstanceID == null) {
            appInstanceID = str3;
        }
        CreateOrderOmegaBuilder fireBaseAppInstanceId = deliveryType2.fireBaseAppInstanceId(appInstanceID);
        String traceId = createOrderState.getTraceId();
        if (traceId != null) {
            str3 = traceId;
        }
        BillOmegaHelper.Companion.onPayCallback(fireBaseAppInstanceId.traceId(str3).pubBizType(Const.PubBizLine.FIN));
    }

    /* renamed from: a */
    private final void m27728a(OrderInfoEntity orderInfoEntity) {
        if (orderInfoEntity != null) {
            ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).addOrderEntity2Monitor(orderInfoEntity, 1);
        }
    }

    /* renamed from: b */
    private final void m27730b() {
        ScopeContext scopeContext = this.f39010a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).loading();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    /* renamed from: a */
    private final void m27727a(CreateOrderState createOrderState, Integer num, String str) {
        ScopeContext scopeContext = this.f39010a;
        if (scopeContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scopeContext");
            scopeContext = null;
        }
        Object object = scopeContext.getObject("pay_callback");
        if (object != null) {
            ((ICustomerPayManager.CartPayButtonCallback) object).fail(createOrderState.getShopId());
            m27726a(createOrderState, 0, num, str);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.manager.base.ICustomerPayManager.CartPayButtonCallback");
    }

    /* renamed from: a */
    private final void m27729a(String str) {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).fetchCartInfo(str);
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/bill/manager/CreateOrderManager$Companion;", "", "()V", "TAG", "", "assemble", "Lcom/didi/soda/bill/manager/CreateOrderManager;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "param", "Lcom/didi/soda/bill/manager/CreateOrderState;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOrderManager assemble(ScopeContext scopeContext, CreateOrderState createOrderState) {
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            Intrinsics.checkNotNullParameter(createOrderState, "param");
            CreateOrderDispatcher createOrderDispatcher = null;
            CreateOrderManager createOrderManager = new CreateOrderManager((DefaultConstructorMarker) null);
            createOrderManager.f39010a = scopeContext;
            createOrderManager.f39011b = CreateOrderDispatcher.Companion.assemble(createOrderManager);
            CreateOrderErrorHandler.Companion companion = CreateOrderErrorHandler.Companion;
            CreateOrderDispatcher access$getDispatcher$p = createOrderManager.f39011b;
            if (access$getDispatcher$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dispatcher");
            } else {
                createOrderDispatcher = access$getDispatcher$p;
            }
            createOrderManager.f39012c = companion.assemble(scopeContext, createOrderDispatcher);
            createOrderManager.f39013d = CreateOrderPayHandler.Companion.assemble(scopeContext);
            createOrderManager.f39014e = createOrderState;
            return createOrderManager;
        }
    }
}
