package com.didichuxing.alpha.lag;

import java.util.concurrent.atomic.AtomicBoolean;

abstract class AbstractSampler {
    private static final int DEFAULT_SAMPLE_INTERVAL = 300;
    /* access modifiers changed from: private */
    public Runnable mRunnable = new Runnable() {
        public void run() {
            AbstractSampler.this.doSample();
            if (AbstractSampler.this.mShouldSample.get()) {
                HandlerThreadFactory.getTimerThreadHandler().postDelayed(AbstractSampler.this.mRunnable, AbstractSampler.this.mSampleInterval);
            }
        }
    };
    protected long mSampleInterval;
    protected AtomicBoolean mShouldSample = new AtomicBoolean(false);

    /* access modifiers changed from: package-private */
    public abstract void doSample();

    public AbstractSampler(long j) {
        this.mSampleInterval = 0 == j ? 300 : j;
    }

    public void start() {
        if (!this.mShouldSample.get()) {
            this.mShouldSample.set(true);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.mRunnable);
            HandlerThreadFactory.getTimerThreadHandler().postDelayed(this.mRunnable, BlockCanaryInternals.getInstance().getSampleDelay());
        }
    }

    public void stop() {
        if (this.mShouldSample.get()) {
            this.mShouldSample.set(false);
            HandlerThreadFactory.getTimerThreadHandler().removeCallbacks(this.mRunnable);
        }
    }
}
