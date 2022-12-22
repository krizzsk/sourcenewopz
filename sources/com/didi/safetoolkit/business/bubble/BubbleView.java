package com.didi.safetoolkit.business.bubble;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.safetoolkit.business.bubble.BubbleSwitcherView;
import com.didi.safetoolkit.business.bubble.model.SfBubbleData;
import com.didi.safetoolkit.imageloader.SfOnlineImageCacheRegister;
import com.didi.safetoolkit.util.JarvisArgbEvaluator;
import com.didi.safetoolkit.util.SfViewUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.taxis99.R;
import rui.config.RConfigConstants;

public class BubbleView extends FrameLayout implements ViewSwitcher.ViewFactory {

    /* renamed from: a */
    private static final String f34254a = "BubbleView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SimpleDraweeView f34255b;

    /* renamed from: c */
    private ViewSwitcher f34256c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f34257d;

    /* renamed from: e */
    private String f34258e;

    /* renamed from: f */
    private int f34259f;

    /* renamed from: g */
    private boolean f34260g = true;

    /* renamed from: h */
    private int f34261h;

    /* renamed from: i */
    private int f34262i;

    /* renamed from: j */
    private int f34263j;

    /* renamed from: k */
    private int f34264k;

    /* renamed from: l */
    private int f34265l = -1;

    /* renamed from: m */
    private SparseArray<Drawable> f34266m = new SparseArray<>();

    public BubbleView(Context context) {
        super(context);
        this.f34257d = context;
        m24228a(context);
    }

    public BubbleView(Context context, int i) {
        super(context);
        this.f34257d = context;
        this.f34265l = i;
        m24228a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34257d = context;
        m24228a(context);
    }

