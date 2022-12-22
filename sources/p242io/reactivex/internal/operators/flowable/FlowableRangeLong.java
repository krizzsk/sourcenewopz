package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.internal.fuseable.ConditionalSubscriber;
import p242io.reactivex.internal.subscriptions.BasicQueueSubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.BackpressureHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableRangeLong */
public final class FlowableRangeLong extends Flowable<Long> {

    /* renamed from: a */
    final long f58393a;

    /* renamed from: b */
    final long f58394b;

    public FlowableRangeLong(long j, long j2) {
        this.f58393a = j;
        this.f58394b = j + j2;
    }

    public void subscribeActual(Subscriber<? super Long> subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.onSubscribe(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f58393a, this.f58394b));
            return;
        }
        subscriber.onSubscribe(new RangeSubscription(subscriber, this.f58393a, this.f58394b));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableRangeLong$BaseRangeSubscription */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;
        volatile boolean cancelled;
        final long end;
        long index;

        /* access modifiers changed from: package-private */
        public abstract void fastPath();

        public final int requestFusion(int i) {
            return i & 1;
        }

        /* access modifiers changed from: package-private */
        public abstract void slowPath(long j);

        BaseRangeSubscription(long j, long j2) {
            this.index = j;
            this.end = j2;
        }

        public final Long poll() {
            long j = this.index;
            if (j == this.end) {
                return null;
            }
            this.index = 1 + j;
            return Long.valueOf(j);
        }

        public final boolean isEmpty() {
            return this.index == this.end;
        }

        public final void clear() {
            this.index = this.end;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j) && BackpressureHelper.add(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        public final void cancel() {
            this.cancelled = true;
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableRangeLong$RangeSubscription */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final Subscriber<? super Long> downstream;

        RangeSubscription(Subscriber<? super Long> subscriber, long j, long j2) {
            super(j, j2);
            this.downstream = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void fastPath() {
            long j = this.end;
            Subscriber<? super Long> subscriber = this.downstream;
            long j2 = this.index;
            while (j2 != j) {
                if (!this.cancelled) {
                    subscriber.onNext(Long.valueOf(j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                subscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void slowPath(long j) {
            long j2 = this.end;
            long j3 = this.index;
            Subscriber<? super Long> subscriber = this.downstream;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 == j || j3 == j2) {
                        if (j3 != j2) {
                            j = get();
                            if (j4 == j) {
                                this.index = j3;
                                j = addAndGet(-j4);
                            }
                        } else if (!this.cancelled) {
                            subscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        subscriber.onNext(Long.valueOf(j3));
                        j4++;
                        j3++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableRangeLong$RangeConditionalSubscription */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;
        final ConditionalSubscriber<? super Long> downstream;

        RangeConditionalSubscription(ConditionalSubscriber<? super Long> conditionalSubscriber, long j, long j2) {
            super(j, j2);
            this.downstream = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void fastPath() {
            long j = this.end;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
            long j2 = this.index;
            while (j2 != j) {
                if (!this.cancelled) {
                    conditionalSubscriber.tryOnNext(Long.valueOf(j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!this.cancelled) {
                conditionalSubscriber.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void slowPath(long j) {
            long j2 = this.end;
            long j3 = this.index;
            ConditionalSubscriber<? super Long> conditionalSubscriber = this.downstream;
            do {
                long j4 = 0;
                while (true) {
                    if (j4 == j || j3 == j2) {
                        if (j3 != j2) {
                            j = get();
                            if (j4 == j) {
                                this.index = j3;
                                j = addAndGet(-j4);
                            }
                        } else if (!this.cancelled) {
                            conditionalSubscriber.onComplete();
                            return;
                        } else {
                            return;
                        }
                    } else if (!this.cancelled) {
                        if (conditionalSubscriber.tryOnNext(Long.valueOf(j3))) {
                            j4++;
                        }
                        j3++;
                    } else {
                        return;
                    }
                }
            } while (j != 0);
        }
    }
}
