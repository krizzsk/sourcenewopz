package com.didi.app.nova.skeleton.conductor.changehandler;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.didi.app.nova.skeleton.conductor.Controller;
import com.didi.app.nova.skeleton.conductor.ControllerChangeHandler;

public abstract class AnimatorChangeHandler extends ControllerChangeHandler {
    public static final long DEFAULT_ANIMATION_DURATION = -1;

    /* renamed from: a */
    private static final String f8358a = "AnimatorChangeHandler.duration";

    /* renamed from: b */
    private static final String f8359b = "AnimatorChangeHandler.removesFromViewOnPush";

    /* renamed from: c */
    private long f8360c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f8361d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f8362e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f8363f;

    /* renamed from: g */
    private boolean f8364g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Animator f8365h;

    /* renamed from: i */
    private OnAnimationReadyOrAbortedListener f8366i;

    /* access modifiers changed from: protected */
    public abstract Animator getAnimator(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2);

    /* access modifiers changed from: protected */
    public abstract void resetFromView(View view);

    public AnimatorChangeHandler() {
        this(-1, true);
    }

    public AnimatorChangeHandler(boolean z) {
        this(-1, z);
    }

    public AnimatorChangeHandler(long j) {
        this(j, true);
    }

    public AnimatorChangeHandler(long j, boolean z) {
        this.f8360c = j;
        this.f8361d = z;
    }

    public void saveToBundle(Bundle bundle) {
        super.saveToBundle(bundle);
        bundle.putLong(f8358a, this.f8360c);
        bundle.putBoolean(f8359b, this.f8361d);
    }

    public void restoreFromBundle(Bundle bundle) {
        super.restoreFromBundle(bundle);
        this.f8360c = bundle.getLong(f8358a);
        this.f8361d = bundle.getBoolean(f8359b);
    }

    public void onAbortPush(ControllerChangeHandler controllerChangeHandler, Controller controller) {
        super.onAbortPush(controllerChangeHandler, controller);
        this.f8362e = true;
        Animator animator = this.f8365h;
        if (animator != null) {
            animator.cancel();
            return;
        }
        OnAnimationReadyOrAbortedListener onAnimationReadyOrAbortedListener = this.f8366i;
        if (onAnimationReadyOrAbortedListener != null) {
            onAnimationReadyOrAbortedListener.onReadyOrAborted();
        }
    }

    public void completeImmediately() {
        super.completeImmediately();
        this.f8363f = true;
        Animator animator = this.f8365h;
        if (animator != null) {
            animator.end();
            return;
        }
        OnAnimationReadyOrAbortedListener onAnimationReadyOrAbortedListener = this.f8366i;
        if (onAnimationReadyOrAbortedListener != null) {
            onAnimationReadyOrAbortedListener.onReadyOrAborted();
        }
    }

    public long getAnimationDuration() {
        return this.f8360c;
    }

