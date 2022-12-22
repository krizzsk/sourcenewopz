package com.didi.addressold.view.tips;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class TipsView extends FrameLayout {

    /* renamed from: a */
    private CharSequence f7993a;

    /* renamed from: b */
    private TextView f7994b;

    /* renamed from: c */
    private TextView f7995c;

    /* renamed from: d */
    private TextView f7996d;

    /* renamed from: e */
    private boolean f7997e;

    /* renamed from: f */
    private boolean f7998f = false;

    /* renamed from: g */
    private boolean f7999g = false;

    /* renamed from: h */
    private Context f8000h;

    /* renamed from: i */
    private int f8001i;

    /* renamed from: j */
    private int f8002j;

    /* renamed from: k */
    private int f8003k;

    /* renamed from: l */
    private int f8004l;

    /* renamed from: m */
    private View f8005m;
    protected ImageView mIvGuide;
    protected View mIvTriangleBC;
    protected View mIvTriangleBL;
    protected View mIvTriangleBR;
    protected View mIvTriangleLC;
    protected View mIvTriangleRC;
    protected View mIvTriangleTC;
    protected View mIvTriangleTL;
    protected View mIvTriangleTR;
    protected FrameLayout mLineContainer;

    /* renamed from: n */
    private View f8006n;

    /* renamed from: o */
    private View f8007o;

    /* renamed from: p */
    private int f8008p;

    /* renamed from: q */
    private int f8009q;

    /* renamed from: r */
    private int f8010r;

    /* renamed from: s */
    private int f8011s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public TipsContainer f8012t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public View.OnClickListener f8013u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public View.OnClickListener f8014v;

    public TipsView(Context context) {
        super(context);
        m5168a(context);
    }

    public TipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5168a(context);
    }

    public TipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5168a(context);
    }

    public TipsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m5168a(context);
    }

    /* renamed from: a */
    private void m5168a(Context context) {
        this.f8000h = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.v_common_tips, this, true);
        this.f8005m = inflate;
        m5169a(inflate);
    }

    public String getTips() {
        CharSequence charSequence = this.f7993a;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void setTips(String str) {
        setTips((CharSequence) str);
    }

    public void setTips(CharSequence charSequence) {
        this.f7993a = charSequence;
        TextPaint paint = this.f7994b.getPaint();
        paint.setTextSize(this.f7994b.getTextSize());
        paint.measureText(charSequence.toString());
        if (charSequence.length() <= 3) {
            paint.measureText(charSequence.toString());
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f7994b.setVisibility(8);
            this.f7995c.setVisibility(8);
            this.f7996d.setVisibility(8);
            if (this.f7997e) {
                this.f7994b.setText(charSequence);
                this.f7994b.setVisibility(0);
                setContainerHeight(40);
            } else if (charSequence.length() > 20) {
                this.f7995c.setText(charSequence);
                this.f7995c.setVisibility(0);
                setContainerHeight(57);
            } else {
                this.f7994b.setText(charSequence);
                this.f7994b.setVisibility(0);
                setContainerHeight(40);
            }
        }
    }

    public void setSingleLine(boolean z) {
        this.f7997e = z;
        CharSequence charSequence = this.f7993a;
        if (charSequence != null && !TextUtil.isEmpty(charSequence.toString())) {
            setTips(this.f7993a);
        }
    }

    public void setShowGuideIcon(boolean z) {
        if (z) {
            this.f7999g = z;
            this.mIvGuide.setVisibility(0);
            findViewById(R.id.iv_guide_frame_close).setVisibility(0);
            this.f8006n.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.rightMargin = 0;
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    public void setMoreLineTips(String str) {
        setMoreLineTips((CharSequence) str);
    }

    public void setMoreLineTips(CharSequence charSequence) {
        this.f7993a = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f7996d.setText(charSequence);
            this.f7996d.setVisibility(0);
            this.f7994b.setVisibility(8);
            this.f7995c.setVisibility(8);
        }
    }

    public void setTipsSize(int i, float f) {
        TextView textView = this.f7996d;
        if (textView != null) {
            textView.setTextSize(i, f);
        }
        TextView textView2 = this.f7994b;
        if (textView2 != null) {
            textView2.setTextSize(i, f);
        }
        TextView textView3 = this.f7995c;
        if (textView3 != null) {
            textView3.setTextSize(i, f);
        }
    }

    public void setIcon(int i) {
        this.mIvGuide.setImageResource(i);
    }

    public void setIcon(String str) {
        if (!TextUtil.isEmpty(str)) {
            Glide.with(this.f8000h).load(str).into(this.mIvGuide);
        }
    }

    /* access modifiers changed from: protected */
    public void updateContent(String str) {
        updateContent((CharSequence) str);
    }

    /* access modifiers changed from: protected */
    public void updateContent(CharSequence charSequence) {
        this.f7993a = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.f7994b.getVisibility() == 0) {
            this.f7994b.setText(charSequence);
        } else if (this.f7995c.getVisibility() == 0) {
            this.f7995c.setText(charSequence);
        } else if (this.f7996d.getVisibility() == 0) {
            this.f7996d.setText(charSequence);
        }
    }

    public void setEndAnimationDisable() {
        this.f8011s = 0;
    }

    public void setGuideWireMode(boolean z) {
        this.f7998f = z;
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.f8013u = onClickListener;
    }

    public void setmRemoveListener(View.OnClickListener onClickListener) {
        this.f8014v = onClickListener;
    }

    public void setMargins(int i, int i2, int i3, int i4) {
        this.f8001i = i;
        this.f8002j = i2;
        this.f8004l = i3;
        this.f8003k = i4;
    }

    public int getLeftMargin() {
        return this.f8001i;
    }

    public void setLeftMargin(int i) {
        this.f8001i = i;
    }

    public int getTopMargin() {
        return this.f8002j;
    }

    public void setTopMargin(int i) {
        this.f8002j = i;
    }

    public int getBottomMargin() {
        return this.f8003k;
    }

    public void setBottomMargin(int i) {
        this.f8003k = i;
    }

    public int getRightMargin() {
        return this.f8004l;
    }

    public void setRightMargin(int i) {
        this.f8004l = i;
    }

    public void attachContainer(TipsContainer tipsContainer) {
        this.f8012t = tipsContainer;
    }

    public void setPos(int i, int i2) {
        this.f8008p = i;
        this.f8009q = i2;
        mo39926a(i, i2);
        m5174b(this.f8008p, this.f8009q);
    }

    public void setPosGone() {
        View view = this.mIvTriangleTL;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mIvTriangleTC;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mIvTriangleTR;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        View view4 = this.mIvTriangleBL;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mIvTriangleBC;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.mIvTriangleBR;
        if (view6 != null) {
            view6.setVisibility(8);
        }
        View view7 = this.mIvTriangleLC;
        if (view7 != null) {
            view7.setVisibility(8);
        }
        View view8 = this.mIvTriangleRC;
        if (view8 != null) {
            view8.setVisibility(8);
        }
    }

    public void showEnterAnim() {
        int i = this.f8010r;
        if (i <= 0) {
            return;
        }
        if (!this.f7999g) {
            startAnimation(AnimationUtils.loadAnimation(this.f8000h, i));
        } else if (i == R.anim.tips_anima_top_align_left_in) {
            m5172b();
        } else if (i == R.anim.tips_anima_top_align_right_in) {
            m5176c();
        } else if (i == R.anim.tips_anima_top_center_in) {
            m5166a();
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.f8000h, i));
        }
    }

    public void setLines(int i) {
        this.f7996d.setLines(i);
    }

    /* renamed from: a */
    private void m5166a() {
        float f = this.f8000h.getResources().getDisplayMetrics().density;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.02f, 0.0f, 1.02f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(200);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.02f, 1.0f, 1.02f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation2.setInterpolator(new LinearInterpolator());
        scaleAnimation2.setDuration(200);
        scaleAnimation2.setStartOffset(100);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        startAnimation(animationSet);
    }

    /* renamed from: b */
    private void m5172b() {
        float f = this.f8000h.getResources().getDisplayMetrics().density;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.02f, 0.0f, 1.02f, 1, 0.05f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(200);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.02f, 1.0f, 1.02f, 1.0f, 1, 0.05f, 1, 1.0f);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation2.setInterpolator(new LinearInterpolator());
        scaleAnimation2.setDuration(200);
        scaleAnimation2.setStartOffset(100);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        startAnimation(animationSet);
    }

    /* renamed from: c */
    private void m5176c() {
        float f = this.f8000h.getResources().getDisplayMetrics().density;
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.02f, 0.0f, 1.02f, 1, 0.95f, 1, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new LinearInterpolator());
        scaleAnimation.setDuration(250);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.02f, 1.0f, 1.02f, 1.0f, 1, 0.95f, 1, 1.0f);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation2.setInterpolator(new LinearInterpolator());
        scaleAnimation2.setDuration(250);
        scaleAnimation2.setStartOffset(100);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        startAnimation(animationSet);
    }

    public void detachFromContainer() {
        int i = this.f8011s;
        if (i > 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f8000h, i);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    TipsView.this.m5179d();
                }
            });
            startAnimation(loadAnimation);
            return;
        }
        m5179d();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m5179d() {
        post(new Runnable() {
            public void run() {
                if (TipsView.this.f8012t != null) {
                    TipsView.this.f8012t.removeView(TipsView.this);
                } else {
                    ViewParent parent = TipsView.this.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(TipsView.this);
                    }
                }
                if (TipsView.this.f8014v != null) {
                    TipsView.this.f8014v.onClick((View) null);
                }
                TipsContainer.subtractShowTime();
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo39926a(int i, int i2) {
        if (i == 0) {
            m5167a(i2);
        } else if (i == 1) {
            m5173b(i2);
        } else if (i == 2) {
            m5177c(i2);
        } else if (i == 3) {
            m5167a(i2);
        } else if (i == 4) {
            m5167a(i2);
        }
    }

    private void setContainerHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.mLineContainer.getLayoutParams();
        layoutParams.height = -2;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMargin(int i, int i2, int i3, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.setMargins(i, i2, i3, i4);
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginLeft(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.leftMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginTop(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.topMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginRight(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.rightMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginBottom(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private void m5169a(View view) {
        this.mLineContainer = (FrameLayout) view.findViewById(R.id.tv_tips_content_container);
        this.f7994b = (TextView) view.findViewById(R.id.tv_tips_content_1_line);
        this.f7995c = (TextView) view.findViewById(R.id.tv_tips_content_2_line);
        this.f7996d = (TextView) view.findViewById(R.id.tv_tips_content_more_line);
        this.mIvGuide = (ImageView) view.findViewById(R.id.iv_guide);
        this.mIvTriangleTC = view.findViewById(R.id.iv_tc);
        this.mIvTriangleTR = view.findViewById(R.id.iv_tr);
        this.mIvTriangleTL = view.findViewById(R.id.iv_tl);
        this.mIvTriangleBC = view.findViewById(R.id.iv_bc);
        this.mIvTriangleBR = view.findViewById(R.id.iv_br);
        this.mIvTriangleBL = view.findViewById(R.id.iv_bl);
        this.mIvTriangleLC = view.findViewById(R.id.iv_lc);
        this.mIvTriangleRC = view.findViewById(R.id.iv_rc);
        View findViewById = view.findViewById(R.id.iv_close);
        this.f8006n = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TipsView.this.f8013u != null) {
                    TipsView.this.f8013u.onClick(view);
                }
                TipsView.this.detachFromContainer();
            }
        });
        this.f8007o = view.findViewById(R.id.iv_guide_close);
        findViewById(R.id.iv_guide_frame_close).setVisibility(8);
        findViewById(R.id.iv_guide_frame_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TipsView.this.f8013u != null) {
                    TipsView.this.f8013u.onClick(view);
                }
                TipsView.this.detachFromContainer();
            }
        });
        setOnClickListener((View.OnClickListener) null);
        if (getTag() == null) {
            setTag(Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* renamed from: a */
    private void m5167a(int i) {
        if (i == 0) {
            this.mIvTriangleBC.setVisibility(0);
        } else if (i == 1) {
            this.mIvTriangleRC.setVisibility(0);
        } else if (i == 2) {
            this.mIvTriangleLC.setVisibility(0);
        } else if (i == 3) {
            this.mIvTriangleLC.setVisibility(0);
        } else if (i == 4) {
            this.mIvTriangleRC.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m5173b(int i) {
        if (i == 0) {
            this.mIvTriangleBC.setVisibility(0);
        } else if (i == 1) {
            this.mIvTriangleBR.setVisibility(0);
        } else if (i == 2) {
            this.mIvTriangleBL.setVisibility(0);
        } else if (i == 3) {
            this.mIvTriangleBL.setVisibility(0);
        } else if (i == 4) {
            this.mIvTriangleBR.setVisibility(0);
        }
    }

    /* renamed from: c */
    private void m5177c(int i) {
        if (i == 0) {
            this.mIvTriangleTC.setVisibility(0);
        } else if (i == 1) {
            this.mIvTriangleTR.setVisibility(0);
        } else if (i == 2) {
            this.mIvTriangleTL.setVisibility(0);
        } else if (i == 3) {
            this.mIvTriangleTL.setVisibility(0);
        } else if (i == 4) {
            this.mIvTriangleTR.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m5174b(int i, int i2) {
        if (i == 1 && i2 == 0) {
            this.f8010r = R.anim.tips_anima_top_center_in;
            this.f8011s = R.anim.tips_anima_top_center_out;
        } else if (i == 2 && i2 == 0) {
            this.f8010r = R.anim.tips_anima_bottom_center_in;
            this.f8011s = R.anim.tips_anima_bottom_center_out;
        } else if (i == 0 && i2 == 1) {
            this.f8010r = R.anim.tips_anima_center_left_in;
            this.f8011s = R.anim.tips_anima_center_left_out;
        } else if (i == 0 && i2 == 2) {
            this.f8010r = R.anim.tips_anima_center_right_in;
            this.f8011s = R.anim.tips_anima_center_right_out;
        } else if ((i == 1 && i2 == 3) || (i == 1 && i2 == 2)) {
            this.f8010r = R.anim.tips_anima_top_align_left_in;
            this.f8011s = R.anim.tips_anima_top_align_left_out;
        } else if ((i == 1 && i2 == 4) || (i == 1 && i2 == 1)) {
            this.f8010r = R.anim.tips_anima_top_align_right_in;
            this.f8011s = R.anim.tips_anima_top_align_right_out;
        } else if ((i == 2 && i2 == 3) || (i == 2 && i2 == 2)) {
            this.f8010r = R.anim.tips_anima_bottom_align_left_in;
            this.f8011s = R.anim.tips_anima_bottom_align_left_out;
        } else if ((i == 2 && i2 == 4) || (i == 2 && i2 == 1)) {
            this.f8010r = R.anim.tips_anima_bottom_align_right_in;
            this.f8011s = R.anim.tips_anima_bottom_align_right_out;
        } else if (i2 == 1 && (i == 3 || i == 4)) {
            this.f8010r = R.anim.tips_anima_center_left_in;
            this.f8011s = R.anim.tips_anima_center_left_out;
        } else if (i2 != 2) {
        } else {
            if (i == 3 || i == 4) {
                this.f8010r = R.anim.tips_anima_center_right_in;
                this.f8011s = R.anim.tips_anima_center_right_out;
            }
        }
    }
}
