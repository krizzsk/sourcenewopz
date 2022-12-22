package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.ImageUtils;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.taxis99.R;

public class EvaluateTagImageLayout extends AbsBaseTagLayout {

    /* renamed from: a */
    private ViewGroup f13405a;

    /* renamed from: b */
    private TextView f13406b;

    /* renamed from: c */
    private ImageView f13407c;

    /* renamed from: d */
    private View f13408d;

    /* renamed from: e */
    private FrameLayout f13409e;

    /* renamed from: f */
    private LinearLayout f13410f;

    /* renamed from: g */
    private View f13411g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LottieAnimationView f13412h;

    public EvaluateTagImageLayout(Context context) {
        super(context);
        m9191a();
    }

    public EvaluateTagImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9191a();
    }

    public EvaluateTagImageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9191a();
    }

    /* renamed from: a */
    private void m9191a() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tag_image_layout, this, true);
        this.f13405a = viewGroup;
        this.f13406b = (TextView) viewGroup.findViewById(R.id.tag_text_view);
        this.f13407c = (ImageView) this.f13405a.findViewById(R.id.tag_image_view);
        this.f13408d = this.f13405a.findViewById(R.id.mask_view);
        this.f13409e = (FrameLayout) this.f13405a.findViewById(R.id.tag_image_layout);
        this.f13410f = (LinearLayout) this.f13405a.findViewById(R.id.new_evaluate_tag_image_layout);
        this.f13411g = this.f13405a.findViewById(R.id.tag_text_loading);
        this.f13412h = (LottieAnimationView) this.f13405a.findViewById(R.id.lottie_animation);
        this.f13409e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EvaluateTagImageLayout.this.mEnable) {
                    EvaluateTagImageLayout evaluateTagImageLayout = EvaluateTagImageLayout.this;
                    evaluateTagImageLayout.mIsSelected = !evaluateTagImageLayout.mIsSelected;
                    EvaluateTagImageLayout evaluateTagImageLayout2 = EvaluateTagImageLayout.this;
                    evaluateTagImageLayout2.setSelected(evaluateTagImageLayout2.mIsSelected);
                }
            }
        });
    }

    private void setText(String str) {
        this.f13406b.setVisibility(0);
        this.f13406b.setText(str);
    }

    private void setImageUrl(String str) {
        ImageUtils.glideLoad(getContext(), str, this.f13407c);
    }

    public void setSelected(boolean z) {
        if (z) {
            m9192a(this.f13407c, this.f13408d);
        } else {
            this.f13408d.setVisibility(0);
        }
    }

    public View getView() {
        return this.f13405a;
    }

    public void setMarginRight(int i) {
        ((FrameLayout.LayoutParams) this.f13410f.getLayoutParams()).rightMargin = i;
    }

    public void setTagModel(CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl) {
        super.setTagModel(evaluateTagImpl);
        if (evaluateTagImpl != null) {
            setText(evaluateTagImpl.getText());
            setImageUrl(evaluateTagImpl.getIcon());
        }
    }

    public void setTagModel(EvaluateTag evaluateTag) {
        super.setTagModel(evaluateTag);
        if (evaluateTag != null) {
            setText(evaluateTag.getText());
            setImageUrl(evaluateTag.getIcon());
        }
    }

    public void setLoading(boolean z) {
        super.setLoading(z);
        if (z) {
            this.f13411g.setVisibility(0);
            this.f13406b.setVisibility(8);
            this.f13408d.setVisibility(8);
            return;
        }
        this.f13411g.setVisibility(8);
        this.f13406b.setVisibility(0);
        this.f13408d.setVisibility(0);
    }

    /* renamed from: a */
    private void m9192a(final View view, final View view2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(100);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view2.setVisibility(8);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(200);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        EvaluateTagImageLayout.this.f13412h.setVisibility(8);
                        EvaluateTagImageLayout.this.f13412h.cancelAnimation();
                    }
                });
                view.startAnimation(scaleAnimation);
            }
        });
        view.startAnimation(scaleAnimation);
        this.f13412h.setVisibility(0);
        this.f13412h.playAnimation();
    }
}
