package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.IPresenter;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.model.JumpableItem;
import com.didi.component.payentrance.utils.SimpleSpanStringBuilder;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.Mode;
import com.didi.component.payentrance.view.PayentranceLoadingView;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.List;

public abstract class BasePayEntranceView implements IPayEntranceView {
    protected static final float PRICE_RATIO = 1.875f;

    /* renamed from: a */
    private static final String f15018a = "PayEntranceView";

    /* renamed from: b */
    private PayentranceLoadingView f15019b;

    /* renamed from: c */
    private Mode f15020c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IPayEntranceView.OnErrorClickListener f15021d;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected IPayEntranceView.OnBindCardClickListener mOnBindCardClickListener;
    protected IPayEntranceView.OnCancelRuleClickListener mOnCancelRuleClickListener;
    protected IPayEntranceView.OnJumpableClickListener mOnJumpableClickListener;
    protected IPayEntranceView.OnPayListener mOnPayListener;
    protected View.OnClickListener mOnViewClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (BasePayEntranceView.this.mOnJumpableClickListener != null) {
                BasePayEntranceView.this.mOnJumpableClickListener.onItemClick((JumpableItem) view.getTag());
            }
        }
    };
    protected View mView;

    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return null;
    }

    public ViewGroup getSupplementContainer() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void onViewCreated(View view);

    public void setActionButtonEnable(boolean z) {
    }

    public void setCancelRuleShow(boolean z) {
    }

    public void setFeeDescribe(CharSequence charSequence) {
    }

    public void setIconShow(boolean z) {
    }

    public void setInputHint(CharSequence charSequence) {
    }

    public void setInputLabel(CharSequence charSequence) {
    }

    public void setJumpableItems(List<Jumpable> list) {
    }

    public void setOnInputValueChangeListener(IPayEntranceView.OnInputValueChangeListener onInputValueChangeListener) {
    }

    public void setPayWay(String str) {
    }

    public void setPresenter(IPresenter iPresenter) {
    }

    public void showBindCard(boolean z) {
    }

    public void showTipsCheckbox(String str, boolean z, IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
    }

    public BasePayEntranceView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mContext = context;
        this.mInflater = layoutInflater;
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        this.mView = inflate;
        onViewCreated(inflate);
    }

    public <T extends View> T findView(int i) {
        return this.mView.findViewById(i);
    }

    public void setMoneyWithUnit(TextView textView, String str) {
        setMoneyWithUnit(textView, str, 3.0f);
    }

    public void setMoneyWithUnit(TextView textView, String str, float f) {
        SimpleSpanStringBuilder simpleSpanStringBuilder = new SimpleSpanStringBuilder(str);
        simpleSpanStringBuilder.spanNumSize(f);
        textView.setText(simpleSpanStringBuilder);
        textView.setVisibility(0);
    }

    public void setCouponSupplement(String str, String str2) {
        if (getSupplementContainer() != null) {
            getSupplementContainer().removeAllViews();
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_supplement_coupon_item, getSupplementContainer());
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_pay_entrance_supplement_icon);
            imageView.setBackgroundResource(R.drawable.global_common_coupon_icon);
            imageView.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.g_pay_entrance_supplement_name);
            textView.setTextColor(ResourcesHelper.getColor(this.mContext, R.color.color_333333));
            textView.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen._14sp));
            textView.getPaint().setFlags(17);
            textView.setTypeface(Typeface.defaultFromStyle(1));
            TextView textView2 = (TextView) inflate.findViewById(R.id.g_pay_entrance_supplement_value);
            textView2.setTextColor(ResourcesHelper.getColor(this.mContext, R.color.color_333333));
            textView2.setTextSize(0, (float) ResourcesHelper.getDimensionPixelSize(this.mContext, R.dimen._14sp));
            textView2.setTypeface(Typeface.defaultFromStyle(1));
            textView.setText(ResourcesHelper.getString(this.mContext, R.string.pe_pay_entrance_total_fee_txt, str));
            textView2.setText(HighlightUtil.highlight(this.mContext, " " + ResourcesHelper.getString(this.mContext, R.string.pe_pay_entrance_discount_fee_txt, str2)));
        }
    }

    public View getView() {
        return this.mView;
    }

    public void setOnPayListener(IPayEntranceView.OnPayListener onPayListener) {
        this.mOnPayListener = onPayListener;
    }

    public void setOnJumpableClickListener(IPayEntranceView.OnJumpableClickListener onJumpableClickListener) {
        this.mOnJumpableClickListener = onJumpableClickListener;
    }

    public void setOnCancelRuleClickListener(IPayEntranceView.OnCancelRuleClickListener onCancelRuleClickListener) {
        this.mOnCancelRuleClickListener = onCancelRuleClickListener;
    }

    /* access modifiers changed from: protected */
    public void addJumpableViews(ViewGroup viewGroup, List<Jumpable> list) {
        if (list != null && list.size() != 0) {
            viewGroup.removeAllViews();
            for (Jumpable createJumpableView : list) {
                viewGroup.addView(createJumpableView(viewGroup, createJumpableView));
            }
            if (viewGroup.getVisibility() == 8) {
                viewGroup.setVisibility(0);
            }
        }
    }

    public void showLoading() {
        View loadingArea = getLoadingArea();
        if (loadingArea != null) {
            ViewParent parent = loadingArea.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                loadingArea.setVisibility(4);
                if (this.f15019b == null) {
                    this.f15019b = new PayentranceLoadingView(this.mContext);
                }
                if (this.f15019b.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 17;
                    frameLayout.addView(this.f15019b, 0, layoutParams);
                }
                this.f15019b.showMask();
                frameLayout.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = (android.widget.FrameLayout) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hideLoading() {
        /*
            r5 = this;
            android.view.View r0 = r5.getLoadingArea()
            if (r0 == 0) goto L_0x002a
            android.view.ViewParent r1 = r0.getParent()
            boolean r2 = r1 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L_0x002a
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            r2 = 0
            android.view.View r3 = r1.getChildAt(r2)
            if (r3 == 0) goto L_0x002a
            boolean r4 = r3 instanceof com.didi.component.payentrance.view.PayentranceLoadingView
            if (r4 == 0) goto L_0x002a
            com.didi.component.payentrance.view.PayentranceLoadingView r3 = (com.didi.component.payentrance.view.PayentranceLoadingView) r3
            r3.hideMask()
            r1.removeView(r3)
            r0.setVisibility(r2)
            r0 = 0
            r1.setOnClickListener(r0)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.view.impl.BasePayEntranceView.hideLoading():void");
    }

    public void showError(CharSequence charSequence) {
        View loadingArea = getLoadingArea();
        if (loadingArea != null) {
            ViewParent parent = loadingArea.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                loadingArea.setVisibility(4);
                if (this.f15019b == null) {
                    this.f15019b = new PayentranceLoadingView(this.mContext);
                }
                if (this.f15019b.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 17;
                    frameLayout.addView(this.f15019b, 0, layoutParams);
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    this.f15019b.showError(charSequence);
                } else {
                    this.f15019b.showError();
                }
                frameLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        GLog.m7965d(BasePayEntranceView.f15018a, "on error view click");
                        if (BasePayEntranceView.this.f15021d != null) {
                            BasePayEntranceView.this.f15021d.onErrorClick();
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (android.widget.FrameLayout) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hideError() {
        /*
            r4 = this;
            android.view.View r0 = r4.getLoadingArea()
            if (r0 == 0) goto L_0x002a
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.widget.FrameLayout
            if (r1 == 0) goto L_0x002a
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r1 = 0
            android.view.View r2 = r0.getChildAt(r1)
            if (r2 == 0) goto L_0x002a
            boolean r3 = r2 instanceof com.didi.component.payentrance.view.PayentranceLoadingView
            if (r3 == 0) goto L_0x002a
            com.didi.component.payentrance.view.PayentranceLoadingView r2 = (com.didi.component.payentrance.view.PayentranceLoadingView) r2
            r2.hideError()
            r3 = 0
            r0.setOnClickListener(r3)
            r0.removeView(r2)
            r0.setVisibility(r1)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.view.impl.BasePayEntranceView.hideError():void");
    }

    public void setOnErrorListener(IPayEntranceView.OnErrorClickListener onErrorClickListener) {
        this.f15021d = onErrorClickListener;
    }

    public View createJumpableView(ViewGroup viewGroup, Jumpable jumpable) {
        TextView textView = (TextView) this.mInflater.inflate(R.layout.global_pe_jumpalbe_item_view, viewGroup, false);
        if (!TextUtils.isEmpty(jumpable.getText())) {
            textView.setText(jumpable.getText());
        } else {
            textView.setText(jumpable.getTextRes());
        }
        if (3 == jumpable.getId()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.global_pay_penalty_icon_rule, 0, R.drawable.common_icon_right, 0);
            textView.setCompoundDrawablePadding(UIUtils.dip2pxInt(this.mContext, 6.0f));
        }
        textView.setContentDescription(textView.getText() + textView.getContext().getString(R.string.pe_voice_btn_to_jump));
        textView.setTag(jumpable);
        textView.setOnClickListener(this.mOnViewClickListener);
        return textView;
    }

    /* access modifiers changed from: protected */
    public void performOnPay(String str, String str2) {
        IPayEntranceView.OnPayListener onPayListener = this.mOnPayListener;
        if (onPayListener != null) {
            onPayListener.onPayClick(this.f15020c, Double.valueOf(str.trim()).doubleValue(), Double.valueOf(str2.trim()).doubleValue());
        }
    }

    public final void setMode(Mode mode) {
        this.f15020c = mode;
    }

    public final Mode getMode() {
        return this.f15020c;
    }

    public void setOnBindCardClickListener(IPayEntranceView.OnBindCardClickListener onBindCardClickListener) {
        this.mOnBindCardClickListener = onBindCardClickListener;
    }
}
