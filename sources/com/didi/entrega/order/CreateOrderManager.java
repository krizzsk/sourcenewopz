package com.didi.entrega.order;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcService;
import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillExtraData;
import com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.customer.foundation.util.CipherUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.order.CreateOrderErrorHandler;
import com.didi.entrega.router.DiRouter;
import com.didi.security.uuid.adapter.DeviceTokenWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0011\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J9\u0010\u0019\u001a\u00020\u00142!\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00140\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0002J$\u0010!\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\r2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J,\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u000b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140 2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140 H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\rH\u0002J\u0012\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002J\u0012\u0010'\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u0016H\u0002J\u0006\u00100\u001a\u00020\u0014J\u0010\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203H&R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0012¨\u00065"}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderManager;", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "billEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;)V", "getBillEntity", "()Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "createOrderFunction", "Lcom/didi/entrega/order/CreateOrderCallBack;", "Lcom/didi/entrega/foundation/rpc/entity/OrderCreateEntity;", "createOrderStatus", "", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "timeoutHandler", "com/didi/entrega/order/CreateOrderManager$timeoutHandler$1", "Lcom/didi/entrega/order/CreateOrderManager$timeoutHandler$1;", "consumeCreateFailed", "", "preOrderId", "", "exception", "Lcom/didi/entrega/customer/foundation/rpc/net/SFRpcException;", "consumeParam", "failedFunction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "focusType", "successFunction", "Lkotlin/Function0;", "createOrder", "duplicateOrderConfirm", "callback", "createPreOrderId", "doPay", "order", "refreshBillInfo", "goToOrder", "getBillDataByType", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillExtraData;", "type", "gotoOrderPage", "orderId", "onProgressEnd", "onProgressStart", "start", "updateLoading", "isShowLoading", "", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
public abstract class CreateOrderManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STATUS_CREATE_FAILED = 102;
    public static final int STATUS_CREATE_ORDER = 100;
    public static final int STATUS_CREATE_SUCCESS = 101;
    public static final int STATUS_INIT = 0;
    public static final String TAG = "CreateOrderManager";
    private final BillEntity billEntity;
    /* access modifiers changed from: private */
    public CreateOrderCallBack<OrderCreateEntity> createOrderFunction;
    /* access modifiers changed from: private */
    public int createOrderStatus;
    private final ScopeContext scopeContext;
    /* access modifiers changed from: private */
    public CreateOrderManager$timeoutHandler$1 timeoutHandler = new CreateOrderManager$timeoutHandler$1(this);

    public abstract void updateLoading(boolean z);

    public CreateOrderManager(ScopeContext scopeContext2, BillEntity billEntity2) {
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        Intrinsics.checkNotNullParameter(billEntity2, "billEntity");
        this.scopeContext = scopeContext2;
        this.billEntity = billEntity2;
    }

    public final BillEntity getBillEntity() {
        return this.billEntity;
    }

    public final ScopeContext getScopeContext() {
        return this.scopeContext;
    }

    public final void start() {
        consumeParam(new CreateOrderManager$start$1(this), new CreateOrderManager$start$2(this));
    }

    /* access modifiers changed from: private */
    public final void onProgressEnd() {
        this.timeoutHandler.cancel();
        updateLoading(false);
    }

    private final void onProgressStart() {
        updateLoading(true);
        this.timeoutHandler.start();
    }

    private final void consumeParam(Function1<? super Integer, Unit> function1, Function0<Unit> function0) {
        LogUtil.m14765i("CreateOrderManager", "consumeParam " + this.billEntity.getCartId() + " start");
        if (!LoginUtil.isLogin()) {
            LogUtil.m14765i("CreateOrderManager", "consumeParam " + this.billEntity.getCartId() + " goLogin");
            LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 9);
            function1.invoke(0);
            return;
        }
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public final void consumeCreateFailed(String str, SFRpcException sFRpcException) {
        StringBuilder sb = new StringBuilder();
        sb.append("consumeCreateFailed ");
        sb.append(this.billEntity.getCartId());
        sb.append(" error=");
        String str2 = null;
        sb.append(sFRpcException == null ? null : Integer.valueOf(sFRpcException.getCode()));
        sb.append(" msg=");
        sb.append(sFRpcException == null ? null : sFRpcException.getMessage());
        LogUtil.m14765i("CreateOrderManager", sb.toString());
        BillOmegaHelper billOmegaHelper = BillOmegaHelper.INSTANCE;
        String cartId = this.billEntity.getCartId();
        Integer valueOf = sFRpcException == null ? null : Integer.valueOf(sFRpcException.getCode());
        if (sFRpcException != null) {
            str2 = sFRpcException.getMessage();
        }
        BillOmegaHelper.tracePayResult$default(billOmegaHelper, cartId, 0, (String) null, valueOf, str2, 4, (Object) null);
        new CreateOrderManager$consumeCreateFailed$1(this, this.scopeContext).consumeError(new CreateOrderErrorHandler.Companion.PayErrorModel(str, sFRpcException, this.billEntity));
        onProgressEnd();
    }

    /* access modifiers changed from: private */
    public final void doPay(OrderCreateEntity orderCreateEntity, Function0<Unit> function0, Function0<Unit> function02) {
        new CreateOrderManager$doPay$1(this, orderCreateEntity, function02, function0, this.scopeContext, this.timeoutHandler).doPay(orderCreateEntity.getTransId(), orderCreateEntity.getOrderId());
    }

    /* access modifiers changed from: private */
    public final void refreshBillInfo(String str) {
        LogUtil.m14765i("CreateOrderManager", "refreshBillInfo cartId=" + this.billEntity.getCartId() + ' ');
        ICustomerContactManager iCustomerContactManager = (ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class);
        BillRepo billRepo = BillRepo.Companion.get(this.scopeContext);
        if (str == null) {
            str = "";
        }
        billRepo.getBillInfo(iCustomerContactManager.getCartId(), iCustomerContactManager.getSendContact(), iCustomerContactManager.getReceiveContact(), iCustomerContactManager.getContStuf(), str, true);
    }

    /* access modifiers changed from: private */
    public final void gotoOrderPage(String str) {
        LogUtil.m14765i("CreateOrderManager", "refreshBillInfo cartId=" + this.billEntity.getCartId() + " order=" + str);
        ((ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class)).clear();
        DiRouter.request().path("orderPage").putString("path", "/order_page").putInt("from", 2).putString("orderId", str).open();
        this.scopeContext.getNavigator().finish();
        onProgressEnd();
    }

    private final BillExtraData getBillDataByType(int i) {
        Object obj;
        boolean z;
        List<BillSectionEntity> sections = this.billEntity.getSections();
        if (sections == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (BillSectionEntity components : sections) {
            List<BillComponentEntity> components2 = components.getComponents();
            if (components2 != null) {
                arrayList.add(components2);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (List addAll : (List) arrayList) {
            CollectionsKt.addAll(arrayList2, addAll);
        }
        Iterator it = ((List) arrayList2).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (i == ((BillComponentEntity) obj).getType()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        BillComponentEntity billComponentEntity = (BillComponentEntity) obj;
        if (billComponentEntity == null) {
            return null;
        }
        return billComponentEntity.getData();
    }

    static /* synthetic */ void createOrder$default(CreateOrderManager createOrderManager, int i, CreateOrderCallBack createOrderCallBack, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                createOrderCallBack = null;
            }
            createOrderManager.createOrder(i, createOrderCallBack);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createOrder");
    }

    /* access modifiers changed from: private */
    public final void createOrder(int i, CreateOrderCallBack<OrderCreateEntity> createOrderCallBack) {
        LogUtil.m14765i("CreateOrderManager", "createOrder cartId=" + this.billEntity.getCartId() + " duplicate=" + i);
        String createPreOrderId = createPreOrderId();
        if (createOrderCallBack != null) {
            createOrderCallBack.setPreOrderId(createPreOrderId);
        }
        this.createOrderStatus = 100;
        onProgressStart();
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        String cartId = this.billEntity.getCartId();
        String sn = this.billEntity.getSn();
        String deviceToken = DeviceTokenWrapper.getInstance().getDeviceToken();
        if (deviceToken == null) {
            deviceToken = "";
        }
        customerRpcService.createOrder(cartId, sn, i, createPreOrderId, deviceToken, createOrderCallBack);
    }

    private final String createPreOrderId() {
        String md5 = CipherUtil.md5(LoginUtil.getUid() + "16" + (System.currentTimeMillis() / ((long) 1000)));
        Intrinsics.checkNotNullExpressionValue(md5, "md5(LoginUtil.getUid() +…rrentTimeMillis() / 1000)");
        return md5;
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderManager$Companion;", "", "()V", "STATUS_CREATE_FAILED", "", "STATUS_CREATE_ORDER", "STATUS_CREATE_SUCCESS", "STATUS_INIT", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreateOrderManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
