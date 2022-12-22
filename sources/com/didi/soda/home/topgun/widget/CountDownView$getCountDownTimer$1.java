package com.didi.soda.home.topgun.widget;

import android.os.CountDownTimer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/soda/home/topgun/widget/CountDownView$getCountDownTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "l", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CountDownView.kt */
public final class CountDownView$getCountDownTimer$1 extends CountDownTimer {
    final /* synthetic */ CountDownView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CountDownView$getCountDownTimer$1(CountDownView countDownView, long j, long j2) {
        super(j, j2);
        this.this$0 = countDownView;
    }

    public void onFinish() {
        this.this$0.setTime2Text(0);
        Function0 access$getMCountTimeoutListener$p = this.this$0.f43044g;
        if (access$getMCountTimeoutListener$p != null) {
            access$getMCountTimeoutListener$p.invoke();
        }
    }

    public void onTick(long j) {
        if (j > 0) {
            this.this$0.setTime2Text(j);
        }
    }
}
