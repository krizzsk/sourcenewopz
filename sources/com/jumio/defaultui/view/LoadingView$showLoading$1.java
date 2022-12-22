package com.jumio.defaultui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.jumio.defaultui.view.LoadingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/jumio/defaultui/view/LoadingView$showLoading$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: LoadingView.kt */
public final class LoadingView$showLoading$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ LoadingView this$0;

    public LoadingView$showLoading$1(LoadingView loadingView) {
        this.this$0 = loadingView;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationEnd(animator);
        Object access$getCurrentStateLock$p = this.this$0.currentStateLock;
        LoadingView loadingView = this.this$0;
        synchronized (access$getCurrentStateLock$p) {
            if (!loadingView.isShowing()) {
                if (loadingView.isActive) {
                    loadingView.isActive = false;
                    loadingView.log("isActive false onAnimationEnd");
                    loadingView.log("animationState reset to start");
                    loadingView.animationState = LoadingView.C20075a.START;
                    LoadingView.ViewState viewState = LoadingView.ViewState.STOPPED;
                    loadingView.setCurrentState$jumio_defaultui_release(new LoadingView.State(viewState, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null));
                    synchronized (loadingView.nextStateLock) {
                        loadingView.nextState = new LoadingView.State(viewState, 0, (String) null, 0, (View.OnClickListener) null, 30, (DefaultConstructorMarker) null);
                        Unit unit = Unit.INSTANCE;
                    }
                    MotionLayout access$getLoadingViewLayout$p = loadingView.loadingViewLayout;
                    if (access$getLoadingViewLayout$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingViewLayout");
                        access$getLoadingViewLayout$p = null;
                    }
                    access$getLoadingViewLayout$p.setTransitionListener((MotionLayout.TransitionListener) null);
                    loadingView.log("transition listener was set with state " + loadingView.getCurrentState$jumio_defaultui_release().getViewState().name() + " to null");
                }
                loadingView.loadingViewContainer.setVisibility(4);
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        super.onAnimationStart(animator);
        this.this$0.loadingViewContainer.setVisibility(0);
        this.this$0.log("onAnimationStart: loadingViewContainer shown and transitioning to end");
    }
}
