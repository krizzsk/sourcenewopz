package com.didi.safetoolkit.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.didichuxing.drtl.tookit.DRtlToolkit;

public class DiTips extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f34544a;

    /* renamed from: b */
    private View f34545b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Point f34546c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public float[] f34547d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f34548e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f34549f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f34550g;

    /* renamed from: h */
    private int f34551h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f34552i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f34553j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f34554k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f34555l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f34556m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public Animator f34557n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Animator f34558o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f34559p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public FrameLayout f34560q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ViewTreeObserver.OnGlobalLayoutListener f34561r;

    private DiTips(Context context) {
        super(context);
        this.f34546c = new Point();
        this.f34547d = new float[2];
        this.f34552i = false;
        this.f34553j = false;
        this.f34554k = false;
        this.f34561r = new ViewTreeObserver.OnGlobalLayoutListener() {
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
                    if (DiTips.this.f34544a != null) {
                        if (DiTips.this.f34544a.getMeasuredWidth() == 0 || DiTips.this.f34544a.getMeasuredHeight() == 0) {
                            DiTips.this.f34544a.post(new Runnable() {
                                public void run() {
                                    C117841.this.onGlobalLayout();
                                }
                            });
                        }
                        if (!DiTips.this.f34553j) {
                            DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f34561r);
                        }
                        if (DiTips.this.f34556m) {
                            int[] iArr = new int[2];
                            DiTips.this.f34544a.getLocationOnScreen(iArr);
                            if (DiTips.this.f34552i) {
                                iArr[1] = iArr[1] - DiTips.this.getStatusBarHeight();
                            }
                            int i8 = iArr[0];
                            int i9 = iArr[1];
                            int measuredWidth = DiTips.this.getMeasuredWidth() / 2;
                            int measuredHeight = DiTips.this.getMeasuredHeight() / 2;
                            if (DiTips.this.f34555l) {
                                measuredWidth = 0;
                            }
                            int h = DiTips.this.f34548e;
                            if (h != 1) {
                                if (h != 2) {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f34544a.getMeasuredWidth() / 2;
                                } else {
                                    i7 = i8 - measuredWidth;
                                    i6 = DiTips.this.f34544a.getMeasuredWidth();
                                }
                                i = i7 + i6;
                            } else {
                                i = i8 - measuredWidth;
                            }
                            int i10 = DiTips.this.f34549f;
                            if (i10 != 1) {
                                if (i10 != 2) {
                                    i5 = DiTips.this.getMeasuredHeight();
                                } else {
                                    i5 = DiTips.this.getMeasuredHeight();
                                }
                                i2 = i9 - i5;
                            } else {
                                i2 = i9 + DiTips.this.f34544a.getMeasuredHeight();
                            }
                            if (DiTips.this.f34547d[0] == 0.0f) {
                                i3 = i + DiTips.this.f34546c.x;
                            } else {
                                if (DiTips.this.f34555l) {
                                    f2 = (float) i;
                                    f = DiTips.this.f34547d[0];
                                    measuredWidth = DiTips.this.getMeasuredWidth();
                                } else {
                                    f2 = (float) i;
                                    f = DiTips.this.f34547d[0];
                                }
                                i3 = (int) (f2 + (f * ((float) measuredWidth)));
                            }
                            if (DiTips.this.f34547d[1] == 0.0f) {
                                i4 = i2 + DiTips.this.f34546c.y;
                            } else {
                                i4 = (int) (((float) i2) + (DiTips.this.f34547d[1] * ((float) DiTips.this.getMeasuredHeight())));
                            }
                            if (DiTips.this.f34554k) {
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
                            if (DRtlToolkit.rtl()) {
                                DiTips.this.setTranslationX((float) ((i3 - DiTips.this.getResources().getDisplayMetrics().widthPixels) + DiTips.this.getWidth()));
                            } else {
                                DiTips.this.setTranslationX((float) i3);
                            }
                            DiTips.this.setTranslationY((float) i4);
                            DiTips.this.setVisibility(0);
                            if (DiTips.this.f34558o != null) {
                                DiTips.this.f34558o.start();
                                Animator unused = DiTips.this.f34558o = null;
                            }
                            if (DiTips.this.f34559p) {
                                DiTips.this.f34560q.setOnTouchListener(new View.OnTouchListener() {
                                    public boolean onTouch(View view, MotionEvent motionEvent) {
                                        if (motionEvent.getAction() != 0 || !DiTips.this.f34559p || !DiTips.this.isShow()) {
                                            return false;
                                        }
                                        DiTips.this.dismiss();
                                        return false;
                                    }
                                });
                            } else {
                                DiTips.this.f34560q.setOnTouchListener((View.OnTouchListener) null);
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
    public void m24428a() {
        LayoutInflater.from(getContext()).inflate(this.f34550g, this, true);
        if (this.f34551h != 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.f34551h, this, false);
            this.f34545b = inflate;
            inflate.setVisibility(4);
            addView(this.f34545b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    private int m24422a(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public static class Builder {
        private DiTips mDiTips;

        public Builder(Context context, int i) {
            DiTips diTips = new DiTips(context);
            this.mDiTips = diTips;
            int unused = diTips.f34550g = i;
        }

        public Builder setAnchor(View view) {
            View unused = this.mDiTips.f34544a = view;
            return this;
        }

        public Builder setBelowAnchor(boolean z) {
            int unused = this.mDiTips.f34549f = z ? 1 : 0;
            return this;
        }

        public Builder setAboveAnchor(boolean z) {
            int unused = this.mDiTips.f34549f = z ? 2 : 0;
            return this;
        }

        public Builder setLeftAnchor(boolean z) {
            int unused = this.mDiTips.f34548e = z ? 1 : 0;
            return this;
        }

        public Builder setRightAnchor(boolean z) {
            int unused = this.mDiTips.f34548e = z ? 2 : 0;
            return this;
        }

        public Builder setOffsetX(int i) {
            this.mDiTips.f34546c.x = i;
            return this;
        }

        public Builder setOffsetY(int i) {
            this.mDiTips.f34546c.y = i;
            return this;
        }

        public Builder setDismissInTouchOut(boolean z) {
            boolean unused = this.mDiTips.f34559p = z;
            return this;
        }

        public Builder setFitsSystemWindows(boolean z) {
            boolean unused = this.mDiTips.f34552i = z;
            return this;
        }

        public Builder setOffsetXPercent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f34547d[0] = f;
            return this;
        }

        public Builder setOffsetYPersent(float f) {
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (f < -2.0f) {
                f = -2.0f;
            }
            this.mDiTips.f34547d[1] = f;
            return this;
        }

        public Builder setFollowingLayout(boolean z) {
            boolean unused = this.mDiTips.f34553j = z;
            return this;
        }

        public Builder setKeepInScreenRange(boolean z) {
            boolean unused = this.mDiTips.f34554k = z;
            return this;
        }

        public Builder setUseOriginalDrawPoint(boolean z) {
            boolean unused = this.mDiTips.f34555l = z;
            return this;
        }

        public DiTips build() {
            this.mDiTips.m24428a();
            return this.mDiTips;
        }
    }

    public boolean isShow() {
        return this.f34556m;
    }

    public void show(final Animator animator) {
        if (!this.f34556m) {
            final Activity activity = (Activity) getContext();
            if (!activity.isFinishing()) {
                setVisibility(4);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        FrameLayout unused = DiTips.this.f34560q = new FrameLayout(DiTips.this.getContext());
                        DiTips.this.f34560q.setBackgroundColor(0);
                        DiTips.this.f34560q.addView(DiTips.this, new FrameLayout.LayoutParams(-2, -2));
                        activity.addContentView(DiTips.this.f34560q, layoutParams);
                        DiTips.this.getViewTreeObserver().removeOnGlobalLayoutListener(DiTips.this.f34561r);
                        DiTips.this.getViewTreeObserver().addOnGlobalLayoutListener(DiTips.this.f34561r);
                        DiTips.this.requestLayout();
                        if (DiTips.this.f34557n != null) {
                            DiTips.this.f34557n.cancel();
                            Animator unused2 = DiTips.this.f34557n = null;
                        }
                        if (DiTips.this.f34558o != null) {
                            DiTips.this.f34558o.cancel();
                            Animator unused3 = DiTips.this.f34558o = null;
                        }
                        Animator animator = animator;
                        if (animator != null) {
                            Animator unused4 = DiTips.this.f34558o = animator;
                        }
                        boolean unused5 = DiTips.this.f34556m = true;
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
        if (this.f34556m) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f34561r);
            if (animator != null) {
                Animator animator2 = this.f34557n;
                if (animator2 != null) {
                    animator2.cancel();
                    this.f34557n = null;
                }
                Animator animator3 = this.f34558o;
                if (animator3 != null) {
                    animator3.cancel();
                    this.f34558o = null;
                }
                this.f34557n = animator;
                animator.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                                if (viewGroup != null) {
                                    viewGroup.removeView(DiTips.this);
                                }
                                boolean unused = DiTips.this.f34556m = false;
                            }
                        });
                    }
                });
                animator.start();
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (DiTips.this.f34557n != null) {
                        DiTips.this.f34557n.cancel();
                        Animator unused = DiTips.this.f34557n = null;
                    }
                    if (DiTips.this.f34558o != null) {
                        DiTips.this.f34558o.cancel();
                        Animator unused2 = DiTips.this.f34558o = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) DiTips.this.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(DiTips.this);
                    }
                    boolean unused3 = DiTips.this.f34556m = false;
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
