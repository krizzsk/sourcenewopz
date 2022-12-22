package p089public;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: public.try */
/* compiled from: SensorDataStorage */
public class C3013try {

    /* renamed from: a */
    private final int f6738a;

    /* renamed from: b */
    private final LinkedList<C3009for> f6739b = new LinkedList<>();

    public C3013try(int i) {
        this.f6738a = i;
    }

    /* renamed from: do */
    public void mo38433do(C3009for forR) {
        if (this.f6739b.size() == this.f6738a) {
            this.f6739b.removeFirst();
        }
        this.f6739b.add(forR);
    }

    /* renamed from: do */
    public List<C3009for> mo38432do() {
        ArrayList arrayList = new ArrayList(this.f6739b);
        this.f6739b.clear();
        return arrayList;
    }
}
