package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class SpreadBuilder {

    /* renamed from: a */
    private final ArrayList<Object> f59918a;

    public SpreadBuilder(int i) {
        this.f59918a = new ArrayList<>(i);
    }

    public void addSpread(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.f59918a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.f59918a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.f59918a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object add : (Iterable) obj) {
                    this.f59918a.add(add);
                }
            } else if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    this.f59918a.add(it.next());
                }
            } else {
                throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
            }
        }
    }

    public int size() {
        return this.f59918a.size();
    }

    public void add(Object obj) {
        this.f59918a.add(obj);
    }

    public Object[] toArray(Object[] objArr) {
        return this.f59918a.toArray(objArr);
    }
}
