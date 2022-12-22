package com.component.android.comp_location.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.component.android.comp_location.AbsGlobalLocationPresenter;
import com.component.android.comp_location.IGlobalLocationView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.sdk.view.LazyInflateView;
import com.taxis99.R;

public class GlobalHomeLocationView extends LazyInflateView implements IGlobalLocationView {

    /* renamed from: f */
    private static final int f3303f = 0;

    /* renamed from: g */
    private static final int f3304g = 1;

    /* renamed from: a */
    private View f3305a;

    /* renamed from: b */
    private View.OnClickListener f3306b = null;

    /* renamed from: c */
    private View.OnClickListener f3307c = null;

    /* renamed from: d */
    private int f3308d = 100;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AbsGlobalLocationPresenter f3309e;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f3310h;

    /* renamed from: i */
    private final View.OnClickListener f3311i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (GlobalHomeLocationView.this.f3310h == 0) {
                GlobalHomeLocationView.this.mStartOrEndView.setImageResource(R.drawable.start_to_pickup_overview);
                int unused = GlobalHomeLocationView.this.f3310h = 1;
            } else {
                GlobalHomeLocationView.this.mStartOrEndView.setImageResource(R.drawable.getoff_to_dest_overview);
                int unused2 = GlobalHomeLocationView.this.f3310h = 0;
            }
            if (GlobalHomeLocationView.this.f3309e != null) {
                GlobalHomeLocationView.this.f3309e.switchViewForGetOnAndOff(GlobalHomeLocationView.this.f3310h);
            }
        }
    };
    protected ImageView mOverviewBtn;
    protected View mOverviewParentBtn;
    protected View mResetBtnParentView;
    protected ImageView mResetBtnView;
    protected View mStartOrEndParentView;
    protected ImageView mStartOrEndView;

    public void doAnim(int i, int i2) {
    }

    public void setAlpha(float f) {
    }

    public void setStartOrEndOverviewVisible(int i) {
    }

    public GlobalHomeLocationView(Context context) {
        super(context, (ViewGroup) null, R.layout.global_home_reset_location_layout);
        this.isInflated = false;
    }

    /* access modifiers changed from: protected */
    public void onInflate(View view) {
        View.OnClickListener onClickListener;
        View.OnClickListener onClickListener2;
        this.f3305a = view;
        this.mResetBtnParentView = view.findViewById(R.id.home_reset_location_parent_btn);
        this.mResetBtnView = (ImageView) this.f3305a.findViewById(R.id.home_reset_location_btn);
        if (GlobalApolloUtil.isRiderSafetyToolkitIcon()) {
            this.mResetBtnView.setImageDrawable(this.f3305a.getContext().getResources().getDrawable(R.drawable.reset_location_icon_new));
        } else {
            this.mResetBtnView.setImageDrawable(this.f3305a.getContext().getResources().getDrawable(R.drawable.reset_location_icon));
        }
        ImageView imageView = this.mResetBtnView;
        if (!(imageView == null || (onClickListener2 = this.f3306b) == null)) {
            imageView.setOnClickListener(onClickListener2);
        }
        this.mOverviewParentBtn = this.f3305a.findViewById(R.id.global_carpool_overview_parent_btn);
        View findViewById = this.f3305a.findViewById(R.id.global_minibus_overview_parent_btn);
        this.mStartOrEndParentView = findViewById;
        findViewById.setOnClickListener(this.f3311i);
        this.mStartOrEndView = (ImageView) this.f3305a.findViewById(R.id.global_minibus_overview_btn);
        ImageView imageView2 = (ImageView) this.f3305a.findViewById(R.id.global_carpool_overview_btn);
        this.mOverviewBtn = imageView2;
        if (!(imageView2 == null || (onClickListener = this.f3307c) == null)) {
            imageView2.setOnClickListener(onClickListener);
        }
        int i = this.f3308d;
        if (i <= 0) {
            this.f3305a.setTranslationY((float) i);
        }
    }

    public View getView() {
        return getRealView();
    }

    public void setPresenter(AbsGlobalLocationPresenter absGlobalLocationPresenter) {
        this.f3309e = absGlobalLocationPresenter;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mResetBtnView;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        } else {
            this.f3306b = onClickListener;
        }
    }

    public void setVisibility(int i) {
        super.inflate();
        if (i != this.mResetBtnParentView.getVisibility()) {
            ViewPropertyAnimator animate = this.mResetBtnParentView.animate();
            this.mResetBtnParentView.setVisibility(0);
            if (i == 0) {
                this.mResetBtnParentView.setAlpha(0.0f);
                animate.alpha(1.0f);
                animate.setListener(new AnimatorListenerAdapter() {
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    public void onAnimationEnd(Animator animator) {
                        GlobalHomeLocationView.this.mResetBtnParentView.setAlpha(1.0f);
                        GlobalHomeLocationView.this.mResetBtnParentView.invalidate();
                    }
                });
            } else {
                this.mResetBtnParentView.setAlpha(1.0f);
                animate.alpha(0.0f);
                animate.setListener(new AnimatorListenerAdapter() {
                    public void onAnimationCancel(Animator animator) {
                        onAnimationEnd(animator);
                    }

                    public void onAnimationEnd(Animator animator) {
                        GlobalHomeLocationView.this.mResetBtnParentView.setVisibility(4);
                        GlobalHomeLocationView.this.mResetBtnParentView.invalidate();
                    }
                });
            }
            animate.setDuration(200);
            animate.start();
        }
    }

    public void setTranslationY(int i) {
        if (this.isInflated) {
            getView().setTranslationY((float) i);
        } else {
            this.f3308d = i;
        }
    }

    public void setOnOverviewClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.mOverviewBtn;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        } else {
            this.f3307c = onClickListener;
        }
    }

    public void setOverviewVisibility(int i) {
        super.show();
        View view = this.mOverviewParentBtn;
        if (view != null) {
            view.setVisibility(i);
            if (i == 0) {
                this.mResetBtnParentView.setPadding(0, 0, 0, 0);
            } else {
                this.mResetBtnParentView.setPadding(0, 0, 0, UiUtils.dip2px(this.mOverviewParentBtn.getContext(), 8.0f));
            }
        }
    }

    public void setOverviewIcon(int i) {
        ImageView imageView = this.mOverviewBtn;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public int getViewType() {
        return this.f3310h;
    }
}
