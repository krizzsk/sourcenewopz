package p242io.reactivex.processors;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p242io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.processors.a */
/* compiled from: SerializedProcessor */
final class C21229a<T> extends FlowableProcessor<T> {

    /* renamed from: a */
    final FlowableProcessor<T> f59402a;

    /* renamed from: b */
    boolean f59403b;

    /* renamed from: c */
    AppendOnlyLinkedArrayList<Object> f59404c;

    /* renamed from: d */
    volatile boolean f59405d;

    C21229a(FlowableProcessor<T> flowableProcessor) {
        this.f59402a = flowableProcessor;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f59402a.subscribe(subscriber);
    }

    public void onSubscribe(Subscription subscription) {
        boolean z = true;
        if (!this.f59405d) {
            synchronized (this) {
                if (!this.f59405d) {
                    if (this.f59403b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59404c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59404c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.subscription(subscription));
                        return;
                    }
                    this.f59403b = true;
                    z = false;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.f59402a.onSubscribe(subscription);
        mo175493a();
    }

    public void onNext(T t) {
        if (!this.f59405d) {
            synchronized (this) {
                if (!this.f59405d) {
                    if (this.f59403b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59404c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59404c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f59403b = true;
                    this.f59402a.onNext(t);
                    mo175493a();
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
        r2.f59402a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f59405d
            if (r0 == 0) goto L_0x0008
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f59405d     // Catch:{ all -> 0x003b }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x002e
        L_0x000f:
            r2.f59405d = r1     // Catch:{ all -> 0x003b }
            boolean r0 = r2.f59403b     // Catch:{ all -> 0x003b }
            if (r0 == 0) goto L_0x002a
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f59404c     // Catch:{ all -> 0x003b }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x003b }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x003b }
            r2.f59404c = r0     // Catch:{ all -> 0x003b }
        L_0x0021:
            java.lang.Object r3 = p242io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x003b }
            r0.setFirst(r3)     // Catch:{ all -> 0x003b }
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            return
        L_0x002a:
            r0 = 0
            r2.f59403b = r1     // Catch:{ all -> 0x003b }
            r1 = 0
        L_0x002e:
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x0035
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0035:
            io.reactivex.processors.FlowableProcessor<T> r0 = r2.f59402a
            r0.onError(r3)
            return
        L_0x003b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.reactivex.processors.C21229a.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f59405d) {
            synchronized (this) {
                if (!this.f59405d) {
                    this.f59405d = true;
                    if (this.f59403b) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59404c;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59404c = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f59403b = true;
                    this.f59402a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175493a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f59404c;
                if (appendOnlyLinkedArrayList == null) {
                    this.f59403b = false;
                    return;
                }
                this.f59404c = null;
            }
            appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f59402a);
        }
        while (true) {
        }
    }

    public boolean hasSubscribers() {
        return this.f59402a.hasSubscribers();
    }

    public boolean hasThrowable() {
        return this.f59402a.hasThrowable();
    }

    public Throwable getThrowable() {
        return this.f59402a.getThrowable();
    }

    public boolean hasComplete() {
        return this.f59402a.hasComplete();
    }
}
