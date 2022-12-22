package p242io.reactivex.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p242io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.subscribers.SerializedSubscriber */
public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* renamed from: c */
    static final int f59479c = 4;

    /* renamed from: a */
    final Subscriber<? super T> f59480a;

    /* renamed from: b */
    final boolean f59481b;

    /* renamed from: d */
    Subscription f59482d;

    /* renamed from: e */
    boolean f59483e;

    /* renamed from: f */
    AppendOnlyLinkedArrayList<Object> f59484f;

    /* renamed from: g */
    volatile boolean f59485g;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z) {
        this.f59480a = subscriber;
        this.f59481b = z;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.validate(this.f59482d, subscription)) {
            this.f59482d = subscription;
            this.f59480a.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        if (!this.f59485g) {
            if (t == null) {
                this.f59482d.cancel();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f59485g) {
                    if (this.f59483e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59484f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59484f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.next(t));
                        return;
                    }
                    this.f59483e = true;
                    this.f59480a.onNext(t);
                    mo175608a();
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
        r2.f59480a.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.f59485g
            if (r0 == 0) goto L_0x0008
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.f59485g     // Catch:{ all -> 0x0044 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0037
        L_0x000f:
            boolean r0 = r2.f59483e     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0032
            r2.f59485g = r1     // Catch:{ all -> 0x0044 }
            io.reactivex.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.f59484f     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x0021
            io.reactivex.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0044 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0044 }
            r2.f59484f = r0     // Catch:{ all -> 0x0044 }
        L_0x0021:
            java.lang.Object r3 = p242io.reactivex.internal.util.NotificationLite.error(r3)     // Catch:{ all -> 0x0044 }
            boolean r1 = r2.f59481b     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x002d
            r0.add(r3)     // Catch:{ all -> 0x0044 }
            goto L_0x0030
        L_0x002d:
            r0.setFirst(r3)     // Catch:{ all -> 0x0044 }
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            return
        L_0x0032:
            r2.f59485g = r1     // Catch:{ all -> 0x0044 }
            r2.f59483e = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
        L_0x0037:
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            p242io.reactivex.plugins.RxJavaPlugins.onError(r3)
            return
        L_0x003e:
            org.reactivestreams.Subscriber<? super T> r0 = r2.f59480a
            r0.onError(r3)
            return
        L_0x0044:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0044 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.reactivex.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f59485g) {
            synchronized (this) {
                if (!this.f59485g) {
                    if (this.f59483e) {
                        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.f59484f;
                        if (appendOnlyLinkedArrayList == null) {
                            appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                            this.f59484f = appendOnlyLinkedArrayList;
                        }
                        appendOnlyLinkedArrayList.add(NotificationLite.complete());
                        return;
                    }
                    this.f59485g = true;
                    this.f59483e = true;
                    this.f59480a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175608a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.f59484f;
                if (appendOnlyLinkedArrayList == null) {
                    this.f59483e = false;
                    return;
                }
                this.f59484f = null;
            }
        } while (!appendOnlyLinkedArrayList.accept((Subscriber<? super U>) this.f59480a));
    }

    public void request(long j) {
        this.f59482d.request(j);
    }

    public void cancel() {
        this.f59482d.cancel();
    }
}
