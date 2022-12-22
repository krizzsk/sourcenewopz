package com.jumio.core.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class PublisherWithUpdate<Update, Result> {

    /* renamed from: a */
    public final List<SubscriberWithUpdate<Update, Result>> f54793a = new CopyOnWriteArrayList();

    /* renamed from: com.jumio.core.model.PublisherWithUpdate$a */
    public class C19991a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ SubscriberWithUpdate f54794a;

        /* renamed from: b */
        public final /* synthetic */ Object f54795b;

        public C19991a(PublisherWithUpdate publisherWithUpdate, SubscriberWithUpdate subscriberWithUpdate, Object obj) {
            this.f54794a = subscriberWithUpdate;
            this.f54795b = obj;
        }

        public void run() {
            this.f54794a.onUpdate(this.f54795b);
        }
    }

    /* renamed from: com.jumio.core.model.PublisherWithUpdate$b */
    public class C19992b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Subscriber f54796a;

        /* renamed from: b */
        public final /* synthetic */ Object f54797b;

        public C19992b(PublisherWithUpdate publisherWithUpdate, Subscriber subscriber, Object obj) {
            this.f54796a = subscriber;
            this.f54797b = obj;
        }

        public void run() {
            this.f54796a.onResult(this.f54797b);
        }
    }

    /* renamed from: com.jumio.core.model.PublisherWithUpdate$c */
    public class C19993c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Subscriber f54798a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f54799b;

        public C19993c(PublisherWithUpdate publisherWithUpdate, Subscriber subscriber, Throwable th) {
            this.f54798a = subscriber;
            this.f54799b = th;
        }

        public void run() {
            this.f54798a.onError(this.f54799b);
        }
    }

    public List<SubscriberWithUpdate<Update, Result>> getSubscribers() {
        return this.f54793a;
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void publishError(java.lang.Throwable r7) {
        /*
            r6 = this;
            java.util.List r0 = r6.getSubscribers()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r0.next()
            com.jumio.core.model.Subscriber r1 = (com.jumio.core.model.Subscriber) r1
            if (r1 != 0) goto L_0x0017
            goto L_0x0008
        L_0x0017:
            java.lang.String r2 = "onError"
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x004f }
            r4 = 0
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            r3[r4] = r5     // Catch:{ NoSuchMethodException -> 0x004f }
            java.lang.reflect.Method r2 = com.jumio.core.util.ReflectionUtil.getMethod(r1, r2, r3)     // Catch:{ NoSuchMethodException -> 0x004f }
            r3 = 0
            if (r2 == 0) goto L_0x0031
            java.lang.Class<com.jumio.core.model.InvokeOnUiThread> r3 = com.jumio.core.model.InvokeOnUiThread.class
            java.lang.annotation.Annotation r2 = r2.getAnnotation(r3)     // Catch:{ NoSuchMethodException -> 0x004f }
            r3 = r2
            com.jumio.core.model.InvokeOnUiThread r3 = (com.jumio.core.model.InvokeOnUiThread) r3     // Catch:{ NoSuchMethodException -> 0x004f }
        L_0x0031:
            if (r3 == 0) goto L_0x003d
            boolean r2 = r3.value()     // Catch:{ NoSuchMethodException -> 0x004f }
            if (r2 != 0) goto L_0x003d
            r1.onError(r7)     // Catch:{ NoSuchMethodException -> 0x004f }
            goto L_0x0008
        L_0x003d:
            android.os.Handler r2 = new android.os.Handler     // Catch:{ NoSuchMethodException -> 0x004f }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ NoSuchMethodException -> 0x004f }
            r2.<init>(r3)     // Catch:{ NoSuchMethodException -> 0x004f }
            com.jumio.core.model.PublisherWithUpdate$c r3 = new com.jumio.core.model.PublisherWithUpdate$c     // Catch:{ NoSuchMethodException -> 0x004f }
            r3.<init>(r6, r1, r7)     // Catch:{ NoSuchMethodException -> 0x004f }
            r2.post(r3)     // Catch:{ NoSuchMethodException -> 0x004f }
            goto L_0x0008
        L_0x004f:
            r1.onError(r7)
            goto L_0x0008
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.model.PublisherWithUpdate.publishError(java.lang.Throwable):void");
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void publishResult(Result r8) {
        /*
            r7 = this;
            java.util.List r0 = r7.getSubscribers()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r0.next()
            com.jumio.core.model.Subscriber r1 = (com.jumio.core.model.Subscriber) r1
            if (r1 != 0) goto L_0x0017
            goto L_0x0008
        L_0x0017:
            java.lang.String r2 = "onResult"
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0055 }
            r4 = 0
            r5 = 0
            if (r8 == 0) goto L_0x0025
            java.lang.Class r6 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0026
        L_0x0025:
            r6 = r5
        L_0x0026:
            r3[r4] = r6     // Catch:{ NoSuchMethodException -> 0x0055 }
            java.lang.reflect.Method r2 = com.jumio.core.util.ReflectionUtil.getMethod(r1, r2, r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            if (r2 == 0) goto L_0x0037
            java.lang.Class<com.jumio.core.model.InvokeOnUiThread> r3 = com.jumio.core.model.InvokeOnUiThread.class
            java.lang.annotation.Annotation r2 = r2.getAnnotation(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            r5 = r2
            com.jumio.core.model.InvokeOnUiThread r5 = (com.jumio.core.model.InvokeOnUiThread) r5     // Catch:{ NoSuchMethodException -> 0x0055 }
        L_0x0037:
            if (r5 == 0) goto L_0x0043
            boolean r2 = r5.value()     // Catch:{ NoSuchMethodException -> 0x0055 }
            if (r2 != 0) goto L_0x0043
            r1.onResult(r8)     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0008
        L_0x0043:
            android.os.Handler r2 = new android.os.Handler     // Catch:{ NoSuchMethodException -> 0x0055 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ NoSuchMethodException -> 0x0055 }
            r2.<init>(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            com.jumio.core.model.PublisherWithUpdate$b r3 = new com.jumio.core.model.PublisherWithUpdate$b     // Catch:{ NoSuchMethodException -> 0x0055 }
            r3.<init>(r7, r1, r8)     // Catch:{ NoSuchMethodException -> 0x0055 }
            r2.post(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0008
        L_0x0055:
            r1.onResult(r8)
            goto L_0x0008
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.model.PublisherWithUpdate.publishResult(java.lang.Object):void");
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void publishUpdate(Update r8) {
        /*
            r7 = this;
            java.util.List r0 = r7.getSubscribers()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r0.next()
            com.jumio.core.model.SubscriberWithUpdate r1 = (com.jumio.core.model.SubscriberWithUpdate) r1
            if (r1 != 0) goto L_0x0017
            goto L_0x0008
        L_0x0017:
            java.lang.String r2 = "onUpdate"
            r3 = 1
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0055 }
            r4 = 0
            r5 = 0
            if (r8 == 0) goto L_0x0025
            java.lang.Class r6 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0026
        L_0x0025:
            r6 = r5
        L_0x0026:
            r3[r4] = r6     // Catch:{ NoSuchMethodException -> 0x0055 }
            java.lang.reflect.Method r2 = com.jumio.core.util.ReflectionUtil.getMethod(r1, r2, r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            if (r2 == 0) goto L_0x0037
            java.lang.Class<com.jumio.core.model.InvokeOnUiThread> r3 = com.jumio.core.model.InvokeOnUiThread.class
            java.lang.annotation.Annotation r2 = r2.getAnnotation(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            r5 = r2
            com.jumio.core.model.InvokeOnUiThread r5 = (com.jumio.core.model.InvokeOnUiThread) r5     // Catch:{ NoSuchMethodException -> 0x0055 }
        L_0x0037:
            if (r5 == 0) goto L_0x0043
            boolean r2 = r5.value()     // Catch:{ NoSuchMethodException -> 0x0055 }
            if (r2 != 0) goto L_0x0043
            r1.onUpdate(r8)     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0008
        L_0x0043:
            android.os.Handler r2 = new android.os.Handler     // Catch:{ NoSuchMethodException -> 0x0055 }
            android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ NoSuchMethodException -> 0x0055 }
            r2.<init>(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            com.jumio.core.model.PublisherWithUpdate$a r3 = new com.jumio.core.model.PublisherWithUpdate$a     // Catch:{ NoSuchMethodException -> 0x0055 }
            r3.<init>(r7, r1, r8)     // Catch:{ NoSuchMethodException -> 0x0055 }
            r2.post(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0008
        L_0x0055:
            r1.onUpdate(r8)
            goto L_0x0008
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.model.PublisherWithUpdate.publishUpdate(java.lang.Object):void");
    }

    public boolean subscribe(SubscriberWithUpdate<Update, Result> subscriberWithUpdate) {
        return subscriberWithUpdate != null && !getSubscribers().contains(subscriberWithUpdate) && getSubscribers().add(subscriberWithUpdate);
    }

    public boolean unsubscribe(SubscriberWithUpdate<Update, Result> subscriberWithUpdate) {
        return getSubscribers().remove(subscriberWithUpdate);
    }
}
