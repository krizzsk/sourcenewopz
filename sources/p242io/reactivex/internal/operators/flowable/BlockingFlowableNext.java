package p242io.reactivex.internal.operators.flowable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import p242io.reactivex.Flowable;
import p242io.reactivex.Notification;
import p242io.reactivex.internal.util.BlockingHelper;
import p242io.reactivex.internal.util.ExceptionHelper;
import p242io.reactivex.plugins.RxJavaPlugins;
import p242io.reactivex.subscribers.DisposableSubscriber;

/* renamed from: io.reactivex.internal.operators.flowable.BlockingFlowableNext */
public final class BlockingFlowableNext<T> implements Iterable<T> {

    /* renamed from: a */
    final Publisher<? extends T> f58173a;

    public BlockingFlowableNext(Publisher<? extends T> publisher) {
        this.f58173a = publisher;
    }

    public Iterator<T> iterator() {
        return new NextIterator(this.f58173a, new NextSubscriber());
    }

    /* renamed from: io.reactivex.internal.operators.flowable.BlockingFlowableNext$NextIterator */
    static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final Publisher<? extends T> items;
        private T next;
        private boolean started;
        private final NextSubscriber<T> subscriber;

        NextIterator(Publisher<? extends T> publisher, NextSubscriber<T> nextSubscriber) {
            this.items = publisher;
            this.subscriber = nextSubscriber;
        }

        public boolean hasNext() {
            Throwable th = this.error;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            } else if (!this.hasNext) {
                return false;
            } else {
                if (!this.isNextConsumed || moveToNext()) {
                    return true;
                }
                return false;
            }
        }

        private boolean moveToNext() {
            try {
                if (!this.started) {
                    this.started = true;
                    this.subscriber.setWaiting();
                    Flowable.fromPublisher(this.items).materialize().subscribe(this.subscriber);
                }
                Notification<T> takeNext = this.subscriber.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnComplete()) {
                    return false;
                }
                if (takeNext.isOnError()) {
                    Throwable error2 = takeNext.getError();
                    this.error = error2;
                    throw ExceptionHelper.wrapOrThrow(error2);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e) {
                this.subscriber.dispose();
                this.error = e;
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }

        public T next() {
            Throwable th = this.error;
            if (th != null) {
                throw ExceptionHelper.wrapOrThrow(th);
            } else if (hasNext()) {
                this.isNextConsumed = true;
                return this.next;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.BlockingFlowableNext$NextSubscriber */
    static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {
        private final BlockingQueue<Notification<T>> buf = new ArrayBlockingQueue(1);
        final AtomicInteger waiting = new AtomicInteger();

        public void onComplete() {
        }

        NextSubscriber() {
        }

        public void onError(Throwable th) {
            RxJavaPlugins.onError(th);
        }

        public void onNext(Notification<T> notification) {
            if (this.waiting.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<T> notification2 = (Notification) this.buf.poll();
                    if (notification2 != null && !notification2.isOnNext()) {
                        notification = notification2;
                    }
                }
            }
        }

        public Notification<T> takeNext() throws InterruptedException {
            setWaiting();
            BlockingHelper.verifyNonBlocking();
            return this.buf.take();
        }

        /* access modifiers changed from: package-private */
        public void setWaiting() {
            this.waiting.set(1);
        }
    }
}
