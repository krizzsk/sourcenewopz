package global.didi.pay.select.view.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.didi.payment.base.view.PayGlobalLoading;

public abstract class BasePayMethodPageView<T> extends LinearLayout implements IPayMethodListView<T> {
    protected Context mContext;
    protected int mTitleBarId;

    public BasePayMethodPageView(Context context) {
        super(context);
        this.mContext = context;
    }

    public BasePayMethodPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void showProgressDialog(String str) {
        int i;
        Context context = this.mContext;
        if ((context instanceof Activity) && (i = this.mTitleBarId) != 0) {
            PayGlobalLoading.show((Activity) context, i);
        }
    }

    public void dismissProgressDialog() {
        PayGlobalLoading.hide();
    }
}
