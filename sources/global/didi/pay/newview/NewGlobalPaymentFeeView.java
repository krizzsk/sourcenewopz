package global.didi.pay.newview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.util.SimpleSpanStringBuilder;
import com.taxis99.R;

public class NewGlobalPaymentFeeView extends LinearLayout {
    private ImageView iv_fee_arrow;
    private Context mContext;
    /* access modifiers changed from: private */
    public View.OnClickListener mListener;
    private TextView tv_fee_cashback;
    private TextView tv_fee_origin;
    private TextView tv_fee_show;

    public NewGlobalPaymentFeeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NewGlobalPaymentFeeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentFeeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_total_fee, this);
        this.mContext = getContext();
        this.tv_fee_show = (TextView) findViewById(R.id.tv_fee);
        this.tv_fee_origin = (TextView) findViewById(R.id.tv_fee_original);
        this.iv_fee_arrow = (ImageView) findViewById(R.id.iv_fee_arrow);
        this.tv_fee_cashback = (TextView) findViewById(R.id.tv_fee_cashback);
        this.tv_fee_origin.getPaint().setFlags(16);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewGlobalPaymentFeeView.this.mListener != null) {
                    NewGlobalPaymentFeeView.this.mListener.onClick(view);
                }
            }
        });
    }

    public void setDisplayFee(String str) {
        setDisplayFeeWithUnit(this.mContext.getString(R.string.oc_pay_total_str) + this.mContext.getString(R.string.oc_pay_total_fee_str, new Object[]{str}));
    }

    public void setDisplayFeeWithUnit(String str) {
        if (!TextUtils.isEmpty(str)) {
            SimpleSpanStringBuilder simpleSpanStringBuilder = new SimpleSpanStringBuilder(str);
            simpleSpanStringBuilder.spanNumSize(2.0f);
            this.tv_fee_show.setText(simpleSpanStringBuilder);
        }
    }

    public void setCrossFeeWithUnit(String str) {
        if (TextUtils.isEmpty(str)) {
            this.tv_fee_origin.setVisibility(8);
            return;
        }
        this.tv_fee_origin.setVisibility(0);
        this.tv_fee_origin.setText(str);
    }

    public void updateCashback(String str) {
        if (TextUtils.isEmpty(str)) {
            this.tv_fee_cashback.setVisibility(8);
            return;
        }
        this.tv_fee_cashback.setVisibility(0);
        this.tv_fee_cashback.setText(str);
    }

    public void setFeeClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void showFeeArrowVisibility(int i) {
        this.iv_fee_arrow.setVisibility(i);
    }
}
