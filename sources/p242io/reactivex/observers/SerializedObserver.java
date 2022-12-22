package p242io.reactivex.observers;

import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p242io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.observers.SerializedObserver */
public final class SerializedObserver<T> implements Observer<T>, Disposable {

    /* renamed from: c */
    static final int f59316c = 4;

    /* renamed from: a */
    final Observer<? super T> f59317a;

    /* renamed from: b */
    final boolean f59318b;

    /* renamed from: d */
    Disposable f59319d;

    /* renamed from: e */
    boolean f59320e;

    /* renamed from: f */
    AppendOnlyLinkedArrayList<Object> f59321f;

    /* renamed from: g */
    volatile boolean f59322g;

    public SerializedObserver(Observer<? super T> observer) {
        this(observer, false);
    }

    public SerializedObserver(Observer<? super T> observer, boolean z) {
        this.f59317a = observer;
        this.f59318b = z;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f59319d, disposable)) {
            this.f59319d = disposable;
            this.f59317a.onSubscribe(this);
        }
    }

    public void dispose() {
        this.f59319d.dispose();
    }

    public boolean isDisposed() {
        return this.f59319d.isDisposed();
    }

    public void onNext(T t) {
        if (!this.f59322g) {
            if (t == null) {
                this.f59319d.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f59322g) {
                    if (this.f59320e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59321f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59321f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f59320e = true;
                    this.f59317a.onNext(t);
                    mo175367a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        if (r1 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        p242io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003e, code lost:
        r2.f59317a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f59322g
            if (r0 == 0) goto L_0x0008
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f59322g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f59320e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f59322g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f59321f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f59321f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = p242io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f59318b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f59322g = r1     // Catch:{ all -> 0x0044 }
            r2.f59320e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            io.reactivex.Observer<? super T> r0 = r2.f59317a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.reactivex.observers.SerializedObserver.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f59322g) {
            synchronized (this) {
                if (!this.f59322g) {
                    if (this.f59320e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59321f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59321f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f59322g = true;
                    this.f59320e = true;
                    this.f59317a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175367a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f59321f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f59320e = false;
                    return;
                }
                this.f59321f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Observer<? super U>) this.f59317a));
    }
}
