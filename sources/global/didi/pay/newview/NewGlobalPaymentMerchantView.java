package global.didi.pay.newview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class NewGlobalPaymentMerchantView extends LinearLayout {
    private ImageView mCheckBox;
    private TextView mLabelTV;
    private TextView mValueTV;

    public NewGlobalPaymentMerchantView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentMerchantView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NewGlobalPaymentMerchantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_merchant, this);
        this.mLabelTV = (TextView) findViewById(R.id.g_payment_merchant_label);
        this.mValueTV = (TextView) findViewById(R.id.g_payment_merchant_value);
    }

    public void setValue(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mValueTV.setVisibility(8);
            return;
        }
        this.mValueTV.setVisibility(0);
        this.mValueTV.setText(str);
    }
}