    public boolean removesFromViewOnPush() {
        return this.f8361d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void performChange(android.view.ViewGroup r15, android.view.View r16, android.view.View r17, boolean r18, com.didi.app.nova.skeleton.conductor.ControllerChangeHandler.ControllerChangeCompletedListener r19) {
        /*
            r14 = this;
            r8 = r14
            r9 = r15
            r10 = r17
            r11 = 0
            r0 = 1
            if (r10 == 0) goto L_0x0010
            android.view.ViewParent r1 = r17.getParent()
            if (r1 != 0) goto L_0x0010
            r12 = 1
            goto L_0x0011
        L_0x0010:
            r12 = 0
        L_0x0011:
            if (r12 == 0) goto L_0x0052
            if (r18 != 0) goto L_0x0026
            if (r16 != 0) goto L_0x0018
            goto L_0x0026
        L_0x0018:
            android.view.ViewParent r1 = r17.getParent()
            if (r1 != 0) goto L_0x0029
            int r1 = r15.indexOfChild(r16)
            r15.addView(r10, r1)
            goto L_0x0029
        L_0x0026:
            r15.addView(r10)
        L_0x0029:
            int r1 = r17.getWidth()
            if (r1 > 0) goto L_0x0052
            int r1 = r17.getHeight()
            if (r1 > 0) goto L_0x0052
            com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler$OnAnimationReadyOrAbortedListener r13 = new com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler$OnAnimationReadyOrAbortedListener
            r6 = 1
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r7 = r19
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r8.f8366i = r13
            android.view.ViewTreeObserver r0 = r17.getViewTreeObserver()
            com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler$OnAnimationReadyOrAbortedListener r1 = r8.f8366i
            r0.addOnPreDrawListener(r1)
            goto L_0x0053
        L_0x0052:
            r11 = 1
        L_0x0053:
            if (r11 == 0) goto L_0x0063
            r0 = r14
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r12
            r6 = r19
            r0.m5555a(r1, r2, r3, r4, r5, r6)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.skeleton.conductor.changehandler.AnimatorChangeHandler.performChange(android.view.ViewGroup, android.view.View, android.view.View, boolean, com.didi.app.nova.skeleton.conductor.ControllerChangeHandler$ControllerChangeCompletedListener):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5556a(ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener, Animator.AnimatorListener animatorListener) {
        if (!this.f8364g) {
            this.f8364g = true;
            controllerChangeCompletedListener.onChangeCompleted();
        }
        Animator animator = this.f8365h;
        if (animator != null) {
            if (animatorListener != null) {
                animator.removeListener(animatorListener);
            }
            this.f8365h.cancel();
            this.f8365h = null;
        }
        this.f8366i = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5555a(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
        if (this.f8362e) {
            m5556a(controllerChangeCompletedListener, (Animator.AnimatorListener) null);
        } else if (this.f8363f) {
            if (view != null && (!z || this.f8361d)) {
                viewGroup.removeView(view);
            }
            m5556a(controllerChangeCompletedListener, (Animator.AnimatorListener) null);
            if (z && view != null) {
                resetFromView(view);
            }
        } else {
            Animator animator = getAnimator(viewGroup, view, view2, z, z2);
            this.f8365h = animator;
            long j = this.f8360c;
            if (j > 0) {
                animator.setDuration(j);
            }
            final View view3 = view;
            final boolean z3 = z;
            final ViewGroup viewGroup2 = viewGroup;
            final ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener2 = controllerChangeCompletedListener;
            this.f8365h.addListener(new AnimatorListenerAdapter() {
                public void onAnimationCancel(Animator animator) {
                    if (view3 != null && ((!z3 || AnimatorChangeHandler.this.f8361d) && AnimatorChangeHandler.this.f8363f)) {
                        viewGroup2.removeView(view3);
                    }
                    AnimatorChangeHandler.this.m5556a(controllerChangeCompletedListener2, this);
                }

                public void onAnimationEnd(Animator animator) {
                    View view;
                    if (!AnimatorChangeHandler.this.f8362e && AnimatorChangeHandler.this.f8365h != null) {
                        if (view3 != null && (!z3 || AnimatorChangeHandler.this.f8361d)) {
                            viewGroup2.removeView(view3);
                        }
                        AnimatorChangeHandler.this.m5556a(controllerChangeCompletedListener2, this);
                        if (z3 && (view = view3) != null) {
                            AnimatorChangeHandler.this.resetFromView(view);
                        }
                    }
                }
            });
            this.f8365h.start();
        }
    }

    private class OnAnimationReadyOrAbortedListener implements ViewTreeObserver.OnPreDrawListener {
        final boolean addingToView;
        final ControllerChangeHandler.ControllerChangeCompletedListener changeListener;
        final ViewGroup container;
        final View from;
        private boolean hasRun;
        final boolean isPush;

        /* renamed from: to */
        final View f8367to;

        OnAnimationReadyOrAbortedListener(ViewGroup viewGroup, View view, View view2, boolean z, boolean z2, ControllerChangeHandler.ControllerChangeCompletedListener controllerChangeCompletedListener) {
            this.container = viewGroup;
            this.from = view;
            this.f8367to = view2;
            this.isPush = z;
            this.addingToView = z2;
            this.changeListener = controllerChangeCompletedListener;
        }

        public boolean onPreDraw() {
            onReadyOrAborted();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void onReadyOrAborted() {
            if (!this.hasRun) {
                this.hasRun = true;
                View view = this.f8367to;
                if (view != null) {
                    ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this);
                    }
                }
                AnimatorChangeHandler.this.m5555a(this.container, this.from, this.f8367to, this.isPush, this.addingToView, this.changeListener);
            }
        }
    }
}
