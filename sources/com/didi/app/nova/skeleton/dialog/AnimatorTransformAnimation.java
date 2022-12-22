package com.didi.app.nova.skeleton.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;

public abstract class AnimatorTransformAnimation extends TransformAnimation {
    public static final int DEFAULT_ANIMATION_DURATION = -1;

    /* renamed from: b */
    private int f8415b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f8416c = false;

    /* renamed from: d */
    private boolean f8417d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f8418e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Animator f8419f;

    /* renamed from: g */
    private OnAnimationReadyOrAbortedListener f8420g;

    public abstract Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z);

    public abstract void resetFromView(View view);

    public AnimatorTransformAnimation() {
        super(true);
    }

    public AnimatorTransformAnimation(int i, boolean z) {
        super(z);
        this.f8415b = i;
    }

    public void onAbortPush() {
        this.f8416c = true;
        Animator animator = this.f8419f;
        if (animator != null) {
            animator.cancel();
            return;
        }
        OnAnimationReadyOrAbortedListener onAnimationReadyOrAbortedListener = this.f8420g;
        if (onAnimationReadyOrAbortedListener != null) {
            onAnimationReadyOrAbortedListener.onReadyOrAborted();
        }
    }

    public void completeAnimationImmediately() {
        this.f8418e = true;
        Animator animator = this.f8419f;
        if (animator != null) {
            animator.end();
            return;
        }
        OnAnimationReadyOrAbortedListener onAnimationReadyOrAbortedListener = this.f8420g;
        if (onAnimationReadyOrAbortedListener != null) {
            onAnimationReadyOrAbortedListener.onReadyOrAborted();
        }
    }

    public int getAnimationDuration() {
        return this.f8415b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performChange(android.view.ViewGroup r11, android.view.View r12, android.view.View r13, boolean r14, com.didi.app.nova.skeleton.dialog.TransformAnimation.TransformAnimationListener r15) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r13 == 0) goto L_0x000c
            android.view.ViewParent r2 = r13.getParent()
            if (r2 != 0) goto L_0x000c
            r2 = 1
            goto L_0x000d
        L_0x000c:
            r2 = 0
        L_0x000d:
            if (r2 == 0) goto L_0x0049
            if (r14 != 0) goto L_0x0022
            if (r12 != 0) goto L_0x0014
            goto L_0x0022
        L_0x0014:
            android.view.ViewParent r2 = r13.getParent()
            if (r2 != 0) goto L_0x0025
            int r2 = r11.indexOfChild(r12)
            r11.addView(r13, r2)
            goto L_0x0025
        L_0x0022:
            r11.addView(r13)
        L_0x0025:
            int r2 = r13.getWidth()
            if (r2 > 0) goto L_0x0049
            int r2 = r13.getHeight()
            if (r2 > 0) goto L_0x0049
            com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation$OnAnimationReadyOrAbortedListener r1 = new com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation$OnAnimationReadyOrAbortedListener
            r3 = r1
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            r3.<init>(r5, r6, r7, r8, r9)
            r10.f8420g = r1
            android.view.ViewTreeObserver r1 = r13.getViewTreeObserver()
            com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation$OnAnimationReadyOrAbortedListener r2 = r10.f8420g
            r1.addOnPreDrawListener(r2)
            goto L_0x004a
        L_0x0049:
            r0 = 1
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r10.m5609a(r11, r12, r13, r14, r15)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.dialog.AnimatorTransformAnimation.performChange(android.view.ViewGroup, android.view.View, android.view.View, boolean, com.didi.app.nova.skeleton.dialog.TransformAnimation$TransformAnimationListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5612a(TransformAnimation.TransformAnimationListener transformAnimationListener, Animator.AnimatorListener animatorListener) {
        if (!this.f8417d) {
            this.f8417d = true;
            transformAnimationListener.onAnimationCompleted();
        }
        Animator animator = this.f8419f;
        if (animator != null) {
            if (animatorListener != null) {
                animator.removeListener(animatorListener);
            }
            this.f8419f.cancel();
            this.f8419f = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5609a(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimation.TransformAnimationListener transformAnimationListener) {
        if (this.f8416c) {
            m5612a(transformAnimationListener, (Animator.AnimatorListener) null);
        } else if (this.f8418e) {
            if (view != null && (!z || removeFromViewOnEnter())) {
                viewGroup.removeView(view);
            }
            m5612a(transformAnimationListener, (Animator.AnimatorListener) null);
            if (z && view != null) {
                resetFromView(view);
            }
        } else {
            Animator animator = getAnimator(viewGroup, view, view2, z);
            this.f8419f = animator;
            int i = this.f8415b;
            if (i > 0) {
                animator.setDuration((long) i);
            }
            final View view3 = view;
            final boolean z2 = z;
            final ViewGroup viewGroup2 = viewGroup;
            final TransformAnimation.TransformAnimationListener transformAnimationListener2 = transformAnimationListener;
            this.f8419f.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    if (view3 != null && ((!z2 || AnimatorTransformAnimation.this.removeFromViewOnEnter()) && AnimatorTransformAnimation.this.f8418e)) {
                        viewGroup2.removeView(view3);
                    }
                    AnimatorTransformAnimation.this.m5612a(transformAnimationListener2, this);
                }

                public void onAnimationEnd(Animator animator) {
                    View view;
                    if (!AnimatorTransformAnimation.this.f8416c && AnimatorTransformAnimation.this.f8419f != null) {
                        if (view3 != null && (!z2 || AnimatorTransformAnimation.this.removeFromViewOnEnter())) {
                            viewGroup2.removeView(view3);
                        }
                        AnimatorTransformAnimation.this.m5612a(transformAnimationListener2, this);
                        if (z2 && (view = view3) != null) {
                            AnimatorTransformAnimation.this.resetFromView(view);
                        }
                    }
                }
            });
            this.f8419f.start();
        }
    }

    private class OnAnimationReadyOrAbortedListener implements ViewTreeObserver.OnPreDrawListener {
        final TransformAnimation.TransformAnimationListener changeListener;
        final ViewGroup container;
        final View from;
        private boolean hasRun;
        final boolean isPush;

        /* renamed from: to */
        final View f8421to;

        OnAnimationReadyOrAbortedListener(ViewGroup viewGroup, View view, View view2, boolean z, TransformAnimation.TransformAnimationListener transformAnimationListener) {
            this.container = viewGroup;
            this.from = view;
            this.f8421to = view2;
            this.isPush = z;
            this.changeListener = transformAnimationListener;
        }

        public boolean onPreDraw() {
            onReadyOrAborted();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void onReadyOrAborted() {
            if (!this.hasRun) {
                this.hasRun = true;
                View view = this.f8421to;
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this);
                    }
                }
                AnimatorTransformAnimation.this.m5609a(this.container, this.from, this.f8421to, this.isPush, this.changeListener);
            }
        }
    }
}
