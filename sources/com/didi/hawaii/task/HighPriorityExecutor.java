package com.didi.hawaii.task;

import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HighPriorityExecutor implements Executor {

    /* renamed from: a */
    private static final int f24178a = 3;

    /* renamed from: b */
    private static final int f24179b = 5;

    /* renamed from: c */
    private static final int f24180c = 128;

    /* renamed from: d */
    private static final int f24181d = 1;

    /* renamed from: e */
    private final ThreadFactory f24182e = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Hawaii SDK MapTask High #" + this.mCount.getAndIncrement());
            thread.setPriority(6);
            return thread;
        }
    };

    /* renamed from: f */
    private final BlockingQueue<Runnable> f24183f = new BlockingLIFOQueue(5);

    /* renamed from: g */
    private final Executor f24184g = new ThreadPoolExecutor(3, 128, 1, TimeUnit.SECONDS, this.f24183f, this.f24182e, new ThreadPoolExecutor.DiscardOldestPolicy());

    public void execute(Runnable runnable) {
        this.f24184g.execute(runnable);
    }

    private class BlockingLIFOQueue<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
        private static final long serialVersionUID = -8663972601582430388L;
        private int capacity;
        private final AtomicInteger mCount = new AtomicInteger();
        transient BlockingLIFOQueue<E>.Node<E> mHead;
        private final Condition notEmpty;
        private final Condition notFull;
        private final ReentrantLock putLock;
        private final ReentrantLock takeLock;

        class Node<E> {
            E item;
            BlockingLIFOQueue<E>.Node<E> next;

            Node(E e) {
                this.item = e;
            }
        }

        public BlockingLIFOQueue(int i) {
            ReentrantLock reentrantLock = new ReentrantLock();
            this.takeLock = reentrantLock;
            this.notEmpty = reentrantLock.newCondition();
            ReentrantLock reentrantLock2 = new ReentrantLock();
            this.putLock = reentrantLock2;
            this.notFull = reentrantLock2.newCondition();
            this.capacity = i;
            this.mHead = new Node<>(null);
        }

        public Iterator<E> iterator() {
            return new Itr();
        }

        public int size() {
            return this.mCount.get();
        }

        public int drainTo(Collection<? super E> collection) {
            return drainTo(collection, Integer.MAX_VALUE);
        }

        public int drainTo(Collection<? super E> collection, int i) {
            BlockingLIFOQueue<E>.Node<E> node;
            int i2;
            if (collection == null) {
                throw null;
            } else if (collection != this) {
                boolean z = false;
                if (i <= 0) {
                    return 0;
                }
                ReentrantLock reentrantLock = this.takeLock;
                reentrantLock.lock();
                try {
                    int min = Math.min(i, this.mCount.get());
                    node = this.mHead;
                    i2 = 0;
                    while (i2 < min) {
                        BlockingLIFOQueue<E>.Node<E> node2 = node.next;
                        collection.add(node2.item);
                        node2.item = null;
                        node.next = node;
                        i2++;
                        node = node2;
                    }
                    if (i2 > 0) {
                        this.mHead = node;
                        if (this.mCount.getAndAdd(-i2) == this.capacity) {
                            z = true;
                        }
                    }
                    reentrantLock.unlock();
                    if (z) {
                        signalNotFull();
                    }
                    return min;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    if (0 != 0) {
                        signalNotFull();
                    }
                    throw th;
                }
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean offer(E e) {
            if (e != null) {
                AtomicInteger atomicInteger = this.mCount;
                if (atomicInteger.get() == this.capacity) {
                    return false;
                }
                int i = -1;
                Node node = new Node(e);
                ReentrantLock reentrantLock = this.putLock;
                reentrantLock.lock();
                try {
                    if (atomicInteger.get() < this.capacity) {
                        push(node);
                        i = atomicInteger.getAndIncrement();
                        if (i + 1 < this.capacity) {
                            this.notFull.signal();
                        }
                    }
                    if (i == 0) {
                        signalNotEmpty();
                    }
                    if (i >= 0) {
                        return true;
                    }
                    return false;
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw null;
            }
        }

        public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
            if (e != null) {
                long nanos = timeUnit.toNanos(j);
                ReentrantLock reentrantLock = this.putLock;
                AtomicInteger atomicInteger = this.mCount;
                reentrantLock.lockInterruptibly();
                while (atomicInteger.get() == this.capacity) {
                    try {
                        if (nanos <= 0) {
                            return false;
                        }
                        nanos = this.notFull.awaitNanos(nanos);
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                push(new Node(e));
                int andIncrement = atomicInteger.getAndIncrement();
                if (andIncrement + 1 < this.capacity) {
                    this.notFull.signal();
                }
                reentrantLock.unlock();
                if (andIncrement != 0) {
                    return true;
                }
                signalNotEmpty();
                return true;
            }
            throw null;
        }

        public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j);
            AtomicInteger atomicInteger = this.mCount;
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    if (nanos <= 0) {
                        return null;
                    }
                    nanos = this.notEmpty.awaitNanos(nanos);
                } finally {
                    reentrantLock.unlock();
                }
            }
            E pop = pop();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.notEmpty.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.capacity) {
                signalNotFull();
            }
            return pop;
        }

        public void put(E e) throws InterruptedException {
            if (e != null) {
                Node node = new Node(e);
                ReentrantLock reentrantLock = this.putLock;
                AtomicInteger atomicInteger = this.mCount;
                reentrantLock.lockInterruptibly();
                while (atomicInteger.get() == this.capacity) {
                    try {
                        this.notFull.await();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
                push(node);
                int andIncrement = atomicInteger.getAndIncrement();
                if (andIncrement + 1 < this.capacity) {
                    this.notFull.signal();
                }
                if (andIncrement == 0) {
                    signalNotEmpty();
                    return;
                }
                return;
            }
            throw null;
        }

        public int remainingCapacity() {
            return this.capacity - this.mCount.get();
        }

        /* JADX INFO: finally extract failed */
        public E take() throws InterruptedException {
            AtomicInteger atomicInteger = this.mCount;
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == 0) {
                try {
                    this.notEmpty.await();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            E pop = pop();
            int andDecrement = atomicInteger.getAndDecrement();
            if (andDecrement > 1) {
                this.notEmpty.signal();
            }
            reentrantLock.unlock();
            if (andDecrement == this.capacity) {
                signalNotFull();
            }
            return pop;
        }

        public E peek() {
            if (this.mCount.get() == 0) {
                return null;
            }
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lock();
            try {
                BlockingLIFOQueue<E>.Node<E> node = this.mHead.next;
                if (node == null) {
                    return null;
                }
                E e = node.item;
                reentrantLock.unlock();
                return e;
            } finally {
                reentrantLock.unlock();
            }
        }

        /* JADX INFO: finally extract failed */
        public E poll() {
            AtomicInteger atomicInteger = this.mCount;
            E e = null;
            if (atomicInteger.get() == 0) {
                return null;
            }
            int i = -1;
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() > 0) {
                    e = pop();
                    i = atomicInteger.getAndDecrement();
                    if (i > 1) {
                        this.notEmpty.signal();
                    }
                }
                reentrantLock.unlock();
                if (i == this.capacity) {
                    signalNotFull();
                }
                return e;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        private void push(BlockingLIFOQueue<E>.Node<E> node) {
            node.next = this.mHead.next;
            this.mHead.next = node;
        }

        private E pop() {
            BlockingLIFOQueue<E>.Node<E> node = this.mHead.next;
            if (node == null) {
                return null;
            }
            this.mHead.next = node.next;
            node.next = null;
            E e = node.item;
            node.item = null;
            return e;
        }

        /* access modifiers changed from: private */
        public void fullyLock() {
            this.putLock.lock();
            this.takeLock.lock();
        }

        /* access modifiers changed from: package-private */
        public void fullyUnlock() {
            this.takeLock.unlock();
            this.putLock.unlock();
        }

        /* access modifiers changed from: package-private */
        public void unlink(BlockingLIFOQueue<E>.Node<E> node, BlockingLIFOQueue<E>.Node<E> node2) {
            node.item = null;
            node2.next = node.next;
            if (this.mCount.getAndDecrement() == this.capacity) {
                this.notFull.signal();
            }
        }

        private void signalNotFull() {
            ReentrantLock reentrantLock = this.putLock;
            reentrantLock.lock();
            try {
                this.notFull.signal();
            } finally {
                reentrantLock.unlock();
            }
        }

        private void signalNotEmpty() {
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lock();
            try {
                this.notEmpty.signal();
            } finally {
                reentrantLock.unlock();
            }
        }

        public class Itr implements Iterator<E> {
            private BlockingLIFOQueue<E>.Node<E> mCurrent;
            private E mCurrentElement;
            private BlockingLIFOQueue<E>.Node<E> mLastRet;

            Itr() {
                BlockingLIFOQueue.this.fullyLock();
                try {
                    BlockingLIFOQueue<E>.Node<E> node = BlockingLIFOQueue.this.mHead.next;
                    this.mCurrent = node;
                    if (node != null) {
                        this.mCurrentElement = node.item;
                    }
                } finally {
                    BlockingLIFOQueue.this.fullyUnlock();
                }
            }

            public boolean hasNext() {
                return this.mCurrent != null;
            }

            /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: 
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
                	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
                */
            private com.didi.hawaii.task.HighPriorityExecutor.BlockingLIFOQueue<E>.Node<E> nextNode(com.didi.hawaii.task.HighPriorityExecutor.BlockingLIFOQueue<E>.Node<E> r2) {
                /*
                    r1 = this;
                L_0x0000:
                    com.didi.hawaii.task.HighPriorityExecutor$BlockingLIFOQueue<E>$Node<E> r2 = r2.next
                    if (r2 == 0) goto L_0x0008
                    E r0 = r2.item
                    if (r0 == 0) goto L_0x0000
                L_0x0008:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.task.HighPriorityExecutor.BlockingLIFOQueue.Itr.nextNode(com.didi.hawaii.task.HighPriorityExecutor$BlockingLIFOQueue$Node):com.didi.hawaii.task.HighPriorityExecutor$BlockingLIFOQueue$Node");
            }

            public E next() {
                E e;
                BlockingLIFOQueue.this.fullyLock();
                try {
                    if (this.mCurrent != null) {
                        E e2 = this.mCurrentElement;
                        this.mLastRet = this.mCurrent;
                        BlockingLIFOQueue<E>.Node<E> nextNode = nextNode(this.mCurrent);
                        this.mCurrent = nextNode;
                        if (nextNode == null) {
                            e = null;
                        } else {
                            e = nextNode.item;
                        }
                        this.mCurrentElement = e;
                        return e2;
                    }
                    throw new NoSuchElementException();
                } finally {
                    BlockingLIFOQueue.this.fullyUnlock();
                }
            }

            public void remove() {
                BlockingLIFOQueue.this.fullyLock();
                try {
                    BlockingLIFOQueue<E>.Node<E> node = this.mLastRet;
                    this.mLastRet = null;
                    BlockingLIFOQueue<E>.Node<E> node2 = BlockingLIFOQueue.this.mHead;
                    while (true) {
                        BlockingLIFOQueue<E>.Node<E> node3 = node2;
                        node2 = node2.next;
                        if (node2 != null) {
                            if (node2 == node) {
                                BlockingLIFOQueue.this.unlink(node2, node3);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } finally {
                    BlockingLIFOQueue.this.fullyUnlock();
                }
            }
        }
    }
}
