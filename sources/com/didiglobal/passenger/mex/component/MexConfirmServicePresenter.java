package com.didiglobal.passenger.mex.component;

import android.content.Intent;
import com.didi.component.core.ComponentParams;
import com.didi.component.service.ConfirmServicePresenter;
import com.didi.component.service.util.SendOrderTipDialogHelper;
import com.didi.sdk.logging.Logger;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;

public class MexConfirmServicePresenter extends ConfirmServicePresenter {
    public static final int REQUEST_CODE_PAY_FOR_CANCEL_FEE_MEX = 200;

    public MexConfirmServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onOrderCreateFail(CarOrder carOrder) {
        if (carOrder == null) {
            this.mLogger.info("onOrderCreateFail  order == null", new Object[0]);
            SendOrderTipDialogHelper.showOrderFailDialog(this.mContext, getHost().getFragmentManager(), this.mContext.getString(R.string.car_get_order_info_failed));
            return;
        }
        super.onOrderCreateFail(carOrder);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1 && intent != null) {
            int intExtra = intent.getIntExtra("code", 0);
            int intExtra2 = intent.getIntExtra("errCode", 0);
            String stringExtra = intent.getStringExtra("message");
            Logger logger = this.mLogger;
            logger.info("Pay for cancel fee result:code:" + intExtra + ",errorcode:" + intExtra2 + ",message:" + stringExtra, new Object[0]);
        }
    }
}
