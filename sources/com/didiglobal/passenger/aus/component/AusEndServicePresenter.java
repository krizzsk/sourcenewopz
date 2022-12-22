package com.didiglobal.passenger.aus.component;

import android.os.Bundle;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.service.EndServicePresenter;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class AusEndServicePresenter extends EndServicePresenter {

    /* renamed from: a */
    private final Logger f50289a = LoggerFactory.getLogger(getClass());

    public AusEndServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        NotificationUtils.getInstance(this.mContext).hideNotification();
    }

    /* access modifiers changed from: protected */
    public void processPaySuccess() {
        this.f50289a.info("AusEndServicePresenter event=BaseEventKeys.Pay.EVENT_PAYMENT_PAY_SUCCESS", new Object[0]);
        if (GlobalApolloUtil.isNewEvaluate()) {
            super.processPaySuccess();
        } else {
            refreshOrderStatusOnPaySuccess();
        }
    }
}
