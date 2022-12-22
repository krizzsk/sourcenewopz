package global.didi.pay.view.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

class CashierPopup extends PopupWindow {
    private ViewGroup contentView;
    private Context context;
    private CashierBubbleLayout layout;

    CashierPopup(Context context2) {
        this.context = context2;
        setWidth(-2);
        setHeight(-2);
        initPopupWindow();
    }

    /* access modifiers changed from: package-private */
    public void setBgColor(int i) {
        this.layout.setBubbleBackgroundColor(i);
    }

    /* access modifiers changed from: package-private */
    public void setText(String str) {
        this.layout.setText(str);
    }

    /* access modifiers changed from: package-private */
    public void setTextTypeface(int i) {
        this.layout.setTypeface(i);
    }

    /* access modifiers changed from: package-private */
    public void setTextProps(int i, int i2, int i3) {
        this.layout.setTextProps(i, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void setDirection(String str, int i) {
        this.layout.setDirection(str, i);
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(String str) {
        this.layout.setLeftDrawable(str);
    }

    /* access modifiers changed from: package-private */
    public void setLeftDrawable(int i) {
        this.layout.setLeftDrawable(i);
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view) {
        this.layout.setLeftView(view);
    }

    /* access modifiers changed from: package-private */
    public void setLeftView(View view, int i, int i2) {
        this.layout.setLeftView(view, i, i2);
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnVisible(boolean z) {
        this.layout.setCloseBtnVisible(z);
    }

    /* access modifiers changed from: package-private */
    public void setCloseBtnListener(View.OnClickListener onClickListener) {
        this.layout.setCloseClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setOutsideTouch(boolean z) {
        setFocusable(z);
        setOutsideTouchable(z);
    }

    /* access modifiers changed from: package-private */
    public void setContentViewOnClick(View.OnClickListener onClickListener) {
        this.contentView.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int i) {
        this.layout.setMaxLines(i);
    }

    /* access modifiers changed from: package-private */
    public void setBubbleContent(String str, String str2, int i, String str3, int i2, View view, int i3, int i4, View.OnClickListener onClickListener) {
        CashierBubbleLayout cashierBubbleLayout = new CashierBubbleLayout(this.context);
        this.layout = cashierBubbleLayout;
        cashierBubbleLayout.setDirection(str2, 0);
        this.layout.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.layout.setLeftDrawable(str3);
        }
        if (i2 > 0) {
            this.layout.setLeftDrawable(i2);
        }
        if (view != null) {
            if (i3 <= 0 || i4 <= 0) {
                this.layout.setLeftView(view);
            } else {
                this.layout.setLeftView(view, i3, i4);
            }
        }
        this.layout.setTypeface(i);
        this.layout.setCloseBtnVisible(true);
        CashierBubbleLayout cashierBubbleLayout2 = this.layout;
        if (onClickListener == null) {
            onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CashierPopup.this.dismiss();
                }
            };
        }
        cashierBubbleLayout2.setCloseClickListener(onClickListener);
        this.contentView.addView(this.layout);
    }

    /* access modifiers changed from: package-private */
    public void setBubbleContent(String str, int i, String str2, int i2, String str3, int i3, View view, int i4, int i5, boolean z, View.OnClickListener onClickListener) {
        this.layout.setDirection(str2, 0);
        this.layout.setBubbleBackgroundColor(i);
        this.layout.setPadding(20, 20, 20, 20);
        this.layout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.layout.setText(str);
        if (!TextUtils.isEmpty(str3)) {
            this.layout.setLeftDrawable(str3);
        }
        if (i3 > 0) {
            this.layout.setLeftDrawable(i3);
        }
        if (view != null) {
            if (i4 <= 0 || i5 <= 0) {
                this.layout.setLeftView(view);
            } else {
                this.layout.setLeftView(view, i4, i5);
            }
        }
        this.layout.setTypeface(i2);
        this.layout.setCloseBtnVisible(z);
        CashierBubbleLayout cashierBubbleLayout = this.layout;
        if (onClickListener == null) {
            onClickListener = new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CashierPopup.this.dismiss();
                }
            };
        }
        cashierBubbleLayout.setCloseClickListener(onClickListener);
        this.contentView.addView(this.layout);
    }

