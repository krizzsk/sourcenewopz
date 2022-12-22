package com.didi.entrega.bill.datastore;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.bill.datastore.p110op.EntityOperation;
import com.didi.entrega.bill.model.RequestFlowModel;
import com.didi.entrega.customer.base.pages.CustomerPage;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcPath;
import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.sdk.util.SidConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 82\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002JL\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010!\u001a\u00020\"J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0016H\u0002J0\u0010&\u001a\u00020\u001a\"\u0004\b\u0000\u0010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H'0)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H'0-J\u001c\u0010.\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0-J\u000e\u0010/\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u000200JA\u00101\u001a\u00020\u001a\"\u0004\b\u0000\u0010'2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H'0)2%\u00103\u001a!\u0012\u0015\u0012\u0013\u0018\u0001H'¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0006\u0012\u0004\u0018\u0001H'04R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u00069"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/BillRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "", "()V", "<set-?>", "", "cartId", "getCartId", "()Ljava/lang/String;", "flowOp", "Lcom/didi/entrega/bill/datastore/OperationModel;", "Lcom/didi/entrega/bill/model/RequestFlowModel;", "operations", "", "pageSource", "getPageSource", "()I", "setPageSource", "(I)V", "buildCallback", "Lcom/didi/entrega/customer/foundation/rpc/net/CustomerRpcCallback;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "request", "Lcom/didi/entrega/bill/datastore/BillRequest;", "getBillInfo", "", "senderAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "receiverAddress", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "orderId", "recover", "", "internalHandleBillEntity", "requestName", "billEntity", "subscribe", "T", "op", "Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action1;", "subscribeRequestFlow", "update", "Lcom/didi/entrega/bill/datastore/BillUpdateRequest;", "updateOperation", "operation", "updateAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "old", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillRepo.kt */
public final class BillRepo extends Repo<List<? extends Integer>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f19494e = "bill_repo_ref";

    /* renamed from: a */
    private String f19495a = "";

    /* renamed from: b */
    private int f19496b = 1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<C7998a<?>> f19497c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C7998a<RequestFlowModel> f19498d;

    public final String getCartId() {
        return this.f19495a;
    }

    public final int getPageSource() {
        return this.f19496b;
    }

    public final void setPageSource(int i) {
        this.f19496b = i;
    }

    public final void subscribeRequestFlow(ScopeContext scopeContext, Action1<RequestFlowModel> action1) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(action1, "action");
        C7998a<RequestFlowModel> aVar = new C7998a<>((EntityOperation) null, null);
        this.f19498d = aVar;
        subscribe(scopeContext, new BillRepo$subscribeRequestFlow$1(aVar, action1));
    }

    public final <T> void subscribe(EntityOperation<T> entityOperation, ScopeContext scopeContext, Action1<T> action1) {
        Object obj;
        Intrinsics.checkNotNullParameter(entityOperation, "op");
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(action1, "action");
        Iterator it = this.f19497c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((C7998a) obj).mo59342a(), (Object) entityOperation)) {
                break;
            }
        }
        if (((C7998a) obj) != null) {
            LogUtil.m14763e("BillRepo", Intrinsics.stringPlus("error >>>>>> 重复订阅 op = ", entityOperation));
            return;
        }
        C7998a aVar = new C7998a(entityOperation, null);
        this.f19497c.add(aVar);
        subscribe(scopeContext, new BillRepo$subscribe$1(aVar.mo59346c(), this, action1, entityOperation));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m14601a(String str, BillEntity billEntity) {
        if (Intrinsics.areEqual((Object) str, (Object) CustomerRpcPath.BILL_INFO)) {
            this.f19495a = billEntity.getCartId();
        }
        ICustomerContactManager iCustomerContactManager = (ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class);
        iCustomerContactManager.updateCartId(billEntity.getCartId());
        Map mapOf = MapsKt.mapOf(TuplesKt.m42317to(16, new BillRepo$internalHandleBillEntity$1$addressInfo$1(iCustomerContactManager)), TuplesKt.m42317to(17, new BillRepo$internalHandleBillEntity$1$packageInfo$1(iCustomerContactManager)));
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

    /* renamed from: a */
    private final CustomerRpcCallback<BillEntity> m14600a(BillRequest billRequest) {
        return new BillRepo$buildCallback$1(this, billRequest);
    }

    public static /* synthetic */ void getBillInfo$default(BillRepo billRepo, String str, AddressEntity addressEntity, AddressEntity addressEntity2, ContactStufEntity contactStufEntity, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            addressEntity = null;
        }
        if ((i & 4) != 0) {
            addressEntity2 = null;
        }
        if ((i & 8) != 0) {
            contactStufEntity = null;
        }
        if ((i & 16) != 0) {
            str2 = "";
        }
        if ((i & 32) != 0) {
            z = false;
        }
        billRepo.getBillInfo(str, addressEntity, addressEntity2, contactStufEntity, str2, z);
    }

    public final void getBillInfo(String str, AddressEntity addressEntity, AddressEntity addressEntity2, ContactStufEntity contactStufEntity, String str2, boolean z) {
        BillInfoRequest billInfoRequest = new BillInfoRequest();
        billInfoRequest.setCartId(str);
        billInfoRequest.setReceiverAddress(addressEntity2);
        billInfoRequest.setSenderAddress(addressEntity);
        billInfoRequest.setPackageInfo(contactStufEntity);
        billInfoRequest.setOrderId(str2);
        billInfoRequest.setRecover(z);
        BillRequest billRequest = billInfoRequest;
        billInfoRequest.setCallback(m14600a(billRequest));
        C7998a<RequestFlowModel> aVar = this.f19498d;
        if (aVar != null) {
            aVar.mo59344a(new RequestFlowModel(billRequest, 1, (SFRpcException) null, 4, (DefaultConstructorMarker) null));
            setValue(CollectionsKt.listOf(Integer.valueOf(aVar.mo59346c())));
        }
        billInfoRequest.send();
    }

    public final void update(BillUpdateRequest billUpdateRequest) {
        Intrinsics.checkNotNullParameter(billUpdateRequest, "request");
        billUpdateRequest.setCartId(this.f19495a);
        BillRequest billRequest = billUpdateRequest;
        billUpdateRequest.setCallback(m14600a(billRequest));
        C7998a<RequestFlowModel> aVar = this.f19498d;
        if (aVar != null) {
            aVar.mo59344a(new RequestFlowModel(billRequest, 1, (SFRpcException) null, 4, (DefaultConstructorMarker) null));
            setValue(CollectionsKt.listOf(Integer.valueOf(aVar.mo59346c())));
        }
        billUpdateRequest.send();
    }

    public final <T> void updateOperation(EntityOperation<T> entityOperation, Function1<? super T, ? extends T> function1) {
        C7998a aVar;
        Object obj;
        Intrinsics.checkNotNullParameter(entityOperation, SidConverter.SID_OPERATION);
        Intrinsics.checkNotNullParameter(function1, "updateAction");
        Iterator it = this.f19497c.iterator();
        while (true) {
            aVar = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((C7998a) obj).mo59342a(), (Object) entityOperation)) {
                break;
            }
        }
        if (obj instanceof C7998a) {
            aVar = (C7998a) obj;
        }
        if (aVar != null) {
            aVar.mo59344a(function1.invoke(aVar.mo59345b()));
            setValue(CollectionsKt.listOf(Integer.valueOf(aVar.mo59346c())));
        }
    }

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/BillRepo$Companion;", "", "()V", "billRepoRef", "", "get", "Lcom/didi/entrega/bill/datastore/BillRepo;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "initBillRepo", "", "page", "Lcom/didi/entrega/customer/base/pages/CustomerPage;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void initBillRepo(CustomerPage customerPage) {
            Intrinsics.checkNotNullParameter(customerPage, "page");
            LogUtil.m14765i("BillRepo", "begin init bill repo");
            ScopeContext scopeContext = customerPage.getScopeContext();
            if (scopeContext == null) {
                LogUtil.m14765i("BillRepo", "init bill repo, but scopeContext = null");
            } else if (scopeContext.getObject(BillRepo.f19494e) == null) {
                ScopeContext scopeContext2 = customerPage.getScopeContext();
                if (scopeContext2 != null) {
                    scopeContext2.attach(BillRepo.f19494e, new BillRepo());
                }
            } else {
                LogUtil.m14765i("BillRepo", "already init bill repo, don't run init");
            }
        }

        public final BillRepo get(ScopeContext scopeContext) {
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            Object object = scopeContext.getObject(BillRepo.f19494e);
            BillRepo billRepo = object instanceof BillRepo ? (BillRepo) object : null;
            if (billRepo != null) {
                return billRepo;
            }
            LogUtil.m14765i("TAG", "异常case!!! 检查是否在Page调用过initBillRepo");
            return new BillRepo();
        }
    }
}
