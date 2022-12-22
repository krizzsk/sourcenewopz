package global.didi.pay.newview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.model.LoadingState;
import global.didi.pay.newview.pix.NewGlobalPaymentPixCodeView;
import global.didi.pay.newview.pix.NewGlobalPaymentPixPrepayView;
import global.didi.pay.view.dialog.UnifiedPayDialogConfig;
import global.didi.pay.view.dialog.confirm.GlobalPayConfirmDialog;
import global.didi.pay.view.dialog.tip.GlobalPayTipDialog;

public class NewGlobalPaymentViewController {
    private static final int ANIM_DURATION = 400;
    /* access modifiers changed from: private */
    public int mContentHeight;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mMinContentHeight;
    /* access modifiers changed from: private */
    public View mPayCenterLayout;
    private GlobalPayConfirmDialog mPayConfirmDialog;
    /* access modifiers changed from: private */
    public View mPayContentLayout;
    /* access modifiers changed from: private */
    public View mPayNetErrorLayout;
    private GlobalPayTipDialog mPayTipDialog;
    /* access modifiers changed from: private */
    public NewGlobalPaymentPixCodeView mPixCodeView;
    /* access modifiers changed from: private */
    public NewGlobalPaymentPixPrepayView mPixPrepayView;
    /* access modifiers changed from: private */
    public ViewGroup mRootView;
    /* access modifiers changed from: private */
    public NewGlobalPaymentStateView mStateView;
    /* access modifiers changed from: private */
    public NewGlobalPaymentSubmitView mSubmitView;
    /* access modifiers changed from: private */
    public NewGlobalPayTitleView mTitleView;

    private NewGlobalPaymentViewController(Context context) {
        this.mContext = context;
        int dip2px = UIUtils.dip2px(context, 30.0f);
        this.mMinContentHeight = dip2px;
        this.mContentHeight = dip2px;
    }