    /* access modifiers changed from: package-private */
    public void setBubbleContent(CashierPopupModel cashierPopupModel) {
        if (cashierPopupModel != null && cashierPopupModel.text != null && !TextUtils.isEmpty(cashierPopupModel.text.text)) {
            this.layout = new CashierBubbleLayout(this.context);
            if (cashierPopupModel.arrow != null) {
                this.layout.setDirection(cashierPopupModel.arrow.position, cashierPopupModel.arrow.offset);
            }
            if (!TextUtils.isEmpty(cashierPopupModel.background_color)) {
                this.layout.setBubbleBackgroundColor(UIUtils.getColor(cashierPopupModel.background_color));
            }
            this.layout.setPadding(20, 20, 20, 20);
            this.layout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            this.layout.setText(cashierPopupModel.text.text);
            this.layout.setTextProps(cashierPopupModel.text.size, cashierPopupModel.text.bold, cashierPopupModel.text.italic);
            CashierBubbleLayout cashierBubbleLayout = this.layout;
            boolean z = true;
            if (cashierPopupModel.cancelable != 1) {
                z = false;
            }
            cashierBubbleLayout.setCloseBtnVisible(z);
            this.layout.setCloseClickListener(cashierPopupModel.closeListener);
            this.layout.setLeftDrawable(cashierPopupModel.url);
            this.contentView.addView(this.layout);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean show(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT < 19) {
            showForce(view, i, i2);
            return true;
        } else if (!view.getRootView().isAttachedToWindow()) {
            return false;
        } else {
            showForce(view, i, i2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void showForce(final View view, final int i, final int i2) {
        if (view != null && view.getContext() != null && !isActivityDestroyed(view.getContext())) {
            try {
                showAsDropDown(view, i, i2);
            } catch (Exception unused) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        try {
                            CashierPopup.this.showAsDropDown(view, i, i2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 500);
            }
            CashierBubbleLayout cashierBubbleLayout = this.layout;
            cashierBubbleLayout.setPivotX(cashierBubbleLayout.getPivot()[0]);
            CashierBubbleLayout cashierBubbleLayout2 = this.layout;
            cashierBubbleLayout2.setPivotY(cashierBubbleLayout2.getPivot()[1]);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.layout, "translationX", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.layout, "translationY", new float[]{0.0f, 1.0f});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.start();
        }
    }

    private boolean isActivityDestroyed(Context context2) {
        if (context2 == null) {
            return true;
        }
        if (!(context2 instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context2;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        super.dismiss();
    }

    /* access modifiers changed from: package-private */
    public int getContentViewWidth() {
        return this.layout.getLayoutWidth();
    }

    /* access modifiers changed from: package-private */
    public int getContentViewHeight() {
        return this.layout.getLayoutHeight();
    }

    /* access modifiers changed from: package-private */
    public int[] getMeasureWidthAndHeight() {
        return this.layout.getMeasureWidthAndHeight();
    }

    /* access modifiers changed from: package-private */
    public void setWidthAndHeight(int i, int i2) {
        this.layout.setWidthAndHeight(i, i2);
    }

    private void initPopupWindow() {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.layout.g_payment_popup_window, (ViewGroup) null);
        this.contentView = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CashierPopup.this.dismiss();
            }
        });
        setContentView(this.contentView);
        setFocusable(false);
        setOutsideTouchable(false);
        update();
        setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000")));
        CashierBubbleLayout cashierBubbleLayout = new CashierBubbleLayout(this.context);
        this.layout = cashierBubbleLayout;
        cashierBubbleLayout.setBubbleBackgroundColor(this.context.getResources().getColor(R.color.grayscale_color_2));
        this.layout.setPadding(20, 20, 20, 20);
        this.layout.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: package-private */
    public void setContentView() {
        this.contentView.addView(this.layout);
    }
}
