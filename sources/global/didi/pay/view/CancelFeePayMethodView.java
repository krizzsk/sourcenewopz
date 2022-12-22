package global.didi.pay.view;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.unifiedPay.component.widget.PayMethodView;
import com.taxis99.R;

public class CancelFeePayMethodView extends PayMethodView {
    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.gua_oc_cancel_fee_pay_item_layout;
    }

    public CancelFeePayMethodView(Context context) {
        super(context);
    }

    public CancelFeePayMethodView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
