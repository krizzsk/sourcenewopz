package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.processor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.util.AppUtils;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.TwinklingRefreshLayout;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.LogUtil;
import com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils.ScrollingUtil;
import java.io.PrintStream;
import java.util.LinkedList;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.processor.AnimProcessor */
public class AnimProcessor implements IAnimOverScroll, IAnimRefresh {

    /* renamed from: b */
    private static final float f51321b = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public TwinklingRefreshLayout.CoContext f51322a;

    /* renamed from: c */
    private DecelerateInterpolator f51323c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f51324d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f51325e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f51326f = false;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f51327g = false;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f51328h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f51329i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f51330j = false;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f51331k = false;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f51332l = false;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f51333m = false;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f51334n = false;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f51335o = false;

    /* renamed from: p */
    private ValueAnimator.AnimatorUpdateListener f51336p = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!AnimProcessor.this.f51324d || !AnimProcessor.this.f51322a.isEnableKeepIView()) {
                AnimProcessor.this.f51322a.getHeader().getLayoutParams().height = intValue;
                AnimProcessor.this.f51322a.getHeader().requestLayout();
                AnimProcessor.this.f51322a.getHeader().setTranslationY(AnimProcessor.this.m36736a());
                AnimProcessor.this.f51322a.onPullDownReleasing((float) intValue);
            } else {
                AnimProcessor.this.m36738a((float) intValue);
            }
            if (!AnimProcessor.this.f51322a.isOpenFloatRefresh()) {
                AnimProcessor.this.f51322a.getTargetView().setTranslationY((float) intValue);
                AnimProcessor.this.m36739a(intValue);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ValueAnimator.AnimatorUpdateListener f51337q = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!AnimProcessor.this.f51325e || !AnimProcessor.this.f51322a.isEnableKeepIView()) {
                AnimProcessor.this.f51322a.getFooter().getLayoutParams().height = intValue;
                AnimProcessor.this.f51322a.getFooter().requestLayout();
                AnimProcessor.this.f51322a.getFooter().setTranslationY(0.0f);
                AnimProcessor.this.f51322a.onPullUpReleasing((float) intValue);
            } else {
                AnimProcessor.this.m36745b((float) intValue);
            }
            AnimProcessor.this.f51322a.getTargetView().setTranslationY((float) (-intValue));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ValueAnimator.AnimatorUpdateListener f51338r = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (AnimProcessor.this.f51322a.isOverScrollTopShow()) {
                if (AnimProcessor.this.f51322a.getHeader().getVisibility() != 0) {
                    AnimProcessor.this.f51322a.getHeader().setVisibility(0);
                }
            } else if (AnimProcessor.this.f51322a.getHeader().getVisibility() != 8) {
                AnimProcessor.this.f51322a.getHeader().setVisibility(8);
            }
            if (!AnimProcessor.this.f51324d || !AnimProcessor.this.f51322a.isEnableKeepIView()) {
                AnimProcessor.this.f51322a.getHeader().setTranslationY(AnimProcessor.this.m36736a());
                AnimProcessor.this.f51322a.getHeader().getLayoutParams().height = intValue;
                AnimProcessor.this.f51322a.getHeader().requestLayout();
                AnimProcessor.this.f51322a.onPullDownReleasing((float) intValue);
            } else {
                AnimProcessor.this.m36738a((float) intValue);
            }
            AnimProcessor.this.f51322a.getTargetView().setTranslationY((float) intValue);
            AnimProcessor.this.m36739a(intValue);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: s */
    public ValueAnimator.AnimatorUpdateListener f51339s = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (AnimProcessor.this.f51322a.isOverScrollBottomShow()) {
                if (AnimProcessor.this.f51322a.getFooter().getVisibility() != 0) {
                    AnimProcessor.this.f51322a.getFooter().setVisibility(0);
                }
            } else if (AnimProcessor.this.f51322a.getFooter().getVisibility() != 8) {
                AnimProcessor.this.f51322a.getFooter().setVisibility(8);
            }
            if (!AnimProcessor.this.f51325e || !AnimProcessor.this.f51322a.isEnableKeepIView()) {
                AnimProcessor.this.f51322a.getFooter().getLayoutParams().height = intValue;
                AnimProcessor.this.f51322a.getFooter().requestLayout();
                AnimProcessor.this.f51322a.getFooter().setTranslationY(0.0f);
                AnimProcessor.this.f51322a.onPullUpReleasing((float) intValue);
            } else {
                AnimProcessor.this.m36745b((float) intValue);
            }
            AnimProcessor.this.f51322a.getTargetView().setTranslationY((float) (-intValue));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: t */
    public LinkedList<Animator> f51340t;

    public AnimProcessor(TwinklingRefreshLayout.CoContext coContext) {
        this.f51322a = coContext;
        this.f51323c = new DecelerateInterpolator(8.0f);
    }

    public void scrollHeadByMove(float f) {
        float interpolation = (this.f51323c.getInterpolation((f / this.f51322a.getMaxHeadHeight()) / 2.0f) * f) / 2.0f;
        if (this.f51322a.isPureScrollModeOn() || (!this.f51322a.enableRefresh() && !this.f51322a.isOverScrollTopShow())) {
            if (this.f51322a.getHeader().getVisibility() != 8) {
                this.f51322a.getHeader().setVisibility(8);
            }
        } else if (this.f51322a.getHeader().getVisibility() != 0) {
            this.f51322a.getHeader().setVisibility(0);
        }
        if (!this.f51324d || !this.f51322a.isEnableKeepIView()) {
            this.f51322a.getHeader().setTranslationY(m36736a());
            this.f51322a.getHeader().getLayoutParams().height = (int) Math.abs(interpolation);
            this.f51322a.getHeader().bringToFront();
            this.f51322a.getHeader().requestLayout();
            this.f51322a.onPullingDown(interpolation);
        } else {
            this.f51322a.getHeader().setTranslationY(interpolation - ((float) this.f51322a.getHeader().getLayoutParams().height));
        }
        if (!this.f51322a.isOpenFloatRefresh()) {
            this.f51322a.getTargetView().setTranslationY(interpolation);
            m36739a((int) interpolation);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public float m36736a() {
        return UIUtils.dip2px(this.f51322a.getHeader().getContext(), 72.0f) + ((float) AppUtils.getStatusBarHeight(this.f51322a.getHeader().getContext()));
    }

    public void scrollBottomByMove(float f) {
        float interpolation = (this.f51323c.getInterpolation((f / ((float) this.f51322a.getMaxBottomHeight())) / 2.0f) * f) / 2.0f;
        if (this.f51322a.isPureScrollModeOn() || (!this.f51322a.enableLoadmore() && !this.f51322a.isOverScrollBottomShow())) {
            if (this.f51322a.getFooter().getVisibility() != 8) {
                this.f51322a.getFooter().setVisibility(8);
            }
        } else if (this.f51322a.getFooter().getVisibility() != 0) {
            this.f51322a.getFooter().setVisibility(0);
        }
        if (!this.f51325e || !this.f51322a.isEnableKeepIView()) {
            this.f51322a.getFooter().setTranslationY(0.0f);
            this.f51322a.getFooter().getLayoutParams().height = (int) Math.abs(interpolation);
            this.f51322a.getFooter().requestLayout();
            this.f51322a.onPullingUp(-interpolation);
        } else {
            this.f51322a.getFooter().setTranslationY(((float) this.f51322a.getFooter().getLayoutParams().height) - interpolation);
        }
        this.f51322a.getTargetView().setTranslationY(-interpolation);
    }

    public void dealPullDownRelease() {
        if (this.f51322a.isPureScrollModeOn() || !this.f51322a.enableRefresh() || m36744b() < this.f51322a.getHeadHeight() - this.f51322a.getTouchSlop()) {
            animHeadBack(false);
        } else {
            animHeadToRefresh();
        }
    }

    public void dealPullUpRelease() {
        if (this.f51322a.isPureScrollModeOn() || !this.f51322a.enableLoadmore() || m36750c() < this.f51322a.getBottomHeight() - this.f51322a.getTouchSlop()) {
            animBottomBack(false);
        } else {
            animBottomToLoad();
        }
    }

    /* renamed from: b */
    private int m36744b() {
        LogUtil.m36775i("header translationY:" + this.f51322a.getHeader().getTranslationY() + ",Visible head height:" + (((float) this.f51322a.getHeader().getLayoutParams().height) + this.f51322a.getHeader().getTranslationY()));
        return this.f51322a.getHeader().getLayoutParams().height;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public int m36750c() {
        LogUtil.m36775i("footer translationY:" + this.f51322a.getFooter().getTranslationY() + "");
        return (int) (((float) this.f51322a.getFooter().getLayoutParams().height) - this.f51322a.getFooter().getTranslationY());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36738a(float f) {
        this.f51322a.getHeader().setTranslationY((m36736a() + f) - ((float) this.f51322a.getHeader().getLayoutParams().height));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m36745b(float f) {
        this.f51322a.getFooter().setTranslationY(((float) this.f51322a.getFooter().getLayoutParams().height) - f);
    }

    public void animHeadToRefresh() {
        LogUtil.m36775i("animHeadToRefresh:");
        this.f51326f = true;
        animLayoutByTime(m36744b(), this.f51322a.getHeadHeight(), this.f51336p, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f51326f = false;
                if (AnimProcessor.this.f51322a.getHeader().getVisibility() != 0) {
                    AnimProcessor.this.f51322a.getHeader().setVisibility(0);
                }
                AnimProcessor.this.f51322a.setRefreshVisible(true);
                if (!AnimProcessor.this.f51322a.isEnableKeepIView()) {
                    AnimProcessor.this.f51322a.setRefreshing(true);
                    AnimProcessor.this.f51322a.onRefresh();
                } else if (!AnimProcessor.this.f51324d) {
                    AnimProcessor.this.f51322a.setRefreshing(true);
                    AnimProcessor.this.f51322a.onRefresh();
                    boolean unused2 = AnimProcessor.this.f51324d = true;
                }
            }
        });
    }

    public void animHeadBack(final boolean z) {
        LogUtil.m36775i("animHeadBack：finishRefresh?->" + z);
        this.f51327g = true;
        if (z && this.f51324d && this.f51322a.isEnableKeepIView()) {
            this.f51322a.setPrepareFinishRefresh(true);
        }
        animLayoutByTime(m36744b(), 0, this.f51336p, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f51327g = false;
                AnimProcessor.this.f51322a.setRefreshVisible(false);
                if (z && AnimProcessor.this.f51324d && AnimProcessor.this.f51322a.isEnableKeepIView()) {
                    AnimProcessor.this.f51322a.getHeader().getLayoutParams().height = 0;
                    AnimProcessor.this.f51322a.getHeader().requestLayout();
                    AnimProcessor.this.f51322a.getHeader().setTranslationY(AnimProcessor.this.m36736a());
                    boolean unused2 = AnimProcessor.this.f51324d = false;
                    AnimProcessor.this.f51322a.setRefreshing(false);
                    AnimProcessor.this.f51322a.resetHeaderView();
                }
            }
        });
    }

    public void animBottomToLoad() {
        LogUtil.m36775i("animBottomToLoad");
        this.f51328h = true;
        animLayoutByTime(m36750c(), this.f51322a.getBottomHeight(), this.f51337q, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f51328h = false;
                if (AnimProcessor.this.f51322a.getFooter().getVisibility() != 0) {
                    AnimProcessor.this.f51322a.getFooter().setVisibility(0);
                }
                AnimProcessor.this.f51322a.setLoadVisible(true);
                if (!AnimProcessor.this.f51322a.isEnableKeepIView()) {
                    AnimProcessor.this.f51322a.setLoadingMore(true);
                    AnimProcessor.this.f51322a.onLoadMore();
                } else if (!AnimProcessor.this.f51325e) {
                    AnimProcessor.this.f51322a.setLoadingMore(true);
                    AnimProcessor.this.f51322a.onLoadMore();
                    boolean unused2 = AnimProcessor.this.f51325e = true;
                }
            }
        });
    }

    public void animBottomBack(final boolean z) {
        LogUtil.m36775i("animBottomBack：finishLoading?->" + z);
        this.f51329i = true;
        if (z && this.f51325e && this.f51322a.isEnableKeepIView()) {
            this.f51322a.setPrepareFinishLoadMore(true);
        }
        animLayoutByTime(m36750c(), 0, (ValueAnimator.AnimatorUpdateListener) new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int e;
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (!ScrollingUtil.isViewToBottom(AnimProcessor.this.f51322a.getTargetView(), AnimProcessor.this.f51322a.getTouchSlop()) && (e = AnimProcessor.this.m36750c() - intValue) > 0) {
                    if (AnimProcessor.this.f51322a.getTargetView() instanceof RecyclerView) {
                        ScrollingUtil.scrollAViewBy(AnimProcessor.this.f51322a.getTargetView(), e);
                    } else {
                        ScrollingUtil.scrollAViewBy(AnimProcessor.this.f51322a.getTargetView(), e / 2);
                    }
                }
                AnimProcessor.this.f51337q.onAnimationUpdate(valueAnimator);
            }
        }, (Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = AnimProcessor.this.f51329i = false;
                AnimProcessor.this.f51322a.setLoadVisible(false);
                if (z && AnimProcessor.this.f51325e && AnimProcessor.this.f51322a.isEnableKeepIView()) {
                    AnimProcessor.this.f51322a.getFooter().getLayoutParams().height = 0;
                    AnimProcessor.this.f51322a.getFooter().requestLayout();
                    AnimProcessor.this.f51322a.getFooter().setTranslationY(0.0f);
                    boolean unused2 = AnimProcessor.this.f51325e = false;
                    AnimProcessor.this.f51322a.resetBottomView();
                    AnimProcessor.this.f51322a.setLoadingMore(false);
                }
            }
        });
    }

    public void animHeadHideByVy(int i) {
        if (!this.f51330j) {
            this.f51330j = true;
            LogUtil.m36775i("animHeadHideByVy：vy->" + i);
            int abs = Math.abs(i);
            if (abs < 5000) {
                abs = 8000;
            }
            animLayoutByTime(m36744b(), 0, (long) (Math.abs((m36744b() * 1000) / abs) * 5), this.f51336p, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    boolean unused = AnimProcessor.this.f51330j = false;
                    AnimProcessor.this.f51322a.setRefreshVisible(false);
                    if (!AnimProcessor.this.f51322a.isEnableKeepIView()) {
                        AnimProcessor.this.f51322a.setRefreshing(false);
                        AnimProcessor.this.f51322a.onRefreshCanceled();
                        AnimProcessor.this.f51322a.resetHeaderView();
                    }
                }
            });
        }
    }

    public void animBottomHideByVy(int i) {
        LogUtil.m36775i("animBottomHideByVy：vy->" + i);
        if (!this.f51331k) {
            this.f51331k = true;
            int abs = Math.abs(i);
            if (abs < 5000) {
                abs = 8000;
            }
            animLayoutByTime(m36750c(), 0, (long) (((m36750c() * 5) * 1000) / abs), this.f51337q, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    boolean unused = AnimProcessor.this.f51331k = false;
                    AnimProcessor.this.f51322a.setLoadVisible(false);
                    if (!AnimProcessor.this.f51322a.isEnableKeepIView()) {
                        AnimProcessor.this.f51322a.setLoadingMore(false);
                        AnimProcessor.this.f51322a.onLoadmoreCanceled();
                        AnimProcessor.this.f51322a.resetBottomView();
                    }
                }
            });
        }
    }

    public void animOverScrollTop(float f, int i) {
        LogUtil.m36775i("animOverScrollTop：vy->" + f + ",computeTimes->" + i);
        if (!this.f51333m) {
            this.f51333m = true;
            this.f51332l = true;
            this.f51322a.setStatePTD();
            int abs = (int) Math.abs((f / ((float) i)) / 2.0f);
            if (abs > this.f51322a.getOsHeight()) {
                abs = this.f51322a.getOsHeight();
            }
            final int i2 = abs;
            final int i3 = i2 <= 50 ? 115 : (int) ((((double) i2) * 0.3d) + 100.0d);
            animLayoutByTime(m36744b(), i2, (long) i3, this.f51338r, new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (!AnimProcessor.this.f51324d || !AnimProcessor.this.f51322a.isEnableKeepIView() || !AnimProcessor.this.f51322a.showRefreshingWhenOverScroll()) {
                        AnimProcessor animProcessor = AnimProcessor.this;
                        animProcessor.animLayoutByTime(i2, 0, (long) (i3 * 2), animProcessor.f51338r, new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                boolean unused = AnimProcessor.this.f51332l = false;
                                boolean unused2 = AnimProcessor.this.f51333m = false;
                            }
                        });
                        return;
                    }
                    AnimProcessor.this.animHeadToRefresh();
                    boolean unused = AnimProcessor.this.f51332l = false;
                    boolean unused2 = AnimProcessor.this.f51333m = false;
                }
            });
        }
    }

    public void animOverScrollBottom(float f, int i) {
        LogUtil.m36775i("animOverScrollBottom：vy->" + f + ",computeTimes->" + i);
        if (!this.f51335o) {
            this.f51322a.setStatePBU();
            int abs = (int) Math.abs((f / ((float) i)) / 2.0f);
            if (abs > this.f51322a.getOsHeight()) {
                abs = this.f51322a.getOsHeight();
            }
            final int i2 = abs;
            final int i3 = i2 <= 50 ? 115 : (int) ((((double) i2) * 0.3d) + 100.0d);
            if (this.f51325e || !this.f51322a.autoLoadMore()) {
                this.f51335o = true;
                this.f51334n = true;
                animLayoutByTime(0, i2, (long) i3, this.f51339s, new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        if (!AnimProcessor.this.f51325e || !AnimProcessor.this.f51322a.isEnableKeepIView() || !AnimProcessor.this.f51322a.showLoadingWhenOverScroll()) {
                            AnimProcessor animProcessor = AnimProcessor.this;
                            animProcessor.animLayoutByTime(i2, 0, (long) (i3 * 2), animProcessor.f51339s, new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    boolean unused = AnimProcessor.this.f51334n = false;
                                    boolean unused2 = AnimProcessor.this.f51335o = false;
                                }
                            });
                            return;
                        }
                        AnimProcessor.this.animBottomToLoad();
                        boolean unused = AnimProcessor.this.f51334n = false;
                        boolean unused2 = AnimProcessor.this.f51335o = false;
                    }
                });
                return;
            }
            this.f51322a.startLoadMore();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36739a(int i) {
        if (!this.f51322a.isExHeadLocked()) {
            this.f51322a.getExHead().setTranslationY((float) i);
        }
    }

    public void animLayoutByTime(int i, int i2, long j, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.addListener(animatorListener);
        ofInt.setDuration(j);
        ofInt.start();
    }

    public void animLayoutByTime(int i, int i2, long j, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.setDuration(j);
        ofInt.start();
    }

    public void animLayoutByTime(int i, int i2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener, Animator.AnimatorListener animatorListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.addUpdateListener(animatorUpdateListener);
        ofInt.addListener(animatorListener);
        ofInt.setDuration((long) ((int) (((float) Math.abs(i - i2)) * 1.0f)));
        ofInt.start();
    }

    /* renamed from: a */
    private void m36740a(Animator animator) {
        if (animator != null) {
            if (this.f51340t == null) {
                this.f51340t = new LinkedList<>();
            }
            this.f51340t.offer(animator);
            PrintStream printStream = System.out;
            printStream.println("Current Animators：" + this.f51340t.size());
            animator.addListener(new AnimatorListenerAdapter() {
                long startTime = 0;

                public void onAnimationStart(Animator animator) {
                    this.startTime = System.currentTimeMillis();
                }

                public void onAnimationEnd(Animator animator) {
                    AnimProcessor.this.f51340t.poll();
                    if (AnimProcessor.this.f51340t.size() > 0) {
                        ((Animator) AnimProcessor.this.f51340t.getFirst()).start();
                    }
                    PrintStream printStream = System.out;
                    printStream.println("Anim end：start time->" + this.startTime + ",elapsed time->" + (System.currentTimeMillis() - this.startTime));
                }
            });
            if (this.f51340t.size() == 1) {
                animator.start();
            }
        }
    }
}