    public void showTipDialog(UnifiedPayDialogConfig unifiedPayDialogConfig, IGlobalPayView.DialogTipsListener dialogTipsListener) {
        int i = this.mContentHeight;
        final int i2 = this.mMinContentHeight;
        animShrink(i, i2, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((Integer) valueAnimator.getAnimatedValue()).intValue() == i2) {
                    NewGlobalPaymentViewController.this.mStateView.switchStatus("empty");
                    int unused = NewGlobalPaymentViewController.this.mContentHeight = i2;
                }
            }
        });
        if (this.mPayTipDialog == null) {
            this.mPayTipDialog = GlobalPayTipDialog.createTransDialog(this.mContext);
        }
        this.mPayTipDialog.setCancelable(false);
        this.mPayTipDialog.setConfig(unifiedPayDialogConfig);
        this.mPayTipDialog.setTipsDialogListener(dialogTipsListener);
        if (!this.mPayTipDialog.isShowing()) {
            SystemUtils.showDialog(this.mPayTipDialog);
        }
    }

    public void showLoadingView(String str, boolean z, int i, int i2) {
        if (z) {
            if (this.mContentHeight > this.mMinContentHeight) {
                showShrinkLoadingView(str, i, i2);
            } else {
                showInitLoadingView(str, i, i2);
            }
        }
    }

    public void showConfirmDialog(UnifiedPayDialogConfig unifiedPayDialogConfig, IGlobalPayView.DialogConfirmListener dialogConfirmListener) {
        int i = this.mContentHeight;
        final int i2 = this.mMinContentHeight;
        animShrink(i, i2, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((Integer) valueAnimator.getAnimatedValue()).intValue() == i2) {
                    NewGlobalPaymentViewController.this.mStateView.switchStatus("empty");
                    int unused = NewGlobalPaymentViewController.this.mContentHeight = i2;
                }
            }
        });
        if (this.mPayConfirmDialog == null) {
            this.mPayConfirmDialog = GlobalPayConfirmDialog.createDialog(this.mContext);
        }
        this.mPayConfirmDialog.setConfig(unifiedPayDialogConfig);
        this.mPayConfirmDialog.setCancelable(false);
        this.mPayConfirmDialog.setListener(dialogConfirmListener);
        if (!this.mPayConfirmDialog.isShowing()) {
            SystemUtils.showDialog(this.mPayConfirmDialog);
        }
    }

    private void showInitLoadingView(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            if (i == LoadingState.TYPE_WAITING.type) {
                this.mTitleView.setTitle(this.mContext.getString(R.string.g_payment_waiting));
            } else if (i == LoadingState.TYPE_REFRESHING.type) {
                this.mTitleView.setTitle(this.mContext.getString(R.string.g_payment_refreshing));
            } else if (i == LoadingState.TYPE_PAYING.type) {
                this.mTitleView.setTitle(this.mContext.getString(R.string.g_payment_paying));
            } else if (i == LoadingState.TYPE_PIX.type) {
                this.mTitleView.setTitle(this.mContext.getString(R.string.GRider_Prepay_Open_your_gBTO), true);
            } else {
                this.mTitleView.setTitle(this.mContext.getString(R.string.g_payment_loading));
            }
            this.mTitleView.setMessage("");
        } else {
            this.mTitleView.setTitle(str);
            this.mTitleView.setMessage("");
        }
        this.mPayCenterLayout.setVisibility(0);
        this.mTitleView.hideCloseButton();
        if ((i2 & 1) != 0) {
            this.mTitleView.showClosePixButton();
        } else {
            this.mTitleView.hideClosePixButton();
        }
        this.mStateView.switchStatus("process");
        this.mPayContentLayout.setVisibility(8);
        this.mPayNetErrorLayout.setVisibility(8);
        this.mPixCodeView.setVisibility(8);
        this.mPixPrepayView.setVisibility(8);
        this.mTitleView.setVisibility(0);
    }

    private void showShrinkLoadingView(final String str, final int i, int i2) {
        this.mPayCenterLayout.setVisibility(0);
        this.mPayContentLayout.setVisibility(8);
        this.mPayNetErrorLayout.setVisibility(8);
        this.mPixCodeView.setVisibility(8);
        this.mPixPrepayView.setVisibility(8);
        this.mTitleView.setVisibility(0);
        this.mStateView.setVisibility(0);
        this.mTitleView.hideCloseButton();
        if ((i2 & 1) != 0) {
            this.mTitleView.showClosePixButton();
        } else {
            this.mTitleView.hideClosePixButton();
        }
        this.mTitleView.setTitle("");
        this.mTitleView.setMessage("");
        int i3 = this.mContentHeight;
        final int i4 = this.mMinContentHeight;
        animShrink(i3, i4, new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((Integer) valueAnimator.getAnimatedValue()).intValue() == i4 && NewGlobalPaymentViewController.this.mPayContentLayout.getVisibility() == 8 && NewGlobalPaymentViewController.this.mPayNetErrorLayout.getVisibility() == 8) {
                    if (TextUtils.isEmpty(str)) {
                        if (i == LoadingState.TYPE_WAITING.type) {
                            NewGlobalPaymentViewController.this.mTitleView.setTitle(NewGlobalPaymentViewController.this.mContext.getString(R.string.g_payment_waiting));
                        } else if (i == LoadingState.TYPE_REFRESHING.type) {
                            NewGlobalPaymentViewController.this.mTitleView.setTitle(NewGlobalPaymentViewController.this.mContext.getString(R.string.g_payment_refreshing));
                        } else if (i == LoadingState.TYPE_PAYING.type) {
                            NewGlobalPaymentViewController.this.mTitleView.setTitle(NewGlobalPaymentViewController.this.mContext.getString(R.string.g_payment_paying));
                        } else if (i == LoadingState.TYPE_PIX.type) {
                            NewGlobalPaymentViewController.this.mTitleView.setTitle(NewGlobalPaymentViewController.this.mContext.getString(R.string.GRider_Prepay_Open_your_gBTO), true);
                        } else {
                            NewGlobalPaymentViewController.this.mTitleView.setTitle(NewGlobalPaymentViewController.this.mContext.getString(R.string.g_payment_loading));
                        }
                        NewGlobalPaymentViewController.this.mTitleView.setMessage("");
                    } else {
                        NewGlobalPaymentViewController.this.mTitleView.setTitle(str);
                        NewGlobalPaymentViewController.this.mTitleView.setMessage("");
                    }
                    NewGlobalPaymentViewController.this.mStateView.switchStatus("process");
                    int unused = NewGlobalPaymentViewController.this.mContentHeight = i4;
                }
            }
        });
    }

    public void showPaySuccessView(String str) {
        this.mPayCenterLayout.setVisibility(0);
        this.mTitleView.setVisibility(0);
        this.mTitleView.hideCloseButton();
        this.mTitleView.hideClosePixButton();
        this.mPixCodeView.setVisibility(8);
        this.mPixPrepayView.setVisibility(8);
        this.mStateView.switchStatus("success");
        if (TextUtils.isEmpty(str)) {
            this.mTitleView.setTitle(this.mContext.getString(R.string.g_payment_success));
            this.mTitleView.setMessage("");
            return;
        }
        this.mTitleView.setTitle(str);
        this.mTitleView.setMessage("");
    }

    public void showPayInfoView() {
        this.mPayCenterLayout.setVisibility(0);
        this.mTitleView.setVisibility(0);
        this.mPayContentLayout.setVisibility(0);
        this.mPixCodeView.setVisibility(8);
        this.mPixPrepayView.setVisibility(8);
        this.mTitleView.showCloseButton();
        this.mTitleView.hideClosePixButton();
        this.mStateView.switchStatus(NewGlobalPaymentStateView.TYPE_SUBMIT);
        this.mPayContentLayout.setVisibility(0);
        this.mPayNetErrorLayout.setVisibility(8);
        int i = this.mMinContentHeight;
        int computeHeight = computeHeight(this.mContext, this.mPayCenterLayout);
        this.mContentHeight = computeHeight;
        animExpand(i, computeHeight, this.mPayCenterLayout);
    }

    public void showRetryView() {
        this.mPayCenterLayout.setVisibility(0);
        this.mTitleView.setVisibility(0);
        this.mPixCodeView.setVisibility(8);
        this.mPixPrepayView.setVisibility(8);
        this.mTitleView.showCloseButton();
        this.mTitleView.hideClosePixButton();
        this.mStateView.switchStatus(NewGlobalPaymentStateView.TYPE_SUBMIT);
        this.mPayContentLayout.setVisibility(8);
        this.mPayNetErrorLayout.setVisibility(0);
        int i = this.mMinContentHeight;
        int computeHeight = computeHeight(this.mContext, this.mPayCenterLayout);
        this.mContentHeight = computeHeight;
        animExpand(i, computeHeight, this.mPayCenterLayout);
    }

    public void showPixPrepayView() {
        this.mPayCenterLayout.setVisibility(8);
        this.mTitleView.setVisibility(8);
        this.mPayContentLayout.setVisibility(8);
        this.mPixPrepayView.setVisibility(0);
        this.mStateView.switchStatus("empty");
        this.mContentHeight = computeHeight(this.mContext, this.mPixPrepayView);
        pixAnimExpand(computeHeight(this.mContext, this.mTitleView) + computeHeight(this.mContext, this.mStateView), this.mPixPrepayView);
        this.mPixPrepayView.animExpand(400);
    }

    public void showPixCodeView() {
        this.mTitleView.setVisibility(8);
        this.mPayContentLayout.setVisibility(8);
        this.mPixCodeView.setVisibility(0);
        this.mStateView.switchStatus("empty");
        this.mContentHeight = computeHeight(this.mContext, this.mPixCodeView);
        pixAnimExpand(computeHeight(this.mContext, this.mTitleView) + computeHeight(this.mContext, this.mStateView), this.mPixCodeView);
        this.mPixCodeView.animExpand(400);
    }

    private void animExpand(int i, final int i2, final View view) {
        this.mSubmitView.animExpand(400);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                view.getLayoutParams().height = intValue;
                view.requestLayout();
                if (intValue == i2) {
                    view.getLayoutParams().height = view.getMeasuredHeight();
                    view.requestLayout();
                    int unused = NewGlobalPaymentViewController.this.mContentHeight = view.getMeasuredHeight();
                }
            }
        });
        ofInt.setDuration(400);
        ofInt.start();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPayCenterLayout, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mTitleView, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(600);
        animatorSet.start();
    }

    private void pixAnimExpand(int i, View view) {
        ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) i, 0.0f}).setDuration(400).start();
        ViewGroup viewGroup = this.mRootView;
        ObjectAnimator.ofFloat(viewGroup, "translationY", new float[]{(float) (i - (viewGroup.getMeasuredHeight() - view.getMeasuredHeight())), 0.0f}).setDuration(400).start();
        this.mSubmitView.animExpand(400);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPayCenterLayout, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mTitleView, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(600);
        animatorSet.start();
    }

    private void animShrink(int i, int i2, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mSubmitView.animShrink(400);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NewGlobalPaymentViewController.this.mPayCenterLayout.getLayoutParams().height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NewGlobalPaymentViewController.this.mPayCenterLayout.requestLayout();
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = animatorUpdateListener;
                if (animatorUpdateListener != null) {
                    animatorUpdateListener.onAnimationUpdate(valueAnimator);
                }
            }
        });
        ofInt.setDuration(400);
        ofInt.start();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mPayCenterLayout, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration(200);
        ofFloat.start();
    }

    private int computeHeight(Context context, View view) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        view.measure(point.x, point.y);
        return view.getMeasuredHeight();
    }

    public boolean isRetryViewShowed() {
        return this.mPayNetErrorLayout.getVisibility() == 0;
    }

    public boolean isErrorViewShowed() {
        return (this.mPayNetErrorLayout.getVisibility() == 0) || (this.mPayContentLayout.getVisibility() == 0);
    }

    public boolean isPixCodeShowed() {
        return this.mPixCodeView.getVisibility() == 0;
    }

    public static class Builder {
        private NewGlobalPaymentViewController mController;

        public Builder(Context context) {
            this.mController = new NewGlobalPaymentViewController(context);
        }

        public Builder setRootView(ViewGroup viewGroup) {
            ViewGroup unused = this.mController.mRootView = viewGroup;
            return this;
        }

        public Builder setTitleView(NewGlobalPayTitleView newGlobalPayTitleView) {
            NewGlobalPayTitleView unused = this.mController.mTitleView = newGlobalPayTitleView;
            return this;
        }

        public Builder setStateView(NewGlobalPaymentStateView newGlobalPaymentStateView) {
            NewGlobalPaymentStateView unused = this.mController.mStateView = newGlobalPaymentStateView;
            return this;
        }

        public Builder setSubmitView(NewGlobalPaymentSubmitView newGlobalPaymentSubmitView) {
            NewGlobalPaymentSubmitView unused = this.mController.mSubmitView = newGlobalPaymentSubmitView;
            return this;
        }

        public Builder setCenterLayout(View view) {
            View unused = this.mController.mPayCenterLayout = view;
            return this;
        }

        public Builder setContentLayout(View view) {
            View unused = this.mController.mPayContentLayout = view;
            return this;
        }

        public Builder setEmptyLayout(View view) {
            View unused = this.mController.mPayNetErrorLayout = view;
            return this;
        }

        public Builder setPixCodeView(NewGlobalPaymentPixCodeView newGlobalPaymentPixCodeView) {
            NewGlobalPaymentPixCodeView unused = this.mController.mPixCodeView = newGlobalPaymentPixCodeView;
            return this;
        }

        public Builder setPixPrepayView(NewGlobalPaymentPixPrepayView newGlobalPaymentPixPrepayView) {
            NewGlobalPaymentPixPrepayView unused = this.mController.mPixPrepayView = newGlobalPaymentPixPrepayView;
            return this;
        }

        public NewGlobalPaymentViewController build() {
            return this.mController;
        }
    }
}
