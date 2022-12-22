package com.didi.soda.home.topgun.widget;

import com.didi.app.nova.skeleton.ILive;
import com.didi.app.nova.skeleton.IScopeLifecycle;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, mo175978d2 = {"com/didi/soda/home/topgun/widget/TopicCountDownView$setScope$1", "Lcom/didi/app/nova/skeleton/IScopeLifecycle;", "onCreate", "", "live", "Lcom/didi/app/nova/skeleton/ILive;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TopicCountDownView.kt */
public final class TopicCountDownView$setScope$1 implements IScopeLifecycle {
    final /* synthetic */ TopicCountDownView this$0;

    public void onCreate(ILive iLive) {
    }

    public void onPause(ILive iLive) {
    }

    public void onResume(ILive iLive) {
    }

    public void onStart(ILive iLive) {
    }

    public void onStop(ILive iLive) {
    }

    TopicCountDownView$setScope$1(TopicCountDownView topicCountDownView) {
        this.this$0 = topicCountDownView;
    }

    public void onDestroy(ILive iLive) {
        this.this$0.getHandler().removeCallbacks(this.this$0.f43203k);
    }
}
