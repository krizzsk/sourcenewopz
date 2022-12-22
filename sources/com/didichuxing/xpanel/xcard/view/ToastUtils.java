package com.didichuxing.xpanel.xcard.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class ToastUtils {

    /* renamed from: a */
    View f49644a;

    /* renamed from: b */
    Context f49645b;

    /* renamed from: c */
    private Handler f49646c = new Handler(Looper.getMainLooper());

    public enum Type {
        NONE,
        ERROR,
        LOADING,
        SUCCESS,
        WARN,
        CONFIRM
    }

    public ToastUtils(Context context) {
        this.f49645b = context;
    }

    /* renamed from: a */
    private Hud m35858a(View view, Type type, String str) {
        ObjectAnimator objectAnimator = null;
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        boolean z = view instanceof RelativeLayout;
        boolean z2 = view instanceof FrameLayout;
        if (!z && !z2) {
            return null;
        }
        View inflate = ((LayoutInflater) this.f49645b.getSystemService("layout_inflater")).inflate(R.layout.layout_toast_with_icon, (ViewGroup) null);
        this.f49644a = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.toast_img);
        ((TextView) this.f49644a.findViewById(R.id.toast_txt)).setText(str);
        imageView.setImageResource(m35857a(type));
        if (type == Type.LOADING) {
            objectAnimator = ObjectAnimator.ofFloat(imageView, "rotation", new float[]{0.0f, 360.0f});
            objectAnimator.setRepeatMode(1);
            objectAnimator.setRepeatCount(-1);
            objectAnimator.setDuration(3000);
            objectAnimator.start();
        }
        if (z) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            viewGroup.addView(this.f49644a, layoutParams);
        } else if (z2) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 17;
            viewGroup.addView(this.f49644a, layoutParams2);
        }
        return new Hud(this.f49644a, objectAnimator);
    }

    public static void dismiss(Hud hud) {
        if (hud.f49647ra != null) {
            hud.f49647ra.cancel();
        }
        removeViewFromParent(hud.dialogView);
    }

    public static void removeViewFromParent(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            viewGroup.setClickable(true);
            viewGroup.removeView(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m35859a() {
        View view = this.f49644a;
        if (view != null && view.getParent() != null && (this.f49644a.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f49644a.getParent()).removeView(this.f49644a);
        }
    }

    public Hud loading(View view, String str) {
        view.setClickable(false);
        return m35858a(view, Type.LOADING, str);
    }

    public void toastError(View view, String str) {
        this.f49646c.removeCallbacksAndMessages((Object) null);
        m35859a();
        m35858a(view, Type.ERROR, str);
        this.f49646c.postDelayed(new Runnable() {
            public void run() {
                ToastUtils.this.m35859a();
            }
        }, 1000);
    }

    /* renamed from: a */
    private static int m35857a(Type type) {
        int ordinal = type.ordinal();
        if (ordinal == 1) {
            return R.drawable.toast_icon_warn;
        }
        if (ordinal == 2) {
            return R.drawable.toast_icon_loading;
        }
        if (ordinal != 3) {
            return -1;
        }
        return R.drawable.toast_icon_right;
    }

    public static class Hud {
        public View dialogView;

        /* renamed from: ra */
        public ObjectAnimator f49647ra;

        public Hud(View view, ObjectAnimator objectAnimator) {
            this.dialogView = view;
            this.f49647ra = objectAnimator;
        }
    }
}
