package com.didi.soda.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eJ \u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012R&\u0010\u0004\u001a\u001a\u0012\b\u0012\u00060\u0006R\u00020\u00000\u0005j\f\u0012\b\u0012\u00060\u0006R\u00020\u0000`\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/soda/home/manager/RouterCloseRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/home/manager/RouterCloseRepo$CloseModel;", "()V", "routerSubscriptionList", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/manager/RouterCloseRepo$RouterSubscription;", "Lkotlin/collections/ArrayList;", "setValue", "", "value", "subscribeClose", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "action", "Lcom/didi/app/nova/skeleton/repo/Action1;", "subscribeShutViscidity", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "Lcom/didi/app/nova/skeleton/repo/Action;", "AllCateGoryPageCloseModel", "CloseModel", "Companion", "RouterSubscription", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RouterCloseRepo.kt */
public final class RouterCloseRepo extends Repo<CloseModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ArrayList<RouterSubscription> f42682a = new ArrayList<>();

    @Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/soda/home/manager/RouterCloseRepo$CloseModel;", "", "()V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RouterCloseRepo.kt */
    public static abstract class CloseModel {
    }

    @JvmStatic
    public static final ParameterizedType getType(Class<?> cls, Type... typeArr) {
        return Companion.getType(cls, typeArr);
    }

    public final Subscription subscribeShutViscidity(ScopeContext scopeContext, Action<CloseModel> action) {
        Subscription subscribe = getLiveData().from().shutViscidityNotice().subscribe(scopeContext, action);
        Intrinsics.checkNotNullExpressionValue(subscribe, "liveData.from().shutVisc…ribe(pageContext, action)");
        return subscribe;
    }

    public final Subscription subscribeClose(Action1<CloseModel> action1) {
        RouterSubscription routerSubscription = new RouterSubscription(this, action1);
        this.f42682a.add(routerSubscription);
        return routerSubscription;
    }

    public void setValue(CloseModel closeModel) {
        Action1<CloseModel> action;
        super.setValue(closeModel);
        Iterator<RouterSubscription> it = this.f42682a.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "routerSubscriptionList.iterator()");
        while (it.hasNext()) {
            RouterSubscription next = it.next();
            if (next != null && next.isUnsubscribed()) {
                next.unsubscribe();
            } else if (!(next.getAction() == null || (action = next.getAction()) == null)) {
                action.call(closeModel);
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/home/manager/RouterCloseRepo$RouterSubscription;", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "action", "Lcom/didi/app/nova/skeleton/repo/Action1;", "Lcom/didi/soda/home/manager/RouterCloseRepo$CloseModel;", "(Lcom/didi/soda/home/manager/RouterCloseRepo;Lcom/didi/app/nova/skeleton/repo/Action1;)V", "getAction", "()Lcom/didi/app/nova/skeleton/repo/Action1;", "setAction", "(Lcom/didi/app/nova/skeleton/repo/Action1;)V", "mActive", "", "activeChange", "", "active", "isUnsubscribed", "unsubscribe", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RouterCloseRepo.kt */
    public final class RouterSubscription implements Subscription {
        private Action1<CloseModel> action;
        private boolean mActive = true;
        final /* synthetic */ RouterCloseRepo this$0;

        public final Action1<CloseModel> getAction() {
            return this.action;
        }

        public final void setAction(Action1<CloseModel> action1) {
            this.action = action1;
        }

        public RouterSubscription(RouterCloseRepo routerCloseRepo, Action1<CloseModel> action1) {
            Intrinsics.checkNotNullParameter(routerCloseRepo, "this$0");
            this.this$0 = routerCloseRepo;
            this.action = action1;
        }

        public boolean isUnsubscribed() {
            return !this.mActive;
        }

        public void unsubscribe() {
            this.mActive = false;
            this.this$0.f42682a.remove(this);
        }

        public void activeChange(boolean z) {
            this.mActive = z;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/home/manager/RouterCloseRepo$AllCateGoryPageCloseModel;", "Lcom/didi/soda/home/manager/RouterCloseRepo$CloseModel;", "()V", "cateId", "", "getCateId", "()Ljava/lang/String;", "setCateId", "(Ljava/lang/String;)V", "from", "getFrom", "setFrom", "recId", "getRecId", "setRecId", "url", "getUrl", "setUrl", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RouterCloseRepo.kt */
    public static final class AllCateGoryPageCloseModel extends CloseModel {
        private String cateId = "";
        private String from = "";
        private String recId = "";
        private String url = "";

        public final String getFrom() {
            return this.from;
        }

        public final void setFrom(String str) {
            this.from = str;
        }

        public final String getRecId() {
            return this.recId;
        }

        public final void setRecId(String str) {
            this.recId = str;
        }

        public final String getCateId() {
            return this.cateId;
        }

        public final void setCateId(String str) {
            this.cateId = str;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/manager/RouterCloseRepo$Companion;", "", "()V", "getType", "Ljava/lang/reflect/ParameterizedType;", "raw", "Ljava/lang/Class;", "args", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/Class;[Ljava/lang/reflect/Type;)Ljava/lang/reflect/ParameterizedType;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RouterCloseRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ParameterizedType getType(Class<?> cls, Type... typeArr) {
            Intrinsics.checkNotNullParameter(cls, "raw");
            Intrinsics.checkNotNullParameter(typeArr, "args");
            return new RouterCloseRepo$Companion$getType$1(cls, typeArr);
        }
    }
}
