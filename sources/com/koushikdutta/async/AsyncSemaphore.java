package com.koushikdutta.async;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AsyncSemaphore {

    /* renamed from: a */
    Semaphore f55178a = new Semaphore(0);

    public void acquire() throws InterruptedException {
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        AsyncSemaphore asyncSemaphore = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (!this.f55178a.tryAcquire()) {
                while (true) {
                    Runnable remove = orCreateThreadQueue.remove();
                    if (remove == null) {
                        semaphore.acquire(Math.max(1, semaphore.availablePermits()));
                        if (this.f55178a.tryAcquire()) {
                            orCreateThreadQueue.waiter = asyncSemaphore;
                            return;
                        }
                    } else {
                        remove.run();
                    }
                }
            }
        } finally {
            orCreateThreadQueue.waiter = asyncSemaphore;
        }
    }

    public boolean tryAcquire(long j, TimeUnit timeUnit) throws InterruptedException {
        long convert = TimeUnit.MILLISECONDS.convert(j, timeUnit);
        ThreadQueue orCreateThreadQueue = ThreadQueue.getOrCreateThreadQueue(Thread.currentThread());
        AsyncSemaphore asyncSemaphore = orCreateThreadQueue.waiter;
        orCreateThreadQueue.waiter = this;
        Semaphore semaphore = orCreateThreadQueue.queueSemaphore;
        try {
            if (this.f55178a.tryAcquire()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (true) {
                Runnable remove = orCreateThreadQueue.remove();
                if (remove != null) {
                    remove.run();
                } else if (!semaphore.tryAcquire(Math.max(1, semaphore.availablePermits()), convert, TimeUnit.MILLISECONDS)) {
                    orCreateThreadQueue.waiter = asyncSemaphore;
                    return false;
                } else if (this.f55178a.tryAcquire()) {
                    orCreateThreadQueue.waiter = asyncSemaphore;
                    return true;
                } else if (System.currentTimeMillis() - currentTimeMillis >= convert) {
                    orCreateThreadQueue.waiter = asyncSemaphore;
                    return false;
                }
            }
        } finally {
            orCreateThreadQueue.waiter = asyncSemaphore;
        }
    }

    public void release() {
        this.f55178a.release();
        ThreadQueue.release(this);
    }
}
