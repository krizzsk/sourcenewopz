package com.didi.soda.customer.base.rxdux;

import com.appsflyer.internal.referrer.Payload;
import com.didi.app.nova.skeleton.Component;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.RouterTransaction;
import com.didi.app.nova.skeleton.internal.page.ControllerProxy;
import com.didi.app.nova.skeleton.internal.page.PageInstrumentImpl;
import com.didi.app.nova.skeleton.internal.page.PageWrapper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.jadux.AbsAction;
import com.didi.soda.jadux.Action;
import com.didi.soda.jadux.ActionFunction;
import com.didi.soda.jadux.Store;
import com.didi.soda.jadux.collection.JxArrayList;
import com.didi.soda.jadux.collection.JxList;
import com.didi.soda.jadux.function.MiddwareFunction;
import com.didi.soda.jadux.middleware.LogMiddleWare;
import com.didi.soda.jadux.middleware.ThunkMiddleware;
import com.didi.soda.jadux.utils.ActionTypes;
import p242io.reactivex.Single;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.functions.Function;
import p242io.reactivex.subjects.PublishSubject;
import p242io.reactivex.subjects.SingleSubject;

public final class SkeletonStore {
    public static final String TAG = "SkeletonStore";

    /* renamed from: a */
    private static SkeletonStore f40379a;

    /* renamed from: b */
    private static SkeletonStore f40380b = new SkeletonStore();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PublishSubject<Boolean> f40381c = PublishSubject.create();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f40382d = false;

    /* renamed from: e */
    private PageInstrument f40383e;

    private SkeletonStore() {
    }

    public static SkeletonStore getStore() {
        SkeletonStore skeletonStore = f40379a;
        return skeletonStore == null ? f40380b : skeletonStore;
    }

    public static void createStore(PageInstrument pageInstrument) {
        if (f40379a == null) {
            f40379a = new SkeletonStore();
            JxArrayList jxArrayList = new JxArrayList();
            jxArrayList.add(ThunkMiddleware.createThunkMiddleware());
            jxArrayList.add(LogMiddleWare.createLogMiddleware());
            m28634a(pageInstrument, (JxList<MiddwareFunction>) jxArrayList);
        }
    }

    public static void destory() {
        f40379a = null;
    }

    /* renamed from: a */
    private static void m28634a(PageInstrument pageInstrument, JxList<MiddwareFunction> jxList) {
        if (pageInstrument != null) {
            f40379a.f40383e = pageInstrument;
            return;
        }
        throw new IllegalArgumentException("Root scope must not be null!");
    }

    public Single<AbsAction> dispatch(AbsAction absAction) {
        if (absAction instanceof Action) {
            Action action = (Action) absAction;
            try {
                LogUtil.m29104i(TAG, Thread.currentThread().getName());
                LogUtil.m29100d(TAG, "Dispatch Action: " + action.getType() + "\nPayload:\n" + action.getPayload().toString());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (ActionTypes.UNKNOW.equals(action.getType())) {
                throw new IllegalArgumentException("Unknow action mType!");
            } else if (this.f40382d) {
                String str = " action = " + action.getType();
                LogUtil.m29104i(TAG, str);
                throw new IllegalStateException("Reducers may not dispatch actions. " + str);
            } else if (this.f40383e == null) {
                return Single.just(absAction);
            } else {
                SingleSubject create = SingleSubject.create();
                Single.just(action).flatMap(new Function<Action, SingleSource<?>>() {
                    public SingleSource<?> apply(Action action) throws Exception {
                        return SkeletonStore.this.m28633a(action);
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
                    public void accept(Disposable disposable) {
                        boolean unused = SkeletonStore.this.f40382d = true;
                        SkeletonStore.this.f40381c.onNext(Boolean.valueOf(SkeletonStore.this.f40382d));
                    }
                }).doFinally(new p242io.reactivex.functions.Action() {
                    public void run() throws Exception {
                        boolean unused = SkeletonStore.this.f40382d = false;
                        SkeletonStore.this.f40381c.onNext(Boolean.valueOf(SkeletonStore.this.f40382d));
                    }
                }).doOnSuccess(new Consumer<Object>() {
                    public void accept(Object obj) throws Exception {
                        boolean unused = SkeletonStore.this.f40382d = false;
                    }
                }).doOnError(new Consumer<Throwable>() {
                    public void accept(Throwable th) {
                        boolean unused = SkeletonStore.this.f40382d = false;
                        th.printStackTrace();
                    }
                }).subscribe(create);
                return create;
            }
        } else if (absAction instanceof ActionFunction) {
            throw new IllegalArgumentException("Please include ThunkMiddleware to deal with ActionFunction!");
        } else {
            throw new IllegalArgumentException("Action should be Action or ActionFunction!");
        }
    }

    public <T> Store<T> getScopeStore(Class<T> cls) {
        PageInstrumentImpl pageInstrumentImpl = (PageInstrumentImpl) this.f40383e;
        if (pageInstrumentImpl == null) {
            return null;
        }
        for (RouterTransaction controller : pageInstrumentImpl.f61861router.getBackstack()) {
            Controller controller2 = controller.controller();
            if (controller2 instanceof ControllerProxy) {
                PageWrapper page = ((ControllerProxy) controller2).getPage();
                Store<T> a = m28631a(page.getScopeContext(), cls);
                if (a != null) {
                    return a;
                }
                if (page instanceof RxduxPage) {
                    for (Component scopeContext : ((RxduxPage) page).f40378a) {
                        Store<T> a2 = m28631a(scopeContext.getScopeContext(), cls);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    private <T> Store<T> m28631a(ScopeContext scopeContext, Class<T> cls) {
        Store<T> store = (Store) scopeContext.getObject(scopeContext.alias() + Payload.TYPE_STORE);
        if (store != null && store.getStateClass().equals(cls)) {
            return store;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Single<Action> m28633a(Action action) {
        for (RouterTransaction controller : ((PageInstrumentImpl) this.f40383e).f61861router.getBackstack()) {
            Controller controller2 = controller.controller();
            if (controller2 instanceof ControllerProxy) {
                PageWrapper page = ((ControllerProxy) controller2).getPage();
                m28635a(page.getScopeContext(), action);
                if (page instanceof RxduxPage) {
                    for (Component scopeContext : ((RxduxPage) page).f40378a) {
                        m28635a(scopeContext.getScopeContext(), action);
                    }
                }
            }
        }
        return Single.just(action);
    }

    /* renamed from: a */
    private void m28635a(ScopeContext scopeContext, Action action) {
        Store store = (Store) scopeContext.getObject(scopeContext.alias() + Payload.TYPE_STORE);
        if (store != null) {
            store.dispatch(action);
        }
    }
}
