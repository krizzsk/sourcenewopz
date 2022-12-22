package global.didi.pay.threeds.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0018\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lglobal/didi/pay/threeds/utils/ThreeDSUiThreadHandler;", "", "()V", "sToken", "sUiHandler", "Landroid/os/Handler;", "getsUiHandler", "post", "", "r", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "postOnceDelayed", "removeCallbacks", "", "runnable", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ThreeDSUiThreadHandler.kt */
public final class ThreeDSUiThreadHandler {
    public static final ThreeDSUiThreadHandler INSTANCE = new ThreeDSUiThreadHandler();
    private static final Object sToken = new Object();
    private static final Handler sUiHandler = new Handler(Looper.getMainLooper());

    private ThreeDSUiThreadHandler() {
    }

    public final boolean post(Runnable runnable) {
        return sUiHandler.post(runnable);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return sUiHandler.postDelayed(runnable, j);
    }

    public final Handler getsUiHandler() {
        return sUiHandler;
    }

    public final boolean postOnceDelayed(Runnable runnable, long j) {
        ThreeDSUiThreadHandler threeDSUiThreadHandler = this;
        sUiHandler.removeCallbacks(runnable, sToken);
        return sUiHandler.postDelayed(runnable, j);
    }

    public final void removeCallbacks(Runnable runnable) {
        sUiHandler.removeCallbacks(runnable);
    }
}
