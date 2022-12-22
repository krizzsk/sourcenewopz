package p242io.reactivex.schedulers;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.concurrent.TimeUnit;
import p242io.reactivex.internal.functions.ObjectHelper;

/* renamed from: io.reactivex.schedulers.Timed */
public final class Timed<T> {

    /* renamed from: a */
    final T f59414a;

    /* renamed from: b */
    final long f59415b;

    /* renamed from: c */
    final TimeUnit f59416c;

    public Timed(T t, long j, TimeUnit timeUnit) {
        this.f59414a = t;
        this.f59415b = j;
        this.f59416c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public T value() {
        return this.f59414a;
    }

    public TimeUnit unit() {
        return this.f59416c;
    }

    public long time() {
        return this.f59415b;
    }

    public long time(TimeUnit timeUnit) {
        return timeUnit.convert(this.f59415b, this.f59416c);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.equals(this.f59414a, timed.f59414a) || this.f59415b != timed.f59415b || !ObjectHelper.equals(this.f59416c, timed.f59416c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.f59414a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f59415b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f59416c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f59415b + ", unit=" + this.f59416c + ", value=" + this.f59414a + Const.jaRight;
    }
}
