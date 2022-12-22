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
import com.didi.unifiedPay.sdk.model.InternalPayChannel;
import com.taxis99.R;
import global.didi.pay.IGlobalPayView;

public class NewGlobalPaymentBalanceView extends LinearLayout {
    private ImageView mCheckBox;
    private TextView mLabelTV;
    private TextView mValueTV;

    public NewGlobalPaymentBalanceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewGlobalPaymentBalanceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.new_g_payment_banlance, this);
        this.mLabelTV = (TextView) findViewById(R.id.g_payment_balance_label);
        this.mValueTV = (TextView) findViewById(R.id.g_payment_balance_value);
        this.mCheckBox = (ImageView) findViewById(R.id.g_payment_balance_checkbox);
    }

    private void setLabel(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mLabelTV.setVisibility(8);
            return;
        }
        this.mLabelTV.setVisibility(0);
        this.mLabelTV.setText(str);
    }

    private void setValue(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mValueTV.setVisibility(8);
            return;
        }
        this.mValueTV.setVisibility(0);
        this.mValueTV.setText(str);
    }

    public void update(final InternalPayChannel internalPayChannel, final IGlobalPayView.CheckCallBack checkCallBack) {
        if (TextUtils.isEmpty(internalPayChannel.name)) {
            setVisibility(8);
            return;
        }
        boolean z = false;
        setVisibility(0);
        setLabel(internalPayChannel.name);
        setValue(internalPayChannel.info);
        ImageView imageView = this.mCheckBox;
        if (internalPayChannel.selected == 1) {
            z = true;
        }
        imageView.setSelected(z);
        this.mCheckBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (checkCallBack == null) {
                    return;
                }
                if (internalPayChannel.selected == 0 && internalPayChannel.canSelect == 1) {
                    checkCallBack.onCheckChanged(true);
                } else if (internalPayChannel.selected == 1 && internalPayChannel.canCancel == 1) {
                    checkCallBack.onCheckChanged(false);
                }
            }
        });
    }
}
