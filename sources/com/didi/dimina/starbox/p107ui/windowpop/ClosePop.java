package com.didi.dimina.starbox.p107ui.windowpop;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.PixUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.ClosePop */
public final class ClosePop implements AsyncWindow, Dispatcher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnCloseCallback f18144a;

    /* renamed from: b */
    private final ImageView f18145b;

    /* renamed from: c */
    private final Context f18146c;

    /* renamed from: d */
    private final AsyncWindow f18147d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AsyncWindowPop f18148e;

    /* renamed from: f */
    private Dispatcher f18149f;

    /* renamed from: com.didi.dimina.starbox.ui.windowpop.ClosePop$OnCloseCallback */
    public interface OnCloseCallback {
        void onClose();
    }

    public void setOnCloseCallback(OnCloseCallback onCloseCallback) {
        this.f18144a = onCloseCallback;
    }

    public ClosePop(Context context, AsyncWindow asyncWindow, OnCloseCallback onCloseCallback) {
        this.f18146c = context;
        this.f18144a = onCloseCallback;
        this.f18147d = asyncWindow;
        this.f18145b = new AppCompatImageView(context);
        m13544a(context);
        this.f18148e = new AsyncWindowPop(context, this, this);
    }

    /* renamed from: a */
    private void m13544a(Context context) {
        this.f18145b.setImageResource(R.drawable.dimina_starbox_close_white);
        int dip2px = PixUtil.dip2px(context, 10.0f);
        this.f18145b.setPadding(dip2px, dip2px, dip2px, dip2px);
        this.f18145b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ClosePop.this.f18144a != null) {
                    ClosePop.this.f18144a.onClose();
                    ClosePop.this.f18148e.cancel();
                    return;
                }
                throw new IllegalStateException("setOnCloseCallback must not be null");
            }
        });
    }

    public void onLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = 40;
        layoutParams.width = PixUtil.dip2px(this.f18146c, 30.0f);
        layoutParams.height = PixUtil.dip2px(this.f18146c, 30.0f);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        AsyncWindow asyncWindow = this.f18147d;
        if (asyncWindow != null) {
            asyncWindow.onLayoutParams(layoutParams);
        }
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.f18149f = dispatcher;
    }

    public void pop() {
        this.f18148e.pop();
    }

    public View provideView() {
        AsyncWindow asyncWindow = this.f18147d;
        if (asyncWindow != null) {
            return asyncWindow.provideView();
        }
        return this.f18145b;
    }

    public boolean onForegroundChange(boolean z) {
        AsyncWindow asyncWindow = this.f18147d;
        if (asyncWindow != null) {
            return asyncWindow.onForegroundChange(z);
        }
        return false;
    }

    /* renamed from: a */
    private Dispatcher m13543a() {
        if (this.f18149f == null) {
            this.f18149f = new DefaultDispatcher();
        }
        return this.f18149f;
    }

    public void post(Runnable runnable) {
        m13543a().post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        m13543a().postDelay(runnable, j);
    }
}
