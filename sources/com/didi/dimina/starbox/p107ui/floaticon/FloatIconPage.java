package com.didi.dimina.starbox.p107ui.floaticon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.PixUtil;
import com.didi.dimina.starbox.StarBox;
import com.didi.dimina.starbox.p107ui.windowpop.AsyncWindow;
import com.didi.dimina.starbox.p107ui.windowpop.AsyncWindowPop;
import com.taxis99.R;

/* renamed from: com.didi.dimina.starbox.ui.floaticon.FloatIconPage */
public class FloatIconPage implements AsyncWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AsyncWindowPop f18121a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f18122b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public float f18123c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float f18124d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f18125e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f18126f;

    /* renamed from: g */
    private final View.OnTouchListener f18127g = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            int action = motionEvent.getAction();
            if (action == 0) {
                FloatIconPage floatIconPage = FloatIconPage.this;
                float unused = floatIconPage.f18123c = floatIconPage.f18125e = rawX;
                FloatIconPage floatIconPage2 = FloatIconPage.this;
                float unused2 = floatIconPage2.f18124d = floatIconPage2.f18126f = rawY;
                return false;
            } else if (action == 1) {
                float scaledTouchSlop = (float) ViewConfiguration.get(FloatIconPage.this.f18122b).getScaledTouchSlop();
                if (Math.abs(rawX - FloatIconPage.this.f18123c) > scaledTouchSlop || Math.abs(rawY - FloatIconPage.this.f18124d) > scaledTouchSlop) {
                    return true;
                }
                return false;
            } else if (action != 2) {
                return false;
            } else {
                WindowManager.LayoutParams layoutParams = FloatIconPage.this.f18121a.getLayoutParams();
                layoutParams.x = (int) (((float) layoutParams.x) + (rawX - FloatIconPage.this.f18125e) + 0.5f);
                WindowManager.LayoutParams layoutParams2 = FloatIconPage.this.f18121a.getLayoutParams();
                layoutParams2.y = (int) (((float) layoutParams2.y) + (rawY - FloatIconPage.this.f18126f) + 0.5f);
                float unused3 = FloatIconPage.this.f18125e = rawX;
                float unused4 = FloatIconPage.this.f18126f = rawY;
                FloatIconPage.this.f18121a.updateViewLayout(FloatIconPage.this.f18121a.getFloatView(), FloatIconPage.this.f18121a.getLayoutParams());
                return false;
            }
        }
    };

    public boolean onForegroundChange(boolean z) {
        return false;
    }

    public FloatIconPage(Context context) {
        this.f18122b = context;
        this.f18121a = new AsyncWindowPop(context, this);
    }

    public void pop() {
        this.f18121a.pop();
    }

    public View provideView() {
        View inflate = LayoutInflater.from(this.f18122b).inflate(R.layout.dimina_starbox_float_launch_icon, (ViewGroup) null, false);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                StarBox.launchStarBoxPage(view.getContext());
            }
        });
        inflate.setOnTouchListener(this.f18127g);
        return inflate;
    }

    public void onLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = 8;
        layoutParams.x = PixUtil.px2dip(this.f18122b, (float) this.f18122b.getResources().getDisplayMetrics().widthPixels);
        layoutParams.width = -2;
        layoutParams.height = -2;
    }
}
