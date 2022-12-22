package com.didi.component.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class DiTips extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f11991a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f11992b;

    /* renamed from: c */
    private View f11993c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Point f11994d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float[] f11995e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f11996f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f11997g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f11998h;

    /* renamed from: i */
    private int f11999i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f12000j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f12001k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f12002l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f12003m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f12004n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f12005o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public Animator f12006p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public Animator f12007q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ViewTreeObserver.OnGlobalLayoutListener f12008r;

    private DiTips(Context context) {
        super(context);
        this.f11994d = new Point();
        this.f11995e = new float[2];
        this.f12000j = false;
        this.f12001k = false;
        this.f12002l = false;
        this.f12008r = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                int i;
                int i2;
                int i3;
                int i4;
                float f;
                float f2;
                int i5;
                int i6;
                int i7;
                try {
                    if (DiTips.this.f11992b != null) {
                        if (DiTips.this.f11992b.getMeasuredWidth() == 0 || DiTips.this.f11992b.getMeasuredHeight() == 0) {
                            DiTips.this.f11992b.post(new Runnable() {
                                public void run() {
                                    C48691.this.onGlobalLayout();
                                }
                            });
                        }
                        if (!DiTips.this.f12001k) {
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f12008r);
                        }
                        if (DiTips.this.f12004n) {
                            int[] iArr = new int[2];
                            DiTips.this.f11992b.getLocationOnScreen(iArr);
                            if (DiTips.this.f12000j) {
                                iArr[1] = iArr[1] - DiTips.this.getStatusBarHeight();
                            }
                            int i8 = iArr[0];
                            int i9 = iArr[1];
                            int measuredWidth = DiTips.this.getMeasuredWidth() / 2;
                            int measuredHeight = DiTips.this.getMeasuredHeight() / 2;
                            if (DiTips.this.f12003m) {
                                measuredWidth = 0;
                            }
                            int h = DiTips.this.f11996f;
                            if (h != 1) {
                                if (h != 2) {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f11992b.getMeasuredWidth() / 2;
                                } else {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f11992b.getMeasuredWidth();
                                }
                                i = i7 + i6;
                            } else {
                                i = i8 - measuredWidth;
                            }
                            int i10 = DiTips.this.f11997g;
                            if (i10 != 1) {
                                if (i10 != 2) {
                                    i5 = DiTips.this.getMeasuredHeight();
                                } else {
                                    i5 = DiTips.this.getMeasuredHeight();
                                }
                                i2 = i9 - i5;
                            } else {
                                i2 = i9 + DiTips.this.f11992b.getMeasuredHeight();
                            }
                            if (DiTips.this.f11995e[0] == 0.0f) {
                                i3 = i + DiTips.this.f11994d.x;
                            } else {
                                if (DiTips.this.f12003m) {
                                    f2 = (float) i;
                                    f = DiTips.this.f11995e[0];
                                    measuredWidth = DiTips.this.getMeasuredWidth();
                                } else {
                                    f2 = (float) i;
                                    f = DiTips.this.f11995e[0];
                                }
                                i3 = (int) (f2 + (f * ((float) measuredWidth)));
                            }
                            if (DiTips.this.f11995e[1] == 0.0f) {
                                i4 = i2 + DiTips.this.f11994d.y;
                            } else {
                                i4 = (int) (((float) i2) + (DiTips.this.f11995e[1] * ((float) DiTips.this.getMeasuredHeight())));
                            }
                            if (DiTips.this.f12002l) {
                                int i11 = DiTips.this.getResources().getDisplayMetrics().widthPixels;
                                int i12 = DiTips.this.getResources().getDisplayMetrics().heightPixels;
                                if (i3 < 0) {
                                    i3 = 0;
                                }
                                if (i4 < 0) {
                                    i4 = 0;
                                }
                                if (i3 > i11) {
                                    i3 = i11;
                                }
                                if (i4 > i12) {
                                    i4 = i12;
                                }
                            }
                            DiTips.this.setTranslationX((float) i3);
                            DiTips.this.setTranslationY((float) i4);
                            DiTips.this.setVisibility(0);
                            if (DiTips.this.f12007q != null) {
                                DiTips.this.f12007q.start();
                                Animator unused = DiTips.this.f12007q = null;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8076a() {
        LayoutInflater.from(getContext()).inflate(this.f11998h, this, true);
        if (this.f11999i != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f11999i, this, false);
            this.f11993c = inflate;
            inflate.setVisibility(4);
            addView(this.f11993c, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    private int m8070a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public static class Builder {
        private DiTips mDiTips;

        public Builder(Context context, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            int unused = diTips.f11998h = i;
        }

        public Builder(Context context, ViewGroup viewGroup, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            ViewGroup unused = diTips.f11991a = viewGroup;
            int unused2 = this.mDiTips.f11998h = i;
        }

        public Builder setAnchor(View view) {
            View unused = this.mDiTips.f11992b = view;
            return this;
        }

        public Builder setBelowAnchor(boolean z) {
            int unused = this.mDiTips.f11997g = z ? 1 : 0;
            return this;
        }

        public Builder setAboveAnchor(boolean z) {
            int unused = this.mDiTips.f11997g = z ? 2 : 0;
            return this;
        }

        public Builder setLeftAnchor(boolean z) {
            int unused = this.mDiTips.f11996f = z ? 1 : 0;
            return this;
        }

        public Builder setRightAnchor(boolean z) {
            int unused = this.mDiTips.f11996f = z ? 2 : 0;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mDiTips.f11994d.x = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mDiTips.f11994d.y = i;
            return this;
        }

        public Builder setFitsSystemWindows(boolean z) {
            boolean unused = this.mDiTips.f12000j = z;
            return this;
        }

        public Builder setOffsetXPercent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f11995e[0] = f;
            return this;
        }

        public Builder setOffsetYPersent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f11995e[1] = f;
            return this;
        }

        public Builder setFollowingLayout(boolean z) {
            boolean unused = this.mDiTips.f12001k = z;
            return this;
        }

        public Builder setKeepInScreenRange(boolean z) {
            boolean unused = this.mDiTips.f12002l = z;
            return this;
        }

        public Builder setUseOriginalDrawPoint(boolean z) {
            boolean unused = this.mDiTips.f12003m = z;
            return this;
        }

        public DiTips build() {
            this.mDiTips.m8076a();
            return this.mDiTips;
        }
    }

    public boolean isShow() {
        return this.f12004n;
    }

    public void show(final Animator animator) {
        if (!this.f12004n) {
            this.f12005o = false;
            final Activity activity = (Activity) getContext();
            if (!activity.isFinishing()) {
                setVisibility(4);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!DiTips.this.f12005o) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            if (DiTips.this.f11991a != null) {
                                DiTips.this.f11991a.addView(DiTips.this, layoutParams);
                            } else {
                                activity.addContentView(DiTips.this, layoutParams);
                            }
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f12008r);
                            DiTips.this.getViewTreeObserver().addOnGlobalLayoutListener(DiTips.this.f12008r);
                            DiTips.this.requestLayout();
                            if (DiTips.this.f12006p != null) {
                                DiTips.this.f12006p.cancel();
                                Animator unused = DiTips.this.f12006p = null;
                            }
                            if (DiTips.this.f12007q != null) {
                                DiTips.this.f12007q.cancel();
                                Animator unused2 = DiTips.this.f12007q = null;
                            }
                            Animator animator = animator;
                            if (animator != null) {
                                Animator unused3 = DiTips.this.f12007q = animator;
                            }
                            boolean unused4 = DiTips.this.f12004n = true;
                        }
                    }
                });
            }
        }
    }

    public void show() {
        show((Animator) null);
    }

    public void dismiss() {
        dismiss((Animator) null);
    }

    public void dismiss(Animator animator) {
        if (this.f12004n) {
            this.f12005o = true;
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f12008r);
            if (animator != null) {
                Animator animator2 = this.f12006p;
                if (animator2 != null) {
                    animator2.cancel();
                    this.f12006p = null;
                }
                Animator animator3 = this.f12007q;
                if (animator3 != null) {
                    animator3.cancel();
                    this.f12007q = null;
                }
                this.f12006p = animator;
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                                if (viewGroup != null) {
                                    viewGroup.removeView(DiTips.this);
                                }
                                boolean unused = DiTips.this.f12004n = false;
                            }
                        });
                    }
                });
                animator.start();
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (DiTips.this.f12006p != null) {
                        DiTips.this.f12006p.cancel();
                        Animator unused = DiTips.this.f12006p = null;
                    }
                    if (DiTips.this.f12007q != null) {
                        DiTips.this.f12007q.cancel();
                        Animator unused2 = DiTips.this.f12007q = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(DiTips.this);
                    }
                    boolean unused3 = DiTips.this.f12004n = false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
