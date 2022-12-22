package com.didichuxing.mas.sdk.quality.collect.lag;

class AbstractSampler$1 implements Runnable {
    final /* synthetic */ C15799a this$0;

    AbstractSampler$1(C15799a aVar) {
        this.this$0 = aVar;
    }

    public void run() {
        this.this$0.mo118406c();
        if (this.this$0.f48122a.get()) {
            HandlerThreadFactory.getTimerThreadHandler().postDelayed(this.this$0.f48124d, this.this$0.f48123b);
        }
    }
}
