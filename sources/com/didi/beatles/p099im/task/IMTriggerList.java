package com.didi.beatles.p099im.task;

import com.didi.beatles.p099im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.didi.beatles.im.task.IMTriggerList */
public class IMTriggerList<T> implements IMBaseTriggerList<T> {

    /* renamed from: a */
    private List<IMTriggerList<T>.IMTriggerEntity<T>> f9646a = new ArrayList();

    /* renamed from: b */
    private long f9647b = 2000;

    /* renamed from: c */
    private Timer f9648c = new Timer();

    /* renamed from: d */
    private IMTriggerListener f9649d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f9650e;

    /* renamed from: com.didi.beatles.im.task.IMTriggerList$IMTriggerListener */
    public interface IMTriggerListener<T> {
        boolean onTrigger(List<T> list, boolean z);
    }

    public boolean add(T t) {
        synchronized (this.f9646a) {
            if (this.f9646a == null) {
                return false;
            }
            if (this.f9646a.size() == 0) {
                m6514a();
            }
            this.f9646a.add(new IMTriggerEntity(t));
            return true;
        }
    }

    public void addAll(List<T> list) {
        if (list != null && list.size() != 0) {
            synchronized (this.f9646a) {
                if (this.f9646a.size() == 0) {
                    m6514a();
                }
                for (T iMTriggerEntity : list) {
                    this.f9646a.add(new IMTriggerEntity(iMTriggerEntity));
                }
            }
        }
    }

    /* renamed from: a */
    private void m6514a() {
        if (!this.f9650e) {
            this.f9650e = true;
            this.f9648c.schedule(new TimerTask() {
                public void run() {
                    if (IMTriggerList.this.f9650e) {
                        IMTriggerList.this.m6518c();
                    }
                }
            }, this.f9647b);
        }
    }

    /* renamed from: b */
    private void m6516b() {
        this.f9650e = false;
    }

    public boolean remove(T t) {
        if (t == null) {
            return false;
        }
        synchronized (this.f9646a) {
            int size = this.f9646a.size();
            for (int i = 0; i < size; i++) {
                if (t.equals(this.f9646a.get(i).entity)) {
                    this.f9646a.remove(new IMTriggerEntity(t));
                    return true;
                }
            }
            return false;
        }
    }

    public void removeAll(List<T> list) {
        if (list != null && list.size() != 0) {
            synchronized (this.f9646a) {
                for (T remove : list) {
                    remove(remove);
                }
            }
            if (this.f9646a.size() == 0) {
                IMLog.m6635i("IMMessageReadStatusManager", "list is null after remove,stop timer");
                m6516b();
            }
        }
    }

    public void addTriggerListener(IMTriggerListener<T> iMTriggerListener) {
        this.f9649d = iMTriggerListener;
    }

    public void removeHasExecuted() {
        if (this.f9646a.size() != 0) {
            synchronized (this.f9646a) {
                int size = this.f9646a.size();
                int i = 0;
                while (i < size) {
                    IMTriggerEntity iMTriggerEntity = this.f9646a.get(i);
                    if (iMTriggerEntity.hasExecuted) {
                        this.f9646a.remove(iMTriggerEntity);
                        size--;
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public boolean ExecuteAll(boolean z) {
        m6518c();
        if (!z) {
            return true;
        }
        removeHasExecuted();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m6518c() {
        List<IMTriggerList<T>.IMTriggerEntity<T>> list = this.f9646a;
        if (list != null && list.size() != 0 && this.f9649d != null) {
            synchronized (this.f9646a) {
                boolean isAllExecuted = isAllExecuted();
                ArrayList arrayList = new ArrayList();
                for (IMTriggerEntity next : this.f9646a) {
                    next.hasExecuted = true;
                    arrayList.add(next.entity);
                }
                if (this.f9649d.onTrigger(arrayList, isAllExecuted)) {
                    removeHasExecuted();
                }
                m6516b();
                m6514a();
            }
        }
    }

    public void setTriggerTime(long j) {
        this.f9647b = j;
    }

    public void clear() {
        this.f9646a.clear();
    }

    public boolean isAllExecuted() {
        List<IMTriggerList<T>.IMTriggerEntity<T>> list = this.f9646a;
        if (!(list == null || list.size() == 0)) {
            for (IMTriggerList<T>.IMTriggerEntity<T> iMTriggerEntity : this.f9646a) {
                if (!iMTriggerEntity.hasExecuted) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isRunning() {
        return this.f9650e;
    }

    /* renamed from: com.didi.beatles.im.task.IMTriggerList$IMTriggerEntity */
    private class IMTriggerEntity<T> {
        public T entity;
        public boolean hasExecuted;
        public int priority;

        public IMTriggerEntity(T t) {
            this.entity = t;
        }

        public boolean equals(Object obj) {
            T t;
            T t2;
            if (!(obj instanceof IMTriggerEntity) || (t = ((IMTriggerEntity) obj).entity) == null || (t2 = this.entity) == null) {
                return false;
            }
            return t.equals(t2);
        }
    }
}
