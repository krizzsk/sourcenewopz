package global.didi.pay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class GlobalErrorView extends LinearLayout {
    private ImageView mIconView;
    private TextView mTextTV;

    public GlobalErrorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.g_payment_error, this);
        this.mIconView = (ImageView) findViewById(R.id.g_payment_error_icon);
        this.mTextTV = (TextView) findViewById(R.id.g_payment_error_text);
    }
}
