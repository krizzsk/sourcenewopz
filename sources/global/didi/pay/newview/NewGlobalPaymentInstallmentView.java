package global.didi.pay.newview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class NewGlobalPaymentInstallmentView extends LinearLayout {
    private String currentNumber;
    private String helperUrl;
    private TextView mRedPointView;
    private TextView mTextDesc;
    private TextView mTextTV;

    public NewGlobalPaymentInstallmentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentInstallmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public String getCurrentNumber() {
        return this.currentNumber;
    }

    public void setCurrentNumber(String str) {
        this.currentNumber = str;
    }

    public String getHelperUrl() {
        return this.helperUrl;
    }

    public void setHelperUrl(String str) {
        this.helperUrl = str;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_installment, this);
        this.mTextTV = (TextView) findViewById(R.id.g_payment_paytype_name);
        this.mRedPointView = (TextView) findViewById(R.id.g_payment_red_point);
        this.mTextDesc = (TextView) findViewById(R.id.g_payment_paytype_desc);
    }

    public void setContent(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.mTextTV.setVisibility(8);
            return;
        }
        this.mTextTV.setVisibility(0);
        this.mTextTV.setText(getContext().getString(R.string.GRider_installment__unk_kGjf, new Object[]{str, str2}));
    }

    public void setRedPointVisibility(int i) {
        this.mRedPointView.setVisibility(i);
    }

    public void setDesc(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTextDesc.setVisibility(8);
            return;
        }
        this.mTextDesc.setText(str);
        this.mTextDesc.setVisibility(0);
    }
}
