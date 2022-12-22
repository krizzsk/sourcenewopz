package p242io.socket.emitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* renamed from: io.socket.emitter.Emitter */
public class Emitter {
    private ConcurrentMap<String, ConcurrentLinkedQueue<Listener>> callbacks = new ConcurrentHashMap();

    /* renamed from: io.socket.emitter.Emitter$Listener */
    public interface Listener {
        void call(Object... objArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = new java.util.concurrent.ConcurrentLinkedQueue();
     */
    /* renamed from: on */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p242io.socket.emitter.Emitter mo175675on(java.lang.String r3, p242io.socket.emitter.Emitter.Listener r4) {
        /*
            r2 = this;
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.concurrent.ConcurrentLinkedQueue<io.socket.emitter.Emitter$Listener>> r0 = r2.callbacks
            java.lang.Object r0 = r0.get(r3)
            java.util.concurrent.ConcurrentLinkedQueue r0 = (java.util.concurrent.ConcurrentLinkedQueue) r0
            if (r0 != 0) goto L_0x001a
            java.util.concurrent.ConcurrentLinkedQueue r0 = new java.util.concurrent.ConcurrentLinkedQueue
            r0.<init>()
            java.util.concurrent.ConcurrentMap<java.lang.String, java.util.concurrent.ConcurrentLinkedQueue<io.socket.emitter.Emitter$Listener>> r1 = r2.callbacks
            java.lang.Object r3 = r1.putIfAbsent(r3, r0)
            java.util.concurrent.ConcurrentLinkedQueue r3 = (java.util.concurrent.ConcurrentLinkedQueue) r3
            if (r3 == 0) goto L_0x001a
            r0 = r3
        L_0x001a:
            r0.add(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.socket.emitter.Emitter.mo175675on(java.lang.String, io.socket.emitter.Emitter$Listener):io.socket.emitter.Emitter");
    }

    public Emitter once(String str, Listener listener) {
        mo175675on(str, new OnceListener(str, listener));
        return this;
    }

    public Emitter off() {
        this.callbacks.clear();
        return this;
    }

    public Emitter off(String str) {
        this.callbacks.remove(str);
        return this;
    }

    public Emitter off(String str, Listener listener) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.callbacks.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (sameAs(listener, (Listener) it.next())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return this;
    }

    private static boolean sameAs(Listener listener, Listener listener2) {
        if (listener.equals(listener2)) {
            return true;
        }
        if (listener2 instanceof OnceListener) {
            return listener.equals(((OnceListener) listener2).f59536fn);
        }
        return false;
    }

    public Emitter emit(String str, Object... objArr) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.callbacks.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).call(objArr);
            }
        }
        return this;
    }

    public List<Listener> listeners(String str) {
        ArrayList arrayList;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.callbacks.get(str);
        if (concurrentLinkedQueue == null) {
            arrayList = new ArrayList(0);
        }
        return arrayList;
    }

    public boolean hasListeners(String str) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.callbacks.get(str);
        return concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty();
    }

    /* renamed from: io.socket.emitter.Emitter$OnceListener */
    private class OnceListener implements Listener {
        public final String event;

        /* renamed from: fn */
        public final Listener f59536fn;

        public OnceListener(String str, Listener listener) {
            this.event = str;
            this.f59536fn = listener;
        }

        public void call(Object... objArr) {
            Emitter.this.off(this.event, this);
            this.f59536fn.call(objArr);
        }
    }
}
