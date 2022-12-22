package com.didi.component.common.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import com.didi.component.common.animator.IGlobalXPanelAnimator;
import com.taxis99.R;

public class GlobalXPanelAnimatorImpl implements IGlobalXPanelAnimator {
    public void show(View view, long j, long j2, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        if (view != null) {
            final View view2 = view;
            final IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener2 = visibilityChangedListener;
            final long j3 = j;
            final long j4 = j2;
            view.post(new Runnable() {
                public void run() {
                    View view = view2;
                    if (view != null) {
                        view.animate().cancel();
                        view2.animate().withLayer().setListener(new AnimatorListenerAdapter() {
                            public void onAnimationStart(Animator animator) {
                                if (view2 != null) {
                                    view2.setVisibility(0);
                                }
                                if (visibilityChangedListener2 != null) {
                                    visibilityChangedListener2.onShownStart();
                                }
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (visibilityChangedListener2 != null) {
                                    visibilityChangedListener2.onShown();
                                }
                            }
                        }).alpha(1.0f).translationY(0.0f).setDuration(j3).setInterpolator(new AnticipateOvershootInterpolator(0.5f)).setStartDelay(j4).start();
                    }
                }
            });
        }
    }

    public void hide(View view, long j, long j2, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        if (view != null) {
            final View view2 = view;
            final IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener2 = visibilityChangedListener;
            final long j3 = j;
            final long j4 = j2;
            view.post(new Runnable() {
                public void run() {
                    View view = view2;
                    if (view != null) {
                        view.animate().cancel();
                        view2.animate().withLayer().setListener(new AnimatorListenerAdapter() {
                            public void onAnimationStart(Animator animator) {
                                if (visibilityChangedListener2 != null) {
                                    visibilityChangedListener2.onHiddenStart();
                                }
                            }

                            public void onAnimationEnd(Animator animator) {
                                if (view2 != null) {
                                    view2.setVisibility(4);
                                }
                                if (visibilityChangedListener2 != null) {
                                    visibilityChangedListener2.onHidden();
                                }
                            }
                        }).translationY((float) view2.getMeasuredHeight()).setDuration(j3).setInterpolator(new AnticipateOvershootInterpolator(0.5f)).setStartDelay(j4).start();
                    }
                }
            });
        }
    }

    public void show(View view, long j, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        show(view, (long) view.getContext().getResources().getInteger(R.integer.comp_page_animation_duration), 0, visibilityChangedListener);
    }

    public void hide(View view, long j, IGlobalXPanelAnimator.VisibilityChangedListener visibilityChangedListener) {
        hide(view, (long) view.getContext().getResources().getInteger(R.integer.comp_page_animation_duration), 0, visibilityChangedListener);
    }

    public void show(View view) {
        show(view, 0, (IGlobalXPanelAnimator.VisibilityChangedListener) null);
    }

    public void hide(View view) {
        hide(view, 0, (IGlobalXPanelAnimator.VisibilityChangedListener) null);
    }

    public void initPrepare(final View view) {
        if (view != null) {
            view.setVisibility(4);
            view.post(new Runnable() {
                public void run() {
                    View view = view;
                    if (view != null) {
                        view.setTranslationY((float) view.getMeasuredHeight());
                    }
                }
            });
        }
    }

    public boolean isShown(View view) {
        return view.getVisibility() == 0;
    }
}
