package com.didi.soda.customer.coordshop;

import android.util.Range;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020!J\u0006\u0010$\u001a\u00020\u0013J$\u0010%\u001a\u00020\u00132\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010'H\u0002J\u0006\u0010)\u001a\u00020\u0013J\u000e\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0013J\b\u0010,\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050.H\u0002J\u0006\u00100\u001a\u000201J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u000201J\u000e\u00105\u001a\u0002032\u0006\u00104\u001a\u000201J\"\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0006\u0010<\u001a\u00020\u0007J\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010>J\u000e\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010>J\u0006\u0010@\u001a\u00020\u0019J\u0006\u0010A\u001a\u00020\u0019J\u0010\u0010B\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0014\u0010C\u001a\u00020\u00192\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00010'J\u0016\u0010E\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007J\u0016\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u00072\u0006\u00108\u001a\u000209J\u0016\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007J\b\u0010M\u001a\u00020\u0019H\u0002J\u000e\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020PR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\u0004\u0018\u0001`\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, mo175978d2 = {"Lcom/didi/soda/customer/coordshop/ShopSaver;", "", "()V", "allSessionList", "", "Lcom/didi/soda/customer/coordshop/CollectedShopInfo;", "<set-?>", "", "alreadyShowTimes", "getAlreadyShowTimes", "()I", "Lcom/didi/soda/customer/coordshop/CoordShopInfo;", "coordShopInfo", "getCoordShopInfo", "()Lcom/didi/soda/customer/coordshop/CoordShopInfo;", "curSession", "Lcom/didi/soda/customer/coordshop/FeedSessionInfo;", "curVisibleDish", "isOriginalFilter", "", "()Z", "setOriginalFilter", "(Z)V", "onDataRefreshEvent", "Lkotlin/Function0;", "", "Lcom/didi/soda/customer/coordshop/DataRefreshEvent;", "getOnDataRefreshEvent", "()Lkotlin/jvm/functions/Function0;", "setOnDataRefreshEvent", "(Lkotlin/jvm/functions/Function0;)V", "visibleShopVisitor", "", "Lcom/didi/soda/customer/coordshop/ModelVisitor;", "addAddVisitor", "visitor", "checkAlreadyShowTimes", "checkIsRefresh", "oldItems", "", "newItems", "checkVisibleDishSize", "clearCoordShopInfo", "isInserted", "getCoordInfoForTest", "getCurVisibleShops", "", "getCurVisibleShopsInScreen", "getPrintMsg", "", "getRequestInfo", "Lcom/didi/soda/customer/coordshop/RequestInfo;", "enterShopId", "getRequestInfoTest", "getSaveDataFromModel", "indexInRv", "model", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "type", "Lcom/didi/soda/customer/coordshop/ModelVisitorType;", "getVisibleDishForTest", "getVisibleRange", "Landroid/util/Range;", "getVisibleRangeInScreen", "resetCurrentHostData", "resetVisibleDishWhenExitShop", "saveCoordShopInfo", "saveCurDisplayedItem", "allItems", "saveScreenVisibleChanged", "visibleFirst", "visibleLast", "saveVisibleDishWhenEnterShop", "position", "saveVisibleRange", "lower", "upper", "triggerRefreshEvent", "triggerTopicSw", "shop", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ShopSaver.kt */
public final class ShopSaver {

    /* renamed from: a */
    private Set<CollectedShopInfo> f40853a = new LinkedHashSet();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C13704a f40854b;

    /* renamed from: c */
    private Set<CollectedShopInfo> f40855c = new LinkedHashSet();

    /* renamed from: d */
    private CoordShopInfo f40856d;

    /* renamed from: e */
    private boolean f40857e = true;

    /* renamed from: f */
    private int f40858f;

    /* renamed from: g */
    private Function0<Unit> f40859g;

    /* renamed from: h */
    private List<ModelVisitor> f40860h = new ArrayList();

    public final CoordShopInfo getCoordShopInfo() {
        return this.f40856d;
    }

    public final boolean isOriginalFilter() {
        return this.f40857e;
    }

    public final void setOriginalFilter(boolean z) {
        this.f40857e = z;
    }

    public final int getAlreadyShowTimes() {
        return this.f40858f;
    }

    public final Function0<Unit> getOnDataRefreshEvent() {
        return this.f40859g;
    }

    public final void setOnDataRefreshEvent(Function0<Unit> function0) {
        this.f40859g = function0;
    }

    public final boolean checkAlreadyShowTimes() {
        LogUtil.m29100d("TAG", " >>>>>>>>> checkAlreadyShowTimes dish = " + this.f40858f + " max = " + ApolloCoordConfig.Companion.getMaxVisible());
        return this.f40858f < ApolloCoordConfig.Companion.getMaxVisible();
    }

    public final String getPrintMsg() {
        return "coordShop = " + this.f40856d + " showTimes = " + this.f40858f + " max = " + ApolloCoordConfig.Companion.getMaxVisible() + " visibleDish = " + this.f40855c.size() + " min = " + ApolloCoordConfig.Companion.getMinVisibleDish();
    }

    public final boolean checkVisibleDishSize() {
        LogUtil.m29100d("TAG", " >>>>>>>>> checkVisibleDishSize dish = " + this.f40855c.size() + " min = " + ApolloCoordConfig.Companion.getMinVisibleDish());
        return this.f40855c.size() >= ApolloCoordConfig.Companion.getMinVisibleDish();
    }

    /* renamed from: a */
    private final Set<CollectedShopInfo> m29024a() {
        Set<CollectedShopInfo> linkedHashSet = new LinkedHashSet<>();
        C13704a aVar = this.f40854b;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            CustomerExtentionKt.foreach(aVar.mo102841b(), new ShopSaver$getCurVisibleShops$1(this, linkedHashSet));
        }
        return linkedHashSet;
    }

    /* renamed from: b */
    private final Set<CollectedShopInfo> m29026b() {
        Set<CollectedShopInfo> linkedHashSet = new LinkedHashSet<>();
        C13704a aVar = this.f40854b;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            CustomerExtentionKt.foreach(aVar.mo102843c(), new ShopSaver$getCurVisibleShopsInScreen$1(this, linkedHashSet));
        }
        return linkedHashSet;
    }

    /* renamed from: c */
    private final void m29027c() {
        if (this.f40854b != null) {
            this.f40853a.addAll(m29024a());
            C13704a aVar = this.f40854b;
            Intrinsics.checkNotNull(aVar);
            int a = aVar.mo102837a();
            C13704a aVar2 = new C13704a();
            aVar2.mo102838a(a + 1);
            Unit unit = Unit.INSTANCE;
            this.f40854b = aVar2;
        }
        Function0<Unit> function0 = this.f40859g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void triggerTopicSw(HomeBusinessInfoRvModel homeBusinessInfoRvModel) {
        Intrinsics.checkNotNullParameter(homeBusinessInfoRvModel, "shop");
        Set<CollectedShopInfo> set = this.f40853a;
        String str = homeBusinessInfoRvModel.mShopId;
        Intrinsics.checkNotNullExpressionValue(str, "shop.mShopId");
        set.add(new CollectedShopInfo(str, 0, 0, 0, 14, (DefaultConstructorMarker) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.didi.soda.customer.coordshop.CollectedShopInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.didi.soda.customer.coordshop.CollectedShopInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.didi.soda.customer.coordshop.CollectedShopInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.didi.soda.customer.coordshop.CollectedShopInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: com.didi.soda.customer.coordshop.CollectedShopInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.didi.soda.customer.coordshop.CollectedShopInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.customer.coordshop.RequestInfo getRequestInfo(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "enterShopId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.didi.soda.customer.coordshop.RequestInfo r0 = new com.didi.soda.customer.coordshop.RequestInfo
            r0.<init>()
            com.didi.soda.customer.coordshop.ShopSaver$getRequestInfo$visitVisible$1 r1 = new com.didi.soda.customer.coordshop.ShopSaver$getRequestInfo$visitVisible$1
            r1.<init>(r0)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.didi.soda.customer.coordshop.ShopSaver$getRequestInfo$visitNearBy$1 r2 = new com.didi.soda.customer.coordshop.ShopSaver$getRequestInfo$visitNearBy$1
            r2.<init>(r7, r0)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            com.didi.soda.customer.coordshop.a r3 = r7.f40854b
            r4 = 0
            if (r3 == 0) goto L_0x0077
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            java.util.List r3 = r3.mo102844d()
            r2.invoke(r3)
            java.util.Set r2 = r7.m29024a()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r3 = r4
        L_0x0032:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x004f
            java.lang.Object r5 = r2.next()
            com.didi.soda.customer.coordshop.CollectedShopInfo r5 = (com.didi.soda.customer.coordshop.CollectedShopInfo) r5
            java.util.Set<com.didi.soda.customer.coordshop.CollectedShopInfo> r6 = r7.f40853a
            r6.add(r5)
            java.lang.String r6 = r5.getShopId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x0032
            r3 = r5
            goto L_0x0032
        L_0x004f:
            java.util.Set r2 = r7.m29026b()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0059:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0071
            java.lang.Object r5 = r2.next()
            r6 = r5
            com.didi.soda.customer.coordshop.CollectedShopInfo r6 = (com.didi.soda.customer.coordshop.CollectedShopInfo) r6
            java.lang.String r6 = r6.getShopId()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x0059
            r4 = r5
        L_0x0071:
            com.didi.soda.customer.coordshop.CollectedShopInfo r4 = (com.didi.soda.customer.coordshop.CollectedShopInfo) r4
            if (r4 == 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r4 = r3
        L_0x0077:
            if (r4 == 0) goto L_0x008a
            com.didi.soda.customer.coordshop.RequestInfo$Companion r8 = com.didi.soda.customer.coordshop.RequestInfo.Companion
            com.didi.soda.customer.foundation.rpc.entity.CoordShopRequestEntity r8 = r8.createCoordShopRequestEntity(r4)
            r0.setCurEnterShop(r8)
            int r8 = r4.getIndexInRv()
            r0.setIndexInRv(r8)
            goto L_0x00b0
        L_0x008a:
            java.lang.String r2 = "tech_sailing_c_coord_shop_error"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r2 = com.didi.soda.customer.foundation.tracker.OmegaTracker.Builder.create(r2)
            r3 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "error_type"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r2 = r2.addEventParam(r4, r3)
            java.lang.String r3 = "没有找到进店id = "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r8)
            java.lang.String r3 = "error_msg"
            com.didi.soda.customer.foundation.tracker.OmegaTracker$Builder r8 = r2.addEventParam(r3, r8)
            com.didi.soda.customer.foundation.tracker.OmegaTracker r8 = r8.build()
            r8.track()
        L_0x00b0:
            java.util.Set<com.didi.soda.customer.coordshop.CollectedShopInfo> r8 = r7.f40853a
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x00b8:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L_0x00c8
            java.lang.Object r2 = r8.next()
            com.didi.soda.customer.coordshop.CollectedShopInfo r2 = (com.didi.soda.customer.coordshop.CollectedShopInfo) r2
            r1.invoke(r2)
            goto L_0x00b8
        L_0x00c8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.coordshop.ShopSaver.getRequestInfo(java.lang.String):com.didi.soda.customer.coordshop.RequestInfo");
    }

    public final void saveCoordShopInfo(CoordShopInfo coordShopInfo) {
        this.f40856d = coordShopInfo;
    }

    public final void clearCoordShopInfo(boolean z) {
        this.f40856d = null;
        if (z) {
            this.f40858f++;
        }
    }

    public final void addAddVisitor(ModelVisitor modelVisitor) {
        Intrinsics.checkNotNullParameter(modelVisitor, "visitor");
        this.f40860h.add(modelVisitor);
    }

    public final void saveVisibleDishWhenEnterShop(int i, RecyclerModel recyclerModel) {
        Intrinsics.checkNotNullParameter(recyclerModel, "model");
        CollectedShopInfo a = m29023a(i, recyclerModel, ModelVisitorType.Business);
        if (a != null) {
            this.f40855c.add(a);
        }
    }

    public final void resetVisibleDishWhenExitShop() {
        this.f40855c.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final CollectedShopInfo m29023a(int i, RecyclerModel recyclerModel, ModelVisitorType modelVisitorType) {
        Collection arrayList = new ArrayList();
        for (Object next : this.f40860h) {
            if (((ModelVisitor) next).getType() == modelVisitorType) {
                arrayList.add(next);
            }
        }
        for (ModelVisitor visit : (List) arrayList) {
            CollectedShopInfo visit2 = visit.visit(i, recyclerModel);
            if (visit2 != null) {
                return visit2;
            }
        }
        return null;
    }

    /* renamed from: a */
    private final boolean m29025a(List<? extends Object> list, List<? extends Object> list2) {
        if (!(!list2.isEmpty()) || list2.size() >= list.size()) {
            return !Intrinsics.areEqual(CollectionUtilsKt.safeGet(list, 1), CollectionUtilsKt.safeGet(list2, 1));
        }
        return true;
    }

    public final void saveCurDisplayedItem(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "allItems");
        if (this.f40854b == null) {
            this.f40854b = new C13704a();
        }
        C13704a aVar = this.f40854b;
        Intrinsics.checkNotNull(aVar);
        if (m29025a(aVar.mo102844d(), list)) {
            LogUtil.m29100d("TAG", " >>>>>>>>> 下拉刷新 <<<<<<<<<");
            m29027c();
        } else {
            LogUtil.m29100d("TAG", " >>>>>>>>> 不是下拉刷新 <<<<<<<<<");
        }
        C13704a aVar2 = this.f40854b;
        Intrinsics.checkNotNull(aVar2);
        aVar2.mo102844d().clear();
        C13704a aVar3 = this.f40854b;
        Intrinsics.checkNotNull(aVar3);
        aVar3.mo102844d().addAll(list);
    }

    public final void saveVisibleRange(int i, int i2) {
        if (this.f40854b == null) {
            this.f40854b = new C13704a();
        }
        C13704a aVar = this.f40854b;
        Intrinsics.checkNotNull(aVar);
        aVar.mo102839a((Range<Integer>) new Range(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public final void saveScreenVisibleChanged(int i, int i2) {
        if (this.f40854b == null) {
            this.f40854b = new C13704a();
        }
        C13704a aVar = this.f40854b;
        Intrinsics.checkNotNull(aVar);
        aVar.mo102842b(new Range(Integer.valueOf(i), Integer.valueOf(i2)));
    }

    public final void resetCurrentHostData() {
        this.f40855c.clear();
        this.f40854b = null;
        this.f40856d = null;
        this.f40857e = true;
    }

    public final RequestInfo getRequestInfoTest(String str) {
        Intrinsics.checkNotNullParameter(str, "enterShopId");
        return getRequestInfo(str);
    }

    public final int getVisibleDishForTest() {
        return this.f40855c.size();
    }

    public final Range<Integer> getVisibleRange() {
        C13704a aVar = this.f40854b;
        if (aVar == null) {
            return null;
        }
        return aVar.mo102841b();
    }

    public final Range<Integer> getVisibleRangeInScreen() {
        C13704a aVar = this.f40854b;
        if (aVar == null) {
            return null;
        }
        return aVar.mo102843c();
    }

    public final CoordShopInfo getCoordInfoForTest() {
        return this.f40856d;
    }
}
