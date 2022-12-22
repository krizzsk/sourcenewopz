package com.didichuxing.omega.sdk.analysis;

import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.Iterator;
import java.util.List;

public class EventPersistentQueue {
    /* access modifiers changed from: private */
    public static ArrayBlockingQueue<Event> sQueue = new ArrayBlockingQueue<>(1024);
    private static volatile EventPersistentThread sThread;

    private static EventPersistentThread getPersistentThread() {
        if (sThread == null) {
            synchronized (EventPersistentQueue.class) {
                if (sThread == null) {
                    sThread = new EventPersistentThread();
                }
            }
        }
        return sThread;
    }

    private static void startPersistentThread() {
        EventPersistentThread persistentThread = getPersistentThread();
        try {
            if (!persistentThread.isAlive()) {
                persistentThread.start();
            }
        } catch (Throwable unused) {
        }
    }

    public static class EventPersistentThread extends Thread {
        public EventPersistentThread() {
            super("OmegaSDK.EventPersistentThread");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(2:7|11)|8) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:8:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
            L_0x0000:
                com.didichuxing.omega.sdk.analysis.EventPersistentQueue$ArrayBlockingQueue r0 = com.didichuxing.omega.sdk.analysis.EventPersistentQueue.sQueue     // Catch:{ all -> 0x0000 }
                java.lang.Object r0 = r0.take()     // Catch:{ all -> 0x0000 }
                com.didichuxing.omega.sdk.common.record.Event r0 = (com.didichuxing.omega.sdk.common.record.Event) r0     // Catch:{ all -> 0x0000 }
                long r1 = r0.getSeq()     // Catch:{ all -> 0x0000 }
                java.lang.String r3 = com.didichuxing.omega.sdk.common.perforence.RuntimeCheck.getProcessNameInMD5()     // Catch:{ all -> 0x0000 }
                long r3 = com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getLastSendEventSeq(r3)     // Catch:{ all -> 0x0000 }
                boolean r5 = com.didichuxing.omega.sdk.analysis.EventPersistentQueue.isSamePid(r1, r3)     // Catch:{ all -> 0x0000 }
                if (r5 == 0) goto L_0x0026
                boolean r5 = com.didichuxing.omega.sdk.analysis.EventPersistentQueue.isSamePid(r1, r3)     // Catch:{ all -> 0x0000 }
                if (r5 == 0) goto L_0x0000
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 <= 0) goto L_0x0000
            L_0x0026:
                com.didichuxing.omega.sdk.analysis.EventStorage.push(r0)     // Catch:{ all -> 0x0000 }
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.EventPersistentQueue.EventPersistentThread.run():void");
        }
    }

    public static void add(Event event) {
        sQueue.offer(event);
        startPersistentThread();
    }

    public static List<Event> getAndSyncWithSendQueue(long j, long j2) {
        List<Event> pollAllAndClean = EventStorage.pollAllAndClean();
        long lastSendEventSeq = PersistentInfoCollector.getLastSendEventSeq(RuntimeCheck.getProcessNameInMD5());
        if (!(j == 0 || j2 == 0)) {
            Iterator<Event> it = pollAllAndClean.iterator();
            while (it.hasNext()) {
                long seq = it.next().getSeq();
                if (isSamePid(j, seq)) {
                    if (j <= seq && seq <= j2) {
                        it.remove();
                    }
                } else if (seq <= lastSendEventSeq) {
                    it.remove();
                }
            }
        }
        return pollAllAndClean;
    }

    /* access modifiers changed from: private */
    public static boolean isSamePid(long j, long j2) {
        return j / 1000000 == j2 / 1000000;
    }

    public static class ArrayBlockingQueue<E> {
        private int count;
        private final Object[] items;
        private final Object lock = new Object();
        private int putIndex;
        private int takeIndex;

        public ArrayBlockingQueue(int i) {
            if (i > 0) {
                this.items = new Object[i];
                return;
            }
            throw new IllegalArgumentException();
        }

        private void enqueue(E e) {
            Object[] objArr = this.items;
            int i = this.putIndex;
            objArr[i] = e;
            int i2 = i + 1;
            this.putIndex = i2;
            if (i2 == objArr.length) {
                this.putIndex = 0;
            }
            this.count++;
            this.lock.notifyAll();
        }

        private E dequeue() {
            E[] eArr = this.items;
            int i = this.takeIndex;
            E e = eArr[i];
            eArr[i] = null;
            int i2 = i + 1;
            this.takeIndex = i2;
            if (i2 == eArr.length) {
                this.takeIndex = 0;
            }
            this.count--;
            this.lock.notifyAll();
            return e;
        }

        public boolean offer(E e) {
            requireNonNull(e);
            synchronized (this.lock) {
                if (this.count == this.items.length) {
                    return false;
                }
                enqueue(e);
                return true;
            }
        }

        public void put(E e) throws InterruptedException {
            requireNonNull(e);
            synchronized (this.lock) {
                while (this.count == this.items.length) {
                    this.lock.wait();
                }
                enqueue(e);
            }
        }

        public E poll() {
            E dequeue;
            synchronized (this.lock) {
                dequeue = this.count == 0 ? null : dequeue();
            }
            return dequeue;
        }

        public E take() throws InterruptedException {
            E dequeue;
            synchronized (this.lock) {
                while (this.count == 0) {
                    this.lock.wait();
                }
                dequeue = dequeue();
            }
            return dequeue;
        }

        private static <T> T requireNonNull(T t) {
            if (t != null) {
                return t;
            }
            throw null;
        }
    }
}
