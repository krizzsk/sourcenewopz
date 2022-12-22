package jumio.core;

import com.jumio.core.model.Subscriber;
import java.util.ArrayList;
import java.util.List;

/* renamed from: jumio.core.e0 */
/* compiled from: Publisher */
public class C21348e0<Result> {

    /* renamed from: a */
    public final List<Subscriber<Result>> f59610a = new ArrayList();

    /* renamed from: jumio.core.e0$a */
    /* compiled from: Publisher */
    public class C21349a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Subscriber f59611a;

        /* renamed from: b */
        public final /* synthetic */ Object f59612b;

        public C21349a(C21348e0 e0Var, Subscriber subscriber, Object obj) {
            this.f59611a = subscriber;
            this.f59612b = obj;
        }

        public void run() {
            this.f59611a.onResult(this.f59612b);
        }
    }

    /* renamed from: jumio.core.e0$b */
    /* compiled from: Publisher */
    public class C21350b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Subscriber f59613a;

        /* renamed from: b */
        public final /* synthetic */ Throwable f59614b;

        public C21350b(C21348e0 e0Var, Subscriber subscriber, Throwable th) {
            this.f59613a = subscriber;
            this.f59614b = th;
        }

        public void run() {
            this.f59613a.onError(this.f59614b);
        }
    }

    public boolean add(Subscriber<Result> subscriber) {
        return !getSubscribers().contains(subscriber) && getSubscribers().add(subscriber);
    }

    public List<Subscriber<Result>> getSubscribers() {
        return this.f59610a;
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
            jumio.core.e0$b r3 = new jumio.core.e0$b     // Catch:{ NoSuchMethodException -> 0x004f }
            r3.<init>(r6, r1, r7)     // Catch:{ NoSuchMethodException -> 0x004f }
            r2.post(r3)     // Catch:{ NoSuchMethodException -> 0x004f }
            goto L_0x0008
        L_0x004f:
            r1.onError(r7)
            goto L_0x0008
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21348e0.publishError(java.lang.Throwable):void");
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
            jumio.core.e0$a r3 = new jumio.core.e0$a     // Catch:{ NoSuchMethodException -> 0x0055 }
            r3.<init>(r7, r1, r8)     // Catch:{ NoSuchMethodException -> 0x0055 }
            r2.post(r3)     // Catch:{ NoSuchMethodException -> 0x0055 }
            goto L_0x0008
        L_0x0055:
            r1.onResult(r8)
            goto L_0x0008
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.C21348e0.publishResult(java.lang.Object):void");
    }

    public boolean remove(Subscriber<Result> subscriber) {
        return getSubscribers().remove(subscriber);
    }

    public void removeAllSubscriber() {
        getSubscribers().clear();
    }
}
