package com.didi.soda.search.page;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.conductor.changehandler.SharedElementTransitionChangeHandler;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.animation.transitions.FadeSafeOreo;
import com.didi.soda.customer.animation.transitions.HomeSearchChangeBounds;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.home.topgun.widget.HomeHeaderTransitionContainer;
import com.didi.soda.search.component.header.SearchBackTransitionView;
import com.didi.soda.search.component.header.SearchDividerTransitionView;
import com.taxis99.R;

public class SearchHomeChangeHandler extends SharedElementTransitionChangeHandler {

    /* renamed from: a */
    private static final long f43774a = 1;

    /* renamed from: b */
    private static final String f43775b = "BusinessHomeChangeHandler.names";

    /* renamed from: c */
    private String f43776c;

    public SearchHomeChangeHandler() {
    }

    public SearchHomeChangeHandler(String str) {
        this.f43776c = str;
    }

    public void configureSharedElements(ViewGroup viewGroup, View view, View view2, boolean z) {
        addSharedElement(this.f43776c);
        waitOnSharedElementNamed(this.f43776c);
    }

    public Transition getExitTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        FadeSafeOreo fadeSafeOreo = new FadeSafeOreo();
        fadeSafeOreo.setDuration(250);
        fadeSafeOreo.setInterpolator(CustomerInterpolator.newInstance());
        fadeSafeOreo.setStartDelay(50);
        fadeSafeOreo.addTarget(view);
        fadeSafeOreo.excludeTarget(HomeHeaderTransitionContainer.class, true);
        fadeSafeOreo.excludeTarget(SearchBackTransitionView.class, true);
        fadeSafeOreo.excludeTarget(SearchDividerTransitionView.class, true);
        return fadeSafeOreo;
    }

    public Transition getSharedElementTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        TransitionSet transitionSet = new TransitionSet();
        HomeSearchChangeBounds homeSearchChangeBounds = new HomeSearchChangeBounds();
        homeSearchChangeBounds.addTarget(this.f43776c);
        homeSearchChangeBounds.setDuration(300);
        homeSearchChangeBounds.setInterpolator(CustomerInterpolator.newInstance());
        transitionSet.addTransition(homeSearchChangeBounds);
        m31105a(view, view2, z, transitionSet);
        return transitionSet;
    }

    public Transition getEnterTransition(ViewGroup viewGroup, View view, View view2, boolean z) {
        View findViewById;
        if (z) {
            FadeSafeOreo fadeSafeOreo = new FadeSafeOreo();
            fadeSafeOreo.setDuration(250);
            fadeSafeOreo.setInterpolator(CustomerInterpolator.newInstance());
            fadeSafeOreo.setStartDelay(50);
            fadeSafeOreo.addTarget(view2);
            fadeSafeOreo.excludeTarget(SearchBackTransitionView.class, true);
            fadeSafeOreo.excludeTarget(SearchDividerTransitionView.class, true);
            return fadeSafeOreo;
        } else if (view2 == null || (findViewById = view2.findViewById(R.id.customer_fl_feed_container)) == null) {
            return null;
        } else {
            final RecyclerView recyclerView = (RecyclerView) findViewById.findViewById(R.id.customer_rv_home_main);
            FadeSafeOreo fadeSafeOreo2 = new FadeSafeOreo();
            fadeSafeOreo2.setDuration(300);
            fadeSafeOreo2.setInterpolator(CustomerInterpolator.newInstance());
            fadeSafeOreo2.addTarget(findViewById);
            fadeSafeOreo2.excludeTarget(HomeHeaderTransitionContainer.class, true);
            fadeSafeOreo2.addListener(new Transition.TransitionListener() {
                public void onTransitionCancel(Transition transition) {
                }

                public void onTransitionPause(Transition transition) {
                }

                public void onTransitionResume(Transition transition) {
                }

                public void onTransitionStart(Transition transition) {
                }

                public void onTransitionEnd(Transition transition) {
                    UiHandlerUtil.post(new Runnable() {
                        public void run() {
                            if (recyclerView != null) {
                                recyclerView.scrollBy(0, 1);
                            }
                        }
                    });
                }
            });
            return fadeSafeOreo2;
        }
    }

    public void restoreFromBundle(Bundle bundle) {
        this.f43776c = bundle.getString(f43775b);
    }

    public void saveToBundle(Bundle bundle) {
        bundle.putString(f43775b, this.f43776c);
    }

    /* renamed from: a */
    private void m31105a(View view, View view2, boolean z, Transition transition) {
        final Animator animator;
        final Animator animator2;
        final Animator animator3 = null;
        if (!z || view == null) {
            animator = (z || view2 == null) ? null : m31104a(view2, false);
        } else {
            animator = m31104a(view, true);
        }
        if (!z || view2 == null) {
            animator2 = (z || view == null) ? null : m31106b(view, false);
        } else {
            animator2 = m31106b(view2, true);
        }
        if (z && view2 != null) {
            animator3 = m31107c(view2, true);
        } else if (!z && view != null) {
            animator3 = m31107c(view, false);
        }
        if (animator != null) {
            transition.addListener(new Transition.TransitionListener() {
                public void onTransitionCancel(Transition transition) {
                }

                public void onTransitionPause(Transition transition) {
                }

                public void onTransitionResume(Transition transition) {
                }

                public void onTransitionStart(Transition transition) {
                    animator.start();
                }

                public void onTransitionEnd(Transition transition) {
                    animator.end();
                }
            });
        }
        if (animator2 != null) {
            transition.addListener(new Transition.TransitionListener() {
                public void onTransitionCancel(Transition transition) {
                }

                public void onTransitionPause(Transition transition) {
                }

                public void onTransitionResume(Transition transition) {
                }

                public void onTransitionStart(Transition transition) {
                    animator2.start();
                }

                public void onTransitionEnd(Transition transition) {
                    animator2.end();
                }
            });
        }
        if (animator3 != null) {
            transition.addListener(new Transition.TransitionListener() {
                public void onTransitionCancel(Transition transition) {
                }

                public void onTransitionPause(Transition transition) {
                }

                public void onTransitionResume(Transition transition) {
                }

                public void onTransitionStart(Transition transition) {
                    animator3.start();
                }

                public void onTransitionEnd(Transition transition) {
                    animator3.end();
                }
            });
        }
    }

    /* renamed from: a */
    private Animator m31104a(View view, boolean z) {
        View findViewById = view.findViewById(R.id.customer_rl_home_feed_address);
        if (!(findViewById instanceof HomeHeaderTransitionContainer) || ((Boolean) findViewById.getTag(R.id.customer_home_header_tag_floating_state)).booleanValue()) {
            return null;
        }
        int height = findViewById.getHeight() / 3;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.TRANSLATION_Y, new float[]{(float) (z ? 0 : -height), (float) (z ? -height : 0)});
        ofFloat.setDuration(300);
        ofFloat.setInterpolator(CustomerInterpolator.newInstance());
        float floatValue = ((Float) findViewById.getTag(R.id.customer_home_header_tag_alpha)).floatValue();
        float f = z ? floatValue : 0.0f;
        if (z) {
            floatValue = 0.0f;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{f, floatValue});
        ofFloat2.setDuration(150);
        ofFloat2.setInterpolator(CustomerInterpolator.newInstance());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    /* renamed from: b */
    private Animator m31106b(View view, boolean z) {
        View findViewById = view.findViewById(R.id.customer_iv_search_home_back);
        if (!(findViewById instanceof SearchBackTransitionView)) {
            return null;
        }
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        findViewById.setAlpha(f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{f2, f});
        ofFloat.setDuration(150);
        ofFloat.setStartDelay(150);
        ofFloat.setInterpolator(CustomerInterpolator.newInstance());
        return ofFloat;
    }

    /* renamed from: c */
    private Animator m31107c(View view, boolean z) {
        View findViewById = view.findViewById(R.id.customer_view_shadow);
        if (!(findViewById instanceof SearchDividerTransitionView)) {
            return null;
        }
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        findViewById.setAlpha(f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, View.ALPHA, new float[]{f2, f});
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(CustomerInterpolator.newInstance());
        return ofFloat;
    }
}
