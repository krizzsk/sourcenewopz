package com.didi.sdk.view.tips;

import android.content.Context;
import android.os.Build;
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
    private int mAnimEnter;
    private int mAnimExit;
    private int mBottomMargin;
    /* access modifiers changed from: private */
    public View.OnClickListener mCloseListener;
    /* access modifiers changed from: private */
    public TipsContainer mContainer;
    private Context mContext;
    private View mGuideIvClose;
    private boolean mGuideWireMode = false;
    private int mHorizPos;
    private View mIvClose;
    protected ImageView mIvGuide;
    protected View mIvTriangleBC;
    protected View mIvTriangleBL;
    protected View mIvTriangleBR;
    protected View mIvTriangleLC;
    protected View mIvTriangleRC;
    protected View mIvTriangleTC;
    protected View mIvTriangleTL;
    protected View mIvTriangleTR;
    private int mLeftMargin;
    protected FrameLayout mLineContainer;
    /* access modifiers changed from: private */
    public View.OnClickListener mRemoveListener;
    private int mRightMargin;
    private View mRootView;
    private boolean mShowGuide = false;
    private boolean mSingleLineMode;
    private CharSequence mStrTips;
    private int mTopMargin;
    private TextView mTvTips1Line;
    private TextView mTvTips2Line;
    private TextView mTvTipsMoreLine;
    private int mVertPos;

    public TipsView(Context context) {
        super(context);
        init(context);
    }

    public TipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public TipsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.v_common_tips_new, this, true);
        this.mRootView = inflate;
        initView(inflate);
    }

    public String getTips() {
        CharSequence charSequence = this.mStrTips;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void setTips(String str) {
        setTips((CharSequence) str);
    }

    public void setTips(CharSequence charSequence) {
        this.mStrTips = charSequence;
        TextPaint paint = this.mTvTips1Line.getPaint();
        paint.setTextSize(this.mTvTips1Line.getTextSize());
        paint.measureText(charSequence.toString());
        if (charSequence.length() <= 3) {
            paint.measureText(charSequence.toString());
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.mTvTips1Line.setVisibility(8);
            this.mTvTips2Line.setVisibility(8);
            this.mTvTipsMoreLine.setVisibility(8);
            if (this.mSingleLineMode) {
                this.mTvTips1Line.setText(charSequence);
                this.mTvTips1Line.setVisibility(0);
                setContainerHeight(40);
            } else if (charSequence.length() > 20) {
                this.mTvTips2Line.setText(charSequence);
                this.mTvTips2Line.setVisibility(0);
                setContainerHeight(57);
            } else {
                this.mTvTips1Line.setText(charSequence);
                this.mTvTips1Line.setVisibility(0);
                setContainerHeight(40);
            }
        }
    }

    public void setSingleLine(boolean z) {
        this.mSingleLineMode = z;
        CharSequence charSequence = this.mStrTips;
        if (charSequence != null && !TextUtil.isEmpty(charSequence.toString())) {
            setTips(this.mStrTips);
        }
    }

    public void setShowGuideIcon(boolean z) {
        if (z) {
            this.mShowGuide = z;
            this.mIvGuide.setVisibility(0);
            findViewById(R.id.iv_guide_frame_close).setVisibility(0);
            this.mIvClose.setVisibility(8);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_container);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.rightMargin = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    public void setMoreLineTips(String str) {
        setMoreLineTips((CharSequence) str);
    }

    public void setMoreLineTips(CharSequence charSequence) {
        this.mStrTips = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            this.mTvTipsMoreLine.setText(charSequence);
            this.mTvTipsMoreLine.setVisibility(0);
            this.mTvTips1Line.setVisibility(8);
            this.mTvTips2Line.setVisibility(8);
        }
    }

    public void setIcon(int i) {
        this.mIvGuide.setImageResource(i);
    }

    public void setIcon(String str) {
        if (!TextUtil.isEmpty(str)) {
            Glide.with(this.mContext).load(str).into(this.mIvGuide);
        }
    }

    /* access modifiers changed from: protected */
    public void updateContent(String str) {
        updateContent((CharSequence) str);
    }

    /* access modifiers changed from: protected */
    public void updateContent(CharSequence charSequence) {
        this.mStrTips = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.mTvTips1Line.getVisibility() == 0) {
            this.mTvTips1Line.setText(charSequence);
        } else if (this.mTvTips2Line.getVisibility() == 0) {
            this.mTvTips2Line.setText(charSequence);
        } else if (this.mTvTipsMoreLine.getVisibility() == 0) {
            this.mTvTipsMoreLine.setText(charSequence);
        }
    }

    public void setEndAnimationDisable() {
        this.mAnimExit = 0;
    }

    public void setGuideWireMode(boolean z) {
        this.mGuideWireMode = z;
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.mCloseListener = onClickListener;
    }

    public void setmRemoveListener(View.OnClickListener onClickListener) {
        this.mRemoveListener = onClickListener;
    }

    public void setMargins(int i, int i2, int i3, int i4) {
        this.mLeftMargin = i;
        this.mTopMargin = i2;
        this.mRightMargin = i3;
        this.mBottomMargin = i4;
    }

    public int getLeftMargin() {
        return this.mLeftMargin;
    }

    public void setLeftMargin(int i) {
        this.mLeftMargin = i;
    }

    public int getTopMargin() {
        return this.mTopMargin;
    }

    public void setTopMargin(int i) {
        this.mTopMargin = i;
    }

    public int getBottomMargin() {
        return this.mBottomMargin;
    }

    public void setBottomMargin(int i) {
        this.mBottomMargin = i;
    }

    public int getRightMargin() {
        return this.mRightMargin;
    }

    public void setRightMargin(int i) {
        this.mRightMargin = i;
    }

    public void attachContainer(TipsContainer tipsContainer) {
        this.mContainer = tipsContainer;
    }

    public void setPos(int i, int i2) {
        this.mVertPos = i;
        this.mHorizPos = i2;
        initTriangle(i, i2);
        initAnimation(this.mVertPos, this.mHorizPos);
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
        int i = this.mAnimEnter;
        if (i <= 0) {
            return;
        }
        if (!this.mShowGuide) {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, i));
        } else if (i == R.anim.tips_anima_top_align_left_in) {
            showLeftPaddingAnimation();
        } else if (i == R.anim.tips_anima_top_align_right_in) {
            showRightPaddingAnimation();
        } else if (i == R.anim.tips_anima_top_center_in) {
            showCenterPaddingAnimation();
        } else {
            startAnimation(AnimationUtils.loadAnimation(this.mContext, i));
        }
    }

    public void setLines(int i) {
        this.mTvTipsMoreLine.setLines(i);
    }

    private void showCenterPaddingAnimation() {
        float f = this.mContext.getResources().getDisplayMetrics().density;
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

    private void showLeftPaddingAnimation() {
        float f = this.mContext.getResources().getDisplayMetrics().density;
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

    private void showRightPaddingAnimation() {
        float f = this.mContext.getResources().getDisplayMetrics().density;
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
        int i = this.mAnimExit;
        if (i > 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, i);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    TipsView.this.removeFromParent();
                }
            });
            startAnimation(loadAnimation);
            return;
        }
        removeFromParent();
    }

    /* access modifiers changed from: private */
    public void removeFromParent() {
        post(new Runnable() {
            public void run() {
                if (TipsView.this.mContainer != null) {
                    TipsView.this.mContainer.removeView(TipsView.this);
                } else {
                    ViewParent parent = TipsView.this.getParent();
                    if (parent != null && (parent instanceof ViewGroup)) {
                        ((ViewGroup) parent).removeView(TipsView.this);
                    }
                }
                if (TipsView.this.mRemoveListener != null) {
                    TipsView.this.mRemoveListener.onClick((View) null);
                }
                TipsContainer.subtractShowTime();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void initTriangle(int i, int i2) {
        if (i == 0) {
            handleVCenter(i2);
        } else if (i == 1) {
            handleVAbove(i2);
        } else if (i == 2) {
            handleVBelow(i2);
        } else if (i == 3) {
            handleVCenter(i2);
        } else if (i == 4) {
            handleVCenter(i2);
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
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginLeft(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.leftMargin = i;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
        }
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
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    public void setContainerMarginBottom(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mLineContainer.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.mLineContainer.setLayoutParams(layoutParams);
    }

    private void initView(View view) {
        this.mLineContainer = (FrameLayout) view.findViewById(R.id.tv_tips_content_container);
        this.mTvTips1Line = (TextView) view.findViewById(R.id.tv_tips_content_1_line);
        this.mTvTips2Line = (TextView) view.findViewById(R.id.tv_tips_content_2_line);
        this.mTvTipsMoreLine = (TextView) view.findViewById(R.id.tv_tips_content_more_line);
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
        this.mIvClose = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TipsView.this.mCloseListener != null) {
                    TipsView.this.mCloseListener.onClick(view);
                }
                TipsView.this.detachFromContainer();
            }
        });
        this.mGuideIvClose = view.findViewById(R.id.iv_guide_close);
        findViewById(R.id.iv_guide_frame_close).setVisibility(8);
        findViewById(R.id.iv_guide_frame_close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TipsView.this.mCloseListener != null) {
                    TipsView.this.mCloseListener.onClick(view);
                }
                TipsView.this.detachFromContainer();
            }
        });
        setOnClickListener((View.OnClickListener) null);
        if (getTag() == null) {
            setTag(Long.valueOf(System.currentTimeMillis()));
        }
    }

    private void handleVCenter(int i) {
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

    private void handleVAbove(int i) {
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

    private void handleVBelow(int i) {
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

    private void initAnimation(int i, int i2) {
        if (i == 1 && i2 == 0) {
            this.mAnimEnter = R.anim.tips_anima_top_center_in;
            this.mAnimExit = R.anim.tips_anima_top_center_out;
        } else if (i == 2 && i2 == 0) {
            this.mAnimEnter = R.anim.tips_anima_bottom_center_in;
            this.mAnimExit = R.anim.tips_anima_bottom_center_out;
        } else if (i == 0 && i2 == 1) {
            this.mAnimEnter = R.anim.tips_anima_center_left_in;
            this.mAnimExit = R.anim.tips_anima_center_left_out;
        } else if (i == 0 && i2 == 2) {
            this.mAnimEnter = R.anim.tips_anima_center_right_in;
            this.mAnimExit = R.anim.tips_anima_center_right_out;
        } else if ((i == 1 && i2 == 3) || (i == 1 && i2 == 2)) {
            this.mAnimEnter = R.anim.tips_anima_top_align_left_in;
            this.mAnimExit = R.anim.tips_anima_top_align_left_out;
        } else if ((i == 1 && i2 == 4) || (i == 1 && i2 == 1)) {
            this.mAnimEnter = R.anim.tips_anima_top_align_right_in;
            this.mAnimExit = R.anim.tips_anima_top_align_right_out;
        } else if ((i == 2 && i2 == 3) || (i == 2 && i2 == 2)) {
            this.mAnimEnter = R.anim.tips_anima_bottom_align_left_in;
            this.mAnimExit = R.anim.tips_anima_bottom_align_left_out;
        } else if ((i == 2 && i2 == 4) || (i == 2 && i2 == 1)) {
            this.mAnimEnter = R.anim.tips_anima_bottom_align_right_in;
            this.mAnimExit = R.anim.tips_anima_bottom_align_right_out;
        } else if (i2 == 1 && (i == 3 || i == 4)) {
            this.mAnimEnter = R.anim.tips_anima_center_left_in;
            this.mAnimExit = R.anim.tips_anima_center_left_out;
        } else if (i2 != 2) {
        } else {
            if (i == 3 || i == 4) {
                this.mAnimEnter = R.anim.tips_anima_center_right_in;
                this.mAnimExit = R.anim.tips_anima_center_right_out;
            }
        }
    }
}
