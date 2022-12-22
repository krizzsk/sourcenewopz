package com.didi.entrega.orderlist.data;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.entrega.customer.datasource.listener.DataSourceListener;
import com.didi.entrega.customer.datasource.listener.PageEventListener;
import com.didi.entrega.customer.datasource.listener.PayloadProvider;
import com.didi.entrega.customer.datasource.page.PageController;
import com.didi.entrega.customer.datasource.page.PageStore;
import com.didi.entrega.customer.datasource.page.UpdateUtils;
import com.didi.entrega.customer.datasource.parser.FeedPayload;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.rpc.entity.order.HistoryOrderListEntity;
import com.didi.entrega.customer.foundation.rpc.entity.order.OrderListItemEntity;
import com.didi.entrega.customer.repo.CustomerResource;
import com.didi.entrega.orderlist.binder.OrderListItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005B\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u001b\u001a\u00020\u0014J\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ.\u0010!\u001a\u00020\u001f2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020\u001f2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010$H\u0016J\u001a\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010*\u001a\u00020\u001f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010-\u001a\u00020\u001f2\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rJ\u001a\u0010/\u001a\u00020\u001f2\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rJ\u001a\u00100\u001a\u00020\u001f2\u0012\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\rJ&\u00101\u001a\u00020\u001f2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001032\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u000105R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R6\u0010\u000b\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r`\u000fX\u0004¢\u0006\u0002\n\u0000R6\u0010\u0010\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\r`\u000fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R6\u0010\u0015\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\r0\fj\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\r`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000¨\u00066"}, mo175978d2 = {"Lcom/didi/entrega/orderlist/data/OrderListDataSource;", "Lcom/didi/entrega/customer/datasource/listener/PageEventListener;", "Ljava/lang/Void;", "Lcom/didi/entrega/customer/datasource/listener/PayloadProvider;", "Lcom/didi/entrega/customer/datasource/parser/FeedPayload;", "Lcom/didi/entrega/customer/datasource/listener/DataSourceListener;", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/OrderListItemEntity;", "Lcom/didi/entrega/orderlist/binder/OrderListItemModel;", "()V", "mHasMore", "", "mListChangeActions", "Ljava/util/ArrayList;", "Lcom/didi/app/nova/skeleton/repo/Action1;", "", "Lkotlin/collections/ArrayList;", "mListUpdateActions", "mPageController", "Lcom/didi/entrega/customer/datasource/page/PageController;", "mPageIndex", "", "mPageResultActions", "Lcom/didi/entrega/customer/repo/CustomerResource;", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/HistoryOrderListEntity;", "mPageSize", "mPageStore", "Lcom/didi/entrega/customer/datasource/page/PageStore;", "getPageIndex", "getTargetList", "hasMore", "loadInit", "", "loadNextPage", "onDataSourceChanged", "pageStorage", "listData", "", "onDataSourceUpdate", "updatedList", "onPageLoad", "key", "param", "onPageLoadedResult", "favouriteEntity", "providePayload", "subscribeListChanged", "action", "subscribeListUpdate", "subscribePageResult", "update", "diffCallback", "Lcom/didi/entrega/customer/datasource/page/UpdateUtils$DiffCallback;", "updateCallback", "Lcom/didi/entrega/customer/datasource/page/UpdateUtils$UpdateCallback;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderListDataSource.kt */
public final class OrderListDataSource implements DataSourceListener<OrderListItemEntity, OrderListItemModel>, PageEventListener<Void>, PayloadProvider<FeedPayload> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f20989a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f20990b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f20991c;

    /* renamed from: d */
    private PageStore<OrderListItemEntity, OrderListItemModel> f20992d = new PageStore<>(new OrderListDataMapFunction(this), this);
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PageController<Void, OrderListItemEntity> f20993e;

    /* renamed from: f */
    private final ArrayList<Action1<CustomerResource<HistoryOrderListEntity>>> f20994f = new ArrayList<>();

    /* renamed from: g */
    private final ArrayList<Action1<List<OrderListItemModel>>> f20995g = new ArrayList<>();

    /* renamed from: h */
    private final ArrayList<Action1<List<OrderListItemModel>>> f20996h = new ArrayList<>();

    public FeedPayload providePayload() {
        return null;
    }

    public OrderListDataSource() {
        PageController<Void, OrderListItemEntity> pageController = new PageController<>();
        this.f20993e = pageController;
        if (pageController != null) {
            pageController.initialize(0, this, this.f20992d);
        }
    }

    public final void loadInit() {
        PageController<Void, OrderListItemEntity> pageController = this.f20993e;
        if (pageController != null) {
            pageController.loadInit();
        }
    }

    public final void loadNextPage() {
        PageController<Void, OrderListItemEntity> pageController = this.f20993e;
        if (pageController != null) {
            pageController.loadNextPage();
        }
    }

    public final List<OrderListItemModel> getTargetList() {
        PageStore<OrderListItemEntity, OrderListItemModel> pageStore = this.f20992d;
        if (pageStore == null) {
            return null;
        }
        return pageStore.getTargetList();
    }

    public final void update(UpdateUtils.DiffCallback<OrderListItemModel> diffCallback, UpdateUtils.UpdateCallback<OrderListItemModel> updateCallback) {
        PageStore<OrderListItemEntity, OrderListItemModel> pageStore = this.f20992d;
        if (pageStore != null) {
            pageStore.update(diffCallback, updateCallback);
        }
    }

    public final int getPageIndex() {
        return this.f20989a;
    }

    public final boolean hasMore() {
        return this.f20991c;
    }

    public void onPageLoad(int i, Void voidR) {
        this.f20989a = i;
        CustomerRpcManagerProxy.get().getOrderList(this.f20989a, new OrderListDataSource$onPageLoad$callback$1(this));
    }

    public final void subscribePageResult(Action1<CustomerResource<HistoryOrderListEntity>> action1) {
        Intrinsics.checkNotNullParameter(action1, "action");
        this.f20994f.add(action1);
    }

    public final void subscribeListChanged(Action1<List<OrderListItemModel>> action1) {
        Intrinsics.checkNotNullParameter(action1, "action");
        this.f20995g.add(action1);
    }

    public final void subscribeListUpdate(Action1<List<OrderListItemModel>> action1) {
        Intrinsics.checkNotNullParameter(action1, "action");
        this.f20996h.add(action1);
    }

    public final void onPageLoadedResult(CustomerResource<HistoryOrderListEntity> customerResource) {
        Intrinsics.checkNotNullParameter(customerResource, "favouriteEntity");
        Iterator<Action1<CustomerResource<HistoryOrderListEntity>>> it = this.f20994f.iterator();
        while (it.hasNext()) {
            it.next().call(customerResource);
        }
    }

    public void onDataSourceChanged(PageStore<OrderListItemEntity, OrderListItemModel> pageStore, List<OrderListItemModel> list) {
        Iterator<Action1<List<OrderListItemModel>>> it = this.f20995g.iterator();
        while (it.hasNext()) {
            it.next().call(list);
        }
    }

    public void onDataSourceUpdate(List<OrderListItemModel> list) {
        Iterator<Action1<List<OrderListItemModel>>> it = this.f20996h.iterator();
        while (it.hasNext()) {
            it.next().call(list);
        }
    }
}
