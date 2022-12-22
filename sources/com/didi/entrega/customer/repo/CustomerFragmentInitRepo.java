package com.didi.entrega.customer.repo;

import com.didi.app.nova.skeleton.repo.Action1;
import java.util.ArrayList;
import java.util.Iterator;

public class CustomerFragmentInitRepo {

    /* renamed from: a */
    private static CustomerFragmentInitRepo f20228a;

    /* renamed from: b */
    private boolean f20229b;

    /* renamed from: c */
    private ArrayList<Action1<Boolean>> f20230c = new ArrayList<>();

    public static CustomerFragmentInitRepo getInstance() {
        if (f20228a == null) {
            f20228a = new CustomerFragmentInitRepo();
        }
        return f20228a;
    }

    public void setValue(boolean z) {
        this.f20229b = z;
        Iterator<Action1<Boolean>> it = this.f20230c.iterator();
        while (it.hasNext()) {
            it.next().call(Boolean.valueOf(z));
        }
    }

    public void subscribe(Action1<Boolean> action1) {
        this.f20230c.add(action1);
        Iterator<Action1<Boolean>> it = this.f20230c.iterator();
        while (it.hasNext()) {
            it.next().call(Boolean.valueOf(this.f20229b));
        }
    }

    public void remove(Action1<Boolean> action1) {
        if (this.f20230c.contains(action1)) {
            this.f20230c.remove(action1);
        }
    }

    public void clear() {
        this.f20229b = false;
        this.f20230c.clear();
    }
}
