package com.didi.soda.business.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;
import com.didi.app.nova.skeleton.conductor.changehandler.SimpleSwapChangeHandler;
import com.didi.soda.business.page.OverlayView;
import com.didi.soda.business.page.PreviewImageChangeHandler;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.taxis99.R;
import java.util.ArrayList;

public class PreviewImageChangeHandler extends SimpleSwapChangeHandler {

    /* renamed from: a */
    private static final String f39747a = "PreviewImageChangeHandler";

    /* renamed from: b */
    private TranslationValue f39748b;

    /* renamed from: c */
    private TranslationValue f39749c;

    /* renamed from: d */
    private String f39750d;

    /* renamed from: e */
    private FrameLayout f39751e;

    /* renamed from: f */
    private boolean f39752f;

    /* renamed from: g */
    private boolean f39753g = false;

    public PreviewImageChangeHandler() {
        super(false);
    }

    public PreviewImageChangeHandler(String str) {
        super(false);
        this.f39750d = str;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m28327b(View view, int[] iArr) {
        view.getLocationOnScreen(iArr);
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f39752f = true;
    }

    public void setPopFadeChange() {
        this.f39753g = true;
    }

    public void performChange(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        final int i;
        ViewGroup viewGroup2 = viewGroup;
        if (view == null || view2 == null) {
            super.performChange(viewGroup, view, view2, z, controllerChangeCompletedListener);
            return;
        }
        boolean z2 = !TextUtils.isEmpty(this.f39750d);
        if (z2) {
            int[] iArr = new int[2];
            m28327b(viewGroup, iArr);
            i = iArr[1];
            m28320a(view, true, i);
        } else {
            i = 0;
        }
        m28322a(viewGroup, view, view2, z, controllerChangeCompletedListener);
        if (z2) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            this.f39751e = frameLayout;
            frameLayout.setClickable(false);
            viewGroup.addView(this.f39751e, new ViewGroup.LayoutParams(-1, -1));
            if (!z) {
                this.f39751e.addView(view);
            }
            final View view3 = view2;
            final ViewGroup viewGroup3 = viewGroup;
            final View view4 = view;
            final boolean z3 = z;
            final ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener2 = controllerChangeCompletedListener;
            view2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    view3.getViewTreeObserver().removeOnPreDrawListener(this);
                    PreviewImageChangeHandler.this.m28320a(view3, false, i);
                    PreviewImageChangeHandler.this.m28323a(viewGroup3, view4, view3, z3, (OverlayView.AnimateEndListener) new OverlayView.AnimateEndListener(controllerChangeCompletedListener2) {
                        public final /* synthetic */ ControllerChangeHandler.ControllerChangeCompletedListener f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onAnimationEnd() {
                            PreviewImageChangeHandler.C135021.this.lambda$onPreDraw$0$PreviewImageChangeHandler$1(this.f$1);
                        }
                    });
                    return true;
                }

                public /* synthetic */ void lambda$onPreDraw$0$PreviewImageChangeHandler$1(ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
                    controllerChangeCompletedListener.onChangeCompleted();
                    PreviewImageChangeHandler.this.m28329d();
                }
            });
        }
    }

    /* renamed from: a */
    private void m28322a(ViewGroup viewGroup, View view, View view2, boolean z, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (!this.f39752f) {
            if (view != null && (!z || removesFromViewOnPush())) {
                viewGroup.removeView(view);
            }
            if (view2 != null && view2.getParent() == null) {
                viewGroup.addView(view2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28323a(ViewGroup viewGroup, View view, View view2, boolean z, final OverlayView.AnimateEndListener animateEndListener) {
        Animator a = m28319a(view, view2, z);
        Animator c = this.f39753g ? null : m28328c();
        if (a == null && c == null) {
            animateEndListener.onAnimationEnd();
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (a != null) {
            arrayList.add(a);
        }
        if (c != null) {
            arrayList.add(c);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                animateEndListener.onAnimationEnd();
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                animateEndListener.onAnimationEnd();
            }
        });
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200);
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        animatorSet.start();
    }

    /* renamed from: a */
    private Animator m28319a(View view, View view2, boolean z) {
        int i;
        int i2;
        View view3;
        if (view == null || view2 == null) {
            return null;
        }
        if (z) {
            view3 = view2.findViewById(R.id.customer_cl_image_root_view);
            i2 = 0;
            i = 1;
        } else {
            view3 = view.findViewById(R.id.customer_cl_image_root_view);
            i2 = 1;
            i = 0;
        }
        if (view3 == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{(float) i2, (float) i});
        ofFloat.setDuration(200);
        ofFloat.setInterpolator(CustomerInterpolator.newInstance());
        return ofFloat;
    }

    /* renamed from: c */
    private Animator m28328c() {
        TranslationValue translationValue = this.f39748b;
        if (!(translationValue == null || this.f39749c == null)) {
            View view = translationValue.mView;
            try {
                Bitmap createBitmap = (view.getWidth() <= 0 || view.getHeight() <= 0) ? null : Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                if (createBitmap == null) {
                    LogUtil.m29102e("PreviewImage", "创建图片失败，不支持转场动画");
                    return null;
                }
                view.draw(new Canvas(createBitmap));
                OverlayView overlayView = new OverlayView(this.f39751e.getContext(), createBitmap);
                this.f39751e.addView(overlayView, new ViewGroup.LayoutParams(-1, -1));
                overlayView.mo100892a(view, this.f39748b.mScreenX, this.f39748b.mScreenY);
                overlayView.mo100894b(this.f39749c.mView, this.f39749c.mScreenX, this.f39749c.mScreenY);
                return overlayView.mo100893b();
            } catch (OutOfMemoryError unused) {
                LogUtil.m29102e("PreviewImage", "创建图片失败 OOM 异常，不支持转场动画");
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m28329d() {
        FrameLayout frameLayout = this.f39751e;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f39751e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28320a(View view, boolean z, int i) {
        if (view != null && !TextUtils.isEmpty(this.f39750d)) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (z) {
                if (TextUtils.equals(this.f39750d, transitionName)) {
                    if (this.f39748b == null) {
                        this.f39748b = TranslationValue.create(view, i);
                    } else {
                        LogUtil.m29106w(f39747a, "页面中含有两个相同的 Transition Name value = " + transitionName + "， 动画时会忽略第二个");
                    }
                }
            } else if (TextUtils.equals(this.f39750d, transitionName)) {
                if (this.f39749c == null) {
                    this.f39749c = TranslationValue.create(view, i);
                } else {
                    LogUtil.m29106w(f39747a, "页面中含有两个相同的 Transition Name value = " + transitionName + "， 动画时会忽略第二个");
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    m28320a(viewGroup.getChildAt(i2), z, i);
                }
            }
        }
    }

    private static class TranslationValue {
        int mScreenX;
        int mScreenY;
        View mView;

        private TranslationValue() {
        }

        static TranslationValue create(View view, int i) {
            TranslationValue translationValue = new TranslationValue();
            translationValue.mView = view;
            int[] iArr = new int[2];
            PreviewImageChangeHandler.m28327b(view, iArr);
            translationValue.mScreenX = iArr[0];
            translationValue.mScreenY = iArr[1] - i;
            return translationValue;
        }
    }
}
