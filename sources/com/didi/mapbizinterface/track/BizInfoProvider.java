package com.didi.mapbizinterface.track;

import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BizInfoProvider {
    public static final int INFO_TYPE_APPPAGE = 4097;
    public static final int INFO_TYPE_VDR_LOCATION = 4098;

    /* renamed from: c */
    private static final int f29074c = 3600;

    /* renamed from: a */
    private SparseArray<Object> f29075a;

    /* renamed from: b */
    private SparseArray<Queue<Object>> f29076b;

    private BizInfoProvider() {
        this.f29075a = new SparseArray<>();
        SparseArray<Queue<Object>> sparseArray = new SparseArray<>();
        this.f29076b = sparseArray;
        sparseArray.put(4098, new ArrayDeque());
    }

    private static class SingletonHolder {
        static BizInfoProvider INSTANCE = new BizInfoProvider();

        private SingletonHolder() {
        }
    }

    /* renamed from: a */
    static BizInfoProvider m20490a() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo79984a(int i, Object obj) {
        if (i == 4097) {
            this.f29075a.put(i, obj);
        } else if (i == 4098) {
            Queue queue = this.f29076b.get(i);
            if (queue.size() >= 3600) {
                queue.poll();
            }
            queue.offer(obj);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Object mo79982a(int i) {
        return this.f29075a.get(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized int mo79985b(int i) {
        return this.f29076b.get(i).size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized <T> List<T> mo79983a(int i, Class<T> cls, int i2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Queue queue = this.f29076b.get(i);
        int i3 = 0;
        while (!queue.isEmpty() && i3 < i2) {
            try {
                arrayList.add(queue.poll());
            } catch (Exception unused) {
            }
            i3++;
        }
        return arrayList;
    }
}
