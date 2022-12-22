package p242io.reactivex.internal.operators.observable;

import com.didi.payment.base.cons.WalletExtraConstant;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p242io.reactivex.internal.util.BlockingHelper;
import p242io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.operators.observable.BlockingObservableIterable */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* renamed from: a */
    final ObservableSource<? extends T> f58702a;

    /* renamed from: b */
    final int f58703b;

    public BlockingObservableIterable(ObservableSource<? extends T> observableSource, int i) {
        this.f58702a = observableSource;
        this.f58703b = i;
    }

    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f58703b);
        this.f58702a.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }

    /* renamed from: io.reactivex.internal.operators.observable.BlockingObservableIterable$BlockingObservableIterator */
    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Iterator<T> {
        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition;
        volatile boolean done;
        Throwable error;
        final Lock lock;
        final SpscLinkedArrayQueue<T> queue;

        BlockingObservableIterator(int i) {
            this.queue = new SpscLinkedArrayQueue<>(i);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        public boolean hasNext() {
            while (true) {
                boolean z = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw ExceptionHelper.wrapOrThrow(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                BlockingHelper.verifyNonBlocking();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty()) {
                    try {
                        this.condition.await();
                    } catch (InterruptedException e) {
                        DisposableHelper.dispose(this);
                        signalConsumer();
                        throw ExceptionHelper.wrapOrThrow(e);
                    } catch (Throwable th2) {
                        this.lock.unlock();
                        throw th2;
                    }
                }
                this.lock.unlock();
            }
        }

        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        /* access modifiers changed from: package-private */
        public void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException(WalletExtraConstant.Key.REMOVE);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }
    }
}
