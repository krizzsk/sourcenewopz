package com.didi.beatles.p099im.access.notify.decorfloat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.didi.beatles.p099im.access.notify.decorfloat.IIMDecorFloatMsg;
import com.didi.beatles.p099im.access.notify.decorfloat.wrapper.IMFloatMessageWrapper;
import com.didi.beatles.p099im.common.util.IMUtils;
import com.didi.beatles.p099im.manager.IMActivityController;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMWindowUtil;
import com.didi.beatles.p099im.utils.UiThreadHandler;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.didi.beatles.im.access.notify.decorfloat.IMDecorFloatController */
public class IMDecorFloatController {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f8811a = IMDecorFloatController.class.getSimpleName();

    /* renamed from: b */
    private static final int f8812b = 1000;

    /* renamed from: c */
    private DecorFloatViewGroup f8813c;

    /* renamed from: d */
    private Queue<IIMDecorFloatMsg<?>> f8814d;

    /* renamed from: e */
    private Runnable f8815e;

    /* renamed from: f */
    private Runnable f8816f;

    private IMDecorFloatController() {
        this.f8814d = new LinkedList();
        this.f8815e = new Runnable() {
            public void run() {
                IMDecorFloatController.this.m5881a(true, 0);
            }
        };
        this.f8816f = new Runnable() {
            public void run() {
                IMDecorFloatController.this.m5883b();
            }
        };
    }

    public static IMDecorFloatController getInstance() {
        return Holder.INSTANCE;
    }

    public void add(IMMessage iMMessage) {
        if (iMMessage == null) {
            IMLog.m6632e(f8811a, "[add] null message");
            return;
        }
        add((IIMDecorFloatMsg<?>) new IMFloatMessageWrapper(iMMessage));
    }