    public BubbleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34257d = context;
        m24228a(context);
    }

    /* renamed from: a */
    private void m24228a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.sf_jarvis_bubble_layout, this, true);
        this.f34255b = (SimpleDraweeView) findViewById(R.id.sf_safe_toolkit_bubble_icon);
        this.f34256c = (ViewSwitcher) findViewById(R.id.sf_jarvis_switcher);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f34257d, R.anim.in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f34257d, R.anim.out);
        this.f34256c.setInAnimation(loadAnimation);
        this.f34256c.setOutAnimation(loadAnimation2);
        this.f34256c.setFactory(this);
    }

    public void setIconSize(int i) {
        int dip2px = (i - UiUtils.dip2px(getContext(), 30.0f)) / 2;
        ((FrameLayout.LayoutParams) this.f34255b.getLayoutParams()).setMargins(dip2px, dip2px, dip2px, dip2px);
    }

    public void setVisibleExceptImg(boolean z) {
        this.f34256c.setVisibility(z ? 0 : 8);
    }

    public void updateSwitcher(SfBubbleData sfBubbleData, BubbleSwitcherView.ClickListener clickListener) {
        if (this.f34260g) {
            ViewSwitcher viewSwitcher = this.f34256c;
            if (viewSwitcher != null && (viewSwitcher.getCurrentView() instanceof BubbleSwitcherView)) {
                ((BubbleSwitcherView) this.f34256c.getCurrentView()).updateSwitcherView(sfBubbleData, clickListener);
                this.f34260g = false;
                this.f34256c.getCurrentView().getLayoutParams().width = -2;
                this.f34256c.getCurrentView().getLayoutParams().height = -2;
                ((FrameLayout.LayoutParams) this.f34256c.getCurrentView().getLayoutParams()).gravity = 80;
                this.f34256c.getCurrentView().measure(0, 0);
                this.f34263j = this.f34256c.getCurrentView().getMeasuredHeight();
                this.f34261h = this.f34256c.getCurrentView().getMeasuredWidth();
                if (this.f34263j == 0) {
                    this.f34263j = getMeasuredHeight();
                }
                if (this.f34261h == 0) {
                    this.f34261h = getMeasuredWidth();
                }
                getLayoutParams().width = this.f34261h;
                getLayoutParams().height = this.f34263j;
                SystemUtils.log(4, f34254a, "first w = " + this.f34261h + "fist h = " + this.f34263j, (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView", 139);
                return;
            }
            return;
        }
        ViewSwitcher viewSwitcher2 = this.f34256c;
        if (viewSwitcher2 != null && (viewSwitcher2.getNextView() instanceof BubbleSwitcherView)) {
            BubbleSwitcherView bubbleSwitcherView = (BubbleSwitcherView) this.f34256c.getNextView();
            bubbleSwitcherView.updateSwitcherView(sfBubbleData, clickListener);
            ((FrameLayout.LayoutParams) bubbleSwitcherView.getLayoutParams()).gravity = 80;
            this.f34256c.getNextView().getLayoutParams().width = -2;
            this.f34256c.getNextView().getLayoutParams().height = -2;
            this.f34256c.getNextView().measure(0, 0);
            int measuredHeight = this.f34256c.getNextView().getMeasuredHeight();
            int measuredWidth = this.f34256c.getNextView().getMeasuredWidth();
            if (measuredWidth == 0 || measuredHeight == 0) {
                measure(0, 0);
                if (measuredHeight == 0) {
                    measuredHeight = getMeasuredHeight();
                }
                if (measuredWidth == 0) {
                    measuredWidth = getMeasuredWidth();
                }
            }
            int i = this.f34261h;
            if (i != measuredWidth) {
                m24233b(i, measuredWidth);
                SystemUtils.log(4, f34254a, "lw = " + this.f34261h + "w = " + measuredWidth, (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView", 170);
            }
            this.f34261h = measuredWidth;
            int i2 = this.f34263j;
            if (i2 != measuredHeight) {
                m24227a(i2, measuredHeight);
                SystemUtils.log(4, f34254a, "lh = " + this.f34263j + "h = " + measuredHeight, (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView", 176);
            }
            this.f34263j = measuredHeight;
            this.f34256c.showNext();
        }
    }

    /* renamed from: a */
    private void m24227a(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleView.this.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SystemUtils.log(4, BubbleView.f34254a, "animationH = " + valueAnimator.getAnimatedValue(), (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView$1", 194);
                    BubbleView.this.requestLayout();
                }
            });
            ofInt.setDuration(1000).start();
        }
    }

    /* renamed from: b */
    private void m24233b(int i, int i2) {
        if (i != i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BubbleView.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SystemUtils.log(4, BubbleView.f34254a, "animationW = " + valueAnimator.getAnimatedValue(), (Throwable) null, "com.didi.safetoolkit.business.bubble.BubbleView$2", 213);
                    BubbleView.this.requestLayout();
                }
            });
            ofInt.setDuration(1000).start();
        }
    }

    public void setBubbleBg(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 1) {
            str = "#00000000";
        }
        int parseColor = Color.parseColor(str);
        int i = this.f34259f;
        if (i == 0) {
            setBackground(createBgDrawable(parseColor, SfViewUtils.dp2px(this.f34257d, 20.0f)));
            this.f34259f = parseColor;
            return;
        }
        if (i != parseColor) {
            m24234c(i, parseColor);
        }
        this.f34259f = parseColor;
    }

    public void setIconResources(int i) {
        if (this.f34255b != null) {
            try {
                ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(Integer.valueOf(i)).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).fitCenter()).into((ImageView) this.f34255b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public GradientDrawable createBgDrawable(int i, int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadius((float) i2);
        return gradientDrawable;
    }

    public void setBubbleSymbol(String str) {
        if (TextUtils.isEmpty(this.f34258e)) {
            m24231a(str, str);
        } else {
            m24231a(this.f34258e, str);
        }
    }

    /* renamed from: c */
    private void m24234c(final int i, final int i2) {
        ValueAnimator valueAnimator;
        if (Build.VERSION.SDK_INT < 21) {
            valueAnimator = ValueAnimator.ofObject(JarvisArgbEvaluator.getInstance(), new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            valueAnimator = ValueAnimator.ofArgb(new int[]{i, i2});
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            private JarvisArgbEvaluator evaluator = JarvisArgbEvaluator.getInstance();

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) this.evaluator.evaluate(valueAnimator.getAnimatedFraction(), Integer.valueOf(i), Integer.valueOf(i2))).intValue();
                BubbleView bubbleView = BubbleView.this;
                bubbleView.setBackground(bubbleView.createBgDrawable(intValue, SfViewUtils.dp2px(bubbleView.f34257d, 20.0f)));
            }
        });
        valueAnimator.setDuration(1000).start();
    }

    /* renamed from: a */
    private void m24231a(String str, final String str2) {
        LogUtil.m26312d(f34254a, "symbolAnimator:lastLevel = " + str + ", nowLevel = " + str2);
        this.f34258e = str2;
        m24230a(this.f34255b, str, false, new Runnable() {
            public void run() {
                BubbleView bubbleView = BubbleView.this;
                bubbleView.m24230a(bubbleView.f34255b, str2, true, (Runnable) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24230a(final SimpleDraweeView simpleDraweeView, final String str, boolean z, final Runnable runnable) {
        LogUtil.m26312d(f34254a, "loadImage:draweeView = " + simpleDraweeView + ", dangerLevel = " + str + ", isIn = " + z + ", animationEndAction = " + runnable);
        if (simpleDraweeView != null) {
            simpleDraweeView.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(SfOnlineImageCacheRegister.getUrl(str, z)).setAutoPlayAnimations(true)).setControllerListener(new ControllerListener<ImageInfo>() {
                public void onIntermediateImageFailed(String str, Throwable th) {
                }

                public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
                }

                public void onRelease(String str) {
                }

                public void onSubmit(String str, Object obj) {
                }

                public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                    LogUtil.m26312d(BubbleView.f34254a, "onFinalImageSet:animatable = " + animatable);
                    if (animatable instanceof AnimatedDrawable2) {
                        ((AnimatedDrawable2) animatable).setAnimationListener(new AnimationListener() {
                            public void onAnimationStart(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m26312d(BubbleView.f34254a, "onAnimationStart");
                            }

                            public void onAnimationStop(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m26312d(BubbleView.f34254a, "onAnimationStop");
                                if (runnable != null && simpleDraweeView != null) {
                                    simpleDraweeView.post(new Runnable() {
                                        public void run() {
                                            runnable.run();
                                        }
                                    });
                                }
                            }

                            public void onAnimationReset(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m26312d(BubbleView.f34254a, "onAnimationReset");
                            }

                            public void onAnimationRepeat(AnimatedDrawable2 animatedDrawable2) {
                                LogUtil.m26312d(BubbleView.f34254a, "onAnimationRepeat");
                            }

                            public void onAnimationFrame(AnimatedDrawable2 animatedDrawable2, int i) {
                                LogUtil.m26312d(BubbleView.f34254a, "onAnimationFrame");
                            }
                        });
                    }
                }

                public void onFailure(String str, Throwable th) {
                    SimpleDraweeView simpleDraweeView = simpleDraweeView;
                    if (simpleDraweeView != null) {
                        simpleDraweeView.setImageResource(SfOnlineImageCacheRegister.getPlaceHolderRes(str));
                        simpleDraweeView.postDelayed(new Runnable() {
                            public void run() {
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        }, 500);
                    }
                }
            })).build());
        }
    }

    /* renamed from: a */
    private Drawable m24226a(String str) {
        int identifier = getResources().getIdentifier(str, RConfigConstants.TYPE_DRAWABLE, getContext().getPackageName());
        if (identifier == 0) {
            return null;
        }
        Drawable drawable = this.f34266m.get(identifier);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = getResources().getDrawable(identifier);
        this.f34266m.put(identifier, drawable2);
        return drawable2;
    }

    public View makeView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        BubbleSwitcherView bubbleSwitcherView = new BubbleSwitcherView(this.f34257d);
        bubbleSwitcherView.setSize(this.f34265l);
        bubbleSwitcherView.setLayoutParams(layoutParams);
        return bubbleSwitcherView;
    }
}
