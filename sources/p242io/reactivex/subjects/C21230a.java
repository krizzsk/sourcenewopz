package p242io.reactivex.subjects;

import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p242io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.subjects.a */
/* compiled from: SerializedSubject */
final class C21230a<T> extends Subject<T> implements AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {

    /* renamed from: a */
    final Subject<T> f59469a;

    /* renamed from: b */
    boolean f59470b;

    /* renamed from: c */
    AppendOnlyLinkedArrayList<Object> f59471c;

    /* renamed from: d */
    volatile boolean f59472d;

    C21230a(Subject<T> subject) {
        this.f59469a = subject;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super T> observer) {
        this.f59469a.subscribe(observer);
    }

    public void onSubscribe(Disposable disposable) {
        boolean z = true;
        if (!this.f59472d) {
            synchronized (this) {
                if (!this.f59472d) {
                    if (this.f59470b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59471c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59471c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.disposable(disposable));
                        return;
                    }
                    this.f59470b = true;
                    z = false;
                }
            }
        }
        if (z) {
            disposable.dispose();
            return;
        }
        this.f59469a.onSubscribe(disposable);
        mo175596a();
    }

    public void onNext(T t) {
        if (!this.f59472d) {
            synchronized (this) {
                if (!this.f59472d) {
                    if (this.f59470b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59471c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59471c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f59470b = true;
                    this.f59469a.onNext(t);
                    mo175596a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r1 == false) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0031, code lost:
        p242io.reactivex.plugins.RxJavaPlugins.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r2.f59469a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f59472d
            if (r0 == 0) goto L_0x0008
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f59472d     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f59472d = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f59470b     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f59471c     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f59471c = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = p242io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003b }
            r0.setFirst(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f59470b = r1     // Catch:{ all -> 0x003b }
            r1 = 0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0035:
            io.reactivex.subjects.Subject<T> r0 = r2.f59469a
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.reactivex.subjects.C21230a.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f59472d) {
            synchronized (this) {
                if (!this.f59472d) {
                    this.f59472d = true;
                    if (this.f59470b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59471c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59471c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f59470b = true;
                    this.f59469a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175596a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f59471c;
                if (appendOnlyLinkedArrayList == null) {
                    this.f59470b = false;
                    return;
                }
                this.f59471c = null;
            }
            appendOnlyLinkedArrayList.forEachWhile(this);
        }
        while (true) {
        }
    }

    public boolean test(Object obj) {
        return NotificationLite.acceptFull(obj, this.f59469a);
    }

    public boolean hasObservers() {
        return this.f59469a.hasObservers();
    }

    public boolean hasThrowable() {
        return this.f59469a.hasThrowable();
    }

    public Throwable getThrowable() {
        return this.f59469a.getThrowable();
    }

    public boolean hasComplete() {
        return this.f59469a.hasComplete();
    }
}
