package com.didi.entrega.order.component;

import android.os.CountDownTimer;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.widget.countdown.DurationFormatUtils;
import com.didi.entrega.order.widgets.SpreadView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo175978d2 = {"com/didi/entrega/order/component/OrderMapView$showInfoWindow$1$1", "Landroid/os/CountDownTimer;", "mCountDownShowAnim", "", "getMCountDownShowAnim", "()Z", "setMCountDownShowAnim", "(Z)V", "onFinish", "", "onTick", "millisUntilFinished", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderMapView.kt */
public final class OrderMapView$showInfoWindow$1$1 extends CountDownTimer {
    final /* synthetic */ long $gapTime;
    final /* synthetic */ boolean $showAnim;
    private boolean mCountDownShowAnim = this.$showAnim;
    final /* synthetic */ OrderMapView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OrderMapView$showInfoWindow$1$1(boolean z, OrderMapView orderMapView, long j) {
        super(j, 1000);
        this.$showAnim = z;
        this.this$0 = orderMapView;
        this.$gapTime = j;
    }

    public final boolean getMCountDownShowAnim() {
        return this.mCountDownShowAnim;
    }

    public final void setMCountDownShowAnim(boolean z) {
        this.mCountDownShowAnim = z;
    }

    public void onTick(long j) {
        String formatDuration = DurationFormatUtils.formatDuration(j, "mm:ss");
        Intrinsics.checkNotNullExpressionValue(formatDuration, "formatDuration(millisUntilFinished, \"mm:ss\")");
        LogUtil.m14765i("OrderMapView", "MapTipInfo countdownTime tick：" + j + ' ' + formatDuration);
        SpreadView access$getMSpreadView$p = this.this$0.f20849f;
        if (access$getMSpreadView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            access$getMSpreadView$p = null;
        }
        access$getMSpreadView$p.setCountDownTimeStr(formatDuration, Boolean.valueOf(this.this$0.f20855l));
        this.mCountDownShowAnim = false;
    }

    public void onFinish() {
        SpreadView access$getMSpreadView$p = this.this$0.f20849f;
        if (access$getMSpreadView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpreadView");
            access$getMSpreadView$p = null;
        }
        access$getMSpreadView$p.setCountDownTimeStr("00:00", Boolean.valueOf(this.this$0.f20855l));
    }
}
