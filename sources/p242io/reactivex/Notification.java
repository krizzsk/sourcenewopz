package p242io.reactivex;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.util.NotificationLite;

/* renamed from: io.reactivex.Notification */
public final class Notification<T> {

    /* renamed from: b */
    static final Notification<Object> f58020b = new Notification<>((Object) null);

    /* renamed from: a */
    final Object f58021a;

    private Notification(Object obj) {
        this.f58021a = obj;
    }

    public boolean isOnComplete() {
        return this.f58021a == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.f58021a);
    }

    public boolean isOnNext() {
        Object obj = this.f58021a;
        return obj != null && !NotificationLite.isError(obj);
    }

    public T getValue() {
        Object obj = this.f58021a;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return this.f58021a;
    }

    public Throwable getError() {
        Object obj = this.f58021a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Notification) {
            return ObjectHelper.equals(this.f58021a, ((Notification) obj).f58021a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f58021a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f58021a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + Const.jaRight;
        }
        return "OnNextNotification[" + this.f58021a + Const.jaRight;
    }

    public static <T> Notification<T> createOnNext(T t) {
        ObjectHelper.requireNonNull(t, "value is null");
        return new Notification<>(t);
    }

    public static <T> Notification<T> createOnError(Throwable th) {
        ObjectHelper.requireNonNull(th, "error is null");
        return new Notification<>(NotificationLite.error(th));
    }

    public static <T> Notification<T> createOnComplete() {
        return f58020b;
    }
}
