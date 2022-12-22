package com.didi.nova.assembly.serial;

import com.didi.app.nova.skeleton.tools.Cancelable;
import com.didi.nova.assembly.ALog;
import com.didi.nova.assembly.serial.Dispatcher;
import java.util.ArrayDeque;
import java.util.Iterator;

public class SerialTaskQueue {

    /* renamed from: a */
    private final ArrayDeque<Work> f29200a = new ArrayDeque<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Work f29201b;

    public enum AppendMode {
        Normal,
        Replace,
        Discard,
        ReplaceStrict,
        DiscardStrict
    }

    static abstract class Work implements Dispatcher.DispatchRunnable {
        volatile boolean cancel;
        volatile boolean finished;

        /* access modifiers changed from: package-private */
        public abstract String getCategory();

        /* access modifiers changed from: package-private */
        public abstract void onCancel();

        Work() {
        }
    }

    public Cancelable append(Task task, AppendMode appendMode) {
        ArrayDeque arrayDeque;
        Work work;
        if (appendMode != AppendMode.Normal) {
            if (appendMode == AppendMode.ReplaceStrict) {
                Work work2 = this.f29201b;
                if (work2 != null && work2.getCategory().equals(task.getCategory())) {
                    this.f29201b.cancel = true;
                    if (!this.f29201b.finished) {
                        this.f29201b.onCancel();
                    }
                }
            } else if (appendMode == AppendMode.DiscardStrict && (work = this.f29201b) != null && work.getCategory().equals(task.getCategory())) {
                m20593a("Cancel " + task + " category: " + task.getCategory() + " mode: " + appendMode);
                task.onCancel();
                return new EmptyCancelable();
            }
            synchronized (this.f29200a) {
                arrayDeque = new ArrayDeque(this.f29200a);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Work work3 = (Work) it.next();
                if (work3.getCategory().equals(task.getCategory())) {
                    if (appendMode == AppendMode.Replace || appendMode == AppendMode.ReplaceStrict) {
                        m20593a("Cancel " + work3 + " mode: " + appendMode);
                        work3.cancel = true;
                        if (!work3.finished) {
                            work3.onCancel();
                        }
                        m20593a(work3.toString() + " is Replaced.");
                    } else if (appendMode == AppendMode.Discard || appendMode == AppendMode.DiscardStrict) {
                        m20593a("Cancel " + task + " category: " + task.getCategory() + " mode: " + appendMode);
                        task.onCancel();
                        return new EmptyCancelable();
                    }
                }
            }
        }
        final Work a = m20590a(task);
        m20593a("Execute " + a + " mode: " + appendMode + "\n\tmActive: " + this.f29201b);
        return new Cancelable() {
            public void cancel() {
                if (!a.cancel && !a.finished) {
                    a.onCancel();
                }
            }
        };
    }

    public void clear() {
        Iterator<Work> it = this.f29200a.iterator();
        while (it.hasNext()) {
            Work next = it.next();
            if (!next.finished) {
                next.onCancel();
            }
        }
        synchronized (this.f29200a) {
            this.f29200a.clear();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20593a(String str) {
        try {
            ALog.m20509i(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private synchronized Work m20590a(final Task task) {
        C102732 r0;
        r0 = new Work() {
            public void onWorkThread() {
                SerialTaskQueue serialTaskQueue = SerialTaskQueue.this;
                serialTaskQueue.m20593a("onWorkThread " + this);
                if (!this.finished) {
                    if (this.cancel) {
                        onCancel();
                    } else {
                        task.onWorkThread();
                    }
                }
            }

            public void onMainThread() {
                SerialTaskQueue serialTaskQueue = SerialTaskQueue.this;
                serialTaskQueue.m20593a("onMainThread " + this + "\n\tmActive: " + SerialTaskQueue.this.f29201b);
                if (this.finished) {
                    if (SerialTaskQueue.this.f29201b == this) {
                        SerialTaskQueue.this.m20591a();
                    }
                } else if (this.cancel) {
                    onCancel();
                } else {
                    task.onMainThread();
                    this.finished = true;
                    SerialTaskQueue.this.m20591a();
                }
            }

            public void onCancel() {
                SerialTaskQueue serialTaskQueue = SerialTaskQueue.this;
                serialTaskQueue.m20593a("onCancel " + this + "\n\tmActive: " + SerialTaskQueue.this.f29201b);
                task.onCancel();
                this.finished = true;
                if (SerialTaskQueue.this.f29201b == this) {
                    SerialTaskQueue.this.m20591a();
                }
            }

            /* access modifiers changed from: package-private */
            public String getCategory() {
                return task.getCategory();
            }

            public String toString() {
                return task.toString() + " category: " + getCategory() + " cancel: " + this.cancel + " finished: " + this.finished;
            }
        };
        synchronized (this.f29200a) {
            this.f29200a.offer(r0);
        }
        if (this.f29201b == null) {
            m20591a();
        }
        return r0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20591a() {
        Work poll;
        synchronized (this.f29200a) {
            poll = this.f29200a.poll();
            this.f29201b = poll;
        }
        if (poll == null) {
            return;
        }
        if (poll.cancel) {
            if (!this.f29201b.finished) {
                this.f29201b.onCancel();
            }
            m20591a();
            return;
        }
        Dispatcher.async((Dispatcher.DispatchRunnable) this.f29201b);
    }

    static class EmptyCancelable implements Cancelable {
        public void cancel() {
        }

        EmptyCancelable() {
        }
    }
}
