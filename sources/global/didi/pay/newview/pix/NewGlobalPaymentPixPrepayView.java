package global.didi.pay.newview.pix;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import global.didi.pay.newview.NewGlobalPaymentFeeView;
import global.didi.pay.newview.NewGlobalPaymentSubmitView;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import global.didi.pay.omega.GlobalPayOmegaManager;

public class NewGlobalPaymentPixPrepayView extends FrameLayout implements IPixView {
    private LinearLayout mCancelLL;
    private NewGlobalPaymentSubmitView mCancelSV;
    private View mCloseIV;
    private View mCloseLL;
    private NewGlobalPaymentSubmitView mConfirmSV;
    private NewGlobalPaymentFeeView mFeeView;
    private TextView mInfo;
    private GlobalPayOmegaManager mOmegaManager;
    private NewGlobalPaymentSubmitView mPaidSV;
    /* access modifiers changed from: private */
    public String mPixCode;
    private View mPixContainer;
    private TextView mPixTv;
    private TextView mTips;
    private TextView mTitle;

    public String getPixType() {
        return "pix_prepay_page";
    }

    public NewGlobalPaymentPixPrepayView(Context context) {
        super(context);
        init();
    }

    public NewGlobalPaymentPixPrepayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NewGlobalPaymentPixPrepayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* access modifiers changed from: protected */
    public GlobalPayOmegaManager getOmegaManager() {
        if (this.mOmegaManager == null) {
            this.mOmegaManager = new GlobalPayOmegaManager();
        }
        return this.mOmegaManager;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_pix_prepay, this);
        this.mTitle = (TextView) findViewById(R.id.tv_pix_prepay_code_title);
        this.mInfo = (TextView) findViewById(R.id.tv_pix_prepay_code_info);
        this.mTips = (TextView) findViewById(R.id.tv_pix_prepay_code_tips);
        this.mPixContainer = findViewById(R.id.ll_pix_prepay_copy_container);
        this.mPixTv = (TextView) findViewById(R.id.tv_pix_prepay_container_code);
        this.mFeeView = (NewGlobalPaymentFeeView) findViewById(R.id.fv_pix_prepay_fee);
        this.mConfirmSV = (NewGlobalPaymentSubmitView) findViewById(R.id.sv_pix_prepay_code_confirm);
        this.mPaidSV = (NewGlobalPaymentSubmitView) findViewById(R.id.sv_pix_prepay_code_paid);
        this.mCancelSV = (NewGlobalPaymentSubmitView) findViewById(R.id.sv_pix_prepay_code_cancel);
        this.mCancelLL = (LinearLayout) findViewById(R.id.tv_pix_prepay_code_cancel);
        this.mCloseLL = findViewById(R.id.g_pix_prepay_close_layout);
        this.mCloseIV = findViewById(R.id.g_pix_prepay_close_image);
        this.mConfirmSV.setSubmitText(getContext().getString(R.string.GRider_Prepay_Copy_code_Sdgo));
        this.mPaidSV.setSubmitText(getContext().getString(R.string.GRider_Prepay_Try_again_SSkP));
        this.mCancelSV.setSubmitText(getContext().getString(R.string.GRider_Prepay_Cancel_oTCB));
        this.mCancelSV.setSubmitBackgroundGray();
        this.mPixContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ToastHelper.showShortInfo(NewGlobalPaymentPixPrepayView.this.getContext(), NewGlobalPaymentPixPrepayView.this.getContext().getString(R.string.GRider_payment_Copy_successfully_Lycd), (int) R.drawable.g_icon_payment_success);
                ((ClipboardManager) NewGlobalPaymentPixPrepayView.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Label", NewGlobalPaymentPixPrepayView.this.mPixCode));
                NewGlobalPaymentPixPrepayView.this.getOmegaManager().doOmegaForPixPrepay(GlobalPayOmegaConstant.EventId.ibt_gp_cashier_noresult_copy_ck, (String) null, "cashier", (String) null);
            }
        });
    }

    public void setDisplayFeeWithUnit(String str) {
        this.mFeeView.setDisplayFeeWithUnit(str);
    }

    public void setFeeClickListener(View.OnClickListener onClickListener) {
        this.mFeeView.setFeeClickListener(onClickListener);
    }

    public void showFeeArrowVisibility(int i) {
        this.mFeeView.showFeeArrowVisibility(i);
    }

    public String getPixCode() {
        return this.mPixCode;
    }

    public void updatePixViewStatus(String str) {
        this.mTitle.setText(TextUtils.equals(str, IPixView.PAGE_STATUS_INIT) ? R.string.GRider_Prepay_Payment_completed_CWrs : R.string.GRider_Prepay_Failure_to_GLbw);
        int i = 0;
        this.mInfo.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_INIT) ? 0 : 8);
        this.mTips.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_PAID) ? 0 : 8);
        this.mPixContainer.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_PAID) ? 0 : 8);
        this.mConfirmSV.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_INIT) ? 0 : 8);
        this.mPaidSV.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_PAID) ? 0 : 8);
        this.mCancelSV.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_PAID) ? 0 : 8);
        this.mCancelLL.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_INIT) ? 0 : 8);
        this.mCloseLL.setVisibility(TextUtils.equals(str, IPixView.PAGE_STATUS_INIT) ? 0 : 8);
        View view = this.mCloseIV;
        if (!TextUtils.equals(str, IPixView.PAGE_STATUS_INIT)) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void updatePixCode(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            this.mPixCode = str;
            this.mPixTv.setText(str);
            if (Build.VERSION.SDK_INT >= 23 || this.mPixCode.length() < 30) {
                str2 = "<font color='#000000'>" + getContext().getString(R.string.GRider_Prepay_Transaction_code_rmjK) + "</font>:<font color='#FF8040'>" + this.mPixCode + "</font>";
            } else {
                str2 = "<font color='#000000'>" + getContext().getString(R.string.GRider_Prepay_Transaction_code_rmjK) + "</font>:<font color='#FF8040'>" + this.mPixCode.substring(0, 29) + "...</font>";
            }
            this.mInfo.setText(Html.fromHtml(str2));
            this.mTips.setText(getContext().getString(R.string.GRider_Prepay_You_can_KanG) + "\n" + getContext().getString(R.string.GRider_Prepay_If_you_kess, new Object[]{getContext().getString(R.string.GRider_Prepay_2_hour_qidq)}));
        }
    }

    public void setOnPaidClick(final View.OnClickListener onClickListener) {
        this.mPaidSV.setSubmitClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnConfirmClick(final View.OnClickListener onClickListener) {
        this.mConfirmSV.setSubmitClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnCancelClick(final View.OnClickListener onClickListener) {
        this.mCancelSV.setSubmitClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        this.mCloseLL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
        this.mCloseIV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnChangeClick(final View.OnClickListener onClickListener) {
        this.mCancelLL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void animExpand(int i) {
        this.mCancelSV.animExpand(i);
        this.mConfirmSV.animExpand(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTitle, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mInfo, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration((long) ((int) (((double) i) * 1.5d)));
        animatorSet.start();
    }
}
