package com.didi.entrega.orderlist.component;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.order.ButtonEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderData;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import com.didi.entrega.customer.foundation.share.ShareHelper;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerOrderManager;
import com.didi.entrega.orderlist.binder.OrderListItemModel;
import com.didi.entrega.orderlist.component.Contract;
import com.didi.entrega.orderlist.data.OrderListDataSource;
import com.didi.entrega.orderlist.omega.OrderListOmegaHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.customer.app.constant.StringConst;
import com.didi.soda.web.model.ShareToolModel;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u001a\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0006\u0010\u0019\u001a\u00020\u000fJ\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0014J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0014J\b\u0010 \u001a\u00020\u000fH\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J\b\u0010\"\u001a\u00020\u000fH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010$H\u0002J\b\u0010&\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006("}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/OrderListPresenter;", "Lcom/didi/entrega/orderlist/component/Contract$IOrderListPresenter;", "()V", "clickedModel", "Lcom/didi/entrega/orderlist/component/ClickedModel;", "dataSource", "Lcom/didi/entrega/orderlist/data/OrderListDataSource;", "isRedirected", "", "listManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "omegaHelper", "Lcom/didi/entrega/orderlist/omega/OrderListOmegaHelper;", "buttonGroupClick", "", "buttonEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ButtonEntity;", "itemModel", "doRefresh", "bundle", "Landroid/os/Bundle;", "isPullDown", "fillInClickedModel", "goOrderPage", "init", "initDataManagers", "onCreate", "onDestroy", "onLoadMore", "onPullToRefresh", "onResume", "refreshOrderInfoById", "refreshOrderInfoIfNeed", "resetClickedModel", "transformErrorMsg", "", "errMsg", "updatePageMoreState", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListPresenter.kt */
public final class OrderListPresenter extends Contract.IOrderListPresenter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f */
    private static final String f20979f = "OrderListPresenter";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ChildDataListManager<OrderListItemModel> f20980a;

    /* renamed from: b */
    private OrderListDataSource f20981b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f20982c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ClickedModel f20983d = new ClickedModel();

    /* renamed from: e */
    private final OrderListOmegaHelper f20984e = OrderListOmegaHelper.Companion.getInstance();

    public void onCreate() {
        super.onCreate();
        OrderListOmegaHelper orderListOmegaHelper = this.f20984e;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        orderListOmegaHelper.attach(scopeContext);
        init();
    }

    public final void init() {
        OrderListDataSource orderListDataSource = new OrderListDataSource();
        orderListDataSource.subscribeListChanged(new Action1() {
            public final void call(Object obj) {
                OrderListPresenter.m15357a(OrderListPresenter.this, (List) obj);
            }
        });
        orderListDataSource.subscribePageResult(new Action1() {
            public final void call(Object obj) {
                OrderListPresenter.m15356a(OrderListPresenter.this, (CustomerResource) obj);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.f20981b = orderListDataSource;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15357a(OrderListPresenter orderListPresenter, List list) {
        Intrinsics.checkNotNullParameter(orderListPresenter, "this$0");
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            ((Contract.IOrderListView) orderListPresenter.getLogicView()).showNoData();
            return;
        }
        ChildDataListManager<OrderListItemModel> childDataListManager = orderListPresenter.f20980a;
        if (childDataListManager != null) {
            childDataListManager.set(list);
        }
        ((Contract.IOrderListView) orderListPresenter.getLogicView()).hideAbnormalView();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        r5 = r5.getOrderList();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m15356a(com.didi.entrega.orderlist.component.OrderListPresenter r4, com.didi.entrega.customer.repo.CustomerResource r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.didi.app.nova.skeleton.mvp.IView r0 = r4.getLogicView()
            com.didi.entrega.orderlist.component.Contract$IOrderListView r0 = (com.didi.entrega.orderlist.component.Contract.IOrderListView) r0
            r0.hideGlobalLoading()
            com.didi.app.nova.skeleton.mvp.IView r0 = r4.getLogicView()
            com.didi.entrega.orderlist.component.Contract$IOrderListView r0 = (com.didi.entrega.orderlist.component.Contract.IOrderListView) r0
            r0.dismissPullToRefresh()
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0047
            com.didi.app.nova.skeleton.repo.Resource$Status r2 = r5.status
            com.didi.app.nova.skeleton.repo.Resource$Status r3 = com.didi.app.nova.skeleton.repo.Resource.Status.ERROR
            if (r2 != r3) goto L_0x0023
            goto L_0x0047
        L_0x0023:
            java.lang.Object r5 = r5.data
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderListEntity r5 = (com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderListEntity) r5
            if (r5 != 0) goto L_0x002b
        L_0x0029:
            r5 = 0
            goto L_0x003b
        L_0x002b:
            java.util.List r5 = r5.getOrderList()
            if (r5 != 0) goto L_0x0032
            goto L_0x0029
        L_0x0032:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            if (r5 != r0) goto L_0x0029
            r5 = 1
        L_0x003b:
            if (r5 == 0) goto L_0x006e
            com.didi.app.nova.skeleton.mvp.IView r5 = r4.getLogicView()
            com.didi.entrega.orderlist.component.Contract$IOrderListView r5 = (com.didi.entrega.orderlist.component.Contract.IOrderListView) r5
            r5.showNoData()
            goto L_0x006e
        L_0x0047:
            android.content.Context r2 = r4.getContext()
            boolean r2 = com.didi.entrega.customer.foundation.util.NetWorkUtils.isNetworkConnected(r2)
            if (r2 != 0) goto L_0x005b
            com.didi.app.nova.skeleton.mvp.IView r5 = r4.getLogicView()
            com.didi.entrega.orderlist.component.Contract$IOrderListView r5 = (com.didi.entrega.orderlist.component.Contract.IOrderListView) r5
            r5.showNetError()
            goto L_0x006e
        L_0x005b:
            if (r5 != 0) goto L_0x005f
            r5 = 0
            goto L_0x0061
        L_0x005f:
            java.lang.String r5 = r5.message
        L_0x0061:
            java.lang.String r5 = r4.m15353a((java.lang.String) r5)
            com.didi.app.nova.skeleton.mvp.IView r2 = r4.getLogicView()
            com.didi.entrega.orderlist.component.Contract$IOrderListView r2 = (com.didi.entrega.orderlist.component.Contract.IOrderListView) r2
            r2.showServerError(r5)
        L_0x006e:
            com.didi.entrega.orderlist.data.OrderListDataSource r5 = r4.f20981b
            if (r5 != 0) goto L_0x0074
        L_0x0072:
            r5 = 0
            goto L_0x007b
        L_0x0074:
            int r5 = r5.getPageIndex()
            if (r5 != 0) goto L_0x0072
            r5 = 1
        L_0x007b:
            if (r5 == 0) goto L_0x0086
            com.didi.app.nova.skeleton.mvp.IView r5 = r4.getLogicView()
            com.didi.entrega.orderlist.component.Contract$IOrderListView r5 = (com.didi.entrega.orderlist.component.Contract.IOrderListView) r5
            r5.scrollToTop()
        L_0x0086:
            com.didi.entrega.orderlist.data.OrderListDataSource r5 = r4.f20981b
            if (r5 != 0) goto L_0x008c
        L_0x008a:
            r0 = 0
            goto L_0x0099
        L_0x008c:
            java.util.List r5 = r5.getTargetList()
            if (r5 != 0) goto L_0x0093
            goto L_0x008a
        L_0x0093:
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x008a
        L_0x0099:
            if (r0 == 0) goto L_0x009e
            r4.m15354a()
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.orderlist.component.OrderListPresenter.m15356a(com.didi.entrega.orderlist.component.OrderListPresenter, com.didi.entrega.customer.repo.CustomerResource):void");
    }

    /* renamed from: a */
    private final void m15354a() {
        OrderListDataSource orderListDataSource = this.f20981b;
        boolean z = false;
        if (orderListDataSource != null && !orderListDataSource.hasMore()) {
            z = true;
        }
        if (z) {
            ((Contract.IOrderListView) getLogicView()).showFooterNoMoreView();
        } else {
            ((Contract.IOrderListView) getLogicView()).showFooterEmptyView();
        }
    }

    public void initDataManagers() {
        super.initDataManagers();
        if (this.f20980a == null) {
            ChildDataListManager<OrderListItemModel> createChildDataListManager = createChildDataListManager();
            this.f20980a = createChildDataListManager;
            addDataManager(createChildDataListManager);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f20982c) {
            m15358b();
            this.f20982c = false;
            return;
        }
        doRefresh((Bundle) null, false);
    }

    public void onPullToRefresh() {
        doRefresh((Bundle) null, true);
    }

    public void doRefresh(Bundle bundle, boolean z) {
        if (!z) {
            ((Contract.IOrderListView) getLogicView()).showGlobalLoading();
        }
        ((Contract.IOrderListView) getLogicView()).hideAbnormalView();
        OrderListDataSource orderListDataSource = this.f20981b;
        if (orderListDataSource != null) {
            orderListDataSource.loadInit();
        }
    }

    public void onLoadMore() {
        OrderListDataSource orderListDataSource = this.f20981b;
        if (orderListDataSource != null && orderListDataSource.hasMore() && !((Contract.IOrderListView) getLogicView()).needBlockFooterLoading()) {
            ((Contract.IOrderListView) getLogicView()).showFooterLoadingView();
            orderListDataSource.loadNextPage();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        OrderListOmegaHelper orderListOmegaHelper = this.f20984e;
        ScopeContext scopeContext = getScopeContext();
        Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
        orderListOmegaHelper.detach(scopeContext);
    }

    public void buttonGroupClick(ButtonEntity buttonEntity, OrderListItemModel orderListItemModel) {
        Integer num;
        Intrinsics.checkNotNullParameter(orderListItemModel, "itemModel");
        ChildDataListManager<OrderListItemModel> childDataListManager = this.f20980a;
        OrderListOmegaHelper.Companion.getInstance().trackOrderButtonCK(orderListItemModel, childDataListManager == null ? null : Integer.valueOf(childDataListManager.indexOf(orderListItemModel)), buttonEntity == null ? null : Integer.valueOf(buttonEntity.getType()));
        if (buttonEntity == null) {
            num = null;
        } else {
            num = Integer.valueOf(buttonEntity.getType());
        }
        if (num != null && num.intValue() == 1) {
            ShareToolModel shareToolModel = new ShareToolModel();
            shareToolModel.title = buttonEntity.getTitle();
            shareToolModel.content = buttonEntity.getShareContent();
            shareToolModel.url = buttonEntity.getUrl();
            ShareHelper.getInstance().systemShare(GlobalContext.getContext(), shareToolModel, (ICallback.IPlatformShareCallback) null);
        } else if (num == null || num.intValue() != 2) {
            if (num == null || num.intValue() != 3) {
                goOrderPage(orderListItemModel);
            }
        }
    }

    /* renamed from: b */
    private final void m15358b() {
        OrderData orderData;
        OrderInfoEntity orderInfoById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderInfoById(this.f20983d.getOrderId());
        boolean z = false;
        if (!(orderInfoById == null || (orderData = orderInfoById.getOrderData()) == null || orderData.getStatus() != this.f20983d.getOrderStatus())) {
            z = true;
        }
        if (!z) {
            m15359c();
        }
    }

    /* renamed from: c */
    private final void m15359c() {
        CharSequence orderId = this.f20983d.getOrderId();
        if (!(orderId == null || orderId.length() == 0)) {
            CustomerRpcManagerProxy.get().getOrderInfo(this.f20983d.getOrderId(), this.f20983d.getCityId(), new OrderListPresenter$refreshOrderInfoById$callback$1(this));
        }
    }

    public void goOrderPage(OrderListItemModel orderListItemModel) {
        HistoryOrderInfoEntity orderInfo;
        Intrinsics.checkNotNullParameter(orderListItemModel, "itemModel");
        this.f20982c = true;
        m15355a(orderListItemModel);
        DiRouter.request().path("orderPage").putString("path", "/order_page").putInt("from", 3).putString("orderId", this.f20983d.getOrderId()).open();
        ChildDataListManager<OrderListItemModel> childDataListManager = this.f20980a;
        Integer num = null;
        Integer valueOf = childDataListManager == null ? null : Integer.valueOf(childDataListManager.indexOf(orderListItemModel));
        OrderListOmegaHelper instance = OrderListOmegaHelper.Companion.getInstance();
        String orderId = this.f20983d.getOrderId();
        OrderListItemEntity data = orderListItemModel.getData();
        if (!(data == null || (orderInfo = data.getOrderInfo()) == null)) {
            num = Integer.valueOf(orderInfo.getStatus());
        }
        instance.trackOrderCK(orderId, num, valueOf);
    }

    /* renamed from: a */
    private final String m15353a(String str) {
        CharSequence charSequence = str;
        return ((charSequence == null || charSequence.length() == 0) || StringsKt.contains$default(charSequence, (CharSequence) StringConst.JAVA, false, 2, (Object) null)) ? getContext().getResources().getString(R.string.FoodC_orderlist3_No_service_laow) : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r1 = r1.getOrderInfo();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m15355a(com.didi.entrega.orderlist.binder.OrderListItemModel r4) {
        /*
            r3 = this;
            com.didi.entrega.orderlist.component.ClickedModel r0 = r3.f20983d
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r1 = r4.getData()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            goto L_0x0015
        L_0x000a:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r1 = r1.getOrderInfo()
            if (r1 != 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            java.lang.String r2 = r1.getOrderId()
        L_0x0015:
            r0.setOrderId(r2)
            com.didi.entrega.orderlist.component.ClickedModel r0 = r3.f20983d
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r1 = r4.getData()
            r2 = 0
            if (r1 != 0) goto L_0x0023
        L_0x0021:
            r1 = 0
            goto L_0x002e
        L_0x0023:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r1 = r1.getOrderInfo()
            if (r1 != 0) goto L_0x002a
            goto L_0x0021
        L_0x002a:
            int r1 = r1.getCityId()
        L_0x002e:
            r0.setCityId(r1)
            com.didi.entrega.orderlist.component.ClickedModel r0 = r3.f20983d
            com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity r4 = r4.getData()
            if (r4 != 0) goto L_0x003a
            goto L_0x0045
        L_0x003a:
            com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderInfoEntity r4 = r4.getOrderInfo()
            if (r4 != 0) goto L_0x0041
            goto L_0x0045
        L_0x0041:
            int r2 = r4.getStatus()
        L_0x0045:
            r0.setOrderStatus(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.orderlist.component.OrderListPresenter.m15355a(com.didi.entrega.orderlist.binder.OrderListItemModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m15360d() {
        if (!this.f20982c) {
            this.f20983d.setOrderId((String) null);
            this.f20983d.setCityId(0);
            this.f20983d.setOrderStatus(0);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/component/OrderListPresenter$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderListPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
