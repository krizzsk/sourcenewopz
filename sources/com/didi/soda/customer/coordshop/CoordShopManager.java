package com.didi.soda.customer.coordshop;

import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.soda.customer.coordshop.finder.FinderVisibleDish;
import com.didi.soda.customer.coordshop.visitor.BlockShopItemVisitor;
import com.didi.soda.customer.coordshop.visitor.NativeShopItemVisitor;
import com.didi.soda.customer.coordshop.visitor.VisibleDishVisitor;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.datasource.page.dynamic.DynamicRecyclePresenter;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002JD\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\"\b\u0002\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopManager;", "", "()V", "coordHost", "Lcom/didi/soda/customer/coordshop/CoordHost;", "requestCoordShop", "Lcom/didi/soda/customer/coordshop/RequestCoordShop;", "shopSaver", "Lcom/didi/soda/customer/coordshop/ShopSaver;", "attachToHost", "", "present", "Lcom/didi/soda/customer/base/recycler/CustomerRecyclerPresenter;", "addCoordShopCard", "Lkotlin/Function2;", "", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "Lcom/didi/soda/customer/coordshop/AddCoordShopCard;", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "detachFromHost", "findCoordShopPredicate", "recyclerView", "getSaver", "triggerEnterBusinessEvent", "page", "Lcom/didi/soda/customer/base/pages/CustomerPage;", "triggerTopicSw", "shop", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "updateFilterStatus", "isOriginalFilter", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CoordShopManager.kt */
public final class CoordShopManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static CoordShopManager f40840d;

    /* renamed from: a */
    private final ShopSaver f40841a;

    /* renamed from: b */
    private final RequestCoordShop f40842b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CoordHost f40843c;

    public CoordShopManager() {
        ShopSaver shopSaver = new ShopSaver();
        shopSaver.addAddVisitor(new BlockShopItemVisitor());
        shopSaver.addAddVisitor(new NativeShopItemVisitor());
        shopSaver.addAddVisitor(new VisibleDishVisitor());
        Unit unit = Unit.INSTANCE;
        this.f40841a = shopSaver;
        this.f40842b = new RequestCoordShop(shopSaver);
    }

    public final ShopSaver getSaver() {
        return this.f40841a;
    }

    public final void updateFilterStatus(boolean z) {
        this.f40841a.setOriginalFilter(z);
    }

    public final void triggerEnterBusinessEvent(CustomerPage customerPage) {
        Intrinsics.checkNotNullParameter(customerPage, "page");
        if (!this.f40841a.checkAlreadyShowTimes() || !this.f40841a.isOriginalFilter()) {
            LogUtil.m29104i("Coord", "fail trigger coord when enter shop!!，" + this.f40841a.getPrintMsg() + " p2=" + this.f40841a.isOriginalFilter());
            return;
        }
        this.f40842b.triggerEnterBusinessEvent(customerPage, new CoordShopManager$triggerEnterBusinessEvent$1(customerPage, this));
    }

    public static /* synthetic */ void attachToHost$default(CoordShopManager coordShopManager, CustomerRecyclerPresenter customerRecyclerPresenter, Function2 function2, RecyclerView recyclerView, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            recyclerView = null;
        }
        coordShopManager.attachToHost(customerRecyclerPresenter, function2, recyclerView);
    }

    public final void attachToHost(CustomerRecyclerPresenter<?> customerRecyclerPresenter, Function2<? super Integer, ? super RecyclerModel, Unit> function2, RecyclerView recyclerView) {
        IBlockScope scope = customerRecyclerPresenter instanceof DynamicRecyclePresenter ? ((DynamicRecyclePresenter) customerRecyclerPresenter).getScope() : null;
        CoordHost coordHost = this.f40843c;
        if (coordHost != null) {
            Intrinsics.checkNotNull(coordHost);
            coordHost.detach();
        }
        CoordHost create = CoordHost.Companion.create(this.f40841a, scope, function2, recyclerView);
        this.f40843c = create;
        if (create != null) {
            create.attached();
        }
    }

    public final void detachFromHost() {
        CoordHost coordHost = this.f40843c;
        if (coordHost != null) {
            coordHost.detach();
        }
        this.f40843c = null;
    }

    public final void triggerTopicSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "shop");
        getSaver().triggerTopicSw(homeBusinessInfoRvModel);
    }

    public final void findCoordShopPredicate(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.f40841a.checkAlreadyShowTimes()) {
            new FinderVisibleDish(this.f40841a).findInRecycleView(recyclerView);
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/CoordShopManager$Companion;", "", "()V", "instance", "Lcom/didi/soda/customer/coordshop/CoordShopManager;", "get", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CoordShopManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CoordShopManager get() {
            if (CoordShopManager.f40840d == null) {
                CoordShopManager.f40840d = new CoordShopManager();
            }
            CoordShopManager access$getInstance$cp = CoordShopManager.f40840d;
            Intrinsics.checkNotNull(access$getInstance$cp);
            return access$getInstance$cp;
        }
    }
}
