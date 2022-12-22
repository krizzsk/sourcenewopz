package global.didi.pay.newview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import global.didi.pay.p236ui.theme.UnifiedPayThemeManager;

public class NewGlobalPaymentSubmitView extends LinearLayout {
    private View ll_submit;
    /* access modifiers changed from: private */
    public View ll_submit_center;
    /* access modifiers changed from: private */
    public View.OnClickListener mListener;
    private TextView tv_submit;

    public NewGlobalPaymentSubmitView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentSubmitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_submit, this);
        this.ll_submit = findViewById(R.id.ll_submit);
        this.ll_submit.setBackground(AppCompatResources.getDrawable(getContext(), UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getNewMainBtnBg()));
        TextView textView = (TextView) findViewById(R.id.tv_submit);
        this.tv_submit = textView;
        textView.setTextColor(getResources().getColorStateList(UnifiedPayThemeManager.getINS().getPayTheme(getContext()).getPayBtnTxtColor()));
        this.ll_submit_center = findViewById(R.id.ll_submit_center);
        this.ll_submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentSubmitView.this.mListener != null) {
                    NewGlobalPaymentSubmitView.this.mListener.onClick(view);
                }
            }
        });
    }

    public void setSubmitText(String str) {
        this.tv_submit.setText(str);
    }

    public void setSubmitEnable(boolean z) {
        this.tv_submit.setEnabled(z);
        this.ll_submit.setEnabled(z);
    }

    public void setSubmitBackgroundGray() {
        this.ll_submit.setBackground(getResources().getDrawable(R.drawable.g_payment_submit_btn_bg_gray));
    }

    public void setSubmitClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void animExpand(int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration((long) ((int) (((double) i) * 1.5d)));
        ofFloat.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, dip2px(getContext(), 287.0f)});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NewGlobalPaymentSubmitView.this.ll_submit_center.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NewGlobalPaymentSubmitView.this.ll_submit_center.requestLayout();
            }
        });
        ofInt.setDuration((long) i);
        ofInt.start();
    }

    public void animShrink(int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.setDuration((long) (i / 2));
        ofFloat.start();
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{dip2px(getContext(), 287.0f), 0});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NewGlobalPaymentSubmitView.this.ll_submit_center.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                NewGlobalPaymentSubmitView.this.ll_submit_center.requestLayout();
            }
        });
        ofInt.setDuration((long) i);
        ofInt.start();
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
