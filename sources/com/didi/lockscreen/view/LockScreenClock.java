package com.didi.lockscreen.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.component.common.helper.ThreadPoolHelper;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/lockscreen/view/LockScreenClock;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "start", "", "tvClock", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "tvTime", "workHandler", "Landroid/os/Handler;", "", "stop", "Companion", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LockScreenClock.kt */
public final class LockScreenClock extends FrameLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DADA = 10030;
    public static final int DIDI = 10029;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final TextView f24412a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final TextView f24413b;

    /* renamed from: c */
    private boolean f24414c;

    /* renamed from: d */
    private final Handler f24415d;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LockScreenClock(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.global_view_lock_screen_clock, this);
        this.f24412a = (TextView) findViewById(R.id.tv_lock_screen_clock);
        this.f24413b = (TextView) findViewById(R.id.tv_lock_screen_time);
        this.f24415d = new LockScreenClock$workHandler$1(this, Looper.getMainLooper());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public LockScreenClock(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/lockscreen/view/LockScreenClock$Companion;", "", "()V", "DADA", "", "DIDI", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: LockScreenClock.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void start() {
        this.f24414c = true;
        ThreadPoolHelper.getInstance().execute(new Runnable() {
            public final void run() {
                LockScreenClock.m17468a(LockScreenClock.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m17468a(LockScreenClock lockScreenClock) {
        Intrinsics.checkNotNullParameter(lockScreenClock, "this$0");
        while (lockScreenClock.f24414c) {
            int i = 0;
            lockScreenClock.f24415d.sendEmptyMessage(10030);
            while (true) {
                int i2 = i + 1;
                if (i < 60) {
                    Thread.sleep(1000);
                    lockScreenClock.f24415d.sendEmptyMessage(10029);
                    i = i2;
                }
            }
        }
    }

    public final void stop() {
        this.f24414c = false;
    }
}
