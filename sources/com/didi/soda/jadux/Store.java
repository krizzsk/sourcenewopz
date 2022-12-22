package com.didi.soda.jadux;

import com.didi.soda.jadux.collection.JxArrayList;
import com.didi.soda.jadux.collection.JxList;
import com.didi.soda.jadux.function.DispatchFunction;
import com.didi.soda.jadux.function.MiddwareFunction;
import com.didi.soda.jadux.middleware.LogMiddleWare;
import com.didi.soda.jadux.middleware.ThunkMiddleware;
import com.didi.soda.jadux.utils.ActionTypes;
import com.google.gson.Gson;
import p242io.reactivex.Single;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.functions.Action;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.functions.Function;
import p242io.reactivex.subjects.BehaviorSubject;
import p242io.reactivex.subjects.PublishSubject;
import p242io.reactivex.subjects.SingleSubject;

public class Store<State> {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Gson f43352d = new Gson();
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f43353a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Reducer<State> f43354b;

    /* renamed from: c */
    private String f43355c = null;
    public DispatchFunction dispatchFunction = new DispatchFunction() {
        public Single<AbsAction> apply(AbsAction absAction) {
            return Store.this.dispatch(absAction);
        }
    };
    protected PublishSubject<Boolean> dispatchingSubject = PublishSubject.create();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Class<State> f43356e = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f43357f = false;
    protected BehaviorSubject<State> publishSubject;

    /* renamed from: a */
    private void m30656a(JxList<MiddwareFunction> jxList) {
    }

    public void destroyStore() {
    }

    public Store createStore(Reducer<State> reducer, State state) {
        JxArrayList jxArrayList = new JxArrayList();
        jxArrayList.add(ThunkMiddleware.createThunkMiddleware());
        jxArrayList.add(LogMiddleWare.createLogMiddleware());
        m30654a(reducer, state, jxArrayList);
        return this;
    }

    /* renamed from: a */
    private Store m30654a(Reducer<State> reducer, State state, JxList<MiddwareFunction> jxList) {
        if (reducer != null) {
            this.f43354b = reducer;
            if (state != null) {
                this.f43356e = state.getClass();
            }
            String json = f43352d.toJson((Object) state);
            this.f43353a = json;
            this.f43355c = json;
            this.publishSubject = BehaviorSubject.createDefault(state);
            m30656a(jxList);
            return this;
        }
        throw new IllegalArgumentException("reducer must not be null!");
    }

    public Single<AbsAction> dispatch(final AbsAction absAction) {
        if (absAction instanceof Action) {
            Action action = (Action) absAction;
            if (ActionTypes.UNKNOW.equals(action.getType())) {
                throw new IllegalArgumentException("Unknow action type!");
            } else if (this.f43357f) {
                throw new IllegalStateException("Reducers may not dispatch actions.");
            } else if (this.f43354b != null) {
                SingleSubject create = SingleSubject.create();
                Single.just(action).map(new Function<Action, State>() {
                    public State apply(Action action) throws Exception {
                        return Store.this.f43354b.reduce(Store.f43352d.fromJson(Store.this.f43353a, Store.this.f43356e), action);
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
                    public void accept(Disposable disposable) {
                        boolean unused = Store.this.f43357f = true;
                        Store.this.dispatchingSubject.onNext(Boolean.valueOf(Store.this.f43357f));
                    }
                }).doFinally(new Action() {
                    public void run() throws Exception {
                        boolean unused = Store.this.f43357f = false;
                        Store.this.dispatchingSubject.onNext(Boolean.valueOf(Store.this.f43357f));
                    }
                }).doOnSuccess(new Consumer<State>() {
                    public void accept(State state) {
                        boolean unused = Store.this.f43357f = false;
                        Store.this.update(state);
                    }
                }).doOnError(new Consumer<Throwable>() {
                    public void accept(Throwable th) {
                        boolean unused = Store.this.f43357f = false;
                        th.printStackTrace();
                    }
                }).map(new Function<State, AbsAction>() {
                    public AbsAction apply(State state) {
                        return absAction;
                    }
                }).subscribe(create);
                return create;
            } else {
                throw new IllegalStateException("Call createStore first to init the store!");
            }
        } else if (absAction instanceof ActionFunction) {
            throw new IllegalArgumentException("Please include ThunkMiddleware to deal with ActionFunction!");
        } else {
            throw new IllegalArgumentException("Action should be Action or ActionFunction!");
        }
    }

    /* access modifiers changed from: protected */
    public void update(State state) {
        String json = f43352d.toJson((Object) state);
        if (!this.f43353a.equals(json)) {
            this.f43353a = json;
            this.publishSubject.onNext(state);
        }
    }

    public Disposable subscribe(Consumer<State> consumer, Consumer<Throwable> consumer2) {
        return this.publishSubject.subscribe(consumer, consumer2);
    }

    public Disposable subscribe(Consumer<State> consumer) {
        return this.publishSubject.subscribe(consumer);
    }

    public State getState() {
        return f43352d.fromJson(this.f43353a, this.f43356e);
    }

    public Class<State> getStateClass() {
        return this.f43356e;
    }
}
