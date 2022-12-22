package com.didi.soda.customer.coordshop;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.coordshop.CoordShopDisplayInfo;
import com.didi.soda.customer.coordshop.finder.FinderAllItem;
import com.didi.soda.customer.coordshop.finder.FinderVisibleShop;
import com.didi.soda.customer.coordshop.finder.IFinder;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.CoordShopEntity;
import com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 (2\u00020\u0001:\u0001(B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\tH\u0002J\b\u0010'\u001a\u00020\tH\u0002R4\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006j\u0004\u0018\u0001`\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordHost;", "", "shopSaver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "(Lcom/didi/soda/customer/coordshop/ShopSaver;)V", "addCoordShopCard", "Lkotlin/Function2;", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "", "Lcom/didi/soda/customer/coordshop/AddCoordShopCard;", "getAddCoordShopCard", "()Lkotlin/jvm/functions/Function2;", "setAddCoordShopCard", "(Lkotlin/jvm/functions/Function2;)V", "finders", "", "Lcom/didi/soda/customer/coordshop/finder/IFinder;", "getFinders", "()Ljava/util/List;", "setFinders", "(Ljava/util/List;)V", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycleView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecycleView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "getScope", "()Lcom/didi/soda/blocks/scope/IBlockScope;", "setScope", "(Lcom/didi/soda/blocks/scope/IBlockScope;)V", "attached", "detach", "listenBackFromBusiness", "runAnim", "shouCoordShopInFeed", "triggerRefreshEvent", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CoordHost.kt */
public final class CoordHost {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final ShopSaver f40829a;

    /* renamed from: b */
    private IBlockScope f40830b;

    /* renamed from: c */
    private Function2<? super Integer, ? super RecyclerModel, Unit> f40831c;

    /* renamed from: d */
    private RecyclerView f40832d;

    /* renamed from: e */
    private List<? extends IFinder> f40833e;

    public CoordHost(ShopSaver shopSaver) {
        Intrinsics.checkNotNullParameter(shopSaver, "shopSaver");
        this.f40829a = shopSaver;
        this.f40833e = CollectionsKt.listOf(new FinderVisibleShop(shopSaver), new FinderAllItem(this.f40829a));
    }

    public final IBlockScope getScope() {
        return this.f40830b;
    }

    public final void setScope(IBlockScope iBlockScope) {
        this.f40830b = iBlockScope;
    }

    public final Function2<Integer, RecyclerModel, Unit> getAddCoordShopCard() {
        return this.f40831c;
    }

    public final void setAddCoordShopCard(Function2<? super Integer, ? super RecyclerModel, Unit> function2) {
        this.f40831c = function2;
    }

    public final RecyclerView getRecycleView() {
        return this.f40832d;
    }

    public final void setRecycleView(RecyclerView recyclerView) {
        this.f40832d = recyclerView;
    }

    public final List<IFinder> getFinders() {
        return this.f40833e;
    }

    public final void setFinders(List<? extends IFinder> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f40833e = list;
    }

    public final void attached() {
        if (this.f40832d != null) {
            for (IFinder findInRecycleView : this.f40833e) {
                RecyclerView recycleView = getRecycleView();
                Intrinsics.checkNotNull(recycleView);
                findInRecycleView.findInRecycleView(recycleView);
            }
        }
        this.f40829a.setOnDataRefreshEvent(new CoordHost$attached$2(this));
    }

    public final void detach() {
        this.f40829a.setOnDataRefreshEvent((Function0<Unit>) null);
        this.f40829a.resetCurrentHostData();
        for (IFinder clear : this.f40833e) {
            clear.clear();
        }
        this.f40831c = null;
        this.f40832d = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29014a() {
        if (this.f40832d != null) {
            for (IFinder refresh : this.f40833e) {
                RecyclerView recycleView = getRecycleView();
                Intrinsics.checkNotNull(recycleView);
                refresh.refresh(recycleView);
            }
        }
    }

    /* renamed from: a */
    private final void m29015a(RecyclerView recyclerView) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(300);
        defaultItemAnimator.setRemoveDuration(300);
        recyclerView.setItemAnimator(defaultItemAnimator);
        recyclerView.postDelayed(new Runnable(itemAnimator) {
            public final /* synthetic */ RecyclerView.ItemAnimator f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                CoordHost.m29016a(RecyclerView.this, this.f$1);
            }
        }, 300);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m29016a(RecyclerView recyclerView, RecyclerView.ItemAnimator itemAnimator) {
        Intrinsics.checkNotNullParameter(recyclerView, "$recycleView");
        recyclerView.setItemAnimator(itemAnimator);
    }

    /* renamed from: b */
    private final void m29017b() {
        CoordShopInfo coordShopInfo = this.f40829a.getCoordShopInfo();
        CoordShopEntity entity = coordShopInfo == null ? null : coordShopInfo.getEntity();
        if (this.f40829a.getCoordShopInfo() == null || entity == null) {
            this.f40829a.clearCoordShopInfo(false);
            LogUtil.m29104i("Coord", "show coord fail ，shop=" + this.f40829a.getCoordShopInfo() + " entity=" + entity);
            return;
        }
        CoordShopInfo coordShopInfo2 = this.f40829a.getCoordShopInfo();
        Intrinsics.checkNotNull(coordShopInfo2);
        int indexInRv = coordShopInfo2.getRequestInfo().getIndexInRv();
        CoordShopInfo coordShopInfo3 = this.f40829a.getCoordShopInfo();
        Intrinsics.checkNotNull(coordShopInfo3);
        String traceId = coordShopInfo3.getTraceId();
        int alreadyShowTimes = this.f40829a.getAlreadyShowTimes();
        CoordShopDisplayInfo.Companion companion = CoordShopDisplayInfo.Companion;
        IBlockScope iBlockScope = this.f40830b;
        CoordShopInfo coordShopInfo4 = this.f40829a.getCoordShopInfo();
        Intrinsics.checkNotNull(coordShopInfo4);
        RecyclerModel create = companion.create(iBlockScope, coordShopInfo4.getRequestInfo(), entity, traceId, alreadyShowTimes);
        if (create == null || indexInRv <= 0) {
            this.f40829a.clearCoordShopInfo(false);
            return;
        }
        LogUtil.m29104i("Coord", Intrinsics.stringPlus(">>>>> show coord shop: recId=", entity.recId));
        Function2<? super Integer, ? super RecyclerModel, Unit> function2 = this.f40831c;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(indexInRv), create);
        }
        RecyclerView recyclerView = this.f40832d;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            m29015a(recyclerView);
        }
        this.f40829a.clearCoordShopInfo(true);
        if (!this.f40829a.checkAlreadyShowTimes()) {
            detach();
        }
    }

    public final void listenBackFromBusiness() {
        RequestInfo requestInfo;
        CoordShopRequestEntity curEnterShop;
        if (!this.f40829a.checkAlreadyShowTimes() || !this.f40829a.checkVisibleDishSize()) {
            LogUtil.m29104i("Coord", Intrinsics.stringPlus("显示协同失败，", this.f40829a.getPrintMsg()));
            if (this.f40829a.getCoordShopInfo() != null) {
                OmegaTracker.Builder create = OmegaTracker.Builder.create(EventConst.Home.SAILING_C_X_HOME_COORD_REQUEST_SUCCESS);
                CoordShopInfo coordShopInfo = this.f40829a.getCoordShopInfo();
                String str = null;
                if (!(coordShopInfo == null || (requestInfo = coordShopInfo.getRequestInfo()) == null || (curEnterShop = requestInfo.getCurEnterShop()) == null)) {
                    str = curEnterShop.shopId;
                }
                if (str == null) {
                    str = "";
                }
                create.addEventParam("shop_id", str).build().track();
                return;
            }
            return;
        }
        m29017b();
    }

    @Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\"\b\u0002\u0010\t\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\u0004\u0018\u0001`\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordHost$Companion;", "", "()V", "create", "Lcom/didi/soda/customer/coordshop/CoordHost;", "shopSaver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "addCoordShopCard", "Lkotlin/Function2;", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "", "Lcom/didi/soda/customer/coordshop/AddCoordShopCard;", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CoordHost.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CoordHost create$default(Companion companion, ShopSaver shopSaver, IBlockScope iBlockScope, Function2 function2, RecyclerView recyclerView, int i, Object obj) {
            if ((i & 4) != 0) {
                function2 = null;
            }
            if ((i & 8) != 0) {
                recyclerView = null;
            }
            return companion.create(shopSaver, iBlockScope, function2, recyclerView);
        }

        public final CoordHost create(ShopSaver shopSaver, IBlockScope iBlockScope, Function2<? super Integer, ? super RecyclerModel, Unit> function2, RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(shopSaver, "shopSaver");
            CoordHost coordHost = new CoordHost(shopSaver);
            coordHost.setScope(iBlockScope);
            coordHost.setAddCoordShopCard(function2);
            coordHost.setRecycleView(recyclerView);
            return coordHost;
        }
    }
}
