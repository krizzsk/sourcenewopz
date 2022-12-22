package com.didi.component.expectation.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.didi.component.common.util.UIUtils;
import com.didi.component.expectation.model.ProgressState;
import com.didi.travel.psnger.utils.UIThreadHandler;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WaitView extends LinearLayout {

    /* renamed from: a */
    List<ProgressState> f13647a;

    /* renamed from: b */
    private final View f13648b;

    /* renamed from: c */
    private final FrameLayout f13649c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ProgressBar f13650d;

    /* renamed from: e */
    private final LottieAnimationView f13651e;

    /* renamed from: f */
    private final LottieAnimationView f13652f;

    /* renamed from: g */
    private final LottieAnimationView f13653g;

    /* renamed from: h */
    private final LottieAnimationView f13654h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final LottieAnimationView f13655i;

    /* renamed from: j */
    private final FrameLayout f13656j;

    /* renamed from: k */
    private final ImageView f13657k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final FrameLayout f13658l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final ImageView f13659m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final TextView f13660n;

    /* renamed from: o */
    private int f13661o;

    /* renamed from: p */
    private float f13662p;

    /* renamed from: q */
    private final int f13663q;

    /* renamed from: r */
    private float f13664r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final Context f13665s;

    /* renamed from: t */
    private ObjectAnimator f13666t;

    /* renamed from: u */
    private ObjectAnimator f13667u;

    /* renamed from: v */
    private final int f13668v;

    /* renamed from: w */
    private float f13669w;

    /* renamed from: x */
    private List<ViewHolder> f13670x;

    /* renamed from: y */
    private int f13671y;

    public WaitView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WaitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13661o = 100;
        View inflate = LayoutInflater.from(context).inflate(R.layout.wait_need_compensation_layout, this, false);
        this.f13648b = inflate;
        this.f13649c = (FrameLayout) inflate.findViewById(R.id.root_fl);
        this.f13650d = (ProgressBar) this.f13648b.findViewById(R.id.progress_bar);
        this.f13652f = (LottieAnimationView) this.f13648b.findViewById(R.id.gift_lottie_view);
        this.f13653g = (LottieAnimationView) this.f13648b.findViewById(R.id.discount_lottie_view);
        this.f13654h = (LottieAnimationView) this.f13648b.findViewById(R.id.start_bg_lottie_view);
        this.f13655i = (LottieAnimationView) this.f13648b.findViewById(R.id.discount_lottie_view_translate);
        this.f13656j = (FrameLayout) this.f13648b.findViewById(R.id.thumb_layout_fl);
        this.f13651e = (LottieAnimationView) this.f13648b.findViewById(R.id.thumb_lottie_view);
        this.f13657k = (ImageView) this.f13648b.findViewById(R.id.thumb_image);
        this.f13658l = (FrameLayout) this.f13648b.findViewById(R.id.gift_box_layout_fl);
        this.f13659m = (ImageView) this.f13648b.findViewById(R.id.discount_coupon_image);
        this.f13660n = (TextView) this.f13648b.findViewById(R.id.discount_number);
        this.f13661o = this.f13650d.getMax();
        this.f13665s = context;
        this.f13668v = UIUtils.dip2pxInt(context, 282.0f);
        this.f13663q = UIUtils.dip2pxInt(this.f13665s, 217.0f);
        addView(this.f13648b);
    }

    public void addNodeView(List<ProgressState> list) {
        if (list != null && list.size() > 0) {
            this.f13647a = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ProgressState progressState = list.get(i);
                ProgressState progressState2 = new ProgressState();
                progressState2.setEndIconType(progressState.getEndIconType());
                progressState2.setEndIconUri(progressState.getEndIconUri());
                progressState2.setEndProgress(progressState.getEndProgress());
                progressState2.setProcessIconType(progressState.getProcessIconType());
                progressState2.setProcessIconUri(progressState.getProcessIconUri());
                progressState2.setShowTime(progressState.getShowTime());
                progressState2.setStartProgress(progressState.getStartProgress());
                progressState2.setTimeInterval(progressState.getTimeInterval());
                this.f13647a.add(progressState2);
            }
            List<ViewHolder> list2 = this.f13670x;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < this.f13670x.size(); i2++) {
                    if (!(this.f13670x.get(i2).nodeRoot == null || this.f13670x.get(i2).nodeRoot.getParent() == null)) {
                        this.f13649c.removeView(this.f13670x.get(i2).nodeRoot);
                    }
                }
            }
            if (this.f13670x == null) {
                this.f13670x = new ArrayList();
            }
            this.f13670x.clear();
            int size = list.size();
            this.f13671y = size;
            this.f13662p = (((float) this.f13661o) * 1.0f) / ((float) size);
            float f = (float) size;
            float f2 = (((float) this.f13668v) * 1.0f) / f;
            this.f13669w = f2;
            this.f13664r = (((float) this.f13663q) * 1.0f) / f;
            int i3 = 0;
            while (i3 < list.size()) {
                View inflate = LayoutInflater.from(this.f13665s).inflate(R.layout.wait_progress_node_layout, this.f13649c, false);
                FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.node_fl);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) inflate.findViewById(R.id.node_lottie);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.node_image);
                frameLayout.setId(View.generateViewId());
                lottieAnimationView.setId(View.generateViewId());
                imageView.setId(View.generateViewId());
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.nodeRoot = inflate;
                viewHolder.nodeFl = frameLayout;
                viewHolder.nodeImage = imageView;
                viewHolder.nodeLottie = lottieAnimationView;
                this.f13670x.add(viewHolder);
                int i4 = i3 + 1;
                int dip2pxInt = (((int) f2) * i4) - UIUtils.dip2pxInt(this.f13665s, 100.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtils.dip2pxInt(this.f13665s, 100.0f), UIUtils.dip2pxInt(this.f13665s, 100.0f), 16);
                layoutParams.setMargins(dip2pxInt, 0, 0, 0);
                frameLayout.setLayoutParams(layoutParams);
                this.f13649c.addView(inflate);
                ProgressState progressState3 = list.get(i3);
                if (progressState3 == null) {
                    frameLayout.setVisibility(8);
                } else if (progressState3.getEndIconType() == 0) {
                    frameLayout.setVisibility(8);
                } else if (progressState3.getEndIconType() == 1 && !TextUtils.isEmpty(progressState3.getEndIconUri()) && !isDestroy((Activity) this.f13665s)) {
                    frameLayout.setVisibility(0);
                    lottieAnimationView.setVisibility(8);
                    imageView.setVisibility(0);
                    Glide.with(this.f13665s).load(progressState3.getEndIconUri()).into(imageView);
                } else if (progressState3.getEndIconType() != 2 || TextUtils.isEmpty(progressState3.getEndIconUri())) {
                    frameLayout.setVisibility(8);
                } else {
                    frameLayout.setVisibility(0);
                    lottieAnimationView.setVisibility(0);
                    imageView.setVisibility(8);
                    playLocalNodeLottie(lottieAnimationView, progressState3.getEndIconUri());
                }
                i3 = i4;
            }
        }
    }

    static class ViewHolder {
        public FrameLayout nodeFl;
        public ImageView nodeImage;
        public LottieAnimationView nodeLottie;
        public View nodeRoot;

        ViewHolder() {
        }
    }

    public void setThumbLayoutVisibility(int i) {
        FrameLayout frameLayout = this.f13656j;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    public void setThumbLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f13651e;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setThumbImageVisibility(int i) {
        ImageView imageView = this.f13657k;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setDiscountLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f13653g;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setProgressBarVisibility(int i) {
        ProgressBar progressBar = this.f13650d;
        if (progressBar != null) {
            progressBar.setVisibility(i);
        }
    }

    public void setEndGiftBoxFlVisibility(int i) {
        FrameLayout frameLayout = this.f13658l;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }

    public void setGiftBoxLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f13652f;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setDiscountCouponVisibility(int i) {
        ImageView imageView = this.f13659m;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setDiscountNumberVisibility(int i) {
        TextView textView = this.f13660n;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    public void setStartBgLottieVisibility(int i) {
        LottieAnimationView lottieAnimationView = this.f13654h;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(i);
        }
    }

    public void setNodesVisibility(int i) {
        List<ViewHolder> list = this.f13670x;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.f13670x.size(); i2++) {
                this.f13670x.get(i2).nodeFl.setVisibility(i);
            }
        }
    }

    public void cancelThumbAnim() {
        ObjectAnimator objectAnimator = this.f13666t;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f13666t.removeAllListeners();
            this.f13666t = null;
        }
    }

    public void cancelShakeAnim() {
        ObjectAnimator objectAnimator = this.f13667u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f13667u.removeAllListeners();
            this.f13667u = null;
        }
    }

    public void cancelThumbLottie() {
        LottieAnimationView lottieAnimationView = this.f13651e;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f13651e.clearAnimation();
        }
    }

    public void cancelGiftBoxLottie() {
        LottieAnimationView lottieAnimationView = this.f13652f;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
            this.f13652f.clearAnimation();
        }
    }

    public void updateThumbMargin(float f, float f2, int i) {
        ProgressState progressState = this.f13647a.get(i);
        float startProgress = (((float) i) * this.f13664r) + (((f - progressState.getStartProgress()) / (progressState.getEndProgress() - progressState.getStartProgress())) * this.f13664r);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(UIUtils.dip2pxInt(this.f13665s, 40.0f), UIUtils.dip2pxInt(this.f13665s, 40.0f), 16);
        layoutParams.setMargins((int) startProgress, 0, 0, 0);
        this.f13656j.setLayoutParams(layoutParams);
    }

    public void setProgress(float f, ProgressState progressState, int i) {
        ProgressState progressState2 = this.f13647a.get(i);
        this.f13650d.setProgress((int) ((((float) i) * this.f13662p) + (((f - progressState2.getStartProgress()) / (progressState2.getEndProgress() - progressState2.getStartProgress())) * this.f13662p)));
    }

    public void setMaxProgress(int i) {
        this.f13661o = i;
        this.f13662p = (((float) i) * 1.0f) / ((float) this.f13671y);
        this.f13650d.setMax(i);
    }

    public void showRemoteThumbImage(String str) {
        if (this.f13657k != null && !TextUtils.isEmpty(str) && !isDestroy((Activity) this.f13665s)) {
            Glide.with(this.f13665s).load(str).into(this.f13657k);
        }
    }

    public void playLocalNodeLottie(LottieAnimationView lottieAnimationView, String str) {
        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.clearAnimation();
        }
        lottieAnimationView.setAnimation(str);
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.playAnimation();
    }

    public void playLocalThumbLottie(String str) {
        if (this.f13651e.isAnimating()) {
            this.f13651e.cancelAnimation();
            this.f13651e.clearAnimation();
        }
        this.f13651e.setAnimation(str);
        this.f13651e.setRepeatMode(1);
        this.f13651e.setRepeatCount(-1);
        this.f13651e.playAnimation();
    }

    public void translateThumb(float f, float f2, int i, int i2) {
        ObjectAnimator objectAnimator = this.f13666t;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f13666t.removeAllListeners();
            this.f13666t = null;
        }
        ProgressState progressState = this.f13647a.get(i2);
        float endProgress = (((float) i2) * this.f13664r) + (((f2 - f) / (progressState.getEndProgress() - progressState.getStartProgress())) * this.f13664r);
        int i3 = ((FrameLayout.LayoutParams) this.f13656j.getLayoutParams()).leftMargin;
        float translationX = this.f13656j.getTranslationX();
        if (i3 > 0) {
            endProgress = (((float) (i2 + 1)) * this.f13664r) - ((float) i3);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f13656j, "translationX", new float[]{translationX, endProgress});
        this.f13666t = ofFloat;
        ofFloat.setDuration((long) ((i * 1000) + 2000));
        this.f13666t.start();
    }

    public void setTranslationX(float f) {
        FrameLayout frameLayout = this.f13656j;
        if (frameLayout != null) {
            frameLayout.setTranslationX(f);
            this.f13656j.requestLayout();
        }
    }

    public void playGiftBoxLottie(String str, Animator.AnimatorListener animatorListener) {
        if (this.f13652f.isAnimating()) {
            this.f13652f.cancelAnimation();
            this.f13652f.removeAllAnimatorListeners();
            this.f13652f.clearAnimation();
        }
        this.f13652f.setAnimation(str);
        this.f13652f.setImageAssetsFolder("images/");
        this.f13652f.setRepeatMode(1);
        this.f13652f.setRepeatCount(0);
        if (animatorListener != null) {
            this.f13652f.addAnimatorListener(animatorListener);
        }
        this.f13652f.playAnimation();
    }

    public void shakeGiftBox(float f, long j, int i, int i2, Animator.AnimatorListener animatorListener) {
        ObjectAnimator objectAnimator = this.f13667u;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f13667u.removeAllListeners();
            this.f13667u = null;
        }
        List<ViewHolder> list = this.f13670x;
        ViewHolder viewHolder = list.get(list.size() - 1);
        viewHolder.nodeImage.setRotation(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewHolder.nodeImage, "rotation", new float[]{0.0f, f, 0.0f, -f, 0.0f});
        this.f13667u = ofFloat;
        ofFloat.setDuration(j);
        this.f13667u.setRepeatMode(1);
        if (i == 0) {
            this.f13667u.setRepeatCount(0);
        } else if (i == -1) {
            this.f13667u.setRepeatCount(-1);
        }
        if (animatorListener != null) {
            this.f13667u.addListener(animatorListener);
        }
        this.f13667u.start();
    }

    public void openBoxAndShowCoupon(final float f) {
        List<ViewHolder> list = this.f13670x;
        list.get(list.size() - 1).nodeFl.setVisibility(8);
        this.f13654h.setVisibility(8);
        setThumbLayoutVisibility(8);
        this.f13652f.setVisibility(0);
        UIThreadHandler.post(new Runnable() {
            public void run() {
                WaitView.this.f13659m.setVisibility(0);
                WaitView.this.f13660n.setVisibility(0);
                WaitView.this.f13660n.setText(String.valueOf((int) f));
            }
        }, 300);
        playGiftBoxLottie("gift_box_open.json", new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator, boolean z) {
            }

            public void onAnimationEnd(Animator animator, boolean z) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setStartOffset(500);
                animationSet.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.46f, 1.0f));
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -UIUtils.dip2px(WaitView.this.f13665s, 88.0f), 0.0f, 0.0f);
                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(500);
                translateAnimation.setRepeatCount(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setRepeatCount(0);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);
                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        WaitView.this.f13658l.setVisibility(8);
                    }
                });
                WaitView.this.f13658l.startAnimation(animationSet);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.46f, 1.0f));
                alphaAnimation2.setDuration(250);
                alphaAnimation2.setStartOffset(500);
                alphaAnimation2.setFillAfter(true);
                alphaAnimation2.setRepeatCount(0);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        WaitView.this.setProgressBarVisibility(8);
                        WaitView.this.setEndGiftBoxFlVisibility(8);
                        WaitView.this.setNodesVisibility(8);
                    }
                });
                WaitView.this.f13650d.startAnimation(alphaAnimation2);
                UIThreadHandler.post(new Runnable() {
                    public void run() {
                        WaitView.this.f13655i.setVisibility(0);
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.setInterpolator(PathInterpolatorCompat.create(0.26f, 0.0f, 0.46f, 1.0f));
                        animationSet.setAnimationListener(new Animation.AnimationListener() {
                            public void onAnimationRepeat(Animation animation) {
                            }

                            public void onAnimationStart(Animation animation) {
                            }

                            public void onAnimationEnd(Animation animation) {
                                WaitView.this.setDiscountLottieVisibility(0);
                                WaitView.this.f13655i.setVisibility(8);
                            }
                        });
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, -UIUtils.dip2px(WaitView.this.f13665s, 94.0f), 0.0f, 0.0f);
                        translateAnimation.setDuration(500);
                        translateAnimation.setRepeatCount(0);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration(500);
                        alphaAnimation.setRepeatCount(0);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                        WaitView.this.f13655i.startAnimation(animationSet);
                    }
                }, 500);
            }
        });
    }

    public static boolean isDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed());
    }
}