    public void add(IIMDecorFloatMsg<?> iIMDecorFloatMsg) {
        IMLog.m6631d(f8811a, "[add] new decor float msg");
        if (iIMDecorFloatMsg != null) {
            this.f8814d.add(iIMDecorFloatMsg);
            if (this.f8813c == null) {
                Runnable runnable = this.f8816f;
                if (runnable != null) {
                    UiThreadHandler.removeCallbacks(runnable);
                }
                m5883b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m5883b() {
        Queue<IIMDecorFloatMsg<?>> queue = this.f8814d;
        if (queue == null || queue.isEmpty()) {
            IMLog.m6631d(f8811a, "[showNext] #queue is empty#");
        } else if (!m5882a(this.f8814d.poll())) {
            IMLog.m6631d(f8811a, "[showNext] #poll#");
            m5883b();
        }
    }

    /* renamed from: a */
    private <T> boolean m5882a(IIMDecorFloatMsg<T> iIMDecorFloatMsg) {
        if (iIMDecorFloatMsg == null) {
            return false;
        }
        if (!IMUtils.isAppForeground()) {
            IMLog.m6632e(f8811a, "[show] ignore with app in background");
            iIMDecorFloatMsg.showNotification();
            return false;
        }
        Activity topActivity = IMActivityController.getInstance().getTopActivity();
        if (topActivity == null) {
            IMLog.m6632e(f8811a, "[show] ignore with top activity is null");
            iIMDecorFloatMsg.showNotification();
            return false;
        } else if (!iIMDecorFloatMsg.canShowFloat(topActivity)) {
            IMLog.m6632e(f8811a, "[show] ignore with can't show float");
            return false;
        } else {
            ViewGroup a = m5877a(topActivity);
            if (a == null) {
                IMLog.m6632e(f8811a, "[show] #IGNORE# with null parent view");
                iIMDecorFloatMsg.showNotification();
                return false;
            }
            View view = iIMDecorFloatMsg.getView(topActivity, new IIMDecorFloatMsg.RequestCallback() {
                public void requestDismiss(int i) {
                    IMDecorFloatController.this.m5881a(true, i);
                }

                public void requestCancelDismissTask() {
                    IMDecorFloatController.this.m5885c();
                }
            });
            if (view == null) {
                IMLog.m6632e(f8811a, "[show] #IGNORE# with null float view");
                return false;
            }
            Animator enterAnimator = iIMDecorFloatMsg.getEnterAnimator(view);
            DecorFloatViewGroup decorFloatViewGroup = new DecorFloatViewGroup(a, view, enterAnimator, iIMDecorFloatMsg.getExitAnimator(view));
            this.f8813c = decorFloatViewGroup;
            decorFloatViewGroup.showFloatView();
            UiThreadHandler.postDelayed(this.f8815e, iIMDecorFloatMsg.getDisplayDuration() + (enterAnimator != null ? enterAnimator.getDuration() : 0));
            return true;
        }
    }

    /* renamed from: a */
    private ViewGroup m5877a(Activity activity) {
        View decorView;
        if (activity.getWindow() == null || (decorView = activity.getWindow().getDecorView()) == null) {
            return null;
        }
        View findViewById = decorView.findViewById(16908290);
        if (findViewById instanceof ViewGroup) {
            return (ViewGroup) findViewById;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m5881a(boolean z, int i) {
        IMLog.m6631d(f8811a, C4234I.m6591t("[dismiss] showNextFloat=", Boolean.valueOf(z)));
        DecorFloatViewGroup decorFloatViewGroup = this.f8813c;
        long j = 0;
        if (decorFloatViewGroup != null) {
            Animator exitAnimation = decorFloatViewGroup.getExitAnimation();
            if (exitAnimation != null) {
                j = exitAnimation.getDuration();
            }
            this.f8813c.dismissFloatView(i);
            this.f8813c = null;
        }
        if (z) {
            Runnable runnable = this.f8815e;
            if (runnable != null) {
                UiThreadHandler.removeCallbacks(runnable);
            }
            UiThreadHandler.postDelayed(this.f8816f, j + 1000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m5885c() {
        Runnable runnable = this.f8815e;
        if (runnable != null) {
            UiThreadHandler.removeCallbacks(runnable);
        }
    }

    public void destroy() {
        m5885c();
        m5881a(false, 0);
        Queue<IIMDecorFloatMsg<?>> queue = this.f8814d;
        if (queue != null) {
            queue.clear();
        }
    }

    /* renamed from: com.didi.beatles.im.access.notify.decorfloat.IMDecorFloatController$DecorFloatViewGroup */
    private static class DecorFloatViewGroup {
        private Animator enterAnimation;
        private Animator exitAnimation;
        private View mFloatView;
        private ViewGroup mParentView;

        public DecorFloatViewGroup(ViewGroup viewGroup, View view, Animator animator, Animator animator2) {
            this.mParentView = viewGroup;
            this.mFloatView = view;
            this.enterAnimation = animator;
            this.exitAnimation = animator2;
        }

        public Animator getEnterAnimation() {
            return this.enterAnimation;
        }

        public Animator getExitAnimation() {
            return this.exitAnimation;
        }

        public void showFloatView() {
            try {
                if (this.mParentView != null && this.mFloatView != null) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
                    marginLayoutParams.topMargin = IMWindowUtil.getStatusBarHeight();
                    this.mParentView.addView(this.mFloatView, marginLayoutParams);
                    if (this.enterAnimation != null) {
                        this.enterAnimation.start();
                    }
                }
            } catch (Exception e) {
                IMLog.m6632e(IMDecorFloatController.f8811a, "[showFloatView]", e);
                IMTraceError.trackError("im_decor_float#showFloatView", e);
            }
        }

        /* access modifiers changed from: private */
        public void executeDismiss(int i) {
            try {
                if (this.mFloatView != null && (this.mFloatView instanceof IIMDecorFloatView)) {
                    ((IIMDecorFloatView) this.mFloatView).onFloatViewRemoved(i);
                }
                if (this.mParentView != null) {
                    this.mParentView.removeView(this.mFloatView);
                }
                this.mParentView = null;
                this.mFloatView = null;
            } catch (Exception e) {
                IMLog.m6632e(IMDecorFloatController.f8811a, "[executeDismiss]", e);
                IMTraceError.trackError("im_decor_float#executeDismiss", e);
            }
        }

        public void dismissFloatView(final int i) {
            if (this.mParentView != null && this.mFloatView != null) {
                Animator animator = this.exitAnimation;
                if (animator != null) {
                    animator.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            DecorFloatViewGroup.this.executeDismiss(i);
                        }
                    });
                    this.exitAnimation.start();
                    return;
                }
                executeDismiss(i);
            }
        }
    }

    /* renamed from: com.didi.beatles.im.access.notify.decorfloat.IMDecorFloatController$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMDecorFloatController INSTANCE = new IMDecorFloatController();

        private Holder() {
        }
    }
}
