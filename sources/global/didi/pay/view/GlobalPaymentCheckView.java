package global.didi.pay.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.GlideUtils;
import com.taxis99.R;
import global.didi.pay.model.GlobalPayType;

public class GlobalPaymentCheckView extends LinearLayout {
    private GlobalPayType mCurrentSelectedType;
    private ImageView mIconView;
    private TextView mRedPointView;
    private TextView mTextDesc;
    private TextView mTextTV;

    public GlobalPaymentCheckView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalPaymentCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.g_payment_paytype, this);
        this.mIconView = (ImageView) findViewById(R.id.g_payment_paytype_icon);
        this.mTextTV = (TextView) findViewById(R.id.g_payment_paytype_name);
        this.mRedPointView = (TextView) findViewById(R.id.g_payment_red_point);
        this.mTextDesc = (TextView) findViewById(R.id.g_payment_paytype_desc);
    }

    public void setIcon(int i) {
        this.mIconView.setBackgroundResource(i);
    }

    public void setName(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTextTV.setVisibility(8);
            return;
        }
        this.mTextTV.setVisibility(0);
        this.mTextTV.setText(str);
    }

    public void setCurrentSelectedType(GlobalPayType globalPayType) {
        this.mCurrentSelectedType = globalPayType;
        if (!TextUtils.isEmpty(globalPayType.iconUrl)) {
            this.mIconView.setVisibility(0);
            loadImg(globalPayType.iconUrl);
        } else if (globalPayType.iconRes > 0) {
            this.mIconView.setVisibility(0);
            setIcon(globalPayType.iconRes);
        } else {
            this.mIconView.setVisibility(8);
        }
        setName(globalPayType.name);
    }

    public GlobalPayType getCurrentSelectedType() {
        return this.mCurrentSelectedType;
    }

    private void loadImg(String str) {
        GlideUtils.with2load2into(getContext(), str, this.mIconView);
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
