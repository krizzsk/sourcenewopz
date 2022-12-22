package global.didi.pay.newview.pix;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import global.didi.pay.newview.NewGlobalPaymentSubmitView;

public class NewGlobalPaymentPixCodeView extends FrameLayout implements IPixView {
    private String mPixCode;
    private NewGlobalPaymentSubmitView mSvCancel;
    private NewGlobalPaymentSubmitView mSvConfirm;
    private NewGlobalPaymentSubmitView mSvPaid;
    private TextView mTvPixCodeDetail;
    private TextView mTvPixCodeInfo;
    private TextView mTvPixCodeTitle;

    public String getPixType() {
        return "pix_page";
    }

    public NewGlobalPaymentPixCodeView(Context context) {
        super(context);
        init();
    }

    public NewGlobalPaymentPixCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NewGlobalPaymentPixCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_pix_code, this);
        this.mSvConfirm = (NewGlobalPaymentSubmitView) findViewById(R.id.sv_pix_code_confirm);
        this.mSvPaid = (NewGlobalPaymentSubmitView) findViewById(R.id.sv_pix_code_paid);
        this.mSvCancel = (NewGlobalPaymentSubmitView) findViewById(R.id.sv_pix_code_cancel);
        this.mTvPixCodeDetail = (TextView) findViewById(R.id.tv_pix_code_detail);
        this.mTvPixCodeTitle = (TextView) findViewById(R.id.tv_pix_code_title);
        this.mTvPixCodeInfo = (TextView) findViewById(R.id.tv_pix_code_info);
        updatePixViewStatus(IPixView.PAGE_STATUS_INIT);
        this.mSvConfirm.setSubmitText(getResources().getString(R.string.GRider_payment_Copy_PIX_ybbs));
        this.mSvPaid.setSubmitText(getResources().getString(R.string.GRider_payment_I_have_uyIU));
        this.mSvCancel.setSubmitText(getResources().getString(R.string.GRider_payment_Cancel_ntbd));
        this.mSvCancel.setSubmitBackgroundGray();
    }

    public void updatePixViewStatus(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            this.mSvConfirm.setVisibility(str.equals(IPixView.PAGE_STATUS_INIT) ? 0 : 8);
            NewGlobalPaymentSubmitView newGlobalPaymentSubmitView = this.mSvPaid;
            if (!str.equals(IPixView.PAGE_STATUS_PAID)) {
                i = 8;
            }
            newGlobalPaymentSubmitView.setVisibility(i);
        }
    }

    public String getPixCode() {
        return this.mPixCode;
    }

    public void updatePixCode(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPixCode = str;
            this.mTvPixCodeDetail.setText(str);
        }
    }

    public void setOnConfirmClickListener(final View.OnClickListener onClickListener) {
        this.mSvConfirm.setSubmitClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnCancelClickListener(final View.OnClickListener onClickListener) {
        this.mSvCancel.setSubmitClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                View.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        });
    }

    public void setOnPaidClickListener(final View.OnClickListener onClickListener) {
        this.mSvPaid.setSubmitClickListener(new View.OnClickListener() {
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
        this.mSvConfirm.animExpand(i);
        this.mSvPaid.animExpand(i);
        this.mSvCancel.animExpand(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTvPixCodeDetail, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mTvPixCodeTitle, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mTvPixCodeInfo, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.setDuration((long) ((int) (((double) i) * 1.5d)));
        animatorSet.start();
    }
}
