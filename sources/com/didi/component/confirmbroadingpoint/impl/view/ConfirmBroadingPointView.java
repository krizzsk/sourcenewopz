package com.didi.component.confirmbroadingpoint.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.confirmbroadingpoint.AbsConfirmBroadingPointPresenter;
import com.didi.component.confirmbroadingpoint.IConfirmBroadingPointView;
import com.didi.sdk.async.AsyncLayoutFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.omega.sdk.Omega;
import com.taxis99.R;

public class ConfirmBroadingPointView implements View.OnClickListener, IConfirmBroadingPointView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsConfirmBroadingPointPresenter f12657a;

    /* renamed from: b */
    private View f12658b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f12659c;

    /* renamed from: d */
    private TextView f12660d;

    /* renamed from: e */
    private View f12661e;

    /* renamed from: f */
    private TextView f12662f;

    /* renamed from: g */
    private ViewGroup f12663g;

    /* renamed from: h */
    private int f12664h;

    /* renamed from: i */
    private int f12665i;

    /* renamed from: j */
    private int f12666j;
    protected TextView mConfirmView;
    protected Activity mContext;
    protected TextView mEditView;

    public int getLayoutId() {
        return R.layout.global_comfirm_broading_point_layout;
    }

    public void setNormalCardView(View view) {
    }

    public void setNormalVisible(int i) {
    }

    public void setSubTitle(CharSequence charSequence) {
    }

    /* access modifiers changed from: protected */
    public boolean showEditEntrance() {
        return false;
    }

    public void showError() {
    }

    public void stopLoading() {
    }

    public ConfirmBroadingPointView(Activity activity, ViewGroup viewGroup) {
        this.mContext = activity;
        LayoutInflater from = LayoutInflater.from(activity);
        View viewByResId = AsyncLayoutFactory.getInstance().getViewByResId(getLayoutId());
        viewByResId = viewByResId == null ? from.inflate(getLayoutId(), viewGroup, false) : viewByResId;
        this.f12658b = viewByResId;
        this.f12659c = (TextView) viewByResId.findViewById(R.id.tv_global_confirm_broading_point_title);
        this.f12660d = (TextView) this.f12658b.findViewById(R.id.tv_global_confirm_broading_point_subtitle);
        View findViewById = this.f12658b.findViewById(R.id.rl_global_confirm_broading_point_content_layout);
        this.f12661e = findViewById;
        findViewById.setOnClickListener(this);
        this.f12662f = (TextView) this.f12658b.findViewById(R.id.tv_global_confirm_broading_point_content);
        this.mEditView = (TextView) this.f12658b.findViewById(R.id.tv_global_confirm_broading_point_edit);
        if (GlobalApolloUtil.isConfirmBroadingViewHasEdit() || showEditEntrance()) {
            this.mEditView.setVisibility(0);
            this.mEditView.setOnClickListener(this);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f12662f.getLayoutParams();
            layoutParams.rightMargin = ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen.global_confirm_broading_point_margin_right);
            this.f12662f.setLayoutParams(layoutParams);
        }
        this.f12665i = ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen.global_confirm_broading_point_content_height);
        int dimensionPixelSize = ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen.global_confirm_broading_point_loading_height);
        this.f12664h = dimensionPixelSize;
        this.f12666j = dimensionPixelSize;
        this.f12659c.postDelayed(new Runnable() {
            public void run() {
                ConfirmBroadingPointView.this.f12659c.sendAccessibilityEvent(8);
            }
        }, 700);
        TextView textView = (TextView) this.f12658b.findViewById(R.id.tv_global_confirm_broading_point_confirm);
        TextView textView2 = (TextView) this.f12658b.findViewById(R.id.tv_global_confirm_broading_point_confirm_new);
        textView.setBackground(DidiThemeManager.getIns().getResPicker(activity).getDrawable(R.attr.submit_btn_bg_selector));
        textView2.setBackground(DidiThemeManager.getIns().getResPicker(activity).getDrawable(R.attr.submit_btn_bg_new_selector));
        try {
            ColorStateList colorStateList = ContextCompat.getColorStateList(activity, DidiThemeManager.getIns().getResPicker(activity).getResIdByTheme(R.attr.submit_btn_text_color_selector));
            textView.setTextColor(colorStateList);
            textView2.setTextColor(colorStateList);
        } catch (Resources.NotFoundException e) {
            Omega.trackError("comp-confirmbroadingpoint", e);
        }
        this.mConfirmView = textView;
        textView2.setVisibility(8);
        this.mConfirmView.setVisibility(0);
        this.mConfirmView.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void updateConfirmText() {
        if (FormStore.getInstance().isMatchToGo()) {
            this.mConfirmView.setText(ResourcesHelper.getString(this.mContext, R.string.global_confirm_broading_button));
        }
    }

    public void setPresenter(AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter) {
        this.f12657a = absConfirmBroadingPointPresenter;
    }

    public View getView() {
        return this.f12658b;
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f12659c.setText(charSequence);
        } else {
            this.f12659c.setText("");
        }
    }

    public void showSubTitle() {
        this.f12660d.setVisibility(0);
    }

    public void hideSubTitle() {
        this.f12660d.setVisibility(8);
    }

    public void setSubTitleColor(int i) {
        this.f12660d.setTextColor(i);
    }

    public void setContent(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f12661e.getVisibility() != 0) {
                this.f12661e.setVisibility(0);
                m8619a(this.f12661e, 0.0f, 1.0f);
            }
            stopLoading();
            this.f12661e.setEnabled(true);
            this.f12662f.setText(charSequence);
            updateConfirmText();
        }
    }

    public void setContentColor(int i) {
        this.f12662f.setTextColor(i);
    }

    public void enableContent(boolean z) {
        this.f12662f.setEnabled(z);
        if (z) {
            this.f12662f.setTextColor(ResourcesHelper.getColor(this.mContext, R.color.gray));
        } else {
            this.f12662f.setTextColor(ResourcesHelper.getColor(this.mContext, R.color.light_gray));
        }
    }

    public TextView getMainTitleView() {
        return this.f12659c;
    }

    public TextView getSubTitleView() {
        return this.f12660d;
    }

    public void showLoading() {
        if (this.f12661e.getVisibility() != 8) {
            enableConfirm(false);
            this.f12661e.setEnabled(false);
        }
    }

    public void setVisible(boolean z) {
        this.f12658b.setVisibility(z ? 0 : 8);
    }

    public void enableConfirm(boolean z) {
        this.mConfirmView.setEnabled(z);
    }

    public void setConfirmAction(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mConfirmView.setText(str);
        }
    }

    public void onClick(View view) {
        AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter;
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.tv_global_confirm_broading_point_confirm || id == R.id.tv_global_confirm_broading_point_confirm_new) {
            AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter2 = this.f12657a;
            if (absConfirmBroadingPointPresenter2 != null) {
                absConfirmBroadingPointPresenter2.onConfirmClicked();
                this.f12657a.trackEvent();
            }
        } else if (id == R.id.rl_global_confirm_broading_point_content_layout) {
            AbsConfirmBroadingPointPresenter absConfirmBroadingPointPresenter3 = this.f12657a;
            if (absConfirmBroadingPointPresenter3 != null) {
                absConfirmBroadingPointPresenter3.onAddressClicked();
            }
        } else if (id == R.id.tv_global_confirm_broading_point_edit && (absConfirmBroadingPointPresenter = this.f12657a) != null) {
            absConfirmBroadingPointPresenter.onEditClicked();
            this.f12657a.onAddressClicked();
        }
    }

    /* renamed from: a */
    private void m8619a(final View view, float f, float f2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f, f2});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.start();
    }

    /* renamed from: a */
    private void m8621a(final View view, final int i, final int i2) {
        if (i != i2) {
            ValueAnimator valueAnimator = null;
            Object tag = view.getTag(view.getId());
            if (tag != null && (tag instanceof ValueAnimator)) {
                valueAnimator = (ValueAnimator) tag;
            }
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.setDuration(300);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    int i = i2;
                    int i2 = i;
                    ConfirmBroadingPointView.this.m8620a(view, i2 + ((int) (((float) (i - i2)) * floatValue)));
                }
            });
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    if (ConfirmBroadingPointView.this.f12657a != null) {
                        ConfirmBroadingPointView.this.f12657a.onSizeChanged(ConfirmBroadingPointView.this.getView().getHeight());
                    }
                }
            });
            ofFloat.start();
            view.setTag(view.getId(), ofFloat);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8620a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i != layoutParams.height) {
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }
}
